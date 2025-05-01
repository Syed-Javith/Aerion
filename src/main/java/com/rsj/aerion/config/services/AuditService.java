package com.rsj.aerion.config.services;

import com.rsj.aerion.config.models.ApiAudit;
import com.rsj.aerion.config.models.Audit;
import com.rsj.aerion.config.models.UserAudit;
import com.rsj.aerion.config.repositories.ApiAuditRepository;
import com.rsj.aerion.config.repositories.AuditRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuditService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuditService.class);

    @Autowired
    private AuditRepository auditRepository;
    @Autowired
    private ApiAuditRepository apiAuditRepository;

    public void addUserAudit(UserAudit userAudit) {
        auditRepository.save(userAudit);
    }

    public void addApiAudit(ApiAudit apiAudit) {
        apiAuditRepository.save(apiAudit);
    }

    public ResponseEntity<?> fetchAllUserAudits() {
        try {
            List<UserAudit> audits = auditRepository.findAll();
            System.out.println(audits);
            return ResponseEntity.ok(new ArrayList<UserAudit>(audits));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
