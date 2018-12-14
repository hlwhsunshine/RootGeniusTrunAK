package com.baidu.mobads.production.p039a;

import com.baidu.mobads.p021j.C0338m;

/* renamed from: com.baidu.mobads.production.a.b */
class C0377b implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0376a f836a;

    C0377b(C0376a c0376a) {
        this.f836a = c0376a;
    }

    public void run() {
        C0338m.m569a().mo5040m().getBaiduMapsInfo(this.f836a.f815f);
        C0338m.m569a().mo5041n().getCUID(this.f836a.f815f);
        C0338m.m569a().mo5041n().getCell(this.f836a.f815f);
        C0338m.m569a().mo5041n().getAppSDC();
        C0338m.m569a().mo5041n().getWIFI(this.f836a.f815f);
        C0338m.m569a().mo5041n().getGPS(this.f836a.f815f);
        C0338m.m569a().mo5041n().getNetType(this.f836a.f815f);
        C0338m.m569a().mo5041n().getAppSDC();
        C0338m.m569a().mo5041n().getMem();
        C0338m.m569a().mo5041n().getAndroidId(this.f836a.f815f);
        C0338m.m569a().mo5040m().createRequestId(this.f836a.f815f, "");
    }
}
