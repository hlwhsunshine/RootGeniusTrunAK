package net.tsz.afinal.p121db.table;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import net.tsz.afinal.exception.DbException;
import net.tsz.afinal.utils.ClassUtils;
import net.tsz.afinal.utils.FieldUtils;

/* renamed from: net.tsz.afinal.db.table.TableInfo */
public class TableInfo {
    private static final HashMap<String, TableInfo> tableInfoMap = new HashMap();
    private boolean checkDatabese;
    private String className;
    /* renamed from: id */
    private C1786Id f5206id;
    public final HashMap<String, ManyToOne> manyToOneMap = new HashMap();
    public final HashMap<String, OneToMany> oneToManyMap = new HashMap();
    public final HashMap<String, Property> propertyMap = new HashMap();
    private String tableName;

    private TableInfo() {
    }

    public static TableInfo get(Class<?> cls) {
        if (cls == null) {
            throw new DbException("table info get error,because the clazz is null");
        }
        TableInfo tableInfo = (TableInfo) tableInfoMap.get(cls.getName());
        if (tableInfo == null) {
            TableInfo tableInfo2 = new TableInfo();
            tableInfo2.setTableName(ClassUtils.getTableName(cls));
            tableInfo2.setClassName(cls.getName());
            Field primaryKeyField = ClassUtils.getPrimaryKeyField(cls);
            if (primaryKeyField != null) {
                C1786Id c1786Id = new C1786Id();
                c1786Id.setColumn(FieldUtils.getColumnByField(primaryKeyField));
                c1786Id.setFieldName(primaryKeyField.getName());
                c1786Id.setSet(FieldUtils.getFieldSetMethod((Class) cls, primaryKeyField));
                c1786Id.setGet(FieldUtils.getFieldGetMethod((Class) cls, primaryKeyField));
                c1786Id.setDataType(primaryKeyField.getType());
                tableInfo2.setId(c1786Id);
                List<Property> propertyList = ClassUtils.getPropertyList(cls);
                if (propertyList != null) {
                    for (Property property : propertyList) {
                        if (property != null) {
                            tableInfo2.propertyMap.put(property.getColumn(), property);
                        }
                    }
                }
                List<ManyToOne> manyToOneList = ClassUtils.getManyToOneList(cls);
                if (manyToOneList != null) {
                    for (ManyToOne manyToOne : manyToOneList) {
                        if (manyToOne != null) {
                            tableInfo2.manyToOneMap.put(manyToOne.getColumn(), manyToOne);
                        }
                    }
                }
                List<OneToMany> oneToManyList = ClassUtils.getOneToManyList(cls);
                if (oneToManyList != null) {
                    for (OneToMany oneToMany : oneToManyList) {
                        if (oneToMany != null) {
                            tableInfo2.oneToManyMap.put(oneToMany.getColumn(), oneToMany);
                        }
                    }
                }
                tableInfoMap.put(cls.getName(), tableInfo2);
                tableInfo = tableInfo2;
            } else {
                throw new DbException("the class[" + cls + "]'s idField is null , \n you can define _id,id property or use annotation @id to solution this exception");
            }
        }
        if (tableInfo != null) {
            return tableInfo;
        }
        throw new DbException("the class[" + cls + "]'s table is null");
    }

    public static TableInfo get(String str) {
        try {
            return TableInfo.get(Class.forName(str));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getClassName() {
        return this.className;
    }

    public C1786Id getId() {
        return this.f5206id;
    }

    public String getTableName() {
        return this.tableName;
    }

    public boolean isCheckDatabese() {
        return this.checkDatabese;
    }

    public void setCheckDatabese(boolean z) {
        this.checkDatabese = z;
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public void setId(C1786Id c1786Id) {
        this.f5206id = c1786Id;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }
}
