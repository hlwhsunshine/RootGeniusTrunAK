package com.nineoldandroids.p054a;

/* renamed from: com.nineoldandroids.a.c */
public final class C0927c implements C0926z<Number> {
    /* renamed from: a */
    public final /* synthetic */ Object mo6052a(float f, Object obj, Object obj2) {
        Number number = (Number) obj2;
        float floatValue = ((Number) obj).floatValue();
        return Float.valueOf(floatValue + ((number.floatValue() - floatValue) * f));
    }
}
