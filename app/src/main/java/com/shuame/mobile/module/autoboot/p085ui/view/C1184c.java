package com.shuame.mobile.module.autoboot.p085ui.view;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout.LayoutParams;

/* renamed from: com.shuame.mobile.module.autoboot.ui.view.c */
public final class C1184c extends Animation {
    /* renamed from: a */
    private float f3167a;
    /* renamed from: b */
    private int f3168b;
    /* renamed from: c */
    private ViewGroup f3169c;
    /* renamed from: d */
    private LayoutParams f3170d = new LayoutParams(-1, -2);

    public C1184c(ViewGroup viewGroup, int i) {
        this.f3169c = viewGroup;
        this.f3167a = (float) viewGroup.getTop();
        this.f3168b = i;
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        this.f3170d.topMargin = (int) (this.f3167a - ((this.f3167a - ((float) this.f3168b)) * f));
        this.f3169c.setLayoutParams(this.f3170d);
    }
}
