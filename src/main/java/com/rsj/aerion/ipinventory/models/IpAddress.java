package com.rsj.aerion.ipinventory.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class IpAddress {

    public IpAddress() {
    }

    public IpAddress(String ip) {
        this.ip = ip;
        this.type = AddressType.MANAGEMENT_IP;
        this.hostName = ip;
    }

    public IpAddress(Long id, String ip, Subnet subnet, AddressType type, boolean pingable, String hostName, String macAddress, String netmask, String ipv6, int v6Prefix, String v6LinkLocal, Long updatedTime, Long pingUpdatedTime) {
        this.id = id;
        this.ip = ip;
        this.subnet = subnet;
        this.type = type;
        this.pingable = pingable;
        this.hostName = hostName;
        this.macAddress = macAddress;
        this.netmask = netmask;
        this.ipv6 = ipv6;
        this.v6Prefix = v6Prefix;
        this.v6LinkLocal = v6LinkLocal;
        this.updatedTime = updatedTime;
        this.pingUpdatedTime = pingUpdatedTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ip;
    @ManyToOne
    private Subnet subnet;
    @Enumerated(EnumType.STRING)
    private AddressType type;
	@Column(nullable = false)
    private boolean pingable = true;
	@Column(unique = true)
	private String hostName;
	@Column(unique = true)
	private String macAddress;
	@Column(length = 20)
	private String netmask;
	@Column(unique = true)
	private String ipv6;
    @Column(nullable = false)
	private int v6Prefix = -1;
    @Column(length = 50)
	private String v6LinkLocal;
	private Long updatedTime;
	private Long pingUpdatedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Subnet getSubnet() {
        return subnet;
    }

    public void setSubnet(Subnet subnet) {
        this.subnet = subnet;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    public boolean isPingable() {
        return pingable;
    }

    public void setPingable(boolean pingable) {
        this.pingable = pingable;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getNetmask() {
        return netmask;
    }

    public void setNetmask(String netmask) {
        this.netmask = netmask;
    }

    public String getIpv6() {
        return ipv6;
    }

    public void setIpv6(String ipv6) {
        this.ipv6 = ipv6;
    }

    public int getV6Prefix() {
        return v6Prefix;
    }

    public void setV6Prefix(int v6Prefix) {
        this.v6Prefix = v6Prefix;
    }

    public String getV6LinkLocal() {
        return v6LinkLocal;
    }

    public void setV6LinkLocal(String v6LinkLocal) {
        this.v6LinkLocal = v6LinkLocal;
    }

    public Long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Long updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Long getPingUpdatedTime() {
        return pingUpdatedTime;
    }

    public void setPingUpdatedTime(Long pingUpdatedTime) {
        this.pingUpdatedTime = pingUpdatedTime;
    }

    public String toString() {
        return "IP Address " + this.ip;
    }
}
