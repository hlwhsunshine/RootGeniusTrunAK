package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.event.C1741e;

/* renamed from: com.tencent.stat.r */
final class C1760r implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f5167a;
    /* renamed from: b */
    final /* synthetic */ Context f5168b;
    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f5169c;

    C1760r(String str, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f5167a = str;
        this.f5168b = context;
        this.f5169c = statSpecifyReportedInfo;
    }

    public final void run() {
        try {
            if (StatServiceImpl.m4631a(this.f5167a)) {
                StatServiceImpl.f4884q.error((Object) "Error message in StatService.reportError() is empty.");
            } else {
                new C1700av(new C1741e(this.f5168b, StatServiceImpl.m4619a(this.f5168b, false, this.f5169c), this.f5167a, 0, StatConfig.getMaxReportEventLength(), null, this.f5169c)).mo7867a();
            }
        } catch (Throwable th) {
            StatServiceImpl.f4884q.mo7900e(th);
            StatServiceImpl.m4629a(this.f5168b, th);
        }
    }
}
