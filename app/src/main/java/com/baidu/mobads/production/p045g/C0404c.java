package com.baidu.mobads.production.p045g;

import android.view.ViewGroup;

/* renamed from: com.baidu.mobads.production.g.c */
class C0404c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0403b f930a;

    C0404c(C0403b c0403b) {
        this.f930a = c0403b;
    }

    public void run() {
        this.f930a.f927x.mo4921d("remote Interstitial.removeAd");
        this.f930a.f922B = false;
        try {
            this.f930a.f814e.removeAllViews();
            ViewGroup a = this.f930a.m847c(this.f930a.f814e.getContext());
            this.f930a.f924D.removeAllViews();
            a.removeView(this.f930a.f924D);
        } catch (Throwable e) {
            this.f930a.f927x.mo4923d("Interstitial.removeAd", e);
        }
    }
}
