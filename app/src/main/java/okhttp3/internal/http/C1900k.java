package okhttp3.internal.http;

/* renamed from: okhttp3.internal.http.k */
public final class C1900k {
    /* renamed from: a */
    public static boolean m5396a(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    /* renamed from: b */
    public static boolean m5397b(String str) {
        return C1900k.m5396a(str) || str.equals("OPTIONS") || str.equals("DELETE") || str.equals("PROPFIND") || str.equals("MKCOL") || str.equals("LOCK");
    }
}
