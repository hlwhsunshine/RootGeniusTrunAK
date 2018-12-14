package com.tencent.stat;

public class StatSpecifyReportedInfo {
    /* renamed from: a */
    private String f4894a = null;
    /* renamed from: b */
    private String f4895b = null;
    /* renamed from: c */
    private String f4896c = null;
    /* renamed from: d */
    private boolean f4897d = false;
    /* renamed from: e */
    private boolean f4898e = false;

    public String getAppKey() {
        return this.f4894a;
    }

    public String getInstallChannel() {
        return this.f4895b;
    }

    public String getVersion() {
        return this.f4896c;
    }

    public boolean isImportant() {
        return this.f4898e;
    }

    public boolean isSendImmediately() {
        return this.f4897d;
    }

    public void setAppKey(String str) {
        this.f4894a = str;
    }

    public void setImportant(boolean z) {
        this.f4898e = z;
    }

    public void setInstallChannel(String str) {
        this.f4895b = str;
    }

    public void setSendImmediately(boolean z) {
        this.f4897d = z;
    }

    public void setVersion(String str) {
        this.f4896c = str;
    }

    public String toString() {
        return "StatSpecifyReportedInfo [appKey=" + this.f4894a + ", installChannel=" + this.f4895b + ", version=" + this.f4896c + ", sendImmediately=" + this.f4897d + ", isImportant=" + this.f4898e + "]";
    }
}
