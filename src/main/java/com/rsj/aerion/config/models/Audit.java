package com.rsj.aerion.config.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Audit {

    Audit() {

    }

    public Audit(String title, String message, Long timeStamp) {
        this.title = title;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public Audit(Long id, String title, String message, Long timeStamp) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String message;
    private Long timeStamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
