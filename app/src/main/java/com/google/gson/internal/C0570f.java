package com.google.gson.internal;

import java.lang.reflect.Type;

/* renamed from: com.google.gson.internal.f */
final class C0570f implements C0566x<T> {
    /* renamed from: a */
    final /* synthetic */ Class f1426a;
    /* renamed from: b */
    final /* synthetic */ Type f1427b;
    /* renamed from: c */
    final /* synthetic */ C0565b f1428c;
    /* renamed from: d */
    private final C0560aa f1429d = C0560aa.m1263a();

    C0570f(C0565b c0565b, Class cls, Type type) {
        this.f1428c = c0565b;
        this.f1426a = cls;
        this.f1427b = type;
    }

    /* renamed from: a */
    public final T mo5534a() {
        try {
            return this.f1429d.mo5531a(this.f1426a);
        } catch (Throwable e) {
            throw new RuntimeException("Unable to invoke no-args constructor for " + this.f1427b + ". Register an InstanceCreator with Gson for this type may fix this problem.", e);
        }
    }
}
