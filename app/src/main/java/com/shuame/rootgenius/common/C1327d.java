package com.shuame.rootgenius.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shuame.rootgenius.common.event.C1345i;

/* renamed from: com.shuame.rootgenius.common.d */
final class C1327d extends BroadcastReceiver {
    C1327d() {
    }

    public final void onReceive(Context context, Intent intent) {
        if (!"android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
            return;
        }
        if (2 == intent.getIntExtra("plugged", -1)) {
            C1345i.m3749a().mo7017a(true);
        } else {
            C1345i.m3749a().mo7017a(false);
        }
    }
}
