package com.shuame.mobile.module.autoboot.p085ui;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.shuame.mobile.module.autoboot.ui.e */
final class C1174e implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ AutoBootManagerActivity f3121a;

    C1174e(AutoBootManagerActivity autoBootManagerActivity) {
        this.f3121a = autoBootManagerActivity;
    }

    public final void onClick(View view) {
        if (this.f3121a.f3094p && this.f3121a.f3084f.getAppNum() > 0) {
            this.f3121a.f3082d.mo6778a(this.f3121a.f3084f.getAppNum());
        }
    }
}
