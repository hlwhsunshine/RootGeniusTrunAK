package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.event.C1735f;
import com.tencent.stat.event.C1739c;
import com.tencent.stat.event.C1740d;

/* renamed from: com.tencent.stat.aa */
final class C1679aa implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f4900a;
    /* renamed from: b */
    final /* synthetic */ C1740d f4901b;
    /* renamed from: c */
    final /* synthetic */ Context f4902c;
    /* renamed from: d */
    final /* synthetic */ StatSpecifyReportedInfo f4903d;

    C1679aa(String str, C1740d c1740d, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f4900a = str;
        this.f4901b = c1740d;
        this.f4902c = context;
        this.f4903d = statSpecifyReportedInfo;
    }

    public final void run() {
        try {
            if (StatServiceImpl.m4631a(this.f4900a)) {
                StatServiceImpl.f4884q.error((Object) "The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
                return;
            }
            Long l = (Long) StatServiceImpl.f4872e.remove(this.f4901b);
            if (l != null) {
                C1735f c1739c = new C1739c(this.f4902c, StatServiceImpl.m4619a(this.f4902c, false, this.f4903d), this.f4901b.f5113a, this.f4903d);
                c1739c.mo7934b().f5114b = this.f4901b.f5114b;
                l = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
                c1739c.mo7933a(Long.valueOf(l.longValue() == 0 ? 1 : l.longValue()).longValue());
                new C1700av(c1739c).mo7867a();
                return;
            }
            StatServiceImpl.f4884q.error("No start time found for custom event: " + this.f4901b.toString() + ", lost trackCustomBeginEvent()?");
        } catch (Throwable th) {
            StatServiceImpl.f4884q.mo7900e(th);
            StatServiceImpl.m4629a(this.f4902c, th);
        }
    }
}
