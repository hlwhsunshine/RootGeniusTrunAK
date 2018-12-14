package com.baidu.mobads.p040vo.p050a;

import com.baidu.mobads.command.XAdCommandExtraInfo;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.baidu.mobads.vo.a.c */
public class C0435c extends C0433a {
    /* renamed from: A */
    public long f1073A = 0;
    /* renamed from: B */
    public int f1074B = 0;
    /* renamed from: C */
    public int f1075C = 0;
    /* renamed from: D */
    public int f1076D = 0;
    /* renamed from: E */
    public int f1077E = 0;
    /* renamed from: F */
    public int f1078F = 0;
    /* renamed from: G */
    public int f1079G = 0;
    /* renamed from: H */
    public int f1080H = 0;
    /* renamed from: n */
    public String f1081n;
    /* renamed from: o */
    public int f1082o;
    /* renamed from: p */
    public int f1083p;
    /* renamed from: q */
    public int f1084q;
    /* renamed from: r */
    public AtomicInteger f1085r = new AtomicInteger(0);
    /* renamed from: s */
    public int f1086s;
    /* renamed from: t */
    public int f1087t;
    /* renamed from: u */
    public long f1088u;
    /* renamed from: v */
    public int f1089v;
    /* renamed from: w */
    public int f1090w;
    /* renamed from: x */
    public int f1091x;
    /* renamed from: y */
    public int f1092y;
    /* renamed from: z */
    public long f1093z = 0;

    public C0435c(XAdCommandExtraInfo xAdCommandExtraInfo) {
        super(xAdCommandExtraInfo);
    }

    /* renamed from: b */
    protected HashMap<String, String> mo5263b() {
        HashMap<String, String> hashMap = new HashMap();
        if (this.f1081n.length() > 1024) {
            hashMap.put("obj", this.f1081n.substring(0, 1023));
        } else {
            hashMap.put("obj", this.f1081n);
        }
        hashMap.put("order", this.f1082o);
        hashMap.put("height", this.f1083p);
        hashMap.put("progress", this.f1084q);
        hashMap.put("moves", this.f1085r.get());
        hashMap.put("clicks", this.f1086s);
        hashMap.put("urlclicks", this.f1086s);
        hashMap.put("lploadtime", this.f1087t);
        hashMap.put("duration", this.f1088u);
        hashMap.put("_lpWebStartLoad", this.f1093z);
        hashMap.put("_lpWebFinishLoad", this.f1073A);
        hashMap.put("e75", this.f1089v);
        hashMap.put("e75_3", this.f1090w);
        hashMap.put("from", this.f1091x);
        hashMap.put("maxTabs", this.f1092y);
        hashMap.put("b_cancel", this.f1078F);
        hashMap.put("b_refresh", this.f1076D);
        hashMap.put("b_copy", this.f1077E);
        hashMap.put("b_goback", this.f1074B);
        hashMap.put("b_threeP", this.f1075C);
        hashMap.put("b_home", this.f1080H);
        hashMap.put("b_osgoback", this.f1079G);
        return hashMap;
    }
}
