package com.shuame.rootgenius.common.p087ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.shuame.rootgenius.common.C1335e.C1328a;

/* renamed from: com.shuame.rootgenius.common.ui.LoadingView */
public class LoadingView extends ImageView {
    /* renamed from: a */
    private Animation f3810a;
    /* renamed from: b */
    private boolean f3811b;

    public LoadingView(Context context) {
        this(context, null);
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    public final void mo7087a() {
        if (!this.f3811b) {
            if (this.f3810a == null) {
                this.f3810a = AnimationUtils.loadAnimation(getContext(), C1328a.loading);
            }
            clearAnimation();
            startAnimation(this.f3810a);
            this.f3811b = true;
        }
    }

    /* renamed from: b */
    public final void mo7088b() {
        if (this.f3811b) {
            clearAnimation();
            this.f3811b = false;
        }
    }
}
