package com.rsj.aerion.inventory.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(name = "RAMModule_UK",
             columnNames =  {"type", "size", "speed", "configuredClockSpeed", "manufacturer", "partNumber", "locator"}
        )
)
public class RAMModule {

    public RAMModule() {
    }

    public RAMModule(Long id, RAMType type, int size, int speed, int configuredClockSpeed, String manufacturer, String partNumber, String locator) {
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
    @Column(length = 50)
    private RAMType type;                  // e.g., DDR4
    private int size;                  // e.g., 32 GB
    private int speed;                 // e.g., 3200 MT/s
    private int configuredClockSpeed;  // e.g., 3200 MT/s
    @Column(length = 100)
    private String manufacturer;          // e.g., 802C869D802C
    @Column(length = 100)
    private String partNumber;            // e.g., 36ASF4G72PZ-3G2J3
    @Column(length = 100)
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getConfiguredClockSpeed() {
        return configuredClockSpeed;
    }

    public void setConfiguredClockSpeed(int configuredClockSpeed) {
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
