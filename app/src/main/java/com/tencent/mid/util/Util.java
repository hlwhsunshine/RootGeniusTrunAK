package com.tencent.mid.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
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
import com.tencent.mid.api.MidEntity;
import com.tencent.mid.api.MidService;
import com.tencent.mid.p117b.C1649g;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URL;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.List;
import java.util.zip.GZIPInputStream;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONObject;

public class Util {
    public static byte[] StringToBytes(String str) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str.getBytes();
        }
    }

    public static String bytesToString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return new String(bArr);
        }
    }

    public static boolean checkPermission(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            return false;
        }
    }

    public static void clear(Context context) {
        if (context != null) {
            C1649g.m4537a(context).mo7667c();
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
            return new String(C1656g.m4553b(Base64.decode(str.getBytes("UTF-8"), 0)), "UTF-8").trim().replace("\t", "").replace("\n", "").replace("\r", "");
        } catch (Throwable th) {
            return str;
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

    public static String encode(String str) {
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(Base64.encode(C1656g.m4551a(str.getBytes("UTF-8")), 0), "UTF-8").trim().replace("\t", "").replace("\n", "").replace("\r", "");
        } catch (Throwable th) {
            return str;
        }
    }

    public static boolean equal(MidEntity midEntity, MidEntity midEntity2) {
        return (midEntity == null || midEntity2 == null) ? midEntity == null && midEntity2 == null : midEntity.compairTo(midEntity2) == 0;
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

    public static byte[] getHMAC(String str, String str2) {
        try {
            Key secretKeySpec = new SecretKeySpec(str.getBytes(), "hmacmd5");
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            instance.update(str2.getBytes());
            return instance.doFinal();
        } catch (Throwable e) {
            logWarn(e);
            return null;
        }
    }

    public static HttpHost getHttpProxy() {
        return Proxy.getDefaultHost() != null ? new HttpHost(Proxy.getDefaultHost(), Proxy.getDefaultPort()) : null;
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
            logInfo("network type:" + extraInfo);
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
            logWarn(th);
        }
    }

    public static String getHttpUrl() {
        return "http://pingmid.qq.com:80/";
    }

    public static String getImei(Context context) {
        try {
            if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId != null) {
                    return deviceId;
                }
            }
            logInfo("Could not get permission of android.permission.READ_PHONE_STATE");
        } catch (Throwable th) {
            logWarn(th);
        }
        return "";
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

    public static MidEntity getNewerMidEntity(MidEntity midEntity, MidEntity midEntity2) {
        return (midEntity == null || midEntity2 == null) ? midEntity == null ? midEntity2 != null ? midEntity2 : null : midEntity : midEntity.compairTo(midEntity2) >= 0 ? midEntity : midEntity2;
    }

    public static String getRemoteUrlIp(String str) {
        try {
            InetAddress byName = InetAddress.getByName(new URL(str).getHost());
            if (byName != null) {
                return byName.getHostAddress();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
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
            logWarn(th);
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
            logWarn(th);
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
        if (checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI);
                return wifiManager == null ? "" : wifiManager.getConnectionInfo().getMacAddress();
            } catch (Exception e) {
                logInfo("get wifi address error" + e);
                return "";
            }
        }
        logInfo("Could not get permission of android.permission.ACCESS_WIFI_STATE");
        return "";
    }

    public static JSONArray getWifiTopN(Context context, int i) {
        try {
            if (checkPermission(context, "android.permission.INTERNET") && checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                WifiManager wifiManager = (WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI);
                if (wifiManager != null) {
                    List scanResults = wifiManager.getScanResults();
                    if (scanResults != null && scanResults.size() > 0) {
                        Collections.sort(scanResults, new C1659j());
                        JSONArray jSONArray = new JSONArray();
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 < scanResults.size() && i3 < i) {
                                ScanResult scanResult = (ScanResult) scanResults.get(i3);
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("bs", scanResult.BSSID);
                                jSONObject.put("ss", scanResult.SSID);
                                jSONArray.put(jSONObject);
                                i2 = i3 + 1;
                            }
                        }
                        return jSONArray;
                    }
                }
                return null;
            }
            logInfo("can not get the permisson of android.permission.INTERNET");
            return null;
        } catch (Throwable th) {
            logWarn(th);
        }
    }

    public static boolean isMidValid(String str) {
        return str != null && str.trim().length() >= 40;
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

    public static boolean isStringValid(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    public static boolean isWifiNet(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getTypeName() == null || !activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) ? false : true;
    }

    public static void jsonPut(JSONObject jSONObject, String str, String str2) {
        if (isStringValid(str2)) {
            jSONObject.put(str, str2);
        }
    }

    public static void logInfo(String str) {
        MidService.isEnableDebug();
    }

    public static void logWarn(Throwable th) {
        MidService.isEnableDebug();
    }

    public static String md5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes("UTF-8"));
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte append : digest) {
                stringBuffer.append(append);
            }
            return stringBuffer.toString();
        } catch (Throwable e) {
            logWarn(e);
            return str;
        } catch (Throwable e2) {
            logWarn(e2);
            return str;
        }
    }

    public static void updateIfLocalInvalid(Context context, String str) {
        if (isMidValid(str)) {
            MidEntity midEntity = new MidEntity();
            midEntity.setImei(getImei(context));
            midEntity.setMac(getWifiMacAddress(context));
            midEntity.setMid(str);
            C1649g.m4537a(context).mo7663a(midEntity);
        }
    }
}
