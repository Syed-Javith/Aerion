package com.rsj.aerion.config.repositories;

import com.rsj.aerion.config.models.ApiAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiAuditRepository extends JpaRepository<ApiAudit, Long> {
}
