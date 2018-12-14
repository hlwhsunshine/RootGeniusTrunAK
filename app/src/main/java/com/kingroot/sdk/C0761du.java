package com.kingroot.sdk;

import android.content.Context;
import com.kingroot.sdk.util.C0893l;
import com.kingroot.sdk.util.Cryptor;
import java.io.File;

/* renamed from: com.kingroot.sdk.du */
public class C0761du {
    /* renamed from: a */
    public static int m1885a(Context context, File file) {
        return C0761du.m1886a(context, file, 14);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0076  */
    /* renamed from: a */
    private static int m1886a(android.content.Context r6, java.io.File r7, int r8) {
        /*
        r2 = 0;
        r0 = r7.getAbsolutePath();	 Catch:{ Exception -> 0x0050, all -> 0x0073 }
        r0 = com.kingroot.sdk.util.C0884d.m2411W(r0);	 Catch:{ Exception -> 0x0050, all -> 0x0073 }
        r1 = r7.getAbsolutePath();	 Catch:{ Exception -> 0x0050, all -> 0x0073 }
        r3 = r7.getAbsolutePath();	 Catch:{ Exception -> 0x0050, all -> 0x0073 }
        r4 = java.io.File.separator;	 Catch:{ Exception -> 0x0050, all -> 0x0073 }
        r3 = r3.lastIndexOf(r4);	 Catch:{ Exception -> 0x0050, all -> 0x0073 }
        r3 = r3 + 1;
        r3 = r1.substring(r3);	 Catch:{ Exception -> 0x0050, all -> 0x0073 }
        r1 = new java.io.File;	 Catch:{ Exception -> 0x0050, all -> 0x0073 }
        r4 = r6.getCacheDir();	 Catch:{ Exception -> 0x0050, all -> 0x0073 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0050, all -> 0x0073 }
        r5.<init>();	 Catch:{ Exception -> 0x0050, all -> 0x0073 }
        r3 = r5.append(r3);	 Catch:{ Exception -> 0x0050, all -> 0x0073 }
        r5 = "___";
        r3 = r3.append(r5);	 Catch:{ Exception -> 0x0050, all -> 0x0073 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0050, all -> 0x0073 }
        r1.<init>(r4, r3);	 Catch:{ Exception -> 0x0050, all -> 0x0073 }
        r2 = r1.getAbsolutePath();	 Catch:{ Exception -> 0x007d }
        com.kingroot.sdk.util.C0883c.m2400b(r0, r2);	 Catch:{ Exception -> 0x007d }
        r0 = r1.getAbsolutePath();	 Catch:{ Exception -> 0x007d }
        r0 = com.kingroot.sdk.util.C0883c.m2387W(r0);	 Catch:{ Exception -> 0x007d }
        com.kingroot.sdk.util.C0883c.m2406h(r1);
        r0 = com.kingroot.sdk.C0761du.m1887a(r6, r0, r8);
    L_0x004f:
        return r0;
    L_0x0050:
        r0 = move-exception;
        r1 = r2;
    L_0x0052:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x007a }
        r3 = "decode file error:";
        r2.<init>(r3);	 Catch:{ all -> 0x007a }
        r3 = r0.getMessage();	 Catch:{ all -> 0x007a }
        r2 = r2.append(r3);	 Catch:{ all -> 0x007a }
        r2 = r2.toString();	 Catch:{ all -> 0x007a }
        com.kingroot.sdk.C0633at.m1463g(r2);	 Catch:{ all -> 0x007a }
        r0.printStackTrace();	 Catch:{ all -> 0x007a }
        if (r1 == 0) goto L_0x0070;
    L_0x006d:
        com.kingroot.sdk.util.C0883c.m2406h(r1);
    L_0x0070:
        r0 = -7000; // 0xffffffffffffe4a8 float:NaN double:NaN;
        goto L_0x004f;
    L_0x0073:
        r0 = move-exception;
    L_0x0074:
        if (r2 == 0) goto L_0x0079;
    L_0x0076:
        com.kingroot.sdk.util.C0883c.m2406h(r2);
    L_0x0079:
        throw r0;
    L_0x007a:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0074;
    L_0x007d:
        r0 = move-exception;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.du.a(android.content.Context, java.io.File, int):int");
    }

    /* renamed from: a */
    private static int m1887a(Context context, byte[] bArr, int i) {
        C0769dy.m1908V(context);
        C0781ei c0781ei = new C0781ei();
        c0781ei.f1913hv = "1";
        c0781ei.f1912ha = C0618aj.m1394o(44);
        c0781ei.f1911gQ = C0893l.m2440M(context);
        c0781ei.f1910gL = i;
        C0782ej c0782ej = new C0782ej();
        c0782ej.f1916hw = c0781ei;
        c0782ej.f1917hx = bArr;
        byte[] c = Cryptor.m2365c(context, c0782ej.toByteArray());
        C0762dv u = C0762dv.m1894u(context, C0627aq.f1566bT);
        u.setRequestMethod("POST");
        u.mo5785k(c);
        u.mo5774bu();
        C0633at.m1463g("request Host=" + C0627aq.f1566bT + ", ContentLength=" + c.length);
        C0633at.m1463g("reponseCode=" + u.getResponseCode() + ", contentLength=" + u.getContentLength() + ", contentType=" + u.getContentType());
        return u.getResponseCode() == 200 ? 0 : -4000;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* renamed from: a */
    private static int m1888a(android.content.Context r4, byte[] r5, java.lang.String r6, int r7) {
        /*
        r2 = 0;
        r1 = new java.io.File;	 Catch:{ Exception -> 0x0021, all -> 0x0044 }
        r0 = r4.getCacheDir();	 Catch:{ Exception -> 0x0021, all -> 0x0044 }
        r1.<init>(r0, r6);	 Catch:{ Exception -> 0x0021, all -> 0x0044 }
        r0 = r1.getAbsolutePath();	 Catch:{ Exception -> 0x004e }
        com.kingroot.sdk.util.C0883c.m2400b(r5, r0);	 Catch:{ Exception -> 0x004e }
        r0 = r1.getAbsolutePath();	 Catch:{ Exception -> 0x004e }
        r0 = com.kingroot.sdk.util.C0883c.m2387W(r0);	 Catch:{ Exception -> 0x004e }
        com.kingroot.sdk.util.C0883c.m2406h(r1);
        r0 = com.kingroot.sdk.C0761du.m1887a(r4, r0, r7);
    L_0x0020:
        return r0;
    L_0x0021:
        r0 = move-exception;
        r1 = r2;
    L_0x0023:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x004c }
        r3 = "decode file error:";
        r2.<init>(r3);	 Catch:{ all -> 0x004c }
        r3 = r0.getMessage();	 Catch:{ all -> 0x004c }
        r2 = r2.append(r3);	 Catch:{ all -> 0x004c }
        r2 = r2.toString();	 Catch:{ all -> 0x004c }
        com.kingroot.sdk.C0633at.m1463g(r2);	 Catch:{ all -> 0x004c }
        r0.printStackTrace();	 Catch:{ all -> 0x004c }
        if (r1 == 0) goto L_0x0041;
    L_0x003e:
        com.kingroot.sdk.util.C0883c.m2406h(r1);
    L_0x0041:
        r0 = -7000; // 0xffffffffffffe4a8 float:NaN double:NaN;
        goto L_0x0020;
    L_0x0044:
        r0 = move-exception;
        r1 = r2;
    L_0x0046:
        if (r1 == 0) goto L_0x004b;
    L_0x0048:
        com.kingroot.sdk.util.C0883c.m2406h(r1);
    L_0x004b:
        throw r0;
    L_0x004c:
        r0 = move-exception;
        goto L_0x0046;
    L_0x004e:
        r0 = move-exception;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.du.a(android.content.Context, byte[], java.lang.String, int):int");
    }

    /* renamed from: f */
    public static int m1889f(Context context, byte[] bArr) {
        return C0761du.m1888a(context, bArr, "rnsll__", 13);
    }
}
