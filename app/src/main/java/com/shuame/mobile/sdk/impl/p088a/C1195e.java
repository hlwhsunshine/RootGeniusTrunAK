package com.shuame.mobile.sdk.impl.p088a;

import java.util.Map;
import java.util.Map.Entry;
import org.keplerproject.luajava.LuaState;

/* renamed from: com.shuame.mobile.sdk.impl.a.e */
public class C1195e extends C1185a {
    /* renamed from: a */
    private static final String f3184a = C1195e.class.getSimpleName();
    /* renamed from: b */
    private Map<String, Object> f3185b;

    public C1195e(LuaState luaState, Map<String, Object> map) {
        super(luaState);
        this.f3185b = map;
    }

    /* renamed from: a */
    private void m3414a(Map<String, Object> map) {
        this.f3172L.newTable();
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Map) {
                m3414a((Map) value);
                this.f3172L.setField(-2, str);
            } else if (value != null) {
                this.f3172L.pushString(value.toString());
                this.f3172L.setField(-2, str);
            }
        }
    }

    /* renamed from: a */
    public String mo6833a() {
        return "get_configuration";
    }

    public int execute() {
        this.f3172L.newTable();
        if (this.f3185b != null) {
            m3414a(this.f3185b);
        }
        return 1;
    }
}
