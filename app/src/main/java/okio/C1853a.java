package okio;

import java.io.IOException;
import java.io.InterruptedIOException;

/* renamed from: okio.a */
public class C1853a extends C1852y {
    /* renamed from: a */
    private static C1853a f5464a;
    /* renamed from: c */
    private boolean f5465c;
    /* renamed from: d */
    private C1853a f5466d;
    /* renamed from: e */
    private long f5467e;

    /* renamed from: okio.a$a */
    private static final class C1854a extends Thread {
        public C1854a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        public final void run() {
            while (true) {
                try {
                    C1853a e = C1853a.m5191e();
                    if (e != null) {
                        e.mo8776a();
                    }
                } catch (InterruptedException e2) {
                }
            }
        }
    }

    /* renamed from: a */
    private static synchronized void m5189a(C1853a c1853a, long j, boolean z) {
        synchronized (C1853a.class) {
            if (f5464a == null) {
                f5464a = new C1853a();
                new C1854a().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                c1853a.f5467e = Math.min(j, c1853a.mo8771d() - nanoTime) + nanoTime;
            } else if (j != 0) {
                c1853a.f5467e = nanoTime + j;
            } else if (z) {
                c1853a.f5467e = c1853a.mo8771d();
            } else {
                throw new AssertionError();
            }
            long j2 = c1853a.f5467e - nanoTime;
            C1853a c1853a2 = f5464a;
            while (c1853a2.f5466d != null && j2 >= c1853a2.f5466d.f5467e - nanoTime) {
                c1853a2 = c1853a2.f5466d;
            }
            c1853a.f5466d = c1853a2.f5466d;
            c1853a2.f5466d = c1853a;
            if (c1853a2 == f5464a) {
                C1853a.class.notify();
            }
        }
    }

    /* renamed from: a */
    private static synchronized boolean m5190a(C1853a c1853a) {
        boolean z;
        synchronized (C1853a.class) {
            for (C1853a c1853a2 = f5464a; c1853a2 != null; c1853a2 = c1853a2.f5466d) {
                if (c1853a2.f5466d == c1853a) {
                    c1853a2.f5466d = c1853a.f5466d;
                    c1853a.f5466d = null;
                    z = false;
                    break;
                }
            }
            z = true;
        }
        return z;
    }

    /* renamed from: e */
    static synchronized C1853a m5191e() {
        C1853a c1853a = null;
        synchronized (C1853a.class) {
            C1853a c1853a2 = f5464a.f5466d;
            if (c1853a2 == null) {
                C1853a.class.wait();
            } else {
                long nanoTime = c1853a2.f5467e - System.nanoTime();
                if (nanoTime > 0) {
                    long j = nanoTime / 1000000;
                    C1853a.class.wait(j, (int) (nanoTime - (1000000 * j)));
                } else {
                    f5464a.f5466d = c1853a2.f5466d;
                    c1853a2.f5466d = null;
                    c1853a = c1853a2;
                }
            }
        }
        return c1853a;
    }

    /* renamed from: a */
    protected IOException mo8775a(IOException iOException) {
        IOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* renamed from: a */
    protected void mo8776a() {
    }

    /* renamed from: a */
    final void mo8777a(boolean z) {
        if (mo8778a_() && z) {
            throw mo8775a(null);
        }
    }

    /* renamed from: a_ */
    public final boolean mo8778a_() {
        if (!this.f5465c) {
            return false;
        }
        this.f5465c = false;
        return C1853a.m5190a(this);
    }

    /* renamed from: b */
    final IOException mo8779b(IOException iOException) {
        return !mo8778a_() ? iOException : mo8775a(iOException);
    }

    /* renamed from: c */
    public final void mo8780c() {
        if (this.f5465c) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long b_ = mo8769b_();
        boolean c_ = mo8770c_();
        if (b_ != 0 || c_) {
            this.f5465c = true;
            C1853a.m5189a(this, b_, c_);
        }
    }
}
