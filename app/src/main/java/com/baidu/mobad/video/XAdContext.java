package com.baidu.mobad.video;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.ActivityState;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.ScreenSizeMode;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotState;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.VideoState;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.VisitorAction;
import com.baidu.mobads.interfaces.IXAdContext;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdInternalConstants;
import com.baidu.mobads.interfaces.IXAdManager;
import com.baidu.mobads.interfaces.IXAdProd;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.openad.p020d.C0232b;
import com.baidu.mobads.openad.p020d.C0257c;
import com.baidu.mobads.openad.p037e.C0368a;
import com.baidu.mobads.openad.p037e.C0371d;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.production.p048i.C0413b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class XAdContext implements IXAdContext {
    public static final String TAG = "XAdContext";
    /* renamed from: a */
    int f252a = 0;
    /* renamed from: b */
    int f253b = 0;
    /* renamed from: c */
    private HashMap<String, Object> f254c = new HashMap();
    /* renamed from: d */
    private ScreenSizeMode f255d = ScreenSizeMode.FULL_SCREEN;
    /* renamed from: e */
    private VideoState f256e = VideoState.IDLE;
    /* renamed from: f */
    private ActivityState f257f = ActivityState.CREATE;
    /* renamed from: g */
    private VisitorAction f258g;
    /* renamed from: h */
    private double f259h;
    /* renamed from: i */
    private int f260i;
    /* renamed from: j */
    private int f261j;
    /* renamed from: k */
    private Context f262k;
    /* renamed from: l */
    private String f263l;
    /* renamed from: m */
    private Location f264m;
    protected IXAdLogger mAdLogger;
    /* renamed from: n */
    private Activity f265n;
    /* renamed from: o */
    private RelativeLayout f266o;
    /* renamed from: p */
    private final IOAdEventDispatcher f267p;
    /* renamed from: q */
    private final XAdSlotManager f268q;

    /* renamed from: com.baidu.mobad.video.XAdContext$1 */
    class C02301 implements Runnable {
        C02301() {
        }

        public void run() {
            IXAdProd retrievePrerollAdSlot = XAdContext.this.f268q.retrievePrerollAdSlot();
            if (retrievePrerollAdSlot != null && retrievePrerollAdSlot.getSlotState() == SlotState.PLAYING) {
                retrievePrerollAdSlot.resize();
            }
        }
    }

    public static class AdSlotEventListener implements IOAdEventListener {
        public static final String TAG = "AdSlotEventListener";
        /* renamed from: a */
        private final Context f249a;
        /* renamed from: b */
        private final IXAdProd f250b;
        /* renamed from: c */
        private final IOAdEventDispatcher f251c;

        public AdSlotEventListener(Context context, IXAdProd iXAdProd, IOAdEventDispatcher iOAdEventDispatcher) {
            this.f249a = context;
            this.f250b = iXAdProd;
            this.f251c = iOAdEventDispatcher;
        }

        public void run(final IOAdEvent iOAdEvent) {
            C0338m.m569a().mo5033f().mo4931i(TAG, iOAdEvent.getType());
            C0338m.m569a().mo5040m().mo5017a(new Runnable() {
                public void run() {
                    if (iOAdEvent.getType().equals(C0232b.COMPLETE)) {
                        AdSlotEventListener.this.f251c.dispatchEvent(new XAdEvent4PDK(IXAdConstants4PDK.EVENT_REQUEST_COMPLETE, AdSlotEventListener.this.f250b));
                    }
                    if (iOAdEvent.getType().equals(IXAdEvent.AD_STARTED)) {
                        if (AdSlotEventListener.this.f250b.getProdBase() != null) {
                            AdSlotEventListener.this.f250b.getProdBase().setVisibility(0);
                        }
                        AdSlotEventListener.this.f251c.dispatchEvent(new XAdEvent4PDK(IXAdConstants4PDK.EVENT_SLOT_STARTED, AdSlotEventListener.this.f250b));
                    }
                    if (iOAdEvent.getType().equals("AdUserClick")) {
                        AdSlotEventListener.this.f251c.dispatchEvent(new XAdEvent4PDK(IXAdConstants4PDK.EVENT_SLOT_CLICKED, AdSlotEventListener.this.f250b));
                    }
                    if (iOAdEvent.getType().equals(IXAdEvent.AD_STOPPED)) {
                        if (AdSlotEventListener.this.f250b.getProdBase() != null) {
                            AdSlotEventListener.this.f250b.getProdBase().setVisibility(4);
                        }
                        AdSlotEventListener.this.f251c.dispatchEvent(new XAdEvent4PDK(IXAdConstants4PDK.EVENT_SLOT_ENDED, AdSlotEventListener.this.f250b));
                    }
                    if (iOAdEvent.getType().equals(IXAdEvent.AD_ERROR)) {
                        if (AdSlotEventListener.this.f250b.getProdBase() != null) {
                            AdSlotEventListener.this.f250b.getProdBase().setVisibility(4);
                        }
                        AdSlotEventListener.this.f251c.dispatchEvent(new XAdEvent4PDK(IXAdConstants4PDK.EVENT_ERROR, AdSlotEventListener.this.f250b));
                    }
                }
            });
        }
    }

    public XAdContext(Context context, String str, Location location) {
        this.f262k = context;
        this.f263l = str;
        this.f264m = location;
        this.f267p = new C0257c();
        this.f268q = new XAdSlotManager();
        this.mAdLogger = C0338m.m569a().mo5033f();
    }

    /* renamed from: a */
    private void m266a(Set<String> set) {
        C0368a c0368a = new C0368a();
        for (String c0371d : set) {
            C0371d c0371d2 = new C0371d(c0371d, "");
            c0371d2.f798e = 1;
            c0368a.mo5118a(c0371d2, Boolean.valueOf(true));
        }
    }

    public void addEventListener(String str, IOAdEventListener iOAdEventListener) {
        this.f267p.addEventListener(str, iOAdEventListener);
    }

    public void dispatchEvent(IOAdEvent iOAdEvent) {
    }

    public void dispose() {
    }

    public Activity getActivity() {
        return this.f265n;
    }

    public Object getParameter(String str) {
        return this.f254c.get(str);
    }

    public IXAdProd getSlotById(String str) {
        return this.f268q.retrieveAdSlotById(str);
    }

    public IXAdManager getXAdManager() {
        return null;
    }

    public IXLinearAdSlot newPrerollAdSlot(String str, int i, int i2) {
        if (!this.f268q.containsAdSlot(str).booleanValue()) {
            IXAdProd c0413b = new C0413b(this.f265n, str);
            c0413b.setActivity(this.f265n);
            c0413b.setAdSlotBase(this.f266o);
            c0413b.setId(str);
            IOAdEventListener adSlotEventListener = new AdSlotEventListener(this.f262k, c0413b, this.f267p);
            c0413b.removeAllListeners();
            c0413b.addEventListener(C0232b.COMPLETE, adSlotEventListener);
            c0413b.addEventListener(IXAdEvent.AD_STARTED, adSlotEventListener);
            c0413b.addEventListener(IXAdEvent.AD_STOPPED, adSlotEventListener);
            c0413b.addEventListener(IXAdEvent.AD_ERROR, adSlotEventListener);
            c0413b.addEventListener("AdUserClick", adSlotEventListener);
            this.f268q.addAdSlot(c0413b);
        }
        return this.f268q.retrievePrerollAdSlot();
    }

    public void notifyVisitorAction(VisitorAction visitorAction) {
        this.f258g = visitorAction;
    }

    public void removeEventListener(String str, IOAdEventListener iOAdEventListener) {
        this.f267p.removeEventListener(str, iOAdEventListener);
    }

    public void setActivity(Activity activity) {
        if (activity != null && this.f265n == null) {
            this.f265n = activity;
            if (this.f262k == null) {
                this.f262k = this.f265n.getApplicationContext();
            }
        }
    }

    public void setActivityState(ActivityState activityState) {
        this.f257f = activityState;
        this.mAdLogger.mo4931i(TAG, activityState.getValue());
        IXAdProd retrievePrerollAdSlot = this.f268q.retrievePrerollAdSlot();
        if (retrievePrerollAdSlot != null) {
            if (activityState == ActivityState.PAUSE) {
                retrievePrerollAdSlot.pause();
            }
            if (activityState == ActivityState.RESUME) {
                retrievePrerollAdSlot.resume();
            }
        }
    }

    public void setAdCreativeLoadingTimeout(int i) {
        this.f261j = i;
    }

    public void setAdServerRequestingTimeout(int i) {
        this.f260i = i;
    }

    public void setContentVideoPlayheadTime(double d) {
        this.f259h = d;
    }

    public void setContentVideoScreenMode(ScreenSizeMode screenSizeMode) {
        this.f255d = screenSizeMode;
        IXAdProd retrievePrerollAdSlot = this.f268q.retrievePrerollAdSlot();
        if (this.f255d == ScreenSizeMode.FULL_SCREEN && retrievePrerollAdSlot != null && retrievePrerollAdSlot.getSlotState() == SlotState.PLAYING) {
            IXAdInstanceInfo currentAdInstance = retrievePrerollAdSlot.getCurrentAdInstance();
            if (currentAdInstance != null) {
                int playheadTime = (int) retrievePrerollAdSlot.getCurrentXAdContainer().getPlayheadTime();
                IXAdURIUitls i = C0338m.m569a().mo5036i();
                List arrayList = new ArrayList();
                List fullScreenTrackers = currentAdInstance.getFullScreenTrackers();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < fullScreenTrackers.size()) {
                        arrayList.add(i.addParameter((String) fullScreenTrackers.get(i3), "progress", String.valueOf(playheadTime)));
                        i2 = i3 + 1;
                    } else {
                        currentAdInstance.setFullScreenTrackers(arrayList);
                        Set hashSet = new HashSet();
                        hashSet.addAll(currentAdInstance.getFullScreenTrackers());
                        m266a(hashSet);
                        return;
                    }
                }
            }
        }
    }

    public void setContentVideoState(VideoState videoState) {
        this.f256e = videoState;
    }

    public void setParameter(String str, Object obj) {
        this.f254c.put(str, obj);
    }

    public void setVideoDisplayBase(RelativeLayout relativeLayout) {
        this.f266o = relativeLayout;
        setActivity((Activity) this.f266o.getContext());
        new Handler(getActivity().getMainLooper()).post(new C02301());
    }

    public void setVideoDisplayBaseHeight(int i) {
        this.f253b = i;
    }

    public void setVideoDisplayBaseWidth(int i) {
        this.f252a = i;
    }

    public void submitRequest() {
        IXAdProd retrievePrerollAdSlot = this.f268q.retrievePrerollAdSlot();
        if (this.f260i > 0 && this.f261j > 0) {
            HashMap parameter = retrievePrerollAdSlot.getParameter();
            parameter.put(IXAdInternalConstants.PARAMETER_KEY_OF_AD_REQUESTING_TIMEOUT, this.f260i);
            parameter.put(IXAdInternalConstants.PARAMETER_KEY_OF_AD_CREATIVE_LOADING_TIMEOUT, this.f261j);
            parameter.put(IXAdInternalConstants.PARAMETER_KEY_OF_BASE_WIDTH, this.f252a);
            parameter.put(IXAdInternalConstants.PARAMETER_KEY_OF_BASE_HEIGHT, this.f253b);
            retrievePrerollAdSlot.setParameter(parameter);
        }
        retrievePrerollAdSlot.request();
    }
}
