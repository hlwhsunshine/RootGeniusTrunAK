package com.google.gson.internal;

import com.google.gson.C0590j;
import com.google.gson.p052b.C0475a;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* renamed from: com.google.gson.internal.b */
public final class C0565b {
    /* renamed from: a */
    private final Map<Type, C0590j<?>> f1420a;

    public C0565b(Map<Type, C0590j<?>> map) {
        this.f1420a = map;
    }

    /* renamed from: a */
    private <T> C0566x<T> m1269a(Class<? super T> cls) {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new C0572h(this, declaredConstructor);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    /* renamed from: a */
    public final <T> C0566x<T> mo5532a(C0475a<T> c0475a) {
        Type b = c0475a.mo5372b();
        Class a = c0475a.mo5371a();
        C0590j c0590j = (C0590j) this.f1420a.get(b);
        if (c0590j != null) {
            return new C0567c(this, c0590j, b);
        }
        c0590j = (C0590j) this.f1420a.get(a);
        if (c0590j != null) {
            return new C0571g(this, c0590j, b);
        }
        C0566x<T> a2 = m1269a(a);
        if (a2 != null) {
            return a2;
        }
        a2 = Collection.class.isAssignableFrom(a) ? SortedSet.class.isAssignableFrom(a) ? new C0573i(this) : EnumSet.class.isAssignableFrom(a) ? new C0574j(this, b) : Set.class.isAssignableFrom(a) ? new C0575k(this) : Queue.class.isAssignableFrom(a) ? new C0576l(this) : new C0577m(this) : Map.class.isAssignableFrom(a) ? SortedMap.class.isAssignableFrom(a) ? new C0578n(this) : (!(b instanceof ParameterizedType) || String.class.isAssignableFrom(C0475a.m1006a(((ParameterizedType) b).getActualTypeArguments()[0]).mo5371a())) ? new C0569e(this) : new C0568d(this) : null;
        return a2 == null ? new C0570f(this, a, b) : a2;
    }

    public final String toString() {
        return this.f1420a.toString();
    }
}
