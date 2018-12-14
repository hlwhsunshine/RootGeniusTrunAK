package com.google.gson.internal;

import java.lang.reflect.Method;

/* renamed from: com.google.gson.internal.ac */
final class C0562ac extends C0560aa {
    /* renamed from: a */
    final /* synthetic */ Method f1417a;
    /* renamed from: b */
    final /* synthetic */ int f1418b;

    C0562ac(Method method, int i) {
        this.f1417a = method;
        this.f1418b = i;
    }

    /* renamed from: a */
    public final <T> T mo5531a(Class<T> cls) {
        return this.f1417a.invoke(null, new Object[]{cls, Integer.valueOf(this.f1418b)});
    }
}
