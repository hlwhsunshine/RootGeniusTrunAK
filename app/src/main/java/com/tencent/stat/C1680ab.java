package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.event.C1740d;

/* renamed from: com.tencent.stat.ab */
final class C1680ab implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f4904a;
    /* renamed from: b */
    final /* synthetic */ C1740d f4905b;
    /* renamed from: c */
    final /* synthetic */ Context f4906c;

    C1680ab(String str, C1740d c1740d, Context context) {
        this.f4904a = str;
        this.f4905b = c1740d;
        this.f4906c = context;
    }

    public final void run() {
        try {
            if (StatServiceImpl.m4631a(this.f4904a)) {
                StatServiceImpl.f4884q.error((Object) "The event_id of StatService.trackCustomBeginEvent() can not be null or empty.");
                return;
            }
            if (StatConfig.isDebugEnable()) {
                StatServiceImpl.f4884q.mo7904i("add begin key:" + this.f4905b);
            }
            if (StatServiceImpl.f4872e.containsKey(this.f4905b)) {
                StatServiceImpl.f4884q.warn("Duplicate CustomEvent key: " + this.f4905b.toString() + ", trackCustomBeginKVEvent() repeated?");
            } else if (StatServiceImpl.f4872e.size() <= StatConfig.getMaxParallelTimmingEvents()) {
                StatServiceImpl.f4872e.put(this.f4905b, Long.valueOf(System.currentTimeMillis()));
            } else {
                StatServiceImpl.f4884q.error("The number of timedEvent exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
            }
        } catch (Throwable th) {
            StatServiceImpl.f4884q.mo7900e(th);
            StatServiceImpl.m4629a(this.f4906c, th);
        }
    }
}
