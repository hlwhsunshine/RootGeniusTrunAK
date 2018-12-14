package com.shuame.rootgenius.common.util;

import android.content.Context;
import android.content.Intent;
import android.content.p013pm.PackageManager;
import android.content.p013pm.PackageManager.NameNotFoundException;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.shuame.mobile.sdk.impl.utils.ShellUtils;
import java.io.File;

/* renamed from: com.shuame.rootgenius.common.util.a */
public class C1383a {
    /* renamed from: a */
    private static final String f3853a = C1383a.class.getSimpleName();

    /* renamed from: a */
    public static int m3855a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        String execSuCmd = ShellUtils.execSuCmd("LD_LIBRARY_PATH=/vendor/lib:/system/lib pm uninstall " + str, 60000);
        return (execSuCmd.contains("Success") || execSuCmd.contains("success")) ? 1 : execSuCmd.contains("Create su process failed!") ? -3 : -1;
    }

    /* renamed from: a */
    public static int m3856a(String str, String str2) {
        long j = 10000;
        if (TextUtils.isEmpty(str)) {
            return -3;
        }
        File file = new File(str);
        if (!file.exists()) {
            return -3;
        }
        long length = (long) (((double) file.length()) * 0.0095367431640625d);
        if (length >= 10000) {
            j = length;
        }
        String str3 = "-r ";
        if (!TextUtils.isEmpty(str2)) {
            str3 = str3 + str2;
        }
        str3 = "LD_LIBRARY_PATH=/vendor/lib:/system/lib pm install " + str3 + " " + str;
        new StringBuilder("silentInstall cmd:").append(str3).append(";timeout:").append(j);
        String execBlockSuCmd = (Build.BRAND.equals("vivo") && Build.MODEL.equals("vivo S7")) ? ShellUtils.execBlockSuCmd(str3) : ShellUtils.execSuCmd(str3, j);
        return (execBlockSuCmd.contains("Success") || execBlockSuCmd.contains("success")) ? 1 : execBlockSuCmd.contains("INSTALL_FAILED_ALREADY_EXISTS") ? -1 : execBlockSuCmd.contains("INSTALL_FAILED_INVALID_APK") ? -2 : execBlockSuCmd.contains("INSTALL_FAILED_INVALID_URI") ? -3 : execBlockSuCmd.contains("INSTALL_FAILED_INSUFFICIENT_STORAGE") ? -4 : execBlockSuCmd.contains("INSTALL_FAILED_DUPLICATE_PACKAGE") ? -5 : execBlockSuCmd.contains("INSTALL_FAILED_NO_SHARED_USER") ? -6 : execBlockSuCmd.contains("INSTALL_FAILED_UPDATE_INCOMPATIBLE") ? -7 : execBlockSuCmd.contains("INSTALL_FAILED_SHARED_USER_INCOMPATIBLE") ? -8 : execBlockSuCmd.contains("INSTALL_FAILED_MISSING_SHARED_LIBRARY") ? -9 : execBlockSuCmd.contains("INSTALL_FAILED_REPLACE_COULDNT_DELETE") ? -10 : execBlockSuCmd.contains("INSTALL_FAILED_DEXOPT") ? -11 : execBlockSuCmd.contains("INSTALL_FAILED_OLDER_SDK") ? -12 : execBlockSuCmd.contains("INSTALL_FAILED_CONFLICTING_PROVIDER") ? -13 : execBlockSuCmd.contains("INSTALL_FAILED_NEWER_SDK") ? -14 : execBlockSuCmd.contains("INSTALL_FAILED_TEST_ONLY") ? -15 : execBlockSuCmd.contains("INSTALL_FAILED_CPU_ABI_INCOMPATIBLE") ? -16 : execBlockSuCmd.contains("INSTALL_FAILED_MISSING_FEATURE") ? -17 : execBlockSuCmd.contains("INSTALL_FAILED_CONTAINER_ERROR") ? -18 : execBlockSuCmd.contains("INSTALL_FAILED_INVALID_INSTALL_LOCATION") ? -19 : execBlockSuCmd.contains("INSTALL_FAILED_MEDIA_UNAVAILABLE") ? -20 : execBlockSuCmd.contains("INSTALL_FAILED_VERIFICATION_TIMEOUT") ? -21 : execBlockSuCmd.contains("INSTALL_FAILED_VERIFICATION_FAILURE") ? -22 : execBlockSuCmd.contains("INSTALL_FAILED_PACKAGE_CHANGED") ? -23 : execBlockSuCmd.contains("INSTALL_FAILED_UID_CHANGED") ? -24 : execBlockSuCmd.contains("INSTALL_PARSE_FAILED_NOT_APK") ? -100 : execBlockSuCmd.contains("INSTALL_PARSE_FAILED_BAD_MANIFEST") ? PackageManager.INSTALL_PARSE_FAILED_BAD_MANIFEST : execBlockSuCmd.contains("INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION") ? PackageManager.INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION : execBlockSuCmd.contains("INSTALL_PARSE_FAILED_NO_CERTIFICATES") ? PackageManager.INSTALL_PARSE_FAILED_NO_CERTIFICATES : execBlockSuCmd.contains("INSTALL_PARSE_FAILED_INCONSISTENT_CERTIFICATES") ? PackageManager.INSTALL_PARSE_FAILED_INCONSISTENT_CERTIFICATES : execBlockSuCmd.contains("INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING") ? PackageManager.INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING : execBlockSuCmd.contains("INSTALL_PARSE_FAILED_BAD_PACKAGE_NAME") ? PackageManager.INSTALL_PARSE_FAILED_BAD_PACKAGE_NAME : execBlockSuCmd.contains("INSTALL_PARSE_FAILED_BAD_SHARED_USER_ID") ? PackageManager.INSTALL_PARSE_FAILED_BAD_SHARED_USER_ID : execBlockSuCmd.contains("INSTALL_PARSE_FAILED_MANIFEST_MALFORMED") ? PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED : execBlockSuCmd.contains("INSTALL_PARSE_FAILED_MANIFEST_EMPTY") ? PackageManager.INSTALL_PARSE_FAILED_MANIFEST_EMPTY : execBlockSuCmd.contains("INSTALL_FAILED_INTERNAL_ERROR") ? PackageManager.INSTALL_FAILED_INTERNAL_ERROR : execBlockSuCmd.contains("INSTALL_FAILED_USER_RESTRICTED") ? PackageManager.INSTALL_FAILED_POLICY_REJECTED_PERMISSION : execBlockSuCmd.contains("Create su process failed!") ? -112 : -113;
    }

    /* renamed from: a */
    public static boolean m3857a(Context context) {
        boolean b = C1383a.m3859b(context);
        boolean z = !b ? ShellUtils.obtainRoot() == 1 : false;
        return b || z;
    }

    /* renamed from: a */
    public static boolean m3858a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        intent.addFlags(268435456);
        context.startActivity(intent);
        return true;
    }

    /* renamed from: b */
    private static boolean m3859b(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            return applicationInfo != null && (applicationInfo.flags & 1) > 0;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m3860b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.DELETE", Uri.parse("package:" + str));
        intent.addFlags(268435456);
        context.startActivity(intent);
        return true;
    }
}
