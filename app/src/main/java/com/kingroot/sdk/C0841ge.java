package com.kingroot.sdk;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.CRC32;

/* renamed from: com.kingroot.sdk.ge */
public final class C0841ge {
    /* renamed from: W */
    public static byte[] m2178W(String str) {
        FileInputStream fileInputStream = new FileInputStream(str);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(fileInputStream.available());
        byte[] bArr = new byte[1024];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read < 0) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        bArr = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        fileInputStream.close();
        return bArr != null ? bArr : "".getBytes();
    }

    /* renamed from: a */
    public static void m2179a(byte[] bArr, String str) {
        FileOutputStream fileOutputStream = new FileOutputStream(str, false);
        fileOutputStream.write(bArr);
        fileOutputStream.close();
    }

    /* renamed from: c */
    public static String m2180c(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            stringBuilder.append("0123456789abcdef".charAt((b >> 4) & 15)).append("0123456789abcdef".charAt(b & 15));
        }
        return stringBuilder.toString();
    }

    /* renamed from: f */
    public static long m2181f(File file) {
        Throwable th;
        long j = 0;
        FileInputStream fileInputStream;
        try {
            CRC32 crc32 = new CRC32();
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        j = crc32.getValue();
                        try {
                            fileInputStream.close();
                            break;
                        } catch (IOException e) {
                        }
                    } else {
                        crc32.update(bArr, 0, read);
                    }
                }
            } catch (Exception e2) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                }
            }
            return j;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x003a A:{SYNTHETIC, Splitter: B:26:0x003a} */
    /* renamed from: g */
    public static java.lang.String m2182g(java.io.File r6) {
        /*
        r0 = "";
        r3 = 0;
        r1 = "MD5";
        r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ Exception -> 0x0044, all -> 0x0036 }
        r2 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0044, all -> 0x0036 }
        r2.<init>(r6);	 Catch:{ Exception -> 0x0044, all -> 0x0036 }
        r3 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r3 = new byte[r3];	 Catch:{ Exception -> 0x002a }
    L_0x0012:
        r4 = r2.read(r3);	 Catch:{ Exception -> 0x002a }
        r5 = -1;
        if (r4 != r5) goto L_0x0025;
    L_0x0019:
        r1 = r1.digest();	 Catch:{ Exception -> 0x002a }
        r0 = com.kingroot.sdk.C0841ge.m2180c(r1);	 Catch:{ Exception -> 0x002a }
        r2.close();	 Catch:{ IOException -> 0x0040 }
    L_0x0024:
        return r0;
    L_0x0025:
        r5 = 0;
        r1.update(r3, r5, r4);	 Catch:{ Exception -> 0x002a }
        goto L_0x0012;
    L_0x002a:
        r1 = move-exception;
    L_0x002b:
        r1.printStackTrace();	 Catch:{ all -> 0x0042 }
        if (r2 == 0) goto L_0x0024;
    L_0x0030:
        r2.close();	 Catch:{ IOException -> 0x0034 }
        goto L_0x0024;
    L_0x0034:
        r1 = move-exception;
        goto L_0x0024;
    L_0x0036:
        r0 = move-exception;
        r2 = r3;
    L_0x0038:
        if (r2 == 0) goto L_0x003d;
    L_0x003a:
        r2.close();	 Catch:{ IOException -> 0x003e }
    L_0x003d:
        throw r0;
    L_0x003e:
        r1 = move-exception;
        goto L_0x003d;
    L_0x0040:
        r1 = move-exception;
        goto L_0x0024;
    L_0x0042:
        r0 = move-exception;
        goto L_0x0038;
    L_0x0044:
        r1 = move-exception;
        r2 = r3;
        goto L_0x002b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.ge.g(java.io.File):java.lang.String");
    }

    /* renamed from: k */
    public static boolean m2183k(File file) {
        if (file != null) {
            return !file.getCanonicalFile().equals(file.getAbsoluteFile());
        } else {
            throw new NullPointerException("File must not be null");
        }
    }
}
