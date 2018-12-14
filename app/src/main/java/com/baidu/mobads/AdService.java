package com.baidu.mobads;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.baidu.mobads.p021j.C0338m;

public class AdService {
    protected static String channelId = "";
    protected static int instanceCount = -1;
    /* renamed from: a */
    private AdView f301a;

    public AdService(Context context, ViewGroup viewGroup, LayoutParams layoutParams, AdViewListener adViewListener) {
        this(context, viewGroup, layoutParams, adViewListener, AdSize.Banner, "");
    }

    public AdService(Context context, ViewGroup viewGroup, LayoutParams layoutParams, AdViewListener adViewListener, AdSize adSize, String str) {
        if (context == null || viewGroup == null || layoutParams == null || adViewListener == null || adSize == null) {
            throw new IllegalArgumentException("One of arguments is null");
        }
        this.f301a = new AdView(context, false, adSize, str);
        this.f301a.setListener(adViewListener);
        m267a(viewGroup, layoutParams);
        instanceCount++;
    }

    /* renamed from: a */
    private void m267a(ViewGroup viewGroup, LayoutParams layoutParams) {
        try {
            if (this.f301a.getParent() != viewGroup) {
                if (this.f301a.getParent() != null) {
                    ((ViewGroup) this.f301a.getParent()).removeView(this.f301a);
                }
                viewGroup.addView(this.f301a, layoutParams);
            }
        } catch (Throwable e) {
            C0338m.m569a().mo5033f().mo4924d(e);
        }
    }

    public static void setChannelId(String str) {
        channelId = str;
        C0338m.m569a().mo5040m().setChannelId(str);
    }

    public void destroy() {
        if (this.f301a != null) {
            this.f301a.destroy();
            this.f301a = null;
        }
    }
}
