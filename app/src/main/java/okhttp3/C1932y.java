package okhttp3;

import okhttp3.C1923s.C1922a;
import okhttp3.internal.http.C1900k;

/* renamed from: okhttp3.y */
public final class C1932y {
    /* renamed from: a */
    private final HttpUrl f5792a;
    /* renamed from: b */
    private final String f5793b;
    /* renamed from: c */
    private final C1923s f5794c;
    /* renamed from: d */
    private final C1788z f5795d;
    /* renamed from: e */
    private final Object f5796e;
    /* renamed from: f */
    private volatile C1798e f5797f;

    /* renamed from: okhttp3.y$a */
    public static class C1931a {
        /* renamed from: a */
        private HttpUrl f5787a;
        /* renamed from: b */
        private String f5788b;
        /* renamed from: c */
        private C1922a f5789c;
        /* renamed from: d */
        private C1788z f5790d;
        /* renamed from: e */
        private Object f5791e;

        public C1931a() {
            this.f5788b = "GET";
            this.f5789c = new C1922a();
        }

        private C1931a(C1932y c1932y) {
            this.f5787a = c1932y.f5792a;
            this.f5788b = c1932y.f5793b;
            this.f5790d = c1932y.f5795d;
            this.f5791e = c1932y.f5796e;
            this.f5789c = c1932y.f5794c.mo8919b();
        }

        /* synthetic */ C1931a(C1932y c1932y, byte b) {
            this(c1932y);
        }

        /* renamed from: a */
        public final C1931a mo8956a(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else {
                if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = "https:" + str.substring(4);
                }
            }
            HttpUrl d = HttpUrl.m4856d(str);
            if (d != null) {
                return mo8959a(d);
            }
            throw new IllegalArgumentException("unexpected url: " + str);
        }

        /* renamed from: a */
        public final C1931a mo8957a(String str, String str2) {
            this.f5789c.mo8913b(str, str2);
            return this;
        }

        /* renamed from: a */
        public final C1931a mo8958a(String str, C1788z c1788z) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (c1788z != null && !C1900k.m5397b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (c1788z == null && C1900k.m5396a(str)) {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            } else {
                this.f5788b = str;
                this.f5790d = c1788z;
                return this;
            }
        }

        /* renamed from: a */
        public final C1931a mo8959a(HttpUrl httpUrl) {
            if (httpUrl == null) {
                throw new NullPointerException("url == null");
            }
            this.f5787a = httpUrl;
            return this;
        }

        /* renamed from: a */
        public final C1931a mo8960a(C1788z c1788z) {
            return mo8958a("POST", c1788z);
        }

        /* renamed from: a */
        public final C1932y mo8961a() {
            if (this.f5787a != null) {
                return new C1932y(this, (byte) 0);
            }
            throw new IllegalStateException("url == null");
        }

        /* renamed from: b */
        public final C1931a mo8962b(String str) {
            this.f5789c.mo8912b(str);
            return this;
        }
    }

    private C1932y(C1931a c1931a) {
        Object e;
        this.f5792a = c1931a.f5787a;
        this.f5793b = c1931a.f5788b;
        this.f5794c = c1931a.f5789c.mo8911a();
        this.f5795d = c1931a.f5790d;
        if (c1931a.f5791e != null) {
            e = c1931a.f5791e;
        } else {
            C1932y e2 = this;
        }
        this.f5796e = e2;
    }

    /* synthetic */ C1932y(C1931a c1931a, byte b) {
        this(c1931a);
    }

    /* renamed from: a */
    public final String mo8963a(String str) {
        return this.f5794c.mo8916a(str);
    }

    /* renamed from: a */
    public final HttpUrl mo8964a() {
        return this.f5792a;
    }

    /* renamed from: b */
    public final String mo8965b() {
        return this.f5793b;
    }

    /* renamed from: c */
    public final C1923s mo8966c() {
        return this.f5794c;
    }

    /* renamed from: d */
    public final C1788z mo8967d() {
        return this.f5795d;
    }

    /* renamed from: e */
    public final C1931a mo8968e() {
        return new C1931a(this, (byte) 0);
    }

    /* renamed from: f */
    public final C1798e mo8969f() {
        C1798e c1798e = this.f5797f;
        if (c1798e != null) {
            return c1798e;
        }
        c1798e = C1798e.m4949a(this.f5794c);
        this.f5797f = c1798e;
        return c1798e;
    }

    /* renamed from: g */
    public final boolean mo8970g() {
        return this.f5792a.mo8584c();
    }

    public final String toString() {
        return "Request{method=" + this.f5793b + ", url=" + this.f5792a + ", tag=" + (this.f5796e != this ? this.f5796e : null) + '}';
    }
}
