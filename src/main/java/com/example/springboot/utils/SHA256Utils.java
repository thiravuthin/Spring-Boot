package com.example.springboot.utils;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Getter
@Setter
public class SHA256Utils {

    private String salt;

    public SHA256Utils(String salt) {
        this.salt = salt;
    }

    public String encrypt(String str) throws NoSuchAlgorithmException {

        if (str == null) return "";

        if (salt == null) return "";

        byte[] hashValue;

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        md.reset();
        md.update(salt.getBytes());

        hashValue = md.digest(str.getBytes());

        //String s = new String(Base64.encodeBase64(hashValue));
        return null;
    }

}