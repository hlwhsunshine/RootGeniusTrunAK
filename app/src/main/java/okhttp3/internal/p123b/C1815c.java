package okhttp3.internal.p123b;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.C1910m;

/* renamed from: okhttp3.internal.b.c */
public final class C1815c implements HostnameVerifier {
    /* renamed from: a */
    public static final C1815c f5339a = new C1815c();

    private C1815c() {
    }

    /* renamed from: a */
    public static List<String> m5012a(X509Certificate x509Certificate) {
        Collection a = C1815c.m5013a(x509Certificate, 7);
        Collection a2 = C1815c.m5013a(x509Certificate, 2);
        List<String> arrayList = new ArrayList(a.size() + a2.size());
        arrayList.addAll(a);
        arrayList.addAll(a2);
        return arrayList;
    }

    /* renamed from: a */
    private static List<String> m5013a(X509Certificate x509Certificate, int i) {
        List<String> arrayList = new ArrayList();
        try {
            Collection<List> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2) {
                    Integer num = (Integer) list.get(0);
                    if (num != null && num.intValue() == i) {
                        String str = (String) list.get(1);
                        if (str != null) {
                            arrayList.add(str);
                        }
                    }
                }
            }
            return arrayList;
        } catch (CertificateParsingException e) {
            return Collections.emptyList();
        }
    }

    /* renamed from: a */
    private static boolean m5014a(String str, String str2) {
        if (str == null || str.length() == 0 || str.startsWith(".") || str.endsWith("..") || str2 == null || str2.length() == 0 || str2.startsWith(".") || str2.endsWith("..")) {
            return false;
        }
        if (!str.endsWith(".")) {
            str = str + '.';
        }
        if (!str2.endsWith(".")) {
            str2 = str2 + '.';
        }
        String toLowerCase = str2.toLowerCase(Locale.US);
        if (!toLowerCase.contains("*")) {
            return str.equals(toLowerCase);
        }
        if (!toLowerCase.startsWith("*.") || toLowerCase.indexOf(42, 1) != -1 || str.length() < toLowerCase.length() || "*.".equals(toLowerCase)) {
            return false;
        }
        toLowerCase = toLowerCase.substring(1);
        if (!str.endsWith(toLowerCase)) {
            return false;
        }
        int length = str.length() - toLowerCase.length();
        return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            X509Certificate x509Certificate = (X509Certificate) sSLSession.getPeerCertificates()[0];
            int i;
            if (C1910m.m5466c(str)) {
                List a = C1815c.m5013a(x509Certificate, 7);
                int size = a.size();
                for (i = 0; i < size; i++) {
                    if (str.equalsIgnoreCase((String) a.get(i))) {
                        return true;
                    }
                }
                return false;
            }
            String toLowerCase = str.toLowerCase(Locale.US);
            List a2 = C1815c.m5013a(x509Certificate, 2);
            int size2 = a2.size();
            int i2 = 0;
            Object obj = null;
            while (i2 < size2) {
                if (C1815c.m5014a(toLowerCase, (String) a2.get(i2))) {
                    return true;
                }
                i2++;
                i = 1;
            }
            if (obj == null) {
                String a3 = new C1814b(x509Certificate.getSubjectX500Principal()).mo8693a("cn");
                if (a3 != null) {
                    return C1815c.m5014a(toLowerCase, a3);
                }
            }
            return false;
        } catch (SSLException e) {
            return false;
        }
    }
}
