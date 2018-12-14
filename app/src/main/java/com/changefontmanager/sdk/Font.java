package com.changefontmanager.sdk;

import java.io.Serializable;

public class Font implements Serializable {
    private static final long serialVersionUID = 1;
    /* renamed from: h */
    private String f1127h;
    /* renamed from: i */
    private long f1128i;
    /* renamed from: j */
    private String f1129j = "";
    /* renamed from: k */
    private String f1130k = "";

    public String getEnLocalPath() {
        return this.f1130k;
    }

    public String getFontName() {
        return this.f1127h;
    }

    public long getFontSize() {
        return this.f1128i;
    }

    public String getZhLocalPath() {
        return this.f1129j;
    }

    public void setEnLocalPath(String str) {
        this.f1130k = str;
    }

    public void setFontName(String str) {
        this.f1127h = str;
    }

    public void setFontSize(long j) {
        this.f1128i = j;
    }

    public void setZhLocalPath(String str) {
        this.f1129j = str;
    }
}
