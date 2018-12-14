package com.shuame.rootgenius;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import com.shuame.mobile.module.autoboot.C1151a;
import com.shuame.p075ad.C1106j;
import com.shuame.rootgenius.appmanager.C1253a;
import com.shuame.rootgenius.common.C1325c;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.event.C1345i;
import com.shuame.rootgenius.common.manager.AppManager;
import com.shuame.rootgenius.common.p101b.C1321b;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Type;
import com.shuame.rootgenius.common.util.C1385ab;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.common.util.C1390c;
import com.shuame.rootgenius.common.util.C1408q;
import com.shuame.rootgenius.common.util.C1412t;
import com.shuame.rootgenius.hook.HookModule;
import com.shuame.rootgenius.p099c.C1314a;
import com.shuame.rootgenius.p108e.C1426e;
import com.shuame.rootgenius.p108e.C1427f;
import com.tencent.beacon.event.UserAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p120de.greenrobot.event.EventBus;

public class RootGeniusApp extends Application {
    /* renamed from: a */
    public static NotificationManager f3301a;
    /* renamed from: b */
    public static float f3302b = 1.0f;
    /* renamed from: c */
    public static String f3303c;
    /* renamed from: d */
    static int f3304d = 0;
    /* renamed from: e */
    private static final String f3305e = RootGeniusApp.class.getSimpleName();
    /* renamed from: f */
    private static Context f3306f;
    /* renamed from: g */
    private static boolean f3307g;
    /* renamed from: h */
    private BroadcastReceiver f3308h = new C1421d(this);
    /* renamed from: i */
    private List<QQDownloadFile> f3309i = new ArrayList();
    /* renamed from: j */
    private List<QQDownloadFile> f3310j = new ArrayList();
    /* renamed from: k */
    private BroadcastReceiver f3311k = new C1431e(this);
    /* renamed from: l */
    private C1408q f3312l;

    /* renamed from: a */
    public static Context m3523a() {
        return f3306f;
    }

    /* renamed from: b */
    public static boolean m3526b() {
        return f3307g;
    }

    /* renamed from: c */
    static /* synthetic */ void m3527c(RootGeniusApp rootGeniusApp) {
        rootGeniusApp.f3310j.clear();
        rootGeniusApp.f3309i.clear();
        Collection a = C1361b.m3817a().mo7069a(Type.APK, Status.PENDING);
        Collection a2 = C1361b.m3817a().mo7069a(Type.APK, Status.STARTING_OR_DOWNLOADING);
        Collection a3 = C1361b.m3817a().mo7069a(Type.ROM, Status.PENDING);
        Collection a4 = C1361b.m3817a().mo7069a(Type.ROM, Status.STARTING_OR_DOWNLOADING);
        rootGeniusApp.f3309i.addAll(a);
        rootGeniusApp.f3310j.addAll(a2);
        rootGeniusApp.f3309i.addAll(a3);
        rootGeniusApp.f3310j.addAll(a4);
        if (!rootGeniusApp.f3309i.isEmpty() || !rootGeniusApp.f3310j.isEmpty()) {
            C1361b.m3817a().mo7070a(Type.APK);
            C1361b.m3817a().mo7070a(Type.ROM);
            rootGeniusApp.sendBroadcast(new Intent(C1340e.f3632c));
        }
    }

    public void onCreate() {
        boolean z;
        super.onCreate();
        String packageName = getPackageName();
        int myPid = Process.myPid();
        for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid && runningAppProcessInfo.processName.equals(packageName)) {
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            f3306f = this;
            f3301a = (NotificationManager) getSystemService("notification");
            EventBus.getDefault().register(C1427f.m3959a());
            C1345i.m3749a().mo7015a(new C1426e());
            if (!C1387ad.m3879g(this)) {
                C1390c.m3888a().mo7116b();
            }
            C1325c.m3725a(this);
            HookModule.init(this);
            C1151a.m3311a(this);
            C1253a.m3546a(this);
            UserAction.initUserAction(this);
            if (C1412t.f3902a) {
                UserAction.setLogAble(true, false);
            }
            new C1313b(this).start();
            this.f3312l = new C1408q(new C1434f(this));
            this.f3312l.mo7132a((Context) this);
            registerReceiver(this.f3311k, new IntentFilter(C1340e.f3633d));
            AppManager.m3771a().mo7033a(C1321b.m3685a());
            C1361b.m3817a().mo7071a(AppManager.m3771a());
            new C1315c(this).start();
            C1385ab.m3862a(f3306f);
            C1446g.m4003a();
            C1446g.m4006b();
            Map hashMap = new HashMap();
            hashMap.put(C1106j.f2960a, C1314a.f3562b);
            C1106j.m3208a().mo6704b();
            C1106j.m3208a().mo6702a(getApplicationContext(), hashMap);
            C1106j.m3208a().mo6703a(false);
        }
    }
}
