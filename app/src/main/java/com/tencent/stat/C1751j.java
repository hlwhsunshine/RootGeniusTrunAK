package com.tencent.stat;

/* renamed from: com.tencent.stat.j */
class C1751j implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f5145a;
    /* renamed from: b */
    final /* synthetic */ String f5146b;
    /* renamed from: c */
    final /* synthetic */ StatFBDispatchCallback f5147c;
    /* renamed from: d */
    final /* synthetic */ C1748g f5148d;

    C1751j(C1748g c1748g, String str, String str2, StatFBDispatchCallback statFBDispatchCallback) {
        this.f5148d = c1748g;
        this.f5145a = str;
        this.f5146b = str2;
        this.f5147c = statFBDispatchCallback;
    }

    /* JADX WARNING: Failed to extract finally block: empty outs */
    public void run() {
        /*
        r5 = this;
        r1 = "";
        r0 = r5.f5148d;	 Catch:{ Exception -> 0x0016 }
        r2 = r5.f5145a;	 Catch:{ Exception -> 0x0016 }
        r3 = r5.f5146b;	 Catch:{ Exception -> 0x0016 }
        r0 = r0.mo7945a(r2, r3);	 Catch:{ Exception -> 0x0016 }
        r1 = r5.f5147c;
        if (r1 == 0) goto L_0x0015;
    L_0x0010:
        r1 = r5.f5147c;
        r1.onFBDispatch(r0);
    L_0x0015:
        return;
    L_0x0016:
        r0 = move-exception;
        r2 = r5.f5148d;	 Catch:{ all -> 0x002d }
        r3 = -1;
        r4 = "IOException happen";
        r1 = r2.m4804a(r3, r4);	 Catch:{ all -> 0x002d }
        r0.printStackTrace();	 Catch:{ all -> 0x002d }
        r0 = r5.f5147c;
        if (r0 == 0) goto L_0x0015;
    L_0x0027:
        r0 = r5.f5147c;
        r0.onFBDispatch(r1);
        goto L_0x0015;
    L_0x002d:
        r0 = move-exception;
        r2 = r5.f5147c;
        if (r2 == 0) goto L_0x0037;
    L_0x0032:
        r2 = r5.f5147c;
        r2.onFBDispatch(r1);
    L_0x0037:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.j.run():void");
    }
}
