package com.kingroot.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.kingroot.sdk.C0619ak.C0620a;
import com.kingroot.sdk.C0619ak.C0621b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.kingroot.sdk.al */
public final class C0622al {
    /* renamed from: a */
    private static int m1411a(Context context, C0772ea c0772ea, AtomicReference<C0774ec> atomicReference, int i) {
        C0856gq c0856gq = new C0856gq(true);
        C0856gq c0856gq2 = new C0856gq(true);
        C0622al.m1414a(1, "info", "getGuid", c0856gq, c0856gq2);
        c0856gq.put("phonetype", C0618aj.m1392n());
        c0856gq.put("userinfo", C0618aj.m1383a(context, i));
        c0856gq.put("deviceinfo", c0772ea);
        int a = C0622al.m1412a(context, c0856gq, c0856gq2, false);
        if (a != 0) {
            return a;
        }
        Object a2 = c0856gq2.mo5862a("guidinfo", (Object) new C0774ec());
        if (a2 != null) {
            atomicReference.set((C0774ec) a2);
        }
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ca  */
    /* renamed from: a */
    private static int m1412a(android.content.Context r6, com.kingroot.sdk.C0856gq r7, com.kingroot.sdk.C0856gq r8, boolean r9) {
        /*
        r1 = -6000; // 0xffffffffffffe890 float:NaN double:NaN;
        r2 = 0;
        r0 = r7.mo5859ck();	 Catch:{ IllegalArgumentException -> 0x009e, Exception -> 0x00ad, Throwable -> 0x00be, all -> 0x00cf }
        r0 = com.kingroot.sdk.util.Cryptor.m2363b(r6, r0);	 Catch:{ IllegalArgumentException -> 0x009e, Exception -> 0x00ad, Throwable -> 0x00be, all -> 0x00cf }
        r3 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x009e, Exception -> 0x00ad, Throwable -> 0x00be, all -> 0x00cf }
        r4 = "host url:";
        r3.<init>(r4);	 Catch:{ IllegalArgumentException -> 0x009e, Exception -> 0x00ad, Throwable -> 0x00be, all -> 0x00cf }
        r4 = com.kingroot.sdk.C0602ab.f1481aB;	 Catch:{ IllegalArgumentException -> 0x009e, Exception -> 0x00ad, Throwable -> 0x00be, all -> 0x00cf }
        r3 = r3.append(r4);	 Catch:{ IllegalArgumentException -> 0x009e, Exception -> 0x00ad, Throwable -> 0x00be, all -> 0x00cf }
        r3 = r3.toString();	 Catch:{ IllegalArgumentException -> 0x009e, Exception -> 0x00ad, Throwable -> 0x00be, all -> 0x00cf }
        com.kingroot.sdk.C0617ai.m1380g(r3);	 Catch:{ IllegalArgumentException -> 0x009e, Exception -> 0x00ad, Throwable -> 0x00be, all -> 0x00cf }
        r3 = com.kingroot.sdk.C0602ab.f1481aB;	 Catch:{ IllegalArgumentException -> 0x009e, Exception -> 0x00ad, Throwable -> 0x00be, all -> 0x00cf }
        r3 = com.kingroot.sdk.C0762dv.m1894u(r6, r3);	 Catch:{ IllegalArgumentException -> 0x009e, Exception -> 0x00ad, Throwable -> 0x00be, all -> 0x00cf }
        r2 = "POST";
        r3.setRequestMethod(r2);	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        r3.mo5785k(r0);	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        r3.mo5774bu();	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        r0 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        r2 = "WupSession.reponseCode=";
        r0.<init>(r2);	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        r2 = r3.getResponseCode();	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        r0 = r0.append(r2);	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        r2 = ", contentLength=";
        r0 = r0.append(r2);	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        r4 = r3.getContentLength();	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        r0 = r0.append(r4);	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        r2 = ", contentType=";
        r0 = r0.append(r2);	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        r2 = r3.getContentType();	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        r0 = r0.append(r2);	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        r0 = r0.toString();	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        com.kingroot.sdk.C0617ai.m1380g(r0);	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        r0 = new java.util.concurrent.atomic.AtomicReference;	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        r0.<init>();	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        r2 = 0;
        r2 = r3.mo5770a(r2, r0);	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        if (r2 == 0) goto L_0x007a;
    L_0x006e:
        r0 = "WupSession.httpConnection.getResponse(..)出错了！";
        com.kingroot.sdk.C0617ai.m1382i(r0);	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        if (r3 == 0) goto L_0x0078;
    L_0x0075:
        r3.close();
    L_0x0078:
        r0 = r2;
    L_0x0079:
        return r0;
    L_0x007a:
        r0 = r0.get();	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        r0 = (byte[]) r0;	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        if (r9 != 0) goto L_0x00e5;
    L_0x0082:
        if (r0 == 0) goto L_0x00e5;
    L_0x0084:
        r4 = r0.length;	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        if (r4 <= 0) goto L_0x00e5;
    L_0x0087:
        r0 = com.kingroot.sdk.util.Cryptor.m2367d(r6, r0);	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        if (r0 == 0) goto L_0x0097;
    L_0x008d:
        r8.mo5860m(r0);	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        r0 = r2;
    L_0x0091:
        if (r3 == 0) goto L_0x0079;
    L_0x0093:
        r3.close();
        goto L_0x0079;
    L_0x0097:
        r0 = "Cryptor.y() failed";
        com.kingroot.sdk.C0617ai.m1382i(r0);	 Catch:{ IllegalArgumentException -> 0x00e0, Exception -> 0x00de, Throwable -> 0x00dc }
        r0 = r1;
        goto L_0x0091;
    L_0x009e:
        r0 = move-exception;
        r1 = r2;
    L_0x00a0:
        r2 = "WupSession.IllegalArgumentException";
        com.kingroot.sdk.C0617ai.m1379a(r2, r0);	 Catch:{ all -> 0x00d9 }
        r0 = -6057; // 0xffffffffffffe857 float:NaN double:NaN;
        if (r1 == 0) goto L_0x0079;
    L_0x00a9:
        r1.close();
        goto L_0x0079;
    L_0x00ad:
        r0 = move-exception;
        r3 = r2;
    L_0x00af:
        r2 = "WupSession.Exception";
        com.kingroot.sdk.C0617ai.m1379a(r2, r0);	 Catch:{ all -> 0x00d7 }
        r0.printStackTrace();	 Catch:{ all -> 0x00d7 }
        if (r3 == 0) goto L_0x00e3;
    L_0x00b9:
        r3.close();
        r0 = r1;
        goto L_0x0079;
    L_0x00be:
        r0 = move-exception;
        r3 = r2;
    L_0x00c0:
        r2 = "WupSession.Throwable";
        com.kingroot.sdk.C0617ai.m1379a(r2, r0);	 Catch:{ all -> 0x00d7 }
        r0.printStackTrace();	 Catch:{ all -> 0x00d7 }
        if (r3 == 0) goto L_0x00e3;
    L_0x00ca:
        r3.close();
        r0 = r1;
        goto L_0x0079;
    L_0x00cf:
        r0 = move-exception;
        r3 = r2;
    L_0x00d1:
        if (r3 == 0) goto L_0x00d6;
    L_0x00d3:
        r3.close();
    L_0x00d6:
        throw r0;
    L_0x00d7:
        r0 = move-exception;
        goto L_0x00d1;
    L_0x00d9:
        r0 = move-exception;
        r3 = r1;
        goto L_0x00d1;
    L_0x00dc:
        r0 = move-exception;
        goto L_0x00c0;
    L_0x00de:
        r0 = move-exception;
        goto L_0x00af;
    L_0x00e0:
        r0 = move-exception;
        r1 = r3;
        goto L_0x00a0;
    L_0x00e3:
        r0 = r1;
        goto L_0x0079;
    L_0x00e5:
        r0 = r2;
        goto L_0x0091;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.al.a(android.content.Context, com.kingroot.sdk.gq, com.kingroot.sdk.gq, boolean):int");
    }

    /* renamed from: a */
    private static int m1413a(Context context, List<C0788ep> list, int i, String str) {
        int i2 = 0;
        if (!(list == null || list.size() == 0)) {
            C0856gq c0856gq = new C0856gq(true);
            C0856gq c0856gq2 = new C0856gq(true);
            C0622al.m1414a(0, "report", "reportSoftUsageInfo", c0856gq, c0856gq2);
            C0622al.m1415c(context, i);
            c0856gq.put("phonetype", C0618aj.m1392n());
            c0856gq.put("userinfo", C0618aj.m1383a(context, i));
            c0856gq.put("suikey", C0618aj.m1389c(context, str, i));
            c0856gq.put("vecsui", list);
            i2 = C0622al.m1412a(context, c0856gq, c0856gq2, false);
            if (i2 == 0) {
                C0617ai.m1380g("report stat_point ok");
            }
        }
        return i2;
    }

    /* renamed from: a */
    private static void m1414a(int i, String str, String str2, C0856gq c0856gq, C0856gq c0856gq2) {
        c0856gq.mo5858aq("UTF-8");
        c0856gq.mo5864J(i);
        c0856gq.mo5865ar(str);
        c0856gq.mo5866as(str2);
        c0856gq2.mo5858aq("UTF-8");
    }

    /* JADX WARNING: Missing block: B:6:0x0011, code:
            if (r0 != 0) goto L_0x0013;
     */
    /* renamed from: c */
    private static synchronized int m1415c(android.content.Context r2, int r3) {
        /*
        r1 = com.kingroot.sdk.C0622al.class;
        monitor-enter(r1);
        r0 = com.kingroot.sdk.C0618aj.m1394o(r3);	 Catch:{ all -> 0x0017 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x0017 }
        if (r0 == 0) goto L_0x0015;
    L_0x000d:
        r0 = com.kingroot.sdk.C0622al.m1416d(r2, r3);	 Catch:{ all -> 0x0017 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.al.c(android.content.Context, int):int");
    }

    /* renamed from: d */
    private static int m1416d(Context context, int i) {
        C0617ai.m1380g("getGuidFromServer called");
        C0772ea b = C0618aj.m1388b(context, i);
        AtomicReference atomicReference = new AtomicReference();
        int a = C0622al.m1411a(context, b, atomicReference, i);
        if (a == 0) {
            C0774ec c0774ec = (C0774ec) atomicReference.get();
            if (c0774ec != null) {
                String str = c0774ec.f1889ha;
                if (TextUtils.isEmpty(str)) {
                    return -2001;
                }
                C0618aj.m1387a(str, i);
                C0617ai.m1380g("guid is set");
            }
        }
        return a;
    }

    /* renamed from: i */
    public static boolean m1417i(Context context) {
        try {
            List<String> r = C0620a.m1405r();
            if (r == null || r.isEmpty()) {
                return true;
            }
            List arrayList = new ArrayList();
            for (String str : r) {
                C0788ep c0788ep = new C0788ep();
                c0788ep.f1947id = 250002;
                c0788ep.f1948x = (int) (System.currentTimeMillis() / 1000);
                c0788ep.f1943hN = "";
                c0788ep.f1945hP = str;
                arrayList.add(c0788ep);
            }
            if (!arrayList.isEmpty() && C0622al.m1413a(context, arrayList, 44, "EP_KingCommon") == 0) {
                C0617ai.m1381h("Report shell info success");
                C0620a.m1406s();
                return true;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: j */
    public static boolean m1418j(Context context) {
        try {
            List<String> r = C0621b.m1408r();
            if (r == null || r.isEmpty()) {
                return true;
            }
            List arrayList = new ArrayList();
            for (String str : r) {
                C0788ep c0788ep = new C0788ep();
                c0788ep.f1947id = 250003;
                c0788ep.f1948x = (int) (System.currentTimeMillis() / 1000);
                c0788ep.f1943hN = "";
                c0788ep.f1945hP = str;
                arrayList.add(c0788ep);
            }
            if (!arrayList.isEmpty() && C0622al.m1413a(context, arrayList, 44, "EP_KingCommon") == 0) {
                C0617ai.m1381h("Report su info success");
                C0621b.m1409s();
                return true;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
