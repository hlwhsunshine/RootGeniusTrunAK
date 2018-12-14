package org.keplerproject.luajava;

public abstract class JavaFunction {
    protected static final String TAG = "JavaFunction";
    /* renamed from: L */
    protected LuaState f3172L;

    public JavaFunction(LuaState luaState) {
        this.f3172L = luaState;
    }

    public abstract int execute();

    public LuaObject getParam(int i) {
        return this.f3172L.getLuaObject(i);
    }

    public void register(String str) {
        synchronized (this.f3172L) {
            this.f3172L.pushJavaFunction(this);
            this.f3172L.setGlobal(str);
        }
    }
}
