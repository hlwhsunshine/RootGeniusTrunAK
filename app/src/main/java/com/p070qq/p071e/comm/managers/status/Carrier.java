package com.p070qq.p071e.comm.managers.status;

/* renamed from: com.qq.e.comm.managers.status.Carrier */
public enum Carrier {
    UNKNOWN(0),
    CMCC(1),
    UNICOM(2),
    TELECOM(3);
    
    /* renamed from: a */
    private int f2806a;

    private Carrier(int i) {
        this.f2806a = i;
    }

    public final int getValue() {
        return this.f2806a;
    }
}
