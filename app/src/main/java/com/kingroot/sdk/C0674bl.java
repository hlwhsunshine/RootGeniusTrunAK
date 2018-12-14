package com.kingroot.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.p013pm.PackageManager;
import android.content.p013pm.PackageManager.NameNotFoundException;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import com.kingroot.sdk.C0692by.C0672b;
import com.kingroot.sdk.util.Posix;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import krsdk.RootShell;
import krsdk.RootShell.ShellResult;

/* renamed from: com.kingroot.sdk.bl */
public class C0674bl {
    /* renamed from: a */
    public static void m1599a(final String str, final String str2, C0692by c0692by) {
        List arrayList = new ArrayList();
        arrayList.add(new C0672b() {
            public final String getLocalName() {
                return str2;
            }

            public final String getUrl() {
                return str;
            }
        });
        c0692by.mo5666g(arrayList);
    }

    /* renamed from: a */
    public static boolean m1600a(Context context, ApplicationInfo applicationInfo) {
        if (applicationInfo == null) {
            return false;
        }
        RootShell ae = C0674bl.m1601ae();
        if (ae == null) {
            return false;
        }
        try {
            String str = applicationInfo.sourceDir;
            String str2 = str.subSequence(0, str.length() - 3) + "odex";
            List arrayList = new ArrayList(5);
            arrayList.add(C0821fm.f2063jl);
            arrayList.add("rm -r " + str);
            arrayList.add("rm -r " + str2);
            arrayList.add("pm uninstall " + applicationInfo.packageName);
            List executeCommand2 = ae.executeCommand2(arrayList);
            if (executeCommand2 != null && executeCommand2.size() == arrayList.size()) {
                ShellResult shellResult = (ShellResult) executeCommand2.get(0);
                if (shellResult != null && shellResult.success()) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: ae */
    public static RootShell m1601ae() {
        return C0659bf.m1548c(true);
    }

    /* renamed from: h */
    public static boolean m1602h(Context context, String str) {
        C0633at.m1464h("installApk:" + str);
        if (str == null) {
            return false;
        }
        try {
            int lastIndexOf = str.lastIndexOf(File.separator);
            if (lastIndexOf > 0) {
                String substring = str.substring(0, lastIndexOf);
                C0659bf.m1549z("chmod 0777 " + substring);
                Posix.chmod(substring, 511);
            }
            C0659bf.m1549z("chmod 0777 " + str);
            Posix.chmod(str, 511);
        } catch (Throwable e) {
            C0633at.m1464h("installApk: exception" + e.getMessage());
            C0633at.m1459a(e);
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        context.startActivity(intent);
        return true;
    }

    /* renamed from: i */
    public static boolean m1603i(Context context, String str) {
        if (str == null) {
            return false;
        }
        try {
            RootShell ae = C0674bl.m1601ae();
            if (ae == null) {
                return false;
            }
            int lastIndexOf = str.lastIndexOf(File.separator);
            if (lastIndexOf > 0) {
                String substring = str.substring(0, lastIndexOf);
                ae.executeCommand("chmod 0777 " + substring);
                Posix.chmod(substring, 511);
            }
            ae.executeCommand("chmod 0777 " + str);
            Posix.chmod(str, 511);
            ShellResult executeCommand2 = ae.executeCommand2("pm install -r " + str);
            ae.executeCommand("rm -r " + str);
            return executeCommand2.success();
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: j */
    public static int m1604j(Context context, String str) {
        if (str == null) {
            return 2;
        }
        RootShell ae = C0674bl.m1601ae();
        if (ae == null) {
            return 2;
        }
        try {
            ShellResult shellResult;
            List arrayList = new ArrayList(5);
            arrayList.add("ls -l " + str);
            List executeCommand2 = ae.executeCommand2(arrayList);
            if (executeCommand2 != null && executeCommand2.size() == arrayList.size()) {
                shellResult = (ShellResult) executeCommand2.get(arrayList.size() - 1);
                if (shellResult != null && shellResult.ret == 1) {
                    return 0;
                }
            }
            arrayList.clear();
            if (str.startsWith("/system")) {
                arrayList.add(C0821fm.f2063jl);
            }
            arrayList.add("rm -r " + str);
            arrayList.add("ls -l " + str);
            executeCommand2 = ae.executeCommand2(arrayList);
            if (executeCommand2 != null && executeCommand2.size() == arrayList.size()) {
                shellResult = (ShellResult) executeCommand2.get(arrayList.size() - 1);
                if (shellResult != null && shellResult.ret == 1) {
                    return 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    /* renamed from: k */
    public static boolean m1605k(Context context, String str) {
        if (str == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.DELETE", Uri.parse("package:" + str));
        intent.addFlags(268435456);
        context.startActivity(intent);
        return true;
    }

    /* renamed from: l */
    public static boolean m1606l(Context context, String str) {
        if (str == null) {
            return false;
        }
        RootShell ae = C0674bl.m1601ae();
        if (ae == null) {
            return false;
        }
        try {
            ShellResult executeCommand2 = ae.executeCommand2("service call activity 79 s16 " + str);
            return executeCommand2 != null && executeCommand2.success();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: m */
    public static ApplicationInfo m1607m(Context context, String str) {
        try {
            Context context2 = C0741dg.m1804aL().f1805el;
            if (context2 == null) {
                return null;
            }
            PackageManager packageManager = context2.getPackageManager();
            return packageManager != null ? packageManager.getApplicationInfo(str, 0) : null;
        } catch (NameNotFoundException e) {
            return null;
        }
    }
}
