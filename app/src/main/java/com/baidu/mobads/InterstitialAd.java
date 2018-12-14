package com.baidu.mobads;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.production.p045g.C0395a;
import com.baidu.mobads.production.p045g.C0403b;
import com.baidu.mobads.production.p046f.C0397b;

public class InterstitialAd {
    public static final String TAG = InterstitialAd.class.getSimpleName();
    /* renamed from: a */
    IOAdEventListener f351a;
    /* renamed from: b */
    private AdSize f352b;
    /* renamed from: c */
    private C0395a f353c;
    /* renamed from: d */
    private final IXAdLogger f354d;
    /* renamed from: e */
    private InterstitialAdListener f355e;

    public InterstitialAd(Context context, AdSize adSize, String str) {
        this.f354d = C0338m.m569a().mo5033f();
        this.f355e = new C0441y(this);
        this.f351a = new C0442z(this);
        RelativeLayout c0259ao = new C0259ao(context);
        c0259ao.mo4382a(new C0243ab(this));
        this.f352b = adSize;
        if (m277a()) {
            this.f353c = new C0403b(context, c0259ao, Boolean.valueOf(true), str);
        } else if (m279b()) {
            this.f353c = new C0397b(context, c0259ao, Boolean.valueOf(true), adSize, str);
        }
        this.f353c.addEventListener(IXAdEvent.AD_LOADED, this.f351a);
        this.f353c.addEventListener(IXAdEvent.AD_ERROR, this.f351a);
        this.f353c.addEventListener(IXAdEvent.AD_STOPPED, this.f351a);
        this.f353c.addEventListener(IXAdEvent.AD_USER_CLOSE, this.f351a);
        this.f353c.addEventListener(IXAdEvent.AD_STARTED, this.f351a);
        this.f353c.addEventListener("AdUserClick", this.f351a);
        this.f353c.request();
    }

    public InterstitialAd(Context context, String str) {
        this(context, AdSize.InterstitialGame, str);
    }

    /* renamed from: a */
    private boolean m277a() {
        return this.f352b.getValue() <= AdSize.InterstitialOther.getValue() && this.f352b.getValue() >= AdSize.InterstitialGame.getValue();
    }

    /* renamed from: b */
    private boolean m279b() {
        return this.f352b.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && this.f352b.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue();
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public static void setAppSid(Context context, String str) {
        C0338m.m569a().mo5040m().setAppId(str);
    }

    public void destroy() {
        this.f353c.mo5212l();
    }

    public boolean isAdReady() {
        return this.f353c.mo5214r();
    }

    public void loadAd() {
        this.f353c.mo5213m();
    }

    public void loadAdForVideoApp(int i, int i2) {
        this.f353c.mo5207a(i, i2);
    }

    public void setListener(InterstitialAdListener interstitialAdListener) {
        if (interstitialAdListener == null) {
            throw new IllegalArgumentException();
        }
        this.f355e = interstitialAdListener;
    }

    public void showAd(Activity activity) {
        this.f353c.mo5208a(activity);
    }

    public void showAdInParentForVideoApp(Activity activity, RelativeLayout relativeLayout) {
        if (activity == null || relativeLayout == null) {
            throw new IllegalArgumentException();
        }
        this.f353c.mo5209a(activity, relativeLayout);
    }
}
