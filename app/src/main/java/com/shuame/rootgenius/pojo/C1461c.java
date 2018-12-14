package com.shuame.rootgenius.pojo;

import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Type;

/* renamed from: com.shuame.rootgenius.pojo.c */
public final class C1461c {
    /* renamed from: a */
    public boolean f4014a;
    /* renamed from: b */
    public String f4015b;
    /* renamed from: c */
    public int f4016c;
    /* renamed from: d */
    public String f4017d;
    /* renamed from: e */
    public int f4018e;
    /* renamed from: f */
    public String f4019f;

    /* renamed from: a */
    public final int mo7245a() {
        return this.f4015b == null ? -1 : C1361b.m3815a(this.f4015b);
    }

    /* renamed from: b */
    public final QQDownloadFile mo7246b() {
        QQDownloadFile qQDownloadFile = new QQDownloadFile();
        qQDownloadFile.f3722c = mo7245a();
        qQDownloadFile.f3724e = this.f4015b;
        qQDownloadFile.f3726g = this.f4017d;
        qQDownloadFile.f3734o = Type.APK;
        qQDownloadFile.f3727h = 10485760;
        qQDownloadFile.f3739t = "com.shuame.mobile";
        qQDownloadFile.f3741v = "shuame_mobile";
        return qQDownloadFile;
    }

    public final String toString() {
        return "ShuameMobileInfo [url=" + this.f4015b + ", size=" + this.f4016c + ", md5=" + this.f4017d + ", versionCode=" + this.f4018e + ", versionName=" + this.f4019f + "]";
    }
}
