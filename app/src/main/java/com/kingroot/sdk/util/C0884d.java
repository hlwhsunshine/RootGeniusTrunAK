package com.kingroot.sdk.util;

import com.kingroot.sdk.C0633at;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Random;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.kingroot.sdk.util.d */
public final class C0884d {
    /* renamed from: W */
    public static byte[] m2411W(String str) {
        Closeable byteArrayOutputStream;
        Throwable th;
        Closeable closeable = null;
        try {
            Closeable fileInputStream = new FileInputStream(str);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(fileInputStream.available());
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                closeable = fileInputStream;
                C0885e.m2419a(byteArrayOutputStream);
                C0885e.m2419a(closeable);
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                bArr = byteArrayOutputStream.toByteArray();
                C0885e.m2419a(byteArrayOutputStream);
                C0885e.m2419a(fileInputStream);
                return bArr != null ? bArr : "".getBytes();
            } catch (Throwable th3) {
                th = th3;
                closeable = fileInputStream;
                C0885e.m2419a(byteArrayOutputStream);
                C0885e.m2419a(closeable);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            C0885e.m2419a(byteArrayOutputStream);
            C0885e.m2419a(closeable);
            throw th;
        }
    }

    /* renamed from: X */
    public static boolean m2412X(String str) {
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            C0633at.m1465i("files is NULL");
            return false;
        }
        boolean z = true;
        for (int i = 0; i < listFiles.length; i++) {
            if (!listFiles[i].isFile()) {
                z = C0884d.m2412X(listFiles[i].getAbsolutePath());
                if (!z) {
                    break;
                }
            } else {
                z = C0884d.deleteFile(listFiles[i].getAbsolutePath());
                if (!z) {
                    break;
                }
            }
        }
        return z && file.delete();
    }

    /* renamed from: a */
    public static void m2413a(byte[] bArr, String str) {
        Throwable th;
        Closeable fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str, false);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.getChannel().force(true);
                fileOutputStream.flush();
                C0885e.m2419a(fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
                C0885e.m2419a(fileOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            C0885e.m2419a(fileOutputStream);
            throw th;
        }
    }

    /* renamed from: a */
    public static void m2414a(byte[] bArr, boolean z, String str) {
        Throwable th;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            Closeable fileOutputStream = new FileOutputStream(str, false);
            if (z) {
                try {
                    fileOutputStream.write(C0884d.m2415bi());
                } catch (Throwable th2) {
                    th = th2;
                    closeable = fileOutputStream;
                    C0885e.m2419a(closeable2);
                    C0885e.m2419a(closeable);
                    throw th;
                }
            }
            closeable = new GZIPOutputStream(fileOutputStream);
            try {
                closeable.write(bArr);
                fileOutputStream.getChannel().force(true);
                fileOutputStream.flush();
                C0885e.m2419a(closeable);
                C0885e.m2419a(fileOutputStream);
            } catch (Throwable th3) {
                th = th3;
                closeable2 = closeable;
                closeable = fileOutputStream;
                C0885e.m2419a(closeable2);
                C0885e.m2419a(closeable);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            closeable = null;
            C0885e.m2419a(closeable2);
            C0885e.m2419a(closeable);
            throw th;
        }
    }

    /* renamed from: bi */
    private static byte[] m2415bi() {
        int i = 5;
        Random random = new Random();
        int nextInt = random.nextInt(9);
        if (nextInt > 5) {
            i = nextInt;
        }
        int[] iArr = new int[(i + 4)];
        iArr[0] = 268573306;
        iArr[1] = 175;
        iArr[2] = random.nextInt();
        iArr[3] = i;
        for (nextInt = 0; nextInt < i; nextInt++) {
            iArr[nextInt + 4] = random.nextInt();
        }
        nextInt = iArr.length << 2;
        byte[] bArr = new byte[nextInt];
        for (i = 0; i < nextInt; i++) {
            bArr[i] = (byte) ((iArr[i >>> 2] >>> ((i & 3) << 3)) & 255);
        }
        return bArr;
    }

    /* renamed from: c */
    public static String m2416c(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            stringBuilder.append("0123456789abcdef".charAt((b >> 4) & 15)).append("0123456789abcdef".charAt(b & 15));
        }
        return stringBuilder.toString();
    }

    public static boolean deleteFile(String str) {
        try {
            return new File(str).delete();
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: g */
    public static String m2417g(File file) {
        Exception e;
        Throwable th;
        String str = "";
        Closeable fileInputStream;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                str = C0884d.m2416c(instance.digest());
                C0885e.m2419a(fileInputStream);
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    C0885e.m2419a(fileInputStream);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    C0885e.m2419a(fileInputStream);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            e.printStackTrace();
            C0885e.m2419a(fileInputStream);
            return str;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            C0885e.m2419a(fileInputStream);
            throw th;
        }
        return str;
    }
}
