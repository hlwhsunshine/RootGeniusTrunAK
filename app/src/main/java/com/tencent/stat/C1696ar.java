package com.tencent.stat;

import android.content.Context;

/* renamed from: com.tencent.stat.ar */
final class C1696ar implements Runnable {
    /* renamed from: a */
    final /* synthetic */ StatAccount f4940a;
    /* renamed from: b */
    final /* synthetic */ Context f4941b;
    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f4942c;

    C1696ar(StatAccount statAccount, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f4940a = statAccount;
        this.f4941b = context;
        this.f4942c = statSpecifyReportedInfo;
    }

    public final void run() {
        if (this.f4940a == null || this.f4940a.getAccount().trim().length() == 0) {
            StatServiceImpl.f4884q.mo7912w("account is null or empty.");
            return;
        }
        StatConfig.setQQ(this.f4941b, this.f4940a.getAccount());
        StatServiceImpl.m4636b(this.f4941b, this.f4940a, this.f4942c);
    }
}
