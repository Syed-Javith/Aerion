package com.rsj.aerion.inventory.models;

import com.rsj.aerion.ipinventory.models.IpAddress;
import jakarta.persistence.CascadeType;
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

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private IpAddress ipAddress;

    @ManyToOne(cascade = CascadeType.ALL)
    private OS osInfo;

    @ManyToOne(cascade = CascadeType.ALL)
    private CentralProcessingUnit centralProcessingUnit;

    @OneToMany(cascade = CascadeType.ALL)
    List<RAMModule> ramModules;

    public Long getId() {
        return id;
    }

    public Node setId(Long id) {
        this.id = id;
        return this;
    }

    public IpAddress getIpAddress() {
        return ipAddress;
    }

    public Node setIpAddress(IpAddress ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public OS getOsInfo() {
        return osInfo;
    }

    public Node setOsInfo(OS osInfo) {
        this.osInfo = osInfo;
        return this;
    }

    public CentralProcessingUnit getCentralProcessingUnit() {
        return centralProcessingUnit;
    }

    public Node setCentralProcessingUnit(CentralProcessingUnit centralProcessingUnit) {
        this.centralProcessingUnit = centralProcessingUnit;
        return this;
    }

    public List<RAMModule> getRamModules() {
        return ramModules;
    }

    public Node setRamModules(List<RAMModule> ramModules) {
        this.ramModules = ramModules;
        return this;
    }
}
