package com.p070qq.p071e.comm.net.p072rr;

import android.net.Uri;
import android.net.Uri.Builder;
import com.p070qq.p071e.comm.net.p072rr.Request.Method;
import com.p070qq.p071e.comm.util.StringUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.qq.e.comm.net.rr.AbstractRequest */
public abstract class AbstractRequest implements Request {
    /* renamed from: a */
    private boolean f2837a = true;
    /* renamed from: b */
    private int f2838b;
    /* renamed from: c */
    private int f2839c;
    /* renamed from: d */
    private int f2840d;
    /* renamed from: e */
    private String f2841e;
    /* renamed from: f */
    private Map<String, String> f2842f = new HashMap();
    /* renamed from: g */
    private Map<String, String> f2843g = new HashMap();
    /* renamed from: h */
    private Map<String, String> f2844h = Collections.unmodifiableMap(this.f2842f);
    /* renamed from: i */
    private Map<String, String> f2845i = Collections.unmodifiableMap(this.f2843g);
    /* renamed from: j */
    private Method f2846j;
    /* renamed from: k */
    private byte[] f2847k;

    public AbstractRequest(String str, Method method, byte[] bArr) {
        this.f2841e = str;
        this.f2846j = method;
        if (bArr == null) {
            this.f2847k = null;
        } else {
            this.f2847k = (byte[]) bArr.clone();
        }
    }

    public void addHeader(String str, String str2) {
        if (!StringUtil.isEmpty(str) && !StringUtil.isEmpty(str2)) {
            this.f2842f.put(str, str2);
        }
    }

    public void addQuery(String str, String str2) {
        this.f2843g.put(str, str2);
    }

    public int getConnectionTimeOut() {
        return this.f2839c;
    }

    public Map<String, String> getHeaders() {
        return this.f2844h;
    }

    public Method getMethod() {
        return this.f2846j;
    }

    public byte[] getPostData() {
        return this.f2847k;
    }

    public int getPriority() {
        return this.f2838b;
    }

    public Map<String, String> getQuerys() {
        return this.f2845i;
    }

    public int getSocketTimeOut() {
        return this.f2840d;
    }

    public String getUrl() {
        return this.f2841e;
    }

    public String getUrlWithParas() {
        if (getQuerys().isEmpty()) {
            return getUrl();
        }
        Builder buildUpon = Uri.parse(getUrl()).buildUpon();
        for (Entry entry : getQuerys().entrySet()) {
            buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        return buildUpon.build().toString();
    }

    public boolean isAutoClose() {
        return this.f2837a;
    }

    public void setAutoClose(boolean z) {
        this.f2837a = z;
    }

    public void setConnectionTimeOut(int i) {
        this.f2839c = i;
    }

    public void setPriority(int i) {
        this.f2838b = i;
    }

    public void setSocketTimeOut(int i) {
        this.f2840d = i;
    }
}
