package com.shuame.rootgenius.p115ui.adapter;

import android.support.p015v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* renamed from: com.shuame.rootgenius.ui.adapter.l */
public final class C1519l extends PagerAdapter {
    /* renamed from: a */
    private ArrayList<View> f4321a;

    public C1519l(ArrayList<View> arrayList) {
        this.f4321a = arrayList;
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) this.f4321a.get(i));
    }

    public final void finishUpdate(ViewGroup viewGroup) {
        super.finishUpdate(viewGroup);
    }

    public final int getCount() {
        return this.f4321a.size();
    }

    public final int getItemPosition(Object obj) {
        return super.getItemPosition(obj);
    }

    public final CharSequence getPageTitle(int i) {
        return super.getPageTitle(i);
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView((View) this.f4321a.get(i));
        return this.f4321a.get(i);
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
