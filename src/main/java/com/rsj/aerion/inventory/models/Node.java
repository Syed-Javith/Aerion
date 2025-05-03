package com.rsj.aerion.inventory.models;

import com.rsj.aerion.ipinventory.models.IpAddress;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Node {

    public Node() {
    }

    public Node(Long id, IpAddress ipAddress, OS osInfo, CentralProcessingUnit centralProcessingUnit, List<RAMModule> ramModules) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.osInfo = osInfo;
        this.centralProcessingUnit = centralProcessingUnit;
        this.ramModules = ramModules;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private IpAddress ipAddress;

    @ManyToOne
    private OS osInfo;

    @ManyToOne
    private CentralProcessingUnit centralProcessingUnit;

    @OneToMany
    List<RAMModule> ramModules;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IpAddress getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(IpAddress ipAddress) {
        this.ipAddress = ipAddress;
    }

    public OS getOsInfo() {
        return osInfo;
    }

    public void setOsInfo(OS osInfo) {
        this.osInfo = osInfo;
    }

    public CentralProcessingUnit getCentralProcessingUnit() {
        return centralProcessingUnit;
    }

    public void setCentralProcessingUnit(CentralProcessingUnit centralProcessingUnit) {
        this.centralProcessingUnit = centralProcessingUnit;
    }

    public List<RAMModule> getRamModules() {
        return ramModules;
    }

    public void setRamModules(List<RAMModule> ramModules) {
        this.ramModules = ramModules;
    }
}
