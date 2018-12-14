package com.shuame.rootgenius.common.util;

import android.os.Build.VERSION;
import com.shuame.mobile.utils.NativeUtils;
import java.io.File;

/* renamed from: com.shuame.rootgenius.common.util.w */
public final class C1415w {
    /* renamed from: a */
    private static final String[] f3905a = new String[]{"/system/bin/su", "/system/xbin/su", "/data/bin/su"};
    /* renamed from: b */
    private static String f3906b = "/system/bin/shuamesu";

    /* renamed from: a */
    public static String m3932a() {
        Object obj = null;
        if (VERSION.SDK_INT < 18 && new File(f3906b).exists() && NativeUtils.checkRootFileExecute(f3906b) == 0) {
            obj = 1;
        }
        return obj != null ? f3906b : null;
    }
}
