package com.kingroot.sdk.util;

import android.content.Context;
import android.os.Environment;
import com.kingroot.sdk.C0633at;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* renamed from: com.kingroot.sdk.util.c */
public final class C0883c {
    /* renamed from: W */
    public static byte[] m2387W(String str) {
        return C0884d.m2411W(str);
    }

    /* renamed from: X */
    public static boolean m2388X(String str) {
        return C0884d.m2412X(str);
    }

    /* renamed from: Y */
    public static String m2389Y(String str) {
        Closeable bufferedInputStream;
        FileNotFoundException e;
        Closeable closeable;
        Throwable th;
        IOException e2;
        Closeable closeable2 = null;
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream);
            } catch (FileNotFoundException e3) {
                e = e3;
                closeable = null;
                bufferedInputStream = fileInputStream;
                try {
                    e.printStackTrace();
                    C0885e.m2419a(closeable);
                    C0885e.m2419a(closeable2);
                    C0885e.m2419a(bufferedInputStream);
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = bufferedInputStream;
                    bufferedInputStream = closeable2;
                    C0885e.m2419a(closeable);
                    C0885e.m2419a(bufferedInputStream);
                    C0885e.m2419a(fileInputStream);
                    throw th;
                }
            } catch (IOException e4) {
                e2 = e4;
                closeable = null;
                bufferedInputStream = null;
                try {
                    e2.printStackTrace();
                    C0885e.m2419a(closeable);
                    C0885e.m2419a(bufferedInputStream);
                    C0885e.m2419a(fileInputStream);
                    return "";
                } catch (Throwable th3) {
                    th = th3;
                    C0885e.m2419a(closeable);
                    C0885e.m2419a(bufferedInputStream);
                    C0885e.m2419a(fileInputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                closeable = null;
                bufferedInputStream = null;
                C0885e.m2419a(closeable);
                C0885e.m2419a(bufferedInputStream);
                C0885e.m2419a(fileInputStream);
                throw th;
            }
            try {
                closeable = new ByteArrayOutputStream();
            } catch (FileNotFoundException e5) {
                e = e5;
                closeable = null;
                closeable2 = bufferedInputStream;
                bufferedInputStream = fileInputStream;
                e.printStackTrace();
                C0885e.m2419a(closeable);
                C0885e.m2419a(closeable2);
                C0885e.m2419a(bufferedInputStream);
                return "";
            } catch (IOException e6) {
                e2 = e6;
                closeable = null;
                e2.printStackTrace();
                C0885e.m2419a(closeable);
                C0885e.m2419a(bufferedInputStream);
                C0885e.m2419a(fileInputStream);
                return "";
            } catch (Throwable th5) {
                th = th5;
                closeable = null;
                C0885e.m2419a(closeable);
                C0885e.m2419a(bufferedInputStream);
                C0885e.m2419a(fileInputStream);
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read != -1) {
                        closeable.write(bArr, 0, read);
                    } else {
                        String str2 = new String(closeable.toByteArray());
                        C0885e.m2419a(closeable);
                        C0885e.m2419a(bufferedInputStream);
                        C0885e.m2419a(fileInputStream);
                        return str2;
                    }
                }
            } catch (FileNotFoundException e7) {
                e = e7;
                closeable2 = bufferedInputStream;
                bufferedInputStream = fileInputStream;
                e.printStackTrace();
                C0885e.m2419a(closeable);
                C0885e.m2419a(closeable2);
                C0885e.m2419a(bufferedInputStream);
                return "";
            } catch (IOException e8) {
                e2 = e8;
                e2.printStackTrace();
                C0885e.m2419a(closeable);
                C0885e.m2419a(bufferedInputStream);
                C0885e.m2419a(fileInputStream);
                return "";
            }
        } catch (FileNotFoundException e9) {
            e = e9;
            closeable = null;
            bufferedInputStream = null;
            e.printStackTrace();
            C0885e.m2419a(closeable);
            C0885e.m2419a(closeable2);
            C0885e.m2419a(bufferedInputStream);
            return "";
        } catch (IOException e10) {
            e2 = e10;
            closeable = null;
            bufferedInputStream = null;
            fileInputStream = null;
            e2.printStackTrace();
            C0885e.m2419a(closeable);
            C0885e.m2419a(bufferedInputStream);
            C0885e.m2419a(fileInputStream);
            return "";
        } catch (Throwable th6) {
            th = th6;
            closeable = null;
            bufferedInputStream = null;
            fileInputStream = null;
            C0885e.m2419a(closeable);
            C0885e.m2419a(bufferedInputStream);
            C0885e.m2419a(fileInputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public static void m2390a(Context context, String str, File file) {
        Throwable th;
        Object obj;
        Closeable obj2 = null;
        Closeable fileOutputStream;
        try {
            InputStream open = context.getAssets().open(str);
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    C0885e.m2418a(open, (OutputStream) fileOutputStream);
                    fileOutputStream.getChannel().force(true);
                    fileOutputStream.flush();
                    C0885e.m2419a(open);
                    C0885e.m2419a(fileOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    obj2 = open;
                    C0885e.m2419a(obj2);
                    C0885e.m2419a(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                obj2 = open;
                C0885e.m2419a(obj2);
                C0885e.m2419a(fileOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    /* renamed from: a */
    public static void m2391a(File file, String str, Context context) {
        InputStream fileInputStream = new FileInputStream(file);
        try {
            C0883c.m2392a(fileInputStream, str, context);
        } finally {
            C0885e.m2419a(fileInputStream);
        }
    }

    /* renamed from: a */
    public static void m2392a(InputStream inputStream, String str, Context context) {
        Closeable fileOutputStream;
        Throwable th;
        File file = new File(str);
        file.mkdirs();
        InputStream zipInputStream = new ZipInputStream(inputStream);
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    new StringBuilder("entry = ").append(nextEntry.getName());
                    if (nextEntry.isDirectory()) {
                        new File(file, nextEntry.getName()).mkdirs();
                        new StringBuilder("mkDir : ").append(file.getAbsolutePath());
                    } else {
                        File file2 = new File(file, nextEntry.getName());
                        File parentFile = file2.getParentFile();
                        new StringBuilder("parent : ").append(parentFile.getAbsolutePath());
                        if (!(parentFile == null || parentFile.exists())) {
                            new StringBuilder("mkDir2 : ").append(parentFile.getAbsolutePath());
                            parentFile.mkdirs();
                        }
                        file2.delete();
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            C0885e.m2418a(zipInputStream, (OutputStream) fileOutputStream);
                            fileOutputStream.getChannel().force(true);
                            fileOutputStream.flush();
                            C0885e.m2419a(fileOutputStream);
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                } else {
                    C0885e.m2419a(zipInputStream);
                    return;
                }
            } catch (Throwable th3) {
                C0885e.m2419a(zipInputStream);
            }
        }
        C0885e.m2419a(fileOutputStream);
        throw th;
    }

    /* renamed from: a */
    public static void m2393a(byte[] bArr, String str) {
        C0884d.m2413a(bArr, str);
    }

    /* renamed from: a */
    public static boolean m2394a(Context context, File file, File file2) {
        Closeable fileOutputStream;
        Throwable th;
        Closeable closeable = null;
        C0886f.clean();
        try {
            Closeable fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                closeable = fileInputStream;
                C0885e.m2419a(closeable);
                C0885e.m2419a(fileOutputStream);
                throw th;
            }
            try {
                Object obj = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(obj);
                    if (read > 0) {
                        Object obj2 = new byte[read];
                        System.arraycopy(obj, 0, obj2, 0, read);
                        byte[] e = Cryptor.m2368e(context, obj2);
                        fileOutputStream.write(e, 0, e.length);
                    } else {
                        fileOutputStream.getChannel().force(true);
                        fileOutputStream.close();
                        C0885e.m2419a(fileInputStream);
                        C0885e.m2419a(fileOutputStream);
                        return true;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = fileInputStream;
                C0885e.m2419a(closeable);
                C0885e.m2419a(fileOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            C0885e.m2419a(closeable);
            C0885e.m2419a(fileOutputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public static boolean m2395a(Context context, File file, String str) {
        InputStream fileInputStream = new FileInputStream(file);
        try {
            boolean a = C0883c.m2397a(fileInputStream, str);
            return a;
        } finally {
            C0885e.m2419a(fileInputStream);
        }
    }

    /* renamed from: a */
    public static boolean m2396a(File file, String str, String str2) {
        Throwable th;
        Closeable closeable = null;
        C0886f.clean();
        File file2 = new File(str);
        file2.mkdirs();
        if (str2 != null) {
            int chmod = Posix.chmod(str, Integer.parseInt(str2, 8));
            if (chmod != 0) {
                C0886f.set(7007, str + " chmod fail rc = " + chmod);
                return false;
            }
        }
        Closeable fileInputStream;
        Closeable zipInputStream;
        Closeable fileOutputStream;
        Throwable th2;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                zipInputStream = new ZipInputStream(fileInputStream);
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            C0885e.m2419a(zipInputStream);
                            C0885e.m2419a(fileInputStream);
                            return true;
                        } else if (nextEntry.isDirectory()) {
                            new File(file2, nextEntry.getName()).mkdir();
                            C0633at.m1464h("mkDir : " + file2.getAbsolutePath());
                        } else {
                            File file3 = new File(file2, nextEntry.getName());
                            try {
                                file3.delete();
                                fileOutputStream = new FileOutputStream(file3);
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = zipInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                    }
                                    fileOutputStream.getChannel().force(true);
                                    fileOutputStream.flush();
                                    C0885e.m2419a(fileOutputStream);
                                    if (str2 != null) {
                                        String absolutePath = file3.getAbsolutePath();
                                        int chmod2 = Posix.chmod(absolutePath, Integer.parseInt(str2, 8));
                                        if (chmod2 != 0) {
                                            C0886f.set(7007, absolutePath + " chmod fail rc = " + chmod2);
                                            C0885e.m2419a(zipInputStream);
                                            C0885e.m2419a(fileInputStream);
                                            return false;
                                        }
                                    }
                                    C0633at.m1464h("extract " + file3.getAbsolutePath());
                                } catch (Throwable th3) {
                                    th2 = th3;
                                }
                            } catch (Throwable th4) {
                                th2 = th4;
                                fileOutputStream = null;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
                C0885e.m2419a(fileOutputStream);
                throw th2;
            } catch (Throwable th6) {
                th = th6;
                zipInputStream = null;
                C0885e.m2419a(zipInputStream);
                C0885e.m2419a(fileInputStream);
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            fileInputStream = null;
            zipInputStream = null;
            C0885e.m2419a(zipInputStream);
            C0885e.m2419a(fileInputStream);
            throw th;
        }
    }

    /* JADX WARNING: Missing block: B:30:?, code:
            new java.lang.StringBuilder("xxx").append(r4.getAbsolutePath()).append(" need update");
     */
    /* JADX WARNING: Missing block: B:31:0x00a3, code:
            com.kingroot.sdk.util.C0885e.m2419a(r1);
     */
    /* JADX WARNING: Missing block: B:33:?, code:
            new java.lang.StringBuilder("xxx").append(r4.getAbsolutePath()).append(" need update");
     */
    /* JADX WARNING: Missing block: B:34:0x00bb, code:
            com.kingroot.sdk.util.C0885e.m2419a(r1);
     */
    /* JADX WARNING: Missing block: B:45:?, code:
            return true;
     */
    /* JADX WARNING: Missing block: B:46:?, code:
            return true;
     */
    /* renamed from: a */
    public static boolean m2397a(java.io.InputStream r6, java.lang.String r7) {
        /*
        r0 = 1;
        r3 = new java.io.File;
        r3.<init>(r7);
        r3.mkdirs();
        r2 = 0;
        r1 = new java.util.zip.ZipInputStream;	 Catch:{ all -> 0x00c5 }
        r1.<init>(r6);	 Catch:{ all -> 0x00c5 }
    L_0x000f:
        r2 = r1.getNextEntry();	 Catch:{ all -> 0x008a }
        if (r2 == 0) goto L_0x00bf;
    L_0x0015:
        r4 = r2.isDirectory();	 Catch:{ all -> 0x008a }
        if (r4 == 0) goto L_0x0042;
    L_0x001b:
        r4 = new java.io.File;	 Catch:{ all -> 0x008a }
        r2 = r2.getName();	 Catch:{ all -> 0x008a }
        r4.<init>(r3, r2);	 Catch:{ all -> 0x008a }
        r2 = r4.exists();	 Catch:{ all -> 0x008a }
        if (r2 != 0) goto L_0x000f;
    L_0x002a:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008a }
        r3 = "xxx";
        r2.<init>(r3);	 Catch:{ all -> 0x008a }
        r3 = r4.getAbsolutePath();	 Catch:{ all -> 0x008a }
        r2 = r2.append(r3);	 Catch:{ all -> 0x008a }
        r3 = " need update";
        r2.append(r3);	 Catch:{ all -> 0x008a }
        com.kingroot.sdk.util.C0885e.m2419a(r1);
    L_0x0041:
        return r0;
    L_0x0042:
        r4 = new java.io.File;	 Catch:{ all -> 0x008a }
        r2 = r2.getName();	 Catch:{ all -> 0x008a }
        r4.<init>(r3, r2);	 Catch:{ all -> 0x008a }
        r2 = r4.exists();	 Catch:{ all -> 0x008a }
        if (r2 == 0) goto L_0x00a7;
    L_0x0051:
        r2 = r4.isFile();	 Catch:{ all -> 0x008a }
        if (r2 == 0) goto L_0x00a7;
    L_0x0057:
        r2 = "ku-config";
        r5 = r4.getName();	 Catch:{ all -> 0x008a }
        r2 = r2.equals(r5);	 Catch:{ all -> 0x008a }
        if (r2 != 0) goto L_0x000f;
    L_0x0063:
        r2 = com.kingroot.sdk.util.C0883c.m2407i(r4);	 Catch:{ all -> 0x008a }
        r5 = com.kingroot.sdk.util.C0883c.m2399b(r1);	 Catch:{ all -> 0x008a }
        if (r2 == 0) goto L_0x008f;
    L_0x006d:
        if (r5 == 0) goto L_0x008f;
    L_0x006f:
        r2 = r2.equalsIgnoreCase(r5);	 Catch:{ all -> 0x008a }
        if (r2 == 0) goto L_0x008f;
    L_0x0075:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008a }
        r5 = "xxx";
        r2.<init>(r5);	 Catch:{ all -> 0x008a }
        r4 = r4.getAbsolutePath();	 Catch:{ all -> 0x008a }
        r2 = r2.append(r4);	 Catch:{ all -> 0x008a }
        r4 = " no changed.";
        r2.append(r4);	 Catch:{ all -> 0x008a }
        goto L_0x000f;
    L_0x008a:
        r0 = move-exception;
    L_0x008b:
        com.kingroot.sdk.util.C0885e.m2419a(r1);
        throw r0;
    L_0x008f:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008a }
        r3 = "xxx";
        r2.<init>(r3);	 Catch:{ all -> 0x008a }
        r3 = r4.getAbsolutePath();	 Catch:{ all -> 0x008a }
        r2 = r2.append(r3);	 Catch:{ all -> 0x008a }
        r3 = " need update";
        r2.append(r3);	 Catch:{ all -> 0x008a }
        com.kingroot.sdk.util.C0885e.m2419a(r1);
        goto L_0x0041;
    L_0x00a7:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008a }
        r3 = "xxx";
        r2.<init>(r3);	 Catch:{ all -> 0x008a }
        r3 = r4.getAbsolutePath();	 Catch:{ all -> 0x008a }
        r2 = r2.append(r3);	 Catch:{ all -> 0x008a }
        r3 = " need update";
        r2.append(r3);	 Catch:{ all -> 0x008a }
        com.kingroot.sdk.util.C0885e.m2419a(r1);
        goto L_0x0041;
    L_0x00bf:
        com.kingroot.sdk.util.C0885e.m2419a(r1);
        r0 = 0;
        goto L_0x0041;
    L_0x00c5:
        r0 = move-exception;
        r1 = r2;
        goto L_0x008b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.util.c.a(java.io.InputStream, java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c4 A:{SYNTHETIC, Splitter: B:47:0x00c4} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008e A:{SYNTHETIC, Splitter: B:29:0x008e} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c4 A:{SYNTHETIC, Splitter: B:47:0x00c4} */
    /* renamed from: a */
    private static boolean m2398a(java.lang.String r8, java.lang.String r9, android.content.Context r10) {
        /*
        r5 = 1;
        r1 = 0;
        r3 = 0;
        r0 = new java.lang.StringBuilder;
        r2 = "extractSu srcPath = ";
        r0.<init>(r2);
        r0 = r0.append(r8);
        r2 = ", dstPath = ";
        r0 = r0.append(r2);
        r0 = r0.append(r9);
        r0 = r0.toString();
        com.kingroot.sdk.C0633at.m1464h(r0);
        r4 = new java.util.zip.ZipFile;	 Catch:{ Exception -> 0x00cf, all -> 0x00c0 }
        r4.<init>(r8);	 Catch:{ Exception -> 0x00cf, all -> 0x00c0 }
        r2 = r4.entries();	 Catch:{ Exception -> 0x0087, all -> 0x00ca }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0087, all -> 0x00ca }
        r6 = "res";
        r0.<init>(r6);	 Catch:{ Exception -> 0x0087, all -> 0x00ca }
        r6 = java.io.File.separatorChar;	 Catch:{ Exception -> 0x0087, all -> 0x00ca }
        r0 = r0.append(r6);	 Catch:{ Exception -> 0x0087, all -> 0x00ca }
        r6 = "raw";
        r0 = r0.append(r6);	 Catch:{ Exception -> 0x0087, all -> 0x00ca }
        r6 = java.io.File.separatorChar;	 Catch:{ Exception -> 0x0087, all -> 0x00ca }
        r0 = r0.append(r6);	 Catch:{ Exception -> 0x0087, all -> 0x00ca }
        r6 = "su";
        r0 = r0.append(r6);	 Catch:{ Exception -> 0x0087, all -> 0x00ca }
        r6 = r0.toString();	 Catch:{ Exception -> 0x0087, all -> 0x00ca }
    L_0x004b:
        r0 = r2.hasMoreElements();	 Catch:{ Exception -> 0x0087, all -> 0x00ca }
        if (r0 == 0) goto L_0x00d6;
    L_0x0051:
        r0 = r2.nextElement();	 Catch:{ Exception -> 0x0087, all -> 0x00ca }
        r0 = (java.util.zip.ZipEntry) r0;	 Catch:{ Exception -> 0x0087, all -> 0x00ca }
        r7 = r0.isDirectory();	 Catch:{ Exception -> 0x0087, all -> 0x00ca }
        if (r7 != 0) goto L_0x004b;
    L_0x005d:
        r7 = r0.getName();	 Catch:{ Exception -> 0x0087, all -> 0x00ca }
        r7 = r6.equals(r7);	 Catch:{ Exception -> 0x0087, all -> 0x00ca }
        if (r7 == 0) goto L_0x004b;
    L_0x0067:
        r2 = new java.io.FileOutputStream;	 Catch:{ all -> 0x00d1 }
        r2.<init>(r9);	 Catch:{ all -> 0x00d1 }
        r6 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r6 = new byte[r6];	 Catch:{ all -> 0x007f }
        r3 = r4.getInputStream(r0);	 Catch:{ all -> 0x007f }
    L_0x0074:
        r0 = r3.read(r6);	 Catch:{ all -> 0x007f }
        if (r0 <= 0) goto L_0x00a5;
    L_0x007a:
        r7 = 0;
        r2.write(r6, r7, r0);	 Catch:{ all -> 0x007f }
        goto L_0x0074;
    L_0x007f:
        r0 = move-exception;
    L_0x0080:
        com.kingroot.sdk.util.C0885e.m2419a(r3);	 Catch:{ Exception -> 0x0087, all -> 0x00ca }
        com.kingroot.sdk.util.C0885e.m2419a(r2);	 Catch:{ Exception -> 0x0087, all -> 0x00ca }
        throw r0;	 Catch:{ Exception -> 0x0087, all -> 0x00ca }
    L_0x0087:
        r0 = move-exception;
        r3 = r4;
    L_0x0089:
        r0.printStackTrace();	 Catch:{ all -> 0x00cc }
        if (r3 == 0) goto L_0x00d4;
    L_0x008e:
        r3.close();	 Catch:{ Exception -> 0x00bd }
        r0 = r1;
    L_0x0092:
        r1 = new java.lang.StringBuilder;
        r2 = "extractSu result = ";
        r1.<init>(r2);
        r1 = r1.append(r0);
        r1 = r1.toString();
        com.kingroot.sdk.C0633at.m1464h(r1);
        return r0;
    L_0x00a5:
        r0 = r2.getChannel();	 Catch:{ all -> 0x007f }
        r6 = 1;
        r0.force(r6);	 Catch:{ all -> 0x007f }
        r2.flush();	 Catch:{ all -> 0x007f }
        com.kingroot.sdk.util.C0885e.m2419a(r3);	 Catch:{ Exception -> 0x0087, all -> 0x00ca }
        com.kingroot.sdk.util.C0885e.m2419a(r2);	 Catch:{ Exception -> 0x0087, all -> 0x00ca }
        r0 = r5;
    L_0x00b7:
        r4.close();	 Catch:{ Exception -> 0x00bb }
        goto L_0x0092;
    L_0x00bb:
        r1 = move-exception;
        goto L_0x0092;
    L_0x00bd:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0092;
    L_0x00c0:
        r0 = move-exception;
        r4 = r3;
    L_0x00c2:
        if (r4 == 0) goto L_0x00c7;
    L_0x00c4:
        r4.close();	 Catch:{ Exception -> 0x00c8 }
    L_0x00c7:
        throw r0;
    L_0x00c8:
        r1 = move-exception;
        goto L_0x00c7;
    L_0x00ca:
        r0 = move-exception;
        goto L_0x00c2;
    L_0x00cc:
        r0 = move-exception;
        r4 = r3;
        goto L_0x00c2;
    L_0x00cf:
        r0 = move-exception;
        goto L_0x0089;
    L_0x00d1:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0080;
    L_0x00d4:
        r0 = r1;
        goto L_0x0092;
    L_0x00d6:
        r0 = r1;
        goto L_0x00b7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.util.c.a(java.lang.String, java.lang.String, android.content.Context):boolean");
    }

    /* renamed from: b */
    public static String m2399b(InputStream inputStream) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return C0897q.m2465c(instance.digest());
                }
                instance.update(bArr, 0, read);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public static void m2400b(byte[] bArr, String str) {
        C0884d.m2414a(bArr, false, str);
    }

    /* renamed from: b */
    public static boolean m2401b(Context context, String str, File file) {
        Closeable fileOutputStream;
        Throwable th;
        Closeable closeable = null;
        C0886f.clean();
        try {
            Closeable open = context.getAssets().open(str);
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                closeable = open;
                C0885e.m2419a(closeable);
                C0885e.m2419a(fileOutputStream);
                throw th;
            }
            try {
                Object obj = new byte[1024];
                while (true) {
                    int read = open.read(obj);
                    if (read > 0) {
                        Object obj2 = new byte[read];
                        System.arraycopy(obj, 0, obj2, 0, read);
                        byte[] e = Cryptor.m2368e(context, obj2);
                        fileOutputStream.write(e, 0, e.length);
                    } else {
                        fileOutputStream.getChannel().force(true);
                        fileOutputStream.flush();
                        C0885e.m2419a(open);
                        C0885e.m2419a(fileOutputStream);
                        return true;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = open;
                C0885e.m2419a(closeable);
                C0885e.m2419a(fileOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            C0885e.m2419a(closeable);
            C0885e.m2419a(fileOutputStream);
            throw th;
        }
    }

    /* renamed from: b */
    public static boolean m2402b(Context context, String str, String str2) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            try {
                String i = C0883c.m2407i(file);
                String s = C0883c.m2409s(context, str2);
                if (!(i == null || s == null || !i.equalsIgnoreCase(s))) {
                    return false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m2403b(String str, String str2, Context context) {
        String str3 = str2 + File.separatorChar + "su2";
        if (C0883c.m2398a(str, str3, context)) {
            String str4 = str2 + File.separatorChar + "su3";
            if (C0883c.m2408m(str3, str4)) {
                String str5 = str2 + File.separatorChar + "su";
                C0633at.m1464h("oldSuPath = " + str5);
                File file = new File(str5);
                if (file.exists()) {
                    C0633at.m1464h(str5 + " exists!");
                    file.delete();
                }
                new File(str3).delete();
                new File(str4).renameTo(file);
                return true;
            }
            new File(str3).delete();
            new File(str4).delete();
            return false;
        }
        new File(str3).delete();
        return false;
    }

    /* renamed from: bh */
    public static boolean m2404bh() {
        String externalStorageState = Environment.getExternalStorageState();
        return externalStorageState == null ? false : externalStorageState.equals("mounted");
    }

    public static boolean deleteFile(String str) {
        return C0884d.deleteFile(str);
    }

    /* renamed from: g */
    public static String m2405g(File file) {
        return (file.exists() && file.isFile()) ? C0884d.m2417g(file) : "";
    }

    /* renamed from: h */
    public static boolean m2406h(File file) {
        return (file == null || !file.exists() || file.delete()) ? true : file.delete();
    }

    /* renamed from: i */
    public static String m2407i(File file) {
        Closeable fileInputStream = new FileInputStream(file);
        try {
            String b = C0883c.m2399b(fileInputStream);
            return b;
        } finally {
            C0885e.m2419a(fileInputStream);
        }
    }

    /* renamed from: m */
    private static boolean m2408m(String str, String str2) {
        Closeable gZIPInputStream;
        FileNotFoundException e;
        Closeable closeable;
        Throwable th;
        Closeable closeable2;
        Exception e2;
        boolean z = true;
        Closeable closeable3 = null;
        C0633at.m1464h("unzipSu srcPath = " + str + ", dstPath = " + str2);
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                gZIPInputStream = new GZIPInputStream(fileInputStream);
            } catch (FileNotFoundException e3) {
                e = e3;
                gZIPInputStream = null;
                closeable = fileInputStream;
                fileInputStream = null;
                closeable3 = closeable;
                try {
                    e.printStackTrace();
                    C0885e.m2419a(fileInputStream);
                    C0885e.m2419a(gZIPInputStream);
                    C0885e.m2419a(closeable3);
                    z = false;
                    C0633at.m1464h("unzipSu srcPath = " + str + ", dstPath = " + str2 + ", result = " + z);
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    closeable2 = fileInputStream;
                    fileInputStream = closeable3;
                    C0885e.m2419a(closeable2);
                    C0885e.m2419a(gZIPInputStream);
                    C0885e.m2419a(fileInputStream);
                    throw th;
                }
            } catch (Exception e4) {
                e2 = e4;
                gZIPInputStream = null;
                closeable2 = null;
                try {
                    e2.printStackTrace();
                    C0885e.m2419a(closeable2);
                    C0885e.m2419a(gZIPInputStream);
                    C0885e.m2419a(fileInputStream);
                    z = false;
                    C0633at.m1464h("unzipSu srcPath = " + str + ", dstPath = " + str2 + ", result = " + z);
                    return z;
                } catch (Throwable th3) {
                    th = th3;
                    C0885e.m2419a(closeable2);
                    C0885e.m2419a(gZIPInputStream);
                    C0885e.m2419a(fileInputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                gZIPInputStream = null;
                closeable2 = null;
                C0885e.m2419a(closeable2);
                C0885e.m2419a(gZIPInputStream);
                C0885e.m2419a(fileInputStream);
                throw th;
            }
            try {
                closeable2 = new FileOutputStream(str2);
            } catch (FileNotFoundException e5) {
                e = e5;
                closeable = fileInputStream;
                fileInputStream = null;
                closeable3 = closeable;
                e.printStackTrace();
                C0885e.m2419a(fileInputStream);
                C0885e.m2419a(gZIPInputStream);
                C0885e.m2419a(closeable3);
                z = false;
                C0633at.m1464h("unzipSu srcPath = " + str + ", dstPath = " + str2 + ", result = " + z);
                return z;
            } catch (Exception e6) {
                e2 = e6;
                closeable2 = null;
                e2.printStackTrace();
                C0885e.m2419a(closeable2);
                C0885e.m2419a(gZIPInputStream);
                C0885e.m2419a(fileInputStream);
                z = false;
                C0633at.m1464h("unzipSu srcPath = " + str + ", dstPath = " + str2 + ", result = " + z);
                return z;
            } catch (Throwable th5) {
                th = th5;
                closeable2 = null;
                C0885e.m2419a(closeable2);
                C0885e.m2419a(gZIPInputStream);
                C0885e.m2419a(fileInputStream);
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = gZIPInputStream.read(bArr);
                    if (read < 0) {
                        break;
                    }
                    closeable2.write(bArr, 0, read);
                }
                closeable2.getChannel().force(true);
                closeable2.flush();
                C0885e.m2419a(closeable2);
                C0885e.m2419a(gZIPInputStream);
                C0885e.m2419a(fileInputStream);
            } catch (FileNotFoundException e7) {
                e = e7;
                closeable3 = fileInputStream;
                fileInputStream = closeable2;
                e.printStackTrace();
                C0885e.m2419a(fileInputStream);
                C0885e.m2419a(gZIPInputStream);
                C0885e.m2419a(closeable3);
                z = false;
                C0633at.m1464h("unzipSu srcPath = " + str + ", dstPath = " + str2 + ", result = " + z);
                return z;
            } catch (Exception e8) {
                e2 = e8;
                e2.printStackTrace();
                C0885e.m2419a(closeable2);
                C0885e.m2419a(gZIPInputStream);
                C0885e.m2419a(fileInputStream);
                z = false;
                C0633at.m1464h("unzipSu srcPath = " + str + ", dstPath = " + str2 + ", result = " + z);
                return z;
            }
        } catch (FileNotFoundException e9) {
            e = e9;
            gZIPInputStream = null;
            fileInputStream = null;
            e.printStackTrace();
            C0885e.m2419a(fileInputStream);
            C0885e.m2419a(gZIPInputStream);
            C0885e.m2419a(closeable3);
            z = false;
            C0633at.m1464h("unzipSu srcPath = " + str + ", dstPath = " + str2 + ", result = " + z);
            return z;
        } catch (Exception e10) {
            e2 = e10;
            gZIPInputStream = null;
            fileInputStream = null;
            closeable2 = null;
            e2.printStackTrace();
            C0885e.m2419a(closeable2);
            C0885e.m2419a(gZIPInputStream);
            C0885e.m2419a(fileInputStream);
            z = false;
            C0633at.m1464h("unzipSu srcPath = " + str + ", dstPath = " + str2 + ", result = " + z);
            return z;
        } catch (Throwable th6) {
            th = th6;
            gZIPInputStream = null;
            fileInputStream = null;
            closeable2 = null;
            C0885e.m2419a(closeable2);
            C0885e.m2419a(gZIPInputStream);
            C0885e.m2419a(fileInputStream);
            throw th;
        }
        C0633at.m1464h("unzipSu srcPath = " + str + ", dstPath = " + str2 + ", result = " + z);
        return z;
    }

    /* renamed from: s */
    public static String m2409s(Context context, String str) {
        Closeable open = context.getAssets().open(str);
        try {
            String b = C0883c.m2399b(open);
            return b;
        } finally {
            C0885e.m2419a(open);
        }
    }

    /* renamed from: t */
    public static boolean m2410t(Context context, String str) {
        try {
            String[] list = context.getAssets().list("");
            if (list == null || list.length <= 0) {
                return false;
            }
            for (Object equals : list) {
                if (str.equals(equals)) {
                    C0633at.m1464h("existAssetFile " + str);
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
