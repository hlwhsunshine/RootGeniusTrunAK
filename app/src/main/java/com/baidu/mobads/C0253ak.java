package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.p021j.C0338m;

/* renamed from: com.baidu.mobads.ak */
class C0253ak implements IOAdEventListener {
    /* renamed from: a */
    final /* synthetic */ VideoAdView f413a;

    C0253ak(VideoAdView videoAdView) {
        this.f413a = videoAdView;
    }

    public void run(IOAdEvent iOAdEvent) {
        C0338m.m569a().mo5040m().mo5017a(new C0254al(this, iOAdEvent));
    }
}
