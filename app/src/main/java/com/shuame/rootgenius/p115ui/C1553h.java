package com.shuame.rootgenius.p115ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shuame.rootgenius.common.util.C1391d;
import com.shuame.rootgenius.hook.C1450R;

/* renamed from: com.shuame.rootgenius.ui.h */
final class C1553h extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ BbxListActivity f4381a;

    C1553h(BbxListActivity bbxListActivity) {
        this.f4381a = bbxListActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        Context context2 = this.f4381a;
        C1391d.m3891a(context2, "", context2.getResources().getString(C1450R.string.update_wifi_changed_msg), null, context2.getResources().getString(C1450R.string.string_cancel), context2.getResources().getString(C1450R.string.string_continue), C1450R.color.dialog_btn_cancel, C1450R.color.dialog_btn_confirm_green, null, new C1594i(context2));
    }
}
