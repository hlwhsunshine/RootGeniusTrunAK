package com.baidu.mobads.p034h;

/* renamed from: com.baidu.mobads.h.k */
class C0312k implements Runnable {
    /* renamed from: a */
    final /* synthetic */ boolean f583a;
    /* renamed from: b */
    final /* synthetic */ C0307g f584b;

    C0312k(C0307g c0307g, boolean z) {
        this.f584b = c0307g;
        this.f583a = z;
    }

    public void run() {
        new Thread(new C0313l(this)).start();
    }
}
