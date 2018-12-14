package com.baidu.mobad.nativevideo;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobad.feeds.BaiduNative;
import com.baidu.mobad.feeds.BaiduNative.BaiduNativeNetworkListener;
import com.baidu.mobad.feeds.NativeErrorCode;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.production.p042d.C0381a;
import com.baidu.mobads.production.p049j.C0415a;
import java.util.ArrayList;
import java.util.List;

public class BaiduVideoNative implements BaiduNativeNetworkListener {
    /* renamed from: a */
    private C0381a f240a;
    /* renamed from: b */
    private BaiduVideoNetworkListener f241b;
    /* renamed from: c */
    private BaiduNative f242c;

    public interface BaiduVideoNetworkListener {
        void onAdFail(NativeErrorCode nativeErrorCode);

        void onAdLoad(List<BaiduVideoResponse> list);
    }

    public BaiduVideoNative(Context context, String str, BaiduVideoNetworkListener baiduVideoNetworkListener) {
        this.f240a = new C0415a(context, str);
        this.f241b = baiduVideoNetworkListener;
        this.f242c = new BaiduNative(context, str, this, this.f240a);
    }

    public static void setAppSid(Activity activity, String str) {
        BaiduNative.setAppSid(activity, str);
    }

    public void makeRequest(RequestParameters requestParameters) {
        this.f242c.makeRequest(requestParameters);
    }

    public void onNativeFail(NativeErrorCode nativeErrorCode) {
        this.f241b.onAdFail(nativeErrorCode);
    }

    public void onNativeLoad(List<NativeResponse> list) {
        List arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                arrayList.add(new XAdVideoResponse((NativeResponse) list.get(i2)));
                i = i2 + 1;
            } else {
                this.f241b.onAdLoad(arrayList);
                return;
            }
        }
    }
}
