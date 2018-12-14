package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy.Type;
import java.util.concurrent.TimeUnit;
import okhttp3.C1791ab;
import okhttp3.C1791ab.C1790a;
import okhttp3.C1792ac;
import okhttp3.C1923s;
import okhttp3.C1923s.C1922a;
import okhttp3.C1932y;
import okhttp3.internal.C1825e;
import okhttp3.internal.C1910m;
import okio.C1823w;
import okio.C1850x;
import okio.C1852y;
import okio.C1937g;
import okio.C1938h;
import okio.C1939e;
import okio.C1942k;
import okio.C1945n;

/* renamed from: okhttp3.internal.http.d */
public final class C1890d implements C1889l {
    /* renamed from: a */
    private final C1907s f5586a;
    /* renamed from: b */
    private final C1938h f5587b;
    /* renamed from: c */
    private final C1937g f5588c;
    /* renamed from: d */
    private C1897h f5589d;
    /* renamed from: e */
    private int f5590e = 0;

    /* renamed from: okhttp3.internal.http.d$a */
    private abstract class C1883a implements C1850x {
        /* renamed from: a */
        protected final C1942k f5568a;
        /* renamed from: b */
        protected boolean f5569b;

        private C1883a() {
            this.f5568a = new C1942k(C1890d.this.f5587b.mo8764a());
        }

        /* synthetic */ C1883a(C1890d c1890d, byte b) {
            this();
        }

        /* renamed from: a */
        public final C1852y mo8764a() {
            return this.f5568a;
        }

        /* renamed from: a */
        protected final void mo8835a(boolean z) {
            if (C1890d.this.f5590e != 6) {
                if (C1890d.this.f5590e != 5) {
                    throw new IllegalStateException("state: " + C1890d.this.f5590e);
                }
                C1890d.m5343a(this.f5568a);
                C1890d.this.f5590e = 6;
                if (C1890d.this.f5586a != null) {
                    C1890d.this.f5586a.mo8868a(!z, C1890d.this);
                }
            }
        }
    }

    /* renamed from: okhttp3.internal.http.d$b */
    private final class C1884b implements C1823w {
        /* renamed from: b */
        private final C1942k f5572b;
        /* renamed from: c */
        private boolean f5573c;

        private C1884b() {
            this.f5572b = new C1942k(C1890d.this.f5588c.mo8703a());
        }

        /* synthetic */ C1884b(C1890d c1890d, byte b) {
            this();
        }

        /* renamed from: a */
        public final C1852y mo8703a() {
            return this.f5572b;
        }

        /* renamed from: a_ */
        public final void mo8704a_(C1939e c1939e, long j) {
            if (this.f5573c) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                C1890d.this.f5588c.mo9021i(j);
                C1890d.this.f5588c.mo9012b("\r\n");
                C1890d.this.f5588c.mo8704a_(c1939e, j);
                C1890d.this.f5588c.mo9012b("\r\n");
            }
        }

        public final synchronized void close() {
            if (!this.f5573c) {
                this.f5573c = true;
                C1890d.this.f5588c.mo9012b("0\r\n\r\n");
                C1890d.m5343a(this.f5572b);
                C1890d.this.f5590e = 3;
            }
        }

        public final synchronized void flush() {
            if (!this.f5573c) {
                C1890d.this.f5588c.flush();
            }
        }
    }

    /* renamed from: okhttp3.internal.http.d$c */
    private class C1885c extends C1883a {
        /* renamed from: e */
        private long f5575e = -1;
        /* renamed from: f */
        private boolean f5576f = true;
        /* renamed from: g */
        private final C1897h f5577g;

        C1885c(C1897h c1897h) {
            super(C1890d.this, (byte) 0);
            this.f5577g = c1897h;
        }

        /* renamed from: a */
        public final long mo8763a(C1939e c1939e, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f5569b) {
                throw new IllegalStateException("closed");
            } else if (!this.f5576f) {
                return -1;
            } else {
                if (this.f5575e == 0 || this.f5575e == -1) {
                    if (this.f5575e != -1) {
                        C1890d.this.f5587b.mo9038o();
                    }
                    try {
                        this.f5575e = C1890d.this.f5587b.mo9037l();
                        String trim = C1890d.this.f5587b.mo9038o().trim();
                        if (this.f5575e < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                            throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f5575e + trim + "\"");
                        }
                        if (this.f5575e == 0) {
                            this.f5576f = false;
                            this.f5577g.mo8851a(C1890d.this.mo8846d());
                            mo8835a(true);
                        }
                        if (!this.f5576f) {
                            return -1;
                        }
                    } catch (NumberFormatException e) {
                        throw new ProtocolException(e.getMessage());
                    }
                }
                long a = C1890d.this.f5587b.mo8763a(c1939e, Math.min(j, this.f5575e));
                if (a == -1) {
                    mo8835a(false);
                    throw new ProtocolException("unexpected end of stream");
                }
                this.f5575e -= a;
                return a;
            }
        }

        public final void close() {
            if (!this.f5569b) {
                if (this.f5576f && !C1910m.m5458a((C1850x) this, TimeUnit.MILLISECONDS)) {
                    mo8835a(false);
                }
                this.f5569b = true;
            }
        }
    }

    /* renamed from: okhttp3.internal.http.d$d */
    private final class C1886d implements C1823w {
        /* renamed from: b */
        private final C1942k f5579b;
        /* renamed from: c */
        private boolean f5580c;
        /* renamed from: d */
        private long f5581d;

        private C1886d(long j) {
            this.f5579b = new C1942k(C1890d.this.f5588c.mo8703a());
            this.f5581d = j;
        }

        /* synthetic */ C1886d(C1890d c1890d, long j, byte b) {
            this(j);
        }

        /* renamed from: a */
        public final C1852y mo8703a() {
            return this.f5579b;
        }

        /* renamed from: a_ */
        public final void mo8704a_(C1939e c1939e, long j) {
            if (this.f5580c) {
                throw new IllegalStateException("closed");
            }
            C1910m.m5451a(c1939e.mo9049b(), j);
            if (j > this.f5581d) {
                throw new ProtocolException("expected " + this.f5581d + " bytes but received " + j);
            }
            C1890d.this.f5588c.mo8704a_(c1939e, j);
            this.f5581d -= j;
        }

        public final void close() {
            if (!this.f5580c) {
                this.f5580c = true;
                if (this.f5581d > 0) {
                    throw new ProtocolException("unexpected end of stream");
                }
                C1890d.m5343a(this.f5579b);
                C1890d.this.f5590e = 3;
            }
        }

        public final void flush() {
            if (!this.f5580c) {
                C1890d.this.f5588c.flush();
            }
        }
    }

    /* renamed from: okhttp3.internal.http.d$e */
    private class C1887e extends C1883a {
        /* renamed from: e */
        private long f5583e;

        public C1887e(long j) {
            super(C1890d.this, (byte) 0);
            this.f5583e = j;
            if (this.f5583e == 0) {
                mo8835a(true);
            }
        }

        /* renamed from: a */
        public final long mo8763a(C1939e c1939e, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f5569b) {
                throw new IllegalStateException("closed");
            } else if (this.f5583e == 0) {
                return -1;
            } else {
                long a = C1890d.this.f5587b.mo8763a(c1939e, Math.min(this.f5583e, j));
                if (a == -1) {
                    mo8835a(false);
                    throw new ProtocolException("unexpected end of stream");
                }
                this.f5583e -= a;
                if (this.f5583e == 0) {
                    mo8835a(true);
                }
                return a;
            }
        }

        public final void close() {
            if (!this.f5569b) {
                if (!(this.f5583e == 0 || C1910m.m5458a((C1850x) this, TimeUnit.MILLISECONDS))) {
                    mo8835a(false);
                }
                this.f5569b = true;
            }
        }
    }

    /* renamed from: okhttp3.internal.http.d$f */
    private class C1888f extends C1883a {
        /* renamed from: e */
        private boolean f5585e;

        private C1888f() {
            super(C1890d.this, (byte) 0);
        }

        /* synthetic */ C1888f(C1890d c1890d, byte b) {
            this();
        }

        /* renamed from: a */
        public final long mo8763a(C1939e c1939e, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (this.f5569b) {
                throw new IllegalStateException("closed");
            } else if (this.f5585e) {
                return -1;
            } else {
                long a = C1890d.this.f5587b.mo8763a(c1939e, j);
                if (a != -1) {
                    return a;
                }
                this.f5585e = true;
                mo8835a(true);
                return -1;
            }
        }

        public final void close() {
            if (!this.f5569b) {
                if (!this.f5585e) {
                    mo8835a(false);
                }
                this.f5569b = true;
            }
        }
    }

    public C1890d(C1907s c1907s, C1938h c1938h, C1937g c1937g) {
        this.f5586a = c1907s;
        this.f5587b = c1938h;
        this.f5588c = c1937g;
    }

    /* renamed from: a */
    public final C1790a mo8836a() {
        return mo8845c();
    }

    /* renamed from: a */
    public final C1792ac mo8837a(C1791ab c1791ab) {
        C1850x a;
        if (!C1897h.m5376a(c1791ab)) {
            a = mo8843a(0);
        } else if ("chunked".equalsIgnoreCase(c1791ab.mo8628a("Transfer-Encoding"))) {
            C1897h c1897h = this.f5589d;
            if (this.f5590e != 4) {
                throw new IllegalStateException("state: " + this.f5590e);
            }
            this.f5590e = 5;
            a = new C1885c(c1897h);
        } else {
            long a2 = C1901m.m5398a(c1791ab);
            if (a2 != -1) {
                a = mo8843a(a2);
            } else if (this.f5590e != 4) {
                throw new IllegalStateException("state: " + this.f5590e);
            } else if (this.f5586a == null) {
                throw new IllegalStateException("streamAllocation == null");
            } else {
                this.f5590e = 5;
                this.f5586a.mo8871d();
                a = new C1888f(this, (byte) 0);
            }
        }
        return new C1902n(c1791ab.mo8634e(), C1945n.m5708a(a));
    }

    /* renamed from: a */
    public final C1823w mo8838a(C1932y c1932y, long j) {
        if ("chunked".equalsIgnoreCase(c1932y.mo8963a("Transfer-Encoding"))) {
            if (this.f5590e != 1) {
                throw new IllegalStateException("state: " + this.f5590e);
            }
            this.f5590e = 2;
            return new C1884b(this, (byte) 0);
        } else if (j == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        } else if (this.f5590e != 1) {
            throw new IllegalStateException("state: " + this.f5590e);
        } else {
            this.f5590e = 2;
            return new C1886d(this, j, (byte) 0);
        }
    }

    /* renamed from: a */
    public final C1850x mo8843a(long j) {
        if (this.f5590e != 4) {
            throw new IllegalStateException("state: " + this.f5590e);
        }
        this.f5590e = 5;
        return new C1887e(j);
    }

    /* renamed from: a */
    public final void mo8839a(C1897h c1897h) {
        this.f5589d = c1897h;
    }

    /* renamed from: a */
    public final void mo8840a(C1904p c1904p) {
        if (this.f5590e != 1) {
            throw new IllegalStateException("state: " + this.f5590e);
        }
        this.f5590e = 3;
        c1904p.mo8858a(this.f5588c);
    }

    /* renamed from: a */
    public final void mo8844a(C1923s c1923s, String str) {
        if (this.f5590e != 0) {
            throw new IllegalStateException("state: " + this.f5590e);
        }
        this.f5588c.mo9012b(str).mo9012b("\r\n");
        int a = c1923s.mo8914a();
        for (int i = 0; i < a; i++) {
            this.f5588c.mo9012b(c1923s.mo8915a(i)).mo9012b(": ").mo9012b(c1923s.mo8917b(i)).mo9012b("\r\n");
        }
        this.f5588c.mo9012b("\r\n");
        this.f5590e = 1;
    }

    /* renamed from: a */
    public final void mo8841a(C1932y c1932y) {
        this.f5589d.mo8853b();
        Type type = this.f5589d.f5618b.mo8869b().mo8673a().mo8647b().type();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c1932y.mo8965b());
        stringBuilder.append(' ');
        Object obj = (c1932y.mo8970g() || type != Type.HTTP) ? null : 1;
        if (obj != null) {
            stringBuilder.append(c1932y.mo8964a());
        } else {
            stringBuilder.append(C1903o.m5406a(c1932y.mo8964a()));
        }
        stringBuilder.append(" HTTP/1.1");
        mo8844a(c1932y.mo8966c(), stringBuilder.toString());
    }

    /* renamed from: b */
    public final void mo8842b() {
        this.f5588c.flush();
    }

    /* renamed from: c */
    public final C1790a mo8845c() {
        if (this.f5590e == 1 || this.f5590e == 3) {
            C1790a a;
            C1906r a2;
            do {
                try {
                    a2 = C1906r.m5418a(this.f5587b.mo9038o());
                    a = new C1790a().mo8618a(a2.f5658a).mo8614a(a2.f5659b).mo8616a(a2.f5660c).mo8622a(mo8846d());
                } catch (Throwable e) {
                    IOException iOException = new IOException("unexpected end of stream on " + this.f5586a);
                    iOException.initCause(e);
                    throw iOException;
                }
            } while (a2.f5659b == 100);
            this.f5590e = 4;
            return a;
        }
        throw new IllegalStateException("state: " + this.f5590e);
    }

    /* renamed from: d */
    public final C1923s mo8846d() {
        C1922a c1922a = new C1922a();
        while (true) {
            String o = this.f5587b.mo9038o();
            if (o.length() == 0) {
                return c1922a.mo8911a();
            }
            C1825e.f5371a.mo8711a(c1922a, o);
        }
    }
}
