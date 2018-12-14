package okhttp3;

import com.p070qq.p071e.comm.constants.ErrorCode.InitError;
import java.io.Closeable;
import okhttp3.C1923s.C1922a;

/* renamed from: okhttp3.ab */
public final class C1791ab implements Closeable {
    /* renamed from: a */
    private final C1932y f5252a;
    /* renamed from: b */
    private final Protocol f5253b;
    /* renamed from: c */
    private final int f5254c;
    /* renamed from: d */
    private final String f5255d;
    /* renamed from: e */
    private final C1921r f5256e;
    /* renamed from: f */
    private final C1923s f5257f;
    /* renamed from: g */
    private final C1792ac f5258g;
    /* renamed from: h */
    private final C1791ab f5259h;
    /* renamed from: i */
    private final C1791ab f5260i;
    /* renamed from: j */
    private final C1791ab f5261j;
    /* renamed from: k */
    private final long f5262k;
    /* renamed from: l */
    private final long f5263l;
    /* renamed from: m */
    private volatile C1798e f5264m;

    /* renamed from: okhttp3.ab$a */
    public static class C1790a {
        /* renamed from: a */
        private C1932y f5240a;
        /* renamed from: b */
        private Protocol f5241b;
        /* renamed from: c */
        private int f5242c;
        /* renamed from: d */
        private String f5243d;
        /* renamed from: e */
        private C1921r f5244e;
        /* renamed from: f */
        private C1922a f5245f;
        /* renamed from: g */
        private C1792ac f5246g;
        /* renamed from: h */
        private C1791ab f5247h;
        /* renamed from: i */
        private C1791ab f5248i;
        /* renamed from: j */
        private C1791ab f5249j;
        /* renamed from: k */
        private long f5250k;
        /* renamed from: l */
        private long f5251l;

        public C1790a() {
            this.f5242c = -1;
            this.f5245f = new C1922a();
        }

        private C1790a(C1791ab c1791ab) {
            this.f5242c = -1;
            this.f5240a = c1791ab.f5252a;
            this.f5241b = c1791ab.f5253b;
            this.f5242c = c1791ab.f5254c;
            this.f5243d = c1791ab.f5255d;
            this.f5244e = c1791ab.f5256e;
            this.f5245f = c1791ab.f5257f.mo8919b();
            this.f5246g = c1791ab.f5258g;
            this.f5247h = c1791ab.f5259h;
            this.f5248i = c1791ab.f5260i;
            this.f5249j = c1791ab.f5261j;
            this.f5250k = c1791ab.f5262k;
            this.f5251l = c1791ab.f5263l;
        }

        /* synthetic */ C1790a(C1791ab c1791ab, byte b) {
            this(c1791ab);
        }

        /* renamed from: a */
        private static void m4888a(String str, C1791ab c1791ab) {
            if (c1791ab.f5258g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (c1791ab.f5259h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (c1791ab.f5260i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (c1791ab.f5261j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        /* renamed from: a */
        public final C1790a mo8614a(int i) {
            this.f5242c = i;
            return this;
        }

        /* renamed from: a */
        public final C1790a mo8615a(long j) {
            this.f5250k = j;
            return this;
        }

        /* renamed from: a */
        public final C1790a mo8616a(String str) {
            this.f5243d = str;
            return this;
        }

        /* renamed from: a */
        public final C1790a mo8617a(String str, String str2) {
            this.f5245f.mo8910a(str, str2);
            return this;
        }

        /* renamed from: a */
        public final C1790a mo8618a(Protocol protocol) {
            this.f5241b = protocol;
            return this;
        }

        /* renamed from: a */
        public final C1790a mo8619a(C1791ab c1791ab) {
            if (c1791ab != null) {
                C1790a.m4888a("networkResponse", c1791ab);
            }
            this.f5247h = c1791ab;
            return this;
        }

        /* renamed from: a */
        public final C1790a mo8620a(C1792ac c1792ac) {
            this.f5246g = c1792ac;
            return this;
        }

        /* renamed from: a */
        public final C1790a mo8621a(C1921r c1921r) {
            this.f5244e = c1921r;
            return this;
        }

        /* renamed from: a */
        public final C1790a mo8622a(C1923s c1923s) {
            this.f5245f = c1923s.mo8919b();
            return this;
        }

        /* renamed from: a */
        public final C1790a mo8623a(C1932y c1932y) {
            this.f5240a = c1932y;
            return this;
        }

        /* renamed from: a */
        public final C1791ab mo8624a() {
            if (this.f5240a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f5241b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f5242c >= 0) {
                return new C1791ab(this, (byte) 0);
            } else {
                throw new IllegalStateException("code < 0: " + this.f5242c);
            }
        }

        /* renamed from: b */
        public final C1790a mo8625b(long j) {
            this.f5251l = j;
            return this;
        }

        /* renamed from: b */
        public final C1790a mo8626b(C1791ab c1791ab) {
            if (c1791ab != null) {
                C1790a.m4888a("cacheResponse", c1791ab);
            }
            this.f5248i = c1791ab;
            return this;
        }

        /* renamed from: c */
        public final C1790a mo8627c(C1791ab c1791ab) {
            if (c1791ab == null || c1791ab.f5258g == null) {
                this.f5249j = c1791ab;
                return this;
            }
            throw new IllegalArgumentException("priorResponse.body != null");
        }
    }

    private C1791ab(C1790a c1790a) {
        this.f5252a = c1790a.f5240a;
        this.f5253b = c1790a.f5241b;
        this.f5254c = c1790a.f5242c;
        this.f5255d = c1790a.f5243d;
        this.f5256e = c1790a.f5244e;
        this.f5257f = c1790a.f5245f.mo8911a();
        this.f5258g = c1790a.f5246g;
        this.f5259h = c1790a.f5247h;
        this.f5260i = c1790a.f5248i;
        this.f5261j = c1790a.f5249j;
        this.f5262k = c1790a.f5250k;
        this.f5263l = c1790a.f5251l;
    }

    /* synthetic */ C1791ab(C1790a c1790a, byte b) {
        this(c1790a);
    }

    /* renamed from: a */
    public final String mo8628a(String str) {
        String a = this.f5257f.mo8916a(str);
        return a != null ? a : null;
    }

    /* renamed from: a */
    public final C1932y mo8629a() {
        return this.f5252a;
    }

    /* renamed from: b */
    public final int mo8630b() {
        return this.f5254c;
    }

    /* renamed from: c */
    public final boolean mo8631c() {
        return this.f5254c >= 200 && this.f5254c < InitError.INIT_AD_ERROR;
    }

    public final void close() {
        this.f5258g.close();
    }

    /* renamed from: d */
    public final C1921r mo8633d() {
        return this.f5256e;
    }

    /* renamed from: e */
    public final C1923s mo8634e() {
        return this.f5257f;
    }

    /* renamed from: f */
    public final C1792ac mo8635f() {
        return this.f5258g;
    }

    /* renamed from: g */
    public final C1790a mo8636g() {
        return new C1790a(this, (byte) 0);
    }

    /* renamed from: h */
    public final C1798e mo8637h() {
        C1798e c1798e = this.f5264m;
        if (c1798e != null) {
            return c1798e;
        }
        c1798e = C1798e.m4949a(this.f5257f);
        this.f5264m = c1798e;
        return c1798e;
    }

    /* renamed from: i */
    public final long mo8638i() {
        return this.f5262k;
    }

    /* renamed from: j */
    public final long mo8639j() {
        return this.f5263l;
    }

    public final String toString() {
        return "Response{protocol=" + this.f5253b + ", code=" + this.f5254c + ", message=" + this.f5255d + ", url=" + this.f5252a.mo8964a() + '}';
    }
}
