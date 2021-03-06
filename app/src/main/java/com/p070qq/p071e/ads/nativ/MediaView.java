package com.p070qq.p071e.ads.nativ;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.p070qq.p071e.comm.util.GDTLogger;

/* renamed from: com.qq.e.ads.nativ.MediaView */
public final class MediaView extends FrameLayout {
    public MediaView(Context context) {
        super(context);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @SuppressLint({"NewApi"})
    protected final void onAttachedToWindow() {
        GDTLogger.m3130d("onAttachedToWindow");
        super.onAttachedToWindow();
        if (VERSION.SDK_INT >= 11 && !isHardwareAccelerated()) {
            GDTLogger.m3131e("Hardware acceleration is off");
        }
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
