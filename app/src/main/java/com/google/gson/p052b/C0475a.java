package com.google.gson.p052b;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.C0559a;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* renamed from: com.google.gson.b.a */
public class C0475a<T> {
    /* renamed from: a */
    final Class<? super T> f1225a;
    /* renamed from: b */
    final Type f1226b;
    /* renamed from: c */
    final int f1227c;

    protected C0475a() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        this.f1226b = C$Gson$Types.m1031a(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        this.f1225a = C$Gson$Types.m1036b(this.f1226b);
        this.f1227c = this.f1226b.hashCode();
    }

    private C0475a(Type type) {
        this.f1226b = C$Gson$Types.m1031a((Type) C0559a.m1261a((Object) type));
        this.f1225a = C$Gson$Types.m1036b(this.f1226b);
        this.f1227c = this.f1226b.hashCode();
    }

    /* renamed from: a */
    public static <T> C0475a<T> m1005a(Class<T> cls) {
        return new C0475a(cls);
    }

    /* renamed from: a */
    public static C0475a<?> m1006a(Type type) {
        return new C0475a(type);
    }

    /* renamed from: a */
    public final Class<? super T> mo5371a() {
        return this.f1225a;
    }

    /* renamed from: b */
    public final Type mo5372b() {
        return this.f1226b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C0475a) && C$Gson$Types.m1035a(this.f1226b, ((C0475a) obj).f1226b);
    }

    public final int hashCode() {
        return this.f1227c;
    }

    public final String toString() {
        return C$Gson$Types.m1039c(this.f1226b);
    }
}
