package com.shuame.rootgenius.p107d;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.shuame.rootgenius.common.p100a.C1317b;
import com.shuame.rootgenius.p108e.C1422a;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.shuame.rootgenius.d.a */
public class C1419a {
    /* renamed from: c */
    private static volatile C1419a f3911c;
    /* renamed from: a */
    private final String f3912a = C1419a.class.getSimpleName();
    /* renamed from: b */
    private C1317b f3913b = C1317b.m3684a();

    private C1419a() {
    }

    /* renamed from: a */
    public static C1419a m3940a() {
        if (f3911c == null) {
            synchronized (C1419a.class) {
                if (f3911c == null) {
                    f3911c = new C1419a();
                }
            }
        }
        return f3911c;
    }

    /* renamed from: a */
    public final synchronized boolean mo7135a(C1422a c1422a) {
        SQLiteDatabase sQLiteDatabase = null;
        boolean z = false;
        synchronized (this) {
            if (c1422a != null) {
                long j;
                ContentValues contentValues = new ContentValues();
                contentValues.put("category_", c1422a.f3918a);
                contentValues.put("name_", c1422a.f3919b);
                try {
                    sQLiteDatabase = this.f3913b.getWritableDatabase();
                    long insert = sQLiteDatabase.insert("bbx_open_report", null, contentValues);
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
                    new StringBuilder("保存数据失败--name=").append(c1422a.f3919b);
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    public final synchronized boolean mo7136a(ArrayList<C1422a> arrayList) {
        boolean z;
        if (arrayList != null) {
            if (!arrayList.isEmpty()) {
                long j;
                ArrayList arrayList2 = new ArrayList();
                StringBuffer stringBuffer = new StringBuffer("id_ in(");
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    C1422a c1422a = (C1422a) it.next();
                    stringBuffer.append("?,");
                    arrayList2.add(c1422a.f3920c);
                }
                stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
                stringBuffer.append(")");
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    sQLiteDatabase = this.f3913b.getWritableDatabase();
                    long delete = (long) sQLiteDatabase.delete("bbx_open_report", stringBuffer.toString(), (String[]) arrayList2.toArray(new String[0]));
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
                    new StringBuilder("删除数据失败--db_ids=").append(arrayList2);
                    z = false;
                } else {
                    new StringBuilder("删除数据成功--db_ids=").append(arrayList2);
                    z = true;
                }
            }
        }
        z = false;
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a2  */
    /* renamed from: b */
    public final java.util.ArrayList<com.shuame.rootgenius.p108e.C1422a> mo7137b() {
        /*
        r7 = this;
        r1 = 0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "SELECT * ";
        r0.append(r2);
        r2 = " FROM bbx_open_report";
        r0.append(r2);
        r3 = new java.util.ArrayList;
        r3.<init>();
        r2 = r7.f3913b;	 Catch:{ Exception -> 0x00a8, all -> 0x0093 }
        r2 = r2.getReadableDatabase();	 Catch:{ Exception -> 0x00a8, all -> 0x0093 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x005f }
        r4 = 0;
        r1 = r2.rawQuery(r0, r4);	 Catch:{ Exception -> 0x005f }
        if (r1 == 0) goto L_0x0082;
    L_0x0026:
        r0 = r1.getCount();	 Catch:{ Exception -> 0x005f }
        if (r0 <= 0) goto L_0x0082;
    L_0x002c:
        r0 = r1.moveToNext();	 Catch:{ Exception -> 0x005f }
        if (r0 == 0) goto L_0x0082;
    L_0x0032:
        r0 = "id_";
        r0 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x005f }
        r0 = r1.getInt(r0);	 Catch:{ Exception -> 0x005f }
        r4 = "category_";
        r4 = r1.getColumnIndex(r4);	 Catch:{ Exception -> 0x005f }
        r4 = r1.getString(r4);	 Catch:{ Exception -> 0x005f }
        r5 = "name_";
        r5 = r1.getColumnIndex(r5);	 Catch:{ Exception -> 0x005f }
        r5 = r1.getString(r5);	 Catch:{ Exception -> 0x005f }
        r6 = new com.shuame.rootgenius.e.a;	 Catch:{ Exception -> 0x005f }
        r6.<init>();	 Catch:{ Exception -> 0x005f }
        r6.f3920c = r0;	 Catch:{ Exception -> 0x005f }
        r6.f3918a = r4;	 Catch:{ Exception -> 0x005f }
        r6.f3919b = r5;	 Catch:{ Exception -> 0x005f }
        r3.add(r6);	 Catch:{ Exception -> 0x005f }
        goto L_0x002c;
    L_0x005f:
        r0 = move-exception;
    L_0x0060:
        r0.printStackTrace();	 Catch:{ all -> 0x00a6 }
        if (r1 == 0) goto L_0x006e;
    L_0x0065:
        r0 = r1.isClosed();
        if (r0 != 0) goto L_0x006e;
    L_0x006b:
        r1.close();
    L_0x006e:
        if (r2 == 0) goto L_0x0073;
    L_0x0070:
        r2.close();
    L_0x0073:
        r0 = new java.lang.StringBuilder;
        r1 = "getAllData的记录:";
        r0.<init>(r1);
        r1 = r3.size();
        r0.append(r1);
        return r3;
    L_0x0082:
        if (r1 == 0) goto L_0x008d;
    L_0x0084:
        r0 = r1.isClosed();
        if (r0 != 0) goto L_0x008d;
    L_0x008a:
        r1.close();
    L_0x008d:
        if (r2 == 0) goto L_0x0073;
    L_0x008f:
        r2.close();
        goto L_0x0073;
    L_0x0093:
        r0 = move-exception;
        r2 = r1;
    L_0x0095:
        if (r1 == 0) goto L_0x00a0;
    L_0x0097:
        r3 = r1.isClosed();
        if (r3 != 0) goto L_0x00a0;
    L_0x009d:
        r1.close();
    L_0x00a0:
        if (r2 == 0) goto L_0x00a5;
    L_0x00a2:
        r2.close();
    L_0x00a5:
        throw r0;
    L_0x00a6:
        r0 = move-exception;
        goto L_0x0095;
    L_0x00a8:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0060;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.d.a.b():java.util.ArrayList<com.shuame.rootgenius.e.a>");
    }
}
