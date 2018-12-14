package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.C0479d;
import com.google.gson.internal.p053a.C0544n.C0543b;
import com.google.gson.p052b.C0475a;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;
import java.lang.reflect.Field;

/* renamed from: com.google.gson.internal.a.o */
final class C0545o extends C0543b {
    /* renamed from: a */
    final C0477r<?> f1355a = C0544n.m1226a(this.f1360f, this.f1356b, this.f1357c, this.f1358d);
    /* renamed from: b */
    final /* synthetic */ C0479d f1356b;
    /* renamed from: c */
    final /* synthetic */ Field f1357c;
    /* renamed from: d */
    final /* synthetic */ C0475a f1358d;
    /* renamed from: e */
    final /* synthetic */ boolean f1359e;
    /* renamed from: f */
    final /* synthetic */ C0544n f1360f;

    C0545o(C0544n c0544n, String str, boolean z, boolean z2, C0479d c0479d, Field field, C0475a c0475a, boolean z3) {
        this.f1360f = c0544n;
        this.f1356b = c0479d;
        this.f1357c = field;
        this.f1358d = c0475a;
        this.f1359e = z3;
        super(str, z, z2);
    }

    /* renamed from: a */
    final void mo5528a(C0531a c0531a, Object obj) {
        Object a = this.f1355a.mo5377a(c0531a);
        if (a != null || !this.f1359e) {
            this.f1357c.set(obj, a);
        }
    }

    /* renamed from: a */
    final void mo5529a(C0534c c0534c, Object obj) {
        new C0550t(this.f1356b, this.f1355a, this.f1358d.mo5372b()).mo5378a(c0534c, this.f1357c.get(obj));
    }

    /* renamed from: a */
    public final boolean mo5530a(Object obj) {
        return this.f1350h && this.f1357c.get(obj) != obj;
    }
}
