package com.rsj.aerion.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class SecurityParser implements Parser {

    @Autowired
    private SecurityMapper securityMapper;

    public void parse() throws Exception {
        ClassPathResource resource = getResource();
        ObjectMapper objectMapper = new ObjectMapper();
        SecurityMapper parsed = objectMapper.readValue(resource.getInputStream(), SecurityMapper.class);
        securityMapper.setUrls(parsed.getUrls());
    }

    @Override
    public ClassPathResource getResource() {
        return new ClassPathResource("security/security.json");
    }
}
