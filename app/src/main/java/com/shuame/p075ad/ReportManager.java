package com.shuame.p075ad;

import android.content.Context;
import android.text.TextUtils;
import com.shuame.p074a.C1081a;
import com.shuame.reportsdk.ReportSdk;
import com.shuame.utils.C1618b;
import com.shuame.utils.C1619c;
import com.shuame.utils.C1621e;

/* renamed from: com.shuame.ad.ReportManager */
class ReportManager {
    /* renamed from: a */
    private static final String f2880a = ReportManager.class.getSimpleName();
    /* renamed from: b */
    private String f2881b;
    /* renamed from: c */
    private String f2882c;
    /* renamed from: d */
    private int f2883d;
    /* renamed from: e */
    private String f2884e;
    /* renamed from: f */
    private String f2885f;
    /* renamed from: g */
    private String f2886g;
    /* renamed from: h */
    private String f2887h;
    /* renamed from: i */
    private String f2888i;
    /* renamed from: j */
    private volatile InitStatus f2889j;
    /* renamed from: k */
    private Context f2890k;

    /* renamed from: com.shuame.ad.ReportManager$InitStatus */
    private enum InitStatus {
        NOT_READY,
        INITING,
        FAILED,
        FINISH
    }

    /* renamed from: com.shuame.ad.ReportManager$a */
    private static class C1082a {
        /* renamed from: a */
        private static ReportManager f2879a = new ReportManager();
    }

    private ReportManager() {
        this.f2889j = InitStatus.NOT_READY;
    }

    /* synthetic */ ReportManager(byte b) {
        this();
    }

    /* renamed from: a */
    protected static ReportManager m3144a() {
        return C1082a.f2879a;
    }

    /* renamed from: a */
    private void m3145a(Context context) {
        try {
            synchronized (this) {
                this.f2881b = context.getPackageName();
                this.f2882c = C1621e.m4398e(context);
                this.f2883d = C1621e.m4399f(context);
                this.f2884e = C1621e.m4396c(context);
                this.f2885f = C1621e.m4397d(context);
                this.f2887h = C1621e.m4395b(context);
                TextUtils.isEmpty(this.f2887h);
                this.f2889j = InitStatus.FINISH;
                notifyAll();
            }
        } catch (Exception e) {
            synchronized (this) {
                this.f2889j = InitStatus.FAILED;
                notifyAll();
            }
        }
    }

    /* renamed from: b */
    private synchronized void m3146b() {
        if (this.f2889j == InitStatus.NOT_READY || this.f2889j == InitStatus.FAILED) {
            m3145a(this.f2890k);
        }
        while (this.f2889j == InitStatus.INITING) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return;
    }

    /* renamed from: a */
    protected final void mo6671a(Context context, boolean z) {
        this.f2890k = context;
        m3145a(context);
        if (z) {
            ReportSdk.m3502a(context);
            ReportSdk.m3504a(C1106j.m3208a().mo6707f() ? "http://api.shuame.org" : "http://api.shuame.com");
            ReportSdk.m3505a(C1619c.f4580c);
        }
    }

    /* renamed from: a */
    public final synchronized boolean mo6672a(C1104i c1104i) {
        boolean z = true;
        synchronized (this) {
            m3146b();
            if (this.f2889j == InitStatus.FAILED) {
                z = false;
            } else {
                if (TextUtils.isEmpty(this.f2887h)) {
                    this.f2887h = C1621e.m4395b(this.f2890k);
                }
                if (TextUtils.isEmpty(this.f2884e)) {
                    this.f2884e = C1621e.m4396c(this.f2890k);
                }
                if (TextUtils.isEmpty(this.f2886g)) {
                    this.f2886g = C1081a.m3141a(true);
                }
                if (TextUtils.isEmpty(c1104i.f2944f)) {
                    c1104i.f2944f = this.f2887h;
                }
                if (TextUtils.isEmpty(c1104i.f2939a)) {
                    c1104i.f2939a = this.f2884e;
                }
                if (TextUtils.isEmpty(c1104i.f2940b)) {
                    c1104i.f2940b = this.f2885f;
                }
                if (c1104i.f2945g == 0) {
                    c1104i.f2945g = this.f2883d;
                }
                if (TextUtils.isEmpty(c1104i.f2942d)) {
                    c1104i.f2942d = this.f2882c;
                }
                if (TextUtils.isEmpty(c1104i.f2943e)) {
                    c1104i.f2943e = this.f2881b;
                }
                if (c1104i.f2946h == null) {
                    c1104i.f2946h = C1618b.m4388a(this.f2890k);
                }
                if (TextUtils.isEmpty(c1104i.f2958t)) {
                    c1104i.f2958t = this.f2888i;
                }
                if (TextUtils.isEmpty(c1104i.f2941c)) {
                    if (TextUtils.isEmpty(this.f2886g)) {
                        c1104i.f2941c = null;
                    } else {
                        c1104i.f2941c = this.f2886g;
                    }
                }
            }
        }
        return z;
    }
}
