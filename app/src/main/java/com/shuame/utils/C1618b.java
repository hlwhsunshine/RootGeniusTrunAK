package com.shuame.utils;

import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import android.p014os.SystemProperties;
import android.telephony.TelephonyManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.regex.Pattern;

/* renamed from: com.shuame.utils.b */
public class C1618b {
    /* renamed from: a */
    private static final String f4577a = C1618b.class.getSimpleName();

    /* renamed from: a */
    private static String m4387a() {
        String str;
        String str2 = "";
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            Method method = cls.getMethod("get", new Class[]{String.class});
            if (method != null) {
                if (((String) method.invoke(cls.newInstance(), new Object[]{"telephony.lteOnCdmaDevice"})).equals("1")) {
                    Method method2 = Class.forName("com.huawei.android.hwnv.HWNVFuncation").getMethod("getNVIMEI", new Class[0]);
                    if (method2 == null) {
                        return str2;
                    }
                    method2.setAccessible(true);
                    str = (String) method2.invoke(null, new Object[0]);
                    return str;
                }
            }
        } catch (Throwable th) {
        }
        str = str2;
        return str;
    }

    /* renamed from: a */
    public static HashSet<String> m4388a(Context context) {
        int i = 0;
        HashSet<String> hashSet = new HashSet();
        String str = Build.MODEL;
        Build.BRAND.toLowerCase().trim();
        try {
            String deviceId;
            Class cls;
            Field field;
            int parseInt;
            Field field2;
            String trim;
            Class cls2;
            Method method;
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                deviceId = (context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0 ? 1 : i) != 0 ? telephonyManager.getDeviceId() : null;
            } else {
                deviceId = null;
            }
            if (deviceId != null && deviceId.indexOf("0000000000") >= 0) {
                deviceId = "";
            }
            if (!(deviceId == null || deviceId == "")) {
                hashSet.add(deviceId + "|z1");
            }
            try {
                int parseInt2;
                telephonyManager = (TelephonyManager) context.getSystemService("phone");
                cls = Class.forName("com.android.internal.telephony.Phone");
                try {
                    field = cls.getField("GEMINI_SIM_1");
                    field.setAccessible(true);
                    parseInt = Integer.parseInt(field.get(null).toString());
                    field2 = cls.getField("GEMINI_SIM_2");
                    field2.setAccessible(true);
                    parseInt2 = Integer.parseInt(field2.get(null).toString());
                } catch (Throwable th) {
                    parseInt = i;
                    parseInt2 = 1;
                }
                Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getDeviceIdGemini", new Class[]{Integer.TYPE});
                trim = ((String) declaredMethod.invoke(telephonyManager, new Object[]{Integer.valueOf(parseInt)})).trim();
                deviceId = ((String) declaredMethod.invoke(telephonyManager, new Object[]{Integer.valueOf(parseInt2)})).trim();
                if (!(hashSet.contains(trim) || trim == null || trim.indexOf("0000000000") != -1)) {
                    hashSet.add(trim + "|a1");
                }
                if (!(hashSet.contains(deviceId) || deviceId == null || deviceId.indexOf("0000000000") != -1)) {
                    hashSet.add(deviceId + "|a2");
                }
            } catch (Throwable th2) {
            }
            try {
                telephonyManager = (TelephonyManager) context.getSystemService("phone");
                cls = Class.forName("com.android.internal.telephony.Phone");
                try {
                    field = cls.getField("GEMINI_SIM_1");
                    field.setAccessible(true);
                    parseInt = Integer.parseInt(field.get(null).toString());
                    field2 = cls.getField("GEMINI_SIM_2");
                    field2.setAccessible(true);
                    i = Integer.parseInt(field2.get(null).toString());
                } catch (Throwable th3) {
                    parseInt = i;
                    i = 1;
                }
                Method method2 = TelephonyManager.class.getMethod("getDefault", new Class[]{Integer.TYPE});
                TelephonyManager telephonyManager2 = (TelephonyManager) method2.invoke(telephonyManager, new Object[]{Integer.valueOf(parseInt)});
                telephonyManager = (TelephonyManager) method2.invoke(telephonyManager, new Object[]{Integer.valueOf(i)});
                trim = telephonyManager2.getDeviceId().trim();
                deviceId = telephonyManager.getDeviceId().trim();
                if (!(hashSet.contains(trim) || trim == null || trim.indexOf("0000000000") != -1)) {
                    hashSet.add(trim + "|b1");
                }
                if (!(hashSet.contains(deviceId) || deviceId == null || deviceId.indexOf("0000000000") != -1)) {
                    hashSet.add(deviceId + "|b2");
                }
            } catch (Throwable th4) {
            }
            try {
                cls2 = Class.forName("com.android.internal.telephony.PhoneFactory");
                deviceId = (String) cls2.getMethod("getServiceName", new Class[]{String.class, Integer.TYPE}).invoke(cls2, new Object[]{"phone", Integer.valueOf(1)});
                trim = ((TelephonyManager) context.getSystemService("phone")).getDeviceId().trim();
                deviceId = ((TelephonyManager) context.getSystemService(deviceId)).getDeviceId().trim();
                if (!(hashSet.contains(trim) || trim == null || trim.indexOf("0000000000") != -1)) {
                    hashSet.add(trim + "|c1");
                }
                if (!(hashSet.contains(deviceId) || deviceId == null || deviceId.indexOf("0000000000") != -1)) {
                    hashSet.add(deviceId + "|c2");
                }
            } catch (Throwable th5) {
            }
            try {
                cls2 = Class.forName("android.telephony.MSimTelephonyManager");
                Object systemService = context.getSystemService("phone_msim");
                method = cls2.getMethod("getDeviceId", new Class[]{Integer.TYPE});
                String trim2 = ((String) method.invoke(systemService, new Object[]{Integer.valueOf(0)})).trim();
                deviceId = ((String) method.invoke(systemService, new Object[]{Integer.valueOf(1)})).trim();
                if (!(hashSet.contains(trim2) || trim2 == null || trim2.indexOf("0000000000") != -1)) {
                    hashSet.add(trim2 + "|d1");
                }
                if (!(hashSet.contains(deviceId) || deviceId == null || deviceId.indexOf("0000000000") != -1)) {
                    hashSet.add(deviceId + "|d2");
                }
            } catch (Throwable th6) {
            }
            try {
                telephonyManager = (TelephonyManager) context.getSystemService("phone");
                method = Class.forName("android.telephony.TelephonyManager").getMethod("getDeviceIdDs", new Class[]{Integer.TYPE});
                if (method != null) {
                    trim = (String) method.invoke(telephonyManager, new Object[]{Integer.valueOf(0)});
                    deviceId = (String) method.invoke(telephonyManager, new Object[]{Integer.valueOf(1)});
                    if (C1618b.m4389a(trim)) {
                        hashSet.add(trim + "|e1");
                    }
                    if (C1618b.m4389a(deviceId)) {
                        hashSet.add(deviceId + "|e2");
                    }
                }
            } catch (Throwable th7) {
            }
            try {
                Method method3;
                if (!(str.contains("WP-S") || str.contains("D5012T") || str.contains("K-Touch K3"))) {
                    try {
                        telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        telephonyManager.getPhoneType();
                        method = telephonyManager.getClass().getMethod("getDeviceId", new Class[]{Integer.TYPE});
                        if (method != null) {
                            hashSet.add(((String) method.invoke(telephonyManager, new Object[]{Integer.valueOf(0)})) + "|f1");
                            hashSet.add(((String) method.invoke(telephonyManager, new Object[]{Integer.valueOf(1)})) + "|f2");
                            hashSet.add(((String) method.invoke(telephonyManager, new Object[]{Integer.valueOf(2)})) + "|f3");
                        }
                    } catch (Throwable th8) {
                    }
                }
                try {
                    telephonyManager = (TelephonyManager) context.getSystemService("phone2");
                    method3 = context.getSystemService("phone2").getClass().getMethod("getImeiInCDMAGSMPhone", new Class[0]);
                    if (method3 != null) {
                        deviceId = method3.invoke(telephonyManager, new Object[0]).toString();
                        if (C1618b.m4389a(deviceId)) {
                            hashSet.add(deviceId + "|g1");
                        }
                    }
                } catch (Throwable th9) {
                }
                try {
                    if (SystemProperties.getInt("ro.miui.ui.version.code", 0) < 5) {
                        trim = "";
                        try {
                            IBinder iBinder = (IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"phone"});
                            Object invoke = Class.forName("com.android.internal.telephony.ITelephony$Stub").getMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{iBinder});
                            deviceId = invoke.getClass().getMethod("getMeid", new Class[0]).invoke(invoke, new Object[0]).toString();
                        } catch (Throwable th10) {
                            deviceId = trim;
                        }
                        if (C1618b.m4389a(deviceId)) {
                            hashSet.add(deviceId + "|h1");
                        }
                    }
                } catch (Throwable th11) {
                }
                try {
                    telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    method3 = context.getSystemService("phone").getClass().getMethod("getCurrentPhoneType", new Class[0]);
                    if (method3 != null) {
                        int intValue = ((Integer) method3.invoke(telephonyManager, new Object[0])).intValue();
                        if (intValue != 1 && intValue == 2) {
                            deviceId = C1618b.m4387a();
                            if (deviceId != null && deviceId.length() > 0) {
                                hashSet.add(deviceId + "|i1");
                            }
                        }
                    }
                } catch (Throwable th12) {
                }
                try {
                    try {
                        deviceId = (String) Class.forName("com.huawei.android.hwnv.HWNVFuncation").getMethod("getNVMEID", new Class[0]).invoke(null, new Object[0]);
                    } catch (Throwable th13) {
                        deviceId = "";
                    }
                    if (!hashSet.contains(deviceId) && deviceId != null && deviceId.length() > 0 && deviceId.indexOf("0000000000") == -1) {
                        hashSet.add(deviceId + "|g1");
                    }
                } catch (Throwable th14) {
                }
            } catch (Throwable th15) {
            }
        } catch (Throwable th16) {
        }
        return hashSet;
    }

    /* renamed from: a */
    private static boolean m4389a(String str) {
        return str != null && str.length() != 0 && Pattern.compile("^[0-9A-Fa-f]{13,18}+$").matcher(str).matches() && str.indexOf("000000000") == -1 && str.indexOf("111111111") == -1 && str.indexOf("222222222") == -1 && str.indexOf("333333333") == -1 && str.indexOf("444444444") == -1 && str.indexOf("555555555") == -1 && str.indexOf("666666666") == -1 && str.indexOf("777777777") == -1 && str.indexOf("888888888") == -1 && str.indexOf("999999999") == -1;
    }
}
