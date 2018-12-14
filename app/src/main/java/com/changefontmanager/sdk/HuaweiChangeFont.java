package com.changefontmanager.sdk;

import com.changefontmanager.sdk.utils.FileUtils;
import java.io.File;

public class HuaweiChangeFont {
    private static int OTHER = 5;
    /* renamed from: l */
    private static String f1131l = "/data/skin/fonts/Roboto-Regular.ttf";
    /* renamed from: m */
    private static String f1132m = "/data/skin/fonts/Roboto-Bold.ttf";
    /* renamed from: n */
    private static String f1133n = "/data/skin/fonts/DroidSansChinese.ttf";
    /* renamed from: o */
    private static int f1134o = 0;
    /* renamed from: p */
    private static int f1135p = 1;
    /* renamed from: q */
    private static int f1136q = 2;
    /* renamed from: r */
    private static int f1137r = 3;
    /* renamed from: s */
    private static int f1138s = 4;
    /* renamed from: t */
    private int f1139t;

    /* renamed from: a */
    private static int m919a() {
        return 0;
    }

    /* renamed from: a */
    public static boolean m920a(String str) {
        try {
            FileUtils.m966e(str, f1131l);
            FileUtils.m966e(str, f1132m);
            Runtime.getRuntime().exec("chmod 777 " + f1131l);
            Runtime.getRuntime().exec("chmod 777 " + f1132m);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    private static boolean m921b() {
        try {
            FileUtils.deleteFile(new File(f1131l));
            FileUtils.deleteFile(new File(f1132m));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m922b(String str) {
        try {
            FileUtils.m966e(str, f1133n);
            Runtime.getRuntime().exec("chmod 777 " + f1133n);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: c */
    private static boolean m923c() {
        try {
            FileUtils.deleteFile(new File(f1133n));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public final int mo5299a(String str, String str2) {
        boolean a = m920a(str2);
        boolean b = m922b(str);
        return (b && a) ? 1 : (!b || a) ? (b || !a) ? -1 : 4 : 3;
    }
}
