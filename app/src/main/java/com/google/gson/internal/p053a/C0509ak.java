package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;
import java.sql.Timestamp;
import java.util.Date;

/* renamed from: com.google.gson.internal.a.ak */
final class C0509ak extends C0477r<Timestamp> {
    /* renamed from: a */
    final /* synthetic */ C0477r f1283a;
    /* renamed from: b */
    final /* synthetic */ C0508aj f1284b;

    C0509ak(C0508aj c0508aj, C0477r c0477r) {
        this.f1284b = c0508aj;
        this.f1283a = c0477r;
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo5377a(C0531a c0531a) {
        Date date = (Date) this.f1283a.mo5377a(c0531a);
        return date != null ? new Timestamp(date.getTime()) : null;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo5378a(C0534c c0534c, Object obj) {
        this.f1283a.mo5378a(c0534c, (Timestamp) obj);
    }
}
