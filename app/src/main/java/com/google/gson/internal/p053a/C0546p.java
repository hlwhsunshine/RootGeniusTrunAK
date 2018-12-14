package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.C0507s;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;
import com.google.gson.stream.JsonToken;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/* renamed from: com.google.gson.internal.a.p */
public final class C0546p extends C0477r<Date> {
    /* renamed from: a */
    public static final C0507s f1361a = new C0547q();
    /* renamed from: b */
    private final DateFormat f1362b = new SimpleDateFormat("MMM d, yyyy");

    /* renamed from: a */
    private synchronized void m1234a(C0534c c0534c, Date date) {
        c0534c.mo5510b(date == null ? null : this.f1362b.format(date));
    }

    /* renamed from: b */
    private synchronized Date m1235b(C0531a c0531a) {
        Date date;
        if (c0531a.mo5490f() == JsonToken.NULL) {
            c0531a.mo5494j();
            date = null;
        } else {
            try {
                date = new Date(this.f1362b.parse(c0531a.mo5492h()).getTime());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }
        return date;
    }
}
