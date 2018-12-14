package com.shuame.rootgenius.receiver;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.shuame.rootgenius.C1446g;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.common.util.NetworkUtils;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p115ui.homepage.HomepageActivity;
import com.shuame.rootgenius.sdk.RootGenius;
import com.shuame.rootgenius.sdk.proto.ProtoData.QuerySupportResult;
import com.shuame.rootgenius.service.C1492j;

public class CheckNewSupportRootReceiver extends BroadcastReceiver implements Runnable {
    /* renamed from: a */
    private static final String f4022a = CheckNewSupportRootReceiver.class.getSimpleName();
    /* renamed from: b */
    private static boolean f4023b = false;

    public void onReceive(Context context, Intent intent) {
        Object obj = null;
        Object obj2 = 1;
        if (!f4023b) {
            if (NetworkUtils.m3852b()) {
                int b = C1387ad.m3869b(RootGeniusApp.m3523a());
                C1446g.m4003a();
                long g = C1446g.m4013g();
                long currentTimeMillis = System.currentTimeMillis();
                long j = (currentTimeMillis - g) / 1000;
                new StringBuilder("lastCheckTime:").append(g).append(",currTime:").append(currentTimeMillis).append(",timeDiff:").append(j);
                if ((j < 345600 || b == -1) && ((j < 172800 || b != 0) && (j < 43200 || b != 1))) {
                    obj2 = null;
                }
                obj = obj2;
            }
            if (obj != null && !C1323b.m3701f()) {
                C1446g.m4003a();
                C1446g.m4010d();
                new Thread(this).start();
            }
        }
    }

    public void run() {
        f4023b = true;
        while (!C1323b.m3695c()) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
        if (!C1323b.m3698d() && !C1323b.m3712q()) {
            if (RootGenius.querySupport(RootGeniusApp.m3523a()) == QuerySupportResult.Support) {
                String string = RootGeniusApp.m3523a().getResources().getString(C1450R.string.notify_new_support_root_title);
                String string2 = RootGeniusApp.m3523a().getResources().getString(C1450R.string.notify_new_support_root_msg);
                String str = Build.MANUFACTURER;
                String str2 = Build.MODEL;
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                str = str2.toLowerCase().contains(str.toLowerCase()) ? str2.trim() : str.trim() + " " + str2.trim();
                C1323b.m3688a();
                CharSequence m = C1323b.m3708m();
                if (!TextUtils.isEmpty(m)) {
                    str = m;
                }
                CharSequence format = String.format(string2, new Object[]{str});
                Context a = RootGeniusApp.m3523a();
                Intent intent = new Intent(a, HomepageActivity.class);
                intent.setAction(C1340e.f3637h);
                PendingIntent activity = PendingIntent.getActivity(a, 0, intent, 134217728);
                C1492j.m4165a();
                C1492j.m4169a(RootGeniusApp.m3523a(), string, format, activity);
                C1323b.m3702g();
            }
            f4023b = false;
        }
    }
}
