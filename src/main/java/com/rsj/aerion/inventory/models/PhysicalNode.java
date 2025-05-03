package com.rsj.aerion.inventory.models;

import com.rsj.aerion.ipinventory.models.IpAddress;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "node_id")
public class PhysicalNode extends Node {

    @Column(unique = true)
    private String label;

    @OneToOne(cascade = CascadeType.ALL)
    private IpAddress managementIp;
    private String type;
    private String serialNumber;
    private String details;
    private String location;
    @ManyToOne(cascade = CascadeType.ALL)
    private Vendor vendor;
    private Long hardwareTypeId;
    private Long updatedTime;
    private Long purchaseDate;
    private String chassisSerialNumber;
    private Long chassisId;
    private Integer serverLocation;
    private Integer ramSize;
    private Integer maxRamCapacity;
    private Integer maxRamModules;
    private Integer powerConsumed;
    private String motherboardModel;
    private String biosVersion;
    private String ipmiVersion;
    private String bmcVersion;
    private String serverModel;
    private Integer diskSize;
    private Integer diskCount;
    private String driveType;
    private Integer diskEncryption;
    private Integer powerStatus;
    private String bootMode;
    private String secureBoot;
    private Integer ipmiStatus;
    private Long ipmiUpdatedTime;
    @OneToMany(cascade = CascadeType.ALL)
    private List<LogicalVolume> lvs;

    public String getLabel() {
        return label;
    }

    public PhysicalNode setLabel(String label) {
        this.label = label;
        return this;
    }

    public IpAddress getManagementIp() {
        return managementIp;
    }

    public PhysicalNode setManagementIp(IpAddress managementIp) {
        this.managementIp = managementIp;
        return this;
    }

    public String getType() {
        return type;
    }

    public PhysicalNode setType(String type) {
        this.type = type;
        return this;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public PhysicalNode setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public PhysicalNode setDetails(String details) {
        this.details = details;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public PhysicalNode setLocation(String location) {
        this.location = location;
        return this;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public PhysicalNode setVendor(Vendor vendor) {
        this.vendor = vendor;
        return this;
    }

    public Long getHardwareTypeId() {
        return hardwareTypeId;
    }

    public PhysicalNode setHardwareTypeId(Long hardwareTypeId) {
        this.hardwareTypeId = hardwareTypeId;
        return this;
    }

    public Long getUpdatedTime() {
        return updatedTime;
    }

    public PhysicalNode setUpdatedTime(Long updatedTime) {
        this.updatedTime = updatedTime;
        return this;
    }

    public Long getPurchaseDate() {
        return purchaseDate;
    }

    public PhysicalNode setPurchaseDate(Long purchaseDate) {
        this.purchaseDate = purchaseDate;
        return this;
    }

    public String getChassisSerialNumber() {
        return chassisSerialNumber;
    }

    public PhysicalNode setChassisSerialNumber(String chassisSerialNumber) {
        this.chassisSerialNumber = chassisSerialNumber;
        return this;
    }

    public Long getChassisId() {
        return chassisId;
    }

    public PhysicalNode setChassisId(Long chassisId) {
        this.chassisId = chassisId;
        return this;
    }

    public Integer getServerLocation() {
        return serverLocation;
    }

    public PhysicalNode setServerLocation(Integer serverLocation) {
        this.serverLocation = serverLocation;
        return this;
    }

    public Integer getRamSize() {
        return ramSize;
    }

    public PhysicalNode setRamSize(Integer ramSize) {
        this.ramSize = ramSize;
        return this;
    }

    public Integer getMaxRamCapacity() {
        return maxRamCapacity;
    }

    public PhysicalNode setMaxRamCapacity(Integer maxRamCapacity) {
        this.maxRamCapacity = maxRamCapacity;
        return this;
    }

    public Integer getMaxRamModules() {
        return maxRamModules;
    }

    public PhysicalNode setMaxRamModules(Integer maxRamModules) {
        this.maxRamModules = maxRamModules;
        return this;
    }

    public Integer getPowerConsumed() {
        return powerConsumed;
    }

    public PhysicalNode setPowerConsumed(Integer powerConsumed) {
        this.powerConsumed = powerConsumed;
        return this;
    }

    public String getMotherboardModel() {
        return motherboardModel;
    }

    public PhysicalNode setMotherboardModel(String motherboardModel) {
        this.motherboardModel = motherboardModel;
        return this;
    }

    public String getBiosVersion() {
        return biosVersion;
    }

    public PhysicalNode setBiosVersion(String biosVersion) {
        this.biosVersion = biosVersion;
        return this;
    }

    public String getIpmiVersion() {
        return ipmiVersion;
    }

    public PhysicalNode setIpmiVersion(String ipmiVersion) {
        this.ipmiVersion = ipmiVersion;
        return this;
    }

    public String getBmcVersion() {
        return bmcVersion;
    }

    public PhysicalNode setBmcVersion(String bmcVersion) {
        this.bmcVersion = bmcVersion;
        return this;
    }

    public String getServerModel() {
        return serverModel;
    }

    public PhysicalNode setServerModel(String serverModel) {
        this.serverModel = serverModel;
        return this;
    }

    public Integer getDiskSize() {
        return diskSize;
    }

    public PhysicalNode setDiskSize(Integer diskSize) {
        this.diskSize = diskSize;
        return this;
    }

    public Integer getDiskCount() {
        return diskCount;
    }

    public PhysicalNode setDiskCount(Integer diskCount) {
        this.diskCount = diskCount;
        return this;
    }

    public String getDriveType() {
        return driveType;
    }

    public PhysicalNode setDriveType(String driveType) {
        this.driveType = driveType;
        return this;
    }

    public Integer getDiskEncryption() {
        return diskEncryption;
    }

    public PhysicalNode setDiskEncryption(Integer diskEncryption) {
        this.diskEncryption = diskEncryption;
        return this;
    }

    public Integer getPowerStatus() {
        return powerStatus;
    }

    public PhysicalNode setPowerStatus(Integer powerStatus) {
        this.powerStatus = powerStatus;
        return this;
    }

    public String getBootMode() {
        return bootMode;
    }

    public PhysicalNode setBootMode(String bootMode) {
        this.bootMode = bootMode;
        return this;
    }

    public String getSecureBoot() {
        return secureBoot;
    }

    public PhysicalNode setSecureBoot(String secureBoot) {
        this.secureBoot = secureBoot;
        return this;
    }

    public Integer getIpmiStatus() {
        return ipmiStatus;
    }

    public PhysicalNode setIpmiStatus(Integer ipmiStatus) {
        this.ipmiStatus = ipmiStatus;
        return this;
    }

    public Long getIpmiUpdatedTime() {
        return ipmiUpdatedTime;
    }

    public PhysicalNode setIpmiUpdatedTime(Long ipmiUpdatedTime) {
        this.ipmiUpdatedTime = ipmiUpdatedTime;
        return this;
    }

    public List<LogicalVolume> getLvs() {
        return lvs;
    }

    public PhysicalNode setLvs(List<LogicalVolume> lvs) {
        this.lvs = lvs;
        return this;
    }
}
