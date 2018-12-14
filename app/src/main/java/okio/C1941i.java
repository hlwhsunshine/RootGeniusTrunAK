package okio;

import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* renamed from: okio.i */
public final class C1941i implements C1823w {
    /* renamed from: a */
    private final C1937g f5809a;
    /* renamed from: b */
    private final Deflater f5810b;
    /* renamed from: c */
    private boolean f5811c;

    private C1941i(C1937g c1937g, Deflater deflater) {
        if (c1937g == null) {
            throw new IllegalArgumentException("source == null");
        } else if (deflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.f5809a = c1937g;
            this.f5810b = deflater;
        }
    }

    public C1941i(C1823w c1823w, Deflater deflater) {
        this(C1945n.m5707a(c1823w), deflater);
    }

    @IgnoreJRERequirement
    /* renamed from: a */
    private void m5686a(boolean z) {
        C1952u e;
        C1939e c = this.f5809a.mo9015c();
        while (true) {
            e = c.mo9056e(1);
            int deflate = z ? this.f5810b.deflate(e.f5835a, e.f5837c, 8192 - e.f5837c, 2) : this.f5810b.deflate(e.f5835a, e.f5837c, 8192 - e.f5837c);
            if (deflate > 0) {
                e.f5837c += deflate;
                c.f5807b += (long) deflate;
                this.f5809a.mo9023r();
            } else if (this.f5810b.needsInput()) {
                break;
            }
        }
        if (e.f5836b == e.f5837c) {
            c.f5806a = e.mo9083a();
            C1953v.m5757a(e);
        }
    }

    /* renamed from: a */
    public final C1852y mo8703a() {
        return this.f5809a.mo8703a();
    }

    /* renamed from: a_ */
    public final void mo8704a_(C1939e c1939e, long j) {
        C1933aa.m5591a(c1939e.f5807b, 0, j);
        while (j > 0) {
            C1952u c1952u = c1939e.f5806a;
            int min = (int) Math.min(j, (long) (c1952u.f5837c - c1952u.f5836b));
            this.f5810b.setInput(c1952u.f5835a, c1952u.f5836b, min);
            m5686a(false);
            c1939e.f5807b -= (long) min;
            c1952u.f5836b += min;
            if (c1952u.f5836b == c1952u.f5837c) {
                c1939e.f5806a = c1952u.mo9083a();
                C1953v.m5757a(c1952u);
            }
            j -= (long) min;
        }
    }

    public final void close() {
        Throwable th;
        if (!this.f5811c) {
            Throwable th2 = null;
            try {
                this.f5810b.finish();
                m5686a(false);
            } catch (Throwable th3) {
                th2 = th3;
            }
            try {
                this.f5810b.end();
                th3 = th2;
            } catch (Throwable th4) {
                th3 = th4;
                if (th2 != null) {
                    th3 = th2;
                }
            }
            try {
                this.f5809a.close();
            } catch (Throwable th22) {
                if (th3 == null) {
                    th3 = th22;
                }
            }
            this.f5811c = true;
            if (th3 != null) {
                C1933aa.m5592a(th3);
            }
        }
    }

    public final void flush() {
        m5686a(true);
        this.f5809a.flush();
    }

    public final String toString() {
        return "DeflaterSink(" + this.f5809a + ")";
    }
}
