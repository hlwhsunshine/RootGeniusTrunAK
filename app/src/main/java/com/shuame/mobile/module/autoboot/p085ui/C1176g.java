package com.shuame.mobile.module.autoboot.p085ui;

import com.shuame.rootgenius.p098b.C1312a.C1308b;

/* renamed from: com.shuame.mobile.module.autoboot.ui.g */
final class C1176g implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f3123a;
    /* renamed from: b */
    final /* synthetic */ AutoBootManagerActivity f3124b;

    C1176g(AutoBootManagerActivity autoBootManagerActivity, int i) {
        this.f3124b = autoBootManagerActivity;
        this.f3123a = i;
    }

    public final void run() {
        if (this.f3124b.f3089k) {
            this.f3124b.f3084f.setAppNum(this.f3123a);
            if (this.f3123a == 0) {
                this.f3124b.f3087i.setBackgroundResource(C1308b.green_gradient_bg);
            } else {
                this.f3124b.f3087i.setBackgroundResource(C1308b.yellow_gradient_bg);
            }
        }
    }
}
