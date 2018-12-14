package com.tencent.stat;

import android.content.Context;

/* renamed from: com.tencent.stat.ag */
final class C1685ag implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f4918a;
    /* renamed from: b */
    final /* synthetic */ int f4919b;

    C1685ag(Context context, int i) {
        this.f4918a = context;
        this.f4919b = i;
    }

    public final void run() {
        try {
            StatServiceImpl.flushDataToDB(this.f4918a);
            C1706ba.m4673a(this.f4918a).mo7870a(this.f4919b);
        } catch (Throwable th) {
            StatServiceImpl.f4884q.mo7900e(th);
            StatServiceImpl.m4629a(this.f4918a, th);
        }
    }
}
