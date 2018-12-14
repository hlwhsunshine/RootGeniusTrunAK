package com.shuame.rootgenius.sdk;

import android.content.Context;

/* renamed from: com.shuame.rootgenius.sdk.f */
final class C1471f implements Runnable {
    /* renamed from: a */
    private /* synthetic */ Context f4060a;
    /* renamed from: b */
    private /* synthetic */ C1469d f4061b;

    C1471f(C1469d c1469d, Context context) {
        this.f4061b = c1469d;
        this.f4060a = context;
    }

    public final void run() {
        this.f4061b.m4075c(this.f4060a);
    }
}
