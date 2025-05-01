package com.rsj.aerion.usermgmt.repositories;

import com.rsj.aerion.usermgmt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserMgmtRepository extends JpaRepository<User, Long> {

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);
}
