package com.tencent.stat;

import com.tencent.stat.event.C1735f;

/* renamed from: com.tencent.stat.be */
class C1710be implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1735f f4982a;
    /* renamed from: b */
    final /* synthetic */ StatDispatchCallback f4983b;
    /* renamed from: c */
    final /* synthetic */ boolean f4984c;
    /* renamed from: d */
    final /* synthetic */ boolean f4985d;
    /* renamed from: e */
    final /* synthetic */ C1706ba f4986e;

    C1710be(C1706ba c1706ba, C1735f c1735f, StatDispatchCallback statDispatchCallback, boolean z, boolean z2) {
        this.f4986e = c1706ba;
        this.f4982a = c1735f;
        this.f4983b = statDispatchCallback;
        this.f4984c = z;
        this.f4985d = z2;
    }

    public void run() {
        this.f4986e.m4691b(this.f4982a, this.f4983b, this.f4984c, this.f4985d);
    }
}
