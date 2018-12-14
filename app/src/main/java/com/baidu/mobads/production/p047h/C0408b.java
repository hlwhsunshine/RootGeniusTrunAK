package com.baidu.mobads.production.p047h;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.p032f.C0280a;

/* renamed from: com.baidu.mobads.production.h.b */
class C0408b implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0407a f936a;

    C0408b(C0407a c0407a) {
        this.f936a = c0407a;
    }

    public void run() {
        this.f936a.dispatchEvent(new C0280a(IXAdEvent.AD_LOADED));
    }
}
