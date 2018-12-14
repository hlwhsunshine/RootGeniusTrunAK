package com.shuame.rootgenius.p115ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shuame.rootgenius.common.util.C1391d;
import com.shuame.rootgenius.hook.C1450R;

/* renamed from: com.shuame.rootgenius.ui.ak */
final class C1533ak extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ ShuameGuideActivity f4350a;

    C1533ak(ShuameGuideActivity shuameGuideActivity) {
        this.f4350a = shuameGuideActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        Context context2 = this.f4350a;
        C1391d.m3891a(context2, "", context2.getResources().getString(C1450R.string.update_wifi_changed_msg), null, context2.getResources().getString(C1450R.string.string_cancel), context2.getResources().getString(C1450R.string.string_continue), C1450R.color.dialog_btn_cancel, C1450R.color.dialog_btn_confirm_green, null, new C1534al(context2));
    }
}
