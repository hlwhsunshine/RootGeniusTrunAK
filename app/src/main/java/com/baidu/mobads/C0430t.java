package com.baidu.mobads;

import com.baidu.mobads.p033g.C0291d.C0290b;
import com.baidu.mobads.p040vo.p050a.C0435c;

/* renamed from: com.baidu.mobads.t */
class C0430t implements C0290b {
    /* renamed from: a */
    final /* synthetic */ AppActivity f983a;

    C0430t(AppActivity appActivity) {
        this.f983a = appActivity;
    }

    /* renamed from: a */
    public void mo4471a() {
        C0435c c = this.f983a.f159A;
        c.f1076D++;
        this.f983a.m234g();
        this.f983a.runBottomViewExitAnimation(this.f983a.f161C, this.f983a.mBottomView);
    }

    /* renamed from: b */
    public void mo4472b() {
        C0435c c = this.f983a.f159A;
        c.f1077E++;
        this.f983a.copyCurrentPageUrl();
        this.f983a.runBottomViewExitAnimation(this.f983a.f161C, this.f983a.mBottomView);
    }

    /* renamed from: c */
    public void mo4473c() {
        C0435c c = this.f983a.f159A;
        c.f1078F++;
        this.f983a.runBottomViewExitAnimation(this.f983a.f161C, this.f983a.mBottomView);
    }
}
