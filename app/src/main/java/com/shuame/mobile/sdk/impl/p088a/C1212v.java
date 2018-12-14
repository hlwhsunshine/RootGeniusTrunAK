package com.shuame.mobile.sdk.impl.p088a;

import com.shuame.mobile.sdk.impl.utils.C1219a;
import com.shuame.mobile.sdk.impl.utils.C1228g;
import com.shuame.rootgenius.sdk.RootGenius;
import org.keplerproject.luajava.LuaState;

/* renamed from: com.shuame.mobile.sdk.impl.a.v */
public class C1212v extends C1185a {
    /* renamed from: a */
    private int f3198a;

    public C1212v(LuaState luaState) {
        super(luaState);
    }

    /* renamed from: a */
    public String mo6833a() {
        return "root";
    }

    public int execute() {
        this.f3198a = -1;
        try {
            RootGenius.initialize(C1219a.m3445a());
            int startRoot = RootGenius.startRoot(new C1213w(this));
            if (startRoot == 1) {
                this.f3198a = 0;
            }
            C1228g.m3458a("RootFunction", "mRet:" + this.f3198a + ";result=" + startRoot);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f3172L.pushInteger(this.f3198a);
        return 1;
    }
}
