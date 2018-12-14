package com.baidu.mobads.p040vo.p050a;

import android.content.Context;
import com.baidu.mobads.command.XAdCommandExtraInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.p021j.C0329d;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.p022a.C0238a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.baidu.mobads.vo.a.a */
public abstract class C0433a {
    /* renamed from: a */
    public long f1057a;
    /* renamed from: b */
    public String f1058b;
    /* renamed from: c */
    public String f1059c;
    /* renamed from: d */
    public String f1060d;
    /* renamed from: e */
    public String f1061e;
    /* renamed from: f */
    public String f1062f;
    /* renamed from: g */
    public String f1063g;
    /* renamed from: h */
    public String f1064h;
    /* renamed from: i */
    public String f1065i;
    /* renamed from: j */
    public String f1066j;
    /* renamed from: k */
    protected Context f1067k;
    /* renamed from: l */
    protected C0329d f1068l;
    /* renamed from: m */
    protected IXAdSystemUtils f1069m;

    public C0433a(XAdCommandExtraInfo xAdCommandExtraInfo) {
        this(xAdCommandExtraInfo.getAdInstanceInfo().getAdId(), xAdCommandExtraInfo.getAdInstanceInfo().getQueryKey(), xAdCommandExtraInfo.mProdType);
    }

    public C0433a(String str, String str2, String str3) {
        this.f1058b = "-1";
        this.f1059c = "";
        this.f1060d = "";
        this.f1061e = "";
        this.f1062f = "";
        this.f1063g = "";
        this.f1064h = "";
        this.f1066j = "";
        this.f1068l = C0338m.m569a().mo5040m();
        this.f1069m = C0338m.m569a().mo5041n();
        this.f1067k = C0338m.m569a().mo5031d();
        this.f1057a = System.currentTimeMillis();
        this.f1058b = str;
        this.f1059c = str2;
        this.f1061e = this.f1068l.getAppSec(this.f1067k);
        if (this.f1067k != null) {
            this.f1060d = this.f1067k.getPackageName();
        }
        this.f1062f = this.f1068l.getAppId(this.f1067k);
        this.f1064h = this.f1069m.getEncodedSN(this.f1067k);
        this.f1065i = "android";
        this.f1063g = "android_" + C0238a.f376c + "_4.1.30";
        this.f1066j = str3;
    }

    /* renamed from: a */
    protected String mo5260a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", ")").replaceAll("\\%7E", "~");
        } catch (Exception e) {
            return str;
        }
    }

    /* renamed from: a */
    protected String mo5261a(HashMap<String, String> hashMap) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            C0329d m = C0338m.m569a().mo5040m();
            StringBuilder stringBuilder2 = new StringBuilder();
            for (String str : hashMap.keySet()) {
                String str2;
                String str3 = (String) hashMap.get(str2);
                if (!(str2 == null || str3 == null)) {
                    str2 = mo5260a(str2);
                    str3 = mo5260a(str3);
                    stringBuilder.append(str2 + "=" + str3 + "&");
                    stringBuilder2.append(str3 + ",");
                }
            }
            stringBuilder2.append("mobads,");
            stringBuilder.append("vd=" + m.getMD5(stringBuilder2.toString()) + "&");
            return stringBuilder.toString();
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: a */
    protected HashMap<String, String> mo5262a() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("adid", this.f1058b);
        hashMap.put("appsec", this.f1061e);
        hashMap.put("appsid", this.f1062f);
        hashMap.put("pack", this.f1060d);
        hashMap.put("qk", this.f1059c);
        hashMap.put(IXAdRequestInfo.f649SN, this.f1064h);
        hashMap.put("ts", this.f1057a);
        hashMap.put(IXAdRequestInfo.f650V, this.f1063g);
        hashMap.put(IXAdRequestInfo.f648OS, this.f1065i);
        hashMap.put("prod", this.f1066j);
        hashMap.put(IXAdRequestInfo.P_VER, "8.25");
        return hashMap;
    }

    /* renamed from: b */
    protected abstract HashMap<String, String> mo5263b();

    /* renamed from: c */
    public HashMap<String, String> mo5264c() {
        HashMap<String, String> a = mo5262a();
        Map b = mo5263b();
        if (b != null) {
            a.putAll(b);
        }
        return a;
    }

    public String toString() {
        return mo5261a(mo5264c());
    }
}
