package com.rsj.aerion.inventory.models;

public enum RAMType {
    DDR,
    DDR2,
    DDR3,
    DDR4,
    DDR5,
    LPDDR,
    GDDR5,
    GDDR6,
    ECC_DDR4,
    ECC_DDR5,
    SODIMM,
    UDIMM,
    RDIMM,
    LRDIMM,
    NVDIMM;

    @Override
    public String toString() {
        return name().replace("_", "-");
    }

    public static RAMType getRAMType(String type) {
        for(RAMType ramType : RAMType.values()) {
            if(ramType.toString().equals(type)) return ramType;
        }
        return DDR;
    }
}
