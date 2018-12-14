package okhttp3.internal.http;

import okhttp3.C1791ab;
import okhttp3.C1923s;
import okhttp3.C1932y;
import okhttp3.internal.C1809k;

/* renamed from: okhttp3.internal.http.m */
public final class C1901m {
    /* renamed from: a */
    static final String f5639a = C1809k.m4985d();
    /* renamed from: b */
    public static final String f5640b = (f5639a + "-Sent-Millis");
    /* renamed from: c */
    public static final String f5641c = (f5639a + "-Received-Millis");
    /* renamed from: d */
    public static final String f5642d = (f5639a + "-Selected-Protocol");
    /* renamed from: e */
    public static final String f5643e = (f5639a + "-Response-Source");

    static {
        C1809k.m4984c();
    }

    /* renamed from: a */
    public static long m5398a(C1791ab c1791ab) {
        return C1901m.m5399a(c1791ab.mo8634e());
    }

    /* renamed from: a */
    public static long m5399a(C1923s c1923s) {
        return C1901m.m5402b(c1923s.mo8916a("Content-Length"));
    }

    /* renamed from: a */
    public static long m5400a(C1932y c1932y) {
        return C1901m.m5399a(c1932y.mo8966c());
    }

    /* renamed from: a */
    static boolean m5401a(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    /* renamed from: b */
    private static long m5402b(String str) {
        long j = -1;
        if (str == null) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            return j;
        }
    }
}
