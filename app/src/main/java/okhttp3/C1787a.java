package okhttp3;

import android.support.p015v4.internal.view.SupportMenu;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.HttpUrl.Builder;
import okhttp3.internal.C1910m;

/* renamed from: okhttp3.a */
public final class C1787a {
    /* renamed from: a */
    final HttpUrl f5225a;
    /* renamed from: b */
    final C1919p f5226b;
    /* renamed from: c */
    final SocketFactory f5227c;
    /* renamed from: d */
    final C1794b f5228d;
    /* renamed from: e */
    final List<Protocol> f5229e;
    /* renamed from: f */
    final List<C1914k> f5230f;
    /* renamed from: g */
    final ProxySelector f5231g;
    /* renamed from: h */
    final Proxy f5232h;
    /* renamed from: i */
    final SSLSocketFactory f5233i;
    /* renamed from: j */
    final HostnameVerifier f5234j;
    /* renamed from: k */
    final C1802g f5235k;

    public C1787a(String str, int i, C1919p c1919p, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, C1802g c1802g, C1794b c1794b, Proxy proxy, List<Protocol> list, List<C1914k> list2, ProxySelector proxySelector) {
        Builder builder = new Builder();
        String str2 = sSLSocketFactory != null ? "https" : "http";
        if (str2.equalsIgnoreCase("http")) {
            builder.f5207a = "http";
        } else if (str2.equalsIgnoreCase("https")) {
            builder.f5207a = "https";
        } else {
            throw new IllegalArgumentException("unexpected scheme: " + str2);
        }
        Builder a = builder.mo8577a(str);
        if (i <= 0 || i > SupportMenu.USER_MASK) {
            throw new IllegalArgumentException("unexpected port: " + i);
        }
        a.f5211e = i;
        this.f5225a = a.mo8579b();
        if (c1919p == null) {
            throw new NullPointerException("dns == null");
        }
        this.f5226b = c1919p;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.f5227c = socketFactory;
        if (c1794b == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.f5228d = c1794b;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.f5229e = C1910m.m5447a((List) list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f5230f = C1910m.m5447a((List) list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.f5231g = proxySelector;
        this.f5232h = proxy;
        this.f5233i = sSLSocketFactory;
        this.f5234j = hostnameVerifier;
        this.f5235k = c1802g;
    }

    /* renamed from: a */
    public final HttpUrl mo8598a() {
        return this.f5225a;
    }

    /* renamed from: b */
    public final C1919p mo8599b() {
        return this.f5226b;
    }

    /* renamed from: c */
    public final SocketFactory mo8600c() {
        return this.f5227c;
    }

    /* renamed from: d */
    public final C1794b mo8601d() {
        return this.f5228d;
    }

    /* renamed from: e */
    public final List<Protocol> mo8602e() {
        return this.f5229e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1787a)) {
            return false;
        }
        C1787a c1787a = (C1787a) obj;
        return this.f5225a.equals(c1787a.f5225a) && this.f5226b.equals(c1787a.f5226b) && this.f5228d.equals(c1787a.f5228d) && this.f5229e.equals(c1787a.f5229e) && this.f5230f.equals(c1787a.f5230f) && this.f5231g.equals(c1787a.f5231g) && C1910m.m5456a(this.f5232h, c1787a.f5232h) && C1910m.m5456a(this.f5233i, c1787a.f5233i) && C1910m.m5456a(this.f5234j, c1787a.f5234j) && C1910m.m5456a(this.f5235k, c1787a.f5235k);
    }

    /* renamed from: f */
    public final List<C1914k> mo8604f() {
        return this.f5230f;
    }

    /* renamed from: g */
    public final ProxySelector mo8605g() {
        return this.f5231g;
    }

    /* renamed from: h */
    public final Proxy mo8606h() {
        return this.f5232h;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.f5234j != null ? this.f5234j.hashCode() : 0) + (((this.f5233i != null ? this.f5233i.hashCode() : 0) + (((this.f5232h != null ? this.f5232h.hashCode() : 0) + ((((((((((((this.f5225a.hashCode() + 527) * 31) + this.f5226b.hashCode()) * 31) + this.f5228d.hashCode()) * 31) + this.f5229e.hashCode()) * 31) + this.f5230f.hashCode()) * 31) + this.f5231g.hashCode()) * 31)) * 31)) * 31)) * 31;
        if (this.f5235k != null) {
            i = this.f5235k.hashCode();
        }
        return hashCode + i;
    }

    /* renamed from: i */
    public final SSLSocketFactory mo8608i() {
        return this.f5233i;
    }

    /* renamed from: j */
    public final HostnameVerifier mo8609j() {
        return this.f5234j;
    }

    /* renamed from: k */
    public final C1802g mo8610k() {
        return this.f5235k;
    }
}
