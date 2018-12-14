package com.nineoldandroids.p055b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.nineoldandroids.p054a.C0916a.C0915a;

/* renamed from: com.nineoldandroids.b.e */
final class C0965e implements AnimatorListener {
    /* renamed from: a */
    final /* synthetic */ C0915a f2393a;
    /* renamed from: b */
    final /* synthetic */ C0964d f2394b;

    C0965e(C0964d c0964d, C0915a c0915a) {
        this.f2394b = c0964d;
        this.f2393a = c0915a;
    }

    public final void onAnimationCancel(Animator animator) {
        this.f2393a.mo6024c(null);
    }

    public final void onAnimationEnd(Animator animator) {
        this.f2393a.mo6023b(null);
    }

    public final void onAnimationRepeat(Animator animator) {
        this.f2393a.mo6025d(null);
    }

    public final void onAnimationStart(Animator animator) {
        this.f2393a.mo6022a(null);
    }
}
