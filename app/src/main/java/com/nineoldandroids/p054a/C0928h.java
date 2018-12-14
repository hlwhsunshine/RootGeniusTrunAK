package com.nineoldandroids.p054a;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: com.nineoldandroids.a.h */
class C0928h {
    /* renamed from: a */
    int f2291a;
    /* renamed from: b */
    C0932g f2292b;
    /* renamed from: c */
    C0932g f2293c;
    /* renamed from: d */
    Interpolator f2294d;
    /* renamed from: e */
    ArrayList<C0932g> f2295e = new ArrayList();
    /* renamed from: f */
    C0926z f2296f;

    public C0928h(C0932g... c0932gArr) {
        this.f2291a = c0932gArr.length;
        this.f2295e.addAll(Arrays.asList(c0932gArr));
        this.f2292b = (C0932g) this.f2295e.get(0);
        this.f2293c = (C0932g) this.f2295e.get(this.f2291a - 1);
        this.f2294d = this.f2293c.mo6062b();
    }

    /* renamed from: a */
    public C0928h clone() {
        ArrayList arrayList = this.f2295e;
        int size = this.f2295e.size();
        C0932g[] c0932gArr = new C0932g[size];
        for (int i = 0; i < size; i++) {
            c0932gArr[i] = ((C0932g) arrayList.get(i)).clone();
        }
        return new C0928h(c0932gArr);
    }

    /* renamed from: a */
    public Object mo6054a(float f) {
        C0932g c0932g;
        Interpolator b;
        float f2;
        if (this.f2291a == 2) {
            if (this.f2294d != null) {
                f = this.f2294d.getInterpolation(f);
            }
            return this.f2296f.mo6052a(f, this.f2292b.mo6059a(), this.f2293c.mo6059a());
        } else if (f <= 0.0f) {
            c0932g = (C0932g) this.f2295e.get(1);
            b = c0932g.mo6062b();
            if (b != null) {
                f = b.getInterpolation(f);
            }
            f2 = this.f2292b.f2305a;
            return this.f2296f.mo6052a((f - f2) / (c0932g.f2305a - f2), this.f2292b.mo6059a(), c0932g.mo6059a());
        } else if (f >= 1.0f) {
            c0932g = (C0932g) this.f2295e.get(this.f2291a - 2);
            b = this.f2293c.mo6062b();
            if (b != null) {
                f = b.getInterpolation(f);
            }
            f2 = c0932g.f2305a;
            return this.f2296f.mo6052a((f - f2) / (this.f2293c.f2305a - f2), c0932g.mo6059a(), this.f2293c.mo6059a());
        } else {
            C0932g c0932g2 = this.f2292b;
            int i = 1;
            while (i < this.f2291a) {
                c0932g = (C0932g) this.f2295e.get(i);
                if (f < c0932g.f2305a) {
                    b = c0932g.mo6062b();
                    if (b != null) {
                        f = b.getInterpolation(f);
                    }
                    f2 = c0932g2.f2305a;
                    return this.f2296f.mo6052a((f - f2) / (c0932g.f2305a - f2), c0932g2.mo6059a(), c0932g.mo6059a());
                }
                i++;
                c0932g2 = c0932g;
            }
            return this.f2293c.mo6059a();
        }
    }

    public String toString() {
        String str = " ";
        int i = 0;
        while (i < this.f2291a) {
            String str2 = str + ((C0932g) this.f2295e.get(i)).mo6059a() + "  ";
            i++;
            str = str2;
        }
        return str;
    }
}
