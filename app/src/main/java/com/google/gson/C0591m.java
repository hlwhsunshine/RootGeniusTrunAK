package com.google.gson;

import com.google.gson.internal.C0589z;
import com.google.gson.stream.C0534c;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/* renamed from: com.google.gson.m */
public abstract class C0591m {
    /* renamed from: a */
    public Number mo5546a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: b */
    public String mo5547b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: c */
    public double mo5548c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: d */
    public long mo5549d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: e */
    public int mo5550e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: f */
    public boolean mo5551f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: g */
    public final C0595p mo5552g() {
        if (this instanceof C0595p) {
            return (C0595p) this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    public String toString() {
        try {
            Writer stringWriter = new StringWriter();
            C0534c c0534c = new C0534c(stringWriter);
            c0534c.mo5511b(true);
            C0589z.m1298a(this, c0534c);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
