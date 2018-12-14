package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.C0507s;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;
import com.google.gson.stream.JsonToken;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/* renamed from: com.google.gson.internal.a.r */
public final class C0548r extends C0477r<Time> {
    /* renamed from: a */
    public static final C0507s f1363a = new C0549s();
    /* renamed from: b */
    private final DateFormat f1364b = new SimpleDateFormat("hh:mm:ss a");

    /* renamed from: a */
    private synchronized void m1239a(C0534c c0534c, Time time) {
        c0534c.mo5510b(time == null ? null : this.f1364b.format(time));
    }

    /* renamed from: b */
    private synchronized Time m1240b(C0531a c0531a) {
        Time time;
        if (c0531a.mo5490f() == JsonToken.NULL) {
            c0531a.mo5494j();
            time = null;
        } else {
            try {
                time = new Time(this.f1364b.parse(c0531a.mo5492h()).getTime());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }
        return time;
    }
}
