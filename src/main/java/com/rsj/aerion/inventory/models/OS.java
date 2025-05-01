package com.rsj.aerion.inventory.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String osName;
    @Enumerated(EnumType.STRING)
    private OSType osType;
    String kernelVersion;

    public OS() {
    }

    public OS(String osName, OSType osType, String kernelVersion) {
        this.osName = osName;
        this.osType = osType;
        this.kernelVersion = kernelVersion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public OSType getOsType() {
        return osType;
    }

    public void setOsType(OSType osType) {
        this.osType = osType;
    }

    public String getKernelVersion() {
        return kernelVersion;
    }

    public void setKernelVersion(String kernelVersion) {
        this.kernelVersion = kernelVersion;
    }
}
