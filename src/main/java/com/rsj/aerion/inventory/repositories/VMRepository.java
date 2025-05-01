package com.rsj.aerion.inventory.repositories;

import com.rsj.aerion.inventory.models.VirtualNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VMRepository extends JpaRepository<VirtualNode, Long> {
}
