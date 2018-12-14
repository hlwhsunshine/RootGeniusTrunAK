package com.shuame.rootgenius.appmanager.p096ui.activity;

import com.shuame.rootgenius.appmanager.p091b.C1254a;
import com.shuame.rootgenius.appmanager.p091b.C1259d;
import com.shuame.rootgenius.appmanager.p096ui.view.SwipeDismissListView.C1291a;

/* renamed from: com.shuame.rootgenius.appmanager.ui.activity.e */
final class C1292e implements C1291a {
    /* renamed from: a */
    final /* synthetic */ AppUninstallActivity f3515a;

    C1292e(AppUninstallActivity appUninstallActivity) {
        this.f3515a = appUninstallActivity;
    }

    /* renamed from: a */
    public final void mo6961a(C1254a c1254a) {
        C1259d.m3554a(this.f3515a.f3478g).mo6899a(c1254a);
        ((AppUninstallActivity) this.f3515a.f3478g).mo6947d();
        this.f3515a.f3493v.notifyDataSetChanged();
        C1259d.f3363e = Boolean.valueOf(false);
        C1259d.f3369k = System.currentTimeMillis();
    }
}
