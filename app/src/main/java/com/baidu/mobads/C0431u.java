package com.baidu.mobads;

import android.view.View;

/* renamed from: com.baidu.mobads.u */
class C0431u implements Runnable {
    /* renamed from: a */
    final /* synthetic */ View f984a;
    /* renamed from: b */
    final /* synthetic */ View f985b;
    /* renamed from: c */
    final /* synthetic */ AppActivity f986c;

    C0431u(AppActivity appActivity, View view, View view2) {
        this.f986c = appActivity;
        this.f984a = view;
        this.f985b = view2;
    }

    public void run() {
        this.f986c.m220b(this.f984a);
        this.f986c.m220b(this.f985b);
    }
}
