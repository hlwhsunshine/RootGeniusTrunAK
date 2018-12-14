package com.shuame.mobile.sdk.impl.p088a;

import org.keplerproject.luajava.LuaState;

/* renamed from: com.shuame.mobile.sdk.impl.a.h */
public class C1198h extends C1185a {
    /* renamed from: a */
    private int f3187a;

    public C1198h(LuaState luaState, int i) {
        super(luaState);
        this.f3187a = i;
    }

    /* renamed from: a */
    public String mo6833a() {
        return "get_sdk_version_int";
    }

    public int execute() {
        this.f3172L.pushInteger(this.f3187a);
        return 1;
    }
}
