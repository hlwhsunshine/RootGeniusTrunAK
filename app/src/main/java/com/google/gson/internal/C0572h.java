package com.google.gson.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* renamed from: com.google.gson.internal.h */
final class C0572h implements C0566x<T> {
    /* renamed from: a */
    final /* synthetic */ Constructor f1433a;
    /* renamed from: b */
    final /* synthetic */ C0565b f1434b;

    C0572h(C0565b c0565b, Constructor constructor) {
        this.f1434b = c0565b;
        this.f1433a = constructor;
    }

    /* renamed from: a */
    public final T mo5534a() {
        try {
            return this.f1433a.newInstance(null);
        } catch (Throwable e) {
            throw new RuntimeException("Failed to invoke " + this.f1433a + " with no args", e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException("Failed to invoke " + this.f1433a + " with no args", e2.getTargetException());
        } catch (IllegalAccessException e3) {
            throw new AssertionError(e3);
        }
    }
}
