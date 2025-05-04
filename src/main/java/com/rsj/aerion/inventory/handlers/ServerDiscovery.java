package com.rsj.aerion.inventory.handlers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rsj.aerion.inventory.models.CentralProcessingUnit;
import com.rsj.aerion.inventory.models.OS;
import com.rsj.aerion.inventory.models.OSType;
import com.rsj.aerion.inventory.models.PhysicalNode;
import com.rsj.aerion.inventory.models.RAMModule;
import com.rsj.aerion.inventory.models.RAMType;
import com.rsj.aerion.inventory.repositories.PhysicalNodeRepository;
import com.rsj.aerion.inventory.repositories.RAMModuleRepository;
import com.rsj.aerion.ipinventory.handlers.Discovery;
import com.rsj.aerion.ipinventory.models.AddressType;
import com.rsj.aerion.ipinventory.models.IpAddress;
import com.rsj.aerion.ipinventory.repositories.IpRepository;
import com.rsj.aerion.utils.JsonUtils;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ServerDiscovery extends Discovery {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerDiscovery.class);

    private static final int MAX_SERVER_PROCESS_COUNT = 10;
    private static final String SERVER = "server";
    @Autowired
    private PhysicalNodeRepository physicalNodeRepository;
    @Autowired
    private IpRepository ipRepository;
    @Autowired
    private RAMModuleRepository ramModuleRepository;
    JsonNode serverInfo;

    ServerDiscovery(){}

    ServerDiscovery(JsonNode serverInfo) {
        this.serverInfo = serverInfo;
    }

    @Override
    public void parse() throws IOException {
        LOGGER.info("Started Server Discovery " + new Date(System.currentTimeMillis()));
        System.out.println(physicalNodeRepository.findByIpAddress_HostName("172.20.56.57").orElse(new PhysicalNode()).getIpAddress());
        ClassPathResource resource = new ClassPathResource("/data/servers.json");
        serverInfo = new ObjectMapper().readTree(resource.getInputStream());
    }

    @Transactional
    @Override
    public void compute() {
        int size = serverInfo.size();
        if(size > MAX_SERVER_PROCESS_COUNT) {
            Discovery lTask = new ServerDiscovery(JsonUtils.getSubArray(this.serverInfo, 0, size/2));
            Discovery rTask = new ServerDiscovery(JsonUtils.getSubArray(this.serverInfo, size/2, size));
            lTask.fork();
            rTask.compute();
            lTask.join();
            return;
        }
        for(JsonNode data : serverInfo) {
            try {
                addOrUpdateServer(data);
            } catch (Exception e) {
                System.out.println("Exception while discovery " + e.getMessage());
            }
        }
    }

    @Override
    public void cleanUp() {

    }

    public String getOSType(String os) {
        String regex = ".*(CentOS|Debian|FreeBSD|Windows|macOS).*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(os);
        if(matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    public void addOrUpdateServer(JsonNode data) throws Exception {
        //LOGGER.info(data.toPrettyString());
        JsonNode serverObj = data.get(SERVER);
        JsonNode memoryObj = data.get("memory");
        String os = serverObj.get("os").textValue();
        String hostName = serverObj.get("hostname").textValue();
        String kernelVersion = serverObj.get("kernel").textValue();
        String type = serverObj.get("machine_type").textValue();

        PhysicalNode physicalNode = physicalNodeRepository.findByIpAddress_HostName(hostName).orElse(new PhysicalNode());
        System.out.println(physicalNode.getIpAddress());
        IpAddress ipAddress = ipRepository.findByIp(hostName);  // You need to create this query

        if (ipAddress == null) {
            ipAddress = new IpAddress();
            ipAddress.setIp(hostName);
            ipAddress.setHostName(hostName);
            ipAddress.setType(AddressType.getType(type));
            ipRepository.save(ipAddress);
        } else {
            ipAddress.setHostName(hostName);
            ipAddress.setType(AddressType.getType(type));
            ipRepository.save(ipAddress);
        }

        if(physicalNode.getManagementIp() == null) {
            physicalNode.setManagementIp(new IpAddress(serverObj.get("mgmt_ip").asText()));
        }

        physicalNode
                .setOsInfo(
                        new OS(os, OSType.getOSType(getOSType(os)), kernelVersion)
                )
                .setIpAddress(
                    ipAddress
                )
                .setCentralProcessingUnit(
                        getCPUDetails(data.get("cpu"))
                )
                .setRamModules(
                        getRAMModules(memoryObj.get("modules"))
                )
        ;
        addPhysicalNodeDetails(physicalNode, data);
        physicalNodeRepository.save(physicalNode);
    }

    private void addPhysicalNodeDetails(PhysicalNode physicalNode, JsonNode root) {
        JsonNode serverObj = root.get("server");
        JsonNode hwObj = root.get("hw");
        JsonNode cpuObj = root.get("cpu");
        JsonNode bootInfoObj = root.get("boot_info");
        JsonNode memoryObj = root.get("memory");

        String mgmtIp = serverObj.get("mgmt_ip").asText();

        physicalNode
                .setLabel(hwObj.get("server_label").asText())
                .setType(serverObj.get("machine_type").asText())
                .setSerialNumber(hwObj.get("serial_number").asText())
                .setDetails(cpuObj.get("model").asText())
                .setLocation(hwObj.get("cage").asText())
                .setChassisSerialNumber(hwObj.get("chassis_serial_number").asText())
                .setMaxRamCapacity(parseMemorySize(memoryObj.get("max_capacity").asText()))
                .setMaxRamModules(memoryObj.get("max_no_of_modules").asInt())
                .setPowerConsumed(hwObj.get("power_consumed").asInt())
                .setMotherboardModel(hwObj.get("motherboard_model").asText())
                .setBiosVersion(hwObj.get("bios_version").asText())
                .setIpmiVersion(hwObj.get("ipmi_version").asText())
                .setBmcVersion(hwObj.get("bmc_version").asText())
                .setServerModel(hwObj.get("server_model").asText())
                .setBootMode(bootInfoObj.get("boot_mode").asText())
                .setSecureBoot(bootInfoObj.get("secure_boot").asText())
                .setIpmiUpdatedTime(System.currentTimeMillis());
    }

    private IpAddress getIpAddress(JsonNode data) throws Exception {
        JsonNode serverObj = data.get(SERVER);
        String hostName = serverObj.get("hostname").textValue();
        String type = serverObj.get("machine_type").textValue();
        AddressType addressType = AddressType.getType(type);
        String macAddress = serverObj.get("mac").textValue();
        String netmask = serverObj.get("netmask").textValue();
        String ipv6 = serverObj.get("ipv6").asText();
        int v6Prefix = serverObj.get("v6_prefix").asInt();
        String ipv6LinkLocal = serverObj.get("ipv6_link_local").asText();
        String v6LinkLocalPrefix = serverObj.get("v6_link_local_prefix").asText();

        IpAddress ipAddress = new IpAddress();
        ipAddress.setIp(hostName);
        ipAddress.setType(addressType);
        ipAddress.setPingable(true);
        ipAddress.setHostName(hostName);
        ipAddress.setMacAddress(macAddress);
        ipAddress.setNetmask(netmask);
        ipAddress.setIpv6(ipv6);
        ipAddress.setV6Prefix(v6Prefix);
        ipAddress.setV6LinkLocal(ipv6LinkLocal);
        ipAddress.setV6LinkLocal(v6LinkLocalPrefix);
        return ipAddress;
    }

    private CentralProcessingUnit getCPUDetails(JsonNode cpuObj) throws Exception {
        String arch = cpuObj.get("arch").asText();
        String vendor = cpuObj.get("vendor").asText();
        String model = cpuObj.get("model").asText();

        int socket = cpuObj.get("socket").asInt();
        int cores = cpuObj.get("cores").asInt();
        int threadsPerCore = cpuObj.get("threads_per_core").asInt();
        int processor = cpuObj.get("processor").asInt();
        int siblings = cpuObj.get("siblings").asInt();

        String l1dCache = cpuObj.get("l1d").asText();
        String l1iCache = cpuObj.get("l1i").asText();
        String l2Cache = cpuObj.get("l2c").asText();
        String l3Cache = cpuObj.get("l3c").asText();

        CentralProcessingUnit centralProcessingUnit = new CentralProcessingUnit();
        centralProcessingUnit.setArchitecture(arch);
        centralProcessingUnit.setVendor(vendor);
        centralProcessingUnit.setModel(model);
        centralProcessingUnit.setPhysicalCpu(socket);
        centralProcessingUnit.setCores(cores);
        centralProcessingUnit.setThreadsPerCore(threadsPerCore);
        centralProcessingUnit.setCpus(processor);
        centralProcessingUnit.setSiblings(siblings);
        centralProcessingUnit.setL1dCache(l1dCache);
        centralProcessingUnit.setL1iCache(l1iCache);
        centralProcessingUnit.setL2Cache(l2Cache);
        centralProcessingUnit.setL3Cache(l3Cache);
        return centralProcessingUnit;
    }

    private List<RAMModule> getRAMModules(JsonNode ramObj) throws Exception {
        List<RAMModule> ramModules = new ArrayList<>();
        for(JsonNode ramModuleJson : ramObj) {
            String type = ramModuleJson.get("type").asText();
            String size = ramModuleJson.get("size").asText();
            String speed = ramModuleJson.get("speed").asText();
            String configuredClockSpeed = ramModuleJson.get("configured_clock_speed").asText();
            String manufacturer = ramModuleJson.get("manufacturer").asText();
            String partNumber = ramModuleJson.get("part_number").asText();
            String locator = ramModuleJson.get("locator").asText();

            RAMModule ramModule = ramModuleRepository
                    .findByTypeAndSizeAndSpeedAndConfiguredClockSpeedAndManufacturerAndPartNumberAndLocator(
                            RAMType.getRAMType(type),
                            getIntegerValue(size),
                            getIntegerValue(speed),
                            getIntegerValue(configuredClockSpeed),
                            manufacturer,
                            partNumber,
                            locator
                    ).orElse(null);
            if(ramModule == null) {
                ramModule = new RAMModule();
                ramModule.setType(RAMType.getRAMType(type));
                ramModule.setSize(getIntegerValue(size));
                ramModule.setLocator(locator);
                ramModule.setManufacturer(manufacturer);
                ramModule.setConfiguredClockSpeed(getIntegerValue(configuredClockSpeed));
                ramModule.setPartNumber(partNumber);
                ramModule.setSpeed(getIntegerValue(speed));
            }
            ramModules.add(ramModule);
        }
        return ramModules;
    }

    private static int getIntegerValue(String text) {
        String regex = "\\D*(\\d+)\\D*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 0;
    }

    private Integer parseMemorySize(String size) {
        if (size == null) return null;
        size = size.trim().toUpperCase();
        if (size.endsWith("TB")) return Integer.parseInt(size.replace("TB", "").trim()) * 1024;
        if (size.endsWith("GB")) return Integer.parseInt(size.replace("GB", "").trim());
        return null;
    }
}
