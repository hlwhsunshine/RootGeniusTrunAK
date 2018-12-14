package com.tencent.stat;

/* renamed from: com.tencent.stat.ax */
class C1702ax implements StatDispatchCallback {
    /* renamed from: a */
    final /* synthetic */ C1700av f4954a;

    C1702ax(C1700av c1700av) {
        this.f4954a = c1700av;
    }

    public void onDispatchFailure() {
        StatServiceImpl.m4644d();
    }

    public void onDispatchSuccess() {
        StatServiceImpl.m4643c();
    }
}
