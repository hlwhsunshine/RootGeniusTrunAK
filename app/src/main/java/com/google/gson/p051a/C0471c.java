package com.google.gson.p051a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: com.google.gson.a.c */
public @interface C0471c {
    /* renamed from: a */
    String mo5365a();

    /* renamed from: b */
    String[] mo5366b() default {};
}
