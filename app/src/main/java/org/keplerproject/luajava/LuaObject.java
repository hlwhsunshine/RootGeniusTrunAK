package org.keplerproject.luajava;

import java.lang.reflect.Proxy;
import java.util.StringTokenizer;

public class LuaObject {
    /* renamed from: L */
    protected LuaState f5844L;
    protected Integer ref;

    protected LuaObject(LuaObject luaObject, Number number) {
        synchronized (luaObject.getLuaState()) {
            this.f5844L = luaObject.getLuaState();
            if (luaObject.isTable() || luaObject.isUserdata()) {
                luaObject.push();
                this.f5844L.pushNumber(number.doubleValue());
                this.f5844L.getTable(-2);
                this.f5844L.remove(-2);
                registerValue(-1);
                this.f5844L.pop(1);
            } else {
                throw new LuaException("Object parent should be a table or userdata .");
            }
        }
    }

    protected LuaObject(LuaObject luaObject, String str) {
        synchronized (luaObject.getLuaState()) {
            this.f5844L = luaObject.getLuaState();
            if (luaObject.isTable() || luaObject.isUserdata()) {
                luaObject.push();
                this.f5844L.pushString(str);
                this.f5844L.getTable(-2);
                this.f5844L.remove(-2);
                registerValue(-1);
                this.f5844L.pop(1);
            } else {
                throw new LuaException("Object parent should be a table or userdata .");
            }
        }
    }

    protected LuaObject(LuaObject luaObject, LuaObject luaObject2) {
        if (luaObject.getLuaState() != luaObject2.getLuaState()) {
            throw new LuaException("LuaStates must be the same!");
        }
        synchronized (luaObject.getLuaState()) {
            if (luaObject.isTable() || luaObject.isUserdata()) {
                this.f5844L = luaObject.getLuaState();
                luaObject.push();
                luaObject2.push();
                this.f5844L.getTable(-2);
                this.f5844L.remove(-2);
                registerValue(-1);
                this.f5844L.pop(1);
            } else {
                throw new LuaException("Object parent should be a table or userdata .");
            }
        }
    }

    protected LuaObject(LuaState luaState, int i) {
        synchronized (luaState) {
            this.f5844L = luaState;
            registerValue(i);
        }
    }

    protected LuaObject(LuaState luaState, String str) {
        synchronized (luaState) {
            this.f5844L = luaState;
            luaState.getGlobal(str);
            registerValue(-1);
            luaState.pop(1);
        }
    }

    private void registerValue(int i) {
        synchronized (this.f5844L) {
            this.f5844L.pushValue(i);
            this.ref = new Integer(this.f5844L.Lref(LuaState.LUA_REGISTRYINDEX.intValue()));
        }
    }

    public Object call(Object[] objArr) {
        return call(objArr, 1)[0];
    }

    public Object[] call(Object[] objArr, int i) {
        Object[] objArr2;
        int i2 = 0;
        synchronized (this.f5844L) {
            if (isFunction() || isTable() || isUserdata()) {
                int length;
                int top = this.f5844L.getTop();
                push();
                if (objArr != null) {
                    length = objArr.length;
                    while (i2 < length) {
                        this.f5844L.pushObjectValue(objArr[i2]);
                        i2++;
                    }
                } else {
                    length = 0;
                }
                i2 = this.f5844L.pcall(length, i, 0);
                if (i2 != 0) {
                    String luaState;
                    if (this.f5844L.isString(-1)) {
                        luaState = this.f5844L.toString(-1);
                        this.f5844L.pop(1);
                    } else {
                        luaState = "";
                    }
                    luaState = i2 == LuaState.LUA_ERRRUN.intValue() ? "Runtime error. " + luaState : i2 == LuaState.LUA_ERRMEM.intValue() ? "Memory allocation error. " + luaState : i2 == LuaState.LUA_ERRERR.intValue() ? "Error while running the error handler function. " + luaState : "Lua Error code " + i2 + ". " + luaState;
                    throw new LuaException(luaState);
                }
                length = i == LuaState.LUA_MULTRET.intValue() ? this.f5844L.getTop() - top : i;
                if (this.f5844L.getTop() - top < length) {
                    throw new LuaException("Invalid Number of Results .");
                }
                objArr2 = new Object[length];
                while (length > 0) {
                    objArr2[length - 1] = this.f5844L.toJavaObject(-1);
                    this.f5844L.pop(1);
                    length--;
                }
            } else {
                throw new LuaException("Invalid object. Not a function, table or userdata .");
            }
        }
        return objArr2;
    }

    public Object createProxy(String str) {
        Object newProxyInstance;
        synchronized (this.f5844L) {
            if (isTable()) {
                StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
                Class[] clsArr = new Class[stringTokenizer.countTokens()];
                int i = 0;
                while (stringTokenizer.hasMoreTokens()) {
                    clsArr[i] = Class.forName(stringTokenizer.nextToken());
                    i++;
                }
                newProxyInstance = Proxy.newProxyInstance(getClass().getClassLoader(), clsArr, new LuaInvocationHandler(this));
            } else {
                throw new LuaException("Invalid Object. Must be Table.");
            }
        }
        return newProxyInstance;
    }

    protected void finalize() {
    }

    public boolean getBoolean() {
        boolean toBoolean;
        synchronized (this.f5844L) {
            push();
            toBoolean = this.f5844L.toBoolean(-1);
            this.f5844L.pop(1);
        }
        return toBoolean;
    }

    public LuaObject getField(String str) {
        return this.f5844L.getLuaObject(this, str);
    }

    public LuaState getLuaState() {
        return this.f5844L;
    }

    public double getNumber() {
        double toNumber;
        synchronized (this.f5844L) {
            push();
            toNumber = this.f5844L.toNumber(-1);
            this.f5844L.pop(1);
        }
        return toNumber;
    }

    public Object getObject() {
        Object objectFromUserdata;
        synchronized (this.f5844L) {
            push();
            objectFromUserdata = this.f5844L.getObjectFromUserdata(-1);
            this.f5844L.pop(1);
        }
        return objectFromUserdata;
    }

    public String getString() {
        String luaState;
        synchronized (this.f5844L) {
            push();
            luaState = this.f5844L.toString(-1);
            this.f5844L.pop(1);
        }
        return luaState;
    }

    public boolean isBoolean() {
        boolean isBoolean;
        synchronized (this.f5844L) {
            push();
            isBoolean = this.f5844L.isBoolean(-1);
            this.f5844L.pop(1);
        }
        return isBoolean;
    }

    public boolean isFunction() {
        boolean isFunction;
        synchronized (this.f5844L) {
            push();
            isFunction = this.f5844L.isFunction(-1);
            this.f5844L.pop(1);
        }
        return isFunction;
    }

    public boolean isJavaFunction() {
        boolean isJavaFunction;
        synchronized (this.f5844L) {
            push();
            isJavaFunction = this.f5844L.isJavaFunction(-1);
            this.f5844L.pop(1);
        }
        return isJavaFunction;
    }

    public boolean isJavaObject() {
        boolean isObject;
        synchronized (this.f5844L) {
            push();
            isObject = this.f5844L.isObject(-1);
            this.f5844L.pop(1);
        }
        return isObject;
    }

    public boolean isNil() {
        boolean isNil;
        synchronized (this.f5844L) {
            push();
            isNil = this.f5844L.isNil(-1);
            this.f5844L.pop(1);
        }
        return isNil;
    }

    public boolean isNumber() {
        boolean isNumber;
        synchronized (this.f5844L) {
            push();
            isNumber = this.f5844L.isNumber(-1);
            this.f5844L.pop(1);
        }
        return isNumber;
    }

    public boolean isString() {
        boolean isString;
        synchronized (this.f5844L) {
            push();
            isString = this.f5844L.isString(-1);
            this.f5844L.pop(1);
        }
        return isString;
    }

    public boolean isTable() {
        boolean isTable;
        synchronized (this.f5844L) {
            push();
            isTable = this.f5844L.isTable(-1);
            this.f5844L.pop(1);
        }
        return isTable;
    }

    public boolean isUserdata() {
        boolean isUserdata;
        synchronized (this.f5844L) {
            push();
            isUserdata = this.f5844L.isUserdata(-1);
            this.f5844L.pop(1);
        }
        return isUserdata;
    }

    public void push() {
        this.f5844L.rawGetI(LuaState.LUA_REGISTRYINDEX.intValue(), this.ref.intValue());
    }

    public String toString() {
        synchronized (this.f5844L) {
            try {
                String valueOf;
                if (isNil()) {
                    return "nil";
                } else if (isBoolean()) {
                    valueOf = String.valueOf(getBoolean());
                    return valueOf;
                } else if (isNumber()) {
                    valueOf = String.valueOf(getNumber());
                    return valueOf;
                } else if (isString()) {
                    valueOf = getString();
                    return valueOf;
                } else if (isFunction()) {
                    return "Lua Function";
                } else if (isJavaObject()) {
                    valueOf = getObject().toString();
                    return valueOf;
                } else if (isUserdata()) {
                    return "Userdata";
                } else if (isTable()) {
                    return "Lua Table";
                } else if (isJavaFunction()) {
                    return "Java Function";
                } else {
                    return null;
                }
            } catch (LuaException e) {
                return null;
            }
        }
    }

    public int type() {
        int type;
        synchronized (this.f5844L) {
            push();
            type = this.f5844L.type(-1);
            this.f5844L.pop(1);
        }
        return type;
    }
}
