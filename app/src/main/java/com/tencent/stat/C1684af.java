package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.event.C1735f;
import com.tencent.stat.event.C1739c;
import com.tencent.stat.event.C1740d;

/* renamed from: com.tencent.stat.af */
final class C1684af implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f4914a;
    /* renamed from: b */
    final /* synthetic */ StatSpecifyReportedInfo f4915b;
    /* renamed from: c */
    final /* synthetic */ C1740d f4916c;
    /* renamed from: d */
    final /* synthetic */ int f4917d;

    C1684af(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo, C1740d c1740d, int i) {
        this.f4914a = context;
        this.f4915b = statSpecifyReportedInfo;
        this.f4916c = c1740d;
        this.f4917d = i;
    }

    public final void run() {
        try {
            C1735f c1739c = new C1739c(this.f4914a, StatServiceImpl.m4619a(this.f4914a, false, this.f4915b), this.f4916c.f5113a, this.f4915b);
            c1739c.mo7934b().f5115c = this.f4916c.f5115c;
            Long valueOf = Long.valueOf((long) this.f4917d);
            c1739c.mo7933a(Long.valueOf(valueOf.longValue() <= 0 ? 1 : valueOf.longValue()).longValue());
            new C1700av(c1739c).mo7867a();
        } catch (Throwable th) {
            StatServiceImpl.f4884q.mo7900e(th);
            StatServiceImpl.m4629a(this.f4914a, th);
        }
    }
}
