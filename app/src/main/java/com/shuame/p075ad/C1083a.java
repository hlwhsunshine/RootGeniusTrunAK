package com.shuame.p075ad;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.p015v4.app.Fragment;
import android.support.p015v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.baidu.mobads.production.BaiduXAdSDKContext;
import com.shuame.p075ad.C1090ad.C1087a;
import com.shuame.p075ad.C1090ad.C1088b;
import com.shuame.p075ad.C1090ad.C1089c;
import com.shuame.p075ad.ChannelConfig.PositionConfig;
import com.shuame.reportsdk.C1103b;
import com.shuame.reportsdk.ReportSdk;
import com.shuame.utils.C1621e;
import com.shuame.utils.NetworkUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.shuame.ad.a */
public class C1083a extends Fragment {
    /* renamed from: b */
    private static final String f2891b = C1083a.class.getSimpleName();
    /* renamed from: c */
    private static String f2892c = "context_key";
    /* renamed from: a */
    public boolean f2893a = false;
    /* renamed from: d */
    private FragmentBuildContext f2894d;
    /* renamed from: e */
    private List<C1107n> f2895e = new ArrayList();
    /* renamed from: f */
    private int f2896f = 0;
    /* renamed from: g */
    private boolean f2897g = false;
    /* renamed from: h */
    private C1107n f2898h;
    /* renamed from: i */
    private PositionConfig f2899i;
    /* renamed from: j */
    private ViewGroup f2900j;
    /* renamed from: k */
    private boolean f2901k = false;
    /* renamed from: l */
    private int f2902l = 0;
    /* renamed from: m */
    private C1101g f2903m;
    /* renamed from: n */
    private boolean f2904n = false;
    /* renamed from: o */
    private boolean f2905o;
    /* renamed from: p */
    private C1120v f2906p;
    /* renamed from: q */
    private C1096w f2907q = new C1097c(this);
    /* renamed from: r */
    private Handler f2908r = new C1099e(this);

    /* renamed from: a */
    private void m3153a(C1107n c1107n, C1104i c1104i, int i) {
        if (c1107n != null && c1107n.f2967b != null) {
            c1104i.f2953o = i;
            c1104i.f2951m = this.f2902l;
            c1104i.f2955q = (long) this.f2899i.getFailTimeout();
            c1104i.f2947i = this.f2899i.getName();
            c1104i.f2949k = c1107n.f2967b.source;
            if ("mssp".equals(c1104i.f2949k)) {
                c1104i.f2948j = c1107n.f2969d.getBaiduPositionId();
            } else {
                if ("guangdiantong".equals(c1104i.f2949k)) {
                    c1104i.f2948j = c1107n.f2969d.getGdtPositionId();
                }
            }
            c1104i.f2950l = this.f2899i.priority.indexOf(c1104i.f2949k) + 1;
            c1104i.f2957s = C1621e.m4393a();
            try {
                ReportManager.m3144a().mo6672a(c1104i);
                ReportSdk.m3503a((C1103b) c1104i);
            } catch (InterruptedException e) {
            }
        }
    }

    /* renamed from: b */
    private void m3155b() {
        if (getActivity() != null && this.f2899i.isEnabled() && this.f2898h == null && !this.f2901k && this.f2896f != this.f2895e.size() && NetworkUtils.m4385a(getActivity())) {
            C1107n c1107n = (C1107n) this.f2895e.get(this.f2896f);
            if (c1107n != null) {
                this.f2896f++;
                this.f2900j.addView(c1107n.mo6709a(this.f2894d.getAdType()), 0);
                if (!this.f2904n) {
                    this.f2900j.findViewById(C1088b.ivClose).setVisibility(8);
                    this.f2904n = true;
                }
                if (this.f2899i.getFailTimeout() == 0) {
                    this.f2908r.sendEmptyMessageDelayed(2, 5000);
                } else if (this.f2894d.getAdType() == AdType.SPLASH) {
                    this.f2908r.sendEmptyMessageDelayed(2, (long) (this.f2899i.getSplashLoadTime() == 0 ? 5000 : this.f2899i.getSplashLoadTime()));
                } else {
                    this.f2908r.sendEmptyMessageDelayed(2, (long) this.f2899i.getFailTimeout());
                }
            }
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m3156b(C1083a c1083a, C1107n c1107n) {
        AdType adType = c1083a.f2894d.getAdType();
        if (adType != AdType.BANNER && c1083a.isAdded()) {
            LayoutParams layoutParams;
            if (adType == AdType.SPLASH) {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(11);
                layoutParams.topMargin = c1083a.getResources().getDimensionPixelSize(C1087a.mssp_splash_close_margin_top);
                layoutParams.rightMargin = c1083a.getResources().getDimensionPixelSize(C1087a.mssp_splash_close_margin_right);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(c1083a.getResources().getDimensionPixelSize(C1087a.mssp_banner_close_height), c1083a.getResources().getDimensionPixelSize(C1087a.mssp_banner_close_width));
                layoutParams.topMargin = c1083a.getResources().getDimensionPixelSize(C1087a.mssp_banner_close_margin_top);
                layoutParams.leftMargin = c1083a.getResources().getDimensionPixelSize(C1087a.mssp_banner_close_margin_left);
                layoutParams.addRule(9);
            }
            View findViewById = c1083a.f2900j.findViewById(C1088b.ivClose);
            findViewById.setVisibility(0);
            findViewById.setLayoutParams(layoutParams);
            findViewById.setOnClickListener(new C1095b(c1083a, c1107n));
        }
    }

    /* renamed from: c */
    private void m3158c() {
        if (!this.f2893a) {
            this.f2893a = true;
        } else if (this.f2903m != null) {
            this.f2903m.onAdDismissed();
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m3159c(C1083a c1083a, C1107n c1107n) {
        View k = c1107n.mo6720k();
        if (k != null) {
            k.setVisibility(8);
            c1083a.f2900j.removeView(k);
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m3161d(C1083a c1083a, C1107n c1107n) {
        FragmentActivity activity = c1083a.getActivity();
        C1104i c1104i = new C1104i();
        c1104i.mo6701a(EventType.SOURCELOAD_EVENT_TYPE);
        c1104i.f2956r = SystemClock.elapsedRealtime() - c1107n.mo6718i();
        if (c1107n != c1083a.f2898h || activity == null || activity.isFinishing() || c1083a.f2905o || c1083a.isDetached() || c1083a.isHidden()) {
            c1104i.f2954p = "";
            if (c1107n != c1083a.f2898h) {
                c1104i.f2954p = " ad had show ";
            }
            if (activity == null) {
                c1104i.f2954p += " ac null ";
            }
            if (activity != null && activity.isFinishing()) {
                c1104i.f2954p += " ac isFinishing ";
            }
            if (c1083a.isDetached() || c1083a.f2905o) {
                c1104i.f2954p += " fragment destroy ";
            }
            if (c1083a.isHidden()) {
                c1104i.f2954p += " fragment isHidden ";
            }
        } else if (c1083a.f2894d.getAdType() != AdType.SPLASH || c1104i.f2956r <= ((long) c1083a.f2899i.getFailTimeout())) {
            c1083a.m3153a(c1107n, c1104i, 0);
            return;
        } else {
            c1104i.f2954p = "startup time out";
        }
        c1083a.m3153a(c1107n, c1104i, 1);
    }

    /* renamed from: p */
    static /* synthetic */ void m3173p(C1083a c1083a) {
        c1083a.f2898h = null;
        c1083a.m3155b();
    }

    /* renamed from: a */
    protected final void mo6673a(FragmentBuildContext fragmentBuildContext, C1101g c1101g) {
        this.f2903m = c1101g;
        this.f2894d = fragmentBuildContext;
        Bundle bundle = new Bundle();
        bundle.putSerializable(f2892c, fragmentBuildContext);
        setArguments(bundle);
    }

    /* renamed from: a */
    protected final void mo6674a(C1120v c1120v) {
        this.f2906p = c1120v;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1089c.ad_fragment_layout, null);
        this.f2900j = (ViewGroup) inflate;
        Bundle arguments = getArguments();
        if (this.f2894d == null) {
            this.f2894d = (FragmentBuildContext) arguments.getSerializable(f2892c);
        }
        this.f2899i = C1114p.m3236a().mo6721a(this.f2894d.getPositionName());
        this.f2899i.toString();
        long delay = (this.f2899i.getDelay() + C1114p.m3236a().mo6723b()) - System.currentTimeMillis();
        C1102h c1102h = new C1102h(getActivity(), this.f2899i, this.f2907q, this.f2894d);
        if (delay < 0) {
            new StringBuilder("getFailTimeout = ").append(this.f2899i.getFailTimeout());
            this.f2908r.sendEmptyMessageDelayed(3, (long) this.f2899i.getFailTimeout());
            Context c = C1106j.m3208a().mo6705c();
            for (String a : this.f2899i.priority) {
                C1107n a2 = c1102h.mo6699a(c, a);
                if (a2 != null) {
                    this.f2895e.add(a2);
                }
            }
        }
        m3155b();
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f2905o = true;
        this.f2908r.removeMessages(1);
        this.f2908r.removeMessages(2);
        this.f2908r.removeMessages(3);
        this.f2900j.removeAllViews();
        BaiduXAdSDKContext.exit();
    }

    public void onPause() {
        super.onPause();
        this.f2893a = false;
    }

    public void onResume() {
        super.onResume();
        if (this.f2893a) {
            m3158c();
        }
        this.f2893a = true;
    }
}
