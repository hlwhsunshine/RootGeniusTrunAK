package com.shuame.p075ad;

import android.widget.ImageView;

/* renamed from: com.shuame.ad.z */
final class C1123z implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f3010a;
    /* renamed from: b */
    final /* synthetic */ ImageView f3011b;
    /* renamed from: c */
    final /* synthetic */ C1121x f3012c;

    C1123z(C1121x c1121x, String str, ImageView imageView) {
        this.f3012c = c1121x;
        this.f3010a = str;
        this.f3011b = imageView;
    }

    public final void run() {
        C1121x.f3006f;
        if (!C1121x.m3259a(this.f3012c, this.f3010a, this.f3011b)) {
            C1121x.m3261b(this.f3012c, this.f3010a, this.f3011b);
        }
    }
}
