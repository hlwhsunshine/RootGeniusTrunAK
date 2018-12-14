package com.p070qq.p071e.ads.banner;

import com.p070qq.p071e.comm.util.GDTLogger;

/* renamed from: com.qq.e.ads.banner.AbstractBannerADListener */
public abstract class AbstractBannerADListener implements BannerADListener {
    public void onADClicked() {
        GDTLogger.m3133i("On BannerAD Clicked");
    }

    public void onADCloseOverlay() {
        GDTLogger.m3133i("On BannerAD AdCloseOverlay");
    }

    public void onADClosed() {
        GDTLogger.m3133i("On BannerAD Closed");
    }

    public void onADExposure() {
        GDTLogger.m3133i("On BannerAD Exposured");
    }

    public void onADLeftApplication() {
        GDTLogger.m3133i("On BannerAD AdLeftApplication");
    }

    public void onADOpenOverlay() {
        GDTLogger.m3133i("On BannerAD AdOpenOverlay");
    }
}
