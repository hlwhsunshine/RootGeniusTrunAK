package com.shuame.mobile.module.autoboot.p085ui.view;

import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.shuame.mobile.module.autoboot.ui.view.a */
public final class C1182a {
    /* renamed from: a */
    private Timer f3155a;
    /* renamed from: b */
    private int f3156b;
    /* renamed from: c */
    private int f3157c;
    /* renamed from: d */
    private int f3158d;
    /* renamed from: e */
    private View f3159e;
    /* renamed from: f */
    private Rect f3160f;
    /* renamed from: g */
    private C1180a f3161g;
    /* renamed from: h */
    private long f3162h;
    /* renamed from: i */
    private Object f3163i;
    /* renamed from: j */
    private Handler f3164j;
    /* renamed from: k */
    private C1181b f3165k;

    /* renamed from: com.shuame.mobile.module.autoboot.ui.view.a$a */
    private class C1180a extends TimerTask {
        /* renamed from: b */
        private boolean f3154b;

        private C1180a() {
            this.f3154b = false;
        }

        /* synthetic */ C1180a(C1182a c1182a, byte b) {
            this();
        }

        public final void run() {
            synchronized (C1182a.this.f3163i) {
                System.out.println("-Lock=" + C1182a.this.f3157c);
                if (C1182a.this.f3157c == 0 || C1182a.this.f3157c < C1182a.this.f3156b) {
                    C1182a.this.f3157c = C1182a.this.f3157c + 1;
                    if (!this.f3154b && C1182a.this.f3157c > C1182a.this.f3158d) {
                        C1182a.this.f3164j.sendEmptyMessage(18);
                        this.f3154b = true;
                    }
                } else if (C1182a.this.f3157c <= 0 || C1182a.this.f3157c <= C1182a.this.f3156b) {
                    cancel();
                } else {
                    C1182a.this.f3157c = C1182a.this.f3157c - 1;
                    if (!this.f3154b && C1182a.this.f3157c <= C1182a.this.f3158d) {
                        C1182a.this.f3164j.sendEmptyMessage(19);
                        this.f3154b = true;
                    }
                }
                if (C1182a.this.f3160f == null) {
                    C1182a.this.f3159e.postInvalidate();
                } else {
                    C1182a.this.f3159e.postInvalidate(C1182a.this.f3160f.left, C1182a.this.f3160f.top, C1182a.this.f3160f.right, C1182a.this.f3160f.bottom);
                }
            }
        }
    }

    /* renamed from: com.shuame.mobile.module.autoboot.ui.view.a$b */
    public interface C1181b {
    }

    public C1182a(View view) {
        this(view, (byte) 0);
    }

    private C1182a(View view, byte b) {
        this.f3155a = null;
        this.f3156b = 0;
        this.f3157c = 0;
        this.f3158d = -1;
        this.f3159e = null;
        this.f3160f = null;
        this.f3161g = null;
        this.f3162h = 0;
        this.f3163i = new Object();
        this.f3164j = new C1183b(this);
        this.f3165k = null;
        this.f3155a = new Timer();
        this.f3159e = view;
        this.f3160f = null;
        this.f3162h = 8;
    }

    /* renamed from: a */
    public final void mo6811a() {
        if (this.f3155a != null) {
            this.f3155a.cancel();
            this.f3155a = null;
        }
    }

    /* renamed from: a */
    public final void mo6812a(int i) {
        synchronized (this.f3163i) {
            this.f3156b = i;
            if (this.f3161g != null) {
                this.f3161g.cancel();
                this.f3161g = null;
            }
            if (this.f3155a != null) {
                this.f3161g = new C1180a(this, (byte) 0);
                this.f3155a.schedule(this.f3161g, 0, this.f3162h);
            }
        }
    }

    /* renamed from: b */
    public final int mo6813b() {
        int i;
        synchronized (this.f3163i) {
            i = this.f3157c;
        }
        return i;
    }
}
