package com.baidu.mobad.nativevideo;

import android.content.Context;
import android.view.View;
import com.baidu.mobad.feeds.BaiduNative;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobad.feeds.XAdNativeResponse;
import com.baidu.mobad.nativevideo.BaiduVideoResponse.PrerollMaterialType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;

class XAdVideoResponse implements BaiduVideoResponse {
    /* renamed from: a */
    NativeResponse f245a;

    public XAdVideoResponse(NativeResponse nativeResponse) {
        this.f245a = nativeResponse;
    }

    public XAdVideoResponse(IXAdInstanceInfo iXAdInstanceInfo, BaiduNative baiduNative, IXAdFeedsRequestParameters iXAdFeedsRequestParameters, IXAdContainer iXAdContainer) {
        this.f245a = new XAdNativeResponse(iXAdInstanceInfo, baiduNative, iXAdFeedsRequestParameters, iXAdContainer);
    }

    public String getAdLogoUrl() {
        return this.f245a.getAdLogoUrl();
    }

    public String getBaiduLogoUrl() {
        return this.f245a.getBaiduLogoUrl();
    }

    public int getDuration() {
        return this.f245a.getDuration();
    }

    public String getImageUrl() {
        return this.f245a.getImageUrl();
    }

    public PrerollMaterialType getMaterialType() {
        PrerollMaterialType prerollMaterialType = PrerollMaterialType.NORMAL;
        switch (this.f245a.getMaterialType()) {
            case VIDEO:
                return PrerollMaterialType.VIDEO;
            case NORMAL:
                return this.f245a.getImageUrl().endsWith(".gif") ? PrerollMaterialType.GIF : prerollMaterialType;
            default:
                return prerollMaterialType;
        }
    }

    public String getVideoUrl() {
        return this.f245a.getVideoUrl();
    }

    public void handleClick(View view) {
        this.f245a.handleClick(view);
    }

    public void handleClick(View view, int i) {
        this.f245a.handleClick(view, i);
    }

    public boolean isDownloadApp() {
        return this.f245a.isDownloadApp();
    }

    public void onClickAd(Context context) {
        this.f245a.onClickAd(context);
    }

    public void onClose(Context context, int i) {
        this.f245a.onClose(context, i);
    }

    public void onComplete(Context context) {
        this.f245a.onComplete(context);
    }

    public void onError(Context context, int i, int i2) {
        this.f245a.onError(context, i, i2);
    }

    public void onFullScreen(Context context, int i) {
        this.f245a.onFullScreen(context, i);
    }

    public void onStart(Context context) {
        this.f245a.onStart(context);
    }

    public void recordImpression(View view) {
        this.f245a.recordImpression(view);
    }
}
