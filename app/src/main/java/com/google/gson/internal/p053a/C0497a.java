package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.C0479d;
import com.google.gson.C0507s;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;
import com.google.gson.stream.JsonToken;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.gson.internal.a.a */
public final class C0497a<E> extends C0477r<Object> {
    /* renamed from: a */
    public static final C0507s f1280a = new C0525b();
    /* renamed from: b */
    private final Class<E> f1281b;
    /* renamed from: c */
    private final C0477r<E> f1282c;

    public C0497a(C0479d c0479d, C0477r<E> c0477r, Class<E> cls) {
        this.f1282c = new C0550t(c0479d, c0477r, cls);
        this.f1281b = cls;
    }

    /* renamed from: a */
    public final Object mo5377a(C0531a c0531a) {
        if (c0531a.mo5490f() == JsonToken.NULL) {
            c0531a.mo5494j();
            return null;
        }
        List arrayList = new ArrayList();
        c0531a.mo5483a();
        while (c0531a.mo5489e()) {
            arrayList.add(this.f1282c.mo5377a(c0531a));
        }
        c0531a.mo5485b();
        Object newInstance = Array.newInstance(this.f1281b, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    /* renamed from: a */
    public final void mo5378a(C0534c c0534c, Object obj) {
        if (obj == null) {
            c0534c.mo5519f();
            return;
        }
        c0534c.mo5509b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f1282c.mo5378a(c0534c, Array.get(obj, i));
        }
        c0534c.mo5512c();
    }
}
