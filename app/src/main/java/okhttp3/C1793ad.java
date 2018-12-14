package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

/* renamed from: okhttp3.ad */
public final class C1793ad {
    /* renamed from: a */
    final C1787a f5265a;
    /* renamed from: b */
    final Proxy f5266b;
    /* renamed from: c */
    final InetSocketAddress f5267c;

    public C1793ad(C1787a c1787a, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (c1787a == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        } else {
            this.f5265a = c1787a;
            this.f5266b = proxy;
            this.f5267c = inetSocketAddress;
        }
    }

    /* renamed from: a */
    public final C1787a mo8646a() {
        return this.f5265a;
    }

    /* renamed from: b */
    public final Proxy mo8647b() {
        return this.f5266b;
    }

    /* renamed from: c */
    public final InetSocketAddress mo8648c() {
        return this.f5267c;
    }

    /* renamed from: d */
    public final boolean mo8649d() {
        return this.f5265a.f5233i != null && this.f5266b.type() == Type.HTTP;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1793ad)) {
            return false;
        }
        C1793ad c1793ad = (C1793ad) obj;
        return this.f5265a.equals(c1793ad.f5265a) && this.f5266b.equals(c1793ad.f5266b) && this.f5267c.equals(c1793ad.f5267c);
    }

    public final int hashCode() {
        return ((((this.f5265a.hashCode() + 527) * 31) + this.f5266b.hashCode()) * 31) + this.f5267c.hashCode();
    }
}
