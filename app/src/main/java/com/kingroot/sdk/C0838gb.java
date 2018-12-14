package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.gb */
public class C0838gb {
    /* renamed from: l */
    public static int m2164l(byte[] bArr) {
        return bArr.length != 4 ? 0 : (((bArr[0] & 255) | ((bArr[1] & 255) << 8)) | ((bArr[2] & 255) << 16)) | ((bArr[3] & 255) << 24);
    }
}
