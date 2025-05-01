package com.rsj.aerion.config.repositories;

import com.rsj.aerion.config.models.UserAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<UserAudit, Long> {
}
