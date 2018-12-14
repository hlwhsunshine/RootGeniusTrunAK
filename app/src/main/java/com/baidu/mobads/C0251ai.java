package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.p021j.C0338m;

/* renamed from: com.baidu.mobads.ai */
class C0251ai implements Runnable {
    /* renamed from: a */
    final /* synthetic */ IOAdEvent f406a;
    /* renamed from: b */
    final /* synthetic */ C0250ah f407b;

    C0251ai(C0250ah c0250ah, IOAdEvent iOAdEvent) {
        this.f407b = c0250ah;
        this.f406a = iOAdEvent;
    }

    public void run() {
        if (IXAdEvent.AD_LOADED.equals(this.f406a.getType())) {
            C0338m.m569a().mo5033f().mo4933i(this.f406a);
        } else if (IXAdEvent.AD_STARTED.equals(this.f406a.getType())) {
            this.f407b.f405a.f358c.onAdPresent();
        } else if ("AdUserClick".equals(this.f406a.getType())) {
            this.f407b.f405a.f358c.onAdClick();
        } else if (IXAdEvent.AD_STOPPED.equals(this.f406a.getType())) {
            this.f407b.f405a.f356a.removeAllListeners();
            this.f407b.f405a.f358c.onAdDismissed();
        } else if (IXAdEvent.AD_ERROR.equals(this.f406a.getType())) {
            this.f407b.f405a.f356a.removeAllListeners();
            this.f407b.f405a.f358c.onAdFailed(C0338m.m569a().mo5044q().getMessage(this.f406a.getData()));
        }
    }
}
