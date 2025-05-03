package com.rsj.aerion.ipinventory.handlers;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DHCPDiscovery extends Discovery{

    JSONObject dhcpDetails = new JSONObject();

    @Override
    public void parse() throws IOException {

    }

    @Override
    public void compute() {

    }

    @Override
    public void cleanUp() {

    }
}
