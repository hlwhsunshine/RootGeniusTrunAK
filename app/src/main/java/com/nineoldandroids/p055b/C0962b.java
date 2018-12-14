package com.nineoldandroids.p055b;

import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.p054a.C0916a;
import com.nineoldandroids.p054a.C0916a.C0915a;
import com.nineoldandroids.p054a.C0919aa;
import com.nineoldandroids.p054a.C0919aa.C0918b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.nineoldandroids.b.b */
final class C0962b extends C0958a {
    /* renamed from: a */
    ArrayList<C0960b> f2379a = new ArrayList();
    /* renamed from: b */
    private final WeakReference<View> f2380b;
    /* renamed from: c */
    private long f2381c;
    /* renamed from: d */
    private boolean f2382d = false;
    /* renamed from: e */
    private long f2383e = 0;
    /* renamed from: f */
    private boolean f2384f = false;
    /* renamed from: g */
    private Interpolator f2385g;
    /* renamed from: h */
    private boolean f2386h = false;
    /* renamed from: i */
    private C0915a f2387i = null;
    /* renamed from: j */
    private C0959a f2388j = new C0959a(this, (byte) 0);
    /* renamed from: k */
    private Runnable f2389k = new C0963c(this);
    /* renamed from: l */
    private HashMap<C0916a, C0961c> f2390l = new HashMap();

    /* renamed from: com.nineoldandroids.b.b$a */
    private class C0959a implements C0915a, C0918b {
        private C0959a() {
        }

        /* synthetic */ C0959a(C0962b c0962b, byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo6022a(C0916a c0916a) {
            if (C0962b.this.f2387i != null) {
                C0962b.this.f2387i.mo6022a(c0916a);
            }
        }

        /* renamed from: a */
        public final void mo6032a(C0919aa c0919aa) {
            float h = c0919aa.mo6045h();
            C0961c c0961c = (C0961c) C0962b.this.f2390l.get(c0919aa);
            if ((c0961c.f2377a & 511) != 0) {
                View view = (View) C0962b.this.f2380b.get();
                if (view != null) {
                    view.invalidate();
                }
            }
            ArrayList arrayList = c0961c.f2378b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    C0960b c0960b = (C0960b) arrayList.get(i);
                    C0962b.m2701a(C0962b.this, c0960b.f2374a, c0960b.f2375b + (c0960b.f2376c * h));
                }
            }
            View view2 = (View) C0962b.this.f2380b.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }

        /* renamed from: b */
        public final void mo6023b(C0916a c0916a) {
            if (C0962b.this.f2387i != null) {
                C0962b.this.f2387i.mo6023b(c0916a);
            }
            C0962b.this.f2390l.remove(c0916a);
            if (C0962b.this.f2390l.isEmpty()) {
                C0962b.this.f2387i = null;
            }
        }

        /* renamed from: c */
        public final void mo6024c(C0916a c0916a) {
            if (C0962b.this.f2387i != null) {
                C0962b.this.f2387i.mo6024c(c0916a);
            }
        }

        /* renamed from: d */
        public final void mo6025d(C0916a c0916a) {
            if (C0962b.this.f2387i != null) {
                C0962b.this.f2387i.mo6025d(c0916a);
            }
        }
    }

    /* renamed from: com.nineoldandroids.b.b$b */
    private static class C0960b {
        /* renamed from: a */
        int f2374a;
        /* renamed from: b */
        float f2375b;
        /* renamed from: c */
        float f2376c;

        C0960b(int i, float f, float f2) {
            this.f2374a = i;
            this.f2375b = f;
            this.f2376c = f2;
        }
    }

    /* renamed from: com.nineoldandroids.b.b$c */
    private static class C0961c {
        /* renamed from: a */
        int f2377a;
        /* renamed from: b */
        ArrayList<C0960b> f2378b;

        C0961c(int i, ArrayList<C0960b> arrayList) {
            this.f2377a = i;
            this.f2378b = arrayList;
        }
    }

    C0962b(View view) {
        this.f2380b = new WeakReference(view);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006c  */
    /* renamed from: a */
    private void m2699a(int r11, float r12) {
        /*
        r10 = this;
        r5 = 0;
        r0 = r10.f2380b;
        r0 = r0.get();
        r0 = (android.view.View) r0;
        if (r0 == 0) goto L_0x000e;
    L_0x000b:
        switch(r11) {
            case 1: goto L_0x008e;
            case 2: goto L_0x0095;
            case 4: goto L_0x00b1;
            case 8: goto L_0x00b8;
            case 16: goto L_0x009c;
            case 32: goto L_0x00a3;
            case 64: goto L_0x00aa;
            case 128: goto L_0x00bf;
            case 256: goto L_0x00c6;
            case 512: goto L_0x00cd;
            default: goto L_0x000e;
        };
    L_0x000e:
        r0 = 0;
        r3 = r0;
    L_0x0010:
        r7 = r12 - r3;
        r0 = r10.f2390l;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x006f;
    L_0x001a:
        r4 = 0;
        r0 = r10.f2390l;
        r0 = r0.keySet();
        r8 = r0.iterator();
    L_0x0025:
        r0 = r8.hasNext();
        if (r0 == 0) goto L_0x00db;
    L_0x002b:
        r0 = r8.next();
        r0 = (com.nineoldandroids.p054a.C0916a) r0;
        r1 = r10.f2390l;
        r1 = r1.get(r0);
        r1 = (com.nineoldandroids.p055b.C0962b.C0961c) r1;
        r2 = r1.f2377a;
        r2 = r2 & r11;
        if (r2 == 0) goto L_0x00d9;
    L_0x003e:
        r2 = r1.f2378b;
        if (r2 == 0) goto L_0x00d9;
    L_0x0042:
        r2 = r1.f2378b;
        r9 = r2.size();
        r6 = r5;
    L_0x0049:
        if (r6 >= r9) goto L_0x00d9;
    L_0x004b:
        r2 = r1.f2378b;
        r2 = r2.get(r6);
        r2 = (com.nineoldandroids.p055b.C0962b.C0960b) r2;
        r2 = r2.f2374a;
        if (r2 != r11) goto L_0x00d4;
    L_0x0057:
        r2 = r1.f2378b;
        r2.remove(r6);
        r2 = r1.f2377a;
        r6 = r11 ^ -1;
        r2 = r2 & r6;
        r1.f2377a = r2;
        r2 = 1;
    L_0x0064:
        if (r2 == 0) goto L_0x0025;
    L_0x0066:
        r1 = r1.f2377a;
        if (r1 != 0) goto L_0x0025;
    L_0x006a:
        if (r0 == 0) goto L_0x006f;
    L_0x006c:
        r0.mo6028b();
    L_0x006f:
        r0 = new com.nineoldandroids.b.b$b;
        r0.<init>(r11, r3, r7);
        r1 = r10.f2379a;
        r1.add(r0);
        r0 = r10.f2380b;
        r0 = r0.get();
        r0 = (android.view.View) r0;
        if (r0 == 0) goto L_0x008d;
    L_0x0083:
        r1 = r10.f2389k;
        r0.removeCallbacks(r1);
        r1 = r10.f2389k;
        r0.post(r1);
    L_0x008d:
        return;
    L_0x008e:
        r0 = r0.getTranslationX();
        r3 = r0;
        goto L_0x0010;
    L_0x0095:
        r0 = r0.getTranslationY();
        r3 = r0;
        goto L_0x0010;
    L_0x009c:
        r0 = r0.getRotation();
        r3 = r0;
        goto L_0x0010;
    L_0x00a3:
        r0 = r0.getRotationX();
        r3 = r0;
        goto L_0x0010;
    L_0x00aa:
        r0 = r0.getRotationY();
        r3 = r0;
        goto L_0x0010;
    L_0x00b1:
        r0 = r0.getScaleX();
        r3 = r0;
        goto L_0x0010;
    L_0x00b8:
        r0 = r0.getScaleY();
        r3 = r0;
        goto L_0x0010;
    L_0x00bf:
        r0 = r0.getX();
        r3 = r0;
        goto L_0x0010;
    L_0x00c6:
        r0 = r0.getY();
        r3 = r0;
        goto L_0x0010;
    L_0x00cd:
        r0 = r0.getAlpha();
        r3 = r0;
        goto L_0x0010;
    L_0x00d4:
        r2 = r6 + 1;
        r6 = r2;
        goto L_0x0049;
    L_0x00d9:
        r2 = r5;
        goto L_0x0064;
    L_0x00db:
        r0 = r4;
        goto L_0x006a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nineoldandroids.b.b.a(int, float):void");
    }

    /* renamed from: a */
    static /* synthetic */ void m2701a(C0962b c0962b, int i, float f) {
        View view = (View) c0962b.f2380b.get();
        if (view != null) {
            switch (i) {
                case 1:
                    view.setTranslationX(f);
                    return;
                case 2:
                    view.setTranslationY(f);
                    return;
                case 4:
                    view.setScaleX(f);
                    return;
                case 8:
                    view.setScaleY(f);
                    return;
                case 16:
                    view.setRotation(f);
                    return;
                case 32:
                    view.setRotationX(f);
                    return;
                case 64:
                    view.setRotationY(f);
                    return;
                case 128:
                    view.setX(f);
                    return;
                case 256:
                    view.setY(f);
                    return;
                case 512:
                    view.setAlpha(f);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    public final C0958a mo6112a() {
        m2699a(512, 1.0f);
        return this;
    }

    /* renamed from: a */
    public final C0958a mo6113a(float f) {
        m2699a(1, f);
        return this;
    }

    /* renamed from: a */
    public final C0958a mo6114a(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Animators cannot have negative duration: " + j);
        }
        this.f2382d = true;
        this.f2381c = j;
        return this;
    }

    /* renamed from: a */
    public final C0958a mo6115a(C0915a c0915a) {
        this.f2387i = c0915a;
        return this;
    }
}
