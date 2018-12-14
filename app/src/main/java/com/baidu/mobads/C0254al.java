package com.baidu.mobads;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.p020d.C0232b;

/* renamed from: com.baidu.mobads.al */
class C0254al implements Runnable {
    /* renamed from: a */
    final /* synthetic */ IOAdEvent f414a;
    /* renamed from: b */
    final /* synthetic */ C0253ak f415b;

    C0254al(C0253ak c0253ak, IOAdEvent iOAdEvent) {
        this.f415b = c0253ak;
        this.f414a = iOAdEvent;
    }

    public void run() {
        if (IXAdEvent.AD_LOADED.equals(this.f414a.getType())) {
            this.f415b.f413a.f373c.onVideoPrepared();
        }
        if (IXAdEvent.AD_STARTED.equals(this.f414a.getType())) {
            this.f415b.f413a.f373c.onVideoStart();
        }
        if (IXAdEvent.AD_CLICK_THRU.equals(this.f414a.getType())) {
            this.f415b.f413a.f373c.onVideoClickAd();
        }
        if (IXAdEvent.AD_STOPPED.equals(this.f414a.getType())) {
            this.f415b.f413a.f373c.onVideoFinish();
        }
        if (IXAdEvent.AD_ERROR.equals(this.f414a.getType())) {
            this.f414a.getData().get(C0232b.EVENT_MESSAGE);
            this.f415b.f413a.f373c.onVideoError();
        }
    }
}
