package com.shuame.rootgenius.appmanager.p095f;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.shuame.rootgenius.appmanager.p091b.C1254a;
import com.shuame.rootgenius.appmanager.p091b.C1259d;
import com.shuame.rootgenius.appmanager.p095f.C1272b.C1271a;
import com.shuame.rootgenius.appmanager.p096ui.activity.AppUninstallActivity;
import com.shuame.rootgenius.appmanager.p096ui.activity.RecycleBinActivity;
import com.shuame.rootgenius.common.p103d.C1326a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.shuame.rootgenius.appmanager.f.a */
public final class C1270a {
    /* renamed from: a */
    private static C1326a f3404a = new C1326a((byte) 0);

    /* renamed from: com.shuame.rootgenius.appmanager.f.a$a */
    public static class C1268a extends Thread {
        /* renamed from: a */
        private String f3395a;
        /* renamed from: b */
        private Handler f3396b;
        /* renamed from: c */
        private C1254a f3397c;
        /* renamed from: d */
        private C1271a f3398d;

        public C1268a(Context context, String str, C1254a c1254a) {
            this.f3397c = c1254a;
            this.f3395a = str;
            this.f3396b = ((RecycleBinActivity) context).mo6953b();
        }

        public final void run() {
            super.run();
            this.f3398d = C1270a.m3610b(this.f3397c.f3340d, this.f3397c.f3341e, this.f3395a, this.f3397c.f3337a);
            Message obtainMessage = this.f3396b.obtainMessage();
            obtainMessage.what = 3;
            this.f3398d.f3409e = this.f3397c;
            obtainMessage.obj = this.f3398d;
            this.f3396b.sendMessageDelayed(obtainMessage, 1500);
        }
    }

    /* renamed from: com.shuame.rootgenius.appmanager.f.a$b */
    public static class C1269b extends Thread {
        /* renamed from: a */
        private String f3399a;
        /* renamed from: b */
        private Handler f3400b;
        /* renamed from: c */
        private C1254a f3401c;
        /* renamed from: d */
        private C1271a f3402d;
        /* renamed from: e */
        private Boolean f3403e;

        public C1269b(Context context, String str, C1254a c1254a, Boolean bool) {
            this.f3401c = c1254a;
            this.f3399a = str;
            this.f3403e = bool;
            this.f3400b = ((AppUninstallActivity) context).mo6945b();
        }

        public final void run() {
            super.run();
            Message obtainMessage;
            if (this.f3403e.booleanValue()) {
                this.f3402d = C1270a.m3604a(this.f3401c.f3340d, this.f3401c.f3341e, this.f3399a, this.f3401c.f3337a);
                obtainMessage = this.f3400b.obtainMessage();
                obtainMessage.what = 1;
                this.f3402d.f3409e = this.f3401c;
                obtainMessage.obj = this.f3402d;
                this.f3400b.sendMessageDelayed(obtainMessage, 1500);
                return;
            }
            this.f3402d = C1270a.m3603a(this.f3401c.f3337a);
            obtainMessage = this.f3400b.obtainMessage();
            obtainMessage.what = 2;
            this.f3402d.f3409e = this.f3401c;
            obtainMessage.obj = this.f3402d;
            this.f3400b.sendMessageDelayed(obtainMessage, 1500);
        }
    }

    /* renamed from: a */
    public static C1271a m3603a(String str) {
        String a = f3404a.mo7002a("pm uninstall " + str, 3000, 3);
        C1271a c1271a = new C1271a(0, a, null);
        if (a.equals("Success")) {
            c1271a.f3406b = 0;
        } else {
            c1271a.f3406b = 1;
        }
        return c1271a;
    }

    /* renamed from: a */
    public static C1271a m3604a(String str, String str2, String str3, String str4) {
        if (!(str.indexOf("(") == -1 && str.indexOf(")") == -1)) {
            str = str.replace("(", "*").replace(")", "*");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C1259d.m3570m() + " chmod 755 ").append(str);
        stringBuilder.delete(0, stringBuilder.length());
        String stringBuilder2 = stringBuilder.append(C1259d.m3570m() + " mv ").append(str).append(" ").append(str2).toString();
        stringBuilder.delete(0, stringBuilder.length());
        String stringBuilder3 = stringBuilder.append("/data/data/").append(str4).toString();
        stringBuilder.delete(0, stringBuilder.length());
        String stringBuilder4 = stringBuilder.append(C1259d.m3570m() + " mv -f ").append(stringBuilder3).append(" ").append(str3).toString();
        List arrayList = new ArrayList();
        arrayList.add(C1259d.m3570m() + " mount -o remount,rw /system");
        arrayList.add(stringBuilder2);
        arrayList.add(stringBuilder4);
        C1271a c1271a = new C1271a(0, f3404a.mo7002a((C1259d.m3570m() + " mount -o remount,rw /system") + "\n" + stringBuilder2 + "\n" + stringBuilder4, 5000, 1), null);
        c1271a.f3406b = C1270a.m3609b(str, str2);
        return c1271a;
    }

    /* renamed from: a */
    public static String m3605a(Context context) {
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        String path = context.getFilesDir().getPath();
        C1259d.m3565d(path + "/Data/Bin/busybox");
        path = path + "/uninstallBackup";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return path;
    }

    /* renamed from: a */
    public static String m3606a(String str, String str2) {
        return str + str2.substring(str2.lastIndexOf("/"), str2.length());
    }

    /* renamed from: a */
    public static void m3607a() {
        List arrayList = new ArrayList();
        arrayList.add(C1259d.m3570m() + " rm -rf " + C1259d.m3566i() + "/*");
        C1272b.m3613a((String[]) arrayList.toArray(new String[0]));
    }

    /* renamed from: a */
    public static boolean m3608a(Context context, String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.DELETE", Uri.parse("package:" + str));
        intent.addFlags(268435456);
        context.startActivity(intent);
        return true;
    }

    /* renamed from: b */
    private static int m3609b(String str, String str2) {
        String a = f3404a.mo7002a((C1259d.m3570m() + " test -e ") + str2 + " -a ! -e " + str + " && echo \"true\" || echo \"false\"", 3000, 3);
        return a == null ? 1 : a.contains("true") ? 0 : a.equals("true") ? 0 : 1;
    }

    /* renamed from: b */
    public static C1271a m3610b(String str, String str2, String str3, String str4) {
        StringBuilder stringBuilder = new StringBuilder();
        String stringBuilder2 = stringBuilder.append(C1259d.m3570m() + " mv ").append(str2).append(" ").append(str).toString();
        stringBuilder.delete(0, stringBuilder.length());
        String stringBuilder3 = stringBuilder.append(str3).append("/").append(str4).toString();
        stringBuilder.delete(0, stringBuilder.length());
        String stringBuilder4 = stringBuilder.append(C1259d.m3570m() + " mv -f ").append(stringBuilder3).append(" /data/data/").toString();
        List arrayList = new ArrayList();
        arrayList.add(C1259d.m3570m() + " mount -o remount,rw /system");
        arrayList.add(stringBuilder2);
        arrayList.add(stringBuilder4);
        C1271a c1271a = new C1271a(0, f3404a.mo7002a((C1259d.m3570m() + " mount -o remount,rw /system") + "\n" + stringBuilder2 + "\n" + stringBuilder4, 3000, 2), null);
        c1271a.f3406b = C1270a.m3609b(str2, str);
        return c1271a;
    }
}
