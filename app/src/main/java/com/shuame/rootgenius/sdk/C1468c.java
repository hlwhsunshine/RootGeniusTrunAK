package com.shuame.rootgenius.sdk;

import android.support.p015v4.media.TransportMediator;
import android.support.p015v4.view.MotionEventCompat;
import java.io.DataInput;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Random;
import p000a.p001a.p002a.p007c.C0010a;
import p000a.p001a.p002a.p009e.C0020f;
import p000a.p001a.p002a.p009e.C0022h;

/* renamed from: com.shuame.rootgenius.sdk.c */
public class C1468c {
    /* renamed from: a */
    public int f4036a = -1;
    /* renamed from: b */
    public int f4037b = 0;

    public C1468c(int i, int i2) {
    }

    /* renamed from: a */
    public static int m4048a(DataInput dataInput, byte[] bArr) {
        try {
            dataInput.readFully(bArr, 0, 4);
            return ((bArr[0] & 255) | ((bArr[1] & 255) << 8)) | (((bArr[2] & 255) | ((bArr[3] & 255) << 8)) << 16);
        } catch (Throwable e) {
            throw new C0010a(e);
        }
    }

    /* renamed from: a */
    public static long m4049a(byte[] bArr, int i) {
        return ((((((((((((((0 | ((long) (bArr[7] & 255))) << 8) | ((long) (bArr[6] & 255))) << 8) | ((long) (bArr[5] & 255))) << 8) | ((long) (bArr[4] & 255))) << 8) | ((long) (bArr[3] & 255))) << 8) | ((long) (bArr[2] & 255))) << 8) | ((long) (bArr[1] & 255))) << 8) | ((long) (bArr[0] & 255));
    }

    /* renamed from: a */
    public static String m4050a(byte[] bArr) {
        try {
            return new String(bArr, "Cp850");
        } catch (UnsupportedEncodingException e) {
            return new String(bArr);
        }
    }

    /* renamed from: a */
    public static String m4051a(byte[] bArr, boolean z) {
        if (!z) {
            return C1468c.m4050a(bArr);
        }
        try {
            return new String(bArr, "UTF8");
        } catch (UnsupportedEncodingException e) {
            return new String(bArr);
        }
    }

    /* renamed from: a */
    public static String m4052a(char[] cArr, int i) {
        if (cArr == null || cArr.length == 0 || i < 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(i);
        Random random = new Random();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append(cArr[random.nextInt(cArr.length)]);
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static void m4053a(C0020f c0020f, File file, C0022h c0022h) {
        if (c0020f == null) {
            throw new C0010a("cannot set file properties: file header is null");
        } else if (file == null) {
            throw new C0010a("cannot set file properties: output file is null");
        } else if (C1468c.m4055a(file)) {
            if (c0020f.mo66b() > 0 && file.exists()) {
                int b = c0020f.mo66b();
                int i = (b & 31) * 2;
                int i2 = (b >> 5) & 63;
                int i3 = (b >> 11) & 31;
                int i4 = (b >> 16) & 31;
                int i5 = ((b >> 21) & 15) - 1;
                int i6 = ((b >> 25) & TransportMediator.KEYCODE_MEDIA_PAUSE) + 1980;
                Calendar instance = Calendar.getInstance();
                instance.set(i6, i5, i4, i3, i2, i);
                instance.set(14, 0);
                file.setLastModified(instance.getTime().getTime());
            }
            C1468c.m4054a(c0020f, file, true, true, true, true);
        } else {
            throw new C0010a("cannot set file properties: file doesnot exist");
        }
    }

    /* renamed from: a */
    private static void m4054a(C0020f c0020f, File file, boolean z, boolean z2, boolean z3, boolean z4) {
        if (c0020f == null) {
            throw new C0010a("invalid file header. cannot set file attributes");
        }
        byte[] h = c0020f.mo80h();
        if (h != null) {
            switch (h[0]) {
                case (byte) 1:
                    if (z) {
                        C1468c.m4059b(file);
                        return;
                    }
                    return;
                case (byte) 2:
                case (byte) 18:
                    if (z2) {
                    }
                    return;
                case (byte) 3:
                    if (z) {
                        C1468c.m4059b(file);
                    }
                    if (z2) {
                    }
                    return;
                case (byte) 32:
                case (byte) 48:
                    if (z3) {
                    }
                    return;
                case (byte) 33:
                    if (z) {
                        C1468c.m4059b(file);
                        return;
                    }
                    return;
                case (byte) 34:
                case (byte) 50:
                    if (z2) {
                    }
                    return;
                case MotionEventCompat.AXIS_GENERIC_4 /*35*/:
                    if (z) {
                        C1468c.m4059b(file);
                    }
                    if (z2) {
                    }
                    return;
                case (byte) 38:
                    if (z) {
                        C1468c.m4059b(file);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    public static boolean m4055a(File file) {
        if (file != null) {
            return file.exists();
        }
        throw new C0010a("cannot check if file exists: input file is null");
    }

    /* renamed from: a */
    public static boolean m4056a(String str) {
        return str != null && str.trim().length() > 0;
    }

    /* renamed from: a */
    public static byte[] m4057a(char[] cArr) {
        if (cArr == null) {
            throw new NullPointerException();
        }
        byte[] bArr = new byte[cArr.length];
        for (int i = 0; i < cArr.length; i++) {
            bArr[i] = (byte) cArr[i];
        }
        return bArr;
    }

    /* renamed from: b */
    public static int m4058b(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
    }

    /* renamed from: b */
    public static void m4059b(File file) {
        if (file == null) {
            throw new C0010a("input file is null. cannot set read only file attribute");
        } else if (file.exists()) {
            file.setReadOnly();
        }
    }

    /* renamed from: b */
    public static boolean m4060b(String str) {
        if (C1468c.m4056a(str)) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.mkdirs();
                    if (!file.isDirectory()) {
                        throw new C0010a("output folder is not valid");
                    } else if (!file.canWrite()) {
                        throw new C0010a("no write access to destination folder");
                    }
                } catch (Exception e) {
                    throw new C0010a("Cannot create destination folder");
                }
            } else if (!file.isDirectory()) {
                throw new C0010a("output folder is not valid");
            } else if (!file.canWrite()) {
                throw new C0010a("no write access to output folder");
            }
            return true;
        }
        throw new C0010a(new NullPointerException("output path is null"));
    }

    /* renamed from: c */
    public static short m4061c(byte[] bArr, int i) {
        return (short) (((short) (((short) ((bArr[i] & 255) | 0)) << 8)) | (bArr[i + 1] & 255));
    }

    /* renamed from: c */
    public static boolean m4062c(String str) {
        if (!C1468c.m4056a(str)) {
            throw new C0010a("path is null");
        } else if (C1468c.m4064d(str)) {
            try {
                return new File(str).canRead();
            } catch (Exception e) {
                throw new C0010a("cannot read zip file");
            }
        } else {
            throw new C0010a(new StringBuffer("file does not exist: ").append(str).toString());
        }
    }

    /* renamed from: d */
    public static int m4063d(byte[] bArr, int i) {
        return ((bArr[0] & 255) | ((bArr[1] & 255) << 8)) | (((bArr[2] & 255) | ((bArr[3] & 255) << 8)) << 16);
    }

    /* renamed from: d */
    public static boolean m4064d(String str) {
        if (C1468c.m4056a(str)) {
            return C1468c.m4055a(new File(str));
        }
        throw new C0010a("path is null");
    }

    /* renamed from: e */
    public static void m4065e(byte[] bArr, int i) {
        bArr[0] = (byte) i;
        bArr[1] = (byte) (i >> 8);
        bArr[2] = (byte) (i >> 16);
        bArr[3] = i >> 24;
        bArr[4] = (byte) 0;
        bArr[5] = (byte) 0;
        bArr[6] = (byte) 0;
        bArr[7] = (byte) 0;
        bArr[8] = (byte) 0;
        bArr[9] = (byte) 0;
        bArr[10] = (byte) 0;
        bArr[11] = (byte) 0;
        bArr[12] = (byte) 0;
        bArr[13] = (byte) 0;
        bArr[14] = (byte) 0;
        bArr[15] = (byte) 0;
    }
}
