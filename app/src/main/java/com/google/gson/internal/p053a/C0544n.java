package com.google.gson.internal.p053a;

import com.google.gson.C0461c;
import com.google.gson.C0477r;
import com.google.gson.C0479d;
import com.google.gson.C0507s;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.C0565b;
import com.google.gson.internal.C0566x;
import com.google.gson.internal.C0579o;
import com.google.gson.p051a.C0470b;
import com.google.gson.p051a.C0471c;
import com.google.gson.p052b.C0475a;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;
import com.google.gson.stream.JsonToken;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.gson.internal.a.n */
public final class C0544n implements C0507s {
    /* renamed from: a */
    private final C0565b f1352a;
    /* renamed from: b */
    private final C0461c f1353b;
    /* renamed from: c */
    private final C0579o f1354c;

    /* renamed from: com.google.gson.internal.a.n$a */
    public static final class C0542a<T> extends C0477r<T> {
        /* renamed from: a */
        private final C0566x<T> f1347a;
        /* renamed from: b */
        private final Map<String, C0543b> f1348b;

        private C0542a(C0566x<T> c0566x, Map<String, C0543b> map) {
            this.f1347a = c0566x;
            this.f1348b = map;
        }

        /* synthetic */ C0542a(C0566x c0566x, Map map, byte b) {
            this(c0566x, map);
        }

        /* renamed from: a */
        public final T mo5377a(C0531a c0531a) {
            if (c0531a.mo5490f() == JsonToken.NULL) {
                c0531a.mo5494j();
                return null;
            }
            T a = this.f1347a.mo5534a();
            try {
                c0531a.mo5486c();
                while (c0531a.mo5489e()) {
                    C0543b c0543b = (C0543b) this.f1348b.get(c0531a.mo5491g());
                    if (c0543b == null || !c0543b.f1351i) {
                        c0531a.mo5498n();
                    } else {
                        c0543b.mo5528a(c0531a, (Object) a);
                    }
                }
                c0531a.mo5488d();
                return a;
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        /* renamed from: a */
        public final void mo5378a(C0534c c0534c, T t) {
            if (t == null) {
                c0534c.mo5519f();
                return;
            }
            c0534c.mo5516d();
            try {
                for (C0543b c0543b : this.f1348b.values()) {
                    if (c0543b.mo5530a(t)) {
                        c0534c.mo5507a(c0543b.f1349g);
                        c0543b.mo5529a(c0534c, (Object) t);
                    }
                }
                c0534c.mo5518e();
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            }
        }
    }

    /* renamed from: com.google.gson.internal.a.n$b */
    static abstract class C0543b {
        /* renamed from: g */
        final String f1349g;
        /* renamed from: h */
        final boolean f1350h;
        /* renamed from: i */
        final boolean f1351i;

        protected C0543b(String str, boolean z, boolean z2) {
            this.f1349g = str;
            this.f1350h = z;
            this.f1351i = z2;
        }

        /* renamed from: a */
        abstract void mo5528a(C0531a c0531a, Object obj);

        /* renamed from: a */
        abstract void mo5529a(C0534c c0534c, Object obj);

        /* renamed from: a */
        abstract boolean mo5530a(Object obj);
    }

    public C0544n(C0565b c0565b, C0461c c0461c, C0579o c0579o) {
        this.f1352a = c0565b;
        this.f1353b = c0461c;
        this.f1354c = c0579o;
    }

    /* renamed from: a */
    static /* synthetic */ C0477r m1226a(C0544n c0544n, C0479d c0479d, Field field, C0475a c0475a) {
        C0470b c0470b = (C0470b) field.getAnnotation(C0470b.class);
        if (c0470b != null) {
            C0477r a = C0530f.m1118a(c0544n.f1352a, c0479d, c0475a, c0470b);
            if (a != null) {
                return a;
            }
        }
        return c0479d.mo5380a(c0475a);
    }

    /* renamed from: a */
    private List<String> m1227a(Field field) {
        C0461c c0461c = this.f1353b;
        C0471c c0471c = (C0471c) field.getAnnotation(C0471c.class);
        List<String> linkedList = new LinkedList();
        if (c0471c == null) {
            linkedList.add(c0461c.translateName(field));
        } else {
            linkedList.add(c0471c.mo5365a());
            for (Object add : c0471c.mo5366b()) {
                linkedList.add(add);
            }
        }
        return linkedList;
    }

    /* JADX WARNING: Missing block: B:25:0x00ac, code:
            r21 = com.google.gson.p052b.C0475a.m1006a(com.google.gson.internal.C$Gson$Types.m1034a(r21.mo5372b(), r22, r22.getGenericSuperclass()));
            r22 = r21.mo5371a();
     */
    /* renamed from: a */
    private java.util.Map<java.lang.String, com.google.gson.internal.p053a.C0544n.C0543b> m1228a(com.google.gson.C0479d r20, com.google.gson.p052b.C0475a<?> r21, java.lang.Class<?> r22) {
        /*
        r19 = this;
        r12 = new java.util.LinkedHashMap;
        r12.<init>();
        r1 = r22.isInterface();
        if (r1 == 0) goto L_0x000d;
    L_0x000b:
        r1 = r12;
    L_0x000c:
        return r1;
    L_0x000d:
        r14 = r21.mo5372b();
    L_0x0011:
        r1 = java.lang.Object.class;
        r0 = r22;
        if (r0 == r1) goto L_0x00c4;
    L_0x0017:
        r15 = r22.getDeclaredFields();
        r0 = r15.length;
        r16 = r0;
        r1 = 0;
        r13 = r1;
    L_0x0020:
        r0 = r16;
        if (r13 >= r0) goto L_0x00ac;
    L_0x0024:
        r7 = r15[r13];
        r1 = 1;
        r0 = r19;
        r4 = r0.m1229a(r7, r1);
        r1 = 0;
        r0 = r19;
        r5 = r0.m1229a(r7, r1);
        if (r4 != 0) goto L_0x0038;
    L_0x0036:
        if (r5 == 0) goto L_0x00a7;
    L_0x0038:
        r1 = 1;
        r7.setAccessible(r1);
        r1 = r21.mo5372b();
        r2 = r7.getGenericType();
        r0 = r22;
        r17 = com.google.gson.internal.C$Gson$Types.m1034a(r1, r0, r2);
        r0 = r19;
        r18 = r0.m1227a(r7);
        r10 = 0;
        r1 = 0;
        r11 = r1;
    L_0x0053:
        r1 = r18.size();
        if (r11 >= r1) goto L_0x0086;
    L_0x0059:
        r0 = r18;
        r3 = r0.get(r11);
        r3 = (java.lang.String) r3;
        if (r11 == 0) goto L_0x0064;
    L_0x0063:
        r4 = 0;
    L_0x0064:
        r8 = com.google.gson.p052b.C0475a.m1006a(r17);
        r1 = r8.mo5371a();
        r9 = com.google.gson.internal.C0588y.m1297a(r1);
        r1 = new com.google.gson.internal.a.o;
        r2 = r19;
        r6 = r20;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9);
        r1 = r12.put(r3, r1);
        r1 = (com.google.gson.internal.p053a.C0544n.C0543b) r1;
        if (r10 != 0) goto L_0x00c7;
    L_0x0081:
        r2 = r11 + 1;
        r11 = r2;
        r10 = r1;
        goto L_0x0053;
    L_0x0086:
        if (r10 == 0) goto L_0x00a7;
    L_0x0088:
        r1 = new java.lang.IllegalArgumentException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r14);
        r3 = " declares multiple JSON fields named ";
        r2 = r2.append(r3);
        r3 = r10.f1349g;
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2);
        throw r1;
    L_0x00a7:
        r1 = r13 + 1;
        r13 = r1;
        goto L_0x0020;
    L_0x00ac:
        r1 = r21.mo5372b();
        r2 = r22.getGenericSuperclass();
        r0 = r22;
        r1 = com.google.gson.internal.C$Gson$Types.m1034a(r1, r0, r2);
        r21 = com.google.gson.p052b.C0475a.m1006a(r1);
        r22 = r21.mo5371a();
        goto L_0x0011;
    L_0x00c4:
        r1 = r12;
        goto L_0x000c;
    L_0x00c7:
        r1 = r10;
        goto L_0x0081;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.a.n.a(com.google.gson.d, com.google.gson.b.a, java.lang.Class):java.util.Map<java.lang.String, com.google.gson.internal.a.n$b>");
    }

    /* renamed from: a */
    private boolean m1229a(Field field, boolean z) {
        C0579o c0579o = this.f1354c;
        return (c0579o.mo5535a(field.getType(), z) || c0579o.mo5536a(field, z)) ? false : true;
    }

    /* renamed from: a */
    public final <T> C0477r<T> mo5478a(C0479d c0479d, C0475a<T> c0475a) {
        Class a = c0475a.mo5371a();
        return !Object.class.isAssignableFrom(a) ? null : new C0542a(this.f1352a.mo5532a((C0475a) c0475a), m1228a(c0479d, c0475a, a), (byte) 0);
    }
}
