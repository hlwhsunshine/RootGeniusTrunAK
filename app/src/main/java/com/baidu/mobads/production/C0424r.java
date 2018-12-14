package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainer;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.production.r */
class C0424r implements Runnable {
    /* renamed from: a */
    final /* synthetic */ IXAdContainer f974a;
    /* renamed from: b */
    final /* synthetic */ HashMap f975b;
    /* renamed from: c */
    final /* synthetic */ C0421o f976c;

    C0424r(C0421o c0421o, IXAdContainer iXAdContainer, HashMap hashMap) {
        this.f976c = c0421o;
        this.f974a = iXAdContainer;
        this.f975b = hashMap;
    }

    public void run() {
        this.f976c.f952b.mo5141a(this.f974a, this.f975b);
    }
}
