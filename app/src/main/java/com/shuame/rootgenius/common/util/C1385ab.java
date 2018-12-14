package com.shuame.rootgenius.common.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.preference.PreferenceManager;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.C1325c;
import com.shuame.rootgenius.sdk.CommUtils;
import com.shuame.rootgenius.sdk.RootGenius;

/* renamed from: com.shuame.rootgenius.common.util.ab */
public class C1385ab {
    /* renamed from: a */
    private static final String f3856a = C1385ab.class.getSimpleName();

    /* renamed from: a */
    static /* synthetic */ String m3861a() {
        int versionCode = CommUtils.getVersionCode(C1325c.m3724a());
        C1323b.m3688a();
        String n = C1323b.m3709n();
        String str = RootGenius.GetDeviceInfo().phoneId.rid;
        String d = C1387ad.m3874d(C1325c.m3724a());
        String a = C1387ad.m3865a(true);
        String str2 = "http://m.shuame.%s/uninstall/root?channelName=%s&versionCode=%d&rid=%s&mac=%s&qimei=%s";
        Object[] objArr = new Object[6];
        objArr[0] = C1412t.f3902a ? "org" : "com";
        objArr[1] = n;
        objArr[2] = Integer.valueOf(versionCode);
        objArr[3] = str;
        objArr[4] = d;
        objArr[5] = a;
        return String.format(str2, objArr);
    }

    /* renamed from: a */
    public static void m3862a(Context context) {
        int i = 0;
        int i2 = PreferenceManager.getDefaultSharedPreferences(C1325c.m3724a()).getInt("observerProcessPid", 0);
        if (i2 > 0) {
            Process.killProcess(i2);
        }
        if (new Intent("android.intent.action.VIEW", Uri.parse("http://m.shuame.com/uninstall/root")).resolveActivity(context.getPackageManager()) != null) {
            i = 1;
        }
        if (i != 0) {
            new C1386ac(context).start();
        }
    }
}
