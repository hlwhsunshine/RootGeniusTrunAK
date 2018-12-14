package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.p064b.C0999c;

/* renamed from: com.nostra13.universalimageloader.core.l */
final class C1048l implements Runnable {
    /* renamed from: a */
    private final C1042f f2677a;
    /* renamed from: b */
    private final Bitmap f2678b;
    /* renamed from: c */
    private final C1044h f2679c;
    /* renamed from: d */
    private final Handler f2680d;

    public C1048l(C1042f c1042f, Bitmap bitmap, C1044h c1044h, Handler handler) {
        this.f2677a = c1042f;
        this.f2678b = bitmap;
        this.f2679c = c1044h;
        this.f2680d = handler;
    }

    public final void run() {
        C0999c.m2831a("PostProcess image before displaying [%s]", this.f2679c.f2663b);
        LoadAndDisplayImageTask.m2843a(new C1024b(this.f2679c.f2666e.mo6279p().mo6295a(), this.f2679c, this.f2677a, LoadedFrom.MEMORY_CACHE), this.f2679c.f2666e.mo6282s(), this.f2680d, this.f2677a);
    }
}
