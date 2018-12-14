package com.tencent.stat;

/* renamed from: com.tencent.stat.aw */
class C1701aw implements StatDispatchCallback {
    /* renamed from: a */
    final /* synthetic */ C1700av f4953a;

    C1701aw(C1700av c1700av) {
        this.f4953a = c1700av;
    }

    public void onDispatchFailure() {
        StatServiceImpl.m4644d();
    }

    public void onDispatchSuccess() {
        StatServiceImpl.m4643c();
        if (C1706ba.m4689b().mo7869a() >= StatConfig.getMaxBatchReportCount()) {
            C1706ba.m4689b().mo7870a(StatConfig.getMaxBatchReportCount());
        }
    }
}
