package com.rsj.aerion.ipinventory.repositories;

import com.rsj.aerion.ipinventory.models.IpAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IpRepository extends JpaRepository<IpAddress, Long> {
}
