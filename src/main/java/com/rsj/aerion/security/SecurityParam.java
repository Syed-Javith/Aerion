package com.rsj.aerion.security;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SecurityParam {
    @JsonProperty("type")
    private ParamType type;
    @JsonProperty("regex")
    private String regex;
    @JsonProperty("minOccurrence")
    private int minOccurrence;
    @JsonProperty("maxOccurrence")
    private int maxOccurrence;

    public SecurityParam() {
    }
    public SecurityParam(ParamType type, String regex, int minOccurrence, int maxOccurrence) {
        this.type = type;
        this.regex = regex;
        this.minOccurrence = minOccurrence;
        this.maxOccurrence = maxOccurrence;
    }

    public ParamType getType() {
        return type;
    }

    public void setType(ParamType type) {
        this.type = type;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public int getMinOccurrence() {
        return minOccurrence;
    }

    public void setMinOccurrence(int minOccurrence) {
        this.minOccurrence = minOccurrence;
    }

    public int getMaxOccurrence() {
        return maxOccurrence;
    }

    public void setMaxOccurrence(int maxOccurrence) {
        this.maxOccurrence = maxOccurrence;
    }

    @Override
    public String toString() {
        return "SecurityParam{" +
                " type=" + type +
                ", regex='" + regex + '\'' +
                ", minOccurrence=" + minOccurrence +
                ", maxOccurrence=" + maxOccurrence +
                '}';
    }
}
