package com.shuame.rootgenius.p115ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.common.event.C1340e;

/* renamed from: com.shuame.rootgenius.ui.al */
final class C1534al implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ ShuameGuideActivity f4351a;

    C1534al(ShuameGuideActivity shuameGuideActivity) {
        this.f4351a = shuameGuideActivity;
    }

    public final void onClick(View view) {
        this.f4351a.sendBroadcast(new Intent(C1340e.f3633d));
    }
}
