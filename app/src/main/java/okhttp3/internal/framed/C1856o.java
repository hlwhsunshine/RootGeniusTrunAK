package okhttp3.internal.framed;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okio.C1823w;
import okio.C1850x;
import okio.C1852y;
import okio.C1853a;
import okio.C1938h;
import okio.C1939e;

/* renamed from: okhttp3.internal.framed.o */
public final class C1856o {
    /* renamed from: d */
    static final /* synthetic */ boolean f5469d = (!C1856o.class.desiredAssertionStatus());
    /* renamed from: a */
    long f5470a = 0;
    /* renamed from: b */
    long f5471b;
    /* renamed from: c */
    final C1849a f5472c;
    /* renamed from: e */
    private final int f5473e;
    /* renamed from: f */
    private final C1837c f5474f;
    /* renamed from: g */
    private final List<C1857p> f5475g;
    /* renamed from: h */
    private List<C1857p> f5476h;
    /* renamed from: i */
    private final C1851b f5477i;
    /* renamed from: j */
    private final C1855c f5478j = new C1855c();
    /* renamed from: k */
    private final C1855c f5479k = new C1855c();
    /* renamed from: l */
    private ErrorCode f5480l = null;

    /* renamed from: okhttp3.internal.framed.o$a */
    final class C1849a implements C1823w {
        /* renamed from: a */
        static final /* synthetic */ boolean f5448a = (!C1856o.class.desiredAssertionStatus());
        /* renamed from: c */
        private final C1939e f5450c = new C1939e();
        /* renamed from: d */
        private boolean f5451d;
        /* renamed from: e */
        private boolean f5452e;

        C1849a() {
        }

        /* renamed from: a */
        private void m5166a(boolean z) {
            long min;
            synchronized (C1856o.this) {
                C1856o.this.f5479k.mo8780c();
                while (C1856o.this.f5471b <= 0 && !this.f5452e && !this.f5451d && C1856o.this.f5480l == null) {
                    try {
                        C1856o.this.m5210j();
                    } catch (Throwable th) {
                        C1856o.this.f5479k.mo8782b();
                    }
                }
                C1856o.this.f5479k.mo8782b();
                C1856o.m5209h(C1856o.this);
                min = Math.min(C1856o.this.f5471b, this.f5450c.mo9049b());
                C1856o c1856o = C1856o.this;
                c1856o.f5471b -= min;
            }
            C1856o.this.f5479k.mo8780c();
            try {
                C1837c a = C1856o.this.f5474f;
                int b = C1856o.this.f5473e;
                boolean z2 = z && min == this.f5450c.mo9049b();
                a.mo8756a(b, z2, this.f5450c, min);
            } finally {
                C1856o.this.f5479k.mo8782b();
            }
        }

        /* renamed from: a */
        public final C1852y mo8703a() {
            return C1856o.this.f5479k;
        }

        /* renamed from: a_ */
        public final void mo8704a_(C1939e c1939e, long j) {
            if (f5448a || !Thread.holdsLock(C1856o.this)) {
                this.f5450c.mo8704a_(c1939e, j);
                while (this.f5450c.mo9049b() >= 16384) {
                    m5166a(false);
                }
                return;
            }
            throw new AssertionError();
        }

        /* JADX WARNING: Missing block: B:14:0x0025, code:
            if (r6.f5449b.f5472c.f5452e != false) goto L_0x0052;
     */
        /* JADX WARNING: Missing block: B:16:0x002f, code:
            if (r6.f5450c.mo9049b() <= 0) goto L_0x0042;
     */
        /* JADX WARNING: Missing block: B:18:0x0039, code:
            if (r6.f5450c.mo9049b() <= 0) goto L_0x0052;
     */
        /* JADX WARNING: Missing block: B:19:0x003b, code:
            m5166a(true);
     */
        /* JADX WARNING: Missing block: B:24:0x0042, code:
            okhttp3.internal.framed.C1856o.m5201a(r6.f5449b).mo8756a(okhttp3.internal.framed.C1856o.m5202b(r6.f5449b), true, null, 0);
     */
        /* JADX WARNING: Missing block: B:25:0x0052, code:
            r1 = r6.f5449b;
     */
        /* JADX WARNING: Missing block: B:26:0x0054, code:
            monitor-enter(r1);
     */
        /* JADX WARNING: Missing block: B:29:?, code:
            r6.f5451d = true;
     */
        /* JADX WARNING: Missing block: B:30:0x0058, code:
            monitor-exit(r1);
     */
        /* JADX WARNING: Missing block: B:31:0x0059, code:
            okhttp3.internal.framed.C1856o.m5201a(r6.f5449b).mo8760c();
            okhttp3.internal.framed.C1856o.m5207f(r6.f5449b);
     */
        /* JADX WARNING: Missing block: B:44:?, code:
            return;
     */
        public final void close() {
            /*
            r6 = this;
            r4 = 0;
            r2 = 1;
            r0 = f5448a;
            if (r0 != 0) goto L_0x0015;
        L_0x0007:
            r0 = okhttp3.internal.framed.C1856o.this;
            r0 = java.lang.Thread.holdsLock(r0);
            if (r0 == 0) goto L_0x0015;
        L_0x000f:
            r0 = new java.lang.AssertionError;
            r0.<init>();
            throw r0;
        L_0x0015:
            r1 = okhttp3.internal.framed.C1856o.this;
            monitor-enter(r1);
            r0 = r6.f5451d;	 Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x001e;
        L_0x001c:
            monitor-exit(r1);	 Catch:{ all -> 0x003f }
        L_0x001d:
            return;
        L_0x001e:
            monitor-exit(r1);	 Catch:{ all -> 0x003f }
            r0 = okhttp3.internal.framed.C1856o.this;
            r0 = r0.f5472c;
            r0 = r0.f5452e;
            if (r0 != 0) goto L_0x0052;
        L_0x0027:
            r0 = r6.f5450c;
            r0 = r0.mo9049b();
            r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
            if (r0 <= 0) goto L_0x0042;
        L_0x0031:
            r0 = r6.f5450c;
            r0 = r0.mo9049b();
            r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
            if (r0 <= 0) goto L_0x0052;
        L_0x003b:
            r6.m5166a(r2);
            goto L_0x0031;
        L_0x003f:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x003f }
            throw r0;
        L_0x0042:
            r0 = okhttp3.internal.framed.C1856o.this;
            r0 = r0.f5474f;
            r1 = okhttp3.internal.framed.C1856o.this;
            r1 = r1.f5473e;
            r3 = 0;
            r0.mo8756a(r1, r2, r3, r4);
        L_0x0052:
            r1 = okhttp3.internal.framed.C1856o.this;
            monitor-enter(r1);
            r0 = 1;
            r6.f5451d = r0;	 Catch:{ all -> 0x0068 }
            monitor-exit(r1);	 Catch:{ all -> 0x0068 }
            r0 = okhttp3.internal.framed.C1856o.this;
            r0 = r0.f5474f;
            r0.mo8760c();
            r0 = okhttp3.internal.framed.C1856o.this;
            okhttp3.internal.framed.C1856o.m5207f(r0);
            goto L_0x001d;
        L_0x0068:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0068 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.framed.o.a.close():void");
        }

        public final void flush() {
            if (f5448a || !Thread.holdsLock(C1856o.this)) {
                synchronized (C1856o.this) {
                    C1856o.m5209h(C1856o.this);
                }
                while (this.f5450c.mo9049b() > 0) {
                    m5166a(false);
                    C1856o.this.f5474f.mo8760c();
                }
                return;
            }
            throw new AssertionError();
        }
    }

    /* renamed from: okhttp3.internal.framed.o$b */
    private final class C1851b implements C1850x {
        /* renamed from: a */
        static final /* synthetic */ boolean f5453a = (!C1856o.class.desiredAssertionStatus());
        /* renamed from: c */
        private final C1939e f5455c;
        /* renamed from: d */
        private final C1939e f5456d;
        /* renamed from: e */
        private final long f5457e;
        /* renamed from: f */
        private boolean f5458f;
        /* renamed from: g */
        private boolean f5459g;

        private C1851b(long j) {
            this.f5455c = new C1939e();
            this.f5456d = new C1939e();
            this.f5457e = j;
        }

        /* synthetic */ C1851b(C1856o c1856o, long j, byte b) {
            this(j);
        }

        /* renamed from: b */
        private void m5176b() {
            C1856o.this.f5478j.mo8780c();
            while (this.f5456d.mo9049b() == 0 && !this.f5459g && !this.f5458f && C1856o.this.f5480l == null) {
                try {
                    C1856o.this.m5210j();
                } catch (Throwable th) {
                    C1856o.this.f5478j.mo8782b();
                }
            }
            C1856o.this.f5478j.mo8782b();
        }

        /* renamed from: a */
        public final long mo8763a(C1939e c1939e, long j) {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            long j2;
            synchronized (C1856o.this) {
                m5176b();
                if (this.f5458f) {
                    throw new IOException("stream closed");
                } else if (C1856o.this.f5480l != null) {
                    throw new StreamResetException(C1856o.this.f5480l);
                } else if (this.f5456d.mo9049b() == 0) {
                    j2 = -1;
                } else {
                    j2 = this.f5456d.mo8763a(c1939e, Math.min(j, this.f5456d.mo9049b()));
                    C1856o c1856o = C1856o.this;
                    c1856o.f5470a += j2;
                    if (C1856o.this.f5470a >= ((long) (C1856o.this.f5474f.f5398e.mo8828e() / 2))) {
                        C1856o.this.f5474f.mo8754a(C1856o.this.f5473e, C1856o.this.f5470a);
                        C1856o.this.f5470a = 0;
                    }
                    synchronized (C1856o.this.f5474f) {
                        C1837c a = C1856o.this.f5474f;
                        a.f5396c += j2;
                        if (C1856o.this.f5474f.f5396c >= ((long) (C1856o.this.f5474f.f5398e.mo8828e() / 2))) {
                            C1856o.this.f5474f.mo8754a(0, C1856o.this.f5474f.f5396c);
                            C1856o.this.f5474f.f5396c = 0;
                        }
                    }
                }
            }
            return j2;
        }

        /* renamed from: a */
        public final C1852y mo8764a() {
            return C1856o.this.f5478j;
        }

        /* renamed from: a */
        final void mo8766a(C1938h c1938h, long j) {
            if (f5453a || !Thread.holdsLock(C1856o.this)) {
                while (j > 0) {
                    boolean z;
                    Object obj;
                    synchronized (C1856o.this) {
                        z = this.f5459g;
                        obj = this.f5456d.mo9049b() + j > this.f5457e ? 1 : null;
                    }
                    if (obj != null) {
                        c1938h.mo9031f(j);
                        C1856o.this.mo8788b(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        c1938h.mo9031f(j);
                        return;
                    } else {
                        long a = c1938h.mo8763a(this.f5455c, j);
                        if (a == -1) {
                            throw new EOFException();
                        }
                        j -= a;
                        synchronized (C1856o.this) {
                            obj = this.f5456d.mo9049b() == 0 ? 1 : null;
                            this.f5456d.mo9011a(this.f5455c);
                            if (obj != null) {
                                C1856o.this.notifyAll();
                            }
                        }
                    }
                }
                return;
            }
            throw new AssertionError();
        }

        public final void close() {
            synchronized (C1856o.this) {
                this.f5458f = true;
                this.f5456d.mo9063q();
                C1856o.this.notifyAll();
            }
            C1856o.m5207f(C1856o.this);
        }
    }

    /* renamed from: okhttp3.internal.framed.o$c */
    class C1855c extends C1853a {
        C1855c() {
        }

        /* renamed from: a */
        protected final IOException mo8775a(IOException iOException) {
            IOException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* renamed from: a */
        protected final void mo8776a() {
            C1856o.this.mo8788b(ErrorCode.CANCEL);
        }

        /* renamed from: b */
        public final void mo8782b() {
            if (mo8778a_()) {
                throw mo8775a(null);
            }
        }
    }

    C1856o(int i, C1837c c1837c, boolean z, boolean z2, List<C1857p> list) {
        if (c1837c == null) {
            throw new NullPointerException("connection == null");
        } else if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        } else {
            this.f5473e = i;
            this.f5474f = c1837c;
            this.f5471b = (long) c1837c.f5399f.mo8828e();
            this.f5477i = new C1851b(this, (long) c1837c.f5398e.mo8828e(), (byte) 0);
            this.f5472c = new C1849a();
            this.f5477i.f5459g = z2;
            this.f5472c.f5452e = z;
            this.f5475g = list;
        }
    }

    /* renamed from: d */
    private boolean m5205d(ErrorCode errorCode) {
        if (f5469d || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.f5480l != null) {
                    return false;
                } else if (this.f5477i.f5459g && this.f5472c.f5452e) {
                    return false;
                } else {
                    this.f5480l = errorCode;
                    notifyAll();
                    this.f5474f.mo8758b(this.f5473e);
                    return true;
                }
            }
        }
        throw new AssertionError();
    }

    /* renamed from: f */
    static /* synthetic */ void m5207f(C1856o c1856o) {
        if (f5469d || !Thread.holdsLock(c1856o)) {
            Object obj;
            boolean b;
            synchronized (c1856o) {
                obj = (!c1856o.f5477i.f5459g && c1856o.f5477i.f5458f && (c1856o.f5472c.f5452e || c1856o.f5472c.f5451d)) ? 1 : null;
                b = c1856o.mo8789b();
            }
            if (obj != null) {
                c1856o.mo8786a(ErrorCode.CANCEL);
                return;
            } else if (!b) {
                c1856o.f5474f.mo8758b(c1856o.f5473e);
                return;
            } else {
                return;
            }
        }
        throw new AssertionError();
    }

    /* renamed from: h */
    static /* synthetic */ void m5209h(C1856o c1856o) {
        if (c1856o.f5472c.f5451d) {
            throw new IOException("stream closed");
        } else if (c1856o.f5472c.f5452e) {
            throw new IOException("stream finished");
        } else if (c1856o.f5480l != null) {
            throw new StreamResetException(c1856o.f5480l);
        }
    }

    /* renamed from: j */
    private void m5210j() {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new InterruptedIOException();
        }
    }

    /* renamed from: a */
    public final int mo8783a() {
        return this.f5473e;
    }

    /* renamed from: a */
    final void mo8784a(long j) {
        this.f5471b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* renamed from: a */
    final void mo8785a(List<C1857p> list, HeadersMode headersMode) {
        if (f5469d || !Thread.holdsLock(this)) {
            ErrorCode errorCode = null;
            boolean z = true;
            synchronized (this) {
                if (this.f5476h == null) {
                    if (headersMode.failIfHeadersAbsent()) {
                        errorCode = ErrorCode.PROTOCOL_ERROR;
                    } else {
                        this.f5476h = list;
                        z = mo8789b();
                        notifyAll();
                    }
                } else if (headersMode.failIfHeadersPresent()) {
                    errorCode = ErrorCode.STREAM_IN_USE;
                } else {
                    List arrayList = new ArrayList();
                    arrayList.addAll(this.f5476h);
                    arrayList.addAll(list);
                    this.f5476h = arrayList;
                }
            }
            if (errorCode != null) {
                mo8788b(errorCode);
                return;
            } else if (!z) {
                this.f5474f.mo8758b(this.f5473e);
                return;
            } else {
                return;
            }
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public final void mo8786a(ErrorCode errorCode) {
        if (m5205d(errorCode)) {
            this.f5474f.mo8759b(this.f5473e, errorCode);
        }
    }

    /* renamed from: a */
    final void mo8787a(C1938h c1938h, int i) {
        if (f5469d || !Thread.holdsLock(this)) {
            this.f5477i.mo8766a(c1938h, (long) i);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: b */
    public final void mo8788b(ErrorCode errorCode) {
        if (m5205d(errorCode)) {
            this.f5474f.mo8755a(this.f5473e, errorCode);
        }
    }

    /* renamed from: b */
    public final synchronized boolean mo8789b() {
        boolean z = false;
        synchronized (this) {
            if (this.f5480l == null) {
                if (!(this.f5477i.f5459g || this.f5477i.f5458f) || (!(this.f5472c.f5452e || this.f5472c.f5451d) || this.f5476h == null)) {
                    z = true;
                }
            }
        }
        return z;
    }

    /* renamed from: c */
    final synchronized void mo8790c(ErrorCode errorCode) {
        if (this.f5480l == null) {
            this.f5480l = errorCode;
            notifyAll();
        }
    }

    /* renamed from: c */
    public final boolean mo8791c() {
        return this.f5474f.f5395b == ((this.f5473e & 1) == 1);
    }

    /* renamed from: d */
    public final synchronized List<C1857p> mo8792d() {
        this.f5478j.mo8780c();
        while (this.f5476h == null && this.f5480l == null) {
            try {
                m5210j();
            } catch (Throwable th) {
                this.f5478j.mo8782b();
            }
        }
        this.f5478j.mo8782b();
        if (this.f5476h != null) {
        } else {
            throw new StreamResetException(this.f5480l);
        }
        return this.f5476h;
    }

    /* renamed from: e */
    public final C1852y mo8793e() {
        return this.f5478j;
    }

    /* renamed from: f */
    public final C1852y mo8794f() {
        return this.f5479k;
    }

    /* renamed from: g */
    public final C1850x mo8795g() {
        return this.f5477i;
    }

    /* renamed from: h */
    public final C1823w mo8796h() {
        synchronized (this) {
            if (this.f5476h != null || mo8791c()) {
            } else {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f5472c;
    }

    /* renamed from: i */
    final void mo8797i() {
        if (f5469d || !Thread.holdsLock(this)) {
            boolean b;
            synchronized (this) {
                this.f5477i.f5459g = true;
                b = mo8789b();
                notifyAll();
            }
            if (!b) {
                this.f5474f.mo8758b(this.f5473e);
                return;
            }
            return;
        }
        throw new AssertionError();
    }
}
