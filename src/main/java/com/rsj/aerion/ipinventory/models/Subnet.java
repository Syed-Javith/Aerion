package com.rsj.aerion.ipinventory.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Subnet {

    Subnet() {

    }

    public Subnet(Long id, String name, String cidr, List<IpAddress> ipAddresses) {
        this.id = id;
        this.name = name;
        this.cidr = cidr;
        this.ipAddresses = ipAddresses;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cidr;
    @OneToMany(mappedBy = "subnet", fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<IpAddress> ipAddresses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCidr() {
        return cidr;
    }

    public void setCidr(String cidr) {
        this.cidr = cidr;
    }

    public List<IpAddress> getIpAddresses() {
        return ipAddresses;
    }

    public void setIpAddresses(List<IpAddress> ipAddresses) {
        this.ipAddresses = ipAddresses;
    }
}
