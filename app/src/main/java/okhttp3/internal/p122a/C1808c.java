package okhttp3.internal.p122a;

import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import okhttp3.C1787a;
import okhttp3.C1793ad;
import okhttp3.C1802g;
import okhttp3.C1803h;
import okhttp3.C1914k;
import okhttp3.C1921r;
import okhttp3.Protocol;
import okhttp3.internal.C1809k;
import okhttp3.internal.C1819b;
import okhttp3.internal.C1910m;
import okhttp3.internal.framed.C1837c;
import okhttp3.internal.framed.C1837c.C1807b;
import okhttp3.internal.framed.C1837c.C1834a;
import okhttp3.internal.framed.C1856o;
import okhttp3.internal.framed.ErrorCode;
import okhttp3.internal.http.C1907s;
import okhttp3.internal.p123b.C1815c;
import okio.C1937g;
import okio.C1938h;
import okio.C1945n;

/* renamed from: okhttp3.internal.a.c */
public final class C1808c extends C1807b implements C1803h {
    /* renamed from: b */
    public Socket f5309b;
    /* renamed from: c */
    public volatile C1837c f5310c;
    /* renamed from: d */
    public int f5311d;
    /* renamed from: e */
    public C1938h f5312e;
    /* renamed from: f */
    public C1937g f5313f;
    /* renamed from: g */
    public int f5314g;
    /* renamed from: h */
    public final List<Reference<C1907s>> f5315h = new ArrayList();
    /* renamed from: i */
    public boolean f5316i;
    /* renamed from: j */
    public long f5317j = Long.MAX_VALUE;
    /* renamed from: k */
    private final C1793ad f5318k;
    /* renamed from: l */
    private Socket f5319l;
    /* renamed from: m */
    private C1921r f5320m;
    /* renamed from: n */
    private Protocol f5321n;

    public C1808c(C1793ad c1793ad) {
        this.f5318k = c1793ad;
    }

    /* renamed from: a */
    private void m4974a(int i, int i2) {
        Proxy b = this.f5318k.mo8647b();
        Socket createSocket = (b.type() == Type.DIRECT || b.type() == Type.HTTP) ? this.f5318k.mo8646a().mo8600c().createSocket() : new Socket(b);
        this.f5319l = createSocket;
        this.f5319l.setSoTimeout(i2);
        try {
            C1809k.m4984c().mo8688a(this.f5319l, this.f5318k.mo8648c(), i);
            this.f5312e = C1945n.m5708a(C1945n.m5711b(this.f5319l));
            this.f5313f = C1945n.m5707a(C1945n.m5709a(this.f5319l));
        } catch (ConnectException e) {
            throw new ConnectException("Failed to connect to " + this.f5318k.mo8648c());
        }
    }

    /* renamed from: a */
    private void m4975a(C1819b c1819b) {
        Throwable th;
        Socket socket;
        AssertionError e;
        Throwable th2;
        String str = null;
        if (this.f5318k.mo8646a().mo8608i() != null) {
            C1787a a = this.f5318k.mo8646a();
            try {
                Socket socket2 = (SSLSocket) a.mo8608i().createSocket(this.f5319l, a.mo8598a().mo8588f(), a.mo8598a().mo8589g(), true);
                try {
                    C1914k a2 = c1819b.mo8696a((SSLSocket) socket2);
                    if (a2.mo8891b()) {
                        C1809k.m4984c().mo8689a((SSLSocket) socket2, a.mo8598a().mo8588f(), a.mo8602e());
                    }
                    socket2.startHandshake();
                    C1921r a3 = C1921r.m5500a(socket2.getSession());
                    if (a.mo8609j().verify(a.mo8598a().mo8588f(), socket2.getSession())) {
                        a.mo8610k().mo8672a(a.mo8598a().mo8588f(), a3.mo8906b());
                        if (a2.mo8891b()) {
                            str = C1809k.m4984c().mo8685a((SSLSocket) socket2);
                        }
                        this.f5309b = socket2;
                        this.f5312e = C1945n.m5708a(C1945n.m5711b(this.f5309b));
                        this.f5313f = C1945n.m5707a(C1945n.m5709a(this.f5309b));
                        this.f5320m = a3;
                        this.f5321n = str != null ? Protocol.get(str) : Protocol.HTTP_1_1;
                        if (socket2 != null) {
                            C1809k.m4984c().mo8691b(socket2);
                        }
                    } else {
                        Certificate certificate = (X509Certificate) a3.mo8906b().get(0);
                        throw new SSLPeerUnverifiedException("Hostname " + a.mo8598a().mo8588f() + " not verified:\n    certificate: " + C1802g.m4961a(certificate) + "\n    DN: " + certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + C1815c.m5012a(certificate));
                    }
                } catch (Throwable e2) {
                    th = e2;
                    socket = socket2;
                    e = th;
                } catch (Throwable e22) {
                    th = e22;
                    socket = socket2;
                    th2 = th;
                    if (socket != null) {
                        C1809k.m4984c().mo8691b(socket);
                    }
                    C1910m.m5454a(socket);
                    throw th2;
                }
            } catch (AssertionError e3) {
                e = e3;
                try {
                    if (C1910m.m5455a(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                } catch (Throwable th3) {
                    th2 = th3;
                }
            }
        } else {
            this.f5321n = Protocol.HTTP_1_1;
            this.f5309b = this.f5319l;
        }
        if (this.f5321n == Protocol.SPDY_3 || this.f5321n == Protocol.HTTP_2) {
            this.f5309b.setSoTimeout(0);
            C1837c a4 = new C1834a().mo8745a(this.f5309b, this.f5318k.mo8646a().mo8598a().mo8588f(), this.f5312e, this.f5313f).mo8746a(this.f5321n).mo8747a((C1807b) this).mo8748a();
            a4.mo8762d();
            this.f5314g = a4.mo8757b();
            this.f5310c = a4;
            return;
        }
        this.f5314g = 1;
    }

    /* renamed from: a */
    public final C1793ad mo8673a() {
        return this.f5318k;
    }

    /* renamed from: a */
    public final void mo8681a(int r11, int r12, int r13, java.util.List<okhttp3.C1914k> r14, boolean r15) {
        /*
        r10 = this;
        r1 = 0;
        r0 = r10.f5321n;
        if (r0 == 0) goto L_0x000d;
    L_0x0005:
        r0 = new java.lang.IllegalStateException;
        r1 = "already connected";
        r0.<init>(r1);
        throw r0;
    L_0x000d:
        r4 = new okhttp3.internal.b;
        r4.<init>(r14);
        r0 = r10.f5318k;
        r0 = r0.mo8646a();
        r0 = r0.mo8608i();
        if (r0 != 0) goto L_0x0188;
    L_0x001e:
        r0 = okhttp3.C1914k.f5688c;
        r0 = r14.contains(r0);
        if (r0 != 0) goto L_0x0188;
    L_0x0026:
        r0 = new okhttp3.internal.http.RouteException;
        r1 = new java.net.UnknownServiceException;
        r2 = new java.lang.StringBuilder;
        r3 = "CLEARTEXT communication not supported: ";
        r2.<init>(r3);
        r2 = r2.append(r14);
        r2 = r2.toString();
        r1.<init>(r2);
        r0.<init>(r1);
        throw r0;
    L_0x0040:
        r10.m4975a(r4);	 Catch:{ IOException -> 0x011f }
    L_0x0043:
        r2 = r10.f5321n;
        if (r2 != 0) goto L_0x0187;
    L_0x0047:
        r2 = r10.f5318k;	 Catch:{ IOException -> 0x011f }
        r2 = r2.mo8649d();	 Catch:{ IOException -> 0x011f }
        if (r2 == 0) goto L_0x017b;
    L_0x004f:
        r2 = new okhttp3.y$a;	 Catch:{ IOException -> 0x011f }
        r2.<init>();	 Catch:{ IOException -> 0x011f }
        r3 = r10.f5318k;	 Catch:{ IOException -> 0x011f }
        r3 = r3.mo8646a();	 Catch:{ IOException -> 0x011f }
        r3 = r3.mo8598a();	 Catch:{ IOException -> 0x011f }
        r2 = r2.mo8959a(r3);	 Catch:{ IOException -> 0x011f }
        r3 = "Host";
        r5 = r10.f5318k;	 Catch:{ IOException -> 0x011f }
        r5 = r5.mo8646a();	 Catch:{ IOException -> 0x011f }
        r5 = r5.mo8598a();	 Catch:{ IOException -> 0x011f }
        r6 = 1;
        r5 = okhttp3.internal.C1910m.m5446a(r5, r6);	 Catch:{ IOException -> 0x011f }
        r2 = r2.mo8957a(r3, r5);	 Catch:{ IOException -> 0x011f }
        r3 = "Proxy-Connection";
        r5 = "Keep-Alive";
        r2 = r2.mo8957a(r3, r5);	 Catch:{ IOException -> 0x011f }
        r3 = "User-Agent";
        r5 = "okhttp/3.3.0";
        r2 = r2.mo8957a(r3, r5);	 Catch:{ IOException -> 0x011f }
        r2 = r2.mo8961a();	 Catch:{ IOException -> 0x011f }
        r3 = r2.mo8964a();	 Catch:{ IOException -> 0x011f }
        r10.m4974a(r11, r12);	 Catch:{ IOException -> 0x011f }
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x011f }
        r6 = "CONNECT ";
        r5.<init>(r6);	 Catch:{ IOException -> 0x011f }
        r6 = 1;
        r3 = okhttp3.internal.C1910m.m5446a(r3, r6);	 Catch:{ IOException -> 0x011f }
        r3 = r5.append(r3);	 Catch:{ IOException -> 0x011f }
        r5 = " HTTP/1.1";
        r3 = r3.append(r5);	 Catch:{ IOException -> 0x011f }
        r3 = r3.toString();	 Catch:{ IOException -> 0x011f }
        r5 = new okhttp3.internal.http.d;	 Catch:{ IOException -> 0x011f }
        r6 = 0;
        r7 = r10.f5312e;	 Catch:{ IOException -> 0x011f }
        r8 = r10.f5313f;	 Catch:{ IOException -> 0x011f }
        r5.<init>(r6, r7, r8);	 Catch:{ IOException -> 0x011f }
        r6 = r10.f5312e;	 Catch:{ IOException -> 0x011f }
        r6 = r6.mo8764a();	 Catch:{ IOException -> 0x011f }
        r8 = (long) r12;	 Catch:{ IOException -> 0x011f }
        r7 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ IOException -> 0x011f }
        r6.mo8768a(r8, r7);	 Catch:{ IOException -> 0x011f }
        r6 = r10.f5313f;	 Catch:{ IOException -> 0x011f }
        r6 = r6.mo8703a();	 Catch:{ IOException -> 0x011f }
        r8 = (long) r13;	 Catch:{ IOException -> 0x011f }
        r7 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ IOException -> 0x011f }
        r6.mo8768a(r8, r7);	 Catch:{ IOException -> 0x011f }
        r6 = r2.mo8966c();	 Catch:{ IOException -> 0x011f }
        r5.mo8844a(r6, r3);	 Catch:{ IOException -> 0x011f }
        r5.mo8842b();	 Catch:{ IOException -> 0x011f }
        r3 = r5.mo8845c();	 Catch:{ IOException -> 0x011f }
        r2 = r3.mo8623a(r2);	 Catch:{ IOException -> 0x011f }
        r6 = r2.mo8624a();	 Catch:{ IOException -> 0x011f }
        r2 = okhttp3.internal.http.C1901m.m5398a(r6);	 Catch:{ IOException -> 0x011f }
        r8 = -1;
        r7 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r7 != 0) goto L_0x00f0;
    L_0x00ee:
        r2 = 0;
    L_0x00f0:
        r2 = r5.mo8843a(r2);	 Catch:{ IOException -> 0x011f }
        r3 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r5 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ IOException -> 0x011f }
        okhttp3.internal.C1910m.m5457a(r2, r3, r5);	 Catch:{ IOException -> 0x011f }
        r2.close();	 Catch:{ IOException -> 0x011f }
        r2 = r6.mo8630b();	 Catch:{ IOException -> 0x011f }
        switch(r2) {
            case 200: goto L_0x0146;
            case 407: goto L_0x0166;
            default: goto L_0x0106;
        };	 Catch:{ IOException -> 0x011f }
    L_0x0106:
        r2 = new java.io.IOException;	 Catch:{ IOException -> 0x011f }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x011f }
        r5 = "Unexpected response code for CONNECT: ";
        r3.<init>(r5);	 Catch:{ IOException -> 0x011f }
        r5 = r6.mo8630b();	 Catch:{ IOException -> 0x011f }
        r3 = r3.append(r5);	 Catch:{ IOException -> 0x011f }
        r3 = r3.toString();	 Catch:{ IOException -> 0x011f }
        r2.<init>(r3);	 Catch:{ IOException -> 0x011f }
        throw r2;	 Catch:{ IOException -> 0x011f }
    L_0x011f:
        r2 = move-exception;
        r3 = r10.f5309b;
        okhttp3.internal.C1910m.m5454a(r3);
        r3 = r10.f5319l;
        okhttp3.internal.C1910m.m5454a(r3);
        r10.f5309b = r1;
        r10.f5319l = r1;
        r10.f5312e = r1;
        r10.f5313f = r1;
        r10.f5320m = r1;
        r10.f5321n = r1;
        if (r0 != 0) goto L_0x0183;
    L_0x0138:
        r0 = new okhttp3.internal.http.RouteException;
        r0.<init>(r2);
    L_0x013d:
        if (r15 == 0) goto L_0x0145;
    L_0x013f:
        r2 = r4.mo8697a(r2);
        if (r2 != 0) goto L_0x0043;
    L_0x0145:
        throw r0;
    L_0x0146:
        r2 = r10.f5312e;	 Catch:{ IOException -> 0x011f }
        r2 = r2.mo9027c();	 Catch:{ IOException -> 0x011f }
        r2 = r2.mo9028e();	 Catch:{ IOException -> 0x011f }
        if (r2 == 0) goto L_0x015e;
    L_0x0152:
        r2 = r10.f5313f;	 Catch:{ IOException -> 0x011f }
        r2 = r2.mo9015c();	 Catch:{ IOException -> 0x011f }
        r2 = r2.mo9028e();	 Catch:{ IOException -> 0x011f }
        if (r2 != 0) goto L_0x0040;
    L_0x015e:
        r2 = new java.io.IOException;	 Catch:{ IOException -> 0x011f }
        r3 = "TLS tunnel buffered too many bytes!";
        r2.<init>(r3);	 Catch:{ IOException -> 0x011f }
        throw r2;	 Catch:{ IOException -> 0x011f }
    L_0x0166:
        r2 = r10.f5318k;	 Catch:{ IOException -> 0x011f }
        r2 = r2.mo8646a();	 Catch:{ IOException -> 0x011f }
        r2 = r2.mo8601d();	 Catch:{ IOException -> 0x011f }
        r2.mo8652a();	 Catch:{ IOException -> 0x011f }
        r2 = new java.io.IOException;	 Catch:{ IOException -> 0x011f }
        r3 = "Failed to authenticate with proxy";
        r2.<init>(r3);	 Catch:{ IOException -> 0x011f }
        throw r2;	 Catch:{ IOException -> 0x011f }
    L_0x017b:
        r10.m4974a(r11, r12);	 Catch:{ IOException -> 0x011f }
        r10.m4975a(r4);	 Catch:{ IOException -> 0x011f }
        goto L_0x0043;
    L_0x0183:
        r0.addConnectException(r2);
        goto L_0x013d;
    L_0x0187:
        return;
    L_0x0188:
        r0 = r1;
        goto L_0x0043;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.a.c.a(int, int, int, java.util.List, boolean):void");
    }

    /* renamed from: a */
    public final void mo8679a(C1837c c1837c) {
        this.f5314g = c1837c.mo8757b();
    }

    /* renamed from: a */
    public final void mo8680a(C1856o c1856o) {
        c1856o.mo8786a(ErrorCode.REFUSED_STREAM);
    }

    /* renamed from: a */
    public final boolean mo8682a(boolean z) {
        if (this.f5309b.isClosed() || this.f5309b.isInputShutdown() || this.f5309b.isOutputShutdown()) {
            return false;
        }
        if (this.f5310c != null || !z) {
            return true;
        }
        int soTimeout;
        try {
            soTimeout = this.f5309b.getSoTimeout();
            this.f5309b.setSoTimeout(1);
            if (this.f5312e.mo9028e()) {
                this.f5309b.setSoTimeout(soTimeout);
                return false;
            }
            this.f5309b.setSoTimeout(soTimeout);
            return true;
        } catch (SocketTimeoutException e) {
            return true;
        } catch (IOException e2) {
            return false;
        } catch (Throwable th) {
            this.f5309b.setSoTimeout(soTimeout);
        }
    }

    /* renamed from: b */
    public final C1921r mo8683b() {
        return this.f5320m;
    }

    public final String toString() {
        return "Connection{" + this.f5318k.mo8646a().mo8598a().mo8588f() + ":" + this.f5318k.mo8646a().mo8598a().mo8589g() + ", proxy=" + this.f5318k.mo8647b() + " hostAddress=" + this.f5318k.mo8648c() + " cipherSuite=" + (this.f5320m != null ? this.f5320m.mo8905a() : IXAdSystemUtils.NT_NONE) + " protocol=" + this.f5321n + '}';
    }
}
