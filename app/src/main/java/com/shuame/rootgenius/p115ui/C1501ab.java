package com.shuame.rootgenius.p115ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.p102c.C1324a;

/* renamed from: com.shuame.rootgenius.ui.ab */
final class C1501ab implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ MoreActivity f4266a;

    C1501ab(MoreActivity moreActivity) {
        this.f4266a = moreActivity;
    }

    public final void onClick(View view) {
        this.f4266a.f4218a.clear();
        this.f4266a.f4218a.setProperty("selected", "坚持移除");
        C1324a c1324a = this.f4266a.f4219b;
        C1324a.m3723a("RemoveROOT", this.f4266a.f4218a);
        RootGeniusApp.m3523a().sendBroadcast(new Intent(C1340e.f3646q));
        this.f4266a.finish();
    }
}
