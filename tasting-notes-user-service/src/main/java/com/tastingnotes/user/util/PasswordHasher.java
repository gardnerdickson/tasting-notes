package com.tastingnotes.user.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher
{
    private PasswordHasher()
    {
    }

    public static byte[] hash(char[] password) throws NoSuchAlgorithmException
    {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(new String(password).getBytes());
    }
}
