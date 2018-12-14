package com.p070qq.p071e.comm.managers.plugin;

import android.content.Context;
import com.p070qq.p071e.comm.p073pi.POFactory;
import com.p070qq.p071e.comm.util.GDTLogger;
import com.p070qq.p071e.comm.util.StringUtil;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.qq.e.comm.managers.plugin.PM */
public class C1061PM {
    /* renamed from: i */
    private static final Map<Class<?>, String> f2771i = new C10601();
    /* renamed from: a */
    private final Context f2772a;
    /* renamed from: b */
    private String f2773b;
    /* renamed from: c */
    private File f2774c;
    /* renamed from: d */
    private int f2775d;
    /* renamed from: e */
    private DexClassLoader f2776e;
    /* renamed from: f */
    private RandomAccessFile f2777f;
    /* renamed from: g */
    private FileLock f2778g;
    /* renamed from: h */
    private boolean f2779h = m3081b();

    /* renamed from: com.qq.e.comm.managers.plugin.PM$1 */
    final class C10601 extends HashMap<Class<?>, String> {
        C10601() {
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }
    }

    public C1061PM(Context context) {
        this.f2772a = context.getApplicationContext();
        if (m3080a()) {
            GDTLogger.m3130d("PluginFile:\t" + (this.f2774c == null ? "null" : this.f2774c.getAbsolutePath()));
            if (this.f2773b != null) {
                try {
                    this.f2776e = new DexClassLoader(this.f2774c.getAbsolutePath(), this.f2772a.getDir("e_qq_com_dex", 0).getAbsolutePath(), null, getClass().getClassLoader());
                    return;
                } catch (Throwable th) {
                    GDTLogger.m3132e("exception while init plugin class loader", th);
                    return;
                }
            }
            this.f2776e = null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0091 A:{Catch:{ Throwable -> 0x00f3, all -> 0x0110 }} */
    /* JADX WARNING: Missing block: B:17:0x0096, code:
            if (r2 != false) goto L_0x0098;
     */
    /* renamed from: a */
    private boolean m3080a() {
        /*
        r7 = this;
        r6 = 535; // 0x217 float:7.5E-43 double:2.643E-321;
        r1 = 1;
        r0 = 0;
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00f3 }
        r3 = "TimeStap_BEFORE_PLUGIN_INIT:";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00f3 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00f3 }
        r2 = r2.append(r4);	 Catch:{ Throwable -> 0x00f3 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00f3 }
        com.p070qq.p071e.comm.util.GDTLogger.m3130d(r2);	 Catch:{ Throwable -> 0x00f3 }
        r2 = r7.f2779h;	 Catch:{ Throwable -> 0x00f3 }
        if (r2 == 0) goto L_0x0057;
    L_0x001e:
        r2 = new com.qq.e.comm.managers.plugin.c;	 Catch:{ Throwable -> 0x00f3 }
        r3 = r7.f2772a;	 Catch:{ Throwable -> 0x00f3 }
        r3 = com.p070qq.p071e.comm.managers.plugin.C1065c.m3087b(r3);	 Catch:{ Throwable -> 0x00f3 }
        r4 = r7.f2772a;	 Catch:{ Throwable -> 0x00f3 }
        r4 = com.p070qq.p071e.comm.managers.plugin.C1065c.m3089d(r4);	 Catch:{ Throwable -> 0x00f3 }
        r2.<init>(r3, r4);	 Catch:{ Throwable -> 0x00f3 }
        r3 = r2.mo6468a();	 Catch:{ Throwable -> 0x00f3 }
        if (r3 == 0) goto L_0x0057;
    L_0x0035:
        r3 = r7.f2772a;	 Catch:{ Throwable -> 0x00f3 }
        r3 = com.p070qq.p071e.comm.managers.plugin.C1065c.m3086a(r3);	 Catch:{ Throwable -> 0x00f3 }
        r4 = r7.f2772a;	 Catch:{ Throwable -> 0x00f3 }
        r4 = com.p070qq.p071e.comm.managers.plugin.C1065c.m3088c(r4);	 Catch:{ Throwable -> 0x00f3 }
        r2 = r2.mo6469a(r3, r4);	 Catch:{ Throwable -> 0x00f3 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00f3 }
        r4 = "NextExist,Updated=";
        r3.<init>(r4);	 Catch:{ Throwable -> 0x00f3 }
        r2 = r3.append(r2);	 Catch:{ Throwable -> 0x00f3 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00f3 }
        com.p070qq.p071e.comm.util.GDTLogger.m3130d(r2);	 Catch:{ Throwable -> 0x00f3 }
    L_0x0057:
        r2 = new com.qq.e.comm.managers.plugin.c;	 Catch:{ Throwable -> 0x00f3 }
        r3 = r7.f2772a;	 Catch:{ Throwable -> 0x00f3 }
        r3 = com.p070qq.p071e.comm.managers.plugin.C1065c.m3086a(r3);	 Catch:{ Throwable -> 0x00f3 }
        r4 = r7.f2772a;	 Catch:{ Throwable -> 0x00f3 }
        r4 = com.p070qq.p071e.comm.managers.plugin.C1065c.m3088c(r4);	 Catch:{ Throwable -> 0x00f3 }
        r2.<init>(r3, r4);	 Catch:{ Throwable -> 0x00f3 }
        r3 = r2.mo6468a();	 Catch:{ Throwable -> 0x00f3 }
        if (r3 == 0) goto L_0x008e;
    L_0x006e:
        r3 = r2.mo6470b();	 Catch:{ Throwable -> 0x00f3 }
        if (r3 >= r6) goto L_0x00b0;
    L_0x0074:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00f3 }
        r3 = "last updated plugin version =";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00f3 }
        r3 = r7.f2775d;	 Catch:{ Throwable -> 0x00f3 }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x00f3 }
        r3 = ";asset plugin version=535";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x00f3 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00f3 }
        com.p070qq.p071e.comm.util.GDTLogger.m3130d(r2);	 Catch:{ Throwable -> 0x00f3 }
    L_0x008e:
        r2 = r0;
    L_0x008f:
        if (r2 != 0) goto L_0x0098;
    L_0x0091:
        r2 = r7.f2779h;	 Catch:{ Throwable -> 0x00f3 }
        if (r2 != 0) goto L_0x00c6;
    L_0x0095:
        r2 = r0;
    L_0x0096:
        if (r2 == 0) goto L_0x0099;
    L_0x0098:
        r0 = r1;
    L_0x0099:
        r1 = new java.lang.StringBuilder;
        r2 = "TimeStap_AFTER_PLUGIN_INIT:";
        r1.<init>(r2);
        r2 = java.lang.System.currentTimeMillis();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.p070qq.p071e.comm.util.GDTLogger.m3130d(r1);
    L_0x00af:
        return r0;
    L_0x00b0:
        r3 = r2.mo6471c();	 Catch:{ Throwable -> 0x00f3 }
        r7.f2773b = r3;	 Catch:{ Throwable -> 0x00f3 }
        r2 = r2.mo6470b();	 Catch:{ Throwable -> 0x00f3 }
        r7.f2775d = r2;	 Catch:{ Throwable -> 0x00f3 }
        r2 = r7.f2772a;	 Catch:{ Throwable -> 0x00f3 }
        r2 = com.p070qq.p071e.comm.managers.plugin.C1065c.m3086a(r2);	 Catch:{ Throwable -> 0x00f3 }
        r7.f2774c = r2;	 Catch:{ Throwable -> 0x00f3 }
        r2 = r1;
        goto L_0x008f;
    L_0x00c6:
        r2 = r7.f2772a;	 Catch:{ Throwable -> 0x00f3 }
        r3 = r7.f2772a;	 Catch:{ Throwable -> 0x00f3 }
        r3 = com.p070qq.p071e.comm.managers.plugin.C1065c.m3086a(r3);	 Catch:{ Throwable -> 0x00f3 }
        r4 = r7.f2772a;	 Catch:{ Throwable -> 0x00f3 }
        r4 = com.p070qq.p071e.comm.managers.plugin.C1065c.m3088c(r4);	 Catch:{ Throwable -> 0x00f3 }
        r2 = com.p070qq.p071e.comm.C1058a.m3071a(r2, r3, r4);	 Catch:{ Throwable -> 0x00f3 }
        if (r2 == 0) goto L_0x00ec;
    L_0x00da:
        r2 = "RWtxb3jO/9WIesAzpsBHoMTVGmWsvpGAoNUiPqGzDVvxszqElU0z/uVXSKAziaR/I77GNRKD3ECAPD81e5tzAh0W3aNNEC6TP50Tzt4Jzbn2/MFFeHPxCOZGrv4m9iZOHXsx3XkqReLGgA+TfZnNV1BQcaEI0R2edBqcRR73v1U=";
        r7.f2773b = r2;	 Catch:{ Throwable -> 0x00f3 }
        r2 = r7.f2772a;	 Catch:{ Throwable -> 0x00f3 }
        r2 = com.p070qq.p071e.comm.managers.plugin.C1065c.m3086a(r2);	 Catch:{ Throwable -> 0x00f3 }
        r7.f2774c = r2;	 Catch:{ Throwable -> 0x00f3 }
        r2 = 535; // 0x217 float:7.5E-43 double:2.643E-321;
        r7.f2775d = r2;	 Catch:{ Throwable -> 0x00f3 }
        r2 = r1;
        goto L_0x0096;
    L_0x00ec:
        r2 = "Fail to prepair Defult plugin ";
        com.p070qq.p071e.comm.util.GDTLogger.m3131e(r2);	 Catch:{ Throwable -> 0x00f3 }
        r2 = r0;
        goto L_0x0096;
    L_0x00f3:
        r1 = move-exception;
        r2 = "Exception while init plugin manager";
        com.p070qq.p071e.comm.util.GDTLogger.report(r2, r1);	 Catch:{ all -> 0x0110 }
        r1 = new java.lang.StringBuilder;
        r2 = "TimeStap_AFTER_PLUGIN_INIT:";
        r1.<init>(r2);
        r2 = java.lang.System.currentTimeMillis();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.p070qq.p071e.comm.util.GDTLogger.m3130d(r1);
        goto L_0x00af;
    L_0x0110:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r2 = "TimeStap_AFTER_PLUGIN_INIT:";
        r1.<init>(r2);
        r2 = java.lang.System.currentTimeMillis();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.p070qq.p071e.comm.util.GDTLogger.m3130d(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.plugin.PM.a():boolean");
    }

    /* renamed from: b */
    private boolean m3081b() {
        try {
            File file = new File(this.f2772a.getDir("e_qq_com_plugin", 0), "update_lc");
            if (!file.exists()) {
                file.createNewFile();
                StringUtil.writeTo("lock", file);
            }
            if (!file.exists()) {
                return false;
            }
            this.f2777f = new RandomAccessFile(file, "rw");
            this.f2778g = this.f2777f.getChannel().tryLock();
            if (this.f2778g == null) {
                return false;
            }
            this.f2777f.writeByte(37);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public <T> T getFactory(Class<T> cls) {
        GDTLogger.m3130d("GetFactoryInstaceforInterface:" + cls);
        ClassLoader classLoader = this.f2776e;
        if (classLoader == null) {
            throw new C1064b("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
        }
        try {
            String str = (String) f2771i.get(cls);
            if (StringUtil.isEmpty(str)) {
                throw new C1064b("factory  implemention name is not specified for interface:" + cls.getName());
            }
            Class loadClass = classLoader.loadClass(str);
            return cls.cast(loadClass.getDeclaredMethod("getInstance", new Class[0]).invoke(loadClass, new Object[0]));
        } catch (Throwable th) {
            C1064b c1064b = new C1064b("Fail to getfactory implement instance for interface:" + cls.getName(), th);
        }
    }

    public String getLocalSig() {
        return this.f2773b;
    }

    public POFactory getPOFactory() {
        return (POFactory) getFactory(POFactory.class);
    }

    public int getPluginVersion() {
        return this.f2775d;
    }

    public void update(String str, String str2) {
        if (this.f2779h) {
            new C1063a(this.f2772a).mo6467a(str, str2);
        }
    }
}
