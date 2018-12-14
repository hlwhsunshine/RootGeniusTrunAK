package okhttp3.internal.http;

import com.p070qq.p071e.comm.constants.ErrorCode.InitError;
import com.p070qq.p071e.comm.constants.ErrorCode.NetWorkError;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy.Type;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.C1787a;
import okhttp3.C1791ab;
import okhttp3.C1791ab.C1790a;
import okhttp3.C1792ac;
import okhttp3.C1793ad;
import okhttp3.C1802g;
import okhttp3.C1803h;
import okhttp3.C1804i;
import okhttp3.C1915l;
import okhttp3.C1916m;
import okhttp3.C1923s;
import okhttp3.C1923s.C1922a;
import okhttp3.C1924t;
import okhttp3.C1924t.C1895a;
import okhttp3.C1927v;
import okhttp3.C1932y;
import okhttp3.C1932y.C1931a;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.internal.C1825e;
import okhttp3.internal.C1826f;
import okhttp3.internal.C1910m;
import okhttp3.internal.http.C1881b.C1880a;
import okio.C1823w;
import okio.C1850x;
import okio.C1937g;
import okio.C1943l;
import okio.C1945n;

/* renamed from: okhttp3.internal.http.h */
public final class C1897h {
    /* renamed from: e */
    private static final C1792ac f5616e = new C1898i();
    /* renamed from: a */
    final C1927v f5617a;
    /* renamed from: b */
    public final C1907s f5618b;
    /* renamed from: c */
    long f5619c = -1;
    /* renamed from: d */
    public final boolean f5620d;
    /* renamed from: f */
    private final C1791ab f5621f;
    /* renamed from: g */
    private C1889l f5622g;
    /* renamed from: h */
    private boolean f5623h;
    /* renamed from: i */
    private final C1932y f5624i;
    /* renamed from: j */
    private C1932y f5625j;
    /* renamed from: k */
    private C1791ab f5626k;
    /* renamed from: l */
    private C1791ab f5627l;
    /* renamed from: m */
    private C1823w f5628m;
    /* renamed from: n */
    private C1937g f5629n;
    /* renamed from: o */
    private final boolean f5630o;
    /* renamed from: p */
    private final boolean f5631p;
    /* renamed from: q */
    private C1879a f5632q;
    /* renamed from: r */
    private C1881b f5633r;

    /* renamed from: okhttp3.internal.http.h$a */
    class C1896a implements C1895a {
        /* renamed from: b */
        private final int f5612b;
        /* renamed from: c */
        private final C1932y f5613c;
        /* renamed from: d */
        private final C1803h f5614d;
        /* renamed from: e */
        private int f5615e;

        C1896a(int i, C1932y c1932y, C1803h c1803h) {
            this.f5612b = i;
            this.f5613c = c1932y;
            this.f5614d = c1803h;
        }

        /* renamed from: a */
        public final C1791ab mo8848a(C1932y c1932y) {
            C1924t c1924t;
            this.f5615e++;
            if (this.f5612b > 0) {
                c1924t = (C1924t) C1897h.this.f5617a.mo8954t().get(this.f5612b - 1);
                C1787a a = this.f5614d.mo8673a().mo8646a();
                if (!c1932y.mo8964a().mo8588f().equals(a.mo8598a().mo8588f()) || c1932y.mo8964a().mo8589g() != a.mo8598a().mo8589g()) {
                    throw new IllegalStateException("network interceptor " + c1924t + " must retain the same host and port");
                } else if (this.f5615e > 1) {
                    throw new IllegalStateException("network interceptor " + c1924t + " must call proceed() exactly once");
                }
            }
            if (this.f5612b < C1897h.this.f5617a.mo8954t().size()) {
                C1896a c1896a = new C1896a(this.f5612b + 1, c1932y, this.f5614d);
                c1924t = (C1924t) C1897h.this.f5617a.mo8954t().get(this.f5612b);
                C1791ab a2 = c1924t.mo8923a();
                if (c1896a.f5615e != 1) {
                    throw new IllegalStateException("network interceptor " + c1924t + " must call proceed() exactly once");
                } else if (a2 != null) {
                    return a2;
                } else {
                    throw new NullPointerException("network interceptor " + c1924t + " returned null");
                }
            }
            C1897h.this.f5622g.mo8841a(c1932y);
            C1897h.this.f5625j = c1932y;
            if (C1897h.m5377a(c1932y) && c1932y.mo8967d() != null) {
                C1937g a3 = C1945n.m5707a(C1897h.this.f5622g.mo8838a(c1932y, c1932y.mo8967d().mo8613b()));
                c1932y.mo8967d().mo8612a(a3);
                a3.close();
            }
            C1791ab b = C1897h.this.m5381g();
            int b2 = b.mo8630b();
            if ((b2 != 204 && b2 != 205) || b.mo8635f().mo8642b() <= 0) {
                return b;
            }
            throw new ProtocolException("HTTP " + b2 + " had non-zero Content-Length: " + b.mo8635f().mo8642b());
        }
    }

    public C1897h(C1927v c1927v, C1932y c1932y, boolean z, boolean z2, boolean z3, C1907s c1907s, C1791ab c1791ab) {
        this.f5617a = c1927v;
        this.f5624i = c1932y;
        this.f5620d = z;
        this.f5630o = z2;
        this.f5631p = z3;
        if (c1907s == null) {
            C1804i n = c1927v.mo8948n();
            SSLSocketFactory sSLSocketFactory = null;
            HostnameVerifier hostnameVerifier = null;
            C1802g c1802g = null;
            if (c1932y.mo8970g()) {
                sSLSocketFactory = c1927v.mo8943i();
                hostnameVerifier = c1927v.mo8944j();
                c1802g = c1927v.mo8945k();
            }
            C1907s c1907s2 = new C1907s(n, new C1787a(c1932y.mo8964a().mo8588f(), c1932y.mo8964a().mo8589g(), c1927v.mo8941g(), c1927v.mo8942h(), sSLSocketFactory, hostnameVerifier, c1802g, c1927v.mo8947m(), c1927v.mo8938d(), c1927v.mo8952r(), c1927v.mo8953s(), c1927v.mo8939e()));
        }
        this.f5618b = c1907s;
        this.f5628m = null;
        this.f5621f = c1791ab;
    }

    /* renamed from: a */
    private static String m5372a(List<C1915l> list) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append("; ");
            }
            C1915l c1915l = (C1915l) list.get(i);
            stringBuilder.append(c1915l.mo8895a()).append('=').append(c1915l.mo8896b());
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private static C1923s m5374a(C1923s c1923s, C1923s c1923s2) {
        int i;
        int i2 = 0;
        C1922a c1922a = new C1922a();
        int a = c1923s.mo8914a();
        for (i = 0; i < a; i++) {
            String a2 = c1923s.mo8915a(i);
            String b = c1923s.mo8917b(i);
            if (!("Warning".equalsIgnoreCase(a2) && b.startsWith("1")) && (!C1901m.m5401a(a2) || c1923s2.mo8916a(a2) == null)) {
                c1922a.mo8910a(a2, b);
            }
        }
        i = c1923s2.mo8914a();
        while (i2 < i) {
            String a3 = c1923s2.mo8915a(i2);
            if (!"Content-Length".equalsIgnoreCase(a3) && C1901m.m5401a(a3)) {
                c1922a.mo8910a(a3, c1923s2.mo8917b(i2));
            }
            i2++;
        }
        return c1922a.mo8911a();
    }

    /* renamed from: a */
    public static boolean m5376a(C1791ab c1791ab) {
        if (c1791ab.mo8629a().mo8965b().equals("HEAD")) {
            return false;
        }
        int b = c1791ab.mo8630b();
        return ((b >= 100 && b < 200) || b == 204 || b == InitError.INVALID_REQUEST_ERROR) ? C1901m.m5398a(c1791ab) != -1 || "chunked".equalsIgnoreCase(c1791ab.mo8628a("Transfer-Encoding")) : true;
    }

    /* renamed from: a */
    static boolean m5377a(C1932y c1932y) {
        return C1900k.m5397b(c1932y.mo8965b());
    }

    /* renamed from: b */
    private static C1791ab m5378b(C1791ab c1791ab) {
        return (c1791ab == null || c1791ab.mo8635f() == null) ? c1791ab : c1791ab.mo8636g().mo8620a(null).mo8624a();
    }

    /* renamed from: c */
    private C1791ab m5380c(C1791ab c1791ab) {
        if (!this.f5623h || !"gzip".equalsIgnoreCase(this.f5627l.mo8628a("Content-Encoding")) || c1791ab.mo8635f() == null) {
            return c1791ab;
        }
        C1850x c1943l = new C1943l(c1791ab.mo8635f().mo8643c());
        C1923s a = c1791ab.mo8634e().mo8919b().mo8912b("Content-Encoding").mo8912b("Content-Length").mo8911a();
        return c1791ab.mo8636g().mo8622a(a).mo8620a(new C1902n(a, C1945n.m5708a(c1943l))).mo8624a();
    }

    /* renamed from: g */
    private C1791ab m5381g() {
        this.f5622g.mo8842b();
        C1791ab a = this.f5622g.mo8836a().mo8623a(this.f5625j).mo8621a(this.f5618b.mo8869b().mo8683b()).mo8615a(this.f5619c).mo8625b(System.currentTimeMillis()).mo8624a();
        if (!this.f5631p) {
            a = a.mo8636g().mo8620a(this.f5622g.mo8837a(a)).mo8624a();
        }
        if ("close".equalsIgnoreCase(a.mo8629a().mo8963a("Connection")) || "close".equalsIgnoreCase(a.mo8628a("Connection"))) {
            this.f5618b.mo8871d();
        }
        return a;
    }

    /* renamed from: a */
    public final C1897h mo8849a(IOException iOException, boolean z) {
        Object obj = null;
        this.f5618b.mo8866a(iOException);
        if (!this.f5617a.mo8951q()) {
            return null;
        }
        if (!(iOException instanceof ProtocolException) && ((iOException instanceof InterruptedIOException) ? (iOException instanceof SocketTimeoutException) && z : !(((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)))) {
            obj = 1;
        }
        if (obj == null || !this.f5618b.mo8872e()) {
            return null;
        }
        return new C1897h(this.f5617a, this.f5624i, this.f5620d, this.f5630o, this.f5631p, mo8855d(), this.f5621f);
    }

    /* renamed from: a */
    public final void mo8850a() {
        if (this.f5633r == null) {
            if (this.f5622g != null) {
                throw new IllegalStateException();
            }
            C1932y c1932y = this.f5624i;
            C1931a e = c1932y.mo8968e();
            if (c1932y.mo8963a("Host") == null) {
                e.mo8957a("Host", C1910m.m5446a(c1932y.mo8964a(), false));
            }
            if (c1932y.mo8963a("Connection") == null) {
                e.mo8957a("Connection", "Keep-Alive");
            }
            if (c1932y.mo8963a("Accept-Encoding") == null) {
                this.f5623h = true;
                e.mo8957a("Accept-Encoding", "gzip");
            }
            List b = this.f5617a.mo8940f().mo8901b();
            if (!b.isEmpty()) {
                e.mo8957a("Cookie", C1897h.m5372a(b));
            }
            if (c1932y.mo8963a("User-Agent") == null) {
                e.mo8957a("User-Agent", "okhttp/3.3.0");
            }
            C1932y a = e.mo8961a();
            C1826f a2 = C1825e.f5371a.mo8708a(this.f5617a);
            C1791ab a3 = a2 != null ? a2.mo8714a() : null;
            this.f5633r = new C1880a(System.currentTimeMillis(), a, a3).mo8834a();
            this.f5625j = this.f5633r.f5566a;
            this.f5626k = this.f5633r.f5567b;
            if (a3 != null && this.f5626k == null) {
                C1910m.m5452a(a3.mo8635f());
            }
            if (this.f5625j == null && this.f5626k == null) {
                this.f5627l = new C1790a().mo8623a(this.f5624i).mo8627c(C1897h.m5378b(this.f5621f)).mo8618a(Protocol.HTTP_1_1).mo8614a(504).mo8616a("Unsatisfiable Request (only-if-cached)").mo8620a(f5616e).mo8615a(this.f5619c).mo8625b(System.currentTimeMillis()).mo8624a();
            } else if (this.f5625j == null) {
                this.f5627l = this.f5626k.mo8636g().mo8623a(this.f5624i).mo8627c(C1897h.m5378b(this.f5621f)).mo8626b(C1897h.m5378b(this.f5626k)).mo8624a();
                this.f5627l = m5380c(this.f5627l);
            } else {
                try {
                    this.f5622g = this.f5618b.mo8865a(this.f5617a.mo8934a(), this.f5617a.mo8936b(), this.f5617a.mo8937c(), this.f5617a.mo8951q(), !this.f5625j.mo8965b().equals("GET"));
                    this.f5622g.mo8839a(this);
                    boolean z = this.f5630o && C1900k.m5397b(this.f5625j.mo8965b()) && this.f5628m == null;
                    if (z) {
                        long a4 = C1901m.m5400a(a);
                        if (!this.f5620d) {
                            this.f5622g.mo8841a(this.f5625j);
                            this.f5628m = this.f5622g.mo8838a(this.f5625j, a4);
                        } else if (a4 > 2147483647L) {
                            throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                        } else if (a4 != -1) {
                            this.f5622g.mo8841a(this.f5625j);
                            this.f5628m = new C1904p((int) a4);
                        } else {
                            this.f5628m = new C1904p();
                        }
                    }
                } catch (Throwable th) {
                    if (a3 != null) {
                        C1910m.m5452a(a3.mo8635f());
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo8851a(C1923s c1923s) {
        if (this.f5617a.mo8940f() != C1916m.f5707a && !C1915l.m5488a(this.f5624i.mo8964a(), c1923s).isEmpty()) {
            this.f5617a.mo8940f().mo8900a();
        }
    }

    /* renamed from: a */
    public final boolean mo8852a(HttpUrl httpUrl) {
        HttpUrl a = this.f5624i.mo8964a();
        return a.mo8588f().equals(httpUrl.mo8588f()) && a.mo8589g() == httpUrl.mo8589g() && a.mo8582b().equals(httpUrl.mo8582b());
    }

    /* renamed from: b */
    public final void mo8853b() {
        if (this.f5619c != -1) {
            throw new IllegalStateException();
        }
        this.f5619c = System.currentTimeMillis();
    }

    /* renamed from: c */
    public final C1791ab mo8854c() {
        if (this.f5627l != null) {
            return this.f5627l;
        }
        throw new IllegalStateException();
    }

    /* renamed from: d */
    public final C1907s mo8855d() {
        if (this.f5629n != null) {
            C1910m.m5452a(this.f5629n);
        } else if (this.f5628m != null) {
            C1910m.m5452a(this.f5628m);
        }
        if (this.f5627l != null) {
            C1910m.m5452a(this.f5627l.mo8635f());
        } else {
            this.f5618b.mo8866a(null);
        }
        return this.f5618b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:78:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0195  */
    /* JADX WARNING: Missing block: B:50:0x0153, code:
            if (r4.getTime() < r3.getTime()) goto L_0x0041;
     */
    /* renamed from: e */
    public final void mo8856e() {
        /*
        r10 = this;
        r8 = -1;
        r1 = 1;
        r2 = 0;
        r0 = r10.f5627l;
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = r10.f5625j;
        if (r0 != 0) goto L_0x0019;
    L_0x000d:
        r0 = r10.f5626k;
        if (r0 != 0) goto L_0x0019;
    L_0x0011:
        r0 = new java.lang.IllegalStateException;
        r1 = "call sendRequest() first!";
        r0.<init>(r1);
        throw r0;
    L_0x0019:
        r0 = r10.f5625j;
        if (r0 == 0) goto L_0x0008;
    L_0x001d:
        r0 = r10.f5631p;
        if (r0 == 0) goto L_0x00a0;
    L_0x0021:
        r0 = r10.f5622g;
        r3 = r10.f5625j;
        r0.mo8841a(r3);
    L_0x0028:
        r0 = r10.m5381g();
    L_0x002c:
        r3 = r0.mo8634e();
        r10.mo8851a(r3);
        r3 = r10.f5626k;
        if (r3 == 0) goto L_0x0161;
    L_0x0037:
        r3 = r10.f5626k;
        r4 = r0.mo8630b();
        r5 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r4 != r5) goto L_0x0131;
    L_0x0041:
        if (r1 == 0) goto L_0x0158;
    L_0x0043:
        r1 = r10.f5626k;
        r1 = r1.mo8636g();
        r2 = r10.f5624i;
        r1 = r1.mo8623a(r2);
        r2 = r10.f5621f;
        r2 = okhttp3.internal.http.C1897h.m5378b(r2);
        r1 = r1.mo8627c(r2);
        r2 = r10.f5626k;
        r2 = r2.mo8634e();
        r3 = r0.mo8634e();
        r2 = okhttp3.internal.http.C1897h.m5374a(r2, r3);
        r1 = r1.mo8622a(r2);
        r2 = r10.f5626k;
        r2 = okhttp3.internal.http.C1897h.m5378b(r2);
        r1 = r1.mo8626b(r2);
        r2 = okhttp3.internal.http.C1897h.m5378b(r0);
        r1 = r1.mo8619a(r2);
        r1 = r1.mo8624a();
        r10.f5627l = r1;
        r0 = r0.mo8635f();
        r0.close();
        r0 = r10.f5618b;
        r0.mo8870c();
        r0 = okhttp3.internal.C1825e.f5371a;
        r1 = r10.f5617a;
        r0.mo8708a(r1);
        r0 = r10.f5627l;
        r0 = r10.m5380c(r0);
        r10.f5627l = r0;
        goto L_0x0008;
    L_0x00a0:
        r0 = r10.f5630o;
        if (r0 != 0) goto L_0x00b9;
    L_0x00a4:
        r0 = new okhttp3.internal.http.h$a;
        r3 = r10.f5625j;
        r4 = r10.f5618b;
        r4 = r4.mo8869b();
        r0.<init>(r2, r3, r4);
        r3 = r10.f5625j;
        r0 = r0.mo8848a(r3);
        goto L_0x002c;
    L_0x00b9:
        r0 = r10.f5629n;
        if (r0 == 0) goto L_0x00d2;
    L_0x00bd:
        r0 = r10.f5629n;
        r0 = r0.mo9015c();
        r4 = r0.mo9049b();
        r6 = 0;
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 <= 0) goto L_0x00d2;
    L_0x00cd:
        r0 = r10.f5629n;
        r0.mo9017d();
    L_0x00d2:
        r4 = r10.f5619c;
        r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r0 != 0) goto L_0x010d;
    L_0x00d8:
        r0 = r10.f5625j;
        r4 = okhttp3.internal.http.C1901m.m5400a(r0);
        r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r0 != 0) goto L_0x0106;
    L_0x00e2:
        r0 = r10.f5628m;
        r0 = r0 instanceof okhttp3.internal.http.C1904p;
        if (r0 == 0) goto L_0x0106;
    L_0x00e8:
        r0 = r10.f5628m;
        r0 = (okhttp3.internal.http.C1904p) r0;
        r4 = r0.mo8859b();
        r0 = r10.f5625j;
        r0 = r0.mo8968e();
        r3 = "Content-Length";
        r4 = java.lang.Long.toString(r4);
        r0 = r0.mo8957a(r3, r4);
        r0 = r0.mo8961a();
        r10.f5625j = r0;
    L_0x0106:
        r0 = r10.f5622g;
        r3 = r10.f5625j;
        r0.mo8841a(r3);
    L_0x010d:
        r0 = r10.f5628m;
        if (r0 == 0) goto L_0x0028;
    L_0x0111:
        r0 = r10.f5629n;
        if (r0 == 0) goto L_0x012b;
    L_0x0115:
        r0 = r10.f5629n;
        r0.close();
    L_0x011a:
        r0 = r10.f5628m;
        r0 = r0 instanceof okhttp3.internal.http.C1904p;
        if (r0 == 0) goto L_0x0028;
    L_0x0120:
        r3 = r10.f5622g;
        r0 = r10.f5628m;
        r0 = (okhttp3.internal.http.C1904p) r0;
        r3.mo8840a(r0);
        goto L_0x0028;
    L_0x012b:
        r0 = r10.f5628m;
        r0.close();
        goto L_0x011a;
    L_0x0131:
        r3 = r3.mo8634e();
        r4 = "Last-Modified";
        r3 = r3.mo8918b(r4);
        if (r3 == 0) goto L_0x0155;
    L_0x013d:
        r4 = r0.mo8634e();
        r5 = "Last-Modified";
        r4 = r4.mo8918b(r5);
        if (r4 == 0) goto L_0x0155;
    L_0x0149:
        r4 = r4.getTime();
        r6 = r3.getTime();
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 < 0) goto L_0x0041;
    L_0x0155:
        r1 = r2;
        goto L_0x0041;
    L_0x0158:
        r1 = r10.f5626k;
        r1 = r1.mo8635f();
        okhttp3.internal.C1910m.m5452a(r1);
    L_0x0161:
        r1 = r0.mo8636g();
        r2 = r10.f5624i;
        r1 = r1.mo8623a(r2);
        r2 = r10.f5621f;
        r2 = okhttp3.internal.http.C1897h.m5378b(r2);
        r1 = r1.mo8627c(r2);
        r2 = r10.f5626k;
        r2 = okhttp3.internal.http.C1897h.m5378b(r2);
        r1 = r1.mo8626b(r2);
        r0 = okhttp3.internal.http.C1897h.m5378b(r0);
        r0 = r1.mo8619a(r0);
        r0 = r0.mo8624a();
        r10.f5627l = r0;
        r0 = r10.f5627l;
        r0 = okhttp3.internal.http.C1897h.m5376a(r0);
        if (r0 == 0) goto L_0x0008;
    L_0x0195:
        r0 = okhttp3.internal.C1825e.f5371a;
        r1 = r10.f5617a;
        r0 = r0.mo8708a(r1);
        if (r0 == 0) goto L_0x01d4;
    L_0x019f:
        r1 = r10.f5627l;
        r2 = r10.f5625j;
        r1 = okhttp3.internal.http.C1881b.m5322a(r1, r2);
        if (r1 != 0) goto L_0x01e2;
    L_0x01a9:
        r0 = r10.f5625j;
        r0 = r0.mo8965b();
        r1 = "POST";
        r1 = r0.equals(r1);
        if (r1 != 0) goto L_0x01d4;
    L_0x01b7:
        r1 = "PATCH";
        r1 = r0.equals(r1);
        if (r1 != 0) goto L_0x01d4;
    L_0x01bf:
        r1 = "PUT";
        r1 = r0.equals(r1);
        if (r1 != 0) goto L_0x01d4;
    L_0x01c7:
        r1 = "DELETE";
        r1 = r0.equals(r1);
        if (r1 != 0) goto L_0x01d4;
    L_0x01cf:
        r1 = "MOVE";
        r0.equals(r1);
    L_0x01d4:
        r1 = r10.f5632q;
        r0 = r10.f5627l;
        if (r1 != 0) goto L_0x01e9;
    L_0x01da:
        r0 = r10.m5380c(r0);
        r10.f5627l = r0;
        goto L_0x0008;
    L_0x01e2:
        r0 = r0.mo8715b();
        r10.f5632q = r0;
        goto L_0x01d4;
    L_0x01e9:
        r2 = r1.mo8833a();
        if (r2 == 0) goto L_0x01da;
    L_0x01ef:
        r3 = r0.mo8635f();
        r3 = r3.mo8643c();
        r2 = okio.C1945n.m5707a(r2);
        r4 = new okhttp3.internal.http.j;
        r4.<init>(r10, r3, r1, r2);
        r1 = r0.mo8636g();
        r2 = new okhttp3.internal.http.n;
        r0 = r0.mo8634e();
        r3 = okio.C1945n.m5708a(r4);
        r2.<init>(r0, r3);
        r0 = r1.mo8620a(r2);
        r0 = r0.mo8624a();
        goto L_0x01da;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.h.e():void");
    }

    /* renamed from: f */
    public final C1932y mo8857f() {
        Object obj = 1;
        if (this.f5627l == null) {
            throw new IllegalStateException();
        }
        C1803h b = this.f5618b.mo8869b();
        C1793ad a = b != null ? b.mo8673a() : null;
        int b2 = this.f5627l.mo8630b();
        String b3 = this.f5624i.mo8965b();
        switch (b2) {
            case InitError.INIT_AD_ERROR /*300*/:
            case InitError.INIT_ADMANGER_ERROR /*301*/:
            case InitError.INIT_PLUGIN_ERROR /*302*/:
            case InitError.GET_INTERFACE_ERROR /*303*/:
                break;
            case 307:
            case 308:
                if (!(b3.equals("GET") || b3.equals("HEAD"))) {
                    return null;
                }
            case NetWorkError.QUEUE_FULL_ERROR /*401*/:
                return this.f5617a.mo8946l().mo8652a();
            case NetWorkError.RETRY_TIME_JS_ERROR /*407*/:
                if ((a != null ? a.mo8647b() : this.f5617a.mo8938d()).type() == Type.HTTP) {
                    return this.f5617a.mo8947m().mo8652a();
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            case 408:
                Object obj2 = (this.f5628m == null || (this.f5628m instanceof C1904p)) ? 1 : null;
                return (this.f5630o && obj2 == null) ? null : this.f5624i;
            default:
                return null;
        }
        if (!this.f5617a.mo8950p()) {
            return null;
        }
        String a2 = this.f5627l.mo8628a("Location");
        if (a2 == null) {
            return null;
        }
        HttpUrl c = this.f5624i.mo8964a().mo8583c(a2);
        if (c == null) {
            return null;
        }
        if (!c.mo8582b().equals(this.f5624i.mo8964a().mo8582b()) && !this.f5617a.mo8949o()) {
            return null;
        }
        C1931a e = this.f5624i.mo8968e();
        if (C1900k.m5397b(b3)) {
            if (b3.equals("PROPFIND")) {
                obj = null;
            }
            if (obj != null) {
                e.mo8958a("GET", null);
            } else {
                e.mo8958a(b3, null);
            }
            e.mo8962b("Transfer-Encoding");
            e.mo8962b("Content-Length");
            e.mo8962b("Content-Type");
        }
        if (!mo8852a(c)) {
            e.mo8962b("Authorization");
        }
        return e.mo8959a(c).mo8961a();
    }
}
