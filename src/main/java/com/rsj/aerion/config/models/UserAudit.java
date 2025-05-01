package com.rsj.aerion.config.models;

import jakarta.persistence.Entity;

@Entity
public class UserAudit extends Audit {

    private String user;
    private String ip;

    public UserAudit() {
        super();
    }

    public UserAudit(String title, String message, Long timeStamp, String user, String ip) {
        super(title, message, timeStamp);
        this.user = user;
        this.ip = ip;
    }

    public UserAudit(Long id, String title, String message, Long timeStamp, String user, String ip) {
        super(id, title, message, timeStamp);
        this.user = user;
        this.ip = ip;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
