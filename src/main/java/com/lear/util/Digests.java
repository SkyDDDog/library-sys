package com.lear.util;


import com.lear.exception.Exceptions;
import org.apache.commons.lang3.Validate;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class Digests {

    private static final String SHA1 = "SHA-1";
    private static final String MD5 = "MD5";
    private static SecureRandom random = new SecureRandom();

    public Digests() {
    }

    public static byte[] md5(byte[] input) {
        return digest(input, "MD5", (byte[])null, 1);
    }

    public static byte[] md5(byte[] input, int iterations) {
        return digest(input, "MD5", (byte[])null, iterations);
    }

    public static byte[] sha1(byte[] input) {
        return digest(input, "SHA-1", (byte[])null, 1);
    }

    public static byte[] sha1(byte[] input, byte[] salt) {
        return digest(input, "SHA-1", salt, 1);
    }

    public static byte[] sha1(byte[] input, byte[] salt, int iterations) {
        return digest(input, "SHA-1", salt, iterations);
    }

    private static byte[] digest(byte[] input, String algorithm, byte[] salt, int iterations) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            if (salt != null) {
                digest.update(salt);
            }

            byte[] result = digest.digest(input);

            for(int i = 1; i < iterations; ++i) {
                digest.reset();
                result = digest.digest(result);
            }

            return result;
        } catch (GeneralSecurityException var7) {
            throw Exceptions.unchecked(var7);
        }
    }

    public static byte[] generateSalt(int numBytes) {
        Validate.isTrue(numBytes > 0, "numBytes argument must be a positive integer (1 or larger)", (long)numBytes);
        byte[] bytes = new byte[numBytes];
        random.nextBytes(bytes);
        return bytes;
    }

    public static byte[] md5(InputStream input) throws IOException {
        return digest(input, "MD5");
    }

    public static byte[] sha1(InputStream input) throws IOException {
        return digest(input, "SHA-1");
    }

    private static byte[] digest(InputStream input, String algorithm) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            int bufferLength = 8192;
            byte[] buffer = new byte[bufferLength];

            for(int read = input.read(buffer, 0, bufferLength); read > -1; read = input.read(buffer, 0, bufferLength)) {
                messageDigest.update(buffer, 0, read);
            }

            return messageDigest.digest();
        } catch (GeneralSecurityException var6) {
            throw Exceptions.unchecked(var6);
        }
    }



}
