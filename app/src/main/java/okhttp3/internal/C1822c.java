package okhttp3.internal;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import okhttp3.internal.p122a.C1805a;
import okio.C1823w;
import okio.C1937g;

/* renamed from: okhttp3.internal.c */
public final class C1822c implements Closeable, Flushable {
    /* renamed from: a */
    static final Pattern f5356a = Pattern.compile("[a-z0-9_-]{1,120}");
    /* renamed from: b */
    static final /* synthetic */ boolean f5357b = (!C1822c.class.desiredAssertionStatus());
    /* renamed from: o */
    private static final C1823w f5358o = new C1824d();
    /* renamed from: c */
    private final C1805a f5359c;
    /* renamed from: d */
    private long f5360d;
    /* renamed from: e */
    private final int f5361e;
    /* renamed from: f */
    private long f5362f;
    /* renamed from: g */
    private C1937g f5363g;
    /* renamed from: h */
    private final LinkedHashMap<String, C1821b> f5364h;
    /* renamed from: i */
    private int f5365i;
    /* renamed from: j */
    private boolean f5366j;
    /* renamed from: k */
    private boolean f5367k;
    /* renamed from: l */
    private boolean f5368l;
    /* renamed from: m */
    private final Executor f5369m;
    /* renamed from: n */
    private final Runnable f5370n;

    /* renamed from: okhttp3.internal.c$a */
    public final class C1820a {
        /* renamed from: a */
        final /* synthetic */ C1822c f5347a;
        /* renamed from: b */
        private final C1821b f5348b;
        /* renamed from: c */
        private boolean f5349c;

        /* renamed from: a */
        final void mo8698a() {
            if (this.f5348b.f5355f == this) {
                for (int i = 0; i < this.f5347a.f5361e; i++) {
                    try {
                        this.f5347a.f5359c.mo8678a(this.f5348b.f5353d[i]);
                    } catch (IOException e) {
                    }
                }
                this.f5348b.f5355f = null;
            }
        }

        /* renamed from: b */
        public final void mo8699b() {
            synchronized (this.f5347a) {
                if (this.f5349c) {
                    throw new IllegalStateException();
                }
                if (this.f5348b.f5355f == this) {
                    this.f5347a.m5035a(this);
                }
                this.f5349c = true;
            }
        }
    }

    /* renamed from: okhttp3.internal.c$b */
    private final class C1821b {
        /* renamed from: a */
        private final String f5350a;
        /* renamed from: b */
        private final long[] f5351b;
        /* renamed from: c */
        private final File[] f5352c;
        /* renamed from: d */
        private final File[] f5353d;
        /* renamed from: e */
        private boolean f5354e;
        /* renamed from: f */
        private C1820a f5355f;

        /* renamed from: a */
        final void mo8700a(C1937g c1937g) {
            for (long j : this.f5351b) {
                c1937g.mo9020h(32).mo9022j(j);
            }
        }
    }

    /* renamed from: a */
    private synchronized void m5035a(C1820a c1820a) {
        C1821b a = c1820a.f5348b;
        if (a.f5355f != c1820a) {
            throw new IllegalStateException();
        }
        for (int i = 0; i < this.f5361e; i++) {
            this.f5359c.mo8678a(a.f5353d[i]);
        }
        this.f5365i++;
        a.f5355f = null;
        if ((a.f5354e | 0) != 0) {
            a.f5354e = true;
            this.f5363g.mo9012b("CLEAN").mo9020h(32);
            this.f5363g.mo9012b(a.f5350a);
            a.mo8700a(this.f5363g);
            this.f5363g.mo9020h(10);
        } else {
            this.f5364h.remove(a.f5350a);
            this.f5363g.mo9012b("REMOVE").mo9020h(32);
            this.f5363g.mo9012b(a.f5350a);
            this.f5363g.mo9020h(10);
        }
        this.f5363g.flush();
        if (this.f5362f > this.f5360d || m5037a()) {
            this.f5369m.execute(this.f5370n);
        }
    }

    /* renamed from: a */
    private boolean m5037a() {
        return this.f5365i >= 2000 && this.f5365i >= this.f5364h.size();
    }

    /* renamed from: b */
    private synchronized boolean m5039b() {
        return this.f5367k;
    }

    /* renamed from: c */
    private synchronized void m5040c() {
        if (m5039b()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* renamed from: d */
    private void m5041d() {
        while (this.f5362f > this.f5360d) {
            C1821b c1821b = (C1821b) this.f5364h.values().iterator().next();
            if (c1821b.f5355f != null) {
                c1821b.f5355f.mo8698a();
            }
            for (int i = 0; i < this.f5361e; i++) {
                this.f5359c.mo8678a(c1821b.f5352c[i]);
                this.f5362f -= c1821b.f5351b[i];
                c1821b.f5351b[i] = 0;
            }
            this.f5365i++;
            this.f5363g.mo9012b("REMOVE").mo9020h(32).mo9012b(c1821b.f5350a).mo9020h(10);
            this.f5364h.remove(c1821b.f5350a);
            if (m5037a()) {
                this.f5369m.execute(this.f5370n);
            }
        }
        this.f5368l = false;
    }

    public final synchronized void close() {
        if (!this.f5366j || this.f5367k) {
            this.f5367k = true;
        } else {
            for (C1821b c1821b : (C1821b[]) this.f5364h.values().toArray(new C1821b[this.f5364h.size()])) {
                if (c1821b.f5355f != null) {
                    c1821b.f5355f.mo8699b();
                }
            }
            m5041d();
            this.f5363g.close();
            this.f5363g = null;
            this.f5367k = true;
        }
    }

    public final synchronized void flush() {
        if (this.f5366j) {
            m5040c();
            m5041d();
            this.f5363g.flush();
        }
    }
}
