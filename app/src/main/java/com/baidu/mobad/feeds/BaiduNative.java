package com.baidu.mobad.feeds;

import android.content.Context;
import android.view.View;
import com.baidu.mobad.feeds.RequestParameters.Builder;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.p034h.C0318q;
import com.baidu.mobads.production.p042d.C0381a;
import java.util.List;

public class BaiduNative {
    /* renamed from: a */
    private final Context f209a;
    /* renamed from: b */
    private final String f210b;
    /* renamed from: c */
    private C0381a f211c;
    /* renamed from: d */
    private BaiduNativeNetworkListener f212d;
    /* renamed from: e */
    private BaiduNativeEventListener f213e;

    public interface BaiduNativeNetworkListener {
        void onNativeFail(NativeErrorCode nativeErrorCode);

        void onNativeLoad(List<NativeResponse> list);
    }

    public interface BaiduNativeEventListener {
        void onClicked();

        void onImpressionSended();
    }

    class CustomIOAdEventListener implements IOAdEventListener {
        /* renamed from: b */
        private IXAdFeedsRequestParameters f208b;

        /* renamed from: com.baidu.mobad.feeds.BaiduNative$CustomIOAdEventListener$2 */
        class C02252 implements Runnable {
            C02252() {
            }

            public void run() {
                BaiduNative.this.f212d.onNativeFail(NativeErrorCode.LOAD_AD_FAILED);
            }
        }

        public CustomIOAdEventListener(IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
            this.f208b = iXAdFeedsRequestParameters;
        }

        /* JADX WARNING: Removed duplicated region for block: B:35:0x0097 A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x007c  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x007c  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0097 A:{SYNTHETIC} */
        public void run(com.baidu.mobads.openad.interfaces.event.IOAdEvent r13) {
            /*
            r12 = this;
            r4 = 1;
            r2 = 0;
            r0 = "AdStarted";
            r1 = r13.getType();
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x00c5;
        L_0x000e:
            r0 = com.baidu.mobad.feeds.BaiduNative.this;
            r0 = r0.f211c;
            r0.removeAllListeners();
            r0 = com.baidu.mobad.feeds.BaiduNative.this;
            r0 = r0.f212d;
            if (r0 == 0) goto L_0x00c5;
        L_0x001f:
            r6 = new java.util.ArrayList;
            r6.<init>();
            r7 = new java.util.HashSet;
            r7.<init>();
            r0 = com.baidu.mobads.p021j.C0338m.m569a();
            r8 = r0.mo5043p();
            r1 = r2;
        L_0x0032:
            r0 = com.baidu.mobad.feeds.BaiduNative.this;
            r0 = r0.f211c;
            r0 = r0.mo5197m();
            r0 = r0.size();
            if (r1 >= r0) goto L_0x00b5;
        L_0x0042:
            r0 = com.baidu.mobad.feeds.BaiduNative.this;
            r0 = r0.f211c;
            r0 = r0.mo5197m();
            r0 = r0.get(r1);
            r0 = (com.baidu.mobads.interfaces.IXAdInstanceInfo) r0;
            r3 = r0.getAppPackageName();
            r5 = r0.getActionType();
            r9 = r8.getActTypeDownload();
            if (r5 != r9) goto L_0x00fc;
        L_0x0060:
            if (r3 == 0) goto L_0x0078;
        L_0x0062:
            r5 = "";
            r5 = r3.equals(r5);
            if (r5 != 0) goto L_0x0078;
        L_0x006a:
            r5 = "null";
            r5 = r3.equals(r5);
            if (r5 != 0) goto L_0x0078;
        L_0x0072:
            r5 = r7.contains(r3);
            if (r5 == 0) goto L_0x009b;
        L_0x0078:
            r3 = r2;
            r5 = r4;
        L_0x007a:
            if (r5 != 0) goto L_0x0097;
        L_0x007c:
            r5 = new com.baidu.mobad.feeds.XAdNativeResponse;
            r9 = com.baidu.mobad.feeds.BaiduNative.this;
            r10 = r12.f208b;
            r11 = com.baidu.mobad.feeds.BaiduNative.this;
            r11 = r11.f211c;
            r11 = r11.getCurrentXAdContainer();
            r5.<init>(r0, r9, r10, r11);
            if (r3 != r4) goto L_0x0094;
        L_0x0091:
            r5.setIsDownloadApp(r2);
        L_0x0094:
            r6.add(r5);
        L_0x0097:
            r0 = r1 + 1;
            r1 = r0;
            goto L_0x0032;
        L_0x009b:
            r7.add(r3);
            r5 = com.baidu.mobads.p021j.C0338m.m569a();
            r5 = r5.mo5039l();
            r9 = com.baidu.mobad.feeds.BaiduNative.this;
            r9 = r9.f209a;
            r3 = r5.isInstalled(r9, r3);
            if (r3 == 0) goto L_0x00fc;
        L_0x00b2:
            r3 = r4;
            r5 = r2;
            goto L_0x007a;
        L_0x00b5:
            r0 = com.baidu.mobads.p021j.C0338m.m569a();
            r0 = r0.mo5040m();
            r1 = new com.baidu.mobad.feeds.BaiduNative$CustomIOAdEventListener$1;
            r1.<init>(r6);
            r0.mo5017a(r1);
        L_0x00c5:
            r0 = "AdError";
            r1 = r13.getType();
            r0 = r0.equals(r1);
            if (r0 == 0) goto L_0x00fb;
        L_0x00d1:
            r0 = com.baidu.mobad.feeds.BaiduNative.this;
            r0 = r0.f211c;
            r0.removeAllListeners();
            r0 = r13.getData();
            r1 = "message";
            r0.get(r1);
            r0 = com.baidu.mobad.feeds.BaiduNative.this;
            r0 = r0.f212d;
            if (r0 == 0) goto L_0x00fb;
        L_0x00eb:
            r0 = com.baidu.mobads.p021j.C0338m.m569a();
            r0 = r0.mo5040m();
            r1 = new com.baidu.mobad.feeds.BaiduNative$CustomIOAdEventListener$2;
            r1.<init>();
            r0.mo5017a(r1);
        L_0x00fb:
            return;
        L_0x00fc:
            r3 = r2;
            r5 = r2;
            goto L_0x007a;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobad.feeds.BaiduNative.CustomIOAdEventListener.run(com.baidu.mobads.openad.interfaces.event.IOAdEvent):void");
        }
    }

    public BaiduNative(Context context, String str, BaiduNativeNetworkListener baiduNativeNetworkListener) {
        this(context, str, baiduNativeNetworkListener, new C0381a(context, str));
    }

    public BaiduNative(Context context, String str, BaiduNativeNetworkListener baiduNativeNetworkListener, C0381a c0381a) {
        this.f209a = context;
        C0338m.m569a().mo5026a(context.getApplicationContext());
        this.f210b = str;
        this.f212d = baiduNativeNetworkListener;
        C0318q.m476a(context).mo4523a();
        this.f211c = c0381a;
    }

    public static void setAppSid(Context context, String str) {
        C0338m.m569a().mo5040m().setAppId(str);
    }

    public void destroy() {
    }

    protected void handleClick(View view, IXAdInstanceInfo iXAdInstanceInfo, int i, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.f211c.mo5188a(view, iXAdInstanceInfo, i, iXAdFeedsRequestParameters);
    }

    protected void handleClick(View view, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.f211c.mo5194b(view, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected void handleOnClickAd(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.f211c.mo5196d(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected void handleOnClose(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.f211c.mo5187a(context, i, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected void handleOnComplete(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.f211c.mo5195c(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected void handleOnError(Context context, int i, int i2, IXAdInstanceInfo iXAdInstanceInfo) {
        this.f211c.mo5186a(context, i, i2, iXAdInstanceInfo);
    }

    protected void handleOnFullScreen(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.f211c.mo5192b(context, i, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected void handleOnStart(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.f211c.mo5193b(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    protected boolean isAdAvailable(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        return this.f211c.mo5191a(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    public void makeRequest() {
        makeRequest(null);
    }

    public void makeRequest(RequestParameters requestParameters) {
        Object requestParameters2;
        if (requestParameters2 == null) {
            requestParameters2 = new Builder().build();
        }
        requestParameters2.mPlacementId = this.f210b;
        IOAdEventListener customIOAdEventListener = new CustomIOAdEventListener(requestParameters2);
        this.f211c.addEventListener(IXAdEvent.AD_STARTED, customIOAdEventListener);
        this.f211c.addEventListener(IXAdEvent.AD_ERROR, customIOAdEventListener);
        this.f211c.mo5190a(requestParameters2);
        this.f211c.request();
    }

    protected void recordImpression(View view, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        this.f211c.mo5189a(view, iXAdInstanceInfo, iXAdFeedsRequestParameters);
    }

    @Deprecated
    public void setNativeEventListener(BaiduNativeEventListener baiduNativeEventListener) {
        this.f213e = baiduNativeEventListener;
    }
}
