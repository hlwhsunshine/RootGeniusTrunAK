package net.tsz.afinal.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.tsz.afinal.annotation.sqlite.C1783Id;
import net.tsz.afinal.annotation.sqlite.ManyToOne;
import net.tsz.afinal.annotation.sqlite.OneToMany;
import net.tsz.afinal.annotation.sqlite.Property;
import net.tsz.afinal.annotation.sqlite.Transient;

public class FieldUtils {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Method getBooleanFieldGetMethod(Class<?> cls, String str) {
        String str2 = "is" + str.substring(0, 1).toUpperCase() + str.substring(1);
        if (!isISStart(str)) {
            str = str2;
        }
        try {
            return cls.getDeclaredMethod(str, new Class[0]);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Method getBooleanFieldSetMethod(Class<?> cls, Field field) {
        String name = field.getName();
        String str = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
        if (isISStart(field.getName())) {
            str = "set" + name.substring(2, 3).toUpperCase() + name.substring(3);
        }
        try {
            return cls.getDeclaredMethod(str, new Class[]{field.getType()});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getColumnByField(Field field) {
        Property property = (Property) field.getAnnotation(Property.class);
        if (property != null && property.column().trim().length() != 0) {
            return property.column();
        }
        ManyToOne manyToOne = (ManyToOne) field.getAnnotation(ManyToOne.class);
        if (manyToOne != null && manyToOne.column().trim().length() != 0) {
            return manyToOne.column();
        }
        OneToMany oneToMany = (OneToMany) field.getAnnotation(OneToMany.class);
        if (oneToMany != null && oneToMany.manyColumn() != null && oneToMany.manyColumn().trim().length() != 0) {
            return oneToMany.manyColumn();
        }
        C1783Id c1783Id = (C1783Id) field.getAnnotation(C1783Id.class);
        return (c1783Id == null || c1783Id.column().trim().length() == 0) ? field.getName() : c1783Id.column();
    }

    public static Field getFieldByColumnName(Class<?> cls, String str) {
        if (str == null) {
            return null;
        }
        Field[] declaredFields = cls.getDeclaredFields();
        if (declaredFields == null || declaredFields.length <= 0) {
            return null;
        }
        Field field;
        Field primaryKeyField = str.equals(ClassUtils.getPrimaryKeyColumn(cls)) ? ClassUtils.getPrimaryKeyField(cls) : null;
        if (primaryKeyField == null) {
            for (Field field2 : declaredFields) {
                Property property = (Property) field2.getAnnotation(Property.class);
                if (property != null && str.equals(property.column())) {
                    field = field2;
                    break;
                }
                ManyToOne manyToOne = (ManyToOne) field2.getAnnotation(ManyToOne.class);
                if (manyToOne != null && manyToOne.column().trim().length() != 0) {
                    field = field2;
                    break;
                }
            }
        }
        field = primaryKeyField;
        return field == null ? getFieldByName(cls, str) : field;
    }

    public static Field getFieldByName(Class<?> cls, String str) {
        Field field = null;
        if (str == null) {
            return field;
        }
        try {
            return cls.getDeclaredField(str);
        } catch (SecurityException e) {
            e.printStackTrace();
            return field;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return field;
        }
    }

    public static Method getFieldGetMethod(Class<?> cls, String str) {
        try {
            return cls.getDeclaredMethod("get" + str.substring(0, 1).toUpperCase() + str.substring(1), new Class[0]);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Method getFieldGetMethod(Class<?> cls, Field field) {
        String name = field.getName();
        Method method = null;
        if (field.getType() == Boolean.TYPE) {
            method = getBooleanFieldGetMethod(cls, name);
        }
        return method == null ? getFieldGetMethod((Class) cls, name) : method;
    }

    public static Method getFieldSetMethod(Class<?> cls, String str) {
        try {
            return getFieldSetMethod((Class) cls, cls.getDeclaredField(str));
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public static Method getFieldSetMethod(Class<?> cls, Field field) {
        String name = field.getName();
        try {
            return cls.getDeclaredMethod("set" + name.substring(0, 1).toUpperCase() + name.substring(1), new Class[]{field.getType()});
        } catch (NoSuchMethodException e) {
            return field.getType() == Boolean.TYPE ? getBooleanFieldSetMethod(cls, field) : null;
        }
    }

    public static Object getFieldValue(Object obj, String str) {
        return invoke(obj, getFieldGetMethod(obj.getClass(), str));
    }

    public static Object getFieldValue(Object obj, Field field) {
        return invoke(obj, getFieldGetMethod(obj.getClass(), field));
    }

    public static String getPropertyDefaultValue(Field field) {
        Property property = (Property) field.getAnnotation(Property.class);
        return (property == null || property.defaultValue().trim().length() == 0) ? null : property.defaultValue();
    }

    private static Object invoke(Object obj, Method method) {
        Object obj2 = null;
        if (obj == null || method == null) {
            return obj2;
        }
        try {
            return method.invoke(obj, new Object[0]);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return obj2;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return obj2;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return obj2;
        }
    }

    public static boolean isBaseDateType(Field field) {
        Class type = field.getType();
        return type.equals(String.class) || type.equals(Integer.class) || type.equals(Byte.class) || type.equals(Long.class) || type.equals(Double.class) || type.equals(Float.class) || type.equals(Character.class) || type.equals(Short.class) || type.equals(Boolean.class) || type.equals(Date.class) || type.equals(Date.class) || type.equals(java.sql.Date.class) || type.isPrimitive();
    }

    private static boolean isISStart(String str) {
        return (str == null || str.trim().length() == 0 || !str.startsWith("is") || Character.isLowerCase(str.charAt(2))) ? false : true;
    }

    public static boolean isManyToOne(Field field) {
        return field.getAnnotation(ManyToOne.class) != null;
    }

    public static boolean isManyToOneOrOneToMany(Field field) {
        return isManyToOne(field) || isOneToMany(field);
    }

    public static boolean isOneToMany(Field field) {
        return field.getAnnotation(OneToMany.class) != null;
    }

    public static boolean isTransient(Field field) {
        return field.getAnnotation(Transient.class) != null;
    }

    public static void setFieldValue(Object obj, Field field, Object obj2) {
        Date date = null;
        try {
            Method fieldSetMethod = getFieldSetMethod(obj.getClass(), field);
            if (fieldSetMethod != null) {
                fieldSetMethod.setAccessible(true);
                Class type = field.getType();
                Object[] objArr;
                if (type == String.class) {
                    fieldSetMethod.invoke(obj, new Object[]{obj2.toString()});
                } else if (type == Integer.TYPE || type == Integer.class) {
                    int intValue;
                    objArr = new Object[1];
                    if (obj2 == null) {
                        Integer num = null;
                        intValue = num.intValue();
                    } else {
                        intValue = Integer.parseInt(obj2.toString());
                    }
                    objArr[0] = Integer.valueOf(intValue);
                    fieldSetMethod.invoke(obj, objArr);
                } else if (type == Float.TYPE || type == Float.class) {
                    float floatValue;
                    objArr = new Object[1];
                    if (obj2 == null) {
                        Float f = null;
                        floatValue = f.floatValue();
                    } else {
                        floatValue = Float.parseFloat(obj2.toString());
                    }
                    objArr[0] = Float.valueOf(floatValue);
                    fieldSetMethod.invoke(obj, objArr);
                } else if (type == Long.TYPE || type == Long.class) {
                    long longValue;
                    Object[] objArr2 = new Object[1];
                    if (obj2 == null) {
                        Long l = null;
                        longValue = l.longValue();
                    } else {
                        longValue = Long.parseLong(obj2.toString());
                    }
                    objArr2[0] = Long.valueOf(longValue);
                    fieldSetMethod.invoke(obj, objArr2);
                } else if (type == Date.class) {
                    objArr = new Object[1];
                    if (obj2 != null) {
                        date = stringToDateTime(obj2.toString());
                    }
                    objArr[0] = date;
                    fieldSetMethod.invoke(obj, objArr);
                } else {
                    fieldSetMethod.invoke(obj, new Object[]{obj2});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Date stringToDateTime(String str) {
        if (str != null) {
            try {
                return sdf.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
