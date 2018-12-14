package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.et */
public abstract class C0793et implements C0792fa {
    /* renamed from: iA */
    private boolean f2008iA = false;
    /* renamed from: iB */
    private boolean f2009iB = false;

    /* renamed from: a */
    public abstract boolean mo5804a(C0716ga c0716ga);

    /* renamed from: b */
    public abstract boolean mo5805b(C0716ga c0716ga);

    /* renamed from: bC */
    public synchronized boolean mo5801bC() {
        return this.f2009iB;
    }

    /* renamed from: c */
    public synchronized boolean mo5802c(C0716ga c0716ga) {
        boolean z = false;
        synchronized (this) {
            this.f2009iB = !mo5804a(c0716ga);
            this.f2008iA = true;
            if (!this.f2009iB) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: d */
    public synchronized boolean mo5803d(C0716ga c0716ga) {
        if (!this.f2008iA) {
            mo5802c(c0716ga);
        }
        return !this.f2009iB ? true : mo5805b(c0716ga);
    }
}
