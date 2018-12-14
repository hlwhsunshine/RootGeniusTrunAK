package com.baidu.mobads.production.p045g;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo.CreativeType;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.p037e.C0371d;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.p040vo.C0378d;
import com.baidu.mobads.production.C0375a;
import com.baidu.mobads.production.C0426t;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.production.g.b */
public class C0403b extends C0375a implements C0395a {
    /* renamed from: A */
    private boolean f921A = false;
    /* renamed from: B */
    private boolean f922B = false;
    /* renamed from: C */
    private Activity f923C;
    /* renamed from: D */
    private RelativeLayout f924D;
    /* renamed from: E */
    private Boolean f925E;
    /* renamed from: w */
    public final String f926w = "html5_intersitial";
    /* renamed from: x */
    protected final IXAdLogger f927x = C0338m.m569a().mo5033f();
    /* renamed from: y */
    private C0405d f928y;
    /* renamed from: z */
    private AdSize f929z;

    public C0403b(Context context, RelativeLayout relativeLayout, Boolean bool, String str) {
        super(context);
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.f825p = SlotType.SLOT_TYPE_INTERSTITIAL;
        this.f925E = bool;
        this.f929z = AdSize.InterstitialGame;
        C0338m.m569a().mo5043p();
        this.f928y = new C0405d(getApplicationContext(), getActivity(), this.f825p, Boolean.valueOf(true));
        this.f928y.mo5181d(str);
        this.f928y.mo5177c(AdSize.InterstitialGame.getValue());
        mo5156c(str);
    }

    /* renamed from: c */
    private ViewGroup m847c(Context context) {
        return (ViewGroup) ((Activity) context).getWindow().getDecorView();
    }

    /* renamed from: a */
    public void mo5207a(int i, int i2) {
    }

    /* renamed from: a */
    public void mo5208a(Activity activity) {
        if (this.f921A && !this.f922B) {
            this.f922B = true;
            this.f921A = false;
            this.f923C = activity;
            start();
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            this.f814e.setBackgroundColor(0);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = rect.top;
            ViewGroup c = m847c((Context) activity);
            this.f924D = new RelativeLayout(activity);
            this.f924D.addView(this.f814e, layoutParams);
            c.addView(this.f924D, new RelativeLayout.LayoutParams(-1, -1));
            this.f814e.setFocusableInTouchMode(true);
            this.f814e.setFocusable(true);
            this.f814e.requestFocus();
        } else if (this.f922B) {
            this.f927x.mo4936w("interstitial ad is showing now");
        } else if (!this.f921A) {
            this.f927x.mo4936w("interstitial ad is not ready");
        }
    }

    /* renamed from: a */
    public void mo5209a(Activity activity, RelativeLayout relativeLayout) {
    }

    /* renamed from: a */
    protected void mo5145a(C0371d c0371d, C0426t c0426t, int i) {
        c0426t.mo5243a(c0371d, "{'ad':[{'id':99999999,'url':'" + this.f928y.mo5174b() + "', type='" + CreativeType.HTML.getValue() + "'}],'n':1}");
    }

    /* renamed from: c */
    public void mo5154c() {
    }

    /* renamed from: c */
    protected void mo5155c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        this.f921A = true;
        if (hashMap != null) {
            Object obj = hashMap.get("type");
            if (obj != null) {
                ((String) obj).equals("video");
            }
        }
    }

    /* renamed from: d */
    protected void mo5157d() {
        this.f823n = 8000;
    }

    /* renamed from: d */
    protected void mo5158d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    /* renamed from: e */
    protected void mo5160e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        mo5227o();
        this.f922B = false;
    }

    /* renamed from: m */
    public void mo5213m() {
        load();
    }

    /* renamed from: n */
    public C0378d getAdRequestInfo() {
        return this.f928y;
    }

    /* renamed from: o */
    public void mo5227o() {
        if (this.f923C != null) {
            this.f923C.runOnUiThread(new C0404c(this));
        }
    }

    /* renamed from: r */
    public boolean mo5214r() {
        return this.f921A;
    }

    public void request() {
        super.mo5149a(this.f928y);
    }

    public void start() {
        super.start();
    }
}
