package okhttp3;

import java.util.Arrays;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.C1910m;

/* renamed from: okhttp3.k */
public final class C1914k {
    /* renamed from: a */
    public static final C1914k f5686a = new C1913a(true).mo8884a(f5689d).mo8885a(TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).mo8882a().mo8887b();
    /* renamed from: b */
    public static final C1914k f5687b = new C1913a(f5686a).mo8885a(TlsVersion.TLS_1_0).mo8882a().mo8887b();
    /* renamed from: c */
    public static final C1914k f5688c = new C1913a(false).mo8887b();
    /* renamed from: d */
    private static final CipherSuite[] f5689d = new CipherSuite[]{CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
    /* renamed from: e */
    private final boolean f5690e;
    /* renamed from: f */
    private final boolean f5691f;
    /* renamed from: g */
    private final String[] f5692g;
    /* renamed from: h */
    private final String[] f5693h;

    /* renamed from: okhttp3.k$a */
    public static final class C1913a {
        /* renamed from: a */
        private boolean f5682a;
        /* renamed from: b */
        private String[] f5683b;
        /* renamed from: c */
        private String[] f5684c;
        /* renamed from: d */
        private boolean f5685d;

        public C1913a(C1914k c1914k) {
            this.f5682a = c1914k.f5690e;
            this.f5683b = c1914k.f5692g;
            this.f5684c = c1914k.f5693h;
            this.f5685d = c1914k.f5691f;
        }

        C1913a(boolean z) {
            this.f5682a = z;
        }

        /* renamed from: a */
        public final C1913a mo8882a() {
            if (this.f5682a) {
                this.f5685d = true;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        /* renamed from: a */
        public final C1913a mo8883a(String... strArr) {
            if (!this.f5682a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            } else {
                this.f5683b = (String[]) strArr.clone();
                return this;
            }
        }

        /* renamed from: a */
        public final C1913a mo8884a(CipherSuite... cipherSuiteArr) {
            if (this.f5682a) {
                String[] strArr = new String[cipherSuiteArr.length];
                for (int i = 0; i < cipherSuiteArr.length; i++) {
                    strArr[i] = cipherSuiteArr[i].javaName;
                }
                return mo8883a(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        /* renamed from: a */
        public final C1913a mo8885a(TlsVersion... tlsVersionArr) {
            if (this.f5682a) {
                String[] strArr = new String[tlsVersionArr.length];
                for (int i = 0; i < tlsVersionArr.length; i++) {
                    strArr[i] = tlsVersionArr[i].javaName;
                }
                return mo8886b(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        /* renamed from: b */
        public final C1913a mo8886b(String... strArr) {
            if (!this.f5682a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            } else {
                this.f5684c = (String[]) strArr.clone();
                return this;
            }
        }

        /* renamed from: b */
        public final C1914k mo8887b() {
            return new C1914k(this, (byte) 0);
        }
    }

    private C1914k(C1913a c1913a) {
        this.f5690e = c1913a.f5682a;
        this.f5692g = c1913a.f5683b;
        this.f5693h = c1913a.f5684c;
        this.f5691f = c1913a.f5685d;
    }

    /* synthetic */ C1914k(C1913a c1913a, byte b) {
        this(c1913a);
    }

    /* renamed from: a */
    private static boolean m5478a(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        for (String a : strArr) {
            if (C1910m.m5459a(strArr2, a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    final void mo8888a(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites = this.f5692g != null ? (String[]) C1910m.m5460a(String.class, this.f5692g, sSLSocket.getEnabledCipherSuites()) : sSLSocket.getEnabledCipherSuites();
        String[] enabledProtocols = this.f5693h != null ? (String[]) C1910m.m5460a(String.class, this.f5693h, sSLSocket.getEnabledProtocols()) : sSLSocket.getEnabledProtocols();
        if (z && C1910m.m5459a(sSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV")) {
            enabledCipherSuites = C1910m.m5464b(enabledCipherSuites, "TLS_FALLBACK_SCSV");
        }
        C1914k b = new C1913a(this).mo8883a(enabledCipherSuites).mo8886b(enabledProtocols).mo8887b();
        if (b.f5693h != null) {
            sSLSocket.setEnabledProtocols(b.f5693h);
        }
        if (b.f5692g != null) {
            sSLSocket.setEnabledCipherSuites(b.f5692g);
        }
    }

    /* renamed from: a */
    public final boolean mo8889a() {
        return this.f5690e;
    }

    /* renamed from: a */
    public final boolean mo8890a(SSLSocket sSLSocket) {
        return !this.f5690e ? false : (this.f5693h == null || C1914k.m5478a(this.f5693h, sSLSocket.getEnabledProtocols())) ? this.f5692g == null || C1914k.m5478a(this.f5692g, sSLSocket.getEnabledCipherSuites()) : false;
    }

    /* renamed from: b */
    public final boolean mo8891b() {
        return this.f5691f;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1914k)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        C1914k c1914k = (C1914k) obj;
        return this.f5690e == c1914k.f5690e ? !this.f5690e || (Arrays.equals(this.f5692g, c1914k.f5692g) && Arrays.equals(this.f5693h, c1914k.f5693h) && this.f5691f == c1914k.f5691f) : false;
    }

    public final int hashCode() {
        if (!this.f5690e) {
            return 17;
        }
        return (this.f5691f ? 0 : 1) + ((((Arrays.hashCode(this.f5692g) + 527) * 31) + Arrays.hashCode(this.f5693h)) * 31);
    }

    public final String toString() {
        Object obj = null;
        int i = 0;
        if (!this.f5690e) {
            return "ConnectionSpec()";
        }
        String obj2;
        String obj3;
        if (this.f5692g != null) {
            Object obj4;
            if (this.f5692g == null) {
                obj4 = null;
            } else {
                Object[] objArr = new CipherSuite[this.f5692g.length];
                for (int i2 = 0; i2 < this.f5692g.length; i2++) {
                    objArr[i2] = CipherSuite.forJavaName(this.f5692g[i2]);
                }
                obj4 = C1910m.m5448a(objArr);
            }
            obj2 = obj4.toString();
        } else {
            obj2 = "[all enabled]";
        }
        if (this.f5693h != null) {
            if (this.f5693h != null) {
                Object[] objArr2 = new TlsVersion[this.f5693h.length];
                while (i < this.f5693h.length) {
                    objArr2[i] = TlsVersion.forJavaName(this.f5693h[i]);
                    i++;
                }
                obj = C1910m.m5448a(objArr2);
            }
            obj3 = obj.toString();
        } else {
            obj3 = "[all enabled]";
        }
        return "ConnectionSpec(cipherSuites=" + obj2 + ", tlsVersions=" + obj3 + ", supportsTlsExtensions=" + this.f5691f + ")";
    }
}
