package com.google.gson;

import com.google.gson.internal.C0565b;
import com.google.gson.internal.C0579o;
import com.google.gson.internal.C0588y;
import com.google.gson.internal.C0589z;
import com.google.gson.internal.p053a.C0497a;
import com.google.gson.internal.p053a.C0527c;
import com.google.gson.internal.p053a.C0528d;
import com.google.gson.internal.p053a.C0530f;
import com.google.gson.internal.p053a.C0538k;
import com.google.gson.internal.p053a.C0540l;
import com.google.gson.internal.p053a.C0544n;
import com.google.gson.internal.p053a.C0546p;
import com.google.gson.internal.p053a.C0548r;
import com.google.gson.internal.p053a.C0553u;
import com.google.gson.p052b.C0475a;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;
import com.google.gson.stream.JsonToken;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.gson.d */
public final class C0479d {
    /* renamed from: a */
    final C0480l f1230a;
    /* renamed from: b */
    final C0482q f1231b;
    /* renamed from: c */
    private final ThreadLocal<Map<C0475a<?>, C0478a<?>>> f1232c;
    /* renamed from: d */
    private final Map<C0475a<?>, C0477r<?>> f1233d;
    /* renamed from: e */
    private final List<C0507s> f1234e;
    /* renamed from: f */
    private final C0565b f1235f;
    /* renamed from: g */
    private final boolean f1236g;
    /* renamed from: h */
    private final boolean f1237h;
    /* renamed from: i */
    private final boolean f1238i;
    /* renamed from: j */
    private final boolean f1239j;

    /* renamed from: com.google.gson.d$a */
    static class C0478a<T> extends C0477r<T> {
        /* renamed from: a */
        private C0477r<T> f1229a;

        C0478a() {
        }

        /* renamed from: a */
        public final T mo5377a(C0531a c0531a) {
            if (this.f1229a != null) {
                return this.f1229a.mo5377a(c0531a);
            }
            throw new IllegalStateException();
        }

        /* renamed from: a */
        public final void mo5379a(C0477r<T> c0477r) {
            if (this.f1229a != null) {
                throw new AssertionError();
            }
            this.f1229a = c0477r;
        }

        /* renamed from: a */
        public final void mo5378a(C0534c c0534c, T t) {
            if (this.f1229a == null) {
                throw new IllegalStateException();
            }
            this.f1229a.mo5378a(c0534c, t);
        }
    }

    public C0479d() {
        this(C0579o.f1442a, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), LongSerializationPolicy.DEFAULT, Collections.emptyList());
    }

    private C0479d(C0579o c0579o, C0461c c0461c, Map<Type, C0590j<?>> map, LongSerializationPolicy longSerializationPolicy, List<C0507s> list) {
        this.f1232c = new ThreadLocal();
        this.f1233d = Collections.synchronizedMap(new HashMap());
        this.f1230a = new C0481e(this);
        this.f1231b = new C0483f(this);
        this.f1235f = new C0565b(map);
        this.f1236g = false;
        this.f1238i = false;
        this.f1237h = true;
        this.f1239j = false;
        List arrayList = new ArrayList();
        arrayList.add(C0553u.f1387Q);
        arrayList.add(C0540l.f1345a);
        arrayList.add(c0579o);
        arrayList.addAll(list);
        arrayList.add(C0553u.f1412x);
        arrayList.add(C0553u.f1401m);
        arrayList.add(C0553u.f1395g);
        arrayList.add(C0553u.f1397i);
        arrayList.add(C0553u.f1399k);
        arrayList.add(C0553u.m1249a(Long.TYPE, Long.class, longSerializationPolicy == LongSerializationPolicy.DEFAULT ? C0553u.f1402n : new C0486i(this)));
        arrayList.add(C0553u.m1249a(Double.TYPE, Double.class, new C0484g(this)));
        arrayList.add(C0553u.m1249a(Float.TYPE, Float.class, new C0485h(this)));
        arrayList.add(C0553u.f1406r);
        arrayList.add(C0553u.f1408t);
        arrayList.add(C0553u.f1414z);
        arrayList.add(C0553u.f1372B);
        arrayList.add(C0553u.m1248a(BigDecimal.class, C0553u.f1410v));
        arrayList.add(C0553u.m1248a(BigInteger.class, C0553u.f1411w));
        arrayList.add(C0553u.f1374D);
        arrayList.add(C0553u.f1376F);
        arrayList.add(C0553u.f1380J);
        arrayList.add(C0553u.f1385O);
        arrayList.add(C0553u.f1378H);
        arrayList.add(C0553u.f1392d);
        arrayList.add(C0528d.f1298a);
        arrayList.add(C0553u.f1383M);
        arrayList.add(C0548r.f1363a);
        arrayList.add(C0546p.f1361a);
        arrayList.add(C0553u.f1381K);
        arrayList.add(C0497a.f1280a);
        arrayList.add(C0553u.f1390b);
        arrayList.add(new C0527c(this.f1235f));
        arrayList.add(new C0538k(this.f1235f));
        arrayList.add(new C0530f(this.f1235f));
        arrayList.add(C0553u.f1388R);
        arrayList.add(new C0544n(this.f1235f, c0461c, c0579o));
        this.f1234e = Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    private C0534c m1015a(Writer writer) {
        if (this.f1238i) {
            writer.write(")]}'\n");
        }
        C0534c c0534c = new C0534c(writer);
        if (this.f1239j) {
            c0534c.mo5513c("  ");
        }
        c0534c.mo5517d(this.f1236g);
        return c0534c;
    }

    /* renamed from: a */
    private <T> T m1016a(C0531a c0531a, Type type) {
        boolean z = true;
        boolean p = c0531a.mo5499p();
        c0531a.mo5484a(true);
        try {
            c0531a.mo5490f();
            z = false;
            T a = mo5380a(C0475a.m1006a(type)).mo5377a(c0531a);
            c0531a.mo5484a(p);
            return a;
        } catch (Throwable e) {
            if (z) {
                c0531a.mo5484a(p);
                return null;
            }
            throw new JsonSyntaxException(e);
        } catch (Throwable e2) {
            throw new JsonSyntaxException(e2);
        } catch (Throwable e22) {
            throw new JsonSyntaxException(e22);
        } catch (Throwable th) {
            c0531a.mo5484a(p);
        }
    }

    /* renamed from: a */
    public final <T> C0477r<T> mo5380a(C0475a<T> c0475a) {
        C0477r<T> c0477r = (C0477r) this.f1233d.get(c0475a);
        if (c0477r == null) {
            Map map;
            Map map2 = (Map) this.f1232c.get();
            Object obj = null;
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                this.f1232c.set(hashMap);
                map = hashMap;
                obj = 1;
            } else {
                map = map2;
            }
            C0478a c0477r2 = (C0478a) map.get(c0475a);
            if (c0477r2 == null) {
                try {
                    C0478a c0478a = new C0478a();
                    map.put(c0475a, c0478a);
                    for (C0507s a : this.f1234e) {
                        C0477r c0477r22 = a.mo5478a(this, c0475a);
                        if (c0477r22 != null) {
                            c0478a.mo5379a(c0477r22);
                            this.f1233d.put(c0475a, c0477r22);
                            map.remove(c0475a);
                            if (obj != null) {
                                this.f1232c.remove();
                            }
                        }
                    }
                    throw new IllegalArgumentException("GSON cannot handle " + c0475a);
                } catch (Throwable th) {
                    map.remove(c0475a);
                    if (obj != null) {
                        this.f1232c.remove();
                    }
                }
            }
        }
        return c0477r22;
    }

    /* renamed from: a */
    public final <T> C0477r<T> mo5381a(C0507s c0507s, C0475a<T> c0475a) {
        Object obj = null;
        if (!this.f1234e.contains(c0507s)) {
            obj = 1;
        }
        Object obj2 = obj;
        for (C0507s c0507s2 : this.f1234e) {
            if (obj2 != null) {
                C0477r<T> a = c0507s2.mo5478a(this, c0475a);
                if (a != null) {
                    return a;
                }
            } else if (c0507s2 == c0507s) {
                obj2 = 1;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + c0475a);
    }

    /* renamed from: a */
    public final <T> C0477r<T> mo5382a(Class<T> cls) {
        return mo5380a(C0475a.m1005a((Class) cls));
    }

    /* renamed from: a */
    public final <T> T mo5383a(String str, Class<T> cls) {
        return C0588y.m1295a((Class) cls).cast(mo5384a(str, (Type) cls));
    }

    /* renamed from: a */
    public final <T> T mo5384a(String str, Type type) {
        if (str == null) {
            return null;
        }
        C0531a c0531a = new C0531a(new StringReader(str));
        T a = m1016a(c0531a, type);
        if (a == null) {
            return a;
        }
        try {
            if (c0531a.mo5490f() == JsonToken.END_DOCUMENT) {
                return a;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } catch (Throwable e) {
            throw new JsonSyntaxException(e);
        } catch (Throwable e2) {
            throw new JsonIOException(e2);
        }
    }

    /* renamed from: a */
    public final String mo5385a(Object obj) {
        StringWriter stringWriter;
        C0534c a;
        boolean g;
        boolean h;
        if (obj == null) {
            C0591m c0591m = C0593n.f1463a;
            stringWriter = new StringWriter();
            try {
                a = m1015a((Writer) stringWriter);
                g = a.mo5521g();
                a.mo5511b(true);
                h = a.mo5522h();
                a.mo5514c(this.f1237h);
                boolean i = a.mo5523i();
                a.mo5517d(this.f1236g);
                try {
                    C0589z.m1298a(c0591m, a);
                    a.mo5511b(g);
                    a.mo5514c(h);
                    a.mo5517d(i);
                    return stringWriter.toString();
                } catch (Throwable e) {
                    throw new JsonIOException(e);
                } catch (Throwable th) {
                    a.mo5511b(g);
                    a.mo5514c(h);
                    a.mo5517d(i);
                }
            } catch (Throwable e2) {
                throw new RuntimeException(e2);
            }
        }
        Type type = obj.getClass();
        stringWriter = new StringWriter();
        try {
            a = m1015a((Writer) stringWriter);
            C0477r a2 = mo5380a(C0475a.m1006a(type));
            boolean g2 = a.mo5521g();
            a.mo5511b(true);
            g = a.mo5522h();
            a.mo5514c(this.f1237h);
            h = a.mo5523i();
            a.mo5517d(this.f1236g);
            try {
                a2.mo5378a(a, obj);
                a.mo5511b(g2);
                a.mo5514c(g);
                a.mo5517d(h);
                return stringWriter.toString();
            } catch (Throwable e22) {
                throw new JsonIOException(e22);
            } catch (Throwable th2) {
                a.mo5511b(g2);
                a.mo5514c(g);
                a.mo5517d(h);
            }
        } catch (Throwable e222) {
            throw new JsonIOException(e222);
        }
    }

    public final String toString() {
        return "{serializeNulls:" + this.f1236g + "factories:" + this.f1234e + ",instanceCreators:" + this.f1235f + "}";
    }
}
