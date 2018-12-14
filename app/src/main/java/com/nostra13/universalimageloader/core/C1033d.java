package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.C1013c;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.p066b.C1020a;
import com.nostra13.universalimageloader.core.p067c.C1026a;
import com.nostra13.universalimageloader.core.p067c.C1028b;
import com.nostra13.universalimageloader.core.p068d.C1030a;
import com.nostra13.universalimageloader.core.p068d.C1032c;
import com.nostra13.universalimageloader.p064b.C0996a;
import com.nostra13.universalimageloader.p064b.C0999c;

/* renamed from: com.nostra13.universalimageloader.core.d */
public class C1033d {
    /* renamed from: a */
    public static final String f2593a = C1033d.class.getSimpleName();
    /* renamed from: e */
    private static volatile C1033d f2594e;
    /* renamed from: b */
    private C1041e f2595b;
    /* renamed from: c */
    private C1042f f2596c;
    /* renamed from: d */
    private final C1030a f2597d = new C1032c();

    protected C1033d() {
    }

    /* renamed from: a */
    private static Handler m2983a(C1029c c1029c) {
        Handler r = c1029c.mo6281r();
        return c1029c.mo6282s() ? null : (r == null && Looper.myLooper() == Looper.getMainLooper()) ? new Handler() : r;
    }

    /* renamed from: a */
    public static C1033d m2984a() {
        if (f2594e == null) {
            synchronized (C1033d.class) {
                if (f2594e == null) {
                    f2594e = new C1033d();
                }
            }
        }
        return f2594e;
    }

    /* renamed from: a */
    private void m2985a(String str, C1026a c1026a, C1029c c1029c, C1030a c1030a) {
        if (this.f2595b == null) {
            throw new IllegalStateException("ImageLoader must be init with configuration before using");
        }
        C1030a c1030a2 = c1030a == null ? this.f2597d : c1030a;
        C1029c c1029c2 = c1029c == null ? this.f2595b.f2647r : c1029c;
        if (TextUtils.isEmpty(str)) {
            this.f2596c.mo6304b(c1026a);
            c1026a.mo6256d();
            if (c1029c2.mo6264b()) {
                c1026a.mo6253a(c1029c2.mo6263b(this.f2595b.f2630a));
            } else {
                c1026a.mo6253a(null);
            }
            c1030a2.onLoadingComplete$5848811b(c1026a.mo6256d());
            return;
        }
        C1041e c1041e = this.f2595b;
        DisplayMetrics displayMetrics = c1041e.f2630a.getDisplayMetrics();
        int i = c1041e.f2631b;
        if (i <= 0) {
            i = displayMetrics.widthPixels;
        }
        int i2 = c1041e.f2632c;
        if (i2 <= 0) {
            i2 = displayMetrics.heightPixels;
        }
        C1013c a = C0996a.m2824a(c1026a, new C1013c(i, i2));
        String str2 = "_" + a.mo6177a() + "x" + a.mo6180b();
        this.f2596c.mo6300a(c1026a, str2);
        c1026a.mo6256d();
        Bitmap bitmap = (Bitmap) this.f2595b.f2643n.mo6150b(str2);
        if (bitmap == null || bitmap.isRecycled()) {
            if (c1029c2.mo6262a()) {
                c1026a.mo6253a(c1029c2.mo6261a(this.f2595b.f2630a));
            } else if (c1029c2.mo6270g()) {
                c1026a.mo6253a(null);
            }
            LoadAndDisplayImageTask loadAndDisplayImageTask = new LoadAndDisplayImageTask(this.f2596c, new C1044h(str, c1026a, a, str2, c1029c2, c1030a2, this.f2596c.mo6298a(str)), C1033d.m2983a(c1029c2));
            if (c1029c2.mo6282s()) {
                loadAndDisplayImageTask.run();
                return;
            } else {
                this.f2596c.mo6299a(loadAndDisplayImageTask);
                return;
            }
        }
        C0999c.m2831a("Load image from memory cache [%s]", str2);
        if (c1029c2.mo6268e()) {
            C1048l c1048l = new C1048l(this.f2596c, bitmap, new C1044h(str, c1026a, a, str2, c1029c2, c1030a2, this.f2596c.mo6298a(str)), C1033d.m2983a(c1029c2));
            if (c1029c2.mo6282s()) {
                c1048l.run();
                return;
            } else {
                this.f2596c.mo6301a(c1048l);
                return;
            }
        }
        C1020a q = c1029c2.mo6280q();
        LoadedFrom loadedFrom = LoadedFrom.MEMORY_CACHE;
        q.mo6234a(bitmap, c1026a);
        c1030a2.onLoadingComplete$5848811b(c1026a.mo6256d());
    }

    /* renamed from: a */
    public final synchronized void mo6284a(C1041e c1041e) {
        if (c1041e == null) {
            throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
        } else if (this.f2595b == null) {
            C0999c.m2831a("Initialize ImageLoader with configuration", new Object[0]);
            this.f2596c = new C1042f(c1041e);
            this.f2595b = c1041e;
        } else {
            C0999c.m2835c("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
        }
    }

    /* renamed from: a */
    public final void mo6285a(String str, ImageView imageView, C1029c c1029c) {
        m2985a(str, new C1028b(imageView), c1029c, null);
    }

    /* renamed from: a */
    public final void mo6286a(String str, ImageView imageView, C1029c c1029c, C1030a c1030a) {
        m2985a(str, new C1028b(imageView), c1029c, c1030a);
    }

    /* renamed from: b */
    public final boolean mo6287b() {
        return this.f2595b != null;
    }
}
