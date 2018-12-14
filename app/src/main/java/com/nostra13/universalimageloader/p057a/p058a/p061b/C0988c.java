package com.nostra13.universalimageloader.p057a.p058a.p061b;

import com.nostra13.universalimageloader.p064b.C0999c;
import java.math.BigInteger;
import java.security.MessageDigest;

/* renamed from: com.nostra13.universalimageloader.a.a.b.c */
public final class C0988c implements C0986a {
    /* renamed from: a */
    private static byte[] m2796a(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return instance.digest();
        } catch (Throwable e) {
            C0999c.m2832a(e);
            return bArr2;
        }
    }

    /* renamed from: a */
    public final String mo6146a(String str) {
        return new BigInteger(C0988c.m2796a(str.getBytes())).abs().toString(36);
    }
}
