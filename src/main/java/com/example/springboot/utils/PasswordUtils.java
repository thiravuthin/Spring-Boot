package com.example.springboot.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Base64;

@Component //
public class PasswordUtils {

    /***************************************************************
     * | Searching -> How to make Encryption security spring boot | *
     * **************************************************************/
    private static final String CIPHER_INSTANCE_NAME = "AES/CBC/PKCS5Padding";
    private static final String SECRET_KEY_ALGORITHM = "AES";
    public static String ENCRYPTION_KEY;

    public static String decrypt(String encryptedText) throws Exception {

        byte[] encrypted = Base64.getDecoder().decode(encryptedText);

        Cipher cipher = prepareAndInitCipher(Cipher.DECRYPT_MODE);

        byte[] original = cipher.doFinal(encrypted);
        return new String(original);
    }
    @Value("${password.encryption.key}")
    public void setEncryptionKey(String encryptionKey) {
        ENCRYPTION_KEY = encryptionKey;
    }

    private static Cipher prepareAndInitCipher(int encryptionMode) throws Exception {

        byte[] secretKey = getKey(ENCRYPTION_KEY);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, SECRET_KEY_ALGORITHM);

        String iv = new String(Hex.encode(secretKey)).substring(0, 16);
        IvParameterSpec algorithmParameters = new IvParameterSpec(iv.getBytes());

        Cipher cipher = Cipher.getInstance(CIPHER_INSTANCE_NAME);
        cipher.init(encryptionMode, secretKeySpec, algorithmParameters);

        return cipher;
    }

    private static byte[] getKey(String originalKey) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(originalKey.getBytes());
    }

}