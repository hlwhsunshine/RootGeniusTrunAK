package okhttp3.internal.framed;

import okio.C1850x;
import okio.C1869j;
import okio.C1939e;

/* renamed from: okhttp3.internal.framed.u */
final class C1870u extends C1869j {
    /* renamed from: a */
    final /* synthetic */ C1868t f5534a;

    C1870u(C1868t c1868t, C1850x c1850x) {
        this.f5534a = c1868t;
        super(c1850x);
    }

    /* renamed from: a */
    public final long mo8763a(C1939e c1939e, long j) {
        if (this.f5534a.f5531b == 0) {
            return -1;
        }
        long a = super.mo8763a(c1939e, Math.min(j, (long) this.f5534a.f5531b));
        if (a == -1) {
            return -1;
        }
        this.f5534a.f5531b = (int) (((long) this.f5534a.f5531b) - a);
        return a;
    }
}
