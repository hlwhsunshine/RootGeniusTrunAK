package com.tencent.stat;

/* renamed from: com.tencent.stat.ap */
final class C1694ap implements StatActionListener {
    /* renamed from: a */
    final /* synthetic */ StatSpecifyReportedInfo f4936a;

    C1694ap(StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f4936a = statSpecifyReportedInfo;
    }

    public final void onBecameBackground() {
        StatServiceImpl.m4637b(StatServiceImpl.f4887t, this.f4936a, true);
    }

    public final void onBecameForeground() {
        StatServiceImpl.f4866A = System.currentTimeMillis();
    }
}
