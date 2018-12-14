package com.p070qq.p071e.comm;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import com.p070qq.p071e.comm.constants.Constants.PLUGIN;
import com.p070qq.p071e.comm.constants.CustomPkgConstants;
import com.p070qq.p071e.comm.managers.plugin.C1061PM;
import com.p070qq.p071e.comm.managers.setting.C1066SM;
import com.p070qq.p071e.comm.managers.setting.C1067a;
import com.p070qq.p071e.comm.managers.status.APPStatus;
import com.p070qq.p071e.comm.managers.status.DeviceStatus;
import com.p070qq.p071e.comm.managers.status.SDKStatus;
import com.p070qq.p071e.comm.util.FileUtil;
import com.p070qq.p071e.comm.util.GDTLogger;
import com.p070qq.p071e.comm.util.StringUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map.Entry;
import org.json.JSONObject;

/* renamed from: com.qq.e.comm.a */
public class C1058a {
    /* renamed from: a */
    private String f2760a;
    /* renamed from: b */
    private C1067a f2761b;

    public C1058a(String str, C1067a c1067a) {
        this.f2760a = str;
        this.f2761b = c1067a;
    }

    /* renamed from: a */
    public static JSONObject m3066a(C1061PM c1061pm) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("sdkv", SDKStatus.getSDKVersion());
        jSONObject.putOpt("pv", Integer.valueOf(c1061pm.getPluginVersion()));
        return jSONObject;
    }

    /* renamed from: a */
    public static JSONObject m3067a(C1066SM c1066sm) {
        JSONObject jSONObject = new JSONObject();
        if (c1066sm != null) {
            jSONObject.putOpt("suid", c1066sm.getSuid());
            jSONObject.putOpt("sid", c1066sm.getSid());
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static JSONObject m3068a(APPStatus aPPStatus) {
        JSONObject jSONObject = new JSONObject();
        if (aPPStatus != null) {
            jSONObject.putOpt("an", aPPStatus.getAPPName());
            jSONObject.putOpt("appkey", aPPStatus.getAPPID());
            jSONObject.putOpt("appv", aPPStatus.getAPPVersion());
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static JSONObject m3069a(DeviceStatus deviceStatus) {
        JSONObject jSONObject = new JSONObject();
        if (deviceStatus != null) {
            jSONObject.putOpt("so", deviceStatus.getScreenOrientation());
            jSONObject.putOpt("dn", deviceStatus.getDataNet());
            jSONObject.putOpt("lat", deviceStatus.getLat());
            jSONObject.putOpt("lng", deviceStatus.getLng());
            for (Entry entry : deviceStatus.getLacAndCeilId().entrySet()) {
                jSONObject.putOpt((String) entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static boolean m3070a(Context context) {
        try {
            if (C1058a.m3074b(context)) {
                if (C1058a.m3072a(context, Class.forName(CustomPkgConstants.getADActivityName()))) {
                    if (C1058a.m3075b(context, Class.forName(CustomPkgConstants.getDownLoadServiceName()))) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            GDTLogger.m3132e("Exception While check SDK Env", th);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m3071a(Context context, File file, File file2) {
        AssetManager assets = context.getAssets();
        try {
            if (Arrays.binarySearch(assets.list(CustomPkgConstants.getAssetPluginDir()), CustomPkgConstants.getAssetPluginName()) < 0) {
                return false;
            }
            String str = CustomPkgConstants.getAssetPluginDir() + File.separator + CustomPkgConstants.getAssetPluginName();
            StringUtil.writeTo("535#####" + PLUGIN.ASSET_PLUGIN_SIG, file2);
            if (StringUtil.isEmpty(CustomPkgConstants.getAssetPluginXorKey())) {
                return FileUtil.copyTo(assets.open(str), file);
            }
            InputStream open = assets.open(str);
            OutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bytes = CustomPkgConstants.getAssetPluginXorKey().getBytes();
            byte[] bArr = new byte[1024];
            int length = bytes.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    int i3 = 0;
                    while (i3 < read) {
                        int i4 = i + 1;
                        if (i >= 64) {
                            i = i2 + 1;
                            bArr[i3] = (byte) (bytes[i2 % length] ^ bArr[i3]);
                        } else {
                            i = i2;
                        }
                        i3++;
                        i2 = i;
                        i = i4;
                    }
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    open.close();
                    fileOutputStream.close();
                    return true;
                }
            }
        } catch (Throwable th) {
            GDTLogger.report("Exception while init default plugin manager", th);
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m3072a(Context context, Class<?>... clsArr) {
        int i = 0;
        while (i <= 0) {
            try {
                Intent intent = new Intent();
                intent.setClass(context, clsArr[0]);
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    GDTLogger.m3131e(String.format("Activity[%s] is required in AndroidManifest.xml", new Object[]{clsArr[0].getName()}));
                    return false;
                }
                i++;
            } catch (Throwable th) {
                GDTLogger.m3132e("Exception while checking required activities", th);
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0040 A:{SYNTHETIC, Splitter: B:27:0x0040} */
    /* renamed from: a */
    public static byte[] m3073a(byte[] r4) {
        /*
        r0 = 0;
        if (r4 == 0) goto L_0x0006;
    L_0x0003:
        r1 = r4.length;
        if (r1 != 0) goto L_0x0008;
    L_0x0006:
        r0 = r4;
    L_0x0007:
        return r0;
    L_0x0008:
        r3 = new java.io.ByteArrayOutputStream;
        r3.<init>();
        r2 = new java.util.zip.GZIPOutputStream;	 Catch:{ Exception -> 0x0028, all -> 0x003b }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0028, all -> 0x003b }
        r2.write(r4);	 Catch:{ Exception -> 0x004e }
        r2.finish();	 Catch:{ Exception -> 0x004e }
        r0 = r3.toByteArray();	 Catch:{ Exception -> 0x004e }
        r2.close();	 Catch:{ Exception -> 0x0023 }
        r3.close();	 Catch:{ Exception -> 0x0023 }
        goto L_0x0007;
    L_0x0023:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0007;
    L_0x0028:
        r1 = move-exception;
        r2 = r0;
    L_0x002a:
        r1.printStackTrace();	 Catch:{ all -> 0x004c }
        if (r2 == 0) goto L_0x0032;
    L_0x002f:
        r2.close();	 Catch:{ Exception -> 0x0036 }
    L_0x0032:
        r3.close();	 Catch:{ Exception -> 0x0036 }
        goto L_0x0007;
    L_0x0036:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0007;
    L_0x003b:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x003e:
        if (r2 == 0) goto L_0x0043;
    L_0x0040:
        r2.close();	 Catch:{ Exception -> 0x0047 }
    L_0x0043:
        r3.close();	 Catch:{ Exception -> 0x0047 }
    L_0x0046:
        throw r0;
    L_0x0047:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0046;
    L_0x004c:
        r0 = move-exception;
        goto L_0x003e;
    L_0x004e:
        r1 = move-exception;
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.a.a(byte[]):byte[]");
    }

    /* renamed from: b */
    private static boolean m3074b(Context context) {
        String[] strArr = new String[]{"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.READ_PHONE_STATE", "android.permission.WRITE_EXTERNAL_STORAGE"};
        int i = 0;
        while (i < 5) {
            try {
                if (context.checkCallingOrSelfPermission(strArr[i]) == -1) {
                    GDTLogger.m3131e(String.format("Permission %s is required in AndroidManifest.xml", new Object[]{strArr[i]}));
                    return false;
                }
                i++;
            } catch (Throwable th) {
                GDTLogger.m3132e("Check required Permissions error", th);
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private static boolean m3075b(Context context, Class<?>... clsArr) {
        int i = 0;
        while (i <= 0) {
            try {
                Class cls = clsArr[0];
                Intent intent = new Intent();
                intent.setClass(context, cls);
                if (context.getPackageManager().resolveService(intent, 65536) == null) {
                    GDTLogger.m3131e(String.format("Service[%s] is required in AndroidManifest.xml", new Object[]{cls.getName()}));
                    return false;
                }
                i++;
            } catch (Throwable th) {
                GDTLogger.m3132e("Exception while checking required services", th);
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0057 A:{SYNTHETIC, Splitter: B:31:0x0057} */
    /* renamed from: b */
    public static byte[] m3076b(byte[] r7) {
        /*
        r0 = 0;
        if (r7 == 0) goto L_0x0006;
    L_0x0003:
        r1 = r7.length;
        if (r1 != 0) goto L_0x0008;
    L_0x0006:
        r0 = r7;
    L_0x0007:
        return r0;
    L_0x0008:
        r3 = new java.io.ByteArrayInputStream;
        r3.<init>(r7);
        r4 = new java.io.ByteArrayOutputStream;
        r4.<init>();
        r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r1 = new byte[r1];
        r2 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x0068, all -> 0x0052 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0068, all -> 0x0052 }
    L_0x001b:
        r5 = r2.read(r1);	 Catch:{ Exception -> 0x0027 }
        r6 = -1;
        if (r5 == r6) goto L_0x003c;
    L_0x0022:
        r6 = 0;
        r4.write(r1, r6, r5);	 Catch:{ Exception -> 0x0027 }
        goto L_0x001b;
    L_0x0027:
        r1 = move-exception;
    L_0x0028:
        r1.printStackTrace();	 Catch:{ all -> 0x0066 }
        if (r2 == 0) goto L_0x0030;
    L_0x002d:
        r2.close();	 Catch:{ Exception -> 0x0037 }
    L_0x0030:
        r3.close();	 Catch:{ Exception -> 0x0037 }
        r4.close();	 Catch:{ Exception -> 0x0037 }
        goto L_0x0007;
    L_0x0037:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0007;
    L_0x003c:
        r4.flush();	 Catch:{ Exception -> 0x0027 }
        r0 = r4.toByteArray();	 Catch:{ Exception -> 0x0027 }
        r2.close();	 Catch:{ Exception -> 0x004d }
        r3.close();	 Catch:{ Exception -> 0x004d }
        r4.close();	 Catch:{ Exception -> 0x004d }
        goto L_0x0007;
    L_0x004d:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0007;
    L_0x0052:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x0055:
        if (r2 == 0) goto L_0x005a;
    L_0x0057:
        r2.close();	 Catch:{ Exception -> 0x0061 }
    L_0x005a:
        r3.close();	 Catch:{ Exception -> 0x0061 }
        r4.close();	 Catch:{ Exception -> 0x0061 }
    L_0x0060:
        throw r0;
    L_0x0061:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0060;
    L_0x0066:
        r0 = move-exception;
        goto L_0x0055;
    L_0x0068:
        r1 = move-exception;
        r2 = r0;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.a.b(byte[]):byte[]");
    }

    /* renamed from: a */
    public String mo6446a() {
        return this.f2760a;
    }

    /* renamed from: b */
    public C1067a mo6447b() {
        return this.f2761b;
    }
}
