package okio;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: okio.y */
public class C1852y {
    /* renamed from: b */
    public static final C1852y f5460b = new C1954z();
    /* renamed from: a */
    private boolean f5461a;
    /* renamed from: c */
    private long f5462c;
    /* renamed from: d */
    private long f5463d;

    /* renamed from: a */
    public C1852y mo8767a(long j) {
        this.f5461a = true;
        this.f5462c = j;
        return this;
    }

    /* renamed from: a */
    public C1852y mo8768a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: " + j);
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            this.f5463d = timeUnit.toNanos(j);
            return this;
        }
    }

    /* renamed from: b_ */
    public long mo8769b_() {
        return this.f5463d;
    }

    /* renamed from: c_ */
    public boolean mo8770c_() {
        return this.f5461a;
    }

    /* renamed from: d */
    public long mo8771d() {
        if (this.f5461a) {
            return this.f5462c;
        }
        throw new IllegalStateException("No deadline");
    }

    /* renamed from: d_ */
    public C1852y mo8772d_() {
        this.f5463d = 0;
        return this;
    }

    /* renamed from: f */
    public C1852y mo8773f() {
        this.f5461a = false;
        return this;
    }

    /* renamed from: g */
    public void mo8774g() {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.f5461a && this.f5462c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
