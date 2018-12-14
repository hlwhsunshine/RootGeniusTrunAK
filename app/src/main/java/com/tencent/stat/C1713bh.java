package com.tencent.stat;

/* renamed from: com.tencent.stat.bh */
class C1713bh implements Runnable {
    /* renamed from: a */
    final /* synthetic */ int f4992a;
    /* renamed from: b */
    final /* synthetic */ C1706ba f4993b;

    C1713bh(C1706ba c1706ba, int i) {
        this.f4993b = c1706ba;
        this.f4992a = i;
    }

    public void run() {
        this.f4993b.m4690b(this.f4992a, true);
        this.f4993b.m4690b(this.f4992a, false);
    }
}
