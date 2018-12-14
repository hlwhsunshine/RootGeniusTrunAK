package com.shuame.p075ad;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.baidu.mobads.AdView;
import com.baidu.mobads.AdViewListener;
import com.baidu.mobads.AppActivity;
import com.baidu.mobads.AppActivity.ActionBarColorTheme;
import com.baidu.mobads.SplashAd;
import com.baidu.mobads.SplashAdListener;

/* renamed from: com.shuame.ad.k */
class C1108k extends C1107n {
    /* renamed from: f */
    private static final String f2976f = C1108k.class.getSimpleName();
    /* renamed from: g */
    private String f2977g = "";
    /* renamed from: h */
    private ViewGroup f2978h;
    /* renamed from: i */
    private SplashAdListener f2979i = new C1109l(this);
    /* renamed from: j */
    private AdViewListener f2980j = new C1110m(this);

    C1108k() {
    }

    /* renamed from: a */
    protected final View mo6708a() {
        new StringBuilder("mAdPlaceId=").append(this.f2977g);
        this.f2978h = mo6719j();
        SplashAd splashAd = new SplashAd(this.f2968c, this.f2978h, this.f2979i, this.f2977g, true);
        return this.f2978h;
    }

    /* renamed from: a */
    final void mo6711a(FragmentBuildContext fragmentBuildContext) {
        this.f2977g = fragmentBuildContext.getBaiduPositionId();
        if (this.f2967b != null) {
            this.f2970e = this.f2967b.closeBtn;
        }
    }

    /* renamed from: b */
    protected final View mo6712b() {
        AppActivity.setActionBarColorTheme(ActionBarColorTheme.ACTION_BAR_WHITE_THEME);
        View adView = new AdView(this.f2968c, this.f2977g);
        adView.setListener(this.f2980j);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        View j = mo6719j();
        j.addView(adView, layoutParams);
        return j;
    }
}
