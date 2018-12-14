package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.event.C1735f;
import com.tencent.stat.event.C1737k;

/* renamed from: com.tencent.stat.ai */
final class C1687ai implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f4921a;
    /* renamed from: b */
    final /* synthetic */ String f4922b;
    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f4923c;

    C1687ai(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f4921a = context;
        this.f4922b = str;
        this.f4923c = statSpecifyReportedInfo;
    }

    public final void run() {
        try {
            Long l;
            StatServiceImpl.flushDataToDB(this.f4921a);
            synchronized (StatServiceImpl.f4882o) {
                l = (Long) StatServiceImpl.f4882o.remove(this.f4922b);
            }
            if (l != null) {
                Long valueOf = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
                if (valueOf.longValue() <= 0) {
                    valueOf = Long.valueOf(1);
                }
                String j = StatServiceImpl.f4881n;
                if (j != null && j.equals(this.f4922b)) {
                    j = "-";
                }
                C1735f c1737k = new C1737k(this.f4921a, j, this.f4922b, StatServiceImpl.m4619a(this.f4921a, false, this.f4923c), valueOf, this.f4923c);
                if (!this.f4922b.equals(StatServiceImpl.f4880m)) {
                    StatServiceImpl.f4884q.warn("Invalid invocation since previous onResume on diff page.");
                }
                new C1700av(c1737k).mo7867a();
                StatServiceImpl.f4881n = this.f4922b;
                return;
            }
            StatServiceImpl.f4884q.mo7899e("Starttime for PageID:" + this.f4922b + " not found, lost onResume()?");
        } catch (Throwable th) {
            StatServiceImpl.f4884q.mo7900e(th);
            StatServiceImpl.m4629a(this.f4921a, th);
        }
    }
}
