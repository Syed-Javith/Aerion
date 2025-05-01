package com.rsj.aerion.inventory.models;

import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "node_id")
public class ContainerNode extends Node {

    @Column(unique = true, nullable = false, length = 50)
    private String label;

    @Column(nullable = false, length = 15)
    private String containerName;

    @ManyToOne
    private PhysicalNode physicalNode;

    @Column(nullable = false)
    private int ramSize = 0;

    @Column(nullable = false)
    private int driveSize = 0;

    @Column(nullable = false, length = 20)
    private String runningStatus = "running";

    @Column(nullable = false)
    private int cpuCores = 0;

    @Column(nullable = false, length = 50)
    private String containerType;

    @Column(nullable = false)
    private boolean isCpuPinned = false;

    @Column(nullable = false)
    private int cpuGroup = 0;

    @Column(nullable = false)
    private byte isSwapEnabled = -1;

    public ContainerNode() {
    }

    public ContainerNode(String label, String containerName, PhysicalNode physicalNode, int ramSize,
                         int driveSize, String runningStatus, int cpuCores, String containerType,
                         boolean isCpuPinned, int cpuGroup, byte isSwapEnabled) {
        this.label = label;
        this.containerName = containerName;
        this.physicalNode = physicalNode;
        this.ramSize = ramSize;
        this.driveSize = driveSize;
        this.runningStatus = runningStatus;
        this.cpuCores = cpuCores;
        this.containerType = containerType;
        this.isCpuPinned = isCpuPinned;
        this.cpuGroup = cpuGroup;
        this.isSwapEnabled = isSwapEnabled;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getContainerName() {
        return containerName;
    }

    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    public PhysicalNode getPhysicalNodeId() {
        return physicalNode;
    }

    public void setPhysicalNodeId(PhysicalNode physicalNode) {
        this.physicalNode = physicalNode;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public int getDriveSize() {
        return driveSize;
    }

    public void setDriveSize(int driveSize) {
        this.driveSize = driveSize;
    }

    public String getRunningStatus() {
        return runningStatus;
    }

    public void setRunningStatus(String runningStatus) {
        this.runningStatus = runningStatus;
    }

    public int getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(int cpuCores) {
        this.cpuCores = cpuCores;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public boolean isCpuPinned() {
        return isCpuPinned;
    }

    public void setCpuPinned(boolean cpuPinned) {
        isCpuPinned = cpuPinned;
    }

    public int getCpuGroup() {
        return cpuGroup;
    }

    public void setCpuGroup(int cpuGroup) {
        this.cpuGroup = cpuGroup;
    }

    public byte getIsSwapEnabled() {
        return isSwapEnabled;
    }

    public void setIsSwapEnabled(byte isSwapEnabled) {
        this.isSwapEnabled = isSwapEnabled;
    }
}