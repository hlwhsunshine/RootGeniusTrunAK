package okhttp3.internal.http;

import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.C1791ab;
import okhttp3.C1791ab.C1790a;
import okhttp3.C1792ac;
import okhttp3.C1923s;
import okhttp3.C1923s.C1922a;
import okhttp3.C1932y;
import okhttp3.Protocol;
import okhttp3.internal.C1910m;
import okhttp3.internal.framed.C1837c;
import okhttp3.internal.framed.C1856o;
import okhttp3.internal.framed.C1857p;
import okio.ByteString;
import okio.C1823w;
import okio.C1850x;
import okio.C1869j;
import okio.C1945n;

/* renamed from: okhttp3.internal.http.e */
public final class C1892e implements C1889l {
    /* renamed from: a */
    private static final ByteString f5592a = ByteString.encodeUtf8("connection");
    /* renamed from: b */
    private static final ByteString f5593b = ByteString.encodeUtf8("host");
    /* renamed from: c */
    private static final ByteString f5594c = ByteString.encodeUtf8("keep-alive");
    /* renamed from: d */
    private static final ByteString f5595d = ByteString.encodeUtf8("proxy-connection");
    /* renamed from: e */
    private static final ByteString f5596e = ByteString.encodeUtf8("transfer-encoding");
    /* renamed from: f */
    private static final ByteString f5597f = ByteString.encodeUtf8("te");
    /* renamed from: g */
    private static final ByteString f5598g = ByteString.encodeUtf8("encoding");
    /* renamed from: h */
    private static final ByteString f5599h = ByteString.encodeUtf8("upgrade");
    /* renamed from: i */
    private static final List<ByteString> f5600i = C1910m.m5448a(f5592a, f5593b, f5594c, f5595d, f5596e, C1857p.f5482b, C1857p.f5483c, C1857p.f5484d, C1857p.f5485e, C1857p.f5486f, C1857p.f5487g);
    /* renamed from: j */
    private static final List<ByteString> f5601j = C1910m.m5448a(f5592a, f5593b, f5594c, f5595d, f5596e);
    /* renamed from: k */
    private static final List<ByteString> f5602k = C1910m.m5448a(f5592a, f5593b, f5594c, f5595d, f5597f, f5596e, f5598g, f5599h, C1857p.f5482b, C1857p.f5483c, C1857p.f5484d, C1857p.f5485e, C1857p.f5486f, C1857p.f5487g);
    /* renamed from: l */
    private static final List<ByteString> f5603l = C1910m.m5448a(f5592a, f5593b, f5594c, f5595d, f5597f, f5596e, f5598g, f5599h);
    /* renamed from: m */
    private final C1907s f5604m;
    /* renamed from: n */
    private final C1837c f5605n;
    /* renamed from: o */
    private C1897h f5606o;
    /* renamed from: p */
    private C1856o f5607p;

    /* renamed from: okhttp3.internal.http.e$a */
    class C1891a extends C1869j {
        public C1891a(C1850x c1850x) {
            super(c1850x);
        }

        public final void close() {
            C1892e.this.f5604m.mo8868a(false, C1892e.this);
            super.close();
        }
    }

    public C1892e(C1907s c1907s, C1837c c1837c) {
        this.f5604m = c1907s;
        this.f5605n = c1837c;
    }

    /* renamed from: a */
    private static C1790a m5358a(List<C1857p> list) {
        String str = null;
        String str2 = "HTTP/1.1";
        C1922a c1922a = new C1922a();
        int size = list.size();
        int i = 0;
        while (i < size) {
            ByteString byteString = ((C1857p) list.get(i)).f5488h;
            String utf8 = ((C1857p) list.get(i)).f5489i.utf8();
            String str3 = str2;
            int i2 = 0;
            while (i2 < utf8.length()) {
                int indexOf = utf8.indexOf(0, i2);
                if (indexOf == -1) {
                    indexOf = utf8.length();
                }
                str2 = utf8.substring(i2, indexOf);
                if (!byteString.equals(C1857p.f5481a)) {
                    if (byteString.equals(C1857p.f5487g)) {
                        str3 = str2;
                        str2 = str;
                    } else {
                        if (!f5601j.contains(byteString)) {
                            c1922a.mo8910a(byteString.utf8(), str2);
                        }
                        str2 = str;
                    }
                }
                str = str2;
                i2 = indexOf + 1;
            }
            i++;
            str2 = str3;
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        C1906r a = C1906r.m5418a(str2 + " " + str);
        return new C1790a().mo8618a(Protocol.SPDY_3).mo8614a(a.f5659b).mo8616a(a.f5660c).mo8622a(c1922a.mo8911a());
    }

    /* renamed from: b */
    private static List<C1857p> m5360b(C1932y c1932y) {
        C1923s c = c1932y.mo8966c();
        List<C1857p> arrayList = new ArrayList(c.mo8914a() + 5);
        arrayList.add(new C1857p(C1857p.f5482b, c1932y.mo8965b()));
        arrayList.add(new C1857p(C1857p.f5483c, C1903o.m5406a(c1932y.mo8964a())));
        arrayList.add(new C1857p(C1857p.f5487g, "HTTP/1.1"));
        arrayList.add(new C1857p(C1857p.f5486f, C1910m.m5446a(c1932y.mo8964a(), false)));
        arrayList.add(new C1857p(C1857p.f5484d, c1932y.mo8964a().mo8582b()));
        Set linkedHashSet = new LinkedHashSet();
        int a = c.mo8914a();
        for (int i = 0; i < a; i++) {
            ByteString encodeUtf8 = ByteString.encodeUtf8(c.mo8915a(i).toLowerCase(Locale.US));
            if (!f5600i.contains(encodeUtf8)) {
                String b = c.mo8917b(i);
                if (linkedHashSet.add(encodeUtf8)) {
                    arrayList.add(new C1857p(encodeUtf8, b));
                } else {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        if (((C1857p) arrayList.get(i2)).f5488h.equals(encodeUtf8)) {
                            arrayList.set(i2, new C1857p(encodeUtf8, new StringBuilder(((C1857p) arrayList.get(i2)).f5489i.utf8()).append(0).append(b).toString()));
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public final C1790a mo8836a() {
        if (this.f5605n.mo8751a() != Protocol.HTTP_2) {
            return C1892e.m5358a(this.f5607p.mo8792d());
        }
        List d = this.f5607p.mo8792d();
        String str = null;
        C1922a c1922a = new C1922a();
        int size = d.size();
        int i = 0;
        while (i < size) {
            ByteString byteString = ((C1857p) d.get(i)).f5488h;
            String utf8 = ((C1857p) d.get(i)).f5489i.utf8();
            if (!byteString.equals(C1857p.f5481a)) {
                if (!f5603l.contains(byteString)) {
                    c1922a.mo8910a(byteString.utf8(), utf8);
                }
                utf8 = str;
            }
            i++;
            str = utf8;
        }
        if (str == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        C1906r a = C1906r.m5418a("HTTP/1.1 " + str);
        return new C1790a().mo8618a(Protocol.HTTP_2).mo8614a(a.f5659b).mo8616a(a.f5660c).mo8622a(c1922a.mo8911a());
    }

    /* renamed from: a */
    public final C1792ac mo8837a(C1791ab c1791ab) {
        return new C1902n(c1791ab.mo8634e(), C1945n.m5708a(new C1891a(this.f5607p.mo8795g())));
    }

    /* renamed from: a */
    public final C1823w mo8838a(C1932y c1932y, long j) {
        return this.f5607p.mo8796h();
    }

    /* renamed from: a */
    public final void mo8839a(C1897h c1897h) {
        this.f5606o = c1897h;
    }

    /* renamed from: a */
    public final void mo8840a(C1904p c1904p) {
        c1904p.mo8858a(this.f5607p.mo8796h());
    }

    /* renamed from: a */
    public final void mo8841a(C1932y c1932y) {
        int i = 0;
        if (this.f5607p == null) {
            List arrayList;
            this.f5606o.mo8853b();
            boolean a = C1897h.m5377a(c1932y);
            if (this.f5605n.mo8751a() == Protocol.HTTP_2) {
                C1923s c = c1932y.mo8966c();
                arrayList = new ArrayList(c.mo8914a() + 4);
                arrayList.add(new C1857p(C1857p.f5482b, c1932y.mo8965b()));
                arrayList.add(new C1857p(C1857p.f5483c, C1903o.m5406a(c1932y.mo8964a())));
                arrayList.add(new C1857p(C1857p.f5485e, C1910m.m5446a(c1932y.mo8964a(), false)));
                arrayList.add(new C1857p(C1857p.f5484d, c1932y.mo8964a().mo8582b()));
                int a2 = c.mo8914a();
                while (i < a2) {
                    ByteString encodeUtf8 = ByteString.encodeUtf8(c.mo8915a(i).toLowerCase(Locale.US));
                    if (!f5602k.contains(encodeUtf8)) {
                        arrayList.add(new C1857p(encodeUtf8, c.mo8917b(i)));
                    }
                    i++;
                }
            } else {
                arrayList = C1892e.m5360b(c1932y);
            }
            this.f5607p = this.f5605n.mo8753a(arrayList, a);
            this.f5607p.mo8793e().mo8768a((long) this.f5606o.f5617a.mo8936b(), TimeUnit.MILLISECONDS);
            this.f5607p.mo8794f().mo8768a((long) this.f5606o.f5617a.mo8937c(), TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: b */
    public final void mo8842b() {
        this.f5607p.mo8796h().close();
    }
}
