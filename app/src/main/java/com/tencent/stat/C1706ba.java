package com.tencent.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.stat.common.C1721e;
import com.tencent.stat.common.DeviceInfo;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatConstants;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.StatPreferences;
import com.tencent.stat.event.C1735f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.stat.ba */
public class C1706ba {
    /* renamed from: h */
    private static StatLogger f4958h = StatCommonHelper.getLogger();
    /* renamed from: i */
    private static Context f4959i = null;
    /* renamed from: j */
    private static C1706ba f4960j = null;
    /* renamed from: a */
    volatile int f4961a = 0;
    /* renamed from: b */
    DeviceInfo f4962b = null;
    /* renamed from: c */
    private C1714bi f4963c = null;
    /* renamed from: d */
    private C1714bi f4964d = null;
    /* renamed from: e */
    private C1721e f4965e = null;
    /* renamed from: f */
    private String f4966f = "";
    /* renamed from: g */
    private String f4967g = "";
    /* renamed from: k */
    private int f4968k = 0;
    /* renamed from: l */
    private ConcurrentHashMap<C1735f, String> f4969l = null;
    /* renamed from: m */
    private boolean f4970m = false;
    /* renamed from: n */
    private HashMap<String, String> f4971n = new HashMap();

    private C1706ba(Context context) {
        try {
            this.f4965e = new C1721e();
            f4959i = context.getApplicationContext();
            this.f4969l = new ConcurrentHashMap();
            this.f4966f = StatCommonHelper.getDatabaseName(context);
            this.f4967g = "pri_" + StatCommonHelper.getDatabaseName(context);
            this.f4963c = new C1714bi(f4959i, this.f4966f);
            this.f4964d = new C1714bi(f4959i, this.f4967g);
            m4687a(true);
            m4687a(false);
            m4698f();
            mo7875b(f4959i);
            mo7877d();
            m4702j();
        } catch (Throwable th) {
            f4958h.mo7900e(th);
        }
    }

    /* renamed from: a */
    public static C1706ba m4673a(Context context) {
        if (f4960j == null) {
            synchronized (C1706ba.class) {
                if (f4960j == null) {
                    f4960j = new C1706ba(context);
                }
            }
        }
        return f4960j;
    }

    /* renamed from: a */
    private String m4674a(String str) {
        return new StringBuilder(StatConstants.MTA_DB2SP_TAG).append(str).toString();
    }

    /* renamed from: a */
    private String m4675a(List<C1715bj> list) {
        StringBuilder stringBuilder = new StringBuilder(list.size() * 3);
        stringBuilder.append("event_id in (");
        int i = 0;
        int size = list.size();
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                stringBuilder.append(((C1715bj) it.next()).f4996a);
                if (i2 != size - 1) {
                    stringBuilder.append(",");
                }
                i = i2 + 1;
            } else {
                stringBuilder.append(")");
                return stringBuilder.toString();
            }
        }
    }

    /* renamed from: a */
    private synchronized void m4676a(int i, boolean z) {
        try {
            if (this.f4961a > 0 && i > 0 && !StatServiceImpl.m4630a()) {
                if (StatConfig.isDebugEnable()) {
                    f4958h.mo7904i("Load " + this.f4961a + " unsent events");
                }
                List arrayList = new ArrayList(i);
                m4693b(arrayList, i, z);
                if (arrayList.size() > 0) {
                    if (StatConfig.isDebugEnable()) {
                        f4958h.mo7904i("Peek " + arrayList.size() + " unsent events.");
                    }
                    m4685a(arrayList, 2, z);
                    C1748g.m4809b(f4959i).mo7954b(arrayList, new C1712bg(this, arrayList, z));
                }
            }
        } catch (Throwable th) {
            f4958h.mo7900e(th);
        }
        return;
    }

    /* renamed from: a */
    private void m4677a(Context context, String str, int i, long j) {
        StatPreferences.putString(context, m4674a("uid"), str);
        StatPreferences.putInt(context, m4674a("user_type"), i);
        StatPreferences.putString(context, m4674a("app_ver"), StatCommonHelper.getAppVersion(context));
        StatPreferences.putLong(context, m4674a("ts"), j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x008d  */
    /* renamed from: a */
    private void m4684a(com.tencent.stat.event.C1735f r7, com.tencent.stat.StatDispatchCallback r8, boolean r9) {
        /*
        r6 = this;
        r1 = 0;
        r1 = r6.m4694c(r9);	 Catch:{ Throwable -> 0x00bf }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x00bf }
        if (r9 != 0) goto L_0x002d;
    L_0x000a:
        r0 = r6.f4961a;	 Catch:{ Throwable -> 0x00bf }
        r2 = com.tencent.stat.StatConfig.getMaxStoreEventCount();	 Catch:{ Throwable -> 0x00bf }
        if (r0 <= r2) goto L_0x002d;
    L_0x0012:
        r0 = f4958h;	 Catch:{ Throwable -> 0x00bf }
        r2 = "Too many events stored in db.";
        r0.warn(r2);	 Catch:{ Throwable -> 0x00bf }
        r0 = r6.f4961a;	 Catch:{ Throwable -> 0x00bf }
        r2 = r6.f4963c;	 Catch:{ Throwable -> 0x00bf }
        r2 = r2.getWritableDatabase();	 Catch:{ Throwable -> 0x00bf }
        r3 = "events";
        r4 = "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)";
        r5 = 0;
        r2 = r2.delete(r3, r4, r5);	 Catch:{ Throwable -> 0x00bf }
        r0 = r0 - r2;
        r6.f4961a = r0;	 Catch:{ Throwable -> 0x00bf }
    L_0x002d:
        r0 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x00bf }
        r0.<init>();	 Catch:{ Throwable -> 0x00bf }
        r2 = r7.mo7932h();	 Catch:{ Throwable -> 0x00bf }
        r3 = com.tencent.stat.StatConfig.isDebugEnable();	 Catch:{ Throwable -> 0x00bf }
        if (r3 == 0) goto L_0x0050;
    L_0x003c:
        r3 = f4958h;	 Catch:{ Throwable -> 0x00bf }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00bf }
        r5 = "insert 1 event, content:";
        r4.<init>(r5);	 Catch:{ Throwable -> 0x00bf }
        r4 = r4.append(r2);	 Catch:{ Throwable -> 0x00bf }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x00bf }
        r3.mo7904i(r4);	 Catch:{ Throwable -> 0x00bf }
    L_0x0050:
        r2 = com.tencent.stat.common.Util.encode(r2);	 Catch:{ Throwable -> 0x00bf }
        r3 = "content";
        r0.put(r3, r2);	 Catch:{ Throwable -> 0x00bf }
        r2 = "send_count";
        r3 = "0";
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x00bf }
        r2 = "status";
        r3 = 1;
        r3 = java.lang.Integer.toString(r3);	 Catch:{ Throwable -> 0x00bf }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x00bf }
        r2 = "timestamp";
        r4 = r7.mo7928d();	 Catch:{ Throwable -> 0x00bf }
        r3 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x00bf }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x00bf }
        r2 = "events";
        r3 = 0;
        r2 = r1.insert(r2, r3, r0);	 Catch:{ Throwable -> 0x00bf }
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00bf }
        if (r1 == 0) goto L_0x00fd;
    L_0x0083:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00b7 }
        r0 = r2;
    L_0x0087:
        r2 = 0;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x00e4;
    L_0x008d:
        r0 = r6.f4961a;
        r0 = r0 + 1;
        r6.f4961a = r0;
        r0 = com.tencent.stat.StatConfig.isDebugEnable();
        if (r0 == 0) goto L_0x00b1;
    L_0x0099:
        r0 = f4958h;
        r1 = new java.lang.StringBuilder;
        r2 = "directStoreEvent insert event to db, event:";
        r1.<init>(r2);
        r2 = r7.mo7932h();
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.mo7897d(r1);
    L_0x00b1:
        if (r8 == 0) goto L_0x00b6;
    L_0x00b3:
        r8.onDispatchSuccess();
    L_0x00b6:
        return;
    L_0x00b7:
        r0 = move-exception;
        r1 = f4958h;
        r1.mo7900e(r0);
        r0 = r2;
        goto L_0x0087;
    L_0x00bf:
        r0 = move-exception;
        r2 = -1;
        r4 = f4958h;	 Catch:{ all -> 0x00d6 }
        r4.mo7900e(r0);	 Catch:{ all -> 0x00d6 }
        if (r1 == 0) goto L_0x00fd;
    L_0x00c9:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00ce }
        r0 = r2;
        goto L_0x0087;
    L_0x00ce:
        r0 = move-exception;
        r1 = f4958h;
        r1.mo7900e(r0);
        r0 = r2;
        goto L_0x0087;
    L_0x00d6:
        r0 = move-exception;
        if (r1 == 0) goto L_0x00dc;
    L_0x00d9:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00dd }
    L_0x00dc:
        throw r0;
    L_0x00dd:
        r1 = move-exception;
        r2 = f4958h;
        r2.mo7900e(r1);
        goto L_0x00dc;
    L_0x00e4:
        r0 = f4958h;
        r1 = new java.lang.StringBuilder;
        r2 = "Failed to store event:";
        r1.<init>(r2);
        r2 = r7.mo7932h();
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.error(r1);
        goto L_0x00b6;
    L_0x00fd:
        r0 = r2;
        goto L_0x0087;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.ba.a(com.tencent.stat.event.f, com.tencent.stat.StatDispatchCallback, boolean):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d4 A:{SYNTHETIC, Splitter: B:48:0x00d4} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c3 A:{SYNTHETIC, Splitter: B:40:0x00c3} */
    /* renamed from: a */
    private synchronized void m4685a(java.util.List<com.tencent.stat.C1715bj> r7, int r8, boolean r9) {
        /*
        r6 = this;
        r2 = 0;
        monitor-enter(r6);
        r0 = r7.size();	 Catch:{ all -> 0x007e }
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r6);
        return;
    L_0x000a:
        r3 = r6.m4688b(r9);	 Catch:{ all -> 0x007e }
        r1 = r6.m4694c(r9);	 Catch:{ Throwable -> 0x00e1, all -> 0x00d0 }
        r0 = 2;
        if (r8 != r0) goto L_0x0081;
    L_0x0015:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00bb }
        r3 = "update events set status=";
        r0.<init>(r3);	 Catch:{ Throwable -> 0x00bb }
        r0 = r0.append(r8);	 Catch:{ Throwable -> 0x00bb }
        r3 = ", send_count=send_count+1  where ";
        r0 = r0.append(r3);	 Catch:{ Throwable -> 0x00bb }
        r3 = r6.m4675a(r7);	 Catch:{ Throwable -> 0x00bb }
        r0 = r0.append(r3);	 Catch:{ Throwable -> 0x00bb }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00bb }
    L_0x0032:
        r3 = com.tencent.stat.StatConfig.isDebugEnable();	 Catch:{ Throwable -> 0x00bb }
        if (r3 == 0) goto L_0x004c;
    L_0x0038:
        r3 = f4958h;	 Catch:{ Throwable -> 0x00bb }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00bb }
        r5 = "update sql:";
        r4.<init>(r5);	 Catch:{ Throwable -> 0x00bb }
        r4 = r4.append(r0);	 Catch:{ Throwable -> 0x00bb }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x00bb }
        r3.mo7904i(r4);	 Catch:{ Throwable -> 0x00bb }
    L_0x004c:
        r1.beginTransaction();	 Catch:{ Throwable -> 0x00bb }
        r1.execSQL(r0);	 Catch:{ Throwable -> 0x00bb }
        if (r2 == 0) goto L_0x006e;
    L_0x0054:
        r0 = f4958h;	 Catch:{ Throwable -> 0x00bb }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00bb }
        r4 = "update for delete sql:";
        r3.<init>(r4);	 Catch:{ Throwable -> 0x00bb }
        r3 = r3.append(r2);	 Catch:{ Throwable -> 0x00bb }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00bb }
        r0.mo7904i(r3);	 Catch:{ Throwable -> 0x00bb }
        r1.execSQL(r2);	 Catch:{ Throwable -> 0x00bb }
        r6.m4698f();	 Catch:{ Throwable -> 0x00bb }
    L_0x006e:
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00bb }
        if (r1 == 0) goto L_0x0008;
    L_0x0073:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0077 }
        goto L_0x0008;
    L_0x0077:
        r0 = move-exception;
        r1 = f4958h;	 Catch:{ all -> 0x007e }
        r1.mo7900e(r0);	 Catch:{ all -> 0x007e }
        goto L_0x0008;
    L_0x007e:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
    L_0x0081:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00bb }
        r4 = "update events set status=";
        r0.<init>(r4);	 Catch:{ Throwable -> 0x00bb }
        r0 = r0.append(r8);	 Catch:{ Throwable -> 0x00bb }
        r4 = " where ";
        r0 = r0.append(r4);	 Catch:{ Throwable -> 0x00bb }
        r4 = r6.m4675a(r7);	 Catch:{ Throwable -> 0x00bb }
        r0 = r0.append(r4);	 Catch:{ Throwable -> 0x00bb }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00bb }
        r4 = r6.f4968k;	 Catch:{ Throwable -> 0x00bb }
        r4 = r4 % 3;
        if (r4 != 0) goto L_0x00b3;
    L_0x00a4:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00bb }
        r4 = "delete from events where send_count>";
        r2.<init>(r4);	 Catch:{ Throwable -> 0x00bb }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x00bb }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00bb }
    L_0x00b3:
        r3 = r6.f4968k;	 Catch:{ Throwable -> 0x00bb }
        r3 = r3 + 1;
        r6.f4968k = r3;	 Catch:{ Throwable -> 0x00bb }
        goto L_0x0032;
    L_0x00bb:
        r0 = move-exception;
    L_0x00bc:
        r2 = f4958h;	 Catch:{ all -> 0x00df }
        r2.mo7900e(r0);	 Catch:{ all -> 0x00df }
        if (r1 == 0) goto L_0x0008;
    L_0x00c3:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00c8 }
        goto L_0x0008;
    L_0x00c8:
        r0 = move-exception;
        r1 = f4958h;	 Catch:{ all -> 0x007e }
        r1.mo7900e(r0);	 Catch:{ all -> 0x007e }
        goto L_0x0008;
    L_0x00d0:
        r0 = move-exception;
        r1 = r2;
    L_0x00d2:
        if (r1 == 0) goto L_0x00d7;
    L_0x00d4:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00d8 }
    L_0x00d7:
        throw r0;	 Catch:{ all -> 0x007e }
    L_0x00d8:
        r1 = move-exception;
        r2 = f4958h;	 Catch:{ all -> 0x007e }
        r2.mo7900e(r1);	 Catch:{ all -> 0x007e }
        goto L_0x00d7;
    L_0x00df:
        r0 = move-exception;
        goto L_0x00d2;
    L_0x00e1:
        r0 = move-exception;
        r1 = r2;
        goto L_0x00bc;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.ba.a(java.util.List, int, boolean):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.stat.ba.a(java.util.List, boolean):void, dom blocks: [B:25:0x00c1, B:44:0x00e9]
        	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:89)
        	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.lang.Iterable.forEach(Unknown Source)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
        */
    /* renamed from: a */
    private synchronized void m4686a(java.util.List<com.tencent.stat.C1715bj> r9, boolean r10) {
        /*
        r8 = this;
        r1 = 0;
        monitor-enter(r8);
        r0 = r9.size();	 Catch:{ all -> 0x00ce }
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r8);
        return;
    L_0x000a:
        r0 = com.tencent.stat.StatConfig.isDebugEnable();	 Catch:{ all -> 0x00ce }
        if (r0 == 0) goto L_0x0032;	 Catch:{ all -> 0x00ce }
    L_0x0010:
        r0 = f4958h;	 Catch:{ all -> 0x00ce }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ce }
        r3 = "Delete ";	 Catch:{ all -> 0x00ce }
        r2.<init>(r3);	 Catch:{ all -> 0x00ce }
        r3 = r9.size();	 Catch:{ all -> 0x00ce }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ce }
        r3 = " events, important:";	 Catch:{ all -> 0x00ce }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ce }
        r2 = r2.append(r10);	 Catch:{ all -> 0x00ce }
        r2 = r2.toString();	 Catch:{ all -> 0x00ce }
        r0.mo7904i(r2);	 Catch:{ all -> 0x00ce }
    L_0x0032:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ce }
        r0 = r9.size();	 Catch:{ all -> 0x00ce }
        r0 = r0 * 3;	 Catch:{ all -> 0x00ce }
        r3.<init>(r0);	 Catch:{ all -> 0x00ce }
        r0 = "event_id in (";	 Catch:{ all -> 0x00ce }
        r3.append(r0);	 Catch:{ all -> 0x00ce }
        r0 = 0;	 Catch:{ all -> 0x00ce }
        r4 = r9.size();	 Catch:{ all -> 0x00ce }
        r5 = r9.iterator();	 Catch:{ all -> 0x00ce }
        r2 = r0;	 Catch:{ all -> 0x00ce }
    L_0x004c:
        r0 = r5.hasNext();	 Catch:{ all -> 0x00ce }
        if (r0 == 0) goto L_0x006a;	 Catch:{ all -> 0x00ce }
    L_0x0052:
        r0 = r5.next();	 Catch:{ all -> 0x00ce }
        r0 = (com.tencent.stat.C1715bj) r0;	 Catch:{ all -> 0x00ce }
        r6 = r0.f4996a;	 Catch:{ all -> 0x00ce }
        r3.append(r6);	 Catch:{ all -> 0x00ce }
        r0 = r4 + -1;	 Catch:{ all -> 0x00ce }
        if (r2 == r0) goto L_0x0066;	 Catch:{ all -> 0x00ce }
    L_0x0061:
        r0 = ",";	 Catch:{ all -> 0x00ce }
        r3.append(r0);	 Catch:{ all -> 0x00ce }
    L_0x0066:
        r0 = r2 + 1;	 Catch:{ all -> 0x00ce }
        r2 = r0;	 Catch:{ all -> 0x00ce }
        goto L_0x004c;	 Catch:{ all -> 0x00ce }
    L_0x006a:
        r0 = ")";	 Catch:{ all -> 0x00ce }
        r3.append(r0);	 Catch:{ all -> 0x00ce }
        r1 = r8.m4694c(r10);	 Catch:{ Throwable -> 0x00d1 }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x00d1 }
        r0 = "events";	 Catch:{ Throwable -> 0x00d1 }
        r2 = r3.toString();	 Catch:{ Throwable -> 0x00d1 }
        r5 = 0;	 Catch:{ Throwable -> 0x00d1 }
        r0 = r1.delete(r0, r2, r5);	 Catch:{ Throwable -> 0x00d1 }
        r2 = com.tencent.stat.StatConfig.isDebugEnable();	 Catch:{ Throwable -> 0x00d1 }
        if (r2 == 0) goto L_0x00b3;	 Catch:{ Throwable -> 0x00d1 }
    L_0x0087:
        r2 = f4958h;	 Catch:{ Throwable -> 0x00d1 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d1 }
        r6 = "delete ";	 Catch:{ Throwable -> 0x00d1 }
        r5.<init>(r6);	 Catch:{ Throwable -> 0x00d1 }
        r4 = r5.append(r4);	 Catch:{ Throwable -> 0x00d1 }
        r5 = " event ";	 Catch:{ Throwable -> 0x00d1 }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00d1 }
        r3 = r4.append(r3);	 Catch:{ Throwable -> 0x00d1 }
        r4 = ", success delete:";	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.append(r0);	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00d1 }
        r2.mo7904i(r3);	 Catch:{ Throwable -> 0x00d1 }
    L_0x00b3:
        r2 = r8.f4961a;	 Catch:{ Throwable -> 0x00d1 }
        r0 = r2 - r0;	 Catch:{ Throwable -> 0x00d1 }
        r8.f4961a = r0;	 Catch:{ Throwable -> 0x00d1 }
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00d1 }
        r8.m4698f();	 Catch:{ Throwable -> 0x00d1 }
        if (r1 == 0) goto L_0x0008;
    L_0x00c1:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00c6 }
        goto L_0x0008;
    L_0x00c6:
        r0 = move-exception;
        r1 = f4958h;	 Catch:{ all -> 0x00ce }
        r1.mo7900e(r0);	 Catch:{ all -> 0x00ce }
        goto L_0x0008;
    L_0x00ce:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x00d1:
        r0 = move-exception;
        r2 = f4958h;	 Catch:{ all -> 0x00e6 }
        r2.mo7900e(r0);	 Catch:{ all -> 0x00e6 }
        if (r1 == 0) goto L_0x0008;
    L_0x00d9:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00de }
        goto L_0x0008;
    L_0x00de:
        r0 = move-exception;
        r1 = f4958h;	 Catch:{ all -> 0x00ce }
        r1.mo7900e(r0);	 Catch:{ all -> 0x00ce }
        goto L_0x0008;
    L_0x00e6:
        r0 = move-exception;
        if (r1 == 0) goto L_0x00ec;
    L_0x00e9:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00ed }
    L_0x00ec:
        throw r0;	 Catch:{ all -> 0x00ce }
    L_0x00ed:
        r1 = move-exception;	 Catch:{ all -> 0x00ce }
        r2 = f4958h;	 Catch:{ all -> 0x00ce }
        r2.mo7900e(r1);	 Catch:{ all -> 0x00ce }
        goto L_0x00ec;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.ba.a(java.util.List, boolean):void");
    }

    /* renamed from: a */
    private void m4687a(boolean z) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = m4694c(z);
            sQLiteDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", Integer.valueOf(1));
            int update = sQLiteDatabase.update("events", contentValues, "status=?", new String[]{Long.toString(2)});
            if (StatConfig.isDebugEnable()) {
                f4958h.mo7904i("update " + update + " unsent events.");
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th) {
                    f4958h.mo7900e(th);
                }
            }
        } catch (Throwable th2) {
            f4958h.mo7900e(th2);
        }
    }

    /* renamed from: b */
    private int m4688b(boolean z) {
        return !z ? StatConfig.getMaxSendRetryCount() : StatConfig.getMaxImportantDataSendRetryCount();
    }

    /* renamed from: b */
    public static C1706ba m4689b() {
        return f4960j;
    }

    /* renamed from: b */
    private void m4690b(int i, boolean z) {
        int g = i == -1 ? !z ? m4699g() : m4700h() : i;
        if (g > 0) {
            int sendPeriodMinutes = (StatConfig.getSendPeriodMinutes() * 60) * StatConfig.getNumEventsCommitPerSec();
            if (g > sendPeriodMinutes && sendPeriodMinutes > 0) {
                g = sendPeriodMinutes;
            }
            int b = StatConfig.m4605b();
            int i2 = g / b;
            int i3 = g % b;
            if (StatConfig.isDebugEnable()) {
                f4958h.mo7904i("sentStoreEventsByDb sendNumbers=" + g + ",important=" + z + ",maxSendNumPerFor1Period=" + sendPeriodMinutes + ",maxCount=" + i2 + ",restNumbers=" + i3);
            }
            for (g = 0; g < i2; g++) {
                m4676a(b, z);
            }
            if (i3 > 0) {
                m4676a(i3, z);
            }
        }
    }

    /* renamed from: b */
    private synchronized void m4691b(C1735f c1735f, StatDispatchCallback statDispatchCallback, boolean z, boolean z2) {
        if (StatConfig.getMaxStoreEventCount() > 0) {
            if (StatConfig.f4840m <= 0 || z || z2) {
                m4684a(c1735f, statDispatchCallback, z);
            } else if (StatConfig.f4840m > 0) {
                if (StatConfig.isDebugEnable()) {
                    f4958h.mo7904i("cacheEventsInMemory.size():" + this.f4969l.size() + ",numEventsCachedInMemory:" + StatConfig.f4840m + ",numStoredEvents:" + this.f4961a);
                    f4958h.mo7904i("cache event:" + c1735f.mo7932h());
                }
                this.f4969l.put(c1735f, "");
                if (this.f4969l.size() >= StatConfig.f4840m) {
                    m4701i();
                }
                if (statDispatchCallback != null) {
                    if (this.f4969l.size() > 0) {
                        m4701i();
                    }
                    statDispatchCallback.onDispatchSuccess();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f2 A:{SYNTHETIC, Splitter: B:39:0x00f2} */
    /* renamed from: b */
    private synchronized void m4692b(com.tencent.stat.C1747f r14) {
        /*
        r13 = this;
        r9 = 1;
        r10 = 0;
        r8 = 0;
        monitor-enter(r13);
        r11 = r14.mo7944c();	 Catch:{ Throwable -> 0x0106, all -> 0x00ee }
        r0 = com.tencent.stat.common.StatCommonHelper.md5sum(r11);	 Catch:{ Throwable -> 0x0106, all -> 0x00ee }
        r12 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x0106, all -> 0x00ee }
        r12.<init>();	 Catch:{ Throwable -> 0x0106, all -> 0x00ee }
        r1 = "content";
        r2 = r14.f5130b;	 Catch:{ Throwable -> 0x0106, all -> 0x00ee }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0106, all -> 0x00ee }
        r12.put(r1, r2);	 Catch:{ Throwable -> 0x0106, all -> 0x00ee }
        r1 = "md5sum";
        r12.put(r1, r0);	 Catch:{ Throwable -> 0x0106, all -> 0x00ee }
        r14.f5131c = r0;	 Catch:{ Throwable -> 0x0106, all -> 0x00ee }
        r0 = "version";
        r1 = r14.f5132d;	 Catch:{ Throwable -> 0x0106, all -> 0x00ee }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Throwable -> 0x0106, all -> 0x00ee }
        r12.put(r0, r1);	 Catch:{ Throwable -> 0x0106, all -> 0x00ee }
        r0 = r13.f4963c;	 Catch:{ Throwable -> 0x0106, all -> 0x00ee }
        r0 = r0.getReadableDatabase();	 Catch:{ Throwable -> 0x0106, all -> 0x00ee }
        r1 = "config";
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x0106, all -> 0x00ee }
    L_0x0040:
        r0 = r1.moveToNext();	 Catch:{ Throwable -> 0x00d7 }
        if (r0 == 0) goto L_0x010b;
    L_0x0046:
        r0 = 0;
        r0 = r1.getInt(r0);	 Catch:{ Throwable -> 0x00d7 }
        r2 = r14.f5129a;	 Catch:{ Throwable -> 0x00d7 }
        if (r0 != r2) goto L_0x0040;
    L_0x004f:
        r0 = r9;
    L_0x0050:
        r2 = r13.f4963c;	 Catch:{ Throwable -> 0x00d7 }
        r2 = r2.getWritableDatabase();	 Catch:{ Throwable -> 0x00d7 }
        r2.beginTransaction();	 Catch:{ Throwable -> 0x00d7 }
        if (r9 != r0) goto L_0x00a9;
    L_0x005b:
        r0 = r13.f4963c;	 Catch:{ Throwable -> 0x00d7 }
        r0 = r0.getWritableDatabase();	 Catch:{ Throwable -> 0x00d7 }
        r2 = "config";
        r3 = "type=?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Throwable -> 0x00d7 }
        r5 = 0;
        r6 = r14.f5129a;	 Catch:{ Throwable -> 0x00d7 }
        r6 = java.lang.Integer.toString(r6);	 Catch:{ Throwable -> 0x00d7 }
        r4[r5] = r6;	 Catch:{ Throwable -> 0x00d7 }
        r0 = r0.update(r2, r12, r3, r4);	 Catch:{ Throwable -> 0x00d7 }
        r2 = (long) r0;	 Catch:{ Throwable -> 0x00d7 }
    L_0x0076:
        r4 = -1;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x00c2;
    L_0x007c:
        r0 = f4958h;	 Catch:{ Throwable -> 0x00d7 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d7 }
        r3 = "Failed to store cfg:";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00d7 }
        r2 = r2.append(r11);	 Catch:{ Throwable -> 0x00d7 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00d7 }
        r0.mo7899e(r2);	 Catch:{ Throwable -> 0x00d7 }
    L_0x0090:
        r0 = r13.f4963c;	 Catch:{ Throwable -> 0x00d7 }
        r0 = r0.getWritableDatabase();	 Catch:{ Throwable -> 0x00d7 }
        r0.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00d7 }
        if (r1 == 0) goto L_0x009e;
    L_0x009b:
        r1.close();	 Catch:{ all -> 0x00ff }
    L_0x009e:
        r0 = r13.f4963c;	 Catch:{ Exception -> 0x0109 }
        r0 = r0.getWritableDatabase();	 Catch:{ Exception -> 0x0109 }
        r0.endTransaction();	 Catch:{ Exception -> 0x0109 }
    L_0x00a7:
        monitor-exit(r13);
        return;
    L_0x00a9:
        r0 = "type";
        r2 = r14.f5129a;	 Catch:{ Throwable -> 0x00d7 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Throwable -> 0x00d7 }
        r12.put(r0, r2);	 Catch:{ Throwable -> 0x00d7 }
        r0 = r13.f4963c;	 Catch:{ Throwable -> 0x00d7 }
        r0 = r0.getWritableDatabase();	 Catch:{ Throwable -> 0x00d7 }
        r2 = "config";
        r3 = 0;
        r2 = r0.insert(r2, r3, r12);	 Catch:{ Throwable -> 0x00d7 }
        goto L_0x0076;
    L_0x00c2:
        r0 = f4958h;	 Catch:{ Throwable -> 0x00d7 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d7 }
        r3 = "Sucessed to store cfg:";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00d7 }
        r2 = r2.append(r11);	 Catch:{ Throwable -> 0x00d7 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00d7 }
        r0.mo7897d(r2);	 Catch:{ Throwable -> 0x00d7 }
        goto L_0x0090;
    L_0x00d7:
        r0 = move-exception;
    L_0x00d8:
        r2 = f4958h;	 Catch:{ all -> 0x0104 }
        r2.mo7900e(r0);	 Catch:{ all -> 0x0104 }
        if (r1 == 0) goto L_0x00e2;
    L_0x00df:
        r1.close();	 Catch:{ all -> 0x00ff }
    L_0x00e2:
        r0 = r13.f4963c;	 Catch:{ Exception -> 0x00ec }
        r0 = r0.getWritableDatabase();	 Catch:{ Exception -> 0x00ec }
        r0.endTransaction();	 Catch:{ Exception -> 0x00ec }
        goto L_0x00a7;
    L_0x00ec:
        r0 = move-exception;
        goto L_0x00a7;
    L_0x00ee:
        r0 = move-exception;
        r1 = r8;
    L_0x00f0:
        if (r1 == 0) goto L_0x00f5;
    L_0x00f2:
        r1.close();	 Catch:{ all -> 0x00ff }
    L_0x00f5:
        r1 = r13.f4963c;	 Catch:{ Exception -> 0x0102 }
        r1 = r1.getWritableDatabase();	 Catch:{ Exception -> 0x0102 }
        r1.endTransaction();	 Catch:{ Exception -> 0x0102 }
    L_0x00fe:
        throw r0;	 Catch:{ all -> 0x00ff }
    L_0x00ff:
        r0 = move-exception;
        monitor-exit(r13);
        throw r0;
    L_0x0102:
        r1 = move-exception;
        goto L_0x00fe;
    L_0x0104:
        r0 = move-exception;
        goto L_0x00f0;
    L_0x0106:
        r0 = move-exception;
        r1 = r8;
        goto L_0x00d8;
    L_0x0109:
        r0 = move-exception;
        goto L_0x00a7;
    L_0x010b:
        r0 = r10;
        goto L_0x0050;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.ba.b(com.tencent.stat.f):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x009f A:{SYNTHETIC, Splitter: B:31:0x009f} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009f A:{SYNTHETIC, Splitter: B:31:0x009f} */
    /* renamed from: b */
    private void m4693b(java.util.List<com.tencent.stat.C1715bj> r11, int r12, boolean r13) {
        /*
        r10 = this;
        r9 = 0;
        r0 = r10.m4696d(r13);	 Catch:{ Throwable -> 0x00ad, all -> 0x009b }
        r1 = "events";
        r2 = 0;
        r3 = "status=?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Throwable -> 0x00ad, all -> 0x009b }
        r5 = 0;
        r6 = 1;
        r6 = java.lang.Integer.toString(r6);	 Catch:{ Throwable -> 0x00ad, all -> 0x009b }
        r4[r5] = r6;	 Catch:{ Throwable -> 0x00ad, all -> 0x009b }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = java.lang.Integer.toString(r12);	 Catch:{ Throwable -> 0x00ad, all -> 0x009b }
        r7 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Throwable -> 0x00ad, all -> 0x009b }
    L_0x0020:
        r0 = r7.moveToNext();	 Catch:{ Throwable -> 0x007e, all -> 0x00a8 }
        if (r0 == 0) goto L_0x008b;
    L_0x0026:
        r0 = 0;
        r2 = r7.getLong(r0);	 Catch:{ Throwable -> 0x007e, all -> 0x00a8 }
        r0 = 1;
        r4 = r7.getString(r0);	 Catch:{ Throwable -> 0x007e, all -> 0x00a8 }
        r0 = com.tencent.stat.StatConfig.f4834g;	 Catch:{ Throwable -> 0x007e, all -> 0x00a8 }
        if (r0 != 0) goto L_0x0038;
    L_0x0034:
        r4 = com.tencent.stat.common.Util.decode(r4);	 Catch:{ Throwable -> 0x007e, all -> 0x00a8 }
    L_0x0038:
        r0 = 2;
        r5 = r7.getInt(r0);	 Catch:{ Throwable -> 0x007e, all -> 0x00a8 }
        r0 = 3;
        r6 = r7.getInt(r0);	 Catch:{ Throwable -> 0x007e, all -> 0x00a8 }
        r1 = new com.tencent.stat.bj;	 Catch:{ Throwable -> 0x007e, all -> 0x00a8 }
        r1.<init>(r2, r4, r5, r6);	 Catch:{ Throwable -> 0x007e, all -> 0x00a8 }
        r0 = com.tencent.stat.StatConfig.isDebugEnable();	 Catch:{ Throwable -> 0x007e, all -> 0x00a8 }
        if (r0 == 0) goto L_0x007a;
    L_0x004d:
        r0 = f4958h;	 Catch:{ Throwable -> 0x007e, all -> 0x00a8 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x007e, all -> 0x00a8 }
        r5 = "peek event, id=";
        r4.<init>(r5);	 Catch:{ Throwable -> 0x007e, all -> 0x00a8 }
        r2 = r4.append(r2);	 Catch:{ Throwable -> 0x007e, all -> 0x00a8 }
        r3 = ",send_count=";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x007e, all -> 0x00a8 }
        r2 = r2.append(r6);	 Catch:{ Throwable -> 0x007e, all -> 0x00a8 }
        r3 = ",timestamp=";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x007e, all -> 0x00a8 }
        r3 = 4;
        r4 = r7.getLong(r3);	 Catch:{ Throwable -> 0x007e, all -> 0x00a8 }
        r2 = r2.append(r4);	 Catch:{ Throwable -> 0x007e, all -> 0x00a8 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x007e, all -> 0x00a8 }
        r0.mo7904i(r2);	 Catch:{ Throwable -> 0x007e, all -> 0x00a8 }
    L_0x007a:
        r11.add(r1);	 Catch:{ Throwable -> 0x007e, all -> 0x00a8 }
        goto L_0x0020;
    L_0x007e:
        r0 = move-exception;
        r1 = r7;
    L_0x0080:
        r2 = f4958h;	 Catch:{ all -> 0x00aa }
        r2.mo7900e(r0);	 Catch:{ all -> 0x00aa }
        if (r1 == 0) goto L_0x008a;
    L_0x0087:
        r1.close();	 Catch:{ Throwable -> 0x0096 }
    L_0x008a:
        return;
    L_0x008b:
        if (r7 == 0) goto L_0x008a;
    L_0x008d:
        r7.close();	 Catch:{ Throwable -> 0x0091 }
        goto L_0x008a;
    L_0x0091:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x008a;
    L_0x0096:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x008a;
    L_0x009b:
        r0 = move-exception;
        r7 = r9;
    L_0x009d:
        if (r7 == 0) goto L_0x00a2;
    L_0x009f:
        r7.close();	 Catch:{ Throwable -> 0x00a3 }
    L_0x00a2:
        throw r0;
    L_0x00a3:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x00a2;
    L_0x00a8:
        r0 = move-exception;
        goto L_0x009d;
    L_0x00aa:
        r0 = move-exception;
        r7 = r1;
        goto L_0x009d;
    L_0x00ad:
        r0 = move-exception;
        r1 = r9;
        goto L_0x0080;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.ba.b(java.util.List, int, boolean):void");
    }

    /* renamed from: c */
    private SQLiteDatabase m4694c(boolean z) {
        return !z ? this.f4963c.getWritableDatabase() : this.f4964d.getWritableDatabase();
    }

    /* renamed from: c */
    private boolean m4695c(Context context) {
        return StatPreferences.contains(context, m4674a("uid")) || StatPreferences.contains(context, m4674a("user_type")) || StatPreferences.contains(context, m4674a("app_ver")) || StatPreferences.contains(context, m4674a("ts"));
    }

    /* renamed from: d */
    private SQLiteDatabase m4696d(boolean z) {
        return !z ? this.f4963c.getReadableDatabase() : this.f4964d.getReadableDatabase();
    }

    /* renamed from: f */
    private void m4698f() {
        this.f4961a = m4699g() + m4700h();
    }

    /* renamed from: g */
    private int m4699g() {
        try {
            return (int) DatabaseUtils.queryNumEntries(this.f4963c.getReadableDatabase(), "events");
        } catch (Throwable th) {
            f4958h.mo7900e(th);
            return 0;
        }
    }

    /* renamed from: h */
    private int m4700h() {
        try {
            return (int) DatabaseUtils.queryNumEntries(this.f4964d.getReadableDatabase(), "events");
        } catch (Throwable th) {
            f4958h.mo7900e(th);
            return 0;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.stat.ba.i():void, dom blocks: [B:40:0x011b, B:49:0x0133]
        	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:89)
        	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.lang.Iterable.forEach(Unknown Source)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
        */
    /* renamed from: i */
    private void m4701i() {
        /*
        r9 = this;
        r1 = 0;
        r0 = r9.f4970m;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r2 = r9.f4969l;
        monitor-enter(r2);
        r0 = r9.f4969l;	 Catch:{ all -> 0x0013 }
        r0 = r0.size();	 Catch:{ all -> 0x0013 }
        if (r0 != 0) goto L_0x0016;	 Catch:{ all -> 0x0013 }
    L_0x0011:
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        goto L_0x0005;	 Catch:{ all -> 0x0013 }
    L_0x0013:
        r0 = move-exception;	 Catch:{ all -> 0x0013 }
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        throw r0;
    L_0x0016:
        r0 = 1;
        r9.f4970m = r0;	 Catch:{ all -> 0x0013 }
        r0 = com.tencent.stat.StatConfig.isDebugEnable();	 Catch:{ all -> 0x0013 }
        if (r0 == 0) goto L_0x0051;	 Catch:{ all -> 0x0013 }
    L_0x001f:
        r0 = f4958h;	 Catch:{ all -> 0x0013 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0013 }
        r4 = "insert ";	 Catch:{ all -> 0x0013 }
        r3.<init>(r4);	 Catch:{ all -> 0x0013 }
        r4 = r9.f4969l;	 Catch:{ all -> 0x0013 }
        r4 = r4.size();	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = " events ,numEventsCachedInMemory:";	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = com.tencent.stat.StatConfig.f4840m;	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = ",numStoredEvents:";	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = r9.f4961a;	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r3 = r3.toString();	 Catch:{ all -> 0x0013 }
        r0.mo7904i(r3);	 Catch:{ all -> 0x0013 }
    L_0x0051:
        r0 = r9.f4963c;	 Catch:{ Throwable -> 0x00ca }
        r1 = r0.getWritableDatabase();	 Catch:{ Throwable -> 0x00ca }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x00ca }
        r0 = r9.f4969l;	 Catch:{ Throwable -> 0x00ca }
        r0 = r0.entrySet();	 Catch:{ Throwable -> 0x00ca }
        r3 = r0.iterator();	 Catch:{ Throwable -> 0x00ca }
    L_0x0064:
        r0 = r3.hasNext();	 Catch:{ Throwable -> 0x00ca }
        if (r0 == 0) goto L_0x0116;	 Catch:{ Throwable -> 0x00ca }
    L_0x006a:
        r0 = r3.next();	 Catch:{ Throwable -> 0x00ca }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ Throwable -> 0x00ca }
        r0 = r0.getKey();	 Catch:{ Throwable -> 0x00ca }
        r0 = (com.tencent.stat.event.C1735f) r0;	 Catch:{ Throwable -> 0x00ca }
        r4 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x00ca }
        r4.<init>();	 Catch:{ Throwable -> 0x00ca }
        r5 = r0.mo7932h();	 Catch:{ Throwable -> 0x00ca }
        r6 = com.tencent.stat.StatConfig.isDebugEnable();	 Catch:{ Throwable -> 0x00ca }
        if (r6 == 0) goto L_0x0099;	 Catch:{ Throwable -> 0x00ca }
    L_0x0085:
        r6 = f4958h;	 Catch:{ Throwable -> 0x00ca }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00ca }
        r8 = "insert content:";	 Catch:{ Throwable -> 0x00ca }
        r7.<init>(r8);	 Catch:{ Throwable -> 0x00ca }
        r7 = r7.append(r5);	 Catch:{ Throwable -> 0x00ca }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x00ca }
        r6.mo7904i(r7);	 Catch:{ Throwable -> 0x00ca }
    L_0x0099:
        r5 = com.tencent.stat.common.Util.encode(r5);	 Catch:{ Throwable -> 0x00ca }
        r6 = "content";	 Catch:{ Throwable -> 0x00ca }
        r4.put(r6, r5);	 Catch:{ Throwable -> 0x00ca }
        r5 = "send_count";	 Catch:{ Throwable -> 0x00ca }
        r6 = "0";	 Catch:{ Throwable -> 0x00ca }
        r4.put(r5, r6);	 Catch:{ Throwable -> 0x00ca }
        r5 = "status";	 Catch:{ Throwable -> 0x00ca }
        r6 = 1;	 Catch:{ Throwable -> 0x00ca }
        r6 = java.lang.Integer.toString(r6);	 Catch:{ Throwable -> 0x00ca }
        r4.put(r5, r6);	 Catch:{ Throwable -> 0x00ca }
        r5 = "timestamp";	 Catch:{ Throwable -> 0x00ca }
        r6 = r0.mo7928d();	 Catch:{ Throwable -> 0x00ca }
        r0 = java.lang.Long.valueOf(r6);	 Catch:{ Throwable -> 0x00ca }
        r4.put(r5, r0);	 Catch:{ Throwable -> 0x00ca }
        r0 = "events";	 Catch:{ Throwable -> 0x00ca }
        r5 = 0;	 Catch:{ Throwable -> 0x00ca }
        r1.insert(r0, r5, r4);	 Catch:{ Throwable -> 0x00ca }
        r3.remove();	 Catch:{ Throwable -> 0x00ca }
        goto L_0x0064;
    L_0x00ca:
        r0 = move-exception;
        r3 = f4958h;	 Catch:{ all -> 0x0130 }
        r3.mo7900e(r0);	 Catch:{ all -> 0x0130 }
        if (r1 == 0) goto L_0x00d8;
    L_0x00d2:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0129 }
        r9.m4698f();	 Catch:{ Throwable -> 0x0129 }
    L_0x00d8:
        r0 = 0;
        r9.f4970m = r0;	 Catch:{ all -> 0x0013 }
        r0 = com.tencent.stat.StatConfig.isDebugEnable();	 Catch:{ all -> 0x0013 }
        if (r0 == 0) goto L_0x0113;	 Catch:{ all -> 0x0013 }
    L_0x00e1:
        r0 = f4958h;	 Catch:{ all -> 0x0013 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0013 }
        r3 = "after insert, cacheEventsInMemory.size():";	 Catch:{ all -> 0x0013 }
        r1.<init>(r3);	 Catch:{ all -> 0x0013 }
        r3 = r9.f4969l;	 Catch:{ all -> 0x0013 }
        r3 = r3.size();	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = ",numEventsCachedInMemory:";	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = com.tencent.stat.StatConfig.f4840m;	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = ",numStoredEvents:";	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = r9.f4961a;	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r1 = r1.toString();	 Catch:{ all -> 0x0013 }
        r0.mo7904i(r1);	 Catch:{ all -> 0x0013 }
    L_0x0113:
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        goto L_0x0005;
    L_0x0116:
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00ca }
        if (r1 == 0) goto L_0x00d8;
    L_0x011b:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0122 }
        r9.m4698f();	 Catch:{ Throwable -> 0x0122 }
        goto L_0x00d8;
    L_0x0122:
        r0 = move-exception;
        r1 = f4958h;	 Catch:{ all -> 0x0013 }
        r1.mo7900e(r0);	 Catch:{ all -> 0x0013 }
        goto L_0x00d8;	 Catch:{ all -> 0x0013 }
    L_0x0129:
        r0 = move-exception;	 Catch:{ all -> 0x0013 }
        r1 = f4958h;	 Catch:{ all -> 0x0013 }
        r1.mo7900e(r0);	 Catch:{ all -> 0x0013 }
        goto L_0x00d8;
    L_0x0130:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0139;
    L_0x0133:
        r1.endTransaction();	 Catch:{ Throwable -> 0x013a }
        r9.m4698f();	 Catch:{ Throwable -> 0x013a }
    L_0x0139:
        throw r0;	 Catch:{ all -> 0x0013 }
    L_0x013a:
        r1 = move-exception;	 Catch:{ all -> 0x0013 }
        r3 = f4958h;	 Catch:{ all -> 0x0013 }
        r3.mo7900e(r1);	 Catch:{ all -> 0x0013 }
        goto L_0x0139;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.ba.i():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003f  */
    /* renamed from: j */
    private void m4702j() {
        /*
        r9 = this;
        r8 = 0;
        r0 = r9.f4963c;	 Catch:{ Throwable -> 0x0045, all -> 0x003b }
        r0 = r0.getReadableDatabase();	 Catch:{ Throwable -> 0x0045, all -> 0x003b }
        r1 = "keyvalues";
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x0045, all -> 0x003b }
    L_0x0013:
        r0 = r1.moveToNext();	 Catch:{ Throwable -> 0x0029 }
        if (r0 == 0) goto L_0x0035;
    L_0x0019:
        r0 = r9.f4971n;	 Catch:{ Throwable -> 0x0029 }
        r2 = 0;
        r2 = r1.getString(r2);	 Catch:{ Throwable -> 0x0029 }
        r3 = 1;
        r3 = r1.getString(r3);	 Catch:{ Throwable -> 0x0029 }
        r0.put(r2, r3);	 Catch:{ Throwable -> 0x0029 }
        goto L_0x0013;
    L_0x0029:
        r0 = move-exception;
    L_0x002a:
        r2 = f4958h;	 Catch:{ all -> 0x0043 }
        r2.mo7900e(r0);	 Catch:{ all -> 0x0043 }
        if (r1 == 0) goto L_0x0034;
    L_0x0031:
        r1.close();
    L_0x0034:
        return;
    L_0x0035:
        if (r1 == 0) goto L_0x0034;
    L_0x0037:
        r1.close();
        goto L_0x0034;
    L_0x003b:
        r0 = move-exception;
        r1 = r8;
    L_0x003d:
        if (r1 == 0) goto L_0x0042;
    L_0x003f:
        r1.close();
    L_0x0042:
        throw r0;
    L_0x0043:
        r0 = move-exception;
        goto L_0x003d;
    L_0x0045:
        r0 = move-exception;
        r1 = r8;
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.ba.j():void");
    }

    /* renamed from: a */
    public int mo7869a() {
        return this.f4961a;
    }

    /* renamed from: a */
    void mo7870a(int i) {
        this.f4965e.mo7916a(new C1713bh(this, i));
    }

    /* renamed from: a */
    void mo7871a(C1735f c1735f, StatDispatchCallback statDispatchCallback, boolean z, boolean z2) {
        if (this.f4965e != null) {
            this.f4965e.mo7916a(new C1710be(this, c1735f, statDispatchCallback, z, z2));
        }
    }

    /* renamed from: a */
    void mo7872a(C1747f c1747f) {
        if (c1747f != null) {
            c1747f.mo7941a(f4959i);
            this.f4965e.mo7916a(new C1711bf(this, c1747f));
        }
    }

    /* renamed from: a */
    void mo7873a(List<C1715bj> list, int i, boolean z, boolean z2) {
        if (this.f4965e != null) {
            this.f4965e.mo7916a(new C1707bb(this, list, i, z, z2));
        }
    }

    /* renamed from: a */
    void mo7874a(List<C1715bj> list, boolean z, boolean z2) {
        if (this.f4965e != null) {
            this.f4965e.mo7916a(new C1708bc(this, list, z, z2));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:133:0x033a A:{SYNTHETIC, Splitter: B:133:0x033a} */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0356 A:{SYNTHETIC, Splitter: B:142:0x0356} */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0356 A:{SYNTHETIC, Splitter: B:142:0x0356} */
    /* renamed from: b */
    public synchronized com.tencent.stat.common.DeviceInfo mo7875b(android.content.Context r18) {
        /*
        r17 = this;
        monitor-enter(r17);
        r0 = r17;
        r2 = r0.f4962b;	 Catch:{ all -> 0x0300 }
        if (r2 == 0) goto L_0x000d;
    L_0x0007:
        r0 = r17;
        r2 = r0.f4962b;	 Catch:{ all -> 0x0300 }
    L_0x000b:
        monitor-exit(r17);
        return r2;
    L_0x000d:
        r2 = r17.m4695c(r18);	 Catch:{ all -> 0x0300 }
        if (r2 == 0) goto L_0x0138;
    L_0x0013:
        r2 = com.tencent.stat.StatConfig.isDebugEnable();	 Catch:{ all -> 0x0300 }
        if (r2 == 0) goto L_0x0020;
    L_0x0019:
        r2 = f4958h;	 Catch:{ all -> 0x0300 }
        r3 = "try to load user info from sp.";
        r2.mo7904i(r3);	 Catch:{ all -> 0x0300 }
    L_0x0020:
        r2 = "uid";
        r0 = r17;
        r2 = r0.m4674a(r2);	 Catch:{ all -> 0x0300 }
        r3 = "";
        r0 = r18;
        r11 = com.tencent.stat.common.StatPreferences.getString(r0, r2, r3);	 Catch:{ all -> 0x0300 }
        r8 = com.tencent.stat.common.Util.decode(r11);	 Catch:{ all -> 0x0300 }
        r2 = "user_type";
        r0 = r17;
        r2 = r0.m4674a(r2);	 Catch:{ all -> 0x0300 }
        r3 = 1;
        r0 = r18;
        r10 = com.tencent.stat.common.StatPreferences.getInt(r0, r2, r3);	 Catch:{ all -> 0x0300 }
        r2 = "app_ver";
        r0 = r17;
        r2 = r0.m4674a(r2);	 Catch:{ all -> 0x0300 }
        r3 = "";
        r0 = r18;
        r2 = com.tencent.stat.common.StatPreferences.getString(r0, r2, r3);	 Catch:{ all -> 0x0300 }
        r3 = "ts";
        r0 = r17;
        r3 = r0.m4674a(r3);	 Catch:{ all -> 0x0300 }
        r4 = 0;
        r0 = r18;
        r4 = com.tencent.stat.common.StatPreferences.getLong(r0, r3, r4);	 Catch:{ all -> 0x0300 }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0300 }
        r12 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 / r12;
        r3 = 1;
        if (r10 == r3) goto L_0x0396;
    L_0x006d:
        r12 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4 * r12;
        r3 = com.tencent.stat.common.StatCommonHelper.getDateFormat(r4);	 Catch:{ all -> 0x0300 }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4 * r6;
        r4 = com.tencent.stat.common.StatCommonHelper.getDateFormat(r4);	 Catch:{ all -> 0x0300 }
        r3 = r3.equals(r4);	 Catch:{ all -> 0x0300 }
        if (r3 != 0) goto L_0x0396;
    L_0x0081:
        r5 = 1;
    L_0x0082:
        r3 = com.tencent.stat.common.StatCommonHelper.getAppVersion(r18);	 Catch:{ all -> 0x0300 }
        r2 = r2.equals(r3);	 Catch:{ all -> 0x0300 }
        if (r2 != 0) goto L_0x008e;
    L_0x008c:
        r5 = r5 | 2;
    L_0x008e:
        r2 = 0;
        if (r8 == 0) goto L_0x0393;
    L_0x0091:
        r2 = ",";
        r2 = r8.split(r2);	 Catch:{ all -> 0x0300 }
        r9 = r2;
    L_0x0098:
        r4 = 0;
        if (r9 == 0) goto L_0x0107;
    L_0x009b:
        r2 = r9.length;	 Catch:{ all -> 0x0300 }
        if (r2 <= 0) goto L_0x0107;
    L_0x009e:
        r2 = 0;
        r3 = r9[r2];	 Catch:{ all -> 0x0300 }
        if (r3 == 0) goto L_0x00ab;
    L_0x00a3:
        r2 = r3.length();	 Catch:{ all -> 0x0300 }
        r12 = 11;
        if (r2 >= r12) goto L_0x038b;
    L_0x00ab:
        r2 = com.tencent.stat.common.Util.getDeviceID(r18);	 Catch:{ all -> 0x0300 }
        if (r2 == 0) goto L_0x0387;
    L_0x00b1:
        r12 = r2.length();	 Catch:{ all -> 0x0300 }
        r13 = 10;
        if (r12 <= r13) goto L_0x0387;
    L_0x00b9:
        r3 = 1;
    L_0x00ba:
        r4 = r8;
        r8 = r2;
    L_0x00bc:
        if (r9 == 0) goto L_0x0113;
    L_0x00be:
        r2 = r9.length;	 Catch:{ all -> 0x0300 }
        r12 = 2;
        if (r2 < r12) goto L_0x0113;
    L_0x00c2:
        r2 = 1;
        r2 = r9[r2];	 Catch:{ all -> 0x0300 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0300 }
        r4.<init>();	 Catch:{ all -> 0x0300 }
        r4 = r4.append(r8);	 Catch:{ all -> 0x0300 }
        r9 = ",";
        r4 = r4.append(r9);	 Catch:{ all -> 0x0300 }
        r4 = r4.append(r2);	 Catch:{ all -> 0x0300 }
        r4 = r4.toString();	 Catch:{ all -> 0x0300 }
    L_0x00dc:
        r9 = new com.tencent.stat.common.DeviceInfo;	 Catch:{ all -> 0x0300 }
        r9.<init>(r8, r2, r5);	 Catch:{ all -> 0x0300 }
        r0 = r17;
        r0.f4962b = r9;	 Catch:{ all -> 0x0300 }
        r4 = com.tencent.stat.common.Util.encode(r4);	 Catch:{ all -> 0x0300 }
        if (r3 == 0) goto L_0x00f8;
    L_0x00eb:
        r2 = r4.equals(r11);	 Catch:{ all -> 0x0300 }
        if (r2 == 0) goto L_0x00f8;
    L_0x00f1:
        r2 = r17;
        r3 = r18;
        r2.m4677a(r3, r4, r5, r6);	 Catch:{ all -> 0x0300 }
    L_0x00f8:
        if (r5 == r10) goto L_0x0101;
    L_0x00fa:
        r2 = r17;
        r3 = r18;
        r2.m4677a(r3, r4, r5, r6);	 Catch:{ all -> 0x0300 }
    L_0x0101:
        r0 = r17;
        r2 = r0.f4962b;	 Catch:{ all -> 0x0300 }
        goto L_0x000b;
    L_0x0107:
        r3 = com.tencent.stat.common.StatCommonHelper.getUserID(r18);	 Catch:{ all -> 0x0300 }
        r4 = 1;
        r8 = r3;
        r16 = r4;
        r4 = r3;
        r3 = r16;
        goto L_0x00bc;
    L_0x0113:
        r2 = com.tencent.stat.common.StatCommonHelper.getMacId(r18);	 Catch:{ all -> 0x0300 }
        if (r2 == 0) goto L_0x00dc;
    L_0x0119:
        r9 = r2.length();	 Catch:{ all -> 0x0300 }
        if (r9 <= 0) goto L_0x00dc;
    L_0x011f:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0300 }
        r3.<init>();	 Catch:{ all -> 0x0300 }
        r3 = r3.append(r8);	 Catch:{ all -> 0x0300 }
        r4 = ",";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0300 }
        r3 = r3.append(r2);	 Catch:{ all -> 0x0300 }
        r4 = r3.toString();	 Catch:{ all -> 0x0300 }
        r3 = 1;
        goto L_0x00dc;
    L_0x0138:
        r11 = 0;
        r0 = r17;
        r2 = r0.f4963c;	 Catch:{ Throwable -> 0x0331, all -> 0x0352 }
        r2 = r2.getWritableDatabase();	 Catch:{ Throwable -> 0x0331, all -> 0x0352 }
        r2.beginTransaction();	 Catch:{ Throwable -> 0x0331, all -> 0x0352 }
        r2 = com.tencent.stat.StatConfig.isDebugEnable();	 Catch:{ Throwable -> 0x0331, all -> 0x0352 }
        if (r2 == 0) goto L_0x0151;
    L_0x014a:
        r2 = f4958h;	 Catch:{ Throwable -> 0x0331, all -> 0x0352 }
        r3 = "try to load user info from db.";
        r2.mo7904i(r3);	 Catch:{ Throwable -> 0x0331, all -> 0x0352 }
    L_0x0151:
        r0 = r17;
        r2 = r0.f4963c;	 Catch:{ Throwable -> 0x0331, all -> 0x0352 }
        r2 = r2.getReadableDatabase();	 Catch:{ Throwable -> 0x0331, all -> 0x0352 }
        r3 = "user";
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r8 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ Throwable -> 0x0331, all -> 0x0352 }
        r2 = 0;
        r3 = r8.moveToNext();	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        if (r3 == 0) goto L_0x0260;
    L_0x016d:
        r2 = 0;
        r13 = r8.getString(r2);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r10 = com.tencent.stat.common.Util.decode(r13);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r2 = 1;
        r12 = r8.getInt(r2);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r2 = 2;
        r2 = r8.getString(r2);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r3 = 3;
        r4 = r8.getLong(r3);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r9 = 1;
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 / r14;
        r3 = 1;
        if (r12 == r3) goto L_0x0384;
    L_0x0190:
        r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4 * r14;
        r3 = com.tencent.stat.common.StatCommonHelper.getDateFormat(r4);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4 * r6;
        r4 = com.tencent.stat.common.StatCommonHelper.getDateFormat(r4);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r3 = r3.equals(r4);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        if (r3 != 0) goto L_0x0384;
    L_0x01a4:
        r5 = 1;
    L_0x01a5:
        r3 = com.tencent.stat.common.StatCommonHelper.getAppVersion(r18);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r2 = r2.equals(r3);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        if (r2 != 0) goto L_0x01b1;
    L_0x01af:
        r5 = r5 | 2;
    L_0x01b1:
        r2 = 0;
        if (r10 == 0) goto L_0x0381;
    L_0x01b4:
        r2 = ",";
        r2 = r10.split(r2);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r11 = r2;
    L_0x01bb:
        r2 = 0;
        if (r11 == 0) goto L_0x0303;
    L_0x01be:
        r3 = r11.length;	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        if (r3 <= 0) goto L_0x0303;
    L_0x01c1:
        r3 = 0;
        r4 = r11[r3];	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        if (r4 == 0) goto L_0x01ce;
    L_0x01c6:
        r3 = r4.length();	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r14 = 11;
        if (r3 >= r14) goto L_0x037a;
    L_0x01ce:
        r3 = com.tencent.stat.common.Util.getDeviceID(r18);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        if (r3 == 0) goto L_0x0377;
    L_0x01d4:
        r14 = r3.length();	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r15 = 10;
        if (r14 <= r15) goto L_0x0377;
    L_0x01dc:
        r2 = 1;
    L_0x01dd:
        r4 = r10;
        r10 = r3;
    L_0x01df:
        if (r11 == 0) goto L_0x030b;
    L_0x01e1:
        r3 = r11.length;	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r14 = 2;
        if (r3 < r14) goto L_0x030b;
    L_0x01e5:
        r3 = 1;
        r3 = r11[r3];	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r4.<init>();	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r4 = r4.append(r10);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r11 = ",";
        r4 = r4.append(r11);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r4 = r4.append(r3);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
    L_0x01ff:
        r11 = new com.tencent.stat.common.DeviceInfo;	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r11.<init>(r10, r3, r5);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r0 = r17;
        r0.f4962b = r11;	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r3 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r3.<init>();	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r4 = com.tencent.stat.common.Util.encode(r4);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r10 = "uid";
        r3.put(r10, r4);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r10 = "user_type";
        r11 = java.lang.Integer.valueOf(r5);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r3.put(r10, r11);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r10 = "app_ver";
        r11 = com.tencent.stat.common.StatCommonHelper.getAppVersion(r18);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r3.put(r10, r11);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r10 = "ts";
        r11 = java.lang.Long.valueOf(r6);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r3.put(r10, r11);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        if (r2 == 0) goto L_0x0248;
    L_0x0233:
        r0 = r17;
        r2 = r0.f4963c;	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r2 = r2.getWritableDatabase();	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r10 = "user";
        r11 = "uid=?";
        r14 = 1;
        r14 = new java.lang.String[r14];	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r15 = 0;
        r14[r15] = r13;	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r2.update(r10, r3, r11, r14);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
    L_0x0248:
        if (r5 == r12) goto L_0x0258;
    L_0x024a:
        r0 = r17;
        r2 = r0.f4963c;	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r2 = r2.getWritableDatabase();	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r10 = "user";
        r11 = 0;
        r2.replace(r10, r11, r3);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
    L_0x0258:
        r2 = r17;
        r3 = r18;
        r2.m4677a(r3, r4, r5, r6);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r2 = r9;
    L_0x0260:
        if (r2 != 0) goto L_0x02db;
    L_0x0262:
        r9 = com.tencent.stat.common.StatCommonHelper.getUserID(r18);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r10 = com.tencent.stat.common.StatCommonHelper.getMacId(r18);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        if (r10 == 0) goto L_0x0374;
    L_0x026c:
        r2 = r10.length();	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        if (r2 <= 0) goto L_0x0374;
    L_0x0272:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r2.<init>();	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r2 = r2.append(r9);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r3 = ",";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r2 = r2.append(r10);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
    L_0x0289:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r4 / r6;
        r3 = com.tencent.stat.common.StatCommonHelper.getAppVersion(r18);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r5 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r5.<init>();	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r4 = com.tencent.stat.common.Util.encode(r2);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r2 = "uid";
        r5.put(r2, r4);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r2 = "user_type";
        r11 = 0;
        r11 = java.lang.Integer.valueOf(r11);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r5.put(r2, r11);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r2 = "app_ver";
        r5.put(r2, r3);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r2 = "ts";
        r3 = java.lang.Long.valueOf(r6);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r5.put(r2, r3);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r0 = r17;
        r2 = r0.f4963c;	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r2 = r2.getWritableDatabase();	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r3 = "user";
        r11 = 0;
        r2.insert(r3, r11, r5);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r5 = 0;
        r2 = r17;
        r3 = r18;
        r2.m4677a(r3, r4, r5, r6);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r2 = new com.tencent.stat.common.DeviceInfo;	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r3 = 0;
        r2.<init>(r9, r10, r3);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r0 = r17;
        r0.f4962b = r2;	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
    L_0x02db:
        r0 = r17;
        r2 = r0.f4963c;	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r2 = r2.getWritableDatabase();	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r2.setTransactionSuccessful();	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        if (r8 == 0) goto L_0x02eb;
    L_0x02e8:
        r8.close();	 Catch:{ Throwable -> 0x02f8 }
    L_0x02eb:
        r0 = r17;
        r2 = r0.f4963c;	 Catch:{ Throwable -> 0x02f8 }
        r2 = r2.getWritableDatabase();	 Catch:{ Throwable -> 0x02f8 }
        r2.endTransaction();	 Catch:{ Throwable -> 0x02f8 }
        goto L_0x0101;
    L_0x02f8:
        r2 = move-exception;
        r3 = f4958h;	 Catch:{ all -> 0x0300 }
        r3.mo7900e(r2);	 Catch:{ all -> 0x0300 }
        goto L_0x0101;
    L_0x0300:
        r2 = move-exception;
        monitor-exit(r17);
        throw r2;
    L_0x0303:
        r4 = com.tencent.stat.common.StatCommonHelper.getUserID(r18);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r2 = 1;
        r10 = r4;
        goto L_0x01df;
    L_0x030b:
        r3 = com.tencent.stat.common.StatCommonHelper.getMacId(r18);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        if (r3 == 0) goto L_0x01ff;
    L_0x0311:
        r11 = r3.length();	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        if (r11 <= 0) goto L_0x01ff;
    L_0x0317:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r2.<init>();	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r2 = r2.append(r10);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r4 = ",";
        r2 = r2.append(r4);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r4 = r2.toString();	 Catch:{ Throwable -> 0x0371, all -> 0x036c }
        r2 = 1;
        goto L_0x01ff;
    L_0x0331:
        r2 = move-exception;
        r3 = r11;
    L_0x0333:
        r4 = f4958h;	 Catch:{ all -> 0x036e }
        r4.mo7900e(r2);	 Catch:{ all -> 0x036e }
        if (r3 == 0) goto L_0x033d;
    L_0x033a:
        r3.close();	 Catch:{ Throwable -> 0x034a }
    L_0x033d:
        r0 = r17;
        r2 = r0.f4963c;	 Catch:{ Throwable -> 0x034a }
        r2 = r2.getWritableDatabase();	 Catch:{ Throwable -> 0x034a }
        r2.endTransaction();	 Catch:{ Throwable -> 0x034a }
        goto L_0x0101;
    L_0x034a:
        r2 = move-exception;
        r3 = f4958h;	 Catch:{ all -> 0x0300 }
        r3.mo7900e(r2);	 Catch:{ all -> 0x0300 }
        goto L_0x0101;
    L_0x0352:
        r2 = move-exception;
        r8 = r11;
    L_0x0354:
        if (r8 == 0) goto L_0x0359;
    L_0x0356:
        r8.close();	 Catch:{ Throwable -> 0x0365 }
    L_0x0359:
        r0 = r17;
        r3 = r0.f4963c;	 Catch:{ Throwable -> 0x0365 }
        r3 = r3.getWritableDatabase();	 Catch:{ Throwable -> 0x0365 }
        r3.endTransaction();	 Catch:{ Throwable -> 0x0365 }
    L_0x0364:
        throw r2;	 Catch:{ all -> 0x0300 }
    L_0x0365:
        r3 = move-exception;
        r4 = f4958h;	 Catch:{ all -> 0x0300 }
        r4.mo7900e(r3);	 Catch:{ all -> 0x0300 }
        goto L_0x0364;
    L_0x036c:
        r2 = move-exception;
        goto L_0x0354;
    L_0x036e:
        r2 = move-exception;
        r8 = r3;
        goto L_0x0354;
    L_0x0371:
        r2 = move-exception;
        r3 = r8;
        goto L_0x0333;
    L_0x0374:
        r2 = r9;
        goto L_0x0289;
    L_0x0377:
        r3 = r4;
        goto L_0x01dd;
    L_0x037a:
        r16 = r4;
        r4 = r10;
        r10 = r16;
        goto L_0x01df;
    L_0x0381:
        r11 = r2;
        goto L_0x01bb;
    L_0x0384:
        r5 = r12;
        goto L_0x01a5;
    L_0x0387:
        r2 = r3;
        r3 = r4;
        goto L_0x00ba;
    L_0x038b:
        r16 = r3;
        r3 = r4;
        r4 = r8;
        r8 = r16;
        goto L_0x00bc;
    L_0x0393:
        r9 = r2;
        goto L_0x0098;
    L_0x0396:
        r5 = r10;
        goto L_0x0082;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.ba.b(android.content.Context):com.tencent.stat.common.DeviceInfo");
    }

    /* renamed from: c */
    void mo7876c() {
        if (StatConfig.isEnableStatService()) {
            try {
                this.f4965e.mo7916a(new C1709bd(this));
            } catch (Throwable th) {
                f4958h.mo7900e(th);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0075  */
    /* renamed from: d */
    void mo7877d() {
        /*
        r9 = this;
        r8 = 0;
        r0 = com.tencent.stat.StatConfig.f4829b;
        r1 = f4959i;
        r0 = r0.mo7943b(r1);
        if (r0 != 0) goto L_0x0015;
    L_0x000b:
        r0 = com.tencent.stat.StatConfig.f4824a;
        r1 = f4959i;
        r0 = r0.mo7943b(r1);
        if (r0 == 0) goto L_0x0016;
    L_0x0015:
        return;
    L_0x0016:
        r0 = r9.f4963c;	 Catch:{ Throwable -> 0x007b, all -> 0x0071 }
        r0 = r0.getReadableDatabase();	 Catch:{ Throwable -> 0x007b, all -> 0x0071 }
        r1 = "config";
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x007b, all -> 0x0071 }
    L_0x0028:
        r0 = r1.moveToNext();	 Catch:{ Throwable -> 0x005f }
        if (r0 == 0) goto L_0x006b;
    L_0x002e:
        r0 = 0;
        r0 = r1.getInt(r0);	 Catch:{ Throwable -> 0x005f }
        r2 = 1;
        r2 = r1.getString(r2);	 Catch:{ Throwable -> 0x005f }
        r3 = 2;
        r3 = r1.getString(r3);	 Catch:{ Throwable -> 0x005f }
        r4 = 3;
        r4 = r1.getInt(r4);	 Catch:{ Throwable -> 0x005f }
        r5 = new com.tencent.stat.f;	 Catch:{ Throwable -> 0x005f }
        r5.<init>(r0);	 Catch:{ Throwable -> 0x005f }
        r5.f5129a = r0;	 Catch:{ Throwable -> 0x005f }
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x005f }
        r0.<init>(r2);	 Catch:{ Throwable -> 0x005f }
        r5.f5130b = r0;	 Catch:{ Throwable -> 0x005f }
        r5.f5131c = r3;	 Catch:{ Throwable -> 0x005f }
        r5.f5132d = r4;	 Catch:{ Throwable -> 0x005f }
        r0 = f4959i;	 Catch:{ Throwable -> 0x005f }
        r5.mo7941a(r0);	 Catch:{ Throwable -> 0x005f }
        r0 = f4959i;	 Catch:{ Throwable -> 0x005f }
        com.tencent.stat.StatConfig.m4597a(r0, r5);	 Catch:{ Throwable -> 0x005f }
        goto L_0x0028;
    L_0x005f:
        r0 = move-exception;
    L_0x0060:
        r2 = f4958h;	 Catch:{ all -> 0x0079 }
        r2.mo7900e(r0);	 Catch:{ all -> 0x0079 }
        if (r1 == 0) goto L_0x0015;
    L_0x0067:
        r1.close();
        goto L_0x0015;
    L_0x006b:
        if (r1 == 0) goto L_0x0015;
    L_0x006d:
        r1.close();
        goto L_0x0015;
    L_0x0071:
        r0 = move-exception;
        r1 = r8;
    L_0x0073:
        if (r1 == 0) goto L_0x0078;
    L_0x0075:
        r1.close();
    L_0x0078:
        throw r0;
    L_0x0079:
        r0 = move-exception;
        goto L_0x0073;
    L_0x007b:
        r0 = move-exception;
        r1 = r8;
        goto L_0x0060;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.ba.d():void");
    }
}
