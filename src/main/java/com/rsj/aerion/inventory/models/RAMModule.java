package com.rsj.aerion.inventory.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class RAMModule {

    public RAMModule() {
    }

    public RAMModule(Long id, RAMType type, String size, String speed, String configuredClockSpeed, String manufacturer, String partNumber, String locator) {
        this.id = id;
        this.type = type;
        this.size = size;
        this.speed = speed;
        this.configuredClockSpeed = configuredClockSpeed;
        this.manufacturer = manufacturer;
        this.partNumber = partNumber;
        this.locator = locator;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private RAMType type;                  // e.g., DDR4
    private String size;                  // e.g., 32 GB
    private String speed;                 // e.g., 3200 MT/s
    private String configuredClockSpeed;  // e.g., 3200 MT/s
    private String manufacturer;          // e.g., 802C869D802C
    private String partNumber;            // e.g., 36ASF4G72PZ-3G2J3
    private String locator;               // e.g., A2 (DIMM slot location)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RAMType getType() {
        return type;
    }

    public void setType(RAMType type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getConfiguredClockSpeed() {
        return configuredClockSpeed;
    }

    public void setConfiguredClockSpeed(String configuredClockSpeed) {
        this.configuredClockSpeed = configuredClockSpeed;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getLocator() {
        return locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }
}
