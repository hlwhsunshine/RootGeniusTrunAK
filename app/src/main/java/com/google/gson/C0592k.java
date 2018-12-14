package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.gson.k */
public final class C0592k extends C0591m implements Iterable<C0591m> {
    /* renamed from: a */
    private final List<C0591m> f1462a = new ArrayList();

    /* renamed from: a */
    public final Number mo5546a() {
        if (this.f1462a.size() == 1) {
            return ((C0591m) this.f1462a.get(0)).mo5546a();
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public final void mo5554a(C0591m c0591m) {
        Object c0591m2;
        if (c0591m2 == null) {
            c0591m2 = C0593n.f1463a;
        }
        this.f1462a.add(c0591m2);
    }

    /* renamed from: b */
    public final String mo5547b() {
        if (this.f1462a.size() == 1) {
            return ((C0591m) this.f1462a.get(0)).mo5547b();
        }
        throw new IllegalStateException();
    }

    /* renamed from: c */
    public final double mo5548c() {
        if (this.f1462a.size() == 1) {
            return ((C0591m) this.f1462a.get(0)).mo5548c();
        }
        throw new IllegalStateException();
    }

    /* renamed from: d */
    public final long mo5549d() {
        if (this.f1462a.size() == 1) {
            return ((C0591m) this.f1462a.get(0)).mo5549d();
        }
        throw new IllegalStateException();
    }

    /* renamed from: e */
    public final int mo5550e() {
        if (this.f1462a.size() == 1) {
            return ((C0591m) this.f1462a.get(0)).mo5550e();
        }
        throw new IllegalStateException();
    }

    public final boolean equals(Object obj) {
        return obj == this || ((obj instanceof C0592k) && ((C0592k) obj).f1462a.equals(this.f1462a));
    }

    /* renamed from: f */
    public final boolean mo5551f() {
        if (this.f1462a.size() == 1) {
            return ((C0591m) this.f1462a.get(0)).mo5551f();
        }
        throw new IllegalStateException();
    }

    public final int hashCode() {
        return this.f1462a.hashCode();
    }

    public final Iterator<C0591m> iterator() {
        return this.f1462a.iterator();
    }
}
