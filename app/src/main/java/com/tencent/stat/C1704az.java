package com.tencent.stat;

/* renamed from: com.tencent.stat.az */
class C1704az implements StatDispatchCallback {
    /* renamed from: a */
    final /* synthetic */ C1700av f4956a;

    C1704az(C1700av c1700av) {
        this.f4956a = c1700av;
    }

    public void onDispatchFailure() {
        C1706ba.m4689b().mo7871a(this.f4956a.f4948a, null, this.f4956a.f4950c, true);
        StatServiceImpl.m4644d();
    }

    public void onDispatchSuccess() {
        StatServiceImpl.m4643c();
    }
}
