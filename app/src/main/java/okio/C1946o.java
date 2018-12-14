package okio;

import java.io.OutputStream;

/* renamed from: okio.o */
final class C1946o implements C1823w {
    /* renamed from: a */
    final /* synthetic */ C1852y f5823a;
    /* renamed from: b */
    final /* synthetic */ OutputStream f5824b;

    C1946o(C1852y c1852y, OutputStream outputStream) {
        this.f5823a = c1852y;
        this.f5824b = outputStream;
    }

    /* renamed from: a */
    public final C1852y mo8703a() {
        return this.f5823a;
    }

    /* renamed from: a_ */
    public final void mo8704a_(C1939e c1939e, long j) {
        C1933aa.m5591a(c1939e.f5807b, 0, j);
        while (j > 0) {
            this.f5823a.mo8774g();
            C1952u c1952u = c1939e.f5806a;
            int min = (int) Math.min(j, (long) (c1952u.f5837c - c1952u.f5836b));
            this.f5824b.write(c1952u.f5835a, c1952u.f5836b, min);
            c1952u.f5836b += min;
            j -= (long) min;
            c1939e.f5807b -= (long) min;
            if (c1952u.f5836b == c1952u.f5837c) {
                c1939e.f5806a = c1952u.mo9083a();
                C1953v.m5757a(c1952u);
            }
        }
    }

    public final void close() {
        this.f5824b.close();
    }

    public final void flush() {
        this.f5824b.flush();
    }

    public final String toString() {
        return "sink(" + this.f5824b + ")";
    }
}
