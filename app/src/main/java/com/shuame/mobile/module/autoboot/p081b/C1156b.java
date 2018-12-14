package com.shuame.mobile.module.autoboot.p081b;

import com.shuame.mobile.module.autoboot.p081b.C1155a.C1153b;
import java.util.Iterator;

/* renamed from: com.shuame.mobile.module.autoboot.b.b */
final class C1156b implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f3045a;
    /* renamed from: b */
    final /* synthetic */ boolean f3046b;
    /* renamed from: c */
    final /* synthetic */ C1155a f3047c;

    C1156b(C1155a c1155a, int i, boolean z) {
        this.f3047c = c1155a;
        this.f3045a = i;
        this.f3046b = z;
    }

    public final void run() {
        Iterator it = this.f3047c.f3035e.iterator();
        while (it.hasNext()) {
            ((C1153b) it.next()).mo6747a(this.f3045a, this.f3046b);
        }
    }
}
