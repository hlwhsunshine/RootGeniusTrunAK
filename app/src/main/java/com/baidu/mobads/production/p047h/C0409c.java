package com.baidu.mobads.production.p047h;

import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.p032f.C0280a;

/* renamed from: com.baidu.mobads.production.h.c */
class C0409c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0407a f937a;

    C0409c(C0407a c0407a) {
        this.f937a = c0407a;
    }

    public void run() {
        this.f937a.dispatchEvent(new C0280a(IXAdEvent.AD_STOPPED));
    }
}
