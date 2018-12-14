package com.tencent.stat.common;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.p013pm.PackageInfo;
import android.content.p013pm.PackageManager.NameNotFoundException;
import android.content.p013pm.ResolveInfo;
import android.content.p013pm.Signature;
import android.content.pm.ApplicationInfo;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.p070qq.p071e.comm.constants.ErrorCode.NetWorkError;
import com.tencent.stat.C1706ba;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatReportStrategy;
import com.tencent.stat.StatSpecifyReportedInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public class StatCommonHelper {
    /* renamed from: a */
    private static String f5010a = null;
    /* renamed from: b */
    private static String f5011b = null;
    /* renamed from: c */
    private static String f5012c = null;
    /* renamed from: d */
    private static String f5013d = null;
    /* renamed from: e */
    private static Random f5014e = null;
    /* renamed from: f */
    private static DisplayMetrics f5015f = null;
    /* renamed from: g */
    private static String f5016g = null;
    /* renamed from: h */
    private static String f5017h = "";
    /* renamed from: i */
    private static String f5018i = "";
    /* renamed from: j */
    private static String f5019j = "";
    /* renamed from: k */
    private static String f5020k = "";
    /* renamed from: l */
    private static int f5021l = -1;
    /* renamed from: m */
    private static StatLogger f5022m = null;
    /* renamed from: n */
    private static String f5023n = null;
    /* renamed from: o */
    private static String f5024o = null;
    /* renamed from: p */
    private static volatile int f5025p = -1;
    /* renamed from: q */
    private static String f5026q = null;
    /* renamed from: r */
    private static String f5027r = null;
    /* renamed from: s */
    private static long f5028s = -1;
    /* renamed from: t */
    private static String f5029t = "";
    /* renamed from: u */
    private static C1730n f5030u = null;
    /* renamed from: v */
    private static String f5031v = "__MTA_FIRST_ACTIVATE__";
    /* renamed from: w */
    private static int f5032w = -1;
    /* renamed from: x */
    private static long f5033x = -1;
    /* renamed from: y */
    private static int f5034y = 0;
    /* renamed from: z */
    private static String f5035z = "";

    /* renamed from: a */
    static String m4720a(Context context) {
        try {
            if (f5024o != null) {
                return f5024o;
            }
            int myPid = Process.myPid();
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    f5024o = runningAppProcessInfo.processName;
                    break;
                }
            }
            return f5024o;
        } catch (Throwable th) {
        }
    }

    /* renamed from: b */
    private static long m4721b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    /* renamed from: b */
    private static synchronized Random m4722b() {
        Random random;
        synchronized (StatCommonHelper.class) {
            if (f5014e == null) {
                f5014e = new Random();
            }
            random = f5014e;
        }
        return random;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e A:{SYNTHETIC, Splitter: B:32:0x005e} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0063 A:{Catch:{ Exception -> 0x0067 }} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004b A:{SYNTHETIC, Splitter: B:23:0x004b} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0050 A:{Catch:{ Exception -> 0x0054 }} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e A:{SYNTHETIC, Splitter: B:32:0x005e} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0063 A:{Catch:{ Exception -> 0x0067 }} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004b A:{SYNTHETIC, Splitter: B:23:0x004b} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0050 A:{Catch:{ Exception -> 0x0054 }} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e A:{SYNTHETIC, Splitter: B:32:0x005e} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0063 A:{Catch:{ Exception -> 0x0067 }} */
    /* renamed from: c */
    private static long m4723c() {
        /*
        r4 = 0;
        r0 = f5028s;
        r2 = 0;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x000c;
    L_0x0009:
        r0 = f5028s;
    L_0x000b:
        return r0;
    L_0x000c:
        r2 = "/proc/meminfo";
        r0 = 1;
        r5 = new java.io.FileReader;	 Catch:{ Exception -> 0x0044, all -> 0x0059 }
        r5.<init>(r2);	 Catch:{ Exception -> 0x0044, all -> 0x0059 }
        r3 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0074, all -> 0x006c }
        r2 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r3.<init>(r5, r2);	 Catch:{ Exception -> 0x0074, all -> 0x006c }
        r2 = r3.readLine();	 Catch:{ Exception -> 0x0078, all -> 0x006f }
        if (r2 == 0) goto L_0x0036;
    L_0x0022:
        r4 = "\\s+";
        r2 = r2.split(r4);	 Catch:{ Exception -> 0x0078, all -> 0x006f }
        r4 = 1;
        r2 = r2[r4];	 Catch:{ Exception -> 0x0078, all -> 0x006f }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x0078, all -> 0x006f }
        r0 = r2.intValue();	 Catch:{ Exception -> 0x0078, all -> 0x006f }
        r0 = r0 * 1024;
        r0 = (long) r0;
    L_0x0036:
        r5.close();	 Catch:{ Exception -> 0x003f }
        r3.close();	 Catch:{ Exception -> 0x003f }
    L_0x003c:
        f5028s = r0;
        goto L_0x000b;
    L_0x003f:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x003c;
    L_0x0044:
        r2 = move-exception;
        r3 = r4;
    L_0x0046:
        r2.printStackTrace();	 Catch:{ all -> 0x0071 }
        if (r4 == 0) goto L_0x004e;
    L_0x004b:
        r4.close();	 Catch:{ Exception -> 0x0054 }
    L_0x004e:
        if (r3 == 0) goto L_0x003c;
    L_0x0050:
        r3.close();	 Catch:{ Exception -> 0x0054 }
        goto L_0x003c;
    L_0x0054:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x003c;
    L_0x0059:
        r0 = move-exception;
        r3 = r4;
        r5 = r4;
    L_0x005c:
        if (r5 == 0) goto L_0x0061;
    L_0x005e:
        r5.close();	 Catch:{ Exception -> 0x0067 }
    L_0x0061:
        if (r3 == 0) goto L_0x0066;
    L_0x0063:
        r3.close();	 Catch:{ Exception -> 0x0067 }
    L_0x0066:
        throw r0;
    L_0x0067:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0066;
    L_0x006c:
        r0 = move-exception;
        r3 = r4;
        goto L_0x005c;
    L_0x006f:
        r0 = move-exception;
        goto L_0x005c;
    L_0x0071:
        r0 = move-exception;
        r5 = r4;
        goto L_0x005c;
    L_0x0074:
        r2 = move-exception;
        r3 = r4;
        r4 = r5;
        goto L_0x0046;
    L_0x0078:
        r2 = move-exception;
        r4 = r5;
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.common.StatCommonHelper.c():long");
    }

    public static int checkBluetooth() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter == null ? -1 : defaultAdapter.isEnabled() ? 1 : 0;
    }

    public static void checkFirstTimeActivate(Context context) {
        int i = StatPreferences.getInt(context, f5031v, 1);
        f5032w = i;
        if (i == 1) {
            StatPreferences.putInt(context, f5031v, 0);
        }
    }

    public static boolean checkPhoneState(Context context) {
        return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0;
    }

    public static Long convertStringToLong(String str, String str2, int i, int i2, Long l) {
        if (str == null || str2 == null) {
            return l;
        }
        if (str2.equalsIgnoreCase(".") || str2.equalsIgnoreCase("|")) {
            str2 = "\\" + str2;
        }
        String[] split = str.split(str2);
        if (split.length != i2) {
            return l;
        }
        try {
            Long valueOf = Long.valueOf(0);
            int i3 = 0;
            while (i3 < split.length) {
                Long valueOf2 = Long.valueOf(((long) i) * (valueOf.longValue() + Long.valueOf(split[i3]).longValue()));
                i3++;
                valueOf = valueOf2;
            }
            return valueOf;
        } catch (NumberFormatException e) {
            return l;
        }
    }

    public static byte[] deocdeGZipContent(byte[] bArr) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return bArr2;
            }
        }
    }

    public static String getActivityName(Context context) {
        return context == null ? null : context.getClass().getName();
    }

    public static String getAllSensors(Context context) {
        if (isStringValid(f5029t)) {
            return f5029t;
        }
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager != null) {
                List sensorList = sensorManager.getSensorList(-1);
                if (sensorList != null) {
                    StringBuilder stringBuilder = new StringBuilder(sensorList.size() * 10);
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= sensorList.size()) {
                            break;
                        }
                        stringBuilder.append(((Sensor) sensorList.get(i2)).getType());
                        if (i2 != sensorList.size() - 1) {
                            stringBuilder.append(",");
                        }
                        i = i2 + 1;
                    }
                    f5029t = stringBuilder.toString();
                }
            }
        } catch (Throwable th) {
            f5022m.mo7900e(th);
        }
        return f5029t;
    }

    public static int getAndroidOsBuildVersion() {
        return VERSION.SDK_INT;
    }

    public static String getAppKey(Context context) {
        if (f5011b != null) {
            return f5011b;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString("TA_APPKEY");
                if (string != null) {
                    f5011b = string;
                    return string;
                }
                f5022m.mo7904i("Could not read APPKEY meta-data from AndroidManifest.xml");
            }
        } catch (Throwable th) {
            f5022m.mo7904i("Could not read APPKEY meta-data from AndroidManifest.xml");
        }
        return null;
    }

    public static String getAppVersion(Context context) {
        if (isStringValid(f5020k)) {
            return f5020k;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f5020k = str;
            if (str == null || f5020k.length() == 0) {
                return "unknown";
            }
        } catch (Throwable th) {
            f5022m.mo7900e(th);
        }
        return f5020k;
    }

    public static String getCameras(Context context) {
        if (isStringValid(f5035z)) {
            return f5035z;
        }
        Camera camera = null;
        try {
            if (Util.checkPermission(context, "android.permission.CAMERA")) {
                camera = Camera.open();
                if (camera != null) {
                    Size size = (Size) camera.getParameters().getSupportedPictureSizes().get(0);
                    f5035z = size.width + "*" + size.height;
                }
            }
            if (camera != null) {
                camera.release();
            }
        } catch (Throwable th) {
            if (camera != null) {
                camera.release();
            }
        }
        return f5035z;
    }

    public static synchronized C1730n getCamerasHelper(Context context) {
        C1730n c1730n;
        synchronized (StatCommonHelper.class) {
            if (f5030u == null) {
                f5030u = new C1730n();
            }
            c1730n = f5030u;
        }
        return c1730n;
    }

    public static JSONObject getCpuInfo(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IXAdRequestInfo.AD_COUNT, C1728l.m4755a());
            String d = C1728l.m4758d();
            if (d != null && d.length() > 0) {
                jSONObject.put("na", d);
            }
            int b = C1728l.m4756b();
            if (b > 0) {
                jSONObject.put("fx", b / 1000000);
            }
            b = C1728l.m4757c();
            if (b > 0) {
                jSONObject.put("fn", b / 1000000);
            }
        } catch (Throwable th) {
        }
        return jSONObject;
    }

    public static String getCpuString() {
        if (isStringValid(f5026q)) {
            return f5026q;
        }
        if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
            f5026q = "Intel";
        } else {
            try {
                byte[] bArr = new byte[1024];
                RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/cpuinfo", "r");
                randomAccessFile.read(bArr);
                randomAccessFile.close();
                String str = new String(bArr);
                int indexOf = str.indexOf(0);
                if (indexOf != -1) {
                    f5026q = str.substring(0, indexOf);
                } else {
                    f5026q = str;
                }
            } catch (Throwable th) {
                f5022m.mo7900e(th);
            }
        }
        return f5026q;
    }

    public static String getCpuType() {
        String str;
        String cpuString = getCpuString();
        if (cpuString.contains("ARMv5")) {
            str = "armv5";
        } else if (cpuString.contains("ARMv6")) {
            str = "armv6";
        } else if (cpuString.contains("ARMv7")) {
            str = "armv7";
        } else if (!cpuString.contains("Intel")) {
            return "unknown";
        } else {
            str = "x86";
        }
        return cpuString.contains("neon") ? str + "_neon" : cpuString.contains("vfpv3") ? str + "_vfpv3" : cpuString.contains(" vfp") ? str + "_vfp" : str + "_none";
    }

    public static String getCurAppMd5Signature(Context context) {
        if (isStringValid(f5018i)) {
            return f5018i;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo == null) {
                f5022m.mo7899e((Object) "packageInfo is null ");
                return "";
            }
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null || signatureArr.length == 0) {
                f5022m.mo7899e((Object) "signatures is null");
                return "";
            }
            f5018i = md5sum(signatureArr[0].toCharsString());
            return f5018i;
        } catch (Throwable th) {
            f5022m.mo7900e(th);
        }
    }

    public static String getCurAppSHA1Signature(Context context) {
        if (isStringValid(f5019j)) {
            return f5019j;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo == null) {
                f5022m.mo7899e((Object) "packageInfo is null ");
                return "";
            }
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null || signatureArr.length == 0) {
                f5022m.mo7899e((Object) "signatures is null");
                return "";
            }
            byte[] digest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            int length = digest.length;
            for (int i = 0; i < length; i++) {
                String toUpperCase = Integer.toHexString(digest[i] & 255).toUpperCase(Locale.US);
                if (toUpperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(toUpperCase);
                if (i != length - 1) {
                    stringBuffer.append(":");
                }
            }
            f5019j = stringBuffer.toString();
            return f5019j;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String getCurAppVersion(Context context) {
        if (isStringValid(f5017h)) {
            return f5017h;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            f5017h = str;
            if (str == null) {
                return "";
            }
        } catch (Throwable th) {
            f5022m.mo7900e(th);
        }
        return f5017h;
    }

    public static String getDatabaseName(Context context) {
        return getTagForConcurrentProcess(context, StatConstants.DATABASE_NAME);
    }

    public static String getDateFormat(long j) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(j));
    }

    public static String getDateString(int i) {
        Calendar instance = Calendar.getInstance();
        instance.roll(6, i);
        return new SimpleDateFormat("yyyyMMdd").format(instance.getTime());
    }

    public static String getDeviceIMSI(Context context) {
        try {
            if (Util.checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                String subscriberId = checkPhoneState(context) ? ((TelephonyManager) context.getSystemService("phone")).getSubscriberId() : null;
                return subscriberId != null ? subscriberId : null;
            }
        } catch (Throwable th) {
            f5022m.mo7900e(th);
        }
        return "";
    }

    public static String getDeviceModel(Context context) {
        if (f5013d == null) {
            f5013d = Build.MODEL;
        }
        return f5013d;
    }

    public static int getDiffTime(Context context, boolean z) {
        if (z) {
            f5034y = readDiffTimeFromServer(context);
        }
        return f5034y;
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        if (f5015f == null) {
            f5015f = new DisplayMetrics();
            ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(f5015f);
        }
        return f5015f;
    }

    public static String getExternalStorageInfo(Context context) {
        if (isStringValid(f5023n)) {
            return f5023n;
        }
        try {
            if (Util.checkPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                String externalStorageState = Environment.getExternalStorageState();
                if (externalStorageState != null && externalStorageState.equals("mounted")) {
                    externalStorageState = Environment.getExternalStorageDirectory().getPath();
                    if (externalStorageState != null) {
                        StatFs statFs = new StatFs(externalStorageState);
                        long blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000;
                        externalStorageState = String.valueOf((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1000000) + "/" + String.valueOf(blockCount);
                        f5023n = externalStorageState;
                        return externalStorageState;
                    }
                }
                return null;
            }
            f5022m.warn("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        } catch (Throwable th) {
            f5022m.mo7900e(th);
        }
    }

    public static Location getGPSLocation(Context context) {
        Throwable th;
        Location lastKnownLocation;
        try {
            if (Util.checkPermission(context, "android.permission.ACCESS_FINE_LOCATION")) {
                f5022m.mo7899e((Object) "getGPSLocation");
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                if (locationManager.isProviderEnabled("gps")) {
                    lastKnownLocation = locationManager.getLastKnownLocation("gps");
                    try {
                        f5022m.mo7899e("getGPSLocation location:" + lastKnownLocation);
                        return lastKnownLocation;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
            return null;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            lastKnownLocation = null;
            th = th4;
            f5022m.mo7900e(th);
            return lastKnownLocation;
        }
    }

    public static HttpHost getHttpProxy(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
                return null;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getTypeName() != null && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                return null;
            }
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (extraInfo == null) {
                return null;
            }
            if (extraInfo.equals("cmwap") || extraInfo.equals("3gwap") || extraInfo.equals("uniwap")) {
                return new HttpHost("10.0.0.172", 80);
            }
            if (extraInfo.equals("ctwap")) {
                return new HttpHost("10.0.0.200", 80);
            }
            String defaultHost = Proxy.getDefaultHost();
            if (defaultHost != null && defaultHost.trim().length() > 0) {
                return new HttpHost(defaultHost, Proxy.getDefaultPort());
            }
            return null;
        } catch (Throwable th) {
            f5022m.mo7900e(th);
        }
    }

    public static String getInstallChannel(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Object obj = applicationInfo.metaData.get("InstallChannel");
                if (obj != null) {
                    return obj.toString();
                }
                f5022m.mo7912w("Could not read InstallChannel meta-data from AndroidManifest.xml");
            }
        } catch (Throwable th) {
            f5022m.mo7899e((Object) "Could not read InstallChannel meta-data from AndroidManifest.xml");
        }
        return null;
    }

    public static String getLauncherPackageName(Context context) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        return (resolveActivity.activityInfo == null || resolveActivity.activityInfo.packageName.equals("android")) ? null : resolveActivity.activityInfo.packageName;
    }

    public static String getLinkedWay(Context context) {
        String str = "";
        try {
            if (Util.checkPermission(context, "android.permission.INTERNET") && Util.checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                String typeName;
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    typeName = activeNetworkInfo.getTypeName();
                    String extraInfo = activeNetworkInfo.getExtraInfo();
                    if (typeName != null) {
                        if (typeName.equalsIgnoreCase("WIFI")) {
                            return "WIFI";
                        }
                        if (typeName.equalsIgnoreCase("MOBILE")) {
                            return (extraInfo == null || extraInfo.trim().length() <= 0) ? "MOBILE" : extraInfo;
                        } else {
                            if (extraInfo != null && extraInfo.trim().length() > 0) {
                                return extraInfo;
                            }
                            return typeName;
                        }
                    }
                }
                typeName = str;
                return typeName;
            }
            f5022m.mo7899e((Object) "can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return str;
        } catch (Throwable th) {
            f5022m.mo7900e(th);
            return str;
        }
    }

    public static synchronized StatLogger getLogger() {
        StatLogger statLogger;
        synchronized (StatCommonHelper.class) {
            if (f5022m == null) {
                statLogger = new StatLogger(StatConstants.LOG_TAG);
                f5022m = statLogger;
                statLogger.setDebugEnable(false);
            }
            statLogger = f5022m;
        }
        return statLogger;
    }

    public static synchronized String getMacId(Context context) {
        String str;
        synchronized (StatCommonHelper.class) {
            if (f5012c == null || f5012c.trim().length() == 0) {
                f5012c = Util.getWifiMacAddress(context);
            }
            str = f5012c;
        }
        return str;
    }

    public static Location getNetworkLocation(Context context) {
        Throwable th;
        Location lastKnownLocation;
        try {
            if (!Util.checkPermission(context, "android.permission.ACCESS_COARSE_LOCATION") && !Util.checkPermission(context, "android.permission.ACCESS_FINE_LOCATION")) {
                return null;
            }
            f5022m.mo7899e((Object) "getNetworkLocation");
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            lastKnownLocation = locationManager.isProviderEnabled("network") ? locationManager.getLastKnownLocation("network") : null;
            try {
                f5022m.mo7899e("getNetworkLocation location:" + lastKnownLocation);
                return lastKnownLocation;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            lastKnownLocation = null;
            th = th4;
            f5022m.mo7900e(th);
            return lastKnownLocation;
        }
    }

    public static synchronized Integer getNextEventIndexNo(Context context) {
        Integer valueOf;
        int i = 0;
        synchronized (StatCommonHelper.class) {
            if (f5025p <= 0) {
                f5025p = StatPreferences.getInt(context, "MTA_EVENT_INDEX", 0);
                StatPreferences.putInt(context, "MTA_EVENT_INDEX", f5025p + 1000);
            } else if (f5025p % 1000 == 0) {
                try {
                    int i2 = f5025p + 1000;
                    if (f5025p < 2147383647) {
                        i = i2;
                    }
                    StatPreferences.putInt(context, "MTA_EVENT_INDEX", i);
                } catch (Throwable th) {
                    f5022m.mo7912w(th);
                }
            }
            i = f5025p + 1;
            f5025p = i;
            valueOf = Integer.valueOf(i);
        }
        return valueOf;
    }

    public static int getNextSessionID() {
        return m4722b().nextInt(Integer.MAX_VALUE);
    }

    public static String getPackageName(Context context) {
        if (Util.checkPermission(context, "android.permission.GET_TASKS")) {
            return ((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getPackageName();
        }
        f5022m.mo7899e((Object) "Could not get permission of android.permission.GET_TASKS");
        return null;
    }

    public static String getProperty(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString(str);
                if (string != null) {
                    return string;
                }
            }
        } catch (Throwable th) {
            f5022m.mo7900e(th);
        }
        return "";
    }

    public static String getRomMemory() {
        if (isStringValid(f5027r)) {
            return f5027r;
        }
        long totalInternalMemorySize = getTotalInternalMemorySize() / 1000000;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        String str = String.valueOf((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1000000) + "/" + String.valueOf(totalInternalMemorySize);
        f5027r = str;
        return str;
    }

    public static long getSDKLongVersion(String str) {
        return convertStringToLong(str, ".", 100, 3, Long.valueOf(0)).longValue();
    }

    public static String getSimOperator(Context context) {
        if (f5016g != null) {
            return f5016g;
        }
        try {
            if (!Util.checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                f5022m.mo7899e((Object) "Could not get permission of android.permission.READ_PHONE_STATE");
            } else if (checkPhoneState(context)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    f5016g = telephonyManager.getSimOperator();
                }
            }
        } catch (Throwable th) {
            f5022m.mo7900e(th);
        }
        return f5016g;
    }

    public static StatReportStrategy getStatSendStrategy(Context context) {
        return StatConfig.getStatSendStrategy();
    }

    public static String getSystemMemory(Context context) {
        try {
            return String.valueOf(m4721b(context) / 1000000) + "/" + String.valueOf(m4723c() / 1000000);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String getTagForConcurrentProcess(Context context, String str) {
        if (!StatConfig.isEnableConcurrentProcess()) {
            return str;
        }
        if (f5024o == null) {
            f5024o = m4720a(context);
        }
        return f5024o != null ? str + "_" + f5024o : str;
    }

    public static Integer getTelephonyNetworkType(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return Integer.valueOf(telephonyManager.getNetworkType());
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static long getTomorrowStartMilliseconds() {
        try {
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            return instance.getTimeInMillis() + 86400000;
        } catch (Throwable th) {
            f5022m.mo7900e(th);
            return System.currentTimeMillis() + 86400000;
        }
    }

    public static long getTotalInternalMemorySize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    public static DeviceInfo getUser(Context context) {
        return C1706ba.m4673a(context).mo7875b(context);
    }

    public static synchronized String getUserID(Context context) {
        String deviceID;
        synchronized (StatCommonHelper.class) {
            if (f5010a == null || f5010a.trim().length() == 0) {
                deviceID = Util.getDeviceID(context);
                f5010a = deviceID;
                if (deviceID == null || f5010a.trim().length() == 0) {
                    f5010a = Integer.toString(m4722b().nextInt(Integer.MAX_VALUE));
                }
                deviceID = f5010a;
            } else {
                deviceID = f5010a;
            }
        }
        return deviceID;
    }

    public static int hasRootAccess(Context context) {
        if (f5021l != -1) {
            return f5021l;
        }
        f5021l = 0;
        try {
            if (C1731o.m4759a()) {
                f5021l = 1;
            }
        } catch (Throwable th) {
            f5022m.mo7900e(th);
        }
        return f5021l;
    }

    public static boolean haveGravity(Context context) {
        return ((SensorManager) context.getSystemService("sensor")) != null;
    }

    public static boolean isApplicationBroughtToBackground(Context context) {
        if (!Util.checkPermission(context, "android.permission.GET_TASKS")) {
            return true;
        }
        List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (!runningTasks.isEmpty()) {
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            f5022m.mo7904i("isApplicationBroughtToBackground top package:" + componentName.getPackageName());
            if (!componentName.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBackground(Context context) {
        for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.processName.equalsIgnoreCase(context.getPackageName())) {
                f5022m.mo7904i("isBackground processName:" + runningAppProcessInfo.processName + ", importance:" + runningAppProcessInfo.importance);
                if ((runningAppProcessInfo.importance == 100 || runningAppProcessInfo.importance == 200) && !isLockScreenOn(context)) {
                    return isApplicationBroughtToBackground(context);
                }
                return true;
            }
        }
        return true;
    }

    public static boolean isBackgroundRunning(Context context) {
        if (context == null) {
            return false;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return false;
        }
        String packageName = context.getPackageName();
        for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.processName.startsWith(packageName)) {
                return runningAppProcessInfo.importance == NetWorkError.STUB_NETWORK_ERROR;
            }
        }
        return false;
    }

    public static boolean isLockScreenOn(Context context) {
        return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    public static boolean isSpecifyReportedValid(StatSpecifyReportedInfo statSpecifyReportedInfo) {
        return statSpecifyReportedInfo == null ? false : isStringValid(statSpecifyReportedInfo.getAppKey());
    }

    public static boolean isStringValid(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    public static synchronized int isTheFirstTimeActivate(Context context) {
        int i;
        synchronized (StatCommonHelper.class) {
            if (f5032w != -1) {
                i = f5032w;
            } else {
                checkFirstTimeActivate(context);
                i = f5032w;
            }
        }
        return i;
    }

    public static boolean isWiFiActive(Context context) {
        try {
            if (Util.checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
                    if (allNetworkInfo != null) {
                        int i = 0;
                        while (i < allNetworkInfo.length) {
                            if (allNetworkInfo[i].getTypeName().equalsIgnoreCase("WIFI") && allNetworkInfo[i].isConnected()) {
                                return true;
                            }
                            i++;
                        }
                    }
                }
                return false;
            }
            f5022m.warn("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return false;
        } catch (Throwable th) {
            f5022m.mo7900e(th);
        }
    }

    public static String md5sum(String str) {
        if (str == null) {
            return "0";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            return "0";
        }
    }

    public static boolean needCheckTime(Context context) {
        if (f5033x < 0) {
            f5033x = StatPreferences.getLong(context, "mta.qq.com.checktime", 0);
        }
        return Math.abs(System.currentTimeMillis() - f5033x) > 86400000;
    }

    public static int readDiffTimeFromServer(Context context) {
        return StatPreferences.getInt(context, "mta.qq.com.difftime", 0);
    }

    public static void updateCheckTime(Context context) {
        f5033x = System.currentTimeMillis();
        StatPreferences.putLong(context, "mta.qq.com.checktime", f5033x);
    }

    public static void writeDiffTimeFromServer(Context context, int i) {
        f5034y = i;
        StatPreferences.putInt(context, "mta.qq.com.difftime", i);
    }
}
