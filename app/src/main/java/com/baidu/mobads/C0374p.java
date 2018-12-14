package com.baidu.mobads;

import android.view.ViewTreeObserver.OnPreDrawListener;

/* renamed from: com.baidu.mobads.p */
class C0374p implements OnPreDrawListener {
    /* renamed from: a */
    final /* synthetic */ AppActivity f809a;

    C0374p(AppActivity appActivity) {
        this.f809a = appActivity;
    }

    public boolean onPreDraw() {
        this.f809a.f170d.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f809a.m212a(this.f809a.f170d);
        return true;
    }
}
