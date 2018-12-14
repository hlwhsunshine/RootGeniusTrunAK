package com.shuame.mobile.sdk.impl.p088a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.keplerproject.luajava.LuaState;

/* renamed from: com.shuame.mobile.sdk.impl.a.t */
public class C1210t extends C1185a {
    /* renamed from: a */
    private static final List<String> f3194a = new ArrayList();

    public C1210t(LuaState luaState) {
        super(luaState);
    }

    /* renamed from: a */
    public String mo6833a() {
        return "report";
    }

    /* renamed from: d */
    public List<String> mo6840d() {
        return f3194a;
    }

    /* renamed from: e */
    public void mo6841e() {
        f3194a.clear();
    }

    public int execute() {
        CharSequence luaState = this.f3172L.toString(2);
        if (!TextUtils.isEmpty(luaState)) {
            f3194a.add(luaState);
        }
        return 0;
    }
}
