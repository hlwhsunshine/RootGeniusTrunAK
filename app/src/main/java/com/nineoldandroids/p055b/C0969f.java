package com.nineoldandroids.p055b;

import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.p054a.C0916a;
import com.nineoldandroids.p054a.C0916a.C0915a;
import com.nineoldandroids.p054a.C0919aa;
import com.nineoldandroids.p054a.C0919aa.C0918b;
import com.nineoldandroids.p055b.p056a.C0957a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.nineoldandroids.b.f */
final class C0969f extends C0958a {
    /* renamed from: a */
    ArrayList<C0967b> f2401a = new ArrayList();
    /* renamed from: b */
    private final C0957a f2402b;
    /* renamed from: c */
    private final WeakReference<View> f2403c;
    /* renamed from: d */
    private long f2404d;
    /* renamed from: e */
    private boolean f2405e = false;
    /* renamed from: f */
    private long f2406f = 0;
    /* renamed from: g */
    private boolean f2407g = false;
    /* renamed from: h */
    private Interpolator f2408h;
    /* renamed from: i */
    private boolean f2409i = false;
    /* renamed from: j */
    private C0915a f2410j = null;
    /* renamed from: k */
    private C0966a f2411k = new C0966a(this, (byte) 0);
    /* renamed from: l */
    private Runnable f2412l = new C0970g(this);
    /* renamed from: m */
    private HashMap<C0916a, C0968c> f2413m = new HashMap();

    /* renamed from: com.nineoldandroids.b.f$a */
    private class C0966a implements C0915a, C0918b {
        private C0966a() {
        }

        /* synthetic */ C0966a(C0969f c0969f, byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo6022a(C0916a c0916a) {
            if (C0969f.this.f2410j != null) {
                C0969f.this.f2410j.mo6022a(c0916a);
            }
        }

        /* renamed from: a */
        public final void mo6032a(C0919aa c0919aa) {
            float h = c0919aa.mo6045h();
            C0968c c0968c = (C0968c) C0969f.this.f2413m.get(c0919aa);
            if ((c0968c.f2399a & 511) != 0) {
                View view = (View) C0969f.this.f2403c.get();
                if (view != null) {
                    view.invalidate();
                }
            }
            ArrayList arrayList = c0968c.f2400b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    C0967b c0967b = (C0967b) arrayList.get(i);
                    C0969f.m2721a(C0969f.this, c0967b.f2396a, c0967b.f2397b + (c0967b.f2398c * h));
                }
            }
            View view2 = (View) C0969f.this.f2403c.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }

        /* renamed from: b */
        public final void mo6023b(C0916a c0916a) {
            if (C0969f.this.f2410j != null) {
                C0969f.this.f2410j.mo6023b(c0916a);
            }
            C0969f.this.f2413m.remove(c0916a);
            if (C0969f.this.f2413m.isEmpty()) {
                C0969f.this.f2410j = null;
            }
        }

        /* renamed from: c */
        public final void mo6024c(C0916a c0916a) {
            if (C0969f.this.f2410j != null) {
                C0969f.this.f2410j.mo6024c(c0916a);
            }
        }

        /* renamed from: d */
        public final void mo6025d(C0916a c0916a) {
            if (C0969f.this.f2410j != null) {
                C0969f.this.f2410j.mo6025d(c0916a);
            }
        }
    }

    /* renamed from: com.nineoldandroids.b.f$b */
    private static class C0967b {
        /* renamed from: a */
        int f2396a;
        /* renamed from: b */
        float f2397b;
        /* renamed from: c */
        float f2398c;

        C0967b(int i, float f, float f2) {
            this.f2396a = i;
            this.f2397b = f;
            this.f2398c = f2;
        }
    }

    /* renamed from: com.nineoldandroids.b.f$c */
    private static class C0968c {
        /* renamed from: a */
        int f2399a;
        /* renamed from: b */
        ArrayList<C0967b> f2400b;

        C0968c(int i, ArrayList<C0967b> arrayList) {
            this.f2399a = i;
            this.f2400b = arrayList;
        }
    }

    C0969f(View view) {
        this.f2403c = new WeakReference(view);
        this.f2402b = C0957a.m2656a(view);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0062  */
    /* renamed from: a */
    private void m2719a(int r11, float r12) {
        /*
        r10 = this;
        r5 = 0;
        switch(r11) {
            case 1: goto L_0x0084;
            case 2: goto L_0x008d;
            case 4: goto L_0x00b1;
            case 8: goto L_0x00ba;
            case 16: goto L_0x0096;
            case 32: goto L_0x009f;
            case 64: goto L_0x00a8;
            case 128: goto L_0x00c3;
            case 256: goto L_0x00cc;
            case 512: goto L_0x00d5;
            default: goto L_0x0004;
        };
    L_0x0004:
        r0 = 0;
        r3 = r0;
    L_0x0006:
        r7 = r12 - r3;
        r0 = r10.f2413m;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x0065;
    L_0x0010:
        r4 = 0;
        r0 = r10.f2413m;
        r0 = r0.keySet();
        r8 = r0.iterator();
    L_0x001b:
        r0 = r8.hasNext();
        if (r0 == 0) goto L_0x00e6;
    L_0x0021:
        r0 = r8.next();
        r0 = (com.nineoldandroids.p054a.C0916a) r0;
        r1 = r10.f2413m;
        r1 = r1.get(r0);
        r1 = (com.nineoldandroids.p055b.C0969f.C0968c) r1;
        r2 = r1.f2399a;
        r2 = r2 & r11;
        if (r2 == 0) goto L_0x00e3;
    L_0x0034:
        r2 = r1.f2400b;
        if (r2 == 0) goto L_0x00e3;
    L_0x0038:
        r2 = r1.f2400b;
        r9 = r2.size();
        r6 = r5;
    L_0x003f:
        if (r6 >= r9) goto L_0x00e3;
    L_0x0041:
        r2 = r1.f2400b;
        r2 = r2.get(r6);
        r2 = (com.nineoldandroids.p055b.C0969f.C0967b) r2;
        r2 = r2.f2396a;
        if (r2 != r11) goto L_0x00de;
    L_0x004d:
        r2 = r1.f2400b;
        r2.remove(r6);
        r2 = r1.f2399a;
        r6 = r11 ^ -1;
        r2 = r2 & r6;
        r1.f2399a = r2;
        r2 = 1;
    L_0x005a:
        if (r2 == 0) goto L_0x001b;
    L_0x005c:
        r1 = r1.f2399a;
        if (r1 != 0) goto L_0x001b;
    L_0x0060:
        if (r0 == 0) goto L_0x0065;
    L_0x0062:
        r0.mo6028b();
    L_0x0065:
        r0 = new com.nineoldandroids.b.f$b;
        r0.<init>(r11, r3, r7);
        r1 = r10.f2401a;
        r1.add(r0);
        r0 = r10.f2403c;
        r0 = r0.get();
        r0 = (android.view.View) r0;
        if (r0 == 0) goto L_0x0083;
    L_0x0079:
        r1 = r10.f2412l;
        r0.removeCallbacks(r1);
        r1 = r10.f2412l;
        r0.post(r1);
    L_0x0083:
        return;
    L_0x0084:
        r0 = r10.f2402b;
        r0 = r0.mo6106k();
        r3 = r0;
        goto L_0x0006;
    L_0x008d:
        r0 = r10.f2402b;
        r0 = r0.mo6108l();
        r3 = r0;
        goto L_0x0006;
    L_0x0096:
        r0 = r10.f2402b;
        r0 = r0.mo6092d();
        r3 = r0;
        goto L_0x0006;
    L_0x009f:
        r0 = r10.f2402b;
        r0 = r0.mo6094e();
        r3 = r0;
        goto L_0x0006;
    L_0x00a8:
        r0 = r10.f2402b;
        r0 = r0.mo6096f();
        r3 = r0;
        goto L_0x0006;
    L_0x00b1:
        r0 = r10.f2402b;
        r0 = r0.mo6098g();
        r3 = r0;
        goto L_0x0006;
    L_0x00ba:
        r0 = r10.f2402b;
        r0 = r0.mo6100h();
        r3 = r0;
        goto L_0x0006;
    L_0x00c3:
        r0 = r10.f2402b;
        r0 = r0.mo6110m();
        r3 = r0;
        goto L_0x0006;
    L_0x00cc:
        r0 = r10.f2402b;
        r0 = r0.mo6111n();
        r3 = r0;
        goto L_0x0006;
    L_0x00d5:
        r0 = r10.f2402b;
        r0 = r0.mo6083a();
        r3 = r0;
        goto L_0x0006;
    L_0x00de:
        r2 = r6 + 1;
        r6 = r2;
        goto L_0x003f;
    L_0x00e3:
        r2 = r5;
        goto L_0x005a;
    L_0x00e6:
        r0 = r4;
        goto L_0x0060;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nineoldandroids.b.f.a(int, float):void");
    }

    /* renamed from: a */
    static /* synthetic */ void m2721a(C0969f c0969f, int i, float f) {
        switch (i) {
            case 1:
                c0969f.f2402b.mo6103i(f);
                return;
            case 2:
                c0969f.f2402b.mo6105j(f);
                return;
            case 4:
                c0969f.f2402b.mo6099g(f);
                return;
            case 8:
                c0969f.f2402b.mo6101h(f);
                return;
            case 16:
                c0969f.f2402b.mo6093d(f);
                return;
            case 32:
                c0969f.f2402b.mo6095e(f);
                return;
            case 64:
                c0969f.f2402b.mo6097f(f);
                return;
            case 128:
                c0969f.f2402b.mo6107k(f);
                return;
            case 256:
                c0969f.f2402b.mo6109l(f);
                return;
            case 512:
                c0969f.f2402b.mo6084a(f);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public final C0958a mo6112a() {
        m2719a(512, 1.0f);
        return this;
    }

    /* renamed from: a */
    public final C0958a mo6113a(float f) {
        m2719a(1, f);
        return this;
    }

    /* renamed from: a */
    public final C0958a mo6114a(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.f2405e = true;
        this.f2404d = j;
        return this;
    }

    /* renamed from: a */
    public final C0958a mo6115a(C0915a c0915a) {
        this.f2410j = c0915a;
        return this;
    }
}
