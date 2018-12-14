package com.kingroot.sdk;

import android.content.Context;
import android.content.p013pm.PackageInfo;
import android.text.TextUtils;
import com.kingroot.sdk.util.C0885e;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* renamed from: com.kingroot.sdk.ay */
public class C0641ay {
    /* renamed from: a */
    private static JSONObject m1481a(String str, Context context) {
        Closeable fileInputStream;
        Throwable th;
        Closeable closeable = null;
        C0633at.m1464h("buildJSONObj kuConfigPath = " + str);
        try {
            fileInputStream = new FileInputStream(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fileInputStream = null;
        }
        Closeable bufferedReader;
        try {
            Closeable inputStreamReader;
            JSONObject jSONObject;
            StringBuilder stringBuilder = new StringBuilder();
            if (fileInputStream != null) {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                stringBuilder.append(readLine);
                            }
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        } catch (Throwable th2) {
                            th = th2;
                            closeable = bufferedReader;
                            bufferedReader = inputStreamReader;
                        }
                        try {
                            break;
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = inputStreamReader;
                    C0885e.m2419a(closeable);
                    C0885e.m2419a(bufferedReader);
                    C0885e.m2419a(fileInputStream);
                    throw th;
                }
            }
            bufferedReader = null;
            inputStreamReader = null;
            try {
                jSONObject = (JSONObject) new JSONTokener(stringBuilder.toString()).nextValue();
            } catch (JSONException e3) {
                e3.printStackTrace();
                jSONObject = null;
            }
            C0885e.m2419a(bufferedReader);
            C0885e.m2419a(inputStreamReader);
            C0885e.m2419a(fileInputStream);
            return jSONObject;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            C0885e.m2419a(closeable);
            C0885e.m2419a(bufferedReader);
            C0885e.m2419a(fileInputStream);
            throw th;
        }
    }

    /* renamed from: b */
    public static int m1482b(String str, Context context) {
        int i = 0;
        JSONObject a = C0641ay.m1481a(str, context);
        if (a == null) {
            return i;
        }
        try {
            return a.getInt("buildno");
        } catch (JSONException e) {
            e.printStackTrace();
            return i;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00bb  */
    /* renamed from: b */
    public static boolean m1483b(int r8, android.content.Context r9) {
        /*
        r3 = 1;
        r1 = 0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "krsdk";
        r2 = r9.getDir(r2, r1);
        r2 = r2.getPath();
        r0 = r0.append(r2);
        r2 = java.io.File.separatorChar;
        r0 = r0.append(r2);
        r2 = "ku-config";
        r0 = r0.append(r2);
        r5 = r0.toString();
        r6 = com.kingroot.sdk.C0641ay.m1481a(r5, r9);
        if (r6 == 0) goto L_0x00fb;
    L_0x002b:
        r0 = "buildno";
        r0 = r6.getInt(r0);	 Catch:{ JSONException -> 0x00d2 }
    L_0x0031:
        r2 = new java.lang.StringBuilder;
        r4 = "old buildno = ";
        r2.<init>(r4);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.kingroot.sdk.C0633at.m1464h(r2);
        r2 = "buildno";
        r6.put(r2, r8);	 Catch:{ JSONException -> 0x00d9 }
        r2 = r3;
    L_0x0049:
        r4 = "buildno";
        r0 = r6.getInt(r4);	 Catch:{ JSONException -> 0x00e0 }
    L_0x004f:
        r4 = new java.lang.StringBuilder;
        r7 = "new buildno = ";
        r4.<init>(r7);
        r0 = r4.append(r0);
        r4 = ", json content = ";
        r0 = r0.append(r4);
        r4 = r6.toString();
        r0 = r0.append(r4);
        r0 = r0.toString();
        com.kingroot.sdk.C0633at.m1464h(r0);
        r0 = new java.io.File;
        r0.<init>(r5);
        r4 = r0.exists();
        if (r4 == 0) goto L_0x007d;
    L_0x007a:
        r0.delete();
    L_0x007d:
        r0 = new java.lang.StringBuilder;
        r4 = "updateKuBuildNo kuConfigPath = ";
        r0.<init>(r4);
        r0 = r0.append(r5);
        r0 = r0.toString();
        com.kingroot.sdk.C0633at.m1464h(r0);
        r4 = 0;
        r0 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x00e6 }
        r0.<init>(r5);	 Catch:{ FileNotFoundException -> 0x00e6 }
        r4 = r0;
    L_0x0096:
        if (r4 == 0) goto L_0x00f9;
    L_0x0098:
        r0 = r6.toString();
        r0 = r0.getBytes();
        r4.write(r0);	 Catch:{ IOException -> 0x00eb }
        r0 = r4.getChannel();	 Catch:{ IOException -> 0x00eb }
        r5 = 1;
        r0.force(r5);	 Catch:{ IOException -> 0x00eb }
        r4.flush();	 Catch:{ IOException -> 0x00eb }
        com.kingroot.sdk.util.C0885e.m2419a(r4);
        r0 = r2;
    L_0x00b2:
        r2 = new java.lang.StringBuilder;
        r4 = "jsonObj == null : ";
        r2.<init>(r4);
        if (r6 != 0) goto L_0x00bc;
    L_0x00bb:
        r1 = r3;
    L_0x00bc:
        r1 = r2.append(r1);
        r2 = ", isBuildNoUpdated = ";
        r1 = r1.append(r2);
        r1 = r1.append(r0);
        r1 = r1.toString();
        com.kingroot.sdk.C0633at.m1464h(r1);
        return r0;
    L_0x00d2:
        r0 = move-exception;
        r0.printStackTrace();
        r0 = r1;
        goto L_0x0031;
    L_0x00d9:
        r2 = move-exception;
        r2.printStackTrace();
        r2 = r1;
        goto L_0x0049;
    L_0x00e0:
        r4 = move-exception;
        r4.printStackTrace();
        goto L_0x004f;
    L_0x00e6:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0096;
    L_0x00eb:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x00f4 }
        com.kingroot.sdk.util.C0885e.m2419a(r4);
        r0 = r2;
        goto L_0x00b2;
    L_0x00f4:
        r0 = move-exception;
        com.kingroot.sdk.util.C0885e.m2419a(r4);
        throw r0;
    L_0x00f9:
        r0 = r2;
        goto L_0x00b2;
    L_0x00fb:
        r0 = r1;
        goto L_0x00b2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.ay.b(int, android.content.Context):boolean");
    }

    /* renamed from: p */
    public static String m1484p(Context context) {
        String str = "";
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(C0741dg.m1804aL().f1806em.workingDir.getPath() + File.separatorChar + "superuser.apk", 1);
        if (packageArchiveInfo != null) {
            str = packageArchiveInfo.versionName;
        }
        C0633at.m1464h("getKinguserVersionCode versionName = " + str);
        return str;
    }

    /* renamed from: v */
    public static C0783ek m1485v(String str) {
        int i = 1;
        C0783ek c0783ek = new C0783ek();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.trim().split("[\\.]");
            try {
                if (split.length > 0) {
                    i = Integer.parseInt(split[0]);
                }
                c0783ek.f1918ab = i;
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                c0783ek.f1919ac = split.length >= 2 ? Integer.parseInt(split[1]) : 0;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                c0783ek.f1920ad = split.length >= 3 ? Integer.parseInt(split[2]) : 0;
            } catch (Exception e22) {
                e22.printStackTrace();
            }
        }
        return c0783ek;
    }
}
