package com.kingroot.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kingroot.sdk.util.C0885e;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import krsdk.C1774c;

/* renamed from: com.kingroot.sdk.dy */
public final class C0769dy {
    /* renamed from: gF */
    private static C0768a[] f1869gF = new C0768a[]{new C0768a(0, "info|getUpdatesV2"), new C0768a(1, "conf|getConfigV2"), new C0768a(2, "kinguser|getSoftStatus"), new C0768a(3, "kinguser|reportSoftStatus"), new C0768a(4, "info|reportSoftList"), new C0768a(5, "kinguser|reportMsg"), new C0768a(6, "tipsmain|getMainTips"), new C0768a(7, "softupdate|getSoftUpdateTips"), new C0768a(8, "conf|getConfigTips"), new C0768a(9, "cmdactivity|getActivityTips"), new C0768a(10, "info|reportTipsRes"), new C0768a(11, "info|reportChannelInfo"), new C0768a(12, "report|reportSoftUsageInfo"), new C0768a(13, "info|getGuid"), new C0768a(14, "kinguserreport|reportKUStatus"), new C0768a(15, "kingrootsolution|getSolutions"), new C0768a(16, "kingrootreport|reportKingRootResult"), new C0768a(17, "KingUserIssue|getKingUserUrl"), new C0768a(18, "checkCanTmpRoot|checkCanTmpRoot"), new C0768a(19, "rootCheck|reqRootRes")};

    /* renamed from: com.kingroot.sdk.dy$a */
    static class C0768a {
        /* renamed from: gH */
        int f1866gH;
        /* renamed from: gI */
        String f1867gI;
        /* renamed from: gJ */
        String f1868gJ;

        public C0768a(int i, String str) {
            this.f1866gH = i;
            int indexOf = str.indexOf("|");
            this.f1867gI = str.substring(0, indexOf);
            this.f1868gJ = str.substring(indexOf + 1, str.length());
        }
    }

    /* renamed from: D */
    public static C1774c m1906D(Context context) {
        C1774c c1774c = new C1774c();
        C0856gq c0856gq = new C0856gq(true);
        C0856gq c0856gq2 = new C0856gq(true);
        C0791es k = C0625ao.m1434k(context);
        C0775ed n = C0625ao.m1437n(context);
        C0633at.m1464h("WupSession.getSolutions()上报设备信息deviceInfoXml : " + n.f1891hb);
        C0769dy.m1917a(15, c0856gq, c0856gq2);
        c0856gq.put("userinfo", k);
        c0856gq.put("req", n);
        c0856gq.put("phonetype", C0769dy.m1932n());
        int a = C0769dy.m1913a(context, c0856gq, c0856gq2, false, true);
        if (a != 0) {
            C0633at.m1465i("WupSession.getSolutions()上报出错  err : " + a);
            c1774c.f5199kA = a;
            return c1774c;
        }
        Object a2 = c0856gq2.mo5862a("resp", (Object) new C0776ee());
        if (a2 != null) {
            C0776ee c0776ee = (C0776ee) a2;
            C0625ao.m1433a(c0776ee.f1897hf);
            C0739de.m1795a(context, "session_id", c0776ee.f1897hf);
            try {
                c1774c.f5200kB = C0623am.m1422e(c0776ee.f1898hg);
            } catch (Exception e) {
                e.printStackTrace();
            }
            c1774c.f5198hi = c0776ee.f1900hi;
            c1774c.f5197hh = c0776ee.f1899hh;
        }
        return c1774c;
    }

    /* renamed from: U */
    public static int m1907U(Context context) {
        C0856gq c0856gq = new C0856gq(true);
        C0856gq c0856gq2 = new C0856gq(true);
        C0769dy.m1917a(11, c0856gq, c0856gq2);
        C0791es k = C0625ao.m1434k(context);
        C0770dz x = C0625ao.m1442x();
        C0633at.m1464h(String.format("渠道信息上报： channelId = %s, version = %d, isbuildin = %d, isroot = %d, buildno = %d, guid = %s", new Object[]{x.f1871gK, Integer.valueOf(k.f2004iv.f1918ab), Integer.valueOf(x.f1873gM), Integer.valueOf(k.f2005iw), Integer.valueOf(k.f1987aA), k.f1998ha}));
        c0856gq.put("phonetype", C0769dy.m1932n());
        c0856gq.put("userinfo", C0625ao.m1434k(context));
        c0856gq.put("channelinfo", C0625ao.m1442x());
        int b = C0769dy.m1919b(context, c0856gq, c0856gq2, false);
        return b != 0 ? b : 0;
    }

    /* JADX WARNING: Missing block: B:6:0x0011, code:
            if (r0 != 0) goto L_0x0013;
     */
    /* renamed from: V */
    static synchronized int m1908V(android.content.Context r2) {
        /*
        r1 = com.kingroot.sdk.C0769dy.class;
        monitor-enter(r1);
        r0 = com.kingroot.sdk.C0624an.m1430v();	 Catch:{ all -> 0x0017 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x0017 }
        if (r0 == 0) goto L_0x0015;
    L_0x000d:
        r0 = com.kingroot.sdk.C0769dy.m1909W(r2);	 Catch:{ all -> 0x0017 }
        if (r0 == 0) goto L_0x0015;
    L_0x0013:
        monitor-exit(r1);
        return r0;
    L_0x0015:
        r0 = 0;
        goto L_0x0013;
    L_0x0017:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.dy.V(android.content.Context):int");
    }

    /* renamed from: W */
    private static int m1909W(Context context) {
        C0772ea m = C0625ao.m1436m(context);
        AtomicReference atomicReference = new AtomicReference();
        int a = C0769dy.m1912a(context, m, atomicReference);
        if (a == 0) {
            C0774ec c0774ec = (C0774ec) atomicReference.get();
            if (c0774ec != null) {
                Object obj = c0774ec.f1889ha;
                if (TextUtils.isEmpty(obj)) {
                    return -2001;
                }
                C0624an.m1427n(obj);
            }
        }
        return a;
    }

    /* renamed from: X */
    private static C0875q m1910X(Context context) {
        C0875q c0875q = new C0875q();
        c0875q.mo5943b(C0646bc.m1512S());
        c0875q.mo5942a(new C0902w(context.getPackageName()));
        return c0875q;
    }

    /* renamed from: a */
    public static int m1911a(Context context, C0643b c0643b, AtomicReference<C0598a> atomicReference) {
        C0856gq c0856gq = new C0856gq(true);
        C0856gq c0856gq2 = new C0856gq(true);
        C0769dy.m1917a(9, c0856gq, c0856gq2);
        c0856gq.put("phonetype", C0769dy.m1932n());
        c0856gq.put("userinfo", C0625ao.m1434k(context));
        c0856gq.put("reqinfo", c0643b);
        int b = C0769dy.m1919b(context, c0856gq, c0856gq2, false);
        if (b != 0) {
            return b;
        }
        Object a = c0856gq2.mo5862a("cmdinfo", (Object) new C0598a());
        if (a != null) {
            atomicReference.set((C0598a) a);
        }
        return 0;
    }

    /* renamed from: a */
    public static int m1912a(Context context, C0772ea c0772ea, AtomicReference<C0774ec> atomicReference) {
        C0856gq c0856gq = new C0856gq(true);
        C0856gq c0856gq2 = new C0856gq(true);
        C0769dy.m1917a(13, c0856gq, c0856gq2);
        c0856gq.put("phonetype", C0769dy.m1932n());
        c0856gq.put("userinfo", C0625ao.m1434k(context));
        c0856gq.put("deviceinfo", c0772ea);
        int a = C0769dy.m1913a(context, c0856gq, c0856gq2, false, true);
        if (a != 0) {
            return a;
        }
        Object a2 = c0856gq2.mo5862a("guidinfo", (Object) new C0774ec());
        if (a2 != null) {
            atomicReference.set((C0774ec) a2);
        }
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d8  */
    /* renamed from: a */
    private static int m1913a(android.content.Context r6, com.kingroot.sdk.C0856gq r7, com.kingroot.sdk.C0856gq r8, boolean r9, boolean r10) {
        /*
        r1 = -6000; // 0xffffffffffffe890 float:NaN double:NaN;
        if (r10 != 0) goto L_0x0007;
    L_0x0004:
        com.kingroot.sdk.C0769dy.m1908V(r6);
    L_0x0007:
        r2 = 0;
        r0 = r7.mo5859ck();	 Catch:{ IllegalArgumentException -> 0x00a3, Exception -> 0x00b2, Throwable -> 0x00c3, all -> 0x00d4 }
        r0 = com.kingroot.sdk.util.Cryptor.m2363b(r6, r0);	 Catch:{ IllegalArgumentException -> 0x00a3, Exception -> 0x00b2, Throwable -> 0x00c3, all -> 0x00d4 }
        r3 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x00a3, Exception -> 0x00b2, Throwable -> 0x00c3, all -> 0x00d4 }
        r4 = "HOST_URL = ";
        r3.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x00a3, Exception -> 0x00b2, Throwable -> 0x00c3, all -> 0x00d4 }
        r4 = com.kingroot.sdk.C0627aq.f1565bS;	 Catch:{ IllegalArgumentException -> 0x00a3, Exception -> 0x00b2, Throwable -> 0x00c3, all -> 0x00d4 }
        r3 = r3.append(r4);	 Catch:{ IllegalArgumentException -> 0x00a3, Exception -> 0x00b2, Throwable -> 0x00c3, all -> 0x00d4 }
        r3 = r3.toString();	 Catch:{ IllegalArgumentException -> 0x00a3, Exception -> 0x00b2, Throwable -> 0x00c3, all -> 0x00d4 }
        com.kingroot.sdk.C0633at.m1464h(r3);	 Catch:{ IllegalArgumentException -> 0x00a3, Exception -> 0x00b2, Throwable -> 0x00c3, all -> 0x00d4 }
        r3 = com.kingroot.sdk.C0627aq.f1565bS;	 Catch:{ IllegalArgumentException -> 0x00a3, Exception -> 0x00b2, Throwable -> 0x00c3, all -> 0x00d4 }
        r3 = com.kingroot.sdk.C0762dv.m1894u(r6, r3);	 Catch:{ IllegalArgumentException -> 0x00a3, Exception -> 0x00b2, Throwable -> 0x00c3, all -> 0x00d4 }
        r2 = "POST";
        r3.setRequestMethod(r2);	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        r3.mo5785k(r0);	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        r3.mo5774bu();	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        r0 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        r2 = "WupSession.reponseCode = ";
        r0.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        r2 = r3.getResponseCode();	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        r0 = r0.append(r2);	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        r2 = ", contentLength = ";
        r0 = r0.append(r2);	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        r4 = r3.getContentLength();	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        r0 = r0.append(r4);	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        r2 = ", contentType = ";
        r0 = r0.append(r2);	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        r2 = r3.getContentType();	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        r0 = r0.append(r2);	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        r0 = r0.toString();	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        com.kingroot.sdk.C0633at.m1464h(r0);	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        r0 = new java.util.concurrent.atomic.AtomicReference;	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        r0.<init>();	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        r2 = 0;
        r2 = r3.mo5770a(r2, r0);	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        if (r2 == 0) goto L_0x007f;
    L_0x0073:
        r0 = "WupSession.httpConnection.getResponse(..)出错了！";
        com.kingroot.sdk.C0633at.m1465i(r0);	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        if (r3 == 0) goto L_0x007d;
    L_0x007a:
        r3.close();
    L_0x007d:
        r0 = r2;
    L_0x007e:
        return r0;
    L_0x007f:
        r0 = r0.get();	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        r0 = (byte[]) r0;	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        if (r9 != 0) goto L_0x00ea;
    L_0x0087:
        if (r0 == 0) goto L_0x00ea;
    L_0x0089:
        r4 = r0.length;	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        if (r4 <= 0) goto L_0x00ea;
    L_0x008c:
        r0 = com.kingroot.sdk.util.Cryptor.m2367d(r6, r0);	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        if (r0 == 0) goto L_0x009c;
    L_0x0092:
        r8.mo5860m(r0);	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        r0 = r2;
    L_0x0096:
        if (r3 == 0) goto L_0x007e;
    L_0x0098:
        r3.close();
        goto L_0x007e;
    L_0x009c:
        r0 = "WupSession.Cryptor.y(..)出错了！";
        com.kingroot.sdk.C0633at.m1465i(r0);	 Catch:{ IllegalArgumentException -> 0x00e5, Exception -> 0x00e3, Throwable -> 0x00e1 }
        r0 = r1;
        goto L_0x0096;
    L_0x00a3:
        r0 = move-exception;
        r1 = r2;
    L_0x00a5:
        r2 = "WupSession.IllegalArgumentException";
        com.kingroot.sdk.C0633at.m1458a(r2, r0);	 Catch:{ all -> 0x00de }
        r0 = -6057; // 0xffffffffffffe857 float:NaN double:NaN;
        if (r1 == 0) goto L_0x007e;
    L_0x00ae:
        r1.close();
        goto L_0x007e;
    L_0x00b2:
        r0 = move-exception;
        r3 = r2;
    L_0x00b4:
        r2 = "WupSession.Exception";
        com.kingroot.sdk.C0633at.m1458a(r2, r0);	 Catch:{ all -> 0x00dc }
        r0.printStackTrace();	 Catch:{ all -> 0x00dc }
        if (r3 == 0) goto L_0x00e8;
    L_0x00be:
        r3.close();
        r0 = r1;
        goto L_0x007e;
    L_0x00c3:
        r0 = move-exception;
        r3 = r2;
    L_0x00c5:
        r2 = "WupSession.Throwable";
        com.kingroot.sdk.C0633at.m1458a(r2, r0);	 Catch:{ all -> 0x00dc }
        r0.printStackTrace();	 Catch:{ all -> 0x00dc }
        if (r3 == 0) goto L_0x00e8;
    L_0x00cf:
        r3.close();
        r0 = r1;
        goto L_0x007e;
    L_0x00d4:
        r0 = move-exception;
        r3 = r2;
    L_0x00d6:
        if (r3 == 0) goto L_0x00db;
    L_0x00d8:
        r3.close();
    L_0x00db:
        throw r0;
    L_0x00dc:
        r0 = move-exception;
        goto L_0x00d6;
    L_0x00de:
        r0 = move-exception;
        r3 = r1;
        goto L_0x00d6;
    L_0x00e1:
        r0 = move-exception;
        goto L_0x00c5;
    L_0x00e3:
        r0 = move-exception;
        goto L_0x00b4;
    L_0x00e5:
        r0 = move-exception;
        r1 = r3;
        goto L_0x00a5;
    L_0x00e8:
        r0 = r1;
        goto L_0x007e;
    L_0x00ea:
        r0 = r2;
        goto L_0x0096;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.dy.a(android.content.Context, com.kingroot.sdk.gq, com.kingroot.sdk.gq, boolean, boolean):int");
    }

    /* renamed from: a */
    public static int m1914a(Context context, C0866h c0866h) {
        C0856gq c0856gq = new C0856gq(true);
        C0856gq c0856gq2 = new C0856gq(true);
        C0769dy.m1917a(10, c0856gq, c0856gq2);
        c0856gq.put("phonetype", C0769dy.m1932n());
        c0856gq.put("userinfo", C0625ao.m1434k(context));
        c0856gq.put("cmdinfores", c0866h);
        int b = C0769dy.m1919b(context, c0856gq, c0856gq2, false);
        return b != 0 ? b : 0;
    }

    /* renamed from: a */
    public static int m1915a(Context context, AtomicReference<C0878t> atomicReference) {
        C0856gq c0856gq = new C0856gq(true);
        C0856gq c0856gq2 = new C0856gq(true);
        C0769dy.m1917a(6, c0856gq, c0856gq2);
        c0856gq.put("phonetype", C0769dy.m1932n());
        c0856gq.put("userinfo", C0625ao.m1434k(context));
        c0856gq.put("reqinfo", C0769dy.m1910X(context));
        int b = C0769dy.m1919b(context, c0856gq, c0856gq2, false);
        if (b != 0) {
            return b;
        }
        C0878t c0878t = (C0878t) c0856gq2.mo5862a("cmdinfo", (Object) new C0878t());
        if (c0878t != null) {
            atomicReference.set(c0878t);
        }
        return 0;
    }

    /* renamed from: a */
    public static int m1916a(C0783ek c0783ek, int i, C0645bb c0645bb, Context context) {
        C0633at.m1464h("checkUpdate req buildno = " + i + ", version : " + c0783ek.f1918ab + "." + c0783ek.f1919ac + "." + c0783ek.f1920ad);
        C0856gq c0856gq = new C0856gq(true);
        C0856gq c0856gq2 = new C0856gq(true);
        C0791es k = C0625ao.m1434k(context);
        C0785em c0785em = new C0785em();
        c0785em.f1927hD = c0783ek;
        c0785em.f1928hE = i;
        C0769dy.m1917a(17, c0856gq, c0856gq2);
        c0856gq.put("userinfo", k);
        c0856gq.put("reqInfo", c0785em);
        int a = C0769dy.m1913a(context, c0856gq, c0856gq2, false, true);
        if (a != 0) {
            C0633at.m1465i("WupSession.getSolutions()上报出错  err : " + a);
            return a;
        }
        Object a2 = c0856gq2.mo5862a("respInfo", (Object) new C0786en());
        if (a2 != null) {
            C0786en c0786en = (C0786en) a2;
            C0633at.m1464h("checkUpdate resp : url = " + c0786en.f1934hG + ", buildno = " + c0786en.f1933hE + ",version = " + c0786en.f1932hD.f1918ab + "." + c0786en.f1932hD.f1919ac + "." + c0786en.f1932hD.f1920ad);
            c0645bb.f1631cS = c0786en.f1934hG;
            c0645bb.f1627cO = c0786en.f1933hE;
            c0645bb.f1628cP = c0786en.f1932hD.f1919ac;
            c0645bb.f1629cQ = c0786en.f1932hD.f1918ab;
            c0645bb.f1630cR = c0786en.f1932hD.f1920ad;
            c0645bb.f1632cT = c0786en.f1935hH;
            c0645bb.f1623O = c0786en.f1930O;
        } else {
            C0633at.m1464h("checkUpdate resp : tmpInfo == null");
        }
        return 0;
    }

    /* renamed from: a */
    private static void m1917a(int i, C0856gq c0856gq, C0856gq c0856gq2) {
        c0856gq.mo5858aq("UTF-8");
        c0856gq.mo5864J(i);
        c0856gq.mo5865ar(f1869gF[i].f1867gI);
        c0856gq.mo5866as(f1869gF[i].f1868gJ);
        c0856gq2.mo5858aq("UTF-8");
    }

    /* renamed from: a */
    public static boolean m1918a(Context context, C0626ap c0626ap, boolean z) {
        Throwable th;
        C0762dv c0762dv = null;
        C0633at.m1464h("WupSession.downloadSolutionFile()下载方案Jar, sid = " + c0626ap.f1556bK);
        File file = new File(c0626ap.f1563bR);
        try {
            C0762dv u = C0762dv.m1894u(context, c0626ap.f1553M);
            try {
                u.setRequestMethod("GET");
                u.mo5774bu();
                Closeable inputStream = u.getInputStream();
                byte[] bArr = new byte[1024];
                Closeable fileOutputStream;
                try {
                    fileOutputStream = new FileOutputStream(file);
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        } catch (Throwable th2) {
                            th = th2;
                            C0885e.m2419a(fileOutputStream);
                            C0885e.m2419a(inputStream);
                            throw th;
                        }
                    }
                    fileOutputStream.getChannel().force(true);
                    fileOutputStream.flush();
                    C0885e.m2419a(fileOutputStream);
                    C0885e.m2419a(inputStream);
                    if (u != null) {
                        u.close();
                    }
                    C0633at.m1464h("WupSession.downloadSolutionFile()下载方案Jar返回, sid = " + c0626ap.f1556bK + ", err = 0");
                    return true;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                    C0885e.m2419a(fileOutputStream);
                    C0885e.m2419a(inputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                c0762dv = u;
                if (c0762dv != null) {
                    c0762dv.close();
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    /* renamed from: b */
    private static int m1919b(Context context, C0856gq c0856gq, C0856gq c0856gq2, boolean z) {
        return C0769dy.m1913a(context, c0856gq, c0856gq2, z, false);
    }

    /* renamed from: b */
    public static int m1921b(Context context, File file) {
        return C0769dy.m1922b(context, file, 10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00f7  */
    /* renamed from: b */
    public static int m1922b(android.content.Context r6, java.io.File r7, int r8) {
        /*
        com.kingroot.sdk.C0769dy.m1908V(r6);
        r0 = new com.kingroot.sdk.ei;
        r0.<init>();
        r1 = "1";
        r0.f1913hv = r1;
        r1 = 44;
        r1 = com.kingroot.sdk.C0618aj.m1394o(r1);
        r0.f1912ha = r1;
        r1 = com.kingroot.sdk.util.C0893l.m2440M(r6);
        r0.f1911gQ = r1;
        r0.f1910gL = r8;
        r2 = 0;
        r1 = r7.getAbsolutePath();	 Catch:{ Exception -> 0x00d0, all -> 0x00f3 }
        r3 = com.kingroot.sdk.util.C0884d.m2411W(r1);	 Catch:{ Exception -> 0x00d0, all -> 0x00f3 }
        r1 = new java.io.File;	 Catch:{ Exception -> 0x00d0, all -> 0x00f3 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00d0, all -> 0x00f3 }
        r4.<init>();	 Catch:{ Exception -> 0x00d0, all -> 0x00f3 }
        r5 = r7.getAbsolutePath();	 Catch:{ Exception -> 0x00d0, all -> 0x00f3 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00d0, all -> 0x00f3 }
        r5 = "___";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00d0, all -> 0x00f3 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x00d0, all -> 0x00f3 }
        r1.<init>(r4);	 Catch:{ Exception -> 0x00d0, all -> 0x00f3 }
        r2 = r1.getAbsolutePath();	 Catch:{ Exception -> 0x0100 }
        com.kingroot.sdk.util.C0883c.m2400b(r3, r2);	 Catch:{ Exception -> 0x0100 }
        r2 = r1.getAbsolutePath();	 Catch:{ Exception -> 0x0100 }
        r2 = com.kingroot.sdk.util.C0883c.m2387W(r2);	 Catch:{ Exception -> 0x0100 }
        com.kingroot.sdk.util.C0883c.m2406h(r1);
        r1 = new com.kingroot.sdk.ej;
        r1.<init>();
        r1.f1916hw = r0;
        r1.f1917hx = r2;
        r0 = r1.toByteArray();
        r0 = com.kingroot.sdk.util.Cryptor.m2365c(r6, r0);
        r1 = com.kingroot.sdk.C0627aq.f1566bT;
        r1 = com.kingroot.sdk.C0762dv.m1894u(r6, r1);
        r2 = "POST";
        r1.setRequestMethod(r2);
        r1.mo5785k(r0);
        r1.mo5774bu();
        r2 = new java.lang.StringBuilder;
        r3 = "request Host=";
        r2.<init>(r3);
        r3 = com.kingroot.sdk.C0627aq.f1566bT;
        r2 = r2.append(r3);
        r3 = ", ContentLength=";
        r2 = r2.append(r3);
        r0 = r0.length;
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.kingroot.sdk.C0633at.m1463g(r0);
        r0 = new java.lang.StringBuilder;
        r2 = "reponseCode=";
        r0.<init>(r2);
        r2 = r1.getResponseCode();
        r0 = r0.append(r2);
        r2 = ", contentLength=";
        r0 = r0.append(r2);
        r2 = r1.getContentLength();
        r0 = r0.append(r2);
        r2 = ", contentType=";
        r0 = r0.append(r2);
        r2 = r1.getContentType();
        r0 = r0.append(r2);
        r0 = r0.toString();
        com.kingroot.sdk.C0633at.m1463g(r0);
        r0 = r1.getResponseCode();
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 != r1) goto L_0x00fb;
    L_0x00ce:
        r0 = 0;
    L_0x00cf:
        return r0;
    L_0x00d0:
        r0 = move-exception;
        r1 = r2;
    L_0x00d2:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00fe }
        r3 = "decode file error:";
        r2.<init>(r3);	 Catch:{ all -> 0x00fe }
        r3 = r0.getMessage();	 Catch:{ all -> 0x00fe }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00fe }
        r2 = r2.toString();	 Catch:{ all -> 0x00fe }
        com.kingroot.sdk.C0633at.m1463g(r2);	 Catch:{ all -> 0x00fe }
        r0.printStackTrace();	 Catch:{ all -> 0x00fe }
        if (r1 == 0) goto L_0x00f0;
    L_0x00ed:
        com.kingroot.sdk.util.C0883c.m2406h(r1);
    L_0x00f0:
        r0 = -7000; // 0xffffffffffffe4a8 float:NaN double:NaN;
        goto L_0x00cf;
    L_0x00f3:
        r0 = move-exception;
        r1 = r2;
    L_0x00f5:
        if (r1 == 0) goto L_0x00fa;
    L_0x00f7:
        com.kingroot.sdk.util.C0883c.m2406h(r1);
    L_0x00fa:
        throw r0;
    L_0x00fb:
        r0 = -4000; // 0xfffffffffffff060 float:NaN double:NaN;
        goto L_0x00cf;
    L_0x00fe:
        r0 = move-exception;
        goto L_0x00f5;
    L_0x0100:
        r0 = move-exception;
        goto L_0x00d2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.dy.b(android.content.Context, java.io.File, int):int");
    }

    /* renamed from: b */
    public static boolean m1924b(Context context, C0626ap c0626ap) {
        return C0769dy.m1918a(context, c0626ap, false);
    }

    /* renamed from: c */
    public static int m1927c(Context context, File file) {
        return C0769dy.m1922b(context, file, 3);
    }

    /* renamed from: d */
    public static void m1928d(final Context context, Handler handler) {
        String str = C0625ao.m1442x().f1871gK;
        if ("0".equals(str) || "".equals(str)) {
            C0633at.m1465i("No ChannelNo! Error.");
        } else {
            handler.post(new Runnable() {
                public final void run() {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("kingrootsdk", 0);
                    if (System.currentTimeMillis() - sharedPreferences.getLong("REPORT_CHANNEL_TIME", 0) > 604800000) {
                        int U = C0769dy.m1907U(context);
                        if (U == 0) {
                            C0633at.m1463g("Report Channel suc, errCode = " + U);
                            sharedPreferences.edit().putLong("REPORT_CHANNEL_TIME", System.currentTimeMillis()).commit();
                            return;
                        }
                        C0633at.m1463g("Report Channel fail， errCode = " + U);
                        return;
                    }
                    C0633at.m1463g("Duing 7 Day, Not report Channel.");
                }
            });
        }
    }

    /* renamed from: e */
    public static void m1929e(final Context context, Handler handler) {
        handler.post(new Runnable() {
            public final void run() {
                C0760dt E = C0760dt.m1855E(context.getApplicationContext());
                ArrayList aX = E.mo5765aX();
                if (aX.size() == 0) {
                    C0633at.m1463g("No UnReport SUI");
                    C0739de.m1801o(context, "has_action_stats");
                    return;
                }
                C0856gq c0856gq = new C0856gq(true);
                C0856gq c0856gq2 = new C0856gq(true);
                C0769dy.m1917a(12, c0856gq, c0856gq2);
                c0856gq.put("phonetype", C0769dy.m1932n());
                c0856gq.put("userinfo", C0625ao.m1434k(context));
                c0856gq.put("suikey", C0625ao.m1435l(context));
                c0856gq.put("vecsui", aX);
                int size = aX.size();
                for (int i = 0; i < size; i++) {
                    C0788ep c0788ep = (C0788ep) aX.get(i);
                    C0633at.m1463g(String.format("[REPORT] %s|%s", new Object[]{C0773eb.getAction(c0788ep.f1947id), c0788ep.f1945hP}));
                }
                int c = C0769dy.m1919b(context, c0856gq, c0856gq2, false);
                C0633at.m1463g("[REPORT_RET] err = " + c);
                if (c == 0) {
                    C0739de.m1801o(context, "has_action_stats");
                    E.mo5766aY();
                    C0633at.m1464h("Delete sui file");
                }
            }
        });
    }

    /* renamed from: f */
    public static void m1930f(final Context context, Handler handler) {
        handler.post(new Runnable() {
            public final void run() {
                C0760dt E = C0760dt.m1855E(context.getApplicationContext());
                ArrayList aZ = E.mo5767aZ();
                if (aZ.size() == 0) {
                    C0633at.m1463g("No UnReport RootResult");
                    return;
                }
                int i;
                C0856gq c0856gq = new C0856gq(true);
                C0856gq c0856gq2 = new C0856gq(true);
                C0791es k = C0625ao.m1434k(context);
                C0625ao.m1436m(context);
                C0784el o = C0625ao.m1439o(context);
                o.f1923hA = aZ;
                C0769dy.m1917a(16, c0856gq, c0856gq2);
                c0856gq.put("userinfo", k);
                c0856gq.put("req", o);
                for (i = 0; i < aZ.size(); i++) {
                    aZ.get(i);
                }
                i = C0769dy.m1913a(context, c0856gq, c0856gq2, false, true);
                C0633at.m1463g("[ROOT_RESULT_RET] err : " + i);
                if (i == 0) {
                    E.mo5769ba();
                    C0633at.m1464h("Delete rootResult file");
                }
            }
        });
    }

    /* renamed from: g */
    public static void m1931g(Context context, Handler handler) {
        C0769dy.m1928d(context, handler);
        Object[] C = C0749dk.m1820C(context);
        if (!(C == null || C[0] == null)) {
            long longValue = ((Long) C[1]).longValue();
            long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            C0633at.m1465i("xxxxxxxxxxx = lastBootTime = " + longValue + ", bootTime = " + currentTimeMillis);
            int i = Math.abs(currentTimeMillis - longValue) > 10000 ? 7034 : 7035;
            String str = (String) C[0];
            C0739de.m1798b(context, "solution_crash_" + str, 1);
            C0633at.m1464h("WupSession.reportWhenEver mark crash solution " + str);
            C0633at.m1464h("WupSession.reportWhenEver delete last unfinish solution.");
            C0760dt E = C0760dt.m1855E(context);
            String p = C0739de.m1802p(context, "runned_sids");
            E.mo5758a(null, 200033, 0, String.valueOf(i), "", handler, str, p);
            C0778ef c0778ef = new C0778ef();
            c0778ef.f1904hp = (long) i;
            c0778ef.f1901hm = str;
            c0778ef.index = -1;
            c0778ef.f1902hn = -1;
            c0778ef.f1903ho = -1;
            E.mo5757a(c0778ef, handler);
        }
        C0769dy.m1929e(context, handler);
        C0769dy.m1930f(context, handler);
        if (!C0749dk.f1835fF) {
            String[] q = C0739de.m1803q(context, "EMID_KRSDK_EXReport_Info");
            C0739de.m1801o(context, "EMID_KRSDK_EXReport_Info");
            if (q.length >= 5) {
                C0760dt.m1855E(context).mo5758a(null, 200039, 1, "7088", "reboot", handler, q[0], q[1], q[2], q[3], q[4], Integer.valueOf(0));
                C0769dy.m1929e(context, handler);
            }
            C0756dq.m1848b(context, handler);
            C0605ac.m1338d().mo5580a(context, handler);
        }
    }

    /* renamed from: n */
    private static C0779eg m1932n() {
        return C0625ao.m1438n();
    }
}
