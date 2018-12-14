package com.google.gson.internal;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.gson.internal.y */
public final class C0588y {
    /* renamed from: a */
    private static final Map<Class<?>, Class<?>> f1460a;
    /* renamed from: b */
    private static final Map<Class<?>, Class<?>> f1461b;

    static {
        Map hashMap = new HashMap(16);
        Map hashMap2 = new HashMap(16);
        C0588y.m1296a(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        C0588y.m1296a(hashMap, hashMap2, Byte.TYPE, Byte.class);
        C0588y.m1296a(hashMap, hashMap2, Character.TYPE, Character.class);
        C0588y.m1296a(hashMap, hashMap2, Double.TYPE, Double.class);
        C0588y.m1296a(hashMap, hashMap2, Float.TYPE, Float.class);
        C0588y.m1296a(hashMap, hashMap2, Integer.TYPE, Integer.class);
        C0588y.m1296a(hashMap, hashMap2, Long.TYPE, Long.class);
        C0588y.m1296a(hashMap, hashMap2, Short.TYPE, Short.class);
        C0588y.m1296a(hashMap, hashMap2, Void.TYPE, Void.class);
        f1460a = Collections.unmodifiableMap(hashMap);
        f1461b = Collections.unmodifiableMap(hashMap2);
    }

    /* renamed from: a */
    public static <T> Class<T> m1295a(Class<T> cls) {
        Class<T> cls2 = (Class) f1460a.get(C0559a.m1261a((Object) cls));
        return cls2 == null ? cls : cls2;
    }

    /* renamed from: a */
    private static void m1296a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    /* renamed from: a */
    public static boolean m1297a(Type type) {
        return f1460a.containsKey(type);
    }
}
