package com.p070qq.p071e.comm.util;

import android.support.p015v4.media.TransportMediator;
import android.support.p015v4.view.InputDeviceCompat;
import android.util.Base64;
import java.security.MessageDigest;

/* renamed from: com.qq.e.comm.util.Md5Util */
public class Md5Util {
    /* renamed from: a */
    private static final String[] f2872a = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String byteArrayToHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : bArr) {
            int i2;
            if (i2 < 0) {
                i2 += 256;
            }
            stringBuffer.append(f2872a[i2 / 16] + f2872a[i2 % 16]);
        }
        return stringBuffer.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x003e A:{SYNTHETIC, Splitter: B:26:0x003e} */
    public static java.lang.String encode(java.io.File r6) {
        /*
        if (r6 != 0) goto L_0x0005;
    L_0x0002:
        r0 = "";
    L_0x0004:
        return r0;
    L_0x0005:
        r0 = 0;
        r1 = "MD5";
        r2 = java.security.MessageDigest.getInstance(r1);	 Catch:{ Exception -> 0x0048, all -> 0x0038 }
        r1 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0048, all -> 0x0038 }
        r1.<init>(r6);	 Catch:{ Exception -> 0x0048, all -> 0x0038 }
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r0];	 Catch:{ Exception -> 0x0020, all -> 0x0046 }
    L_0x0015:
        r3 = r1.read(r0);	 Catch:{ Exception -> 0x0020, all -> 0x0046 }
        if (r3 <= 0) goto L_0x002a;
    L_0x001b:
        r4 = 0;
        r2.update(r0, r4, r3);	 Catch:{ Exception -> 0x0020, all -> 0x0046 }
        goto L_0x0015;
    L_0x0020:
        r0 = move-exception;
        r0 = r1;
    L_0x0022:
        if (r0 == 0) goto L_0x0027;
    L_0x0024:
        r0.close();	 Catch:{ Exception -> 0x0042 }
    L_0x0027:
        r0 = "";
        goto L_0x0004;
    L_0x002a:
        r0 = r2.digest();	 Catch:{ Exception -> 0x0020, all -> 0x0046 }
        r0 = com.p070qq.p071e.comm.util.Md5Util.byteArrayToHexString(r0);	 Catch:{ Exception -> 0x0020, all -> 0x0046 }
        r1.close();	 Catch:{ Exception -> 0x0036 }
        goto L_0x0004;
    L_0x0036:
        r1 = move-exception;
        goto L_0x0004;
    L_0x0038:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
    L_0x003c:
        if (r1 == 0) goto L_0x0041;
    L_0x003e:
        r1.close();	 Catch:{ Exception -> 0x0044 }
    L_0x0041:
        throw r0;
    L_0x0042:
        r0 = move-exception;
        goto L_0x0027;
    L_0x0044:
        r1 = move-exception;
        goto L_0x0041;
    L_0x0046:
        r0 = move-exception;
        goto L_0x003c;
    L_0x0048:
        r1 = move-exception;
        goto L_0x0022;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.util.Md5Util.encode(java.io.File):java.lang.String");
    }

    public static String encode(String str) {
        try {
            String str2 = new String(str);
            try {
                return Md5Util.byteArrayToHexString(MessageDigest.getInstance("MD5").digest(str2.getBytes()));
            } catch (Exception e) {
                return str2;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    public static String encodeBase64String(String str) {
        try {
            return Md5Util.byteArrayToHexString(MessageDigest.getInstance("MD5").digest(Base64.decode(str, 0)));
        } catch (Throwable e) {
            GDTLogger.m3132e("Exception while md5 base64String", e);
            return null;
        }
    }

    public static byte[] hexStringtoByteArray(String str) {
        if (str.length() % 2 != 0) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length() - 1; i += 2) {
            char charAt = str.charAt(i);
            char charAt2 = str.charAt(i + 1);
            charAt = Character.toLowerCase(charAt);
            charAt2 = Character.toLowerCase(charAt2);
            int i2 = (charAt <= '9' ? charAt - 48 : (charAt - 97) + 10) << 4;
            i2 = charAt2 <= '9' ? i2 + (charAt2 - 48) : i2 + ((charAt2 - 97) + 10);
            if (i2 > TransportMediator.KEYCODE_MEDIA_PAUSE) {
                i2 += InputDeviceCompat.SOURCE_ANY;
            }
            bArr[i / 2] = (byte) i2;
        }
        return bArr;
    }
}
