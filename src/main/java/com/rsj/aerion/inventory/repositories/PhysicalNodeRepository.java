package com.rsj.aerion.inventory.repositories;

import com.rsj.aerion.inventory.models.PhysicalNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhysicalNodeRepository extends JpaRepository<PhysicalNode, Long> {
    Optional<PhysicalNode> findByIpAddress_HostName(String hostName);
    Optional<PhysicalNode> findByManagementIp_HostName(String hostName);
}
