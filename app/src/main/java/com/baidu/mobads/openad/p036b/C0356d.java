package com.baidu.mobads.openad.p036b;

import java.util.HashMap;

/* renamed from: com.baidu.mobads.openad.b.d */
public class C0356d implements C0353a {
    /* renamed from: a */
    public static String f730a = "_uid=b000_5511089179943706094;expires=Dec, 21 Aug 2014 06:40:41 GMT;domain=.youku.com;path=/;";
    /* renamed from: b */
    private HashMap<String, String> f731b = new HashMap();

    /* renamed from: a */
    public String mo5065a(String str) {
        return (String) this.f731b.get(str);
    }

    /* renamed from: a */
    public void mo5066a() {
        mo5069b();
    }

    /* renamed from: a */
    public void mo5067a(String str, String str2) {
        this.f731b.put(str, str2);
    }

    /* renamed from: b */
    public void mo5069b() {
        for (String remove : this.f731b.keySet()) {
            this.f731b.remove(remove);
        }
    }
}
