package com.kingroot.sdk;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.kingroot.sdk.gc */
public class C0839gc {
    /* renamed from: jB */
    public int f2096jB;
    /* renamed from: jC */
    public byte[] f2097jC;
    public int mVersion;

    /* renamed from: d */
    public static C0839gc m2165d(InputStream inputStream) {
        C0839gc c0839gc = new C0839gc();
        try {
            byte[] bArr = new byte[4];
            inputStream.read(bArr);
            c0839gc.mVersion = C0838gb.m2164l(bArr);
            inputStream.read(bArr);
            c0839gc.f2096jB = C0838gb.m2164l(bArr);
            bArr = new byte[16];
            inputStream.read(bArr);
            c0839gc.f2097jC = bArr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return c0839gc;
    }
}
