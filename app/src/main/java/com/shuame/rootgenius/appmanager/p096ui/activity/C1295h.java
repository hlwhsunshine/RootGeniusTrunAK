package com.shuame.rootgenius.appmanager.p096ui.activity;

import com.shuame.rootgenius.appmanager.p091b.C1254a;
import com.shuame.rootgenius.appmanager.p091b.C1259d;
import com.shuame.rootgenius.appmanager.p096ui.view.SwipeDismissListView.C1291a;

/* renamed from: com.shuame.rootgenius.appmanager.ui.activity.h */
final class C1295h implements C1291a {
    /* renamed from: a */
    final /* synthetic */ RecycleBinActivity f3518a;

    C1295h(RecycleBinActivity recycleBinActivity) {
        this.f3518a = recycleBinActivity;
    }

    /* renamed from: a */
    public final void mo6961a(C1254a c1254a) {
        this.f3518a.f3504g = C1259d.m3554a(this.f3518a.f3498a);
        this.f3518a.f3504g.mo6905b(c1254a);
        if (this.f3518a.f3503f.isEmpty()) {
            this.f3518a.f3500c.setVisibility(8);
            this.f3518a.f3501d.setVisibility(0);
        }
        this.f3518a.f3504g.mo6897a();
        C1259d.f3365g = Boolean.valueOf(false);
        C1259d.f3368j = System.currentTimeMillis();
    }
}
