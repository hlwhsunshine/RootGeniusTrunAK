package com.p070qq.p071e.comm.net.p072rr;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.util.Base64;
import com.p070qq.p071e.comm.C1058a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.qq.e.comm.net.rr.a */
public final class C1075a {
    /* renamed from: a */
    private static final byte[] f2850a = new byte[]{(byte) 91, (byte) -62};
    /* renamed from: b */
    private static Cipher f2851b = null;
    /* renamed from: c */
    private static Cipher f2852c = null;
    /* renamed from: d */
    private static byte[] f2853d = Base64.decode("4M3PpUC4Vu1uMp+Y0Mxd+vfc6v4ggJAINfgTlH74pis=", 0);

    /* renamed from: com.qq.e.comm.net.rr.a$a */
    static class C1073a extends Exception {
        public C1073a(String str, Throwable th) {
            super(str, th);
        }
    }

    /* renamed from: com.qq.e.comm.net.rr.a$b */
    public static class C1074b extends Exception {
        public C1074b(String str, Throwable th) {
            super(str, th);
        }
    }

    @SuppressLint({"TrulyRandom"})
    /* renamed from: a */
    private static synchronized Cipher m3116a() {
        Cipher cipher;
        synchronized (C1075a.class) {
            if (f2851b != null) {
                cipher = f2851b;
            } else {
                try {
                    cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
                    cipher.init(1, new SecretKeySpec(f2853d, "AES"));
                    f2851b = cipher;
                    cipher = f2851b;
                } catch (Throwable e) {
                    throw new C1073a("Fail To Init Cipher", e);
                }
            }
        }
        return cipher;
    }

    /* renamed from: a */
    public static byte[] m3117a(byte[] bArr) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.write(f2850a);
            dataOutputStream.writeByte(1);
            dataOutputStream.writeByte(2);
            dataOutputStream.write(C1075a.m3120c(C1058a.m3073a(bArr)));
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable e) {
            throw new C1074b("Exception while packaging byte array", e);
        }
    }

    /* renamed from: b */
    private static synchronized Cipher m3118b() {
        Cipher cipher;
        synchronized (C1075a.class) {
            if (f2852c != null) {
                cipher = f2852c;
            } else {
                try {
                    cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
                    cipher.init(2, new SecretKeySpec(f2853d, "AES"));
                    f2852c = cipher;
                    cipher = f2852c;
                } catch (Throwable e) {
                    throw new C1073a("Fail To Init Cipher", e);
                }
            }
        }
        return cipher;
    }

    @TargetApi(9)
    /* renamed from: b */
    public static byte[] m3119b(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            throw new C1074b("S2SS Package FormatError", null);
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
            byte[] bArr2 = new byte[4];
            dataInputStream.read(bArr2);
            if (f2850a[0] == bArr2[0] && f2850a[1] == bArr2[1] && (byte) 1 == bArr2[2] && (byte) 2 == bArr2[3]) {
                return C1058a.m3076b(C1075a.m3121d(Arrays.copyOfRange(bArr, 4, bArr.length)));
            }
            throw new C1074b("S2SS Package Magic/Version FormatError", null);
        } catch (Throwable e) {
            throw new C1074b("Exception while packaging byte array", e);
        }
    }

    /* renamed from: c */
    private static byte[] m3120c(byte[] bArr) {
        try {
            return C1075a.m3116a().doFinal(bArr);
        } catch (Throwable e) {
            throw new C1073a("Exception While encrypt byte array", e);
        }
    }

    /* renamed from: d */
    private static byte[] m3121d(byte[] bArr) {
        try {
            return C1075a.m3118b().doFinal(bArr);
        } catch (Throwable e) {
            throw new C1073a("Exception While dencrypt byte array", e);
        }
    }
}
