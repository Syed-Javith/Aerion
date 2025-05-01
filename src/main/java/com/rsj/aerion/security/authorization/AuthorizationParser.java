package com.rsj.aerion.security.authorization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rsj.aerion.security.Parser;
import com.rsj.aerion.usermgmt.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class AuthorizationParser implements Parser {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public void parse() throws Exception {
        ClassPathResource resource = getResource();
        ObjectMapper objectMapper = new ObjectMapper();
        RoleMapper parsed = objectMapper.readValue(resource.getInputStream(), RoleMapper.class);
        roleMapper.setRoles(parsed.getRoles());
        Map<String, List<String>> roleVsURLs = roleMapper.getRoles();
        for(String role : roleVsURLs.keySet()) {
            int nUrls = roleVsURLs.get(role).size();
            List<String> allowedURLs = new ArrayList<>();
            for(int urlIndex = 0; urlIndex < nUrls; urlIndex++) {
                String url = roleVsURLs.get(role).get(urlIndex);
                if(url.startsWith("Role:")) {
                    String embeddedRole = url.replace("Role:", "");
                    allowedURLs.addAll(roleVsURLs.get(embeddedRole));
                    continue;
                }
                allowedURLs.add(url);
            }
            roleVsURLs.put(role, allowedURLs);
        }
    }

    @Override
    public ClassPathResource getResource() {
        return new ClassPathResource("security/roles.json");
    }
}
