package com.baidu.mobads;

import android.view.ViewTreeObserver.OnPreDrawListener;

/* renamed from: com.baidu.mobads.r */
class C0428r implements OnPreDrawListener {
    /* renamed from: a */
    final /* synthetic */ AppActivity f981a;

    C0428r(AppActivity appActivity) {
        this.f981a = appActivity;
    }

    public boolean onPreDraw() {
        this.f981a.mBottomView.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f981a.runBottomViewEnterAnimation(this.f981a.f161C, this.f981a.mBottomView);
        return true;
    }
}
