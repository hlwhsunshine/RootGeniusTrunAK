package com.shuame.p075ad;

import android.view.ViewGroup;
import com.p070qq.p071e.ads.splash.SplashADListener;

/* renamed from: com.shuame.ad.t */
final class C1118t implements SplashADListener {
    /* renamed from: a */
    final /* synthetic */ C1117s f3004a;

    C1118t(C1117s c1117s) {
        this.f3004a = c1117s;
    }

    public final void onADClicked() {
        if (this.f3004a.f2966a != null) {
            this.f3004a.f2966a.mo6684b(this.f3004a);
        }
    }

    public final void onADDismissed() {
        if (this.f3004a.f2966a != null) {
            this.f3004a.f2966a.mo6686d(this.f3004a);
        }
    }

    public final void onADPresent() {
        if (this.f3004a.f2966a != null) {
            this.f3004a.f2966a.mo6682a(this.f3004a);
        }
        ViewGroup viewGroup = (ViewGroup) this.f3004a.f3001i.getChildAt(0);
        if (viewGroup.getChildCount() >= 2) {
            viewGroup.getChildAt(1).setVisibility(8);
        }
    }

    public final void onNoAD(int i) {
        C1117s.f2998g;
        if (this.f3004a.f2966a != null) {
            this.f3004a.f2966a.mo6683a(this.f3004a, String.valueOf(i));
        }
    }
}
