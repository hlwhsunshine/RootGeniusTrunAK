package com.tencent.stat;

public class StatAppMonitor implements Cloneable {
    public static final int FAILURE_RESULT_TYPE = 1;
    public static final int LOGIC_FAILURE_RESULT_TYPE = 2;
    public static final int SUCCESS_RESULT_TYPE = 0;
    /* renamed from: a */
    private String f4791a = null;
    /* renamed from: b */
    private long f4792b = 0;
    /* renamed from: c */
    private long f4793c = 0;
    /* renamed from: d */
    private int f4794d = 0;
    /* renamed from: e */
    private long f4795e = 0;
    /* renamed from: f */
    private int f4796f = 0;
    /* renamed from: g */
    private int f4797g = 1;

    public StatAppMonitor(String str) {
        this.f4791a = str;
    }

    public StatAppMonitor(String str, int i, int i2, long j, long j2, long j3, int i3) {
        this.f4791a = str;
        this.f4792b = j;
        this.f4793c = j2;
        this.f4794d = i;
        this.f4795e = j3;
        this.f4796f = i2;
        this.f4797g = i3;
    }

    public StatAppMonitor clone() {
        try {
            return (StatAppMonitor) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String getInterfaceName() {
        return this.f4791a;
    }

    public long getMillisecondsConsume() {
        return this.f4795e;
    }

    public long getReqSize() {
        return this.f4792b;
    }

    public long getRespSize() {
        return this.f4793c;
    }

    public int getResultType() {
        return this.f4794d;
    }

    public int getReturnCode() {
        return this.f4796f;
    }

    public int getSampling() {
        return this.f4797g;
    }

    public void setInterfaceName(String str) {
        this.f4791a = str;
    }

    public void setMillisecondsConsume(long j) {
        this.f4795e = j;
    }

    public void setReqSize(long j) {
        this.f4792b = j;
    }

    public void setRespSize(long j) {
        this.f4793c = j;
    }

    public void setResultType(int i) {
        this.f4794d = i;
    }

    public void setReturnCode(int i) {
        this.f4796f = i;
    }

    public void setSampling(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.f4797g = i;
    }
}
