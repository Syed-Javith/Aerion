package com.rsj.aerion.security.authorization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
@Scope("singleton")
public class RoleMapper {

    @JsonProperty("roles")
    private Map<String, List<String>> roles;

    public Map<String, List<String>> getRoles() {
        return roles;
    }

    public void setRoles(Map<String, List<String>> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "RoleMapper{" +
                "roles=" + roles +
                '}';
    }
}
