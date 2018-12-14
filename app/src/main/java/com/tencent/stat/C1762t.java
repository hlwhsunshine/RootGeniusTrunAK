package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.event.C1741e;

/* renamed from: com.tencent.stat.t */
final class C1762t implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Throwable f5172a;
    /* renamed from: b */
    final /* synthetic */ Context f5173b;
    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f5174c;

    C1762t(Throwable th, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f5172a = th;
        this.f5173b = context;
        this.f5174c = statSpecifyReportedInfo;
    }

    public final void run() {
        if (this.f5172a == null) {
            StatServiceImpl.f4884q.error((Object) "The Throwable error message of StatService.reportException() can not be null!");
        } else {
            new C1700av(new C1741e(this.f5173b, StatServiceImpl.m4619a(this.f5173b, false, this.f5174c), 1, this.f5172a, this.f5174c)).mo7867a();
        }
    }
}
