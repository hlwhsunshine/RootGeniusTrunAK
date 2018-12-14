package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.dw */
public class C0763dw extends Exception {
    /* renamed from: gD */
    private int f1861gD;
    /* renamed from: gE */
    private String f1862gE;

    public C0763dw(int i, String str) {
        super(str);
        this.f1861gD = i;
        this.f1862gE = str;
    }

    /* renamed from: bA */
    public String mo5788bA() {
        return this.f1862gE != null ? this.f1862gE : "";
    }

    /* renamed from: bz */
    public int mo5789bz() {
        return this.f1861gD;
    }
}
