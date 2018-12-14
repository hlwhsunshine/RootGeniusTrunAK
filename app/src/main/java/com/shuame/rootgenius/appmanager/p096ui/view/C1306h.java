package com.shuame.rootgenius.appmanager.p096ui.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.shuame.rootgenius.appmanager.p091b.C1259d;

/* renamed from: com.shuame.rootgenius.appmanager.ui.view.h */
final class C1306h implements AnimationListener {
    /* renamed from: a */
    final /* synthetic */ C1305g f3559a;

    C1306h(C1305g c1305g) {
        this.f3559a = c1305g;
    }

    public final void onAnimationEnd(Animation animation) {
        C1259d.f3364f = Boolean.valueOf(false);
        C1259d.f3367i = Boolean.valueOf(false);
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
