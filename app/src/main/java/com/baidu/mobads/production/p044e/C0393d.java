package com.baidu.mobads.production.p044e;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;

/* renamed from: com.baidu.mobads.production.e.d */
class C0393d implements Runnable {
    /* renamed from: a */
    final /* synthetic */ LayoutParams f900a;
    /* renamed from: b */
    final /* synthetic */ View f901b;
    /* renamed from: c */
    final /* synthetic */ C0392c f902c;

    C0393d(C0392c c0392c, LayoutParams layoutParams, View view) {
        this.f902c = c0392c;
        this.f900a = layoutParams;
        this.f901b = view;
    }

    public void run() {
        this.f900a.addRule(11);
        this.f900a.rightMargin = 0;
        this.f900a.topMargin = this.f901b.getTop();
        this.f902c.f896g.setLayoutParams(this.f900a);
    }
}
