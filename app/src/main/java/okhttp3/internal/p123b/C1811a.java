package okhttp3.internal.p123b;

import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* renamed from: okhttp3.internal.b.a */
public abstract class C1811a {

    /* renamed from: okhttp3.internal.b.a$a */
    static final class C1812a extends C1811a {
        /* renamed from: a */
        private final Object f5329a;
        /* renamed from: b */
        private final Method f5330b;

        C1812a(Object obj, Method method) {
            this.f5329a = obj;
            this.f5330b = method;
        }

        /* renamed from: a */
        public final List<Certificate> mo8692a(List<Certificate> list, String str) {
            try {
                X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
                return (List) this.f5330b.invoke(this.f5329a, new Object[]{x509CertificateArr, "RSA", str});
            } catch (Throwable e) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
                sSLPeerUnverifiedException.initCause(e);
                throw sSLPeerUnverifiedException;
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    /* renamed from: okhttp3.internal.b.a$b */
    static final class C1813b extends C1811a {
        /* renamed from: a */
        private final C1816d f5331a;

        public C1813b(C1816d c1816d) {
            this.f5331a = c1816d;
        }

        /* renamed from: a */
        private static boolean m5003a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
            if (!x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
                return false;
            }
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return true;
            } catch (GeneralSecurityException e) {
                return false;
            }
        }

        /* renamed from: a */
        public final List<Certificate> mo8692a(List<Certificate> list, String str) {
            Object obj = null;
            Deque arrayDeque = new ArrayDeque(list);
            List<Certificate> arrayList = new ArrayList();
            arrayList.add(arrayDeque.removeFirst());
            int i = 0;
            while (true) {
                Object obj2 = obj;
                if (i < 9) {
                    X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
                    X509Certificate a = this.f5331a.mo8695a(x509Certificate);
                    if (a != null) {
                        if (arrayList.size() > 1 || !x509Certificate.equals(a)) {
                            arrayList.add(a);
                        }
                        if (C1813b.m5003a(a, a)) {
                            return arrayList;
                        }
                        obj = 1;
                    } else {
                        Iterator it = arrayDeque.iterator();
                        while (it.hasNext()) {
                            a = (X509Certificate) it.next();
                            if (C1813b.m5003a(x509Certificate, a)) {
                                it.remove();
                                arrayList.add(a);
                                obj = obj2;
                            }
                        }
                        if (obj2 != null) {
                            return arrayList;
                        }
                        throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
                    }
                    i++;
                } else {
                    throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
                }
            }
        }
    }

    /* renamed from: a */
    public static C1811a m5000a(X509TrustManager x509TrustManager) {
        try {
            Class cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C1812a(cls.getConstructor(new Class[]{X509TrustManager.class}).newInstance(new Object[]{x509TrustManager}), cls.getMethod("checkServerTrusted", new Class[]{X509Certificate[].class, String.class, String.class}));
        } catch (Exception e) {
            return new C1813b(C1816d.m5015a(x509TrustManager));
        }
    }

    /* renamed from: a */
    public abstract List<Certificate> mo8692a(List<Certificate> list, String str);
}
