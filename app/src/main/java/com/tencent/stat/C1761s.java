package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.event.C1741e;
import com.tencent.stat.event.C1744i;

/* renamed from: com.tencent.stat.s */
final class C1761s implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f5170a;
    /* renamed from: b */
    final /* synthetic */ Throwable f5171b;

    C1761s(Context context, Throwable th) {
        this.f5170a = context;
        this.f5171b = th;
    }

    public final void run() {
        try {
            if (StatConfig.isEnableStatService()) {
                new C1700av(new C1741e(this.f5170a, StatServiceImpl.m4619a(this.f5170a, false, null), 99, this.f5171b, C1744i.f5123a)).mo7867a();
            }
        } catch (Throwable th) {
            StatServiceImpl.f4884q.mo7899e("reportSdkSelfException error: " + th);
        }
    }
}
