package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.event.C1735f;
import com.tencent.stat.event.C1739c;
import com.tencent.stat.event.C1740d;

/* renamed from: com.tencent.stat.ac */
final class C1681ac implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f4907a;
    /* renamed from: b */
    final /* synthetic */ C1740d f4908b;
    /* renamed from: c */
    final /* synthetic */ Context f4909c;
    /* renamed from: d */
    final /* synthetic */ StatSpecifyReportedInfo f4910d;

    C1681ac(String str, C1740d c1740d, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f4907a = str;
        this.f4908b = c1740d;
        this.f4909c = context;
        this.f4910d = statSpecifyReportedInfo;
    }

    public final void run() {
        try {
            if (StatServiceImpl.m4631a(this.f4907a)) {
                StatServiceImpl.f4884q.error((Object) "The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
                return;
            }
            Long l = (Long) StatServiceImpl.f4872e.remove(this.f4908b);
            if (l != null) {
                C1735f c1739c = new C1739c(this.f4909c, StatServiceImpl.m4619a(this.f4909c, false, this.f4910d), this.f4908b.f5113a, this.f4910d);
                c1739c.mo7934b().f5115c = this.f4908b.f5115c;
                l = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
                c1739c.mo7933a(Long.valueOf(l.longValue() <= 0 ? 1 : l.longValue()).longValue());
                new C1700av(c1739c).mo7867a();
                return;
            }
            StatServiceImpl.f4884q.warn("No start time found for custom event: " + this.f4908b.toString() + ", lost trackCustomBeginKVEvent()?");
        } catch (Throwable th) {
            StatServiceImpl.f4884q.mo7900e(th);
            StatServiceImpl.m4629a(this.f4909c, th);
        }
    }
}
