package com.baidu.mobads.production.p046f;

import android.graphics.Color;

/* renamed from: com.baidu.mobads.production.f.c */
class C0398c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0397b f915a;

    C0398c(C0397b c0397b) {
        this.f915a = c0397b;
    }

    public void run() {
        if (this.f915a.mo5217o()) {
            this.f915a.f814e.setBackgroundColor(Color.argb(51, 0, 0, 0));
        }
        if (this.f915a.f817h.getAdView() != null) {
            this.f915a.f817h.getAdView().setVisibility(0);
        }
        if (this.f915a.m820s()) {
            this.f915a.f912x.mo4921d("add countdown view");
            this.f915a.m822u();
            this.f915a.f814e.addView(this.f915a.m821t(), this.f915a.m823v());
        }
    }
}
