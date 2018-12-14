package com.tencent.stat;

import android.content.Context;

/* renamed from: com.tencent.stat.x */
final class C1766x implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f5179a;
    /* renamed from: b */
    final /* synthetic */ Context f5180b;
    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f5181c;

    C1766x(String str, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f5179a = str;
        this.f5180b = context;
        this.f5181c = statSpecifyReportedInfo;
    }

    public final void run() {
        try {
            synchronized (StatServiceImpl.f4882o) {
                if (StatServiceImpl.f4882o.size() >= StatConfig.getMaxParallelTimmingEvents()) {
                    StatServiceImpl.f4884q.error("The number of page events exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
                    return;
                }
                StatServiceImpl.f4880m = this.f5179a;
                if (StatServiceImpl.f4882o.containsKey(StatServiceImpl.f4880m)) {
                    StatServiceImpl.f4884q.mo7899e("Duplicate PageID : " + StatServiceImpl.f4880m + ", onResume() repeated?");
                    return;
                }
                StatServiceImpl.f4882o.put(StatServiceImpl.f4880m, Long.valueOf(System.currentTimeMillis()));
                StatServiceImpl.m4619a(this.f5180b, true, this.f5181c);
            }
        } catch (Throwable th) {
            StatServiceImpl.f4884q.mo7900e(th);
            StatServiceImpl.m4629a(this.f5180b, th);
        }
    }
}
