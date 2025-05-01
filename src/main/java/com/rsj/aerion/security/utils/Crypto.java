package com.rsj.aerion.security.utils;

import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class Crypto {

    private static final String ALGORITHM = "HmacSHA256";
    private static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;
    private static final Logger LOGGER = LoggerFactory.getLogger(Crypto.class);

    public static Key generateKey() {
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("Error generating key", e);
        }
        keyGenerator.init(256);
        return keyGenerator.generateKey();
    }

    public static SignatureAlgorithm getSignatureAlgorithm() {
        return SIGNATURE_ALGORITHM;
    }
}
