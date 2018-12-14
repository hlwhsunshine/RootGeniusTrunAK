package okio;

import java.io.IOException;

/* renamed from: okio.b */
final class C1934b implements C1823w {
    /* renamed from: a */
    final /* synthetic */ C1823w f5799a;
    /* renamed from: b */
    final /* synthetic */ C1853a f5800b;

    C1934b(C1853a c1853a, C1823w c1823w) {
        this.f5800b = c1853a;
        this.f5799a = c1823w;
    }

    /* renamed from: a */
    public final C1852y mo8703a() {
        return this.f5800b;
    }

    /* renamed from: a_ */
    public final void mo8704a_(C1939e c1939e, long j) {
        C1933aa.m5591a(c1939e.f5807b, 0, j);
        long j2 = j;
        while (j2 > 0) {
            C1952u c1952u = c1939e.f5806a;
            long j3 = 0;
            while (j3 < 65536) {
                j3 += (long) (c1939e.f5806a.f5837c - c1939e.f5806a.f5836b);
                if (j3 >= j2) {
                    j3 = j2;
                    break;
                }
            }
            this.f5800b.mo8780c();
            try {
                this.f5799a.mo8704a_(c1939e, j3);
                j2 -= j3;
                this.f5800b.mo8777a(true);
            } catch (IOException e) {
                throw this.f5800b.mo8779b(e);
            } catch (Throwable th) {
                this.f5800b.mo8777a(false);
            }
        }
    }

    public final void close() {
        this.f5800b.mo8780c();
        try {
            this.f5799a.close();
            this.f5800b.mo8777a(true);
        } catch (IOException e) {
            throw this.f5800b.mo8779b(e);
        } catch (Throwable th) {
            this.f5800b.mo8777a(false);
        }
    }

    public final void flush() {
        this.f5800b.mo8780c();
        try {
            this.f5799a.flush();
            this.f5800b.mo8777a(true);
        } catch (IOException e) {
            throw this.f5800b.mo8779b(e);
        } catch (Throwable th) {
            this.f5800b.mo8777a(false);
        }
    }

    public final String toString() {
        return "AsyncTimeout.sink(" + this.f5799a + ")";
    }
}
