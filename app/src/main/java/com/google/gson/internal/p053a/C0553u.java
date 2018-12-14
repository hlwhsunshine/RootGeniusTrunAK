package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.C0507s;
import com.google.gson.C0591m;
import com.google.gson.p051a.C0471c;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;
import com.google.gson.stream.JsonToken;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.google.gson.internal.a.u */
public final class C0553u {
    /* renamed from: A */
    public static final C0477r<StringBuffer> f1371A = new C0501ad();
    /* renamed from: B */
    public static final C0507s f1372B = C0553u.m1248a(StringBuffer.class, f1371A);
    /* renamed from: C */
    public static final C0477r<URL> f1373C = new C0502ae();
    /* renamed from: D */
    public static final C0507s f1374D = C0553u.m1248a(URL.class, f1373C);
    /* renamed from: E */
    public static final C0477r<URI> f1375E = new C0503af();
    /* renamed from: F */
    public static final C0507s f1376F = C0553u.m1248a(URI.class, f1375E);
    /* renamed from: G */
    public static final C0477r<InetAddress> f1377G = new C0505ah();
    /* renamed from: H */
    public static final C0507s f1378H = C0553u.m1250b(InetAddress.class, f1377G);
    /* renamed from: I */
    public static final C0477r<UUID> f1379I = new C0506ai();
    /* renamed from: J */
    public static final C0507s f1380J = C0553u.m1248a(UUID.class, f1379I);
    /* renamed from: K */
    public static final C0507s f1381K = new C0508aj();
    /* renamed from: L */
    public static final C0477r<Calendar> f1382L = new C0510al();
    /* renamed from: M */
    public static final C0507s f1383M = new C0517as(Calendar.class, GregorianCalendar.class, f1382L);
    /* renamed from: N */
    public static final C0477r<Locale> f1384N = new C0511am();
    /* renamed from: O */
    public static final C0507s f1385O = C0553u.m1248a(Locale.class, f1384N);
    /* renamed from: P */
    public static final C0477r<C0591m> f1386P = new C0512an();
    /* renamed from: Q */
    public static final C0507s f1387Q = C0553u.m1250b(C0591m.class, f1386P);
    /* renamed from: R */
    public static final C0507s f1388R = new C0513ao();
    /* renamed from: a */
    public static final C0477r<Class> f1389a = new C0554v();
    /* renamed from: b */
    public static final C0507s f1390b = C0553u.m1248a(Class.class, f1389a);
    /* renamed from: c */
    public static final C0477r<BitSet> f1391c = new C0504ag();
    /* renamed from: d */
    public static final C0507s f1392d = C0553u.m1248a(BitSet.class, f1391c);
    /* renamed from: e */
    public static final C0477r<Boolean> f1393e = new C0516ar();
    /* renamed from: f */
    public static final C0477r<Boolean> f1394f = new C0519au();
    /* renamed from: g */
    public static final C0507s f1395g = C0553u.m1249a(Boolean.TYPE, Boolean.class, f1393e);
    /* renamed from: h */
    public static final C0477r<Number> f1396h = new C0520av();
    /* renamed from: i */
    public static final C0507s f1397i = C0553u.m1249a(Byte.TYPE, Byte.class, f1396h);
    /* renamed from: j */
    public static final C0477r<Number> f1398j = new C0521aw();
    /* renamed from: k */
    public static final C0507s f1399k = C0553u.m1249a(Short.TYPE, Short.class, f1398j);
    /* renamed from: l */
    public static final C0477r<Number> f1400l = new C0522ax();
    /* renamed from: m */
    public static final C0507s f1401m = C0553u.m1249a(Integer.TYPE, Integer.class, f1400l);
    /* renamed from: n */
    public static final C0477r<Number> f1402n = new C0523ay();
    /* renamed from: o */
    public static final C0477r<Number> f1403o = new C0524az();
    /* renamed from: p */
    public static final C0477r<Number> f1404p = new C0555w();
    /* renamed from: q */
    public static final C0477r<Number> f1405q = new C0556x();
    /* renamed from: r */
    public static final C0507s f1406r = C0553u.m1248a(Number.class, f1405q);
    /* renamed from: s */
    public static final C0477r<Character> f1407s = new C0557y();
    /* renamed from: t */
    public static final C0507s f1408t = C0553u.m1249a(Character.TYPE, Character.class, f1407s);
    /* renamed from: u */
    public static final C0477r<String> f1409u = new C0558z();
    /* renamed from: v */
    public static final C0477r<BigDecimal> f1410v = new C0498aa();
    /* renamed from: w */
    public static final C0477r<BigInteger> f1411w = new C0499ab();
    /* renamed from: x */
    public static final C0507s f1412x = C0553u.m1248a(String.class, f1409u);
    /* renamed from: y */
    public static final C0477r<StringBuilder> f1413y = new C0500ac();
    /* renamed from: z */
    public static final C0507s f1414z = C0553u.m1248a(StringBuilder.class, f1413y);

    /* renamed from: com.google.gson.internal.a.u$a */
    private static final class C0552a<T extends Enum<T>> extends C0477r<T> {
        /* renamed from: a */
        private final Map<String, T> f1369a = new HashMap();
        /* renamed from: b */
        private final Map<T, String> f1370b = new HashMap();

        public C0552a(Class<T> cls) {
            try {
                for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
                    String name = enumR.name();
                    C0471c c0471c = (C0471c) cls.getField(name).getAnnotation(C0471c.class);
                    if (c0471c != null) {
                        name = c0471c.mo5365a();
                        for (Object put : c0471c.mo5366b()) {
                            this.f1369a.put(put, enumR);
                        }
                    }
                    String str = name;
                    this.f1369a.put(str, enumR);
                    this.f1370b.put(enumR, str);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError();
            }
        }

        /* renamed from: a */
        public final /* synthetic */ Object mo5377a(C0531a c0531a) {
            if (c0531a.mo5490f() != JsonToken.NULL) {
                return (Enum) this.f1369a.get(c0531a.mo5492h());
            }
            c0531a.mo5494j();
            return null;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5378a(C0534c c0534c, Object obj) {
            Enum enumR = (Enum) obj;
            c0534c.mo5510b(enumR == null ? null : (String) this.f1370b.get(enumR));
        }
    }

    /* renamed from: a */
    public static <TT> C0507s m1248a(Class<TT> cls, C0477r<TT> c0477r) {
        return new C0514ap(cls, c0477r);
    }

    /* renamed from: a */
    public static <TT> C0507s m1249a(Class<TT> cls, Class<TT> cls2, C0477r<? super TT> c0477r) {
        return new C0515aq(cls, cls2, c0477r);
    }

    /* renamed from: b */
    private static <TT> C0507s m1250b(Class<TT> cls, C0477r<TT> c0477r) {
        return new C0518at(cls, c0477r);
    }
}
