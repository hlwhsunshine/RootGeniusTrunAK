package com.tencent.stat;

import android.content.Context;

/* renamed from: com.tencent.stat.aq */
final class C1695aq implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f4937a;
    /* renamed from: b */
    final /* synthetic */ Context f4938b;
    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f4939c;

    C1695aq(String str, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f4937a = str;
        this.f4938b = context;
        this.f4939c = statSpecifyReportedInfo;
    }

    public final void run() {
        if (this.f4937a == null || this.f4937a.trim().length() == 0) {
            StatServiceImpl.f4884q.mo7912w("qq num is null or empty.");
            return;
        }
        StatConfig.f4833f = this.f4937a;
        StatServiceImpl.m4636b(this.f4938b, new StatAccount(this.f4937a), this.f4939c);
    }
}
