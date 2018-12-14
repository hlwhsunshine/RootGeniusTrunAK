package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.FailReason.FailType;

/* renamed from: com.nostra13.universalimageloader.core.j */
final class C1046j implements Runnable {
    /* renamed from: a */
    final /* synthetic */ FailType f2673a;
    /* renamed from: b */
    final /* synthetic */ Throwable f2674b;
    /* renamed from: c */
    final /* synthetic */ LoadAndDisplayImageTask f2675c;

    C1046j(LoadAndDisplayImageTask loadAndDisplayImageTask, FailType failType, Throwable th) {
        this.f2675c = loadAndDisplayImageTask;
        this.f2673a = failType;
        this.f2674b = th;
    }

    public final void run() {
        if (this.f2675c.f2486c.mo6266c()) {
            this.f2675c.f2485b.mo6253a(this.f2675c.f2486c.mo6265c(this.f2675c.f2492i.f2630a));
        }
        this.f2675c.f2485b.mo6256d();
        FailReason failReason = new FailReason(this.f2673a, this.f2674b);
    }
}
