package com.shuame.rootgenius.common.event;

import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.C1325c;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.sdk.RootGenius;

/* renamed from: com.shuame.rootgenius.common.event.f */
public final class C1341f {
    /* renamed from: a */
    public String f3648a;
    /* renamed from: b */
    public String f3649b;
    /* renamed from: c */
    public String f3650c;
    /* renamed from: d */
    public String f3651d;
    /* renamed from: e */
    private String f3652e;
    /* renamed from: f */
    private String f3653f;
    /* renamed from: g */
    private String f3654g;
    /* renamed from: h */
    private String f3655h;
    /* renamed from: i */
    private String f3656i;
    /* renamed from: j */
    private String f3657j;
    /* renamed from: k */
    private String f3658k;
    /* renamed from: l */
    private String f3659l;

    /* renamed from: b */
    private void m3744b() {
        C1323b.m3688a();
        this.f3652e = C1323b.m3707l();
        this.f3653f = RootGenius.GetDeviceInfo().phoneInfo.androidVersion;
        this.f3654g = RootGenius.GetDeviceInfo().phoneInfo.buildFingerPrint;
        this.f3655h = RootGenius.GetDeviceInfo().phoneInfo.kernel;
        this.f3656i = RootGenius.GetDeviceInfo().phoneId.rid;
        this.f3657j = C1387ad.m3874d(C1325c.m3724a());
        this.f3658k = C1387ad.m3865a(true);
        this.f3659l = C1387ad.m3877e(C1325c.m3724a());
    }

    /* renamed from: a */
    public final String mo7010a() {
        m3744b();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
        stringBuilder.append("<report>");
        if (this.f3648a != null) {
            stringBuilder.append("<problem_id>").append(this.f3648a).append("</problem_id>");
        }
        if (this.f3649b != null) {
            stringBuilder.append("<selects>").append(this.f3649b).append("</selects>");
        }
        if (this.f3650c != null) {
            stringBuilder.append("<content>").append(this.f3650c).append("</content>");
        }
        if (this.f3651d != null) {
            stringBuilder.append("<contact>").append(this.f3651d).append("</contact>");
        }
        if (this.f3652e != null) {
            stringBuilder.append("<product_id>").append(this.f3652e).append("</product_id>");
        }
        if (this.f3653f != null) {
            stringBuilder.append("<android_version>").append(this.f3653f).append("</android_version>");
        }
        if (this.f3654g != null) {
            stringBuilder.append("<ro_build_fingerprint>").append(this.f3654g).append("</ro_build_fingerprint>");
        }
        if (this.f3655h != null) {
            stringBuilder.append("<kernel_version>").append(this.f3655h).append("</kernel_version>");
        }
        if (this.f3656i != null) {
            stringBuilder.append("<rid>").append(this.f3656i).append("</rid>");
        }
        if (this.f3657j != null) {
            stringBuilder.append("<mac_address>").append(this.f3657j).append("</mac_address>");
        }
        if (this.f3658k != null) {
            stringBuilder.append("<qimei>").append(this.f3658k).append("</qimei>");
        }
        if (this.f3659l != null) {
            stringBuilder.append("<imei>").append(this.f3659l).append("</imei>");
        }
        stringBuilder.append("</report>");
        return stringBuilder.toString();
    }

    public final String toString() {
        m3744b();
        return "FeedBackReport:[problem_id:" + this.f3648a + "\\selects:" + this.f3649b + "\\content:" + this.f3650c + "\\contact:" + this.f3651d + "\\product_id:" + this.f3652e + "\\android_version:" + this.f3653f + "\\ro_build_fingerprint:" + this.f3654g + "\\kernel_version:" + this.f3655h + "\\rid:" + this.f3656i + "\\mac_address:" + this.f3657j + "\\qimei:" + this.f3658k + "\\imei:" + this.f3659l + "]";
    }
}
