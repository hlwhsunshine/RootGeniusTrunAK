package com.shuame.p076b.p077a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;

/* renamed from: com.shuame.b.a.q */
public final class C1141q {
    /* renamed from: a */
    private String f3017a = VERSION.INCREMENTAL;
    /* renamed from: b */
    private String f3018b = Build.ID;
    /* renamed from: c */
    private String f3019c = Build.DISPLAY;
    /* renamed from: d */
    private String f3020d = VERSION.RELEASE;
    /* renamed from: e */
    private Context f3021e;

    public C1141q(Context context) {
        this.f3021e = context;
    }

    /* renamed from: a */
    public final String mo6732a() {
        return this.f3017a;
    }

    /* renamed from: b */
    public final String mo6733b() {
        return this.f3018b;
    }

    /* renamed from: c */
    public final String mo6734c() {
        return this.f3019c;
    }

    /* renamed from: d */
    public final Context mo6735d() {
        return this.f3021e;
    }

    /* renamed from: e */
    public final String mo6736e() {
        return this.f3020d;
    }
}
