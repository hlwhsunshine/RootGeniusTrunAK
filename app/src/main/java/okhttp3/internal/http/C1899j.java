package okhttp3.internal.http;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.C1910m;
import okio.C1850x;
import okio.C1852y;
import okio.C1937g;
import okio.C1938h;
import okio.C1939e;

/* renamed from: okhttp3.internal.http.j */
final class C1899j implements C1850x {
    /* renamed from: a */
    boolean f5634a;
    /* renamed from: b */
    final /* synthetic */ C1938h f5635b;
    /* renamed from: c */
    final /* synthetic */ C1879a f5636c;
    /* renamed from: d */
    final /* synthetic */ C1937g f5637d;
    /* renamed from: e */
    final /* synthetic */ C1897h f5638e;

    C1899j(C1897h c1897h, C1938h c1938h, C1879a c1879a, C1937g c1937g) {
        this.f5638e = c1897h;
        this.f5635b = c1938h;
        this.f5636c = c1879a;
        this.f5637d = c1937g;
    }

    /* renamed from: a */
    public final long mo8763a(C1939e c1939e, long j) {
        try {
            long a = this.f5635b.mo8763a(c1939e, j);
            if (a == -1) {
                if (!this.f5634a) {
                    this.f5634a = true;
                    this.f5637d.close();
                }
                return -1;
            }
            c1939e.mo9046a(this.f5637d.mo9015c(), c1939e.mo9049b() - a, a);
            this.f5637d.mo9023r();
            return a;
        } catch (IOException e) {
            if (!this.f5634a) {
                this.f5634a = true;
            }
            throw e;
        }
    }

    /* renamed from: a */
    public final C1852y mo8764a() {
        return this.f5635b.mo8764a();
    }

    public final void close() {
        if (!(this.f5634a || C1910m.m5458a((C1850x) this, TimeUnit.MILLISECONDS))) {
            this.f5634a = true;
        }
        this.f5635b.close();
    }
}
