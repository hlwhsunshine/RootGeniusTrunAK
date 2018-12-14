package com.baidu.mobads.production.p046f;

import android.view.ViewGroup;

/* renamed from: com.baidu.mobads.production.f.d */
class C0399d implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0397b f916a;

    C0399d(C0397b c0397b) {
        this.f916a = c0397b;
    }

    public void run() {
        this.f916a.f912x.mo4921d("remote Interstitial.removeAd");
        try {
            if (this.f916a.f814e.getParent() != null) {
                ((ViewGroup) this.f916a.f814e.getParent()).removeView(this.f916a.f814e);
            }
            this.f916a.f814e.removeAllViews();
        } catch (Throwable e) {
            this.f916a.f912x.mo4923d("Interstitial.removeAd", e);
        }
    }
}
