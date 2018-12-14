package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.event.C1743h;

/* renamed from: com.tencent.stat.ad */
final class C1682ad implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f4911a;
    /* renamed from: b */
    final /* synthetic */ StatSpecifyReportedInfo f4912b;
    /* renamed from: c */
    final /* synthetic */ StatAppMonitor f4913c;

    C1682ad(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo, StatAppMonitor statAppMonitor) {
        this.f4911a = context;
        this.f4912b = statSpecifyReportedInfo;
        this.f4913c = statAppMonitor;
    }

    public final void run() {
        try {
            new C1700av(new C1743h(this.f4911a, StatServiceImpl.m4619a(this.f4911a, false, this.f4912b), this.f4913c, this.f4912b)).mo7867a();
        } catch (Throwable th) {
            StatServiceImpl.f4884q.mo7900e(th);
            StatServiceImpl.m4629a(this.f4911a, th);
        }
    }
}
