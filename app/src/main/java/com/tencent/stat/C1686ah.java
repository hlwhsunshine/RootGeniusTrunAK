package com.tencent.stat;

import android.content.Context;

/* renamed from: com.tencent.stat.ah */
final class C1686ah implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f4920a;

    C1686ah(Context context) {
        this.f4920a = context;
    }

    public final void run() {
        try {
            new Thread(new C1699au(this.f4920a, null, null), "NetworkMonitorTask").start();
        } catch (Throwable th) {
            StatServiceImpl.f4884q.mo7900e(th);
            StatServiceImpl.m4629a(this.f4920a, th);
        }
    }
}
