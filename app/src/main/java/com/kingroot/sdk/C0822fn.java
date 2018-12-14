package com.kingroot.sdk;

import android.os.Environment;
import java.io.File;

/* renamed from: com.kingroot.sdk.fn */
public class C0822fn {
    /* renamed from: bP */
    public static String m2081bP() {
        return "ktools";
    }

    /* renamed from: bQ */
    public static String m2082bQ() {
        if (C0826fr.m2103bY()) {
            File file = new File(new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(Environment.getDataDirectory().getAbsolutePath())).append(File.separator).append("data-lib").append(File.separator).append(C0823fo.m2083bR().getPackageName()).toString())).append(File.separator).append("ktools").toString());
            if (file.exists()) {
                return file.getAbsolutePath();
            }
        }
        String stringBuilder = new StringBuilder(String.valueOf(C0818fj.m2075bL().getAbsolutePath())).append(File.separator).append("ktools").toString();
        if (new File(stringBuilder).exists()) {
            return stringBuilder;
        }
        C0825fq.m2102s("ktools", "KToolsMgr|getPublicFilePath|NO KTOOLS FOUND!");
        return "echo";
    }
}
