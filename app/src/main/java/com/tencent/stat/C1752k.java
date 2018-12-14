package com.tencent.stat;

/* renamed from: com.tencent.stat.k */
class C1752k implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f5149a;
    /* renamed from: b */
    final /* synthetic */ int f5150b;
    /* renamed from: c */
    final /* synthetic */ StatFBDispatchCallback f5151c;
    /* renamed from: d */
    final /* synthetic */ C1748g f5152d;

    C1752k(C1748g c1748g, int i, int i2, StatFBDispatchCallback statFBDispatchCallback) {
        this.f5152d = c1748g;
        this.f5149a = i;
        this.f5150b = i2;
        this.f5151c = statFBDispatchCallback;
    }

    public void run() {
        this.f5152d.mo7947a(this.f5149a, this.f5150b, this.f5151c);
    }
}
