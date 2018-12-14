package com.tencent.stat;

/* renamed from: com.tencent.stat.ay */
class C1703ay implements StatDispatchCallback {
    /* renamed from: a */
    final /* synthetic */ C1700av f4955a;

    C1703ay(C1700av c1700av) {
        this.f4955a = c1700av;
    }

    public void onDispatchFailure() {
        C1706ba.m4689b().mo7871a(this.f4955a.f4948a, null, this.f4955a.f4950c, true);
        StatServiceImpl.m4644d();
    }

    public void onDispatchSuccess() {
        StatServiceImpl.m4643c();
        if (C1706ba.m4689b().f4961a > 0) {
            StatServiceImpl.commitEvents(this.f4955a.f4951d, -1);
        }
    }
}
