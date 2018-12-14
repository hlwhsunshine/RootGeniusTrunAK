package com.shuame.rootgenius.common.util;

import android.content.Context;
import android.preference.PreferenceManager;
import com.lzyblog.uninstalldemo.UninstalledObserver;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.C1325c;

/* renamed from: com.shuame.rootgenius.common.util.ac */
final class C1386ac extends Thread {
    /* renamed from: a */
    final /* synthetic */ Context f3857a;

    C1386ac(Context context) {
        this.f3857a = context;
    }

    public final void run() {
        while (!C1323b.m3695c()) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
        int a = UninstalledObserver.m2505a(this.f3857a).mo6021a(C1385ab.m3861a());
        PreferenceManager.getDefaultSharedPreferences(C1325c.m3724a()).edit().putInt("observerProcessPid", a).commit();
        C1385ab.f3856a;
    }
}
