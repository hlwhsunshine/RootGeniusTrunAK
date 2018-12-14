package com.kingroot.sdk.util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.p014os.SystemProperties;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import java.io.File;

/* renamed from: com.kingroot.sdk.util.l */
public final class C0893l {

    /* renamed from: com.kingroot.sdk.util.l$a */
    public static class C0892a {
        /* renamed from: gn */
        public long f2218gn;
        /* renamed from: go */
        public long f2219go;
    }

    /* renamed from: I */
    public static int m2439I() {
        return VERSION.SDK_INT;
    }

    /* renamed from: M */
    public static String m2440M(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            return "00000000000001";
        }
    }

    /* renamed from: N */
    public static String m2441N(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            return "000000000000001";
        }
    }

    /* renamed from: O */
    public static String m2442O(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo();
            return connectionInfo == null ? null : connectionInfo.getMacAddress();
        } catch (Exception e) {
            return "00:00:00:00:00:01";
        }
    }

    /* renamed from: P */
    public static String m2443P(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
        } catch (Exception e) {
            return "0000001";
        }
    }

    /* renamed from: Q */
    public static String m2444Q(Context context) {
        String[] strArr = new String[]{"ro.mediatek.platform", "ro.build.hidden_ver", "ro.product.model"};
        for (int i = 0; i < 3; i++) {
            Object obj = SystemProperties.get(strArr[i]);
            if (!TextUtils.isEmpty(obj)) {
                return obj;
            }
        }
        return Build.MODEL;
    }

    /* renamed from: R */
    public static int m2445R(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /* renamed from: S */
    public static int m2446S(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /* renamed from: a */
    public static void m2447a(C0892a c0892a) {
        if (C0883c.m2404bh()) {
            C0893l.m2448a(Environment.getExternalStorageDirectory(), c0892a);
            return;
        }
        c0892a.f2218gn = 0;
        c0892a.f2219go = 0;
    }

    /* renamed from: a */
    public static void m2448a(File file, C0892a c0892a) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            long blockSize = (long) statFs.getBlockSize();
            c0892a.f2218gn = ((long) statFs.getAvailableBlocks()) * blockSize;
            c0892a.f2219go = ((long) statFs.getBlockCount()) * blockSize;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: bm */
    public static String m2449bm() {
        return "android_id";
    }

    /* renamed from: bn */
    public static String m2450bn() {
        return Build.MODEL;
    }

    /* renamed from: bo */
    public static String m2451bo() {
        return Build.PRODUCT;
    }
}
