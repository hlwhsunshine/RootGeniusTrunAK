package com.kingroot.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;
import krsdk.RootShell;

/* renamed from: com.kingroot.sdk.cm */
public final class C0708cm {
    /* renamed from: F */
    public static File m1697F(String str) {
        return C0708cm.m1700k(str, "0771");
    }

    /* renamed from: an */
    public static File m1698an() {
        Context context = C0741dg.m1804aL().f1805el;
        if (context == null) {
            return new File("");
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String str = applicationInfo.dataDir;
        File file = new File(str);
        if (file.canRead() && file.canWrite()) {
            return file;
        }
        RootShell c = C0659bf.m1548c(true);
        if (c != null) {
            c.executeCommand("mkdir " + str);
            c.executeCommand("chmod 0751 " + str);
            c.executeCommand("chown " + applicationInfo.uid + "." + applicationInfo.uid + " " + str);
        }
        return new File(str);
    }

    /* renamed from: ao */
    public static File m1699ao() {
        return C0708cm.m1697F("applib");
    }

    /* renamed from: k */
    public static File m1700k(String str, String str2) {
        File file = new File(C0708cm.m1698an(), str);
        if (!file.exists()) {
            Context context = C0741dg.m1804aL().f1805el;
            if (context != null) {
                File dir = context.getDir(str + "temp", 0);
                if (dir.exists() && !dir.renameTo(file)) {
                    dir.delete();
                }
                file = new File(C0708cm.m1698an(), str);
                if (!file.exists()) {
                    file.mkdirs();
                    file = new File(C0708cm.m1698an(), str);
                    if (!file.exists()) {
                        context.getFilesDir();
                        file.mkdirs();
                        file = new File(C0708cm.m1698an(), str);
                    }
                }
                try {
                    C0659bf.m1546Y().mo5855c("chmod " + str2 + " " + file.getAbsolutePath(), 120000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }
}
