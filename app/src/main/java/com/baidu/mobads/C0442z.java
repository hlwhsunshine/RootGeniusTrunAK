package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.p021j.C0338m;

/* renamed from: com.baidu.mobads.z */
class C0442z implements IOAdEventListener {
    /* renamed from: a */
    final /* synthetic */ InterstitialAd f1119a;

    C0442z(InterstitialAd interstitialAd) {
        this.f1119a = interstitialAd;
    }

    public void run(IOAdEvent iOAdEvent) {
        C0338m.m569a().mo5033f().mo4931i(InterstitialAd.TAG, "evt.type=" + iOAdEvent.getType());
        C0338m.m569a().mo5040m().mo5017a(new C0241aa(this, iOAdEvent));
    }
}
