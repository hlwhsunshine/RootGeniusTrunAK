package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;
import com.google.gson.stream.JsonToken;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* renamed from: com.google.gson.internal.a.al */
final class C0510al extends C0477r<Calendar> {
    C0510al() {
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo5377a(C0531a c0531a) {
        int i = 0;
        if (c0531a.mo5490f() == JsonToken.NULL) {
            c0531a.mo5494j();
            return null;
        }
        c0531a.mo5486c();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (c0531a.mo5490f() != JsonToken.END_OBJECT) {
            String g = c0531a.mo5491g();
            int m = c0531a.mo5497m();
            if ("year".equals(g)) {
                i6 = m;
            } else if ("month".equals(g)) {
                i5 = m;
            } else if ("dayOfMonth".equals(g)) {
                i4 = m;
            } else if ("hourOfDay".equals(g)) {
                i3 = m;
            } else if ("minute".equals(g)) {
                i2 = m;
            } else if ("second".equals(g)) {
                i = m;
            }
        }
        c0531a.mo5488d();
        return new GregorianCalendar(i6, i5, i4, i3, i2, i);
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5378a(C0534c c0534c, Object obj) {
        Calendar calendar = (Calendar) obj;
        if (calendar == null) {
            c0534c.mo5519f();
            return;
        }
        c0534c.mo5516d();
        c0534c.mo5507a("year");
        c0534c.mo5505a((long) calendar.get(1));
        c0534c.mo5507a("month");
        c0534c.mo5505a((long) calendar.get(2));
        c0534c.mo5507a("dayOfMonth");
        c0534c.mo5505a((long) calendar.get(5));
        c0534c.mo5507a("hourOfDay");
        c0534c.mo5505a((long) calendar.get(11));
        c0534c.mo5507a("minute");
        c0534c.mo5505a((long) calendar.get(12));
        c0534c.mo5507a("second");
        c0534c.mo5505a((long) calendar.get(13));
        c0534c.mo5518e();
    }
}
