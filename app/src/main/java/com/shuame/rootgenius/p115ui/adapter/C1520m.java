package com.shuame.rootgenius.p115ui.adapter;

import android.support.p015v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/* renamed from: com.shuame.rootgenius.ui.adapter.m */
public final class C1520m extends PagerAdapter {
    /* renamed from: a */
    private List<View> f4322a;

    public C1520m(List<View> list) {
        this.f4322a = list;
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.f4322a != null) {
            View view = (View) this.f4322a.get(i);
            if (view != null) {
                viewGroup.removeView(view);
            }
        }
    }

    public final int getCount() {
        return this.f4322a != null ? this.f4322a.size() : 0;
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        Object obj = null;
        if (this.f4322a != null) {
            obj = (View) this.f4322a.get(i);
            if (obj != null) {
                viewGroup.addView(obj);
            }
        }
        return obj;
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
