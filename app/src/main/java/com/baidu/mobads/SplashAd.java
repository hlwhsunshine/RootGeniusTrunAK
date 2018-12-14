package com.baidu.mobads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.p025c.C0265a;
import com.baidu.mobads.production.p047h.C0407a;

public class SplashAd {
    /* renamed from: a */
    private C0407a f356a;
    /* renamed from: b */
    private volatile String f357b;
    /* renamed from: c */
    private SplashAdListener f358c;
    /* renamed from: d */
    private IOAdEventListener f359d;

    public SplashAd(Context context, ViewGroup viewGroup, SplashAdListener splashAdListener, String str) {
        this(context, viewGroup, splashAdListener, str, true);
    }

    public SplashAd(Context context, ViewGroup viewGroup, SplashAdListener splashAdListener, String str, boolean z) {
        this.f357b = "init";
        this.f358c = new C0249ag(this);
        this.f359d = new C0250ah(this);
        if (splashAdListener != null) {
            try {
                this.f358c = splashAdListener;
            } catch (Throwable e) {
                C0338m.m569a().mo5033f().mo4924d(e);
                C0265a.m334a().mo4397a("splash ad create failed: " + e.toString());
                return;
            }
        }
        if (TextUtils.isEmpty(str)) {
            this.f358c.onAdFailed("请您输入正确的广告位ID");
            return;
        }
        View c0259ao = new C0259ao(context);
        c0259ao.mo4382a(new C0252aj(this, context, c0259ao, str, z));
        c0259ao.setLayoutParams(new LayoutParams(-1, -1));
        viewGroup.addView(c0259ao);
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public static void setAppSid(Context context, String str) {
        C0338m.m569a().mo5040m().setAppId(str);
    }

    public void destroy() {
        if (this.f356a != null) {
            this.f356a.mo5167l();
        }
    }
}
