package com.tencent.stat;

import java.util.List;

/* renamed from: com.tencent.stat.bb */
class C1707bb implements Runnable {
    /* renamed from: a */
    final /* synthetic */ List f4972a;
    /* renamed from: b */
    final /* synthetic */ int f4973b;
    /* renamed from: c */
    final /* synthetic */ boolean f4974c;
    /* renamed from: d */
    final /* synthetic */ boolean f4975d;
    /* renamed from: e */
    final /* synthetic */ C1706ba f4976e;

    C1707bb(C1706ba c1706ba, List list, int i, boolean z, boolean z2) {
        this.f4976e = c1706ba;
        this.f4972a = list;
        this.f4973b = i;
        this.f4974c = z;
        this.f4975d = z2;
    }

    public void run() {
        this.f4976e.m4685a(this.f4972a, this.f4973b, this.f4974c);
        if (this.f4975d) {
            this.f4972a.clear();
        }
    }
}
