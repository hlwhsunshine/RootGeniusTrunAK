package com.google.gson.internal;

import com.google.gson.C0474a;
import com.google.gson.C0476b;
import com.google.gson.C0477r;
import com.google.gson.C0479d;
import com.google.gson.C0507s;
import com.google.gson.p051a.C0469a;
import com.google.gson.p051a.C0472d;
import com.google.gson.p051a.C0473e;
import com.google.gson.p052b.C0475a;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.gson.internal.o */
public final class C0579o implements C0507s, Cloneable {
    /* renamed from: a */
    public static final C0579o f1442a = new C0579o();
    /* renamed from: b */
    private double f1443b = -1.0d;
    /* renamed from: c */
    private int f1444c = 136;
    /* renamed from: d */
    private boolean f1445d = true;
    /* renamed from: e */
    private boolean f1446e;
    /* renamed from: f */
    private List<C0474a> f1447f = Collections.emptyList();
    /* renamed from: g */
    private List<C0474a> f1448g = Collections.emptyList();

    /* renamed from: a */
    private C0579o m1284a() {
        try {
            return (C0579o) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private boolean m1285a(C0472d c0472d, C0473e c0473e) {
        boolean z = c0472d == null || c0472d.mo5367a() <= this.f1443b;
        if (z) {
            z = c0473e == null || c0473e.mo5368a() > this.f1443b;
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m1286a(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    /* renamed from: b */
    private static boolean m1287b(Class<?> cls) {
        if (cls.isMemberClass()) {
            if (!((cls.getModifiers() & 8) != 0)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final <T> C0477r<T> mo5478a(C0479d c0479d, C0475a<T> c0475a) {
        Class a = c0475a.mo5371a();
        boolean a2 = mo5535a(a, true);
        boolean a3 = mo5535a(a, false);
        return (a2 || a3) ? new C0580p(this, a3, a2, c0479d, c0475a) : null;
    }

    /* renamed from: a */
    public final boolean mo5535a(Class<?> cls, boolean z) {
        if (this.f1443b != -1.0d && !m1285a((C0472d) cls.getAnnotation(C0472d.class), (C0473e) cls.getAnnotation(C0473e.class))) {
            return true;
        }
        if (!this.f1445d && C0579o.m1287b(cls)) {
            return true;
        }
        if (C0579o.m1286a(cls)) {
            return true;
        }
        for (C0474a b : z ? this.f1447f : this.f1448g) {
            if (b.mo5370b()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final boolean mo5536a(Field field, boolean z) {
        if ((this.f1444c & field.getModifiers()) != 0) {
            return true;
        }
        if (this.f1443b != -1.0d && !m1285a((C0472d) field.getAnnotation(C0472d.class), (C0473e) field.getAnnotation(C0473e.class))) {
            return true;
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (this.f1446e) {
            C0469a c0469a = (C0469a) field.getAnnotation(C0469a.class);
            if (c0469a == null || (z ? !c0469a.mo5362a() : !c0469a.mo5363b())) {
                return true;
            }
        }
        if (!this.f1445d && C0579o.m1287b(field.getType())) {
            return true;
        }
        if (C0579o.m1286a(field.getType())) {
            return true;
        }
        List<C0474a> list = z ? this.f1447f : this.f1448g;
        if (!list.isEmpty()) {
            C0476b c0476b = new C0476b(field);
            for (C0474a a : list) {
                if (a.mo5369a()) {
                    return true;
                }
            }
        }
        return false;
    }
}
