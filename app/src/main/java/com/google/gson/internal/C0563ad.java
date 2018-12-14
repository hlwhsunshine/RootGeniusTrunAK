package com.google.gson.internal;

import java.lang.reflect.Method;

/* renamed from: com.google.gson.internal.ad */
final class C0563ad extends C0560aa {
    /* renamed from: a */
    final /* synthetic */ Method f1419a;

    C0563ad(Method method) {
        this.f1419a = method;
    }

    /* renamed from: a */
    public final <T> T mo5531a(Class<T> cls) {
        return this.f1419a.invoke(null, new Object[]{cls, Object.class});
    }
}
