package okhttp3.internal.http;

import okhttp3.HttpUrl;

/* renamed from: okhttp3.internal.http.o */
public final class C1903o {
    /* renamed from: a */
    public static String m5406a(HttpUrl httpUrl) {
        String h = httpUrl.mo8590h();
        String j = httpUrl.mo8593j();
        return j != null ? h + '?' + j : h;
    }
}
