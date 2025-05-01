package com.rsj.aerion.usermgmt.utils;

public class AuthResponse {

    public AuthResponse(String response) {
        this.response = response;
    }

    private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
