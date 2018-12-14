package com.kingroot.sdk;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.io.File;

/* renamed from: com.kingroot.sdk.fj */
public final class C0818fj {
    /* renamed from: an */
    public static File m2073an() {
        return new File(C0823fo.m2083bR().getApplicationInfo().dataDir);
    }

    /* renamed from: b */
    public static File m2074b(File file, String str) {
        File file2 = new File(file, str);
        if (!file2.exists()) {
            Context bR = C0823fo.m2083bR();
            File dir = bR.getDir(new StringBuilder(String.valueOf(str)).append("temp").toString(), 0);
            if (dir.exists() && !dir.renameTo(file2)) {
                dir.delete();
            }
            file2 = new File(file, str);
            if (!file2.exists()) {
                file2.mkdirs();
                file2 = new File(file, str);
                if (!file2.exists()) {
                    bR.getFilesDir();
                    file2.mkdirs();
                    file2 = new File(file, str);
                }
            }
            C0827fs.m2109t(IXAdRequestInfo.SCREEN_HEIGHT, "chmod 0771 " + file2.getAbsolutePath());
        }
        return file2;
    }

    /* renamed from: bL */
    public static File m2075bL() {
        return C0818fj.m2074b(C0818fj.m2073an(), "sdkexec");
    }

    public static File getFilesDir() {
        return C0823fo.m2083bR().getFilesDir();
    }
}
