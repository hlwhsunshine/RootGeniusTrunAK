package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.Inflater;

/* renamed from: okio.m */
public final class C1944m implements C1850x {
    /* renamed from: a */
    private final C1938h f5818a;
    /* renamed from: b */
    private final Inflater f5819b;
    /* renamed from: c */
    private int f5820c;
    /* renamed from: d */
    private boolean f5821d;

    C1944m(C1938h c1938h, Inflater inflater) {
        if (c1938h == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.f5818a = c1938h;
            this.f5819b = inflater;
        }
    }

    public C1944m(C1850x c1850x, Inflater inflater) {
        this(C1945n.m5708a(c1850x), inflater);
    }

    /* renamed from: c */
    private void m5703c() {
        if (this.f5820c != 0) {
            int remaining = this.f5820c - this.f5819b.getRemaining();
            this.f5820c -= remaining;
            this.f5818a.mo9031f((long) remaining);
        }
    }

    /* renamed from: a */
    public final long mo8763a(C1939e c1939e, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (this.f5821d) {
            throw new IllegalStateException("closed");
        } else if (j == 0) {
            return 0;
        } else {
            boolean b;
            do {
                b = mo9073b();
                try {
                    C1952u e = c1939e.mo9056e(1);
                    int inflate = this.f5819b.inflate(e.f5835a, e.f5837c, 8192 - e.f5837c);
                    if (inflate > 0) {
                        e.f5837c += inflate;
                        c1939e.f5807b += (long) inflate;
                        return (long) inflate;
                    } else if (this.f5819b.finished() || this.f5819b.needsDictionary()) {
                        m5703c();
                        if (e.f5836b == e.f5837c) {
                            c1939e.f5806a = e.mo9083a();
                            C1953v.m5757a(e);
                        }
                        return -1;
                    }
                } catch (Throwable e2) {
                    throw new IOException(e2);
                }
            } while (!b);
            throw new EOFException("source exhausted prematurely");
        }
    }

    /* renamed from: a */
    public final C1852y mo8764a() {
        return this.f5818a.mo8764a();
    }

    /* renamed from: b */
    public final boolean mo9073b() {
        if (!this.f5819b.needsInput()) {
            return false;
        }
        m5703c();
        if (this.f5819b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f5818a.mo9028e()) {
            return true;
        } else {
            C1952u c1952u = this.f5818a.mo9027c().f5806a;
            this.f5820c = c1952u.f5837c - c1952u.f5836b;
            this.f5819b.setInput(c1952u.f5835a, c1952u.f5836b, this.f5820c);
            return false;
        }
    }

    public final void close() {
        if (!this.f5821d) {
            this.f5819b.end();
            this.f5821d = true;
            this.f5818a.close();
        }
    }
}
