package com.shuame.p075ad;

import android.view.View;
import android.view.ViewGroup;
import com.p070qq.p071e.ads.banner.ADSize;
import com.p070qq.p071e.ads.banner.BannerADListener;
import com.p070qq.p071e.ads.banner.BannerView;
import com.p070qq.p071e.ads.splash.SplashAD;
import com.p070qq.p071e.ads.splash.SplashADListener;

/* renamed from: com.shuame.ad.s */
class C1117s extends C1107n {
    /* renamed from: g */
    private static final String f2998g = C1117s.class.getSimpleName();
    /* renamed from: f */
    public String f2999f;
    /* renamed from: h */
    private int f3000h;
    /* renamed from: i */
    private ViewGroup f3001i;
    /* renamed from: j */
    private SplashADListener f3002j = new C1118t(this);
    /* renamed from: k */
    private BannerADListener f3003k = new C1119u(this);

    C1117s() {
    }

    /* renamed from: a */
    protected final View mo6708a() {
        new StringBuilder("loadSplash: mPositionId=").append(this.f2999f);
        this.f3001i = mo6719j();
        SplashAD splashAD = new SplashAD(this.f2968c, this.f3001i, C1106j.m3208a().mo6706d(), this.f2999f, this.f3002j);
        return this.f3001i;
    }

    /* renamed from: a */
    final void mo6711a(FragmentBuildContext fragmentBuildContext) {
        this.f2999f = fragmentBuildContext.getGdtPositionId();
        if (this.f2967b != null) {
            this.f3000h = this.f2967b.refresh;
            this.f2970e = this.f2967b.closeBtn;
        }
    }

    /* renamed from: b */
    protected final View mo6712b() {
        new StringBuilder("loadBanner: mPositionId=").append(this.f2999f).append(";   mCloseBtn=").append(this.f2970e).append(";   refresh=").append(this.f3000h);
        View bannerView = new BannerView(this.f2968c, ADSize.BANNER, C1106j.m3208a().mo6706d(), this.f2999f);
        bannerView.setRefresh(this.f3000h);
        bannerView.setShowClose(false);
        bannerView.setADListener(this.f3003k);
        bannerView.loadAD();
        return bannerView;
    }
}
