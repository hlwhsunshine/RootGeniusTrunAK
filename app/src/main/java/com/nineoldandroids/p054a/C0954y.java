package com.nineoldandroids.p054a;

import com.nineoldandroids.p054a.C0932g.C0933a;
import com.nineoldandroids.p054a.C0932g.C0934b;
import com.nineoldandroids.util.C0937c;
import com.nineoldandroids.util.C0938a;
import com.nineoldandroids.util.C0941b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: com.nineoldandroids.a.y */
public class C0954y implements Cloneable {
    /* renamed from: i */
    private static final C0926z f2331i = new C0930e();
    /* renamed from: j */
    private static final C0926z f2332j = new C0927c();
    /* renamed from: k */
    private static Class[] f2333k = new Class[]{Float.TYPE, Float.class, Double.TYPE, Integer.TYPE, Double.class, Integer.class};
    /* renamed from: l */
    private static Class[] f2334l = new Class[]{Integer.TYPE, Integer.class, Float.TYPE, Double.TYPE, Float.class, Double.class};
    /* renamed from: m */
    private static Class[] f2335m = new Class[]{Double.TYPE, Double.class, Float.TYPE, Integer.TYPE, Float.class, Integer.class};
    /* renamed from: n */
    private static final HashMap<Class, HashMap<String, Method>> f2336n = new HashMap();
    /* renamed from: o */
    private static final HashMap<Class, HashMap<String, Method>> f2337o = new HashMap();
    /* renamed from: a */
    String f2338a;
    /* renamed from: b */
    protected C0937c f2339b;
    /* renamed from: c */
    Method f2340c;
    /* renamed from: d */
    Class f2341d;
    /* renamed from: e */
    C0928h f2342e;
    /* renamed from: f */
    final ReentrantReadWriteLock f2343f;
    /* renamed from: g */
    final Object[] f2344g;
    /* renamed from: h */
    private Method f2345h;
    /* renamed from: p */
    private C0926z f2346p;
    /* renamed from: q */
    private Object f2347q;

    /* renamed from: com.nineoldandroids.a.y$a */
    static class C0955a extends C0954y {
        /* renamed from: h */
        C0929d f2348h;
        /* renamed from: i */
        float f2349i;
        /* renamed from: j */
        private C0938a f2350j;

        public C0955a(C0937c c0937c, float... fArr) {
            super(c0937c, (byte) 0);
            mo6076a(fArr);
            if (c0937c instanceof C0938a) {
                this.f2350j = (C0938a) this.f2339b;
            }
        }

        public C0955a(String str, C0929d c0929d) {
            super(str, (byte) 0);
            this.f2341d = Float.TYPE;
            this.f2342e = c0929d;
            this.f2348h = (C0929d) this.f2342e;
        }

        public C0955a(String str, float... fArr) {
            super(str, (byte) 0);
            mo6076a(fArr);
        }

        /* renamed from: d */
        private C0955a m2642d() {
            C0955a c0955a = (C0955a) super.clone();
            c0955a.f2348h = (C0929d) c0955a.f2342e;
            return c0955a;
        }

        /* renamed from: a */
        final void mo6072a(float f) {
            this.f2349i = this.f2348h.mo6057b(f);
        }

        /* renamed from: a */
        final void mo6074a(Class cls) {
            if (this.f2339b == null) {
                super.mo6074a(cls);
            }
        }

        /* renamed from: a */
        public final void mo6076a(float... fArr) {
            super.mo6076a(fArr);
            this.f2348h = (C0929d) this.f2342e;
        }

        /* renamed from: b */
        final void mo6079b(Object obj) {
            if (this.f2350j != null) {
                this.f2350j.mo6069a(obj, this.f2349i);
            } else if (this.f2339b != null) {
                this.f2339b.mo6068a(obj, Float.valueOf(this.f2349i));
            } else if (this.f2340c != null) {
                try {
                    this.f2344g[0] = Float.valueOf(this.f2349i);
                    this.f2340c.invoke(obj, this.f2344g);
                } catch (InvocationTargetException e) {
                    e.toString();
                } catch (IllegalAccessException e2) {
                    e2.toString();
                }
            }
        }

        /* renamed from: c */
        final Object mo6080c() {
            return Float.valueOf(this.f2349i);
        }
    }

    /* renamed from: com.nineoldandroids.a.y$b */
    static class C0956b extends C0954y {
        /* renamed from: h */
        C0931f f2351h;
        /* renamed from: i */
        int f2352i;
        /* renamed from: j */
        private C0941b f2353j;

        public C0956b(C0937c c0937c, int... iArr) {
            super(c0937c, (byte) 0);
            mo6077a(iArr);
            if (c0937c instanceof C0941b) {
                this.f2353j = (C0941b) this.f2339b;
            }
        }

        public C0956b(String str, C0931f c0931f) {
            super(str, (byte) 0);
            this.f2341d = Integer.TYPE;
            this.f2342e = c0931f;
            this.f2351h = (C0931f) this.f2342e;
        }

        public C0956b(String str, int... iArr) {
            super(str, (byte) 0);
            mo6077a(iArr);
        }

        /* renamed from: d */
        private C0956b m2649d() {
            C0956b c0956b = (C0956b) super.clone();
            c0956b.f2351h = (C0931f) c0956b.f2342e;
            return c0956b;
        }

        /* renamed from: a */
        final void mo6072a(float f) {
            this.f2352i = this.f2351h.mo6058b(f);
        }

        /* renamed from: a */
        final void mo6074a(Class cls) {
            if (this.f2339b == null) {
                super.mo6074a(cls);
            }
        }

        /* renamed from: a */
        public final void mo6077a(int... iArr) {
            super.mo6077a(iArr);
            this.f2351h = (C0931f) this.f2342e;
        }

        /* renamed from: b */
        final void mo6079b(Object obj) {
            if (this.f2353j != null) {
                this.f2353j.mo6070a(obj, this.f2352i);
            } else if (this.f2339b != null) {
                this.f2339b.mo6068a(obj, Integer.valueOf(this.f2352i));
            } else if (this.f2340c != null) {
                try {
                    this.f2344g[0] = Integer.valueOf(this.f2352i);
                    this.f2340c.invoke(obj, this.f2344g);
                } catch (InvocationTargetException e) {
                    e.toString();
                } catch (IllegalAccessException e2) {
                    e2.toString();
                }
            }
        }

        /* renamed from: c */
        final Object mo6080c() {
            return Integer.valueOf(this.f2352i);
        }
    }

    private C0954y(C0937c c0937c) {
        this.f2340c = null;
        this.f2345h = null;
        this.f2342e = null;
        this.f2343f = new ReentrantReadWriteLock();
        this.f2344g = new Object[1];
        this.f2339b = c0937c;
        if (c0937c != null) {
            this.f2338a = c0937c.mo6067a();
        }
    }

    private C0954y(String str) {
        this.f2340c = null;
        this.f2345h = null;
        this.f2342e = null;
        this.f2343f = new ReentrantReadWriteLock();
        this.f2344g = new Object[1];
        this.f2338a = str;
    }

    /* renamed from: a */
    public static C0954y m2625a(C0937c<?, Float> c0937c, float... fArr) {
        return new C0955a((C0937c) c0937c, fArr);
    }

    /* renamed from: a */
    public static C0954y m2626a(C0937c<?, Integer> c0937c, int... iArr) {
        return new C0956b((C0937c) c0937c, iArr);
    }

    /* renamed from: a */
    public static C0954y m2627a(String str, float... fArr) {
        return new C0955a(str, fArr);
    }

    /* renamed from: a */
    public static C0954y m2628a(String str, int... iArr) {
        return new C0956b(str, iArr);
    }

    /* renamed from: a */
    public static C0954y m2629a(String str, C0932g... c0932gArr) {
        C0928h c0929d;
        int length = c0932gArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i < length) {
            if (!(c0932gArr[i] instanceof C0933a) && (c0932gArr[i] instanceof C0934b)) {
                i4 = 1;
                i++;
            } else {
                i4 = 1;
                i++;
            }
        }
        int i5;
        if (i4 != 0 && i3 == 0 && i2 == 0) {
            C0933a[] c0933aArr = new C0933a[length];
            for (i5 = 0; i5 < length; i5++) {
                c0933aArr[i5] = (C0933a) c0932gArr[i5];
            }
            c0929d = new C0929d(c0933aArr);
        } else if (i3 != 0 && i4 == 0 && i2 == 0) {
            C0934b[] c0934bArr = new C0934b[length];
            for (i5 = 0; i5 < length; i5++) {
                c0934bArr[i5] = (C0934b) c0932gArr[i5];
            }
            c0929d = new C0931f(c0934bArr);
        } else {
            c0929d = new C0928h(c0932gArr);
        }
        if (c0929d instanceof C0931f) {
            return new C0956b(str, (C0931f) c0929d);
        }
        if (c0929d instanceof C0929d) {
            return new C0955a(str, (C0929d) c0929d);
        }
        C0954y c0954y = new C0954y(str);
        c0954y.f2342e = c0929d;
        c0954y.f2341d = c0932gArr[0].f2306b;
        return c0954y;
    }

    /* renamed from: a */
    private Method m2630a(Class cls, String str, Class cls2) {
        Method method = null;
        String str2 = this.f2338a;
        if (!(str2 == null || str2.length() == 0)) {
            str = str + Character.toUpperCase(str2.charAt(0)) + str2.substring(1);
        }
        if (cls2 == null) {
            try {
                return cls.getMethod(str, null);
            } catch (NoSuchMethodException e) {
                Method declaredMethod;
                try {
                    declaredMethod = cls.getDeclaredMethod(str, null);
                    try {
                        declaredMethod.setAccessible(true);
                        return declaredMethod;
                    } catch (NoSuchMethodException e2) {
                    }
                } catch (NoSuchMethodException e3) {
                    declaredMethod = null;
                    new StringBuilder("Couldn't find no-arg method for property ").append(this.f2338a).append(": ").append(e);
                    return declaredMethod;
                }
            }
        }
        Class[] clsArr = new Class[1];
        Class[] clsArr2 = this.f2341d.equals(Float.class) ? f2333k : this.f2341d.equals(Integer.class) ? f2334l : this.f2341d.equals(Double.class) ? f2335m : new Class[]{this.f2341d};
        int length = clsArr2.length;
        int i = 0;
        while (i < length) {
            Class cls3 = clsArr2[i];
            clsArr[0] = cls3;
            try {
                method = cls.getMethod(str, clsArr);
                this.f2341d = cls3;
                return method;
            } catch (NoSuchMethodException e4) {
                try {
                    method = cls.getDeclaredMethod(str, clsArr);
                    method.setAccessible(true);
                    this.f2341d = cls3;
                    return method;
                } catch (NoSuchMethodException e5) {
                    i++;
                }
            }
        }
        new StringBuilder("Couldn't find setter/getter for property ").append(this.f2338a).append(" with value type ").append(this.f2341d);
        return method;
    }

    /* renamed from: a */
    private Method m2631a(Class cls, HashMap<Class, HashMap<String, Method>> hashMap, String str, Class cls2) {
        Method method = null;
        try {
            this.f2343f.writeLock().lock();
            HashMap hashMap2 = (HashMap) hashMap.get(cls);
            if (hashMap2 != null) {
                method = (Method) hashMap2.get(this.f2338a);
            }
            if (method == null) {
                method = m2630a(cls, str, cls2);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap();
                    hashMap.put(cls, hashMap2);
                }
                hashMap2.put(this.f2338a, method);
            }
            Method method2 = method;
            this.f2343f.writeLock().unlock();
            return method2;
        } catch (Throwable th) {
            this.f2343f.writeLock().unlock();
        }
    }

    /* renamed from: a */
    public C0954y clone() {
        try {
            C0954y c0954y = (C0954y) super.clone();
            c0954y.f2338a = this.f2338a;
            c0954y.f2339b = this.f2339b;
            c0954y.f2342e = this.f2342e.clone();
            c0954y.f2346p = this.f2346p;
            return c0954y;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    /* renamed from: a */
    void mo6072a(float f) {
        this.f2347q = this.f2342e.mo6054a(f);
    }

    /* renamed from: a */
    public final void mo6073a(C0937c c0937c) {
        this.f2339b = c0937c;
    }

    /* renamed from: a */
    void mo6074a(Class cls) {
        this.f2340c = m2631a(cls, f2336n, "set", this.f2341d);
    }

    /* renamed from: a */
    final void mo6075a(Object obj) {
        C0932g c0932g;
        if (this.f2339b != null) {
            try {
                this.f2339b.mo6066a(obj);
                Iterator it = this.f2342e.f2295e.iterator();
                while (it.hasNext()) {
                    c0932g = (C0932g) it.next();
                    if (!c0932g.f2307c) {
                        c0932g.mo6061a(this.f2339b.mo6066a(obj));
                    }
                }
                return;
            } catch (ClassCastException e) {
                new StringBuilder("No such property (").append(this.f2339b.mo6067a()).append(") on target object ").append(obj).append(". Trying reflection instead");
                this.f2339b = null;
            }
        }
        Class cls = obj.getClass();
        if (this.f2340c == null) {
            mo6074a(cls);
        }
        Iterator it2 = this.f2342e.f2295e.iterator();
        while (it2.hasNext()) {
            c0932g = (C0932g) it2.next();
            if (!c0932g.f2307c) {
                if (this.f2345h == null) {
                    this.f2345h = m2631a(cls, f2337o, "get", null);
                }
                try {
                    c0932g.mo6061a(this.f2345h.invoke(obj, new Object[0]));
                } catch (InvocationTargetException e2) {
                    e2.toString();
                } catch (IllegalAccessException e3) {
                    e3.toString();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo6076a(float... fArr) {
        int i = 1;
        this.f2341d = Float.TYPE;
        int length = fArr.length;
        C0933a[] c0933aArr = new C0933a[Math.max(length, 2)];
        if (length == 1) {
            c0933aArr[0] = new C0933a();
            c0933aArr[1] = (C0933a) C0932g.m2565a(1.0f, fArr[0]);
        } else {
            c0933aArr[0] = (C0933a) C0932g.m2565a(0.0f, fArr[0]);
            while (i < length) {
                c0933aArr[i] = (C0933a) C0932g.m2565a(((float) i) / ((float) (length - 1)), fArr[i]);
                i++;
            }
        }
        this.f2342e = new C0929d(c0933aArr);
    }

    /* renamed from: a */
    public void mo6077a(int... iArr) {
        int i = 1;
        this.f2341d = Integer.TYPE;
        int length = iArr.length;
        C0934b[] c0934bArr = new C0934b[Math.max(length, 2)];
        if (length == 1) {
            c0934bArr[0] = new C0934b();
            c0934bArr[1] = (C0934b) C0932g.m2566a(1.0f, iArr[0]);
        } else {
            c0934bArr[0] = (C0934b) C0932g.m2566a(0.0f, iArr[0]);
            while (i < length) {
                c0934bArr[i] = (C0934b) C0932g.m2566a(((float) i) / ((float) (length - 1)), iArr[i]);
                i++;
            }
        }
        this.f2342e = new C0931f(c0934bArr);
    }

    /* renamed from: b */
    final void mo6078b() {
        if (this.f2346p == null) {
            C0926z c0926z = this.f2341d == Integer.class ? f2331i : this.f2341d == Float.class ? f2332j : null;
            this.f2346p = c0926z;
        }
        if (this.f2346p != null) {
            this.f2342e.f2296f = this.f2346p;
        }
    }

    /* renamed from: b */
    void mo6079b(Object obj) {
        if (this.f2339b != null) {
            this.f2339b.mo6068a(obj, mo6080c());
        }
        if (this.f2340c != null) {
            try {
                this.f2344g[0] = mo6080c();
                this.f2340c.invoke(obj, this.f2344g);
            } catch (InvocationTargetException e) {
                e.toString();
            } catch (IllegalAccessException e2) {
                e2.toString();
            }
        }
    }

    /* renamed from: c */
    Object mo6080c() {
        return this.f2347q;
    }

    public String toString() {
        return this.f2338a + ": " + this.f2342e.toString();
    }
}
