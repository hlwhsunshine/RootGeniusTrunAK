package com.baidu.mobads;

import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.p021j.C0338m;

/* renamed from: com.baidu.mobads.a */
class C0240a implements IOAdEventListener {
    /* renamed from: a */
    final /* synthetic */ AdView f387a;

    C0240a(AdView adView) {
        this.f387a = adView;
    }

    public void run(IOAdEvent iOAdEvent) {
        if (this.f387a.f347d != null) {
            C0338m.m569a().mo5040m().mo5017a(new C0264b(this, iOAdEvent));
        }
    }
}
