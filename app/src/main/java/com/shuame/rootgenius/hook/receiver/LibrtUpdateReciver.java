package com.shuame.rootgenius.hook.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shuame.rootgenius.hook.util.HookManager;

public class LibrtUpdateReciver extends BroadcastReceiver {
    private static final String TAG = LibrtUpdateReciver.class.getSimpleName();

    public void onReceive(Context context, Intent intent) {
        HookManager.registerHook();
    }
}
