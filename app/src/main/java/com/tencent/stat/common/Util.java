package com.tencent.stat.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.tencent.mid.api.MidService;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class Util {
    /* renamed from: a */
    private static String f5040a = "";

    public static boolean checkPermission(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            return false;
        }
    }

    public static String decode(String str) {
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(C1722f.m4741b(C1724h.m4749a(str.getBytes("UTF-8"), 0)), "UTF-8");
        } catch (Throwable th) {
            return str;
        }
    }

    public static String encode(String str) {
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(C1724h.m4751b(C1722f.m4739a(str.getBytes("UTF-8")), 0), "UTF-8");
        } catch (Throwable th) {
            return str;
        }
    }

    public static JSONObject getConnecetedWifiInfo(Context context) {
        WifiInfo wifiInfo = getWifiInfo(context);
        if (wifiInfo != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("bs", wifiInfo.getBSSID());
                jSONObject.put("ss", wifiInfo.getSSID());
                jSONObject.put("dBm", wifiInfo.getRssi());
                return jSONObject;
            } catch (Throwable th) {
            }
        }
        return null;
    }

    public static String getDeviceID(Context context) {
        try {
            if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId != null) {
                    return deviceId;
                }
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static String getExternalStorageInfo(Context context) {
        try {
            if (!checkPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                return null;
            }
            String externalStorageState = Environment.getExternalStorageState();
            if (externalStorageState == null || !externalStorageState.equals("mounted")) {
                return null;
            }
            externalStorageState = Environment.getExternalStorageDirectory().getPath();
            if (externalStorageState == null) {
                return null;
            }
            StatFs statFs = new StatFs(externalStorageState);
            long blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000;
            return String.valueOf((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1000000) + "/" + String.valueOf(blockCount);
        } catch (Throwable th) {
            return null;
        }
    }

    public static String getLinkedWay(Context context) {
        try {
            if (checkPermission(context, "android.permission.INTERNET") && checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    String typeName = activeNetworkInfo.getTypeName();
                    String extraInfo = activeNetworkInfo.getExtraInfo();
                    if (typeName != null) {
                        return typeName.equalsIgnoreCase("WIFI") ? "WIFI" : typeName.equalsIgnoreCase("MOBILE") ? extraInfo != null ? extraInfo : "MOBILE" : extraInfo != null ? extraInfo : typeName;
                    }
                }
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static String getMid(Context context) {
        return com.tencent.mid.util.Util.isMidValid(f5040a) ? f5040a : MidService.getMid(context);
    }

    public static String getSimOperator(Context context) {
        try {
            if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    return telephonyManager.getSimOperator();
                }
            }
        } catch (Throwable th) {
        }
        return null;
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

    public static String getWiFiBBSID(Context context) {
        try {
            WifiInfo wifiInfo = getWifiInfo(context);
            if (wifiInfo != null) {
                return wifiInfo.getBSSID();
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static String getWiFiSSID(Context context) {
        try {
            WifiInfo wifiInfo = getWifiInfo(context);
            if (wifiInfo != null) {
                return wifiInfo.getSSID();
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static WifiInfo getWifiInfo(Context context) {
        if (checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(IXAdSystemUtils.NT_WIFI);
            if (wifiManager != null) {
                return wifiManager.getConnectionInfo();
            }
        }
        return null;
    }

    public static String getWifiMacAddress(Context context) {
        if (!checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
            return "";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI);
            return wifiManager == null ? "" : wifiManager.getConnectionInfo().getMacAddress();
        } catch (Exception e) {
            return "";
        }
    }

    public static JSONArray getWifiTopN(Context context, int i) {
        try {
            if (checkPermission(context, "android.permission.INTERNET") && checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                WifiManager wifiManager = (WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI);
                if (wifiManager != null) {
                    List scanResults = wifiManager.getScanResults();
                    if (scanResults != null && scanResults.size() > 0) {
                        Collections.sort(scanResults, new C1732p());
                        JSONArray jSONArray = new JSONArray();
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 < scanResults.size() && i3 < i) {
                                ScanResult scanResult = (ScanResult) scanResults.get(i3);
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("bs", scanResult.BSSID);
                                jSONObject.put("ss", scanResult.SSID);
                                jSONObject.put("dBm", scanResult.level);
                                jSONArray.put(jSONObject);
                                i2 = i3 + 1;
                            }
                        }
                        return jSONArray;
                    }
                }
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static boolean isNetworkAvailable(Context context) {
        try {
            if (checkPermission(context, "android.permission.INTERNET") && checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
                }
            }
        } catch (Throwable th) {
        }
        return false;
    }

    public static boolean isWifiNet(Context context) {
        try {
            if (checkPermission(context, "android.permission.INTERNET") && checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI");
                }
            }
        } catch (Throwable th) {
        }
        return false;
    }

    public static void jsonPut(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            try {
                if (str2.length() > 0) {
                    jSONObject.put(str, str2);
                }
            } catch (Throwable th) {
            }
        }
    }
}
