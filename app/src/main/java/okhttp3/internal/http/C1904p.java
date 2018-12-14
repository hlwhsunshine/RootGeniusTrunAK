package okhttp3.internal.http;

import java.net.ProtocolException;
import okhttp3.internal.C1910m;
import okio.C1823w;
import okio.C1852y;
import okio.C1939e;

/* renamed from: okhttp3.internal.http.p */
public final class C1904p implements C1823w {
    /* renamed from: a */
    private boolean f5646a;
    /* renamed from: b */
    private final int f5647b;
    /* renamed from: c */
    private final C1939e f5648c;

    public C1904p() {
        this(-1);
    }

    public C1904p(int i) {
        this.f5648c = new C1939e();
        this.f5647b = i;
    }

    /* renamed from: a */
    public final C1852y mo8703a() {
        return C1852y.f5460b;
    }

    /* renamed from: a */
    public final void mo8858a(C1823w c1823w) {
        C1939e c1939e = new C1939e();
        this.f5648c.mo9046a(c1939e, 0, this.f5648c.mo9049b());
        c1823w.mo8704a_(c1939e, c1939e.mo9049b());
    }

    /* renamed from: a_ */
    public final void mo8704a_(C1939e c1939e, long j) {
        if (this.f5646a) {
            throw new IllegalStateException("closed");
        }
        C1910m.m5451a(c1939e.mo9049b(), j);
        if (this.f5647b == -1 || this.f5648c.mo9049b() <= ((long) this.f5647b) - j) {
            this.f5648c.mo8704a_(c1939e, j);
            return;
        }
        throw new ProtocolException("exceeded content-length limit of " + this.f5647b + " bytes");
    }

    /* renamed from: b */
    public final long mo8859b() {
        return this.f5648c.mo9049b();
    }

    public final void close() {
        if (!this.f5646a) {
            this.f5646a = true;
            if (this.f5648c.mo9049b() < ((long) this.f5647b)) {
                throw new ProtocolException("content-length promised " + this.f5647b + " bytes, but received " + this.f5648c.mo9049b());
            }
        }
    }

    public final void flush() {
    }
}
