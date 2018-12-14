package com.example.myfontsdk;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.example.myfontsdk.k */
public final class C0454k {
    /* renamed from: a */
    public static String m992a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            for (int i : instance.digest()) {
                int i2;
                if (i2 < 0) {
                    i2 += 256;
                }
                if (i2 < 16) {
                    stringBuilder.append("0");
                }
                stringBuilder.append(Integer.toHexString(i2));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
