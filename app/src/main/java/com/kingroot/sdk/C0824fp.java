package com.kingroot.sdk;

import android.content.p013pm.PackageInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kingroot.sdk.fp */
public class C0824fp {
    /* renamed from: ji */
    private C0716ga f2070ji = null;

    public C0824fp(C0716ga c0716ga) {
        this.f2070ji = c0716ga;
    }

    /* renamed from: a */
    private void m2089a(List<String> list, String str, File file) {
        if (!TextUtils.isEmpty(str)) {
            List arrayList = new ArrayList();
            arrayList.add(str);
            m2090a((List) list, arrayList, file);
        }
    }

    /* renamed from: a */
    private void m2090a(List<String> list, List<String> list2, File file) {
        if (list != null && file != null && file.isFile()) {
            PackageInfo ai = mo5823ai(file.getAbsolutePath());
            if (ai != null) {
                C0825fq.m2099g("KuSdkDetector", "getApkWhitPkgNameList(), apkName: " + file.getName() + " ,packageName:" + ai.packageName + " ,versionCode:" + ai.versionCode + " ,versionName:" + ai.versionName);
                for (String equals : list2) {
                    if (ai.packageName.equals(equals)) {
                        list.add(file.getAbsolutePath());
                        CharSequence q = m2091q(file.getParent(), file.getName());
                        if (!TextUtils.isEmpty(q)) {
                            list.add(q);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: q */
    private String m2091q(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str2.substring(0, str2.length() - 4) + ".odex";
        String stringBuilder = new StringBuilder(String.valueOf(str)).append(File.separator).append(str3).toString();
        File file = new File(stringBuilder);
        if (file.exists() && file.isFile()) {
            return stringBuilder;
        }
        if (VERSION.SDK_INT >= 20) {
            stringBuilder = new StringBuilder(String.valueOf(str)).append(File.separator).append("arm").append(File.separator).append(str3).toString();
            File file2 = new File(stringBuilder);
            if (file2.exists() && file2.isFile()) {
                return stringBuilder;
            }
        }
        return null;
    }

    /* renamed from: a */
    public List<String> mo5821a(String str, FileFilter fileFilter) {
        List arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            C0825fq.m2099g("KuSdkDetector", "lookupApkWhitPkgName(" + str + ")");
            try {
                for (File file : new File("/system/app").listFiles(fileFilter)) {
                    if (file.isFile()) {
                        m2089a(arrayList, str, file);
                    } else if (VERSION.SDK_INT >= 20) {
                        for (File file2 : file.listFiles(fileFilter)) {
                            if (file2.isFile()) {
                                m2089a(arrayList, str, file2);
                            }
                        }
                    }
                }
            } catch (Throwable e) {
                C0825fq.m2096a(e);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public List<String> mo5822a(List<String> list, FileFilter fileFilter) {
        List arrayList = new ArrayList();
        if (!(list == null || list.size() == 0)) {
            try {
                for (File file : new File("/system/app").listFiles(fileFilter)) {
                    if (file.isFile()) {
                        m2090a(arrayList, (List) list, file);
                    } else if (VERSION.SDK_INT >= 20) {
                        for (File file2 : file.listFiles(fileFilter)) {
                            if (file2.isFile()) {
                                m2090a(arrayList, (List) list, file2);
                            }
                        }
                    }
                }
            } catch (Throwable e) {
                C0825fq.m2096a(e);
            }
        }
        return arrayList;
    }

    /* renamed from: ai */
    protected PackageInfo mo5823ai(String str) {
        PackageInfo packageInfo = null;
        try {
            return C0843gg.m2186cf().getPackageArchiveInfo(str, 1);
        } catch (Throwable e) {
            C0825fq.m2096a(e);
            return packageInfo;
        }
    }

    /* renamed from: bW */
    public List<String> mo5824bW() {
        return mo5821a("com.kingroot.kinguser", new C0817fi());
    }
}
