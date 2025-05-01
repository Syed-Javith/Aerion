package com.rsj.aerion.web.interceptors;

import com.rsj.aerion.security.authorization.RoleMapper;
import com.rsj.aerion.usermgmt.models.UserDetailsImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationInterceptor.class);
    private static final List ADMIN_USERS = Arrays.asList("admin@gmail.com","admin1@gmail.com") ;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!authentication.isAuthenticated()) {
            return false;
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetailsImpl userDetails) {
            String username = userDetails.getUsername();
            LOGGER.info("Authenticated user: {}", username);
            if(ADMIN_USERS.contains(username)) {
                return true;
            }
            List<GrantedAuthority> roles = new ArrayList<>(userDetails.getAuthorities());
            String uri = request.getRequestURI().replace("/api", "");
            for(GrantedAuthority role : roles) {
                String roleName = role.getAuthority();
                List<String> allowedURLs = roleMapper.getRoles().get(roleName);
                if(!allowedURLs.contains(uri)) {
                    return false;
                }
            }
        }
        return true;
    }

}
