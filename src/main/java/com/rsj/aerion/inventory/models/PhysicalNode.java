package com.rsj.aerion.inventory.models;

import com.rsj.aerion.ipinventory.models.IpAddress;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @OneToOne
    private IpAddress managementIp;
    private String type;
    private String serialNumber;
    private String details;
    private String location;
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
    private List<LogicalVolume> lvs;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public IpAddress getManagementIp() {
        return managementIp;
    }

    public void setManagementIp(IpAddress managementIp) {
        this.managementIp = managementIp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Long getHardwareTypeId() {
        return hardwareTypeId;
    }

    public void setHardwareTypeId(Long hardwareTypeId) {
        this.hardwareTypeId = hardwareTypeId;
    }

    public Long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Long updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Long getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Long purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getChassisSerialNumber() {
        return chassisSerialNumber;
    }

    public void setChassisSerialNumber(String chassisSerialNumber) {
        this.chassisSerialNumber = chassisSerialNumber;
    }

    public Long getChassisId() {
        return chassisId;
    }

    public void setChassisId(Long chassisId) {
        this.chassisId = chassisId;
    }

    public Integer getServerLocation() {
        return serverLocation;
    }

    public void setServerLocation(Integer serverLocation) {
        this.serverLocation = serverLocation;
    }

    public Integer getRamSize() {
        return ramSize;
    }

    public void setRamSize(Integer ramSize) {
        this.ramSize = ramSize;
    }

    public Integer getMaxRamCapacity() {
        return maxRamCapacity;
    }

    public void setMaxRamCapacity(Integer maxRamCapacity) {
        this.maxRamCapacity = maxRamCapacity;
    }

    public Integer getMaxRamModules() {
        return maxRamModules;
    }

    public void setMaxRamModules(Integer maxRamModules) {
        this.maxRamModules = maxRamModules;
    }

    public Integer getPowerConsumed() {
        return powerConsumed;
    }

    public void setPowerConsumed(Integer powerConsumed) {
        this.powerConsumed = powerConsumed;
    }

    public String getMotherboardModel() {
        return motherboardModel;
    }

    public void setMotherboardModel(String motherboardModel) {
        this.motherboardModel = motherboardModel;
    }

    public String getBiosVersion() {
        return biosVersion;
    }

    public void setBiosVersion(String biosVersion) {
        this.biosVersion = biosVersion;
    }

    public String getIpmiVersion() {
        return ipmiVersion;
    }

    public void setIpmiVersion(String ipmiVersion) {
        this.ipmiVersion = ipmiVersion;
    }

    public String getBmcVersion() {
        return bmcVersion;
    }

    public void setBmcVersion(String bmcVersion) {
        this.bmcVersion = bmcVersion;
    }

    public String getServerModel() {
        return serverModel;
    }

    public void setServerModel(String serverModel) {
        this.serverModel = serverModel;
    }

    public Integer getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(Integer diskSize) {
        this.diskSize = diskSize;
    }

    public Integer getDiskCount() {
        return diskCount;
    }

    public void setDiskCount(Integer diskCount) {
        this.diskCount = diskCount;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public Integer getDiskEncryption() {
        return diskEncryption;
    }

    public void setDiskEncryption(Integer diskEncryption) {
        this.diskEncryption = diskEncryption;
    }

    public Integer getPowerStatus() {
        return powerStatus;
    }

    public void setPowerStatus(Integer powerStatus) {
        this.powerStatus = powerStatus;
    }

    public String getBootMode() {
        return bootMode;
    }

    public void setBootMode(String bootMode) {
        this.bootMode = bootMode;
    }

    public String getSecureBoot() {
        return secureBoot;
    }

    public void setSecureBoot(String secureBoot) {
        this.secureBoot = secureBoot;
    }

    public Integer getIpmiStatus() {
        return ipmiStatus;
    }

    public void setIpmiStatus(Integer ipmiStatus) {
        this.ipmiStatus = ipmiStatus;
    }

    public Long getIpmiUpdatedTime() {
        return ipmiUpdatedTime;
    }

    public void setIpmiUpdatedTime(Long ipmiUpdatedTime) {
        this.ipmiUpdatedTime = ipmiUpdatedTime;
    }

    public List<LogicalVolume> getLvs() {
        return lvs;
    }

    public void setLvs(List<LogicalVolume> lvs) {
        this.lvs = lvs;
    }
}
