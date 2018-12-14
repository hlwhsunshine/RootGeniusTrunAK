package com.shuame.mobile.sdk.impl.p088a;

import org.keplerproject.luajava.JavaFunction;
import org.keplerproject.luajava.LuaState;

/* renamed from: com.shuame.mobile.sdk.impl.a.a */
public abstract class C1185a extends JavaFunction {
    public C1185a(LuaState luaState) {
        super(luaState);
    }

    /* renamed from: a */
    public abstract String mo6833a();

    /* renamed from: b */
    public void mo6834b() {
        synchronized (this.f3172L) {
            this.f3172L.pushString(mo6833a());
            this.f3172L.pushJavaFunction(this);
            this.f3172L.setTable(-3);
        }
    }

    /* renamed from: c */
    public void mo6835c() {
        register(mo6833a());
    }

    public int execute() {
        return 0;
    }
}
