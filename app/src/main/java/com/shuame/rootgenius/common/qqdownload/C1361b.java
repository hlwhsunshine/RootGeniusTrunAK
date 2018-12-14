package com.shuame.rootgenius.common.qqdownload;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import com.shuame.rootgenius.common.C1325c;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Type;
import com.tencent.xuanfeng.downloadsdkkernel.KernelImpl;
import com.tencent.xuanfeng.downloadsdkkernel.NetCallUntl;
import com.tencent.xuanfeng.libInterface.IKernel;
import com.tencent.xuanfeng.libInterface.LinkStruct;
import com.tencent.xuanfeng.libInterface.P2PInitParam;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.shuame.rootgenius.common.qqdownload.b */
public class C1361b implements C1319h {
    /* renamed from: a */
    public static int f3750a = 1;
    /* renamed from: b */
    public static int f3751b = 2;
    /* renamed from: c */
    public static int f3752c = 1;
    /* renamed from: d */
    public static QQDownloadFile f3753d;
    /* renamed from: e */
    private static final String f3754e = C1361b.class.getSimpleName();
    /* renamed from: f */
    private static C1361b f3755f;
    /* renamed from: g */
    private IKernel f3756g = KernelImpl.getInstance();
    /* renamed from: h */
    private C1360a f3757h;
    /* renamed from: i */
    private List<C1319h> f3758i;
    /* renamed from: j */
    private Map<Integer, C1319h> f3759j;
    /* renamed from: k */
    private Map<Integer, QQDownloadFile> f3760k;
    /* renamed from: l */
    private Map<Integer, QQDownloadFile> f3761l;
    /* renamed from: m */
    private List<Integer> f3762m;
    /* renamed from: n */
    private List<Integer> f3763n;
    /* renamed from: o */
    private List<Integer> f3764o;
    /* renamed from: p */
    private List<Integer> f3765p;
    /* renamed from: q */
    private List<Integer> f3766q;
    /* renamed from: r */
    private List<Integer> f3767r;
    /* renamed from: s */
    private List<Integer> f3768s;
    /* renamed from: t */
    private Map<Integer, Long> f3769t;
    /* renamed from: u */
    private Map<Integer, Boolean> f3770u;
    /* renamed from: v */
    private Map<Integer, Integer> f3771v;
    /* renamed from: w */
    private WakeLock f3772w;
    /* renamed from: x */
    private HandlerThread f3773x;
    /* renamed from: y */
    private Handler f3774y;
    /* renamed from: z */
    private C1367i f3775z;

    private C1361b() {
        Context a = C1325c.m3724a();
        P2PInitParam p2PInitParam = new P2PInitParam(1802000701, NetCallUntl.getMyUUID(a));
        this.f3756g.setLibName("qqdlkernel-1.1.23.109");
        this.f3756g.KernelInit(a, p2PInitParam);
        this.f3756g.setOnFileDownloadListener(this);
        this.f3756g.setUseSearchDir(false);
        this.f3756g.setIncrementFileSizeMB(5);
        this.f3756g.setLogcatEnable(false);
        this.f3757h = new C1360a(a);
        this.f3758i = Collections.synchronizedList(new ArrayList());
        this.f3759j = new ConcurrentHashMap();
        this.f3760k = new ConcurrentHashMap();
        this.f3761l = new ConcurrentHashMap();
        this.f3762m = Collections.synchronizedList(new ArrayList());
        this.f3763n = Collections.synchronizedList(new ArrayList());
        this.f3764o = Collections.synchronizedList(new ArrayList());
        this.f3765p = Collections.synchronizedList(new ArrayList());
        this.f3766q = Collections.synchronizedList(new ArrayList());
        this.f3767r = Collections.synchronizedList(new ArrayList());
        this.f3768s = Collections.synchronizedList(new ArrayList());
        this.f3769t = new ConcurrentHashMap();
        this.f3770u = new ConcurrentHashMap();
        this.f3771v = new ConcurrentHashMap();
        m3823d();
        this.f3773x = new HandlerThread("QQDownloaderHandlerThread");
        this.f3773x.start();
        this.f3774y = new Handler(this.f3773x.getLooper());
        this.f3775z = new C1367i(this.f3758i, this.f3759j, this.f3760k, this.f3771v, this.f3757h, this.f3774y);
    }

    /* renamed from: a */
    public static int m3815a(String str) {
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            i2 += str.charAt(i);
            i2 += i2 << 10;
            i2 ^= i2 >> 6;
            i++;
        }
        i = (i2 << 3) + i2;
        i ^= i >> 11;
        i += i << 15;
        return i < 0 ? -i : i;
    }

    /* renamed from: a */
    public static C1361b m3817a() {
        if (f3755f == null) {
            synchronized (C1361b.class) {
                if (f3755f == null) {
                    f3755f = new C1361b();
                }
            }
        }
        return f3755f;
    }

    /* renamed from: a */
    private void m3818a(List<Integer> list) {
        if (list != null) {
            synchronized (list) {
                Integer[] numArr = list != null ? (Integer[]) list.toArray(new Integer[list.size()]) : null;
                if (numArr != null) {
                    for (Integer intValue : numArr) {
                        mo7073b(intValue.intValue());
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m3819a(QQDownloadFile qQDownloadFile) {
        if (qQDownloadFile == null) {
            return false;
        }
        switch (C1366g.f3786a[qQDownloadFile.f3734o.ordinal()]) {
            case 1:
                return C1361b.m3820a(this.f3762m, qQDownloadFile.f3722c);
            case 2:
                return C1361b.m3820a(this.f3763n, qQDownloadFile.f3722c);
            case 3:
                return C1361b.m3820a(this.f3764o, qQDownloadFile.f3722c);
            case 4:
                return C1361b.m3820a(this.f3765p, qQDownloadFile.f3722c);
            default:
                return false;
        }
    }

    /* renamed from: a */
    private static boolean m3820a(List<Integer> list, int i) {
        synchronized (list) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (((Integer) list.get(i2)).intValue() == i) {
                    list.remove(i2);
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: b */
    private void m3821b(QQDownloadFile qQDownloadFile) {
        int intValue;
        switch (C1366g.f3786a[qQDownloadFile.f3734o.ordinal()]) {
            case 1:
                C1361b.m3820a(this.f3762m, qQDownloadFile.f3722c);
                if (this.f3762m.size() < f3750a && this.f3766q.size() > 0) {
                    synchronized (this.f3766q) {
                        intValue = ((Integer) this.f3766q.get(0)).intValue();
                        this.f3766q.remove(0);
                    }
                    if (intValue > 0) {
                        mo7067a((QQDownloadFile) this.f3760k.get(Integer.valueOf(intValue)), (C1319h) this.f3759j.get(Integer.valueOf(intValue)));
                        return;
                    }
                    return;
                }
                return;
            case 2:
                C1361b.m3820a(this.f3763n, qQDownloadFile.f3722c);
                if (this.f3763n.size() < f3751b && this.f3767r.size() > 0) {
                    synchronized (this.f3767r) {
                        intValue = ((Integer) this.f3767r.get(0)).intValue();
                        this.f3767r.remove(0);
                    }
                    if (intValue > 0) {
                        mo7067a((QQDownloadFile) this.f3760k.get(Integer.valueOf(intValue)), (C1319h) this.f3759j.get(Integer.valueOf(intValue)));
                        return;
                    }
                    return;
                }
                return;
            case 3:
                C1361b.m3820a(this.f3764o, qQDownloadFile.f3722c);
                if (this.f3764o.size() < f3752c && this.f3768s.size() > 0) {
                    synchronized (this.f3768s) {
                        intValue = ((Integer) this.f3768s.get(0)).intValue();
                        this.f3768s.remove(0);
                    }
                    if (intValue > 0) {
                        mo7067a((QQDownloadFile) this.f3760k.get(Integer.valueOf(intValue)), (C1319h) this.f3759j.get(Integer.valueOf(intValue)));
                        return;
                    }
                    return;
                }
                return;
            case 4:
                C1361b.m3820a(this.f3765p, qQDownloadFile.f3722c);
                return;
            default:
                return;
        }
    }

    /* renamed from: d */
    private void m3823d() {
        for (QQDownloadFile qQDownloadFile : this.f3757h.mo7057a()) {
            if (!TextUtils.isEmpty(qQDownloadFile.f3725f)) {
                boolean z = false;
                if (qQDownloadFile.f3728i == 1000) {
                    if (new File(qQDownloadFile.f3725f).exists()) {
                        z = true;
                    }
                } else if (new File(qQDownloadFile.mo7051a()).exists()) {
                    z = true;
                }
                if (z) {
                    if (qQDownloadFile.f3733n == 0 && qQDownloadFile.f3728i == 1000) {
                        qQDownloadFile.f3719C = Status.FINISHED;
                    }
                    this.f3760k.put(Integer.valueOf(qQDownloadFile.f3722c), qQDownloadFile);
                }
                new StringBuilder("loadFromDb path:").append(qQDownloadFile.f3725f).append(";status:").append(qQDownloadFile.f3719C).append(";isOk:").append(z);
            }
        }
    }

    /* renamed from: e */
    private void m3824e() {
        if (this.f3762m.size() == 0 && this.f3766q.size() == 0 && this.f3763n.size() == 0 && this.f3767r.size() == 0 && this.f3764o.size() == 0 && this.f3768s.size() == 0 && this.f3772w != null) {
            this.f3772w.release();
            this.f3772w = null;
        }
    }

    /* renamed from: a */
    public final int mo7067a(com.shuame.rootgenius.common.qqdownload.QQDownloadFile r9, com.shuame.rootgenius.common.qqdownload.C1319h r10) {
        /*
        r8 = this;
        r1 = 0;
        r2 = 1;
        if (r9 != 0) goto L_0x0006;
    L_0x0004:
        r0 = r1;
    L_0x0005:
        return r0;
    L_0x0006:
        r0 = com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Type.ROM;
        r0 = com.shuame.rootgenius.common.C1325c.m3724a();
        if (r0 == 0) goto L_0x0027;
    L_0x000e:
        r3 = "power";
        r0 = r0.getSystemService(r3);
        r0 = (android.os.PowerManager) r0;
        r3 = r8.f3772w;
        if (r3 != 0) goto L_0x0027;
    L_0x001a:
        r3 = "QQDownloaderWakeLock";
        r0 = r0.newWakeLock(r2, r3);
        r8.f3772w = r0;
        r0 = r8.f3772w;
        r0.acquire();
    L_0x0027:
        r0 = new java.lang.StringBuilder;
        r3 = "startDownload downloadFile.taskId:";
        r0.<init>(r3);
        r3 = r9.f3722c;
        r0.append(r3);
        r0 = r9.f3722c;
        if (r0 > 0) goto L_0x004b;
    L_0x0037:
        r0 = r9.f3724e;
        r0 = com.shuame.rootgenius.common.qqdownload.C1361b.m3815a(r0);
        r9.f3722c = r0;
        r0 = new java.lang.StringBuilder;
        r3 = "startDownload downloadFile.taskId <= 0, create taskId:";
        r0.<init>(r3);
        r3 = r9.f3722c;
        r0.append(r3);
    L_0x004b:
        r0 = r9.f3722c;
        if (r9 == 0) goto L_0x005c;
    L_0x004f:
        r3 = com.shuame.rootgenius.common.qqdownload.C1366g.f3786a;
        r4 = r9.f3734o;
        r4 = r4.ordinal();
        r3 = r3[r4];
        switch(r3) {
            case 1: goto L_0x007d;
            case 2: goto L_0x008d;
            case 3: goto L_0x009d;
            case 4: goto L_0x00ad;
            default: goto L_0x005c;
        };
    L_0x005c:
        r3 = r1;
    L_0x005d:
        if (r3 != 0) goto L_0x0071;
    L_0x005f:
        if (r9 == 0) goto L_0x006e;
    L_0x0061:
        r3 = com.shuame.rootgenius.common.qqdownload.C1366g.f3786a;
        r4 = r9.f3734o;
        r4 = r4.ordinal();
        r3 = r3[r4];
        switch(r3) {
            case 1: goto L_0x00bd;
            case 2: goto L_0x00cd;
            case 3: goto L_0x00dd;
            case 4: goto L_0x00ed;
            default: goto L_0x006e;
        };
    L_0x006e:
        r3 = r1;
    L_0x006f:
        if (r3 == 0) goto L_0x00ef;
    L_0x0071:
        if (r10 == 0) goto L_0x0005;
    L_0x0073:
        r1 = r8.f3759j;
        r2 = java.lang.Integer.valueOf(r0);
        r1.put(r2, r10);
        goto L_0x0005;
    L_0x007d:
        r3 = r8.f3762m;
        r4 = r9.f3722c;
        r4 = java.lang.Integer.valueOf(r4);
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x005c;
    L_0x008b:
        r3 = r2;
        goto L_0x005d;
    L_0x008d:
        r3 = r8.f3763n;
        r4 = r9.f3722c;
        r4 = java.lang.Integer.valueOf(r4);
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x005c;
    L_0x009b:
        r3 = r2;
        goto L_0x005d;
    L_0x009d:
        r3 = r8.f3764o;
        r4 = r9.f3722c;
        r4 = java.lang.Integer.valueOf(r4);
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x005c;
    L_0x00ab:
        r3 = r2;
        goto L_0x005d;
    L_0x00ad:
        r3 = r8.f3765p;
        r4 = r9.f3722c;
        r4 = java.lang.Integer.valueOf(r4);
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x005c;
    L_0x00bb:
        r3 = r2;
        goto L_0x005d;
    L_0x00bd:
        r3 = r8.f3766q;
        r4 = r9.f3722c;
        r4 = java.lang.Integer.valueOf(r4);
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x006e;
    L_0x00cb:
        r3 = r2;
        goto L_0x006f;
    L_0x00cd:
        r3 = r8.f3767r;
        r4 = r9.f3722c;
        r4 = java.lang.Integer.valueOf(r4);
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x006e;
    L_0x00db:
        r3 = r2;
        goto L_0x006f;
    L_0x00dd:
        r3 = r8.f3768s;
        r4 = r9.f3722c;
        r4 = java.lang.Integer.valueOf(r4);
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x006e;
    L_0x00eb:
        r3 = r2;
        goto L_0x006f;
    L_0x00ed:
        r3 = r1;
        goto L_0x006f;
    L_0x00ef:
        if (r9 == 0) goto L_0x00fe;
    L_0x00f1:
        r3 = com.shuame.rootgenius.common.qqdownload.C1366g.f3786a;
        r4 = r9.f3734o;
        r4 = r4.ordinal();
        r3 = r3[r4];
        switch(r3) {
            case 1: goto L_0x01c7;
            case 2: goto L_0x020e;
            case 3: goto L_0x0255;
            case 4: goto L_0x00fe;
            default: goto L_0x00fe;
        };
    L_0x00fe:
        if (r1 != 0) goto L_0x0005;
    L_0x0100:
        if (r9 == 0) goto L_0x0005;
    L_0x0102:
        r1 = new java.io.File;
        r2 = r9.f3725f;
        r1.<init>(r2);
        r2 = new com.tencent.xuanfeng.libInterface.TASKINFO;
        r2.<init>();
        r3 = r9.f3724e;
        r2.strUrl = r3;
        r3 = r1.getParent();
        r2.strPathName = r3;
        r3 = r1.getName();
        r2.strFileName = r3;
        r3 = 15;
        r2.timeoutSecond = r3;
        r3 = r9.f3722c;
        r2.uiTaskID = r3;
        r3 = new java.lang.StringBuilder;
        r4 = "download uiTaskID:";
        r3.<init>(r4);
        r4 = r2.uiTaskID;
        r3 = r3.append(r4);
        r4 = ";path:";
        r3 = r3.append(r4);
        r4 = r9.f3725f;
        r3 = r3.append(r4);
        r4 = ";url:";
        r3 = r3.append(r4);
        r4 = r9.f3724e;
        r3.append(r4);
        r3 = r1.getParentFile();
        r4 = r3.exists();
        if (r4 != 0) goto L_0x016c;
    L_0x0154:
        r4 = r3.mkdirs();
        r5 = new java.lang.StringBuilder;
        r6 = "addToDownloadingList mkdirs:";
        r5.<init>(r6);
        r3 = r5.append(r3);
        r5 = ";isOk:";
        r3 = r3.append(r5);
        r3.append(r4);
    L_0x016c:
        r3 = r8.f3774y;
        r4 = new com.shuame.rootgenius.common.qqdownload.f;
        r4.<init>(r8, r9);
        r3.postAtFrontOfQueue(r4);
        r3 = r8.f3760k;
        r4 = r9.f3722c;
        r4 = java.lang.Integer.valueOf(r4);
        r3.put(r4, r9);
        if (r10 == 0) goto L_0x018e;
    L_0x0183:
        r3 = r8.f3759j;
        r4 = r9.f3722c;
        r4 = java.lang.Integer.valueOf(r4);
        r3.put(r4, r10);
    L_0x018e:
        r3 = com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status.DOWNLOADING;
        r9.f3719C = r3;
        r3 = r9.f3722c;
        r4 = r9.f3719C;
        r8.onStatusChanged(r3, r4);
        r3 = com.shuame.rootgenius.common.qqdownload.C1366g.f3786a;
        r4 = r9.f3734o;
        r4 = r4.ordinal();
        r3 = r3[r4];
        switch(r3) {
            case 1: goto L_0x029c;
            case 2: goto L_0x02a9;
            case 3: goto L_0x02b6;
            case 4: goto L_0x02c3;
            default: goto L_0x01a6;
        };
    L_0x01a6:
        r3 = r8.f3775z;
        r3.mo7081a();
        r3 = r1.exists();
        if (r3 == 0) goto L_0x02d0;
    L_0x01b1:
        r4 = r1.length();
        r6 = 0;
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r1 <= 0) goto L_0x02d0;
    L_0x01bb:
        r1 = r8.f3774y;
        r2 = new com.shuame.rootgenius.common.qqdownload.d;
        r2.<init>(r8, r9);
        r1.post(r2);
        goto L_0x0005;
    L_0x01c7:
        r3 = r8.f3762m;
        r3 = r3.size();
        r4 = f3750a;
        if (r3 < r4) goto L_0x00fe;
    L_0x01d1:
        r1 = new java.lang.StringBuilder;
        r3 = "addToPendingList ROM taskId:";
        r1.<init>(r3);
        r3 = r9.f3722c;
        r1.append(r3);
        r1 = r8.f3760k;
        r3 = r9.f3722c;
        r3 = java.lang.Integer.valueOf(r3);
        r1.put(r3, r9);
        if (r10 == 0) goto L_0x01f5;
    L_0x01ea:
        r1 = r8.f3759j;
        r3 = r9.f3722c;
        r3 = java.lang.Integer.valueOf(r3);
        r1.put(r3, r10);
    L_0x01f5:
        r1 = r8.f3766q;
        r3 = r9.f3722c;
        r3 = java.lang.Integer.valueOf(r3);
        r1.add(r3);
        r1 = com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status.PENDING;
        r9.f3719C = r1;
        r1 = r9.f3722c;
        r3 = r9.f3719C;
        r8.onStatusChanged(r1, r3);
        r1 = r2;
        goto L_0x00fe;
    L_0x020e:
        r3 = r8.f3763n;
        r3 = r3.size();
        r4 = f3751b;
        if (r3 < r4) goto L_0x00fe;
    L_0x0218:
        r1 = new java.lang.StringBuilder;
        r3 = "addToPendingList APK taskId:";
        r1.<init>(r3);
        r3 = r9.f3722c;
        r1.append(r3);
        r1 = r8.f3760k;
        r3 = r9.f3722c;
        r3 = java.lang.Integer.valueOf(r3);
        r1.put(r3, r9);
        if (r10 == 0) goto L_0x023c;
    L_0x0231:
        r1 = r8.f3759j;
        r3 = r9.f3722c;
        r3 = java.lang.Integer.valueOf(r3);
        r1.put(r3, r10);
    L_0x023c:
        r1 = r8.f3767r;
        r3 = r9.f3722c;
        r3 = java.lang.Integer.valueOf(r3);
        r1.add(r3);
        r1 = com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status.PENDING;
        r9.f3719C = r1;
        r1 = r9.f3722c;
        r3 = r9.f3719C;
        r8.onStatusChanged(r1, r3);
        r1 = r2;
        goto L_0x00fe;
    L_0x0255:
        r3 = r8.f3764o;
        r3 = r3.size();
        r4 = f3752c;
        if (r3 < r4) goto L_0x00fe;
    L_0x025f:
        r1 = new java.lang.StringBuilder;
        r3 = "addToPendingList FONT taskId:";
        r1.<init>(r3);
        r3 = r9.f3722c;
        r1.append(r3);
        r1 = r8.f3760k;
        r3 = r9.f3722c;
        r3 = java.lang.Integer.valueOf(r3);
        r1.put(r3, r9);
        if (r10 == 0) goto L_0x0283;
    L_0x0278:
        r1 = r8.f3759j;
        r3 = r9.f3722c;
        r3 = java.lang.Integer.valueOf(r3);
        r1.put(r3, r10);
    L_0x0283:
        r1 = r8.f3768s;
        r3 = r9.f3722c;
        r3 = java.lang.Integer.valueOf(r3);
        r1.add(r3);
        r1 = com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status.PENDING;
        r9.f3719C = r1;
        r1 = r9.f3722c;
        r3 = r9.f3719C;
        r8.onStatusChanged(r1, r3);
        r1 = r2;
        goto L_0x00fe;
    L_0x029c:
        r3 = r8.f3762m;
        r4 = r9.f3722c;
        r4 = java.lang.Integer.valueOf(r4);
        r3.add(r4);
        goto L_0x01a6;
    L_0x02a9:
        r3 = r8.f3763n;
        r4 = r9.f3722c;
        r4 = java.lang.Integer.valueOf(r4);
        r3.add(r4);
        goto L_0x01a6;
    L_0x02b6:
        r3 = r8.f3764o;
        r4 = r9.f3722c;
        r4 = java.lang.Integer.valueOf(r4);
        r3.add(r4);
        goto L_0x01a6;
    L_0x02c3:
        r3 = r8.f3765p;
        r4 = r9.f3722c;
        r4 = java.lang.Integer.valueOf(r4);
        r3.add(r4);
        goto L_0x01a6;
    L_0x02d0:
        r1 = r8.f3756g;
        r1 = r1.CreateTask(r2);
        if (r1 > 0) goto L_0x0005;
    L_0x02d8:
        r1 = r8.f3774y;
        r2 = new com.shuame.rootgenius.common.qqdownload.e;
        r2.<init>(r8, r9);
        r1.post(r2);
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.common.qqdownload.b.a(com.shuame.rootgenius.common.qqdownload.QQDownloadFile, com.shuame.rootgenius.common.qqdownload.h):int");
    }

    /* renamed from: a */
    public final QQDownloadFile mo7068a(int i) {
        return (QQDownloadFile) this.f3760k.get(Integer.valueOf(i));
    }

    /* renamed from: a */
    public final List<QQDownloadFile> mo7069a(Type type, Status status) {
        List<QQDownloadFile> arrayList = new ArrayList();
        synchronized (this.f3760k) {
            for (QQDownloadFile qQDownloadFile : this.f3760k.values()) {
                if (qQDownloadFile.f3734o == type) {
                    Object obj;
                    int obj2;
                    if (status == Status.STARTING_OR_DOWNLOADING) {
                        obj2 = (qQDownloadFile.f3719C == Status.STARTING || qQDownloadFile.f3719C == Status.DOWNLOADING) ? 1 : null;
                    } else if (status == Status.STOPING_OR_STOPED) {
                        if (qQDownloadFile.f3719C == Status.STOPING || qQDownloadFile.f3719C == Status.STOPED || qQDownloadFile.f3719C == Status.PENDING_STOPED || qQDownloadFile.f3719C == Status.ERROR_STOPED) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                    } else if (status == Status.NOT_FINISHED) {
                        if (qQDownloadFile.f3719C != Status.FINISHED) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                    } else if (qQDownloadFile.f3719C == status) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        arrayList.add(qQDownloadFile);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public final void mo7070a(Type type) {
        switch (C1366g.f3786a[type.ordinal()]) {
            case 1:
                m3818a(this.f3766q);
                m3818a(this.f3762m);
                return;
            case 2:
                m3818a(this.f3767r);
                m3818a(this.f3763n);
                return;
            case 3:
                m3818a(this.f3768s);
                m3818a(this.f3764o);
                return;
            case 4:
                m3818a(this.f3765p);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public final void mo7071a(C1319h c1319h) {
        if (c1319h != null) {
            synchronized (this.f3758i) {
                if (!this.f3758i.contains(c1319h)) {
                    this.f3758i.add(c1319h);
                }
            }
        }
    }

    /* renamed from: b */
    public final void mo7072b() {
        mo7070a(Type.ROM);
        mo7070a(Type.APK);
        mo7070a(Type.FONT);
        mo7070a(Type.FONT_MANAGER);
    }

    /* renamed from: b */
    public final void mo7073b(int i) {
        boolean z = false;
        QQDownloadFile qQDownloadFile = (QQDownloadFile) this.f3760k.get(Integer.valueOf(i));
        if (qQDownloadFile != null) {
            if (f3753d != null && f3753d.f3722c == i) {
                f3753d = null;
            }
            if (qQDownloadFile != null) {
                switch (C1366g.f3786a[qQDownloadFile.f3734o.ordinal()]) {
                    case 1:
                        z = C1361b.m3820a(this.f3766q, qQDownloadFile.f3722c);
                        break;
                    case 2:
                        z = C1361b.m3820a(this.f3767r, qQDownloadFile.f3722c);
                        break;
                    case 3:
                        z = C1361b.m3820a(this.f3768s, qQDownloadFile.f3722c);
                        break;
                }
            }
            if (z) {
                qQDownloadFile.f3719C = Status.PENDING_STOPED;
                onStatusChanged(qQDownloadFile.f3722c, qQDownloadFile.f3719C);
            } else if (m3819a(qQDownloadFile)) {
                qQDownloadFile.f3719C = Status.STOPING;
                onStatusChanged(qQDownloadFile.f3722c, qQDownloadFile.f3719C);
                this.f3756g.DelTask(qQDownloadFile.f3724e);
            }
        }
    }

    /* renamed from: b */
    public final void mo7074b(C1319h c1319h) {
        if (c1319h != null) {
            synchronized (this.f3758i) {
                if (this.f3758i.contains(c1319h)) {
                    this.f3758i.remove(c1319h);
                }
            }
        }
    }

    /* renamed from: c */
    public final void mo7075c(int i) {
        QQDownloadFile qQDownloadFile = (QQDownloadFile) this.f3760k.get(Integer.valueOf(i));
        if (qQDownloadFile != null) {
            this.f3761l.put(Integer.valueOf(i), qQDownloadFile);
            mo7073b(i);
            this.f3760k.remove(Integer.valueOf(i));
            qQDownloadFile.f3728i = 0;
            qQDownloadFile.f3733n = 0;
        }
    }

    /* renamed from: d */
    public final void mo7076d(int i) {
        QQDownloadFile qQDownloadFile = (QQDownloadFile) this.f3760k.get(Integer.valueOf(i));
        if (qQDownloadFile != null) {
            this.f3761l.put(Integer.valueOf(i), qQDownloadFile);
            mo7073b(i);
            this.f3760k.remove(Integer.valueOf(i));
            this.f3774y.postAtFrontOfQueue(new C1362c(this, i, qQDownloadFile));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00af  */
    public void onComplete(int r9, long r10) {
        /*
        r8 = this;
        r4 = 1;
        r1 = 0;
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0063, all -> 0x0092 }
        r2 = "onComplete taskId:";
        r0.<init>(r2);	 Catch:{ Exception -> 0x0063, all -> 0x0092 }
        r0 = r0.append(r9);	 Catch:{ Exception -> 0x0063, all -> 0x0092 }
        r2 = "; resultCode:";
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x0063, all -> 0x0092 }
        r0.append(r10);	 Catch:{ Exception -> 0x0063, all -> 0x0092 }
        r0 = r8.f3769t;	 Catch:{ Exception -> 0x0063, all -> 0x0092 }
        r2 = java.lang.Integer.valueOf(r9);	 Catch:{ Exception -> 0x0063, all -> 0x0092 }
        r3 = java.lang.Long.valueOf(r10);	 Catch:{ Exception -> 0x0063, all -> 0x0092 }
        r0.put(r2, r3);	 Catch:{ Exception -> 0x0063, all -> 0x0092 }
        r0 = r8.f3760k;	 Catch:{ Exception -> 0x0063, all -> 0x0092 }
        r2 = java.lang.Integer.valueOf(r9);	 Catch:{ Exception -> 0x0063, all -> 0x0092 }
        r0 = r0.get(r2);	 Catch:{ Exception -> 0x0063, all -> 0x0092 }
        r0 = (com.shuame.rootgenius.common.qqdownload.QQDownloadFile) r0;	 Catch:{ Exception -> 0x0063, all -> 0x0092 }
        r8.m3819a(r0);	 Catch:{ Exception -> 0x00c8, all -> 0x00c1 }
        r1 = r8.f3775z;	 Catch:{ Exception -> 0x00c8, all -> 0x00c1 }
        r1.onComplete(r9, r10);	 Catch:{ Exception -> 0x00c8, all -> 0x00c1 }
        if (r0 != 0) goto L_0x004f;
    L_0x003a:
        r0 = r8.f3761l;
        r1 = java.lang.Integer.valueOf(r9);
        r0 = r0.get(r1);
        r0 = (com.shuame.rootgenius.common.qqdownload.QQDownloadFile) r0;
        r1 = r8.f3761l;
        r2 = java.lang.Integer.valueOf(r9);
        r1.remove(r2);
    L_0x004f:
        if (r0 == 0) goto L_0x005f;
    L_0x0051:
        r1 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r1 < 0) goto L_0x005c;
    L_0x0055:
        r1 = r8.f3756g;
        r2 = r0.f3724e;
        r1.DelTask(r2);
    L_0x005c:
        r8.m3821b(r0);
    L_0x005f:
        r8.m3824e();
    L_0x0062:
        return;
    L_0x0063:
        r0 = move-exception;
    L_0x0064:
        r0.printStackTrace();	 Catch:{ all -> 0x00c3 }
        if (r1 != 0) goto L_0x00cd;
    L_0x0069:
        r0 = r8.f3761l;
        r1 = java.lang.Integer.valueOf(r9);
        r0 = r0.get(r1);
        r0 = (com.shuame.rootgenius.common.qqdownload.QQDownloadFile) r0;
        r1 = r8.f3761l;
        r2 = java.lang.Integer.valueOf(r9);
        r1.remove(r2);
    L_0x007e:
        if (r0 == 0) goto L_0x008e;
    L_0x0080:
        r1 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r1 < 0) goto L_0x008b;
    L_0x0084:
        r1 = r8.f3756g;
        r2 = r0.f3724e;
        r1.DelTask(r2);
    L_0x008b:
        r8.m3821b(r0);
    L_0x008e:
        r8.m3824e();
        goto L_0x0062;
    L_0x0092:
        r0 = move-exception;
        r6 = r0;
        r0 = r1;
        r1 = r6;
    L_0x0096:
        if (r0 != 0) goto L_0x00ad;
    L_0x0098:
        r0 = r8.f3761l;
        r2 = java.lang.Integer.valueOf(r9);
        r0 = r0.get(r2);
        r0 = (com.shuame.rootgenius.common.qqdownload.QQDownloadFile) r0;
        r2 = r8.f3761l;
        r3 = java.lang.Integer.valueOf(r9);
        r2.remove(r3);
    L_0x00ad:
        if (r0 == 0) goto L_0x00bd;
    L_0x00af:
        r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1));
        if (r2 < 0) goto L_0x00ba;
    L_0x00b3:
        r2 = r8.f3756g;
        r3 = r0.f3724e;
        r2.DelTask(r3);
    L_0x00ba:
        r8.m3821b(r0);
    L_0x00bd:
        r8.m3824e();
        throw r1;
    L_0x00c1:
        r1 = move-exception;
        goto L_0x0096;
    L_0x00c3:
        r0 = move-exception;
        r6 = r0;
        r0 = r1;
        r1 = r6;
        goto L_0x0096;
    L_0x00c8:
        r1 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x0064;
    L_0x00cd:
        r0 = r1;
        goto L_0x007e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.common.qqdownload.b.onComplete(int, long):void");
    }

    public void onDonwloadInfo(int i, LinkStruct[] linkStructArr) {
        this.f3775z.onDonwloadInfo(i, linkStructArr);
    }

    public void onFileName(int i, String str) {
        new StringBuilder("onFileName taskId:").append(i).append(";fileName:").append(str);
        this.f3775z.onFileName(i, str);
    }

    public void onOnlySrcUrl(int i) {
        this.f3775z.onOnlySrcUrl(i);
    }

    public void onStatusChanged(int i, Status status) {
        new StringBuilder("onStatusChanged taskId:").append(i).append(";status:").append(status);
        this.f3775z.onStatusChanged(i, status);
    }

    public void onStorageErrorInfo(int i, int i2, String str) {
        this.f3775z.onStorageErrorInfo(i, i2, str);
    }

    public void onTaskInfo(int i, int i2, int i3) {
        new StringBuilder("onTaskInfo taskId:").append(i).append(";thousandth:").append(i2).append(";speed:").append(i3);
        this.f3775z.onTaskInfo(i, i2, i3);
    }

    public void onWaitStart(int i) {
        this.f3775z.onWaitStart(i);
    }
}
