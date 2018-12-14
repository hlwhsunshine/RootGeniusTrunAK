package com.tencent.beacon.cover;

import android.content.Context;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.beacon.cover.b */
public final class C1623b implements Runnable {
    /* renamed from: c */
    private static C1623b f4596c = null;
    /* renamed from: a */
    private Context f4597a;
    /* renamed from: b */
    private List<C1622a> f4598b = null;
    /* renamed from: d */
    private DexClassLoader f4599d;

    private C1623b(Context context) {
        this.f4597a = context;
        this.f4598b = new ArrayList();
    }

    /* renamed from: a */
    public static C1623b m4400a(Context context, List<C1622a> list) {
        if (f4596c == null) {
            f4596c = new C1623b(context);
        }
        f4596c.m4401a(list);
        return f4596c;
    }

    /* renamed from: a */
    private synchronized C1623b m4401a(List<C1622a> list) {
        this.f4598b.clear();
        this.f4598b.addAll(list);
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x010f  */
    @android.annotation.TargetApi(3)
    /* renamed from: b */
    private synchronized boolean m4402b() {
        /*
        r11 = this;
        r9 = 3;
        r1 = 1;
        r2 = 0;
        monitor-enter(r11);
        r0 = r11.f4599d;	 Catch:{ all -> 0x009a }
        if (r0 == 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r11);
        return r1;
    L_0x000a:
        r0 = r11.f4598b;	 Catch:{ all -> 0x009a }
        if (r0 == 0) goto L_0x0016;
    L_0x000e:
        r0 = r11.f4598b;	 Catch:{ all -> 0x009a }
        r0 = r0.size();	 Catch:{ all -> 0x009a }
        if (r0 > 0) goto L_0x0018;
    L_0x0016:
        r1 = r2;
        goto L_0x0008;
    L_0x0018:
        r0 = "D";
        r3 = "start to load comps to classLoader.";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x009a }
        com.tencent.beacon.cover.C1627f.m4428a(r0, r3, r4);	 Catch:{ all -> 0x009a }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009a }
        r0.<init>();	 Catch:{ all -> 0x009a }
        r3 = r11.f4597a;	 Catch:{ all -> 0x009a }
        r3 = r3.getFilesDir();	 Catch:{ all -> 0x009a }
        r3 = r3.getAbsolutePath();	 Catch:{ all -> 0x009a }
        r0 = r0.append(r3);	 Catch:{ all -> 0x009a }
        r3 = java.io.File.separator;	 Catch:{ all -> 0x009a }
        r0 = r0.append(r3);	 Catch:{ all -> 0x009a }
        r3 = "beacon/comp";
        r0 = r0.append(r3);	 Catch:{ all -> 0x009a }
        r3 = r0.toString();	 Catch:{ all -> 0x009a }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009a }
        r0.<init>();	 Catch:{ all -> 0x009a }
        r4 = r11.f4597a;	 Catch:{ all -> 0x009a }
        r4 = r4.getFilesDir();	 Catch:{ all -> 0x009a }
        r4 = r4.getAbsolutePath();	 Catch:{ all -> 0x009a }
        r0 = r0.append(r4);	 Catch:{ all -> 0x009a }
        r4 = java.io.File.separator;	 Catch:{ all -> 0x009a }
        r0 = r0.append(r4);	 Catch:{ all -> 0x009a }
        r4 = "beacon/odex";
        r0 = r0.append(r4);	 Catch:{ all -> 0x009a }
        r4 = r0.toString();	 Catch:{ all -> 0x009a }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009a }
        r5.<init>();	 Catch:{ all -> 0x009a }
        r0 = r11.f4598b;	 Catch:{ all -> 0x009a }
        r6 = r0.iterator();	 Catch:{ all -> 0x009a }
    L_0x0073:
        r0 = r6.hasNext();	 Catch:{ all -> 0x009a }
        if (r0 == 0) goto L_0x009d;
    L_0x0079:
        r0 = r6.next();	 Catch:{ all -> 0x009a }
        r0 = (com.tencent.beacon.cover.C1622a) r0;	 Catch:{ all -> 0x009a }
        if (r0 == 0) goto L_0x0073;
    L_0x0081:
        r7 = r0.f4590c;	 Catch:{ all -> 0x009a }
        r8 = com.tencent.beacon.cover.C1627f.f4615b;	 Catch:{ all -> 0x009a }
        if (r7 != r8) goto L_0x0073;
    L_0x0087:
        r5.append(r3);	 Catch:{ all -> 0x009a }
        r7 = java.io.File.separator;	 Catch:{ all -> 0x009a }
        r5.append(r7);	 Catch:{ all -> 0x009a }
        r0 = r0.f4591d;	 Catch:{ all -> 0x009a }
        r5.append(r0);	 Catch:{ all -> 0x009a }
        r0 = java.io.File.pathSeparator;	 Catch:{ all -> 0x009a }
        r5.append(r0);	 Catch:{ all -> 0x009a }
        goto L_0x0073;
    L_0x009a:
        r0 = move-exception;
        monitor-exit(r11);
        throw r0;
    L_0x009d:
        r0 = r11.m4403c();	 Catch:{ all -> 0x009a }
        if (r0 < r9) goto L_0x00b0;
    L_0x00a3:
        r0 = "E";
        r1 = "load comps failed for three times, don't load again.";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x009a }
        com.tencent.beacon.cover.C1627f.m4428a(r0, r1, r3);	 Catch:{ all -> 0x009a }
        r1 = r2;
        goto L_0x0008;
    L_0x00b0:
        r6 = r0 + 1;
        r0 = r11.f4597a;	 Catch:{ Throwable -> 0x00fd }
        r7 = "LOAD_RETRIES_TIMES";
        r8 = java.lang.String.valueOf(r6);	 Catch:{ Throwable -> 0x00fd }
        com.tencent.beacon.cover.C1627f.m4429a(r0, r7, r8);	 Catch:{ Throwable -> 0x00fd }
        r0 = "D";
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00fd }
        r8 = "dex file path -> ";
        r7.<init>(r8);	 Catch:{ Throwable -> 0x00fd }
        r8 = r5.toString();	 Catch:{ Throwable -> 0x00fd }
        r7 = r7.append(r8);	 Catch:{ Throwable -> 0x00fd }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x00fd }
        r8 = 0;
        r8 = new java.lang.Object[r8];	 Catch:{ Throwable -> 0x00fd }
        com.tencent.beacon.cover.C1627f.m4428a(r0, r7, r8);	 Catch:{ Throwable -> 0x00fd }
        r0 = new dalvik.system.DexClassLoader;	 Catch:{ Throwable -> 0x00fd }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x00fd }
        r7 = r11.getClass();	 Catch:{ Throwable -> 0x00fd }
        r7 = r7.getClassLoader();	 Catch:{ Throwable -> 0x00fd }
        r0.<init>(r5, r4, r3, r7);	 Catch:{ Throwable -> 0x00fd }
        r11.f4599d = r0;	 Catch:{ Throwable -> 0x00fd }
        r0 = r11.f4599d;	 Catch:{ Throwable -> 0x00fd }
        com.tencent.beacon.event.UserAction.onCompLoaded(r0);	 Catch:{ Throwable -> 0x00fd }
        r0 = r11.f4597a;	 Catch:{ Throwable -> 0x011d }
        r2 = "LOAD_RETRIES_TIMES";
        r3 = "0";
        com.tencent.beacon.cover.C1627f.m4429a(r0, r2, r3);	 Catch:{ Throwable -> 0x011d }
        r0 = r1;
    L_0x00fa:
        r1 = r0;
        goto L_0x0008;
    L_0x00fd:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
    L_0x0100:
        r2 = r11.f4597a;	 Catch:{ all -> 0x009a }
        r2 = com.tencent.beacon.cover.C1626e.m4414a(r2);	 Catch:{ all -> 0x009a }
        r3 = r1.toString();	 Catch:{ all -> 0x009a }
        r2.mo7602a(r3);	 Catch:{ all -> 0x009a }
        if (r6 < r9) goto L_0x0119;
    L_0x010f:
        r2 = r11.f4597a;	 Catch:{ all -> 0x009a }
        r2 = com.tencent.beacon.cover.C1626e.m4414a(r2);	 Catch:{ all -> 0x009a }
        r3 = 0;
        r2.mo7603a(r3);	 Catch:{ all -> 0x009a }
    L_0x0119:
        r1.printStackTrace();	 Catch:{ all -> 0x009a }
        goto L_0x00fa;
    L_0x011d:
        r0 = move-exception;
        r10 = r0;
        r0 = r1;
        r1 = r10;
        goto L_0x0100;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.beacon.cover.b.b():boolean");
    }

    /* renamed from: c */
    private int m4403c() {
        int i = 0;
        try {
            return Integer.parseInt(C1627f.m4435b(this.f4597a, "LOAD_RETRIES_TIMES", "0"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return i;
        }
    }

    /* renamed from: a */
    public final void mo7594a() {
        if (this.f4599d == null) {
            C1627f.m4429a(this.f4597a, "LOAD_RETRIES_TIMES", "0");
            m4402b();
        }
    }

    public final synchronized void run() {
        String str = "load";
        if (C1625d.m4410a(this.f4597a).mo7600a(str)) {
            m4402b();
            C1625d.m4410a(this.f4597a).mo7601b(str);
        }
    }
}
