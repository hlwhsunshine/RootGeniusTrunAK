package okhttp3.internal.p123b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

/* renamed from: okhttp3.internal.b.d */
public abstract class C1816d {

    /* renamed from: okhttp3.internal.b.d$a */
    static final class C1817a extends C1816d {
        /* renamed from: a */
        private final X509TrustManager f5340a;
        /* renamed from: b */
        private final Method f5341b;

        C1817a(X509TrustManager x509TrustManager, Method method) {
            this.f5341b = method;
            this.f5340a = x509TrustManager;
        }

        /* renamed from: a */
        public final X509Certificate mo8695a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f5341b.invoke(this.f5340a, new Object[]{x509Certificate});
                return trustAnchor != null ? trustAnchor.getTrustedCert() : null;
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                return null;
            }
        }
    }

    /* renamed from: okhttp3.internal.b.d$b */
    static final class C1818b extends C1816d {
        /* renamed from: a */
        private final Map<X500Principal, List<X509Certificate>> f5342a = new LinkedHashMap();

        public C1818b(X509Certificate... x509CertificateArr) {
            for (X509Certificate x509Certificate : x509CertificateArr) {
                X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
                List list = (List) this.f5342a.get(subjectX500Principal);
                if (list == null) {
                    list = new ArrayList(1);
                    this.f5342a.put(subjectX500Principal, list);
                }
                list.add(x509Certificate);
            }
        }

        /* renamed from: a */
        public final X509Certificate mo8695a(X509Certificate x509Certificate) {
            List<X509Certificate> list = (List) this.f5342a.get(x509Certificate.getIssuerX500Principal());
            if (list == null) {
                return null;
            }
            for (X509Certificate x509Certificate2 : list) {
                try {
                    x509Certificate.verify(x509Certificate2.getPublicKey());
                    return x509Certificate2;
                } catch (Exception e) {
                }
            }
            return null;
        }
    }

    /* renamed from: a */
    public static C1816d m5015a(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            declaredMethod.setAccessible(true);
            return new C1817a(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException e) {
            return new C1818b(x509TrustManager.getAcceptedIssuers());
        }
    }

    /* renamed from: a */
    abstract X509Certificate mo8695a(X509Certificate x509Certificate);
}
