package okhttp3;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.C1910m;

/* renamed from: okhttp3.r */
public final class C1921r {
    /* renamed from: a */
    private final TlsVersion f5714a;
    /* renamed from: b */
    private final CipherSuite f5715b;
    /* renamed from: c */
    private final List<Certificate> f5716c;
    /* renamed from: d */
    private final List<Certificate> f5717d;

    private C1921r(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        this.f5714a = tlsVersion;
        this.f5715b = cipherSuite;
        this.f5716c = list;
        this.f5717d = list2;
    }

    /* renamed from: a */
    public static C1921r m5500a(SSLSession sSLSession) {
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        CipherSuite forJavaName = CipherSuite.forJavaName(cipherSuite);
        cipherSuite = sSLSession.getProtocol();
        if (cipherSuite == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        Object[] peerCertificates;
        TlsVersion forJavaName2 = TlsVersion.forJavaName(cipherSuite);
        try {
            peerCertificates = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException e) {
            peerCertificates = null;
        }
        List a = peerCertificates != null ? C1910m.m5448a(peerCertificates) : Collections.emptyList();
        Object[] localCertificates = sSLSession.getLocalCertificates();
        return new C1921r(forJavaName2, forJavaName, a, localCertificates != null ? C1910m.m5448a(localCertificates) : Collections.emptyList());
    }

    /* renamed from: a */
    public final CipherSuite mo8905a() {
        return this.f5715b;
    }

    /* renamed from: b */
    public final List<Certificate> mo8906b() {
        return this.f5716c;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1921r)) {
            return false;
        }
        C1921r c1921r = (C1921r) obj;
        return C1910m.m5456a(this.f5715b, c1921r.f5715b) && this.f5715b.equals(c1921r.f5715b) && this.f5716c.equals(c1921r.f5716c) && this.f5717d.equals(c1921r.f5717d);
    }

    public final int hashCode() {
        return (((((((this.f5714a != null ? this.f5714a.hashCode() : 0) + 527) * 31) + this.f5715b.hashCode()) * 31) + this.f5716c.hashCode()) * 31) + this.f5717d.hashCode();
    }
}
