package com.p070qq.p071e.comm.adevent;

/* renamed from: com.qq.e.comm.adevent.ADEvent */
public class ADEvent {
    /* renamed from: a */
    private final int f2762a;
    /* renamed from: b */
    private final Object[] f2763b;

    public ADEvent(int i) {
        this(i, null);
    }

    public ADEvent(int i, Object[] objArr) {
        this.f2762a = i;
        this.f2763b = objArr;
    }

    public Object[] getParas() {
        return this.f2763b == null ? new Object[0] : this.f2763b;
    }

    public int getType() {
        return this.f2762a;
    }
}
