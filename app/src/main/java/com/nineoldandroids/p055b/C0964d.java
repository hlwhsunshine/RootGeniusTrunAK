package com.nineoldandroids.p055b;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.nineoldandroids.p054a.C0916a.C0915a;
import java.lang.ref.WeakReference;

/* renamed from: com.nineoldandroids.b.d */
final class C0964d extends C0958a {
    /* renamed from: a */
    private final WeakReference<ViewPropertyAnimator> f2392a;

    C0964d(View view) {
        this.f2392a = new WeakReference(view.animate());
    }

    /* renamed from: a */
    public final C0958a mo6112a() {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.f2392a.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.alpha(1.0f);
        }
        return this;
    }

    /* renamed from: a */
    public final C0958a mo6113a(float f) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.f2392a.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.translationX(f);
        }
        return this;
    }

    /* renamed from: a */
    public final C0958a mo6114a(long j) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.f2392a.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setDuration(j);
        }
        return this;
    }

    /* renamed from: a */
    public final C0958a mo6115a(C0915a c0915a) {
        ViewPropertyAnimator viewPropertyAnimator = (ViewPropertyAnimator) this.f2392a.get();
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.setListener(new C0965e(this, c0915a));
        }
        return this;
    }
}
