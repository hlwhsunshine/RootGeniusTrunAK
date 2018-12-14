package com.tencent.xuanfeng.downloadsdkkernel;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.util.UUID;
import java.util.regex.Pattern;

public class NetCallUntl {
    public static final int NET_TYPE_LESS_THAN_3G = 102;
    public static final int NET_TYPE_MORE_THAN_3G = 103;
    public static final int NET_TYPE_NOT_CONNECTED = 101;
    public static final int NET_TYPE_WIFI = 104;
    public static final Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");

    public static int getCpuProcessorCount() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() {
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]", file.getName());
                }
            }).length;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    public static int getMaxCpuFreq() {
        try {
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            Object obj = "";
            while (inputStream.read(bArr) != -1) {
                obj = new StringBuilder(String.valueOf(obj)).append(new String(bArr)).toString();
            }
            inputStream.close();
            if (!TextUtils.isEmpty(obj)) {
                return Integer.valueOf(obj.trim()).intValue() / 1000;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 2000;
    }

    public static String getMyUUID(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String str = telephonyManager.getDeviceId();
            return new UUID((long) (Secure.getString(context.getContentResolver(), "android_id")).hashCode(), ((long) (telephonyManager.getSimSerialNumber()).hashCode()) | (((long) str.hashCode()) << 32)).toString();
        } catch (Exception e) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("download", 0);
            String string = sharedPreferences.getString("uuid", null);
            if (string != null) {
                return string;
            }
            string = UUID.randomUUID().toString();
            sharedPreferences.edit().putString("uuid", string).commit();
            return string;
        }
    }

    public static int getNetState(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return 101;
        }
        String typeName = activeNetworkInfo.getTypeName();
        return typeName.equalsIgnoreCase("WIFI") ? NET_TYPE_WIFI : typeName.equalsIgnoreCase("MOBILE") ? activeNetworkInfo.getSubtype() > 5 ? NET_TYPE_MORE_THAN_3G : 102 : NET_TYPE_WIFI;
    }

    public static int getNetworkType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getSubtype();
            }
        } catch (Exception e) {
            e.getLocalizedMessage();
        }
        return 0;
    }

    public static int getSimOperator(Context context) {
        String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        if (simOperator != null) {
            if (simOperator.equals("46000") || simOperator.equals("46002")) {
                return 1;
            }
            if (simOperator.equals("46001")) {
                return 2;
            }
            if (simOperator.equals("46003")) {
                return 3;
            }
        }
        return 0;
    }

    public static String getWapProxy(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && !activeNetworkInfo.getTypeName().equalsIgnoreCase("MOBILE")) {
            return "";
        }
        String string;
        CharSequence string2;
        String toUpperCase;
        String str = "";
        String str2 = "";
        String str3 = "";
        try {
            Cursor query = context.getContentResolver().query(PREFERRED_APN_URI, new String[]{"apn", "proxy", "port"}, null, null, null);
            Object obj;
            if (query != null) {
                if (query.moveToFirst()) {
                    string = query.getString(query.getColumnIndex("apn"));
                    string2 = query.getString(query.getColumnIndex("proxy"));
                    query.getString(query.getColumnIndex("port"));
                    if (!TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                        toUpperCase = string.toUpperCase();
                        if (toUpperCase.equals("CMWAP") || toUpperCase.equals("UNIWAP") || toUpperCase.equals("3GWAP")) {
                            string2 = "10.0.0.172";
                        } else if (toUpperCase.equals("CTWAP")) {
                            string2 = "10.0.0.200";
                        }
                    }
                    toUpperCase = "80";
                } else {
                    toUpperCase = str3;
                    obj = str2;
                    string = str;
                }
                query.close();
            } else {
                toUpperCase = str3;
                obj = str2;
                string = str;
            }
        } catch (Exception e) {
            string = "";
            string2 = "";
            toUpperCase = "";
        }
        return (TextUtils.isEmpty(string2) || TextUtils.isEmpty(string) || !("CMWAP".equalsIgnoreCase(string) || "UNIWAP".equalsIgnoreCase(string) || "CTWAP".equalsIgnoreCase(string))) ? "" : new StringBuilder(String.valueOf(string2)).append(":").append(toUpperCase).toString();
    }

    public static void netEnvChange(Context context) {
        Kernel.getKernel().netEnvChange(getNetState(context), getSimOperator(context), getNetworkType(context), getWapProxy(context));
    }
}
