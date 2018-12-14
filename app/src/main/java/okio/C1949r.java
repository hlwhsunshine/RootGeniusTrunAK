package okio;

import android.support.p015v4.media.session.PlaybackStateCompat;

/* renamed from: okio.r */
final class C1949r implements C1937g {
    /* renamed from: a */
    public final C1939e f5828a = new C1939e();
    /* renamed from: b */
    public final C1823w f5829b;
    /* renamed from: c */
    boolean f5830c;

    C1949r(C1823w c1823w) {
        if (c1823w == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.f5829b = c1823w;
    }

    /* renamed from: a */
    public final long mo9011a(C1850x c1850x) {
        if (c1850x == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long a = c1850x.mo8763a(this.f5828a, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (a == -1) {
                return j;
            }
            j += a;
            mo9023r();
        }
    }

    /* renamed from: a */
    public final C1852y mo8703a() {
        return this.f5829b.mo8703a();
    }

    /* renamed from: a_ */
    public final void mo8704a_(C1939e c1939e, long j) {
        if (this.f5830c) {
            throw new IllegalStateException("closed");
        }
        this.f5828a.mo8704a_(c1939e, j);
        mo9023r();
    }

    /* renamed from: b */
    public final C1937g mo9012b(String str) {
        if (this.f5830c) {
            throw new IllegalStateException("closed");
        }
        this.f5828a.mo9012b(str);
        return mo9023r();
    }

    /* renamed from: b */
    public final C1937g mo9013b(ByteString byteString) {
        if (this.f5830c) {
            throw new IllegalStateException("closed");
        }
        this.f5828a.mo9013b(byteString);
        return mo9023r();
    }

    /* renamed from: b */
    public final C1937g mo9014b(byte[] bArr) {
        if (this.f5830c) {
            throw new IllegalStateException("closed");
        }
        this.f5828a.mo9014b(bArr);
        return mo9023r();
    }

    /* renamed from: c */
    public final C1939e mo9015c() {
        return this.f5828a;
    }

    /* renamed from: c */
    public final C1937g mo9016c(byte[] bArr, int i, int i2) {
        if (this.f5830c) {
            throw new IllegalStateException("closed");
        }
        this.f5828a.mo9016c(bArr, i, i2);
        return mo9023r();
    }

    public final void close() {
        if (!this.f5830c) {
            Throwable th = null;
            try {
                if (this.f5828a.f5807b > 0) {
                    this.f5829b.mo8704a_(this.f5828a, this.f5828a.f5807b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f5829b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f5830c = true;
            if (th != null) {
                C1933aa.m5592a(th);
            }
        }
    }

    /* renamed from: d */
    public final C1937g mo9017d() {
        if (this.f5830c) {
            throw new IllegalStateException("closed");
        }
        long j = this.f5828a.f5807b;
        if (j > 0) {
            this.f5829b.mo8704a_(this.f5828a, j);
        }
        return this;
    }

    /* renamed from: f */
    public final C1937g mo9018f(int i) {
        if (this.f5830c) {
            throw new IllegalStateException("closed");
        }
        this.f5828a.mo9018f(i);
        return mo9023r();
    }

    public final void flush() {
        if (this.f5830c) {
            throw new IllegalStateException("closed");
        }
        if (this.f5828a.f5807b > 0) {
            this.f5829b.mo8704a_(this.f5828a, this.f5828a.f5807b);
        }
        this.f5829b.flush();
    }

    /* renamed from: g */
    public final C1937g mo9019g(int i) {
        if (this.f5830c) {
            throw new IllegalStateException("closed");
        }
        this.f5828a.mo9019g(i);
        return mo9023r();
    }

    /* renamed from: h */
    public final C1937g mo9020h(int i) {
        if (this.f5830c) {
            throw new IllegalStateException("closed");
        }
        this.f5828a.mo9020h(i);
        return mo9023r();
    }

    /* renamed from: i */
    public final C1937g mo9021i(long j) {
        if (this.f5830c) {
            throw new IllegalStateException("closed");
        }
        this.f5828a.mo9021i(j);
        return mo9023r();
    }

    /* renamed from: j */
    public final C1937g mo9022j(long j) {
        if (this.f5830c) {
            throw new IllegalStateException("closed");
        }
        this.f5828a.mo9022j(j);
        return mo9023r();
    }

    /* renamed from: r */
    public final C1937g mo9023r() {
        if (this.f5830c) {
            throw new IllegalStateException("closed");
        }
        C1939e c1939e = this.f5828a;
        long j = c1939e.f5807b;
        if (j == 0) {
            j = 0;
        } else {
            C1952u c1952u = c1939e.f5806a.f5841g;
            if (c1952u.f5837c < 8192 && c1952u.f5839e) {
                j -= (long) (c1952u.f5837c - c1952u.f5836b);
            }
        }
        if (j > 0) {
            this.f5829b.mo8704a_(this.f5828a, j);
        }
        return this;
    }

    public final String toString() {
        return "buffer(" + this.f5829b + ")";
    }
}
