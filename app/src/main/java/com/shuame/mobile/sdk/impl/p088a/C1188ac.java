package com.shuame.mobile.sdk.impl.p088a;

import com.shuame.mobile.sdk.impl.utils.C1234j;
import org.keplerproject.luajava.LuaState;

/* renamed from: com.shuame.mobile.sdk.impl.a.ac */
public class C1188ac extends C1185a {
    public C1188ac(LuaState luaState) {
        super(luaState);
    }

    /* renamed from: a */
    public String mo6833a() {
        return "unzip_file";
    }

    public int execute() {
        int i = -1;
        try {
            if (C1234j.m3495a(this.f3172L.toString(2), this.f3172L.toString(3), new C1190ad(this, this.f3172L.getLuaObject(4)))) {
                i = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f3172L.pushInteger(i);
        return 1;
    }
}
