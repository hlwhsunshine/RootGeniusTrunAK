package com.google.gson.internal;

import com.google.gson.JsonIOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

/* renamed from: com.google.gson.internal.j */
final class C0574j implements C0566x<T> {
    /* renamed from: a */
    final /* synthetic */ Type f1436a;
    /* renamed from: b */
    final /* synthetic */ C0565b f1437b;

    C0574j(C0565b c0565b, Type type) {
        this.f1437b = c0565b;
        this.f1436a = type;
    }

    /* renamed from: a */
    public final T mo5534a() {
        if (this.f1436a instanceof ParameterizedType) {
            Type type = ((ParameterizedType) this.f1436a).getActualTypeArguments()[0];
            if (type instanceof Class) {
                return EnumSet.noneOf((Class) type);
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.f1436a.toString());
        }
        throw new JsonIOException("Invalid EnumSet type: " + this.f1436a.toString());
    }
}
