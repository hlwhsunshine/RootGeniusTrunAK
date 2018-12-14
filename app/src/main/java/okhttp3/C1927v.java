package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.C1809k;
import okhttp3.internal.C1825e;
import okhttp3.internal.C1826f;
import okhttp3.internal.C1910m;
import okhttp3.internal.p123b.C1811a;
import okhttp3.internal.p123b.C1815c;

/* renamed from: okhttp3.v */
public class C1927v implements Cloneable {
    /* renamed from: A */
    private static final List<C1914k> f5751A;
    /* renamed from: z */
    private static final List<Protocol> f5752z = C1910m.m5448a(Protocol.HTTP_2, Protocol.SPDY_3, Protocol.HTTP_1_1);
    /* renamed from: a */
    final C1918o f5753a;
    /* renamed from: b */
    final Proxy f5754b;
    /* renamed from: c */
    final List<Protocol> f5755c;
    /* renamed from: d */
    final List<C1914k> f5756d;
    /* renamed from: e */
    final List<C1924t> f5757e;
    /* renamed from: f */
    final List<C1924t> f5758f;
    /* renamed from: g */
    final ProxySelector f5759g;
    /* renamed from: h */
    final C1916m f5760h;
    /* renamed from: i */
    final C1796d f5761i;
    /* renamed from: j */
    final C1826f f5762j;
    /* renamed from: k */
    final SocketFactory f5763k;
    /* renamed from: l */
    final SSLSocketFactory f5764l;
    /* renamed from: m */
    final C1811a f5765m;
    /* renamed from: n */
    final HostnameVerifier f5766n;
    /* renamed from: o */
    final C1802g f5767o;
    /* renamed from: p */
    final C1794b f5768p;
    /* renamed from: q */
    final C1794b f5769q;
    /* renamed from: r */
    final C1804i f5770r;
    /* renamed from: s */
    final C1919p f5771s;
    /* renamed from: t */
    final boolean f5772t;
    /* renamed from: u */
    final boolean f5773u;
    /* renamed from: v */
    final boolean f5774v;
    /* renamed from: w */
    final int f5775w;
    /* renamed from: x */
    final int f5776x;
    /* renamed from: y */
    final int f5777y;

    /* renamed from: okhttp3.v$a */
    public static final class C1926a {
        /* renamed from: a */
        C1918o f5726a = new C1918o();
        /* renamed from: b */
        Proxy f5727b;
        /* renamed from: c */
        List<Protocol> f5728c = C1927v.f5752z;
        /* renamed from: d */
        List<C1914k> f5729d = C1927v.f5751A;
        /* renamed from: e */
        final List<C1924t> f5730e = new ArrayList();
        /* renamed from: f */
        final List<C1924t> f5731f = new ArrayList();
        /* renamed from: g */
        ProxySelector f5732g = ProxySelector.getDefault();
        /* renamed from: h */
        C1916m f5733h = C1916m.f5707a;
        /* renamed from: i */
        C1796d f5734i;
        /* renamed from: j */
        C1826f f5735j;
        /* renamed from: k */
        SocketFactory f5736k = SocketFactory.getDefault();
        /* renamed from: l */
        SSLSocketFactory f5737l;
        /* renamed from: m */
        C1811a f5738m;
        /* renamed from: n */
        HostnameVerifier f5739n = C1815c.f5339a;
        /* renamed from: o */
        C1802g f5740o = C1802g.f5296a;
        /* renamed from: p */
        C1794b f5741p = C1794b.f5268a;
        /* renamed from: q */
        C1794b f5742q = C1794b.f5268a;
        /* renamed from: r */
        C1804i f5743r = new C1804i();
        /* renamed from: s */
        C1919p f5744s = C1919p.f5713a;
        /* renamed from: t */
        boolean f5745t = true;
        /* renamed from: u */
        boolean f5746u = true;
        /* renamed from: v */
        boolean f5747v = true;
        /* renamed from: w */
        int f5748w = 10000;
        /* renamed from: x */
        int f5749x = 10000;
        /* renamed from: y */
        int f5750y = 10000;

        /* renamed from: a */
        public final C1926a mo8929a(TimeUnit timeUnit) {
            if (0 < 0) {
                throw new IllegalArgumentException("timeout < 0");
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else {
                long toMillis = timeUnit.toMillis(0);
                if (toMillis > 2147483647L) {
                    throw new IllegalArgumentException("Timeout too large.");
                } else if (toMillis != 0 || 0 <= 0) {
                    this.f5748w = (int) toMillis;
                    return this;
                } else {
                    throw new IllegalArgumentException("Timeout too small.");
                }
            }
        }

        /* renamed from: a */
        public final C1926a mo8930a(HostnameVerifier hostnameVerifier) {
            this.f5739n = hostnameVerifier;
            return this;
        }

        /* renamed from: a */
        public final C1926a mo8931a(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            X509TrustManager a = C1809k.m4984c().mo8686a(sSLSocketFactory);
            if (a == null) {
                throw new IllegalStateException("Unable to extract the trust manager on " + C1809k.m4984c() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
            }
            this.f5737l = sSLSocketFactory;
            this.f5738m = C1811a.m5000a(a);
            return this;
        }

        /* renamed from: a */
        public final C1927v mo8932a() {
            return new C1927v(this, (byte) 0);
        }

        /* renamed from: b */
        public final C1926a mo8933b(TimeUnit timeUnit) {
            if (0 < 0) {
                throw new IllegalArgumentException("timeout < 0");
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else {
                long toMillis = timeUnit.toMillis(0);
                if (toMillis > 2147483647L) {
                    throw new IllegalArgumentException("Timeout too large.");
                } else if (toMillis != 0 || 0 <= 0) {
                    this.f5749x = (int) toMillis;
                    return this;
                } else {
                    throw new IllegalArgumentException("Timeout too small.");
                }
            }
        }
    }

    static {
        List arrayList = new ArrayList(Arrays.asList(new C1914k[]{C1914k.f5686a, C1914k.f5687b}));
        if (C1809k.m4984c().mo8690a()) {
            arrayList.add(C1914k.f5688c);
        }
        f5751A = C1910m.m5447a(arrayList);
        C1825e.f5371a = new C1928w();
    }

    public C1927v() {
        this(new C1926a());
    }

    private C1927v(C1926a c1926a) {
        this.f5753a = c1926a.f5726a;
        this.f5754b = c1926a.f5727b;
        this.f5755c = c1926a.f5728c;
        this.f5756d = c1926a.f5729d;
        this.f5757e = C1910m.m5447a(c1926a.f5730e);
        this.f5758f = C1910m.m5447a(c1926a.f5731f);
        this.f5759g = c1926a.f5732g;
        this.f5760h = c1926a.f5733h;
        this.f5761i = c1926a.f5734i;
        this.f5762j = c1926a.f5735j;
        this.f5763k = c1926a.f5736k;
        Object obj = null;
        for (C1914k a : this.f5756d) {
            Object obj2 = (obj != null || a.mo8889a()) ? 1 : null;
            obj = obj2;
        }
        if (c1926a.f5737l != null || obj == null) {
            this.f5764l = c1926a.f5737l;
            this.f5765m = c1926a.f5738m;
        } else {
            X509TrustManager w = C1927v.m5529w();
            this.f5764l = C1927v.m5526a(w);
            this.f5765m = C1811a.m5000a(w);
        }
        this.f5766n = c1926a.f5739n;
        this.f5767o = c1926a.f5740o.mo8671a(this.f5765m);
        this.f5768p = c1926a.f5741p;
        this.f5769q = c1926a.f5742q;
        this.f5770r = c1926a.f5743r;
        this.f5771s = c1926a.f5744s;
        this.f5772t = c1926a.f5745t;
        this.f5773u = c1926a.f5746u;
        this.f5774v = c1926a.f5747v;
        this.f5775w = c1926a.f5748w;
        this.f5776x = c1926a.f5749x;
        this.f5777y = c1926a.f5750y;
    }

    /* synthetic */ C1927v(C1926a c1926a, byte b) {
        this(c1926a);
    }

    /* renamed from: a */
    private static SSLSocketFactory m5526a(X509TrustManager x509TrustManager) {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, new TrustManager[]{x509TrustManager}, null);
            return instance.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw new AssertionError();
        }
    }

    /* renamed from: w */
    private static X509TrustManager m5529w() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init(null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    public final int mo8934a() {
        return this.f5775w;
    }

    /* renamed from: a */
    public final C1799f mo8935a(C1932y c1932y) {
        return new C1930x(this, c1932y);
    }

    /* renamed from: b */
    public final int mo8936b() {
        return this.f5776x;
    }

    /* renamed from: c */
    public final int mo8937c() {
        return this.f5777y;
    }

    /* renamed from: d */
    public final Proxy mo8938d() {
        return this.f5754b;
    }

    /* renamed from: e */
    public final ProxySelector mo8939e() {
        return this.f5759g;
    }

    /* renamed from: f */
    public final C1916m mo8940f() {
        return this.f5760h;
    }

    /* renamed from: g */
    public final C1919p mo8941g() {
        return this.f5771s;
    }

    /* renamed from: h */
    public final SocketFactory mo8942h() {
        return this.f5763k;
    }

    /* renamed from: i */
    public final SSLSocketFactory mo8943i() {
        return this.f5764l;
    }

    /* renamed from: j */
    public final HostnameVerifier mo8944j() {
        return this.f5766n;
    }

    /* renamed from: k */
    public final C1802g mo8945k() {
        return this.f5767o;
    }

    /* renamed from: l */
    public final C1794b mo8946l() {
        return this.f5769q;
    }

    /* renamed from: m */
    public final C1794b mo8947m() {
        return this.f5768p;
    }

    /* renamed from: n */
    public final C1804i mo8948n() {
        return this.f5770r;
    }

    /* renamed from: o */
    public final boolean mo8949o() {
        return this.f5772t;
    }

    /* renamed from: p */
    public final boolean mo8950p() {
        return this.f5773u;
    }

    /* renamed from: q */
    public final boolean mo8951q() {
        return this.f5774v;
    }

    /* renamed from: r */
    public final List<Protocol> mo8952r() {
        return this.f5755c;
    }

    /* renamed from: s */
    public final List<C1914k> mo8953s() {
        return this.f5756d;
    }

    /* renamed from: t */
    public final List<C1924t> mo8954t() {
        return this.f5758f;
    }
}
