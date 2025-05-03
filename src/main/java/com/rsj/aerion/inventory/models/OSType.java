package com.rsj.aerion.inventory.models;

public enum OSType {
    CENTOS("CentOS"),
    DEBIAN("Debian"),
    FREEBSD("FreeBSD"),
    WINDOWS("Windows"),
    MACOS("macOS");

    OSType(String  type) {
        this.type = type;
    }

    String type;

    public static OSType getOSType(String osType) throws Exception {
        for(OSType os : OSType.values()) {
            System.out.println(os.name() + " " + osType);
            if(os.type.equals(osType.trim())) return os;
        }
        throw new Exception("OS Type - " + osType + " is not supported.");
    }
}
