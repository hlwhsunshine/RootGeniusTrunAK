package okhttp3.internal;

import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okio.C1939e;

/* renamed from: okhttp3.internal.a */
final class C1810a extends C1809k {
    /* renamed from: a */
    private final Class<?> f5324a;
    /* renamed from: b */
    private final C1908j<Socket> f5325b;
    /* renamed from: c */
    private final C1908j<Socket> f5326c;
    /* renamed from: d */
    private final C1908j<Socket> f5327d;
    /* renamed from: e */
    private final C1908j<Socket> f5328e;

    private C1810a(Class<?> cls, C1908j<Socket> c1908j, C1908j<Socket> c1908j2, C1908j<Socket> c1908j3, C1908j<Socket> c1908j4) {
        this.f5324a = cls;
        this.f5325b = c1908j;
        this.f5326c = c1908j2;
        this.f5327d = c1908j3;
        this.f5328e = c1908j4;
    }

    /* renamed from: b */
    public static C1809k m4993b() {
        Class cls;
        C1908j c1908j;
        C1908j c1908j2;
        try {
            cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
        } catch (ClassNotFoundException e) {
            cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
        }
        try {
            C1908j c1908j3 = new C1908j(null, "setUseSessionTickets", Boolean.TYPE);
            C1908j c1908j4 = new C1908j(null, "setHostname", String.class);
            C1908j c1908j5;
            try {
                Class.forName("android.net.Network");
                c1908j5 = new C1908j(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                try {
                    c1908j = new C1908j(null, "setAlpnProtocols", byte[].class);
                    c1908j2 = c1908j5;
                } catch (ClassNotFoundException e2) {
                    c1908j = null;
                    c1908j2 = c1908j5;
                    return new C1810a(cls, c1908j3, c1908j4, c1908j2, c1908j);
                }
            } catch (ClassNotFoundException e3) {
                c1908j5 = null;
                c1908j = null;
                c1908j2 = c1908j5;
                return new C1810a(cls, c1908j3, c1908j4, c1908j2, c1908j);
            }
            return new C1810a(cls, c1908j3, c1908j4, c1908j2, c1908j);
        } catch (ClassNotFoundException e4) {
            return null;
        }
    }

    /* renamed from: a */
    public final String mo8685a(SSLSocket sSLSocket) {
        if (this.f5327d == null) {
            return null;
        }
        if (!this.f5327d.mo8875a((Object) sSLSocket)) {
            return null;
        }
        byte[] bArr = (byte[]) this.f5327d.mo8876b(sSLSocket, new Object[0]);
        return bArr != null ? new String(bArr, C1910m.f5676c) : null;
    }

    /* renamed from: a */
    public final X509TrustManager mo8686a(SSLSocketFactory sSLSocketFactory) {
        Object a;
        Object a2 = C1809k.m4982a((Object) sSLSocketFactory, this.f5324a, "sslParameters");
        if (a2 == null) {
            try {
                a = C1809k.m4982a((Object) sSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (ClassNotFoundException e) {
                return super.mo8686a(sSLSocketFactory);
            }
        }
        a = a2;
        X509TrustManager x509TrustManager = (X509TrustManager) C1809k.m4982a(a, X509TrustManager.class, "x509TrustManager");
        return x509TrustManager != null ? x509TrustManager : (X509TrustManager) C1809k.m4982a(a, X509TrustManager.class, "trustManager");
    }

    /* renamed from: a */
    public final void mo8687a(int i, String str, Throwable th) {
        int i2 = i == 5 ? 5 : 3;
        if (th != null) {
            str = str + 10 + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int min;
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    /* renamed from: a */
    public final void mo8688a(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (C1910m.m5455a(e)) {
                throw new IOException(e);
            }
            throw e;
        } catch (Throwable e2) {
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e2);
            throw iOException;
        }
    }

    /* renamed from: a */
    public final void mo8689a(SSLSocket sSLSocket, String str, List<Protocol> list) {
        if (str != null) {
            this.f5325b.mo8874a(sSLSocket, Boolean.valueOf(true));
            this.f5326c.mo8874a(sSLSocket, str);
        }
        if (this.f5328e != null && this.f5328e.mo8875a((Object) sSLSocket)) {
            Object[] objArr = new Object[1];
            C1939e c1939e = new C1939e();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Protocol protocol = (Protocol) list.get(i);
                if (protocol != Protocol.HTTP_1_0) {
                    c1939e.mo9020h(protocol.toString().length());
                    c1939e.mo9012b(protocol.toString());
                }
            }
            objArr[0] = c1939e.mo9039p();
            this.f5328e.mo8876b(sSLSocket, objArr);
        }
    }

    /* renamed from: a */
    public final boolean mo8690a() {
        try {
            Class cls = Class.forName("android.security.NetworkSecurityPolicy");
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), new Object[0])).booleanValue();
        } catch (ClassNotFoundException e) {
            return super.mo8690a();
        } catch (NoSuchMethodException e2) {
            throw new AssertionError();
        } catch (IllegalAccessException e3) {
            throw new AssertionError();
        } catch (IllegalArgumentException e4) {
            throw new AssertionError();
        } catch (InvocationTargetException e5) {
            throw new AssertionError();
        }
    }
}
