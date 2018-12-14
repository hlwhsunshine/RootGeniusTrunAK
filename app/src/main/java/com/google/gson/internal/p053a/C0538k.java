package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.C0479d;
import com.google.gson.C0507s;
import com.google.gson.C0591m;
import com.google.gson.C0592k;
import com.google.gson.C0593n;
import com.google.gson.C0594o;
import com.google.gson.C0595p;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.C0565b;
import com.google.gson.internal.C0566x;
import com.google.gson.internal.C0581q;
import com.google.gson.internal.C0589z;
import com.google.gson.p052b.C0475a;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;
import com.google.gson.stream.JsonToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.gson.internal.a.k */
public final class C0538k implements C0507s {
    /* renamed from: a */
    private final C0565b f1342a;
    /* renamed from: b */
    private final boolean f1343b = false;

    /* renamed from: com.google.gson.internal.a.k$a */
    private final class C0537a<K, V> extends C0477r<Map<K, V>> {
        /* renamed from: b */
        private final C0477r<K> f1339b;
        /* renamed from: c */
        private final C0477r<V> f1340c;
        /* renamed from: d */
        private final C0566x<? extends Map<K, V>> f1341d;

        public C0537a(C0479d c0479d, Type type, C0477r<K> c0477r, Type type2, C0477r<V> c0477r2, C0566x<? extends Map<K, V>> c0566x) {
            this.f1339b = new C0550t(c0479d, c0477r, type);
            this.f1340c = new C0550t(c0479d, c0477r2, type2);
            this.f1341d = c0566x;
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo5377a(C0531a c0531a) {
            JsonToken f = c0531a.mo5490f();
            if (f == JsonToken.NULL) {
                c0531a.mo5494j();
                return null;
            }
            Map map = (Map) this.f1341d.mo5534a();
            Object a;
            if (f == JsonToken.BEGIN_ARRAY) {
                c0531a.mo5483a();
                while (c0531a.mo5489e()) {
                    c0531a.mo5483a();
                    a = this.f1339b.mo5377a(c0531a);
                    if (map.put(a, this.f1340c.mo5377a(c0531a)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + a);
                    }
                    c0531a.mo5485b();
                }
                c0531a.mo5485b();
                return map;
            }
            c0531a.mo5486c();
            while (c0531a.mo5489e()) {
                C0581q.f1455a.mo5538a(c0531a);
                a = this.f1339b.mo5377a(c0531a);
                if (map.put(a, this.f1340c.mo5377a(c0531a)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + a);
                }
            }
            c0531a.mo5488d();
            return map;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5378a(C0534c c0534c, Object obj) {
            int i = 0;
            Map map = (Map) obj;
            if (map == null) {
                c0534c.mo5519f();
            } else if (C0538k.this.f1343b) {
                List arrayList = new ArrayList(map.size());
                List arrayList2 = new ArrayList(map.size());
                int i2 = 0;
                for (Entry entry : map.entrySet()) {
                    C0591m a = this.f1339b.mo5376a(entry.getKey());
                    arrayList.add(a);
                    arrayList2.add(entry.getValue());
                    int i3 = ((a instanceof C0592k) || (a instanceof C0594o)) ? 1 : 0;
                    i2 = i3 | i2;
                }
                if (i2 != 0) {
                    c0534c.mo5509b();
                    while (i < arrayList.size()) {
                        c0534c.mo5509b();
                        C0589z.m1298a((C0591m) arrayList.get(i), c0534c);
                        this.f1340c.mo5378a(c0534c, arrayList2.get(i));
                        c0534c.mo5512c();
                        i++;
                    }
                    c0534c.mo5512c();
                    return;
                }
                c0534c.mo5516d();
                while (i < arrayList.size()) {
                    String valueOf;
                    C0591m c0591m = (C0591m) arrayList.get(i);
                    if (c0591m instanceof C0595p) {
                        C0595p g = c0591m.mo5552g();
                        if (g.mo5567i()) {
                            valueOf = String.valueOf(g.mo5546a());
                        } else if (g.mo5565h()) {
                            valueOf = Boolean.toString(g.mo5551f());
                        } else if (g.mo5568j()) {
                            valueOf = g.mo5547b();
                        } else {
                            throw new AssertionError();
                        }
                    } else if (c0591m instanceof C0593n) {
                        valueOf = "null";
                    } else {
                        throw new AssertionError();
                    }
                    c0534c.mo5507a(valueOf);
                    this.f1340c.mo5378a(c0534c, arrayList2.get(i));
                    i++;
                }
                c0534c.mo5518e();
            } else {
                c0534c.mo5516d();
                for (Entry entry2 : map.entrySet()) {
                    c0534c.mo5507a(String.valueOf(entry2.getKey()));
                    this.f1340c.mo5378a(c0534c, entry2.getValue());
                }
                c0534c.mo5518e();
            }
        }
    }

    public C0538k(C0565b c0565b) {
        this.f1342a = c0565b;
    }

    /* renamed from: a */
    public final <T> C0477r<T> mo5478a(C0479d c0479d, C0475a<T> c0475a) {
        Type b = c0475a.mo5372b();
        if (!Map.class.isAssignableFrom(c0475a.mo5371a())) {
            return null;
        }
        Type[] b2 = C$Gson$Types.m1038b(b, C$Gson$Types.m1036b(b));
        b = b2[0];
        C0477r a = (b == Boolean.TYPE || b == Boolean.class) ? C0553u.f1394f : c0479d.mo5380a(C0475a.m1006a(b));
        return new C0537a(c0479d, b2[0], a, b2[1], c0479d.mo5380a(C0475a.m1006a(b2[1])), this.f1342a.mo5532a((C0475a) c0475a));
    }
}
