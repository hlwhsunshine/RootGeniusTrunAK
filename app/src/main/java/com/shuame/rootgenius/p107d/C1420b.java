package com.shuame.rootgenius.p107d;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.shuame.rootgenius.common.p100a.C1317b;
import com.shuame.rootgenius.pojo.BbxPopInfo;

/* renamed from: com.shuame.rootgenius.d.b */
public class C1420b {
    /* renamed from: c */
    private static C1420b f3914c = new C1420b();
    /* renamed from: a */
    private final String f3915a = C1420b.class.getSimpleName();
    /* renamed from: b */
    private C1317b f3916b = C1317b.m3684a();

    private C1420b() {
    }

    /* renamed from: a */
    public static C1420b m3944a() {
        return f3914c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0071  */
    /* renamed from: a */
    private boolean m3945a(java.lang.String r8) {
        /*
        r7 = this;
        r2 = 0;
        r1 = 1;
        r0 = 0;
        r3 = android.text.TextUtils.isEmpty(r8);
        if (r3 == 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r3 = "SELECT name_";
        r4.append(r3);
        r3 = " FROM bbx_pop";
        r4.append(r3);
        r3 = " WHERE name_=?";
        r4.append(r3);
        r3 = r7.f3916b;	 Catch:{ Exception -> 0x004c, all -> 0x0062 }
        r3 = r3.getReadableDatabase();	 Catch:{ Exception -> 0x004c, all -> 0x0062 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0077 }
        r5 = 1;
        r5 = new java.lang.String[r5];	 Catch:{ Exception -> 0x0077 }
        r6 = 0;
        r5[r6] = r8;	 Catch:{ Exception -> 0x0077 }
        r2 = r3.rawQuery(r4, r5);	 Catch:{ Exception -> 0x0077 }
        if (r2 == 0) goto L_0x003b;
    L_0x0034:
        r4 = r2.getCount();	 Catch:{ Exception -> 0x0077 }
        if (r4 <= 0) goto L_0x003b;
    L_0x003a:
        r0 = r1;
    L_0x003b:
        if (r2 == 0) goto L_0x0046;
    L_0x003d:
        r1 = r2.isClosed();
        if (r1 != 0) goto L_0x0046;
    L_0x0043:
        r2.close();
    L_0x0046:
        if (r3 == 0) goto L_0x0009;
    L_0x0048:
        r3.close();
        goto L_0x0009;
    L_0x004c:
        r1 = move-exception;
        r3 = r2;
    L_0x004e:
        r1.printStackTrace();	 Catch:{ all -> 0x0075 }
        if (r2 == 0) goto L_0x005c;
    L_0x0053:
        r1 = r2.isClosed();
        if (r1 != 0) goto L_0x005c;
    L_0x0059:
        r2.close();
    L_0x005c:
        if (r3 == 0) goto L_0x0009;
    L_0x005e:
        r3.close();
        goto L_0x0009;
    L_0x0062:
        r0 = move-exception;
        r3 = r2;
    L_0x0064:
        if (r2 == 0) goto L_0x006f;
    L_0x0066:
        r1 = r2.isClosed();
        if (r1 != 0) goto L_0x006f;
    L_0x006c:
        r2.close();
    L_0x006f:
        if (r3 == 0) goto L_0x0074;
    L_0x0071:
        r3.close();
    L_0x0074:
        throw r0;
    L_0x0075:
        r0 = move-exception;
        goto L_0x0064;
    L_0x0077:
        r1 = move-exception;
        goto L_0x004e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.d.b.a(java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0087  */
    /* renamed from: a */
    public final boolean mo7138a(com.shuame.rootgenius.pojo.BbxPopInfo r9) {
        /*
        r8 = this;
        r4 = -1;
        r0 = 0;
        r2 = 0;
        if (r9 == 0) goto L_0x000e;
    L_0x0006:
        r1 = r9.name;
        r1 = r8.m3945a(r1);
        if (r1 == 0) goto L_0x000f;
    L_0x000e:
        return r0;
    L_0x000f:
        r7 = new android.content.ContentValues;
        r7.<init>();
        r1 = "option_";
        r3 = r9.option;
        r3 = java.lang.Integer.valueOf(r3);
        r7.put(r1, r3);
        r1 = "name_";
        r3 = r9.name;
        r7.put(r1, r3);
        r1 = "title_";
        r3 = r9.title;
        r7.put(r1, r3);
        r1 = "pic_";
        r3 = r9.pic;
        r7.put(r1, r3);
        r1 = "text_";
        r3 = r9.text;
        r7.put(r1, r3);
        r1 = r8.f3916b;	 Catch:{ Exception -> 0x0071, all -> 0x0083 }
        r6 = r1.getWritableDatabase();	 Catch:{ Exception -> 0x0071, all -> 0x0083 }
        r6.beginTransaction();	 Catch:{ Exception -> 0x00a2 }
        r1 = "bbx_pop";
        r2 = 0;
        r3 = 0;
        r6.delete(r1, r2, r3);	 Catch:{ Exception -> 0x00a2 }
        r1 = "bbx_pop";
        r2 = 0;
        r2 = r6.insert(r1, r2, r7);	 Catch:{ Exception -> 0x00a2 }
        r6.setTransactionSuccessful();	 Catch:{ Exception -> 0x00a5 }
        if (r6 == 0) goto L_0x005d;
    L_0x0057:
        r6.endTransaction();
        r6.close();
    L_0x005d:
        r7.clear();
    L_0x0060:
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 != 0) goto L_0x0091;
    L_0x0064:
        r1 = new java.lang.StringBuilder;
        r2 = "保存数据失败--name=";
        r1.<init>(r2);
        r2 = r9.name;
        r1.append(r2);
        goto L_0x000e;
    L_0x0071:
        r1 = move-exception;
        r6 = r2;
        r2 = r4;
    L_0x0074:
        r1.printStackTrace();	 Catch:{ all -> 0x00a0 }
        if (r6 == 0) goto L_0x007f;
    L_0x0079:
        r6.endTransaction();
        r6.close();
    L_0x007f:
        r7.clear();
        goto L_0x0060;
    L_0x0083:
        r0 = move-exception;
        r6 = r2;
    L_0x0085:
        if (r6 == 0) goto L_0x008d;
    L_0x0087:
        r6.endTransaction();
        r6.close();
    L_0x008d:
        r7.clear();
        throw r0;
    L_0x0091:
        r0 = new java.lang.StringBuilder;
        r1 = "保存数据成功--name=";
        r0.<init>(r1);
        r1 = r9.name;
        r0.append(r1);
        r0 = 1;
        goto L_0x000e;
    L_0x00a0:
        r0 = move-exception;
        goto L_0x0085;
    L_0x00a2:
        r1 = move-exception;
        r2 = r4;
        goto L_0x0074;
    L_0x00a5:
        r1 = move-exception;
        goto L_0x0074;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.d.b.a(com.shuame.rootgenius.pojo.BbxPopInfo):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cc A:{ExcHandler: all (th java.lang.Throwable), Splitter: B:6:0x0021} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c5  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:35:0x00b1, code:
            r3.close();
     */
    /* JADX WARNING: Missing block: B:43:0x00c5, code:
            r3.close();
     */
    /* JADX WARNING: Missing block: B:47:0x00cc, code:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:52:0x00d5, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:53:0x00d6, code:
            r5 = r0;
            r0 = null;
            r2 = r1;
            r1 = r5;
     */
    /* renamed from: b */
    public final com.shuame.rootgenius.pojo.BbxPopInfo mo7139b() {
        /*
        r6 = this;
        r2 = 0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "SELECT * ";
        r0.append(r1);
        r1 = " FROM bbx_pop";
        r0.append(r1);
        r1 = r6.f3916b;	 Catch:{ Exception -> 0x009d, all -> 0x00b5 }
        r3 = r1.getReadableDatabase();	 Catch:{ Exception -> 0x009d, all -> 0x00b5 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00d1, all -> 0x00c9 }
        r1 = 0;
        r1 = r3.rawQuery(r0, r1);	 Catch:{ Exception -> 0x00d1, all -> 0x00c9 }
        if (r1 == 0) goto L_0x00e0;
    L_0x0021:
        r0 = r1.getCount();	 Catch:{ Exception -> 0x00d5, all -> 0x00cc }
        if (r0 <= 0) goto L_0x00e0;
    L_0x0027:
        r4 = new com.shuame.rootgenius.pojo.BbxPopInfo;	 Catch:{ Exception -> 0x00d5, all -> 0x00cc }
        r4.<init>();	 Catch:{ Exception -> 0x00d5, all -> 0x00cc }
        r0 = r1.moveToNext();	 Catch:{ Exception -> 0x00db, all -> 0x00cc }
        if (r0 == 0) goto L_0x0089;
    L_0x0032:
        r0 = "id_";
        r0 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x00db, all -> 0x00cc }
        r0 = r1.getInt(r0);	 Catch:{ Exception -> 0x00db, all -> 0x00cc }
        r4.dbId = r0;	 Catch:{ Exception -> 0x00db, all -> 0x00cc }
        r0 = "option_";
        r0 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x00db, all -> 0x00cc }
        r0 = r1.getInt(r0);	 Catch:{ Exception -> 0x00db, all -> 0x00cc }
        r4.option = r0;	 Catch:{ Exception -> 0x00db, all -> 0x00cc }
        r0 = "name_";
        r0 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x00db, all -> 0x00cc }
        r0 = r1.getString(r0);	 Catch:{ Exception -> 0x00db, all -> 0x00cc }
        r4.name = r0;	 Catch:{ Exception -> 0x00db, all -> 0x00cc }
        r0 = "title_";
        r0 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x00db, all -> 0x00cc }
        r0 = r1.getString(r0);	 Catch:{ Exception -> 0x00db, all -> 0x00cc }
        r4.title = r0;	 Catch:{ Exception -> 0x00db, all -> 0x00cc }
        r0 = "pic_";
        r0 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x00db, all -> 0x00cc }
        r0 = r1.getString(r0);	 Catch:{ Exception -> 0x00db, all -> 0x00cc }
        r4.pic = r0;	 Catch:{ Exception -> 0x00db, all -> 0x00cc }
        r0 = "text_";
        r0 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x00db, all -> 0x00cc }
        r0 = r1.getString(r0);	 Catch:{ Exception -> 0x00db, all -> 0x00cc }
        r4.text = r0;	 Catch:{ Exception -> 0x00db, all -> 0x00cc }
        r0 = "showed_";
        r0 = r1.getColumnIndex(r0);	 Catch:{ Exception -> 0x00db, all -> 0x00cc }
        r0 = r1.getInt(r0);	 Catch:{ Exception -> 0x00db, all -> 0x00cc }
        if (r0 != 0) goto L_0x009b;
    L_0x0086:
        r0 = 0;
    L_0x0087:
        r4.isShowed = r0;	 Catch:{ Exception -> 0x00db, all -> 0x00cc }
    L_0x0089:
        r0 = r4;
    L_0x008a:
        if (r1 == 0) goto L_0x0095;
    L_0x008c:
        r2 = r1.isClosed();
        if (r2 != 0) goto L_0x0095;
    L_0x0092:
        r1.close();
    L_0x0095:
        if (r3 == 0) goto L_0x009a;
    L_0x0097:
        r3.close();
    L_0x009a:
        return r0;
    L_0x009b:
        r0 = 1;
        goto L_0x0087;
    L_0x009d:
        r0 = move-exception;
        r1 = r0;
        r3 = r2;
        r0 = r2;
    L_0x00a1:
        r1.printStackTrace();	 Catch:{ all -> 0x00ce }
        if (r2 == 0) goto L_0x00af;
    L_0x00a6:
        r1 = r2.isClosed();
        if (r1 != 0) goto L_0x00af;
    L_0x00ac:
        r2.close();
    L_0x00af:
        if (r3 == 0) goto L_0x009a;
    L_0x00b1:
        r3.close();
        goto L_0x009a;
    L_0x00b5:
        r0 = move-exception;
        r1 = r2;
        r3 = r2;
    L_0x00b8:
        if (r1 == 0) goto L_0x00c3;
    L_0x00ba:
        r2 = r1.isClosed();
        if (r2 != 0) goto L_0x00c3;
    L_0x00c0:
        r1.close();
    L_0x00c3:
        if (r3 == 0) goto L_0x00c8;
    L_0x00c5:
        r3.close();
    L_0x00c8:
        throw r0;
    L_0x00c9:
        r0 = move-exception;
        r1 = r2;
        goto L_0x00b8;
    L_0x00cc:
        r0 = move-exception;
        goto L_0x00b8;
    L_0x00ce:
        r0 = move-exception;
        r1 = r2;
        goto L_0x00b8;
    L_0x00d1:
        r0 = move-exception;
        r1 = r0;
        r0 = r2;
        goto L_0x00a1;
    L_0x00d5:
        r0 = move-exception;
        r5 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r5;
        goto L_0x00a1;
    L_0x00db:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x00a1;
    L_0x00e0:
        r0 = r2;
        goto L_0x008a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.d.b.b():com.shuame.rootgenius.pojo.BbxPopInfo");
    }

    /* renamed from: b */
    public final synchronized boolean mo7140b(BbxPopInfo bbxPopInfo) {
        boolean z = false;
        synchronized (this) {
            if (bbxPopInfo != null) {
                if (m3945a(bbxPopInfo.name)) {
                    long j;
                    SQLiteDatabase sQLiteDatabase = null;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("showed_", Integer.valueOf(bbxPopInfo.isShowed ? 1 : 0));
                    try {
                        sQLiteDatabase = this.f3916b.getWritableDatabase();
                        long update = (long) sQLiteDatabase.update("bbx_pop", contentValues, "name_=?", new String[]{bbxPopInfo.name});
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        contentValues.clear();
                        j = update;
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
                        new StringBuilder("更新失败--name=").append(bbxPopInfo.name);
                    } else {
                        String.format("更新成功--name=%s,isShowed=%s", new Object[]{bbxPopInfo.name, Boolean.valueOf(bbxPopInfo.isShowed)});
                        z = true;
                    }
                }
            }
        }
        return z;
    }
}
