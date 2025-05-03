package com.rsj.aerion.inventory.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CentralProcessingUnit {

    @Id
    @GeneratedValue
    private Long id;

    private String vendor;
    private String model;
    private String architecture;
    private int physicalCpu;
    private int cores;
    private int threadsPerCore;
    private int siblings;
    private int cpus;
    private String l1dCache;
    private String l1iCache;
    private String l2Cache;
    private String l3Cache;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public int getPhysicalCpu() {
        return physicalCpu;
    }

    public void setPhysicalCpu(int physicalCpu) {
        this.physicalCpu = physicalCpu;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public int getThreadsPerCore() {
        return threadsPerCore;
    }

    public void setThreadsPerCore(int threadsPerCore) {
        this.threadsPerCore = threadsPerCore;
    }

    public int getSiblings() {
        return siblings;
    }

    public void setSiblings(int siblings) {
        this.siblings = siblings;
    }

    public int getCpus() {
        return cpus;
    }

    public void setCpus(int cpus) {
        this.cpus = cpus;
    }

    public String getL1dCache() {
        return l1dCache;
    }

    public void setL1dCache(String l1dCache) {
        this.l1dCache = l1dCache;
    }

    public String getL1iCache() {
        return l1iCache;
    }

    public void setL1iCache(String l1iCache) {
        this.l1iCache = l1iCache;
    }

    public String getL2Cache() {
        return l2Cache;
    }

    public void setL2Cache(String l2Cache) {
        this.l2Cache = l2Cache;
    }

    public String getL3Cache() {
        return l3Cache;
    }

    public void setL3Cache(String l3Cache) {
        this.l3Cache = l3Cache;
    }
}
