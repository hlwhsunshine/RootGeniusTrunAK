package com.nostra13.universalimageloader.core;

import android.content.res.Resources;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.p066b.C1020a;
import com.nostra13.universalimageloader.core.p066b.C1023c;
import com.nostra13.universalimageloader.core.p069e.C1040a;

/* renamed from: com.nostra13.universalimageloader.core.c */
public final class C1029c {
    /* renamed from: a */
    private final int f2574a;
    /* renamed from: b */
    private final int f2575b;
    /* renamed from: c */
    private final int f2576c;
    /* renamed from: d */
    private final Drawable f2577d;
    /* renamed from: e */
    private final Drawable f2578e;
    /* renamed from: f */
    private final Drawable f2579f;
    /* renamed from: g */
    private final boolean f2580g;
    /* renamed from: h */
    private final boolean f2581h;
    /* renamed from: i */
    private final boolean f2582i;
    /* renamed from: j */
    private final ImageScaleType f2583j;
    /* renamed from: k */
    private final Options f2584k;
    /* renamed from: l */
    private final int f2585l;
    /* renamed from: m */
    private final boolean f2586m;
    /* renamed from: n */
    private final Object f2587n;
    /* renamed from: o */
    private final C1040a f2588o;
    /* renamed from: p */
    private final C1040a f2589p;
    /* renamed from: q */
    private final C1020a f2590q;
    /* renamed from: r */
    private final Handler f2591r;
    /* renamed from: s */
    private final boolean f2592s;

    /* renamed from: com.nostra13.universalimageloader.core.c$a */
    public static class C1025a {
        /* renamed from: a */
        private int f2553a;
        /* renamed from: b */
        private int f2554b;
        /* renamed from: c */
        private int f2555c;
        /* renamed from: d */
        private Drawable f2556d;
        /* renamed from: e */
        private Drawable f2557e;
        /* renamed from: f */
        private Drawable f2558f;
        /* renamed from: g */
        private boolean f2559g;
        /* renamed from: h */
        private boolean f2560h;
        /* renamed from: i */
        private boolean f2561i;
        /* renamed from: j */
        private ImageScaleType f2562j;
        /* renamed from: k */
        private Options f2563k;
        /* renamed from: l */
        private int f2564l;
        /* renamed from: m */
        private boolean f2565m;
        /* renamed from: n */
        private Object f2566n;
        /* renamed from: o */
        private C1040a f2567o;
        /* renamed from: p */
        private C1040a f2568p;
        /* renamed from: q */
        private C1020a f2569q;
        /* renamed from: r */
        private Handler f2570r;
        /* renamed from: s */
        private boolean f2571s;

        public C1025a() {
            this.f2553a = 0;
            this.f2554b = 0;
            this.f2555c = 0;
            this.f2556d = null;
            this.f2557e = null;
            this.f2558f = null;
            this.f2559g = false;
            this.f2560h = false;
            this.f2561i = false;
            this.f2562j = ImageScaleType.IN_SAMPLE_POWER_OF_2;
            this.f2563k = new Options();
            this.f2564l = 0;
            this.f2565m = false;
            this.f2566n = null;
            this.f2567o = null;
            this.f2568p = null;
            this.f2569q = new C1023c();
            this.f2570r = null;
            this.f2571s = false;
            this.f2563k.inPurgeable = true;
            this.f2563k.inInputShareable = true;
        }

        /* renamed from: a */
        public final C1025a mo6241a() {
            this.f2561i = true;
            return this;
        }

        /* renamed from: a */
        public final C1025a mo6242a(int i) {
            this.f2553a = i;
            return this;
        }

        /* renamed from: a */
        public final C1025a mo6243a(Config config) {
            if (config == null) {
                throw new IllegalArgumentException("bitmapConfig can't be null");
            }
            this.f2563k.inPreferredConfig = config;
            return this;
        }

        /* renamed from: a */
        public final C1025a mo6244a(ImageScaleType imageScaleType) {
            this.f2562j = imageScaleType;
            return this;
        }

        /* renamed from: a */
        public final C1025a mo6245a(C1020a c1020a) {
            this.f2569q = c1020a;
            return this;
        }

        /* renamed from: a */
        public final C1025a mo6246a(C1029c c1029c) {
            this.f2553a = c1029c.f2574a;
            this.f2554b = c1029c.f2575b;
            this.f2555c = c1029c.f2576c;
            this.f2556d = c1029c.f2577d;
            this.f2557e = c1029c.f2578e;
            this.f2558f = c1029c.f2579f;
            this.f2559g = c1029c.f2580g;
            this.f2560h = c1029c.f2581h;
            this.f2561i = c1029c.f2582i;
            this.f2562j = c1029c.f2583j;
            this.f2563k = c1029c.f2584k;
            this.f2564l = c1029c.f2585l;
            this.f2565m = c1029c.f2586m;
            this.f2566n = c1029c.f2587n;
            this.f2567o = c1029c.f2588o;
            this.f2568p = c1029c.f2589p;
            this.f2569q = c1029c.f2590q;
            this.f2570r = c1029c.f2591r;
            this.f2571s = c1029c.f2592s;
            return this;
        }

        /* renamed from: a */
        public final C1025a mo6247a(boolean z) {
            this.f2560h = z;
            return this;
        }

        /* renamed from: b */
        public final C1025a mo6248b(int i) {
            this.f2554b = i;
            return this;
        }

        /* renamed from: b */
        public final C1029c mo6249b() {
            return new C1029c(this, (byte) 0);
        }

        /* renamed from: c */
        public final C1025a mo6250c(int i) {
            this.f2555c = i;
            return this;
        }
    }

    private C1029c(C1025a c1025a) {
        this.f2574a = c1025a.f2553a;
        this.f2575b = c1025a.f2554b;
        this.f2576c = c1025a.f2555c;
        this.f2577d = c1025a.f2556d;
        this.f2578e = c1025a.f2557e;
        this.f2579f = c1025a.f2558f;
        this.f2580g = c1025a.f2559g;
        this.f2581h = c1025a.f2560h;
        this.f2582i = c1025a.f2561i;
        this.f2583j = c1025a.f2562j;
        this.f2584k = c1025a.f2563k;
        this.f2585l = c1025a.f2564l;
        this.f2586m = c1025a.f2565m;
        this.f2587n = c1025a.f2566n;
        this.f2588o = c1025a.f2567o;
        this.f2589p = c1025a.f2568p;
        this.f2590q = c1025a.f2569q;
        this.f2591r = c1025a.f2570r;
        this.f2592s = c1025a.f2571s;
    }

    /* synthetic */ C1029c(C1025a c1025a, byte b) {
        this(c1025a);
    }

    /* renamed from: a */
    public final Drawable mo6261a(Resources resources) {
        return this.f2574a != 0 ? resources.getDrawable(this.f2574a) : this.f2577d;
    }

    /* renamed from: a */
    public final boolean mo6262a() {
        return (this.f2577d == null && this.f2574a == 0) ? false : true;
    }

    /* renamed from: b */
    public final Drawable mo6263b(Resources resources) {
        return this.f2575b != 0 ? resources.getDrawable(this.f2575b) : this.f2578e;
    }

    /* renamed from: b */
    public final boolean mo6264b() {
        return (this.f2578e == null && this.f2575b == 0) ? false : true;
    }

    /* renamed from: c */
    public final Drawable mo6265c(Resources resources) {
        return this.f2576c != 0 ? resources.getDrawable(this.f2576c) : this.f2579f;
    }

    /* renamed from: c */
    public final boolean mo6266c() {
        return (this.f2579f == null && this.f2576c == 0) ? false : true;
    }

    /* renamed from: d */
    public final boolean mo6267d() {
        return this.f2588o != null;
    }

    /* renamed from: e */
    public final boolean mo6268e() {
        return this.f2589p != null;
    }

    /* renamed from: f */
    public final boolean mo6269f() {
        return this.f2585l > 0;
    }

    /* renamed from: g */
    public final boolean mo6270g() {
        return this.f2580g;
    }

    /* renamed from: h */
    public final boolean mo6271h() {
        return this.f2581h;
    }

    /* renamed from: i */
    public final boolean mo6272i() {
        return this.f2582i;
    }

    /* renamed from: j */
    public final ImageScaleType mo6273j() {
        return this.f2583j;
    }

    /* renamed from: k */
    public final Options mo6274k() {
        return this.f2584k;
    }

    /* renamed from: l */
    public final int mo6275l() {
        return this.f2585l;
    }

    /* renamed from: m */
    public final boolean mo6276m() {
        return this.f2586m;
    }

    /* renamed from: n */
    public final Object mo6277n() {
        return this.f2587n;
    }

    /* renamed from: o */
    public final C1040a mo6278o() {
        return this.f2588o;
    }

    /* renamed from: p */
    public final C1040a mo6279p() {
        return this.f2589p;
    }

    /* renamed from: q */
    public final C1020a mo6280q() {
        return this.f2590q;
    }

    /* renamed from: r */
    public final Handler mo6281r() {
        return this.f2591r;
    }

    /* renamed from: s */
    final boolean mo6282s() {
        return this.f2592s;
    }
}
