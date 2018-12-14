package com.changefontmanager.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.p013pm.PackageInfo;
import android.content.p013pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;
import com.changefontmanager.sdk.utils.ActivityJumpController;
import com.example.myfontsdk.Font;
import java.util.List;

public class HTCChange implements IChangeFont {
    /* renamed from: a */
    private static int m916a(Context context, String str) {
        int i;
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 1);
        Object obj = null;
        if (packageArchiveInfo != null) {
            obj = packageArchiveInfo.applicationInfo.packageName;
            context.getSharedPreferences("pack", 0).edit().putString("name", obj).commit();
        }
        List installedPackages = packageManager.getInstalledPackages(0);
        PackageInfo[] packageInfoArr = new PackageInfo[installedPackages.size()];
        installedPackages.toArray(packageInfoArr);
        for (PackageInfo packageInfo : packageInfoArr) {
            if (packageInfo.packageName.equals(obj)) {
                i = 1;
                break;
            }
        }
        i = 0;
        if (i != 0) {
            ActivityJumpController.m950d(context);
            Toast.makeText(context, "安装成功，请选择“字体”相关选项设置字体", 1).show();
        } else {
            try {
                context.getSharedPreferences("pack", 0).edit().putString("name", context.getPackageManager().getPackageArchiveInfo(str, 1).packageName).commit();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setDataAndType(Uri.parse("file://" + str), "application/vnd.android.package-archive");
                context.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
        return 1;
    }

    /* renamed from: b */
    private static boolean m917b(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 1);
        Object obj = null;
        if (packageArchiveInfo != null) {
            obj = packageArchiveInfo.applicationInfo.packageName;
            context.getSharedPreferences("pack", 0).edit().putString("name", obj).commit();
        }
        List installedPackages = packageManager.getInstalledPackages(0);
        PackageInfo[] packageInfoArr = new PackageInfo[installedPackages.size()];
        installedPackages.toArray(packageInfoArr);
        for (PackageInfo packageInfo : packageInfoArr) {
            if (packageInfo.packageName.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public int changeFont(Context context, Font font) {
        String fontLocalPath = font.getFontLocalPath();
        font.getFontName();
        return m916a(context, fontLocalPath);
    }

    public void changeSuccessed(Context context) {
        ActivityJumpController.jumpToHtcSetting(context);
    }
}
