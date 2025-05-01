package com.rsj.aerion.security.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

    private static final BCryptPasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder(12);

    public static String hashPassword(String password) {
        return PASSWORD_ENCODER.encode(password);
    }
}
