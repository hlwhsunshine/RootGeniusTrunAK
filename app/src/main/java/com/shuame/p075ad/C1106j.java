package com.shuame.p075ad;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.shuame.ad.j */
public class C1106j {
    /* renamed from: a */
    public static final String f2960a = C1106j.class.getSimpleName();
    /* renamed from: b */
    private Map<String, String> f2961b;
    /* renamed from: c */
    private boolean f2962c;
    /* renamed from: d */
    private Context f2963d;
    /* renamed from: e */
    private boolean f2964e;

    /* renamed from: com.shuame.ad.j$a */
    private static class C1105a {
        /* renamed from: a */
        private static final C1106j f2959a = new C1106j();
    }

    private C1106j() {
        this.f2961b = new HashMap();
        this.f2962c = false;
        this.f2964e = false;
    }

    /* synthetic */ C1106j(byte b) {
        this();
    }

    /* renamed from: a */
    public static C1106j m3208a() {
        return C1105a.f2959a;
    }

    /* renamed from: e */
    public static C1100f m3209e() {
        return new C1100f();
    }

    /* renamed from: a */
    public final void mo6702a(Context context, Map<String, String> map) {
        this.f2961b.putAll(map);
        this.f2963d = context.getApplicationContext();
        ReportManager.m3144a().mo6671a(this.f2963d, this.f2964e);
        C1114p.m3236a().mo6722a(this.f2963d);
    }

    /* renamed from: a */
    public final void mo6703a(boolean z) {
        this.f2962c = z;
    }

    /* renamed from: b */
    public final void mo6704b() {
        this.f2964e = true;
    }

    /* renamed from: c */
    public final Context mo6705c() {
        return this.f2963d;
    }

    /* renamed from: d */
    final String mo6706d() {
        return (String) this.f2961b.get(f2960a);
    }

    /* renamed from: f */
    public final boolean mo6707f() {
        return this.f2962c;
    }
}
