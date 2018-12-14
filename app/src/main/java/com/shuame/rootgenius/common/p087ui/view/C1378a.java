package com.shuame.rootgenius.common.p087ui.view;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: com.shuame.rootgenius.common.ui.view.a */
public final class C1378a extends Animation {
    /* renamed from: a */
    private C1177a f3844a;

    /* renamed from: com.shuame.rootgenius.common.ui.view.a$a */
    public interface C1177a {
        /* renamed from: a */
        void mo6801a(float f);
    }

    public C1378a(C1177a c1177a) {
        this.f3844a = c1177a;
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        if (this.f3844a != null) {
            this.f3844a.mo6801a(f);
        }
    }
}
