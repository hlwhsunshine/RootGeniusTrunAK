package com.tencent.stat;

import android.content.Context;

/* renamed from: com.tencent.stat.al */
final class C1690al implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f4928a;
    /* renamed from: b */
    final /* synthetic */ StatSpecifyReportedInfo f4929b;

    C1690al(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f4928a = context;
        this.f4929b = statSpecifyReportedInfo;
    }

    public final void run() {
        try {
            StatServiceImpl.stopSession();
            StatServiceImpl.m4619a(this.f4928a, true, this.f4929b);
        } catch (Throwable th) {
            StatServiceImpl.f4884q.mo7900e(th);
            StatServiceImpl.m4629a(this.f4928a, th);
        }
    }
}
