package okhttp3.internal.http;

import okhttp3.C1792ac;
import okhttp3.C1923s;
import okhttp3.C1925u;
import okio.C1938h;

/* renamed from: okhttp3.internal.http.n */
public final class C1902n extends C1792ac {
    /* renamed from: a */
    private final C1923s f5644a;
    /* renamed from: b */
    private final C1938h f5645b;

    public C1902n(C1923s c1923s, C1938h c1938h) {
        this.f5644a = c1923s;
        this.f5645b = c1938h;
    }

    /* renamed from: a */
    public final C1925u mo8641a() {
        String a = this.f5644a.mo8916a("Content-Type");
        return a != null ? C1925u.m5518a(a) : null;
    }

    /* renamed from: b */
    public final long mo8642b() {
        return C1901m.m5399a(this.f5644a);
    }

    /* renamed from: c */
    public final C1938h mo8643c() {
        return this.f5645b;
    }
}
