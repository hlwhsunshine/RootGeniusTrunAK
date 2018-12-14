package com.shuame.rootgenius.p115ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.common.event.C1340e;

/* renamed from: com.shuame.rootgenius.ui.i */
final class C1594i implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ BbxListActivity f4384a;

    C1594i(BbxListActivity bbxListActivity) {
        this.f4384a = bbxListActivity;
    }

    public final void onClick(View view) {
        this.f4384a.sendBroadcast(new Intent(C1340e.f3633d));
    }
}
