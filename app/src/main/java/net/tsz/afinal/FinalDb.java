package net.tsz.afinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import net.tsz.afinal.exception.DbException;
import net.tsz.afinal.p121db.sqlite.CursorUtils;
import net.tsz.afinal.p121db.sqlite.DbModel;
import net.tsz.afinal.p121db.sqlite.OneToManyLazyLoader;
import net.tsz.afinal.p121db.sqlite.SqlBuilder;
import net.tsz.afinal.p121db.sqlite.SqlInfo;
import net.tsz.afinal.p121db.table.KeyValue;
import net.tsz.afinal.p121db.table.ManyToOne;
import net.tsz.afinal.p121db.table.OneToMany;
import net.tsz.afinal.p121db.table.TableInfo;

public class FinalDb {
    private static final String TAG = "FinalDb";
    private static HashMap<String, FinalDb> daoMap = new HashMap();
    private DaoConfig config;
    /* renamed from: db */
    private SQLiteDatabase f5202db;

    public static class DaoConfig {
        private DbUpdateListener dbUpdateListener;
        private int dbVersion = 1;
        private boolean debug = true;
        private Context mContext = null;
        private String mDbName = "afinal.db";
        private String targetDirectory;

        public Context getContext() {
            return this.mContext;
        }

        public String getDbName() {
            return this.mDbName;
        }

        public DbUpdateListener getDbUpdateListener() {
            return this.dbUpdateListener;
        }

        public int getDbVersion() {
            return this.dbVersion;
        }

        public String getTargetDirectory() {
            return this.targetDirectory;
        }

        public boolean isDebug() {
            return this.debug;
        }

        public void setContext(Context context) {
            this.mContext = context;
        }

        public void setDbName(String str) {
            this.mDbName = str;
        }

        public void setDbUpdateListener(DbUpdateListener dbUpdateListener) {
            this.dbUpdateListener = dbUpdateListener;
        }

        public void setDbVersion(int i) {
            this.dbVersion = i;
        }

        public void setDebug(boolean z) {
            this.debug = z;
        }

        public void setTargetDirectory(String str) {
            this.targetDirectory = str;
        }
    }

    public interface DbUpdateListener {
        void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);
    }

    class SqliteDbHelper extends SQLiteOpenHelper {
        private DbUpdateListener mDbUpdateListener;

        public SqliteDbHelper(Context context, String str, int i, DbUpdateListener dbUpdateListener) {
            super(context, str, null, i);
            this.mDbUpdateListener = dbUpdateListener;
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (this.mDbUpdateListener != null) {
                this.mDbUpdateListener.onUpgrade(sQLiteDatabase, i, i2);
            } else {
                FinalDb.this.dropDb();
            }
        }
    }

    private FinalDb(DaoConfig daoConfig) {
        if (daoConfig == null) {
            throw new DbException("daoConfig is null");
        } else if (daoConfig.getContext() == null) {
            throw new DbException("android context is null");
        } else {
            if (daoConfig.getTargetDirectory() == null || daoConfig.getTargetDirectory().trim().length() <= 0) {
                this.f5202db = new SqliteDbHelper(daoConfig.getContext().getApplicationContext(), daoConfig.getDbName(), daoConfig.getDbVersion(), daoConfig.getDbUpdateListener()).getWritableDatabase();
            } else {
                this.f5202db = createDbFileOnSDCard(daoConfig.getTargetDirectory(), daoConfig.getDbName());
            }
            this.config = daoConfig;
        }
    }

    private void checkTableExist(Class<?> cls) {
        if (!tableIsExist(TableInfo.get((Class) cls))) {
            String creatTableSQL = SqlBuilder.getCreatTableSQL(cls);
            debugSql(creatTableSQL);
            this.f5202db.execSQL(creatTableSQL);
        }
    }

    public static FinalDb create(Context context) {
        DaoConfig daoConfig = new DaoConfig();
        daoConfig.setContext(context);
        return create(daoConfig);
    }

    public static FinalDb create(Context context, String str) {
        DaoConfig daoConfig = new DaoConfig();
        daoConfig.setContext(context);
        daoConfig.setDbName(str);
        return create(daoConfig);
    }

    public static FinalDb create(Context context, String str, String str2) {
        DaoConfig daoConfig = new DaoConfig();
        daoConfig.setContext(context);
        daoConfig.setDbName(str2);
        daoConfig.setTargetDirectory(str);
        return create(daoConfig);
    }

    public static FinalDb create(Context context, String str, String str2, boolean z) {
        DaoConfig daoConfig = new DaoConfig();
        daoConfig.setContext(context);
        daoConfig.setTargetDirectory(str);
        daoConfig.setDbName(str2);
        daoConfig.setDebug(z);
        return create(daoConfig);
    }

    public static FinalDb create(Context context, String str, String str2, boolean z, int i, DbUpdateListener dbUpdateListener) {
        DaoConfig daoConfig = new DaoConfig();
        daoConfig.setContext(context);
        daoConfig.setTargetDirectory(str);
        daoConfig.setDbName(str2);
        daoConfig.setDebug(z);
        daoConfig.setDbVersion(i);
        daoConfig.setDbUpdateListener(dbUpdateListener);
        return create(daoConfig);
    }

    public static FinalDb create(Context context, String str, boolean z) {
        DaoConfig daoConfig = new DaoConfig();
        daoConfig.setContext(context);
        daoConfig.setDbName(str);
        daoConfig.setDebug(z);
        return create(daoConfig);
    }

    public static FinalDb create(Context context, String str, boolean z, int i, DbUpdateListener dbUpdateListener) {
        DaoConfig daoConfig = new DaoConfig();
        daoConfig.setContext(context);
        daoConfig.setDbName(str);
        daoConfig.setDebug(z);
        daoConfig.setDbVersion(i);
        daoConfig.setDbUpdateListener(dbUpdateListener);
        return create(daoConfig);
    }

    public static FinalDb create(Context context, boolean z) {
        DaoConfig daoConfig = new DaoConfig();
        daoConfig.setContext(context);
        daoConfig.setDebug(z);
        return create(daoConfig);
    }

    public static FinalDb create(DaoConfig daoConfig) {
        return getInstance(daoConfig);
    }

    private SQLiteDatabase createDbFileOnSDCard(String str, String str2) {
        File file = new File(str, str2);
        if (file.exists()) {
            return SQLiteDatabase.openOrCreateDatabase(file, null);
        }
        try {
            return file.createNewFile() ? SQLiteDatabase.openOrCreateDatabase(file, null) : null;
        } catch (Throwable e) {
            throw new DbException("数据库文件创建失败", e);
        }
    }

    private void debugSql(String str) {
        if (this.config != null) {
            this.config.isDebug();
        }
    }

    private void exeSqlInfo(SqlInfo sqlInfo) {
        if (sqlInfo != null) {
            debugSql(sqlInfo.getSql());
            this.f5202db.execSQL(sqlInfo.getSql(), sqlInfo.getBindArgsAsArray());
        }
    }

    private <T> List<T> findAllBySql(Class<T> cls, String str) {
        checkTableExist(cls);
        debugSql(str);
        Cursor rawQuery = this.f5202db.rawQuery(str, null);
        try {
            List<T> arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                arrayList.add(CursorUtils.getEntity(rawQuery, cls, this));
            }
            if (rawQuery == null) {
                return arrayList;
            }
            rawQuery.close();
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            if (rawQuery != null) {
                rawQuery.close();
            }
            return null;
        } catch (Throwable th) {
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    private static synchronized FinalDb getInstance(DaoConfig daoConfig) {
        FinalDb finalDb;
        synchronized (FinalDb.class) {
            finalDb = (FinalDb) daoMap.get(daoConfig.getDbName());
            if (finalDb == null) {
                finalDb = new FinalDb(daoConfig);
                daoMap.put(daoConfig.getDbName(), finalDb);
            }
        }
        return finalDb;
    }

    private void insertContentValues(List<KeyValue> list, ContentValues contentValues) {
        if (list != null && contentValues != null) {
            for (KeyValue keyValue : list) {
                contentValues.put(keyValue.getKey(), keyValue.getValue().toString());
            }
        }
    }

    /* JADX WARNING: Failed to extract finally block: empty outs */
    private boolean tableIsExist(net.tsz.afinal.p121db.table.TableInfo r7) {
        /*
        r6 = this;
        r2 = 0;
        r1 = 0;
        r0 = 1;
        r3 = r7.isCheckDatabese();
        if (r3 == 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0046 }
        r4 = "SELECT COUNT(*) AS c FROM sqlite_master WHERE type ='table' AND name ='";
        r3.<init>(r4);	 Catch:{ Exception -> 0x0046 }
        r4 = r7.getTableName();	 Catch:{ Exception -> 0x0046 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0046 }
        r4 = "' ";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0046 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0046 }
        r6.debugSql(r3);	 Catch:{ Exception -> 0x0046 }
        r4 = r6.f5202db;	 Catch:{ Exception -> 0x0046 }
        r5 = 0;
        r2 = r4.rawQuery(r3, r5);	 Catch:{ Exception -> 0x0046 }
        if (r2 == 0) goto L_0x0058;
    L_0x002f:
        r3 = r2.moveToNext();	 Catch:{ Exception -> 0x0046 }
        if (r3 == 0) goto L_0x0058;
    L_0x0035:
        r3 = 0;
        r3 = r2.getInt(r3);	 Catch:{ Exception -> 0x0046 }
        if (r3 <= 0) goto L_0x0058;
    L_0x003c:
        r3 = 1;
        r7.setCheckDatabese(r3);	 Catch:{ Exception -> 0x0046 }
        if (r2 == 0) goto L_0x0009;
    L_0x0042:
        r2.close();
        goto L_0x0009;
    L_0x0046:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0051 }
        if (r2 == 0) goto L_0x004f;
    L_0x004c:
        r2.close();
    L_0x004f:
        r0 = r1;
        goto L_0x0009;
    L_0x0051:
        r0 = move-exception;
        if (r2 == 0) goto L_0x0057;
    L_0x0054:
        r2.close();
    L_0x0057:
        throw r0;
    L_0x0058:
        if (r2 == 0) goto L_0x004f;
    L_0x005a:
        r2.close();
        goto L_0x004f;
        */
        throw new UnsupportedOperationException("Method not decompiled: net.tsz.afinal.FinalDb.tableIsExist(net.tsz.afinal.db.table.TableInfo):boolean");
    }

    public void delete(Object obj) {
        checkTableExist(obj.getClass());
        exeSqlInfo(SqlBuilder.buildDeleteSql(obj));
    }

    public void deleteById(Class<?> cls, Object obj) {
        checkTableExist(cls);
        exeSqlInfo(SqlBuilder.buildDeleteSql((Class) cls, obj));
    }

    public void deleteByWhere(Class<?> cls, String str) {
        checkTableExist(cls);
        String buildDeleteSql = SqlBuilder.buildDeleteSql((Class) cls, str);
        debugSql(buildDeleteSql);
        this.f5202db.execSQL(buildDeleteSql);
    }

    public void dropDb() {
        Cursor rawQuery = this.f5202db.rawQuery("SELECT name FROM sqlite_master WHERE type ='table'", null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                try {
                    this.f5202db.execSQL("DROP TABLE " + rawQuery.getString(0));
                } catch (SQLException e) {
                    e.getMessage();
                }
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
    }

    public <T> List<T> findAll(Class<T> cls) {
        checkTableExist(cls);
        return findAllBySql(cls, SqlBuilder.getSelectSQL(cls));
    }

    public <T> List<T> findAll(Class<T> cls, String str) {
        checkTableExist(cls);
        return findAllBySql(cls, SqlBuilder.getSelectSQL(cls) + " ORDER BY " + str);
    }

    public <T> List<T> findAllByWhere(Class<T> cls, String str) {
        checkTableExist(cls);
        return findAllBySql(cls, SqlBuilder.getSelectSQLByWhere(cls, str));
    }

    public <T> List<T> findAllByWhere(Class<T> cls, String str, String str2) {
        checkTableExist(cls);
        return findAllBySql(cls, SqlBuilder.getSelectSQLByWhere(cls, str) + " ORDER BY " + str2);
    }

    public <T> T findById(Object obj, Class<T> cls) {
        checkTableExist(cls);
        SqlInfo selectSqlAsSqlInfo = SqlBuilder.getSelectSqlAsSqlInfo(cls, obj);
        if (selectSqlAsSqlInfo != null) {
            debugSql(selectSqlAsSqlInfo.getSql());
            Cursor rawQuery = this.f5202db.rawQuery(selectSqlAsSqlInfo.getSql(), selectSqlAsSqlInfo.getBindArgsAsStringArray());
            T entity;
            try {
                if (rawQuery.moveToNext()) {
                    entity = CursorUtils.getEntity(rawQuery, cls, this);
                    return entity;
                }
                rawQuery.close();
            } catch (Exception e) {
                entity = e;
                entity.printStackTrace();
            } finally {
                rawQuery.close();
            }
        }
        return null;
    }

    public DbModel findDbModelBySQL(String str) {
        DbModel dbModel = null;
        debugSql(str);
        Cursor rawQuery = this.f5202db.rawQuery(str, null);
        try {
            if (rawQuery.moveToNext()) {
                dbModel = CursorUtils.getDbModel(rawQuery);
            } else {
                rawQuery.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rawQuery.close();
        }
        return dbModel;
    }

    public List<DbModel> findDbModelListBySQL(String str) {
        debugSql(str);
        Cursor rawQuery = this.f5202db.rawQuery(str, null);
        List<DbModel> arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            try {
                arrayList.add(CursorUtils.getDbModel(rawQuery));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                rawQuery.close();
            }
        }
        return arrayList;
    }

    public <T> T findWithManyToOneById(Object obj, Class<T> cls) {
        checkTableExist(cls);
        String selectSQL = SqlBuilder.getSelectSQL(cls, obj);
        debugSql(selectSQL);
        DbModel findDbModelBySQL = findDbModelBySQL(selectSQL);
        return findDbModelBySQL != null ? loadManyToOne(CursorUtils.dbModel2Entity(findDbModelBySQL, cls), cls, new Class[0]) : null;
    }

    public <T> T findWithManyToOneById(Object obj, Class<T> cls, Class<?>... clsArr) {
        checkTableExist(cls);
        String selectSQL = SqlBuilder.getSelectSQL(cls, obj);
        debugSql(selectSQL);
        DbModel findDbModelBySQL = findDbModelBySQL(selectSQL);
        return findDbModelBySQL != null ? loadManyToOne(CursorUtils.dbModel2Entity(findDbModelBySQL, cls), cls, clsArr) : null;
    }

    public <T> T findWithOneToManyById(Object obj, Class<T> cls) {
        checkTableExist(cls);
        String selectSQL = SqlBuilder.getSelectSQL(cls, obj);
        debugSql(selectSQL);
        DbModel findDbModelBySQL = findDbModelBySQL(selectSQL);
        return findDbModelBySQL != null ? loadOneToMany(CursorUtils.dbModel2Entity(findDbModelBySQL, cls), cls, new Class[0]) : null;
    }

    public <T> T findWithOneToManyById(Object obj, Class<T> cls, Class<?>... clsArr) {
        checkTableExist(cls);
        String selectSQL = SqlBuilder.getSelectSQL(cls, obj);
        debugSql(selectSQL);
        DbModel findDbModelBySQL = findDbModelBySQL(selectSQL);
        return findDbModelBySQL != null ? loadOneToMany(CursorUtils.dbModel2Entity(findDbModelBySQL, cls), cls, clsArr) : null;
    }

    public <T> T loadManyToOne(T t, Class<T> cls, Class<?>... clsArr) {
        if (t != null) {
            try {
                for (ManyToOne manyToOne : TableInfo.get((Class) cls).manyToOneMap.values()) {
                    Object value = manyToOne.getValue(t);
                    if (value != null) {
                        Object obj = (clsArr == null || clsArr.length == 0) ? 1 : null;
                        for (Class<?> cls2 : clsArr) {
                            if (manyToOne.getManyClass() == cls2) {
                                int obj2 = 1;
                                break;
                            }
                        }
                        if (obj2 != null) {
                            obj2 = findById(Integer.valueOf(value.toString()), manyToOne.getDataType());
                            if (obj2 != null) {
                                manyToOne.setValue(t, obj2);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return t;
    }

    public <T> T loadOneToMany(T t, Class<T> cls, Class<?>... clsArr) {
        if (t != null) {
            try {
                Collection<OneToMany> values = TableInfo.get((Class) cls).oneToManyMap.values();
                Object value = TableInfo.get((Class) cls).getId().getValue(t);
                for (OneToMany oneToMany : values) {
                    Object obj = (clsArr == null || clsArr.length == 0) ? 1 : null;
                    for (Class<?> cls2 : clsArr) {
                        if (oneToMany.getOneClass() == cls2) {
                            int obj2 = 1;
                            break;
                        }
                    }
                    if (obj2 != null) {
                        List findAllByWhere = findAllByWhere(oneToMany.getOneClass(), oneToMany.getColumn() + "=" + value);
                        if (findAllByWhere != null) {
                            if (oneToMany.getDataType() == OneToManyLazyLoader.class) {
                                ((OneToManyLazyLoader) oneToMany.getValue(t)).setList(findAllByWhere);
                            } else {
                                oneToMany.setValue(t, findAllByWhere);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return t;
    }

    public void save(Object obj) {
        checkTableExist(obj.getClass());
        exeSqlInfo(SqlBuilder.buildInsertSql(obj));
    }

    public boolean saveBindId(Object obj) {
        checkTableExist(obj.getClass());
        List saveKeyValueListByEntity = SqlBuilder.getSaveKeyValueListByEntity(obj);
        if (saveKeyValueListByEntity == null || saveKeyValueListByEntity.size() <= 0) {
            return false;
        }
        TableInfo tableInfo = TableInfo.get(obj.getClass());
        ContentValues contentValues = new ContentValues();
        insertContentValues(saveKeyValueListByEntity, contentValues);
        Long valueOf = Long.valueOf(this.f5202db.insert(tableInfo.getTableName(), null, contentValues));
        if (valueOf.longValue() == -1) {
            return false;
        }
        tableInfo.getId().setValue(obj, valueOf);
        return true;
    }

    public void update(Object obj) {
        checkTableExist(obj.getClass());
        exeSqlInfo(SqlBuilder.getUpdateSqlAsSqlInfo(obj));
    }

    public void update(Object obj, String str) {
        checkTableExist(obj.getClass());
        exeSqlInfo(SqlBuilder.getUpdateSqlAsSqlInfo(obj, str));
    }
}
