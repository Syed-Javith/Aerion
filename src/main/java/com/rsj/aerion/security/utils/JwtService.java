package com.rsj.aerion.security.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class JwtService {

    private  static final Long EXPIRATION_TIME = TimeUnit.HOURS.toMillis(24);
    private static final String KEY = "212bc4e86316e24a601da55e4144cf5cdd8e5f3365a12f320042fa2c78f32f6a";

    public String generateToken(String username) throws Exception {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .addClaims(claims)
                .setSubject(username)
                .setIssuedAt( new Date(System.currentTimeMillis()))
                .setExpiration( new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(Crypto.getSignatureAlgorithm(), KEY)
                .compact();
    }

    public Claims getClaims(String token) {
        System.out.println(token);
        return Jwts.parserBuilder().setSigningKey(KEY).build().parseClaimsJws(token).getBody();
    }

    public String extractUserName(String token) {
        return getClaims(token).getSubject();
    }

    public boolean validateToke(String token, UserDetails userDetails) {
        String username = extractUserName(token);
        return username.equals(userDetails.getUsername()) && !isExpired(token);
    }

    private boolean isExpired(String token) {
        Date expiration = getClaims(token).getExpiration();
        return expiration.before(new Date());
    }
}
