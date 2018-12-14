package com.shuame.rootgenius.common.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.C1325c;
import com.tencent.beacon.event.UserAction;
import java.util.List;

/* renamed from: com.shuame.rootgenius.common.util.ad */
public class C1387ad {
    /* renamed from: a */
    private static final String f3858a = C1387ad.class.getSimpleName();

    /* renamed from: a */
    public static String m3864a(String str) {
        String str2 = "";
        return (str == null || str.indexOf(47) == -1 || str.length() <= 1) ? str2 : str.substring(str.lastIndexOf(47) + 1);
    }

    /* renamed from: a */
    public static String m3865a(boolean z) {
        String str = "";
        Object obj;
        do {
            try {
                str = UserAction.getQIMEI();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (TextUtils.isEmpty(str) && z) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                obj = 1;
                z = false;
                continue;
            } else {
                obj = null;
                continue;
            }
        } while (obj != null);
        return str;
    }

    /* renamed from: a */
    public static boolean m3866a() {
        C1325c.m3724a();
        return C1387ad.m3870b();
    }

    /* renamed from: a */
    public static boolean m3867a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1;
    }

    /* renamed from: a */
    public static boolean m3868a(Context context, String str) {
        if (!C1387ad.m3871b(str)) {
            return false;
        }
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        launchIntentForPackage.setPackage(null);
        context.startActivity(launchIntentForPackage);
        return true;
    }

    /* renamed from: b */
    public static int m3869b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) ? -1 : activeNetworkInfo.getType();
    }

    /* renamed from: b */
    public static boolean m3870b() {
        String packageName = C1325c.m3724a().getPackageName();
        List runningTasks = ((ActivityManager) C1325c.m3724a().getSystemService("activity")).getRunningTasks(1);
        if (!(runningTasks == null || runningTasks.isEmpty())) {
            try {
                if (packageName.equals(((RunningTaskInfo) runningTasks.get(0)).baseActivity.getPackageName()) || packageName.equals(((RunningTaskInfo) runningTasks.get(0)).topActivity.getPackageName())) {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m3871b(String str) {
        return C1325c.m3724a().getPackageManager().getLaunchIntentForPackage(str) != null;
    }

    /* renamed from: c */
    public static String m3872c() {
        return Build.SERIAL;
    }

    /* renamed from: c */
    public static boolean m3873c(Context context) {
        return C1387ad.m3869b(context) != -1;
    }

    /* renamed from: d */
    public static String m3874d(Context context) {
        String macAddress = ((WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo().getMacAddress();
        return macAddress != null ? macAddress.trim().replace(":", "").replace(".", "").replace("-", "").toLowerCase() : "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e A:{SKIP} */
    /* JADX WARNING: Missing block: B:23:?, code:
            r8.close();
            r7.close();
            r6.close();
     */
    /* renamed from: d */
    public static boolean m3875d() {
        /*
        r3 = 0;
        r12 = -1;
        r2 = 1;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x009c }
        r0 = "/proc/cpuinfo";
        r6.<init>(r0);	 Catch:{ Exception -> 0x009c }
        r7 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x009c }
        r7.<init>(r6);	 Catch:{ Exception -> 0x009c }
        r8 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x009c }
        r8.<init>(r7);	 Catch:{ Exception -> 0x009c }
        r0 = r3;
        r1 = r3;
    L_0x001b:
        r9 = r8.readLine();	 Catch:{ all -> 0x0082 }
        if (r9 == 0) goto L_0x0066;
    L_0x0021:
        r4 = "Processor";
        r4 = r9.indexOf(r4);	 Catch:{ all -> 0x0082 }
        if (r4 == r12) goto L_0x00b1;
    L_0x0029:
        r4 = java.util.Locale.ENGLISH;	 Catch:{ all -> 0x0082 }
        r4 = r9.toLowerCase(r4);	 Catch:{ all -> 0x0082 }
        r10 = "arm";
        r4 = r4.indexOf(r10);	 Catch:{ all -> 0x0082 }
        if (r4 == r12) goto L_0x00af;
    L_0x0037:
        r4 = r2;
    L_0x0038:
        r1 = "\n";
        r1 = r5.append(r1);	 Catch:{ all -> 0x00a3 }
        r10 = "\t";
        r11 = "";
        r10 = r9.replace(r10, r11);	 Catch:{ all -> 0x00a3 }
        r1.append(r10);	 Catch:{ all -> 0x00a3 }
    L_0x0049:
        r1 = "CPU architecture";
        r1 = r9.indexOf(r1);	 Catch:{ all -> 0x00a3 }
        if (r1 == r12) goto L_0x00ac;
    L_0x0051:
        r1 = "64";
        r1 = r9.indexOf(r1);	 Catch:{ all -> 0x00a3 }
        if (r1 != r12) goto L_0x00aa;
    L_0x0059:
        r1 = r2;
    L_0x005a:
        r0 = "\n";
        r0 = r5.append(r0);	 Catch:{ all -> 0x00a8 }
        r0.append(r9);	 Catch:{ all -> 0x00a8 }
        r0 = r1;
        r1 = r4;
        goto L_0x001b;
    L_0x0066:
        r8.close();	 Catch:{ Exception -> 0x00a1 }
        r7.close();	 Catch:{ Exception -> 0x00a1 }
        r6.close();	 Catch:{ Exception -> 0x00a1 }
    L_0x006f:
        r4 = com.shuame.rootgenius.common.C1323b.m3688a();
        r6 = "PREF_CPU_INFO";
        r5 = r5.toString();
        r4.mo6995a(r6, r5);
        if (r2 != r1) goto L_0x009a;
    L_0x007e:
        if (r2 != r0) goto L_0x009a;
    L_0x0080:
        r0 = r2;
    L_0x0081:
        return r0;
    L_0x0082:
        r4 = move-exception;
        r13 = r4;
        r4 = r1;
        r1 = r0;
        r0 = r13;
    L_0x0087:
        r8.close();	 Catch:{ Exception -> 0x0091 }
        r7.close();	 Catch:{ Exception -> 0x0091 }
        r6.close();	 Catch:{ Exception -> 0x0091 }
        throw r0;	 Catch:{ Exception -> 0x0091 }
    L_0x0091:
        r0 = move-exception;
        r13 = r0;
        r0 = r1;
        r1 = r4;
        r4 = r13;
    L_0x0096:
        r4.printStackTrace();
        goto L_0x006f;
    L_0x009a:
        r0 = r3;
        goto L_0x0081;
    L_0x009c:
        r0 = move-exception;
        r4 = r0;
        r1 = r3;
        r0 = r3;
        goto L_0x0096;
    L_0x00a1:
        r4 = move-exception;
        goto L_0x0096;
    L_0x00a3:
        r1 = move-exception;
        r13 = r1;
        r1 = r0;
        r0 = r13;
        goto L_0x0087;
    L_0x00a8:
        r0 = move-exception;
        goto L_0x0087;
    L_0x00aa:
        r1 = r0;
        goto L_0x005a;
    L_0x00ac:
        r1 = r4;
        goto L_0x001b;
    L_0x00af:
        r4 = r1;
        goto L_0x0038;
    L_0x00b1:
        r4 = r1;
        goto L_0x0049;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.common.util.ad.d():boolean");
    }

    /* renamed from: e */
    public static String m3876e() {
        Object g = C1323b.m3688a().mo7001g("PREF_CPU_INFO");
        if (TextUtils.isEmpty(g)) {
            C1387ad.m3875d();
        }
        return g;
    }

    /* renamed from: e */
    public static String m3877e(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
    }

    /* renamed from: f */
    public static String m3878f(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
    }

    /* renamed from: g */
    public static boolean m3879g(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            return false;
        }
    }
}
