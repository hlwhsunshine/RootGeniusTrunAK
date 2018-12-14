package com.changefontmanager.sdk.utils;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CmdUtils {
    /* renamed from: D */
    public static String f1155D = "mount -o remount,rw /system";
    /* renamed from: E */
    public static String f1156E = "mount -o remount rw /system";
    /* renamed from: F */
    public static String f1157F = "mount -o remount /dev/block/mtdblock0 /system";
    /* renamed from: G */
    public static String f1158G = "";
    /* renamed from: H */
    private static ProcessBuilder f1159H = null;
    /* renamed from: I */
    private static Process f1160I = null;
    /* renamed from: J */
    private static DataOutputStream f1161J = null;
    /* renamed from: K */
    private static DataInputStream f1162K = null;
    /* renamed from: L */
    private static final String f1163L = "--CHECK_CMD_END--";

    /* renamed from: a */
    private static void m955a(int i, String str, Context context) {
        InputStream openRawResource = context.getResources().openRawResource(i);
        FileOutputStream openFileOutput = context.openFileOutput(str, 1);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = openRawResource.read(bArr);
            if (read < 0) {
                openRawResource.close();
                openFileOutput.getChannel().force(true);
                openFileOutput.flush();
                openFileOutput.close();
                return;
            }
            openFileOutput.write(bArr, 0, read);
        }
    }

    /* renamed from: e */
    private static boolean m956e(String str) {
        String toLowerCase = str.toLowerCase();
        return toLowerCase.contains("permission denied") || toLowerCase.contains("operation not permitted") || toLowerCase.contains("connect ui: timer expired") || toLowerCase.contains("can't set uid 0") || toLowerCase.contains("can't set gid 0");
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c5 A:{SYNTHETIC, Splitter: B:59:0x00c5} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ca A:{SYNTHETIC, Splitter: B:62:0x00ca} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cf A:{SYNTHETIC, Splitter: B:65:0x00cf} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009c A:{SYNTHETIC, Splitter: B:40:0x009c} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a1 A:{SYNTHETIC, Splitter: B:43:0x00a1} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a6 A:{SYNTHETIC, Splitter: B:46:0x00a6} */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c5 A:{SYNTHETIC, Splitter: B:59:0x00c5} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ca A:{SYNTHETIC, Splitter: B:62:0x00ca} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cf A:{SYNTHETIC, Splitter: B:65:0x00cf} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009c A:{SYNTHETIC, Splitter: B:40:0x009c} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a1 A:{SYNTHETIC, Splitter: B:43:0x00a1} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a6 A:{SYNTHETIC, Splitter: B:46:0x00a6} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c5 A:{SYNTHETIC, Splitter: B:59:0x00c5} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ca A:{SYNTHETIC, Splitter: B:62:0x00ca} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cf A:{SYNTHETIC, Splitter: B:65:0x00cf} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c5 A:{SYNTHETIC, Splitter: B:59:0x00c5} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ca A:{SYNTHETIC, Splitter: B:62:0x00ca} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cf A:{SYNTHETIC, Splitter: B:65:0x00cf} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009c A:{SYNTHETIC, Splitter: B:40:0x009c} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a1 A:{SYNTHETIC, Splitter: B:43:0x00a1} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a6 A:{SYNTHETIC, Splitter: B:46:0x00a6} */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c5 A:{SYNTHETIC, Splitter: B:59:0x00c5} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ca A:{SYNTHETIC, Splitter: B:62:0x00ca} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cf A:{SYNTHETIC, Splitter: B:65:0x00cf} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d4  */
    /* renamed from: f */
    private static boolean m957f(java.lang.String r14) {
        /*
        r7 = 1;
        r1 = 0;
        r3 = 0;
        r0 = m961i(r14);
        r2 = java.lang.Runtime.getRuntime();	 Catch:{ Exception -> 0x0093, all -> 0x00bf }
        r4 = "sh";
        r5 = r2.exec(r4);	 Catch:{ Exception -> 0x0093, all -> 0x00bf }
        r6 = new java.io.DataOutputStream;	 Catch:{ Exception -> 0x010b, all -> 0x00f9 }
        r2 = r5.getOutputStream();	 Catch:{ Exception -> 0x010b, all -> 0x00f9 }
        r6.<init>(r2);	 Catch:{ Exception -> 0x010b, all -> 0x00f9 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0110, all -> 0x00fd }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ Exception -> 0x0110, all -> 0x00fd }
        r2.<init>(r0);	 Catch:{ Exception -> 0x0110, all -> 0x00fd }
        r0 = "\n";
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x0110, all -> 0x00fd }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0110, all -> 0x00fd }
        r6.writeBytes(r0);	 Catch:{ Exception -> 0x0110, all -> 0x00fd }
        r6.flush();	 Catch:{ Exception -> 0x0110, all -> 0x00fd }
        r0 = "echo magic-text $?";
        r6.writeBytes(r0);	 Catch:{ Exception -> 0x0110, all -> 0x00fd }
        r6.flush();	 Catch:{ Exception -> 0x0110, all -> 0x00fd }
        r8 = r5.getInputStream();	 Catch:{ Exception -> 0x0110, all -> 0x00fd }
        r4 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x0110, all -> 0x00fd }
        r4.<init>(r8);	 Catch:{ Exception -> 0x0110, all -> 0x00fd }
        r2 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0115, all -> 0x0100 }
        r2.<init>(r4);	 Catch:{ Exception -> 0x0115, all -> 0x0100 }
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x011c, all -> 0x0102 }
        r12 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r10 = r10 + r12;
        r0 = r1;
    L_0x0051:
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x011c, all -> 0x0102 }
        r3 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1));
        if (r3 < 0) goto L_0x0086;
    L_0x0059:
        r6.close();	 Catch:{ IOException -> 0x00e7 }
    L_0x005c:
        r4.close();	 Catch:{ IOException -> 0x00ed }
    L_0x005f:
        r2.close();	 Catch:{ IOException -> 0x00f3 }
    L_0x0062:
        if (r5 == 0) goto L_0x0067;
    L_0x0064:
        r5.destroy();
    L_0x0067:
        return r0;
    L_0x0068:
        r9 = "magic-text";
        r9 = r3.contains(r9);	 Catch:{ Exception -> 0x011c, all -> 0x0102 }
        if (r9 == 0) goto L_0x0086;
    L_0x0070:
        r9 = " ";
        r3 = r3.split(r9);	 Catch:{ Exception -> 0x011c, all -> 0x0102 }
        r9 = r3.length;	 Catch:{ Exception -> 0x011c, all -> 0x0102 }
        r12 = 2;
        if (r9 <= r12) goto L_0x0086;
    L_0x007a:
        r9 = "0";
        r12 = 1;
        r3 = r3[r12];	 Catch:{ Exception -> 0x011c, all -> 0x0102 }
        r3 = r9.equals(r3);	 Catch:{ Exception -> 0x011c, all -> 0x0102 }
        if (r3 == 0) goto L_0x0086;
    L_0x0085:
        r0 = r7;
    L_0x0086:
        r3 = r8.available();	 Catch:{ Exception -> 0x011c, all -> 0x0102 }
        if (r3 <= 0) goto L_0x0051;
    L_0x008c:
        r3 = r2.readLine();	 Catch:{ Exception -> 0x011c, all -> 0x0102 }
        if (r3 != 0) goto L_0x0068;
    L_0x0092:
        goto L_0x0051;
    L_0x0093:
        r0 = move-exception;
        r2 = r3;
        r4 = r3;
        r5 = r3;
    L_0x0097:
        r0.printStackTrace();	 Catch:{ all -> 0x0105 }
        if (r5 == 0) goto L_0x009f;
    L_0x009c:
        r5.close();	 Catch:{ IOException -> 0x00b0 }
    L_0x009f:
        if (r3 == 0) goto L_0x00a4;
    L_0x00a1:
        r3.close();	 Catch:{ IOException -> 0x00b5 }
    L_0x00a4:
        if (r2 == 0) goto L_0x00a9;
    L_0x00a6:
        r2.close();	 Catch:{ IOException -> 0x00ba }
    L_0x00a9:
        if (r4 == 0) goto L_0x0122;
    L_0x00ab:
        r4.destroy();
        r0 = r1;
        goto L_0x0067;
    L_0x00b0:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x009f;
    L_0x00b5:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x00a4;
    L_0x00ba:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x00a9;
    L_0x00bf:
        r0 = move-exception;
        r4 = r3;
        r5 = r3;
        r6 = r3;
    L_0x00c3:
        if (r6 == 0) goto L_0x00c8;
    L_0x00c5:
        r6.close();	 Catch:{ IOException -> 0x00d8 }
    L_0x00c8:
        if (r4 == 0) goto L_0x00cd;
    L_0x00ca:
        r4.close();	 Catch:{ IOException -> 0x00dd }
    L_0x00cd:
        if (r3 == 0) goto L_0x00d2;
    L_0x00cf:
        r3.close();	 Catch:{ IOException -> 0x00e2 }
    L_0x00d2:
        if (r5 == 0) goto L_0x00d7;
    L_0x00d4:
        r5.destroy();
    L_0x00d7:
        throw r0;
    L_0x00d8:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00c8;
    L_0x00dd:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00cd;
    L_0x00e2:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00d2;
    L_0x00e7:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x005c;
    L_0x00ed:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x005f;
    L_0x00f3:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0062;
    L_0x00f9:
        r0 = move-exception;
        r4 = r3;
        r6 = r3;
        goto L_0x00c3;
    L_0x00fd:
        r0 = move-exception;
        r4 = r3;
        goto L_0x00c3;
    L_0x0100:
        r0 = move-exception;
        goto L_0x00c3;
    L_0x0102:
        r0 = move-exception;
        r3 = r2;
        goto L_0x00c3;
    L_0x0105:
        r0 = move-exception;
        r6 = r5;
        r5 = r4;
        r4 = r3;
        r3 = r2;
        goto L_0x00c3;
    L_0x010b:
        r0 = move-exception;
        r2 = r3;
        r4 = r5;
        r5 = r3;
        goto L_0x0097;
    L_0x0110:
        r0 = move-exception;
        r2 = r3;
        r4 = r5;
        r5 = r6;
        goto L_0x0097;
    L_0x0115:
        r0 = move-exception;
        r2 = r3;
        r3 = r4;
        r4 = r5;
        r5 = r6;
        goto L_0x0097;
    L_0x011c:
        r0 = move-exception;
        r3 = r4;
        r4 = r5;
        r5 = r6;
        goto L_0x0097;
    L_0x0122:
        r0 = r1;
        goto L_0x0067;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.changefontmanager.sdk.utils.CmdUtils.f(java.lang.String):boolean");
    }

    /* renamed from: g */
    private static boolean m958g(String str) {
        FileUtils.m967j("cmd = " + str);
        String i = m961i(str);
        try {
            if (!m959h() && !m963j()) {
                return false;
            }
            while (f1162K.available() > 0) {
                if (f1162K.readLine() == null) {
                    break;
                }
            }
            f1161J.writeBytes(new StringBuilder(String.valueOf(i)).append("\n").toString());
            f1161J.flush();
            f1161J.writeBytes("echo magic-text $? \n");
            f1161J.flush();
            long currentTimeMillis = System.currentTimeMillis() + 5000;
            while (System.currentTimeMillis() < currentTimeMillis) {
                while (f1162K.available() > 0) {
                    String readLine = f1162K.readLine();
                    if (readLine == null) {
                        continue;
                        break;
                    }
                    FileUtils.m967j(readLine);
                    if (readLine.contains("permission denied") || readLine.contains("operation not permitted") || readLine.contains("connect ui: timer expired") || readLine.contains("not found")) {
                        return false;
                    }
                    if (readLine.contains("magic-text")) {
                        String[] split = readLine.split(" ");
                        if (split.length > 1 && "0".equals(split[1])) {
                            return true;
                        }
                        DataInputStream dataInputStream = new DataInputStream(f1160I.getErrorStream());
                        if ("0".equals(split[1])) {
                            return false;
                        }
                        i = dataInputStream.readLine();
                        return i == null || "".equals(i);
                    }
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: h */
    private static boolean m959h() {
        IOException e;
        boolean z = false;
        if (f1160I != null) {
            boolean z2;
            try {
                f1160I.exitValue();
                z2 = false;
            } catch (Exception e2) {
                z2 = true;
            }
            if (z2) {
                try {
                    f1161J.writeBytes("echo --CHECK_CMD_END--\n");
                    f1161J.flush();
                    long currentTimeMillis = 5000 + System.currentTimeMillis();
                    boolean z3 = false;
                    z2 = false;
                    while (System.currentTimeMillis() < currentTimeMillis) {
                        try {
                            while (f1162K.available() > 0) {
                                String readLine = f1162K.readLine();
                                if (readLine != null) {
                                    boolean z4;
                                    String toLowerCase = readLine.toLowerCase();
                                    boolean z5 = toLowerCase.contains("permission denied") || toLowerCase.contains("operation not permitted") || toLowerCase.contains("connect ui: timer expired") || toLowerCase.contains("can't set uid 0") || toLowerCase.contains("can't set gid 0");
                                    if (z5) {
                                        z2 = true;
                                        z3 = false;
                                    } else if (readLine.contains(f1163L)) {
                                        z2 = true;
                                        z3 = true;
                                    } else {
                                        z4 = z3;
                                        z3 = z2;
                                        z2 = z4;
                                    }
                                    if (z2) {
                                        z4 = z2;
                                        z2 = z3;
                                        z3 = z4;
                                        break;
                                    }
                                    z4 = z2;
                                    z2 = z3;
                                    z3 = z4;
                                } else {
                                    break;
                                }
                            }
                            if (z3) {
                                break;
                            }
                        } catch (IOException e3) {
                            IOException iOException = e3;
                            z = z2;
                            e = iOException;
                        }
                    }
                    z = z2;
                    if (!z) {
                        m962i();
                    }
                } catch (IOException e4) {
                    e = e4;
                }
            }
        }
        return z;
        e.printStackTrace();
        return z;
    }

    /* renamed from: h */
    public static boolean m960h(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean g = m958g(str);
        FileUtils.m967j("cmd = " + str + " +++ time =" + (System.currentTimeMillis() - currentTimeMillis) + " +++ re = " + g);
        return g;
    }

    /* renamed from: i */
    private static String m961i(String str) {
        return VERSION.SDK_INT >= 18 ? str.replaceAll(Environment.getExternalStorageDirectory().getPath(), IXAdIOUtils.DEFAULT_SD_CARD_PATH) : str;
    }

    /* renamed from: i */
    private static synchronized void m962i() {
        synchronized (CmdUtils.class) {
            if (f1161J != null) {
                try {
                    f1161J.writeBytes("exit\n");
                    f1161J.flush();
                    f1161J.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                f1161J = null;
            }
            if (f1162K != null) {
                try {
                    f1162K.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                f1162K = null;
            }
            if (f1160I != null) {
                try {
                    f1160I.destroy();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                f1160I = null;
            }
        }
        return;
    }

    /* renamed from: j */
    private static boolean m963j() {
        String str = "su";
        if (RootUtils.f1176Y != null) {
            str = RootUtils.f1176Y;
        }
        try {
            m962i();
            ProcessBuilder processBuilder = new ProcessBuilder(new String[]{str});
            processBuilder.redirectErrorStream(true);
            f1160I = processBuilder.start();
            f1161J = new DataOutputStream(f1160I.getOutputStream());
            f1162K = new DataInputStream(f1160I.getInputStream());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: k */
    private static boolean m964k() {
        return true;
    }
}
