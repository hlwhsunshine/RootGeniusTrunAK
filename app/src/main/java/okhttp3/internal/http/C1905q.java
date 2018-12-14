package okhttp3.internal.http;

import android.support.p015v4.internal.view.SupportMenu;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.C1787a;
import okhttp3.C1793ad;
import okhttp3.HttpUrl;
import okhttp3.internal.C1909l;

/* renamed from: okhttp3.internal.http.q */
public final class C1905q {
    /* renamed from: a */
    private final C1787a f5649a;
    /* renamed from: b */
    private final C1909l f5650b;
    /* renamed from: c */
    private Proxy f5651c;
    /* renamed from: d */
    private InetSocketAddress f5652d;
    /* renamed from: e */
    private List<Proxy> f5653e = Collections.emptyList();
    /* renamed from: f */
    private int f5654f;
    /* renamed from: g */
    private List<InetSocketAddress> f5655g = Collections.emptyList();
    /* renamed from: h */
    private int f5656h;
    /* renamed from: i */
    private final List<C1793ad> f5657i = new ArrayList();

    public C1905q(C1787a c1787a, C1909l c1909l) {
        this.f5649a = c1787a;
        this.f5650b = c1909l;
        HttpUrl a = c1787a.mo8598a();
        Proxy h = c1787a.mo8606h();
        if (h != null) {
            this.f5653e = Collections.singletonList(h);
        } else {
            this.f5653e = new ArrayList();
            Collection select = this.f5649a.mo8605g().select(a.mo8581a());
            if (select != null) {
                this.f5653e.addAll(select);
            }
            this.f5653e.removeAll(Collections.singleton(Proxy.NO_PROXY));
            this.f5653e.add(Proxy.NO_PROXY);
        }
        this.f5654f = 0;
    }

    /* renamed from: a */
    private void m5411a(Proxy proxy) {
        String f;
        int g;
        this.f5655g = new ArrayList();
        if (proxy.type() == Type.DIRECT || proxy.type() == Type.SOCKS) {
            f = this.f5649a.mo8598a().mo8588f();
            g = this.f5649a.mo8598a().mo8589g();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                InetAddress address2 = inetSocketAddress.getAddress();
                f = address2 == null ? inetSocketAddress.getHostName() : address2.getHostAddress();
                g = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (g <= 0 || g > SupportMenu.USER_MASK) {
            throw new SocketException("No route to " + f + ":" + g + "; port is out of range");
        }
        if (proxy.type() == Type.SOCKS) {
            this.f5655g.add(InetSocketAddress.createUnresolved(f, g));
        } else {
            List a = this.f5649a.mo8599b().mo8904a(f);
            int size = a.size();
            for (int i = 0; i < size; i++) {
                this.f5655g.add(new InetSocketAddress((InetAddress) a.get(i), g));
            }
        }
        this.f5656h = 0;
    }

    /* renamed from: c */
    private boolean m5412c() {
        return this.f5654f < this.f5653e.size();
    }

    /* renamed from: d */
    private boolean m5413d() {
        return this.f5656h < this.f5655g.size();
    }

    /* renamed from: e */
    private boolean m5414e() {
        return !this.f5657i.isEmpty();
    }

    /* renamed from: a */
    public final void mo8860a(C1793ad c1793ad, IOException iOException) {
        if (!(c1793ad.mo8647b().type() == Type.DIRECT || this.f5649a.mo8605g() == null)) {
            this.f5649a.mo8605g().connectFailed(this.f5649a.mo8598a().mo8581a(), c1793ad.mo8647b().address(), iOException);
        }
        this.f5650b.mo8877a(c1793ad);
    }

    /* renamed from: a */
    public final boolean mo8861a() {
        return m5413d() || m5412c() || m5414e();
    }

    /* renamed from: b */
    public final C1793ad mo8862b() {
        while (true) {
            List list;
            int i;
            if (!m5413d()) {
                if (m5412c()) {
                    if (m5412c()) {
                        list = this.f5653e;
                        i = this.f5654f;
                        this.f5654f = i + 1;
                        Proxy proxy = (Proxy) list.get(i);
                        m5411a(proxy);
                        this.f5651c = proxy;
                    } else {
                        throw new SocketException("No route to " + this.f5649a.mo8598a().mo8588f() + "; exhausted proxy configurations: " + this.f5653e);
                    }
                } else if (m5414e()) {
                    return (C1793ad) this.f5657i.remove(0);
                } else {
                    throw new NoSuchElementException();
                }
            }
            if (m5413d()) {
                list = this.f5655g;
                i = this.f5656h;
                this.f5656h = i + 1;
                this.f5652d = (InetSocketAddress) list.get(i);
                C1793ad c1793ad = new C1793ad(this.f5649a, this.f5651c, this.f5652d);
                if (!this.f5650b.mo8879c(c1793ad)) {
                    return c1793ad;
                }
                this.f5657i.add(c1793ad);
            } else {
                throw new SocketException("No route to " + this.f5649a.mo8598a().mo8588f() + "; exhausted inet socket addresses: " + this.f5655g);
            }
        }
    }
}
