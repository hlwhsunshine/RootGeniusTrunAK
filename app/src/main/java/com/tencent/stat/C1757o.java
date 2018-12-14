package com.tencent.stat;

import android.content.Context;

/* renamed from: com.tencent.stat.o */
final class C1757o implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f5163a;
    /* renamed from: b */
    final /* synthetic */ StatSpecifyReportedInfo f5164b;

    C1757o(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f5163a = context;
        this.f5164b = statSpecifyReportedInfo;
    }

    public final void run() {
        try {
            StatServiceImpl.m4619a(this.f5163a, false, this.f5164b);
        } catch (Throwable th) {
            StatServiceImpl.f4884q.mo7900e(th);
        }
    }
}
