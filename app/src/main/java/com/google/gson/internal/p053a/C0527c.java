package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.C0479d;
import com.google.gson.C0507s;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.C0565b;
import com.google.gson.internal.C0566x;
import com.google.gson.p052b.C0475a;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;
import com.google.gson.stream.JsonToken;
import java.lang.reflect.Type;
import java.util.Collection;

/* renamed from: com.google.gson.internal.a.c */
public final class C0527c implements C0507s {
    /* renamed from: a */
    private final C0565b f1297a;

    /* renamed from: com.google.gson.internal.a.c$a */
    private static final class C0526a<E> extends C0477r<Collection<E>> {
        /* renamed from: a */
        private final C0477r<E> f1295a;
        /* renamed from: b */
        private final C0566x<? extends Collection<E>> f1296b;

        public C0526a(C0479d c0479d, Type type, C0477r<E> c0477r, C0566x<? extends Collection<E>> c0566x) {
            this.f1295a = new C0550t(c0479d, c0477r, type);
            this.f1296b = c0566x;
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo5377a(C0531a c0531a) {
            if (c0531a.mo5490f() == JsonToken.NULL) {
                c0531a.mo5494j();
                return null;
            }
            Collection collection = (Collection) this.f1296b.mo5534a();
            c0531a.mo5483a();
            while (c0531a.mo5489e()) {
                collection.add(this.f1295a.mo5377a(c0531a));
            }
            c0531a.mo5485b();
            return collection;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5378a(C0534c c0534c, Object obj) {
            Collection<Object> collection = (Collection) obj;
            if (collection == null) {
                c0534c.mo5519f();
                return;
            }
            c0534c.mo5509b();
            for (Object a : collection) {
                this.f1295a.mo5378a(c0534c, a);
            }
            c0534c.mo5512c();
        }
    }

    public C0527c(C0565b c0565b) {
        this.f1297a = c0565b;
    }

    /* renamed from: a */
    public final <T> C0477r<T> mo5478a(C0479d c0479d, C0475a<T> c0475a) {
        Type b = c0475a.mo5372b();
        Class a = c0475a.mo5371a();
        if (!Collection.class.isAssignableFrom(a)) {
            return null;
        }
        Type a2 = C$Gson$Types.m1032a(b, a);
        return new C0526a(c0479d, a2, c0479d.mo5380a(C0475a.m1006a(a2)), this.f1297a.mo5532a((C0475a) c0475a));
    }
}
