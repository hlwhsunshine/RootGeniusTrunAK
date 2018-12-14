package com.shuame.rootgenius.appmanager.p091b;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.shuame.rootgenius.appmanager.C1253a;

/* renamed from: com.shuame.rootgenius.appmanager.b.c */
public class C1256c extends SQLiteOpenHelper {
    /* renamed from: a */
    private static final String f3350a = C1256c.class.getSimpleName();

    private C1256c() {
        super(C1253a.m3545a(), "app_uninstall_module", null, 1);
    }

    /* renamed from: a */
    public static C1256c m3552a() {
        return new C1256c();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        StringBuilder stringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        stringBuilder.append("app_uninstall_report (");
        stringBuilder.append("id_ integer primary key autoincrement");
        stringBuilder.append(" ,package_name varchar");
        stringBuilder.append(" ,version_code varchar");
        stringBuilder.append(")");
        sQLiteDatabase.execSQL(stringBuilder.toString());
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
