package com.nineoldandroids.p054a;

import android.view.animation.Interpolator;

/* renamed from: com.nineoldandroids.a.g */
public abstract class C0932g implements Cloneable {
    /* renamed from: a */
    float f2305a;
    /* renamed from: b */
    Class f2306b;
    /* renamed from: c */
    boolean f2307c = false;
    /* renamed from: d */
    private Interpolator f2308d = null;

    /* renamed from: com.nineoldandroids.a.g$a */
    static class C0933a extends C0932g {
        /* renamed from: d */
        float f2309d;

        C0933a() {
            this.f2305a = 0.0f;
            this.f2306b = Float.TYPE;
        }

        C0933a(float f, float f2) {
            this.f2305a = f;
            this.f2309d = f2;
            this.f2306b = Float.TYPE;
            this.f2307c = true;
        }

        /* renamed from: d */
        private C0933a m2572d() {
            C0933a c0933a = new C0933a(this.f2305a, this.f2309d);
            c0933a.mo6060a(mo6062b());
            return c0933a;
        }

        /* renamed from: a */
        public final Object mo6059a() {
            return Float.valueOf(this.f2309d);
        }

        /* renamed from: a */
        public final void mo6061a(Object obj) {
            if (obj != null && obj.getClass() == Float.class) {
                this.f2309d = ((Float) obj).floatValue();
                this.f2307c = true;
            }
        }
    }

    /* renamed from: com.nineoldandroids.a.g$b */
    static class C0934b extends C0932g {
        /* renamed from: d */
        int f2310d;

        C0934b() {
            this.f2305a = 0.0f;
            this.f2306b = Integer.TYPE;
        }

        C0934b(float f, int i) {
            this.f2305a = f;
            this.f2310d = i;
            this.f2306b = Integer.TYPE;
            this.f2307c = true;
        }

        /* renamed from: d */
        private C0934b m2576d() {
            C0934b c0934b = new C0934b(this.f2305a, this.f2310d);
            c0934b.mo6060a(mo6062b());
            return c0934b;
        }

        /* renamed from: a */
        public final Object mo6059a() {
            return Integer.valueOf(this.f2310d);
        }

        /* renamed from: a */
        public final void mo6061a(Object obj) {
            if (obj != null && obj.getClass() == Integer.class) {
                this.f2310d = ((Integer) obj).intValue();
                this.f2307c = true;
            }
        }
    }

    /* renamed from: a */
    public static C0932g m2565a(float f, float f2) {
        return new C0933a(f, f2);
    }

    /* renamed from: a */
    public static C0932g m2566a(float f, int i) {
        return new C0934b(f, i);
    }

    /* renamed from: a */
    public abstract Object mo6059a();

    /* renamed from: a */
    public final void mo6060a(Interpolator interpolator) {
        this.f2308d = interpolator;
    }

    /* renamed from: a */
    public abstract void mo6061a(Object obj);

    /* renamed from: b */
    public final Interpolator mo6062b() {
        return this.f2308d;
    }

    /* renamed from: c */
    public abstract C0932g clone();
}
