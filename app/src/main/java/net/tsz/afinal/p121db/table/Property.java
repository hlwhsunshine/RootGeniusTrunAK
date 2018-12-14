package net.tsz.afinal.p121db.table;

import android.annotation.SuppressLint;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: net.tsz.afinal.db.table.Property */
public class Property {
    @SuppressLint({"SimpleDateFormat"})
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String column;
    private Class<?> dataType;
    private String defaultValue;
    private Field field;
    private String fieldName;
    private Method get;
    private Method set;

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

    public String getColumn() {
        return this.column;
    }

    public Class<?> getDataType() {
        return this.dataType;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public Field getField() {
        return this.field;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public Method getGet() {
        return this.get;
    }

    public Method getSet() {
        return this.set;
    }

    public <T> T getValue(Object obj) {
        if (!(obj == null || this.get == null)) {
            try {
                return this.get.invoke(obj, new Object[0]);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }

    public void setColumn(String str) {
        this.column = str;
    }

    public void setDataType(Class<?> cls) {
        this.dataType = cls;
    }

    public void setDefaultValue(String str) {
        this.defaultValue = str;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public void setFieldName(String str) {
        this.fieldName = str;
    }

    public void setGet(Method method) {
        this.get = method;
    }

    public void setSet(Method method) {
        this.set = method;
    }

    public void setValue(Object obj, Object obj2) {
        Date date = null;
        if (this.set == null || obj2 == null) {
            try {
                this.field.setAccessible(true);
                this.field.set(obj, obj2);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        try {
            Method method;
            Object[] objArr;
            Method method2;
            Object[] objArr2;
            if (this.dataType == String.class) {
                this.set.invoke(obj, new Object[]{obj2.toString()});
            } else if (this.dataType == Integer.TYPE || this.dataType == Integer.class) {
                int intValue;
                method = this.set;
                objArr = new Object[1];
                if (obj2 == null) {
                    Integer num = null;
                    intValue = num.intValue();
                } else {
                    intValue = Integer.parseInt(obj2.toString());
                }
                objArr[0] = Integer.valueOf(intValue);
                method.invoke(obj, objArr);
            } else if (this.dataType == Float.TYPE || this.dataType == Float.class) {
                float floatValue;
                method = this.set;
                objArr = new Object[1];
                if (obj2 == null) {
                    Float f = null;
                    floatValue = f.floatValue();
                } else {
                    floatValue = Float.parseFloat(obj2.toString());
                }
                objArr[0] = Float.valueOf(floatValue);
                method.invoke(obj, objArr);
            } else if (this.dataType == Double.TYPE || this.dataType == Double.class) {
                double doubleValue;
                method2 = this.set;
                objArr2 = new Object[1];
                if (obj2 == null) {
                    Double d = null;
                    doubleValue = d.doubleValue();
                } else {
                    doubleValue = Double.parseDouble(obj2.toString());
                }
                objArr2[0] = Double.valueOf(doubleValue);
                method2.invoke(obj, objArr2);
            } else if (this.dataType == Long.TYPE || this.dataType == Long.class) {
                long longValue;
                method2 = this.set;
                objArr2 = new Object[1];
                if (obj2 == null) {
                    Long l = null;
                    longValue = l.longValue();
                } else {
                    longValue = Long.parseLong(obj2.toString());
                }
                objArr2[0] = Long.valueOf(longValue);
                method2.invoke(obj, objArr2);
            } else if (this.dataType == Date.class || this.dataType == java.sql.Date.class) {
                method = this.set;
                objArr = new Object[1];
                if (obj2 != null) {
                    date = Property.stringToDateTime(obj2.toString());
                }
                objArr[0] = date;
                method.invoke(obj, objArr);
            } else if (this.dataType == Boolean.TYPE || this.dataType == Boolean.class) {
                boolean booleanValue;
                method = this.set;
                objArr = new Object[1];
                if (obj2 == null) {
                    Boolean bool = null;
                    booleanValue = bool.booleanValue();
                } else {
                    booleanValue = "1".equals(obj2.toString());
                }
                objArr[0] = Boolean.valueOf(booleanValue);
                method.invoke(obj, objArr);
            } else {
                this.set.invoke(obj, new Object[]{obj2});
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
