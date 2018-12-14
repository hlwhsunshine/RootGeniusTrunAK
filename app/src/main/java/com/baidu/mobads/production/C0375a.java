package com.baidu.mobads.production;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.C0258an;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotState;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdContainerContext;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.openad.p020d.C0257c;
import com.baidu.mobads.openad.p036b.C0354b;
import com.baidu.mobads.openad.p036b.C0356d;
import com.baidu.mobads.openad.p037e.C0371d;
import com.baidu.mobads.openad.p038f.C0372a;
import com.baidu.mobads.p021j.C0329d;
import com.baidu.mobads.p021j.C0333g;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.p022a.C0238a;
import com.baidu.mobads.p025c.C0265a;
import com.baidu.mobads.p032f.C0280a;
import com.baidu.mobads.p034h.C0307g;
import com.baidu.mobads.p034h.C0318q;
import com.baidu.mobads.p040vo.C0378d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.baidu.mobads.production.a */
public abstract class C0375a extends C0257c implements IXNonLinearAdSlot {
    /* renamed from: a */
    public static IXAdContainerFactory f810a;
    /* renamed from: w */
    private static final String[] f811w = new String[]{"android.permission.READ_PHONE_STATE", "android.permission.ACCESS_COARSE_LOCATION"};
    /* renamed from: b */
    protected Boolean f812b;
    /* renamed from: d */
    public IXAdInstanceInfo f813d;
    /* renamed from: e */
    protected RelativeLayout f814e;
    /* renamed from: f */
    protected Context f815f;
    /* renamed from: g */
    protected int f816g;
    /* renamed from: h */
    public IXAdContainer f817h;
    /* renamed from: i */
    protected String f818i;
    /* renamed from: j */
    protected C0426t f819j;
    /* renamed from: k */
    protected C0372a f820k;
    /* renamed from: l */
    protected C0378d f821l;
    /* renamed from: m */
    protected SlotState f822m;
    /* renamed from: n */
    protected int f823n;
    /* renamed from: o */
    protected int f824o;
    /* renamed from: p */
    protected SlotType f825p;
    /* renamed from: q */
    protected HashMap<String, String> f826q;
    /* renamed from: r */
    protected AtomicBoolean f827r;
    /* renamed from: s */
    protected final IXAdLogger f828s;
    /* renamed from: t */
    protected long f829t;
    /* renamed from: u */
    protected long f830u;
    /* renamed from: v */
    protected long f831v;
    /* renamed from: x */
    private IXAdResponseInfo f832x;
    /* renamed from: y */
    private String f833y;
    /* renamed from: z */
    private IOAdEventListener f834z;

    public C0375a(Context context) {
        this.f812b = Boolean.valueOf(false);
        this.f813d = null;
        this.f816g = 0;
        this.f822m = SlotState.IDEL;
        this.f823n = 5000;
        this.f824o = 0;
        this.f826q = new HashMap();
        this.f827r = new AtomicBoolean();
        this.f834z = new C0383b(this);
        this.f828s = C0338m.m569a().mo5033f();
        new Thread(new C0394e(this, context)).start();
    }

    public C0375a(Context context, String str, SlotType slotType) {
        this(context);
        this.f815f = context;
        mo5156c(str);
        setId(str);
        this.f825p = slotType;
    }

    /* renamed from: a */
    private void m679a(XAdErrorCode xAdErrorCode, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("msg", xAdErrorCode);
        dispatchEvent(new C0280a(IXAdEvent.AD_ERROR, hashMap));
        C0338m.m569a().mo5044q().printErrorMessage(xAdErrorCode, str);
    }

    /* renamed from: b */
    private IXAdContainer m681b(IXAdContainerContext iXAdContainerContext) {
        IXAdContainer iXAdContainer = null;
        this.f828s.mo4931i("XAbstractAdProdTemplate", "createAdContainer");
        if (f810a != null) {
            iXAdContainer = f810a.createXAdContainer(iXAdContainerContext, null);
            if (iXAdContainer != null) {
                this.f828s.mo4931i("XAbstractAdProdTemplate", "createAdContainer() apk.version=" + f810a.getRemoteVersion());
            }
        }
        return iXAdContainer;
    }

    /* renamed from: b */
    public static IXAdContainerFactory m682b() {
        return f810a;
    }

    /* renamed from: b */
    private void m683b(IXAdResponseInfo iXAdResponseInfo) {
        this.f828s.mo4931i("XAbstractAdProdTemplate", "try2CachingVideoAdCreativeAsset");
        IXAdURIUitls i = C0338m.m569a().mo5036i();
        IXAdInstanceInfo primaryAdInstanceInfo = iXAdResponseInfo.getPrimaryAdInstanceInfo();
        String videoUrl = primaryAdInstanceInfo.getVideoUrl();
        Boolean isHttpProtocol = i.isHttpProtocol(videoUrl);
        this.f828s.mo4931i("XAbstractAdProdTemplate", "try2CachingVideoAdCreativeAsset, should cache=" + isHttpProtocol);
        if (isHttpProtocol.booleanValue()) {
            primaryAdInstanceInfo.setLocalCreativeURL(null);
            String str = getApplicationContext().getFilesDir().getPath() + File.separator + "__bidu_cache_dir" + File.separator;
            String adId = primaryAdInstanceInfo.getAdId();
            C0333g b = C0338m.m569a().mo5028b();
            b.mo5023a(str);
            b.mo5024a(videoUrl, str, adId, new C0417k(this, Looper.getMainLooper(), primaryAdInstanceInfo));
        }
    }

    /* renamed from: c */
    private void m684c(Context context) {
        new Handler(Looper.getMainLooper()).postDelayed(new C0402f(this, context), 2000);
    }

    /* renamed from: a */
    protected void mo5137a() {
    }

    /* renamed from: a */
    public void mo5138a(int i) {
        if (this.f817h != null) {
            this.f817h.onWindowVisibilityChanged(i);
        }
    }

    /* renamed from: a */
    protected void mo5139a(Context context) {
        if (BaiduXAdSDKContext.mApkLoader == null) {
            synchronized (C0307g.class) {
                if (BaiduXAdSDKContext.mApkLoader == null) {
                    BaiduXAdSDKContext.mApkLoader = new C0307g(context.getApplicationContext());
                }
            }
        }
        BaiduXAdSDKContext.mApkLoader.mo4504a(new C0416j(this));
    }

    /* renamed from: a */
    public void mo5140a(Context context, String str) {
        if (!C0338m.m569a().mo5040m().hasPermission(context, str)) {
            String str2 = "Cannot request an ad without necessary permissions!  Open manifest.xml and just before the final </manifest> tag add:  <uses-permission android:name=\"" + str + "\" />";
            this.f828s.mo4929e("BaiduMobAds SDK", str2);
            throw new SecurityException(str2);
        }
    }

    /* renamed from: a */
    protected void mo5141a(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        mo5163h();
        mo5155c(iXAdContainer, hashMap);
        dispatchEvent(new C0280a(IXAdEvent.AD_LOADED));
    }

    /* renamed from: a */
    protected void mo5142a(IXAdContainerContext iXAdContainerContext) {
        try {
            this.f828s.mo4931i("XAbstractAdProdTemplate", "processAllReadyOnUIThread()");
            this.f830u = System.currentTimeMillis();
            this.f817h = m681b(iXAdContainerContext);
            this.f831v = System.currentTimeMillis();
            if (this.f817h == null) {
                this.f828s.mo4929e("XAbstractAdProdTemplate", "processAllReadyOnUIThread(), mAdContainer is null");
                dispatchEvent(new C0280a(IXAdEvent.AD_STOPPED));
                return;
            }
            this.f828s.mo4931i("XAbstractAdProdTemplate", "processAllReadyOnUIThread(), mAdContainer be created");
            this.f826q.put("start", this.f829t);
            this.f826q.put("container_before_created", this.f830u);
            this.f826q.put("container_after_created", this.f831v);
            this.f817h.setParameters(this.f826q);
            C0238a.f376c = this.f817h.getRemoteVersion();
            this.f828s.mo4931i("XAbstractAdProdTemplate", "processAllReadyOnUIThread(), mAdContainer be created, hasCalledLoadAtAppSide=" + this.f827r.get());
            if (this.f827r.get()) {
                this.f817h.load();
            }
            mo5154c();
            m684c(this.f815f);
        } catch (Exception e) {
            this.f828s.mo4926e(C0338m.m569a().mo5044q().genCompleteErrorMessage(XAdErrorCode.PERMISSION_PROBLEM, e.getMessage()));
            C0265a.m334a().mo4397a("process all ready on UI Thread exception: " + e.toString());
        }
    }

    /* renamed from: a */
    protected void mo5143a(IXAdResponseInfo iXAdResponseInfo) {
        this.f828s.mo4931i("XAbstractAdProdTemplate", "handleAllReady");
        this.f816g++;
        this.f813d = iXAdResponseInfo.getPrimaryAdInstanceInfo();
        Context applicationContext = getApplicationContext();
        IXAdContainerContext c0258an = new C0258an(applicationContext, getActivity(), this.f821l.mo5179d(), this.f814e, new C0421o(applicationContext, this), iXAdResponseInfo, null);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            mo5142a(c0258an);
        } else {
            new Handler(Looper.getMainLooper()).post(new C0419m(this, c0258an));
        }
    }

    /* renamed from: a */
    protected void mo5144a(IXAdResponseInfo iXAdResponseInfo, IXAdInstanceInfo iXAdInstanceInfo) {
        this.f813d = iXAdInstanceInfo;
    }

    /* renamed from: a */
    protected abstract void mo5145a(C0371d c0371d, C0426t c0426t, int i);

    /* renamed from: a */
    protected void mo5146a(String str) {
        this.f828s.mo4931i("XAbstractAdProdTemplate", "doubleCheck:" + str + ", bfp=" + this.f812b + ", apk=" + BaiduXAdSDKContext.isRemoteLoadSuccess);
        if (BaiduXAdSDKContext.isRemoteLoadSuccess.booleanValue()) {
            C0338m.m569a().mo5027a(getAdContainerFactory());
        }
        if (BaiduXAdSDKContext.isRemoteLoadSuccess.booleanValue() && this.f812b.booleanValue()) {
            IXAdResponseInfo adResponseInfo = getAdResponseInfo();
            if (adResponseInfo != null) {
                m683b(adResponseInfo);
            }
            mo5143a(getAdResponseInfo());
        }
    }

    /* renamed from: a */
    public void mo5147a(boolean z) {
        if (this.f817h != null) {
            this.f817h.onWindowFocusChanged(z);
        }
    }

    /* renamed from: a */
    public boolean mo5148a(int i, KeyEvent keyEvent) {
        return this.f817h != null ? this.f817h.processKeyEvent(i, keyEvent).booleanValue() : false;
    }

    /* renamed from: a */
    protected boolean mo5149a(C0378d c0378d) {
        this.f828s.mo4931i("XAbstractAdProdTemplate", "doRequest()");
        new Thread(new C0418l(this, c0378d)).start();
        return true;
    }

    /* renamed from: b */
    public void mo5150b(Context context) {
        try {
            C0329d m = C0338m.m569a().mo5040m();
            mo5140a(context, "android.permission.INTERNET");
            mo5140a(context, "android.permission.ACCESS_NETWORK_STATE");
            if (m.isOldPermissionModel()) {
                mo5140a(context, "android.permission.READ_PHONE_STATE");
                mo5140a(context, "android.permission.WRITE_EXTERNAL_STORAGE");
                return;
            }
            int i;
            ArrayList arrayList = new ArrayList();
            for (i = 0; i < f811w.length; i++) {
                if (!m.checkSelfPermission(context, f811w[i])) {
                    arrayList.add(f811w[i]);
                }
            }
            i = arrayList.size();
            if (i > 0) {
                m.mo5015a(context, (String[]) arrayList.toArray(new String[i]), 1234323329);
            }
        } catch (Exception e) {
            this.f828s.mo4926e(C0338m.m569a().mo5044q().genCompleteErrorMessage(XAdErrorCode.PERMISSION_PROBLEM, e.getMessage()));
            C0265a.m334a().mo4397a("check permission exception: " + e.toString());
        }
    }

    /* renamed from: b */
    protected void mo5151b(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        this.f822m = SlotState.PLAYING;
        mo5158d(iXAdContainer, hashMap);
        dispatchEvent(new C0280a(IXAdEvent.AD_STARTED));
    }

    /* renamed from: b */
    protected void mo5152b(C0378d c0378d) {
        this.f821l = c0378d;
        mo5162g();
        this.f812b = Boolean.valueOf(false);
        String b = this.f818i == null ? c0378d.mo5174b() : this.f818i;
        this.f819j = new C0426t();
        try {
            this.f819j.mo5115a(new C0354b());
        } catch (ClassNotFoundException e) {
            this.f819j.mo5115a(new C0356d());
        }
        C0265a.f443b = b;
        C0371d c0371d = new C0371d(b, "");
        c0371d.f798e = 1;
        this.f819j.addEventListener("URLLoader.Load.Complete", this.f834z);
        this.f819j.addEventListener("URLLoader.Load.Error", this.f834z);
        mo5145a(c0371d, this.f819j, this.f823n);
    }

    /* renamed from: b */
    protected void mo5153b(String str) {
        C0265a.m334a().mo4397a(str);
        dispatchEvent(new C0280a(IXAdEvent.AD_ERROR));
    }

    /* renamed from: c */
    public abstract void mo5154c();

    /* renamed from: c */
    protected abstract void mo5155c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap);

    /* renamed from: c */
    protected void mo5156c(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f828s.mo4926e("代码位id(adPlaceId)不可以为空");
        }
    }

    /* renamed from: d */
    protected abstract void mo5157d();

    /* renamed from: d */
    protected abstract void mo5158d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap);

    /* renamed from: e */
    protected void mo5159e() {
        if (this.f817h != null && getApplicationContext() != null) {
            this.f822m = SlotState.PAUSED;
            new Handler(getApplicationContext().getMainLooper()).post(new C0386c(this));
        }
    }

    /* renamed from: e */
    protected void mo5160e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    /* renamed from: f */
    protected void mo5161f() {
        if (this.f817h != null && getApplicationContext() != null) {
            this.f822m = SlotState.PLAYING;
            new Handler(getApplicationContext().getMainLooper()).post(new C0388d(this));
        }
    }

    /* renamed from: g */
    protected void mo5162g() {
        if (this.f819j != null) {
            this.f819j.removeAllListeners();
            this.f819j.mo5114a();
        }
    }

    public Activity getActivity() {
        return this.f815f instanceof Activity ? (Activity) this.f815f : (this.f814e == null || !(this.f814e.getContext() instanceof Activity)) ? null : (Activity) this.f814e.getContext();
    }

    public IXAdContainerFactory getAdContainerFactory() {
        return f810a;
    }

    public IXAdResponseInfo getAdResponseInfo() {
        return this.f832x;
    }

    public Context getApplicationContext() {
        Activity activity = getActivity();
        return activity == null ? this.f815f : activity.getApplicationContext();
    }

    public IXAdInstanceInfo getCurrentAdInstance() {
        return this.f813d;
    }

    public IXAdContainer getCurrentXAdContainer() {
        return this.f817h;
    }

    public int getDuration() {
        return -1;
    }

    public String getId() {
        return this.f833y;
    }

    public HashMap<String, String> getParameter() {
        return this.f826q;
    }

    public int getPlayheadTime() {
        return -1;
    }

    public ViewGroup getProdBase() {
        return this.f814e;
    }

    public IXAdProdInfo getProdInfo() {
        return this.f821l.mo5179d();
    }

    public SlotState getSlotState() {
        return this.f822m;
    }

    public SlotType getType() {
        return this.f825p;
    }

    /* renamed from: h */
    protected void mo5163h() {
        if (this.f820k != null) {
            this.f820k.stop();
        }
        this.f820k = null;
    }

    /* renamed from: i */
    protected void mo5164i() {
        if (this.f820k != null) {
            this.f820k.start();
        }
    }

    public Boolean isAdServerRequestingSuccess() {
        return this.f812b;
    }

    /* renamed from: j */
    public void mo5165j() {
        if (this.f817h != null) {
            this.f817h.onAttachedToWindow();
        }
    }

    @SuppressLint({"MissingSuperCall"})
    /* renamed from: k */
    public void mo5166k() {
        if (this.f817h != null) {
            this.f817h.onDetachedFromWindow();
        }
    }

    /* renamed from: l */
    public void mo5167l() {
        if (this.f817h != null) {
            this.f817h.destroy();
        }
        BaiduXAdSDKContext.exit();
    }

    public void load() {
        if (this.f817h != null) {
            this.f817h.load();
        } else {
            this.f827r.set(true);
        }
    }

    public void pause() {
        mo5159e();
    }

    public void resize() {
        if (this.f817h != null && getApplicationContext() != null) {
            new Handler(getApplicationContext().getMainLooper()).post(new C0420n(this));
        }
    }

    public void resume() {
        mo5161f();
    }

    public void setActivity(Context context) {
        this.f815f = context;
        this.f829t = System.currentTimeMillis();
        mo5137a();
        this.f827r.set(false);
        mo5157d();
        C0354b.m606a(getApplicationContext());
        C0265a.m334a().mo4393a(getApplicationContext());
        C0338m.m569a().mo5026a(getApplicationContext());
        this.f820k = new C0372a(this.f823n);
        this.f820k.setEventHandler(new C0414i(this));
        mo5150b(this.f815f);
        C0318q.m476a(this.f815f).mo4523a();
    }

    public void setAdResponseInfo(IXAdResponseInfo iXAdResponseInfo) {
        this.f832x = iXAdResponseInfo;
    }

    public void setAdSlotBase(RelativeLayout relativeLayout) {
        this.f814e = relativeLayout;
    }

    public void setId(String str) {
        this.f833y = str;
    }

    public void setParameter(HashMap<String, String> hashMap) {
        this.f826q = hashMap;
    }

    public void start() {
        if (this.f817h != null) {
            this.f817h.start();
        }
    }

    public void stop() {
        C0338m.m569a().mo5033f().mo4931i("XAbstractAdProdTemplate", "stop");
        if (this.f817h != null) {
            this.f817h.stop();
            this.f817h = null;
        }
    }
}
