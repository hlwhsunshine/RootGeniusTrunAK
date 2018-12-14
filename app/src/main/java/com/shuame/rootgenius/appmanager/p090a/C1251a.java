package com.shuame.rootgenius.appmanager.p090a;

import android.content.Context;
import android.content.Intent;
import android.content.p013pm.IPackageStatsObserver;
import android.content.p013pm.IPackageStatsObserver.Stub;
import android.content.p013pm.PackageInfo;
import android.content.p013pm.PackageManager;
import android.content.p013pm.PackageManager.NameNotFoundException;
import android.content.p013pm.PackageStats;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.provider.Settings.Secure;
import android.text.format.Formatter;
import com.shuame.rootgenius.appmanager.C1253a;
import com.shuame.rootgenius.appmanager.p091b.C1254a;
import com.shuame.rootgenius.appmanager.p091b.C1259d;
import com.shuame.rootgenius.appmanager.p094d.C1266a;
import com.shuame.rootgenius.appmanager.p094d.C1267b;
import com.shuame.rootgenius.appmanager.service.AppDescManager;
import com.shuame.rootgenius.common.C1325c;
import com.shuame.rootgenius.common.util.NetworkUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.shuame.rootgenius.appmanager.a.a */
public final class C1251a extends Thread {
    /* renamed from: a */
    HashMap<String, String> f3314a = new HashMap();
    /* renamed from: b */
    private Context f3315b;
    /* renamed from: c */
    private List<C1254a> f3316c;
    /* renamed from: d */
    private List<C1254a> f3317d;
    /* renamed from: e */
    private List<C1254a> f3318e;
    /* renamed from: f */
    private HashMap<String, C1266a> f3319f;
    /* renamed from: g */
    private List<C1266a> f3320g;
    /* renamed from: h */
    private List<C1266a> f3321h;
    /* renamed from: i */
    private List<C1254a> f3322i;
    /* renamed from: j */
    private C1259d f3323j;
    /* renamed from: k */
    private AppDescManager f3324k;
    /* renamed from: l */
    private C1254a f3325l;
    /* renamed from: m */
    private int f3326m;
    /* renamed from: n */
    private boolean f3327n = false;
    /* renamed from: o */
    private HashMap<String, String> f3328o = new HashMap();

    /* renamed from: com.shuame.rootgenius.appmanager.a.a$a */
    public class C1250a extends Stub {
        public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
            long j = packageStats.cacheSize;
            long j2 = packageStats.dataSize;
            long j3 = packageStats.codeSize;
            long j4 = (j + j2) + j3;
            new StringBuilder("cachesize--->").append(j).append(" datasize---->").append(j2).append(" codeSize---->").append(j3).append(" size---->").append(j4);
            if (z) {
                if (j4 == 0) {
                    C1251a.this.f3328o.put(packageStats.packageName, "大小未知");
                } else {
                    C1251a.this.f3328o.put(packageStats.packageName, Formatter.formatFileSize(C1251a.this.f3315b, j4));
                }
            }
            if (C1251a.this.f3327n) {
                C1251a.this.m3539c();
            }
        }
    }

    public C1251a(Context context, List<C1254a> list, List<C1254a> list2, List<C1254a> list3, List<C1254a> list4, C1259d c1259d) {
        this.f3315b = context;
        this.f3316c = list2;
        this.f3322i = list;
        this.f3317d = list3;
        this.f3316c = list2;
        this.f3323j = c1259d;
        this.f3318e = list4;
    }

    /* renamed from: a */
    private static C1254a m3531a(PackageInfo packageInfo, PackageManager packageManager) {
        C1254a c1254a = new C1254a();
        c1254a.f3337a = packageInfo.applicationInfo.packageName;
        c1254a.f3340d = packageInfo.applicationInfo.sourceDir;
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = packageManager.getApplicationInfo(c1254a.f3337a, 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        c1254a.f3338b = packageManager.getApplicationIcon(applicationInfo);
        c1254a.f3339c = packageManager.getApplicationLabel(applicationInfo).toString();
        c1254a.f3344h = packageInfo.versionCode;
        return c1254a;
    }

    /* renamed from: a */
    private Boolean m3532a(C1254a c1254a) {
        return this.f3314a.get(c1254a.f3337a) == null ? Boolean.valueOf(false) : Boolean.valueOf(true);
    }

    /* renamed from: a */
    private Boolean m3533a(String str) {
        for (C1254a c1254a : this.f3317d) {
            if (c1254a.f3337a.equals(str)) {
                return Boolean.valueOf(true);
            }
        }
        return Boolean.valueOf(false);
    }

    /* renamed from: a */
    private void m3535a() {
        try {
            InputStream open;
            HashMap hashMap = this.f3319f;
            try {
                open = C1253a.m3545a().getAssets().open("localPreinstalledApplist.properties");
            } catch (IOException e) {
                e.printStackTrace();
                open = null;
            }
            Reader inputStreamReader = new InputStreamReader(open);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split("=");
                    if (split != null) {
                        hashMap.put(split[0], new C1266a(split[0], new String("一款" + split[1] + "应用")));
                    }
                } catch (IOException e2) {
                    bufferedReader.close();
                    inputStreamReader.close();
                    e2.printStackTrace();
                }
            }
            bufferedReader.close();
            inputStreamReader.close();
        } catch (IOException e22) {
            e22.printStackTrace();
        }
        if (this.f3319f.size() > 0) {
            this.f3323j.mo6902a(Boolean.valueOf(true));
            for (C1254a c1254a : this.f3316c) {
                if (!m3533a(c1254a.f3337a).booleanValue() && this.f3323j.mo6904b().booleanValue()) {
                    if (this.f3319f.get(c1254a.f3337a) != null) {
                        c1254a.f3343g = ((C1266a) this.f3319f.get(c1254a.f3337a)).f3393b;
                        c1254a.f3345i = 1;
                        this.f3318e.add(c1254a);
                    } else {
                        c1254a.f3342f = new String("系统组件");
                        c1254a.f3345i = -1;
                    }
                }
            }
            this.f3316c.removeAll(this.f3318e);
            return;
        }
        this.f3324k = AppDescManager.getInstance();
        this.f3323j.mo6902a(Boolean.valueOf(false));
        for (C1254a c1254a2 : this.f3316c) {
            c1254a2.f3345i = -1;
            c1254a2.f3342f = new String("系统组件");
        }
    }

    /* renamed from: b */
    private void m3537b() {
        if (this.f3314a.get("com.shuame.rootgenius") == null) {
            this.f3314a.put("com.shuame.rootgenius", "需要过滤app");
        }
        if (this.f3314a.get("com.shuame.mobile") == null) {
            this.f3314a.put("com.shuame.mobile", "需要过滤app");
        }
        if (this.f3314a.get("com.shuame.sprite") == null) {
            this.f3314a.put("com.shuame.sprite", "需要过滤app");
        }
        String[] split = Secure.getString(this.f3315b.getContentResolver(), "default_input_method").split("/");
        if (this.f3314a.get(split[0]) == null) {
            this.f3314a.put(split[0], "需要过滤当前输入法");
        }
        Collection arrayList = new ArrayList();
        for (C1254a c1254a : this.f3316c) {
            if (m3532a(c1254a).booleanValue()) {
                arrayList.add(c1254a);
            }
        }
        if (!arrayList.isEmpty()) {
            this.f3316c.removeAll(arrayList);
        }
        arrayList.clear();
        for (C1254a c1254a2 : this.f3318e) {
            if (m3532a(c1254a2).booleanValue()) {
                arrayList.add(c1254a2);
            }
        }
        if (!arrayList.isEmpty()) {
            this.f3318e.removeAll(arrayList);
        }
        arrayList.clear();
        for (C1254a c1254a22 : this.f3322i) {
            if (m3532a(c1254a22).booleanValue()) {
                arrayList.add(c1254a22);
            }
        }
        if (!arrayList.isEmpty()) {
            this.f3322i.removeAll(arrayList);
        }
    }

    /* renamed from: b */
    private void m3538b(String str) {
        if (str != null) {
            PackageManager packageManager = this.f3315b.getPackageManager();
            try {
                packageManager.getClass().getMethod("getPackageSizeInfo", new Class[]{String.class, IPackageStatsObserver.class}).invoke(packageManager, new Object[]{str, new C1250a()});
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

    /* renamed from: c */
    private void m3539c() {
        if (this.f3318e.size() != 0) {
            for (C1254a c1254a : this.f3318e) {
                if (this.f3328o.get(c1254a.f3337a) != null) {
                    c1254a.f3342f = (String) this.f3328o.get(c1254a.f3337a);
                    c1254a.f3342f = "占用空间" + c1254a.f3342f;
                }
            }
        }
        if (this.f3322i.size() != 0) {
            for (C1254a c1254a2 : this.f3322i) {
                if (this.f3328o.get(c1254a2.f3337a) != null) {
                    c1254a2.f3342f = (String) this.f3328o.get(c1254a2.f3337a);
                    c1254a2.f3342f = "占用空间" + c1254a2.f3342f;
                }
            }
        }
        C1325c.m3724a().sendBroadcast(new Intent(C1267b.f3394a));
    }

    /* renamed from: d */
    private void m3541d() {
        this.f3319f.clear();
        Cursor b = this.f3323j.mo6903b("backgroundinfo");
        if (b != null && b.getCount() > 0) {
            b.moveToFirst();
            do {
                C1266a c1266a = new C1266a();
                C1259d.m3556a(b, c1266a);
                this.f3319f.put(c1266a.f3392a, c1266a);
            } while (b.moveToNext());
        }
    }

    /* renamed from: e */
    private void m3543e() {
        this.f3314a.clear();
        Cursor b = this.f3323j.mo6903b("appHidelist");
        if (b != null && b.getCount() > 0) {
            b.moveToFirst();
            do {
                C1266a c1266a = new C1266a();
                C1259d.m3556a(b, c1266a);
                this.f3314a.put(c1266a.f3392a, "需要过滤app");
                new StringBuilder().append(c1266a.f3392a).append("\n");
            } while (b.moveToNext());
        }
    }

    /* renamed from: f */
    private void m3544f() {
        if (this.f3323j.mo6896a("recyclebin") >= 1) {
            this.f3317d.clear();
            Cursor b = this.f3323j.mo6903b("recyclebin");
            b.moveToFirst();
            do {
                C1254a c1254a = new C1254a();
                new StringBuilder("index 0:").append(b.getString(0));
                new StringBuilder("index 1:").append(b.getString(1));
                C1259d.m3555a(b, c1254a);
                this.f3317d.add(c1254a);
            } while (b.moveToNext());
        }
    }

    public final void run() {
        super.run();
        C1259d.f3362d = Boolean.valueOf(true);
        this.f3319f = new HashMap();
        m3544f();
        this.f3316c.clear();
        this.f3322i.clear();
        this.f3318e.clear();
        PackageManager packageManager;
        if (this.f3323j.mo6896a("backgroundinfo") < 1 || this.f3323j.mo6896a("appHidelist") < 1) {
            packageManager = this.f3315b.getPackageManager();
            for (PackageInfo packageInfo : packageManager.getInstalledPackages(0)) {
                if ((packageInfo.applicationInfo.flags & 128) == 0 && (packageInfo.applicationInfo.flags & 1) == 0) {
                    this.f3322i.add(C1251a.m3531a(packageInfo, packageManager));
                } else {
                    this.f3316c.add(C1251a.m3531a(packageInfo, packageManager));
                }
            }
            if (NetworkUtils.m3851a(this.f3315b)) {
                this.f3324k = AppDescManager.getInstance();
                this.f3324k.netQueryAppInfos(this.f3316c);
                if (this.f3324k.isHttpReqSucc()) {
                    this.f3320g = this.f3324k.getAppDescList();
                    this.f3321h = this.f3324k.getAppHideList();
                    for (C1266a b : this.f3321h) {
                        this.f3323j.mo6906b(b);
                    }
                    for (C1266a b2 : this.f3320g) {
                        this.f3323j.mo6901a(b2);
                    }
                    m3541d();
                    m3543e();
                    this.f3323j.mo6902a(Boolean.valueOf(true));
                    for (C1254a c1254a : this.f3316c) {
                        if (!m3533a(c1254a.f3337a).booleanValue() && this.f3323j.mo6904b().booleanValue()) {
                            if (this.f3319f.get(c1254a.f3337a) != null) {
                                c1254a.f3343g = ((C1266a) this.f3319f.get(c1254a.f3337a)).f3393b;
                                c1254a.f3345i = 1;
                                this.f3318e.add(c1254a);
                            } else {
                                c1254a.f3342f = new String("系统组件");
                                c1254a.f3345i = -1;
                            }
                        }
                    }
                    this.f3316c.removeAll(this.f3318e);
                } else {
                    m3535a();
                }
            } else {
                m3535a();
            }
        } else {
            m3541d();
            m3543e();
            this.f3323j.mo6902a(Boolean.valueOf(true));
            packageManager = this.f3315b.getPackageManager();
            for (PackageInfo packageInfo2 : packageManager.getInstalledPackages(0)) {
                if ((packageInfo2.applicationInfo.flags & 128) == 0 && (packageInfo2.applicationInfo.flags & 1) == 0) {
                    this.f3322i.add(C1251a.m3531a(packageInfo2, packageManager));
                } else if (!m3533a(packageInfo2.applicationInfo.packageName).booleanValue()) {
                    C1254a a = C1251a.m3531a(packageInfo2, packageManager);
                    if (!this.f3323j.mo6904b().booleanValue()) {
                        this.f3316c.add(a);
                    } else if (this.f3319f.get(a.f3337a) == null) {
                        a.f3342f = new String("系统组件");
                        a.f3345i = -1;
                        this.f3316c.add(a);
                    } else if (a.f3340d.contains("system/delapp")) {
                        this.f3322i.add(C1251a.m3531a(packageInfo2, packageManager));
                    } else {
                        a.f3343g = ((C1266a) this.f3319f.get(a.f3337a)).f3393b;
                        a.f3345i = 1;
                        this.f3318e.add(a);
                    }
                }
            }
        }
        this.f3326m = this.f3318e.size() + this.f3322i.size();
        if (this.f3323j.mo6904b().booleanValue()) {
            this.f3325l = new C1254a();
            this.f3325l.f3345i = 2;
            this.f3325l.f3339c = new String("listDisplayItem");
            this.f3318e.add(this.f3325l);
            for (C1254a c1254a2 : this.f3318e) {
                try {
                    m3538b(c1254a2.f3337a);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.f3322i.size() != 0) {
            for (C1254a c1254a22 : this.f3322i) {
                try {
                    m3538b(c1254a22.f3337a);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        m3537b();
        for (C1254a c1254a222 : this.f3316c) {
            new StringBuilder("系统组件 app name: ").append(c1254a222.f3339c).append(" packageName: ").append(c1254a222.f3337a).append(" sourceDir: ").append(c1254a222.f3340d).append(" packageSize111: ").append(c1254a222.f3342f).append(" desc").append(c1254a222.f3343g).append(" flag").append(c1254a222.f3345i);
        }
        for (C1254a c1254a2222 : this.f3318e) {
            new StringBuilder("预装应用 app name: ").append(c1254a2222.f3339c).append(" packageName: ").append(c1254a2222.f3337a).append(" sourceDir: ").append(c1254a2222.f3340d).append(" packageSize111: ").append(c1254a2222.f3342f).append(" desc").append(c1254a2222.f3343g).append(" flag").append(c1254a2222.f3345i);
        }
        m3539c();
        if (this.f3326m != this.f3328o.size()) {
            this.f3327n = true;
        }
        C1259d.f3362d = Boolean.valueOf(false);
    }
}
