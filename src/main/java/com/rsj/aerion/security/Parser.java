package com.rsj.aerion.security;

import org.springframework.core.io.ClassPathResource;

public interface Parser {
    void parse() throws Exception;

    ClassPathResource getResource();
}
