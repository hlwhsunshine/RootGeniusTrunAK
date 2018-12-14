package com.p070qq.p071e.ads.interstitial;

import com.p070qq.p071e.comm.util.GDTLogger;

/* renamed from: com.qq.e.ads.interstitial.AbstractInterstitialADListener */
public abstract class AbstractInterstitialADListener implements InterstitialADListener {
    public void onADClicked() {
        GDTLogger.m3133i("ON InterstitialAD Clicked");
    }

    public void onADClosed() {
        GDTLogger.m3133i("ON InterstitialAD Closed");
    }

    public void onADExposure() {
        GDTLogger.m3133i("ON InterstitialAD Exposure");
    }

    public void onADLeftApplication() {
        GDTLogger.m3133i("ON InterstitialAD LeftApplication");
    }

    public void onADOpened() {
        GDTLogger.m3133i("ON InterstitialAD Opened");
    }
}
