package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.event.C1740d;

/* renamed from: com.tencent.stat.z */
final class C1768z implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f5185a;
    /* renamed from: b */
    final /* synthetic */ C1740d f5186b;
    /* renamed from: c */
    final /* synthetic */ Context f5187c;

    C1768z(String str, C1740d c1740d, Context context) {
        this.f5185a = str;
        this.f5186b = c1740d;
        this.f5187c = context;
    }

    public final void run() {
        try {
            if (StatServiceImpl.m4631a(this.f5185a)) {
                StatServiceImpl.f4884q.error((Object) "The event_id of StatService.trackCustomBeginEvent() can not be null or empty.");
                return;
            }
            if (StatConfig.isDebugEnable()) {
                StatServiceImpl.f4884q.mo7904i("add begin key:" + this.f5186b.toString());
            }
            if (StatServiceImpl.f4872e.containsKey(this.f5186b)) {
                StatServiceImpl.f4884q.error("Duplicate CustomEvent key: " + this.f5186b.toString() + ", trackCustomBeginEvent() repeated?");
            } else if (StatServiceImpl.f4872e.size() <= StatConfig.getMaxParallelTimmingEvents()) {
                StatServiceImpl.f4872e.put(this.f5186b, Long.valueOf(System.currentTimeMillis()));
            } else {
                StatServiceImpl.f4884q.error("The number of timedEvent exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
            }
        } catch (Throwable th) {
            StatServiceImpl.f4884q.mo7900e(th);
            StatServiceImpl.m4629a(this.f5187c, th);
        }
    }
}
