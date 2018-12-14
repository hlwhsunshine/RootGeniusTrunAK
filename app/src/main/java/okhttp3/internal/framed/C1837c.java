package okhttp3.internal.framed;

import android.support.p015v4.internal.view.SupportMenu;
import android.support.p015v4.view.ViewCompat;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.internal.C1835i;
import okhttp3.internal.C1910m;
import okhttp3.internal.framed.C1828a.C1827a;
import okio.ByteString;
import okio.C1937g;
import okio.C1938h;
import okio.C1939e;

/* renamed from: okhttp3.internal.framed.c */
public final class C1837c implements Closeable {
    /* renamed from: k */
    static final /* synthetic */ boolean f5392k = (!C1837c.class.desiredAssertionStatus());
    /* renamed from: l */
    private static final ExecutorService f5393l = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C1910m.m5449a("OkHttp FramedConnection"));
    /* renamed from: a */
    final Protocol f5394a;
    /* renamed from: b */
    final boolean f5395b;
    /* renamed from: c */
    long f5396c;
    /* renamed from: d */
    long f5397d;
    /* renamed from: e */
    C1875z f5398e;
    /* renamed from: f */
    final C1875z f5399f;
    /* renamed from: g */
    final C1832ab f5400g;
    /* renamed from: h */
    final Socket f5401h;
    /* renamed from: i */
    final C1830b f5402i;
    /* renamed from: j */
    final C1836c f5403j;
    /* renamed from: m */
    private final C1807b f5404m;
    /* renamed from: n */
    private final Map<Integer, C1856o> f5405n;
    /* renamed from: o */
    private final String f5406o;
    /* renamed from: p */
    private int f5407p;
    /* renamed from: q */
    private int f5408q;
    /* renamed from: r */
    private boolean f5409r;
    /* renamed from: s */
    private long f5410s;
    /* renamed from: t */
    private final ExecutorService f5411t;
    /* renamed from: u */
    private Map<Integer, C1872w> f5412u;
    /* renamed from: v */
    private final C1873x f5413v;
    /* renamed from: w */
    private int f5414w;
    /* renamed from: x */
    private boolean f5415x;
    /* renamed from: y */
    private final Set<Integer> f5416y;

    /* renamed from: okhttp3.internal.framed.c$b */
    public static abstract class C1807b {
        /* renamed from: a */
        public static final C1807b f5308a = new C1845k();

        /* renamed from: a */
        public void mo8679a(C1837c c1837c) {
        }

        /* renamed from: a */
        public abstract void mo8680a(C1856o c1856o);
    }

    /* renamed from: okhttp3.internal.framed.c$a */
    public static class C1834a {
        /* renamed from: a */
        private Socket f5381a;
        /* renamed from: b */
        private String f5382b;
        /* renamed from: c */
        private C1938h f5383c;
        /* renamed from: d */
        private C1937g f5384d;
        /* renamed from: e */
        private C1807b f5385e = C1807b.f5308a;
        /* renamed from: f */
        private Protocol f5386f = Protocol.SPDY_3;
        /* renamed from: g */
        private C1873x f5387g = C1873x.f5539a;
        /* renamed from: h */
        private boolean f5388h = true;

        /* renamed from: a */
        public final C1834a mo8745a(Socket socket, String str, C1938h c1938h, C1937g c1937g) {
            this.f5381a = socket;
            this.f5382b = str;
            this.f5383c = c1938h;
            this.f5384d = c1937g;
            return this;
        }

        /* renamed from: a */
        public final C1834a mo8746a(Protocol protocol) {
            this.f5386f = protocol;
            return this;
        }

        /* renamed from: a */
        public final C1834a mo8747a(C1807b c1807b) {
            this.f5385e = c1807b;
            return this;
        }

        /* renamed from: a */
        public final C1837c mo8748a() {
            return new C1837c(this, (byte) 0);
        }
    }

    /* renamed from: okhttp3.internal.framed.c$c */
    class C1836c extends C1835i implements C1827a {
        /* renamed from: b */
        final C1828a f5390b;

        private C1836c(C1828a c1828a) {
            super("OkHttp %s", r5.f5406o);
            this.f5390b = c1828a;
        }

        /* synthetic */ C1836c(C1837c c1837c, C1828a c1828a, byte b) {
            this(c1828a);
        }

        /* renamed from: a */
        protected final void mo8749a() {
            ErrorCode errorCode;
            Throwable th;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
            try {
                if (!C1837c.this.f5395b) {
                    this.f5390b.mo8728a();
                }
                do {
                } while (this.f5390b.mo8729a(this));
                try {
                    C1837c.this.m5119a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
                } catch (IOException e) {
                }
                C1910m.m5452a(this.f5390b);
            } catch (IOException e2) {
                errorCode = ErrorCode.PROTOCOL_ERROR;
                try {
                    C1837c.this.m5119a(errorCode, ErrorCode.PROTOCOL_ERROR);
                } catch (IOException e3) {
                }
                C1910m.m5452a(this.f5390b);
            } catch (Throwable th2) {
                th = th2;
                C1837c.this.m5119a(errorCode, errorCode3);
                C1910m.m5452a(this.f5390b);
                throw th;
            }
        }

        /* renamed from: a */
        public final void mo8720a(int i, long j) {
            if (i == 0) {
                synchronized (C1837c.this) {
                    C1837c c1837c = C1837c.this;
                    c1837c.f5397d += j;
                    C1837c.this.notifyAll();
                }
                return;
            }
            C1856o a = C1837c.this.mo8752a(i);
            if (a != null) {
                synchronized (a) {
                    a.mo8784a(j);
                }
            }
        }

        /* renamed from: a */
        public final void mo8721a(int i, List<C1857p> list) {
            C1837c.m5121a(C1837c.this, i, (List) list);
        }

        /* renamed from: a */
        public final void mo8722a(int i, ErrorCode errorCode) {
            if (C1837c.m5128a(C1837c.this, i)) {
                C1837c.m5123a(C1837c.this, i, errorCode);
                return;
            }
            C1856o b = C1837c.this.mo8758b(i);
            if (b != null) {
                b.mo8790c(errorCode);
            }
        }

        /* renamed from: a */
        public final void mo8723a(int i, ByteString byteString) {
            byteString.size();
            synchronized (C1837c.this) {
                C1856o[] c1856oArr = (C1856o[]) C1837c.this.f5405n.values().toArray(new C1856o[C1837c.this.f5405n.size()]);
                C1837c.this.f5409r = true;
            }
            for (C1856o c1856o : c1856oArr) {
                if (c1856o.mo8783a() > i && c1856o.mo8791c()) {
                    c1856o.mo8790c(ErrorCode.REFUSED_STREAM);
                    C1837c.this.mo8758b(c1856o.mo8783a());
                }
            }
        }

        /* renamed from: a */
        public final void mo8724a(boolean z, int i, int i2) {
            if (z) {
                C1872w c = C1837c.this.m5133c(i);
                if (c != null) {
                    c.mo8813b();
                    return;
                }
                return;
            }
            C1837c.m5120a(C1837c.this, i, i2);
        }

        /* renamed from: a */
        public final void mo8725a(boolean z, int i, C1938h c1938h, int i2) {
            if (C1837c.m5128a(C1837c.this, i)) {
                C1837c.m5124a(C1837c.this, i, c1938h, i2, z);
                return;
            }
            C1856o a = C1837c.this.mo8752a(i);
            if (a == null) {
                C1837c.this.mo8755a(i, ErrorCode.INVALID_STREAM);
                c1938h.mo9031f((long) i2);
                return;
            }
            a.mo8787a(c1938h, i2);
            if (z) {
                a.mo8797i();
            }
        }

        /* renamed from: a */
        public final void mo8726a(boolean z, C1875z c1875z) {
            int e;
            C1856o[] c1856oArr;
            long j;
            synchronized (C1837c.this) {
                int i;
                e = C1837c.this.f5399f.mo8828e();
                if (z) {
                    C1837c.this.f5399f.mo8820a();
                }
                C1875z c1875z2 = C1837c.this.f5399f;
                for (i = 0; i < 10; i++) {
                    if (c1875z.mo8821a(i)) {
                        c1875z2.mo8819a(i, c1875z.mo8825c(i), c1875z.mo8823b(i));
                    }
                }
                if (C1837c.this.f5394a == Protocol.HTTP_2) {
                    C1837c.f5393l.execute(new C1848n(this, "OkHttp %s ACK Settings", new Object[]{C1837c.this.f5406o}, c1875z));
                }
                i = C1837c.this.f5399f.mo8828e();
                if (i == -1 || i == e) {
                    c1856oArr = null;
                    j = 0;
                } else {
                    long j2 = (long) (i - e);
                    if (!C1837c.this.f5415x) {
                        C1837c c1837c = C1837c.this;
                        c1837c.f5397d += j2;
                        if (j2 > 0) {
                            c1837c.notifyAll();
                        }
                        C1837c.this.f5415x = true;
                    }
                    if (C1837c.this.f5405n.isEmpty()) {
                        j = j2;
                        c1856oArr = null;
                    } else {
                        j = j2;
                        c1856oArr = (C1856o[]) C1837c.this.f5405n.values().toArray(new C1856o[C1837c.this.f5405n.size()]);
                    }
                }
                C1837c.f5393l.execute(new C1847m(this, "OkHttp %s settings", C1837c.this.f5406o));
            }
            if (c1856oArr != null && j != 0) {
                for (C1856o c1856o : c1856oArr) {
                    synchronized (c1856o) {
                        c1856o.mo8784a(j);
                    }
                }
            }
        }

        /* JADX WARNING: Missing block: B:29:0x0092, code:
            if (r13.failIfStreamPresent() == false) goto L_0x00a0;
     */
        /* JADX WARNING: Missing block: B:30:0x0094, code:
            r0.mo8788b(okhttp3.internal.framed.ErrorCode.PROTOCOL_ERROR);
            r8.f5391c.mo8758b(r11);
     */
        /* JADX WARNING: Missing block: B:31:0x00a0, code:
            r0.mo8785a((java.util.List) r12, r13);
     */
        /* JADX WARNING: Missing block: B:32:0x00a3, code:
            if (r10 == false) goto L_?;
     */
        /* JADX WARNING: Missing block: B:33:0x00a5, code:
            r0.mo8797i();
     */
        /* JADX WARNING: Missing block: B:35:?, code:
            return;
     */
        /* JADX WARNING: Missing block: B:36:?, code:
            return;
     */
        /* JADX WARNING: Missing block: B:37:?, code:
            return;
     */
        /* renamed from: a */
        public final void mo8727a(boolean r9, boolean r10, int r11, java.util.List<okhttp3.internal.framed.C1857p> r12, okhttp3.internal.framed.HeadersMode r13) {
            /*
            r8 = this;
            r0 = okhttp3.internal.framed.C1837c.this;
            r0 = okhttp3.internal.framed.C1837c.m5128a(r0, r11);
            if (r0 == 0) goto L_0x000e;
        L_0x0008:
            r0 = okhttp3.internal.framed.C1837c.this;
            okhttp3.internal.framed.C1837c.m5122a(r0, r11, r12, r10);
        L_0x000d:
            return;
        L_0x000e:
            r6 = okhttp3.internal.framed.C1837c.this;
            monitor-enter(r6);
            r0 = okhttp3.internal.framed.C1837c.this;	 Catch:{ all -> 0x001b }
            r0 = r0.f5409r;	 Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x001e;
        L_0x0019:
            monitor-exit(r6);	 Catch:{ all -> 0x001b }
            goto L_0x000d;
        L_0x001b:
            r0 = move-exception;
            monitor-exit(r6);	 Catch:{ all -> 0x001b }
            throw r0;
        L_0x001e:
            r0 = okhttp3.internal.framed.C1837c.this;	 Catch:{ all -> 0x001b }
            r0 = r0.mo8752a(r11);	 Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x008d;
        L_0x0026:
            r0 = r13.failIfStreamAbsent();	 Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0035;
        L_0x002c:
            r0 = okhttp3.internal.framed.C1837c.this;	 Catch:{ all -> 0x001b }
            r1 = okhttp3.internal.framed.ErrorCode.INVALID_STREAM;	 Catch:{ all -> 0x001b }
            r0.mo8755a(r11, r1);	 Catch:{ all -> 0x001b }
            monitor-exit(r6);	 Catch:{ all -> 0x001b }
            goto L_0x000d;
        L_0x0035:
            r0 = okhttp3.internal.framed.C1837c.this;	 Catch:{ all -> 0x001b }
            r0 = r0.f5407p;	 Catch:{ all -> 0x001b }
            if (r11 > r0) goto L_0x003f;
        L_0x003d:
            monitor-exit(r6);	 Catch:{ all -> 0x001b }
            goto L_0x000d;
        L_0x003f:
            r0 = r11 % 2;
            r1 = okhttp3.internal.framed.C1837c.this;	 Catch:{ all -> 0x001b }
            r1 = r1.f5408q;	 Catch:{ all -> 0x001b }
            r1 = r1 % 2;
            if (r0 != r1) goto L_0x004d;
        L_0x004b:
            monitor-exit(r6);	 Catch:{ all -> 0x001b }
            goto L_0x000d;
        L_0x004d:
            r0 = new okhttp3.internal.framed.o;	 Catch:{ all -> 0x001b }
            r2 = okhttp3.internal.framed.C1837c.this;	 Catch:{ all -> 0x001b }
            r1 = r11;
            r3 = r9;
            r4 = r10;
            r5 = r12;
            r0.<init>(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x001b }
            r1 = okhttp3.internal.framed.C1837c.this;	 Catch:{ all -> 0x001b }
            r1.f5407p = r11;	 Catch:{ all -> 0x001b }
            r1 = okhttp3.internal.framed.C1837c.this;	 Catch:{ all -> 0x001b }
            r1 = r1.f5405n;	 Catch:{ all -> 0x001b }
            r2 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x001b }
            r1.put(r2, r0);	 Catch:{ all -> 0x001b }
            r1 = okhttp3.internal.framed.C1837c.f5393l;	 Catch:{ all -> 0x001b }
            r2 = new okhttp3.internal.framed.l;	 Catch:{ all -> 0x001b }
            r3 = "OkHttp %s stream %d";
            r4 = 2;
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x001b }
            r5 = 0;
            r7 = okhttp3.internal.framed.C1837c.this;	 Catch:{ all -> 0x001b }
            r7 = r7.f5406o;	 Catch:{ all -> 0x001b }
            r4[r5] = r7;	 Catch:{ all -> 0x001b }
            r5 = 1;
            r7 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x001b }
            r4[r5] = r7;	 Catch:{ all -> 0x001b }
            r2.<init>(r8, r3, r4, r0);	 Catch:{ all -> 0x001b }
            r1.execute(r2);	 Catch:{ all -> 0x001b }
            monitor-exit(r6);	 Catch:{ all -> 0x001b }
            goto L_0x000d;
        L_0x008d:
            monitor-exit(r6);	 Catch:{ all -> 0x001b }
            r1 = r13.failIfStreamPresent();
            if (r1 == 0) goto L_0x00a0;
        L_0x0094:
            r1 = okhttp3.internal.framed.ErrorCode.PROTOCOL_ERROR;
            r0.mo8788b(r1);
            r0 = okhttp3.internal.framed.C1837c.this;
            r0.mo8758b(r11);
            goto L_0x000d;
        L_0x00a0:
            r0.mo8785a(r12, r13);
            if (r10 == 0) goto L_0x000d;
        L_0x00a5:
            r0.mo8797i();
            goto L_0x000d;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.framed.c.c.a(boolean, boolean, int, java.util.List, okhttp3.internal.framed.HeadersMode):void");
        }
    }

    private C1837c(C1834a c1834a) {
        int i = 2;
        this.f5405n = new HashMap();
        this.f5410s = System.nanoTime();
        this.f5396c = 0;
        this.f5398e = new C1875z();
        this.f5399f = new C1875z();
        this.f5415x = false;
        this.f5416y = new LinkedHashSet();
        this.f5394a = c1834a.f5386f;
        this.f5413v = c1834a.f5387g;
        this.f5395b = c1834a.f5388h;
        this.f5404m = c1834a.f5385e;
        this.f5408q = c1834a.f5388h ? 1 : 2;
        if (c1834a.f5388h && this.f5394a == Protocol.HTTP_2) {
            this.f5408q += 2;
        }
        if (c1834a.f5388h) {
            i = 1;
        }
        this.f5414w = i;
        if (c1834a.f5388h) {
            this.f5398e.mo8819a(7, 0, ViewCompat.MEASURED_STATE_TOO_SMALL);
        }
        this.f5406o = c1834a.f5382b;
        if (this.f5394a == Protocol.HTTP_2) {
            this.f5400g = new C1865r();
            this.f5411t = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), C1910m.m5449a(C1910m.m5445a("OkHttp %s Push Observer", this.f5406o)));
            this.f5399f.mo8819a(7, 0, SupportMenu.USER_MASK);
            this.f5399f.mo8819a(5, 0, 16384);
        } else if (this.f5394a == Protocol.SPDY_3) {
            this.f5400g = new C1833aa();
            this.f5411t = null;
        } else {
            throw new AssertionError(this.f5394a);
        }
        this.f5397d = (long) this.f5399f.mo8828e();
        this.f5401h = c1834a.f5381a;
        this.f5402i = this.f5400g.mo8744a(c1834a.f5384d, this.f5395b);
        this.f5403j = new C1836c(this, this.f5400g.mo8743a(c1834a.f5383c, this.f5395b), (byte) 0);
    }

    /* synthetic */ C1837c(C1834a c1834a, byte b) {
        this(c1834a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00b4 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00ae  */
    /* renamed from: a */
    private void m5119a(okhttp3.internal.framed.ErrorCode r8, okhttp3.internal.framed.ErrorCode r9) {
        /*
        r7 = this;
        r3 = 0;
        r2 = 0;
        r0 = f5392k;
        if (r0 != 0) goto L_0x0012;
    L_0x0006:
        r0 = java.lang.Thread.holdsLock(r7);
        if (r0 == 0) goto L_0x0012;
    L_0x000c:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0012:
        r1 = r7.f5402i;	 Catch:{ IOException -> 0x0087 }
        monitor-enter(r1);	 Catch:{ IOException -> 0x0087 }
        monitor-enter(r7);	 Catch:{ all -> 0x0084 }
        r0 = r7.f5409r;	 Catch:{ all -> 0x0081 }
        if (r0 == 0) goto L_0x0071;
    L_0x001a:
        monitor-exit(r7);	 Catch:{ all -> 0x0081 }
        monitor-exit(r1);	 Catch:{ all -> 0x0084 }
        r1 = r2;
    L_0x001d:
        monitor-enter(r7);
        r0 = r7.f5405n;	 Catch:{ all -> 0x008a }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x008a }
        if (r0 != 0) goto L_0x00b9;
    L_0x0026:
        r0 = r7.f5405n;	 Catch:{ all -> 0x008a }
        r0 = r0.values();	 Catch:{ all -> 0x008a }
        r4 = r7.f5405n;	 Catch:{ all -> 0x008a }
        r4 = r4.size();	 Catch:{ all -> 0x008a }
        r4 = new okhttp3.internal.framed.C1856o[r4];	 Catch:{ all -> 0x008a }
        r0 = r0.toArray(r4);	 Catch:{ all -> 0x008a }
        r0 = (okhttp3.internal.framed.C1856o[]) r0;	 Catch:{ all -> 0x008a }
        r4 = r7.f5405n;	 Catch:{ all -> 0x008a }
        r4.clear();	 Catch:{ all -> 0x008a }
        r4 = 0;
        r7.m5127a(r4);	 Catch:{ all -> 0x008a }
        r5 = r0;
    L_0x0044:
        r0 = r7.f5412u;	 Catch:{ all -> 0x008a }
        if (r0 == 0) goto L_0x00b7;
    L_0x0048:
        r0 = r7.f5412u;	 Catch:{ all -> 0x008a }
        r0 = r0.values();	 Catch:{ all -> 0x008a }
        r2 = r7.f5412u;	 Catch:{ all -> 0x008a }
        r2 = r2.size();	 Catch:{ all -> 0x008a }
        r2 = new okhttp3.internal.framed.C1872w[r2];	 Catch:{ all -> 0x008a }
        r0 = r0.toArray(r2);	 Catch:{ all -> 0x008a }
        r0 = (okhttp3.internal.framed.C1872w[]) r0;	 Catch:{ all -> 0x008a }
        r2 = 0;
        r7.f5412u = r2;	 Catch:{ all -> 0x008a }
        r4 = r0;
    L_0x0060:
        monitor-exit(r7);	 Catch:{ all -> 0x008a }
        if (r5 == 0) goto L_0x0093;
    L_0x0063:
        r6 = r5.length;
        r2 = r3;
        r0 = r1;
    L_0x0066:
        if (r2 >= r6) goto L_0x0092;
    L_0x0068:
        r1 = r5[r2];
        r1.mo8786a(r9);	 Catch:{ IOException -> 0x008d }
    L_0x006d:
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x0066;
    L_0x0071:
        r0 = 1;
        r7.f5409r = r0;	 Catch:{ all -> 0x0081 }
        r0 = r7.f5407p;	 Catch:{ all -> 0x0081 }
        monitor-exit(r7);	 Catch:{ all -> 0x0081 }
        r4 = r7.f5402i;	 Catch:{ all -> 0x0084 }
        r5 = okhttp3.internal.C1910m.f5674a;	 Catch:{ all -> 0x0084 }
        r4.mo8734a(r0, r8, r5);	 Catch:{ all -> 0x0084 }
        monitor-exit(r1);	 Catch:{ all -> 0x0084 }
        r1 = r2;
        goto L_0x001d;
    L_0x0081:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x0081 }
        throw r0;	 Catch:{ all -> 0x0084 }
    L_0x0084:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0084 }
        throw r0;	 Catch:{ IOException -> 0x0087 }
    L_0x0087:
        r0 = move-exception;
        r1 = r0;
        goto L_0x001d;
    L_0x008a:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x008a }
        throw r0;
    L_0x008d:
        r1 = move-exception;
        if (r0 == 0) goto L_0x006d;
    L_0x0090:
        r0 = r1;
        goto L_0x006d;
    L_0x0092:
        r1 = r0;
    L_0x0093:
        if (r4 == 0) goto L_0x00a1;
    L_0x0095:
        r2 = r4.length;
        r0 = r3;
    L_0x0097:
        if (r0 >= r2) goto L_0x00a1;
    L_0x0099:
        r3 = r4[r0];
        r3.mo8814c();
        r0 = r0 + 1;
        goto L_0x0097;
    L_0x00a1:
        r0 = r7.f5402i;	 Catch:{ IOException -> 0x00af }
        r0.close();	 Catch:{ IOException -> 0x00af }
        r0 = r1;
    L_0x00a7:
        r1 = r7.f5401h;	 Catch:{ IOException -> 0x00b5 }
        r1.close();	 Catch:{ IOException -> 0x00b5 }
    L_0x00ac:
        if (r0 == 0) goto L_0x00b4;
    L_0x00ae:
        throw r0;
    L_0x00af:
        r0 = move-exception;
        if (r1 == 0) goto L_0x00a7;
    L_0x00b2:
        r0 = r1;
        goto L_0x00a7;
    L_0x00b4:
        return;
    L_0x00b5:
        r0 = move-exception;
        goto L_0x00ac;
    L_0x00b7:
        r4 = r2;
        goto L_0x0060;
    L_0x00b9:
        r5 = r2;
        goto L_0x0044;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.framed.c.a(okhttp3.internal.framed.ErrorCode, okhttp3.internal.framed.ErrorCode):void");
    }

    /* renamed from: a */
    private synchronized void m5127a(boolean z) {
        this.f5410s = z ? System.nanoTime() : Long.MAX_VALUE;
    }

    /* renamed from: b */
    private C1856o m5130b(List<C1857p> list, boolean z) {
        C1856o c1856o;
        Object obj = null;
        boolean z2 = !z;
        synchronized (this.f5402i) {
            int i;
            synchronized (this) {
                if (this.f5409r) {
                    throw new IOException("shutdown");
                }
                i = this.f5408q;
                this.f5408q += 2;
                c1856o = new C1856o(i, this, z2, false, list);
                if (!z || this.f5397d == 0 || c1856o.f5471b == 0) {
                    obj = 1;
                }
                if (c1856o.mo8789b()) {
                    this.f5405n.put(Integer.valueOf(i), c1856o);
                    m5127a(false);
                }
            }
            this.f5402i.mo8737a(z2, i, (List) list);
        }
        if (obj != null) {
            this.f5402i.mo8739b();
        }
        return c1856o;
    }

    /* renamed from: c */
    private synchronized C1872w m5133c(int i) {
        return this.f5412u != null ? (C1872w) this.f5412u.remove(Integer.valueOf(i)) : null;
    }

    /* renamed from: a */
    public final Protocol mo8751a() {
        return this.f5394a;
    }

    /* renamed from: a */
    final synchronized C1856o mo8752a(int i) {
        return (C1856o) this.f5405n.get(Integer.valueOf(i));
    }

    /* renamed from: a */
    public final C1856o mo8753a(List<C1857p> list, boolean z) {
        return m5130b((List) list, z);
    }

    /* renamed from: a */
    final void mo8754a(int i, long j) {
        f5393l.execute(new C1839e(this, "OkHttp Window Update %s stream %d", new Object[]{this.f5406o, Integer.valueOf(i)}, i, j));
    }

    /* renamed from: a */
    final void mo8755a(int i, ErrorCode errorCode) {
        f5393l.submit(new C1838d(this, "OkHttp %s stream %d", new Object[]{this.f5406o, Integer.valueOf(i)}, i, errorCode));
    }

    /* renamed from: a */
    public final void mo8756a(int i, boolean z, C1939e c1939e, long j) {
        if (j == 0) {
            this.f5402i.mo8738a(z, i, c1939e, 0);
            return;
        }
        while (j > 0) {
            int min;
            synchronized (this) {
                while (this.f5397d <= 0) {
                    try {
                        if (this.f5405n.containsKey(Integer.valueOf(i))) {
                            wait();
                        } else {
                            throw new IOException("stream closed");
                        }
                    } catch (InterruptedException e) {
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j, this.f5397d), this.f5402i.mo8741c());
                this.f5397d -= (long) min;
            }
            j -= (long) min;
            C1830b c1830b = this.f5402i;
            boolean z2 = z && j == 0;
            c1830b.mo8738a(z2, i, c1939e, min);
        }
    }

    /* renamed from: b */
    public final synchronized int mo8757b() {
        return this.f5399f.mo8826d();
    }

    /* renamed from: b */
    final synchronized C1856o mo8758b(int i) {
        C1856o c1856o;
        c1856o = (C1856o) this.f5405n.remove(Integer.valueOf(i));
        if (c1856o != null && this.f5405n.isEmpty()) {
            m5127a(true);
        }
        notifyAll();
        return c1856o;
    }

    /* renamed from: b */
    final void mo8759b(int i, ErrorCode errorCode) {
        this.f5402i.mo8733a(i, errorCode);
    }

    /* renamed from: c */
    public final void mo8760c() {
        this.f5402i.mo8739b();
    }

    public final void close() {
        m5119a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    /* renamed from: d */
    public final void mo8762d() {
        this.f5402i.mo8731a();
        this.f5402i.mo8740b(this.f5398e);
        int e = this.f5398e.mo8828e();
        if (e != 65536) {
            this.f5402i.mo8732a(0, (long) (e - 65536));
        }
        new Thread(this.f5403j).start();
    }
}
