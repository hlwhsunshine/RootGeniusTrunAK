package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.C1910m;
import okhttp3.internal.p123b.C1811a;
import okio.ByteString;

/* renamed from: okhttp3.g */
public final class C1802g {
    /* renamed from: a */
    public static final C1802g f5296a = new C1800a().mo8667a();
    /* renamed from: b */
    private final List<C1801b> f5297b;
    /* renamed from: c */
    private final C1811a f5298c;

    /* renamed from: okhttp3.g$a */
    public static final class C1800a {
        /* renamed from: a */
        private final List<C1801b> f5292a = new ArrayList();

        /* renamed from: a */
        public final C1802g mo8667a() {
            return new C1802g(C1910m.m5447a(this.f5292a));
        }
    }

    /* renamed from: okhttp3.g$b */
    static final class C1801b {
        /* renamed from: a */
        final String f5293a;
        /* renamed from: b */
        final String f5294b;
        /* renamed from: c */
        final ByteString f5295c;

        public final boolean equals(Object obj) {
            return (obj instanceof C1801b) && this.f5293a.equals(((C1801b) obj).f5293a) && this.f5294b.equals(((C1801b) obj).f5294b) && this.f5295c.equals(((C1801b) obj).f5295c);
        }

        public final int hashCode() {
            return ((((this.f5293a.hashCode() + 527) * 31) + this.f5294b.hashCode()) * 31) + this.f5295c.hashCode();
        }

        public final String toString() {
            return this.f5294b + this.f5295c.base64();
        }
    }

    /* synthetic */ C1802g(List list) {
        this(list, null);
    }

    private C1802g(List<C1801b> list, C1811a c1811a) {
        this.f5297b = list;
        this.f5298c = c1811a;
    }

    /* renamed from: a */
    public static String m4961a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + C1802g.m4962a((X509Certificate) certificate).base64();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    /* renamed from: a */
    private static ByteString m4962a(X509Certificate x509Certificate) {
        return C1910m.m5463b(ByteString.m5587of(x509Certificate.getPublicKey().getEncoded()));
    }

    /* renamed from: a */
    final C1802g mo8671a(C1811a c1811a) {
        return this.f5298c != c1811a ? new C1802g(this.f5297b, c1811a) : this;
    }

    /* renamed from: a */
    public final void mo8672a(String str, List<Certificate> list) {
        int i = 0;
        List emptyList = Collections.emptyList();
        for (C1801b c1801b : this.f5297b) {
            int i2;
            List arrayList;
            if (c1801b.f5293a.equals(str)) {
                i2 = 1;
            } else {
                i2 = str.indexOf(46);
                if (c1801b.f5293a.startsWith("*.")) {
                    if (str.regionMatches(false, i2 + 1, c1801b.f5293a, 2, c1801b.f5293a.length() - 2)) {
                        i2 = 1;
                    }
                }
                i2 = 0;
            }
            if (i2 != 0) {
                arrayList = emptyList.isEmpty() ? new ArrayList() : emptyList;
                arrayList.add(c1801b);
            } else {
                arrayList = emptyList;
            }
            emptyList = arrayList;
        }
        if (!emptyList.isEmpty()) {
            List list2;
            int i3;
            if (this.f5298c != null) {
                list2 = this.f5298c.mo8692a(list2, str);
            }
            int size = list2.size();
            for (int i4 = 0; i4 < size; i4++) {
                X509Certificate x509Certificate = (X509Certificate) list2.get(i4);
                int size2 = emptyList.size();
                int i5 = 0;
                Object obj = null;
                Object obj2 = null;
                while (i5 < size2) {
                    C1801b c1801b2 = (C1801b) emptyList.get(i5);
                    if (c1801b2.f5294b.equals("sha256/")) {
                        if (obj == null) {
                            obj = C1802g.m4962a(x509Certificate);
                        }
                        if (c1801b2.f5295c.equals(obj)) {
                            return;
                        }
                    } else if (c1801b2.f5294b.equals("sha1/")) {
                        if (obj2 == null) {
                            obj2 = C1910m.m5450a(ByteString.m5587of(x509Certificate.getPublicKey().getEncoded()));
                        }
                        if (c1801b2.f5295c.equals(obj2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError();
                    }
                    i5++;
                    obj2 = obj2;
                    obj = obj;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
            int size3 = list2.size();
            for (i3 = 0; i3 < size3; i3++) {
                Certificate certificate = (X509Certificate) list2.get(i3);
                stringBuilder.append("\n    ").append(C1802g.m4961a(certificate)).append(": ").append(certificate.getSubjectDN().getName());
            }
            stringBuilder.append("\n  Pinned certificates for ").append(str).append(":");
            i3 = emptyList.size();
            while (i < i3) {
                stringBuilder.append("\n    ").append((C1801b) emptyList.get(i));
                i++;
            }
            throw new SSLPeerUnverifiedException(stringBuilder.toString());
        }
    }
}
