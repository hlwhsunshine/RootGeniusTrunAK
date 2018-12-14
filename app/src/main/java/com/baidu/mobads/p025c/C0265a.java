package com.baidu.mobads.p025c;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.mobads.command.C0271a;
import com.baidu.mobads.command.p026a.C0270a;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.download.activate.IXAppInfo;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.p037e.C0368a;
import com.baidu.mobads.openad.p037e.C0371d;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.p022a.C0238a;
import com.baidu.mobads.p040vo.p050a.C0434b;
import java.util.Map;

/* renamed from: com.baidu.mobads.c.a */
public class C0265a {
    /* renamed from: b */
    public static volatile String f443b = "";
    /* renamed from: c */
    public static volatile String f444c = "";
    /* renamed from: d */
    private static C0265a f445d = new C0265a();
    /* renamed from: f */
    private static boolean f446f = false;
    /* renamed from: a */
    protected final IXAdLogger f447a = C0338m.m569a().mo5033f();
    /* renamed from: e */
    private Context f448e;

    private C0265a() {
        new Handler(Looper.getMainLooper()).postDelayed(new C0266b(this), 2000);
    }

    /* renamed from: a */
    public static C0265a m334a() {
        return f445d;
    }

    /* renamed from: a */
    private String m335a(Context context, String str, Map<String, String> map) {
        try {
            String encodeURIComponent;
            StringBuilder stringBuilder = new StringBuilder("type=" + str + "&");
            StringBuilder stringBuilder2 = new StringBuilder();
            map.put("ts", System.currentTimeMillis());
            IXAdCommonUtils m = C0338m.m569a().mo5040m();
            for (String encodeURIComponent2 : map.keySet()) {
                String str2 = (String) map.get(encodeURIComponent2);
                if (!(encodeURIComponent2 == null || str2 == null)) {
                    encodeURIComponent2 = m.encodeURIComponent(encodeURIComponent2);
                    str2 = m.encodeURIComponent(str2);
                    stringBuilder.append(encodeURIComponent2);
                    stringBuilder.append("=");
                    stringBuilder.append(str2);
                    stringBuilder.append("&");
                    stringBuilder2.append(str2);
                    stringBuilder2.append(",");
                }
            }
            stringBuilder2.append("mobads,");
            encodeURIComponent2 = m.getMD5(stringBuilder2.toString());
            this.f447a.mo4921d("ExtraQuery.allValue:" + stringBuilder2);
            stringBuilder.append("vd=" + encodeURIComponent2 + "&");
            this.f447a.mo4921d("ExtraQuery.params:" + stringBuilder);
            return "http://mobads-logs.baidu.com/dz.zb?" + stringBuilder.toString();
        } catch (Throwable e) {
            this.f447a.mo4924d(e);
            return "";
        }
    }

    /* renamed from: a */
    private void m336a(int i, String str) {
        C0368a c0368a = new C0368a();
        C0371d c0371d = new C0371d(str, "");
        c0371d.f798e = i;
        c0368a.mo5118a(c0371d, Boolean.valueOf(true));
    }

    /* renamed from: a */
    private void m337a(Context context, String str, C0271a c0271a) {
        IXAppInfo a = C0270a.m354a(c0271a);
        if (a != null) {
            m338a(context, str, a);
        }
    }

    /* renamed from: a */
    private void m338a(Context context, String str, IXAppInfo iXAppInfo) {
        C0434b c0434b = new C0434b(context, iXAppInfo);
        c0434b.f1058b = iXAppInfo.getAdId();
        m340b(m335a(context, str, c0434b.mo5264c()));
    }

    /* renamed from: a */
    private void m339a(String str, String str2, Builder builder) {
        IXAdConstants p = C0338m.m569a().mo5043p();
        IXAdCommonUtils m = C0338m.m569a().mo5040m();
        if (builder == null) {
            builder = new Builder();
        }
        try {
            builder.appendQueryParameter("type", str2).appendQueryParameter(IXAdRequestInfo.P_VER, "8.25").appendQueryParameter("appsid", p.getAppSid()).appendQueryParameter(IXAdRequestInfo.f650V, "android_" + C0238a.f376c + "_4.1.30").appendQueryParameter("reason", str).appendQueryParameter(IXAdRequestInfo.OSV, VERSION.RELEASE).appendQueryParameter(IXAdRequestInfo.BDR, VERSION.SDK_INT).appendQueryParameter(IXAdRequestInfo.BRAND, m.getTextEncoder(Build.BRAND)).appendQueryParameter("pack", p.getAppPackageNameOfPublisher());
        } catch (Throwable e) {
            C0338m.m569a().mo5033f().mo4928e(e);
        }
        C0371d c0371d = new C0371d("http://mobads-logs.baidu.com/brwhis.log", "");
        c0371d.mo5123a(builder);
        c0371d.mo5122a(0);
        new C0368a().mo5116a(c0371d);
    }

    /* renamed from: b */
    private void m340b(String str) {
        m336a(1, str);
    }

    /* renamed from: a */
    public void mo4393a(Context context) {
        if (this.f448e == null) {
            this.f448e = context;
        }
    }

    /* renamed from: a */
    public void mo4394a(Context context, C0271a c0271a) {
        m337a(context, "9", c0271a);
    }

    /* renamed from: a */
    public void mo4395a(Context context, IXAppInfo iXAppInfo) {
        m338a(context, "10", iXAppInfo);
    }

    /* renamed from: a */
    public void mo4396a(C0271a c0271a) {
    }

    /* renamed from: a */
    public void mo4397a(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("temp_for_feed_response_html")) {
            m339a(str, "400", null);
        } else if (!f446f) {
            mo4398a("temp_for_feed_response_html", "405", f443b + "___" + f444c);
            f446f = true;
        }
    }

    /* renamed from: a */
    public void mo4398a(String str, String str2, String str3) {
        Builder appendQueryParameter = new Builder().appendQueryParameter("stacktrace", str2);
        appendQueryParameter.appendQueryParameter("ad", str3);
        m339a(str, "404", appendQueryParameter);
    }

    /* renamed from: b */
    public void mo4399b(Context context, C0271a c0271a) {
        m337a(context, "11", c0271a);
    }
}
