package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.C0479d;
import com.google.gson.C0507s;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.gson.internal.a.l */
public final class C0540l extends C0477r<Object> {
    /* renamed from: a */
    public static final C0507s f1345a = new C0541m();
    /* renamed from: b */
    private final C0479d f1346b;

    private C0540l(C0479d c0479d) {
        this.f1346b = c0479d;
    }

    /* synthetic */ C0540l(C0479d c0479d, byte b) {
        this(c0479d);
    }

    /* renamed from: a */
    public final Object mo5377a(C0531a c0531a) {
        switch (c0531a.mo5490f()) {
            case BEGIN_ARRAY:
                List arrayList = new ArrayList();
                c0531a.mo5483a();
                while (c0531a.mo5489e()) {
                    arrayList.add(mo5377a(c0531a));
                }
                c0531a.mo5485b();
                return arrayList;
            case BEGIN_OBJECT:
                Map linkedTreeMap = new LinkedTreeMap();
                c0531a.mo5486c();
                while (c0531a.mo5489e()) {
                    linkedTreeMap.put(c0531a.mo5491g(), mo5377a(c0531a));
                }
                c0531a.mo5488d();
                return linkedTreeMap;
            case STRING:
                return c0531a.mo5492h();
            case NUMBER:
                return Double.valueOf(c0531a.mo5495k());
            case BOOLEAN:
                return Boolean.valueOf(c0531a.mo5493i());
            case NULL:
                c0531a.mo5494j();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    public final void mo5378a(C0534c c0534c, Object obj) {
        if (obj == null) {
            c0534c.mo5519f();
            return;
        }
        C0477r a = this.f1346b.mo5382a(obj.getClass());
        if (a instanceof C0540l) {
            c0534c.mo5516d();
            c0534c.mo5518e();
            return;
        }
        a.mo5378a(c0534c, obj);
    }
}
