package com.changefontmanager.sdk.utils;

import android.os.Build;
import android.os.Build.VERSION;
import com.changefontmanager.sdk.ChangeFontManager;
import com.changefontmanager.sdk.HTCChange;
import com.changefontmanager.sdk.HuaWeiC3Change;
import com.changefontmanager.sdk.HuaweiChange;
import com.changefontmanager.sdk.MIUI_V5Change;
import com.changefontmanager.sdk.NormalChange;
import com.changefontmanager.sdk.SAChange;
import java.io.File;

public class RootUtils {
    private static int OTHER = -1;
    /* renamed from: Y */
    public static String f1176Y = null;
    /* renamed from: u */
    private static int f1177u = 1;
    /* renamed from: v */
    private static int f1178v = 2;

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0079 A:{SYNTHETIC, Splitter: B:39:0x0079} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0070 A:{SYNTHETIC, Splitter: B:33:0x0070} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0079 A:{SYNTHETIC, Splitter: B:39:0x0079} */
    /* renamed from: d */
    private static int m970d() {
        /*
        r0 = 1;
        r2 = -1;
        r1 = 0;
        r3 = java.lang.Runtime.getRuntime();	 Catch:{ IOException -> 0x006a, all -> 0x0075 }
        r4 = "getprop ";
        r4 = r3.exec(r4);	 Catch:{ IOException -> 0x006a, all -> 0x0075 }
        r3 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x006a, all -> 0x0075 }
        r5 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x006a, all -> 0x0075 }
        r4 = r4.getInputStream();	 Catch:{ IOException -> 0x006a, all -> 0x0075 }
        r5.<init>(r4);	 Catch:{ IOException -> 0x006a, all -> 0x0075 }
        r4 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r3.<init>(r5, r4);	 Catch:{ IOException -> 0x006a, all -> 0x0075 }
        r1 = r2;
    L_0x001e:
        r4 = r3.readLine();	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        if (r4 != 0) goto L_0x002c;
    L_0x0024:
        r3.close();	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        r3.close();	 Catch:{ IOException -> 0x0083 }
    L_0x002a:
        r0 = r1;
    L_0x002b:
        return r0;
    L_0x002c:
        r5 = "ro.miui.ui.version.code";
        r5 = r4.contains(r5);	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        if (r5 == 0) goto L_0x0058;
    L_0x0034:
        r1 = ":";
        r1 = r4.indexOf(r1);	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        r5 = r1 + 3;
        r1 = r1 + 4;
        r1 = r4.substring(r5, r1);	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        r1 = r1.intValue();	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        r2 = 3;
        if (r1 < r2) goto L_0x0052;
    L_0x004d:
        r3.close();	 Catch:{ IOException -> 0x007d }
    L_0x0050:
        r0 = 2;
        goto L_0x002b;
    L_0x0052:
        r3.close();	 Catch:{ IOException -> 0x0056 }
        goto L_0x002b;
    L_0x0056:
        r1 = move-exception;
        goto L_0x002b;
    L_0x0058:
        r5 = "miui";
        r5 = r4.contains(r5);	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        if (r5 != 0) goto L_0x0068;
    L_0x0060:
        r5 = "MIUI";
        r4 = r4.contains(r5);	 Catch:{ IOException -> 0x008a, all -> 0x0085 }
        if (r4 == 0) goto L_0x001e;
    L_0x0068:
        r1 = r0;
        goto L_0x001e;
    L_0x006a:
        r0 = move-exception;
    L_0x006b:
        r0.printStackTrace();	 Catch:{ all -> 0x0087 }
        if (r1 == 0) goto L_0x0073;
    L_0x0070:
        r1.close();	 Catch:{ IOException -> 0x007f }
    L_0x0073:
        r0 = r2;
        goto L_0x002b;
    L_0x0075:
        r0 = move-exception;
        r3 = r1;
    L_0x0077:
        if (r3 == 0) goto L_0x007c;
    L_0x0079:
        r3.close();	 Catch:{ IOException -> 0x0081 }
    L_0x007c:
        throw r0;
    L_0x007d:
        r0 = move-exception;
        goto L_0x0050;
    L_0x007f:
        r0 = move-exception;
        goto L_0x0073;
    L_0x0081:
        r1 = move-exception;
        goto L_0x007c;
    L_0x0083:
        r0 = move-exception;
        goto L_0x002a;
    L_0x0085:
        r0 = move-exception;
        goto L_0x0077;
    L_0x0087:
        r0 = move-exception;
        r3 = r1;
        goto L_0x0077;
    L_0x008a:
        r0 = move-exception;
        r1 = r3;
        goto L_0x006b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.changefontmanager.sdk.utils.RootUtils.d():int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0049 A:{SYNTHETIC, Splitter: B:22:0x0049} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0054 A:{SYNTHETIC, Splitter: B:28:0x0054} */
    /* renamed from: k */
    private static java.lang.String m971k(java.lang.String r5) {
        /*
        r0 = 0;
        r1 = new java.io.File;	 Catch:{ IOException -> 0x0042, all -> 0x004f }
        r2 = "/system/build.prop";
        r1.<init>(r2);	 Catch:{ IOException -> 0x0042, all -> 0x004f }
        r3 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0042, all -> 0x004f }
        r3.<init>(r1);	 Catch:{ IOException -> 0x0042, all -> 0x004f }
        r2 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x0042, all -> 0x004f }
        r1 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x0042, all -> 0x004f }
        r1.<init>(r3);	 Catch:{ IOException -> 0x0042, all -> 0x004f }
        r3 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r2.<init>(r1, r3);	 Catch:{ IOException -> 0x0042, all -> 0x004f }
    L_0x0019:
        r1 = r2.readLine();	 Catch:{ IOException -> 0x005e }
        if (r1 != 0) goto L_0x0026;
    L_0x001f:
        r2.close();	 Catch:{ IOException -> 0x005e }
        r2.close();	 Catch:{ IOException -> 0x005a }
    L_0x0025:
        return r0;
    L_0x0026:
        r3 = r1.contains(r5);	 Catch:{ IOException -> 0x005e }
        if (r3 == 0) goto L_0x0019;
    L_0x002c:
        r3 = "=";
        r3 = r1.indexOf(r3);	 Catch:{ IOException -> 0x005e }
        r3 = r3 + 1;
        r4 = r1.length();	 Catch:{ IOException -> 0x005e }
        r0 = r1.substring(r3, r4);	 Catch:{ IOException -> 0x005e }
        r2.close();	 Catch:{ IOException -> 0x0040 }
        goto L_0x0025;
    L_0x0040:
        r1 = move-exception;
        goto L_0x0025;
    L_0x0042:
        r1 = move-exception;
        r2 = r0;
    L_0x0044:
        r1.printStackTrace();	 Catch:{ all -> 0x005c }
        if (r2 == 0) goto L_0x0025;
    L_0x0049:
        r2.close();	 Catch:{ IOException -> 0x004d }
        goto L_0x0025;
    L_0x004d:
        r1 = move-exception;
        goto L_0x0025;
    L_0x004f:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x0052:
        if (r2 == 0) goto L_0x0057;
    L_0x0054:
        r2.close();	 Catch:{ IOException -> 0x0058 }
    L_0x0057:
        throw r0;
    L_0x0058:
        r1 = move-exception;
        goto L_0x0057;
    L_0x005a:
        r1 = move-exception;
        goto L_0x0025;
    L_0x005c:
        r0 = move-exception;
        goto L_0x0052;
    L_0x005e:
        r1 = move-exception;
        goto L_0x0044;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.changefontmanager.sdk.utils.RootUtils.k(java.lang.String):java.lang.String");
    }

    /* renamed from: m */
    public static void m972m() {
        float floatValue;
        ChangeFontManager instance = ChangeFontManager.getInstance();
        instance.setChangefont(new NormalChange());
        String str = Build.MANUFACTURER;
        int i = VERSION.SDK_INT;
        String str2 = Build.MODEL;
        String str3 = Build.DISPLAY;
        String str4 = Build.BRAND;
        if (str2.equals("H30-U") && str.contains("huawei")) {
            instance.setChangefont(new HuaWeiC3Change());
        }
        if ((Build.BRAND.equals("Huawei") & new File("/data/skin/fonts").exists()) != 0) {
            instance.setChangefont(new HuaweiChange());
        }
        if (str2.startsWith("Lenovo")) {
            instance.setLenovoLenovo(true);
        }
        if (str2.contains("Nexus 5") || str2.contains("Nexus 7")) {
            instance.setIsnexus(true);
        }
        if (str.contains("OPPO")) {
            instance.setOPPO(true);
        }
        String toLowerCase = str2.trim().toLowerCase();
        if (str != null && str.trim().contains("samsung") && i >= 9 && (str2 == null || !(toLowerCase.contains("google") || toLowerCase.contains("nexus")))) {
            instance.setChangefont(new SAChange());
        }
        if (i >= 14) {
            instance.setSdkGreaterThanApi14(true);
        }
        if (str4.equals("Xiaomi") || (str3 != null && str3.toLowerCase().contains("miui"))) {
            instance.setChangefont(new MIUI_V5Change());
            instance.setLenovoLenovo(false);
            instance.setIsnexus(false);
        }
        switch (m970d()) {
            case 1:
            case 2:
                instance.setChangefont(new MIUI_V5Change());
                instance.setLenovoLenovo(false);
                instance.setIsnexus(false);
                instance.setOPPO(false);
                break;
        }
        str = m971k("ro.build.sense.version");
        String k = m971k("ro.oppo.theme.version");
        str3 = m971k("ro.theme.version");
        try {
            floatValue = Float.valueOf(str).floatValue();
        } catch (Exception e) {
            e.printStackTrace();
            floatValue = 0.0f;
        }
        float floatValue2;
        try {
            floatValue2 = Float.valueOf(k).floatValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            floatValue2 = 0.0f;
        }
        float floatValue3;
        try {
            floatValue3 = Float.valueOf(str3).floatValue();
        } catch (Exception e22) {
            e22.printStackTrace();
            floatValue3 = 0.0f;
        }
        if (((double) floatValue) >= 6.0d || floatValue2 >= 6.0f || floatValue3 >= 4.0f) {
            instance.setChangefont(new HTCChange());
            instance.setLenovoLenovo(false);
            instance.setIsnexus(false);
            instance.setOPPO(false);
        }
    }

    /* renamed from: n */
    private static int m973n() {
        float floatValue;
        float floatValue2;
        float floatValue3;
        int i = 0;
        String str = Build.MANUFACTURER;
        int i2 = VERSION.SDK_INT;
        String str2 = Build.MODEL;
        String str3 = Build.DISPLAY;
        String str4 = Build.BRAND;
        int i3 = (str2.equals("H30-U") && str.contains("huawei")) ? 1 : 0;
        if ((Build.BRAND.equals("Huawei") & new File("/data/skin/fonts").exists()) == 0) {
            i = i3;
        }
        String toLowerCase = str2.trim().toLowerCase();
        i3 = (str == null || !str.trim().contains("samsung") || i2 < 9 || (str2 != null && (toLowerCase.contains("google") || toLowerCase.contains("nexus")))) ? i : 1;
        if ((str3 != null && str3.toLowerCase().contains("miui")) || str4.equals("Xiaomi")) {
            i3 = 1;
        }
        switch (m970d()) {
            case 1:
            case 2:
                i3 = 1;
                break;
        }
        String k = m971k("ro.build.sense.version");
        str = m971k("ro.oppo.theme.version");
        str2 = m971k("ro.theme.version");
        try {
            floatValue = Float.valueOf(k).floatValue();
        } catch (Exception e) {
            e.printStackTrace();
            floatValue = 0.0f;
        }
        try {
            floatValue2 = Float.valueOf(str).floatValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            floatValue2 = 0.0f;
        }
        try {
            floatValue3 = Float.valueOf(str2).floatValue();
        } catch (Exception e22) {
            e22.printStackTrace();
            floatValue3 = 0.0f;
        }
        return (((double) floatValue) >= 6.0d || floatValue2 >= 6.0f || floatValue3 >= 4.0f) ? 1 : i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0099 A:{SYNTHETIC, Splitter: B:56:0x0099} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x009e A:{SYNTHETIC, Splitter: B:59:0x009e} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00a3 A:{SYNTHETIC, Splitter: B:62:0x00a3} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f A:{SYNTHETIC, Splitter: B:36:0x006f} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0074 A:{SYNTHETIC, Splitter: B:39:0x0074} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0079 A:{SYNTHETIC, Splitter: B:42:0x0079} */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0099 A:{SYNTHETIC, Splitter: B:56:0x0099} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x009e A:{SYNTHETIC, Splitter: B:59:0x009e} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00a3 A:{SYNTHETIC, Splitter: B:62:0x00a3} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0099 A:{SYNTHETIC, Splitter: B:56:0x0099} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x009e A:{SYNTHETIC, Splitter: B:59:0x009e} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00a3 A:{SYNTHETIC, Splitter: B:62:0x00a3} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f A:{SYNTHETIC, Splitter: B:36:0x006f} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0074 A:{SYNTHETIC, Splitter: B:39:0x0074} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0079 A:{SYNTHETIC, Splitter: B:42:0x0079} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0099 A:{SYNTHETIC, Splitter: B:56:0x0099} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x009e A:{SYNTHETIC, Splitter: B:59:0x009e} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00a3 A:{SYNTHETIC, Splitter: B:62:0x00a3} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006f A:{SYNTHETIC, Splitter: B:36:0x006f} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0074 A:{SYNTHETIC, Splitter: B:39:0x0074} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0079 A:{SYNTHETIC, Splitter: B:42:0x0079} */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0099 A:{SYNTHETIC, Splitter: B:56:0x0099} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x009e A:{SYNTHETIC, Splitter: B:59:0x009e} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00a3 A:{SYNTHETIC, Splitter: B:62:0x00a3} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00a8  */
    /* renamed from: o */
    public static boolean m974o() {
        /*
        r1 = 0;
        r3 = 0;
        r0 = 1;
        r2 = f1176Y;
        if (r2 != 0) goto L_0x000b;
    L_0x0007:
        r2 = "su";
        f1176Y = r2;
    L_0x000b:
        r2 = java.lang.Runtime.getRuntime();	 Catch:{ Exception -> 0x0066, all -> 0x0093 }
        r4 = f1176Y;	 Catch:{ Exception -> 0x0066, all -> 0x0093 }
        r5 = r2.exec(r4);	 Catch:{ Exception -> 0x0066, all -> 0x0093 }
        r6 = new java.io.DataOutputStream;	 Catch:{ Exception -> 0x00eb, all -> 0x00d9 }
        r2 = r5.getOutputStream();	 Catch:{ Exception -> 0x00eb, all -> 0x00d9 }
        r6.<init>(r2);	 Catch:{ Exception -> 0x00eb, all -> 0x00d9 }
        r2 = "exit\n";
        r6.writeBytes(r2);	 Catch:{ Exception -> 0x00f1, all -> 0x00dd }
        r6.flush();	 Catch:{ Exception -> 0x00f1, all -> 0x00dd }
        r7 = r5.waitFor();	 Catch:{ Exception -> 0x00f1, all -> 0x00dd }
        r4 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x00f1, all -> 0x00dd }
        r2 = r5.getErrorStream();	 Catch:{ Exception -> 0x00f1, all -> 0x00dd }
        r4.<init>(r2);	 Catch:{ Exception -> 0x00f1, all -> 0x00dd }
        r2 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x00f7, all -> 0x00e0 }
        r2.<init>(r4);	 Catch:{ Exception -> 0x00f7, all -> 0x00e0 }
        if (r7 != 0) goto L_0x0048;
    L_0x003a:
        r3 = r2.readLine();	 Catch:{ Exception -> 0x00fe, all -> 0x00e2 }
        if (r3 == 0) goto L_0x00bb;
    L_0x0040:
        r7 = "";
        r3 = r7.equals(r3);	 Catch:{ Exception -> 0x00fe, all -> 0x00e2 }
        if (r3 != 0) goto L_0x00bb;
    L_0x0048:
        r6.close();	 Catch:{ IOException -> 0x0057 }
    L_0x004b:
        r4.close();	 Catch:{ IOException -> 0x005c }
    L_0x004e:
        r2.close();	 Catch:{ IOException -> 0x0061 }
    L_0x0051:
        if (r5 == 0) goto L_0x0056;
    L_0x0053:
        r5.destroy();
    L_0x0056:
        return r1;
    L_0x0057:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x004b;
    L_0x005c:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x004e;
    L_0x0061:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0051;
    L_0x0066:
        r0 = move-exception;
        r2 = r3;
        r4 = r3;
        r5 = r3;
    L_0x006a:
        r0.printStackTrace();	 Catch:{ all -> 0x00e5 }
        if (r5 == 0) goto L_0x0072;
    L_0x006f:
        r5.close();	 Catch:{ IOException -> 0x0084 }
    L_0x0072:
        if (r3 == 0) goto L_0x0077;
    L_0x0074:
        r3.close();	 Catch:{ IOException -> 0x0089 }
    L_0x0077:
        if (r2 == 0) goto L_0x007c;
    L_0x0079:
        r2.close();	 Catch:{ IOException -> 0x008e }
    L_0x007c:
        if (r4 == 0) goto L_0x0104;
    L_0x007e:
        r4.destroy();
        r0 = r1;
    L_0x0082:
        r1 = r0;
        goto L_0x0056;
    L_0x0084:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0072;
    L_0x0089:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0077;
    L_0x008e:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x007c;
    L_0x0093:
        r0 = move-exception;
        r4 = r3;
        r5 = r3;
        r6 = r3;
    L_0x0097:
        if (r6 == 0) goto L_0x009c;
    L_0x0099:
        r6.close();	 Catch:{ IOException -> 0x00ac }
    L_0x009c:
        if (r4 == 0) goto L_0x00a1;
    L_0x009e:
        r4.close();	 Catch:{ IOException -> 0x00b1 }
    L_0x00a1:
        if (r3 == 0) goto L_0x00a6;
    L_0x00a3:
        r3.close();	 Catch:{ IOException -> 0x00b6 }
    L_0x00a6:
        if (r5 == 0) goto L_0x00ab;
    L_0x00a8:
        r5.destroy();
    L_0x00ab:
        throw r0;
    L_0x00ac:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x009c;
    L_0x00b1:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00a1;
    L_0x00b6:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00a6;
    L_0x00bb:
        r6.close();	 Catch:{ IOException -> 0x00ca }
    L_0x00be:
        r4.close();	 Catch:{ IOException -> 0x00cf }
    L_0x00c1:
        r2.close();	 Catch:{ IOException -> 0x00d4 }
    L_0x00c4:
        if (r5 == 0) goto L_0x0082;
    L_0x00c6:
        r5.destroy();
        goto L_0x0082;
    L_0x00ca:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00be;
    L_0x00cf:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00c1;
    L_0x00d4:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00c4;
    L_0x00d9:
        r0 = move-exception;
        r4 = r3;
        r6 = r3;
        goto L_0x0097;
    L_0x00dd:
        r0 = move-exception;
        r4 = r3;
        goto L_0x0097;
    L_0x00e0:
        r0 = move-exception;
        goto L_0x0097;
    L_0x00e2:
        r0 = move-exception;
        r3 = r2;
        goto L_0x0097;
    L_0x00e5:
        r0 = move-exception;
        r6 = r5;
        r5 = r4;
        r4 = r3;
        r3 = r2;
        goto L_0x0097;
    L_0x00eb:
        r0 = move-exception;
        r2 = r3;
        r4 = r5;
        r5 = r3;
        goto L_0x006a;
    L_0x00f1:
        r0 = move-exception;
        r2 = r3;
        r4 = r5;
        r5 = r6;
        goto L_0x006a;
    L_0x00f7:
        r0 = move-exception;
        r2 = r3;
        r3 = r4;
        r4 = r5;
        r5 = r6;
        goto L_0x006a;
    L_0x00fe:
        r0 = move-exception;
        r3 = r4;
        r4 = r5;
        r5 = r6;
        goto L_0x006a;
    L_0x0104:
        r0 = r1;
        goto L_0x0082;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.changefontmanager.sdk.utils.RootUtils.o():boolean");
    }

    /* renamed from: p */
    public static void m975p() {
        CmdUtils.m960h("reboot \n");
    }
}
