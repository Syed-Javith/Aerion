package com.rsj.aerion.controllers;

import com.rsj.aerion.config.services.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/audit")
public class AuditController {

    @Autowired
    AuditService auditService;

    @GetMapping("/user")
    public ResponseEntity<?> fetchUserAudits() {
        System.out.println("Audit hit");
        return auditService.fetchAllUserAudits();
    }
}
