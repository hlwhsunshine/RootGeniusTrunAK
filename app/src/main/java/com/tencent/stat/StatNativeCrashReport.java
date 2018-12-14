package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.StatPreferences;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashSet;

public class StatNativeCrashReport {
    public static final String PRE_TAG_TOMBSTONE_FNAME = "tombstone_";
    /* renamed from: a */
    static StatNativeCrashReport f4857a = new StatNativeCrashReport();
    /* renamed from: b */
    private static StatLogger f4858b = StatCommonHelper.getLogger();
    /* renamed from: d */
    private static boolean f4859d;
    /* renamed from: e */
    private static boolean f4860e = false;
    /* renamed from: f */
    private static String f4861f = null;
    /* renamed from: g */
    private static boolean f4862g;
    /* renamed from: c */
    private volatile boolean f4863c = false;

    static {
        f4859d = false;
        f4862g = false;
        try {
            System.loadLibrary("MtaNativeCrash");
            f4862g = true;
        } catch (Throwable th) {
            f4859d = false;
            f4858b.mo7912w("if you do not need libMtaNativeCrash.so, Dont care!");
            f4858b.mo7912w("can't find libMtaNativeCrash.so, NativeCrash report disable.");
        }
    }

    /* renamed from: a */
    static String m4615a(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(readLine);
                stringBuilder.append(10);
            }
            bufferedReader.close();
        } catch (Throwable e) {
            f4858b.mo7900e(e);
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    static LinkedHashSet<File> m4616a(Context context) {
        LinkedHashSet<File> linkedHashSet = new LinkedHashSet();
        String tombstonesDir = getTombstonesDir(context);
        if (tombstonesDir != null) {
            File file = new File(tombstonesDir);
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (file2.getName().startsWith(PRE_TAG_TOMBSTONE_FNAME) && file2.isFile()) {
                            if (StatConfig.isDebugEnable()) {
                                f4858b.mo7897d("get tombstone file:" + file2.getAbsolutePath().toString());
                            }
                            linkedHashSet.add(file2.getAbsoluteFile());
                        }
                    }
                }
            }
        }
        return linkedHashSet;
    }

    /* renamed from: b */
    static long m4617b(File file) {
        long j = 0;
        try {
            return Long.valueOf(file.getName().replace(PRE_TAG_TOMBSTONE_FNAME, "")).longValue();
        } catch (Throwable e) {
            f4858b.mo7900e(e);
            return j;
        }
    }

    public static void doNativeCrashTest() {
        if (f4862g) {
            f4857a.makeJniCrash();
        } else {
            f4858b.mo7912w("libMtaNativeCrash.so not loaded.");
        }
    }

    public static String getTombstonesDir(Context context) {
        if (f4861f == null) {
            f4861f = StatPreferences.getString(context, "__mta_tombstone__", "");
        }
        return f4861f;
    }

    public static void initNativeCrash(Context context, String str) {
        if (!f4862g) {
            f4858b.mo7912w("libMtaNativeCrash.so not loaded.");
        } else if (!f4857a.f4863c) {
            if (str == null) {
                try {
                    str = context.getDir("tombstones", 0).getAbsolutePath();
                } catch (Throwable th) {
                    f4858b.mo7912w(th);
                    return;
                }
            }
            if (str.length() > 128) {
                f4858b.mo7899e("The length of tombstones dir: " + str + " can't exceeds 200 bytes.");
                return;
            }
            f4861f = str;
            StatPreferences.putString(context, "__mta_tombstone__", str);
            setNativeCrashEnable(true);
            f4857a.initJNICrash(str);
            f4857a.f4863c = true;
            if (StatConfig.isDebugEnable()) {
                f4858b.mo7897d("initNativeCrash success.");
            }
        }
    }

    public static boolean isNativeCrashDebugEnable() {
        return f4860e;
    }

    public static boolean isNativeCrashEnable() {
        return f4859d;
    }

    public static void onNativeCrashHappened(String str) {
        try {
            new RuntimeException("MTA has caught a native crash and dump log file path is:" + str + " java stack:\n").printStackTrace();
        } catch (Throwable e) {
            if (StatConfig.m4613e() != null) {
                StatConfig.m4613e().onMtaException(e);
            } else {
                f4858b.mo7900e(e);
            }
        }
    }

    public static void setNativeCrashDebugEnable(boolean z) {
        if (f4862g) {
            try {
                f4857a.enableNativeCrashDebug(z);
                f4860e = z;
                return;
            } catch (Throwable th) {
                f4858b.mo7912w(th);
                return;
            }
        }
        f4858b.mo7912w("libMtaNativeCrash.so not loaded.");
    }

    public static void setNativeCrashEnable(boolean z) {
        if (f4862g) {
            try {
                f4857a.enableNativeCrash(z);
                f4859d = z;
                return;
            } catch (Throwable th) {
                f4858b.mo7912w(th);
                return;
            }
        }
        f4858b.mo7912w("libMtaNativeCrash.so not loaded.");
    }

    public native void enableNativeCrash(boolean z);

    public native void enableNativeCrashDebug(boolean z);

    public native boolean initJNICrash(String str);

    public native String makeJniCrash();

    public native String stringFromJNI();
}
