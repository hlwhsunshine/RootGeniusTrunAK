package com.kingroot.sdk.util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.p014os.SystemProperties;
import com.kingroot.sdk.util.C0893l.C0892a;
import java.io.Closeable;
import java.io.IOException;

/* renamed from: com.kingroot.sdk.util.a */
public class C0880a {
    /* renamed from: ge */
    private static long f2207ge = -1;

    /* renamed from: G */
    public static String[] m2373G(Context context) {
        String[] strArr = new String[4];
        strArr[0] = Build.MODEL;
        strArr[1] = VERSION.RELEASE;
        String str = "";
        try {
            str = C0883c.m2389Y("/proc/cpuinfo").split("\\n")[0];
        } catch (Exception e) {
            e.printStackTrace();
        }
        strArr[2] = str;
        strArr[3] = Integer.toString(C0893l.m2445R(context)) + "*" + Integer.toString(C0893l.m2446S(context));
        return strArr;
    }

    /* renamed from: H */
    public static String m2374H(Context context) {
        String str = new String();
        String[] G = C0880a.m2373G(context);
        str = (((((((str + "MODEL " + G[0] + ";") + "ANDROID " + G[1] + ";") + "CPU " + G[2] + ";") + "CPUFreq " + C0880a.m2378bc() + ";") + "CPUNum " + Runtime.getRuntime().availableProcessors() + ";") + "resolution " + G[3] + ";") + "ram " + C0880a.m2377bb() + ";") + "rom " + C0880a.m2379bd() + ";";
        C0892a c0892a = new C0892a();
        C0893l.m2447a(c0892a);
        str = (str + "sdcard " + c0892a.f2219go + ";") + "simNum 1;";
        str = str + "baseband " + SystemProperties.get("gsm.version.baseband", "") + ";";
        return str + "inversion " + Build.DISPLAY + ";";
    }

    /* renamed from: I */
    public static long m2375I(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: V */
    public static long m2376V(String str) {
        try {
            StatFs statFs = new StatFs(str);
            if (VERSION.SDK_INT > 18) {
                return statFs.getAvailableBytes();
            }
            return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0041  */
    /* renamed from: bb */
    public static long m2377bb() {
        /*
        r2 = 0;
        r0 = f2207ge;
        r4 = -1;
        r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x0039;
    L_0x0009:
        r0 = new java.io.File;
        r1 = "/proc/meminfo";
        r0.<init>(r1);
        r1 = r0.exists();
        if (r1 == 0) goto L_0x0039;
    L_0x0016:
        r1 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0097, IOException -> 0x005e, NumberFormatException -> 0x006b, all -> 0x0078 }
        r1.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0097, IOException -> 0x005e, NumberFormatException -> 0x006b, all -> 0x0078 }
        r3 = new java.io.DataInputStream;	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x0092, NumberFormatException -> 0x008d, all -> 0x0085 }
        r3.<init>(r1);	 Catch:{ FileNotFoundException -> 0x009a, IOException -> 0x0092, NumberFormatException -> 0x008d, all -> 0x0085 }
        r0 = r3.readLine();	 Catch:{ FileNotFoundException -> 0x002e, IOException -> 0x0095, NumberFormatException -> 0x0090 }
        if (r0 != 0) goto L_0x0044;
    L_0x0026:
        r0 = new java.io.IOException;	 Catch:{ FileNotFoundException -> 0x002e, IOException -> 0x0095, NumberFormatException -> 0x0090 }
        r2 = "/proc/meminfo is empty!";
        r0.<init>(r2);	 Catch:{ FileNotFoundException -> 0x002e, IOException -> 0x0095, NumberFormatException -> 0x0090 }
        throw r0;	 Catch:{ FileNotFoundException -> 0x002e, IOException -> 0x0095, NumberFormatException -> 0x0090 }
    L_0x002e:
        r0 = move-exception;
        r2 = r3;
    L_0x0030:
        r0.printStackTrace();	 Catch:{ all -> 0x008a }
        com.kingroot.sdk.util.C0885e.m2419a(r2);
        com.kingroot.sdk.util.C0885e.m2419a(r1);
    L_0x0039:
        r0 = f2207ge;
        r2 = 0;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x0082;
    L_0x0041:
        r0 = f2207ge;
    L_0x0043:
        return r0;
    L_0x0044:
        r0 = r0.trim();	 Catch:{ FileNotFoundException -> 0x002e, IOException -> 0x0095, NumberFormatException -> 0x0090 }
        r2 = "[\\s]+";
        r0 = r0.split(r2);	 Catch:{ FileNotFoundException -> 0x002e, IOException -> 0x0095, NumberFormatException -> 0x0090 }
        r2 = 1;
        r0 = r0[r2];	 Catch:{ FileNotFoundException -> 0x002e, IOException -> 0x0095, NumberFormatException -> 0x0090 }
        r4 = java.lang.Long.parseLong(r0);	 Catch:{ FileNotFoundException -> 0x002e, IOException -> 0x0095, NumberFormatException -> 0x0090 }
        f2207ge = r4;	 Catch:{ FileNotFoundException -> 0x002e, IOException -> 0x0095, NumberFormatException -> 0x0090 }
        com.kingroot.sdk.util.C0885e.m2419a(r3);
        com.kingroot.sdk.util.C0885e.m2419a(r1);
        goto L_0x0039;
    L_0x005e:
        r0 = move-exception;
        r1 = r2;
        r3 = r2;
    L_0x0061:
        r0.printStackTrace();	 Catch:{ all -> 0x0088 }
        com.kingroot.sdk.util.C0885e.m2419a(r3);
        com.kingroot.sdk.util.C0885e.m2419a(r1);
        goto L_0x0039;
    L_0x006b:
        r0 = move-exception;
        r1 = r2;
        r3 = r2;
    L_0x006e:
        r0.printStackTrace();	 Catch:{ all -> 0x0088 }
        com.kingroot.sdk.util.C0885e.m2419a(r3);
        com.kingroot.sdk.util.C0885e.m2419a(r1);
        goto L_0x0039;
    L_0x0078:
        r0 = move-exception;
        r1 = r2;
        r3 = r2;
    L_0x007b:
        com.kingroot.sdk.util.C0885e.m2419a(r3);
        com.kingroot.sdk.util.C0885e.m2419a(r1);
        throw r0;
    L_0x0082:
        r0 = 1;
        goto L_0x0043;
    L_0x0085:
        r0 = move-exception;
        r3 = r2;
        goto L_0x007b;
    L_0x0088:
        r0 = move-exception;
        goto L_0x007b;
    L_0x008a:
        r0 = move-exception;
        r3 = r2;
        goto L_0x007b;
    L_0x008d:
        r0 = move-exception;
        r3 = r2;
        goto L_0x006e;
    L_0x0090:
        r0 = move-exception;
        goto L_0x006e;
    L_0x0092:
        r0 = move-exception;
        r3 = r2;
        goto L_0x0061;
    L_0x0095:
        r0 = move-exception;
        goto L_0x0061;
    L_0x0097:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0030;
    L_0x009a:
        r0 = move-exception;
        goto L_0x0030;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.util.a.bb():long");
    }

    /* renamed from: bc */
    public static String m2378bc() {
        StringBuilder stringBuilder = new StringBuilder();
        Closeable closeable = null;
        try {
            closeable = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            while (closeable.read(bArr) != -1) {
                stringBuilder.append(new String(bArr));
            }
            closeable.close();
        } catch (IOException e) {
            e.printStackTrace();
            stringBuilder = new StringBuilder("N/A");
        } finally {
            C0885e.m2419a(closeable);
        }
        return stringBuilder.toString().trim();
    }

    /* renamed from: bd */
    public static long m2379bd() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    /* renamed from: be */
    public static long m2380be() {
        return C0880a.m2376V("/system");
    }

    /* renamed from: bf */
    public static long m2381bf() {
        return C0880a.m2376V("/data");
    }
}
