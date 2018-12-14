package com.shuame.rootgenius.appmanager.p096ui.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.event.C1345i;
import com.shuame.rootgenius.common.util.C1416x;
import com.shuame.rootgenius.p089a.C1248a.C1247e;

/* renamed from: com.shuame.rootgenius.appmanager.ui.activity.b */
final class C1288b implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1287a f3512a;

    C1288b(C1287a c1287a) {
        this.f3512a = c1287a;
    }

    public final void onClick(View view) {
        if (C1345i.m3749a().mo7020b()) {
            C1416x.m3936a(C1247e.jointed_core_func_goto_pc_operation);
            return;
        }
        this.f3512a.f3511a.sendBroadcast(new Intent(C1340e.f3640k));
        C1323b.m3688a().mo6998d("appuninstall");
        C1323b.m3697d(true);
        this.f3512a.f3511a.finish();
    }
}
