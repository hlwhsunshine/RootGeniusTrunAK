package com.baidu.mobads.production;

import android.content.Context;

/* renamed from: com.baidu.mobads.production.f */
class C0402f implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f919a;
    /* renamed from: b */
    final /* synthetic */ C0375a f920b;

    C0402f(C0375a c0375a, Context context) {
        this.f920b = c0375a;
        this.f919a = context;
    }

    public void run() {
        new Thread(new C0406g(this)).start();
    }
}
