package com.baidu.mobads.p021j;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.p013pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;

/* renamed from: com.baidu.mobads.j.n */
public class C0339n implements IXAdSystemUtils {
    /* renamed from: b */
    private static String f696b;
    /* renamed from: a */
    public JSONArray f697a = new JSONArray();
    /* renamed from: c */
    private String f698c;
    /* renamed from: d */
    private String f699d;
    /* renamed from: e */
    private String f700e;
    /* renamed from: f */
    private String f701f;
    /* renamed from: g */
    private String f702g;
    /* renamed from: h */
    private int f703h = -1;
    /* renamed from: i */
    private String f704i;
    /* renamed from: j */
    private String f705j;
    /* renamed from: k */
    private String f706k;
    /* renamed from: l */
    private String f707l;

    @TargetApi(18)
    /* renamed from: a */
    private long m589a(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            return (long) (((statFs.getBlockSize() * statFs.getBlockCount()) / 1024) / 1024);
        } catch (Exception e) {
            return -1;
        }
    }

    /* renamed from: a */
    private Boolean m590a(Context context, int i) {
        try {
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
                C0338m.m569a().mo5033f().mo4929e("Utils", "no permission android.permission.ACCESS_NETWORK_STATE");
                return Boolean.valueOf(false);
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            boolean z = activeNetworkInfo != null && activeNetworkInfo.getType() == i && activeNetworkInfo.isConnected();
            return Boolean.valueOf(z);
        } catch (Exception e) {
            return Boolean.valueOf(false);
        }
    }

    @TargetApi(18)
    /* renamed from: b */
    private long m591b(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            return (long) (((statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1024) / 1024);
        } catch (Exception e) {
            return -1;
        }
    }

    public boolean canSupportSdcardStroage(Context context) {
        try {
            return C0338m.m569a().mo5040m().hasPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") || !isUseOldStoragePath();
        } catch (Exception e) {
            return false;
        }
    }

    public long getAllExternalMemorySize() {
        try {
            return Environment.getExternalStorageState().equals("mounted") ? m589a(Environment.getExternalStorageDirectory()) : -1;
        } catch (Exception e) {
            return -1;
        }
    }

    public long getAllInternalMemorySize() {
        try {
            return m589a(Environment.getDataDirectory());
        } catch (Exception e) {
            return -1;
        }
    }

    public String getAndroidId(Context context) {
        try {
            if (TextUtils.isEmpty(this.f701f)) {
                this.f701f = C0338m.m569a().mo5040m().mo5019b(Secure.getString(context.getContentResolver(), "android_id"));
            }
            return this.f701f;
        } catch (Exception e) {
            return "";
        }
    }

    public String getAppSDC() {
        try {
            Object a = C0338m.m569a().mo5040m().mo5012a("sysSdc");
            if (a != null) {
                return (String) a;
            }
        } catch (Throwable e) {
            C0336j.m550a().mo4928e(e);
        }
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return "0,0";
        }
        String str = "";
        try {
            long availableExternalMemorySize = getAvailableExternalMemorySize();
            str = availableExternalMemorySize + "," + getAllExternalMemorySize();
            C0338m.m569a().mo5040m().mo5018a("sysSdc", (Object) str);
            return str;
        } catch (Exception e2) {
            return str;
        }
    }

    public long getAvailableExternalMemorySize() {
        try {
            return Environment.getExternalStorageState().equals("mounted") ? m591b(Environment.getExternalStorageDirectory()) : -1;
        } catch (Exception e) {
            return -1;
        }
    }

    public long getAvailableInternalMemorySize() {
        try {
            return m591b(Environment.getDataDirectory());
        } catch (Exception e) {
            return -1;
        }
    }

    public JSONArray getBackgroundBrowsers(Context context) {
        IXAdLogger f = C0338m.m569a().mo5033f();
        String[] supportedBrowsers = C0338m.m569a().mo5043p().getSupportedBrowsers();
        try {
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (!(packageManager.getLaunchIntentForPackage(runningAppProcessInfo.processName) == null || packageManager.getApplicationInfo(runningAppProcessInfo.processName, 128) == null)) {
                    for (Object equals : supportedBrowsers) {
                        if (runningAppProcessInfo.processName.equals(equals)) {
                            this.f697a.put(runningAppProcessInfo.processName);
                        }
                    }
                }
            }
        } catch (Throwable e) {
            f.mo4924d(e);
        }
        f.mo4921d("bgBrowsers:" + this.f697a);
        return this.f697a;
    }

    public String getCUID(Context context) {
        try {
            if (TextUtils.isEmpty(f696b)) {
                String string = System.getString(context.getContentResolver(), "com.baidu.deviceid");
                if (!(string == null || string.equals(""))) {
                    String string2 = System.getString(context.getContentResolver(), "bd_setting_i");
                    if (TextUtils.isEmpty(string2)) {
                        string2 = "0";
                    }
                    f696b = string + "|" + new StringBuffer(string2).reverse().toString();
                }
            }
            return C0338m.m569a().mo5040m().mo5019b(f696b);
        } catch (Exception e) {
            return C0338m.m569a().mo5040m().mo5019b(f696b);
        }
    }

    public List<String[]> getCell(Context context) {
        try {
            Object a = C0338m.m569a().mo5040m().mo5012a("cell");
            if (a != null) {
                return (List) a;
            }
        } catch (Throwable e) {
            C0336j.m550a().mo4928e(e);
        }
        List<String[]> arrayList = new ArrayList();
        try {
            CellLocation cellLocation = ((TelephonyManager) context.getSystemService("phone")).getCellLocation();
            if (cellLocation != null) {
                Object obj = new String[3];
                if (cellLocation instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    obj[0] = gsmCellLocation.getCid();
                    obj[1] = gsmCellLocation.getLac();
                    obj[2] = "0";
                } else {
                    String[] split = cellLocation.toString().replace("[", "").replace("]", "").split(",");
                    obj[0] = split[0];
                    obj[1] = split[3];
                    obj[2] = split[4];
                }
                arrayList.add(obj);
            }
            C0338m.m569a().mo5040m().mo5018a("cell", (Object) arrayList);
        } catch (Exception e2) {
        }
        return arrayList;
    }

    public int getCurrentProcessId(Context context) {
        try {
            return Process.myPid();
        } catch (Exception e) {
            return 0;
        }
    }

    public String getCurrentProcessName(Context context) {
        try {
            if (this.f707l == null) {
                int myPid = Process.myPid();
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager != null) {
                    List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses != null) {
                        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (runningAppProcessInfo.pid == myPid) {
                                this.f707l = runningAppProcessInfo.processName;
                            }
                        }
                    }
                }
            }
            return this.f707l;
        } catch (Exception e) {
            return this.f707l;
        }
    }

    public String getDeviceId(Context context) {
        return getIMEI(context);
    }

    public String getEncodedSN(Context context) {
        try {
            if (TextUtils.isEmpty(this.f706k)) {
                this.f706k = C0338m.m569a().mo5032e().encode(getSn(context));
            }
            return this.f706k;
        } catch (Exception e) {
            return this.f706k;
        }
    }

    public double[] getGPS(Context context) {
        Object a;
        try {
            a = C0338m.m569a().mo5040m().mo5012a("SYSGPS");
            if (a != null) {
                return (double[]) a;
            }
        } catch (Throwable e) {
            C0336j.m550a().mo4928e(e);
        }
        if (C0338m.m569a().mo5040m().hasPermission(context, "android.permission.ACCESS_FINE_LOCATION")) {
            try {
                Location lastKnownLocation = ((LocationManager) context.getSystemService("location")).getLastKnownLocation("gps");
                if (lastKnownLocation != null) {
                    a = new double[3];
                    try {
                        a[0] = (double) lastKnownLocation.getTime();
                        a[1] = lastKnownLocation.getLongitude();
                        a[2] = lastKnownLocation.getLatitude();
                    } catch (SecurityException e2) {
                    }
                    C0338m.m569a().mo5040m().mo5018a("SYSGPS", a);
                    return a;
                }
            } catch (SecurityException e3) {
                a = null;
            }
        }
        a = null;
        C0338m.m569a().mo5040m().mo5018a("SYSGPS", a);
        return a;
    }

    public String getGUID(Context context) {
        try {
            if (this.f700e != null || context == null) {
                return this.f700e;
            }
            IXAdCommonUtils m = C0338m.m569a().mo5040m();
            this.f700e = context.getSharedPreferences("__x_adsdk_agent_header__", 0).getString("guid", "");
            if (this.f700e == null || this.f700e.length() <= 0) {
                this.f700e = m.md5(getMacAddress(context) + "&" + getIMEI(context) + "&&");
                if (this.f700e == null || this.f700e.length() <= 0) {
                    return "";
                }
                context.getSharedPreferences("__x_adsdk_agent_header__", 0).edit().putString("guid", this.f700e).commit();
            }
            return this.f700e;
        } catch (Exception e) {
            return "";
        }
    }

    public HttpURLConnection getHttpConnection(Context context, String str, int i, int i2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i2);
                return httpURLConnection;
            } catch (Exception e) {
                return httpURLConnection;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    public String getIMEI(Context context) {
        if (TextUtils.isEmpty(this.f698c) && context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("__x_adsdk_agent_header__", 0);
            Object string = sharedPreferences.getString(C0338m.m569a().mo5032e().decodeStr("pyd-pifb"), "");
            if (TextUtils.isEmpty(string)) {
                try {
                    String str = (String) C0338m.m569a().mo5040m().mo5011a((TelephonyManager) context.getApplicationContext().getSystemService("phone"), C0338m.m569a().mo5032e().decodeStr("uvNYwANvpyP-iyfb"), new Object[0]);
                    if (!TextUtils.isEmpty(str)) {
                        new Thread(new C0340o(this, sharedPreferences, str)).start();
                        this.f698c = str;
                    }
                } catch (Throwable e) {
                    C0336j.m550a().mo4924d(e);
                }
            } else {
                this.f698c = string;
            }
        }
        return C0338m.m569a().mo5040m().mo5019b(this.f698c);
    }

    @TargetApi(3)
    public String getIp(Context context) {
        String str = "";
        if (((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() == null) {
            return "";
        }
        String str2;
        try {
            str = Formatter.formatIpAddress(((WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo().getIpAddress());
            if (!TextUtils.isEmpty(str)) {
                return "0.0.0.0".equals(str) ? "" : str;
            } else {
                Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                        if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && inetAddress.isSiteLocalAddress() && (inetAddress instanceof Inet4Address)) {
                            return inetAddress.getHostAddress();
                        }
                    }
                }
                str2 = str;
                return str2;
            }
        } catch (SocketException e) {
            str2 = str;
        } catch (Exception e2) {
            str2 = str;
        }
    }

    public String getMacAddress(Context context) {
        if (TextUtils.isEmpty(this.f702g)) {
            IXAdLogger f = C0338m.m569a().mo5033f();
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI);
                if (C0338m.m569a().mo5040m().hasPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                    this.f702g = C0338m.m569a().mo5040m().mo5019b(wifiManager.getConnectionInfo().getMacAddress());
                } else {
                    f.mo4929e("", "Could not get mac address. no android.permission.ACCESS_WIFI_STATE");
                }
            } catch (Exception e) {
                f.mo4929e("", "Could not get mac address." + e.toString());
            }
        }
        return this.f702g;
    }

    public String getMaxCpuFreq() {
        BufferedReader bufferedReader;
        Throwable e;
        IXAdLogger f;
        FileReader fileReader = null;
        if (this.f703h < 0) {
            FileReader fileReader2;
            try {
                fileReader2 = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
                try {
                    bufferedReader = new BufferedReader(fileReader2);
                } catch (Exception e2) {
                    e = e2;
                    bufferedReader = null;
                    fileReader = fileReader2;
                    try {
                        C0338m.m569a().mo5033f().mo4924d(e);
                        try {
                            fileReader.close();
                            bufferedReader.close();
                        } catch (IOException e3) {
                            e = e3;
                            f = C0338m.m569a().mo5033f();
                        }
                        return this.f703h;
                    } catch (Throwable th) {
                        e = th;
                        fileReader2 = fileReader;
                        try {
                            fileReader2.close();
                            bufferedReader.close();
                        } catch (Throwable e4) {
                            C0338m.m569a().mo5033f().mo4924d(e4);
                        }
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    bufferedReader = null;
                    fileReader2.close();
                    bufferedReader.close();
                    throw e;
                }
                try {
                    this.f703h = Integer.parseInt(bufferedReader.readLine().trim()) / 1000;
                    try {
                        fileReader2.close();
                        bufferedReader.close();
                    } catch (IOException e5) {
                        e = e5;
                        f = C0338m.m569a().mo5033f();
                        f.mo4924d(e);
                        return this.f703h;
                    }
                } catch (Exception e6) {
                    e = e6;
                    fileReader = fileReader2;
                    C0338m.m569a().mo5033f().mo4924d(e);
                    fileReader.close();
                    bufferedReader.close();
                    return this.f703h;
                } catch (Throwable th3) {
                    e = th3;
                    fileReader2.close();
                    bufferedReader.close();
                    throw e;
                }
            } catch (Exception e7) {
                e = e7;
                bufferedReader = null;
                C0338m.m569a().mo5033f().mo4924d(e);
                fileReader.close();
                bufferedReader.close();
                return this.f703h;
            } catch (Throwable th4) {
                e = th4;
                bufferedReader = null;
                fileReader2 = null;
                fileReader2.close();
                bufferedReader.close();
                throw e;
            }
        }
        return this.f703h;
    }

    public String getMem() {
        try {
            Object a = C0338m.m569a().mo5040m().mo5012a("sysMem");
            if (a != null) {
                return (String) a;
            }
        } catch (Throwable e) {
            C0336j.m550a().mo4928e(e);
        }
        String str = "";
        try {
            long availableInternalMemorySize = getAvailableInternalMemorySize();
            str = availableInternalMemorySize + "," + getAllInternalMemorySize();
            C0338m.m569a().mo5040m().mo5018a("sysMem", (Object) str);
            return str;
        } catch (Exception e2) {
            return str;
        }
    }

    public String getNetType(Context context) {
        String str = "";
        try {
            str = "_" + ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            return (networkInfo == null || !networkInfo.isAvailable()) ? (networkInfo2 == null || !networkInfo2.isAvailable()) ? str : new StringBuilder(IXAdSystemUtils.NT_WIFI).append(str).toString() : networkInfo.getExtraInfo() + str;
        } catch (Throwable e) {
            Throwable th = e;
            String str2 = str;
            C0336j.m550a().mo4928e(th);
            return str2;
        }
    }

    public int getNetworkCatagory(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    return 100;
                }
                if (activeNetworkInfo.getType() == 0) {
                    String subtypeName = activeNetworkInfo.getSubtypeName();
                    switch (activeNetworkInfo.getSubtype()) {
                        case 0:
                            return 1;
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return 2;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                            return 3;
                        default:
                            return (subtypeName == null || !(subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000"))) ? 1 : 3;
                    }
                }
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    public String getNetworkOperator(Context context) {
        try {
            if (TextUtils.isEmpty(this.f705j)) {
                this.f705j = C0338m.m569a().mo5040m().mo5019b(((TelephonyManager) context.getSystemService("phone")).getNetworkOperator());
            }
            return this.f705j;
        } catch (Exception e) {
            return this.f705j;
        }
    }

    public String getNetworkOperatorName(Context context) {
        if (TextUtils.isEmpty(this.f704i)) {
            try {
                IXAdCommonUtils m = C0338m.m569a().mo5040m();
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                Object simOperatorName = telephonyManager.getSimOperatorName();
                StringBuilder stringBuilder = new StringBuilder();
                if (TextUtils.isEmpty(simOperatorName)) {
                    simOperatorName = telephonyManager.getNetworkOperatorName();
                    if (TextUtils.isEmpty(simOperatorName)) {
                        return "";
                    }
                    stringBuilder.append(simOperatorName);
                } else {
                    stringBuilder.append(simOperatorName);
                }
                stringBuilder.append("_");
                Object simOperator = telephonyManager.getSimOperator();
                if (!TextUtils.isEmpty(simOperator)) {
                    stringBuilder.append(simOperator);
                }
                if (stringBuilder.length() > 1) {
                    this.f704i = m.getTextEncoder(stringBuilder.toString());
                }
            } catch (Exception e) {
                C0338m.m569a().mo5033f().mo4929e("Get operator failed", "");
            }
        }
        return this.f704i;
    }

    @SuppressLint({"DefaultLocale"})
    @TargetApi(3)
    public String getNetworkType(Context context) {
        Exception e;
        String str = IXAdSystemUtils.NT_NONE;
        String str2;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                return str;
            }
            if (activeNetworkInfo.getType() == 1) {
                return IXAdSystemUtils.NT_WIFI;
            }
            str2 = "unknown";
            try {
                return activeNetworkInfo.getSubtypeName() != null ? activeNetworkInfo.getSubtypeName().toLowerCase() : str2;
            } catch (Exception e2) {
                e = e2;
                C0338m.m569a().mo5033f().mo4933i(e);
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str;
            e = exception;
            C0338m.m569a().mo5033f().mo4933i(e);
            return str2;
        }
    }

    public String getPhoneOSBrand() {
        return C0338m.m569a().mo5040m().mo5019b(Build.BRAND);
    }

    public String getPhoneOSBuildVersionSdk() {
        return C0338m.m569a().mo5040m().mo5019b(VERSION.SDK);
    }

    public String getSn(Context context) {
        try {
            if (TextUtils.isEmpty(this.f699d)) {
                String imei = getIMEI(context);
                if (TextUtils.isEmpty(imei)) {
                    imei = getMacAddress(context);
                }
                this.f699d = C0338m.m569a().mo5040m().mo5019b(imei);
            }
            return this.f699d;
        } catch (Exception e) {
            return "";
        }
    }

    public List<String[]> getWIFI(Context context) {
        int i = 0;
        IXAdCommonUtils m = C0338m.m569a().mo5040m();
        try {
            Object a = ((C0329d) m).mo5012a(IXAdSystemUtils.NT_WIFI);
            if (a != null) {
                return (List) a;
            }
        } catch (Throwable e) {
            C0336j.m550a().mo4928e(e);
        }
        List<String[]> arrayList = new ArrayList();
        try {
            if (m.hasPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                WifiManager wifiManager = (WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI);
                if (wifiManager.isWifiEnabled()) {
                    List scanResults = wifiManager.getScanResults();
                    Collections.sort(scanResults, new C0341p(this));
                    while (i < scanResults.size() && i < 5) {
                        String toLowerCase = ((ScanResult) scanResults.get(i)).BSSID.replace(":", "").toLowerCase(Locale.getDefault());
                        arrayList.add(new String[]{toLowerCase, Math.abs(r1.level)});
                        i++;
                    }
                }
            }
        } catch (Throwable e2) {
            C0336j.m550a().mo4928e(e2);
        }
        ((C0329d) m).mo5018a(IXAdSystemUtils.NT_WIFI, (Object) arrayList);
        return arrayList;
    }

    public String getWifiConnected(Context context) {
        String str = "";
        try {
            if (C0338m.m569a().mo5040m().hasPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo();
                String ssid = connectionInfo.getSSID();
                if (ssid == null) {
                    ssid = "";
                } else if (ssid.length() > 2 && ssid.startsWith("\"") && ssid.endsWith("\"")) {
                    ssid = ssid.substring(1, ssid.length() - 1);
                }
                return connectionInfo.getBSSID() + "|" + C0338m.m569a().mo5032e().encode(ssid);
            }
        } catch (Throwable e) {
            C0338m.m569a().mo5033f().mo4924d(e);
        }
        return str;
    }

    public JSONArray getWifiScans(Context context) {
        try {
            Object a = C0338m.m569a().mo5040m().mo5012a("wifiScans");
            if (a != null) {
                return (JSONArray) a;
            }
        } catch (Throwable e) {
            C0336j.m550a().mo4928e(e);
        }
        JSONArray jSONArray = new JSONArray();
        try {
            if (C0338m.m569a().mo5040m().hasPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                WifiManager wifiManager = (WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI);
                if (wifiManager.isWifiEnabled()) {
                    List scanResults = wifiManager.getScanResults();
                    Collections.sort(scanResults, new C0342q(this));
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= scanResults.size() || i2 >= 50) {
                            break;
                        }
                        ScanResult scanResult = (ScanResult) scanResults.get(i2);
                        jSONArray.put(scanResult.BSSID + "|" + C0338m.m569a().mo5032e().encode(scanResult.SSID));
                        i = i2 + 1;
                    }
                }
            }
        } catch (Throwable e2) {
            C0338m.m569a().mo5033f().mo4924d(e2);
        }
        C0338m.m569a().mo5040m().mo5018a("wifiScans", (Object) jSONArray);
        return jSONArray;
    }

    public Boolean is3GConnected(Context context) {
        return m590a(context, 0);
    }

    public boolean isCurrentNetworkAvailable(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
        } catch (Throwable e) {
            C0338m.m569a().mo5033f().mo4923d("isCurrentNetworkAvailable", e);
            return false;
        }
    }

    @TargetApi(4)
    public boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public boolean isUseOldStoragePath() {
        return VERSION.SDK_INT < 23;
    }

    public Boolean isWifiConnected(Context context) {
        return m590a(context, 1);
    }
}
