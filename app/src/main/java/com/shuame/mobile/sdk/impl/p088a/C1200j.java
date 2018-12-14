package com.shuame.mobile.sdk.impl.p088a;

import org.keplerproject.luajava.LuaState;

/* renamed from: com.shuame.mobile.sdk.impl.a.j */
public class C1200j extends C1185a {
    /* renamed from: a */
    public static boolean f3188a;

    public C1200j(LuaState luaState) {
        super(luaState);
    }

    /* renamed from: a */
    public String mo6833a() {
        return "iscanceled";
    }

    public int execute() {
        int i = -1;
        try {
            i = f3188a ? 0 : 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f3172L.pushInteger(i);
        return 1;
    }
}
