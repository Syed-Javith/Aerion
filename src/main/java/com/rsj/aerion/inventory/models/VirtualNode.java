package com.rsj.aerion.inventory.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "node_id")
public class VirtualNode extends Node {

    @Column(unique = true)
    private String vmName;
    private Integer ramSize;
    private Integer cpuCores;
    @Column(unique = true)
    private String label;
    private String bootMode;
    private String details;
    private Boolean isCpuPinned;
    private String cpuAffinity;
    private Integer cpuGroup;
    private Long lvId;
    private String secureBoot;

    public VirtualNode() {}

    @ManyToOne
    private PhysicalNode physicalNode;

    public String getVmName() {
        return vmName;
    }

    public void setVmName(String vmName) {
        this.vmName = vmName;
    }

    public Integer getRamSize() {
        return ramSize;
    }

    public void setRamSize(Integer ramSize) {
        this.ramSize = ramSize;
    }

    public Integer getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(Integer cpuCores) {
        this.cpuCores = cpuCores;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getBootMode() {
        return bootMode;
    }

    public void setBootMode(String bootMode) {
        this.bootMode = bootMode;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Boolean getIsCpuPinned() {
        return isCpuPinned;
    }

    public void setIsCpuPinned(Boolean isCpuPinned) {
        this.isCpuPinned = isCpuPinned;
    }

    public String getCpuAffinity() {
        return cpuAffinity;
    }

    public void setCpuAffinity(String cpuAffinity) {
        this.cpuAffinity = cpuAffinity;
    }

    public Integer getCpuGroup() {
        return cpuGroup;
    }

    public void setCpuGroup(Integer cpuGroup) {
        this.cpuGroup = cpuGroup;
    }

    public Long getLvId() {
        return lvId;
    }

    public void setLvId(Long lvId) {
        this.lvId = lvId;
    }

    public String getSecureBoot() {
        return secureBoot;
    }

    public void setSecureBoot(String secureBoot) {
        this.secureBoot = secureBoot;
    }

    public PhysicalNode getPhysicalNode() {
        return physicalNode;
    }

    public void setPhysicalNode(PhysicalNode physicalNode) {
        this.physicalNode = physicalNode;
    }

    public VirtualNode(String vmName, Integer ramSize, Integer cpuCores, String label, String bootMode,
                       String details, Boolean isCpuPinned, String cpuAffinity, Integer cpuGroup,
                       Long lvId, String secureBoot, PhysicalNode physicalNode) {
        this.vmName = vmName;
        this.ramSize = ramSize;
        this.cpuCores = cpuCores;
        this.label = label;
        this.bootMode = bootMode;
        this.details = details;
        this.isCpuPinned = isCpuPinned;
        this.cpuAffinity = cpuAffinity;
        this.cpuGroup = cpuGroup;
        this.lvId = lvId;
        this.secureBoot = secureBoot;
        this.physicalNode = physicalNode;
    }
}