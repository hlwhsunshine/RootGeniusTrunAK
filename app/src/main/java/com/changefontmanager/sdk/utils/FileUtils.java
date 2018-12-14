package com.changefontmanager.sdk.utils;

import android.os.Environment;
import com.changefontmanager.sdk.ChangeFontManager;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class FileUtils {
    /* renamed from: W */
    private static int f1174W = 4096;
    /* renamed from: X */
    private static String f1175X = (Environment.getExternalStorageDirectory() + "/changefontSDK.txt");

    /* renamed from: a */
    private static void m965a(File file) {
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                file.delete();
                return;
            }
            for (File a : listFiles) {
                m965a(a);
            }
            file.delete();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x004b A:{SYNTHETIC, Splitter: B:32:0x004b} */
    /* JADX WARNING: Removed duplicated region for block: B:73:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0050 A:{SYNTHETIC, Splitter: B:35:0x0050} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0063 A:{SYNTHETIC, Splitter: B:44:0x0063} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0068 A:{SYNTHETIC, Splitter: B:47:0x0068} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0063 A:{SYNTHETIC, Splitter: B:44:0x0063} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0068 A:{SYNTHETIC, Splitter: B:47:0x0068} */
    private static void copyFile(java.lang.String r5, java.lang.String r6, boolean r7) {
        /*
        r2 = 0;
        if (r5 == 0) goto L_0x0018;
    L_0x0003:
        r0 = r5.trim();
        r0 = r0.length();
        if (r0 <= 0) goto L_0x0018;
    L_0x000d:
        r0 = new java.io.File;
        r0.<init>(r5);
        r0 = r0.exists();
        if (r0 != 0) goto L_0x0019;
    L_0x0018:
        return;
    L_0x0019:
        if (r7 == 0) goto L_0x0018;
    L_0x001b:
        r3 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0083, all -> 0x005e }
        r3.<init>(r5);	 Catch:{ Exception -> 0x0083, all -> 0x005e }
        r1 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0086, all -> 0x007b }
        r1.<init>(r6);	 Catch:{ Exception -> 0x0086, all -> 0x007b }
        r0 = 10240; // 0x2800 float:1.4349E-41 double:5.059E-320;
        r0 = new byte[r0];	 Catch:{ Exception -> 0x0044, all -> 0x007e }
    L_0x0029:
        r2 = r3.read(r0);	 Catch:{ Exception -> 0x0044, all -> 0x007e }
        r4 = -1;
        if (r2 != r4) goto L_0x003f;
    L_0x0030:
        r1.flush();	 Catch:{ Exception -> 0x0044, all -> 0x007e }
        r3.close();	 Catch:{ IOException -> 0x0076 }
    L_0x0036:
        r1.close();	 Catch:{ IOException -> 0x003a }
        goto L_0x0018;
    L_0x003a:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0018;
    L_0x003f:
        r4 = 0;
        r1.write(r0, r4, r2);	 Catch:{ Exception -> 0x0044, all -> 0x007e }
        goto L_0x0029;
    L_0x0044:
        r0 = move-exception;
        r2 = r3;
    L_0x0046:
        r0.printStackTrace();	 Catch:{ all -> 0x0080 }
        if (r2 == 0) goto L_0x004e;
    L_0x004b:
        r2.close();	 Catch:{ IOException -> 0x0059 }
    L_0x004e:
        if (r1 == 0) goto L_0x0018;
    L_0x0050:
        r1.close();	 Catch:{ IOException -> 0x0054 }
        goto L_0x0018;
    L_0x0054:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0018;
    L_0x0059:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x004e;
    L_0x005e:
        r0 = move-exception;
        r1 = r2;
        r3 = r2;
    L_0x0061:
        if (r3 == 0) goto L_0x0066;
    L_0x0063:
        r3.close();	 Catch:{ IOException -> 0x006c }
    L_0x0066:
        if (r1 == 0) goto L_0x006b;
    L_0x0068:
        r1.close();	 Catch:{ IOException -> 0x0071 }
    L_0x006b:
        throw r0;
    L_0x006c:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x0066;
    L_0x0071:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x006b;
    L_0x0076:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0036;
    L_0x007b:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0061;
    L_0x007e:
        r0 = move-exception;
        goto L_0x0061;
    L_0x0080:
        r0 = move-exception;
        r3 = r2;
        goto L_0x0061;
    L_0x0083:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0046;
    L_0x0086:
        r0 = move-exception;
        r1 = r2;
        r2 = r3;
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.changefontmanager.sdk.utils.FileUtils.copyFile(java.lang.String, java.lang.String, boolean):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052 A:{SYNTHETIC, Splitter: B:18:0x0052} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ec A:{SYNTHETIC, Splitter: B:69:0x00ec} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00f1 A:{SYNTHETIC, Splitter: B:72:0x00f1} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d4 A:{SYNTHETIC, Splitter: B:57:0x00d4} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d9 A:{SYNTHETIC, Splitter: B:60:0x00d9} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ec A:{SYNTHETIC, Splitter: B:69:0x00ec} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00f1 A:{SYNTHETIC, Splitter: B:72:0x00f1} */
    private static void copyFile1(java.lang.String r7, java.lang.String r8, boolean r9) {
        /*
        r1 = 0;
        if (r7 == 0) goto L_0x0137;
    L_0x0003:
        r0 = r7.trim();
        r0 = r0.length();
        if (r0 <= 0) goto L_0x0137;
    L_0x000d:
        r0 = new java.io.File;
        r0.<init>(r7);
        r2 = new java.io.File;
        r2.<init>(r8);
        r0 = r0.exists();
        if (r0 != 0) goto L_0x001e;
    L_0x001d:
        return;
    L_0x001e:
        r0 = r2.exists();
        if (r0 == 0) goto L_0x002a;
    L_0x0024:
        r2.delete();
        r2.createNewFile();	 Catch:{ IOException -> 0x00b3 }
    L_0x002a:
        r0 = new java.lang.StringBuilder;
        r2 = "chmod 777 ";
        r0.<init>(r2);
        r0 = r0.append(r8);
        r2 = " \n";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r2 = java.lang.Runtime.getRuntime();	 Catch:{ Exception -> 0x00b9, all -> 0x00c3 }
        r3 = 0;
        r4 = 0;
        r2 = r2.exec(r0, r3, r4);	 Catch:{ Exception -> 0x00b9, all -> 0x00c3 }
        r2.waitFor();	 Catch:{ Exception -> 0x0135 }
        r2.destroy();
        r0 = r2;
    L_0x0050:
        if (r9 == 0) goto L_0x0070;
    L_0x0052:
        r3 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0128, all -> 0x00e7 }
        r3.<init>(r7);	 Catch:{ Exception -> 0x0128, all -> 0x00e7 }
        r2 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x012e, all -> 0x0123 }
        r2.<init>(r8);	 Catch:{ Exception -> 0x012e, all -> 0x0123 }
        r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r1 = new byte[r1];	 Catch:{ Exception -> 0x00ce }
    L_0x0060:
        r4 = r3.read(r1);	 Catch:{ Exception -> 0x00ce }
        r5 = -1;
        if (r4 != r5) goto L_0x00c9;
    L_0x0067:
        r2.flush();	 Catch:{ Exception -> 0x00ce }
        r3.close();	 Catch:{ IOException -> 0x00ff }
    L_0x006d:
        r2.close();	 Catch:{ IOException -> 0x0105 }
    L_0x0070:
        r1 = new java.lang.StringBuilder;
        r2 = "chmod 777 ";
        r1.<init>(r2);
        r1 = r1.append(r8);
        r2 = " \n";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r2 = java.lang.Runtime.getRuntime();	 Catch:{ Exception -> 0x010b, all -> 0x0117 }
        r3 = 0;
        r4 = 0;
        r1 = r2.exec(r1, r3, r4);	 Catch:{ Exception -> 0x010b, all -> 0x0117 }
        r0 = new com.changefontmanager.sdk.utils.StreamGobbler;	 Catch:{ Exception -> 0x0121 }
        r2 = r1.getErrorStream();	 Catch:{ Exception -> 0x0121 }
        r3 = "Error";
        r0.<init>(r2, r3);	 Catch:{ Exception -> 0x0121 }
        r2 = new com.changefontmanager.sdk.utils.StreamGobbler;	 Catch:{ Exception -> 0x0121 }
        r3 = r1.getInputStream();	 Catch:{ Exception -> 0x0121 }
        r4 = "Output";
        r2.<init>(r3, r4);	 Catch:{ Exception -> 0x0121 }
        r0.start();	 Catch:{ Exception -> 0x0121 }
        r2.start();	 Catch:{ Exception -> 0x0121 }
        r1.waitFor();	 Catch:{ Exception -> 0x0121 }
        r1.destroy();
        goto L_0x001d;
    L_0x00b3:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x002a;
    L_0x00b9:
        r0 = move-exception;
        r2 = r1;
    L_0x00bb:
        r0.printStackTrace();	 Catch:{ all -> 0x0133 }
        r2.destroy();
        r0 = r2;
        goto L_0x0050;
    L_0x00c3:
        r0 = move-exception;
        r2 = r1;
    L_0x00c5:
        r2.destroy();
        throw r0;
    L_0x00c9:
        r5 = 0;
        r2.write(r1, r5, r4);	 Catch:{ Exception -> 0x00ce }
        goto L_0x0060;
    L_0x00ce:
        r1 = move-exception;
    L_0x00cf:
        r1.printStackTrace();	 Catch:{ all -> 0x0126 }
        if (r3 == 0) goto L_0x00d7;
    L_0x00d4:
        r3.close();	 Catch:{ IOException -> 0x00e2 }
    L_0x00d7:
        if (r2 == 0) goto L_0x0070;
    L_0x00d9:
        r2.close();	 Catch:{ IOException -> 0x00dd }
        goto L_0x0070;
    L_0x00dd:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0070;
    L_0x00e2:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00d7;
    L_0x00e7:
        r0 = move-exception;
        r2 = r1;
        r3 = r1;
    L_0x00ea:
        if (r3 == 0) goto L_0x00ef;
    L_0x00ec:
        r3.close();	 Catch:{ IOException -> 0x00f5 }
    L_0x00ef:
        if (r2 == 0) goto L_0x00f4;
    L_0x00f1:
        r2.close();	 Catch:{ IOException -> 0x00fa }
    L_0x00f4:
        throw r0;
    L_0x00f5:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00ef;
    L_0x00fa:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00f4;
    L_0x00ff:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x006d;
    L_0x0105:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0070;
    L_0x010b:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x010f:
        r0.printStackTrace();	 Catch:{ all -> 0x011f }
        r1.destroy();
        goto L_0x001d;
    L_0x0117:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x011b:
        r1.destroy();
        throw r0;
    L_0x011f:
        r0 = move-exception;
        goto L_0x011b;
    L_0x0121:
        r0 = move-exception;
        goto L_0x010f;
    L_0x0123:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00ea;
    L_0x0126:
        r0 = move-exception;
        goto L_0x00ea;
    L_0x0128:
        r2 = move-exception;
        r3 = r1;
        r6 = r1;
        r1 = r2;
        r2 = r6;
        goto L_0x00cf;
    L_0x012e:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
        goto L_0x00cf;
    L_0x0133:
        r0 = move-exception;
        goto L_0x00c5;
    L_0x0135:
        r0 = move-exception;
        goto L_0x00bb;
    L_0x0137:
        r0 = r1;
        goto L_0x0070;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.changefontmanager.sdk.utils.FileUtils.copyFile1(java.lang.String, java.lang.String, boolean):void");
    }

    public static void deleteFile(File file) {
        if (file.exists()) {
            try {
                if (file.isFile()) {
                    file.delete();
                } else if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    for (File deleteFile : listFiles) {
                        deleteFile(deleteFile);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x008e A:{Catch:{ all -> 0x0099 }} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009c A:{SYNTHETIC, Splitter: B:43:0x009c} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a1 A:{SYNTHETIC, Splitter: B:46:0x00a1} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009c A:{SYNTHETIC, Splitter: B:43:0x009c} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a1 A:{SYNTHETIC, Splitter: B:46:0x00a1} */
    /* renamed from: e */
    public static void m966e(java.lang.String r6, java.lang.String r7) {
        /*
        r1 = 0;
        r0 = 0;
        if (r6 == 0) goto L_0x0077;
    L_0x0004:
        r2 = r6.trim();
        r2 = r2.length();
        if (r2 <= 0) goto L_0x0077;
    L_0x000e:
        r2 = new java.io.File;
        r2.<init>(r6);
        r3 = r2.exists();
        if (r3 != 0) goto L_0x0021;
    L_0x0019:
        r0 = new java.lang.Exception;
        r1 = "src file is not exists";
        r0.<init>(r1);
        throw r0;
    L_0x0021:
        r3 = new java.lang.StringBuilder;
        r4 = com.changefontmanager.sdk.utils.MemoryUtils.getAvailableExternalMemorySize();
        r4 = java.lang.String.valueOf(r4);
        r3.<init>(r4);
        r4 = "++++";
        r3 = r3.append(r4);
        r4 = r2.length();
        r3.append(r4);
        r4 = com.changefontmanager.sdk.utils.MemoryUtils.getAvailableExternalMemorySize();
        r2 = r2.length();
        r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x0048;
    L_0x0047:
        r0 = 1;
    L_0x0048:
        if (r0 == 0) goto L_0x00b9;
    L_0x004a:
        r0 = new java.io.File;	 Catch:{ Exception -> 0x00cb, all -> 0x00c1 }
        r0.<init>(r7);	 Catch:{ Exception -> 0x00cb, all -> 0x00c1 }
        r2 = r0.exists();	 Catch:{ Exception -> 0x00cb, all -> 0x00c1 }
        if (r2 != 0) goto L_0x0058;
    L_0x0055:
        r0.createNewFile();	 Catch:{ Exception -> 0x00cb, all -> 0x00c1 }
    L_0x0058:
        r3 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x00cb, all -> 0x00c1 }
        r3.<init>(r6);	 Catch:{ Exception -> 0x00cb, all -> 0x00c1 }
        r2 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x00ce, all -> 0x00c4 }
        r2.<init>(r7);	 Catch:{ Exception -> 0x00ce, all -> 0x00c4 }
        r0 = 102400; // 0x19000 float:1.43493E-40 double:5.05923E-319;
        r0 = new byte[r0];	 Catch:{ Exception -> 0x007d, all -> 0x00c7 }
    L_0x0067:
        r1 = r3.read(r0);	 Catch:{ Exception -> 0x007d, all -> 0x00c7 }
        r4 = -1;
        if (r1 != r4) goto L_0x0078;
    L_0x006e:
        r2.flush();	 Catch:{ Exception -> 0x007d, all -> 0x00c7 }
        r3.close();	 Catch:{ IOException -> 0x00af }
    L_0x0074:
        r2.close();	 Catch:{ IOException -> 0x00b4 }
    L_0x0077:
        return;
    L_0x0078:
        r4 = 0;
        r2.write(r0, r4, r1);	 Catch:{ Exception -> 0x007d, all -> 0x00c7 }
        goto L_0x0067;
    L_0x007d:
        r0 = move-exception;
        r1 = r2;
        r2 = r3;
    L_0x0080:
        r0.printStackTrace();	 Catch:{ all -> 0x0099 }
        r0 = new java.io.File;	 Catch:{ all -> 0x0099 }
        r0.<init>(r7);	 Catch:{ all -> 0x0099 }
        r3 = r0.exists();	 Catch:{ all -> 0x0099 }
        if (r3 == 0) goto L_0x0091;
    L_0x008e:
        r0.deleteOnExit();	 Catch:{ all -> 0x0099 }
    L_0x0091:
        r0 = new java.lang.Exception;	 Catch:{ all -> 0x0099 }
        r3 = "IO Exception";
        r0.<init>(r3);	 Catch:{ all -> 0x0099 }
        throw r0;	 Catch:{ all -> 0x0099 }
    L_0x0099:
        r0 = move-exception;
    L_0x009a:
        if (r2 == 0) goto L_0x009f;
    L_0x009c:
        r2.close();	 Catch:{ IOException -> 0x00a5 }
    L_0x009f:
        if (r1 == 0) goto L_0x00a4;
    L_0x00a1:
        r1.close();	 Catch:{ IOException -> 0x00aa }
    L_0x00a4:
        throw r0;
    L_0x00a5:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x009f;
    L_0x00aa:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00a4;
    L_0x00af:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0074;
    L_0x00b4:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0077;
    L_0x00b9:
        r0 = new java.lang.Exception;
        r1 = "memory not enough";
        r0.<init>(r1);
        throw r0;
    L_0x00c1:
        r0 = move-exception;
        r2 = r1;
        goto L_0x009a;
    L_0x00c4:
        r0 = move-exception;
        r2 = r3;
        goto L_0x009a;
    L_0x00c7:
        r0 = move-exception;
        r1 = r2;
        r2 = r3;
        goto L_0x009a;
    L_0x00cb:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0080;
    L_0x00ce:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0080;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.changefontmanager.sdk.utils.FileUtils.e(java.lang.String, java.lang.String):void");
    }

    /* renamed from: j */
    public static void m967j(String str) {
        if (!ChangeFontManager.getInstance().isLogflog()) {
            try {
                File file = new File(f1175X);
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write(new StringBuilder(String.valueOf(str)).append("\r\n").toString());
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: l */
    private static String m968l() {
        FileNotFoundException e;
        IOException e2;
        String str = "";
        File file = new File("/data/data/com.android.settings/app_fonts/sans.loc");
        if (!file.exists()) {
            return str;
        }
        try {
            InputStream fileInputStream = new FileInputStream(file);
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = fileInputStream.read();
                if (read == -1) {
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    fileInputStream.close();
                    String obj = byteArrayOutputStream.toString();
                    try {
                        return obj.substring(0, obj.lastIndexOf("#"));
                    } catch (FileNotFoundException e3) {
                        FileNotFoundException fileNotFoundException = e3;
                        str = obj;
                        e = fileNotFoundException;
                    } catch (IOException e4) {
                        IOException iOException = e4;
                        str = obj;
                        e2 = iOException;
                        e2.printStackTrace();
                        return str;
                    }
                }
                byteArrayOutputStream.write(read);
            }
        } catch (FileNotFoundException e5) {
            e = e5;
        } catch (IOException e6) {
            e2 = e6;
        }
        e.printStackTrace();
        return str;
    }

    private static void unzipApk(String str, String str2, String str3) {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    return;
                }
                try {
                    if (nextEntry.getName().contains("font")) {
                        Object obj = nextEntry.getName().contains("font-en") ? 1 : null;
                        byte[] bArr = new byte[f1174W];
                        File file = new File(new StringBuilder(String.valueOf(str2)).append(str3).append("-zh.ttf").toString());
                        if (obj != null) {
                            file = new File(new StringBuilder(String.valueOf(str2)).append(str3).append("-en.ttf").toString());
                        }
                        File file2 = new File(file.getParent());
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), f1174W);
                        while (true) {
                            int read = zipInputStream.read(bArr, 0, f1174W);
                            if (read == -1) {
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void unzipTmpTTf(String str, String str2) {
        if (!new File(str2).exists()) {
            try {
                ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
                while (zipInputStream.getNextEntry() != null) {
                    try {
                        byte[] bArr = new byte[4096];
                        File file = new File(str2);
                        File file2 = new File(file.getParent());
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 4096);
                        while (true) {
                            int read = zipInputStream.read(bArr, 0, 4096);
                            if (read == -1) {
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                zipInputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        File file3 = new File(str);
        if (file3.exists()) {
            file3.delete();
        }
    }

    private static void zipFiles(String str, String str2, ZipOutputStream zipOutputStream) {
        int i = 0;
        if (zipOutputStream != null) {
            File file = new File(new StringBuilder(String.valueOf(str)).append(str2).toString());
            int read;
            if (file.isFile()) {
                ZipEntry zipEntry = new ZipEntry(str2.replaceAll("miui/", ""));
                FileInputStream fileInputStream = new FileInputStream(file);
                zipOutputStream.putNextEntry(zipEntry);
                byte[] bArr = new byte[f1174W];
                while (true) {
                    read = fileInputStream.read(bArr);
                    if (read == -1) {
                        zipOutputStream.closeEntry();
                        fileInputStream.close();
                        return;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
            } else {
                String[] list = file.list();
                if (list.length <= 0) {
                    zipOutputStream.putNextEntry(new ZipEntry(new StringBuilder(String.valueOf(str2)).append(File.separator).toString()));
                    zipOutputStream.closeEntry();
                }
                read = list.length;
                while (i < read) {
                    zipFiles(str, new StringBuilder(String.valueOf(str2)).append(File.separator).append(list[i]).toString(), zipOutputStream);
                    i++;
                }
            }
        }
    }

    private static void zipFolder(String str, String str2) {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
        File file = new File(str);
        zipFiles(file.getParent() + File.separator, file.getName(), zipOutputStream);
        zipOutputStream.finish();
        zipOutputStream.close();
    }
}
