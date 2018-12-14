package com.baidu.mobads.production.p044e;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.p037e.C0371d;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.p040vo.C0378d;
import com.baidu.mobads.production.C0375a;
import com.baidu.mobads.production.C0426t;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.production.e.b */
public class C0391b extends C0375a {
    /* renamed from: A */
    private boolean f879A = true;
    /* renamed from: B */
    private double f880B = 0.5d;
    /* renamed from: C */
    private int f881C = 0;
    /* renamed from: D */
    private int f882D = 0;
    /* renamed from: E */
    private int f883E = 0;
    /* renamed from: F */
    private ViewGroup f884F;
    /* renamed from: G */
    private RelativeLayout f885G;
    /* renamed from: w */
    protected final IXAdLogger f886w = C0338m.m569a().mo5033f();
    /* renamed from: x */
    IXAdCommonUtils f887x;
    /* renamed from: y */
    private C0389a f888y;
    /* renamed from: z */
    private RelativeLayout f889z;

    /* renamed from: com.baidu.mobads.production.e.b$a */
    static class C0390a {
        /* renamed from: a */
        Activity f875a;
        /* renamed from: b */
        View f876b;
        /* renamed from: c */
        int f877c;
        /* renamed from: d */
        int f878d;

        C0390a() {
        }
    }

    public C0391b(Activity activity, String str, boolean z, double d) {
        super(activity, str, SlotType.SLOT_TYPE_FRONTLINK);
        setActivity(activity);
        this.f887x = C0338m.m569a().mo5040m();
        this.f881C = this.f887x.getPixel(activity, 80);
        this.f882D = this.f887x.getPixel(activity, 80);
        this.f883E = this.f887x.getStatusBarHeight(activity);
        this.f880B = d;
        this.f879A = z;
        this.f888y = new C0389a(getApplicationContext());
        this.f888y.mo5181d(str);
        getAdRequestInfo().mo5171a(this.f882D);
        getAdRequestInfo().mo5175b(this.f881C);
        m791a(activity);
        request();
    }

    /* renamed from: a */
    private void m791a(Activity activity) {
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f882D, this.f881C);
        if (this.f879A) {
            layoutParams.addRule(9);
        } else {
            layoutParams.addRule(11);
        }
        int height = this.f887x.getScreenRect(activity).height();
        int i = (int) (((double) height) * this.f880B);
        height = (height - this.f881C) - this.f883E;
        if (i <= height) {
            height = i;
        }
        layoutParams.topMargin = height;
        this.f885G = new RelativeLayout(activity);
        this.f889z = new RelativeLayout(activity);
        this.f889z.setBackgroundColor(0);
        setAdSlotBase(this.f889z);
        this.f885G.addView(this.f889z, layoutParams);
        this.f885G.setBackgroundColor(0);
        this.f884F = (ViewGroup) activity.getWindow().getDecorView();
        this.f884F.addView(this.f885G, new LayoutParams(-1, -1));
    }

    /* renamed from: a */
    protected void mo5145a(C0371d c0371d, C0426t c0426t, int i) {
        c0426t.mo5117a(c0371d, (double) i);
    }

    /* renamed from: a */
    void mo5202a(C0390a c0390a) {
        Context context = c0390a.f875a;
        View view = this.f889z;
        IXAdCommonUtils m = C0338m.m569a().mo5040m();
        Rect screenRect = m.getScreenRect(context);
        this.f817h.getAdView().setOnTouchListener(new C0392c(this, screenRect.width(), screenRect.height(), view, m.getPixel(context, c0390a.f877c), m.getPixel(context, c0390a.f878d)));
    }

    /* renamed from: c */
    public void mo5154c() {
        if (this.f817h != null) {
            this.f817h.load();
        } else {
            this.f886w.mo4926e("container is null");
        }
    }

    /* renamed from: c */
    protected void mo5155c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        start();
    }

    /* renamed from: d */
    protected void mo5157d() {
        this.f823n = 4200;
    }

    /* renamed from: d */
    protected void mo5158d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        View adView = iXAdContainer.getAdView();
        C0390a c0390a = new C0390a();
        c0390a.f876b = adView;
        c0390a.f875a = getActivity();
        c0390a.f878d = 80;
        c0390a.f877c = 80;
        mo5202a(c0390a);
    }

    /* renamed from: e */
    protected void mo5160e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        super.mo5160e(iXAdContainer, hashMap);
        if (this.f884F != null && this.f885G != null) {
            this.f884F.removeView(this.f885G);
            this.f884F = null;
            this.f885G = null;
            mo5167l();
        }
    }

    /* renamed from: l */
    public void mo5167l() {
        if (this.f884F != null && this.f885G != null) {
            this.f884F.removeView(this.f885G);
            this.f884F = null;
            this.f885G = null;
            super.mo5167l();
        }
    }

    /* renamed from: m */
    public C0378d getAdRequestInfo() {
        return this.f888y;
    }

    public void request() {
        mo5149a(this.f888y);
    }
}
