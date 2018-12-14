package com.nineoldandroids.p054a;

import android.view.animation.Interpolator;
import com.nineoldandroids.p054a.C0932g.C0933a;
import java.util.ArrayList;

/* renamed from: com.nineoldandroids.a.d */
final class C0929d extends C0928h {
    /* renamed from: g */
    private float f2297g;
    /* renamed from: h */
    private float f2298h;
    /* renamed from: i */
    private float f2299i;
    /* renamed from: j */
    private boolean f2300j = true;

    public C0929d(C0933a... c0933aArr) {
        super(c0933aArr);
    }

    /* renamed from: b */
    private C0929d m2556b() {
        ArrayList arrayList = this.f2295e;
        int size = this.f2295e.size();
        C0933a[] c0933aArr = new C0933a[size];
        for (int i = 0; i < size; i++) {
            c0933aArr[i] = (C0933a) ((C0932g) arrayList.get(i)).clone();
        }
        return new C0929d(c0933aArr);
    }

    /* renamed from: a */
    public final Object mo6054a(float f) {
        return Float.valueOf(mo6057b(f));
    }

    /* renamed from: b */
    public final float mo6057b(float f) {
        int i = 1;
        C0933a c0933a;
        C0933a c0933a2;
        float f2;
        float f3;
        float f4;
        float f5;
        Interpolator b;
        if (this.f2291a == 2) {
            if (this.f2300j) {
                this.f2300j = false;
                this.f2297g = ((C0933a) this.f2295e.get(0)).f2309d;
                this.f2298h = ((C0933a) this.f2295e.get(1)).f2309d;
                this.f2299i = this.f2298h - this.f2297g;
            }
            if (this.f2294d != null) {
                f = this.f2294d.getInterpolation(f);
            }
            return this.f2296f == null ? this.f2297g + (this.f2299i * f) : ((Number) this.f2296f.mo6052a(f, Float.valueOf(this.f2297g), Float.valueOf(this.f2298h))).floatValue();
        } else if (f <= 0.0f) {
            c0933a = (C0933a) this.f2295e.get(0);
            c0933a2 = (C0933a) this.f2295e.get(1);
            f2 = c0933a.f2309d;
            f3 = c0933a2.f2309d;
            f4 = c0933a.f2305a;
            f5 = c0933a2.f2305a;
            b = c0933a2.mo6062b();
            if (b != null) {
                f = b.getInterpolation(f);
            }
            f4 = (f - f4) / (f5 - f4);
            return this.f2296f == null ? (f4 * (f3 - f2)) + f2 : ((Number) this.f2296f.mo6052a(f4, Float.valueOf(f2), Float.valueOf(f3))).floatValue();
        } else if (f >= 1.0f) {
            c0933a = (C0933a) this.f2295e.get(this.f2291a - 2);
            c0933a2 = (C0933a) this.f2295e.get(this.f2291a - 1);
            f2 = c0933a.f2309d;
            f3 = c0933a2.f2309d;
            f4 = c0933a.f2305a;
            f5 = c0933a2.f2305a;
            b = c0933a2.mo6062b();
            if (b != null) {
                f = b.getInterpolation(f);
            }
            f4 = (f - f4) / (f5 - f4);
            return this.f2296f == null ? (f4 * (f3 - f2)) + f2 : ((Number) this.f2296f.mo6052a(f4, Float.valueOf(f2), Float.valueOf(f3))).floatValue();
        } else {
            C0932g c0932g = (C0933a) this.f2295e.get(0);
            while (true) {
                C0932g c0932g2 = c0932g;
                if (i >= this.f2291a) {
                    return ((Number) ((C0932g) this.f2295e.get(this.f2291a - 1)).mo6059a()).floatValue();
                }
                c0933a = (C0933a) this.f2295e.get(i);
                if (f < c0933a.f2305a) {
                    b = c0933a.mo6062b();
                    if (b != null) {
                        f = b.getInterpolation(f);
                    }
                    float f6 = (f - c0932g2.f2305a) / (c0933a.f2305a - c0932g2.f2305a);
                    f2 = c0932g2.f2309d;
                    f4 = c0933a.f2309d;
                    return this.f2296f == null ? ((f4 - f2) * f6) + f2 : ((Number) this.f2296f.mo6052a(f6, Float.valueOf(f2), Float.valueOf(f4))).floatValue();
                } else {
                    i++;
                }
            }
        }
    }
}
