package com.nostra13.universalimageloader.core.assist;

/* renamed from: com.nostra13.universalimageloader.core.assist.c */
public final class C1013c {
    /* renamed from: a */
    private final int f2526a;
    /* renamed from: b */
    private final int f2527b;

    public C1013c(int i, int i2) {
        this.f2526a = i;
        this.f2527b = i2;
    }

    public C1013c(int i, int i2, int i3) {
        if (i3 % 180 == 0) {
            this.f2526a = i;
            this.f2527b = i2;
            return;
        }
        this.f2526a = i2;
        this.f2527b = i;
    }

    /* renamed from: a */
    public final int mo6177a() {
        return this.f2526a;
    }

    /* renamed from: a */
    public final C1013c mo6178a(float f) {
        return new C1013c((int) (((float) this.f2526a) * f), (int) (((float) this.f2527b) * f));
    }

    /* renamed from: a */
    public final C1013c mo6179a(int i) {
        return new C1013c(this.f2526a / i, this.f2527b / i);
    }

    /* renamed from: b */
    public final int mo6180b() {
        return this.f2527b;
    }

    public final String toString() {
        return this.f2526a + "x" + this.f2527b;
    }
}
