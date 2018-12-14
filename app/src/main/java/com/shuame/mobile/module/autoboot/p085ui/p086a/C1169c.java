package com.shuame.mobile.module.autoboot.p085ui.p086a;

import com.shuame.mobile.module.autoboot.p081b.C1155a;
import com.shuame.mobile.module.autoboot.p083c.C1161a;

/* renamed from: com.shuame.mobile.module.autoboot.ui.a.c */
final class C1169c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1161a f3113a;
    /* renamed from: b */
    final /* synthetic */ int f3114b;
    /* renamed from: c */
    final /* synthetic */ boolean f3115c;
    /* renamed from: d */
    final /* synthetic */ C1167a f3116d;

    C1169c(C1167a c1167a, C1161a c1161a, int i, boolean z) {
        this.f3116d = c1167a;
        this.f3113a = c1161a;
        this.f3114b = i;
        this.f3115c = z;
    }

    public final void run() {
        this.f3116d.mo6779a(this.f3113a.f3062j);
        int b = C1155a.m3315a().mo6756b();
        new StringBuilder("onEndSetEnabled: result2=").append(this.f3114b).append(";enabled=").append(this.f3115c).append(" disable:").append(this.f3113a.f3065m).append(";count=").append(b);
        C1167a.m3361a();
        this.f3116d.f3111j.mo6746a(b);
    }
}
