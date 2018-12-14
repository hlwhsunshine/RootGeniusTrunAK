package com.baidu.mobads;

import android.view.View;

/* renamed from: com.baidu.mobads.e */
class C0279e implements Runnable {
    /* renamed from: a */
    final /* synthetic */ View f507a;
    /* renamed from: b */
    final /* synthetic */ View f508b;
    /* renamed from: c */
    final /* synthetic */ AppActivity f509c;

    C0279e(AppActivity appActivity, View view, View view2) {
        this.f509c = appActivity;
        this.f507a = view;
        this.f508b = view2;
    }

    public void run() {
        this.f509c.m220b(this.f507a);
        this.f509c.m220b(this.f508b);
    }
}
