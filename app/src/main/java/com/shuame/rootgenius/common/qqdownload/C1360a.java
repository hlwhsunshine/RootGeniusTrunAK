package com.shuame.rootgenius.common.qqdownload;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Type;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.shuame.rootgenius.common.qqdownload.a */
public class C1360a {
    /* renamed from: a */
    private static final String f3747a = C1360a.class.getSimpleName();
    /* renamed from: b */
    private C1359a f3748b;
    /* renamed from: c */
    private SQLiteDatabase f3749c = this.f3748b.getWritableDatabase();

    /* renamed from: com.shuame.rootgenius.common.qqdownload.a$a */
    private static class C1359a extends SQLiteOpenHelper {
        /* renamed from: a */
        private static final String f3746a = C1359a.class.getSimpleName();

        public C1359a(Context context) {
            super(context, "qqdownload.db", null, 8);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS download_files(id INTEGER PRIMARY KEY AUTOINCREMENT,uuid INTEGER,task_id INTEGER UNIQUE,url VARCHAR UNIQUE,path VARCHAR,md5 VARCHAR,file_size BIGINT,percent INTEGER,speed INTEGER,down_time BIGINT,name TEXT,only_src_url BOOL,result INTEGER,type INTEGER,data TEXT,string1 VARCHAR,string2 VARCHAR,string3 VARCHAR,string4 VARCHAR,string5 VARCHAR,string6 VARCHAR,long1 BIGINT,long2 BIGINT,long3 BIGINT,long4 BIGINT,long5 BIGINT,long6 BIGINT);");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            new StringBuilder("onDowngrade oldVersion:").append(i).append(" newVersion:").append(i2);
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            new StringBuilder("onUpgrade oldVersion:").append(i).append(" newVersion:").append(i2);
            try {
                sQLiteDatabase.execSQL("DROP TABLE download_files");
            } catch (Exception e) {
                e.printStackTrace();
            }
            onCreate(sQLiteDatabase);
        }
    }

    C1360a(Context context) {
        this.f3748b = new C1359a(context);
    }

    /* renamed from: a */
    private static QQDownloadFile m3802a(Cursor cursor) {
        boolean z = true;
        QQDownloadFile qQDownloadFile = new QQDownloadFile();
        qQDownloadFile.f3720a = cursor.getInt(cursor.getColumnIndex("id"));
        qQDownloadFile.f3721b = cursor.getInt(cursor.getColumnIndex("uuid"));
        qQDownloadFile.f3722c = cursor.getInt(cursor.getColumnIndex("task_id"));
        qQDownloadFile.f3724e = cursor.getString(cursor.getColumnIndex("url"));
        qQDownloadFile.f3725f = cursor.getString(cursor.getColumnIndex("path"));
        qQDownloadFile.f3726g = cursor.getString(cursor.getColumnIndex("md5"));
        qQDownloadFile.f3727h = cursor.getLong(cursor.getColumnIndex("file_size"));
        qQDownloadFile.f3728i = cursor.getInt(cursor.getColumnIndex("percent"));
        if (cursor.getInt(cursor.getColumnIndex("only_src_url")) != 1) {
            z = false;
        }
        qQDownloadFile.f3732m = z;
        qQDownloadFile.f3733n = cursor.getInt(cursor.getColumnIndex("result"));
        qQDownloadFile.f3734o = Type.fromValue(cursor.getInt(cursor.getColumnIndex("type")));
        qQDownloadFile.f3729j = cursor.getInt(cursor.getColumnIndex("speed"));
        qQDownloadFile.f3731l = cursor.getString(cursor.getColumnIndex("name"));
        qQDownloadFile.f3730k = cursor.getLong(cursor.getColumnIndex("down_time"));
        qQDownloadFile.f3735p = cursor.getString(cursor.getColumnIndex("data"));
        qQDownloadFile.f3736q = cursor.getString(cursor.getColumnIndex("string1"));
        qQDownloadFile.f3737r = cursor.getString(cursor.getColumnIndex("string2"));
        qQDownloadFile.f3738s = cursor.getString(cursor.getColumnIndex("string3"));
        qQDownloadFile.f3739t = cursor.getString(cursor.getColumnIndex("string4"));
        qQDownloadFile.f3740u = cursor.getString(cursor.getColumnIndex("string5"));
        qQDownloadFile.f3741v = cursor.getString(cursor.getColumnIndex("string6"));
        qQDownloadFile.f3742w = cursor.getLong(cursor.getColumnIndex("long1"));
        qQDownloadFile.f3743x = cursor.getLong(cursor.getColumnIndex("long2"));
        qQDownloadFile.f3744y = cursor.getLong(cursor.getColumnIndex("long3"));
        qQDownloadFile.f3745z = cursor.getLong(cursor.getColumnIndex("long4"));
        qQDownloadFile.f3717A = cursor.getLong(cursor.getColumnIndex("long5"));
        qQDownloadFile.f3718B = cursor.getLong(cursor.getColumnIndex("long6"));
        return qQDownloadFile;
    }

    /* renamed from: c */
    private static ContentValues m3803c(QQDownloadFile qQDownloadFile) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("uuid", Integer.valueOf(qQDownloadFile.f3721b));
        contentValues.put("task_id", Integer.valueOf(qQDownloadFile.f3722c));
        contentValues.put("url", qQDownloadFile.f3724e);
        contentValues.put("path", qQDownloadFile.f3725f);
        contentValues.put("md5", qQDownloadFile.f3726g);
        contentValues.put("file_size", Long.valueOf(qQDownloadFile.f3727h));
        contentValues.put("percent", Integer.valueOf(qQDownloadFile.f3728i));
        contentValues.put("speed", Integer.valueOf(qQDownloadFile.f3729j));
        contentValues.put("name", qQDownloadFile.f3731l);
        contentValues.put("down_time", Long.valueOf(qQDownloadFile.f3730k));
        contentValues.put("only_src_url", Boolean.valueOf(qQDownloadFile.f3732m));
        contentValues.put("data", qQDownloadFile.f3735p);
        contentValues.put("string1", qQDownloadFile.f3736q);
        contentValues.put("string2", qQDownloadFile.f3737r);
        contentValues.put("string3", qQDownloadFile.f3738s);
        contentValues.put("string4", qQDownloadFile.f3739t);
        contentValues.put("string5", qQDownloadFile.f3740u);
        contentValues.put("string6", qQDownloadFile.f3741v);
        contentValues.put("long1", Long.valueOf(qQDownloadFile.f3742w));
        contentValues.put("long2", Long.valueOf(qQDownloadFile.f3743x));
        contentValues.put("long3", Long.valueOf(qQDownloadFile.f3744y));
        contentValues.put("long4", Long.valueOf(qQDownloadFile.f3745z));
        contentValues.put("long5", Long.valueOf(qQDownloadFile.f3717A));
        contentValues.put("long6", Long.valueOf(qQDownloadFile.f3718B));
        if (qQDownloadFile.f3734o != null) {
            contentValues.put("type", Integer.valueOf(qQDownloadFile.f3734o.getValue()));
        }
        return contentValues;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0052  */
    /* renamed from: a */
    public final com.shuame.rootgenius.common.qqdownload.QQDownloadFile mo7056a(java.lang.String r10) {
        /*
        r9 = this;
        r8 = 0;
        r0 = r9.f3749c;	 Catch:{ SQLException -> 0x0037, IllegalStateException -> 0x0043 }
        r1 = "download_files";
        r2 = 0;
        r3 = new java.lang.StringBuilder;	 Catch:{ SQLException -> 0x0037, IllegalStateException -> 0x0043 }
        r4 = "url = '";
        r3.<init>(r4);	 Catch:{ SQLException -> 0x0037, IllegalStateException -> 0x0043 }
        r3 = r3.append(r10);	 Catch:{ SQLException -> 0x0037, IllegalStateException -> 0x0043 }
        r4 = "'";
        r3 = r3.append(r4);	 Catch:{ SQLException -> 0x0037, IllegalStateException -> 0x0043 }
        r3 = r3.toString();	 Catch:{ SQLException -> 0x0037, IllegalStateException -> 0x0043 }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ SQLException -> 0x0037, IllegalStateException -> 0x0043 }
        r0 = r8;
    L_0x0024:
        if (r1 == 0) goto L_0x0031;
    L_0x0026:
        r2 = r1.moveToNext();	 Catch:{ SQLException -> 0x005d, IllegalStateException -> 0x0059 }
        if (r2 == 0) goto L_0x0031;
    L_0x002c:
        r0 = com.shuame.rootgenius.common.qqdownload.C1360a.m3802a(r1);	 Catch:{ SQLException -> 0x005d, IllegalStateException -> 0x0059 }
        goto L_0x0024;
    L_0x0031:
        if (r1 == 0) goto L_0x0036;
    L_0x0033:
        r1.close();
    L_0x0036:
        return r0;
    L_0x0037:
        r0 = move-exception;
        r1 = r8;
    L_0x0039:
        r0.printStackTrace();	 Catch:{ all -> 0x0056 }
        if (r1 == 0) goto L_0x0041;
    L_0x003e:
        r1.close();
    L_0x0041:
        r0 = r8;
        goto L_0x0036;
    L_0x0043:
        r0 = move-exception;
        r1 = r0;
        r0 = r8;
    L_0x0046:
        r1.printStackTrace();	 Catch:{ all -> 0x004f }
        if (r8 == 0) goto L_0x0036;
    L_0x004b:
        r8.close();
        goto L_0x0036;
    L_0x004f:
        r0 = move-exception;
    L_0x0050:
        if (r8 == 0) goto L_0x0055;
    L_0x0052:
        r8.close();
    L_0x0055:
        throw r0;
    L_0x0056:
        r0 = move-exception;
        r8 = r1;
        goto L_0x0050;
    L_0x0059:
        r2 = move-exception;
        r8 = r1;
        r1 = r2;
        goto L_0x0046;
    L_0x005d:
        r0 = move-exception;
        goto L_0x0039;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.common.qqdownload.a.a(java.lang.String):com.shuame.rootgenius.common.qqdownload.QQDownloadFile");
    }

    /* renamed from: a */
    public final List<QQDownloadFile> mo7057a() {
        Cursor cursor = null;
        List<QQDownloadFile> arrayList = new ArrayList();
        try {
            cursor = this.f3749c.rawQuery("SELECT * FROM download_files ORDER BY id", null);
            while (cursor.moveToNext()) {
                arrayList.add(C1360a.m3802a(cursor));
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            if (cursor != null) {
                cursor.close();
            }
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public final void mo7058a(int i) {
        try {
            Object[] objArr = new Object[]{Boolean.valueOf(true), Integer.valueOf(i)};
            this.f3749c.execSQL("UPDATE download_files SET only_src_url = ? WHERE task_id = ?", objArr);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void mo7059a(int i, int i2, int i3) {
        try {
            Object[] objArr = new Object[]{Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i)};
            this.f3749c.execSQL("UPDATE download_files SET percent = ?, speed = ? WHERE task_id = ?", objArr);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void mo7060a(int i, long j) {
        try {
            Object[] objArr = new Object[]{Long.valueOf(j), Integer.valueOf(i)};
            this.f3749c.execSQL("UPDATE download_files SET result = ? WHERE task_id = ?", objArr);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void mo7061a(int i, long j, long j2) {
        try {
            Object[] objArr = new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)};
            this.f3749c.execSQL("UPDATE download_files SET result = ?, long6 = ? WHERE task_id = ?", objArr);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void mo7062a(int i, String str) {
        try {
            Object[] objArr = new Object[]{str, Integer.valueOf(i)};
            this.f3749c.execSQL("UPDATE download_files SET path = ? WHERE task_id = ?", objArr);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void mo7063a(QQDownloadFile qQDownloadFile) {
        try {
            this.f3749c.insertOrThrow("download_files", "id", C1360a.m3803c(qQDownloadFile));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: b */
    public final void mo7064b(int i) {
        try {
            Object[] objArr = new Object[]{Integer.valueOf(i)};
            this.f3749c.execSQL("DELETE FROM download_files WHERE task_id = ?", objArr);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: b */
    public final void mo7065b(QQDownloadFile qQDownloadFile) {
        try {
            if (qQDownloadFile.f3720a > 0) {
                this.f3749c.update("download_files", C1360a.m3803c(qQDownloadFile), "id = ?", new String[]{qQDownloadFile.f3720a});
                return;
            }
            this.f3749c.update("download_files", C1360a.m3803c(qQDownloadFile), "url = ?", new String[]{qQDownloadFile.f3724e});
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        } catch (NullPointerException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004c  */
    /* renamed from: c */
    public final com.shuame.rootgenius.common.qqdownload.QQDownloadFile mo7066c(int r10) {
        /*
        r9 = this;
        r8 = 0;
        r0 = r9.f3749c;	 Catch:{ SQLException -> 0x0031, IllegalStateException -> 0x003d }
        r1 = "download_files";
        r2 = 0;
        r3 = new java.lang.StringBuilder;	 Catch:{ SQLException -> 0x0031, IllegalStateException -> 0x003d }
        r4 = "uuid = ";
        r3.<init>(r4);	 Catch:{ SQLException -> 0x0031, IllegalStateException -> 0x003d }
        r3 = r3.append(r10);	 Catch:{ SQLException -> 0x0031, IllegalStateException -> 0x003d }
        r3 = r3.toString();	 Catch:{ SQLException -> 0x0031, IllegalStateException -> 0x003d }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ SQLException -> 0x0031, IllegalStateException -> 0x003d }
        r0 = r8;
    L_0x001e:
        if (r1 == 0) goto L_0x002b;
    L_0x0020:
        r2 = r1.moveToNext();	 Catch:{ SQLException -> 0x0057, IllegalStateException -> 0x0053 }
        if (r2 == 0) goto L_0x002b;
    L_0x0026:
        r0 = com.shuame.rootgenius.common.qqdownload.C1360a.m3802a(r1);	 Catch:{ SQLException -> 0x0057, IllegalStateException -> 0x0053 }
        goto L_0x001e;
    L_0x002b:
        if (r1 == 0) goto L_0x0030;
    L_0x002d:
        r1.close();
    L_0x0030:
        return r0;
    L_0x0031:
        r0 = move-exception;
        r1 = r8;
    L_0x0033:
        r0.printStackTrace();	 Catch:{ all -> 0x0050 }
        if (r1 == 0) goto L_0x003b;
    L_0x0038:
        r1.close();
    L_0x003b:
        r0 = r8;
        goto L_0x0030;
    L_0x003d:
        r0 = move-exception;
        r1 = r0;
        r0 = r8;
    L_0x0040:
        r1.printStackTrace();	 Catch:{ all -> 0x0049 }
        if (r8 == 0) goto L_0x0030;
    L_0x0045:
        r8.close();
        goto L_0x0030;
    L_0x0049:
        r0 = move-exception;
    L_0x004a:
        if (r8 == 0) goto L_0x004f;
    L_0x004c:
        r8.close();
    L_0x004f:
        throw r0;
    L_0x0050:
        r0 = move-exception;
        r8 = r1;
        goto L_0x004a;
    L_0x0053:
        r2 = move-exception;
        r8 = r1;
        r1 = r2;
        goto L_0x0040;
    L_0x0057:
        r0 = move-exception;
        goto L_0x0033;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.common.qqdownload.a.c(int):com.shuame.rootgenius.common.qqdownload.QQDownloadFile");
    }
}
