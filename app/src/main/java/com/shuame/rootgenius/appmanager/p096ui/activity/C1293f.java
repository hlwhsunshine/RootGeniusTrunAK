package com.shuame.rootgenius.appmanager.p096ui.activity;

import com.shuame.rootgenius.appmanager.p091b.C1254a;
import com.shuame.rootgenius.appmanager.p091b.C1259d;
import com.shuame.rootgenius.appmanager.p096ui.view.SwipeDismissListView.C1291a;

/* renamed from: com.shuame.rootgenius.appmanager.ui.activity.f */
final class C1293f implements C1291a {
    /* renamed from: a */
    final /* synthetic */ AppUninstallActivity f3516a;

    C1293f(AppUninstallActivity appUninstallActivity) {
        this.f3516a = appUninstallActivity;
    }

    /* renamed from: a */
    public final void mo6961a(C1254a c1254a) {
        C1259d.m3554a(this.f3516a.f3478g).mo6909e().remove(c1254a);
        if (this.f3516a.f3473b.isEmpty()) {
            this.f3516a.f3488q.setVisibility(8);
            this.f3516a.f3471F.setVisibility(0);
        }
        this.f3516a.f3494w.notifyDataSetChanged();
        C1259d.f3366h = Boolean.valueOf(false);
        C1259d.f3370l = System.currentTimeMillis();
    }
}
