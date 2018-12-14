package com.shuame.rootgenius.pojo;

import android.text.TextUtils;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Type;

/* renamed from: com.shuame.rootgenius.pojo.b */
public final class C1460b {
    /* renamed from: a */
    public int f4006a;
    /* renamed from: b */
    public int f4007b;
    /* renamed from: c */
    public String f4008c;
    /* renamed from: d */
    public String f4009d;
    /* renamed from: e */
    public int f4010e;
    /* renamed from: f */
    public String f4011f;
    /* renamed from: g */
    public String f4012g;
    /* renamed from: h */
    public String f4013h;

    /* renamed from: a */
    public final boolean mo7243a() {
        return (TextUtils.isEmpty(this.f4009d) || TextUtils.isEmpty(this.f4011f)) ? false : true;
    }

    /* renamed from: b */
    public final QQDownloadFile mo7244b() {
        QQDownloadFile qQDownloadFile = new QQDownloadFile();
        qQDownloadFile.f3722c = C1361b.m3815a(this.f4009d);
        qQDownloadFile.f3724e = this.f4009d;
        qQDownloadFile.f3727h = 10485760;
        qQDownloadFile.f3726g = this.f4011f;
        qQDownloadFile.f3734o = Type.ROM;
        return qQDownloadFile;
    }
}
