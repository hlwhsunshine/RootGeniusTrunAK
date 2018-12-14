package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;

/* renamed from: com.google.gson.p */
public final class C0595p extends C0591m {
    /* renamed from: a */
    private static final Class<?>[] f1465a = new Class[]{Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    /* renamed from: b */
    private Object f1466b;

    public C0595p(Boolean bool) {
        m1316a((Object) bool);
    }

    public C0595p(Number number) {
        m1316a((Object) number);
    }

    public C0595p(String str) {
        m1316a((Object) str);
    }

    /* JADX WARNING: Missing block: B:8:0x001c, code:
            if (r2 != false) goto L_0x001e;
     */
    /* renamed from: a */
    private void m1316a(java.lang.Object r8) {
        /*
        r7 = this;
        r1 = 1;
        r0 = 0;
        r2 = r8 instanceof java.lang.Character;
        if (r2 == 0) goto L_0x0013;
    L_0x0006:
        r8 = (java.lang.Character) r8;
        r0 = r8.charValue();
        r0 = java.lang.String.valueOf(r0);
        r7.f1466b = r0;
    L_0x0012:
        return;
    L_0x0013:
        r2 = r8 instanceof java.lang.Number;
        if (r2 != 0) goto L_0x001e;
    L_0x0017:
        r2 = r8 instanceof java.lang.String;
        if (r2 == 0) goto L_0x0025;
    L_0x001b:
        r2 = r1;
    L_0x001c:
        if (r2 == 0) goto L_0x001f;
    L_0x001e:
        r0 = r1;
    L_0x001f:
        com.google.gson.internal.C0559a.m1262a(r0);
        r7.f1466b = r8;
        goto L_0x0012;
    L_0x0025:
        r3 = r8.getClass();
        r4 = f1465a;
        r5 = r4.length;
        r2 = r0;
    L_0x002d:
        if (r2 >= r5) goto L_0x003c;
    L_0x002f:
        r6 = r4[r2];
        r6 = r6.isAssignableFrom(r3);
        if (r6 == 0) goto L_0x0039;
    L_0x0037:
        r2 = r1;
        goto L_0x001c;
    L_0x0039:
        r2 = r2 + 1;
        goto L_0x002d;
    L_0x003c:
        r2 = r0;
        goto L_0x001c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.p.a(java.lang.Object):void");
    }

    /* renamed from: a */
    private static boolean m1317a(C0595p c0595p) {
        if (!(c0595p.f1466b instanceof Number)) {
            return false;
        }
        Number number = (Number) c0595p.f1466b;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    /* renamed from: a */
    public final Number mo5546a() {
        return this.f1466b instanceof String ? new LazilyParsedNumber((String) this.f1466b) : (Number) this.f1466b;
    }

    /* renamed from: b */
    public final String mo5547b() {
        return this.f1466b instanceof Number ? mo5546a().toString() : this.f1466b instanceof Boolean ? ((Boolean) this.f1466b).toString() : (String) this.f1466b;
    }

    /* renamed from: c */
    public final double mo5548c() {
        return this.f1466b instanceof Number ? mo5546a().doubleValue() : Double.parseDouble(mo5547b());
    }

    /* renamed from: d */
    public final long mo5549d() {
        return this.f1466b instanceof Number ? mo5546a().longValue() : Long.parseLong(mo5547b());
    }

    /* renamed from: e */
    public final int mo5550e() {
        return this.f1466b instanceof Number ? mo5546a().intValue() : Integer.parseInt(mo5547b());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0595p c0595p = (C0595p) obj;
        if (this.f1466b == null) {
            return c0595p.f1466b == null;
        } else {
            if (C0595p.m1317a(this) && C0595p.m1317a(c0595p)) {
                return mo5546a().longValue() == c0595p.mo5546a().longValue();
            } else {
                if (!(this.f1466b instanceof Number) || !(c0595p.f1466b instanceof Number)) {
                    return this.f1466b.equals(c0595p.f1466b);
                }
                double doubleValue = mo5546a().doubleValue();
                double doubleValue2 = c0595p.mo5546a().doubleValue();
                return doubleValue != doubleValue2 ? Double.isNaN(doubleValue) && Double.isNaN(doubleValue2) : true;
            }
        }
    }

    /* renamed from: f */
    public final boolean mo5551f() {
        return this.f1466b instanceof Boolean ? ((Boolean) this.f1466b).booleanValue() : Boolean.parseBoolean(mo5547b());
    }

    /* renamed from: h */
    public final boolean mo5565h() {
        return this.f1466b instanceof Boolean;
    }

    public final int hashCode() {
        if (this.f1466b == null) {
            return 31;
        }
        long longValue;
        if (C0595p.m1317a(this)) {
            longValue = mo5546a().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (!(this.f1466b instanceof Number)) {
            return this.f1466b.hashCode();
        } else {
            longValue = Double.doubleToLongBits(mo5546a().doubleValue());
            return (int) (longValue ^ (longValue >>> 32));
        }
    }

    /* renamed from: i */
    public final boolean mo5567i() {
        return this.f1466b instanceof Number;
    }

    /* renamed from: j */
    public final boolean mo5568j() {
        return this.f1466b instanceof String;
    }
}
