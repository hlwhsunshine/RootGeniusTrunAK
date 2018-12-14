package com.shuame.mobile.module.autoboot.p081b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.p013pm.PackageManager;
import android.content.p013pm.ResolveInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.shuame.mobile.module.autoboot.p080a.C1148a;
import com.shuame.mobile.module.autoboot.p080a.C1149b;
import com.shuame.mobile.module.autoboot.p083c.C1161a;
import com.shuame.mobile.module.autoboot.p083c.C1161a.C1160a;
import com.shuame.mobile.sdk.impl.utils.ShellUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* renamed from: com.shuame.mobile.module.autoboot.b.a */
public class C1155a {
    /* renamed from: a */
    private static final String f3028a = C1155a.class.getSimpleName();
    /* renamed from: b */
    private static C1155a f3029b;
    /* renamed from: c */
    private static Context f3030c;
    /* renamed from: g */
    private static final String[] f3031g = new String[]{"android.intent.action.BOOT_COMPLETED", "android.intent.action.PACKAGE_ADDED", "android.intent.action.PACKAGE_CHANGED", "android.intent.action.PACKAGE_REMOVED", "android.intent.action.PACKAGE_REPLACED", "android.intent.action.USER_PRESENT", "android.intent.action.SCREEN_ON", "android.intent.action.SCREEN_OFF", "android.intent.action.ACTION_POWER_CONNECTED", "android.intent.action.ACTION_POWER_DISCONNECTED", "android.intent.action.BATTERY_LOW", "android.intent.action.BATTERY_OKAY"};
    /* renamed from: h */
    private static final String[] f3032h = new String[]{"com.shuame.mobile", "com.shuame.sprite", "com.shuame.rootgenius", "com.kingroot.master", "com.kingroot.kinguser"};
    /* renamed from: i */
    private static final String[] f3033i = new String[]{"inputmethod", "pinyin", "input", "com.htc.android.htcime", "launcher", "com.kingroot.kinguser", "com.tencent.mm", "com.tencent.mobileqq", "com.nd.android.pandahome2", "com.jb.gokeyboard", "com.miui.mihome2", "com.dianxinos.dxhome"};
    /* renamed from: d */
    private ArrayList<C1152a> f3034d;
    /* renamed from: e */
    private ArrayList<C1153b> f3035e;
    /* renamed from: f */
    private Handler f3036f;
    /* renamed from: j */
    private SharedPreferences f3037j;
    /* renamed from: k */
    private HandlerThread f3038k = new HandlerThread("AutoBootManagerHandlerThread");
    /* renamed from: l */
    private C1154c f3039l;
    /* renamed from: m */
    private List<C1148a> f3040m;
    /* renamed from: n */
    private C1149b f3041n;
    /* renamed from: o */
    private List<C1161a> f3042o;
    /* renamed from: p */
    private C1157c f3043p;
    /* renamed from: q */
    private HashSet<Long> f3044q;

    /* renamed from: com.shuame.mobile.module.autoboot.b.a$a */
    public interface C1152a {
        /* renamed from: a */
        void mo6746a(int i);
    }

    /* renamed from: com.shuame.mobile.module.autoboot.b.a$b */
    public interface C1153b {
        /* renamed from: a */
        void mo6747a(int i, boolean z);
    }

    /* renamed from: com.shuame.mobile.module.autoboot.b.a$c */
    private class C1154c extends Handler {
        public C1154c(Looper looper) {
            super(looper);
        }

        public final void dispatchMessage(Message message) {
            switch (message.what) {
                case 1:
                    C1155a.f3028a;
                    while (true) {
                        C1161a a = C1155a.this.f3043p.mo6763a();
                        if (a == null) {
                            synchronized (C1155a.this.f3044q) {
                                C1155a.this.f3044q.clear();
                            }
                            return;
                        } else if (a.f3067o != C1161a.f3057e) {
                            boolean z = a.f3067o == C1161a.f3059g;
                            C1155a.this.f3041n.mo6744a(a, z);
                            int b = C1155a.this.mo6757b(a, z);
                            C1155a.this.f3041n.mo6745a(a, z, b);
                            C1155a.this.mo6754a(a, b);
                        }
                    }
                default:
                    return;
            }
        }
    }

    public C1155a() {
        this.f3038k.start();
        this.f3039l = new C1154c(this.f3038k.getLooper());
        this.f3037j = f3030c.getSharedPreferences("autoboot", 0);
        this.f3040m = Collections.synchronizedList(new ArrayList());
        this.f3041n = new C1149b(this.f3040m);
        this.f3043p = new C1157c();
        this.f3034d = new ArrayList();
        this.f3035e = new ArrayList();
        this.f3036f = new Handler(Looper.getMainLooper());
        this.f3044q = new HashSet();
    }

    /* renamed from: a */
    public static C1155a m3315a() {
        if (f3029b == null) {
            synchronized (C1155a.class) {
                if (f3029b == null) {
                    f3029b = new C1155a();
                }
            }
        }
        return f3029b;
    }

    /* renamed from: a */
    private static C1160a m3317a(List<C1160a> list, ResolveInfo resolveInfo, String str) {
        for (C1160a c1160a : list) {
            if (c1160a.f3051c.equals(resolveInfo.activityInfo.name)) {
                break;
            }
        }
        C1160a c1160a2 = null;
        if (c1160a2 == null) {
            c1160a2 = new C1160a();
            list.add(c1160a2);
        }
        if (c1160a2.f3052d == null) {
            c1160a2.f3052d = new HashSet();
        }
        c1160a2.f3050b = resolveInfo.activityInfo.packageName;
        c1160a2.f3051c = resolveInfo.activityInfo.name;
        c1160a2.f3049a = c1160a2.f3050b + "/" + c1160a2.f3051c;
        c1160a2.f3052d.add(str);
        return c1160a2;
    }

    /* JADX WARNING: Missing block: B:18:0x0037, code:
            if (r1 == null) goto L_0x0039;
     */
    /* renamed from: a */
    private static com.shuame.mobile.module.autoboot.p083c.C1161a m3318a(android.content.p013pm.PackageManager r8, java.util.Map<java.lang.String, com.shuame.mobile.module.autoboot.p083c.C1161a> r9, android.content.p013pm.ResolveInfo r10, java.lang.String r11) {
        /*
        r0 = 0;
        r2 = 1;
        r3 = 0;
        r1 = r10.activityInfo;
        r4 = r1.packageName;
        r5 = f3032h;
        r6 = r5.length;
        r1 = r3;
    L_0x000b:
        if (r1 >= r6) goto L_0x001c;
    L_0x000d:
        r7 = r5[r1];
        r7 = r7.equals(r4);
        if (r7 == 0) goto L_0x0019;
    L_0x0015:
        r1 = r2;
    L_0x0016:
        if (r1 == 0) goto L_0x001e;
    L_0x0018:
        return r0;
    L_0x0019:
        r1 = r1 + 1;
        goto L_0x000b;
    L_0x001c:
        r1 = r3;
        goto L_0x0016;
    L_0x001e:
        r1 = r10.activityInfo;	 Catch:{ NameNotFoundException -> 0x009f }
        r1 = r1.packageName;	 Catch:{ NameNotFoundException -> 0x009f }
        r4 = 0;
        r1 = r8.getApplicationInfo(r1, r4);	 Catch:{ NameNotFoundException -> 0x009f }
        r4 = r1.flags;	 Catch:{ NameNotFoundException -> 0x009f }
        r4 = r4 & 1;
        if (r4 == 0) goto L_0x009b;
    L_0x002d:
        r4 = r2;
    L_0x002e:
        r1 = r1.flags;	 Catch:{ NameNotFoundException -> 0x009f }
        r1 = r1 & 128;
        if (r1 == 0) goto L_0x009d;
    L_0x0034:
        r1 = r2;
    L_0x0035:
        if (r4 != 0) goto L_0x0018;
    L_0x0037:
        if (r1 != 0) goto L_0x0018;
    L_0x0039:
        r0 = r10.activityInfo;
        r0 = r0.packageName;
        r0 = r9.get(r0);
        r0 = (com.shuame.mobile.module.autoboot.p083c.C1161a) r0;
        if (r0 != 0) goto L_0x007f;
    L_0x0045:
        r1 = new com.shuame.mobile.module.autoboot.c.a;
        r1.<init>();
        r0 = r10.activityInfo;
        r0 = r0.packageName;
        r1.f3062j = r0;
        r0 = r10.loadLabel(r8);
        r0 = r0.toString();
        r1.f3060h = r0;
        r0 = r10.loadIcon(r8);
        r1.f3061i = r0;
        r4 = r1.f3062j;
        r5 = f3033i;
        r6 = r5.length;
        r0 = r3;
    L_0x0066:
        if (r0 >= r6) goto L_0x00a7;
    L_0x0068:
        r7 = r5[r0];
        r7 = r4.contains(r7);
        if (r7 == 0) goto L_0x00a4;
    L_0x0070:
        r0 = r2;
    L_0x0071:
        if (r0 == 0) goto L_0x00a9;
    L_0x0073:
        r0 = com.shuame.mobile.module.autoboot.p083c.C1161a.f3056d;
    L_0x0075:
        r1.f3064l = r0;
        r0 = r10.activityInfo;
        r0 = r0.packageName;
        r9.put(r0, r1);
        r0 = r1;
    L_0x007f:
        r1 = r0.f3066n;
        if (r1 != 0) goto L_0x008a;
    L_0x0083:
        r1 = new java.util.ArrayList;
        r1.<init>();
        r0.f3066n = r1;
    L_0x008a:
        r1 = "android.intent.action.BOOT_COMPLETED";
        r1 = r11.equals(r1);
        if (r1 == 0) goto L_0x00ac;
    L_0x0092:
        r1 = r0.f3063k;
        r2 = com.shuame.mobile.module.autoboot.p083c.C1161a.f3053a;
        r1 = r1 | r2;
        r0.f3063k = r1;
        goto L_0x0018;
    L_0x009b:
        r4 = r3;
        goto L_0x002e;
    L_0x009d:
        r1 = r3;
        goto L_0x0035;
    L_0x009f:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0039;
    L_0x00a4:
        r0 = r0 + 1;
        goto L_0x0066;
    L_0x00a7:
        r0 = r3;
        goto L_0x0071;
    L_0x00a9:
        r0 = com.shuame.mobile.module.autoboot.p083c.C1161a.f3055c;
        goto L_0x0075;
    L_0x00ac:
        r1 = r0.f3063k;
        r2 = com.shuame.mobile.module.autoboot.p083c.C1161a.f3054b;
        r1 = r1 | r2;
        r0.f3063k = r1;
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.mobile.module.autoboot.b.a.a(android.content.pm.PackageManager, java.util.Map, android.content.pm.ResolveInfo, java.lang.String):com.shuame.mobile.module.autoboot.c.a");
    }

    /* renamed from: a */
    private void m3319a(int i, boolean z) {
        this.f3036f.post(new C1156b(this, i, z));
    }

    /* renamed from: a */
    public static void m3320a(Context context) {
        f3030c = context;
    }

    /* renamed from: a */
    private boolean m3321a(PackageManager packageManager, C1161a c1161a) {
        if (c1161a == null) {
            return false;
        }
        if (m3322a(c1161a)) {
            new StringBuilder("isDisabled updateDisabledIfNeed packageName:").append(c1161a.f3062j).append(";disabled:").append(c1161a.f3065m);
            return c1161a.f3065m;
        }
        int i = 0;
        for (C1160a c1160a : c1161a.f3066n) {
            int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(c1160a.f3050b, c1160a.f3051c));
            new StringBuilder("isDisabled receiverInfo.fullName:").append(c1160a.f3049a).append(";componentEnabledSetting:").append(componentEnabledSetting);
            i = componentEnabledSetting == 2 ? i + 1 : i;
        }
        boolean z = this.f3037j.getBoolean(c1161a.f3062j, true);
        int size = c1161a.f3066n.size();
        new StringBuilder("isDisabled packageName:").append(c1161a.f3062j).append(";prefsEnabled:").append(z).append(";disabledReceiverCount:").append(i).append(";totalReceiverCount:").append(size);
        return i == size || (i > 0 && !z);
    }

    /* renamed from: a */
    private boolean m3322a(C1161a c1161a) {
        if (c1161a == null) {
            return false;
        }
        C1161a a = this.f3043p.mo6764a(c1161a.f3062j);
        if (a == null) {
            return false;
        }
        if (a.f3067o == C1161a.f3058f) {
            c1161a.f3065m = true;
            return true;
        } else if (a.f3067o != C1161a.f3059g) {
            return false;
        } else {
            c1161a.f3065m = false;
            return true;
        }
    }

    /* renamed from: b */
    private void m3324b(int i) {
        if (i >= 0) {
            Iterator it = this.f3034d.iterator();
            while (it.hasNext()) {
                ((C1152a) it.next()).mo6746a(i);
            }
        }
    }

    /* renamed from: a */
    public final List<C1161a> mo6749a(int i) {
        List<C1161a> arrayList = new ArrayList();
        if (this.f3042o != null) {
            for (C1161a c1161a : this.f3042o) {
                if ((c1161a.f3064l & i) != 0) {
                    arrayList.add(c1161a);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public final void mo6750a(long j) {
        synchronized (this.f3044q) {
            if (!this.f3044q.contains(Long.valueOf(j))) {
                this.f3044q.add(Long.valueOf(j));
            }
        }
    }

    /* renamed from: a */
    public final void mo6751a(C1148a c1148a) {
        if (c1148a != null) {
            synchronized (this.f3040m) {
                if (!this.f3040m.contains(c1148a)) {
                    this.f3040m.add(c1148a);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo6752a(C1152a c1152a) {
        if (c1152a != null) {
            synchronized (this.f3034d) {
                if (!this.f3034d.contains(c1152a)) {
                    this.f3034d.add(c1152a);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo6753a(C1153b c1153b) {
        if (c1153b != null) {
            synchronized (this.f3035e) {
                if (!this.f3035e.contains(c1153b)) {
                    this.f3035e.add(c1153b);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo6754a(C1161a c1161a, int i) {
        if (this.f3044q.contains(Long.valueOf(c1161a.f3068p)) && i == 0 && c1161a.f3067o == C1161a.f3058f) {
            this.f3044q.remove(Long.valueOf(c1161a.f3068p));
        }
    }

    /* renamed from: a */
    public final void mo6755a(C1161a c1161a, boolean z) {
        if (c1161a != null) {
            c1161a.f3067o = z ? C1161a.f3059g : C1161a.f3058f;
            this.f3043p.mo6765a(c1161a);
            this.f3039l.sendEmptyMessage(1);
            m3324b(mo6756b());
        }
    }

    /* renamed from: b */
    public final int mo6756b() {
        int i = 0;
        if (this.f3042o == null) {
            mo6761c();
        }
        if (this.f3042o == null) {
            return 0;
        }
        Iterator it = this.f3042o.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            C1161a c1161a = (C1161a) it.next();
            m3322a(c1161a);
            if (!(c1161a.f3065m || (c1161a.f3064l & C1161a.f3055c) == 0)) {
                i2++;
            }
            i = i2;
        }
    }

    /* renamed from: b */
    public final int mo6757b(C1161a c1161a, boolean z) {
        if (c1161a == null) {
            return 1;
        }
        if (c1161a.f3066n.isEmpty()) {
            return 0;
        }
        String str = "LD_LIBRARY_PATH=/vendor/lib:/system/lib %s";
        Object[] objArr = new Object[1];
        objArr[0] = z ? "pm enable" : "pm disable";
        String format = String.format(str, objArr);
        str = "new state: %s";
        Object[] objArr2 = new Object[1];
        objArr2[0] = z ? "enabled" : "disabled";
        CharSequence format2 = String.format(str, objArr2);
        int i = 0;
        for (C1160a c1160a : c1161a.f3066n) {
            String format3 = String.format("%s '%s'", new Object[]{format, c1160a.f3049a});
            Object execSuCmd = ShellUtils.execSuCmd(format3, 2000);
            new StringBuilder("setAutoBootEnabledSync ").append(format3).append(" output:").append(execSuCmd);
            if (!TextUtils.isEmpty(execSuCmd) && execSuCmd.contains(format2)) {
                i++;
            }
            i = i;
        }
        if (i <= 0) {
            return 1;
        }
        if (z) {
            this.f3037j.edit().remove(c1161a.f3062j).commit();
            return 0;
        }
        this.f3037j.edit().putBoolean(c1161a.f3062j, false).commit();
        return 0;
    }

    /* renamed from: b */
    public final void mo6758b(C1148a c1148a) {
        if (c1148a != null) {
            synchronized (this.f3040m) {
                if (this.f3040m.contains(c1148a)) {
                    this.f3040m.remove(c1148a);
                }
            }
        }
    }

    /* renamed from: b */
    public final void mo6759b(C1152a c1152a) {
        if (c1152a != null) {
            synchronized (this.f3034d) {
                if (this.f3034d.contains(c1152a)) {
                    this.f3034d.remove(c1152a);
                }
            }
        }
    }

    /* renamed from: b */
    public final void mo6760b(C1153b c1153b) {
        if (c1153b != null) {
            synchronized (this.f3035e) {
                if (this.f3035e.contains(c1153b)) {
                    this.f3035e.remove(c1153b);
                }
            }
        }
    }

    /* renamed from: c */
    public final List<C1161a> mo6761c() {
        System.currentTimeMillis();
        Map hashMap = new HashMap();
        PackageManager packageManager = f3030c.getPackageManager();
        m3319a(new Random().nextInt(10) + 75, false);
        for (String str : f3031g) {
            for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(new Intent(str), 512)) {
                if (resolveInfo.activityInfo != null) {
                    C1161a a = C1155a.m3318a(packageManager, hashMap, resolveInfo, str);
                    if (a != null) {
                        C1155a.m3317a(a.f3066n, resolveInfo, str);
                    }
                }
            }
        }
        List<C1161a> arrayList = new ArrayList(hashMap.values());
        for (C1161a c1161a : arrayList) {
            new StringBuilder("name:").append(c1161a.f3060h);
            c1161a.f3065m = m3321a(packageManager, c1161a);
            new StringBuilder("autoBootAppInfo:").append(c1161a);
            for (C1160a c1160a : c1161a.f3066n) {
                new StringBuilder("receiver:").append(c1160a.f3049a);
                Iterator it = c1160a.f3052d.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
        System.currentTimeMillis();
        m3319a(100, true);
        this.f3042o = arrayList;
        m3324b(mo6756b());
        return arrayList;
    }
}
