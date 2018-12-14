package com.baidu.mobads.openad.p029c;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.mobads.p021j.C0338m;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.baidu.mobads.openad.c.g */
public class C0363g {
    /* renamed from: a */
    private C0365i f774a;
    /* renamed from: b */
    private String f775b;

    public C0363g(Context context) {
        this.f774a = new C0365i(context);
        this.f775b = C0338m.m569a().mo5041n().getCurrentProcessName(context);
    }

    /* renamed from: a */
    public void mo5096a(List<C0364h> list) {
        SQLiteDatabase writableDatabase = this.f774a.getWritableDatabase();
        for (C0364h c0364h : list) {
            try {
                writableDatabase.execSQL("insert into download_info(thread_id,url,local_file,start_pos,end_pos,compelete_size,process_name) values (?,?,?,?,?,?,?)", new Object[]{Integer.valueOf(c0364h.mo5106c()), c0364h.mo5103b(), c0364h.mo5111f(), Integer.valueOf(c0364h.mo5108d()), Integer.valueOf(c0364h.mo5110e()), Integer.valueOf(c0364h.mo5100a()), this.f775b});
            } catch (Exception e) {
                C0338m.m569a().mo5033f().mo4929e("OAdSqlLiteAccessObj", e.getMessage());
            }
        }
    }

    /* renamed from: a */
    public boolean mo5097a(String str, String str2) {
        Cursor rawQuery = this.f774a.getReadableDatabase().rawQuery("select count(*)  from download_info where url=? and local_file=? and process_name=?", new String[]{str, str2, this.f775b});
        rawQuery.moveToFirst();
        int i = rawQuery.getInt(0);
        rawQuery.close();
        return i > 0;
    }

    /* renamed from: b */
    public List<C0364h> mo5098b(String str, String str2) {
        List<C0364h> arrayList = new ArrayList();
        Cursor rawQuery = this.f774a.getReadableDatabase().rawQuery("select thread_id, url, local_file, start_pos, end_pos,compelete_size from download_info where url=? and local_file=? and process_name=?", new String[]{str, str2, this.f775b});
        while (rawQuery.moveToNext()) {
            arrayList.add(new C0364h(rawQuery.getInt(0), rawQuery.getString(1), rawQuery.getString(2), rawQuery.getInt(3), rawQuery.getInt(4), rawQuery.getInt(5)));
        }
        rawQuery.close();
        return arrayList;
    }

    /* renamed from: b */
    public void mo5099b(List<C0364h> list) {
        SQLiteDatabase readableDatabase = this.f774a.getReadableDatabase();
        for (C0364h c0364h : list) {
            try {
                readableDatabase.execSQL("update download_info set compelete_size=? where thread_id=? and url=? and local_file=? and process_name=?", new Object[]{Integer.valueOf(c0364h.mo5100a()), Integer.valueOf(c0364h.mo5106c()), c0364h.mo5103b(), c0364h.mo5111f(), this.f775b});
            } catch (Exception e) {
                C0338m.m569a().mo5033f().mo4929e("OAdSqlLiteAccessObj", e.getMessage());
            }
        }
    }
}
