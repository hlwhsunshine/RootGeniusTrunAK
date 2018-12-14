package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.C1029c.C1025a;
import com.nostra13.universalimageloader.core.assist.C1013c;
import com.nostra13.universalimageloader.core.assist.FailReason.FailType;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme;
import com.nostra13.universalimageloader.core.p065a.C1006b;
import com.nostra13.universalimageloader.core.p065a.C1008c;
import com.nostra13.universalimageloader.core.p067c.C1026a;
import com.nostra13.universalimageloader.core.p068d.C1030a;
import com.nostra13.universalimageloader.core.p068d.C1031b;
import com.nostra13.universalimageloader.p064b.C0998b.C0997a;
import com.nostra13.universalimageloader.p064b.C0999c;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

final class LoadAndDisplayImageTask implements C0997a, Runnable {
    /* renamed from: a */
    final String f2484a;
    /* renamed from: b */
    final C1026a f2485b;
    /* renamed from: c */
    final C1029c f2486c;
    /* renamed from: d */
    final C1030a f2487d;
    /* renamed from: e */
    final C1031b f2488e;
    /* renamed from: f */
    private final C1042f f2489f;
    /* renamed from: g */
    private final C1044h f2490g;
    /* renamed from: h */
    private final Handler f2491h;
    /* renamed from: i */
    private final C1041e f2492i;
    /* renamed from: j */
    private final ImageDownloader f2493j;
    /* renamed from: k */
    private final ImageDownloader f2494k;
    /* renamed from: l */
    private final ImageDownloader f2495l;
    /* renamed from: m */
    private final C1006b f2496m;
    /* renamed from: n */
    private final String f2497n;
    /* renamed from: o */
    private final C1013c f2498o;
    /* renamed from: p */
    private final boolean f2499p;
    /* renamed from: q */
    private LoadedFrom f2500q = LoadedFrom.NETWORK;

    class TaskCancelledException extends Exception {
        TaskCancelledException() {
        }
    }

    public LoadAndDisplayImageTask(C1042f c1042f, C1044h c1044h, Handler handler) {
        this.f2489f = c1042f;
        this.f2490g = c1044h;
        this.f2491h = handler;
        this.f2492i = c1042f.f2650a;
        this.f2493j = this.f2492i.f2645p;
        this.f2494k = this.f2492i.f2648s;
        this.f2495l = this.f2492i.f2649t;
        this.f2496m = this.f2492i.f2646q;
        this.f2484a = c1044h.f2662a;
        this.f2497n = c1044h.f2663b;
        this.f2485b = c1044h.f2664c;
        this.f2498o = c1044h.f2665d;
        this.f2486c = c1044h.f2666e;
        this.f2487d = c1044h.f2667f;
        this.f2488e = c1044h.f2668g;
        this.f2499p = this.f2486c.mo6282s();
    }

    /* renamed from: a */
    private Bitmap m2840a(String str) {
        String str2 = str;
        return this.f2496m.mo6157a(new C1008c(this.f2497n, str2, this.f2484a, this.f2498o, this.f2485b.mo6255c(), m2848e(), this.f2486c));
    }

    /* renamed from: a */
    private void m2842a(FailType failType, Throwable th) {
        if (!this.f2499p && !m2854k() && !m2850g()) {
            m2843a(new C1046j(this, failType, th), false, this.f2491h, this.f2489f);
        }
    }

    /* renamed from: a */
    static void m2843a(Runnable runnable, boolean z, Handler handler, C1042f c1042f) {
        if (z) {
            runnable.run();
        } else if (handler == null) {
            c1042f.mo6302a(runnable);
        } else {
            handler.post(runnable);
        }
    }

    /* renamed from: a */
    private boolean m2844a() {
        AtomicBoolean a = this.f2489f.mo6297a();
        if (a.get()) {
            synchronized (this.f2489f.mo6303b()) {
                if (a.get()) {
                    C0999c.m2831a("ImageLoader is paused. Waiting...  [%s]", this.f2497n);
                    try {
                        this.f2489f.mo6303b().wait();
                        C0999c.m2831a(".. Resume loading [%s]", this.f2497n);
                    } catch (InterruptedException e) {
                        C0999c.m2836d("Task was interrupted [%s]", this.f2497n);
                        return true;
                    }
                }
            }
        }
        return m2850g();
    }

    /* renamed from: b */
    private boolean m2845b() {
        if (!this.f2486c.mo6269f()) {
            return false;
        }
        C0999c.m2831a("Delay %d ms before loading...  [%s]", Integer.valueOf(this.f2486c.mo6275l()), this.f2497n);
        try {
            Thread.sleep((long) this.f2486c.mo6275l());
            return m2850g();
        } catch (InterruptedException e) {
            C0999c.m2836d("Task was interrupted [%s]", this.f2497n);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x009e A:{ExcHandler: com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException (r0_13 'e' com.nostra13.universalimageloader.core.LoadAndDisplayImageTask$TaskCancelledException), Splitter: B:1:0x0001} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:12:0x0041, code:
            if (r0.getHeight() > 0) goto L_0x0095;
     */
    /* JADX WARNING: Missing block: B:31:0x009e, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:32:0x009f, code:
            throw r0;
     */
    /* JADX WARNING: Missing block: B:42:0x00c7, code:
            r1 = th;
     */
    /* JADX WARNING: Missing block: B:43:0x00c9, code:
            r1 = e;
     */
    /* JADX WARNING: Missing block: B:44:0x00cb, code:
            r1 = e;
     */
    /* renamed from: c */
    private android.graphics.Bitmap m2846c() {
        /*
        r7 = this;
        r1 = 0;
        r0 = r7.f2492i;	 Catch:{ IllegalStateException -> 0x0096, TaskCancelledException -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        r0 = r0.f2644o;	 Catch:{ IllegalStateException -> 0x0096, TaskCancelledException -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        r2 = r7.f2484a;	 Catch:{ IllegalStateException -> 0x0096, TaskCancelledException -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        r0 = r0.mo6140a(r2);	 Catch:{ IllegalStateException -> 0x0096, TaskCancelledException -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        if (r0 == 0) goto L_0x00cf;
    L_0x000d:
        r2 = r0.exists();	 Catch:{ IllegalStateException -> 0x0096, TaskCancelledException -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        if (r2 == 0) goto L_0x00cf;
    L_0x0013:
        r2 = "Load image from disk cache [%s]";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ IllegalStateException -> 0x0096, TaskCancelledException -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        r4 = 0;
        r5 = r7.f2497n;	 Catch:{ IllegalStateException -> 0x0096, TaskCancelledException -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        r3[r4] = r5;	 Catch:{ IllegalStateException -> 0x0096, TaskCancelledException -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        com.nostra13.universalimageloader.p064b.C0999c.m2831a(r2, r3);	 Catch:{ IllegalStateException -> 0x0096, TaskCancelledException -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        r2 = com.nostra13.universalimageloader.core.assist.LoadedFrom.DISC_CACHE;	 Catch:{ IllegalStateException -> 0x0096, TaskCancelledException -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        r7.f2500q = r2;	 Catch:{ IllegalStateException -> 0x0096, TaskCancelledException -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        r7.m2849f();	 Catch:{ IllegalStateException -> 0x0096, TaskCancelledException -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        r2 = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE;	 Catch:{ IllegalStateException -> 0x0096, TaskCancelledException -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        r0 = r0.getAbsolutePath();	 Catch:{ IllegalStateException -> 0x0096, TaskCancelledException -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        r0 = r2.wrap(r0);	 Catch:{ IllegalStateException -> 0x0096, TaskCancelledException -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
        r0 = r7.m2840a(r0);	 Catch:{ IllegalStateException -> 0x0096, TaskCancelledException -> 0x009e, IOException -> 0x00a0, OutOfMemoryError -> 0x00ad, Throwable -> 0x00ba }
    L_0x0035:
        if (r0 == 0) goto L_0x0043;
    L_0x0037:
        r2 = r0.getWidth();	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        if (r2 <= 0) goto L_0x0043;
    L_0x003d:
        r2 = r0.getHeight();	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        if (r2 > 0) goto L_0x0095;
    L_0x0043:
        r2 = "Load image from network [%s]";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r4 = 0;
        r5 = r7.f2497n;	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r3[r4] = r5;	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        com.nostra13.universalimageloader.p064b.C0999c.m2831a(r2, r3);	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r2 = com.nostra13.universalimageloader.core.assist.LoadedFrom.NETWORK;	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r7.f2500q = r2;	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r2 = r7.f2484a;	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r3 = r7.f2486c;	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r3 = r3.mo6272i();	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        if (r3 == 0) goto L_0x007a;
    L_0x005e:
        r3 = r7.m2847d();	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        if (r3 == 0) goto L_0x007a;
    L_0x0064:
        r3 = r7.f2492i;	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r3 = r3.f2644o;	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r4 = r7.f2484a;	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r3 = r3.mo6140a(r4);	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        if (r3 == 0) goto L_0x007a;
    L_0x0070:
        r2 = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE;	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r3 = r3.getAbsolutePath();	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r2 = r2.wrap(r3);	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
    L_0x007a:
        r7.m2849f();	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r0 = r7.m2840a(r2);	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        if (r0 == 0) goto L_0x008f;
    L_0x0083:
        r2 = r0.getWidth();	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        if (r2 <= 0) goto L_0x008f;
    L_0x0089:
        r2 = r0.getHeight();	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        if (r2 > 0) goto L_0x0095;
    L_0x008f:
        r2 = com.nostra13.universalimageloader.core.assist.FailReason.FailType.DECODING_ERROR;	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
        r3 = 0;
        r7.m2842a(r2, r3);	 Catch:{ IllegalStateException -> 0x00cd, TaskCancelledException -> 0x009e, IOException -> 0x00cb, OutOfMemoryError -> 0x00c9, Throwable -> 0x00c7 }
    L_0x0095:
        return r0;
    L_0x0096:
        r0 = move-exception;
        r0 = r1;
    L_0x0098:
        r2 = com.nostra13.universalimageloader.core.assist.FailReason.FailType.NETWORK_DENIED;
        r7.m2842a(r2, r1);
        goto L_0x0095;
    L_0x009e:
        r0 = move-exception;
        throw r0;
    L_0x00a0:
        r0 = move-exception;
        r6 = r0;
        r0 = r1;
        r1 = r6;
    L_0x00a4:
        com.nostra13.universalimageloader.p064b.C0999c.m2832a(r1);
        r2 = com.nostra13.universalimageloader.core.assist.FailReason.FailType.IO_ERROR;
        r7.m2842a(r2, r1);
        goto L_0x0095;
    L_0x00ad:
        r0 = move-exception;
        r6 = r0;
        r0 = r1;
        r1 = r6;
    L_0x00b1:
        com.nostra13.universalimageloader.p064b.C0999c.m2832a(r1);
        r2 = com.nostra13.universalimageloader.core.assist.FailReason.FailType.OUT_OF_MEMORY;
        r7.m2842a(r2, r1);
        goto L_0x0095;
    L_0x00ba:
        r0 = move-exception;
        r6 = r0;
        r0 = r1;
        r1 = r6;
    L_0x00be:
        com.nostra13.universalimageloader.p064b.C0999c.m2832a(r1);
        r2 = com.nostra13.universalimageloader.core.assist.FailReason.FailType.UNKNOWN;
        r7.m2842a(r2, r1);
        goto L_0x0095;
    L_0x00c7:
        r1 = move-exception;
        goto L_0x00be;
    L_0x00c9:
        r1 = move-exception;
        goto L_0x00b1;
    L_0x00cb:
        r1 = move-exception;
        goto L_0x00a4;
    L_0x00cd:
        r2 = move-exception;
        goto L_0x0098;
    L_0x00cf:
        r0 = r1;
        goto L_0x0035;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.c():android.graphics.Bitmap");
    }

    /* renamed from: d */
    private boolean m2847d() {
        C0999c.m2831a("Cache image on disk [%s]", this.f2497n);
        try {
            boolean a = this.f2492i.f2644o.mo6142a(this.f2484a, m2848e().mo6290a(this.f2484a, this.f2486c.mo6277n()), this);
            if (a) {
                int i = this.f2492i.f2633d;
                int i2 = this.f2492i.f2634e;
                if (i > 0 || i2 > 0) {
                    C0999c.m2831a("Resize image in disk cache [%s]", this.f2497n);
                    File a2 = this.f2492i.f2644o.mo6140a(this.f2484a);
                    if (a2 != null && a2.exists()) {
                        Bitmap a3 = this.f2496m.mo6157a(new C1008c(this.f2497n, Scheme.FILE.wrap(a2.getAbsolutePath()), this.f2484a, new C1013c(i, i2), ViewScaleType.FIT_INSIDE, m2848e(), new C1025a().mo6246a(this.f2486c).mo6244a(ImageScaleType.IN_SAMPLE_INT).mo6249b()));
                        if (!(a3 == null || this.f2492i.f2635f == null)) {
                            C0999c.m2831a("Process image before cache on disk [%s]", this.f2497n);
                            a3 = this.f2492i.f2635f.mo6295a();
                            if (a3 == null) {
                                C0999c.m2836d("Bitmap processor for disk cache returned null [%s]", this.f2497n);
                            }
                        }
                        if (a3 != null) {
                            this.f2492i.f2644o.mo6141a(this.f2484a, a3);
                            a3.recycle();
                        }
                    }
                }
            }
            return a;
        } catch (Throwable e) {
            C0999c.m2832a(e);
            return false;
        }
    }

    /* renamed from: e */
    private ImageDownloader m2848e() {
        return this.f2489f.mo6305c() ? this.f2494k : this.f2489f.mo6306d() ? this.f2495l : this.f2493j;
    }

    /* renamed from: f */
    private void m2849f() {
        if (m2851h()) {
            throw new TaskCancelledException();
        } else if (m2852i()) {
            throw new TaskCancelledException();
        }
    }

    /* renamed from: g */
    private boolean m2850g() {
        return m2851h() || m2852i();
    }

    /* renamed from: h */
    private boolean m2851h() {
        if (!this.f2485b.mo6257e()) {
            return false;
        }
        C0999c.m2831a("ImageAware was collected by GC. Task is cancelled. [%s]", this.f2497n);
        return true;
    }

    /* renamed from: i */
    private boolean m2852i() {
        if (!(!this.f2497n.equals(this.f2489f.mo6296a(this.f2485b)))) {
            return false;
        }
        C0999c.m2831a("ImageAware is reused for another image. Task is cancelled. [%s]", this.f2497n);
        return true;
    }

    /* renamed from: j */
    private void m2853j() {
        if (m2854k()) {
            throw new TaskCancelledException();
        }
    }

    /* renamed from: k */
    private boolean m2854k() {
        if (!Thread.interrupted()) {
            return false;
        }
        C0999c.m2831a("Task was interrupted [%s]", this.f2497n);
        return true;
    }

    /* renamed from: a */
    public final boolean mo6153a(int i, int i2) {
        if (!this.f2499p) {
            boolean z;
            if (m2854k() || m2850g()) {
                z = false;
            } else {
                if (this.f2488e != null) {
                    m2843a(new C1045i(this, i, i2), false, this.f2491h, this.f2489f);
                }
                z = true;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public final void run() {
        if (!m2844a() && !m2845b()) {
            ReentrantLock reentrantLock = this.f2490g.f2669h;
            C0999c.m2831a("Start display image task [%s]", this.f2497n);
            if (reentrantLock.isLocked()) {
                C0999c.m2831a("Image already is loading. Waiting... [%s]", this.f2497n);
            }
            reentrantLock.lock();
            try {
                m2849f();
                Bitmap bitmap = (Bitmap) this.f2492i.f2643n.mo6150b(this.f2497n);
                if (bitmap == null || bitmap.isRecycled()) {
                    bitmap = m2846c();
                    if (bitmap == null) {
                        reentrantLock.unlock();
                        return;
                    }
                    m2849f();
                    m2853j();
                    if (this.f2486c.mo6267d()) {
                        C0999c.m2831a("PreProcess image before caching in memory [%s]", this.f2497n);
                        bitmap = this.f2486c.mo6278o().mo6295a();
                        if (bitmap == null) {
                            C0999c.m2836d("Pre-processor returned null [%s]", this.f2497n);
                        }
                    }
                    if (bitmap != null && this.f2486c.mo6271h()) {
                        C0999c.m2831a("Cache image in memory [%s]", this.f2497n);
                        this.f2492i.f2643n.mo6149a(this.f2497n, bitmap);
                    }
                } else {
                    this.f2500q = LoadedFrom.MEMORY_CACHE;
                    C0999c.m2831a("...Get cached bitmap from memory after waiting. [%s]", this.f2497n);
                }
                if (bitmap != null && this.f2486c.mo6268e()) {
                    C0999c.m2831a("PostProcess image before displaying [%s]", this.f2497n);
                    bitmap = this.f2486c.mo6279p().mo6295a();
                    if (bitmap == null) {
                        C0999c.m2836d("Post-processor returned null [%s]", this.f2497n);
                    }
                }
                m2849f();
                m2853j();
                reentrantLock.unlock();
                m2843a(new C1024b(bitmap, this.f2490g, this.f2489f, this.f2500q), this.f2499p, this.f2491h, this.f2489f);
            } catch (TaskCancelledException e) {
                if (!(this.f2499p || m2854k())) {
                    m2843a(new C1047k(this), false, this.f2491h, this.f2489f);
                }
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }
}
