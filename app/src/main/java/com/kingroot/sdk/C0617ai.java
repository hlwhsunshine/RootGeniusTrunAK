package com.kingroot.sdk;

import android.os.Environment;
import android.util.Log;
import com.kingroot.sdk.util.C0885e;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.kingroot.sdk.ai */
public class C0617ai {
    /* renamed from: aW */
    public static boolean f1510aW = true;
    /* renamed from: aX */
    private static BufferedWriter f1511aX;
    /* renamed from: aY */
    private static SimpleDateFormat f1512aY = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    /* renamed from: a */
    private static void m1378a(String str, String str2) {
        if (f1511aX == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                if (externalStorageDirectory.exists()) {
                    try {
                        f1511aX = new BufferedWriter(new FileWriter(new File(externalStorageDirectory, "reportroot_debug.txt")));
                    } catch (IOException e) {
                        C0885e.m2419a(f1511aX);
                        f1511aX = null;
                    }
                } else {
                    return;
                }
            }
            return;
        }
        if (f1511aX != null) {
            try {
                f1511aX.append(f1512aY.format(new Date())).append(" ").append("[" + str + "]").append(" ").append(str2).append("\n");
                f1511aX.flush();
            } catch (Exception e2) {
                C0885e.m2419a(f1511aX);
                f1511aX = null;
            }
        }
    }

    /* renamed from: a */
    public static void m1379a(String str, Throwable th) {
        if (f1510aW) {
            C0617ai.m1378a("e", str + "\n" + Log.getStackTraceString(th));
        }
    }

    /* renamed from: g */
    public static void m1380g(String str) {
        if (f1510aW) {
            C0617ai.m1378a("i", str);
        }
    }

    /* renamed from: h */
    public static void m1381h(String str) {
        if (f1510aW) {
            C0617ai.m1378a("d", str);
        }
    }

    /* renamed from: i */
    public static void m1382i(String str) {
        if (f1510aW) {
            C0617ai.m1378a("e", str);
        }
    }
}
