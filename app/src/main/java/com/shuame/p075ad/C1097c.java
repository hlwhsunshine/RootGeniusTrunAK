package com.shuame.p075ad;

import android.support.p015v4.app.FragmentActivity;

/* renamed from: com.shuame.ad.c */
final class C1097c implements C1096w {
    /* renamed from: a */
    final /* synthetic */ C1083a f2925a;

    C1097c(C1083a c1083a) {
        this.f2925a = c1083a;
    }

    /* renamed from: a */
    public final void mo6682a(C1107n c1107n) {
        C1083a.f2891b;
        if (this.f2925a.f2898h == null && !c1107n.mo6717h() && this.f2925a.f2902l <= this.f2925a.f2899i.priority.size()) {
            this.f2925a.f2902l = this.f2925a.f2902l + 1;
            this.f2925a.f2898h = c1107n;
            this.f2925a.f2908r.removeMessages(2);
            this.f2925a.f2908r.removeMessages(3);
            if (!(this.f2925a.f2897g || this.f2925a.f2899i.getClickTimeout() == 0)) {
                this.f2925a.f2908r.sendEmptyMessageDelayed(1, (long) this.f2925a.f2899i.getClickTimeout());
            }
            if (this.f2925a.f2894d.getAdType() == AdType.SPLASH && this.f2925a.f2899i.getSplashShowTime() != 0) {
                this.f2925a.f2908r.sendEmptyMessageDelayed(5, (long) this.f2925a.f2899i.getSplashShowTime());
            }
            c1107n.mo6716g();
        }
        if (this.f2925a.f2898h != null && this.f2925a.f2898h.mo6713d()) {
            C1083a.m3156b(this.f2925a, this.f2925a.f2898h);
        }
        for (C1107n c1107n2 : this.f2925a.f2895e) {
            if (!(c1107n2 == this.f2925a.f2898h || this.f2925a.f2898h == null)) {
                C1083a.m3159c(this.f2925a, c1107n2);
            }
        }
        C1083a.f2891b;
        new StringBuilder("hadReportSuccess = ").append(c1107n.mo6715f());
        if (!c1107n.mo6715f()) {
            C1083a.m3161d(this.f2925a, c1107n);
            c1107n.mo6714e();
        }
    }

    /* renamed from: a */
    public final void mo6683a(C1107n c1107n, String str) {
        C1083a.f2891b;
        this.f2925a.f2908r.removeMessages(2);
        C1104i c1104i = new C1104i();
        c1104i.mo6701a(EventType.SOURCELOAD_EVENT_TYPE);
        c1104i.f2954p = str;
        this.f2925a.m3153a(c1107n, c1104i, 1);
        FragmentActivity activity = this.f2925a.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new C1098d(this, c1107n));
        }
    }

    /* renamed from: b */
    public final void mo6684b(C1107n c1107n) {
        C1083a.f2891b;
        this.f2925a.f2897g = true;
        this.f2925a.f2908r.removeMessages(1);
        C1104i c1104i = new C1104i();
        c1104i.mo6701a(EventType.CLICK_EVENT_TYPE);
        this.f2925a.m3153a(c1107n, c1104i, 0);
    }

    /* renamed from: c */
    public final void mo6685c(C1107n c1107n) {
        C1083a.f2891b;
        this.f2925a.f2901k = true;
        C1104i c1104i = new C1104i();
        c1104i.mo6701a(EventType.CLOSE_EVENT_TYPE);
        this.f2925a.m3153a(c1107n, c1104i, 2);
        if (AdType.BANNER.equals(c1107n.f2969d.getAdType())) {
            this.f2925a.f2900j.removeAllViews();
        }
    }

    /* renamed from: d */
    public final void mo6686d(C1107n c1107n) {
        if (c1107n == this.f2925a.f2898h || this.f2925a.f2898h == null) {
            this.f2925a.m3158c();
        }
    }

    /* renamed from: e */
    public final void mo6687e(C1107n c1107n) {
        C1083a.f2891b;
        this.f2925a.f2897g = true;
        if (this.f2925a.f2906p != null) {
            this.f2925a.f2906p.mo6725a();
        }
        this.f2925a.f2908r.removeMessages(1);
        C1104i c1104i = new C1104i();
        c1104i.mo6701a(EventType.CLICK_EVENT_TYPE);
        this.f2925a.m3153a(c1107n, c1104i, 0);
    }
}
