package com.shuame.mobile.sdk.impl.utils;

/* renamed from: com.shuame.mobile.sdk.impl.utils.f */
public final class C1227f {
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0061 A:{SYNTHETIC, Splitter: B:47:0x0061} */
    /* renamed from: a */
    public static java.lang.String m3456a(java.io.File r6) {
        /*
        r0 = 0;
        r1 = "MD5";
        r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0070, FileNotFoundException -> 0x003c, IOException -> 0x004c, all -> 0x005c }
        r2 = new java.io.FileInputStream;	 Catch:{ NoSuchAlgorithmException -> 0x0070, FileNotFoundException -> 0x003c, IOException -> 0x004c, all -> 0x005c }
        r2.<init>(r6);	 Catch:{ NoSuchAlgorithmException -> 0x0070, FileNotFoundException -> 0x003c, IOException -> 0x004c, all -> 0x005c }
        r3 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r3 = new byte[r3];	 Catch:{ NoSuchAlgorithmException -> 0x0028, FileNotFoundException -> 0x006e, IOException -> 0x006c }
    L_0x0010:
        r4 = r2.read(r3);	 Catch:{ NoSuchAlgorithmException -> 0x0028, FileNotFoundException -> 0x006e, IOException -> 0x006c }
        r5 = -1;
        if (r4 != r5) goto L_0x0023;
    L_0x0017:
        r1 = r1.digest();	 Catch:{ NoSuchAlgorithmException -> 0x0028, FileNotFoundException -> 0x006e, IOException -> 0x006c }
        r0 = com.shuame.mobile.sdk.impl.utils.C1227f.m3457a(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0028, FileNotFoundException -> 0x006e, IOException -> 0x006c }
        r2.close();	 Catch:{ IOException -> 0x0037 }
    L_0x0022:
        return r0;
    L_0x0023:
        r5 = 0;
        r1.update(r3, r5, r4);	 Catch:{ NoSuchAlgorithmException -> 0x0028, FileNotFoundException -> 0x006e, IOException -> 0x006c }
        goto L_0x0010;
    L_0x0028:
        r1 = move-exception;
    L_0x0029:
        r1.printStackTrace();	 Catch:{ all -> 0x006a }
        if (r2 == 0) goto L_0x0022;
    L_0x002e:
        r2.close();	 Catch:{ IOException -> 0x0032 }
        goto L_0x0022;
    L_0x0032:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0022;
    L_0x0037:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0022;
    L_0x003c:
        r1 = move-exception;
        r2 = r0;
    L_0x003e:
        r1.printStackTrace();	 Catch:{ all -> 0x006a }
        if (r2 == 0) goto L_0x0022;
    L_0x0043:
        r2.close();	 Catch:{ IOException -> 0x0047 }
        goto L_0x0022;
    L_0x0047:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0022;
    L_0x004c:
        r1 = move-exception;
        r2 = r0;
    L_0x004e:
        r1.printStackTrace();	 Catch:{ all -> 0x006a }
        if (r2 == 0) goto L_0x0022;
    L_0x0053:
        r2.close();	 Catch:{ IOException -> 0x0057 }
        goto L_0x0022;
    L_0x0057:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0022;
    L_0x005c:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x005f:
        if (r2 == 0) goto L_0x0064;
    L_0x0061:
        r2.close();	 Catch:{ IOException -> 0x0065 }
    L_0x0064:
        throw r0;
    L_0x0065:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0064;
    L_0x006a:
        r0 = move-exception;
        goto L_0x005f;
    L_0x006c:
        r1 = move-exception;
        goto L_0x004e;
    L_0x006e:
        r1 = move-exception;
        goto L_0x003e;
    L_0x0070:
        r1 = move-exception;
        r2 = r0;
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.mobile.sdk.impl.utils.f.a(java.io.File):java.lang.String");
    }

    /* renamed from: a */
    public static String m3457a(byte[] bArr) {
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            cArr2[i * 2] = cArr[(b >>> 4) & 15];
            cArr2[(i * 2) + 1] = cArr[b & 15];
        }
        return new String(cArr2);
    }
}
