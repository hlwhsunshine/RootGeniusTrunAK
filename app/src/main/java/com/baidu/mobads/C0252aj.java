package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyEvent;
import com.baidu.mobads.C0259ao.C0242a;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.production.p047h.C0407a;

/* renamed from: com.baidu.mobads.aj */
class C0252aj implements C0242a {
    /* renamed from: a */
    final /* synthetic */ Context f408a;
    /* renamed from: b */
    final /* synthetic */ C0259ao f409b;
    /* renamed from: c */
    final /* synthetic */ String f410c;
    /* renamed from: d */
    final /* synthetic */ boolean f411d;
    /* renamed from: e */
    final /* synthetic */ SplashAd f412e;

    C0252aj(SplashAd splashAd, Context context, C0259ao c0259ao, String str, boolean z) {
        this.f412e = splashAd;
        this.f408a = context;
        this.f409b = c0259ao;
        this.f410c = str;
        this.f411d = z;
    }

    @SuppressLint({"MissingSuperCall"})
    /* renamed from: a */
    public void mo4248a() {
        if (this.f412e.f356a != null) {
            this.f412e.f356a.mo5166k();
        }
    }

    /* renamed from: a */
    public void mo4249a(int i) {
        if (this.f412e.f356a != null) {
            this.f412e.f356a.mo5138a(i);
        }
    }

    /* renamed from: a */
    public void mo4250a(int i, int i2) {
        if (this.f412e.f356a == null) {
            float screenDensity = C0338m.m569a().mo5040m().getScreenDensity(this.f408a);
            if (((float) i) < 200.0f * screenDensity || ((float) i2) < screenDensity * 150.0f) {
                C0338m.m569a().mo5033f().mo4926e(C0338m.m569a().mo5044q().genCompleteErrorMessage(XAdErrorCode.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
                this.f412e.f358c.onAdDismissed();
                return;
            }
            this.f412e.f356a = new C0407a(this.f408a, this.f409b, this.f410c, this.f411d, i, i2);
            this.f412e.f356a.addEventListener("AdUserClick", this.f412e.f359d);
            this.f412e.f356a.addEventListener(IXAdEvent.AD_LOADED, this.f412e.f359d);
            this.f412e.f356a.addEventListener(IXAdEvent.AD_STARTED, this.f412e.f359d);
            this.f412e.f356a.addEventListener(IXAdEvent.AD_STOPPED, this.f412e.f359d);
            this.f412e.f356a.addEventListener(IXAdEvent.AD_ERROR, this.f412e.f359d);
            this.f412e.f356a.request();
        }
    }

    /* renamed from: a */
    public void mo4251a(boolean z) {
        if (this.f412e.f356a != null) {
            this.f412e.f356a.mo5147a(z);
        }
    }

    /* renamed from: a */
    public boolean mo4252a(int i, KeyEvent keyEvent) {
        return false;
    }

    /* renamed from: b */
    public void mo4253b() {
        if (this.f412e.f356a != null) {
            this.f412e.f356a.mo5165j();
        }
    }
}
