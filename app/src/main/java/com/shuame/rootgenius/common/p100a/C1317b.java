package com.shuame.rootgenius.common.p100a;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.shuame.rootgenius.common.C1325c;

/* renamed from: com.shuame.rootgenius.common.a.b */
public class C1317b extends SQLiteOpenHelper {
    /* renamed from: a */
    private static final String f3573a = C1317b.class.getSimpleName();

    private C1317b() {
        super(C1325c.m3724a(), "root_genius", null, 2);
    }

    /* renamed from: a */
    public static C1317b m3684a() {
        return new C1317b();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder stringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
            stringBuilder.append("bbx_report (");
            stringBuilder.append("id_ integer primary key autoincrement");
            stringBuilder.append(" ,project_name varchar");
            stringBuilder.append(" ,action_type varchar");
            stringBuilder.append(" ,success varchar");
            stringBuilder.append(" ,description varchar");
            stringBuilder.append(" ,package_name integer");
            stringBuilder.append(" ,app_check_flag integer");
            stringBuilder.append(")");
            sQLiteDatabase.execSQL(stringBuilder.toString());
            stringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
            stringBuilder.append("bbx_open_report (");
            stringBuilder.append("id_ integer primary key autoincrement");
            stringBuilder.append(" ,category_ varchar");
            stringBuilder.append(" ,name_ varchar");
            stringBuilder.append(")");
            sQLiteDatabase.execSQL(stringBuilder.toString());
            stringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
            stringBuilder.append("bbx_pop (");
            stringBuilder.append("id_ integer primary key autoincrement");
            stringBuilder.append(" ,option_ integer");
            stringBuilder.append(" ,name_ varchar");
            stringBuilder.append(" ,title_ varchar");
            stringBuilder.append(" ,pic_ varchar");
            stringBuilder.append(" ,text_ varchar");
            stringBuilder.append(" ,showed_ integer DEFAULT 0");
            stringBuilder.append(")");
            sQLiteDatabase.execSQL(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bbx_pop");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bbx_report");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bbx_open_report");
            onCreate(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }
}
