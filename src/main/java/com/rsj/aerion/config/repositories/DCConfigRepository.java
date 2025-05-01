package com.rsj.aerion.config.repositories;

import com.rsj.aerion.config.models.DCConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DCConfigRepository extends JpaRepository<DCConfig, Long> {
}
