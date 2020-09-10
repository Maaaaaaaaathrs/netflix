package com.netflix.movies.utils;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptoUtils {

    public static String decrypt(String strToDecr, String password, String algorithm) {
        StandardPBEStringEncryptor crypto = new StandardPBEStringEncryptor();
        crypto.setPassword(password);
        crypto.setAlgorithm(algorithm);
        return crypto.decrypt(strToDecr);
    }
}
