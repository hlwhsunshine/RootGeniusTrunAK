package com.baidu.mobads;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.production.p039a.C0376a;
import java.util.concurrent.atomic.AtomicBoolean;

public final class AdView extends RelativeLayout {
    protected static final String P_VERSION = "3.61";
    /* renamed from: a */
    IOAdEventListener f344a;
    /* renamed from: b */
    private AtomicBoolean f345b;
    /* renamed from: c */
    private C0376a f346c;
    /* renamed from: d */
    private AdViewListener f347d;

    public AdView(Context context) {
        super(context);
        this.f345b = new AtomicBoolean(false);
        this.f344a = new C0240a(this);
    }

    public AdView(Context context, AttributeSet attributeSet, boolean z, AdSize adSize, String str) {
        super(context, attributeSet);
        this.f345b = new AtomicBoolean(false);
        this.f344a = new C0240a(this);
        View c0259ao = new C0259ao(context);
        this.f346c = new C0376a(context, c0259ao, str, z);
        this.f346c.addEventListener(IXAdEvent.AD_LOADED, this.f344a);
        this.f346c.addEventListener(IXAdEvent.AD_ERROR, this.f344a);
        this.f346c.addEventListener(IXAdEvent.AD_STARTED, this.f344a);
        this.f346c.addEventListener("AdUserClick", this.f344a);
        this.f346c.addEventListener(IXAdEvent.AD_USER_CLOSE, this.f344a);
        c0259ao.mo4382a(new C0268c(this));
        addView(c0259ao, new LayoutParams(-1, -1));
    }

    public AdView(Context context, AdSize adSize, String str) {
        this(context, true, adSize, str);
    }

    public AdView(Context context, String str) {
        this(context, true, AdSize.Banner, str);
    }

    AdView(Context context, boolean z, AdSize adSize, String str) {
        this(context, null, z, adSize, str);
    }

    /* renamed from: a */
    private void m272a() {
        if (!this.f345b.get()) {
            this.f345b.set(true);
            this.f346c.request();
        }
    }

    @Deprecated
    public static void setAppSec(Context context, String str) {
    }

    public static void setAppSid(Context context, String str) {
        C0338m.m569a().mo5040m().setAppId(str);
    }

    public final void destroy() {
        this.f346c.mo5167l();
    }

    @Deprecated
    public final void setAlpha(float f) {
    }

    @Deprecated
    public final void setBackgroundColor(int i) {
    }

    public final void setLayoutParams(LayoutParams layoutParams) {
        C0338m.m569a().mo5033f().mo4925d("AdView.setLayoutParams=", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height), Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i3 = displayMetrics.widthPixels;
        int i4 = displayMetrics.heightPixels;
        float f = displayMetrics.density;
        C0338m.m569a().mo5033f().mo4925d("AdView.setLayoutParams", Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f));
        if (i <= 0) {
            i = Math.min(i3, i4);
        } else if (i > 0 && ((float) i) < 200.0f * f) {
            i = (int) (200.0f * f);
        }
        int min = i2 <= 0 ? (int) (((float) Math.min(i3, i4)) * 0.15f) : (i2 <= 0 || ((float) i2) >= 30.0f * f) ? i2 : (int) (30.0f * f);
        layoutParams.width = i;
        layoutParams.height = min;
        C0338m.m569a().mo5033f().mo4925d("AdView.setLayoutParams adapter", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        super.setLayoutParams(layoutParams);
    }

    public final void setListener(AdViewListener adViewListener) {
        this.f347d = adViewListener;
    }
}
