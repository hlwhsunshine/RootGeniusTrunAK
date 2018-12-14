package com.shuame.rootgenius.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.shuame.rootgenius.C1446g;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.common.util.C1389b;
import com.shuame.rootgenius.common.util.C1397j;
import com.shuame.rootgenius.common.util.NetworkUtils;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.hook.util.HookManager;
import com.shuame.rootgenius.pojo.C1459a;
import com.shuame.rootgenius.sdk.RootGenius;
import com.shuame.rootgenius.service.C1488f;
import com.shuame.rootgenius.service.C1492j;

public class CheckAuthComponentUpdateReceiver extends BroadcastReceiver implements Runnable {
    /* renamed from: a */
    private static final String f4020a = CheckAuthComponentUpdateReceiver.class.getSimpleName();
    /* renamed from: b */
    private static boolean f4021b = false;

    public void onReceive(Context context, Intent intent) {
        Object obj = null;
        Object obj2 = 1;
        if (!f4021b) {
            if (NetworkUtils.m3852b()) {
                int b = C1387ad.m3869b(RootGeniusApp.m3523a());
                C1446g.m4003a();
                long currentTimeMillis = (System.currentTimeMillis() - C1446g.m4012f()) / 1000;
                if ((currentTimeMillis <= 172800 || b == -1) && ((currentTimeMillis <= 86400 || b != 0) && (currentTimeMillis <= 21600 || b != 1))) {
                    obj2 = null;
                }
                obj = obj2;
            }
            if (obj != null) {
                new Thread(this).start();
                C1446g.m4003a();
                C1446g.m4011e();
                HookManager.registerHook();
            }
        }
    }

    public void run() {
        f4021b = true;
        C1446g.m4003a();
        if (C1446g.m4014h() && RootGenius.checkRootState() && C1488f.m4146b().mo7311d()) {
            if (C1387ad.m3866a()) {
                String string = RootGeniusApp.m3523a().getString(C1450R.string.notify_component_update_title);
                CharSequence string2 = RootGeniusApp.m3523a().getString(C1450R.string.notify_component_update_msg);
                C1492j.m4165a();
                C1492j.m4168a(RootGeniusApp.m3523a(), string, string2);
            }
            if (NetworkUtils.m3854d()) {
                C1459a a = C1488f.m4146b().mo7309a();
                if ((a.f4005d == null || !a.f4005d.equals(RootGenius.getBuildInKinguserMd5())) && a.mo7241a()) {
                    QQDownloadFile a2 = C1361b.m3817a().mo7068a(C1361b.m3815a(a.f4003b));
                    if (a2 == null) {
                        a2 = a.mo7242b();
                        a2.f3725f = C1397j.m3902b(a2);
                    }
                    C1389b.m3884a();
                    if (C1389b.m3886a(false)) {
                        C1389b.m3884a();
                        if (C1389b.m3885a(a2, false)) {
                            C1361b.m3817a().mo7067a(a2, null);
                        }
                    }
                }
            }
            RootGeniusApp.m3523a().sendBroadcast(new Intent(C1340e.f3643n));
        }
        f4021b = false;
    }
}
