package com.shuame.mobile.sdk.impl.p088a;

import com.shuame.mobile.sdk.FlashEngine;
import org.keplerproject.luajava.LuaState;

/* renamed from: com.shuame.mobile.sdk.impl.a.aa */
public class C1186aa extends C1185a {
    /* renamed from: a */
    private FlashEngine f3173a;

    public C1186aa(LuaState luaState, FlashEngine flashEngine) {
        super(luaState);
        this.f3173a = flashEngine;
    }

    /* renamed from: a */
    public String mo6833a() {
        return "show_dialog";
    }

    public int execute() {
        int i = 2;
        try {
            i = this.f3173a.showDialog(this.f3172L.toString(2), this.f3172L.toInteger(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f3172L.pushInteger(i);
        return 1;
    }
}
