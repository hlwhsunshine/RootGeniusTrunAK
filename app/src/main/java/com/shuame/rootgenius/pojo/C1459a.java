package com.shuame.rootgenius.pojo;

import android.text.TextUtils;
import com.shuame.rootgenius.common.qqdownload.C1361b;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Type;

/* renamed from: com.shuame.rootgenius.pojo.a */
public final class C1459a {
    /* renamed from: a */
    public int f4002a;
    /* renamed from: b */
    public String f4003b;
    /* renamed from: c */
    public int f4004c;
    /* renamed from: d */
    public String f4005d;

    /* renamed from: a */
    public final boolean mo7241a() {
        return (TextUtils.isEmpty(this.f4003b) || TextUtils.isEmpty(this.f4005d)) ? false : true;
    }

    /* renamed from: b */
    public final QQDownloadFile mo7242b() {
        QQDownloadFile qQDownloadFile = new QQDownloadFile();
        qQDownloadFile.f3722c = C1361b.m3815a(this.f4003b);
        qQDownloadFile.f3724e = this.f4003b;
        qQDownloadFile.f3727h = (long) this.f4004c;
        qQDownloadFile.f3726g = this.f4005d;
        qQDownloadFile.f3734o = Type.ROM;
        return qQDownloadFile;
    }
}
