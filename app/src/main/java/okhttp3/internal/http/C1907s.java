package okhttp3.internal.http;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import okhttp3.C1787a;
import okhttp3.C1793ad;
import okhttp3.C1804i;
import okhttp3.internal.C1825e;
import okhttp3.internal.C1909l;
import okhttp3.internal.C1910m;
import okhttp3.internal.framed.ErrorCode;
import okhttp3.internal.framed.StreamResetException;
import okhttp3.internal.p122a.C1808c;

/* renamed from: okhttp3.internal.http.s */
public final class C1907s {
    /* renamed from: a */
    public final C1787a f5661a;
    /* renamed from: b */
    private C1793ad f5662b;
    /* renamed from: c */
    private final C1804i f5663c;
    /* renamed from: d */
    private final C1905q f5664d;
    /* renamed from: e */
    private int f5665e;
    /* renamed from: f */
    private C1808c f5666f;
    /* renamed from: g */
    private boolean f5667g;
    /* renamed from: h */
    private boolean f5668h;
    /* renamed from: i */
    private C1889l f5669i;

    public C1907s(C1804i c1804i, C1787a c1787a) {
        this.f5663c = c1804i;
        this.f5661a = c1787a;
        this.f5664d = new C1905q(c1787a, m5422f());
    }

    /* renamed from: a */
    private C1808c m5419a(int i, int i2, int i3, boolean z) {
        C1808c c1808c;
        synchronized (this.f5663c) {
            if (this.f5667g) {
                throw new IllegalStateException("released");
            } else if (this.f5669i != null) {
                throw new IllegalStateException("stream != null");
            } else if (this.f5668h) {
                throw new IOException("Canceled");
            } else {
                c1808c = this.f5666f;
                if (c1808c == null || c1808c.f5316i) {
                    c1808c = C1825e.f5371a.mo8707a(this.f5663c, this.f5661a, this);
                    if (c1808c != null) {
                        this.f5666f = c1808c;
                    } else {
                        C1793ad c1793ad;
                        C1793ad c1793ad2 = this.f5662b;
                        if (c1793ad2 == null) {
                            c1793ad2 = this.f5664d.mo8862b();
                            synchronized (this.f5663c) {
                                this.f5662b = c1793ad2;
                                this.f5665e = 0;
                            }
                            c1793ad = c1793ad2;
                        } else {
                            c1793ad = c1793ad2;
                        }
                        c1808c = new C1808c(c1793ad);
                        mo8867a(c1808c);
                        synchronized (this.f5663c) {
                            C1825e.f5371a.mo8713b(this.f5663c, c1808c);
                            this.f5666f = c1808c;
                            if (this.f5668h) {
                                throw new IOException("Canceled");
                            }
                        }
                        c1808c.mo8681a(i, i2, i3, this.f5661a.mo8604f(), z);
                        m5422f().mo8878b(c1808c.mo8673a());
                    }
                }
            }
        }
        return c1808c;
    }

    /* renamed from: a */
    private void m5420a(boolean z, boolean z2, boolean z3) {
        C1808c c1808c;
        synchronized (this.f5663c) {
            if (z3) {
                this.f5669i = null;
            }
            if (z2) {
                this.f5667g = true;
            }
            if (this.f5666f != null) {
                if (z) {
                    this.f5666f.f5316i = true;
                }
                if (this.f5669i == null && (this.f5667g || this.f5666f.f5316i)) {
                    C1808c c1808c2 = this.f5666f;
                    int size = c1808c2.f5315h.size();
                    int i = 0;
                    while (i < size) {
                        if (((Reference) c1808c2.f5315h.get(i)).get() == this) {
                            c1808c2.f5315h.remove(i);
                            if (this.f5666f.f5315h.isEmpty()) {
                                this.f5666f.f5317j = System.nanoTime();
                                if (C1825e.f5371a.mo8712a(this.f5663c, this.f5666f)) {
                                    c1808c = this.f5666f;
                                    this.f5666f = null;
                                }
                            }
                            c1808c = null;
                            this.f5666f = null;
                        } else {
                            i++;
                        }
                    }
                    throw new IllegalStateException();
                }
            }
            c1808c = null;
        }
        if (c1808c != null) {
            C1910m.m5454a(c1808c.f5309b);
        }
    }

    /* renamed from: b */
    private C1808c m5421b(int i, int i2, int i3, boolean z, boolean z2) {
        C1808c a;
        while (true) {
            a = m5419a(i, i2, i3, z);
            synchronized (this.f5663c) {
                if (a.f5311d != 0) {
                    if (a.mo8682a(z2)) {
                        break;
                    }
                    m5420a(true, false, false);
                } else {
                    break;
                }
            }
        }
        return a;
    }

    /* renamed from: f */
    private C1909l m5422f() {
        return C1825e.f5371a.mo8709a(this.f5663c);
    }

    /* renamed from: a */
    public final C1889l mo8864a() {
        C1889l c1889l;
        synchronized (this.f5663c) {
            c1889l = this.f5669i;
        }
        return c1889l;
    }

    /* renamed from: a */
    public final C1889l mo8865a(int i, int i2, int i3, boolean z, boolean z2) {
        try {
            C1889l c1892e;
            C1808c b = m5421b(i, i2, i3, z, z2);
            if (b.f5310c != null) {
                c1892e = new C1892e(this, b.f5310c);
            } else {
                b.f5309b.setSoTimeout(i2);
                b.f5312e.mo8764a().mo8768a((long) i2, TimeUnit.MILLISECONDS);
                b.f5313f.mo8703a().mo8768a((long) i3, TimeUnit.MILLISECONDS);
                c1892e = new C1890d(this, b.f5312e, b.f5313f);
            }
            synchronized (this.f5663c) {
                this.f5669i = c1892e;
            }
            return c1892e;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    /* renamed from: a */
    public final void mo8866a(IOException iOException) {
        boolean z;
        synchronized (this.f5663c) {
            if (iOException instanceof StreamResetException) {
                StreamResetException streamResetException = (StreamResetException) iOException;
                if (streamResetException.errorCode == ErrorCode.REFUSED_STREAM) {
                    this.f5665e++;
                }
                if (streamResetException.errorCode != ErrorCode.REFUSED_STREAM || this.f5665e > 1) {
                    this.f5662b = null;
                }
                z = false;
            } else {
                if (this.f5666f != null) {
                    if (!(this.f5666f.f5310c != null)) {
                        if (this.f5666f.f5311d == 0) {
                            if (!(this.f5662b == null || iOException == null)) {
                                this.f5664d.mo8860a(this.f5662b, iOException);
                            }
                            this.f5662b = null;
                        }
                    }
                }
                z = false;
            }
            z = true;
        }
        m5420a(z, false, true);
    }

    /* renamed from: a */
    public final void mo8867a(C1808c c1808c) {
        c1808c.f5315h.add(new WeakReference(this));
    }

    /* renamed from: a */
    public final void mo8868a(boolean z, C1889l c1889l) {
        synchronized (this.f5663c) {
            if (c1889l != null) {
                if (c1889l == this.f5669i) {
                    if (!z) {
                        C1808c c1808c = this.f5666f;
                        c1808c.f5311d++;
                    }
                }
            }
            throw new IllegalStateException("expected " + this.f5669i + " but was " + c1889l);
        }
        m5420a(z, false, true);
    }

    /* renamed from: b */
    public final synchronized C1808c mo8869b() {
        return this.f5666f;
    }

    /* renamed from: c */
    public final void mo8870c() {
        m5420a(false, true, false);
    }

    /* renamed from: d */
    public final void mo8871d() {
        m5420a(true, false, false);
    }

    /* renamed from: e */
    public final boolean mo8872e() {
        return this.f5662b != null || this.f5664d.mo8861a();
    }

    public final String toString() {
        return this.f5661a.toString();
    }
}
