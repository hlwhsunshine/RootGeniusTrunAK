package com.android.volley;

public abstract class Request<T> implements Comparable<Request<T>> {
    /* renamed from: a */
    private final String f145a;
    /* renamed from: b */
    private final int f146b;
    /* renamed from: c */
    private Integer f147c;
    /* renamed from: d */
    private boolean f148d;

    public enum Priority {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public String toString() {
        return new StringBuilder(String.valueOf(this.f148d ? "[X] " : "[ ] ")).append(this.f145a).append(" ").append("0x" + Integer.toHexString(this.f146b)).append(" ").append(Priority.NORMAL).append(" ").append(this.f147c).toString();
    }
}
