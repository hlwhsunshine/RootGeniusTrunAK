package com.shuame.rootgenius.common.p100a;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.shuame.rootgenius.common.event.C1336a;

/* renamed from: com.shuame.rootgenius.common.a.a */
public class C1316a {
    /* renamed from: c */
    private static C1316a f3570c = new C1316a();
    /* renamed from: a */
    private final String f3571a = C1316a.class.getSimpleName();
    /* renamed from: b */
    private C1317b f3572b = C1317b.m3684a();

    private C1316a() {
    }

    /* renamed from: a */
    public static C1316a m3680a() {
        return f3570c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e0  */
    /* renamed from: a */
    public final java.util.ArrayList<com.shuame.rootgenius.common.event.C1336a> mo6976a(int r11) {
        /*
        r10 = this;
        r1 = 0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "SELECT * ";
        r0.append(r2);
        r2 = " FROM bbx_report";
        r0.append(r2);
        r2 = " WHERE app_check_flag=?";
        r0.append(r2);
        r3 = new java.util.ArrayList;
        r3.<init>();
        r2 = r10.f3572b;	 Catch:{ Exception -> 0x00e6, all -> 0x00d1 }
        r2 = r2.getReadableDatabase();	 Catch:{ Exception -> 0x00e6, all -> 0x00d1 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0093 }
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x0093 }
        r5 = 0;
        r6 = java.lang.String.valueOf(r11);	 Catch:{ Exception -> 0x0093 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x0093 }
        r1 = r2.rawQuery(r0, r4);	 Catch:{ Exception -> 0x0093 }
        if (r1 == 0) goto L_0x00c0;
    L_0x0034:
        r0 = r1.getCount();	 Catch:{ Exception -> 0x0093 }
        if (r0 <= 0) goto L_0x00c0;
    L_0x003a:
        r0 = r1.moveToNext();	 Catch:{ Exception -> 0x0093 }
        if (r0 == 0) goto L_0x00c0;
    L_0x0040:
        r0 = "project_name";
        r0 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x0093 }
        r0 = r1.getString(r0);	 Catch:{ Exception -> 0x0093 }
        r4 = "action_type";
        r4 = r1.getColumnIndex(r4);	 Catch:{ Exception -> 0x0093 }
        r4 = r1.getString(r4);	 Catch:{ Exception -> 0x0093 }
        r5 = "success";
        r5 = r1.getColumnIndex(r5);	 Catch:{ Exception -> 0x0093 }
        r5 = r1.getString(r5);	 Catch:{ Exception -> 0x0093 }
        r6 = "description";
        r6 = r1.getColumnIndex(r6);	 Catch:{ Exception -> 0x0093 }
        r6 = r1.getString(r6);	 Catch:{ Exception -> 0x0093 }
        r7 = "package_name";
        r7 = r1.getColumnIndex(r7);	 Catch:{ Exception -> 0x0093 }
        r7 = r1.getString(r7);	 Catch:{ Exception -> 0x0093 }
        r8 = "id_";
        r8 = r1.getColumnIndex(r8);	 Catch:{ Exception -> 0x0093 }
        r8 = r1.getInt(r8);	 Catch:{ Exception -> 0x0093 }
        r9 = new com.shuame.rootgenius.common.event.a;	 Catch:{ Exception -> 0x0093 }
        r9.<init>();	 Catch:{ Exception -> 0x0093 }
        r9.f3610a = r0;	 Catch:{ Exception -> 0x0093 }
        r9.f3611b = r4;	 Catch:{ Exception -> 0x0093 }
        r9.f3612c = r5;	 Catch:{ Exception -> 0x0093 }
        r9.f3613d = r6;	 Catch:{ Exception -> 0x0093 }
        r9.f3614e = r8;	 Catch:{ Exception -> 0x0093 }
        r9.f3616g = r7;	 Catch:{ Exception -> 0x0093 }
        r9.f3615f = r11;	 Catch:{ Exception -> 0x0093 }
        r3.add(r9);	 Catch:{ Exception -> 0x0093 }
        goto L_0x003a;
    L_0x0093:
        r0 = move-exception;
    L_0x0094:
        r0.printStackTrace();	 Catch:{ all -> 0x00e4 }
        if (r1 == 0) goto L_0x00a2;
    L_0x0099:
        r0 = r1.isClosed();
        if (r0 != 0) goto L_0x00a2;
    L_0x009f:
        r1.close();
    L_0x00a2:
        if (r2 == 0) goto L_0x00a7;
    L_0x00a4:
        r2.close();
    L_0x00a7:
        r0 = new java.lang.StringBuilder;
        r1 = "getListByFlag:";
        r0.<init>(r1);
        r0 = r0.append(r11);
        r1 = "的记录:";
        r0 = r0.append(r1);
        r1 = r3.size();
        r0.append(r1);
        return r3;
    L_0x00c0:
        if (r1 == 0) goto L_0x00cb;
    L_0x00c2:
        r0 = r1.isClosed();
        if (r0 != 0) goto L_0x00cb;
    L_0x00c8:
        r1.close();
    L_0x00cb:
        if (r2 == 0) goto L_0x00a7;
    L_0x00cd:
        r2.close();
        goto L_0x00a7;
    L_0x00d1:
        r0 = move-exception;
        r2 = r1;
    L_0x00d3:
        if (r1 == 0) goto L_0x00de;
    L_0x00d5:
        r3 = r1.isClosed();
        if (r3 != 0) goto L_0x00de;
    L_0x00db:
        r1.close();
    L_0x00de:
        if (r2 == 0) goto L_0x00e3;
    L_0x00e0:
        r2.close();
    L_0x00e3:
        throw r0;
    L_0x00e4:
        r0 = move-exception;
        goto L_0x00d3;
    L_0x00e6:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0094;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.common.a.a.a(int):java.util.ArrayList<com.shuame.rootgenius.common.event.a>");
    }

    /* renamed from: a */
    public final synchronized boolean mo6977a(C1336a c1336a) {
        SQLiteDatabase sQLiteDatabase = null;
        boolean z = false;
        synchronized (this) {
            if (c1336a != null) {
                long j;
                ContentValues contentValues = new ContentValues();
                contentValues.put("project_name", c1336a.f3610a);
                contentValues.put("action_type", c1336a.f3611b);
                contentValues.put("success", c1336a.f3612c);
                contentValues.put("description", c1336a.f3613d);
                contentValues.put("package_name", c1336a.f3616g);
                contentValues.put("app_check_flag", Integer.valueOf(c1336a.f3615f));
                try {
                    sQLiteDatabase = this.f3572b.getWritableDatabase();
                    long insert = sQLiteDatabase.insert("bbx_report", null, contentValues);
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    contentValues.clear();
                    j = insert;
                } catch (Exception e) {
                    e.printStackTrace();
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    contentValues.clear();
                    j = -1;
                } catch (Throwable th) {
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    contentValues.clear();
                }
                if (j == -1) {
                    new StringBuilder("保存数据失败--project_name=").append(c1336a.f3610a);
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    /* renamed from: b */
    public final synchronized boolean mo6978b(C1336a c1336a) {
        boolean z = false;
        synchronized (this) {
            if (c1336a != null) {
                if (c1336a.f3614e != -1) {
                    long j;
                    SQLiteDatabase sQLiteDatabase = null;
                    try {
                        sQLiteDatabase = this.f3572b.getWritableDatabase();
                        long delete = (long) sQLiteDatabase.delete("bbx_report", "id_=?", new String[]{c1336a.f3614e});
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                            j = delete;
                        } else {
                            j = delete;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                            j = -1;
                        } else {
                            j = -1;
                        }
                    } catch (Throwable th) {
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                    }
                    if (j == -1) {
                        new StringBuilder("删除数据失败--db_id=").append(c1336a.f3614e);
                    } else {
                        z = true;
                    }
                }
            }
        }
        return z;
    }
}
