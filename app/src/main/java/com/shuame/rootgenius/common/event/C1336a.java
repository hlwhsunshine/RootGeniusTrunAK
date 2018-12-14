package com.shuame.rootgenius.common.event;

import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.C1325c;
import com.shuame.rootgenius.common.util.C1387ad;
import com.shuame.rootgenius.sdk.RootGenius;

/* renamed from: com.shuame.rootgenius.common.event.a */
public final class C1336a {
    /* renamed from: a */
    public String f3610a;
    /* renamed from: b */
    public String f3611b;
    /* renamed from: c */
    public String f3612c;
    /* renamed from: d */
    public String f3613d;
    /* renamed from: e */
    public int f3614e = -1;
    /* renamed from: f */
    public int f3615f;
    /* renamed from: g */
    public String f3616g;
    /* renamed from: h */
    private String f3617h;
    /* renamed from: i */
    private String f3618i;
    /* renamed from: j */
    private String f3619j;
    /* renamed from: k */
    private String f3620k;
    /* renamed from: l */
    private String f3621l;
    /* renamed from: m */
    private String f3622m;
    /* renamed from: n */
    private String f3623n;

    /* renamed from: a */
    public final String mo7004a() {
        this.f3617h = RootGenius.GetDeviceInfo().phoneId.rid;
        this.f3618i = C1387ad.m3877e(C1325c.m3724a());
        this.f3619j = C1387ad.m3878f(C1325c.m3724a());
        this.f3620k = C1387ad.m3865a(true);
        this.f3621l = C1387ad.m3874d(C1325c.m3724a());
        this.f3622m = C1387ad.m3872c();
        C1323b.m3688a();
        this.f3623n = C1323b.m3707l();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
        stringBuilder.append("<report>");
        if (this.f3617h != null) {
            stringBuilder.append("<rid>").append(this.f3617h).append("</rid>");
        }
        if (this.f3618i != null) {
            stringBuilder.append("<imei>").append(this.f3618i).append("</imei>");
        }
        if (this.f3619j != null) {
            stringBuilder.append("<imsi>").append(this.f3619j).append("</imsi>");
        }
        if (this.f3620k != null) {
            stringBuilder.append("<qimei>").append(this.f3620k).append("</qimei>");
        }
        if (this.f3621l != null) {
            stringBuilder.append("<mac_address>").append(this.f3621l).append("</mac_address>");
        }
        if (this.f3622m != null) {
            stringBuilder.append("<sn>").append(this.f3622m).append("</sn>");
        }
        if (this.f3623n != null) {
            stringBuilder.append("<product_id>").append(this.f3623n).append("</product_id>");
        }
        if (this.f3610a != null) {
            stringBuilder.append("<project_name>").append(this.f3610a).append("</project_name>");
        }
        if (this.f3611b != null) {
            stringBuilder.append("<action_type>").append(this.f3611b).append("</action_type>");
        }
        if (this.f3612c != null) {
            stringBuilder.append("<success>").append(this.f3612c).append("</success>");
        }
        if (this.f3613d != null) {
            stringBuilder.append("<description>").append(this.f3613d).append("</description>");
        }
        stringBuilder.append("</report>");
        return stringBuilder.toString();
    }

    public final String toString() {
        return "BbxReport [projectName=" + this.f3610a + ", packageName=" + this.f3616g + ", actionType=" + this.f3611b + ", success=" + this.f3612c + ", description=" + this.f3613d + ", appCheckFlag=" + this.f3615f + "]";
    }
}
