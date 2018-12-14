package com.nineoldandroids.util;

/* renamed from: com.nineoldandroids.util.c */
public abstract class C0937c<T, V> {
    /* renamed from: a */
    private final String f2329a;
    /* renamed from: b */
    private final Class<V> f2330b;

    public C0937c(Class<V> cls, String str) {
        this.f2329a = str;
        this.f2330b = cls;
    }

    /* renamed from: a */
    public abstract V mo6066a(T t);

    /* renamed from: a */
    public final String mo6067a() {
        return this.f2329a;
    }

    /* renamed from: a */
    public void mo6068a(T t, V v) {
        throw new UnsupportedOperationException("Property " + this.f2329a + " is read-only");
    }
}
