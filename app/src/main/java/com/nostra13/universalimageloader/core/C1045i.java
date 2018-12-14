package com.nostra13.universalimageloader.core;

/* renamed from: com.nostra13.universalimageloader.core.i */
final class C1045i implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f2670a;
    /* renamed from: b */
    final /* synthetic */ int f2671b;
    /* renamed from: c */
    final /* synthetic */ LoadAndDisplayImageTask f2672c;

    C1045i(LoadAndDisplayImageTask loadAndDisplayImageTask, int i, int i2) {
        this.f2672c = loadAndDisplayImageTask;
        this.f2670a = i;
        this.f2671b = i2;
    }

    public final void run() {
        this.f2672c.f2485b.mo6256d();
    }
}
