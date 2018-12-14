package com.shuame.p075ad;

import com.p070qq.p071e.ads.banner.BannerADListener;

/* renamed from: com.shuame.ad.u */
final class C1119u implements BannerADListener {
    /* renamed from: a */
    final /* synthetic */ C1117s f3005a;

    C1119u(C1117s c1117s) {
        this.f3005a = c1117s;
    }

    public final void onADClicked() {
        if (this.f3005a.f2966a != null) {
            this.f3005a.f2966a.mo6684b(this.f3005a);
        }
    }

    public final void onADCloseOverlay() {
    }

    public final void onADClosed() {
        if (this.f3005a.f2966a != null) {
            this.f3005a.f2966a.mo6685c(this.f3005a);
        }
    }

    public final void onADExposure() {
    }

    public final void onADLeftApplication() {
    }

    public final void onADOpenOverlay() {
    }

    public final void onADReceiv() {
        if (this.f3005a.f2966a != null) {
            this.f3005a.f2966a.mo6682a(this.f3005a);
        }
    }

    public final void onNoAD(int i) {
        if (this.f3005a.f2966a != null) {
            this.f3005a.f2966a.mo6683a(this.f3005a, String.valueOf(i));
        }
    }
}
