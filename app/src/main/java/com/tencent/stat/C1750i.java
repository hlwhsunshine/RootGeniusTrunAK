package com.tencent.stat;

import java.util.List;

/* renamed from: com.tencent.stat.i */
class C1750i implements Runnable {
    /* renamed from: a */
    final /* synthetic */ List f5142a;
    /* renamed from: b */
    final /* synthetic */ StatDispatchCallback f5143b;
    /* renamed from: c */
    final /* synthetic */ C1748g f5144c;

    C1750i(C1748g c1748g, List list, StatDispatchCallback statDispatchCallback) {
        this.f5144c = c1748g;
        this.f5142a = list;
        this.f5143b = statDispatchCallback;
    }

    public void run() {
        this.f5144c.mo7951a(this.f5142a, this.f5143b);
    }
}
