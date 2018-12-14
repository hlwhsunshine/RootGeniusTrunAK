package com.baidu.mobads.production.p042d;

import android.content.Context;
import android.view.View;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.feeds.IXAdDummyContainer;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.openad.p037e.C0371d;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.p040vo.C0378d;
import com.baidu.mobads.production.C0375a;
import com.baidu.mobads.production.C0426t;
import com.p070qq.p071e.comm.constants.ErrorCode.AdError;
import com.p070qq.p071e.comm.constants.ErrorCode.OtherError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.baidu.mobads.production.d.a */
public class C0381a extends C0375a {
    /* renamed from: w */
    public static String f859w = "";
    /* renamed from: x */
    private C0387b f860x;
    /* renamed from: y */
    private ArrayList<IXAdInstanceInfo> f861y;

    public C0381a(Context context) {
        super(context);
    }

    public C0381a(Context context, String str) {
        super(context);
        setId(str);
        setActivity(context);
        setAdSlotBase(null);
        this.f825p = SlotType.SLOT_TYPE_FEEDS;
        this.f860x = new C0387b(getApplicationContext(), getActivity(), this.f825p);
        IXAdConstants p = C0338m.m569a().mo5043p();
        this.f860x.mo5176b(p.getSupportedActionType4RequestingNone() + "," + p.getSupportedActionType4RequestingLandingPage() + "," + p.getSupportedActionType4RequestingDownload() + "," + p.getSupportedActionType4RequestingAPO());
        this.f860x.mo5171a((int) OtherError.CONTAINER_INVISIBLE_ERROR);
        this.f860x.mo5175b((int) AdError.PLACEMENT_ERROR);
        this.f860x.mo5183e(0);
        this.f860x.mo5181d(str);
        this.f860x.mo5177c(0);
        this.f860x.mo5180d(1);
        this.f860x.mo5185f(C0338m.m569a().mo5043p().getAdCreativeTypeImage());
    }

    /* renamed from: a */
    private Map<String, Object> m753a(int i, List<String> list) {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put(C0338m.m569a().mo5043p().feedsTrackerParameterKeyProgress(), Integer.valueOf(i));
        hashMap.put(C0338m.m569a().mo5043p().feedsTrackerParameterKeyList(), list);
        return hashMap;
    }

    /* renamed from: a */
    public void mo5186a(Context context, int i, int i2, IXAdInstanceInfo iXAdInstanceInfo) {
    }

    /* renamed from: a */
    public void mo5187a(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            ((IXAdDummyContainer) this.f817h).onClose(context, iXAdInstanceInfo, iXAdFeedsRequestParameters, m753a(i, iXAdInstanceInfo.getCloseTrackers()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo5188a(View view, IXAdInstanceInfo iXAdInstanceInfo, int i, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            ((IXAdDummyContainer) this.f817h).onClick(view, iXAdInstanceInfo, i, iXAdFeedsRequestParameters, m753a(i, iXAdInstanceInfo.getThirdClickTrackingUrls()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo5189a(View view, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            ((IXAdDummyContainer) this.f817h).onImpression(view, iXAdInstanceInfo, iXAdFeedsRequestParameters, m753a(-1, iXAdInstanceInfo.getThirdImpressionTrackingUrls()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo5190a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.f860x.mo5171a(width);
            this.f860x.mo5175b(height);
        }
    }

    /* renamed from: a */
    protected void mo5145a(C0371d c0371d, C0426t c0426t, int i) {
        c0426t.mo5117a(c0371d, (double) i);
    }

    /* renamed from: a */
    public boolean mo5191a(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(iXAdInstanceInfo.getHtmlSnippet());
            stringBuffer.append("_&_");
            stringBuffer.append(iXAdInstanceInfo.getQueryKey());
            stringBuffer.append("_&_");
            stringBuffer.append(iXAdInstanceInfo.getAdId());
            stringBuffer.append("_&_");
            stringBuffer.append(iXAdInstanceInfo.getMainPictureUrl());
            stringBuffer.append("_&_");
            stringBuffer.append(iXAdInstanceInfo.getTitle());
            stringBuffer.append("_&_");
            f859w = stringBuffer.toString();
        } catch (Exception e) {
        }
        try {
            return ((IXAdDummyContainer) this.f817h).isAdAvailable(context, iXAdInstanceInfo, iXAdFeedsRequestParameters);
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: b */
    public void mo5192b(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            ((IXAdDummyContainer) this.f817h).onFullScreen(context, i, iXAdInstanceInfo, iXAdFeedsRequestParameters, m753a(i, iXAdInstanceInfo.getFullScreenTrackers()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo5193b(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            ((IXAdDummyContainer) this.f817h).onStart(context, iXAdInstanceInfo, iXAdFeedsRequestParameters, m753a(0, iXAdInstanceInfo.getStartTrackers()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo5194b(View view, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        mo5188a(view, iXAdInstanceInfo, -1, iXAdFeedsRequestParameters);
    }

    /* renamed from: c */
    public void mo5154c() {
        this.f817h.load();
    }

    /* renamed from: c */
    public void mo5195c(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            ((IXAdDummyContainer) this.f817h).onComplete(context, iXAdInstanceInfo, iXAdFeedsRequestParameters, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    protected void mo5155c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        iXAdContainer.start();
    }

    /* renamed from: d */
    protected void mo5157d() {
        this.f823n = 8000;
    }

    /* renamed from: d */
    public void mo5196d(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            ((IXAdDummyContainer) this.f817h).onCstartcard(context, iXAdInstanceInfo, iXAdFeedsRequestParameters, m753a(0, iXAdInstanceInfo.getCstartcardTrackers()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    protected void mo5158d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        this.f861y = iXAdContainer.getAdContainerContext().getAdResponseInfo().getAdInstanceList();
    }

    /* renamed from: m */
    public ArrayList<IXAdInstanceInfo> mo5197m() {
        return this.f861y;
    }

    /* renamed from: n */
    public C0378d getAdRequestInfo() {
        return this.f860x;
    }

    public void request() {
        super.mo5149a(this.f860x);
    }
}
