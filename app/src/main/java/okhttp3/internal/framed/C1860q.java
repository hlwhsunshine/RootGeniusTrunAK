package okhttp3.internal.framed;

import android.support.p015v4.media.TransportMediator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import okio.C1850x;
import okio.C1938h;
import okio.C1939e;
import okio.C1945n;

/* renamed from: okhttp3.internal.framed.q */
final class C1860q {
    /* renamed from: a */
    private static final C1857p[] f5500a = new C1857p[]{new C1857p(C1857p.f5485e, ""), new C1857p(C1857p.f5482b, "GET"), new C1857p(C1857p.f5482b, "POST"), new C1857p(C1857p.f5483c, "/"), new C1857p(C1857p.f5483c, "/index.html"), new C1857p(C1857p.f5484d, "http"), new C1857p(C1857p.f5484d, "https"), new C1857p(C1857p.f5481a, "200"), new C1857p(C1857p.f5481a, "204"), new C1857p(C1857p.f5481a, "206"), new C1857p(C1857p.f5481a, "304"), new C1857p(C1857p.f5481a, "400"), new C1857p(C1857p.f5481a, "404"), new C1857p(C1857p.f5481a, "500"), new C1857p("accept-charset", ""), new C1857p("accept-encoding", "gzip, deflate"), new C1857p("accept-language", ""), new C1857p("accept-ranges", ""), new C1857p("accept", ""), new C1857p("access-control-allow-origin", ""), new C1857p("age", ""), new C1857p("allow", ""), new C1857p("authorization", ""), new C1857p("cache-control", ""), new C1857p("content-disposition", ""), new C1857p("content-encoding", ""), new C1857p("content-language", ""), new C1857p("content-length", ""), new C1857p("content-location", ""), new C1857p("content-range", ""), new C1857p("content-type", ""), new C1857p("cookie", ""), new C1857p("date", ""), new C1857p("etag", ""), new C1857p("expect", ""), new C1857p("expires", ""), new C1857p("from", ""), new C1857p("host", ""), new C1857p("if-match", ""), new C1857p("if-modified-since", ""), new C1857p("if-none-match", ""), new C1857p("if-range", ""), new C1857p("if-unmodified-since", ""), new C1857p("last-modified", ""), new C1857p("link", ""), new C1857p("location", ""), new C1857p("max-forwards", ""), new C1857p("proxy-authenticate", ""), new C1857p("proxy-authorization", ""), new C1857p("range", ""), new C1857p("referer", ""), new C1857p("refresh", ""), new C1857p("retry-after", ""), new C1857p("server", ""), new C1857p("set-cookie", ""), new C1857p("strict-transport-security", ""), new C1857p("transfer-encoding", ""), new C1857p("user-agent", ""), new C1857p("vary", ""), new C1857p("via", ""), new C1857p("www-authenticate", "")};
    /* renamed from: b */
    private static final Map<ByteString, Integer> f5501b;

    /* renamed from: okhttp3.internal.framed.q$a */
    static final class C1858a {
        /* renamed from: a */
        C1857p[] f5491a = new C1857p[8];
        /* renamed from: b */
        int f5492b = (this.f5491a.length - 1);
        /* renamed from: c */
        int f5493c = 0;
        /* renamed from: d */
        int f5494d = 0;
        /* renamed from: e */
        private final List<C1857p> f5495e = new ArrayList();
        /* renamed from: f */
        private final C1938h f5496f;
        /* renamed from: g */
        private int f5497g = 4096;
        /* renamed from: h */
        private int f5498h = 4096;

        C1858a(C1850x c1850x) {
            this.f5496f = C1945n.m5708a(c1850x);
        }

        /* renamed from: a */
        private int m5226a(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            i3 = 0;
            while (true) {
                int e = m5233e();
                if ((e & 128) == 0) {
                    return (e << i3) + i2;
                }
                i2 += (e & TransportMediator.KEYCODE_MEDIA_PAUSE) << i3;
                i3 += 7;
            }
        }

        /* renamed from: a */
        private void m5227a(C1857p c1857p) {
            this.f5495e.add(c1857p);
            int i = c1857p.f5490j;
            if (i > this.f5498h) {
                m5232d();
                return;
            }
            m5228b((this.f5494d + i) - this.f5498h);
            if (this.f5493c + 1 > this.f5491a.length) {
                Object obj = new C1857p[(this.f5491a.length * 2)];
                System.arraycopy(this.f5491a, 0, obj, this.f5491a.length, this.f5491a.length);
                this.f5492b = this.f5491a.length - 1;
                this.f5491a = obj;
            }
            int i2 = this.f5492b;
            this.f5492b = i2 - 1;
            this.f5491a[i2] = c1857p;
            this.f5493c++;
            this.f5494d = i + this.f5494d;
        }

        /* renamed from: b */
        private int m5228b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f5491a.length;
                while (true) {
                    length--;
                    if (length < this.f5492b || i <= 0) {
                        System.arraycopy(this.f5491a, this.f5492b + 1, this.f5491a, (this.f5492b + 1) + i2, this.f5493c);
                        this.f5492b += i2;
                    } else {
                        i -= this.f5491a[length].f5490j;
                        this.f5494d -= this.f5491a[length].f5490j;
                        this.f5493c--;
                        i2++;
                    }
                }
                System.arraycopy(this.f5491a, this.f5492b + 1, this.f5491a, (this.f5492b + 1) + i2, this.f5493c);
                this.f5492b += i2;
            }
            return i2;
        }

        /* renamed from: c */
        private int m5229c(int i) {
            return (this.f5492b + 1) + i;
        }

        /* renamed from: c */
        private void m5230c() {
            if (this.f5498h >= this.f5494d) {
                return;
            }
            if (this.f5498h == 0) {
                m5232d();
            } else {
                m5228b(this.f5494d - this.f5498h);
            }
        }

        /* renamed from: d */
        private ByteString m5231d(int i) {
            return C1858a.m5234e(i) ? C1860q.f5500a[i].f5488h : this.f5491a[m5229c(i - C1860q.f5500a.length)].f5488h;
        }

        /* renamed from: d */
        private void m5232d() {
            this.f5495e.clear();
            Arrays.fill(this.f5491a, null);
            this.f5492b = this.f5491a.length - 1;
            this.f5493c = 0;
            this.f5494d = 0;
        }

        /* renamed from: e */
        private int m5233e() {
            return this.f5496f.mo9032g() & 255;
        }

        /* renamed from: e */
        private static boolean m5234e(int i) {
            return i >= 0 && i <= C1860q.f5500a.length - 1;
        }

        /* renamed from: f */
        private ByteString m5235f() {
            int e = m5233e();
            Object obj = (e & 128) == 128 ? 1 : null;
            e = m5226a(e, TransportMediator.KEYCODE_MEDIA_PAUSE);
            return obj != null ? ByteString.m5587of(C1867s.m5278a().mo8807a(this.f5496f.mo9029e((long) e))) : this.f5496f.mo9026c((long) e);
        }

        /* renamed from: a */
        final void mo8801a() {
            while (!this.f5496f.mo9028e()) {
                int g = this.f5496f.mo9032g() & 255;
                if (g == 128) {
                    throw new IOException("index == 0");
                } else if ((g & 128) == 128) {
                    g = m5226a(g, TransportMediator.KEYCODE_MEDIA_PAUSE) - 1;
                    if (C1858a.m5234e(g)) {
                        this.f5495e.add(C1860q.f5500a[g]);
                    } else {
                        int c = m5229c(g - C1860q.f5500a.length);
                        if (c < 0 || c > this.f5491a.length - 1) {
                            throw new IOException("Header index too large " + (g + 1));
                        }
                        this.f5495e.add(this.f5491a[c]);
                    }
                } else if (g == 64) {
                    m5227a(new C1857p(C1860q.m5242a(m5235f()), m5235f()));
                } else if ((g & 64) == 64) {
                    m5227a(new C1857p(m5231d(m5226a(g, 63) - 1), m5235f()));
                } else if ((g & 32) == 32) {
                    this.f5498h = m5226a(g, 31);
                    if (this.f5498h < 0 || this.f5498h > this.f5497g) {
                        throw new IOException("Invalid dynamic table size update " + this.f5498h);
                    }
                    m5230c();
                } else if (g == 16 || g == 0) {
                    this.f5495e.add(new C1857p(C1860q.m5242a(m5235f()), m5235f()));
                } else {
                    this.f5495e.add(new C1857p(m5231d(m5226a(g, 15) - 1), m5235f()));
                }
            }
        }

        /* renamed from: a */
        final void mo8802a(int i) {
            this.f5497g = i;
            this.f5498h = i;
            m5230c();
        }

        /* renamed from: b */
        public final List<C1857p> mo8803b() {
            List arrayList = new ArrayList(this.f5495e);
            this.f5495e.clear();
            return arrayList;
        }
    }

    /* renamed from: okhttp3.internal.framed.q$b */
    static final class C1859b {
        /* renamed from: a */
        private final C1939e f5499a;

        C1859b(C1939e c1939e) {
            this.f5499a = c1939e;
        }

        /* renamed from: a */
        private void m5239a(int i, int i2) {
            if (i < i2) {
                this.f5499a.mo9020h(i | 0);
                return;
            }
            this.f5499a.mo9020h(i2 | 0);
            int i3 = i - i2;
            while (i3 >= 128) {
                this.f5499a.mo9020h((i3 & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
                i3 >>>= 7;
            }
            this.f5499a.mo9020h(i3);
        }

        /* renamed from: a */
        private void m5240a(ByteString byteString) {
            m5239a(byteString.size(), TransportMediator.KEYCODE_MEDIA_PAUSE);
            this.f5499a.mo9013b(byteString);
        }

        /* renamed from: a */
        final void mo8804a(List<C1857p> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ByteString toAsciiLowercase = ((C1857p) list.get(i)).f5488h.toAsciiLowercase();
                Integer num = (Integer) C1860q.f5501b.get(toAsciiLowercase);
                if (num != null) {
                    m5239a(num.intValue() + 1, 15);
                    m5240a(((C1857p) list.get(i)).f5489i);
                } else {
                    this.f5499a.mo9020h(0);
                    m5240a(toAsciiLowercase);
                    m5240a(((C1857p) list.get(i)).f5489i);
                }
            }
        }
    }

    static {
        int i = 0;
        Map linkedHashMap = new LinkedHashMap(f5500a.length);
        while (i < f5500a.length) {
            if (!linkedHashMap.containsKey(f5500a[i].f5488h)) {
                linkedHashMap.put(f5500a[i].f5488h, Integer.valueOf(i));
            }
            i++;
        }
        f5501b = Collections.unmodifiableMap(linkedHashMap);
    }

    /* renamed from: a */
    static /* synthetic */ ByteString m5242a(ByteString byteString) {
        int i = 0;
        int size = byteString.size();
        while (i < size) {
            byte b = byteString.getByte(i);
            if (b < (byte) 65 || b > (byte) 90) {
                i++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }
}
