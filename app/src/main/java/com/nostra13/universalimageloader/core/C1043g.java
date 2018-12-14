package com.nostra13.universalimageloader.core;

import java.io.File;

/* renamed from: com.nostra13.universalimageloader.core.g */
final class C1043g implements Runnable {
    /* renamed from: a */
    final /* synthetic */ LoadAndDisplayImageTask f2660a;
    /* renamed from: b */
    final /* synthetic */ C1042f f2661b;

    C1043g(C1042f c1042f, LoadAndDisplayImageTask loadAndDisplayImageTask) {
        this.f2661b = c1042f;
        this.f2660a = loadAndDisplayImageTask;
    }

    public final void run() {
        File a = this.f2661b.f2650a.f2644o.mo6140a(this.f2660a.f2484a);
        Object obj = (a == null || !a.exists()) ? null : 1;
        this.f2661b.m3023e();
        if (obj != null) {
            this.f2661b.f2652c.execute(this.f2660a);
        } else {
            this.f2661b.f2651b.execute(this.f2660a);
        }
    }
}
