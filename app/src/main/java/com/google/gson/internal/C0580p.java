package com.google.gson.internal;

import com.google.gson.C0477r;
import com.google.gson.C0479d;
import com.google.gson.p052b.C0475a;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;

/* renamed from: com.google.gson.internal.p */
final class C0580p extends C0477r<T> {
    /* renamed from: a */
    final /* synthetic */ boolean f1449a;
    /* renamed from: b */
    final /* synthetic */ boolean f1450b;
    /* renamed from: c */
    final /* synthetic */ C0479d f1451c;
    /* renamed from: d */
    final /* synthetic */ C0475a f1452d;
    /* renamed from: e */
    final /* synthetic */ C0579o f1453e;
    /* renamed from: f */
    private C0477r<T> f1454f;

    C0580p(C0579o c0579o, boolean z, boolean z2, C0479d c0479d, C0475a c0475a) {
        this.f1453e = c0579o;
        this.f1449a = z;
        this.f1450b = z2;
        this.f1451c = c0479d;
        this.f1452d = c0475a;
    }

    /* renamed from: a */
    private C0477r<T> m1291a() {
        C0477r<T> c0477r = this.f1454f;
        if (c0477r != null) {
            return c0477r;
        }
        c0477r = this.f1451c.mo5381a(this.f1453e, this.f1452d);
        this.f1454f = c0477r;
        return c0477r;
    }

    /* renamed from: a */
    public final T mo5377a(C0531a c0531a) {
        if (!this.f1449a) {
            return m1291a().mo5377a(c0531a);
        }
        c0531a.mo5498n();
        return null;
    }

    /* renamed from: a */
    public final void mo5378a(C0534c c0534c, T t) {
        if (this.f1450b) {
            c0534c.mo5519f();
        } else {
            m1291a().mo5378a(c0534c, t);
        }
    }
}
