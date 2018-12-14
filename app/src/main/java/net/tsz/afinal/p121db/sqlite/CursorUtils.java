package net.tsz.afinal.p121db.sqlite;

import android.database.Cursor;
import java.util.HashMap;
import java.util.Map.Entry;
import net.tsz.afinal.FinalDb;
import net.tsz.afinal.p121db.table.ManyToOne;
import net.tsz.afinal.p121db.table.OneToMany;
import net.tsz.afinal.p121db.table.Property;
import net.tsz.afinal.p121db.table.TableInfo;

/* renamed from: net.tsz.afinal.db.sqlite.CursorUtils */
public class CursorUtils {
    public static <T> T dbModel2Entity(DbModel dbModel, Class<?> cls) {
        if (dbModel != null) {
            HashMap dataMap = dbModel.getDataMap();
            try {
                T newInstance = cls.newInstance();
                for (Entry entry : dataMap.entrySet()) {
                    String str = (String) entry.getKey();
                    TableInfo tableInfo = TableInfo.get((Class) cls);
                    Property property = (Property) tableInfo.propertyMap.get(str);
                    if (property != null) {
                        property.setValue(newInstance, entry.getValue() == null ? null : entry.getValue().toString());
                    } else if (tableInfo.getId().getColumn().equals(str)) {
                        tableInfo.getId().setValue(newInstance, entry.getValue() == null ? null : entry.getValue().toString());
                    }
                }
                return newInstance;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static DbModel getDbModel(Cursor cursor) {
        if (cursor == null || cursor.getColumnCount() <= 0) {
            return null;
        }
        DbModel dbModel = new DbModel();
        int columnCount = cursor.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            dbModel.set(cursor.getColumnName(i), cursor.getString(i));
        }
        return dbModel;
    }

    public static <T> T getEntity(Cursor cursor, Class<T> cls, FinalDb finalDb) {
        if (cursor != null) {
            try {
                TableInfo tableInfo = TableInfo.get((Class) cls);
                int columnCount = cursor.getColumnCount();
                if (columnCount > 0) {
                    T newInstance = cls.newInstance();
                    for (int i = 0; i < columnCount; i++) {
                        String columnName = cursor.getColumnName(i);
                        Property property = (Property) tableInfo.propertyMap.get(columnName);
                        if (property != null) {
                            property.setValue(newInstance, cursor.getString(i));
                        } else if (tableInfo.getId().getColumn().equals(columnName)) {
                            tableInfo.getId().setValue(newInstance, cursor.getString(i));
                        }
                    }
                    for (OneToMany oneToMany : tableInfo.oneToManyMap.values()) {
                        if (oneToMany.getDataType() == OneToManyLazyLoader.class) {
                            oneToMany.setValue(newInstance, new OneToManyLazyLoader(newInstance, cls, oneToMany.getOneClass(), finalDb));
                        }
                    }
                    for (ManyToOne manyToOne : tableInfo.manyToOneMap.values()) {
                        if (manyToOne.getDataType() == ManyToOneLazyLoader.class) {
                            manyToOne.setValue(newInstance, new ManyToOneLazyLoader(newInstance, cls, manyToOne.getManyClass(), finalDb));
                        }
                    }
                    return newInstance;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
