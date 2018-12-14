package com.shuame.mobile.sdk.impl.p088a;

import com.shuame.mobile.sdk.impl.utils.C1230h;
import org.keplerproject.luajava.LuaState;

/* renamed from: com.shuame.mobile.sdk.impl.a.d */
public class C1194d extends C1185a {
    public C1194d(LuaState luaState) {
        super(luaState);
    }

    /* renamed from: a */
    public String mo6833a() {
        return "get_battery_level";
    }

    public int execute() {
        int i = -1;
        try {
            i = C1230h.m3461b();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f3172L.pushInteger(i);
        return 1;
    }
}
