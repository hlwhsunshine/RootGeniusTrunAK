package com.tencent.stat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.tencent.stat.bi */
class C1714bi extends SQLiteOpenHelper {
    /* renamed from: a */
    private String f4994a = "";
    /* renamed from: b */
    private Context f4995b = null;

    public C1714bi(Context context, String str) {
        super(context, str, null, 3);
        this.f4994a = str;
        this.f4995b = context.getApplicationContext();
        if (StatConfig.isDebugEnable()) {
            C1706ba.f4958h.mo7904i("SQLiteOpenHelper " + this.f4994a);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* renamed from: a */
    private void m4712a(android.database.sqlite.SQLiteDatabase r10) {
        /*
        r9 = this;
        r8 = 0;
        r1 = "user";
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r0 = r10;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x0048, all -> 0x0057 }
        r0 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x0061 }
        r0.<init>();	 Catch:{ Throwable -> 0x0061 }
        r2 = r1.moveToNext();	 Catch:{ Throwable -> 0x0061 }
        if (r2 == 0) goto L_0x0033;
    L_0x0019:
        r2 = 0;
        r8 = r1.getString(r2);	 Catch:{ Throwable -> 0x0061 }
        r2 = 1;
        r1.getInt(r2);	 Catch:{ Throwable -> 0x0061 }
        r2 = 2;
        r1.getString(r2);	 Catch:{ Throwable -> 0x0061 }
        r2 = 3;
        r1.getLong(r2);	 Catch:{ Throwable -> 0x0061 }
        r2 = com.tencent.stat.common.Util.encode(r8);	 Catch:{ Throwable -> 0x0061 }
        r3 = "uid";
        r0.put(r3, r2);	 Catch:{ Throwable -> 0x0061 }
    L_0x0033:
        if (r8 == 0) goto L_0x0042;
    L_0x0035:
        r2 = "user";
        r3 = "uid=?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Throwable -> 0x0061 }
        r5 = 0;
        r4[r5] = r8;	 Catch:{ Throwable -> 0x0061 }
        r10.update(r2, r0, r3, r4);	 Catch:{ Throwable -> 0x0061 }
    L_0x0042:
        if (r1 == 0) goto L_0x0047;
    L_0x0044:
        r1.close();
    L_0x0047:
        return;
    L_0x0048:
        r0 = move-exception;
        r1 = r8;
    L_0x004a:
        r2 = com.tencent.stat.C1706ba.f4958h;	 Catch:{ all -> 0x005f }
        r2.mo7900e(r0);	 Catch:{ all -> 0x005f }
        if (r1 == 0) goto L_0x0047;
    L_0x0053:
        r1.close();
        goto L_0x0047;
    L_0x0057:
        r0 = move-exception;
        r1 = r8;
    L_0x0059:
        if (r1 == 0) goto L_0x005e;
    L_0x005b:
        r1.close();
    L_0x005e:
        throw r0;
    L_0x005f:
        r0 = move-exception;
        goto L_0x0059;
    L_0x0061:
        r0 = move-exception;
        goto L_0x004a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.bi.a(android.database.sqlite.SQLiteDatabase):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007c  */
    /* renamed from: b */
    private void m4713b(android.database.sqlite.SQLiteDatabase r11) {
        /*
        r10 = this;
        r8 = 0;
        r1 = "events";
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r0 = r11;
        r7 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x008c, all -> 0x0086 }
        r0 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x0036, all -> 0x0079 }
        r0.<init>();	 Catch:{ Throwable -> 0x0036, all -> 0x0079 }
    L_0x0013:
        r1 = r7.moveToNext();	 Catch:{ Throwable -> 0x0036, all -> 0x0079 }
        if (r1 == 0) goto L_0x0045;
    L_0x0019:
        r1 = 0;
        r2 = r7.getLong(r1);	 Catch:{ Throwable -> 0x0036, all -> 0x0079 }
        r1 = 1;
        r4 = r7.getString(r1);	 Catch:{ Throwable -> 0x0036, all -> 0x0079 }
        r1 = 2;
        r5 = r7.getInt(r1);	 Catch:{ Throwable -> 0x0036, all -> 0x0079 }
        r1 = 3;
        r6 = r7.getInt(r1);	 Catch:{ Throwable -> 0x0036, all -> 0x0079 }
        r1 = new com.tencent.stat.bj;	 Catch:{ Throwable -> 0x0036, all -> 0x0079 }
        r1.<init>(r2, r4, r5, r6);	 Catch:{ Throwable -> 0x0036, all -> 0x0079 }
        r0.add(r1);	 Catch:{ Throwable -> 0x0036, all -> 0x0079 }
        goto L_0x0013;
    L_0x0036:
        r0 = move-exception;
        r1 = r7;
    L_0x0038:
        r2 = com.tencent.stat.C1706ba.f4958h;	 Catch:{ all -> 0x0089 }
        r2.mo7900e(r0);	 Catch:{ all -> 0x0089 }
        if (r1 == 0) goto L_0x0044;
    L_0x0041:
        r1.close();
    L_0x0044:
        return;
    L_0x0045:
        r1 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x0036, all -> 0x0079 }
        r1.<init>();	 Catch:{ Throwable -> 0x0036, all -> 0x0079 }
        r2 = r0.iterator();	 Catch:{ Throwable -> 0x0036, all -> 0x0079 }
    L_0x004e:
        r0 = r2.hasNext();	 Catch:{ Throwable -> 0x0036, all -> 0x0079 }
        if (r0 == 0) goto L_0x0080;
    L_0x0054:
        r0 = r2.next();	 Catch:{ Throwable -> 0x0036, all -> 0x0079 }
        r0 = (com.tencent.stat.C1715bj) r0;	 Catch:{ Throwable -> 0x0036, all -> 0x0079 }
        r3 = "content";
        r4 = r0.f4997b;	 Catch:{ Throwable -> 0x0036, all -> 0x0079 }
        r4 = com.tencent.stat.common.Util.encode(r4);	 Catch:{ Throwable -> 0x0036, all -> 0x0079 }
        r1.put(r3, r4);	 Catch:{ Throwable -> 0x0036, all -> 0x0079 }
        r3 = "events";
        r4 = "event_id=?";
        r5 = 1;
        r5 = new java.lang.String[r5];	 Catch:{ Throwable -> 0x0036, all -> 0x0079 }
        r6 = 0;
        r8 = r0.f4996a;	 Catch:{ Throwable -> 0x0036, all -> 0x0079 }
        r0 = java.lang.Long.toString(r8);	 Catch:{ Throwable -> 0x0036, all -> 0x0079 }
        r5[r6] = r0;	 Catch:{ Throwable -> 0x0036, all -> 0x0079 }
        r11.update(r3, r1, r4, r5);	 Catch:{ Throwable -> 0x0036, all -> 0x0079 }
        goto L_0x004e;
    L_0x0079:
        r0 = move-exception;
    L_0x007a:
        if (r7 == 0) goto L_0x007f;
    L_0x007c:
        r7.close();
    L_0x007f:
        throw r0;
    L_0x0080:
        if (r7 == 0) goto L_0x0044;
    L_0x0082:
        r7.close();
        goto L_0x0044;
    L_0x0086:
        r0 = move-exception;
        r7 = r8;
        goto L_0x007a;
    L_0x0089:
        r0 = move-exception;
        r7 = r1;
        goto L_0x007a;
    L_0x008c:
        r0 = move-exception;
        r1 = r8;
        goto L_0x0038;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.bi.b(android.database.sqlite.SQLiteDatabase):void");
    }

    public synchronized void close() {
        super.close();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
        sQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C1706ba.f4958h.debug("upgrade DB from oldVersion " + i + " to newVersion " + i2);
        if (i == 1) {
            sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
            m4712a(sQLiteDatabase);
            m4713b(sQLiteDatabase);
        }
        if (i == 2) {
            m4712a(sQLiteDatabase);
            m4713b(sQLiteDatabase);
        }
    }
}
