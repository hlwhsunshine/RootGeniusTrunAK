package com.shuame.rootgenius.sdk;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.shuame.rootgenius.sdk.g */
public final class C1472g {
    /* renamed from: a */
    private String f4062a;
    /* renamed from: b */
    private String[] f4063b = new String[]{"com.kingroot.kinguser", "com.qihoo.root", "com.noshufou.android.su", "eu.chainfire.supersu", "com.lbe.security.su", "com.lbe.security.shuame", "com.baidu.easyroot", "com.tencent.tcuser", "com.mgyun.shua.su", "co.lvdou.superuser", "com.koushikdutta.superuser", "com.qihoo.permmgr", "com.koushikdutta.superuser", "com.noshufou.android.su.elite", "com.aroot.asuperuser", "com.dianxinos.superuser"};

    public C1472g(String str) {
        this.f4062a = str;
    }

    /* renamed from: a */
    public final String mo7285a() {
        return CommUtils.execCmd(true, (((((("" + "mount -o rw,remount /system\n") + this.f4062a + "Data/Bin/busybox mount -o rw,remount /system\n") + mo7286a(null, false)) + this.f4062a + "Data/Bin/busybox chattr -ia /system/xbin/su\n") + this.f4062a + "Data/Bin/busybox rm /system/xbin/su\n") + this.f4062a + "Data/Bin/busybox chattr -ia /system/bin/su\n") + this.f4062a + "Data/Bin/busybox rm /system/bin/su\n", 10000);
    }

    /* renamed from: a */
    public final String mo7286a(String str, boolean z) {
        CharSequence execCmd = CommUtils.execCmd("pm list packages -f");
        String str2 = "";
        for (int i = 0; i < this.f4063b.length; i++) {
            C1473h.m4102a("sulist", "removeSuSuite sulist:" + this.f4063b[i]);
            String str3 = this.f4063b[i];
            if (str == null || !str3.equals(str)) {
                Matcher matcher = Pattern.compile("package\\s*:\\s*(.+\\.apk)=" + str3.replace(".", "\\.")).matcher(execCmd);
                if (matcher.find()) {
                    String group = matcher.group(1);
                    if (group.contains("/system/app/")) {
                        str2 = str2 + this.f4062a + "Data/Bin/busybox chattr -ia " + group + "\n" + this.f4062a + "Data/Bin/busybox rm " + group + "\n";
                    } else {
                        str2 = (str2 + this.f4062a + "Data/Bin/busybox chattr -ia " + group + "\n" + this.f4062a + "Data/Bin/busybox rm " + group + "\n") + "pm uninstall " + str3 + "\n";
                    }
                }
            }
        }
        str2 = (str2 + "chattr -ia /system/xbin/.suv\nrm /system/xbin/.suv\n") + "chattr -ia /system/bin/.suv\nrm /system/bin/.suv\n";
        if (z) {
            CommUtils.execCmd(true, str2, 10000);
        }
        return str2;
    }

    /* renamed from: a */
    public final void mo7287a(String[] strArr) {
        this.f4063b = strArr;
        for (String str : this.f4063b) {
            C1473h.m4102a("sulist", "setSuSuite sulist:" + str);
        }
    }
}
