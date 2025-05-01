// Subnet Interface
import {JSX, ReactNode} from "react";

export interface Subnet {
    id: number;
    name: string;
    cidr: string;
}

// IpAddress Interface
export interface IpAddress {
    id: number;
    ip: string;
    subnet: Subnet;
}

// Base Node Class
export class Node {
    id: number;
    ipAddress: IpAddress;

    constructor(id: number, ipAddress: IpAddress) {
        this.id = id;
        this.ipAddress = ipAddress;
    }
}

// VirtualNode Class extending Node
export class VirtualNode extends Node {
    vmName: string;
    ramSize: string;
    cpuCores: number;
    label: string;
    bootMode: string;
    details: string;
    isCpuPinned: boolean;
    cpuAffinity: string;
    cpuGroup: number;
    lvId: number;
    secureBoot: string;
    physicalNode: PhysicalNode;

    // extra params
    ipWithIcon?: JSX.Element;
    host?: JSX.Element;
    ramSizeInGB?: string;

    constructor(
        id: number,
        ipAddress: IpAddress,
        vmName: string,
        ramSize: string,
        cpuCores: number,
        label: string,
        bootMode: string,
        details: string,
        isCpuPinned: boolean,
        cpuAffinity: string,
        cpuGroup: number,
        lvId: number,
        secureBoot: string,
        physicalNode: PhysicalNode,
    ) {
        super(id, ipAddress);
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

    static getRamSizeInGB(ram: string): string {
        if(parseInt(ram) < 1024) {
            return `${ram} GB`;
        }
        return `${parseInt(ram) / 1024} TB`;
    }
}

export class PhysicalNode extends Node {
    label: string;
    managementIp: IpAddress;
    type: string;
    serialNumber: string;
    details: string;
    location: string;
    vendorId: number;
    hardwareTypeId: number;
    updatedTime: number;
    purchaseDate: number;
    chassisSerialNumber: string;
    chassisId: number;
    serverLocation: number;
    ramSize: number;
    maxRamCapacity: number;
    maxRamModules: number;
    powerConsumed: number;
    motherboardModel: string;
    biosVersion: string;
    ipmiVersion: string;
    bmcVersion: string;
    serverModel: string;
    diskSize: number;
    diskCount: number;
    driveType: string;
    diskEncryption: number;
    powerStatus: number;
    bootMode: string;
    secureBoot: string;
    ipmiStatus: number;
    ipmiUpdatedTime: number;

    constructor(
        id: number,
        ipAddress: IpAddress,
        label: string,
        managementIp: IpAddress,
        type: string,
        serialNumber: string,
        details: string,
        location: string,
        vendorId: number,
        hardwareTypeId: number,
        updatedTime: number,
        purchaseDate: number,
        chassisSerialNumber: string,
        chassisId: number,
        serverLocation: number,
        ramSize: number,
        maxRamCapacity: number,
        maxRamModules: number,
        powerConsumed: number,
        motherboardModel: string,
        biosVersion: string,
        ipmiVersion: string,
        bmcVersion: string,
        serverModel: string,
        diskSize: number,
        diskCount: number,
        driveType: string,
        diskEncryption: number,
        powerStatus: number,
        bootMode: string,
        secureBoot: string,
        ipmiStatus: number,
        ipmiUpdatedTime: number
    ) {
        super(id, ipAddress);
        this.label = label;
        this.managementIp = managementIp;
        this.type = type;
        this.serialNumber = serialNumber;
        this.details = details;
        this.location = location;
        this.vendorId = vendorId;
        this.hardwareTypeId = hardwareTypeId;
        this.updatedTime = updatedTime;
        this.purchaseDate = purchaseDate;
        this.chassisSerialNumber = chassisSerialNumber;
        this.chassisId = chassisId;
        this.serverLocation = serverLocation;
        this.ramSize = ramSize;
        this.maxRamCapacity = maxRamCapacity;
        this.maxRamModules = maxRamModules;
        this.powerConsumed = powerConsumed;
        this.motherboardModel = motherboardModel;
        this.biosVersion = biosVersion;
        this.ipmiVersion = ipmiVersion;
        this.bmcVersion = bmcVersion;
        this.serverModel = serverModel;
        this.diskSize = diskSize;
        this.diskCount = diskCount;
        this.driveType = driveType;
        this.diskEncryption = diskEncryption;
        this.powerStatus = powerStatus;
        this.bootMode = bootMode;
        this.secureBoot = secureBoot;
        this.ipmiStatus = ipmiStatus;
        this.ipmiUpdatedTime = ipmiUpdatedTime;
    }
}
