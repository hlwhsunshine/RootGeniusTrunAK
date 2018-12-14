package com.kingroot.sdk;

import android.content.res.AssetManager;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* renamed from: com.kingroot.sdk.gd */
public final class C0840gd {
    /* renamed from: W */
    public static byte[] m2166W(String str) {
        return C0841ge.m2178W(str);
    }

    /* renamed from: a */
    public static void m2167a(AssetManager assetManager, String str, File file) {
        Throwable th;
        Closeable closeable = null;
        Closeable fileOutputStream;
        try {
            Closeable open = assetManager.open(str);
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    C0842gf.m2184a(open, fileOutputStream);
                    C0842gf.m2185a(open);
                    C0842gf.m2185a(fileOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    closeable = open;
                    C0842gf.m2185a(closeable);
                    C0842gf.m2185a(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                closeable = open;
                C0842gf.m2185a(closeable);
                C0842gf.m2185a(fileOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    /* renamed from: a */
    public static void m2168a(byte[] bArr, String str) {
        C0841ge.m2179a(bArr, str);
    }

    /* renamed from: a */
    public static boolean m2169a(AssetManager assetManager, String str, String str2) {
        InputStream open = assetManager.open(str);
        try {
            boolean a = C0840gd.m2170a(open, str2);
            return a;
        } finally {
            C0842gf.m2185a(open);
        }
    }

    /* JADX WARNING: Missing block: B:33:?, code:
            return true;
     */
    /* renamed from: a */
    public static boolean m2170a(java.io.InputStream r7, java.lang.String r8) {
        /*
        r0 = 1;
        r1 = new java.io.File;
        r1.<init>(r8);
        r1.mkdirs();
        r2 = new java.util.zip.ZipInputStream;
        r2.<init>(r7);
    L_0x000e:
        r3 = r2.getNextEntry();
        if (r3 != 0) goto L_0x0016;
    L_0x0014:
        r0 = 0;
    L_0x0015:
        return r0;
    L_0x0016:
        r4 = r3.isDirectory();
        if (r4 == 0) goto L_0x004a;
    L_0x001c:
        r4 = new java.io.File;
        r3 = r3.getName();
        r4.<init>(r1, r3);
        r3 = r4.exists();
        if (r3 != 0) goto L_0x000e;
    L_0x002b:
        r1 = "KUSdkLog";
        r2 = new java.lang.StringBuilder;
        r3 = "xxx";
        r2.<init>(r3);
        r3 = r4.getAbsolutePath();
        r2 = r2.append(r3);
        r3 = " need update";
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.kingroot.sdk.C0825fq.m2099g(r1, r2);
        goto L_0x0015;
    L_0x004a:
        r4 = new java.io.File;
        r3 = r3.getName();
        r4.<init>(r1, r3);
        r3 = r4.exists();
        if (r3 == 0) goto L_0x00b1;
    L_0x0059:
        r3 = r4.isFile();
        if (r3 == 0) goto L_0x00b1;
    L_0x005f:
        r3 = com.kingroot.sdk.C0840gd.m2177i(r4);
        r5 = com.kingroot.sdk.C0840gd.m2171b(r2);
        if (r3 == 0) goto L_0x0091;
    L_0x0069:
        if (r5 == 0) goto L_0x0091;
    L_0x006b:
        r3 = r3.equalsIgnoreCase(r5);
        if (r3 == 0) goto L_0x0091;
    L_0x0071:
        r3 = "KUSdkLog";
        r5 = new java.lang.StringBuilder;
        r6 = "xxx";
        r5.<init>(r6);
        r4 = r4.getAbsolutePath();
        r4 = r5.append(r4);
        r5 = " no changed.";
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.kingroot.sdk.C0825fq.m2099g(r3, r4);
        goto L_0x000e;
    L_0x0091:
        r1 = "KUSdkLog";
        r2 = new java.lang.StringBuilder;
        r3 = "xxx";
        r2.<init>(r3);
        r3 = r4.getAbsolutePath();
        r2 = r2.append(r3);
        r3 = " need update";
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.kingroot.sdk.C0825fq.m2099g(r1, r2);
        goto L_0x0015;
    L_0x00b1:
        r1 = "KUSdkLog";
        r2 = new java.lang.StringBuilder;
        r3 = "xxx";
        r2.<init>(r3);
        r3 = r4.getAbsolutePath();
        r2 = r2.append(r3);
        r3 = " need update";
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.kingroot.sdk.C0825fq.m2099g(r1, r2);
        goto L_0x0015;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.gd.a(java.io.InputStream, java.lang.String):boolean");
    }

    /* renamed from: b */
    public static String m2171b(InputStream inputStream) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return C0847gk.m2198c(instance.digest());
                }
                instance.update(bArr, 0, read);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public static void m2172b(AssetManager assetManager, String str, String str2) {
        Closeable open = assetManager.open(str);
        try {
            C0840gd.m2173b(open, str2);
        } finally {
            C0842gf.m2185a(open);
        }
    }

    /* renamed from: b */
    public static void m2173b(InputStream inputStream, String str) {
        Closeable fileOutputStream;
        Throwable th;
        File file = new File(str);
        file.mkdirs();
        InputStream zipInputStream = new ZipInputStream(inputStream);
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null) {
                if (nextEntry.isDirectory()) {
                    new File(file, nextEntry.getName()).mkdir();
                    C0825fq.m2100h("FileUtil", "mkDir : " + file.getAbsolutePath());
                } else {
                    File file2 = new File(file, nextEntry.getName());
                    try {
                        file2.delete();
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            C0842gf.m2184a(zipInputStream, fileOutputStream);
                            fileOutputStream.flush();
                            C0842gf.m2185a(fileOutputStream);
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                    }
                }
            } else {
                return;
            }
        }
        C0842gf.m2185a(fileOutputStream);
        throw th;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x003c A:{SYNTHETIC, Splitter: B:31:0x003c} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x004c A:{SYNTHETIC, Splitter: B:40:0x004c} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x005a A:{SYNTHETIC, Splitter: B:47:0x005a} */
    /* renamed from: c */
    public static byte[] m2174c(java.lang.String r7, int r8) {
        /*
        r0 = 0;
        r1 = 0;
        r2 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0035, IOException -> 0x0045, all -> 0x0055 }
        r2.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0035, IOException -> 0x0045, all -> 0x0055 }
        r3 = new byte[r8];	 Catch:{ FileNotFoundException -> 0x0067, IOException -> 0x0065 }
    L_0x0009:
        r4 = r8 - r1;
        r4 = r2.read(r3, r1, r4);	 Catch:{ FileNotFoundException -> 0x0067, IOException -> 0x0065 }
        r5 = -1;
        if (r4 != r5) goto L_0x0019;
    L_0x0012:
        r4 = r1;
        if (r4 != 0) goto L_0x0022;
    L_0x0015:
        r2.close();	 Catch:{ IOException -> 0x001d }
    L_0x0018:
        return r0;
    L_0x0019:
        r1 = r1 + r4;
        if (r1 >= r8) goto L_0x0012;
    L_0x001c:
        goto L_0x0009;
    L_0x001d:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0018;
    L_0x0022:
        if (r4 >= r8) goto L_0x0069;
    L_0x0024:
        r1 = new byte[r4];	 Catch:{ FileNotFoundException -> 0x0067, IOException -> 0x0065 }
        r5 = 0;
        r6 = 0;
        java.lang.System.arraycopy(r3, r5, r1, r6, r4);	 Catch:{ FileNotFoundException -> 0x0067, IOException -> 0x0065 }
        r0 = r1;
    L_0x002c:
        r2.close();	 Catch:{ IOException -> 0x0030 }
        goto L_0x0018;
    L_0x0030:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0018;
    L_0x0035:
        r1 = move-exception;
        r2 = r0;
    L_0x0037:
        r1.printStackTrace();	 Catch:{ all -> 0x0063 }
        if (r2 == 0) goto L_0x0018;
    L_0x003c:
        r2.close();	 Catch:{ IOException -> 0x0040 }
        goto L_0x0018;
    L_0x0040:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0018;
    L_0x0045:
        r1 = move-exception;
        r2 = r0;
    L_0x0047:
        r1.printStackTrace();	 Catch:{ all -> 0x0063 }
        if (r2 == 0) goto L_0x0018;
    L_0x004c:
        r2.close();	 Catch:{ IOException -> 0x0050 }
        goto L_0x0018;
    L_0x0050:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0018;
    L_0x0055:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x0058:
        if (r2 == 0) goto L_0x005d;
    L_0x005a:
        r2.close();	 Catch:{ IOException -> 0x005e }
    L_0x005d:
        throw r0;
    L_0x005e:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x005d;
    L_0x0063:
        r0 = move-exception;
        goto L_0x0058;
    L_0x0065:
        r1 = move-exception;
        goto L_0x0047;
    L_0x0067:
        r1 = move-exception;
        goto L_0x0037;
    L_0x0069:
        r0 = r3;
        goto L_0x002c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.gd.c(java.lang.String, int):byte[]");
    }

    /* renamed from: f */
    public static long m2175f(File file) {
        return (file.exists() && file.isFile()) ? C0841ge.m2181f(file) : 0;
    }

    /* renamed from: g */
    public static String m2176g(File file) {
        return (file.exists() && file.isFile()) ? C0841ge.m2182g(file) : "";
    }

    /* renamed from: i */
    public static String m2177i(File file) {
        Closeable fileInputStream = new FileInputStream(file);
        try {
            String b = C0840gd.m2171b(fileInputStream);
            return b;
        } finally {
            C0842gf.m2185a(fileInputStream);
        }
    }
}
