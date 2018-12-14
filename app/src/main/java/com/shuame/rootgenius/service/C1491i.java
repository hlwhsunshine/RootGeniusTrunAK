package com.shuame.rootgenius.service;

import com.shuame.rootgenius.pojo.C1461c;

/* renamed from: com.shuame.rootgenius.service.i */
public final class C1491i {
    /* renamed from: a */
    private static C1491i f4105a = new C1491i();
    /* renamed from: b */
    private C1461c f4106b = new C1461c();
    /* renamed from: c */
    private boolean f4107c = false;

    /* renamed from: a */
    public static C1491i m4161a() {
        return f4105a;
    }

    /* renamed from: a */
    public final void mo7315a(C1461c c1461c) {
        this.f4106b = c1461c;
    }

    /* renamed from: b */
    public final C1461c mo7316b() {
        if (this.f4106b == null) {
            this.f4106b = new C1461c();
        }
        return this.f4106b;
    }

    /* renamed from: c */
    public final boolean mo7317c() {
        if (!this.f4107c) {
            this.f4107c = true;
            C1489g.m4151a().mo7312a(false);
            this.f4107c = false;
        }
        return this.f4107c;
    }
}
