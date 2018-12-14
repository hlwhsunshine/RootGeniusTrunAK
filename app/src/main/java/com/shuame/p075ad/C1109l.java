package com.shuame.p075ad;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.mobads.SplashAdListener;

/* renamed from: com.shuame.ad.l */
final class C1109l implements SplashAdListener {
    /* renamed from: a */
    final /* synthetic */ C1108k f2981a;

    C1109l(C1108k c1108k) {
        this.f2981a = c1108k;
    }

    public final void onAdClick() {
        if (this.f2981a.f2966a != null) {
            this.f2981a.f2966a.mo6684b(this.f2981a);
        }
    }

    public final void onAdDismissed() {
        if (this.f2981a.f2966a != null) {
            this.f2981a.f2966a.mo6686d(this.f2981a);
        }
    }

    public final void onAdFailed(String str) {
        if (this.f2981a.f2966a != null) {
            this.f2981a.f2966a.mo6683a(this.f2981a, str);
        }
    }

    public final void onAdPresent() {
        if (this.f2981a.f2966a != null) {
            this.f2981a.f2966a.mo6682a(this.f2981a);
            try {
                RelativeLayout relativeLayout = (RelativeLayout) this.f2981a.f2978h.getChildAt(0);
                if (relativeLayout.getChildCount() > 0) {
                    ImageView imageView = (ImageView) relativeLayout.getChildAt(0);
                    if (imageView != null) {
                        imageView.setAdjustViewBounds(true);
                        imageView.setScaleType(ScaleType.CENTER_CROP);
                        imageView.setLayoutParams(new LayoutParams(-1, -1));
                    }
                    TextView textView = (TextView) relativeLayout.getChildAt(1);
                    ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
                    layoutParams.addRule(12);
                    layoutParams.addRule(11);
                    textView.setLayoutParams(layoutParams);
                }
            } catch (Exception e) {
                C1108k.f2976f;
            }
        }
    }
}
