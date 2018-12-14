package com.shuame.mobile.sdk.impl.p088a;

import com.shuame.mobile.sdk.impl.utils.C1234j;
import org.keplerproject.luajava.LuaState;

/* renamed from: com.shuame.mobile.sdk.impl.a.ae */
public class C1191ae extends C1185a {
    public C1191ae(LuaState luaState) {
        super(luaState);
    }

    /* renamed from: a */
    public String mo6833a() {
        return "zip_file";
    }

    public int execute() {
        int i = -1;
        try {
            if (C1234j.m3497b(this.f3172L.toString(2), this.f3172L.toString(4), this.f3172L.toString(3))) {
                i = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f3172L.pushInteger(i);
        return 1;
    }
}
