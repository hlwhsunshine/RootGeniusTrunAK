package com.nineoldandroids.p054a;

import android.view.View;
import com.nineoldandroids.p055b.p056a.C0957a;
import com.nineoldandroids.util.C0937c;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.nineoldandroids.a.i */
public final class C0935i extends C0919aa {
    /* renamed from: h */
    private static final Map<String, C0937c> f2311h;
    /* renamed from: i */
    private Object f2312i;
    /* renamed from: j */
    private String f2313j;
    /* renamed from: k */
    private C0937c f2314k;

    static {
        Map hashMap = new HashMap();
        f2311h = hashMap;
        hashMap.put("alpha", C0936j.f2315a);
        f2311h.put("pivotX", C0936j.f2316b);
        f2311h.put("pivotY", C0936j.f2317c);
        f2311h.put("translationX", C0936j.f2318d);
        f2311h.put("translationY", C0936j.f2319e);
        f2311h.put("rotation", C0936j.f2320f);
        f2311h.put("rotationX", C0936j.f2321g);
        f2311h.put("rotationY", C0936j.f2322h);
        f2311h.put("scaleX", C0936j.f2323i);
        f2311h.put("scaleY", C0936j.f2324j);
        f2311h.put("scrollX", C0936j.f2325k);
        f2311h.put("scrollY", C0936j.f2326l);
        f2311h.put("x", C0936j.f2327m);
        f2311h.put("y", C0936j.f2328n);
    }

    /* renamed from: a */
    public static C0935i m2580a(Object obj, C0954y... c0954yArr) {
        C0935i c0935i = new C0935i();
        c0935i.f2312i = obj;
        c0935i.mo6039a(c0954yArr);
        return c0935i;
    }

    /* renamed from: a */
    public final void mo6026a() {
        super.mo6026a();
    }

    /* renamed from: a */
    final void mo6034a(float f) {
        super.mo6034a(f);
        for (C0954y b : this.f2280f) {
            b.mo6079b(this.f2312i);
        }
    }

    /* renamed from: a */
    public final void mo6037a(float... fArr) {
        if (this.f2280f != null && this.f2280f.length != 0) {
            super.mo6037a(fArr);
        } else if (this.f2314k != null) {
            mo6039a(C0954y.m2625a(this.f2314k, fArr));
        } else {
            mo6039a(C0954y.m2627a(this.f2313j, fArr));
        }
    }

    /* renamed from: a */
    public final void mo6038a(int... iArr) {
        if (this.f2280f != null && this.f2280f.length != 0) {
            super.mo6038a(iArr);
        } else if (this.f2314k != null) {
            mo6039a(C0954y.m2626a(this.f2314k, iArr));
        } else {
            mo6039a(C0954y.m2628a(this.f2313j, iArr));
        }
    }

    /* renamed from: c */
    public final /* synthetic */ C0916a mo6029c() {
        return (C0935i) super.clone();
    }

    public final /* synthetic */ Object clone() {
        return (C0935i) super.clone();
    }

    /* renamed from: d */
    final void mo6042d() {
        if (!this.f2279e) {
            if (this.f2314k == null && C0957a.f2354a && (this.f2312i instanceof View) && f2311h.containsKey(this.f2313j)) {
                C0937c c0937c = (C0937c) f2311h.get(this.f2313j);
                if (this.f2280f != null) {
                    C0954y c0954y = this.f2280f[0];
                    String str = c0954y.f2338a;
                    c0954y.mo6073a(c0937c);
                    this.f2281g.remove(str);
                    this.f2281g.put(this.f2313j, c0954y);
                }
                if (this.f2314k != null) {
                    this.f2313j = c0937c.mo6067a();
                }
                this.f2314k = c0937c;
                this.f2279e = false;
            }
            for (C0954y a : this.f2280f) {
                a.mo6075a(this.f2312i);
            }
            super.mo6042d();
        }
    }

    /* renamed from: e */
    public final C0935i mo6065e() {
        super.mo6033a(600);
        return this;
    }

    /* renamed from: f */
    public final /* bridge */ /* synthetic */ C0919aa mo6043f() {
        return (C0935i) super.clone();
    }

    public final String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.f2312i;
        if (this.f2280f != null) {
            for (C0954y c0954y : this.f2280f) {
                str = str + "\n    " + c0954y.toString();
            }
        }
        return str;
    }
}
