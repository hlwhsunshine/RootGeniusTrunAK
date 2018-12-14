package com.kingroot.sdk;

import android.os.Build;
import android.text.TextUtils;
import com.kingroot.sdk.util.C0883c;
import com.kingroot.sdk.util.C0885e;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

/* renamed from: com.kingroot.sdk.ar */
public class C0628ar {
    /* renamed from: bX */
    private static String f1570bX = C0628ar.m1448C();
    /* renamed from: bY */
    private static String f1571bY = C0628ar.m1449D();

    /* renamed from: C */
    private static String m1448C() {
        String str = Build.FINGERPRINT;
        C0633at.m1464h("fingerprint = " + str);
        if (!TextUtils.isEmpty(str) && !"unknown".equalsIgnoreCase(str)) {
            return str;
        }
        str = C0628ar.m1453q("ro.build.description");
        C0633at.m1464h("description = " + str);
        return str;
    }

    /* renamed from: D */
    private static String m1449D() {
        String Y = C0883c.m2389Y("/proc/version");
        if (Y == null) {
            return "";
        }
        C0633at.m1464h("linuxVersion = " + Y);
        return Y.trim();
    }

    /* renamed from: E */
    public static String m1450E() {
        C0633at.m1464h("sFingerprint = " + f1570bX);
        return f1570bX;
    }

    /* renamed from: F */
    public static String m1451F() {
        return f1571bY;
    }

    /* renamed from: G */
    public static String m1452G() {
        Process start;
        Closeable inputStream;
        Closeable byteArrayOutputStream;
        Exception e;
        Throwable th;
        Closeable closeable = null;
        C0633at.m1464h("getPrevSuVersion() end");
        String str = "";
        String str2 = "/system/bin/su";
        if (!new File(str2).exists()) {
            str2 = "/system/xbin/su";
            if (!new File(str2).exists()) {
                C0633at.m1464h("getPrevSuVersion() end notExists");
                return str;
            }
        }
        try {
            start = new ProcessBuilder(new String[0]).command(new String[]{str2, "-v"}).redirectErrorStream(true).start();
        } catch (IOException e2) {
            e2.printStackTrace();
            start = null;
        }
        if (start != null) {
            try {
                inputStream = start.getInputStream();
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception e3) {
                    e = e3;
                    byteArrayOutputStream = null;
                    closeable = inputStream;
                    try {
                        e.printStackTrace();
                        try {
                            start.destroy();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                        C0885e.m2419a(byteArrayOutputStream);
                        C0885e.m2419a(closeable);
                        str2 = str;
                        str = str2.trim();
                        C0633at.m1464h("getPrevSuVersion() end");
                        return str;
                    } catch (Throwable th3) {
                        th2 = th3;
                        inputStream = closeable;
                        try {
                            start.destroy();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                        C0885e.m2419a(byteArrayOutputStream);
                        C0885e.m2419a(inputStream);
                        throw th2;
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    byteArrayOutputStream = null;
                    start.destroy();
                    C0885e.m2419a(byteArrayOutputStream);
                    C0885e.m2419a(inputStream);
                    throw th2;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    str2 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    try {
                        start.destroy();
                    } catch (Throwable th42) {
                        th42.printStackTrace();
                    }
                    C0885e.m2419a(byteArrayOutputStream);
                    C0885e.m2419a(inputStream);
                } catch (Exception e4) {
                    e = e4;
                    closeable = inputStream;
                    e.printStackTrace();
                    start.destroy();
                    C0885e.m2419a(byteArrayOutputStream);
                    C0885e.m2419a(closeable);
                    str2 = str;
                    str = str2.trim();
                    C0633at.m1464h("getPrevSuVersion() end");
                    return str;
                } catch (Throwable th6) {
                    th2 = th6;
                    start.destroy();
                    C0885e.m2419a(byteArrayOutputStream);
                    C0885e.m2419a(inputStream);
                    throw th2;
                }
            } catch (Exception e5) {
                e = e5;
                byteArrayOutputStream = null;
            } catch (Throwable th7) {
                th2 = th7;
                byteArrayOutputStream = null;
                inputStream = null;
                start.destroy();
                C0885e.m2419a(byteArrayOutputStream);
                C0885e.m2419a(inputStream);
                throw th2;
            }
        }
        str2 = str;
        str = str2.trim();
        C0633at.m1464h("getPrevSuVersion() end");
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* renamed from: q */
    public static java.lang.String m1453q(java.lang.String r4) {
        /*
        r2 = 0;
        r1 = new com.kingroot.sdk.av;	 Catch:{ Exception -> 0x0034, all -> 0x003f }
        r0 = "sh";
        r1.<init>(r0);	 Catch:{ Exception -> 0x0034, all -> 0x003f }
        r0 = "export PATH=/sbin:/vendor/bin:/system/sbin:/system/bin:/system/xbin:$PATH";
        r1.mo5609t(r0);	 Catch:{ Exception -> 0x0049 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0049 }
        r2 = "getprop ";
        r0.<init>(r2);	 Catch:{ Exception -> 0x0049 }
        r0 = r0.append(r4);	 Catch:{ Exception -> 0x0049 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0049 }
        r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0 = r1.mo5606b(r0, r2);	 Catch:{ Exception -> 0x0049 }
        r0 = r0.f1585cs;	 Catch:{ Exception -> 0x0049 }
        if (r0 == 0) goto L_0x002e;
    L_0x0026:
        r0 = r0.trim();	 Catch:{ Exception -> 0x0049 }
        r1.shutdown();
    L_0x002d:
        return r0;
    L_0x002e:
        r1.shutdown();
    L_0x0031:
        r0 = "";
        goto L_0x002d;
    L_0x0034:
        r0 = move-exception;
        r1 = r2;
    L_0x0036:
        r0.printStackTrace();	 Catch:{ all -> 0x0047 }
        if (r1 == 0) goto L_0x0031;
    L_0x003b:
        r1.shutdown();
        goto L_0x0031;
    L_0x003f:
        r0 = move-exception;
        r1 = r2;
    L_0x0041:
        if (r1 == 0) goto L_0x0046;
    L_0x0043:
        r1.shutdown();
    L_0x0046:
        throw r0;
    L_0x0047:
        r0 = move-exception;
        goto L_0x0041;
    L_0x0049:
        r0 = move-exception;
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.ar.q(java.lang.String):java.lang.String");
    }
}
