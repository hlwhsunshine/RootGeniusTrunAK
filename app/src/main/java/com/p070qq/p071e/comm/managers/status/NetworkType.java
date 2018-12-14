package com.p070qq.p071e.comm.managers.status;

/* renamed from: com.qq.e.comm.managers.status.NetworkType */
public enum NetworkType {
    UNKNOWN(0, 1),
    WIFI(1, 2),
    NET_2G(2, 4),
    NET_3G(3, 8),
    NET_4G(4, 16);
    
    /* renamed from: a */
    private int f2824a;
    /* renamed from: b */
    private int f2825b;

    private NetworkType(int i, int i2) {
        this.f2824a = i;
        this.f2825b = i2;
    }

    public final int getConnValue() {
        return this.f2824a;
    }

    public final int getPermValue() {
        return this.f2825b;
    }
}
