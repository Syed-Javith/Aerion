package com.rsj.aerion.usermgmt.repositories;

import com.rsj.aerion.usermgmt.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    public Optional<Role> findByName(String name);
}
