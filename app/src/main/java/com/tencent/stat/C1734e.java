package com.tencent.stat;

import android.content.Context;

/* renamed from: com.tencent.stat.e */
final class C1734e implements StatActionListener {
    /* renamed from: a */
    final /* synthetic */ Context f5090a;

    C1734e(Context context) {
        this.f5090a = context;
    }

    public final void onBecameBackground() {
        StatService.commitEvents(this.f5090a, -1);
    }

    public final void onBecameForeground() {
    }
}
