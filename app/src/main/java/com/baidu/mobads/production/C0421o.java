package com.baidu.mobads.production;

import android.content.Context;
import android.content.Intent;
import android.content.p013pm.PackageManager;
import android.content.p013pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.command.p026a.C0270a;
import com.baidu.mobads.command.p027b.C0272a;
import com.baidu.mobads.command.p028c.C0273a;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdContainerContext;
import com.baidu.mobads.interfaces.IXAdContainerEventListener;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import com.baidu.mobads.openad.p037e.C0368a;
import com.baidu.mobads.openad.p037e.C0371d;
import com.baidu.mobads.p021j.C0329d;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.p025c.C0265a;
import com.baidu.mobads.p032f.C0280a;
import com.baidu.mobads.p040vo.XAdInstanceInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.production.o */
public class C0421o implements IXAdContainerEventListener {
    /* renamed from: a */
    private Context f951a;
    /* renamed from: b */
    private final C0375a f952b;
    /* renamed from: c */
    private AtomicBoolean f953c;
    /* renamed from: d */
    private AtomicBoolean f954d;
    /* renamed from: e */
    private AtomicBoolean f955e;
    /* renamed from: f */
    private AtomicBoolean f956f;
    /* renamed from: g */
    private int f957g = 0;
    /* renamed from: h */
    private int f958h = 2;
    /* renamed from: i */
    private int f959i = 15;
    /* renamed from: j */
    private int f960j = 0;
    /* renamed from: k */
    private int f961k = 2;
    /* renamed from: l */
    private int f962l = 15;

    public C0421o(Context context, C0375a c0375a) {
        this.f951a = context;
        this.f952b = c0375a;
        this.f953c = new AtomicBoolean(false);
        this.f954d = new AtomicBoolean(false);
        this.f955e = new AtomicBoolean(false);
        this.f956f = new AtomicBoolean(false);
    }

    /* renamed from: a */
    private void m886a(Context context, String str) {
        try {
            this.f960j = 0;
            Timer timer = new Timer();
            timer.schedule(new C0423q(this, C0338m.m569a().mo5039l(), context, str, timer), 0, 1000);
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private void m887a(Context context, String str, String str2) {
        try {
            this.f957g = 0;
            Timer timer = new Timer();
            timer.schedule(new C0422p(this, C0338m.m569a().mo5039l(), context, str2, timer, str), 0, 1000);
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private void m888a(Set<String> set) {
        C0368a c0368a = new C0368a();
        for (String c0371d : set) {
            C0371d c0371d2 = new C0371d(c0371d, "");
            c0371d2.f798e = 1;
            c0368a.mo5118a(c0371d2, Boolean.valueOf(true));
        }
    }

    public void onAdClicked(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        int i;
        Boolean bool2;
        C0329d m = C0338m.m569a().mo5040m();
        IXAdConstants p = C0338m.m569a().mo5043p();
        IXAdPackageUtils l = C0338m.m569a().mo5039l();
        IXNonLinearAdSlot iXNonLinearAdSlot = this.f952b;
        IXAdResource adResource = iXAdContainer.getAdContainerContext().getAdResource();
        Boolean valueOf = Boolean.valueOf(false);
        String clickThroughUrl = iXAdInstanceInfo.getClickThroughUrl();
        int actionType = iXAdInstanceInfo.getActionType();
        Collection arrayList = new ArrayList();
        List thirdClickTrackingUrls = iXAdInstanceInfo.getThirdClickTrackingUrls();
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= thirdClickTrackingUrls.size()) {
                break;
            }
            arrayList.add(((String) thirdClickTrackingUrls.get(i)).replaceAll("\\$\\{PROGRESS\\}", String.valueOf((int) iXAdContainer.getPlayheadTime())));
            i2 = i + 1;
        }
        Set hashSet = new HashSet();
        hashSet.addAll(arrayList);
        m888a(hashSet);
        int optInt;
        if (actionType == p.getActTypeOpenExternalApp()) {
            JSONObject jSONObject;
            Boolean valueOf2 = Boolean.valueOf(true);
            try {
                jSONObject = new JSONObject(clickThroughUrl);
            } catch (Exception e) {
                try {
                    JSONObject jSONObject2 = new JSONObject(iXAdInstanceInfo.getAppOpenStrs());
                    C0368a c0368a = new C0368a();
                    C0371d c0371d = new C0371d(clickThroughUrl, "");
                    c0371d.f798e = 1;
                    c0368a.mo5118a(c0371d, Boolean.valueOf(true));
                    jSONObject = jSONObject2;
                } catch (Exception e2) {
                    return;
                }
            }
            String optString = jSONObject.optString("page", "");
            if (!l.sendAPOInfo(iXNonLinearAdSlot.getApplicationContext(), optString, iXAdInstanceInfo.getAppPackageName(), 366, jSONObject.optInt("fb_act", 0))) {
                optInt = jSONObject.optInt("fb_act", 0);
                IXAdInstanceInfo xAdInstanceInfo = new XAdInstanceInfo(new JSONObject());
                if (optInt == p.getActTypeLandingPage()) {
                    xAdInstanceInfo.setActionType(p.getActTypeLandingPage());
                    xAdInstanceInfo.setClickThroughUrl(jSONObject.optString("fallback", ""));
                    xAdInstanceInfo.setTitle(iXAdInstanceInfo.getTitle());
                    xAdInstanceInfo.setInapp(true);
                    onAdClicked(iXAdContainer, xAdInstanceInfo, bool, hashMap);
                } else if (optInt == p.getActTypeDownload()) {
                    xAdInstanceInfo.setActionType(p.getActTypeDownload());
                    xAdInstanceInfo.setClickThroughUrl(jSONObject.optString("fallback", ""));
                    xAdInstanceInfo.setTitle(iXAdInstanceInfo.getTitle());
                    xAdInstanceInfo.setInapp(true);
                    xAdInstanceInfo.setAPOOpen(true);
                    xAdInstanceInfo.setPage(optString);
                    xAdInstanceInfo.setAppPackageName(iXAdInstanceInfo.getAppPackageName());
                    onAdClicked(iXAdContainer, xAdInstanceInfo, bool, hashMap);
                }
            } else if (bool.booleanValue()) {
                new C0272a(iXNonLinearAdSlot, iXAdInstanceInfo, adResource, optString).mo4423a();
            }
            m887a(iXNonLinearAdSlot.getApplicationContext(), optString, iXAdInstanceInfo.getAppPackageName());
            bool2 = valueOf2;
        } else if (actionType == p.getActTypeDownload()) {
            bool2 = Boolean.valueOf(false);
            if (bool.booleanValue()) {
                new C0270a(iXNonLinearAdSlot, iXAdInstanceInfo, adResource).mo4406a();
            }
        } else if (actionType == p.getActTypeLandingPage() || actionType == p.getActTypeOpenMap()) {
            bool2 = this.f952b.getProdInfo().getProdType() != p.getProductionTypeSplash() ? Boolean.valueOf(true) : valueOf;
            if (bool.booleanValue()) {
                if (iXAdInstanceInfo.isInapp()) {
                    new C0273a(iXNonLinearAdSlot, iXAdInstanceInfo, adResource, clickThroughUrl).mo4424a();
                } else {
                    m.browserOutside(iXAdContainer.getAdContainerContext().getApplicationContext(), clickThroughUrl);
                }
            }
        } else {
            if (actionType == p.getActTypeMakeCall() || actionType == p.getActTypeSendSMS() || actionType == p.getActTypeSendMail()) {
                valueOf = Boolean.valueOf(true);
                if (bool.booleanValue()) {
                    new C0272a(iXNonLinearAdSlot, iXAdInstanceInfo, adResource, clickThroughUrl).mo4423a();
                }
                if (actionType == p.getActTypeMakeCall()) {
                    PackageManager packageManager = iXNonLinearAdSlot.getApplicationContext().getPackageManager();
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(clickThroughUrl));
                    List queryIntentActivities = packageManager.queryIntentActivities(intent, 64);
                    if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
                        String str;
                        Object obj;
                        String str2 = null;
                        i2 = 0;
                        while (true) {
                            i = i2;
                            str = str2;
                            if (i < queryIntentActivities.size()) {
                                if (i > 0 && !str.equals(((ResolveInfo) queryIntentActivities.get(i)).activityInfo.processName)) {
                                    obj = null;
                                    break;
                                } else {
                                    str2 = ((ResolveInfo) queryIntentActivities.get(i)).activityInfo.processName;
                                    i2 = i + 1;
                                }
                            } else {
                                optInt = 1;
                                break;
                            }
                        }
                        if (obj != null) {
                            m886a(iXNonLinearAdSlot.getApplicationContext(), str);
                        }
                    }
                    bool2 = valueOf;
                }
            } else if (actionType != p.getActTypeNothing2Do()) {
                p.getActTypeRichMedia();
            }
            bool2 = valueOf;
        }
        if (bool2.booleanValue()) {
            this.f952b.dispatchEvent(new C0280a(IXAdEvent.AD_CLICK_THRU));
        }
        this.f952b.dispatchEvent(new C0280a("AdUserClick"));
    }

    public void onAdCustomEvent(String str, IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f955e.get()) {
        }
    }

    public void onAdDurationChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f955e.get()) {
        }
    }

    public void onAdError(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        if (!this.f955e.get()) {
            if (hashMap != null) {
                IXAdConstants p = C0338m.m569a().mo5043p();
                C0265a.m334a().mo4397a(hashMap.get(p.getInfoKeyErrorCode()) + "," + hashMap.get(p.getInfoKeyErrorMessage()) + "," + hashMap.get(p.getInfoKeyErrorModule()));
            }
            this.f955e.set(true);
            this.f952b.dispatchEvent(new C0280a(IXAdEvent.AD_ERROR, hashMap));
        }
    }

    public void onAdExpandedChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f955e.get()) {
        }
    }

    public void onAdImpression(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        m888a(iXAdInstanceInfo.getImpressionUrls());
    }

    public void onAdInteraction(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f955e.get()) {
        }
    }

    public void onAdLinearChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f955e.get()) {
        }
    }

    public void onAdLoaded(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f952b.mo5141a(iXAdContainer, (HashMap) hashMap);
        } else {
            new Handler(this.f951a.getMainLooper()).post(new C0424r(this, iXAdContainer, hashMap));
        }
    }

    public void onAdPaused(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        this.f952b.dispatchEvent(new C0280a(IXAdEvent.AD_PAUSED));
    }

    public void onAdPlaying(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        this.f952b.dispatchEvent(new C0280a(IXAdEvent.AD_PLAYING));
    }

    public void onAdRemainingTimeChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f955e.get()) {
        }
    }

    public void onAdSizeChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f955e.get()) {
        }
    }

    public void onAdSkippableStateChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f955e.get()) {
        }
    }

    public void onAdSkipped(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f955e.get()) {
        }
    }

    public void onAdStarted(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, HashMap<String, Object> hashMap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f952b.mo5151b(iXAdContainer, hashMap);
        } else {
            new Handler(this.f951a.getMainLooper()).post(new C0425s(this, iXAdContainer, hashMap));
        }
    }

    public void onAdStoped(IXAdContainer iXAdContainer, IXAdInstanceInfo iXAdInstanceInfo, Boolean bool, Boolean bool2, HashMap<String, Object> hashMap) {
        if (iXAdInstanceInfo != null) {
            Set hashSet = new HashSet();
            hashSet.addAll(iXAdInstanceInfo.getCloseTrackers());
            m888a(hashSet);
        }
        if (bool2.booleanValue()) {
            IXAdContainerContext adContainerContext = iXAdContainer.getAdContainerContext();
            this.f952b.mo5144a(adContainerContext.getAdResponseInfo(), adContainerContext.getAdInstanceInfo());
            return;
        }
        this.f952b.mo5160e(iXAdContainer, hashMap);
        this.f952b.dispatchEvent(new C0280a(IXAdEvent.AD_STOPPED));
    }

    public void onAdUserAcceptInvitation(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f955e.get()) {
        }
    }

    public void onAdUserClosed(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        this.f952b.dispatchEvent(new C0280a(IXAdEvent.AD_USER_CLOSE));
    }

    public void onAdUserMinimize(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f955e.get()) {
        }
    }

    public void onAdVideoComplete(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f955e.get()) {
        }
    }

    public void onAdVideoFirstQuartile(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f955e.get()) {
        }
    }

    public void onAdVideoMidpoint(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f955e.get()) {
        }
    }

    public void onAdVideoStart(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f955e.get()) {
        }
    }

    public void onAdVideoThirdQuartile(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f955e.get()) {
        }
    }

    public void onAdVolumeChange(IXAdContainer iXAdContainer, Boolean bool, HashMap<String, Object> hashMap) {
        if (this.f955e.get()) {
        }
    }
}
