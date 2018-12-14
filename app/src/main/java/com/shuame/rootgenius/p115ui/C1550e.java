package com.shuame.rootgenius.p115ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.common.event.C1340e;

/* renamed from: com.shuame.rootgenius.ui.e */
final class C1550e implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ BbxDetailActivity f4377a;

    C1550e(BbxDetailActivity bbxDetailActivity) {
        this.f4377a = bbxDetailActivity;
    }

    public final void onClick(View view) {
        this.f4377a.sendBroadcast(new Intent(C1340e.f3633d));
    }
}
