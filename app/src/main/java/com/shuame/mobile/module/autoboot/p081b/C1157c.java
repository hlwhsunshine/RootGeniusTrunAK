package com.shuame.mobile.module.autoboot.p081b;

import com.shuame.mobile.module.autoboot.p083c.C1161a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.shuame.mobile.module.autoboot.b.c */
public final class C1157c {
    /* renamed from: a */
    private List<C1161a> f3048a = new ArrayList();

    /* renamed from: a */
    public final synchronized C1161a mo6763a() {
        return !this.f3048a.isEmpty() ? (C1161a) this.f3048a.remove(0) : null;
    }

    /* renamed from: a */
    public final synchronized C1161a mo6764a(String str) {
        C1161a c1161a;
        for (C1161a c1161a2 : this.f3048a) {
            if (c1161a2.f3062j.equals(str)) {
                break;
            }
        }
        c1161a2 = null;
        return c1161a2;
    }

    /* renamed from: a */
    public final synchronized void mo6765a(C1161a c1161a) {
        if (c1161a != null) {
            for (C1161a c1161a2 : this.f3048a) {
                if (c1161a2.f3062j.equals(c1161a.f3062j)) {
                    c1161a2.f3067o = c1161a.f3067o;
                    c1161a2.f3068p = c1161a.f3068p;
                    c1161a2.f3069q = c1161a.f3069q;
                    break;
                }
            }
            this.f3048a.add(c1161a);
        }
    }
}
