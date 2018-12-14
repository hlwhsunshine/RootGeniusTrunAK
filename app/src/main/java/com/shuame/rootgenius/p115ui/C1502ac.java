package com.shuame.rootgenius.p115ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.common.p102c.C1324a;

/* renamed from: com.shuame.rootgenius.ui.ac */
final class C1502ac implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ MoreActivity f4267a;

    C1502ac(MoreActivity moreActivity) {
        this.f4267a = moreActivity;
    }

    public final void onClick(View view) {
        this.f4267a.f4218a.clear();
        this.f4267a.f4218a.setProperty("selected", "保留特权");
        C1324a c1324a = this.f4267a.f4219b;
        C1324a.m3723a("RemoveROOT", this.f4267a.f4218a);
    }
}
