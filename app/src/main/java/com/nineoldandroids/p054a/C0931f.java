package com.nineoldandroids.p054a;

import android.view.animation.Interpolator;
import com.nineoldandroids.p054a.C0932g.C0934b;
import java.util.ArrayList;

/* renamed from: com.nineoldandroids.a.f */
final class C0931f extends C0928h {
    /* renamed from: g */
    private int f2301g;
    /* renamed from: h */
    private int f2302h;
    /* renamed from: i */
    private int f2303i;
    /* renamed from: j */
    private boolean f2304j = true;

    public C0931f(C0934b... c0934bArr) {
        super(c0934bArr);
    }

    /* renamed from: b */
    private C0931f m2561b() {
        ArrayList arrayList = this.f2295e;
        int size = this.f2295e.size();
        C0934b[] c0934bArr = new C0934b[size];
        for (int i = 0; i < size; i++) {
            c0934bArr[i] = (C0934b) ((C0932g) arrayList.get(i)).clone();
        }
        return new C0931f(c0934bArr);
    }

    /* renamed from: a */
    public final Object mo6054a(float f) {
        return Integer.valueOf(mo6058b(f));
    }

    /* renamed from: b */
    public final int mo6058b(float f) {
        int i = 1;
        C0934b c0934b;
        C0934b c0934b2;
        int i2;
        int i3;
        float f2;
        float f3;
        Interpolator b;
        if (this.f2291a == 2) {
            if (this.f2304j) {
                this.f2304j = false;
                this.f2301g = ((C0934b) this.f2295e.get(0)).f2310d;
                this.f2302h = ((C0934b) this.f2295e.get(1)).f2310d;
                this.f2303i = this.f2302h - this.f2301g;
            }
            if (this.f2294d != null) {
                f = this.f2294d.getInterpolation(f);
            }
            return this.f2296f == null ? this.f2301g + ((int) (((float) this.f2303i) * f)) : ((Number) this.f2296f.mo6052a(f, Integer.valueOf(this.f2301g), Integer.valueOf(this.f2302h))).intValue();
        } else if (f <= 0.0f) {
            c0934b = (C0934b) this.f2295e.get(0);
            c0934b2 = (C0934b) this.f2295e.get(1);
            i2 = c0934b.f2310d;
            i3 = c0934b2.f2310d;
            f2 = c0934b.f2305a;
            f3 = c0934b2.f2305a;
            b = c0934b2.mo6062b();
            if (b != null) {
                f = b.getInterpolation(f);
            }
            f2 = (f - f2) / (f3 - f2);
            return this.f2296f == null ? ((int) (f2 * ((float) (i3 - i2)))) + i2 : ((Number) this.f2296f.mo6052a(f2, Integer.valueOf(i2), Integer.valueOf(i3))).intValue();
        } else if (f >= 1.0f) {
            c0934b = (C0934b) this.f2295e.get(this.f2291a - 2);
            c0934b2 = (C0934b) this.f2295e.get(this.f2291a - 1);
            i2 = c0934b.f2310d;
            i3 = c0934b2.f2310d;
            f2 = c0934b.f2305a;
            f3 = c0934b2.f2305a;
            b = c0934b2.mo6062b();
            if (b != null) {
                f = b.getInterpolation(f);
            }
            f2 = (f - f2) / (f3 - f2);
            return this.f2296f == null ? ((int) (f2 * ((float) (i3 - i2)))) + i2 : ((Number) this.f2296f.mo6052a(f2, Integer.valueOf(i2), Integer.valueOf(i3))).intValue();
        } else {
            C0932g c0932g = (C0934b) this.f2295e.get(0);
            while (true) {
                C0932g c0932g2 = c0932g;
                if (i >= this.f2291a) {
                    return ((Number) ((C0932g) this.f2295e.get(this.f2291a - 1)).mo6059a()).intValue();
                }
                c0934b = (C0934b) this.f2295e.get(i);
                if (f < c0934b.f2305a) {
                    b = c0934b.mo6062b();
                    if (b != null) {
                        f = b.getInterpolation(f);
                    }
                    float f4 = (f - c0932g2.f2305a) / (c0934b.f2305a - c0932g2.f2305a);
                    i2 = c0932g2.f2310d;
                    int i4 = c0934b.f2310d;
                    return this.f2296f == null ? ((int) (((float) (i4 - i2)) * f4)) + i2 : ((Number) this.f2296f.mo6052a(f4, Integer.valueOf(i2), Integer.valueOf(i4))).intValue();
                } else {
                    i++;
                }
            }
        }
    }
}
