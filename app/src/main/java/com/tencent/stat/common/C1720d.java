package com.tencent.stat.common;

import android.content.Context;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.tencent.stat.common.d */
public class C1720d {
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d2 A:{SYNTHETIC, Splitter: B:51:0x00d2} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c8 A:{SYNTHETIC, Splitter: B:46:0x00c8} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cd A:{Catch:{ IOException -> 0x00d6 }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d2 A:{SYNTHETIC, Splitter: B:51:0x00d2} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c8 A:{SYNTHETIC, Splitter: B:46:0x00c8} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cd A:{Catch:{ IOException -> 0x00d6 }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d2 A:{SYNTHETIC, Splitter: B:51:0x00d2} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b5 A:{SYNTHETIC, Splitter: B:37:0x00b5} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ab A:{SYNTHETIC, Splitter: B:32:0x00ab} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b0 A:{Catch:{ IOException -> 0x00be }} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b5 A:{SYNTHETIC, Splitter: B:37:0x00b5} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c8 A:{SYNTHETIC, Splitter: B:46:0x00c8} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cd A:{Catch:{ IOException -> 0x00d6 }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d2 A:{SYNTHETIC, Splitter: B:51:0x00d2} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ab A:{SYNTHETIC, Splitter: B:32:0x00ab} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b0 A:{Catch:{ IOException -> 0x00be }} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b5 A:{SYNTHETIC, Splitter: B:37:0x00b5} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c8 A:{SYNTHETIC, Splitter: B:46:0x00c8} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cd A:{Catch:{ IOException -> 0x00d6 }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d2 A:{SYNTHETIC, Splitter: B:51:0x00d2} */
    /* renamed from: a */
    private static java.lang.String m4736a() {
        /*
        r2 = 0;
        r6 = new java.lang.StringBuffer;
        r6.<init>();
        r5 = 0;
        r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00a3, all -> 0x00c3 }
        r0.<init>();	 Catch:{ Exception -> 0x00a3, all -> 0x00c3 }
        r1 = "logcat";
        r0.add(r1);	 Catch:{ Exception -> 0x00a3, all -> 0x00c3 }
        r1 = "-d";
        r0.add(r1);	 Catch:{ Exception -> 0x00a3, all -> 0x00c3 }
        r1 = "-v";
        r0.add(r1);	 Catch:{ Exception -> 0x00a3, all -> 0x00c3 }
        r1 = "time";
        r0.add(r1);	 Catch:{ Exception -> 0x00a3, all -> 0x00c3 }
        r7 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00a3, all -> 0x00c3 }
        r7.<init>();	 Catch:{ Exception -> 0x00a3, all -> 0x00c3 }
        r1 = "logcat";
        r7.add(r1);	 Catch:{ Exception -> 0x00a3, all -> 0x00c3 }
        r1 = "-c";
        r7.add(r1);	 Catch:{ Exception -> 0x00a3, all -> 0x00c3 }
        r8 = java.lang.Runtime.getRuntime();	 Catch:{ Exception -> 0x00a3, all -> 0x00c3 }
        r1 = r0.size();	 Catch:{ Exception -> 0x00a3, all -> 0x00c3 }
        r1 = new java.lang.String[r1];	 Catch:{ Exception -> 0x00a3, all -> 0x00c3 }
        r0 = r0.toArray(r1);	 Catch:{ Exception -> 0x00a3, all -> 0x00c3 }
        r0 = (java.lang.String[]) r0;	 Catch:{ Exception -> 0x00a3, all -> 0x00c3 }
        r4 = r8.exec(r0);	 Catch:{ Exception -> 0x00a3, all -> 0x00c3 }
        r3 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x00ed, all -> 0x00e0 }
        r0 = r4.getInputStream();	 Catch:{ Exception -> 0x00ed, all -> 0x00e0 }
        r3.<init>(r0);	 Catch:{ Exception -> 0x00ed, all -> 0x00e0 }
        r1 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x00f1, all -> 0x00e3 }
        r1.<init>(r3);	 Catch:{ Exception -> 0x00f1, all -> 0x00e3 }
        r0 = r5;
    L_0x0052:
        r2 = r1.readLine();	 Catch:{ Exception -> 0x00f6, all -> 0x00e5 }
        if (r2 == 0) goto L_0x0074;
    L_0x0058:
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00f6, all -> 0x00e5 }
        r5.<init>();	 Catch:{ Exception -> 0x00f6, all -> 0x00e5 }
        r2 = r5.append(r2);	 Catch:{ Exception -> 0x00f6, all -> 0x00e5 }
        r5 = "\r\n";
        r2 = r2.append(r5);	 Catch:{ Exception -> 0x00f6, all -> 0x00e5 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00f6, all -> 0x00e5 }
        r6.append(r2);	 Catch:{ Exception -> 0x00f6, all -> 0x00e5 }
        r2 = r0 + 1;
        r5 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r0 < r5) goto L_0x00fa;
    L_0x0074:
        r0 = r7.size();	 Catch:{ Exception -> 0x00f6, all -> 0x00e5 }
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x00f6, all -> 0x00e5 }
        r0 = r7.toArray(r0);	 Catch:{ Exception -> 0x00f6, all -> 0x00e5 }
        r0 = (java.lang.String[]) r0;	 Catch:{ Exception -> 0x00f6, all -> 0x00e5 }
        r2 = r8.exec(r0);	 Catch:{ Exception -> 0x00f6, all -> 0x00e5 }
        r3.close();	 Catch:{ IOException -> 0x0099 }
        r1.close();	 Catch:{ IOException -> 0x0099 }
    L_0x008a:
        if (r4 == 0) goto L_0x008f;
    L_0x008c:
        r4.destroy();	 Catch:{ Throwable -> 0x009e }
    L_0x008f:
        if (r2 == 0) goto L_0x0094;
    L_0x0091:
        r2.destroy();	 Catch:{ Throwable -> 0x009e }
    L_0x0094:
        r0 = r6.toString();
        return r0;
    L_0x0099:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x008a;
    L_0x009e:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0094;
    L_0x00a3:
        r0 = move-exception;
        r1 = r2;
        r3 = r2;
    L_0x00a6:
        r0.printStackTrace();	 Catch:{ all -> 0x00e8 }
        if (r2 == 0) goto L_0x00ae;
    L_0x00ab:
        r2.close();	 Catch:{ IOException -> 0x00be }
    L_0x00ae:
        if (r1 == 0) goto L_0x00b3;
    L_0x00b0:
        r1.close();	 Catch:{ IOException -> 0x00be }
    L_0x00b3:
        if (r3 == 0) goto L_0x0094;
    L_0x00b5:
        r3.destroy();	 Catch:{ Throwable -> 0x00b9 }
        goto L_0x0094;
    L_0x00b9:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0094;
    L_0x00be:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x00b3;
    L_0x00c3:
        r0 = move-exception;
        r3 = r2;
        r4 = r2;
    L_0x00c6:
        if (r3 == 0) goto L_0x00cb;
    L_0x00c8:
        r3.close();	 Catch:{ IOException -> 0x00d6 }
    L_0x00cb:
        if (r2 == 0) goto L_0x00d0;
    L_0x00cd:
        r2.close();	 Catch:{ IOException -> 0x00d6 }
    L_0x00d0:
        if (r4 == 0) goto L_0x00d5;
    L_0x00d2:
        r4.destroy();	 Catch:{ Throwable -> 0x00db }
    L_0x00d5:
        throw r0;
    L_0x00d6:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00d0;
    L_0x00db:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00d5;
    L_0x00e0:
        r0 = move-exception;
        r3 = r2;
        goto L_0x00c6;
    L_0x00e3:
        r0 = move-exception;
        goto L_0x00c6;
    L_0x00e5:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00c6;
    L_0x00e8:
        r0 = move-exception;
        r4 = r3;
        r3 = r2;
        r2 = r1;
        goto L_0x00c6;
    L_0x00ed:
        r0 = move-exception;
        r1 = r2;
        r3 = r4;
        goto L_0x00a6;
    L_0x00f1:
        r0 = move-exception;
        r1 = r2;
        r2 = r3;
        r3 = r4;
        goto L_0x00a6;
    L_0x00f6:
        r0 = move-exception;
        r2 = r3;
        r3 = r4;
        goto L_0x00a6;
    L_0x00fa:
        r0 = r2;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.common.d.a():java.lang.String");
    }

    /* renamed from: a */
    public static void m4737a(Context context) {
        FileOutputStream fileOutputStream = null;
        try {
            String a = C1720d.m4736a();
            fileOutputStream = context.getApplicationContext().openFileOutput("feedback.log", 1);
            if (fileOutputStream != null) {
                fileOutputStream.write(a.getBytes());
                fileOutputStream.flush();
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        } catch (IOException e32) {
            e32.printStackTrace();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e322) {
                    e322.printStackTrace();
                }
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }
}
