package com.Mehmet;

import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import org.bouncycastle.util.encoders.Hex;

public class Main {
    public static void main(String[] args) {
        SHA2 sha2 = new SHA2();
        String hashedValue = sha2.digest("Merhaba", "SHA-256");
        System.out.println("Şifrelenmiş metin: " + hashedValue);
    }
}

class SHA2 {
    public String digest(String text, String functionValue) {
        try {
            MessageDigest digestObject = MessageDigest.getInstance(functionValue);
            digestObject.update(text.getBytes(StandardCharsets.UTF_8));
            byte[] digestBytes = digestObject.digest();
            return new String(Hex.encode(digestBytes));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
