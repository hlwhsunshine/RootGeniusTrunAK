package com.shuame.rootgenius.appmanager.p096ui.activity;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.shuame.rootgenius.appmanager.ui.activity.i */
final class C1296i implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ RecycleBinActivity f3519a;

    C1296i(RecycleBinActivity recycleBinActivity) {
        this.f3519a = recycleBinActivity;
    }

    public final void onClick(View view) {
        new Thread(new C1297j(this)).start();
        this.f3519a.f3504g.mo6907c();
        this.f3519a.f3500c.setVisibility(8);
        this.f3519a.f3501d.setVisibility(0);
        this.f3519a.f3504g.mo6897a();
    }
}
