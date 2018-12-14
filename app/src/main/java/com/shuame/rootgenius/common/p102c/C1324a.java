package com.shuame.rootgenius.common.p102c;

import android.content.Context;
import android.content.p013pm.PackageManager.NameNotFoundException;
import android.content.pm.ApplicationInfo;
import com.tencent.stat.MtaSDkException;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatReportStrategy;
import com.tencent.stat.StatService;
import com.tencent.stat.common.StatConstants;
import java.util.Properties;

/* renamed from: com.shuame.rootgenius.common.c.a */
public class C1324a {
    /* renamed from: a */
    private static C1324a f3591a = null;
    /* renamed from: b */
    private static Context f3592b = null;
    /* renamed from: c */
    private static final String f3593c = C1324a.class.getSimpleName();
    /* renamed from: d */
    private static boolean f3594d = false;

    private C1324a(Context context) {
        ApplicationInfo applicationInfo = null;
        f3592b = context;
        if (f3594d) {
            StatConfig.setDebugEnable(true);
            StatConfig.setAutoExceptionCaught(false);
            StatConfig.setEnableSmartReporting(true);
            StatConfig.setStatSendStrategy(StatReportStrategy.INSTANT);
            StatConfig.setReportEventsByOrder(true);
        } else {
            StatConfig.setDebugEnable(false);
            StatConfig.setAutoExceptionCaught(false);
            StatConfig.setStatSendStrategy(StatReportStrategy.APP_LAUNCH);
            StatConfig.setEnableSmartReporting(true);
        }
        try {
            applicationInfo = f3592b.getPackageManager().getApplicationInfo(f3592b.getPackageName(), 128);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        try {
            StatService.startStatService(context, applicationInfo.metaData.getString("TA_APPKEY"), StatConstants.VERSION);
        } catch (MtaSDkException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public static C1324a m3722a(Context context) {
        if (f3591a == null) {
            synchronized (C1324a.class) {
                if (f3591a == null) {
                    f3591a = new C1324a(context.getApplicationContext());
                }
            }
        }
        return f3591a;
    }

    /* renamed from: a */
    public static void m3723a(String str, Properties properties) {
        StatService.trackCustomKVEvent(f3592b, str, properties);
    }
}
