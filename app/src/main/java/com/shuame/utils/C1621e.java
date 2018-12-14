package com.shuame.utils;

import android.content.Context;
import android.content.p013pm.PackageManager.NameNotFoundException;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* renamed from: com.shuame.utils.e */
public class C1621e {
    /* renamed from: a */
    private static final String f4583a = C1621e.class.getSimpleName();
    /* renamed from: b */
    private static int f4584b;
    /* renamed from: c */
    private static String f4585c;
    /* renamed from: d */
    private static Object f4586d = new Object();
    /* renamed from: e */
    private static boolean f4587e = false;

    private C1621e() {
    }

    /* renamed from: a */
    public static String m4393a() {
        String format;
        SimpleDateFormat a = C1617a.m4386a("yyyy-MM-dd'T'HH:mm:ss");
        synchronized (a) {
            a.setTimeZone(TimeZone.getTimeZone("GMT"));
            format = a.format(new Date());
        }
        return format;
    }

    /* renamed from: a */
    public static boolean m4394a(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    /* renamed from: b */
    public static String m4395b(Context context) {
        String macAddress = ((WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo().getMacAddress();
        return macAddress != null ? macAddress.trim().replace(":", "").replace(".", "").replace("-", "").toLowerCase() : "";
    }

    /* renamed from: c */
    public static String m4396c(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
    }

    /* renamed from: d */
    public static String m4397d(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
    }

    /* renamed from: e */
    public static String m4398e(Context context) {
        if (context == null) {
            return f4585c;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            String string = applicationInfo.metaData.getString("InstallChannel");
            f4585c = string;
            if (string == null) {
                f4585c = String.valueOf(applicationInfo.metaData.getInt("InstallChannel"));
            }
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return f4585c;
    }

    /* renamed from: f */
    public static int m4399f(Context context) {
        if (context == null) {
            return f4584b;
        }
        try {
            f4584b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
        }
        return f4584b;
    }
}
