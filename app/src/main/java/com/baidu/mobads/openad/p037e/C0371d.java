package com.baidu.mobads.openad.p037e;

import android.net.Uri.Builder;
import com.baidu.mobads.p021j.C0338m;

/* renamed from: com.baidu.mobads.openad.e.d */
public class C0371d {
    /* renamed from: a */
    public String f794a;
    /* renamed from: b */
    public String f795b;
    /* renamed from: c */
    public long f796c = 0;
    /* renamed from: d */
    public String f797d = "text/plain";
    /* renamed from: e */
    public int f798e = 1;
    /* renamed from: f */
    private Builder f799f;

    public C0371d(String str, String str2) {
        this.f794a = str;
        this.f795b = str2;
    }

    /* renamed from: a */
    public String mo5121a() {
        return C0338m.m569a().mo5036i().getFixedString(this.f794a);
    }

    /* renamed from: a */
    public void mo5122a(int i) {
        this.f798e = i;
    }

    /* renamed from: a */
    public void mo5123a(Builder builder) {
        this.f799f = builder;
    }

    /* renamed from: b */
    public Builder mo5124b() {
        return this.f799f;
    }
}
