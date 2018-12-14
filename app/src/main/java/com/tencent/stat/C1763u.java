package com.tencent.stat;

import android.content.Context;

/* renamed from: com.tencent.stat.u */
final class C1763u implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f5175a;

    C1763u(Context context) {
        this.f5175a = context;
    }

    public final void run() {
        if (this.f5175a == null) {
            StatServiceImpl.f4884q.error((Object) "The Context of StatService.reportNativeCrash() can not be null!");
            return;
        }
        try {
            new Thread(new C1698at(this.f5175a), "NativeCrashRepoter").start();
        } catch (Throwable th) {
            StatServiceImpl.f4884q.mo7900e(th);
            StatServiceImpl.m4629a(this.f5175a, th);
        }
    }
}
