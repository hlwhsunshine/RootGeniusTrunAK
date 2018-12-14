package com.shuame.mobile.module.autoboot.p085ui.p086a;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.C1325c;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.event.C1345i;
import com.shuame.rootgenius.common.util.C1416x;
import com.shuame.rootgenius.p098b.C1312a.C1311e;

/* renamed from: com.shuame.mobile.module.autoboot.ui.a.b */
final class C1168b implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1167a f3112a;

    C1168b(C1167a c1167a) {
        this.f3112a = c1167a;
    }

    public final void onClick(View view) {
        if (C1345i.m3749a().mo7020b()) {
            C1416x.m3936a(C1311e.jointed_core_func_goto_pc_operation);
            return;
        }
        C1325c.m3724a().sendBroadcast(new Intent(C1340e.f3640k));
        C1323b.m3688a().mo6998d("autoboot");
        C1323b.m3697d(true);
        this.f3112a.f3105d.finish();
    }
}
