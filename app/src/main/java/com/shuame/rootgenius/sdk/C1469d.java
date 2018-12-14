package com.shuame.rootgenius.sdk;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.p013pm.PackageInfo;
import android.content.p013pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Environment;
import com.shuame.rootgenius.sdk.RootGenius.RootListener;
import com.shuame.rootgenius.sdk.p114a.C1463a;
import com.shuame.rootgenius.sdk.p114a.C1464b;
import com.shuame.rootgenius.sdk.p114a.C1465c;
import com.shuame.rootgenius.sdk.proto.C1476b;
import com.shuame.rootgenius.sdk.proto.C1477c;
import com.shuame.rootgenius.sdk.proto.C1479e;
import com.shuame.rootgenius.sdk.proto.C1480f;
import com.shuame.rootgenius.sdk.proto.ProtoBase;
import com.shuame.rootgenius.sdk.proto.ProtoData.DeviceSolution;
import com.shuame.rootgenius.sdk.proto.ProtoData.QueryRootingResult;
import com.shuame.rootgenius.sdk.proto.ProtoData.RootResult;
import com.shuame.rootgenius.sdk.proto.ProtoData.RootingDev;
import com.shuame.rootgenius.sdk.proto.ProtoData.ServerConf;
import com.shuame.rootgenius.sdk.proto.ProtoData.Tried;
import com.shuame.rootgenius.sdk.proto.ProtoData.UnrootResult;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;

@SuppressLint({"DefaultLocale"})
/* renamed from: com.shuame.rootgenius.sdk.d */
public class C1469d {
    /* renamed from: a */
    private static final String f4038a = C1469d.class.getSimpleName();
    /* renamed from: f */
    private static SoftReference f4039f = null;
    /* renamed from: g */
    private static String f4040g = null;
    /* renamed from: h */
    private static String f4041h = null;
    /* renamed from: o */
    private static C1469d f4042o = new C1469d();
    /* renamed from: u */
    private static HashMap f4043u = new HashMap();
    /* renamed from: v */
    private static BroadcastReceiver f4044v = new C1470e();
    /* renamed from: b */
    private RootingDev f4045b = new RootingDev();
    /* renamed from: c */
    private RootResult f4046c = new RootResult();
    /* renamed from: d */
    private UnrootResult f4047d = new UnrootResult();
    /* renamed from: e */
    private ServerConf f4048e = new ServerConf();
    /* renamed from: i */
    private int f4049i = 0;
    /* renamed from: j */
    private boolean f4050j = false;
    /* renamed from: k */
    private boolean f4051k = false;
    /* renamed from: l */
    private long f4052l = 0;
    /* renamed from: m */
    private boolean f4053m = false;
    /* renamed from: n */
    private C1465c f4054n = null;
    /* renamed from: p */
    private C1463a f4055p = null;
    /* renamed from: q */
    private String f4056q = null;
    /* renamed from: r */
    private C1472g f4057r = null;
    /* renamed from: s */
    private QueryRootingResult f4058s = new QueryRootingResult();
    /* renamed from: t */
    private boolean f4059t = false;

    private C1469d() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:82:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01ac  */
    /* renamed from: a */
    private com.shuame.rootgenius.sdk.C1468c m4066a(com.shuame.rootgenius.sdk.proto.ProtoData.RootSolution r12, com.shuame.rootgenius.sdk.JniHelper.Data r13, boolean r14) {
        /*
        r11 = this;
        r1 = new com.shuame.rootgenius.sdk.c;
        r0 = -1;
        r2 = 0;
        r1.<init>(r0, r2);
        r2 = "";
        r0 = f4038a;
        r3 = new java.lang.StringBuilder;
        r4 = "[tryRootingBy] start id:";
        r3.<init>(r4);
        r4 = r12.f4068id;
        r3 = r3.append(r4);
        r4 = ",md5:";
        r3 = r3.append(r4);
        r4 = r12.md5;
        r3 = r3.append(r4);
        r4 = ",url:";
        r3 = r3.append(r4);
        r4 = r12.url;
        r3 = r3.append(r4);
        r4 = ",type:";
        r3 = r3.append(r4);
        r4 = r12.type;
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.shuame.rootgenius.sdk.C1473h.m4104c(r0, r3);
        r4 = new com.shuame.rootgenius.sdk.proto.ProtoData$Tried;
        r4.<init>();
        r6 = java.lang.System.currentTimeMillis();
        r3 = r13.field;
        r5 = "solutionPath";
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r0 = r13.field;
        r9 = "workDir";
        r0 = r0.get(r9);
        r0 = (java.lang.String) r0;
        r0 = r8.append(r0);
        r8 = "Data/Sol/";
        r0 = r0.append(r8);
        r8 = r12.f4068id;
        r0 = r0.append(r8);
        r0 = r0.toString();
        r3.put(r5, r0);
        r0 = r13.field;
        r3 = "solutionParam";
        r5 = r12.param;
        r0.put(r3, r5);
        r0 = r13.field;
        r3 = "lastError";
        r5 = "";
        r0.put(r3, r5);
        r0 = r13.field;
        r3 = "id";
        r5 = r12.f4068id;
        r5 = java.lang.Integer.toString(r5);
        r0.put(r3, r5);
        r0 = r13.field;
        r3 = "solutionType";
        r5 = r12.type;
        r0.put(r3, r5);
        r0 = r12.type;
        r3 = "so";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x00b5;
    L_0x00a8:
        r0 = r13.field;
        r3 = "soluWorkDir";
        r5 = r12.f4068id;
        r5 = com.shuame.rootgenius.sdk.C1474i.m4107a(r5);
        r0.put(r3, r5);
    L_0x00b5:
        r0 = new com.shuame.rootgenius.sdk.i;
        r0.<init>();
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0199 }
        r3.<init>();	 Catch:{ Exception -> 0x0199 }
        r0 = r0.mo7288a(r12, r3);	 Catch:{ Exception -> 0x0199 }
        if (r0 == 0) goto L_0x01c1;
    L_0x00c5:
        r0 = r12.f4068id;	 Catch:{ Exception -> 0x0199 }
        com.shuame.rootgenius.sdk.C1469d.m4068a(r0);	 Catch:{ Exception -> 0x0199 }
        r0 = f4038a;	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
        r3 = "suspendStatReport entry";
        com.shuame.rootgenius.sdk.C1473h.m4103b(r0, r3);	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
        r0 = new java.io.ByteArrayOutputStream;	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
        r0.<init>();	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
        r3 = new java.io.ObjectOutputStream;	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
        r3.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
        r5 = r11.f4046c;	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
        r3.writeObject(r5);	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
        r3.close();	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
        r3 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
        r5 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
        r5.<init>();	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
        r8 = com.shuame.rootgenius.sdk.C1469d.m4073b();	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
        r8 = r8.getFilesDir();	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
        r8 = r8.getAbsolutePath();	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
        r5 = r5.append(r8);	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
        r8 = "/stat";
        r5 = r5.append(r8);	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
        r5 = r5.toString();	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
        r3.<init>(r5);	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
        r5 = r3.exists();	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
        if (r5 == 0) goto L_0x0110;
    L_0x010d:
        r3.delete();	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
    L_0x0110:
        r5 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
        r8 = "rwd";
        r5.<init>(r3, r8);	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
        r0 = r0.toByteArray();	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
        r5.write(r0);	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
        r5.close();	 Catch:{ FileNotFoundException -> 0x0194, IOException -> 0x01a1 }
    L_0x0121:
        r0 = f4038a;	 Catch:{ Exception -> 0x0199 }
        r3 = "[tryRootingBy]entry rgMain";
        com.shuame.rootgenius.sdk.C1473h.m4104c(r0, r3);	 Catch:{ Exception -> 0x0199 }
        r0 = com.shuame.rootgenius.sdk.JniHelper.rgMain(r13);	 Catch:{ Exception -> 0x0199 }
        r1.f4036a = r0;	 Catch:{ Exception -> 0x0199 }
        r0 = f4038a;	 Catch:{ Exception -> 0x0199 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0199 }
        r5 = "[tryRootingBy]finish rgMain result:";
        r3.<init>(r5);	 Catch:{ Exception -> 0x0199 }
        r5 = r1.f4036a;	 Catch:{ Exception -> 0x0199 }
        r3 = r3.append(r5);	 Catch:{ Exception -> 0x0199 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0199 }
        com.shuame.rootgenius.sdk.C1473h.m4104c(r0, r3);	 Catch:{ Exception -> 0x0199 }
        r0 = r1.f4036a;	 Catch:{ Exception -> 0x0199 }
        r3 = 2;
        if (r0 != r3) goto L_0x014c;
    L_0x0149:
        r0 = -1;
        r1.f4036a = r0;	 Catch:{ Exception -> 0x0199 }
    L_0x014c:
        r0 = r13.field;	 Catch:{ Exception -> 0x0199 }
        r3 = "lastError";
        r0 = r0.get(r3);	 Catch:{ Exception -> 0x0199 }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0199 }
        if (r14 != 0) goto L_0x02e9;
    L_0x0158:
        r2 = 0;
        r1.f4037b = r2;	 Catch:{ Exception -> 0x02e3, all -> 0x02df }
        r2 = r1.f4036a;	 Catch:{ Exception -> 0x02e3, all -> 0x02df }
        if (r2 != 0) goto L_0x02e9;
    L_0x015f:
        r2 = r12.type;	 Catch:{ Exception -> 0x02e3, all -> 0x02df }
        r3 = "lua";
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x02e3, all -> 0x02df }
        if (r2 != 0) goto L_0x0171;
    L_0x0169:
        r2 = r11.f4055p;	 Catch:{ Exception -> 0x02e3, all -> 0x02df }
        r2 = r2.mo7260d();	 Catch:{ Exception -> 0x02e3, all -> 0x02df }
        if (r2 == 0) goto L_0x02e9;
    L_0x0171:
        r2 = 1;
        r1.f4036a = r2;	 Catch:{ Exception -> 0x02e3, all -> 0x02df }
        r2 = r11.f4055p;	 Catch:{ Exception -> 0x02e3, all -> 0x02df }
        r2 = r2.f4029c;	 Catch:{ Exception -> 0x02e3, all -> 0x02df }
        if (r2 == 0) goto L_0x02e9;
    L_0x017a:
        r2 = 2;
        r1.f4036a = r2;	 Catch:{ Exception -> 0x02e3, all -> 0x02df }
        r2 = r11.mo7280g();	 Catch:{ Exception -> 0x02e3, all -> 0x02df }
        if (r2 == 0) goto L_0x01ae;
    L_0x0183:
        r2 = r1.f4037b;	 Catch:{ Exception -> 0x02e3, all -> 0x02df }
        r3 = 8;
        if (r2 != r3) goto L_0x018c;
    L_0x0189:
        r2 = 0;
        r1.f4037b = r2;	 Catch:{ Exception -> 0x02e3, all -> 0x02df }
    L_0x018c:
        r2 = 1;
        r1.f4036a = r2;	 Catch:{ Exception -> 0x02e3, all -> 0x02df }
        r2 = r0;
    L_0x0190:
        if (r14 == 0) goto L_0x01d8;
    L_0x0192:
        r0 = r1;
    L_0x0193:
        return r0;
    L_0x0194:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x0199 }
        goto L_0x0121;
    L_0x0199:
        r0 = move-exception;
    L_0x019a:
        r0.printStackTrace();	 Catch:{ all -> 0x01a7 }
        if (r14 == 0) goto L_0x0231;
    L_0x019f:
        r0 = r1;
        goto L_0x0193;
    L_0x01a1:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x0199 }
        goto L_0x0121;
    L_0x01a7:
        r0 = move-exception;
        r3 = r2;
        r2 = r0;
    L_0x01aa:
        if (r14 == 0) goto L_0x0288;
    L_0x01ac:
        r0 = r1;
        goto L_0x0193;
    L_0x01ae:
        r2 = new java.io.File;	 Catch:{ Exception -> 0x02e3, all -> 0x02df }
        r3 = "/system/xbin/su";
        r2.<init>(r3);	 Catch:{ Exception -> 0x02e3, all -> 0x02df }
        r2 = r2.exists();	 Catch:{ Exception -> 0x02e3, all -> 0x02df }
        if (r2 != 0) goto L_0x01bf;
    L_0x01bb:
        r2 = -14;
        r1.f4036a = r2;	 Catch:{ Exception -> 0x02e3, all -> 0x02df }
    L_0x01bf:
        r2 = r0;
        goto L_0x0190;
    L_0x01c1:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0199 }
        r0.<init>();	 Catch:{ Exception -> 0x0199 }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x0199 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0199 }
        r0 = r0.append(r3);	 Catch:{ Exception -> 0x0199 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0199 }
        r2 = r0;
        goto L_0x0190;
    L_0x01d8:
        r0 = r12.f4068id;
        r4.f4069id = r0;
        r0 = r1.f4036a;
        r3 = 1;
        if (r0 == r3) goto L_0x01e6;
    L_0x01e1:
        r0 = r1.f4036a;
        r3 = 2;
        if (r0 != r3) goto L_0x022e;
    L_0x01e6:
        r0 = 1;
    L_0x01e7:
        r4.result = r0;
        r8 = java.lang.System.currentTimeMillis();
        r6 = r8 - r6;
        r0 = (int) r6;
        r4.timeUsed = r0;
        r4.description = r2;
        r0 = r1.f4036a;
        r2 = 2;
        if (r0 != r2) goto L_0x020c;
    L_0x01f9:
        r0 = new java.lang.StringBuilder;
        r2 = "[need_reboot]";
        r0.<init>(r2);
        r2 = r4.description;
        r0 = r0.append(r2);
        r0 = r0.toString();
        r4.description = r0;
    L_0x020c:
        r0 = r11.f4046c;
        r0 = r0.triedSolutions;
        r0 = r0.triedList;
        r0.add(r4);
        r0 = f4038a;
        r2 = new java.lang.StringBuilder;
        r3 = "[tryRootingBy]done,result:";
        r2.<init>(r3);
        r3 = r1.f4036a;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.rootgenius.sdk.C1473h.m4104c(r0, r2);
    L_0x022b:
        r0 = r1;
        goto L_0x0193;
    L_0x022e:
        r0 = r1.f4036a;
        goto L_0x01e7;
    L_0x0231:
        r0 = r12.f4068id;
        r4.f4069id = r0;
        r0 = r1.f4036a;
        r3 = 1;
        if (r0 == r3) goto L_0x023f;
    L_0x023a:
        r0 = r1.f4036a;
        r3 = 2;
        if (r0 != r3) goto L_0x0285;
    L_0x023f:
        r0 = 1;
    L_0x0240:
        r4.result = r0;
        r8 = java.lang.System.currentTimeMillis();
        r6 = r8 - r6;
        r0 = (int) r6;
        r4.timeUsed = r0;
        r4.description = r2;
        r0 = r1.f4036a;
        r2 = 2;
        if (r0 != r2) goto L_0x0265;
    L_0x0252:
        r0 = new java.lang.StringBuilder;
        r2 = "[need_reboot]";
        r0.<init>(r2);
        r2 = r4.description;
        r0 = r0.append(r2);
        r0 = r0.toString();
        r4.description = r0;
    L_0x0265:
        r0 = r11.f4046c;
        r0 = r0.triedSolutions;
        r0 = r0.triedList;
        r0.add(r4);
        r0 = f4038a;
        r2 = new java.lang.StringBuilder;
        r3 = "[tryRootingBy]done,result:";
        r2.<init>(r3);
        r3 = r1.f4036a;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.rootgenius.sdk.C1473h.m4104c(r0, r2);
        goto L_0x022b;
    L_0x0285:
        r0 = r1.f4036a;
        goto L_0x0240;
    L_0x0288:
        r0 = r12.f4068id;
        r4.f4069id = r0;
        r0 = r1.f4036a;
        r5 = 1;
        if (r0 == r5) goto L_0x0296;
    L_0x0291:
        r0 = r1.f4036a;
        r5 = 2;
        if (r0 != r5) goto L_0x02dc;
    L_0x0296:
        r0 = 1;
    L_0x0297:
        r4.result = r0;
        r8 = java.lang.System.currentTimeMillis();
        r6 = r8 - r6;
        r0 = (int) r6;
        r4.timeUsed = r0;
        r4.description = r3;
        r0 = r1.f4036a;
        r3 = 2;
        if (r0 != r3) goto L_0x02bc;
    L_0x02a9:
        r0 = new java.lang.StringBuilder;
        r3 = "[need_reboot]";
        r0.<init>(r3);
        r3 = r4.description;
        r0 = r0.append(r3);
        r0 = r0.toString();
        r4.description = r0;
    L_0x02bc:
        r0 = r11.f4046c;
        r0 = r0.triedSolutions;
        r0 = r0.triedList;
        r0.add(r4);
        r0 = f4038a;
        r3 = new java.lang.StringBuilder;
        r4 = "[tryRootingBy]done,result:";
        r3.<init>(r4);
        r1 = r1.f4036a;
        r1 = r3.append(r1);
        r1 = r1.toString();
        com.shuame.rootgenius.sdk.C1473h.m4104c(r0, r1);
        throw r2;
    L_0x02dc:
        r0 = r1.f4036a;
        goto L_0x0297;
    L_0x02df:
        r2 = move-exception;
        r3 = r0;
        goto L_0x01aa;
    L_0x02e3:
        r2 = move-exception;
        r10 = r2;
        r2 = r0;
        r0 = r10;
        goto L_0x019a;
    L_0x02e9:
        r2 = r0;
        goto L_0x0190;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.sdk.d.a(com.shuame.rootgenius.sdk.proto.ProtoData$RootSolution, com.shuame.rootgenius.sdk.JniHelper$Data, boolean):com.shuame.rootgenius.sdk.c");
    }

    /* renamed from: a */
    public static C1469d m4067a() {
        return f4042o;
    }

    /* renamed from: a */
    private static void m4068a(int i) {
        Context b = C1469d.m4073b();
        if (b != null) {
            Editor edit = b.getSharedPreferences(RgsdkConfig.RGSDK_PREF, 0).edit();
            edit.putInt("reboot_tried", i);
            if (i != -1) {
                edit.putLong("reboot_tried_at", System.currentTimeMillis());
            } else {
                edit.putLong("reboot_tried_at", -1);
            }
            edit.commit();
        }
    }

    /* renamed from: a */
    private void m4069a(C1468c c1468c, RootListener rootListener) {
        int i = -1;
        C1473h.m4103b(f4038a, "[onRootFinish]entry");
        if (c1468c.f4036a == 1 && this.f4055p.f4028b && !this.f4055p.mo7262f().isEmpty()) {
            this.f4057r.mo7286a(this.f4055p.mo7262f(), true);
        }
        this.f4046c.totalTimeUsed = (int) (System.currentTimeMillis() - this.f4052l);
        C1479e.m4121a().mo7293a(this.f4046c, this.f4055p.mo7263g());
        C1469d.m4068a(-1);
        File file = new File(f4040g + "stat");
        if (file.exists()) {
            file.delete();
        }
        if (rootListener != null) {
            rootListener.onProgress(100);
            if (c1468c.f4036a != -6) {
                i = c1468c.f4036a;
            }
            rootListener.onResult(i);
            rootListener.onProcess(c1468c.f4037b);
        }
        C1473h.m4103b(f4038a, "[onRootFinish]finish");
    }

    /* renamed from: a */
    private static void m4071a(boolean z) {
        if (z) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addDataScheme("package");
            C1469d.m4073b().registerReceiver(f4044v, intentFilter);
            return;
        }
        f4043u.clear();
        C1469d.m4073b().unregisterReceiver(f4044v);
    }

    /* renamed from: b */
    public static int m4072b(String str) {
        boolean z;
        PackageInfo packageArchiveInfo = C1469d.m4073b().getPackageManager().getPackageArchiveInfo(str, 0);
        C1469d.m4071a(true);
        if (packageArchiveInfo != null) {
            int i = 20000;
            String str2 = packageArchiveInfo.applicationInfo.packageName;
            if (C1469d.m4080f(str2) < packageArchiveInfo.versionCode) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
                intent.setFlags(268435456);
                C1469d.m4073b().startActivity(intent);
                while (true) {
                    try {
                        Thread.sleep(3000);
                        int i2 = i - 3000;
                        if (str2 != null && C1469d.m4080f(str2) > 0 && f4043u.containsKey(str2) && ((Boolean) f4043u.get(str2)).booleanValue()) {
                            z = false;
                            break;
                        } else if (i2 <= 0) {
                            z = true;
                            break;
                        } else {
                            i = i2;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return -1;
                    }
                }
            }
            C1469d.m4071a(false);
            return 0;
        }
        z = true;
        C1469d.m4071a(false);
        return z;
    }

    /* renamed from: b */
    public static Context m4073b() {
        return f4039f != null ? (Context) f4039f.get() : null;
    }

    /* renamed from: c */
    public static int m4074c(String str) {
        C1469d.m4073b().startActivity(new Intent("android.intent.action.DELETE", Uri.parse("package:" + str)));
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x008a A:{Catch:{ Exception -> 0x00f0 }} */
    /* renamed from: c */
    private synchronized void m4075c(android.content.Context r10) {
        /*
        r9 = this;
        r8 = -1;
        r2 = 1;
        r3 = 0;
        monitor-enter(r9);
        r5 = new java.io.File;	 Catch:{ Exception -> 0x00f0 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00f0 }
        r0.<init>();	 Catch:{ Exception -> 0x00f0 }
        r1 = r10.getFilesDir();	 Catch:{ Exception -> 0x00f0 }
        r1 = r1.getAbsolutePath();	 Catch:{ Exception -> 0x00f0 }
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x00f0 }
        r1 = "/stat";
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x00f0 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00f0 }
        r5.<init>(r0);	 Catch:{ Exception -> 0x00f0 }
        r0 = f4038a;	 Catch:{ Exception -> 0x00f0 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00f0 }
        r4 = "sendStatReport,file size:";
        r1.<init>(r4);	 Catch:{ Exception -> 0x00f0 }
        r6 = r5.length();	 Catch:{ Exception -> 0x00f0 }
        r1 = r1.append(r6);	 Catch:{ Exception -> 0x00f0 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00f0 }
        com.shuame.rootgenius.sdk.C1473h.m4104c(r0, r1);	 Catch:{ Exception -> 0x00f0 }
        r0 = r5.exists();	 Catch:{ Exception -> 0x00f0 }
        if (r0 == 0) goto L_0x00fb;
    L_0x0042:
        r1 = new java.io.ObjectInputStream;	 Catch:{ Exception -> 0x00f0 }
        r0 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x00f0 }
        r0.<init>(r5);	 Catch:{ Exception -> 0x00f0 }
        r1.<init>(r0);	 Catch:{ Exception -> 0x00f0 }
        r0 = r1.readObject();	 Catch:{ Exception -> 0x00f0 }
        r0 = (com.shuame.rootgenius.sdk.proto.ProtoData.RootResult) r0;	 Catch:{ Exception -> 0x00f0 }
        r1.close();	 Catch:{ Exception -> 0x00f0 }
        if (r0 != 0) goto L_0x0060;
    L_0x0057:
        r0 = f4038a;	 Catch:{ Exception -> 0x00f0 }
        r1 = "sendStatReport,read object null";
        com.shuame.rootgenius.sdk.C1473h.m4105d(r0, r1);	 Catch:{ Exception -> 0x00f0 }
    L_0x005e:
        monitor-exit(r9);
        return;
    L_0x0060:
        r6 = com.shuame.rootgenius.sdk.C1469d.m4084l();	 Catch:{ Exception -> 0x00f0 }
        if (r6 == r8) goto L_0x00a1;
    L_0x0066:
        r7 = com.shuame.rootgenius.sdk.p114a.C1463a.m4035b();	 Catch:{ Exception -> 0x00f0 }
        r1 = r0.triedSolutions;	 Catch:{ Exception -> 0x00f0 }
        r1 = r1.triedList;	 Catch:{ Exception -> 0x00f0 }
        r4 = r1.iterator();	 Catch:{ Exception -> 0x00f0 }
    L_0x0072:
        r1 = r4.hasNext();	 Catch:{ Exception -> 0x00f0 }
        if (r1 == 0) goto L_0x0104;
    L_0x0078:
        r1 = r4.next();	 Catch:{ Exception -> 0x00f0 }
        r1 = (com.shuame.rootgenius.sdk.proto.ProtoData.Tried) r1;	 Catch:{ Exception -> 0x00f0 }
        r8 = r1.f4069id;	 Catch:{ Exception -> 0x00f0 }
        if (r8 != r6) goto L_0x0072;
    L_0x0082:
        if (r7 == 0) goto L_0x00c3;
    L_0x0084:
        r4 = r2;
    L_0x0085:
        r1.result = r4;	 Catch:{ Exception -> 0x00f0 }
        r1 = r2;
    L_0x0088:
        if (r1 != 0) goto L_0x00a1;
    L_0x008a:
        r4 = new com.shuame.rootgenius.sdk.proto.ProtoData$Tried;	 Catch:{ Exception -> 0x00f0 }
        r4.<init>();	 Catch:{ Exception -> 0x00f0 }
        r4.f4069id = r6;	 Catch:{ Exception -> 0x00f0 }
        if (r7 == 0) goto L_0x00c5;
    L_0x0093:
        r1 = r2;
    L_0x0094:
        r4.result = r1;	 Catch:{ Exception -> 0x00f0 }
        r1 = "[rebooted-checking-root]";
        r4.description = r1;	 Catch:{ Exception -> 0x00f0 }
        r1 = r0.triedSolutions;	 Catch:{ Exception -> 0x00f0 }
        r1 = r1.triedList;	 Catch:{ Exception -> 0x00f0 }
        r1.add(r4);	 Catch:{ Exception -> 0x00f0 }
    L_0x00a1:
        r1 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r1 = com.shuame.rootgenius.sdk.CommUtils.checkActiveNetworkConnected(r10, r1);	 Catch:{ Exception -> 0x00f0 }
        if (r1 == 0) goto L_0x00ce;
    L_0x00a9:
        r1 = 2;
    L_0x00aa:
        if (r1 <= 0) goto L_0x00c7;
    L_0x00ac:
        r2 = com.shuame.rootgenius.sdk.proto.C1479e.m4121a();	 Catch:{ Exception -> 0x00f0 }
        r3 = r9.f4055p;	 Catch:{ Exception -> 0x00f0 }
        r3 = r3.mo7263g();	 Catch:{ Exception -> 0x00f0 }
        r2 = r2.mo7294b(r0, r3);	 Catch:{ Exception -> 0x00f0 }
        r2 = com.shuame.rootgenius.sdk.proto.ProtoBase.isSuccess(r2);	 Catch:{ Exception -> 0x00f0 }
        if (r2 != 0) goto L_0x00c7;
    L_0x00c0:
        r1 = r1 + -1;
        goto L_0x00aa;
    L_0x00c3:
        r4 = r3;
        goto L_0x0085;
    L_0x00c5:
        r1 = r3;
        goto L_0x0094;
    L_0x00c7:
        r5.delete();	 Catch:{ Exception -> 0x00f0 }
        r0 = -1;
        com.shuame.rootgenius.sdk.C1469d.m4068a(r0);	 Catch:{ Exception -> 0x00f0 }
    L_0x00ce:
        r0 = f4038a;	 Catch:{ Exception -> 0x00f0 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00f0 }
        r2 = "sendStatReport,id ";
        r1.<init>(r2);	 Catch:{ Exception -> 0x00f0 }
        r1 = r1.append(r6);	 Catch:{ Exception -> 0x00f0 }
        r2 = ",result:";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00f0 }
        r2 = r9.f4053m;	 Catch:{ Exception -> 0x00f0 }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00f0 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00f0 }
        com.shuame.rootgenius.sdk.C1473h.m4104c(r0, r1);	 Catch:{ Exception -> 0x00f0 }
        goto L_0x005e;
    L_0x00f0:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x00f6 }
        goto L_0x005e;
    L_0x00f6:
        r0 = move-exception;
        throw r0;	 Catch:{ all -> 0x00f8 }
    L_0x00f8:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
    L_0x00fb:
        r0 = f4038a;	 Catch:{ Exception -> 0x00f0 }
        r1 = "sendStatReport stat file not exists!";
        com.shuame.rootgenius.sdk.C1473h.m4104c(r0, r1);	 Catch:{ Exception -> 0x00f0 }
        goto L_0x005e;
    L_0x0104:
        r1 = r3;
        goto L_0x0088;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.sdk.d.c(android.content.Context):void");
    }

    /* renamed from: d */
    private void m4076d(Context context) {
        new Thread(new C1471f(this, context)).start();
    }

    /* renamed from: e */
    public static int m4077e() {
        return 0;
    }

    /* renamed from: e */
    public static void m4078e(String str) {
        CommUtils.execCmd(str + " ln -s " + str + " " + f4040g + "Data/Bin/busybox");
    }

    /* renamed from: e */
    private static boolean m4079e(Context context) {
        boolean z = false;
        if (context != null) {
            z = JniHelper.verify(context);
            C1473h.m4104c(f4038a, "[verify]result..." + z);
        }
        if (!z) {
            C1473h.m4104c(f4038a, "[verify]fail...");
        }
        return z;
    }

    /* renamed from: f */
    private static int m4080f(String str) {
        try {
            PackageInfo packageInfo = C1469d.m4073b().getPackageManager().getPackageInfo(str, 0);
            return (str == null || packageInfo == null) ? 0 : packageInfo.versionCode;
        } catch (NameNotFoundException e) {
            return 0;
        }
    }

    /* renamed from: g */
    private boolean m4081g(String str) {
        if (this.f4056q != null && this.f4055p == this.f4054n) {
            C1473h.m4104c(f4038a, "[startRoot] try to unzip superuser from download");
            C1463a c1464b = new C1464b(f4040g);
            if (c1464b.mo7264a(this.f4056q, str)) {
                C1473h.m4104c(f4038a, "[startRoot] unzip superuser success");
                this.f4055p = c1464b;
                return true;
            }
            C1473h.m4104c(f4038a, "[startRoot] unzip superuser fail");
        }
        return false;
    }

    /* renamed from: l */
    private static int m4084l() {
        Context b = C1469d.m4073b();
        if (b == null) {
            return -1;
        }
        SharedPreferences sharedPreferences = b.getSharedPreferences(RgsdkConfig.RGSDK_PREF, 0);
        return System.currentTimeMillis() - sharedPreferences.getLong("reboot_tried_at", -1) <= 600000 ? sharedPreferences.getInt("reboot_tried", -1) : -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:96:0x03ea A:{PHI: r1 , ExcHandler: all (th java.lang.Throwable), Splitter: B:8:0x004c} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:58:0x01b6, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:59:0x01b7, code:
            r11 = r0;
            r0 = r1;
            r1 = r11;
     */
    /* JADX WARNING: Missing block: B:96:0x03ea, code:
            r0 = th;
     */
    /* renamed from: a */
    public final int mo7269a(com.shuame.rootgenius.sdk.RootGenius.RootListener r13) {
        /*
        r12 = this;
        r3 = 0;
        r4 = -1;
        r10 = 1;
        r2 = 0;
        r0 = r12.f4059t;
        if (r0 == 0) goto L_0x0043;
    L_0x0008:
        r0 = r12.f4046c;
        r1 = r0.flag;
        r1 = r1 | 8;
        r0.flag = r1;
        r12.f4059t = r2;
    L_0x0012:
        r1 = new com.shuame.rootgenius.sdk.c;
        r1.<init>(r4, r2);
        r0 = f4038a;
        r4 = "[startRoot]begining";
        com.shuame.rootgenius.sdk.C1473h.m4104c(r0, r4);
        r0 = r12.f4046c;
        r0 = r0.triedSolutions;
        r0 = r0.triedList;
        r0.clear();
        r4 = java.lang.System.currentTimeMillis();
        r12.f4052l = r4;
        r0 = com.shuame.rootgenius.sdk.C1469d.m4073b();
        r4 = r12.f4055p;
        r4.mo7259c();
        if (r0 != 0) goto L_0x004c;
    L_0x0038:
        r12.m4069a(r1, r13);
        r0 = new java.lang.Exception;
        r1 = "context is null.should call initialize first.";
        r0.<init>(r1);
        throw r0;
    L_0x0043:
        r0 = r12.f4046c;
        r1 = r0.flag;
        r1 = r1 & -9;
        r0.flag = r1;
        goto L_0x0012;
    L_0x004c:
        r4 = f4038a;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r5 = "[startRoot]verifying";
        com.shuame.rootgenius.sdk.C1473h.m4103b(r4, r5);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = com.shuame.rootgenius.sdk.C1469d.m4079e(r0);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        if (r0 != 0) goto L_0x007d;
    L_0x0059:
        r0 = f4038a;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r2 = "[startRoot]verify fail";
        com.shuame.rootgenius.sdk.C1473h.m4103b(r0, r2);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r1;
    L_0x0061:
        r12.m4069a(r0, r13);
    L_0x0064:
        r1 = f4038a;
        r2 = new java.lang.StringBuilder;
        r3 = "[startRoot]done,result:";
        r2.<init>(r3);
        r3 = r0.f4036a;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.shuame.rootgenius.sdk.C1473h.m4104c(r1, r2);
        r0 = r0.f4036a;
        return r0;
    L_0x007d:
        if (r13 == 0) goto L_0x0083;
    L_0x007f:
        r0 = 1;
        r13.onProgress(r0);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
    L_0x0083:
        r0 = r12.f4058s;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r0.result;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = com.shuame.rootgenius.sdk.proto.ProtoBase.isSuccess(r0);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        if (r0 == 0) goto L_0x009c;
    L_0x008d:
        r0 = r12.f4058s;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r0.f4067su;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        if (r0 == 0) goto L_0x009c;
    L_0x0093:
        r0 = r12.f4058s;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r0.f4067su;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r0.md5;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r12.m4081g(r0);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
    L_0x009c:
        if (r13 == 0) goto L_0x00a2;
    L_0x009e:
        r0 = 7;
        r13.onProcess(r0);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
    L_0x00a2:
        r0 = r12.f4058s;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r0.result;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = com.shuame.rootgenius.sdk.proto.ProtoBase.isSuccess(r0);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        if (r0 == 0) goto L_0x017d;
    L_0x00ac:
        r0 = r12.f4058s;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r4 = f4038a;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r5 = "[startRoot]use pre request solution";
        com.shuame.rootgenius.sdk.C1473h.m4104c(r4, r5);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r5 = r0;
    L_0x00b6:
        r0 = r5.result;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = com.shuame.rootgenius.sdk.proto.ProtoBase.isSuccess(r0);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        if (r0 == 0) goto L_0x01c7;
    L_0x00be:
        r0 = r5.productId;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r0.isEmpty();	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        if (r0 != 0) goto L_0x01ac;
    L_0x00c6:
        r0 = r12.f4045b;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r0.phoneInfo;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r4 = r5.productId;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.productId = r4;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
    L_0x00ce:
        r0 = f4038a;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "[startRoot]request solution success, product_id:";
        r4.<init>(r6);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = r12.f4045b;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = r6.phoneInfo;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = r6.productId;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r4 = r4.append(r6);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r4 = r4.toString();	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        com.shuame.rootgenius.sdk.C1473h.m4104c(r0, r4);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r12.f4051k;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        if (r0 == 0) goto L_0x0116;
    L_0x00ec:
        r0 = f4038a;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r4 = "[startRoot]mRemoteTest is true";
        com.shuame.rootgenius.sdk.C1473h.m4103b(r0, r4);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r4 = r2;
    L_0x00f4:
        r0 = r5.solus;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r0.size();	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        if (r4 >= r0) goto L_0x0402;
    L_0x00fc:
        r0 = r5.solus;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r0.get(r4);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = (com.shuame.rootgenius.sdk.proto.ProtoData.RootSolution) r0;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = r0.f4068id;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r12.f4049i;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        if (r6 != r7) goto L_0x01c2;
    L_0x010a:
        r4 = r5.solus;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r4.clear();	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        if (r0 == 0) goto L_0x0116;
    L_0x0111:
        r4 = r5.solus;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r4.add(r0);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
    L_0x0116:
        r0 = r12.f4058s;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r0.result;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = com.shuame.rootgenius.sdk.proto.ProtoBase.isSuccess(r0);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        if (r0 == 0) goto L_0x012f;
    L_0x0120:
        r0 = r12.f4058s;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r0.f4067su;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        if (r0 == 0) goto L_0x012f;
    L_0x0126:
        r0 = r12.f4058s;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r0.f4067su;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r0.md5;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r12.m4081g(r0);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
    L_0x012f:
        r0 = r12.f4050j;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        if (r0 == 0) goto L_0x0168;
    L_0x0133:
        r0 = f4038a;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "[startRoot]mLocalTest is true, use local id:";
        r4.<init>(r6);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = r12.f4049i;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r4 = r4.append(r6);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r4 = r4.toString();	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        com.shuame.rootgenius.sdk.C1473h.m4103b(r0, r4);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r12.f4045b;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r0.phoneInfo;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r4 = "local-test";
        r0.productId = r4;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r5.solus;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.clear();	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r5.solus;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r4 = r12.f4049i;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "lua";
        r7 = new com.shuame.rootgenius.sdk.proto.ProtoData$RootSolution;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7.<init>();	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7.f4068id = r4;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7.type = r6;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.add(r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
    L_0x0168:
        r0 = r5.solus;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r0.size();	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        if (r0 != 0) goto L_0x01f0;
    L_0x0170:
        r0 = f4038a;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r2 = "[startRoot]query result not support";
        com.shuame.rootgenius.sdk.C1473h.m4105d(r0, r2);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = -4;
        r1.f4036a = r0;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r1;
        goto L_0x0061;
    L_0x017d:
        r0 = f4038a;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r4 = "[startRoot]none pre request, request solution now...";
        com.shuame.rootgenius.sdk.C1473h.m4104c(r0, r4);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = new com.shuame.rootgenius.sdk.proto.ProtoData$QueryRootingResult;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.<init>();	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r4 = new com.shuame.rootgenius.sdk.proto.b;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r4.<init>();	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r5 = r12.f4045b;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r4.mo7290a(r5, r0);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r4 = f4038a;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "[startRoot]request solution finish qrRes.result:";
        r5.<init>(r6);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = r0.result;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r5 = r5.toString();	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        com.shuame.rootgenius.sdk.C1473h.m4104c(r4, r5);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r5 = r0;
        goto L_0x00b6;
    L_0x01ac:
        r0 = r12.f4045b;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r0.phoneInfo;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r4 = "query-empty";
        r0.productId = r4;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        goto L_0x00ce;
    L_0x01b6:
        r0 = move-exception;
        r11 = r0;
        r0 = r1;
        r1 = r11;
    L_0x01ba:
        r1.printStackTrace();	 Catch:{ all -> 0x03f4 }
        r12.m4069a(r0, r13);
        goto L_0x0064;
    L_0x01c2:
        r0 = r4 + 1;
        r4 = r0;
        goto L_0x00f4;
    L_0x01c7:
        r0 = f4038a;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r2 = "[startRoot]request solution fail";
        com.shuame.rootgenius.sdk.C1473h.m4105d(r0, r2);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r12.f4045b;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r0.phoneInfo;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r3 = "query-failed:";
        r2.<init>(r3);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r3 = r5.result;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r2 = r2.toString();	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.productId = r2;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = -11;
        r1.f4036a = r0;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r1;
        goto L_0x0061;
    L_0x01f0:
        r4 = new com.shuame.rootgenius.sdk.JniHelper$Data;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r4.<init>();	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = com.shuame.rootgenius.sdk.C1469d.m4073b();	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r4.cntx = r0;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = new java.util.HashMap;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.<init>();	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r4.field = r0;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "callFunc";
        r7 = "main";
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "executePath";
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7.<init>();	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r8 = f4040g;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r8 = "Data/Bin/";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.toString();	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "rootgeniusVer";
        r7 = 84;
        r7 = java.lang.Integer.toString(r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "androidSdkVer";
        r7 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = java.lang.Integer.toString(r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "productId";
        r7 = r5.productId;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "androidVer";
        r7 = r12.f4045b;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.phoneInfo;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.androidVersion;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "buildDescription";
        r7 = r12.f4045b;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.phoneInfo;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.buildDescription;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "coreVer";
        r7 = r12.f4045b;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.phoneInfo;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.kernel;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "serial";
        r7 = r12.f4045b;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.phoneInfo;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.adb;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.serial;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "macAddr";
        r7 = r12.f4045b;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.phoneId;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.mac;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "workDir";
        r7 = f4040g;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "tempDir";
        r7 = f4041h;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "installScript";
        r7 = r12.f4055p;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.mo7261e();	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "instSuScript";
        r7 = r12.f4055p;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.mo7261e();	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = com.shuame.rootgenius.sdk.CommUtils.readFrom(r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r8 = "#!/system/bin/sh";
        r9 = "";
        r7 = r7.replace(r8, r9);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "tempRoot";
        r7 = "false";
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "IMEI";
        r7 = r12.f4045b;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.phoneId;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.phimei;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "IMSI";
        r7 = r12.f4045b;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.phoneId;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.imsi;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "rid";
        r7 = r12.f4045b;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.phoneId;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.rid;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "productModel";
        r7 = r12.f4045b;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.phoneInfo;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.productModel;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "productDevice";
        r7 = r12.f4045b;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.phoneInfo;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.productDevice;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "roHardware";
        r7 = r12.f4045b;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.phoneInfo;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.phoneHardware;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "neo";
        r7 = r5.neo;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "phoneId";
        r7 = r12.f4045b;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.phoneInfo;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.phoneId;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "versionName";
        r7 = com.shuame.rootgenius.sdk.RgsdkConfig.sChVersionName;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r5.rootEngine;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        if (r0 == 0) goto L_0x0355;
    L_0x033f:
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "rootEngineUrl";
        r7 = r5.rootEngine;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.url;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "rootEngineMd5";
        r7 = r5.rootEngine;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.md5;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
    L_0x0355:
        r0 = r4.field;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "phoneId";
        r7 = r12.f4045b;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.phoneInfo;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r7 = r7.phoneId;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.put(r6, r7);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0.<init>();	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = f4040g;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r0.append(r6);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = "Data/Sol/";
        r0 = r0.append(r6);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = r0.toString();	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        com.shuame.rootgenius.sdk.C1474i.f4065a = r0;	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r6 = com.shuame.rootgenius.sdk.C1469d.m4084l();	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
        r0 = -1;
        com.shuame.rootgenius.sdk.C1469d.m4068a(r0);	 Catch:{ Exception -> 0x01b6, all -> 0x03ea }
    L_0x0381:
        r0 = r5.solus;	 Catch:{ Exception -> 0x03f9, all -> 0x03ea }
        r0 = r0.size();	 Catch:{ Exception -> 0x03f9, all -> 0x03ea }
        if (r2 >= r0) goto L_0x03ff;
    L_0x0389:
        r0 = r2 + 1;
        r0 = r0 * 75;
        r7 = r5.solus;	 Catch:{ Exception -> 0x03f9, all -> 0x03ea }
        r7 = r7.size();	 Catch:{ Exception -> 0x03f9, all -> 0x03ea }
        r7 = r7 + 1;
        r0 = r0 / r7;
        r0 = r0 + 15;
        if (r13 == 0) goto L_0x039d;
    L_0x039a:
        r13.onProgress(r0);	 Catch:{ Exception -> 0x03f9, all -> 0x03ea }
    L_0x039d:
        r0 = r5.solus;	 Catch:{ Exception -> 0x03f9, all -> 0x03ea }
        r0 = r0.get(r2);	 Catch:{ Exception -> 0x03f9, all -> 0x03ea }
        r0 = (com.shuame.rootgenius.sdk.proto.ProtoData.RootSolution) r0;	 Catch:{ Exception -> 0x03f9, all -> 0x03ea }
        r7 = r0.f4068id;	 Catch:{ Exception -> 0x03f9, all -> 0x03ea }
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r7 != r8) goto L_0x03ac;
    L_0x03ab:
        r3 = r0;
    L_0x03ac:
        r7 = r0.f4068id;	 Catch:{ Exception -> 0x03f9, all -> 0x03ea }
        if (r7 != r6) goto L_0x03ba;
    L_0x03b0:
        r7 = r2 + 1;
        r8 = r5.solus;	 Catch:{ Exception -> 0x03f9, all -> 0x03ea }
        r8 = r8.size();	 Catch:{ Exception -> 0x03f9, all -> 0x03ea }
        if (r7 < r8) goto L_0x03e4;
    L_0x03ba:
        r7 = 0;
        r0 = r12.m4066a(r0, r4, r7);	 Catch:{ Exception -> 0x03f9, all -> 0x03ea }
        r1 = r0.f4036a;	 Catch:{ Exception -> 0x03e1, all -> 0x03ef }
        if (r1 == r10) goto L_0x03c8;
    L_0x03c3:
        r1 = r0.f4036a;	 Catch:{ Exception -> 0x03e1, all -> 0x03ef }
        r7 = 2;
        if (r1 != r7) goto L_0x03e5;
    L_0x03c8:
        if (r3 == 0) goto L_0x0061;
    L_0x03ca:
        r1 = r12.f4048e;	 Catch:{ Exception -> 0x03e1, all -> 0x03ef }
        r1 = r1.val;	 Catch:{ Exception -> 0x03e1, all -> 0x03ef }
        r1 = r1 & 1;
        if (r1 != 0) goto L_0x0061;
    L_0x03d2:
        r1 = r4.field;	 Catch:{ Exception -> 0x03e1, all -> 0x03ef }
        r2 = "callFunc";
        r5 = "install_rgs";
        r1.put(r2, r5);	 Catch:{ Exception -> 0x03e1, all -> 0x03ef }
        r1 = 1;
        r12.m4066a(r3, r4, r1);	 Catch:{ Exception -> 0x03e1, all -> 0x03ef }
        goto L_0x0061;
    L_0x03e1:
        r1 = move-exception;
        goto L_0x01ba;
    L_0x03e4:
        r0 = r1;
    L_0x03e5:
        r1 = r2 + 1;
        r2 = r1;
        r1 = r0;
        goto L_0x0381;
    L_0x03ea:
        r0 = move-exception;
    L_0x03eb:
        r12.m4069a(r1, r13);
        throw r0;
    L_0x03ef:
        r1 = move-exception;
        r11 = r1;
        r1 = r0;
        r0 = r11;
        goto L_0x03eb;
    L_0x03f4:
        r1 = move-exception;
        r11 = r1;
        r1 = r0;
        r0 = r11;
        goto L_0x03eb;
    L_0x03f9:
        r0 = move-exception;
        r11 = r0;
        r0 = r1;
        r1 = r11;
        goto L_0x01ba;
    L_0x03ff:
        r0 = r1;
        goto L_0x0061;
    L_0x0402:
        r0 = r3;
        goto L_0x010a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.sdk.d.a(com.shuame.rootgenius.sdk.RootGenius$RootListener):int");
    }

    /* renamed from: a */
    public final void mo7270a(Context context) {
        if (C1469d.m4073b() == null) {
            f4039f = new SoftReference(context);
            ProtoBase.setChannel(context.getPackageName());
            f4040g = C1469d.m4073b().getFilesDir().getAbsolutePath() + "/";
            f4041h = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/";
            new File(f4041h).mkdirs();
            new File(f4040g).mkdirs();
            new File(f4040g + "Data/").mkdirs();
            new File(f4040g + "Data/Bin").mkdirs();
            try {
                InputStream open = C1469d.m4073b().getAssets().open(RgsdkConfig.AZ_RGSDK);
                if (open != null) {
                    CommUtils.unzip(open, f4040g);
                    open.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.f4054n = new C1465c(f4040g);
            this.f4054n.mo7265h();
            this.f4055p = this.f4054n;
            this.f4057r = new C1472g(f4040g);
            File file = new File(f4040g + "Data/Sol/1000");
            if (!file.exists()) {
                new File(f4040g + "Data/Bin/rgs").renameTo(file);
            }
            if (!this.f4045b.inited) {
                this.f4045b = CommUtils.parseRootingDev(C1469d.m4073b());
                this.f4046c.phoneId = this.f4045b.phoneId;
                this.f4046c.phoneInfo = this.f4045b.phoneInfo;
                this.f4047d.phoneId = this.f4045b.phoneId;
                this.f4045b.inited = true;
            }
        }
        C1473h.m4103b(f4038a, "[perpare]workDir:" + f4040g + ",tempDir:" + f4041h);
        m4076d(context);
        if (C1469d.m4079e(context)) {
            C1477c.m4116a().mo7291a(this.f4048e);
        }
    }

    /* renamed from: a */
    public final void mo7271a(String str) {
        C1473h.m4104c(f4038a, "[setTestMode]entry");
        if (str != null) {
            if (str.startsWith("L:")) {
                this.f4050j = true;
            } else if (str.startsWith("R:")) {
                this.f4051k = true;
            } else {
                return;
            }
            C1473h.m4104c(f4038a, "[setTestMode]mLocalTest " + this.f4050j);
            String substring = str.substring(2);
            if (substring != null && !substring.isEmpty() && C1469d.m4079e(C1469d.m4073b())) {
                C1473h.m4104c(f4038a, "[setTestMode]JniRoot ");
                int parseInt = Integer.parseInt(substring);
                C1473h.m4104c(f4038a, "[setTestMode]JniRoot soluId:" + parseInt);
                if (parseInt > 0) {
                    this.f4049i = parseInt;
                    substring = "mkdir " + f4040g + "Data/Sol/\nchmod 777 " + f4040g + "Data/Sol/";
                } else {
                    this.f4049i = 0;
                    this.f4050j = false;
                    this.f4051k = false;
                    substring = "mkdir " + f4040g + "Data/Sol/\nchmod 755 " + f4040g + "Data/Sol/";
                }
                CommUtils.execCmd(substring);
            }
        }
    }

    /* renamed from: a */
    public final void mo7272a(String str, RootListener rootListener) {
        C1464b c1464b = new C1464b(f4040g);
        C1468c c1468c = new C1468c(-1, 0);
        if (c1464b.mo7264a(str, null)) {
            this.f4046c.triedSolutions.triedList.clear();
            this.f4052l = System.currentTimeMillis();
            Context b = C1469d.m4073b();
            if (b == null) {
                m4069a(c1468c, rootListener);
                throw new Exception("context is null.should call initialize first.");
            }
            boolean z;
            try {
                if (C1469d.m4079e(b)) {
                    if (rootListener != null) {
                        rootListener.onProgress(1);
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    String e = c1464b.mo7261e();
                    StringBuilder append = new StringBuilder("chmod 755 ").append(e).append("\nsu -c \"");
                    String str2 = "";
                    if (!c1464b.mo7262f().isEmpty()) {
                        str2 = this.f4057r.mo7286a(c1464b.mo7262f(), false);
                    }
                    if (!str2.endsWith("\n")) {
                        str2 = str2 + "\n";
                    }
                    str2 = CommUtils.execCmd(false, append.append("bb=" + f4040g + "Data/Bin/busybox \nchmod 755 $bb\n" + str2).append(e).append("\"").toString());
                    C1473h.m4104c(f4038a, "[updateSU]descrip:" + str2);
                    Tried tried = new Tried();
                    tried.f4069id = 1002;
                    tried.result = 1;
                    tried.timeUsed = (int) (System.currentTimeMillis() - currentTimeMillis);
                    tried.description = str2;
                    this.f4046c.triedSolutions.triedList.add(tried);
                    if (C1463a.m4035b()) {
                        c1468c.f4036a = 1;
                    } else {
                        c1468c.f4036a = 2;
                    }
                }
                z = this.f4055p.f4028b;
                this.f4055p.f4028b = false;
                m4069a(c1468c, rootListener);
                this.f4055p.f4028b = z;
            } catch (Exception e2) {
                e2.printStackTrace();
                c1468c.f4036a = -1;
                z = this.f4055p.f4028b;
                this.f4055p.f4028b = false;
                m4069a(c1468c, rootListener);
                this.f4055p.f4028b = z;
            } catch (Throwable th) {
                boolean z2 = this.f4055p.f4028b;
                this.f4055p.f4028b = false;
                m4069a(c1468c, rootListener);
                this.f4055p.f4028b = z2;
            }
            C1473h.m4103b(f4038a, "[updateSU]finish");
            return;
        }
        c1468c.f4036a = -5;
        m4069a(c1468c, rootListener);
    }

    /* renamed from: a */
    public final void mo7273a(String str, String str2, String str3) {
        this.f4045b.phoneId.phimei = str;
        this.f4045b.phoneId.imsi = str2;
        this.f4045b.phoneId.qimei = str3;
    }

    /* renamed from: a */
    public final void mo7274a(String[] strArr) {
        this.f4057r.mo7287a(strArr);
    }

    /* renamed from: b */
    public final void mo7275b(Context context) {
        m4076d(context);
    }

    /* renamed from: c */
    public final RootingDev mo7276c() {
        return this.f4045b;
    }

    /* renamed from: d */
    public final DeviceSolution mo7277d() {
        C1476b c1476b = new C1476b();
        C1473h.m4104c(f4038a, "[preQueryRoot]start");
        c1476b.mo7290a(this.f4045b, this.f4058s);
        C1473h.m4104c(f4038a, "[preQueryRoot]product_id:" + this.f4058s.productId);
        if (!ProtoBase.isSuccess(this.f4058s.result)) {
            return null;
        }
        DeviceSolution deviceSolution = new DeviceSolution();
        deviceSolution.productId = this.f4058s.productId;
        deviceSolution.productName = this.f4058s.productName;
        deviceSolution.support = this.f4058s.solus.size() > 0;
        if (this.f4058s.f4067su == null || this.f4058s.f4067su.md5.compareToIgnoreCase(this.f4054n.mo7266i()) == 0) {
            C1473h.m4104c(f4038a, "[preQueryRoot] no need update su ");
        } else {
            deviceSolution.f4066su = this.f4058s.f4067su;
            StringBuilder append = new StringBuilder().append(f4040g).append("Data/download/");
            String fileNameFromUrl = CommUtils.getFileNameFromUrl(this.f4058s.f4067su.url);
            int indexOf = fileNameFromUrl.indexOf(45);
            int lastIndexOf = fileNameFromUrl.lastIndexOf(46);
            if (lastIndexOf >= 0 && indexOf >= 0) {
                fileNameFromUrl = fileNameFromUrl.substring(0, indexOf) + fileNameFromUrl.substring(lastIndexOf);
            }
            deviceSolution.suPath = append.append(fileNameFromUrl).toString();
            this.f4056q = deviceSolution.suPath;
            C1473h.m4104c(f4038a, "[preQueryRoot] need update su url:" + deviceSolution.f4066su.url + " md5:" + deviceSolution.f4066su.md5 + " size:" + deviceSolution.f4066su.size + " path:" + deviceSolution.suPath);
        }
        return deviceSolution;
    }

    /* renamed from: d */
    public final String mo7278d(String str) {
        return C1463a.m4035b() ? CommUtils.execCmd(true, str) : "permission denied";
    }

    /* renamed from: f */
    public final int mo7279f() {
        int i = 1;
        Context b = C1469d.m4073b();
        if (b == null) {
            throw new Exception("context is null.should call initialize first.");
        } else if (!C1469d.m4079e(b)) {
            return -1;
        } else {
            this.f4047d.description = this.f4057r.mo7285a();
            if (mo7280g()) {
                this.f4047d.result = 0;
                i = -1;
            } else {
                this.f4047d.result = 1;
            }
            C1480f.m4125a().mo7295a(this.f4047d);
            return i;
        }
    }

    /* renamed from: g */
    public final boolean mo7280g() {
        this.f4053m = C1463a.m4035b();
        return this.f4053m;
    }

    /* renamed from: h */
    public final String mo7281h() {
        return this.f4054n != null ? this.f4054n.mo7266i() : "";
    }

    /* renamed from: i */
    public final void mo7282i() {
        this.f4059t = true;
    }
}
