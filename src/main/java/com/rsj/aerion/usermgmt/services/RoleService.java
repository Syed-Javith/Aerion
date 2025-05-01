package com.rsj.aerion.usermgmt.services;

import com.rsj.aerion.usermgmt.models.Role;
import com.rsj.aerion.usermgmt.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public ResponseEntity<?> addRole(@RequestBody Role role) {
        try {
            roleRepository.save(role);
            return ResponseEntity.created(new URI("role")).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
