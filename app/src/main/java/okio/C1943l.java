package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* renamed from: okio.l */
public final class C1943l implements C1850x {
    /* renamed from: a */
    private int f5813a = 0;
    /* renamed from: b */
    private final C1938h f5814b;
    /* renamed from: c */
    private final Inflater f5815c;
    /* renamed from: d */
    private final C1944m f5816d;
    /* renamed from: e */
    private final CRC32 f5817e = new CRC32();

    public C1943l(C1850x c1850x) {
        if (c1850x == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.f5815c = new Inflater(true);
        this.f5814b = C1945n.m5708a(c1850x);
        this.f5816d = new C1944m(this.f5814b, this.f5815c);
    }

    /* renamed from: a */
    private static void m5699a(String str, int i, int i2) {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }

    /* renamed from: a */
    private void m5700a(C1939e c1939e, long j, long j2) {
        C1952u c1952u = c1939e.f5806a;
        while (j >= ((long) (c1952u.f5837c - c1952u.f5836b))) {
            j -= (long) (c1952u.f5837c - c1952u.f5836b);
            c1952u = c1952u.f5840f;
        }
        while (j2 > 0) {
            int i = (int) (((long) c1952u.f5836b) + j);
            int min = (int) Math.min((long) (c1952u.f5837c - i), j2);
            this.f5817e.update(c1952u.f5835a, i, min);
            j2 -= (long) min;
            c1952u = c1952u.f5840f;
            j = 0;
        }
    }

    /* renamed from: a */
    public final long mo8763a(C1939e c1939e, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j == 0) {
            return 0;
        } else {
            if (this.f5813a == 0) {
                long a;
                this.f5814b.mo9025a(10);
                byte b = this.f5814b.mo9027c().mo9048b(3);
                Object obj = ((b >> 1) & 1) == 1 ? 1 : null;
                if (obj != null) {
                    m5700a(this.f5814b.mo9027c(), 0, 10);
                }
                C1943l.m5699a("ID1ID2", 8075, this.f5814b.mo9033h());
                this.f5814b.mo9031f(8);
                if (((b >> 2) & 1) == 1) {
                    this.f5814b.mo9025a(2);
                    if (obj != null) {
                        m5700a(this.f5814b.mo9027c(), 0, 2);
                    }
                    short j2 = this.f5814b.mo9027c().mo9035j();
                    this.f5814b.mo9025a((long) j2);
                    if (obj != null) {
                        m5700a(this.f5814b.mo9027c(), 0, (long) j2);
                    }
                    this.f5814b.mo9031f((long) j2);
                }
                if (((b >> 3) & 1) == 1) {
                    a = this.f5814b.mo9024a((byte) 0);
                    if (a == -1) {
                        throw new EOFException();
                    }
                    if (obj != null) {
                        m5700a(this.f5814b.mo9027c(), 0, 1 + a);
                    }
                    this.f5814b.mo9031f(1 + a);
                }
                if (((b >> 4) & 1) == 1) {
                    a = this.f5814b.mo9024a((byte) 0);
                    if (a == -1) {
                        throw new EOFException();
                    }
                    if (obj != null) {
                        m5700a(this.f5814b.mo9027c(), 0, 1 + a);
                    }
                    this.f5814b.mo9031f(1 + a);
                }
                if (obj != null) {
                    C1943l.m5699a("FHCRC", this.f5814b.mo9035j(), (short) ((int) this.f5817e.getValue()));
                    this.f5817e.reset();
                }
                this.f5813a = 1;
            }
            if (this.f5813a == 1) {
                long j3 = c1939e.f5807b;
                long a2 = this.f5816d.mo8763a(c1939e, j);
                if (a2 != -1) {
                    m5700a(c1939e, j3, a2);
                    return a2;
                }
                this.f5813a = 2;
            }
            if (this.f5813a == 2) {
                C1943l.m5699a("CRC", this.f5814b.mo9036k(), (int) this.f5817e.getValue());
                C1943l.m5699a("ISIZE", this.f5814b.mo9036k(), this.f5815c.getTotalOut());
                this.f5813a = 3;
                if (!this.f5814b.mo9028e()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    /* renamed from: a */
    public final C1852y mo8764a() {
        return this.f5814b.mo8764a();
    }

    public final void close() {
        this.f5816d.close();
    }
}
