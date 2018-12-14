package org.keplerproject.luajava;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public final class LuaJavaAPI {
    private LuaJavaAPI() {
    }

    public static int checkField(int i, Object obj, String str) {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            try {
                Field field = (obj instanceof Class ? (Class) obj : obj.getClass()).getField(str);
                if (field == null) {
                    return 0;
                }
                try {
                    Object obj2 = field.get(obj);
                    if (obj == null) {
                        return 0;
                    }
                    existingState.pushObjectValue(obj2);
                    return 1;
                } catch (Exception e) {
                    return 0;
                }
            } catch (Exception e2) {
                return 0;
            }
        }
    }

    public static int checkMethod(int i, Object obj, String str) {
        synchronized (LuaStateFactory.getExistingState(i)) {
            Method[] methods = (obj instanceof Class ? (Class) obj : obj.getClass()).getMethods();
            for (Method name : methods) {
                if (name.getName().equals(str)) {
                    return 1;
                }
            }
            return 0;
        }
    }

    public static int classIndex(int i, Class cls, String str) {
        synchronized (LuaStateFactory.getExistingState(i)) {
            if (checkField(i, cls, str) != 0) {
                return 1;
            } else if (checkMethod(i, cls, str) != 0) {
                return 2;
            } else {
                return 0;
            }
        }
    }

    /* JADX WARNING: Missing block: B:12:0x0031, code:
            r0 = 1;
     */
    private static java.lang.Object compareTypes(org.keplerproject.luajava.LuaState r7, java.lang.Class r8, int r9) {
        /*
        r2 = 0;
        r0 = 0;
        r1 = 1;
        r3 = r7.isBoolean(r9);
        if (r3 == 0) goto L_0x0033;
    L_0x0009:
        r2 = r8.isPrimitive();
        if (r2 == 0) goto L_0x0029;
    L_0x000f:
        r2 = java.lang.Boolean.TYPE;
        if (r8 == r2) goto L_0x0031;
    L_0x0013:
        r1 = new java.lang.Boolean;
        r2 = r7.toBoolean(r9);
        r1.<init>(r2);
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x001f:
        if (r1 != 0) goto L_0x00dd;
    L_0x0021:
        r0 = new org.keplerproject.luajava.LuaException;
        r1 = "Invalid Parameter.";
        r0.<init>(r1);
        throw r0;
    L_0x0029:
        r2 = java.lang.Boolean.class;
        r2 = r8.isAssignableFrom(r2);
        if (r2 == 0) goto L_0x0013;
    L_0x0031:
        r0 = r1;
        goto L_0x0013;
    L_0x0033:
        r3 = r7.type(r9);
        r4 = org.keplerproject.luajava.LuaState.LUA_TSTRING;
        r4 = r4.intValue();
        if (r3 != r4) goto L_0x004f;
    L_0x003f:
        r3 = java.lang.String.class;
        r3 = r8.isAssignableFrom(r3);
        if (r3 != 0) goto L_0x004a;
    L_0x0047:
        r1 = r0;
        r0 = r2;
        goto L_0x001f;
    L_0x004a:
        r0 = r7.toString(r9);
        goto L_0x001f;
    L_0x004f:
        r3 = r7.isFunction(r9);
        if (r3 == 0) goto L_0x0065;
    L_0x0055:
        r3 = org.keplerproject.luajava.LuaObject.class;
        r3 = r8.isAssignableFrom(r3);
        if (r3 != 0) goto L_0x0060;
    L_0x005d:
        r1 = r0;
        r0 = r2;
        goto L_0x001f;
    L_0x0060:
        r0 = r7.getLuaObject(r9);
        goto L_0x001f;
    L_0x0065:
        r3 = r7.isTable(r9);
        if (r3 == 0) goto L_0x007b;
    L_0x006b:
        r3 = org.keplerproject.luajava.LuaObject.class;
        r3 = r8.isAssignableFrom(r3);
        if (r3 != 0) goto L_0x0076;
    L_0x0073:
        r1 = r0;
        r0 = r2;
        goto L_0x001f;
    L_0x0076:
        r0 = r7.getLuaObject(r9);
        goto L_0x001f;
    L_0x007b:
        r3 = r7.type(r9);
        r4 = org.keplerproject.luajava.LuaState.LUA_TNUMBER;
        r4 = r4.intValue();
        if (r3 != r4) goto L_0x0099;
    L_0x0087:
        r2 = new java.lang.Double;
        r4 = r7.toNumber(r9);
        r2.<init>(r4);
        r2 = org.keplerproject.luajava.LuaState.convertLuaNumber(r2, r8);
        if (r2 != 0) goto L_0x00de;
    L_0x0096:
        r1 = r0;
        r0 = r2;
        goto L_0x001f;
    L_0x0099:
        r3 = r7.isUserdata(r9);
        if (r3 == 0) goto L_0x00cc;
    L_0x009f:
        r3 = r7.isObject(r9);
        if (r3 == 0) goto L_0x00ba;
    L_0x00a5:
        r3 = r7.getObjectFromUserdata(r9);
        r4 = r3.getClass();
        r4 = r8.isAssignableFrom(r4);
        if (r4 != 0) goto L_0x00b7;
    L_0x00b3:
        r1 = r0;
        r0 = r2;
        goto L_0x001f;
    L_0x00b7:
        r0 = r3;
        goto L_0x001f;
    L_0x00ba:
        r3 = org.keplerproject.luajava.LuaObject.class;
        r3 = r8.isAssignableFrom(r3);
        if (r3 != 0) goto L_0x00c6;
    L_0x00c2:
        r1 = r0;
        r0 = r2;
        goto L_0x001f;
    L_0x00c6:
        r0 = r7.getLuaObject(r9);
        goto L_0x001f;
    L_0x00cc:
        r0 = r7.isNil(r9);
        if (r0 == 0) goto L_0x00d5;
    L_0x00d2:
        r0 = r2;
        goto L_0x001f;
    L_0x00d5:
        r0 = new org.keplerproject.luajava.LuaException;
        r1 = "Invalid Parameters.";
        r0.<init>(r1);
        throw r0;
    L_0x00dd:
        return r0;
    L_0x00de:
        r0 = r2;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.keplerproject.luajava.LuaJavaAPI.compareTypes(org.keplerproject.luajava.LuaState, java.lang.Class, int):java.lang.Object");
    }

    public static int createProxyObject(int i, String str) {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            try {
                if (existingState.isTable(2)) {
                    existingState.pushJavaObject(existingState.getLuaObject(2).createProxy(str));
                } else {
                    throw new LuaException("Parameter is not a table. Can't create proxy.");
                }
            } catch (Exception e) {
                throw new LuaException(e);
            }
        }
        return 1;
    }

    private static Object getObjInstance(LuaState luaState, Class cls) {
        Object newInstance;
        synchronized (luaState) {
            int top = luaState.getTop();
            Object[] objArr = new Object[(top - 1)];
            Constructor[] constructors = cls.getConstructors();
            Constructor constructor = null;
            for (int i = 0; i < constructors.length; i++) {
                Class[] parameterTypes = constructors[i].getParameterTypes();
                if (parameterTypes.length == top - 1) {
                    Object obj = 1;
                    int i2 = 0;
                    while (i2 < parameterTypes.length) {
                        try {
                            objArr[i2] = compareTypes(luaState, parameterTypes[i2], i2 + 2);
                            i2++;
                        } catch (Exception e) {
                            obj = null;
                        }
                    }
                    if (obj != null) {
                        constructor = constructors[i];
                        break;
                    }
                }
            }
            if (constructor == null) {
                throw new LuaException("Invalid method call. No such method.");
            }
            try {
                newInstance = constructor.newInstance(objArr);
                if (newInstance == null) {
                    throw new LuaException("Couldn't instantiate java Object");
                }
            } catch (Exception e2) {
                throw new LuaException(e2);
            }
        }
        return newInstance;
    }

    public static int javaLoadLib(int i, String str, String str2) {
        synchronized (LuaStateFactory.getExistingState(i)) {
            try {
                Object invoke = Class.forName(str).getMethod(str2, new Class[]{LuaState.class}).invoke(null, new Object[]{r2});
                if (invoke == null || !(invoke instanceof Integer)) {
                    return 0;
                }
                int intValue = ((Integer) invoke).intValue();
                return intValue;
            } catch (Exception e) {
                throw new LuaException("Error on calling method. Library could not be loaded. " + e.getMessage());
            } catch (Exception e2) {
                throw new LuaException(e2);
            }
        }
    }

    public static int javaNew(int i, Class cls) {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            existingState.pushJavaObject(getObjInstance(existingState, cls));
        }
        return 1;
    }

    public static int javaNewInstance(int i, String str) {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            try {
                existingState.pushJavaObject(getObjInstance(existingState, Class.forName(str)));
            } catch (Exception e) {
                throw new LuaException(e);
            }
        }
        return 1;
    }

    public static int objectIndex(int i, Object obj, String str) {
        LuaState existingState = LuaStateFactory.getExistingState(i);
        synchronized (existingState) {
            Object obj2;
            Method method;
            int top = existingState.getTop();
            Object[] objArr = new Object[(top - 1)];
            Method[] methods = (obj instanceof Class ? (Class) obj : obj.getClass()).getMethods();
            for (int i2 = 0; i2 < methods.length; i2++) {
                if (methods[i2].getName().equals(str)) {
                    Class[] parameterTypes = methods[i2].getParameterTypes();
                    if (parameterTypes.length == top - 1) {
                        int i3 = 0;
                        while (i3 < parameterTypes.length) {
                            try {
                                objArr[i3] = compareTypes(existingState, parameterTypes[i3], i3 + 2);
                                i3++;
                            } catch (Exception e) {
                                obj2 = null;
                            }
                        }
                        obj2 = 1;
                        if (obj2 != null) {
                            method = methods[i2];
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            method = null;
            if (method == null) {
                throw new LuaException("Invalid method call. No such method.");
            }
            try {
                if (Modifier.isPublic(method.getModifiers())) {
                    method.setAccessible(true);
                }
                obj2 = obj instanceof Class ? method.invoke(null, objArr) : method.invoke(obj, objArr);
                if (obj2 == null) {
                    return 0;
                }
                existingState.pushObjectValue(obj2);
                return 1;
            } catch (Exception e2) {
                throw new LuaException(e2);
            }
        }
    }
}
