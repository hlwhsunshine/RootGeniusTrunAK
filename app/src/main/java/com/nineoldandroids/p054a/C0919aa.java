package com.nineoldandroids.p054a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.nineoldandroids.p054a.C0916a.C0915a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.nineoldandroids.a.aa */
public class C0919aa extends C0916a {
    /* renamed from: h */
    private static ThreadLocal<C0917a> f2262h = new ThreadLocal();
    /* renamed from: i */
    private static final ThreadLocal<ArrayList<C0919aa>> f2263i = new C0920ab();
    /* renamed from: j */
    private static final ThreadLocal<ArrayList<C0919aa>> f2264j = new C0921ac();
    /* renamed from: k */
    private static final ThreadLocal<ArrayList<C0919aa>> f2265k = new C0922ad();
    /* renamed from: l */
    private static final ThreadLocal<ArrayList<C0919aa>> f2266l = new C0923ae();
    /* renamed from: m */
    private static final ThreadLocal<ArrayList<C0919aa>> f2267m = new C0924af();
    /* renamed from: n */
    private static final Interpolator f2268n = new AccelerateDecelerateInterpolator();
    /* renamed from: o */
    private static final C0926z f2269o = new C0930e();
    /* renamed from: p */
    private static final C0926z f2270p = new C0927c();
    /* renamed from: z */
    private static long f2271z = 10;
    /* renamed from: A */
    private int f2272A = 0;
    /* renamed from: B */
    private int f2273B = 1;
    /* renamed from: C */
    private Interpolator f2274C = f2268n;
    /* renamed from: D */
    private ArrayList<C0918b> f2275D = null;
    /* renamed from: b */
    long f2276b;
    /* renamed from: c */
    long f2277c = -1;
    /* renamed from: d */
    int f2278d = 0;
    /* renamed from: e */
    boolean f2279e = false;
    /* renamed from: f */
    C0954y[] f2280f;
    /* renamed from: g */
    HashMap<String, C0954y> f2281g;
    /* renamed from: q */
    private boolean f2282q = false;
    /* renamed from: r */
    private int f2283r = 0;
    /* renamed from: s */
    private float f2284s = 0.0f;
    /* renamed from: t */
    private boolean f2285t = false;
    /* renamed from: u */
    private long f2286u;
    /* renamed from: v */
    private boolean f2287v = false;
    /* renamed from: w */
    private boolean f2288w = false;
    /* renamed from: x */
    private long f2289x = 300;
    /* renamed from: y */
    private long f2290y = 0;

    /* renamed from: com.nineoldandroids.a.aa$a */
    private static class C0917a extends Handler {
        private C0917a() {
        }

        /* synthetic */ C0917a(byte b) {
            this();
        }

        public final void handleMessage(Message message) {
            ArrayList arrayList;
            Object obj;
            ArrayList arrayList2;
            int size;
            int i;
            C0919aa c0919aa;
            ArrayList arrayList3 = (ArrayList) C0919aa.f2263i.get();
            ArrayList arrayList4 = (ArrayList) C0919aa.f2265k.get();
            switch (message.what) {
                case 0:
                    arrayList = (ArrayList) C0919aa.f2264j.get();
                    if (arrayList3.size() > 0 || arrayList4.size() > 0) {
                        obj = null;
                    } else {
                        int obj2 = 1;
                    }
                    while (arrayList.size() > 0) {
                        arrayList2 = (ArrayList) arrayList.clone();
                        arrayList.clear();
                        size = arrayList2.size();
                        for (i = 0; i < size; i++) {
                            c0919aa = (C0919aa) arrayList2.get(i);
                            if (c0919aa.f2290y == 0) {
                                C0919aa.m2521b(c0919aa);
                            } else {
                                arrayList4.add(c0919aa);
                            }
                        }
                    }
                    break;
                case 1:
                    obj2 = 1;
                    break;
                default:
                    return;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            arrayList = (ArrayList) C0919aa.f2267m.get();
            arrayList2 = (ArrayList) C0919aa.f2266l.get();
            size = arrayList4.size();
            for (i = 0; i < size; i++) {
                c0919aa = (C0919aa) arrayList4.get(i);
                if (C0919aa.m2518a(c0919aa, currentAnimationTimeMillis)) {
                    arrayList.add(c0919aa);
                }
            }
            size = arrayList.size();
            if (size > 0) {
                for (i = 0; i < size; i++) {
                    c0919aa = (C0919aa) arrayList.get(i);
                    C0919aa.m2521b(c0919aa);
                    c0919aa.f2287v = true;
                    arrayList4.remove(c0919aa);
                }
                arrayList.clear();
            }
            i = 0;
            int size2 = arrayList3.size();
            while (i < size2) {
                C0919aa c0919aa2 = (C0919aa) arrayList3.get(i);
                if (c0919aa2.mo6041c(currentAnimationTimeMillis)) {
                    arrayList2.add(c0919aa2);
                }
                if (arrayList3.size() == size2) {
                    i++;
                } else {
                    size2--;
                    arrayList2.remove(c0919aa2);
                }
            }
            if (arrayList2.size() > 0) {
                int i2 = 0;
                while (true) {
                    size2 = i2;
                    if (size2 < arrayList2.size()) {
                        ((C0919aa) arrayList2.get(size2)).mo6065e();
                        i2 = size2 + 1;
                    } else {
                        arrayList2.clear();
                    }
                }
            }
            if (obj2 == null) {
                return;
            }
            if (!arrayList3.isEmpty() || !arrayList4.isEmpty()) {
                sendEmptyMessageDelayed(1, Math.max(0, C0919aa.f2271z - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
            }
        }
    }

    /* renamed from: com.nineoldandroids.a.aa$b */
    public interface C0918b {
        /* renamed from: a */
        void mo6032a(C0919aa c0919aa);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m2518a(C0919aa c0919aa, long j) {
        if (c0919aa.f2285t) {
            long j2 = j - c0919aa.f2286u;
            if (j2 > c0919aa.f2290y) {
                c0919aa.f2276b = j - (j2 - c0919aa.f2290y);
                c0919aa.f2278d = 1;
                return true;
            }
        }
        c0919aa.f2285t = true;
        c0919aa.f2286u = j;
        return false;
    }

    /* renamed from: b */
    public static C0919aa m2519b(float... fArr) {
        C0919aa c0919aa = new C0919aa();
        c0919aa.mo6037a(fArr);
        return c0919aa;
    }

    /* renamed from: b */
    public static C0919aa m2520b(int... iArr) {
        C0919aa c0919aa = new C0919aa();
        c0919aa.mo6038a(iArr);
        return c0919aa;
    }

    /* renamed from: d */
    private void m2523d(long j) {
        mo6042d();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f2278d != 1) {
            this.f2277c = j;
            this.f2278d = 2;
        }
        this.f2276b = currentAnimationTimeMillis - j;
        mo6041c(currentAnimationTimeMillis);
    }

    /* renamed from: e */
    private void mo6065e() {
        ((ArrayList) f2263i.get()).remove(this);
        ((ArrayList) f2264j.get()).remove(this);
        ((ArrayList) f2265k.get()).remove(this);
        this.f2278d = 0;
        if (this.f2287v && this.f2261a != null) {
            ArrayList arrayList = (ArrayList) this.f2261a.clone();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((C0915a) arrayList.get(i)).mo6023b(this);
            }
        }
        this.f2287v = false;
        this.f2288w = false;
    }

    /* renamed from: a */
    public C0919aa mo6033a(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.f2289x = j;
        return this;
    }

    /* renamed from: a */
    public void mo6026a() {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        }
        this.f2282q = false;
        this.f2283r = 0;
        this.f2278d = 0;
        this.f2288w = true;
        this.f2285t = false;
        ((ArrayList) f2264j.get()).add(this);
        if (this.f2290y == 0) {
            long currentAnimationTimeMillis = (!this.f2279e || this.f2278d == 0) ? 0 : AnimationUtils.currentAnimationTimeMillis() - this.f2276b;
            m2523d(currentAnimationTimeMillis);
            this.f2278d = 0;
            this.f2287v = true;
            if (this.f2261a != null) {
                ArrayList arrayList = (ArrayList) this.f2261a.clone();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((C0915a) arrayList.get(i)).mo6022a(this);
                }
            }
        }
        C0917a c0917a = (C0917a) f2262h.get();
        if (c0917a == null) {
            c0917a = new C0917a();
            f2262h.set(c0917a);
        }
        c0917a.sendEmptyMessage(0);
    }

    /* renamed from: a */
    void mo6034a(float f) {
        int i;
        float interpolation = this.f2274C.getInterpolation(f);
        this.f2284s = interpolation;
        for (C0954y a : this.f2280f) {
            a.mo6072a(interpolation);
        }
        if (this.f2275D != null) {
            int size = this.f2275D.size();
            for (i = 0; i < size; i++) {
                ((C0918b) this.f2275D.get(i)).mo6032a(this);
            }
        }
    }

    /* renamed from: a */
    public final void mo6035a(Interpolator interpolator) {
        if (interpolator != null) {
            this.f2274C = interpolator;
        } else {
            this.f2274C = new LinearInterpolator();
        }
    }

    /* renamed from: a */
    public final void mo6036a(C0918b c0918b) {
        if (this.f2275D == null) {
            this.f2275D = new ArrayList();
        }
        this.f2275D.add(c0918b);
    }

    /* renamed from: a */
    public void mo6037a(float... fArr) {
        if (fArr != null && fArr.length != 0) {
            if (this.f2280f == null || this.f2280f.length == 0) {
                mo6039a(C0954y.m2627a("", fArr));
            } else {
                this.f2280f[0].mo6076a(fArr);
            }
            this.f2279e = false;
        }
    }

    /* renamed from: a */
    public void mo6038a(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            if (this.f2280f == null || this.f2280f.length == 0) {
                mo6039a(C0954y.m2628a("", iArr));
            } else {
                this.f2280f[0].mo6077a(iArr);
            }
            this.f2279e = false;
        }
    }

    /* renamed from: a */
    public final void mo6039a(C0954y... c0954yArr) {
        this.f2280f = c0954yArr;
        this.f2281g = new HashMap(r2);
        for (C0954y c0954y : c0954yArr) {
            this.f2281g.put(c0954y.f2338a, c0954y);
        }
        this.f2279e = false;
    }

    /* renamed from: b */
    public final void mo6028b() {
        if (this.f2278d != 0 || ((ArrayList) f2264j.get()).contains(this) || ((ArrayList) f2265k.get()).contains(this)) {
            if (this.f2287v && this.f2261a != null) {
                Iterator it = ((ArrayList) this.f2261a.clone()).iterator();
                while (it.hasNext()) {
                    ((C0915a) it.next()).mo6024c(this);
                }
            }
            mo6065e();
        }
    }

    /* renamed from: b */
    public final void mo6040b(long j) {
        this.f2290y = j;
    }

    /* renamed from: c */
    final boolean mo6041c(long j) {
        boolean z = false;
        if (this.f2278d == 0) {
            this.f2278d = 1;
            if (this.f2277c < 0) {
                this.f2276b = j;
            } else {
                this.f2276b = j - this.f2277c;
                this.f2277c = -1;
            }
        }
        switch (this.f2278d) {
            case 1:
            case 2:
                float f;
                float f2 = this.f2289x > 0 ? ((float) (j - this.f2276b)) / ((float) this.f2289x) : 1.0f;
                if (f2 < 1.0f) {
                    f = f2;
                } else if (this.f2283r < this.f2272A || this.f2272A == -1) {
                    if (this.f2261a != null) {
                        int size = this.f2261a.size();
                        for (int i = 0; i < size; i++) {
                            ((C0915a) this.f2261a.get(i)).mo6025d(this);
                        }
                    }
                    if (this.f2273B == 2) {
                        this.f2282q = !this.f2282q;
                    }
                    this.f2283r += (int) f2;
                    f = f2 % 1.0f;
                    this.f2276b += this.f2289x;
                } else {
                    f = Math.min(f2, 1.0f);
                    z = true;
                }
                if (this.f2282q) {
                    f = 1.0f - f;
                }
                mo6034a(f);
                break;
        }
        return z;
    }

    /* renamed from: d */
    void mo6042d() {
        if (!this.f2279e) {
            for (C0954y b : this.f2280f) {
                b.mo6078b();
            }
            this.f2279e = true;
        }
    }

    /* renamed from: f */
    public C0919aa clone() {
        int i = 0;
        C0919aa c0919aa = (C0919aa) super.clone();
        if (this.f2275D != null) {
            ArrayList arrayList = this.f2275D;
            c0919aa.f2275D = new ArrayList();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                c0919aa.f2275D.add(arrayList.get(i2));
            }
        }
        c0919aa.f2277c = -1;
        c0919aa.f2282q = false;
        c0919aa.f2283r = 0;
        c0919aa.f2279e = false;
        c0919aa.f2278d = 0;
        c0919aa.f2285t = false;
        C0954y[] c0954yArr = this.f2280f;
        if (c0954yArr != null) {
            int length = c0954yArr.length;
            c0919aa.f2280f = new C0954y[length];
            c0919aa.f2281g = new HashMap(length);
            while (i < length) {
                C0954y a = c0954yArr[i].clone();
                c0919aa.f2280f[i] = a;
                c0919aa.f2281g.put(a.f2338a, a);
                i++;
            }
        }
        return c0919aa;
    }

    /* renamed from: g */
    public final Object mo6044g() {
        return (this.f2280f == null || this.f2280f.length <= 0) ? null : this.f2280f[0].mo6080c();
    }

    /* renamed from: h */
    public final float mo6045h() {
        return this.f2284s;
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.f2280f != null) {
            for (C0954y c0954y : this.f2280f) {
                str = str + "\n    " + c0954y.toString();
            }
        }
        return str;
    }
}
