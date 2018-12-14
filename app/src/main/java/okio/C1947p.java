package okio;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: okio.p */
final class C1947p implements C1850x {
    /* renamed from: a */
    final /* synthetic */ C1852y f5825a;
    /* renamed from: b */
    final /* synthetic */ InputStream f5826b;

    C1947p(C1852y c1852y, InputStream inputStream) {
        this.f5825a = c1852y;
        this.f5826b = inputStream;
    }

    /* renamed from: a */
    public final long mo8763a(C1939e c1939e, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        } else if (j == 0) {
            return 0;
        } else {
            try {
                this.f5825a.mo8774g();
                C1952u e = c1939e.mo9056e(1);
                int read = this.f5826b.read(e.f5835a, e.f5837c, (int) Math.min(j, (long) (8192 - e.f5837c)));
                if (read == -1) {
                    return -1;
                }
                e.f5837c += read;
                c1939e.f5807b += (long) read;
                return (long) read;
            } catch (AssertionError e2) {
                if (C1945n.m5710a(e2)) {
                    throw new IOException(e2);
                }
                throw e2;
            }
        }
    }

    /* renamed from: a */
    public final C1852y mo8764a() {
        return this.f5825a;
    }

    public final void close() {
        this.f5826b.close();
    }

    public final String toString() {
        return "source(" + this.f5826b + ")";
    }
}
