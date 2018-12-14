package com.shuame.rootgenius.common.p087ui.view;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.common.C1150a;
import com.shuame.rootgenius.common.C1325c;

/* renamed from: com.shuame.rootgenius.common.ui.view.d */
final class C1381d implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1379b f3851a;

    C1381d(C1379b c1379b) {
        this.f3851a = c1379b;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("EXTAR_ACTIVITY", "MoreActivity");
        intent.setFlags(268435456);
        C1150a.m3309a(C1325c.m3724a(), intent);
    }
}
