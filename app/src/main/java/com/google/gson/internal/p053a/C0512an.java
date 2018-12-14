package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.C0591m;
import com.google.gson.C0592k;
import com.google.gson.C0593n;
import com.google.gson.C0594o;
import com.google.gson.C0595p;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;
import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: com.google.gson.internal.a.an */
final class C0512an extends C0477r<C0591m> {
    C0512an() {
    }

    /* renamed from: a */
    private void m1082a(C0534c c0534c, C0591m c0591m) {
        if (c0591m == null || (c0591m instanceof C0593n)) {
            c0534c.mo5519f();
        } else if (c0591m instanceof C0595p) {
            C0595p g = c0591m.mo5552g();
            if (g.mo5567i()) {
                c0534c.mo5378a(g.mo5546a());
            } else if (g.mo5565h()) {
                c0534c.mo5508a(g.mo5551f());
            } else {
                c0534c.mo5510b(g.mo5547b());
            }
        } else if (c0591m instanceof C0592k) {
            c0534c.mo5509b();
            if (c0591m instanceof C0592k) {
                Iterator it = ((C0592k) c0591m).iterator();
                while (it.hasNext()) {
                    m1082a(c0534c, (C0591m) it.next());
                }
                c0534c.mo5512c();
                return;
            }
            throw new IllegalStateException("This is not a JSON Array.");
        } else if (c0591m instanceof C0594o) {
            c0534c.mo5516d();
            if (c0591m instanceof C0594o) {
                for (Entry entry : ((C0594o) c0591m).mo5562h()) {
                    c0534c.mo5507a((String) entry.getKey());
                    m1082a(c0534c, (C0591m) entry.getValue());
                }
                c0534c.mo5518e();
                return;
            }
            throw new IllegalStateException("Not a JSON Object: " + c0591m);
        } else {
            throw new IllegalArgumentException("Couldn't write " + c0591m.getClass());
        }
    }

    /* renamed from: b */
    private C0591m m1083b(C0531a c0531a) {
        C0591m c0592k;
        switch (c0531a.mo5490f()) {
            case NUMBER:
                return new C0595p(new LazilyParsedNumber(c0531a.mo5492h()));
            case BOOLEAN:
                return new C0595p(Boolean.valueOf(c0531a.mo5493i()));
            case STRING:
                return new C0595p(c0531a.mo5492h());
            case NULL:
                c0531a.mo5494j();
                return C0593n.f1463a;
            case BEGIN_ARRAY:
                c0592k = new C0592k();
                c0531a.mo5483a();
                while (c0531a.mo5489e()) {
                    c0592k.mo5554a(m1083b(c0531a));
                }
                c0531a.mo5485b();
                return c0592k;
            case BEGIN_OBJECT:
                c0592k = new C0594o();
                c0531a.mo5486c();
                while (c0531a.mo5489e()) {
                    c0592k.mo5560a(c0531a.mo5491g(), m1083b(c0531a));
                }
                c0531a.mo5488d();
                return c0592k;
            default:
                throw new IllegalArgumentException();
        }
    }
}
