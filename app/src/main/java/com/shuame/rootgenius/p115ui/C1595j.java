package com.shuame.rootgenius.p115ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shuame.rootgenius.common.event.C1340e;

/* renamed from: com.shuame.rootgenius.ui.j */
final class C1595j extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ FontPreviewActivity f4385a;

    C1595j(FontPreviewActivity fontPreviewActivity) {
        this.f4385a = fontPreviewActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(C1340e.f3640k)) {
            this.f4385a.finish();
        }
    }
}
