package com.rsj.aerion.ipinventory.handlers;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class DHCPDiscovery implements Discovery{

    JSONObject dhcpDetails = new JSONObject();

    @Override
    public JSONObject discover() {
        return dhcpDetails;
    }
}
