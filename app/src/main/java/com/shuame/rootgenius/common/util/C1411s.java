package com.shuame.rootgenius.common.util;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.shuame.rootgenius.common.util.s */
public class C1411s {
    /* renamed from: a */
    private static final String f3898a = C1411s.class.getSimpleName();
    /* renamed from: b */
    private static boolean f3899b = false;
    /* renamed from: c */
    private static boolean f3900c = false;
    /* renamed from: d */
    private static List<C1410a> f3901d = new ArrayList();

    /* renamed from: com.shuame.rootgenius.common.util.s$a */
    private static class C1410a {
        /* renamed from: a */
        public String f3896a;
        /* renamed from: b */
        public boolean f3897b;

        private C1410a() {
        }
    }

    /* renamed from: a */
    public static long m3922a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Object a = C1411s.m3923a(false);
            Object b = C1411s.m3928b(false);
            String b2 = C1411s.m3927b();
            if (TextUtils.isEmpty(a) || !str.startsWith(a)) {
                if (TextUtils.isEmpty(b) || !str.startsWith(b)) {
                    String a2 = b2;
                } else {
                    a2 = b;
                }
            }
            if (!TextUtils.isEmpty(a2)) {
                StatFs statFs = new StatFs(a2);
                return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static synchronized String m3923a(boolean z) {
        String a;
        synchronized (C1411s.class) {
            a = C1411s.m3924a(true, z);
        }
        return a;
    }

    /* renamed from: a */
    private static String m3924a(boolean z, boolean z2) {
        String str;
        for (C1410a c1410a : f3901d) {
            if (!z || !c1410a.f3897b) {
                if (!z && !c1410a.f3897b) {
                    str = c1410a.f3896a;
                    break;
                }
            } else {
                str = c1410a.f3896a;
                break;
            }
        }
        str = null;
        new StringBuilder("getSdcardPath sdcardPath:").append(str).append(";isInternal:").append(z).append(";useFallback:").append(z2);
        return (z2 && TextUtils.isEmpty(str)) ? C1411s.m3927b() : str;
    }

    /* renamed from: a */
    public static boolean m3925a() {
        CharSequence b = C1411s.m3928b(true);
        if (TextUtils.isEmpty(b)) {
            b = C1411s.m3923a(true);
        }
        return !TextUtils.isEmpty(b);
    }

    /* renamed from: b */
    public static long m3926b(String str) {
        long availableBlocks;
        if (!TextUtils.isEmpty(str)) {
            Object a = C1411s.m3923a(false);
            Object b = C1411s.m3928b(false);
            String b2 = C1411s.m3927b();
            if (TextUtils.isEmpty(a) || TextUtils.isEmpty(b) || b.length() <= a.length()) {
                Object obj = b;
                b = a;
                a = obj;
            }
            if (TextUtils.isEmpty(b) || !str.startsWith(b)) {
                if (TextUtils.isEmpty(a) || !str.startsWith(a)) {
                    String str2 = b2;
                } else {
                    b = a;
                }
            }
            if (!TextUtils.isEmpty(b)) {
                StatFs statFs = new StatFs(b);
                availableBlocks = (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) - 5242880;
                if (availableBlocks < 0) {
                    availableBlocks = 0;
                }
                new StringBuilder("SdcardAvailableSize:").append((availableBlocks / 1024) / 1024).append("M");
                return availableBlocks;
            }
        }
        availableBlocks = -1;
        new StringBuilder("SdcardAvailableSize:").append((availableBlocks / 1024) / 1024).append("M");
        return availableBlocks;
    }

    /* renamed from: b */
    private static String m3927b() {
        return Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory().getAbsolutePath() : null;
    }

    /* renamed from: b */
    public static synchronized String m3928b(boolean z) {
        String a;
        synchronized (C1411s.class) {
            a = C1411s.m3924a(false, z);
        }
        return a;
    }
}
