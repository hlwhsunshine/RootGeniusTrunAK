package com.baidu.mobads.production.p046f;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.support.p015v4.internal.view.SupportMenu;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
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

/* renamed from: com.baidu.mobads.production.f.b */
public class C0397b extends C0375a implements C0396a {
    /* renamed from: A */
    private CountDownTimer f905A;
    /* renamed from: B */
    private C0401f f906B;
    /* renamed from: C */
    private boolean f907C = false;
    /* renamed from: D */
    private boolean f908D = false;
    /* renamed from: E */
    private Activity f909E;
    /* renamed from: F */
    private Boolean f910F;
    /* renamed from: w */
    public final String f911w = "html5_intersitial";
    /* renamed from: x */
    protected final IXAdLogger f912x = C0338m.m569a().mo5033f();
    /* renamed from: y */
    private RelativeLayout f913y;
    /* renamed from: z */
    private TextView f914z;

    public C0397b(Context context, RelativeLayout relativeLayout, Boolean bool, AdSize adSize, String str) {
        super(context);
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.f825p = SlotType.SLOT_TYPE_INTERSTITIAL;
        this.f910F = bool;
        this.f906B = new C0401f(getApplicationContext(), getActivity(), this.f825p, Boolean.valueOf(true));
        this.f906B.mo5178c(SlotType.SLOT_TYPE_INTERSTITIAL.getValue());
        this.f906B.mo5177c(adSize.getValue());
        this.f906B.mo5181d(str);
        mo5156c(str);
    }

    /* renamed from: s */
    private boolean m820s() {
        return mo5217o();
    }

    /* renamed from: t */
    private View m821t() {
        if (this.f913y == null) {
            this.f913y = new RelativeLayout(this.f815f);
            this.f913y.setBackgroundColor(Color.argb(42, 0, 0, 0));
            this.f914z = new TextView(this.f815f);
            this.f914z.setTextColor(SupportMenu.CATEGORY_MASK);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.f913y.addView(this.f914z, layoutParams);
        }
        this.f905A = new C0400e(this, 6000, 1000).start();
        return this.f913y;
    }

    /* renamed from: u */
    private void m822u() {
        if (!(this.f913y == null || this.f913y.getParent() == null)) {
            ((ViewGroup) this.f913y.getParent()).removeView(this.f913y);
        }
        if (this.f905A != null) {
            this.f912x.mo4921d("cancel countDownTimer before it finished");
            try {
                this.f905A.cancel();
            } catch (Throwable e) {
                this.f912x.mo4924d(e);
            }
        }
    }

    /* renamed from: v */
    private RelativeLayout.LayoutParams m823v() {
        int screenDensity = (int) (20.0f * C0338m.m569a().mo5040m().getScreenDensity(this.f815f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(screenDensity, screenDensity);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        return layoutParams;
    }

    /* renamed from: a */
    public void mo5207a(int i, int i2) {
        if (!this.f907C && !this.f908D) {
            this.f906B.mo5171a(i);
            this.f906B.mo5175b(i2);
            load();
        }
    }

    /* renamed from: a */
    public void mo5208a(Activity activity) {
    }

    /* renamed from: a */
    public void mo5209a(Activity activity, RelativeLayout relativeLayout) {
        try {
            this.f912x.mo4921d("showInterstitialAdInit");
            if (this.f907C && !this.f908D) {
                this.f908D = true;
                this.f907C = false;
                this.f909E = activity;
                start();
                mo5219q();
                this.f814e.setBackgroundColor(0);
                View relativeLayout2 = new RelativeLayout(activity);
                relativeLayout2.setBackgroundColor(0);
                relativeLayout.addView(relativeLayout2, new RelativeLayout.LayoutParams(-1, -1));
                this.f814e.addView(this.f817h.getAdView(), new RelativeLayout.LayoutParams(-1, -1));
                relativeLayout2.addView(this.f814e, new RelativeLayout.LayoutParams(-1, -1));
                this.f817h.getAdView().setVisibility(4);
            } else if (this.f908D) {
                this.f912x.mo4936w("interstitial ad is showing now");
            } else if (!this.f907C) {
                this.f912x.mo4936w("interstitial ad is not ready");
            }
        } catch (Throwable e) {
            this.f912x.mo4924d(e);
        }
    }

    /* renamed from: a */
    protected void mo5145a(C0371d c0371d, C0426t c0426t, int i) {
        c0426t.mo5243a(c0371d, "{'ad':[{'id':99999999,'url':'" + this.f906B.mo5174b() + "', type='" + CreativeType.HTML.getValue() + "'}],'n':1}");
    }

    /* renamed from: a */
    public boolean mo5148a(int i, KeyEvent keyEvent) {
        return true;
    }

    /* renamed from: c */
    public void mo5154c() {
    }

    /* renamed from: c */
    protected void mo5155c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        this.f907C = true;
    }

    /* renamed from: d */
    protected void mo5157d() {
        this.f823n = 8000;
    }

    /* renamed from: d */
    protected void mo5158d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        mo5216n();
    }

    /* renamed from: e */
    protected void mo5160e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        mo5219q();
        this.f908D = false;
    }

    /* renamed from: m */
    public void mo5213m() {
    }

    /* renamed from: n */
    public void mo5216n() {
        new Handler(Looper.getMainLooper()).post(new C0398c(this));
    }

    /* renamed from: o */
    protected boolean mo5217o() {
        return AdSize.InterstitialForVideoBeforePlay.getValue() == this.f906B.getApt();
    }

    /* renamed from: p */
    public C0378d getAdRequestInfo() {
        return this.f906B;
    }

    /* renamed from: q */
    protected void mo5219q() {
        if (this.f909E != null) {
            this.f909E.runOnUiThread(new C0399d(this));
        }
    }

    /* renamed from: r */
    public boolean mo5214r() {
        return this.f907C;
    }

    public void request() {
        super.mo5149a(this.f906B);
    }

    public void start() {
        super.start();
    }
}
