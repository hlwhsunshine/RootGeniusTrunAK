package com.shuame.rootgenius.p109f;

import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.shuame.rootgenius.f.a */
public class C1433a implements C1432b {
    /* renamed from: a */
    private static C1433a f3936a;
    /* renamed from: b */
    private HashSet<C1432b> f3937b = new HashSet();

    private C1433a() {
    }

    /* renamed from: a */
    public static C1433a m3964a() {
        if (f3936a == null) {
            synchronized (C1433a.class) {
                if (f3936a == null) {
                    f3936a = new C1433a();
                }
            }
        }
        return f3936a;
    }

    /* renamed from: a */
    public final void mo7151a(C1432b c1432b) {
        this.f3937b.add(c1432b);
    }

    /* renamed from: b */
    public final void mo7152b(C1432b c1432b) {
        this.f3937b.remove(c1432b);
    }

    public void onChange() {
        Iterator it = this.f3937b.iterator();
        while (it.hasNext()) {
            C1432b c1432b = (C1432b) it.next();
            if (c1432b != null) {
                c1432b.onChange();
            }
        }
    }
}
