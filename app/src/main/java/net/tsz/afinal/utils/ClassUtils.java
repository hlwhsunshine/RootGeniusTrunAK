package net.tsz.afinal.utils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import net.tsz.afinal.annotation.sqlite.C1783Id;
import net.tsz.afinal.annotation.sqlite.Table;
import net.tsz.afinal.exception.DbException;
import net.tsz.afinal.p121db.sqlite.ManyToOneLazyLoader;
import net.tsz.afinal.p121db.table.ManyToOne;
import net.tsz.afinal.p121db.table.OneToMany;
import net.tsz.afinal.p121db.table.Property;

public class ClassUtils {
    public static List<ManyToOne> getManyToOneList(Class<?> cls) {
        List<ManyToOne> arrayList = new ArrayList();
        try {
            for (Field field : cls.getDeclaredFields()) {
                if (!FieldUtils.isTransient(field) && FieldUtils.isManyToOne(field)) {
                    ManyToOne manyToOne = new ManyToOne();
                    if (field.getType() == ManyToOneLazyLoader.class) {
                        Class cls2 = (Class) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[1];
                        if (cls2 != null) {
                            manyToOne.setManyClass(cls2);
                        }
                    } else {
                        manyToOne.setManyClass(field.getType());
                    }
                    manyToOne.setColumn(FieldUtils.getColumnByField(field));
                    manyToOne.setFieldName(field.getName());
                    manyToOne.setDataType(field.getType());
                    manyToOne.setSet(FieldUtils.getFieldSetMethod((Class) cls, field));
                    manyToOne.setGet(FieldUtils.getFieldGetMethod((Class) cls, field));
                    arrayList.add(manyToOne);
                }
            }
            return arrayList;
        } catch (Throwable e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static List<OneToMany> getOneToManyList(Class<?> cls) {
        List<OneToMany> arrayList = new ArrayList();
        try {
            for (Field field : cls.getDeclaredFields()) {
                if (!FieldUtils.isTransient(field) && FieldUtils.isOneToMany(field)) {
                    OneToMany oneToMany = new OneToMany();
                    oneToMany.setColumn(FieldUtils.getColumnByField(field));
                    oneToMany.setFieldName(field.getName());
                    if (field.getGenericType() instanceof ParameterizedType) {
                        ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
                        Class cls2;
                        if (parameterizedType.getActualTypeArguments().length == 1) {
                            cls2 = (Class) parameterizedType.getActualTypeArguments()[0];
                            if (cls2 != null) {
                                oneToMany.setOneClass(cls2);
                            }
                        } else {
                            cls2 = (Class) parameterizedType.getActualTypeArguments()[1];
                            if (cls2 != null) {
                                oneToMany.setOneClass(cls2);
                            }
                        }
                        oneToMany.setDataType(field.getType());
                        oneToMany.setSet(FieldUtils.getFieldSetMethod((Class) cls, field));
                        oneToMany.setGet(FieldUtils.getFieldGetMethod((Class) cls, field));
                        arrayList.add(oneToMany);
                    } else {
                        throw new DbException("getOneToManyList Exception:" + field.getName() + "'s type is null");
                    }
                }
            }
            return arrayList;
        } catch (Throwable e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static String getPrimaryKeyColumn(Class<?> cls) {
        Field[] declaredFields = cls.getDeclaredFields();
        if (declaredFields != null) {
            C1783Id c1783Id = null;
            for (Field field : declaredFields) {
                c1783Id = (C1783Id) field.getAnnotation(C1783Id.class);
                if (c1783Id != null) {
                    break;
                }
            }
            Field field2 = null;
            if (c1783Id != null) {
                String column = c1783Id.column();
                return (column == null || column.trim().length() == 0) ? field2.getName() : column;
            } else {
                for (Field name : declaredFields) {
                    if ("_id".equals(name.getName())) {
                        return "_id";
                    }
                }
                for (Field name2 : declaredFields) {
                    if ("id".equals(name2.getName())) {
                        return "id";
                    }
                }
                return null;
            }
        }
        throw new RuntimeException("this model[" + cls + "] has no field");
    }

    public static Field getPrimaryKeyField(Class<?> cls) {
        Field[] declaredFields = cls.getDeclaredFields();
        if (declaredFields != null) {
            for (Field field : declaredFields) {
                if (field.getAnnotation(C1783Id.class) != null) {
                    break;
                }
            }
            Field field2 = null;
            if (field2 == null) {
                for (Field field3 : declaredFields) {
                    if ("_id".equals(field3.getName())) {
                        break;
                    }
                }
            }
            Field field32 = field2;
            if (field32 != null) {
                return field32;
            }
            for (Field field4 : declaredFields) {
                if ("id".equals(field4.getName())) {
                    return field4;
                }
            }
            return field32;
        }
        throw new RuntimeException("this model[" + cls + "] has no field");
    }

    public static String getPrimaryKeyFieldName(Class<?> cls) {
        Field primaryKeyField = getPrimaryKeyField(cls);
        return primaryKeyField == null ? null : primaryKeyField.getName();
    }

    public static Object getPrimaryKeyValue(Object obj) {
        return FieldUtils.getFieldValue(obj, getPrimaryKeyField(obj.getClass()));
    }

    public static List<Property> getPropertyList(Class<?> cls) {
        List<Property> arrayList = new ArrayList();
        try {
            Field[] declaredFields = cls.getDeclaredFields();
            String primaryKeyFieldName = getPrimaryKeyFieldName(cls);
            for (Field field : declaredFields) {
                if (!(FieldUtils.isTransient(field) || !FieldUtils.isBaseDateType(field) || field.getName().equals(primaryKeyFieldName))) {
                    Property property = new Property();
                    property.setColumn(FieldUtils.getColumnByField(field));
                    property.setFieldName(field.getName());
                    property.setDataType(field.getType());
                    property.setDefaultValue(FieldUtils.getPropertyDefaultValue(field));
                    property.setSet(FieldUtils.getFieldSetMethod((Class) cls, field));
                    property.setGet(FieldUtils.getFieldGetMethod((Class) cls, field));
                    property.setField(field);
                    arrayList.add(property);
                }
            }
            return arrayList;
        } catch (Throwable e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static String getTableName(Class<?> cls) {
        Table table = (Table) cls.getAnnotation(Table.class);
        return (table == null || table.name().trim().length() == 0) ? cls.getName().replace('.', '_') : table.name();
    }
}
