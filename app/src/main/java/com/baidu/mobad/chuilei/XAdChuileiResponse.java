package com.baidu.mobad.chuilei;

import android.view.View;
import com.baidu.mobad.feeds.BaiduNative;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobad.feeds.XAdNativeResponse;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;

class XAdChuileiResponse implements BaiduChuileiResponse {
    /* renamed from: a */
    NativeResponse f154a;

    public XAdChuileiResponse(NativeResponse nativeResponse) {
        this.f154a = nativeResponse;
    }

    public XAdChuileiResponse(IXAdInstanceInfo iXAdInstanceInfo, BaiduNative baiduNative, IXAdFeedsRequestParameters iXAdFeedsRequestParameters, IXAdContainer iXAdContainer) {
        this.f154a = new XAdNativeResponse(iXAdInstanceInfo, baiduNative, iXAdFeedsRequestParameters, iXAdContainer);
    }

    public String getImageUrl() {
        return this.f154a.getImageUrl();
    }

    public String getTitle() {
        return this.f154a.getTitle();
    }

    public void handleClick(View view) {
        this.f154a.handleClick(view);
    }

    public void handleClick(View view, int i) {
        this.f154a.handleClick(view, i);
    }

    public void recordImpression(View view) {
        this.f154a.recordImpression(view);
    }
}
