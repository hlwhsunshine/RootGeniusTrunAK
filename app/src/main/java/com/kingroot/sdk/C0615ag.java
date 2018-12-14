package com.kingroot.sdk;

import android.content.Context;
import com.kingroot.sdk.util.C0885e;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;

/* renamed from: com.kingroot.sdk.ag */
public class C0615ag {
    /* renamed from: aU */
    private static boolean f1508aU = false;
    /* renamed from: aV */
    private static boolean f1509aV = false;

    /* renamed from: g */
    public static String m1371g(Context context) {
        return context.getPackageName();
    }

    /* renamed from: l */
    public static boolean m1372l() {
        return true;
    }

    /* renamed from: m */
    public static synchronized boolean m1373m() {
        boolean z = true;
        synchronized (C0615ag.class) {
            if (!f1508aU) {
                if (C0634au.m1468I() >= 17) {
                    File file = new File("/sys/fs/selinux/enforce");
                    if (file.exists()) {
                        try {
                            Closeable fileInputStream = new FileInputStream(file);
                            try {
                                if (fileInputStream.read() != 49) {
                                    z = false;
                                }
                                f1509aV = z;
                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                C0885e.m2419a(fileInputStream);
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                f1508aU = true;
            }
            z = f1509aV;
        }
        return z;
    }
}
