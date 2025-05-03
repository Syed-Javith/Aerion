package com.rsj.aerion.ipinventory.models;

public enum AddressType {
    NOT_KNOWN("NA"),
    VIRTUAL_NODE("VM"),
    FLOATING_IP("FLOAT"),
    CONTAINER_NODE("CONTAINER"),
    KVM_HOST("KVM"),
    CONTAINER_HOST("CONTAINER_HOST"),
    MANAGEMENT_IP("MGMT_IP");

    AddressType(String type) {
        this.type = type;
    }

    private final String type;

    public static AddressType getType(String type) throws Exception {
        for(AddressType addressType : AddressType.values()) {
            if(addressType.type.equals(type)) return addressType;
        }
        throw new Exception("No Such instance available");
    }
}
