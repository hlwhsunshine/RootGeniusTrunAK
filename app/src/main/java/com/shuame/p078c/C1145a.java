package com.shuame.p078c;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Enumeration;

/* renamed from: com.shuame.c.a */
public final class C1145a {
    /* renamed from: a */
    private static String m3300a() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                Method method = Class.forName("java.net.NetworkInterface").getMethod("getHardwareAddress", new Class[0]);
                while (networkInterfaces.hasMoreElements()) {
                    Object invoke = method.invoke((NetworkInterface) networkInterfaces.nextElement(), new Object[0]);
                    if (invoke instanceof byte[]) {
                        byte[] bArr = (byte[]) invoke;
                        StringBuffer stringBuffer = new StringBuffer();
                        for (int i = 0; i < bArr.length - 1; i++) {
                            stringBuffer.append(C1145a.m3301a(bArr[i]));
                            stringBuffer.append("-");
                        }
                        stringBuffer.append(C1145a.m3301a(bArr[bArr.length - 1]));
                        return stringBuffer.toString();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /* renamed from: a */
    private static String m3301a(byte b) {
        String str = "00" + Integer.toHexString(b).toUpperCase();
        int length = str.length();
        return str.substring(length - 2, length);
    }

    /* renamed from: a */
    public static String m3302a(Context context) {
        String macAddress;
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
            try {
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo();
                if (connectionInfo != null) {
                    macAddress = connectionInfo.getMacAddress();
                    if (macAddress != null && macAddress.length() > 0) {
                        return macAddress;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        macAddress = C1145a.m3300a();
        return (macAddress == null || macAddress.length() <= 0) ? "00-00-00-00-00-00" : macAddress;
    }
}
