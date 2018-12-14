package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.p021j.C0338m;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.b */
class C0264b implements Runnable {
    /* renamed from: a */
    final /* synthetic */ IOAdEvent f441a;
    /* renamed from: b */
    final /* synthetic */ C0240a f442b;

    C0264b(C0240a c0240a, IOAdEvent iOAdEvent) {
        this.f442b = c0240a;
        this.f441a = iOAdEvent;
    }

    public void run() {
        if (IXAdEvent.AD_LOADED.equals(this.f441a.getType())) {
            this.f442b.f387a.f347d.onAdReady(this.f442b.f387a);
        } else if (IXAdEvent.AD_STARTED.equals(this.f441a.getType())) {
            this.f442b.f387a.f347d.onAdSwitch();
            this.f442b.f387a.f347d.onAdShow(new JSONObject());
        } else if (IXAdEvent.AD_ERROR.equals(this.f441a.getType())) {
            this.f442b.f387a.f347d.onAdFailed(C0338m.m569a().mo5044q().getMessage(this.f441a.getData()));
        } else if ("AdUserClick".equals(this.f441a.getType())) {
            this.f442b.f387a.f347d.onAdClick(new JSONObject());
        } else if (IXAdEvent.AD_USER_CLOSE.equals(this.f441a.getType())) {
            C0338m.m569a().mo5040m().mo5016a(this.f442b.f387a);
            this.f442b.f387a.f347d.onAdClose(new JSONObject());
        }
    }
}
