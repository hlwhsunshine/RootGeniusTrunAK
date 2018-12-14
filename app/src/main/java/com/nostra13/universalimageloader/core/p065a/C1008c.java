package com.nostra13.universalimageloader.core.p065a;

import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.nostra13.universalimageloader.core.C1029c;
import com.nostra13.universalimageloader.core.assist.C1013c;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

/* renamed from: com.nostra13.universalimageloader.core.a.c */
public final class C1008c {
    /* renamed from: a */
    private final String f2511a;
    /* renamed from: b */
    private final String f2512b;
    /* renamed from: c */
    private final String f2513c;
    /* renamed from: d */
    private final C1013c f2514d;
    /* renamed from: e */
    private final ImageScaleType f2515e;
    /* renamed from: f */
    private final ViewScaleType f2516f;
    /* renamed from: g */
    private final ImageDownloader f2517g;
    /* renamed from: h */
    private final Object f2518h;
    /* renamed from: i */
    private final boolean f2519i;
    /* renamed from: j */
    private final Options f2520j = new Options();

    public C1008c(String str, String str2, String str3, C1013c c1013c, ViewScaleType viewScaleType, ImageDownloader imageDownloader, C1029c c1029c) {
        this.f2511a = str;
        this.f2512b = str2;
        this.f2513c = str3;
        this.f2514d = c1013c;
        this.f2515e = c1029c.mo6273j();
        this.f2516f = viewScaleType;
        this.f2517g = imageDownloader;
        this.f2518h = c1029c.mo6277n();
        this.f2519i = c1029c.mo6276m();
        Options k = c1029c.mo6274k();
        Options options = this.f2520j;
        options.inDensity = k.inDensity;
        options.inDither = k.inDither;
        options.inInputShareable = k.inInputShareable;
        options.inJustDecodeBounds = k.inJustDecodeBounds;
        options.inPreferredConfig = k.inPreferredConfig;
        options.inPurgeable = k.inPurgeable;
        options.inSampleSize = k.inSampleSize;
        options.inScaled = k.inScaled;
        options.inScreenDensity = k.inScreenDensity;
        options.inTargetDensity = k.inTargetDensity;
        options.inTempStorage = k.inTempStorage;
        if (VERSION.SDK_INT >= 10) {
            options.inPreferQualityOverSpeed = k.inPreferQualityOverSpeed;
        }
        if (VERSION.SDK_INT >= 11) {
            options.inBitmap = k.inBitmap;
            options.inMutable = k.inMutable;
        }
    }

    /* renamed from: a */
    public final String mo6158a() {
        return this.f2511a;
    }

    /* renamed from: b */
    public final String mo6159b() {
        return this.f2512b;
    }

    /* renamed from: c */
    public final C1013c mo6160c() {
        return this.f2514d;
    }

    /* renamed from: d */
    public final ImageScaleType mo6161d() {
        return this.f2515e;
    }

    /* renamed from: e */
    public final ViewScaleType mo6162e() {
        return this.f2516f;
    }

    /* renamed from: f */
    public final ImageDownloader mo6163f() {
        return this.f2517g;
    }

    /* renamed from: g */
    public final Object mo6164g() {
        return this.f2518h;
    }

    /* renamed from: h */
    public final boolean mo6165h() {
        return this.f2519i;
    }

    /* renamed from: i */
    public final Options mo6166i() {
        return this.f2520j;
    }
}
