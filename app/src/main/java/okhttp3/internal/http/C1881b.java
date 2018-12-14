package okhttp3.internal.http;

import com.p070qq.p071e.comm.constants.ErrorCode.AdError;
import com.p070qq.p071e.comm.constants.ErrorCode.InitError;
import com.p070qq.p071e.comm.constants.ErrorCode.NetWorkError;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.C1791ab;
import okhttp3.C1791ab.C1790a;
import okhttp3.C1798e;
import okhttp3.C1923s;
import okhttp3.C1932y;
import okhttp3.C1932y.C1931a;

/* renamed from: okhttp3.internal.http.b */
public final class C1881b {
    /* renamed from: a */
    public final C1932y f5566a;
    /* renamed from: b */
    public final C1791ab f5567b;

    /* renamed from: okhttp3.internal.http.b$a */
    public static class C1880a {
        /* renamed from: a */
        final long f5554a;
        /* renamed from: b */
        final C1932y f5555b;
        /* renamed from: c */
        final C1791ab f5556c;
        /* renamed from: d */
        private Date f5557d;
        /* renamed from: e */
        private String f5558e;
        /* renamed from: f */
        private Date f5559f;
        /* renamed from: g */
        private String f5560g;
        /* renamed from: h */
        private Date f5561h;
        /* renamed from: i */
        private long f5562i;
        /* renamed from: j */
        private long f5563j;
        /* renamed from: k */
        private String f5564k;
        /* renamed from: l */
        private int f5565l = -1;

        public C1880a(long j, C1932y c1932y, C1791ab c1791ab) {
            this.f5554a = j;
            this.f5555b = c1932y;
            this.f5556c = c1791ab;
            if (c1791ab != null) {
                this.f5562i = c1791ab.mo8638i();
                this.f5563j = c1791ab.mo8639j();
                C1923s e = c1791ab.mo8634e();
                int a = e.mo8914a();
                for (int i = 0; i < a; i++) {
                    String a2 = e.mo8915a(i);
                    String b = e.mo8917b(i);
                    if ("Date".equalsIgnoreCase(a2)) {
                        this.f5557d = C1893f.m5369a(b);
                        this.f5558e = b;
                    } else if ("Expires".equalsIgnoreCase(a2)) {
                        this.f5561h = C1893f.m5369a(b);
                    } else if ("Last-Modified".equalsIgnoreCase(a2)) {
                        this.f5559f = C1893f.m5369a(b);
                        this.f5560g = b;
                    } else if ("ETag".equalsIgnoreCase(a2)) {
                        this.f5564k = b;
                    } else if ("Age".equalsIgnoreCase(a2)) {
                        this.f5565l = C1882c.m5323a(b, -1);
                    }
                }
            }
        }

        /* renamed from: a */
        private static boolean m5320a(C1932y c1932y) {
            return (c1932y.mo8963a("If-Modified-Since") == null && c1932y.mo8963a("If-None-Match") == null) ? false : true;
        }

        /* renamed from: a */
        public final C1881b mo8834a() {
            C1881b c1881b;
            if (this.f5556c == null) {
                c1881b = new C1881b(this.f5555b, null, (byte) 0);
            } else if (this.f5555b.mo8970g() && this.f5556c.mo8633d() == null) {
                c1881b = new C1881b(this.f5555b, null, (byte) 0);
            } else if (C1881b.m5322a(this.f5556c, this.f5555b)) {
                C1798e f = this.f5555b.mo8969f();
                if (f.mo8656a() || C1880a.m5320a(this.f5555b)) {
                    c1881b = new C1881b(this.f5555b, null, (byte) 0);
                } else {
                    long max = this.f5557d != null ? Math.max(0, this.f5563j - this.f5557d.getTime()) : 0;
                    if (this.f5565l != -1) {
                        max = Math.max(max, TimeUnit.SECONDS.toMillis((long) this.f5565l));
                    }
                    long j = (max + (this.f5563j - this.f5562i)) + (this.f5554a - this.f5563j);
                    C1798e h = this.f5556c.mo8637h();
                    if (h.mo8658c() != -1) {
                        max = TimeUnit.SECONDS.toMillis((long) h.mo8658c());
                    } else if (this.f5561h != null) {
                        max = this.f5561h.getTime() - (this.f5557d != null ? this.f5557d.getTime() : this.f5563j);
                        if (max <= 0) {
                            max = 0;
                        }
                    } else if (this.f5559f == null || this.f5556c.mo8629a().mo8964a().mo8594k() != null) {
                        max = 0;
                    } else {
                        max = (this.f5557d != null ? this.f5557d.getTime() : this.f5562i) - this.f5559f.getTime();
                        max = max > 0 ? max / 10 : 0;
                    }
                    if (f.mo8658c() != -1) {
                        max = Math.min(max, TimeUnit.SECONDS.toMillis((long) f.mo8658c()));
                    }
                    long j2 = 0;
                    if (f.mo8663h() != -1) {
                        j2 = TimeUnit.SECONDS.toMillis((long) f.mo8663h());
                    }
                    long j3 = 0;
                    C1798e h2 = this.f5556c.mo8637h();
                    if (!(h2.mo8661f() || f.mo8662g() == -1)) {
                        j3 = TimeUnit.SECONDS.toMillis((long) f.mo8662g());
                    }
                    if (h2.mo8656a() || j + j2 >= j3 + max) {
                        C1931a e = this.f5555b.mo8968e();
                        if (this.f5564k != null) {
                            e.mo8957a("If-None-Match", this.f5564k);
                        } else if (this.f5559f != null) {
                            e.mo8957a("If-Modified-Since", this.f5560g);
                        } else if (this.f5557d != null) {
                            e.mo8957a("If-Modified-Since", this.f5558e);
                        }
                        C1932y a = e.mo8961a();
                        c1881b = C1880a.m5320a(a) ? new C1881b(a, this.f5556c, (byte) 0) : new C1881b(a, null, (byte) 0);
                    } else {
                        C1790a g = this.f5556c.mo8636g();
                        if (j2 + j >= max) {
                            g.mo8617a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (j > 86400000) {
                            Object obj = (this.f5556c.mo8637h().mo8658c() == -1 && this.f5561h == null) ? 1 : null;
                            if (obj != null) {
                                g.mo8617a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                            }
                        }
                        c1881b = new C1881b(null, g.mo8624a(), (byte) 0);
                    }
                }
            } else {
                c1881b = new C1881b(this.f5555b, null, (byte) 0);
            }
            return (c1881b.f5566a == null || !this.f5555b.mo8969f().mo8664i()) ? c1881b : new C1881b(null, null, (byte) 0);
        }
    }

    private C1881b(C1932y c1932y, C1791ab c1791ab) {
        this.f5566a = c1932y;
        this.f5567b = c1791ab;
    }

    /* synthetic */ C1881b(C1932y c1932y, C1791ab c1791ab, byte b) {
        this(c1932y, c1791ab);
    }

    /* renamed from: a */
    public static boolean m5322a(C1791ab c1791ab, C1932y c1932y) {
        switch (c1791ab.mo8630b()) {
            case 200:
            case 203:
            case 204:
            case InitError.INIT_AD_ERROR /*300*/:
            case InitError.INIT_ADMANGER_ERROR /*301*/:
            case 308:
            case NetWorkError.TIME_OUT_ERROR /*404*/:
            case NetWorkError.RESOURCE_LOAD_FAIL_ERROR /*405*/:
            case 410:
            case 414:
            case AdError.NO_FILL_ERROR /*501*/:
                break;
            case InitError.INIT_PLUGIN_ERROR /*302*/:
            case 307:
                if (c1791ab.mo8628a("Expires") == null && c1791ab.mo8637h().mo8658c() == -1 && !c1791ab.mo8637h().mo8660e() && !c1791ab.mo8637h().mo8659d()) {
                    return false;
                }
            default:
                return false;
        }
        return (c1791ab.mo8637h().mo8657b() || c1932y.mo8969f().mo8657b()) ? false : true;
    }
}
