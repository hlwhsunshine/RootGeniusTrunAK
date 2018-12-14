package com.shuame.mobile.sdk.impl.p088a;

import com.shuame.mobile.sdk.impl.utils.ShellUtils;
import org.keplerproject.luajava.LuaState;

/* renamed from: com.shuame.mobile.sdk.impl.a.r */
public class C1208r extends C1185a {
    public C1208r(LuaState luaState) {
        super(luaState);
    }

    /* renamed from: a */
    public String mo6833a() {
        return "obtain_root";
    }

    public int execute() {
        int i = -1;
        try {
            i = ShellUtils.obtainRoot() == 1 ? 0 : 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f3172L.pushInteger(i);
        return 1;
    }
}
