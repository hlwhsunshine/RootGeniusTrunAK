package com.shuame.mobile.sdk.impl.p088a;

import com.shuame.mobile.sdk.impl.utils.C1226e;
import com.shuame.mobile.sdk.impl.utils.C1228g;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.keplerproject.luajava.LuaState;

/* renamed from: com.shuame.mobile.sdk.impl.a.u */
public class C1211u extends C1185a {
    /* renamed from: a */
    private static final String f3195a = C1211u.class.getSimpleName();
    /* renamed from: c */
    private static Map<String, String> f3196c = new HashMap();
    /* renamed from: b */
    private String f3197b;

    public C1211u(LuaState luaState, String str) {
        super(luaState);
        this.f3197b = str;
    }

    /* renamed from: d */
    public static void m3429d() {
        f3196c.clear();
    }

    /* renamed from: a */
    public String mo6833a() {
        return "shuame_require";
    }

    public int execute() {
        String str = null;
        String stringBuilder = new StringBuilder(String.valueOf(this.f3172L.toString(2))).append(".lua").toString();
        C1228g.m3458a(f3195a, "moduleFileName:" + stringBuilder);
        if (f3196c.containsKey(stringBuilder)) {
            str = (String) f3196c.get(stringBuilder);
        }
        if (str == null && new File(this.f3197b).exists()) {
            str = C1226e.m3454a(this.f3197b, stringBuilder);
            if (str != null) {
                f3196c.put(stringBuilder, str);
            }
        }
        this.f3172L.LdoString(str);
        return 1;
    }
}
