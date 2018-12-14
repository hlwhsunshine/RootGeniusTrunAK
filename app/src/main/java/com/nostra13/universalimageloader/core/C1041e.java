package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.content.res.Resources;
import com.nostra13.universalimageloader.core.C1029c.C1025a;
import com.nostra13.universalimageloader.core.assist.C1012b;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.C1035a;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme;
import com.nostra13.universalimageloader.core.p065a.C1006b;
import com.nostra13.universalimageloader.core.p065a.C1007a;
import com.nostra13.universalimageloader.core.p069e.C1040a;
import com.nostra13.universalimageloader.p057a.p058a.C0979b;
import com.nostra13.universalimageloader.p057a.p058a.p061b.C0986a;
import com.nostra13.universalimageloader.p057a.p058a.p061b.C0987b;
import com.nostra13.universalimageloader.p057a.p062b.C0990b;
import com.nostra13.universalimageloader.p057a.p062b.p063a.C0991a;
import com.nostra13.universalimageloader.p057a.p062b.p063a.C0992b;
import com.nostra13.universalimageloader.p064b.C0999c;
import com.nostra13.universalimageloader.p064b.C1000d;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* renamed from: com.nostra13.universalimageloader.core.e */
public final class C1041e {
    /* renamed from: a */
    final Resources f2630a;
    /* renamed from: b */
    final int f2631b;
    /* renamed from: c */
    final int f2632c;
    /* renamed from: d */
    final int f2633d;
    /* renamed from: e */
    final int f2634e;
    /* renamed from: f */
    final C1040a f2635f;
    /* renamed from: g */
    final Executor f2636g;
    /* renamed from: h */
    final Executor f2637h;
    /* renamed from: i */
    final boolean f2638i;
    /* renamed from: j */
    final boolean f2639j;
    /* renamed from: k */
    final int f2640k;
    /* renamed from: l */
    final int f2641l;
    /* renamed from: m */
    final QueueProcessingType f2642m;
    /* renamed from: n */
    final C0990b f2643n;
    /* renamed from: o */
    final C0979b f2644o;
    /* renamed from: p */
    final ImageDownloader f2645p;
    /* renamed from: q */
    final C1006b f2646q;
    /* renamed from: r */
    final C1029c f2647r;
    /* renamed from: s */
    final ImageDownloader f2648s;
    /* renamed from: t */
    final ImageDownloader f2649t;

    /* renamed from: com.nostra13.universalimageloader.core.e$a */
    public static class C1037a {
        /* renamed from: a */
        public static final QueueProcessingType f2603a = QueueProcessingType.FIFO;
        /* renamed from: b */
        private Context f2604b;
        /* renamed from: c */
        private int f2605c = 0;
        /* renamed from: d */
        private int f2606d = 0;
        /* renamed from: e */
        private int f2607e = 0;
        /* renamed from: f */
        private int f2608f = 0;
        /* renamed from: g */
        private C1040a f2609g = null;
        /* renamed from: h */
        private Executor f2610h = null;
        /* renamed from: i */
        private Executor f2611i = null;
        /* renamed from: j */
        private boolean f2612j = false;
        /* renamed from: k */
        private boolean f2613k = false;
        /* renamed from: l */
        private int f2614l = 3;
        /* renamed from: m */
        private int f2615m = 4;
        /* renamed from: n */
        private boolean f2616n = false;
        /* renamed from: o */
        private QueueProcessingType f2617o = f2603a;
        /* renamed from: p */
        private int f2618p = 0;
        /* renamed from: q */
        private long f2619q = 0;
        /* renamed from: r */
        private int f2620r = 0;
        /* renamed from: s */
        private C0990b f2621s = null;
        /* renamed from: t */
        private C0979b f2622t = null;
        /* renamed from: u */
        private C0986a f2623u = null;
        /* renamed from: v */
        private ImageDownloader f2624v = null;
        /* renamed from: w */
        private C1006b f2625w;
        /* renamed from: x */
        private C1029c f2626x = null;
        /* renamed from: y */
        private boolean f2627y = false;

        public C1037a(Context context) {
            this.f2604b = context.getApplicationContext();
        }

        /* renamed from: a */
        public final C1037a mo6291a(C0979b c0979b) {
            if (this.f2619q > 0 || this.f2620r > 0) {
                C0999c.m2835c("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
            }
            if (this.f2623u != null) {
                C0999c.m2835c("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
            }
            this.f2622t = c0979b;
            return this;
        }

        /* renamed from: a */
        public final C1037a mo6292a(C0990b c0990b) {
            if (this.f2618p != 0) {
                C0999c.m2835c("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
            }
            this.f2621s = c0990b;
            return this;
        }

        /* renamed from: a */
        public final C1037a mo6293a(C1029c c1029c) {
            this.f2626x = c1029c;
            return this;
        }

        /* renamed from: a */
        public final C1041e mo6294a() {
            if (this.f2610h == null) {
                this.f2610h = C1009a.m2872a(this.f2614l, this.f2615m, this.f2617o);
            } else {
                this.f2612j = true;
            }
            if (this.f2611i == null) {
                this.f2611i = C1009a.m2872a(this.f2614l, this.f2615m, this.f2617o);
            } else {
                this.f2613k = true;
            }
            if (this.f2622t == null) {
                if (this.f2623u == null) {
                    this.f2623u = new C0987b();
                }
                this.f2622t = C1009a.m2870a(this.f2604b, this.f2623u, this.f2619q, this.f2620r);
            }
            if (this.f2621s == null) {
                int i = this.f2618p;
                if (i == 0) {
                    i = (int) (Runtime.getRuntime().maxMemory() / 8);
                }
                this.f2621s = new C0992b(i);
            }
            if (this.f2616n) {
                this.f2621s = new C0991a(this.f2621s, C1000d.m2837a());
            }
            if (this.f2624v == null) {
                this.f2624v = new C1035a(this.f2604b);
            }
            if (this.f2625w == null) {
                this.f2625w = new C1007a(this.f2627y);
            }
            if (this.f2626x == null) {
                this.f2626x = new C1025a().mo6249b();
            }
            return new C1041e(this, (byte) 0);
        }
    }

    /* renamed from: com.nostra13.universalimageloader.core.e$b */
    private static class C1038b implements ImageDownloader {
        /* renamed from: a */
        private final ImageDownloader f2628a;

        public C1038b(ImageDownloader imageDownloader) {
            this.f2628a = imageDownloader;
        }

        /* renamed from: a */
        public final InputStream mo6290a(String str, Object obj) {
            switch (Scheme.ofUri(str)) {
                case HTTP:
                case HTTPS:
                    throw new IllegalStateException();
                default:
                    return this.f2628a.mo6290a(str, obj);
            }
        }
    }

    /* renamed from: com.nostra13.universalimageloader.core.e$c */
    private static class C1039c implements ImageDownloader {
        /* renamed from: a */
        private final ImageDownloader f2629a;

        public C1039c(ImageDownloader imageDownloader) {
            this.f2629a = imageDownloader;
        }

        /* renamed from: a */
        public final InputStream mo6290a(String str, Object obj) {
            InputStream a = this.f2629a.mo6290a(str, obj);
            switch (Scheme.ofUri(str)) {
                case HTTP:
                case HTTPS:
                    return new C1012b(a);
                default:
                    return a;
            }
        }
    }

    private C1041e(C1037a c1037a) {
        this.f2630a = c1037a.f2604b.getResources();
        this.f2631b = c1037a.f2605c;
        this.f2632c = c1037a.f2606d;
        this.f2633d = c1037a.f2607e;
        this.f2634e = c1037a.f2608f;
        this.f2635f = c1037a.f2609g;
        this.f2636g = c1037a.f2610h;
        this.f2637h = c1037a.f2611i;
        this.f2640k = c1037a.f2614l;
        this.f2641l = c1037a.f2615m;
        this.f2642m = c1037a.f2617o;
        this.f2644o = c1037a.f2622t;
        this.f2643n = c1037a.f2621s;
        this.f2647r = c1037a.f2626x;
        this.f2645p = c1037a.f2624v;
        this.f2646q = c1037a.f2625w;
        this.f2638i = c1037a.f2612j;
        this.f2639j = c1037a.f2613k;
        this.f2648s = new C1038b(this.f2645p);
        this.f2649t = new C1039c(this.f2645p);
        C0999c.m2833a(c1037a.f2627y);
    }

    /* synthetic */ C1041e(C1037a c1037a, byte b) {
        this(c1037a);
    }
}
