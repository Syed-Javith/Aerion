package com.rsj.aerion.web.filters;

import com.rsj.aerion.security.SecurityException;
import com.rsj.aerion.security.SecurityMapper;
import com.rsj.aerion.security.SecurityRequest;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
public class SecurityFilter implements Filter {

    @Autowired
    private SecurityMapper securityMapper;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /*
        SecurityRequest securityRequest = new SecurityRequest((HttpServletRequest) request);
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        try {
            securityMapper.secureURL(securityRequest);
            chain.doFilter(securityRequest, httpResponse);
        } catch (Exception e) {
            httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpResponse.setContentType("application/json");
            String errorMessage = "Unable to proccess your request";
            if(e instanceof SecurityException) {
                errorMessage = e.getMessage();
            }
            httpResponse.getWriter().write("{\"error\": \"" + errorMessage + "\"}");
            response = httpResponse;
        }
         */
        chain.doFilter(request, response);
    }
}
