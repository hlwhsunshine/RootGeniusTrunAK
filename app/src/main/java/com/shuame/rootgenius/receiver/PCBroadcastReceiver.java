package com.shuame.rootgenius.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shuame.rootgenius.common.event.C1345i;

public class PCBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        C1345i.m3749a().mo7016a(intent.getStringExtra("action"));
    }
}
