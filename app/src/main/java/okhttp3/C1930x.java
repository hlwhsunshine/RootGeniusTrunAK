package okhttp3;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.C1924t.C1895a;
import okhttp3.C1932y.C1931a;
import okhttp3.internal.http.C1897h;
import okhttp3.internal.http.C1907s;
import okhttp3.internal.http.RequestException;
import okhttp3.internal.http.RouteException;

/* renamed from: okhttp3.x */
final class C1930x implements C1799f {
    /* renamed from: a */
    volatile boolean f5782a;
    /* renamed from: b */
    C1932y f5783b;
    /* renamed from: c */
    C1897h f5784c;
    /* renamed from: d */
    private final C1927v f5785d;
    /* renamed from: e */
    private boolean f5786e;

    /* renamed from: okhttp3.x$a */
    class C1929a implements C1895a {
        /* renamed from: b */
        private final int f5779b;
        /* renamed from: c */
        private final C1932y f5780c;
        /* renamed from: d */
        private final boolean f5781d;

        C1929a(int i, C1932y c1932y, boolean z) {
            this.f5779b = i;
            this.f5780c = c1932y;
            this.f5781d = z;
        }

        /* renamed from: a */
        public final C1791ab mo8848a(C1932y c1932y) {
            if (this.f5779b >= C1930x.this.f5785d.f5757e.size()) {
                return C1930x.this.mo8955a(c1932y, this.f5781d);
            }
            C1929a c1929a = new C1929a(this.f5779b + 1, c1932y, this.f5781d);
            C1924t c1924t = (C1924t) C1930x.this.f5785d.f5757e.get(this.f5779b);
            C1791ab a = c1924t.mo8923a();
            if (a != null) {
                return a;
            }
            throw new NullPointerException("application interceptor " + c1924t + " returned null");
        }
    }

    protected C1930x(C1927v c1927v, C1932y c1932y) {
        this.f5785d = c1927v;
        this.f5783b = c1932y;
    }

    /* renamed from: a */
    public final C1791ab mo8666a() {
        synchronized (this) {
            if (this.f5786e) {
                throw new IllegalStateException("Already Executed");
            }
            this.f5786e = true;
        }
        try {
            this.f5785d.f5753a.mo8903a(this);
            C1791ab a = new C1929a(0, this.f5783b, false).mo8848a(this.f5783b);
            if (a != null) {
                return a;
            }
            throw new IOException("Canceled");
        } finally {
            this.f5785d.f5753a.mo8902a((C1799f) this);
        }
    }

    /* renamed from: a */
    final C1791ab mo8955a(C1932y c1932y, boolean z) {
        C1932y a;
        C1897h a2;
        Object obj;
        Throwable th;
        C1788z d = c1932y.mo8967d();
        if (d != null) {
            C1931a e = c1932y.mo8968e();
            C1925u a3 = d.mo8611a();
            if (a3 != null) {
                e.mo8957a("Content-Type", a3.toString());
            }
            long b = d.mo8613b();
            if (b != -1) {
                e.mo8957a("Content-Length", Long.toString(b));
                e.mo8962b("Transfer-Encoding");
            } else {
                e.mo8957a("Transfer-Encoding", "chunked");
                e.mo8962b("Content-Length");
            }
            a = e.mo8961a();
        } else {
            a = c1932y;
        }
        this.f5784c = new C1897h(this.f5785d, a, false, false, z, null, null);
        int i = 0;
        while (!this.f5782a) {
            try {
                this.f5784c.mo8850a();
                this.f5784c.mo8856e();
                C1791ab c = this.f5784c.mo8854c();
                a = this.f5784c.mo8857f();
                if (a == null) {
                    if (!z) {
                        this.f5784c.f5618b.mo8870c();
                    }
                    return c;
                }
                C1907s d2 = this.f5784c.mo8855d();
                int i2 = i + 1;
                if (i2 > 20) {
                    d2.mo8870c();
                    throw new ProtocolException("Too many follow-up requests: " + i2);
                }
                if (!this.f5784c.mo8852a(a.mo8964a())) {
                    d2.mo8870c();
                    d2 = null;
                } else if (d2.mo8864a() != null) {
                    throw new IllegalStateException("Closing the body of " + c + " didn't close its backing stream. Bad interceptor?");
                }
                this.f5784c = new C1897h(this.f5785d, a, false, false, z, d2, c);
                i = i2;
            } catch (RequestException e2) {
                throw e2.getCause();
            } catch (RouteException e3) {
                a2 = this.f5784c.mo8849a(e3.getLastConnectException(), true);
                if (a2 != null) {
                    obj = null;
                    this.f5784c = a2;
                } else {
                    throw e3.getLastConnectException();
                }
            } catch (IOException e4) {
                a2 = this.f5784c.mo8849a(e4, false);
                if (a2 != null) {
                    obj = null;
                    this.f5784c = a2;
                } else {
                    throw e4;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        this.f5784c.f5618b.mo8870c();
        throw new IOException("Canceled");
        if (obj != null) {
            this.f5784c.mo8855d().mo8870c();
        }
        throw th;
    }
}
