package com.google.gson.internal.p053a;

import com.google.gson.C0591m;
import com.google.gson.C0592k;
import com.google.gson.C0593n;
import com.google.gson.C0594o;
import com.google.gson.C0595p;
import com.google.gson.stream.C0534c;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.gson.internal.a.i */
public final class C0535i extends C0534c {
    /* renamed from: a */
    private static final Writer f1333a = new C0536j();
    /* renamed from: b */
    private static final C0595p f1334b = new C0595p("closed");
    /* renamed from: c */
    private final List<C0591m> f1335c = new ArrayList();
    /* renamed from: d */
    private String f1336d;
    /* renamed from: e */
    private C0591m f1337e = C0593n.f1463a;

    public C0535i() {
        super(f1333a);
    }

    /* renamed from: a */
    private void m1201a(C0591m c0591m) {
        if (this.f1336d != null) {
            if (!(c0591m instanceof C0593n) || mo5523i()) {
                ((C0594o) m1202j()).mo5560a(this.f1336d, c0591m);
            }
            this.f1336d = null;
        } else if (this.f1335c.isEmpty()) {
            this.f1337e = c0591m;
        } else {
            C0591m j = m1202j();
            if (j instanceof C0592k) {
                ((C0592k) j).mo5554a(c0591m);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: j */
    private C0591m m1202j() {
        return (C0591m) this.f1335c.get(this.f1335c.size() - 1);
    }

    /* renamed from: a */
    public final C0591m mo5524a() {
        if (this.f1335c.isEmpty()) {
            return this.f1337e;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f1335c);
    }

    /* renamed from: a */
    public final C0534c mo5505a(long j) {
        m1201a(new C0595p(Long.valueOf(j)));
        return this;
    }

    /* renamed from: a */
    public final C0534c mo5506a(Number number) {
        if (number == null) {
            return mo5519f();
        }
        if (!mo5521g()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        m1201a(new C0595p(number));
        return this;
    }

    /* renamed from: a */
    public final C0534c mo5507a(String str) {
        if (this.f1335c.isEmpty() || this.f1336d != null) {
            throw new IllegalStateException();
        } else if (m1202j() instanceof C0594o) {
            this.f1336d = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    public final C0534c mo5508a(boolean z) {
        m1201a(new C0595p(Boolean.valueOf(z)));
        return this;
    }

    /* renamed from: b */
    public final C0534c mo5509b() {
        C0591m c0592k = new C0592k();
        m1201a(c0592k);
        this.f1335c.add(c0592k);
        return this;
    }

    /* renamed from: b */
    public final C0534c mo5510b(String str) {
        if (str == null) {
            return mo5519f();
        }
        m1201a(new C0595p(str));
        return this;
    }

    /* renamed from: c */
    public final C0534c mo5512c() {
        if (this.f1335c.isEmpty() || this.f1336d != null) {
            throw new IllegalStateException();
        } else if (m1202j() instanceof C0592k) {
            this.f1335c.remove(this.f1335c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public final void close() {
        if (this.f1335c.isEmpty()) {
            this.f1335c.add(f1334b);
            return;
        }
        throw new IOException("Incomplete document");
    }

    /* renamed from: d */
    public final C0534c mo5516d() {
        C0591m c0594o = new C0594o();
        m1201a(c0594o);
        this.f1335c.add(c0594o);
        return this;
    }

    /* renamed from: e */
    public final C0534c mo5518e() {
        if (this.f1335c.isEmpty() || this.f1336d != null) {
            throw new IllegalStateException();
        } else if (m1202j() instanceof C0594o) {
            this.f1335c.remove(this.f1335c.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    /* renamed from: f */
    public final C0534c mo5519f() {
        m1201a(C0593n.f1463a);
        return this;
    }

    public final void flush() {
    }
}
