package com.shuame.p075ad;

/* renamed from: com.shuame.ad.ab */
final class C1085ab implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f2912a;
    /* renamed from: b */
    final /* synthetic */ C1121x f2913b;

    C1085ab(C1121x c1121x, String str) {
        this.f2913b = c1121x;
        this.f2912a = str;
    }

    public final void run() {
        if (this.f2913b.f2966a != null) {
            this.f2913b.f2966a.mo6683a(this.f2913b, this.f2912a);
        }
        this.f2913b.m3255a(0);
    }
}
