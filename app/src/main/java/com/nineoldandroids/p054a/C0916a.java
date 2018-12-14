package com.nineoldandroids.p054a;

import java.util.ArrayList;

/* renamed from: com.nineoldandroids.a.a */
public abstract class C0916a implements Cloneable {
    /* renamed from: a */
    ArrayList<C0915a> f2261a = null;

    /* renamed from: com.nineoldandroids.a.a$a */
    public interface C0915a {
        /* renamed from: a */
        void mo6022a(C0916a c0916a);

        /* renamed from: b */
        void mo6023b(C0916a c0916a);

        /* renamed from: c */
        void mo6024c(C0916a c0916a);

        /* renamed from: d */
        void mo6025d(C0916a c0916a);
    }

    /* renamed from: a */
    public void mo6026a() {
    }

    /* renamed from: a */
    public final void mo6027a(C0915a c0915a) {
        if (this.f2261a == null) {
            this.f2261a = new ArrayList();
        }
        this.f2261a.add(c0915a);
    }

    /* renamed from: b */
    public void mo6028b() {
    }

    /* renamed from: c */
    public C0916a clone() {
        try {
            C0916a c0916a = (C0916a) super.clone();
            if (this.f2261a != null) {
                ArrayList arrayList = this.f2261a;
                c0916a.f2261a = new ArrayList();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    c0916a.f2261a.add(arrayList.get(i));
                }
            }
            return c0916a;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
