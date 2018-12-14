package com.shuame.mobile.sdk.impl;

import com.shuame.mobile.sdk.FlashEngine.FlashListener;
import java.util.Map;
import org.keplerproject.luajava.JavaFunction;
import org.keplerproject.luajava.LuaState;

/* renamed from: com.shuame.mobile.sdk.impl.b */
class C1218b extends JavaFunction {
    /* renamed from: a */
    final /* synthetic */ C1217a f3214a;

    C1218b(C1217a c1217a, LuaState luaState) {
        this.f3214a = c1217a;
        super(luaState);
    }

    public int execute() {
        int toInteger = this.f3172L.toInteger(2);
        int toInteger2 = this.f3172L.toInteger(3);
        Map a = this.f3214a.m3437a(toInteger, this.f3172L.getLuaObject(4));
        for (FlashListener flashListener : this.f3214a.f3209g) {
            if (flashListener != null) {
                flashListener.onFlash(toInteger, toInteger2, a);
            }
        }
        return 0;
    }
}
