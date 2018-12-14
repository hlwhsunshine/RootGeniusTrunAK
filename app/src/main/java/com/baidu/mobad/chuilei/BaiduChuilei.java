package com.baidu.mobad.chuilei;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobad.feeds.BaiduNative;
import com.baidu.mobad.feeds.BaiduNative.BaiduNativeNetworkListener;
import com.baidu.mobad.feeds.NativeErrorCode;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobad.feeds.RequestParameters.Builder;
import com.baidu.mobads.production.p041b.C0382b;
import java.util.ArrayList;
import java.util.List;

public class BaiduChuilei implements BaiduNativeNetworkListener {
    /* renamed from: a */
    private C0382b f149a;
    /* renamed from: b */
    private BaiduChuileiNetworkListener f150b;
    /* renamed from: c */
    private BaiduNative f151c;

    public interface BaiduChuileiNetworkListener {
        void onChuileiFail(BaiduChuileiErrorCode baiduChuileiErrorCode);

        void onChuileiLoad(List<BaiduChuileiResponse> list);
    }

    public BaiduChuilei(Context context, String str, BaiduChuileiNetworkListener baiduChuileiNetworkListener) {
        this.f149a = new C0382b(context, str);
        this.f150b = baiduChuileiNetworkListener;
        this.f151c = new BaiduNative(context, str, this, this.f149a);
    }

    public static void setAppSid(Activity activity, String str) {
        BaiduNative.setAppSid(activity, str);
    }

    public void makeRequest(BaiduChuileiRequestParameters baiduChuileiRequestParameters) {
        RequestParameters requestParameters = baiduChuileiRequestParameters.getRequestParameters();
        if (requestParameters == null) {
            requestParameters = new Builder().build();
        }
        this.f151c.makeRequest(requestParameters);
    }

    public void onNativeFail(NativeErrorCode nativeErrorCode) {
        this.f150b.onChuileiFail(BaiduChuileiErrorCode.LOAD_AD_FAILED);
    }

    public void onNativeLoad(List<NativeResponse> list) {
        List arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                arrayList.add(new XAdChuileiResponse((NativeResponse) list.get(i2)));
                i = i2 + 1;
            } else {
                this.f150b.onChuileiLoad(arrayList);
                return;
            }
        }
    }
}
