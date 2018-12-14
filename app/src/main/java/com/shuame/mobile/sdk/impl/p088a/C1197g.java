package com.shuame.mobile.sdk.impl.p088a;

import org.keplerproject.luajava.LuaState;

/* renamed from: com.shuame.mobile.sdk.impl.a.g */
public class C1197g extends C1185a {
    /* renamed from: a */
    private int f3186a;

    public C1197g(LuaState luaState, int i) {
        super(luaState);
        this.f3186a = i;
    }

    /* renamed from: a */
    public String mo6833a() {
        return "get_client_type";
    }

    public int execute() {
        this.f3172L.pushInteger(this.f3186a);
        return 1;
    }
}
