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
import jakarta.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Node {

    public Node() {}

    public Node(Long id, IpAddress ipAddress, OS osInfo) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.osInfo = osInfo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private IpAddress ipAddress;

    @ManyToOne
    private OS osInfo;

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
}
