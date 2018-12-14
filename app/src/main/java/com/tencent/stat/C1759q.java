package com.tencent.stat;

import android.content.Context;

/* renamed from: com.tencent.stat.q */
final class C1759q implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f5166a;

    C1759q(Context context) {
        this.f5166a = context;
    }

    public final void run() {
        StatServiceImpl.flushDataToDB(this.f5166a);
    }
}
