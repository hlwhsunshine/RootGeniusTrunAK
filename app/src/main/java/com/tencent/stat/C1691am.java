package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.event.C1735f;
import com.tencent.stat.event.C1738b;

/* renamed from: com.tencent.stat.am */
final class C1691am implements Runnable {
    /* renamed from: a */
    final /* synthetic */ long f4930a;
    /* renamed from: b */
    final /* synthetic */ Context f4931b;
    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f4932c;
    /* renamed from: d */
    final /* synthetic */ boolean f4933d;

    C1691am(long j, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo, boolean z) {
        this.f4930a = j;
        this.f4931b = context;
        this.f4932c = statSpecifyReportedInfo;
        this.f4933d = z;
    }

    public final void run() {
        try {
            StatServiceImpl.f4884q.mo7904i("trackBackground duration:" + this.f4930a);
            StatServiceImpl.flushDataToDB(this.f4931b);
            C1735f c1738b = new C1738b(StatServiceImpl.getContext(this.f4931b), StatServiceImpl.m4619a(this.f4931b, false, this.f4932c), Long.valueOf(this.f4930a > 0 ? this.f4930a : 1), this.f4932c);
            if (this.f4933d) {
                C1706ba.m4673a(this.f4931b).mo7871a(c1738b, null, false, true);
            } else {
                new C1700av(c1738b).mo7867a();
            }
        } catch (Throwable th) {
            StatServiceImpl.f4884q.mo7900e(th);
            StatServiceImpl.m4629a(this.f4931b, th);
        }
    }
}
