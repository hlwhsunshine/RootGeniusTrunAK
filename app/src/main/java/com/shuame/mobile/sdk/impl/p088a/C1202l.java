package com.shuame.mobile.sdk.impl.p088a;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import org.keplerproject.luajava.LuaState;

/* renamed from: com.shuame.mobile.sdk.impl.a.l */
public class C1202l extends C1185a {
    public C1202l(LuaState luaState) {
        super(luaState);
    }

    /* renamed from: a */
    public String mo6833a() {
        return "Log";
    }

    /* renamed from: c */
    public void mo6835c() {
        this.f3172L.newTable();
        this.f3172L.pushValue(-1);
        this.f3172L.setGlobal("Log");
        this.f3172L.pushString(IXAdRequestInfo.f650V);
        this.f3172L.pushJavaFunction(new C1203m(this, this.f3172L));
        this.f3172L.setTable(-3);
        this.f3172L.pushString("i");
        this.f3172L.pushJavaFunction(new C1204n(this, this.f3172L));
        this.f3172L.setTable(-3);
        this.f3172L.pushString("d");
        this.f3172L.pushJavaFunction(new C1205o(this, this.f3172L));
        this.f3172L.setTable(-3);
        this.f3172L.pushString(IXAdRequestInfo.WIDTH);
        this.f3172L.pushJavaFunction(new C1206p(this, this.f3172L));
        this.f3172L.setTable(-3);
        this.f3172L.pushString("e");
        this.f3172L.pushJavaFunction(new C1207q(this, this.f3172L));
        this.f3172L.setTable(-3);
        this.f3172L.pop(1);
    }

    public int execute() {
        return 0;
    }
}
