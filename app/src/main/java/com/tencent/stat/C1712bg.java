package com.tencent.stat;

import java.util.List;

/* renamed from: com.tencent.stat.bg */
class C1712bg implements StatDispatchCallback {
    /* renamed from: a */
    final /* synthetic */ List f4989a;
    /* renamed from: b */
    final /* synthetic */ boolean f4990b;
    /* renamed from: c */
    final /* synthetic */ C1706ba f4991c;

    C1712bg(C1706ba c1706ba, List list, boolean z) {
        this.f4991c = c1706ba;
        this.f4989a = list;
        this.f4990b = z;
    }

    public void onDispatchFailure() {
        StatServiceImpl.m4644d();
        this.f4991c.mo7873a(this.f4989a, 1, this.f4990b, true);
    }

    public void onDispatchSuccess() {
        StatServiceImpl.m4643c();
        this.f4991c.mo7874a(this.f4989a, this.f4990b, true);
    }
}
