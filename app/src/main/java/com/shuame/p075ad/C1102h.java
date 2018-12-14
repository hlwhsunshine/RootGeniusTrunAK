package com.shuame.p075ad;

import android.app.Activity;
import android.content.Context;
import android.content.p013pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.shuame.p075ad.ChannelConfig.PositionConfig;

/* renamed from: com.shuame.ad.h */
public class C1102h {
    /* renamed from: e */
    private static final String f2934e = C1102h.class.getSimpleName();
    /* renamed from: a */
    private Activity f2935a;
    /* renamed from: b */
    private PositionConfig f2936b;
    /* renamed from: c */
    private C1096w f2937c;
    /* renamed from: d */
    private FragmentBuildContext f2938d;

    public C1102h(Activity activity, PositionConfig positionConfig, C1096w c1096w, FragmentBuildContext fragmentBuildContext) {
        this.f2935a = activity;
        this.f2936b = positionConfig;
        this.f2937c = c1096w;
        this.f2938d = fragmentBuildContext;
    }

    /* renamed from: a */
    private static Bundle m3202a(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    /* renamed from: a */
    public final C1107n mo6699a(Context context, String str) {
        C1107n c1108k;
        if ("mssp".equals(str)) {
            Bundle a = C1102h.m3202a(context);
            if (a == null || !a.containsKey(IXAdCommonUtils.APPSID)) {
                return null;
            }
            c1108k = new C1108k();
            c1108k.mo6710a(this.f2935a, this.f2936b.getSourceDetail(str), this.f2937c, this.f2938d);
            return c1108k;
        } else if ("guangdiantong".equals(str)) {
            if (TextUtils.isEmpty(C1106j.m3208a().mo6706d())) {
                return null;
            }
            c1108k = new C1117s();
            c1108k.mo6710a(this.f2935a, this.f2936b.getSourceDetail(str), this.f2937c, this.f2938d);
            return c1108k;
        } else if (!"shuame".equals(str)) {
            return null;
        } else {
            c1108k = new C1121x();
            c1108k.mo6710a(this.f2935a, this.f2936b.getSourceDetail(str), this.f2937c, this.f2938d);
            return c1108k;
        }
    }
}
