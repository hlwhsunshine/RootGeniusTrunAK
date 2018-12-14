package com.google.gson.internal.p053a;

import com.google.gson.C0592k;
import com.google.gson.C0593n;
import com.google.gson.C0594o;
import com.google.gson.C0595p;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.JsonToken;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.google.gson.internal.a.g */
public final class C0532g extends C0531a {
    /* renamed from: a */
    private static final Reader f1319a = new C0533h();
    /* renamed from: b */
    private static final Object f1320b = new Object();
    /* renamed from: c */
    private final List<Object> f1321c;

    /* renamed from: a */
    private void m1157a(JsonToken jsonToken) {
        if (mo5490f() != jsonToken) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + mo5490f());
        }
    }

    /* renamed from: r */
    private Object m1158r() {
        return this.f1321c.get(this.f1321c.size() - 1);
    }

    /* renamed from: s */
    private Object m1159s() {
        return this.f1321c.remove(this.f1321c.size() - 1);
    }

    /* renamed from: a */
    public final void mo5483a() {
        m1157a(JsonToken.BEGIN_ARRAY);
        this.f1321c.add(((C0592k) m1158r()).iterator());
    }

    /* renamed from: b */
    public final void mo5485b() {
        m1157a(JsonToken.END_ARRAY);
        m1159s();
        m1159s();
    }

    /* renamed from: c */
    public final void mo5486c() {
        m1157a(JsonToken.BEGIN_OBJECT);
        this.f1321c.add(((C0594o) m1158r()).mo5562h().iterator());
    }

    public final void close() {
        this.f1321c.clear();
        this.f1321c.add(f1320b);
    }

    /* renamed from: d */
    public final void mo5488d() {
        m1157a(JsonToken.END_OBJECT);
        m1159s();
        m1159s();
    }

    /* renamed from: e */
    public final boolean mo5489e() {
        JsonToken f = mo5490f();
        return (f == JsonToken.END_OBJECT || f == JsonToken.END_ARRAY) ? false : true;
    }

    /* renamed from: f */
    public final JsonToken mo5490f() {
        while (!this.f1321c.isEmpty()) {
            Object r = m1158r();
            if (r instanceof Iterator) {
                boolean z = this.f1321c.get(this.f1321c.size() - 2) instanceof C0594o;
                Iterator it = (Iterator) r;
                if (!it.hasNext()) {
                    return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
                } else {
                    if (z) {
                        return JsonToken.NAME;
                    }
                    this.f1321c.add(it.next());
                }
            } else if (r instanceof C0594o) {
                return JsonToken.BEGIN_OBJECT;
            } else {
                if (r instanceof C0592k) {
                    return JsonToken.BEGIN_ARRAY;
                }
                if (r instanceof C0595p) {
                    C0595p c0595p = (C0595p) r;
                    if (c0595p.mo5568j()) {
                        return JsonToken.STRING;
                    }
                    if (c0595p.mo5565h()) {
                        return JsonToken.BOOLEAN;
                    }
                    if (c0595p.mo5567i()) {
                        return JsonToken.NUMBER;
                    }
                    throw new AssertionError();
                } else if (r instanceof C0593n) {
                    return JsonToken.NULL;
                } else {
                    if (r == f1320b) {
                        throw new IllegalStateException("JsonReader is closed");
                    }
                    throw new AssertionError();
                }
            }
        }
        return JsonToken.END_DOCUMENT;
    }

    /* renamed from: g */
    public final String mo5491g() {
        m1157a(JsonToken.NAME);
        Entry entry = (Entry) ((Iterator) m1158r()).next();
        this.f1321c.add(entry.getValue());
        return (String) entry.getKey();
    }

    /* renamed from: h */
    public final String mo5492h() {
        JsonToken f = mo5490f();
        if (f == JsonToken.STRING || f == JsonToken.NUMBER) {
            return ((C0595p) m1159s()).mo5547b();
        }
        throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + f);
    }

    /* renamed from: i */
    public final boolean mo5493i() {
        m1157a(JsonToken.BOOLEAN);
        return ((C0595p) m1159s()).mo5551f();
    }

    /* renamed from: j */
    public final void mo5494j() {
        m1157a(JsonToken.NULL);
        m1159s();
    }

    /* renamed from: k */
    public final double mo5495k() {
        JsonToken f = mo5490f();
        if (f == JsonToken.NUMBER || f == JsonToken.STRING) {
            double c = ((C0595p) m1158r()).mo5548c();
            if (mo5499p() || !(Double.isNaN(c) || Double.isInfinite(c))) {
                m1159s();
                return c;
            }
            throw new NumberFormatException("JSON forbids NaN and infinities: " + c);
        }
        throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + f);
    }

    /* renamed from: l */
    public final long mo5496l() {
        JsonToken f = mo5490f();
        if (f == JsonToken.NUMBER || f == JsonToken.STRING) {
            long d = ((C0595p) m1158r()).mo5549d();
            m1159s();
            return d;
        }
        throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + f);
    }

    /* renamed from: m */
    public final int mo5497m() {
        JsonToken f = mo5490f();
        if (f == JsonToken.NUMBER || f == JsonToken.STRING) {
            int e = ((C0595p) m1158r()).mo5550e();
            m1159s();
            return e;
        }
        throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + f);
    }

    /* renamed from: n */
    public final void mo5498n() {
        if (mo5490f() == JsonToken.NAME) {
            mo5491g();
        } else {
            m1159s();
        }
    }

    /* renamed from: o */
    public final void mo5502o() {
        m1157a(JsonToken.NAME);
        Entry entry = (Entry) ((Iterator) m1158r()).next();
        this.f1321c.add(entry.getValue());
        this.f1321c.add(new C0595p((String) entry.getKey()));
    }

    public final String toString() {
        return getClass().getSimpleName();
    }
}
