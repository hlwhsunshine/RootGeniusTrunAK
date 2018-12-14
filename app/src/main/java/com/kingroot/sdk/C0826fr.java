package com.kingroot.sdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* renamed from: com.kingroot.sdk.fr */
public class C0826fr {
    /* renamed from: jr */
    private static Boolean f2071jr = null;
    /* renamed from: js */
    private static final Object f2072js = new Object();

    /* renamed from: bY */
    public static boolean m2103bY() {
        boolean z = false;
        synchronized (f2072js) {
            if (f2071jr == null) {
                Boolean bool;
                if (C0846gi.m2195I() < 17 || !new File("/sys/fs/selinux/enforce").exists()) {
                    bool = null;
                } else {
                    InputStream fileInputStream;
                    try {
                        fileInputStream = new FileInputStream("/sys/fs/selinux/enforce");
                        if (fileInputStream.read() == 49) {
                            z = true;
                        }
                        bool = Boolean.valueOf(z);
                        try {
                            fileInputStream.close();
                        } catch (Exception e) {
                        }
                    } catch (Exception e2) {
                        bool = null;
                    } catch (Throwable th) {
                        fileInputStream.close();
                    }
                }
                if (bool == null) {
                    bool = Boolean.valueOf(false);
                }
                f2071jr = bool;
            }
            z = f2071jr.booleanValue();
        }
        return z;
    }
}
