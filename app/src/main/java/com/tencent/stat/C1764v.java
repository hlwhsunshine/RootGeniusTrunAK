package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.event.C1735f;
import com.tencent.stat.event.C1739c;
import com.tencent.stat.event.C1740d;

/* renamed from: com.tencent.stat.v */
final class C1764v implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f5176a;
    /* renamed from: b */
    final /* synthetic */ StatSpecifyReportedInfo f5177b;
    /* renamed from: c */
    final /* synthetic */ C1740d f5178c;

    C1764v(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo, C1740d c1740d) {
        this.f5176a = context;
        this.f5177b = statSpecifyReportedInfo;
        this.f5178c = c1740d;
    }

    public final void run() {
        try {
            C1735f c1739c = new C1739c(this.f5176a, StatServiceImpl.m4619a(this.f5176a, false, this.f5177b), this.f5178c.f5113a, this.f5177b);
            c1739c.mo7934b().f5114b = this.f5178c.f5114b;
            new C1700av(c1739c).mo7867a();
        } catch (Throwable th) {
            StatServiceImpl.f4884q.mo7900e(th);
            StatServiceImpl.m4629a(this.f5176a, th);
        }
    }
}
