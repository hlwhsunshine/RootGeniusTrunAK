package com.shuame.mobile.module.autoboot.p085ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* renamed from: com.shuame.mobile.module.autoboot.ui.c */
final class C1172c implements AnimationListener {
    /* renamed from: a */
    final /* synthetic */ AutoBootManagerActivity f3119a;

    C1172c(AutoBootManagerActivity autoBootManagerActivity) {
        this.f3119a = autoBootManagerActivity;
    }

    public final void onAnimationEnd(Animation animation) {
        this.f3119a.f3094p = true;
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }
}
