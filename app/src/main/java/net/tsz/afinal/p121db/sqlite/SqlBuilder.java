package net.tsz.afinal.p121db.sqlite;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.tsz.afinal.exception.DbException;
import net.tsz.afinal.p121db.table.C1786Id;
import net.tsz.afinal.p121db.table.KeyValue;
import net.tsz.afinal.p121db.table.ManyToOne;
import net.tsz.afinal.p121db.table.Property;
import net.tsz.afinal.p121db.table.TableInfo;

/* renamed from: net.tsz.afinal.db.sqlite.SqlBuilder */
public class SqlBuilder {
    public static String buildDeleteSql(Class<?> cls, String str) {
        StringBuffer stringBuffer = new StringBuffer(SqlBuilder.getDeleteSqlBytableName(TableInfo.get((Class) cls).getTableName()));
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append(" WHERE ");
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public static SqlInfo buildDeleteSql(Class<?> cls, Object obj) {
        TableInfo tableInfo = TableInfo.get((Class) cls);
        C1786Id id = tableInfo.getId();
        if (obj == null) {
            throw new DbException("getDeleteSQL:idValue is null");
        }
        StringBuffer stringBuffer = new StringBuffer(SqlBuilder.getDeleteSqlBytableName(tableInfo.getTableName()));
        stringBuffer.append(" WHERE ").append(id.getColumn()).append("=?");
        SqlInfo sqlInfo = new SqlInfo();
        sqlInfo.setSql(stringBuffer.toString());
        sqlInfo.addValue(obj);
        return sqlInfo;
    }

    public static SqlInfo buildDeleteSql(Object obj) {
        TableInfo tableInfo = TableInfo.get(obj.getClass());
        C1786Id id = tableInfo.getId();
        Object value = id.getValue(obj);
        if (value == null) {
            throw new DbException("getDeleteSQL:" + obj.getClass() + " id value is null");
        }
        StringBuffer stringBuffer = new StringBuffer(SqlBuilder.getDeleteSqlBytableName(tableInfo.getTableName()));
        stringBuffer.append(" WHERE ").append(id.getColumn()).append("=?");
        SqlInfo sqlInfo = new SqlInfo();
        sqlInfo.setSql(stringBuffer.toString());
        sqlInfo.addValue(value);
        return sqlInfo;
    }

    public static SqlInfo buildInsertSql(Object obj) {
        List<KeyValue> saveKeyValueListByEntity = SqlBuilder.getSaveKeyValueListByEntity(obj);
        StringBuffer stringBuffer = new StringBuffer();
        if (saveKeyValueListByEntity == null || saveKeyValueListByEntity.size() <= 0) {
            return null;
        }
        SqlInfo sqlInfo = new SqlInfo();
        stringBuffer.append("INSERT INTO ");
        stringBuffer.append(TableInfo.get(obj.getClass()).getTableName());
        stringBuffer.append(" (");
        for (KeyValue keyValue : saveKeyValueListByEntity) {
            stringBuffer.append(keyValue.getKey()).append(",");
            sqlInfo.addValue(keyValue.getValue());
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(") VALUES ( ");
        int size = saveKeyValueListByEntity.size();
        for (int i = 0; i < size; i++) {
            stringBuffer.append("?,");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(")");
        sqlInfo.setSql(stringBuffer.toString());
        return sqlInfo;
    }

    public static String getCreatTableSQL(Class<?> cls) {
        TableInfo tableInfo = TableInfo.get((Class) cls);
        C1786Id id = tableInfo.getId();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CREATE TABLE IF NOT EXISTS ");
        stringBuffer.append(tableInfo.getTableName());
        stringBuffer.append(" ( ");
        Class dataType = id.getDataType();
        if (dataType == Integer.TYPE || dataType == Integer.class) {
            stringBuffer.append("\"").append(id.getColumn()).append("\"    INTEGER PRIMARY KEY AUTOINCREMENT,");
        } else {
            stringBuffer.append("\"").append(id.getColumn()).append("\"    TEXT PRIMARY KEY,");
        }
        for (Property column : tableInfo.propertyMap.values()) {
            stringBuffer.append("\"").append(column.getColumn());
            stringBuffer.append("\",");
        }
        for (ManyToOne column2 : tableInfo.manyToOneMap.values()) {
            stringBuffer.append("\"").append(column2.getColumn()).append("\",");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(" )");
        return stringBuffer.toString();
    }

    private static String getDeleteSqlBytableName(String str) {
        return "DELETE FROM " + str;
    }

    private static String getPropertyStrSql(String str, Object obj) {
        StringBuffer append = new StringBuffer(str).append("=");
        if ((obj instanceof String) || (obj instanceof Date) || (obj instanceof java.sql.Date)) {
            append.append("'").append(obj).append("'");
        } else {
            append.append(obj);
        }
        return append.toString();
    }

    public static List<KeyValue> getSaveKeyValueListByEntity(Object obj) {
        KeyValue property2KeyValue;
        List<KeyValue> arrayList = new ArrayList();
        TableInfo tableInfo = TableInfo.get(obj.getClass());
        Object value = tableInfo.getId().getValue(obj);
        if (!((value instanceof Integer) || !(value instanceof String) || value == null)) {
            arrayList.add(new KeyValue(tableInfo.getId().getColumn(), value));
        }
        for (Property property2KeyValue2 : tableInfo.propertyMap.values()) {
            property2KeyValue = SqlBuilder.property2KeyValue(property2KeyValue2, obj);
            if (property2KeyValue != null) {
                arrayList.add(property2KeyValue);
            }
        }
        for (ManyToOne manyToOne2KeyValue : tableInfo.manyToOneMap.values()) {
            property2KeyValue = SqlBuilder.manyToOne2KeyValue(manyToOne2KeyValue, obj);
            if (property2KeyValue != null) {
                arrayList.add(property2KeyValue);
            }
        }
        return arrayList;
    }

    public static String getSelectSQL(Class<?> cls) {
        return SqlBuilder.getSelectSqlByTableName(TableInfo.get((Class) cls).getTableName());
    }

    public static String getSelectSQL(Class<?> cls, Object obj) {
        TableInfo tableInfo = TableInfo.get((Class) cls);
        StringBuffer stringBuffer = new StringBuffer(SqlBuilder.getSelectSqlByTableName(tableInfo.getTableName()));
        stringBuffer.append(" WHERE ");
        stringBuffer.append(SqlBuilder.getPropertyStrSql(tableInfo.getId().getColumn(), obj));
        return stringBuffer.toString();
    }

    public static String getSelectSQLByWhere(Class<?> cls, String str) {
        StringBuffer stringBuffer = new StringBuffer(SqlBuilder.getSelectSqlByTableName(TableInfo.get((Class) cls).getTableName()));
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append(" WHERE ").append(str);
        }
        return stringBuffer.toString();
    }

    public static SqlInfo getSelectSqlAsSqlInfo(Class<?> cls, Object obj) {
        TableInfo tableInfo = TableInfo.get((Class) cls);
        StringBuffer stringBuffer = new StringBuffer(SqlBuilder.getSelectSqlByTableName(tableInfo.getTableName()));
        stringBuffer.append(" WHERE ").append(tableInfo.getId().getColumn()).append("=?");
        SqlInfo sqlInfo = new SqlInfo();
        sqlInfo.setSql(stringBuffer.toString());
        sqlInfo.addValue(obj);
        return sqlInfo;
    }

    private static String getSelectSqlByTableName(String str) {
        return new StringBuffer("SELECT * FROM ").append(str).toString();
    }

    public static SqlInfo getUpdateSqlAsSqlInfo(Object obj) {
        TableInfo tableInfo = TableInfo.get(obj.getClass());
        Object value = tableInfo.getId().getValue(obj);
        if (value == null) {
            throw new DbException("this entity[" + obj.getClass() + "]'s id value is null");
        }
        KeyValue property2KeyValue;
        List<KeyValue> arrayList = new ArrayList();
        for (Property property2KeyValue2 : tableInfo.propertyMap.values()) {
            property2KeyValue = SqlBuilder.property2KeyValue(property2KeyValue2, obj);
            if (property2KeyValue != null) {
                arrayList.add(property2KeyValue);
            }
        }
        for (ManyToOne manyToOne2KeyValue : tableInfo.manyToOneMap.values()) {
            property2KeyValue = SqlBuilder.manyToOne2KeyValue(manyToOne2KeyValue, obj);
            if (property2KeyValue != null) {
                arrayList.add(property2KeyValue);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        SqlInfo sqlInfo = new SqlInfo();
        StringBuffer stringBuffer = new StringBuffer("UPDATE ");
        stringBuffer.append(tableInfo.getTableName());
        stringBuffer.append(" SET ");
        for (KeyValue property2KeyValue3 : arrayList) {
            stringBuffer.append(property2KeyValue3.getKey()).append("=?,");
            sqlInfo.addValue(property2KeyValue3.getValue());
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(" WHERE ").append(tableInfo.getId().getColumn()).append("=?");
        sqlInfo.addValue(value);
        sqlInfo.setSql(stringBuffer.toString());
        return sqlInfo;
    }

    public static SqlInfo getUpdateSqlAsSqlInfo(Object obj, String str) {
        KeyValue property2KeyValue;
        TableInfo tableInfo = TableInfo.get(obj.getClass());
        List<KeyValue> arrayList = new ArrayList();
        for (Property property2KeyValue2 : tableInfo.propertyMap.values()) {
            property2KeyValue = SqlBuilder.property2KeyValue(property2KeyValue2, obj);
            if (property2KeyValue != null) {
                arrayList.add(property2KeyValue);
            }
        }
        for (ManyToOne manyToOne2KeyValue : tableInfo.manyToOneMap.values()) {
            property2KeyValue = SqlBuilder.manyToOne2KeyValue(manyToOne2KeyValue, obj);
            if (property2KeyValue != null) {
                arrayList.add(property2KeyValue);
            }
        }
        if (arrayList.size() == 0) {
            throw new DbException("this entity[" + obj.getClass() + "] has no property");
        }
        SqlInfo sqlInfo = new SqlInfo();
        StringBuffer stringBuffer = new StringBuffer("UPDATE ");
        stringBuffer.append(tableInfo.getTableName());
        stringBuffer.append(" SET ");
        for (KeyValue property2KeyValue3 : arrayList) {
            stringBuffer.append(property2KeyValue3.getKey()).append("=?,");
            sqlInfo.addValue(property2KeyValue3.getValue());
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append(" WHERE ").append(str);
        }
        sqlInfo.setSql(stringBuffer.toString());
        return sqlInfo;
    }

    private static KeyValue manyToOne2KeyValue(ManyToOne manyToOne, Object obj) {
        String column = manyToOne.getColumn();
        Object value = manyToOne.getValue(obj);
        if (value == null) {
            return null;
        }
        value = value.getClass() == ManyToOneLazyLoader.class ? TableInfo.get(manyToOne.getManyClass()).getId().getValue(value) : TableInfo.get(value.getClass()).getId().getValue(value);
        return (column == null || value == null) ? null : new KeyValue(column, value);
    }

    private static KeyValue property2KeyValue(Property property, Object obj) {
        String column = property.getColumn();
        Object value = property.getValue(obj);
        return value != null ? new KeyValue(column, value) : (property.getDefaultValue() == null || property.getDefaultValue().trim().length() == 0) ? null : new KeyValue(column, property.getDefaultValue());
    }
}
