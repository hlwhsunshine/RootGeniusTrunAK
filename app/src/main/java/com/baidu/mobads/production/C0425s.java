package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.IXAdContainer;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.production.s */
class C0425s implements Runnable {
    /* renamed from: a */
    final /* synthetic */ IXAdContainer f977a;
    /* renamed from: b */
    final /* synthetic */ HashMap f978b;
    /* renamed from: c */
    final /* synthetic */ C0421o f979c;

    C0425s(C0421o c0421o, IXAdContainer iXAdContainer, HashMap hashMap) {
        this.f979c = c0421o;
        this.f977a = iXAdContainer;
        this.f978b = hashMap;
    }

    public void run() {
        this.f979c.f952b.mo5151b(this.f977a, this.f978b);
    }
}
