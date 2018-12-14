package com.nostra13.universalimageloader.core.assist;

public final class FailReason {
    /* renamed from: a */
    private final FailType f2521a;
    /* renamed from: b */
    private final Throwable f2522b;

    public enum FailType {
        IO_ERROR,
        DECODING_ERROR,
        NETWORK_DENIED,
        OUT_OF_MEMORY,
        UNKNOWN
    }

    public FailReason(FailType failType, Throwable th) {
        this.f2521a = failType;
        this.f2522b = th;
    }
}
