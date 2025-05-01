package com.rsj.aerion.controllers;

import com.rsj.aerion.security.utils.JwtService;
import com.rsj.aerion.usermgmt.models.Role;
import com.rsj.aerion.usermgmt.models.User;
import com.rsj.aerion.usermgmt.services.RoleService;
import com.rsj.aerion.usermgmt.services.UserMgmtService;
import com.rsj.aerion.usermgmt.utils.AuthResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserMgmtController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserMgmtController.class);

    @Autowired
    private UserMgmtService userMgmtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private RoleService roleService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user, HttpServletRequest request) {
        try {
            userMgmtService.save(user, request);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody User user) throws Exception {
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
            );
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
        if(authentication.isAuthenticated()) {
            String jwt = jwtService.generateToken(user.getEmail());
            return ResponseEntity.ok(new AuthResponse(jwt));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/role")
    public ResponseEntity<?> addRole(@RequestBody Role role){
        return roleService.addRole(role);
    }

//    @GetMapping("/")
}
