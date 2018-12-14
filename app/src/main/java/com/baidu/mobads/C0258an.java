package com.baidu.mobads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdContainerContext;
import com.baidu.mobads.interfaces.IXAdContainerEventListener;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.error.IXAdErrorCode;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
import com.baidu.mobads.interfaces.utils.IXAdBitmapUtils;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.interfaces.utils.IXAdViewUtils;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager;
import com.baidu.mobads.openad.interfaces.utils.IOAdTimer;
import com.baidu.mobads.openad.p020d.C0232b;
import com.baidu.mobads.openad.p020d.C0257c;
import com.baidu.mobads.openad.p037e.C0368a;
import com.baidu.mobads.openad.p037e.C0371d;
import com.baidu.mobads.openad.p038f.C0372a;
import com.baidu.mobads.p021j.C0338m;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.an */
public class C0258an extends C0257c implements IXAdContainerContext {
    /* renamed from: a */
    public IXAdContainerEventListener f422a;
    /* renamed from: b */
    private Context f423b;
    /* renamed from: d */
    private Activity f424d;
    /* renamed from: e */
    private RelativeLayout f425e;
    /* renamed from: f */
    private IXAdResponseInfo f426f;
    /* renamed from: g */
    private IXAdInstanceInfo f427g;
    /* renamed from: h */
    private View f428h;
    /* renamed from: i */
    private IXAdProdInfo f429i;
    /* renamed from: j */
    private long f430j = 0;
    /* renamed from: k */
    private HashMap<String, Integer> f431k = new HashMap();

    /* renamed from: com.baidu.mobads.an$a */
    public class C0256a extends C0232b {
        /* renamed from: b */
        private String f418b;
        /* renamed from: c */
        private HashMap<String, Object> f419c;

        public C0256a(String str, String str2, HashMap<String, Object> hashMap) {
            super(str);
            this.f418b = str2;
            this.f419c = hashMap;
        }

        public HashMap<String, Object> getData() {
            return this.f419c;
        }
    }

    public C0258an(Context context, Activity activity, IXAdProdInfo iXAdProdInfo, RelativeLayout relativeLayout, IXAdContainerEventListener iXAdContainerEventListener, IXAdResponseInfo iXAdResponseInfo, View view) {
        this.f423b = context;
        this.f424d = activity;
        this.f429i = iXAdProdInfo;
        this.f425e = relativeLayout;
        this.f422a = iXAdContainerEventListener;
        this.f426f = iXAdResponseInfo;
        this.f427g = iXAdResponseInfo.getPrimaryAdInstanceInfo();
        this.f428h = view;
    }

    public IOAdTimer createOAdTimer(int i) {
        return new C0372a(i);
    }

    public IOAdTimer createOAdTimer(int i, int i2) {
        return new C0372a(i, i2);
    }

    public void fireAdMetrics(String str, HashMap<String, String> hashMap) {
        String addParameters = C0338m.m569a().mo5036i().addParameters(str, hashMap);
        C0368a c0368a = new C0368a();
        C0371d c0371d = new C0371d(addParameters, "");
        c0371d.f798e = 1;
        c0368a.mo5118a(c0371d, Boolean.valueOf(true));
    }

    public Activity getActivity() {
        if (this.f424d == null && this.f425e != null) {
            this.f424d = (Activity) this.f425e.getContext();
        }
        return this.f424d;
    }

    public IXAdConstants getAdConstants() {
        return C0338m.m569a().mo5043p();
    }

    public IXAdContainerEventListener getAdContainerListener() {
        return this.f422a;
    }

    public IXAdInstanceInfo getAdInstanceInfo() {
        return this.f427g;
    }

    public View getAdLeadingView() {
        return this.f428h;
    }

    public IXAdLogger getAdLogger() {
        return C0338m.m569a().mo5033f();
    }

    public RelativeLayout getAdProdBase() {
        return this.f425e;
    }

    public IXAdProdInfo getAdProdInfo() {
        return this.f429i;
    }

    public IXAdResource getAdResource() {
        return C0338m.m569a().mo5034g();
    }

    public IXAdResponseInfo getAdResponseInfo() {
        return this.f426f;
    }

    public IXAdURIUitls getAdUitls4URI() {
        return C0338m.m569a().mo5036i();
    }

    public IXAdActivityUtils getAdUtils4Activity() {
        return C0338m.m569a().mo5042o();
    }

    public IXAdBitmapUtils getAdUtils4Bitmap() {
        return C0338m.m569a().mo5035h();
    }

    public IXAdCommonUtils getAdUtils4Common() {
        return C0338m.m569a().mo5040m();
    }

    public IXAdIOUtils getAdUtils4IO() {
        return C0338m.m569a().mo5038k();
    }

    public IXAdPackageUtils getAdUtils4Package() {
        return C0338m.m569a().mo5039l();
    }

    public IXAdSystemUtils getAdUtils4System() {
        return C0338m.m569a().mo5041n();
    }

    public IXAdViewUtils getAdUtils4View() {
        return C0338m.m569a().mo5037j();
    }

    public Context getApplicationContext() {
        return this.f423b;
    }

    public IBase64 getBase64() {
        return C0338m.m569a().mo5032e();
    }

    public IOAdDownloaderManager getDownloaderManager(Context context) {
        return C0338m.m569a().mo5029b(context);
    }

    public IXAdErrorCode getErrorCode() {
        return C0338m.m569a().mo5044q();
    }

    public String getProxyVersion() {
        return "8.25";
    }

    public void processCommand(String str, HashMap<String, Object> hashMap) {
        if (System.currentTimeMillis() - this.f430j > 1000) {
            this.f430j = System.currentTimeMillis();
            dispatchEvent(new C0256a("process_command", str, hashMap));
        }
    }

    public void registerAdService(String str, HashMap<String, Object> hashMap) {
        if (!this.f431k.containsKey(str)) {
            this.f431k.put(str, Integer.valueOf(1));
            dispatchEvent(new C0256a("regsiter_adservice", str, hashMap));
        }
    }

    public void unregisterAdService(String str) {
        if (this.f431k.containsKey(str)) {
            this.f431k.remove(str);
            dispatchEvent(new C0256a("unregsiter_adservice", str, new HashMap()));
        }
    }
}
