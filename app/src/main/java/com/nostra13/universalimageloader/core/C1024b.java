package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.p066b.C1020a;
import com.nostra13.universalimageloader.core.p067c.C1026a;
import com.nostra13.universalimageloader.core.p068d.C1030a;
import com.nostra13.universalimageloader.p064b.C0999c;

/* renamed from: com.nostra13.universalimageloader.core.b */
final class C1024b implements Runnable {
    /* renamed from: a */
    private final Bitmap f2545a;
    /* renamed from: b */
    private final String f2546b;
    /* renamed from: c */
    private final C1026a f2547c;
    /* renamed from: d */
    private final String f2548d;
    /* renamed from: e */
    private final C1020a f2549e;
    /* renamed from: f */
    private final C1030a f2550f;
    /* renamed from: g */
    private final C1042f f2551g;
    /* renamed from: h */
    private final LoadedFrom f2552h;

    public C1024b(Bitmap bitmap, C1044h c1044h, C1042f c1042f, LoadedFrom loadedFrom) {
        this.f2545a = bitmap;
        this.f2546b = c1044h.f2662a;
        this.f2547c = c1044h.f2664c;
        this.f2548d = c1044h.f2663b;
        this.f2549e = c1044h.f2666e.mo6280q();
        this.f2550f = c1044h.f2667f;
        this.f2551g = c1042f;
        this.f2552h = loadedFrom;
    }

    public final void run() {
        if (this.f2547c.mo6257e()) {
            C0999c.m2831a("ImageAware was collected by GC. Task is cancelled. [%s]", this.f2548d);
            this.f2547c.mo6256d();
            return;
        }
        if ((!this.f2548d.equals(this.f2551g.mo6296a(this.f2547c)) ? 1 : 0) != 0) {
            C0999c.m2831a("ImageAware is reused for another image. Task is cancelled. [%s]", this.f2548d);
            this.f2547c.mo6256d();
            return;
        }
        C0999c.m2831a("Display image in ImageAware (loaded from %1$s) [%2$s]", this.f2552h, this.f2548d);
        this.f2549e.mo6234a(this.f2545a, this.f2547c);
        this.f2551g.mo6304b(this.f2547c);
        this.f2550f.onLoadingComplete$5848811b(this.f2547c.mo6256d());
    }
}
