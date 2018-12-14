package com.kingroot.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.text.TextUtils;
import com.kingroot.sdk.C0831fu.C0795a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kingroot.sdk.fw */
public class C0834fw {
    /* renamed from: jy */
    private static C0823fo f2082jy = null;

    /* renamed from: a */
    public static void m2131a(C0716ga c0716ga, Context context, String str, String str2, AssetManager assetManager, C0714fy c0714fy, String str3) {
        if (f2082jy == null) {
            f2082jy = new C0823fo();
        }
        f2082jy.mo5820a(context, str, str2, c0714fy, str3);
        try {
            C0834fw.m2133a(c0716ga, context, C0822fn.m2081bP(), C0818fj.m2075bL().getAbsolutePath(), true, true, assetManager);
            if (C0826fr.m2103bY() && !C0834fw.m2135a(c0716ga, context, new StringBuilder(String.valueOf(C0818fj.m2075bL().getAbsolutePath())).append(File.separator).append(C0822fn.m2081bP()).toString())) {
                C0825fq.m2099g("KuSdkInit", "init|copyExecutableFileToDataLibDir...fail");
            }
        } catch (Throwable e) {
            C0825fq.m2096a(e);
        }
    }

    /* renamed from: a */
    public static void m2132a(C0716ga c0716ga, Context context, String str, String str2, C0714fy c0714fy, String str3) {
        C0834fw.m2131a(c0716ga, context, str, str2, null, c0714fy, str3);
    }

    /* renamed from: a */
    private static void m2133a(C0716ga c0716ga, Context context, String str, String str2, boolean z, boolean z2, AssetManager assetManager) {
        C0825fq.m2099g("KuSdkInit", "RootExecutorFactory.extractFileToWorkDir()");
        if (assetManager == null) {
            assetManager = context.getAssets();
        }
        if (C0840gd.m2169a(assetManager, str, str2)) {
            if (z) {
                C0840gd.m2172b(assetManager, str, str2);
            } else {
                C0840gd.m2167a(assetManager, str, new File(str2, str));
            }
            C0825fq.m2099g("KuSdkInit", "Extract: finished.");
        } else {
            C0825fq.m2099g("KuSdkInit", "Extract: no changed.");
        }
        if (z2) {
            c0716ga.mo5683K("chmod 0764 " + new File(str2, str).getAbsolutePath());
        }
    }

    /* renamed from: a */
    public static void m2134a(C0716ga c0716ga, Boolean bool) {
        if (c0716ga != null && C0834fw.m2136cc()) {
            new C0816fh(c0716ga).mo5818b(true, bool.booleanValue());
        }
    }

    @TargetApi(9)
    /* renamed from: a */
    private static boolean m2135a(C0716ga c0716ga, Context context, String str) {
        String stringBuilder = new StringBuilder(String.valueOf(Environment.getDataDirectory().getAbsolutePath())).append(File.separator).append("data-lib").append(File.separator).append(context.getPackageName()).toString();
        File file = new File(str);
        final File file2 = new File(new StringBuilder(String.valueOf(stringBuilder)).append(File.separator).append(file.getName()).toString());
        final String g = C0840gd.m2176g(file);
        String g2 = C0840gd.m2176g(file2);
        if (!TextUtils.isEmpty(g) && g.equals(g2)) {
            try {
                if (file2.canExecute()) {
                    return true;
                }
            } catch (Exception e) {
            }
        }
        return ((Boolean) C0831fu.m2119a(c0716ga, new C0795a<Boolean>() {
            /* renamed from: a */
            public Boolean mo5806b(C0716ga c0716ga, List<Object> list) {
                boolean z = false;
                String str = (String) list.get(0);
                String str2 = (String) list.get(1);
                if (c0716ga.mo5684f(true)) {
                    List arrayList = new ArrayList(8);
                    if (str2.length() > 1 && str2.endsWith(File.separator)) {
                        str2 = str2.substring(0, str2.length() - 1);
                    }
                    int i = 0;
                    while (true) {
                        i = str2.indexOf(File.separatorChar, i + 1);
                        if (i == -1) {
                            break;
                        }
                        File file = new File(str2.substring(0, i));
                        if (!file.getAbsolutePath().equals("/data")) {
                            if (!file.exists()) {
                                arrayList.add("mkdir " + file.getAbsolutePath());
                                arrayList.add("chown 0.0 " + file.getAbsolutePath());
                                arrayList.add("chmod 0755 " + file.getAbsolutePath());
                                arrayList.add("chcon u:object_r:system_data_file:s0 " + file.getAbsolutePath());
                            } else if (file.isDirectory()) {
                                arrayList.add("chmod 0755 " + file.getAbsolutePath());
                                arrayList.add("chcon u:object_r:system_data_file:s0 " + file.getAbsolutePath());
                            } else {
                                arrayList.add("rm " + file.getAbsolutePath());
                                arrayList.add("mkdir " + file.getAbsolutePath());
                                arrayList.add("chown 0.0 " + file.getAbsolutePath());
                                arrayList.add("chmod 0755 " + file.getAbsolutePath());
                                arrayList.add("chcon u:object_r:system_data_file:s0 " + file.getAbsolutePath());
                            }
                        }
                    }
                    arrayList.add("rm " + str2);
                    arrayList.add(String.format("cat %s > %s", new Object[]{str, str2}));
                    arrayList.add("chown 0.0 " + str2);
                    arrayList.add("chmod 0755 " + str2);
                    arrayList.add("chcon u:object_r:system_file:s0 " + str2);
                    str = C0840gd.m2176g(file2);
                    if (!TextUtils.isEmpty(g) && g.equals(str)) {
                        try {
                            if (file2.canExecute()) {
                                z = true;
                            }
                        } catch (Exception e) {
                            z = true;
                        }
                    }
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        }, str, stringBuilder)).booleanValue();
    }

    /* renamed from: cc */
    private static boolean m2136cc() {
        if (f2082jy == null) {
            C0825fq.m2099g("KuSdkInit", "hasInitOk|sKuSdkConfig...null");
            return false;
        } else if (C0823fo.m2083bR() != null) {
            return true;
        } else {
            C0825fq.m2099g("KuSdkInit", "hasInitOk|KuSdkConfig.getSdkContext()...null");
            return false;
        }
    }

    /* renamed from: h */
    public static boolean m2137h(C0716ga c0716ga) {
        if (c0716ga == null) {
            C0825fq.m2099g("KuSdkInit", "installSync|rootShell is null");
            return false;
        } else if (!C0834fw.m2136cc()) {
            return false;
        } else {
            if (!c0716ga.mo5684f(true)) {
                C0825fq.m2099g("KuSdkInit", "installSync|no root perm");
                return false;
            } else if (TextUtils.isEmpty(C0823fo.m2084bS()) || !new File(C0823fo.m2084bS()).exists()) {
                C0825fq.m2099g("KuSdkInit", "installSync|KuSdkConfig.getNewSuPath()...null");
                return false;
            } else if (TextUtils.isEmpty(C0823fo.m2085bT()) || !new File(C0823fo.m2085bT()).exists()) {
                C0825fq.m2099g("KuSdkInit", "installSync|KuSdkConfig.getNewSupolicyPath()...null");
                return false;
            } else {
                if (C0823fo.m2086bU() == null) {
                    C0825fq.m2099g("KuSdkInit", "installSync|KuSdkConfig.getEncoder()...null");
                }
                if (C0794eu.m1986a(c0716ga, null, null)) {
                    return true;
                }
                C0825fq.m2099g("KuSdkInit", "installSync|CheckExecutor.checkSync...fail!");
                return false;
            }
        }
    }

    /* renamed from: l */
    public static boolean m2138l(C0716ga c0716ga, String str) {
        if (c0716ga == null) {
            C0825fq.m2099g("KuSdkInit", "installSync|rootShell is null");
            return false;
        } else if (!C0834fw.m2136cc()) {
            return false;
        } else {
            C0825fq.m2099g("KuSdkInit", "installSync|kuApkPath..." + str);
            if (TextUtils.isEmpty(str)) {
                C0825fq.m2099g("KuSdkInit", "installSync|kuApkPath is null");
                return false;
            } else if (!c0716ga.mo5684f(true)) {
                C0825fq.m2099g("KuSdkInit", "installSync|no root perm");
                return false;
            } else if (C0823fo.m2084bS() == null) {
                C0825fq.m2099g("KuSdkInit", "installSync|KuSdkConfig.getNewSuPath()...null");
                return false;
            } else if (C0823fo.m2085bT() == null) {
                C0825fq.m2099g("KuSdkInit", "installSync|KuSdkConfig.getNewSupolicyPath()...null");
                return false;
            } else {
                if (C0823fo.m2086bU() == null) {
                    C0825fq.m2099g("KuSdkInit", "installSync|KuSdkConfig.getEncoder()...null");
                }
                if (C0794eu.m1986a(c0716ga, null, null)) {
                    C0835fx c0835fx = new C0835fx(c0716ga);
                    int a = c0835fx.mo5833a(C0823fo.m2083bR(), true, false, str);
                    if (a == 0) {
                        return c0835fx.mo5836cd();
                    }
                    C0825fq.m2099g("KuSdkInit", "installSync|kuInstaller.installKU...install ret:" + a);
                    return false;
                }
                C0825fq.m2099g("KuSdkInit", "installSync|CheckExecutor.checkSync...fail!");
                return false;
            }
        }
    }
}
