package com.rsj.aerion.usermgmt.utils;

import com.rsj.aerion.usermgmt.models.UserDetailsImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserMgmtUtil {

    public static String getLoggedInUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if(principal instanceof UserDetailsImpl) {
            return ((UserDetailsImpl) principal).getUsername();
        }
        return "AnonymousUser";
    }

    public static String getUserIpAddress(HttpServletRequest request) {
        return request.getRemoteAddr();
    }
}
