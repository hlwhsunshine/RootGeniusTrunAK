package okhttp3;

import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.C1809k;
import okhttp3.internal.C1909l;
import okhttp3.internal.C1910m;
import okhttp3.internal.http.C1907s;
import okhttp3.internal.p122a.C1808c;

/* renamed from: okhttp3.i */
public final class C1804i {
    /* renamed from: c */
    static final /* synthetic */ boolean f5299c = (!C1804i.class.desiredAssertionStatus());
    /* renamed from: d */
    private static final Executor f5300d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C1910m.m5449a("OkHttp ConnectionPool"));
    /* renamed from: a */
    final C1909l f5301a;
    /* renamed from: b */
    boolean f5302b;
    /* renamed from: e */
    private final int f5303e;
    /* renamed from: f */
    private final long f5304f;
    /* renamed from: g */
    private final Runnable f5305g;
    /* renamed from: h */
    private final Deque<C1808c> f5306h;

    public C1804i() {
        this(TimeUnit.MINUTES);
    }

    private C1804i(TimeUnit timeUnit) {
        this.f5305g = new C1912j(this);
        this.f5306h = new ArrayDeque();
        this.f5301a = new C1909l();
        this.f5303e = 5;
        this.f5304f = timeUnit.toNanos(5);
        if (5 <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: 5");
        }
    }

    /* renamed from: a */
    final long mo8674a(long j) {
        C1808c c1808c = null;
        long j2 = Long.MIN_VALUE;
        synchronized (this) {
            long j3;
            int i = 0;
            int i2 = 0;
            for (C1808c c1808c2 : this.f5306h) {
                int i3;
                List list = c1808c2.f5315h;
                int i4 = 0;
                while (i4 < list.size()) {
                    if (((Reference) list.get(i4)).get() != null) {
                        i4++;
                    } else {
                        C1809k.m4984c().mo8687a(5, "A connection to " + c1808c2.mo8673a().f5265a.f5225a + " was leaked. Did you forget to close a response body?", null);
                        list.remove(i4);
                        c1808c2.f5316i = true;
                        if (list.isEmpty()) {
                            c1808c2.f5317j = j - this.f5304f;
                            i3 = 0;
                            break;
                        }
                    }
                }
                i3 = list.size();
                if (i3 > 0) {
                    i2++;
                } else {
                    C1808c c1808c3;
                    int i5 = i + 1;
                    long j4 = j - c1808c2.f5317j;
                    if (j4 > j2) {
                        long j5 = j4;
                        c1808c3 = c1808c2;
                        j3 = j5;
                    } else {
                        j3 = j2;
                        c1808c3 = c1808c;
                    }
                    j2 = j3;
                    c1808c = c1808c3;
                    i = i5;
                }
            }
            if (j2 >= this.f5304f || i > this.f5303e) {
                this.f5306h.remove(c1808c);
                C1910m.m5454a(c1808c.f5309b);
                return 0;
            } else if (i > 0) {
                j3 = this.f5304f - j2;
                return j3;
            } else if (i2 > 0) {
                j3 = this.f5304f;
                return j3;
            } else {
                this.f5302b = false;
                return -1;
            }
        }
    }

    /* renamed from: a */
    final C1808c mo8675a(C1787a c1787a, C1907s c1907s) {
        if (f5299c || Thread.holdsLock(this)) {
            for (C1808c c1808c : this.f5306h) {
                if (c1808c.f5315h.size() < c1808c.f5314g && c1787a.equals(c1808c.mo8673a().f5265a) && !c1808c.f5316i) {
                    c1907s.mo8867a(c1808c);
                    return c1808c;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    final void mo8676a(C1808c c1808c) {
        if (f5299c || Thread.holdsLock(this)) {
            if (!this.f5302b) {
                this.f5302b = true;
                f5300d.execute(this.f5305g);
            }
            this.f5306h.add(c1808c);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    final boolean mo8677b(C1808c c1808c) {
        if (!f5299c && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (c1808c.f5316i || this.f5303e == 0) {
            this.f5306h.remove(c1808c);
            return true;
        } else {
            notifyAll();
            return false;
        }
    }
}
