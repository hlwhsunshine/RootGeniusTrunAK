package com.shuame.mobile.sdk.impl.p088a;

import com.shuame.mobile.sdk.impl.utils.C1234j.C1189a;
import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaObject;

/* renamed from: com.shuame.mobile.sdk.impl.a.ad */
class C1190ad implements C1189a {
    /* renamed from: a */
    final /* synthetic */ C1188ac f3174a;
    /* renamed from: b */
    private final /* synthetic */ LuaObject f3175b;

    C1190ad(C1188ac c1188ac, LuaObject luaObject) {
        this.f3174a = c1188ac;
        this.f3175b = luaObject;
    }

    /* renamed from: a */
    public void mo6836a(int i) {
        try {
            this.f3175b.call(new Object[]{Integer.valueOf(i)}, 0);
        } catch (LuaException e) {
            e.printStackTrace();
        }
    }
}
