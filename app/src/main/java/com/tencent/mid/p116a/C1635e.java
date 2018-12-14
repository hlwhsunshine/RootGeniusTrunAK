package com.tencent.mid.p116a;

import com.tencent.mid.api.MidCallback;

/* renamed from: com.tencent.mid.a.e */
class C1635e implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1637g f4663a;
    /* renamed from: b */
    final /* synthetic */ MidCallback f4664b;
    /* renamed from: c */
    final /* synthetic */ C1634d f4665c;

    C1635e(C1634d c1634d, C1637g c1637g, MidCallback midCallback) {
        this.f4665c = c1634d;
        this.f4663a = c1637g;
        this.f4664b = midCallback;
    }

    public void run() {
        this.f4665c.m4472b(this.f4663a, this.f4664b);
    }
}
