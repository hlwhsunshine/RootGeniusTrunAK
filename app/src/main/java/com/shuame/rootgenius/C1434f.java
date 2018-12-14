package com.shuame.rootgenius;

import com.shuame.rootgenius.common.util.C1408q.C1407a;

/* renamed from: com.shuame.rootgenius.f */
final class C1434f implements C1407a {
    /* renamed from: a */
    final /* synthetic */ RootGeniusApp f3938a;
    /* renamed from: b */
    private long f3939b;

    C1434f(RootGeniusApp rootGeniusApp) {
        this.f3938a = rootGeniusApp;
    }

    /* renamed from: a */
    public final void mo7126a() {
        RootGeniusApp.f3305e;
    }

    /* renamed from: b */
    public final void mo7127b() {
        RootGeniusApp.f3305e;
        RootGeniusApp.m3527c(this.f3938a);
    }

    /* renamed from: c */
    public final void mo7128c() {
        RootGeniusApp.f3305e;
    }

    /* renamed from: d */
    public final void mo7129d() {
        RootGeniusApp.f3305e;
        if (System.currentTimeMillis() - this.f3939b > 10000) {
            RootGeniusApp.m3527c(this.f3938a);
        }
    }

    /* renamed from: e */
    public final void mo7130e() {
        RootGeniusApp.f3305e;
    }

    /* renamed from: f */
    public final void mo7131f() {
        RootGeniusApp.f3305e;
        this.f3939b = System.currentTimeMillis();
    }
}
