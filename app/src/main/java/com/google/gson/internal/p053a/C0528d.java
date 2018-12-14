package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.C0507s;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.C0534c;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: com.google.gson.internal.a.d */
public final class C0528d extends C0477r<Date> {
    /* renamed from: a */
    public static final C0507s f1298a = new C0529e();
    /* renamed from: b */
    private final DateFormat f1299b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    /* renamed from: c */
    private final DateFormat f1300c = DateFormat.getDateTimeInstance(2, 2);
    /* renamed from: d */
    private final DateFormat f1301d;

    public C0528d() {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.f1301d = simpleDateFormat;
    }

    /* renamed from: a */
    private synchronized Date m1113a(String str) {
        Date parse;
        try {
            parse = this.f1300c.parse(str);
        } catch (ParseException e) {
            try {
                parse = this.f1299b.parse(str);
            } catch (ParseException e2) {
                try {
                    parse = this.f1301d.parse(str);
                } catch (Throwable e3) {
                    throw new JsonSyntaxException(str, e3);
                }
            }
        }
        return parse;
    }

    /* renamed from: a */
    private synchronized void m1114a(C0534c c0534c, Date date) {
        if (date == null) {
            c0534c.mo5519f();
        } else {
            c0534c.mo5510b(this.f1299b.format(date));
        }
    }
}
