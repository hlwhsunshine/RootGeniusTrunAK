package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainerContext;

/* renamed from: com.baidu.mobads.production.m */
class C0419m implements Runnable {
    /* renamed from: a */
    final /* synthetic */ IXAdContainerContext f948a;
    /* renamed from: b */
    final /* synthetic */ C0375a f949b;

    C0419m(C0375a c0375a, IXAdContainerContext iXAdContainerContext) {
        this.f949b = c0375a;
        this.f948a = iXAdContainerContext;
    }

    public void run() {
        this.f949b.mo5142a(this.f948a);
    }
}
