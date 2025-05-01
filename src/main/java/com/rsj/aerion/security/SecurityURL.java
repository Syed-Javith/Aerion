package com.rsj.aerion.security;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class SecurityURL {

    @JsonProperty("params")
    private Map<String, SecurityParam> params;

    public SecurityURL() {
    }

    public SecurityURL(Map<String, SecurityParam> params) {
        this.params = params;
    }

    public Map<String, SecurityParam> getParams() {
        return params;
    }

    public void setParams(Map<String, SecurityParam> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "SecurityURL{" +
                " params=" + params +
                '}';
    }
}
