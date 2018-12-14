package com.shuame.rootgenius.common.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.shuame.mobile.utils.NativeUtils;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Type;
import java.io.File;

/* renamed from: com.shuame.rootgenius.common.util.j */
public final class C1397j {
    /* renamed from: a */
    private static final String f3877a = C1397j.class.getSimpleName();

    /* renamed from: a */
    public static File m3896a(Context context) {
        File file = Environment.getExternalStorageState().equals("mounted") ? new File(Environment.getExternalStorageDirectory() + "/Android/data/" + context.getPackageName() + "/cache/image") : new File(context.getCacheDir() + "/image");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: a */
    public static String m3897a(QQDownloadFile qQDownloadFile) {
        return C1397j.m3898a(C1405o.m3908a(qQDownloadFile.f3724e) + ".apk", qQDownloadFile.f3727h, Type.APK);
    }

    /* renamed from: a */
    private static String m3898a(String str, long j, Type type) {
        new StringBuilder("fileSize:").append((j / 1024) / 1024).append("M");
        String str2 = "/Download";
        String a = C1397j.m3899a(str, j, C1411s.m3928b(false), str2, type);
        if (a != null) {
            return a;
        }
        a = C1397j.m3899a(str, j, C1411s.m3923a(false), str2, type);
        if (a != null) {
            return a;
        }
        if ("mounted".equals(Environment.getExternalStorageState())) {
            a = C1397j.m3899a(str, j, Environment.getExternalStorageDirectory().getAbsolutePath(), str2, type);
            if (a != null) {
                return a;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static String m3899a(String str, long j, String str2, String str3, Type type) {
        if (TextUtils.isEmpty(str2) || C1411s.m3926b(str2) < j) {
            return null;
        }
        switch (C1398k.f3878a[type.ordinal()]) {
            case 1:
                return str2 + str3 + "/app/" + str;
            case 2:
                String str4 = ".zip";
                if (str != null && str.endsWith(".zip")) {
                    str4 = "";
                }
                return str2 + str3 + "/zip/" + str + str4;
            default:
                return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039 A:{SYNTHETIC, Splitter: B:15:0x0039} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e A:{SYNTHETIC, Splitter: B:18:0x003e} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0053 A:{SYNTHETIC, Splitter: B:32:0x0053} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0058 A:{SYNTHETIC, Splitter: B:35:0x0058} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039 A:{SYNTHETIC, Splitter: B:15:0x0039} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e A:{SYNTHETIC, Splitter: B:18:0x003e} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0053 A:{SYNTHETIC, Splitter: B:32:0x0053} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0058 A:{SYNTHETIC, Splitter: B:35:0x0058} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0062 A:{SYNTHETIC, Splitter: B:41:0x0062} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0067 A:{SYNTHETIC, Splitter: B:44:0x0067} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0062 A:{SYNTHETIC, Splitter: B:41:0x0062} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0067 A:{SYNTHETIC, Splitter: B:44:0x0067} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0062 A:{SYNTHETIC, Splitter: B:41:0x0062} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0067 A:{SYNTHETIC, Splitter: B:44:0x0067} */
    /* renamed from: a */
    public static boolean m3900a(int r7, java.lang.String r8) {
        /*
        r3 = 0;
        r0 = 0;
        r1 = com.shuame.rootgenius.common.C1325c.m3724a();
        r5 = new java.io.File;
        r5.<init>(r8);
        r2 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r6 = new byte[r2];
        r4 = new java.io.BufferedInputStream;	 Catch:{ FileNotFoundException -> 0x0085, IOException -> 0x004c, all -> 0x005e }
        r1 = r1.getResources();	 Catch:{ FileNotFoundException -> 0x0085, IOException -> 0x004c, all -> 0x005e }
        r1 = r1.openRawResource(r7);	 Catch:{ FileNotFoundException -> 0x0085, IOException -> 0x004c, all -> 0x005e }
        r4.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0085, IOException -> 0x004c, all -> 0x005e }
        r2 = new java.io.BufferedOutputStream;	 Catch:{ FileNotFoundException -> 0x0088, IOException -> 0x0080 }
        r1 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0088, IOException -> 0x0080 }
        r1.<init>(r5);	 Catch:{ FileNotFoundException -> 0x0088, IOException -> 0x0080 }
        r2.<init>(r1);	 Catch:{ FileNotFoundException -> 0x0088, IOException -> 0x0080 }
    L_0x0026:
        r1 = r4.read(r6);	 Catch:{ FileNotFoundException -> 0x0032, IOException -> 0x0082, all -> 0x0079 }
        r3 = -1;
        if (r1 == r3) goto L_0x0042;
    L_0x002d:
        r3 = 0;
        r2.write(r6, r3, r1);	 Catch:{ FileNotFoundException -> 0x0032, IOException -> 0x0082, all -> 0x0079 }
        goto L_0x0026;
    L_0x0032:
        r1 = move-exception;
        r3 = r4;
    L_0x0034:
        r1.printStackTrace();	 Catch:{ all -> 0x007c }
        if (r3 == 0) goto L_0x003c;
    L_0x0039:
        r3.close();	 Catch:{ IOException -> 0x006d }
    L_0x003c:
        if (r2 == 0) goto L_0x0041;
    L_0x003e:
        r2.close();	 Catch:{ IOException -> 0x006f }
    L_0x0041:
        return r0;
    L_0x0042:
        r0 = 1;
        r4.close();	 Catch:{ IOException -> 0x006b }
    L_0x0046:
        r2.close();	 Catch:{ IOException -> 0x004a }
        goto L_0x0041;
    L_0x004a:
        r1 = move-exception;
        goto L_0x0041;
    L_0x004c:
        r1 = move-exception;
        r4 = r3;
    L_0x004e:
        r1.printStackTrace();	 Catch:{ all -> 0x0077 }
        if (r4 == 0) goto L_0x0056;
    L_0x0053:
        r4.close();	 Catch:{ IOException -> 0x0071 }
    L_0x0056:
        if (r3 == 0) goto L_0x0041;
    L_0x0058:
        r3.close();	 Catch:{ IOException -> 0x005c }
        goto L_0x0041;
    L_0x005c:
        r1 = move-exception;
        goto L_0x0041;
    L_0x005e:
        r0 = move-exception;
        r4 = r3;
    L_0x0060:
        if (r4 == 0) goto L_0x0065;
    L_0x0062:
        r4.close();	 Catch:{ IOException -> 0x0073 }
    L_0x0065:
        if (r3 == 0) goto L_0x006a;
    L_0x0067:
        r3.close();	 Catch:{ IOException -> 0x0075 }
    L_0x006a:
        throw r0;
    L_0x006b:
        r1 = move-exception;
        goto L_0x0046;
    L_0x006d:
        r1 = move-exception;
        goto L_0x003c;
    L_0x006f:
        r1 = move-exception;
        goto L_0x0041;
    L_0x0071:
        r1 = move-exception;
        goto L_0x0056;
    L_0x0073:
        r1 = move-exception;
        goto L_0x0065;
    L_0x0075:
        r1 = move-exception;
        goto L_0x006a;
    L_0x0077:
        r0 = move-exception;
        goto L_0x0060;
    L_0x0079:
        r0 = move-exception;
        r3 = r2;
        goto L_0x0060;
    L_0x007c:
        r0 = move-exception;
        r4 = r3;
        r3 = r2;
        goto L_0x0060;
    L_0x0080:
        r1 = move-exception;
        goto L_0x004e;
    L_0x0082:
        r1 = move-exception;
        r3 = r2;
        goto L_0x004e;
    L_0x0085:
        r1 = move-exception;
        r2 = r3;
        goto L_0x0034;
    L_0x0088:
        r1 = move-exception;
        r2 = r3;
        r3 = r4;
        goto L_0x0034;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.common.util.j.a(int, java.lang.String):boolean");
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static boolean m3901a(String str) {
        int ensureFileExecute = NativeUtils.ensureFileExecute(str);
        if (ensureFileExecute != 0) {
            File file = new File(str);
            if (file.exists()) {
                boolean readable = file.setReadable(true, false);
                boolean executable = file.setExecutable(true, false);
                new StringBuilder("setReadable:").append(readable).append(";setExecutable:").append(executable);
                return readable && executable;
            }
        }
        return ensureFileExecute == 0;
    }

    /* renamed from: b */
    public static String m3902b(QQDownloadFile qQDownloadFile) {
        return C1397j.m3898a(new File(qQDownloadFile.f3724e).getName(), qQDownloadFile.f3727h, Type.ROM);
    }
}
