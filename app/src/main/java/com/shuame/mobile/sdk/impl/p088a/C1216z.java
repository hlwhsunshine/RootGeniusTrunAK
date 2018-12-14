package com.shuame.mobile.sdk.impl.p088a;

import com.shuame.mobile.sdk.impl.utils.ShellUtils;
import org.keplerproject.luajava.LuaState;

/* renamed from: com.shuame.mobile.sdk.impl.a.z */
public class C1216z extends C1185a {
    public C1216z(LuaState luaState) {
        super(luaState);
    }

    /* renamed from: a */
    public String mo6833a() {
        return "execute_shell_cmd";
    }

    public int execute() {
        try {
            this.f3172L.pushString(ShellUtils.execCmd(this.f3172L.toString(2), this.f3172L.toBoolean(3), (long) this.f3172L.toInteger(4), this.f3172L.toInteger(5)));
        } catch (Exception e) {
            e.printStackTrace();
            this.f3172L.pushString(e.getMessage());
        }
        return 1;
    }
}
