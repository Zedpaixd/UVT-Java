package com.example.lab9javafx;

import java.util.Arrays;

public class Encryption {

    public static String Encrypt(String string, String encryptionKey)
    {
        if (string.isEmpty()) return "";
        return Arrays.toString(new int[]{(string + encryptionKey).hashCode()});
    }

}
