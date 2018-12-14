package com.nostra13.universalimageloader.p057a.p058a.p059a.p060a;

import java.util.concurrent.Callable;

/* renamed from: com.nostra13.universalimageloader.a.a.a.a.b */
final class C0976b implements Callable<Void> {
    /* renamed from: a */
    final /* synthetic */ C0975a f2451a;

    C0976b(C0975a c0975a) {
        this.f2451a = c0975a;
    }

    /* renamed from: a */
    private Void m2776a() {
        synchronized (this.f2451a) {
            if (this.f2451a.f2446m == null) {
            } else {
                this.f2451a.m2770g();
                this.f2451a.m2772h();
                if (this.f2451a.m2766e()) {
                    this.f2451a.m2762d();
                    this.f2451a.f2448o = 0;
                }
            }
        }
        return null;
    }
}
