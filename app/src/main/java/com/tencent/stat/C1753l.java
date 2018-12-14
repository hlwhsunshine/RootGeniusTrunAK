package com.tencent.stat;

/* renamed from: com.tencent.stat.l */
class C1753l implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f5153a;
    /* renamed from: b */
    final /* synthetic */ String f5154b;
    /* renamed from: c */
    final /* synthetic */ StatFBDispatchCallback f5155c;
    /* renamed from: d */
    final /* synthetic */ C1748g f5156d;

    C1753l(C1748g c1748g, String str, String str2, StatFBDispatchCallback statFBDispatchCallback) {
        this.f5156d = c1748g;
        this.f5153a = str;
        this.f5154b = str2;
        this.f5155c = statFBDispatchCallback;
    }

    public void run() {
        this.f5156d.mo7949a(this.f5153a, this.f5154b, this.f5155c);
    }
}
