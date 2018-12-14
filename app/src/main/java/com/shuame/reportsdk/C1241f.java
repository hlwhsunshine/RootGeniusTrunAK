package com.shuame.reportsdk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

/* renamed from: com.shuame.reportsdk.f */
public class C1241f {
    /* renamed from: a */
    private static final String f3298a = C1241f.class.getSimpleName();
    /* renamed from: b */
    private C1240a f3299b;

    /* renamed from: com.shuame.reportsdk.f$a */
    private static class C1240a extends SQLiteOpenHelper {
        /* renamed from: a */
        private static final String f3297a = C1240a.class.getSimpleName();

        public C1240a(Context context, String str) {
            super(context, str, null, 1);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CREATE TABLE IF NOT EXISTS ");
            stringBuilder.append("events");
            stringBuilder.append(" (");
            stringBuilder.append("id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            stringBuilder.append("content TEXT, ");
            stringBuilder.append("url TEXT, ");
            stringBuilder.append("timestamp BIGINT, ");
            stringBuilder.append("support_batch TINYINT, ");
            stringBuilder.append("batch_key_name VARCHAR(255)");
            stringBuilder.append(" )");
            sQLiteDatabase.execSQL(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("CREATE TABLE IF NOT EXISTS ");
            stringBuilder.append("info");
            stringBuilder.append(" (");
            stringBuilder.append("id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            stringBuilder.append("content TEXT, ");
            stringBuilder.append("batch_key_name VARCHAR(255)");
            stringBuilder.append(" )");
            sQLiteDatabase.execSQL(stringBuilder.toString());
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            new StringBuilder("==>onDowngrade oldVersion:").append(i).append(" newVersion:").append(i2).append("<===");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            new StringBuilder("==>onUpgrade oldVersion:").append(i).append(" newVersion:").append(i2).append("<===");
        }
    }

    C1241f(Context context) {
        if (TextUtils.isEmpty(null)) {
            this.f3299b = new C1240a(context, "statv2.db");
        } else {
            this.f3299b = new C1240a(context, null + "-statv2.db");
        }
    }

    /* renamed from: a */
    final int mo6874a(long j) {
        return this.f3299b.getWritableDatabase().delete("events", "id = ? ", new String[]{String.valueOf(j)});
    }

    /* renamed from: a */
    final long mo6875a(String str, String str2, boolean z, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("content", str);
        contentValues.put("url", str2);
        contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        if (z) {
            contentValues.put("support_batch", Integer.valueOf(1));
            contentValues.put("batch_key_name", str3);
        } else {
            contentValues.put("support_batch", Integer.valueOf(0));
        }
        return this.f3299b.getWritableDatabase().insert("events", null, contentValues);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0092 A:{ExcHandler: java.lang.Exception (e java.lang.Exception), Splitter: B:1:0x0007} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a7  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:15:0x0093, code:
            if (r0 != null) goto L_0x0095;
     */
    /* JADX WARNING: Missing block: B:16:0x0095, code:
            r0.close();
     */
    /* JADX WARNING: Missing block: B:24:0x00a7, code:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:26:0x00ab, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:27:0x00ac, code:
            r8 = r1;
            r1 = r0;
            r0 = r8;
     */
    /* renamed from: a */
    public final java.util.List<com.shuame.reportsdk.C1236a> mo6876a(java.lang.String r10) {
        /*
        r9 = this;
        r0 = 0;
        r2 = 1;
        r3 = new java.util.ArrayList;
        r3.<init>();
        r1 = r9.f3299b;	 Catch:{ Exception -> 0x0092, all -> 0x00a1 }
        r4 = r1.getReadableDatabase();	 Catch:{ Exception -> 0x0092, all -> 0x00a1 }
        r1 = "SELECT * FROM events";
        r5 = android.text.TextUtils.isEmpty(r10);	 Catch:{ Exception -> 0x0092, all -> 0x00a1 }
        if (r5 != 0) goto L_0x0032;
    L_0x0015:
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0092, all -> 0x00a1 }
        r5.<init>();	 Catch:{ Exception -> 0x0092, all -> 0x00a1 }
        r1 = r5.append(r1);	 Catch:{ Exception -> 0x0092, all -> 0x00a1 }
        r5 = " where batch_key_name =\"";
        r1 = r1.append(r5);	 Catch:{ Exception -> 0x0092, all -> 0x00a1 }
        r1 = r1.append(r10);	 Catch:{ Exception -> 0x0092, all -> 0x00a1 }
        r5 = "\"";
        r1 = r1.append(r5);	 Catch:{ Exception -> 0x0092, all -> 0x00a1 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0092, all -> 0x00a1 }
    L_0x0032:
        r5 = 0;
        r0 = r4.rawQuery(r1, r5);	 Catch:{ Exception -> 0x0092, all -> 0x00a1 }
    L_0x0037:
        r1 = r0.moveToNext();	 Catch:{ Exception -> 0x0092, all -> 0x00ab }
        if (r1 == 0) goto L_0x009b;
    L_0x003d:
        r4 = new com.shuame.reportsdk.a;	 Catch:{ Exception -> 0x0092, all -> 0x00ab }
        r4.<init>();	 Catch:{ Exception -> 0x0092, all -> 0x00ab }
        r1 = "id";
        r1 = r0.getColumnIndex(r1);	 Catch:{ Exception -> 0x0092, all -> 0x00ab }
        r1 = r0.getInt(r1);	 Catch:{ Exception -> 0x0092, all -> 0x00ab }
        r6 = (long) r1;	 Catch:{ Exception -> 0x0092, all -> 0x00ab }
        r4.f3291a = r6;	 Catch:{ Exception -> 0x0092, all -> 0x00ab }
        r1 = "content";
        r1 = r0.getColumnIndex(r1);	 Catch:{ Exception -> 0x0092, all -> 0x00ab }
        r1 = r0.getString(r1);	 Catch:{ Exception -> 0x0092, all -> 0x00ab }
        r4.f3292b = r1;	 Catch:{ Exception -> 0x0092, all -> 0x00ab }
        r1 = "url";
        r1 = r0.getColumnIndex(r1);	 Catch:{ Exception -> 0x0092, all -> 0x00ab }
        r1 = r0.getString(r1);	 Catch:{ Exception -> 0x0092, all -> 0x00ab }
        r4.f3293c = r1;	 Catch:{ Exception -> 0x0092, all -> 0x00ab }
        r1 = "timestamp";
        r1 = r0.getColumnIndex(r1);	 Catch:{ Exception -> 0x0092, all -> 0x00ab }
        r6 = r0.getLong(r1);	 Catch:{ Exception -> 0x0092, all -> 0x00ab }
        r4.f3294d = r6;	 Catch:{ Exception -> 0x0092, all -> 0x00ab }
        r1 = "support_batch";
        r1 = r0.getColumnIndex(r1);	 Catch:{ Exception -> 0x0092, all -> 0x00ab }
        r1 = r0.getInt(r1);	 Catch:{ Exception -> 0x0092, all -> 0x00ab }
        if (r1 != r2) goto L_0x0099;
    L_0x007f:
        r1 = r2;
    L_0x0080:
        r4.f3295e = r1;	 Catch:{ Exception -> 0x0092, all -> 0x00ab }
        r1 = "batch_key_name";
        r1 = r0.getColumnIndex(r1);	 Catch:{ Exception -> 0x0092, all -> 0x00ab }
        r1 = r0.getString(r1);	 Catch:{ Exception -> 0x0092, all -> 0x00ab }
        r4.f3296f = r1;	 Catch:{ Exception -> 0x0092, all -> 0x00ab }
        r3.add(r4);	 Catch:{ Exception -> 0x0092, all -> 0x00ab }
        goto L_0x0037;
    L_0x0092:
        r1 = move-exception;
        if (r0 == 0) goto L_0x0098;
    L_0x0095:
        r0.close();
    L_0x0098:
        return r3;
    L_0x0099:
        r1 = 0;
        goto L_0x0080;
    L_0x009b:
        if (r0 == 0) goto L_0x0098;
    L_0x009d:
        r0.close();
        goto L_0x0098;
    L_0x00a1:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
    L_0x00a5:
        if (r1 == 0) goto L_0x00aa;
    L_0x00a7:
        r1.close();
    L_0x00aa:
        throw r0;
    L_0x00ab:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x00a5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.reportsdk.f.a(java.lang.String):java.util.List<com.shuame.reportsdk.a>");
    }

    /* renamed from: a */
    final void mo6877a(String str, String str2) {
        ContentValues contentValues;
        if (TextUtils.isEmpty(mo6878b(str))) {
            contentValues = new ContentValues();
            contentValues.put("content", str2);
            contentValues.put("batch_key_name", str);
            this.f3299b.getWritableDatabase().insert("info", null, contentValues);
            return;
        }
        contentValues = new ContentValues();
        contentValues.put("content", str2);
        this.f3299b.getWritableDatabase().update("info", contentValues, "batch_key_name = ? ", new String[]{str});
    }

    /* renamed from: b */
    final String mo6878b(String str) {
        Throwable th;
        String str2 = null;
        Cursor rawQuery;
        try {
            rawQuery = this.f3299b.getReadableDatabase().rawQuery("SELECT content FROM info" + " where batch_key_name = \"" + str + "\"", null);
            try {
                if (rawQuery.moveToFirst()) {
                    str2 = rawQuery.getString(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                } else if (rawQuery != null) {
                    rawQuery.close();
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            rawQuery = null;
            th = th4;
        }
    }

    /* renamed from: c */
    final int mo6879c(String str) {
        Cursor cursor = null;
        int i = 0;
        try {
            SQLiteDatabase readableDatabase = this.f3299b.getReadableDatabase();
            String str2 = "SELECT COUNT(*) FROM events";
            if (!TextUtils.isEmpty(str)) {
                str2 = str2 + " where batch_key_name =\"" + str + "\"";
            }
            cursor = readableDatabase.rawQuery(str2, null);
            if (cursor.moveToFirst()) {
                i = cursor.getInt(0);
            } else if (cursor != null) {
                cursor.close();
            }
            return i;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* renamed from: d */
    final int mo6880d(String str) {
        return this.f3299b.getWritableDatabase().delete("events", "batch_key_name = ? ", new String[]{str});
    }

    /* renamed from: e */
    final int mo6881e(String str) {
        return this.f3299b.getWritableDatabase().delete("info", "batch_key_name = ? ", new String[]{str});
    }
}
