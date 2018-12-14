package com.nineoldandroids.p055b;

import android.os.Build.VERSION;
import android.view.View;
import com.nineoldandroids.p054a.C0916a.C0915a;
import java.util.WeakHashMap;

/* renamed from: com.nineoldandroids.b.a */
public abstract class C0958a {
    /* renamed from: a */
    private static final WeakHashMap<View, C0958a> f2372a = new WeakHashMap(0);

    /* renamed from: a */
    public static C0958a m2689a(View view) {
        C0958a c0958a = (C0958a) f2372a.get(view);
        if (c0958a == null) {
            int intValue = Integer.valueOf(VERSION.SDK).intValue();
            c0958a = intValue >= 14 ? new C0964d(view) : intValue >= 11 ? new C0962b(view) : new C0969f(view);
            f2372a.put(view, c0958a);
        }
        return c0958a;
    }

    /* renamed from: a */
    public abstract C0958a mo6112a();

    /* renamed from: a */
    public abstract C0958a mo6113a(float f);

    /* renamed from: a */
    public abstract C0958a mo6114a(long j);

    /* renamed from: a */
    public abstract C0958a mo6115a(C0915a c0915a);
}
