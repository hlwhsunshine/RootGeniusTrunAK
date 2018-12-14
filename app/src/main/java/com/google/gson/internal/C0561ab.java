package com.google.gson.internal;

import java.lang.reflect.Method;

/* renamed from: com.google.gson.internal.ab */
final class C0561ab extends C0560aa {
    /* renamed from: a */
    final /* synthetic */ Method f1415a;
    /* renamed from: b */
    final /* synthetic */ Object f1416b;

    C0561ab(Method method, Object obj) {
        this.f1415a = method;
        this.f1416b = obj;
    }

    /* renamed from: a */
    public final <T> T mo5531a(Class<T> cls) {
        return this.f1415a.invoke(this.f1416b, new Object[]{cls});
    }
}
