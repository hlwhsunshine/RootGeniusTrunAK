package com.tencent.stat;

import android.content.Context;
import java.util.Map;

/* renamed from: com.tencent.stat.aj */
final class C1688aj implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f4924a;
    /* renamed from: b */
    final /* synthetic */ Map f4925b;
    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f4926c;

    C1688aj(Context context, Map map, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f4924a = context;
        this.f4925b = map;
        this.f4926c = statSpecifyReportedInfo;
    }

    public final void run() {
        try {
            new Thread(new C1699au(this.f4924a, this.f4925b, this.f4926c), "NetworkMonitorTask").start();
        } catch (Throwable th) {
            StatServiceImpl.f4884q.mo7900e(th);
            StatServiceImpl.m4629a(this.f4924a, th);
        }
    }
}
