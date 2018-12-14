package com.tencent.mid.p117b;

import com.tencent.mid.util.Util;
import org.json.JSONObject;

/* renamed from: com.tencent.mid.b.a */
public class C1643a {
    /* renamed from: a */
    public static String f4686a = "ts";
    /* renamed from: b */
    public static String f4687b = "times";
    /* renamed from: c */
    public static String f4688c = "mfreq";
    /* renamed from: d */
    public static String f4689d = "mdays";
    /* renamed from: e */
    private long f4690e = 0;
    /* renamed from: f */
    private int f4691f = 1;
    /* renamed from: g */
    private int f4692g = 1024;
    /* renamed from: h */
    private int f4693h = 3;

    public C1643a(String str) {
        if (Util.isStringValid(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull(f4686a)) {
                    this.f4690e = jSONObject.getLong(f4686a);
                }
                if (!jSONObject.isNull(f4688c)) {
                    this.f4692g = jSONObject.getInt(f4688c);
                }
                if (!jSONObject.isNull(f4687b)) {
                    this.f4691f = jSONObject.getInt(f4687b);
                }
                if (!jSONObject.isNull(f4689d)) {
                    this.f4693h = jSONObject.getInt(f4689d);
                }
            } catch (Throwable e) {
                Util.logWarn(e);
            }
        }
    }

    /* renamed from: a */
    public int mo7636a() {
        return this.f4693h;
    }

    /* renamed from: a */
    public void mo7637a(int i) {
        this.f4693h = i;
    }

    /* renamed from: a */
    public void mo7638a(long j) {
        this.f4690e = j;
    }

    /* renamed from: b */
    public long mo7639b() {
        return this.f4690e;
    }

    /* renamed from: b */
    public void mo7640b(int i) {
        this.f4691f = i;
    }

    /* renamed from: c */
    public int mo7641c() {
        return this.f4691f;
    }

    /* renamed from: c */
    public void mo7642c(int i) {
        this.f4692g = i;
    }

    /* renamed from: d */
    public int mo7643d() {
        return this.f4692g;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f4686a, this.f4690e);
            jSONObject.put(f4687b, this.f4691f);
            jSONObject.put(f4688c, this.f4692g);
            jSONObject.put(f4689d, this.f4693h);
        } catch (Throwable e) {
            Util.logWarn(e);
        }
        return jSONObject.toString();
    }
}
