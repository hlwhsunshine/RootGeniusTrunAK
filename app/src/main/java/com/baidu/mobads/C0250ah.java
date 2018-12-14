package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.p021j.C0338m;

/* renamed from: com.baidu.mobads.ah */
class C0250ah implements IOAdEventListener {
    /* renamed from: a */
    final /* synthetic */ SplashAd f405a;

    C0250ah(SplashAd splashAd) {
        this.f405a = splashAd;
    }

    public void run(IOAdEvent iOAdEvent) {
        if (this.f405a.f358c != null) {
            C0338m.m569a().mo5040m().mo5017a(new C0251ai(this, iOAdEvent));
        }
    }
}
