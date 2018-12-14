package com.baidu.mobads.command.p028c;

import android.content.Intent;
import android.os.Parcelable;
import com.baidu.mobads.AppActivity;
import com.baidu.mobads.command.C0269b;
import com.baidu.mobads.command.XAdLandingPageExtraInfo;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
import com.baidu.mobads.p021j.C0329d;
import com.baidu.mobads.p021j.C0338m;

/* renamed from: com.baidu.mobads.command.c.a */
public class C0273a extends C0269b {
    /* renamed from: f */
    private String f491f = null;

    public C0273a(IXNonLinearAdSlot iXNonLinearAdSlot, IXAdInstanceInfo iXAdInstanceInfo, IXAdResource iXAdResource, String str) {
        super(iXNonLinearAdSlot, iXAdInstanceInfo, iXAdResource);
        this.f491f = str;
    }

    /* renamed from: a */
    public void mo4424a() {
        try {
            C0329d m = C0338m.m569a().mo5040m();
            IXAdActivityUtils o = C0338m.m569a().mo5042o();
            Parcelable xAdLandingPageExtraInfo = new XAdLandingPageExtraInfo(this.f459b.getProdInfo().getProdType(), this.f460c);
            xAdLandingPageExtraInfo.mIntTesting4LM = 999;
            xAdLandingPageExtraInfo.mStringTesting4LM = "this is the test string";
            xAdLandingPageExtraInfo.url = this.f491f;
            xAdLandingPageExtraInfo.e75 = 1;
            xAdLandingPageExtraInfo.from = 0;
            xAdLandingPageExtraInfo.adid = this.f460c.getAdId();
            xAdLandingPageExtraInfo.f452qk = this.f460c.getQueryKey();
            xAdLandingPageExtraInfo.packageNameOfPubliser = this.f458a.getPackageName();
            xAdLandingPageExtraInfo.appsid = m.getAppId(this.f458a);
            xAdLandingPageExtraInfo.appsec = m.getAppSec(this.f458a);
            xAdLandingPageExtraInfo.title = this.f460c.getTitle();
            Intent intent = new Intent(this.f458a, AppActivity.class);
            if (this.f459b.getActivity() != null) {
                xAdLandingPageExtraInfo.isFullScreen = o.isFullScreen(this.f459b.getActivity()).booleanValue();
            }
            xAdLandingPageExtraInfo.orientation = this.f458a.getResources().getConfiguration().orientation;
            intent.putExtra(AppActivity.EXTRA_DATA, xAdLandingPageExtraInfo);
            intent.addFlags(268435456);
            if (!AppActivity.isAppActivityOpening()) {
                this.f458a.startActivity(intent);
            }
        } catch (Exception e) {
        }
    }
}
