package com.shuame.p075ad;

import android.support.p015v4.app.FragmentManager;
import com.shuame.p075ad.ChannelConfig.PositionConfig;

/* renamed from: com.shuame.ad.f */
public class C1100f {
    /* renamed from: a */
    private FragmentBuildContext f2929a = new FragmentBuildContext();
    /* renamed from: b */
    private C1101g f2930b;
    /* renamed from: c */
    private C1120v f2931c;
    /* renamed from: d */
    private C1083a f2932d;
    /* renamed from: e */
    private String f2933e = C1100f.class.getSimpleName();

    /* renamed from: d */
    public static boolean m3193d(String str) {
        PositionConfig a = C1114p.m3236a().mo6721a(str);
        return (a.getDelay() + C1114p.m3236a().mo6723b()) - System.currentTimeMillis() < 0 && a.enabled;
    }

    /* renamed from: a */
    public final C1100f mo6690a() {
        this.f2932d = new C1083a();
        this.f2932d.mo6673a(this.f2929a, this.f2930b);
        this.f2932d.mo6674a(this.f2931c);
        return this;
    }

    /* renamed from: a */
    public final C1100f mo6691a(AdType adType) {
        this.f2929a.setAdType(adType);
        return this;
    }

    /* renamed from: a */
    public final C1100f mo6692a(C1101g c1101g) {
        this.f2930b = c1101g;
        return this;
    }

    /* renamed from: a */
    public final C1100f mo6693a(C1120v c1120v) {
        this.f2931c = c1120v;
        return this;
    }

    /* renamed from: a */
    public final C1100f mo6694a(String str) {
        this.f2929a.setPositionName(str);
        return this;
    }

    /* renamed from: a */
    public final void mo6695a(FragmentManager fragmentManager, int i) {
        if (this.f2932d != null) {
            fragmentManager.beginTransaction().add(i, this.f2932d).commitAllowingStateLoss();
        }
    }

    /* renamed from: b */
    public final C1100f mo6696b(String str) {
        this.f2929a.setBaiduPositionId(str);
        return this;
    }

    /* renamed from: c */
    public final C1100f mo6697c(String str) {
        this.f2929a.setGdtPositionId(str);
        return this;
    }
}
