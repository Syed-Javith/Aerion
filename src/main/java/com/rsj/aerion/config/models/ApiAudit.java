package com.rsj.aerion.config.models;

import jakarta.persistence.Entity;

@Entity
public class ApiAudit extends Audit {
    private String api;

    ApiAudit() {
        super();
    }

    public ApiAudit(Long id, String title, String message, Long timeStamp, String api) {
        super(id, title, message, timeStamp);
        this.api = api;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
