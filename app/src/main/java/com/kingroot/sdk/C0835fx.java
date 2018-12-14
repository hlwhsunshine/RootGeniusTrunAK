package com.kingroot.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.p013pm.PackageInfo;
import android.net.Uri;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kingroot.sdk.fx */
public class C0835fx {
    /* renamed from: ji */
    private C0716ga f2083ji = null;

    private C0835fx() {
    }

    public C0835fx(C0716ga c0716ga) {
        this.f2083ji = c0716ga;
    }

    /* renamed from: Y */
    private String m2139Y(Context context) {
        return "com.kingroot.kinguser.activitys.SuNotifyActivity";
    }

    /* renamed from: Z */
    private void m2140Z(Context context) {
        List bW = new C0824fp(this.f2083ji).mo5824bW();
        if (bW != null && bW.size() > 0) {
            C0845gh.m2190a(context, this.f2083ji, "com.kingroot.kinguser");
            C0835fx.m2145i(this.f2083ji, "pm uninstall com.kingroot.kinguser");
            C0830ft.m2114c(this.f2083ji, bW, null);
        }
    }

    /* renamed from: a */
    private int m2141a(boolean z, PackageInfo packageInfo) {
        return !z ? 0 : packageInfo != null ? (packageInfo.applicationInfo.flags & 1) == 0 ? 1 : 2 : 3;
    }

    /* renamed from: an */
    private boolean m2142an(String str) {
        try {
            if (this.f2083ji != null && this.f2083ji.mo5684f(true)) {
                String str2 = "am start -n " + new ComponentName("com.kingroot.kinguser", str).flattenToShortString();
                C0836fz K = this.f2083ji.mo5683K(str2);
                C0825fq.m2099g("KuSdkInstaller", "starCmd:" + str2 + ", ret:" + K.success() + ", err:" + K.f2086ct);
                return K.success() && !K.f2086ct.contains("Error");
            }
        } catch (Throwable e) {
            C0825fq.m2097b("KuSdkInstaller", e);
        }
        return false;
    }

    /* renamed from: c */
    private synchronized int m2143c(Context context, int i, String str) {
        int a;
        Throwable e;
        C0825fq.m2099g("KuSdkInstaller", "Kinguser-installKU().");
        try {
            a = mo5832a(context, str, "Kinguser.apk", i);
            try {
                C0825fq.m2099g("KuSdkInstaller", "Kinguser-installKU(), ret:" + a);
            } catch (Exception e2) {
                e = e2;
                C0825fq.m2097b("KuSdkInstaller", e);
                return a;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            a = -1;
            e = th;
        }
        return a;
    }

    /* renamed from: ce */
    private boolean m2144ce() {
        try {
            return C0843gg.m2186cf().getPackageInfo("com.kingroot.kinguser", 0) != null;
        } catch (Throwable e) {
            C0825fq.m2096a(e);
            return false;
        }
    }

    /* renamed from: i */
    private static boolean m2145i(C0716ga c0716ga, String str) {
        C0836fz K = c0716ga.mo5683K(str);
        if (K == null || (K.success() && !K.f2085cs.contains("Failure"))) {
            return true;
        }
        C0825fq.m2102s("KuSdkInstaller", "script failed: " + str);
        return false;
    }

    /* renamed from: x */
    private int m2146x(Context context, String str) {
        int i = -2;
        C0825fq.m2099g("KuSdkInstaller", "Kinguser-silentInstallApk().");
        if (str != null) {
            C0845gh.m2190a(context, this.f2083ji, "com.kingroot.kinguser");
            try {
                if (this.f2083ji != null && this.f2083ji.mo5684f(true)) {
                    this.f2083ji.mo5683K("rm -r /data/data/com.kingroot.kinguser");
                    this.f2083ji.mo5683K("chmod 0755 " + str);
                    C0836fz K = this.f2083ji.mo5683K("pm install -r " + str);
                    if (K.f2086ct != null && K.f2086ct.contains("Failure")) {
                        C0825fq.m2099g("KuSdkInstaller", "pm install error:" + K.f2086ct);
                        i = K.f2086ct.contains("INSTALL_FAILED_VERSION_DOWNGRADE") ? -3 : -1;
                    } else if (K.success() && K.f2085cs.contains("Success")) {
                        i = 0;
                    }
                    C0825fq.m2099g("KuSdkInstaller", "Kinguser-silentInstallApk(), ret:" + i);
                }
            } catch (Exception e) {
            }
        }
        return i;
    }

    /* renamed from: y */
    private boolean m2147y(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setFlags(1073741824);
            intent.setClassName("com.kingroot.kinguser", str);
            context.startActivity(intent);
            return true;
        } catch (Throwable e) {
            C0825fq.m2097b("KuSdkInstaller", e);
            return false;
        }
    }

    /* renamed from: a */
    protected synchronized int mo5832a(Context context, String str, String str2, int i) {
        int v;
        Throwable e;
        C0825fq.m2099g("KuSdkInstaller", "Kinguser-install(), apkPath:" + str + "; installedName:" + str2 + "; installMethod:" + i);
        if (i == 0) {
            v = mo5837v(context, str);
        } else if (i == 2 || i == 3) {
            try {
                mo5835c(context, str, str2);
                try {
                    Thread.sleep(3000);
                } catch (Exception e2) {
                }
                for (v = 1; v < 3; v++) {
                    if (m2144ce()) {
                        v = 0;
                        break;
                    }
                    try {
                        Thread.sleep((long) (v * 3000));
                    } catch (Exception e3) {
                    }
                }
                v = -1;
                if (v == -1) {
                    try {
                        v = mo5838w(context, str);
                    } catch (Exception e4) {
                        e = e4;
                    }
                }
            } catch (Throwable e5) {
                Throwable th = e5;
                v = -1;
                e = th;
            }
        } else {
            v = mo5838w(context, str);
        }
        return v;
        C0825fq.m2097b("KuSdkInstaller", e);
        return v;
    }

    /* renamed from: a */
    public synchronized int mo5833a(Context context, boolean z, boolean z2, String str) {
        int i;
        Throwable e;
        PackageInfo packageInfo;
        C0825fq.m2099g("KuSdkInstaller", "Kinguser-installKU().");
        try {
            packageInfo = C0843gg.m2186cf().getPackageInfo("com.kingroot.kinguser", 0);
        } catch (Throwable e2) {
            C0825fq.m2096a(e2);
            packageInfo = null;
        }
        try {
            m2140Z(context);
            int c = m2143c(context, m2141a(z, packageInfo), str);
            if (-1 == c && z && z2) {
                try {
                    if (mo5834am("/system/app/Kinguser.apk")) {
                        i = 1;
                        C0825fq.m2099g("KuSdkInstaller", "安装Kinguser-installKU(), ret:" + i);
                    }
                } catch (Throwable e22) {
                    Throwable th = e22;
                    i = c;
                    e = th;
                }
            }
            i = c;
            try {
                C0825fq.m2099g("KuSdkInstaller", "安装Kinguser-installKU(), ret:" + i);
            } catch (Exception e3) {
                e = e3;
                C0825fq.m2097b("KuSdkInstaller", e);
                return i;
            }
        } catch (Throwable e222) {
            e = e222;
            i = -1;
        }
        return i;
    }

    /* renamed from: am */
    protected boolean mo5834am(String str) {
        C0825fq.m2099g("KuSdkInstaller", "Kinguser-silentRmKUApk().");
        List arrayList = new ArrayList();
        arrayList.add(str);
        C0835fx.m2145i(this.f2083ji, "pm uninstall com.kingroot.kinguser");
        return C0830ft.m2114c(this.f2083ji, arrayList, null);
    }

    /* renamed from: c */
    protected int mo5835c(Context context, String str, String str2) {
        C0825fq.m2099g("KuSdkInstaller", "Kinguser-installWithRoot().");
        C0845gh.m2190a(context, this.f2083ji, "com.kingroot.kinguser");
        return C0830ft.m2115e(this.f2083ji, str, str2) ? 0 : -2;
    }

    /* renamed from: cd */
    public synchronized boolean mo5836cd() {
        boolean an;
        C0825fq.m2099g("KuSdkInstaller", "Kinguser");
        try {
            Context bR = C0823fo.m2083bR();
            String Y = m2139Y(bR);
            an = m2142an(Y);
            if (!an && mo5838w(bR, "/system/app/Kinguser.apk") == 0) {
                an = m2142an(Y);
            }
            if (!an) {
                an = m2147y(bR, Y);
            }
        } catch (Throwable e) {
            C0825fq.m2097b("KuSdkInstaller", e);
            an = false;
        }
        return an;
    }

    /* renamed from: v */
    protected int mo5837v(Context context, String str) {
        C0825fq.m2099g("KuSdkInstaller", "Kinguser-installWithInterface().");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        context.startActivity(intent);
        return 0;
    }

    /* renamed from: w */
    protected int mo5838w(Context context, String str) {
        return m2146x(context, str);
    }
}
