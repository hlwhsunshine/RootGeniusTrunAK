package com.shuame.rootgenius.appmanager.p096ui.view;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import com.shuame.rootgenius.p089a.C1248a.C1245c;

/* renamed from: com.shuame.rootgenius.appmanager.ui.view.g */
public final class C1305g {
    /* renamed from: a */
    private View f3557a;
    /* renamed from: b */
    private View f3558b;

    public C1305g(String str, View view) {
        View findViewWithTag = view.findViewWithTag(str);
        this.f3557a = findViewWithTag.findViewById(C1245c.btn_uninstall);
        this.f3558b = findViewWithTag.findViewById(C1245c.btn_uninstall_confirm);
    }

    /* renamed from: a */
    public final void mo6970a() {
        this.f3558b.setVisibility(0);
        Animation animationSet = new AnimationSet(true);
        Animation translateAnimation = new TranslateAnimation(0.0f, (float) (this.f3557a.getWidth() / 2), 0.0f, 0.0f);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        translateAnimation.setDuration(100);
        Animation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
        alphaAnimation.setDuration(100);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setFillAfter(false);
        animationSet.setFillEnabled(false);
        this.f3557a.startAnimation(animationSet);
        animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, (float) (this.f3557a.getWidth() / 2), 0.0f, 0.0f);
        translateAnimation2.setInterpolator(new AccelerateInterpolator());
        translateAnimation2.setDuration(100);
        translateAnimation = new AlphaAnimation(0.0f, 1.0f);
        translateAnimation.setDuration(200);
        animationSet.addAnimation(translateAnimation);
        animationSet.setFillAfter(false);
        animationSet.setFillEnabled(false);
        this.f3558b.startAnimation(animationSet);
        translateAnimation.setAnimationListener(new C1306h(this));
        this.f3557a.setVisibility(8);
    }
}
