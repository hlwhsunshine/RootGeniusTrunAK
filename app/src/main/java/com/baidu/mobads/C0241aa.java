package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.p021j.C0338m;

/* renamed from: com.baidu.mobads.aa */
class C0241aa implements Runnable {
    /* renamed from: a */
    final /* synthetic */ IOAdEvent f388a;
    /* renamed from: b */
    final /* synthetic */ C0442z f389b;

    C0241aa(C0442z c0442z, IOAdEvent iOAdEvent) {
        this.f389b = c0442z;
        this.f388a = iOAdEvent;
    }

    public void run() {
        if (IXAdEvent.AD_LOADED.equals(this.f388a.getType())) {
            this.f389b.f1119a.f355e.onAdReady();
        } else if (IXAdEvent.AD_ERROR.equals(this.f388a.getType())) {
            this.f389b.f1119a.f355e.onAdFailed(C0338m.m569a().mo5044q().getMessage(this.f388a.getData()));
        } else if (IXAdEvent.AD_STOPPED.equals(this.f388a.getType())) {
            this.f389b.f1119a.f355e.onAdDismissed();
        } else if (IXAdEvent.AD_STARTED.equals(this.f388a.getType())) {
            this.f389b.f1119a.f355e.onAdPresent();
        } else if ("AdUserClick".equals(this.f388a.getType())) {
            this.f389b.f1119a.f355e.onAdClick(this.f389b.f1119a);
        }
    }
}
