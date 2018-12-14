package com.shuame.mobile.sdk.impl.p088a;

import com.shuame.mobile.sdk.impl.utils.C1230h;
import org.keplerproject.luajava.LuaState;

/* renamed from: com.shuame.mobile.sdk.impl.a.f */
public class C1196f extends C1185a {
    public C1196f(LuaState luaState) {
        super(luaState);
    }

    /* renamed from: a */
    public String mo6833a() {
        return "get_network_type";
    }

    public int execute() {
        int i = -1;
        try {
            i = C1230h.m3460a().ordinal();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f3172L.pushInteger(i);
        return 1;
    }
}
