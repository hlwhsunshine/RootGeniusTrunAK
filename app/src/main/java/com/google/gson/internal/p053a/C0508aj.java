package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.C0479d;
import com.google.gson.C0507s;
import com.google.gson.p052b.C0475a;
import java.sql.Timestamp;
import java.util.Date;

/* renamed from: com.google.gson.internal.a.aj */
final class C0508aj implements C0507s {
    C0508aj() {
    }

    /* renamed from: a */
    public final <T> C0477r<T> mo5478a(C0479d c0479d, C0475a<T> c0475a) {
        return c0475a.mo5371a() != Timestamp.class ? null : new C0509ak(this, c0479d.mo5382a(Date.class));
    }
}
