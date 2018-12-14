package com.shuame.rootgenius.common.manager.p104a;

import com.shuame.rootgenius.common.manager.p104a.C1354c.C1352a;

/* renamed from: com.shuame.rootgenius.common.manager.a.d */
final class C1355d implements C1352a {
    /* renamed from: a */
    final /* synthetic */ C1354c f3711a;

    C1355d(C1354c c1354c) {
        this.f3711a = c1354c;
    }

    public final void onFailed(int i) {
        C1354c.m3795a(this.f3711a);
        if (this.f3711a.f3709f != null) {
            this.f3711a.f3709f.onFailed(i);
        }
    }

    public final void onSuccess() {
        C1354c.m3795a(this.f3711a);
        if (this.f3711a.f3709f != null) {
            this.f3711a.f3709f.onSuccess();
        }
    }
}
