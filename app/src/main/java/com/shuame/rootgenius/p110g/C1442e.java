package com.shuame.rootgenius.p110g;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.event.C1345i;
import com.shuame.rootgenius.common.util.C1416x;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p115ui.dialog.C1549b;

/* renamed from: com.shuame.rootgenius.g.e */
final class C1442e implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ Context f3965a;
    /* renamed from: b */
    final /* synthetic */ C1549b f3966b;
    /* renamed from: c */
    final /* synthetic */ C1440c f3967c;

    C1442e(C1440c c1440c, Context context, C1549b c1549b) {
        this.f3967c = c1440c;
        this.f3965a = context;
        this.f3966b = c1549b;
    }

    public final void onClick(View view) {
        if (C1345i.m3749a().mo7020b()) {
            C1416x.m3936a((int) C1450R.string.jointed_core_func_goto_pc_operation);
        } else {
            C1323b.m3697d(true);
            C1323b.m3688a().mo6998d("huangeziti");
            this.f3965a.sendBroadcast(new Intent(C1340e.f3640k));
        }
        this.f3966b.dismiss();
    }
}
