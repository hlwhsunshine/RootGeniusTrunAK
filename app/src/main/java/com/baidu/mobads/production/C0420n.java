package com.baidu.mobads.production;

/* renamed from: com.baidu.mobads.production.n */
class C0420n implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0375a f950a;

    C0420n(C0375a c0375a) {
        this.f950a = c0375a;
    }

    public void run() {
        this.f950a.f817h.resize(this.f950a.getProdBase().getWidth(), this.f950a.getProdBase().getHeight());
    }
}
