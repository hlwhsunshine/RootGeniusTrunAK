package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.fz */
public class C0836fz {
    /* renamed from: cr */
    public final String f2084cr;
    /* renamed from: cs */
    public final String f2085cs;
    /* renamed from: ct */
    public final String f2086ct;
    /* renamed from: cu */
    public final Integer f2087cu;

    public C0836fz(String str, Integer num, String str2, String str3) {
        this.f2084cr = str;
        this.f2087cu = num;
        this.f2085cs = str2;
        this.f2086ct = str3;
    }

    public boolean success() {
        return this.f2087cu != null && this.f2087cu.intValue() == 0;
    }
}
