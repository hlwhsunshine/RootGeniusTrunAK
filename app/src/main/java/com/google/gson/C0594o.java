package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.google.gson.o */
public final class C0594o extends C0591m {
    /* renamed from: a */
    private final LinkedTreeMap<String, C0591m> f1464a = new LinkedTreeMap();

    /* renamed from: a */
    public final void mo5560a(String str, C0591m c0591m) {
        Object c0591m2;
        if (c0591m2 == null) {
            c0591m2 = C0593n.f1463a;
        }
        this.f1464a.put(str, c0591m2);
    }

    public final boolean equals(Object obj) {
        return obj == this || ((obj instanceof C0594o) && ((C0594o) obj).f1464a.equals(this.f1464a));
    }

    /* renamed from: h */
    public final Set<Entry<String, C0591m>> mo5562h() {
        return this.f1464a.entrySet();
    }

    public final int hashCode() {
        return this.f1464a.hashCode();
    }
}
