package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.event.C1735f;
import com.tencent.stat.event.C1739c;
import com.tencent.stat.event.C1740d;

/* renamed from: com.tencent.stat.y */
final class C1767y implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f5182a;
    /* renamed from: b */
    final /* synthetic */ StatSpecifyReportedInfo f5183b;
    /* renamed from: c */
    final /* synthetic */ C1740d f5184c;

    C1767y(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo, C1740d c1740d) {
        this.f5182a = context;
        this.f5183b = statSpecifyReportedInfo;
        this.f5184c = c1740d;
    }

    public final void run() {
        try {
            C1735f c1739c = new C1739c(this.f5182a, StatServiceImpl.m4619a(this.f5182a, false, this.f5183b), this.f5184c.f5113a, this.f5183b);
            c1739c.mo7934b().f5115c = this.f5184c.f5115c;
            new C1700av(c1739c).mo7867a();
        } catch (Throwable th) {
            StatServiceImpl.f4884q.mo7900e(th);
            StatServiceImpl.m4629a(this.f5182a, th);
        }
    }
}
