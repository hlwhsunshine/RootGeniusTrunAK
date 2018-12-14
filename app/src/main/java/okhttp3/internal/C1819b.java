package okhttp3.internal;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.C1914k;

/* renamed from: okhttp3.internal.b */
public final class C1819b {
    /* renamed from: a */
    private final List<C1914k> f5343a;
    /* renamed from: b */
    private int f5344b = 0;
    /* renamed from: c */
    private boolean f5345c;
    /* renamed from: d */
    private boolean f5346d;

    public C1819b(List<C1914k> list) {
        this.f5343a = list;
    }

    /* renamed from: b */
    private boolean m5019b(SSLSocket sSLSocket) {
        int i = this.f5344b;
        while (true) {
            int i2 = i;
            if (i2 >= this.f5343a.size()) {
                return false;
            }
            if (((C1914k) this.f5343a.get(i2)).mo8890a(sSLSocket)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    public final C1914k mo8696a(SSLSocket sSLSocket) {
        C1914k c1914k;
        int i = this.f5344b;
        int size = this.f5343a.size();
        for (int i2 = i; i2 < size; i2++) {
            c1914k = (C1914k) this.f5343a.get(i2);
            if (c1914k.mo8890a(sSLSocket)) {
                this.f5344b = i2 + 1;
                break;
            }
        }
        c1914k = null;
        if (c1914k == null) {
            throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f5346d + ", modes=" + this.f5343a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
        }
        this.f5345c = m5019b(sSLSocket);
        C1825e.f5371a.mo8710a(c1914k, sSLSocket, this.f5346d);
        return c1914k;
    }

    /* renamed from: a */
    public final boolean mo8697a(IOException iOException) {
        this.f5346d = true;
        return (!this.f5345c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) ? false : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : (iOException instanceof SSLHandshakeException) || (iOException instanceof SSLProtocolException);
    }
}
