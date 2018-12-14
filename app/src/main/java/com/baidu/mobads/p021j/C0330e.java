package com.baidu.mobads.p021j;

import android.content.Context;
import android.content.Intent;

/* renamed from: com.baidu.mobads.j.e */
class C0330e implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f666a;
    /* renamed from: b */
    final /* synthetic */ Intent f667b;
    /* renamed from: c */
    final /* synthetic */ C0329d f668c;

    C0330e(C0329d c0329d, Context context, Intent intent) {
        this.f668c = c0329d;
        this.f666a = context;
        this.f667b = intent;
    }

    public void run() {
        this.f666a.startActivity(this.f667b);
    }
}
