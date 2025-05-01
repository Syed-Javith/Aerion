package com.rsj.aerion.inventory.handlers;

import com.rsj.aerion.ipinventory.handlers.Discovery;
import com.rsj.aerion.security.Parser;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;

import java.util.concurrent.RecursiveAction;

public class ServerDiscovery extends RecursiveAction implements Discovery, Parser {

    JSONObject serverInfo = new JSONObject();

    @Override
    public JSONObject discover() {
        return serverInfo;
    }

    @Override
    protected void compute() {

    }

    @Override
    public void parse() throws Exception {

    }

    @Override
    public ClassPathResource getResource() {
        return new ClassPathResource("data/servers.json");
    }
}
