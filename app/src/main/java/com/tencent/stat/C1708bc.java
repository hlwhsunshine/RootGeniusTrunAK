package com.tencent.stat;

import java.util.List;

/* renamed from: com.tencent.stat.bc */
class C1708bc implements Runnable {
    /* renamed from: a */
    final /* synthetic */ List f4977a;
    /* renamed from: b */
    final /* synthetic */ boolean f4978b;
    /* renamed from: c */
    final /* synthetic */ boolean f4979c;
    /* renamed from: d */
    final /* synthetic */ C1706ba f4980d;

    C1708bc(C1706ba c1706ba, List list, boolean z, boolean z2) {
        this.f4980d = c1706ba;
        this.f4977a = list;
        this.f4978b = z;
        this.f4979c = z2;
    }

    public void run() {
        this.f4980d.m4686a(this.f4977a, this.f4978b);
        if (this.f4979c) {
            this.f4977a.clear();
        }
    }
}
