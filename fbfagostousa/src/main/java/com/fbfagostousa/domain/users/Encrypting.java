package com.fbfagostousa.domain.users;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import org.apache.logging.log4j.LogManager;

public class Encrypting {

    public static final String SHA1 = "SHA-1";

    public static final String SHA256 = "SHA-256";

    public static final String SHA384 = "SHA-384";

    public static final String SHA512 = "SHA-512";

    private String algorithm;

    public Encrypting(String algorithm) {
        this.algorithm = algorithm;
    }

    public Encrypting() {
        this(SHA1);
    }

    public byte[] encrypt(String message) {
        byte[] digest = null;
        byte[] buffer = message.getBytes(StandardCharsets.UTF_8);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException nsae) {
            LogManager.getLogger(this.getClass()).error("Error: " + nsae);
        }
        return digest;
    }

    public String encryptInString(String message) {
        byte[] digest = this.encrypt(message);
        String hash = "";
        for (byte digito : digest) {
            int b = digito & 0xff; // 0..255
            if (b < 16) {
                hash += "0";
            } else
                hash += (Integer.toHexString(b));
        }
        return hash.toString();
    }

    public String encryptInBase64(String message) {
        byte[] digest = this.encrypt(message);
        return Base64.getEncoder().encodeToString(digest);
    }

    public String encryptInBase64UrlSafe(String message) {
        byte[] digest = this.encrypt(message);
        String code64Url = Base64.getUrlEncoder().encodeToString(digest);
        return code64Url.substring(0, code64Url.indexOf("="));
    }
}
