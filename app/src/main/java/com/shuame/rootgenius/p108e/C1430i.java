package com.shuame.rootgenius.p108e;

import java.util.ArrayList;

/* renamed from: com.shuame.rootgenius.e.i */
final class C1430i extends Thread {
    /* renamed from: a */
    final /* synthetic */ ArrayList f3933a;
    /* renamed from: b */
    final /* synthetic */ C1429h f3934b;

    C1430i(C1429h c1429h, ArrayList arrayList) {
        this.f3934b = c1429h;
        this.f3933a = arrayList;
    }

    public final void run() {
        C1429h.f3931a;
        new StringBuilder("asyncReport data:").append(this.f3933a.toString());
        C1429h.m3962b(this.f3933a);
    }
}
