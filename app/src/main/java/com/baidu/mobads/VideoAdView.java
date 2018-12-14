package com.baidu.mobads;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.production.p048i.C0413b;
import com.p070qq.p071e.comm.constants.ErrorCode.InitError;
import com.p070qq.p071e.comm.constants.ErrorCode.NetWorkError;

public class VideoAdView extends RelativeLayout {
    /* renamed from: a */
    private C0413b f371a;
    /* renamed from: b */
    private IOAdEventListener f372b = new C0253ak(this);
    /* renamed from: c */
    private VideoAdViewListener f373c;

    public enum VideoDuration {
        DURATION_15_SECONDS(15),
        DURATION_30_SECONDS(30),
        DURATION_45_SECONDS(45);
        
        /* renamed from: a */
        private int f367a;

        private VideoDuration(int i) {
            this.f367a = i;
        }

        protected final int getValue() {
            return this.f367a;
        }
    }

    public enum VideoSize {
        SIZE_16x9(320, 180),
        SIZE_4x3(NetWorkError.STUB_NETWORK_ERROR, InitError.INIT_AD_ERROR);
        
        /* renamed from: a */
        private int f369a;
        /* renamed from: b */
        private int f370b;

        private VideoSize(int i, int i2) {
            this.f369a = i;
            this.f370b = i2;
        }

        protected final int getHeight() {
            return this.f370b;
        }

        protected final int getWidth() {
            return this.f369a;
        }
    }

    public VideoAdView(Context context) {
        super(context);
    }

    public VideoAdView(Context context, String str) {
        super(context, null);
    }

    public static void setAppSid(Context context, String str) {
        AdView.setAppSid(context, str);
    }

    public void requestAd(VideoAdRequest videoAdRequest) {
        this.f371a = new C0413b(getContext(), "TODO");
        this.f371a.setActivity(getContext());
        this.f371a.setAdSlotBase(this);
        this.f371a.addEventListener(IXAdEvent.AD_CLICK_THRU, this.f372b);
        this.f371a.addEventListener(IXAdEvent.AD_LOADED, this.f372b);
        this.f371a.addEventListener(IXAdEvent.AD_STARTED, this.f372b);
        this.f371a.addEventListener(IXAdEvent.AD_STOPPED, this.f372b);
        this.f371a.addEventListener(IXAdEvent.AD_ERROR, this.f372b);
        this.f371a.request();
    }

    public void setListener(VideoAdViewListener videoAdViewListener) {
        this.f373c = videoAdViewListener;
    }

    public void startVideo() {
        this.f371a.start();
    }
}
