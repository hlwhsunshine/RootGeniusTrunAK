package com.shuame.rootgenius.p115ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.hook.C1450R;

/* renamed from: com.shuame.rootgenius.ui.aa */
final class C1500aa extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ MoreActivity f4265a;

    C1500aa(MoreActivity moreActivity) {
        this.f4265a = moreActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        if (C1323b.m3698d()) {
            this.f4265a.f4220c.setTextColor(this.f4265a.getResources().getColor(C1450R.color.selector_more_item_textview_color));
        } else {
            this.f4265a.f4220c.setTextColor(this.f4265a.getResources().getColor(C1450R.color.textcolor_dark_gray));
        }
    }
}
