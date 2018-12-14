package com.shuame.p075ad;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* renamed from: com.shuame.ad.aa */
final class C1084aa implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ImageView f2909a;
    /* renamed from: b */
    final /* synthetic */ Bitmap f2910b;
    /* renamed from: c */
    final /* synthetic */ C1121x f2911c;

    C1084aa(C1121x c1121x, ImageView imageView, Bitmap bitmap) {
        this.f2911c = c1121x;
        this.f2909a = imageView;
        this.f2910b = bitmap;
    }

    public final void run() {
        this.f2909a.setImageBitmap(this.f2910b);
        C1121x.f3006f;
        if (this.f2911c.f2966a != null) {
            this.f2911c.f2966a.mo6682a(this.f2911c);
        }
        this.f2911c.m3255a(5000);
    }
}
