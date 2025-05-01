package com.rsj.aerion.usermgmt.services;

import com.rsj.aerion.config.models.UserAudit;
import com.rsj.aerion.config.services.AuditService;
import com.rsj.aerion.security.utils.PasswordUtils;
import com.rsj.aerion.usermgmt.models.Role;
import com.rsj.aerion.usermgmt.models.User;
import com.rsj.aerion.usermgmt.models.UserDetailsImpl;
import com.rsj.aerion.usermgmt.repositories.RoleRepository;
import com.rsj.aerion.usermgmt.repositories.UserMgmtRepository;
import com.rsj.aerion.usermgmt.utils.UserMgmtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserMgmtService implements UserDetailsService {

    @Autowired
    UserMgmtRepository userMgmtRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    AuditService auditService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMgmtRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserDetailsImpl(user);
    }

    public boolean save(User user, HttpServletRequest request) {
        List<Role> finalRoles = new ArrayList<>();

        for (Role role : user.getRoles()) {
            Role newRoleToBeAdded = roleRepository.findByName(role.getName())
                    .orElseGet(() -> {
                        Role newRole = new Role();
                        newRole.setName(role.getName());
                        return roleRepository.save(newRole);
                    });
            finalRoles.add(newRoleToBeAdded);
        }
        user.setPassword(PasswordUtils.hashPassword(user.getPassword()));
        user.setRoles(finalRoles);
        user = userMgmtRepository.save(user);
        UserAudit userAudit = new UserAudit("User Addition", "New User - " + user.getName() + " added with roles " + user.getRoles(), System.currentTimeMillis(), UserMgmtUtil.getLoggedInUserName(), UserMgmtUtil.getUserIpAddress(request));
        auditService.addUserAudit(userAudit);
        return user.getId() != null;
    }
}
