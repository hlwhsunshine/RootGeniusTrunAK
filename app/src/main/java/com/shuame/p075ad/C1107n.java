package com.shuame.p075ad;

import android.app.Activity;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.shuame.p075ad.C1090ad.C1087a;
import com.shuame.p075ad.ChannelConfig.PositionConfig.SourceDetails;

/* renamed from: com.shuame.ad.n */
abstract class C1107n {
    /* renamed from: f */
    private static final String f2965f = C1107n.class.getSimpleName();
    /* renamed from: a */
    protected C1096w f2966a;
    /* renamed from: b */
    protected SourceDetails f2967b;
    /* renamed from: c */
    protected Activity f2968c;
    /* renamed from: d */
    protected FragmentBuildContext f2969d;
    /* renamed from: e */
    protected boolean f2970e;
    /* renamed from: g */
    private View f2971g;
    /* renamed from: h */
    private long f2972h;
    /* renamed from: i */
    private boolean f2973i = false;
    /* renamed from: j */
    private boolean f2974j = false;
    /* renamed from: k */
    private AdType f2975k;

    C1107n() {
    }

    /* renamed from: a */
    protected abstract View mo6708a();

    /* renamed from: a */
    protected final View mo6709a(AdType adType) {
        this.f2975k = adType;
        this.f2972h = SystemClock.elapsedRealtime();
        if (this.f2971g == null) {
            switch (C1111o.f2983a[adType.ordinal()]) {
                case 1:
                    this.f2971g = mo6712b();
                    break;
                case 2:
                    this.f2971g = mo6708a();
                    break;
            }
        }
        return this.f2971g;
    }

    /* renamed from: a */
    final void mo6710a(Activity activity, SourceDetails sourceDetails, C1096w c1096w, FragmentBuildContext fragmentBuildContext) {
        this.f2966a = c1096w;
        this.f2967b = sourceDetails;
        this.f2968c = activity;
        this.f2969d = fragmentBuildContext;
        mo6711a(fragmentBuildContext);
    }

    /* renamed from: a */
    abstract void mo6711a(FragmentBuildContext fragmentBuildContext);

    /* renamed from: b */
    protected abstract View mo6712b();

    /* renamed from: d */
    final boolean mo6713d() {
        return this.f2970e;
    }

    /* renamed from: e */
    protected final void mo6714e() {
        this.f2973i = true;
    }

    /* renamed from: f */
    protected final boolean mo6715f() {
        return this.f2973i;
    }

    /* renamed from: g */
    protected final void mo6716g() {
        this.f2974j = true;
    }

    /* renamed from: h */
    protected final boolean mo6717h() {
        return this.f2974j;
    }

    /* renamed from: i */
    protected final long mo6718i() {
        return this.f2972h;
    }

    /* renamed from: j */
    protected final ViewGroup mo6719j() {
        ViewGroup relativeLayout = new RelativeLayout(this.f2968c);
        switch (C1111o.f2983a[this.f2975k.ordinal()]) {
            case 1:
                relativeLayout.setLayoutParams(new LayoutParams(-1, -2));
                break;
            case 2:
                relativeLayout.setLayoutParams(new LayoutParams(-1, -1));
                relativeLayout.setMinimumHeight(((int) this.f2968c.getResources().getDimension(C1087a.gdt_splash_minimum_height)) + 1);
                break;
        }
        return relativeLayout;
    }

    /* renamed from: k */
    protected final View mo6720k() {
        return this.f2971g;
    }
}
