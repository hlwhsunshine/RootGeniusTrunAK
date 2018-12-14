package com.shuame.rootgenius.appmanager.p096ui.p097a;

import android.os.Parcelable;
import android.support.p015v4.view.PagerAdapter;
import android.support.p015v4.view.ViewPager;
import android.view.View;
import java.util.List;

/* renamed from: com.shuame.rootgenius.appmanager.ui.a.a */
public final class C1274a extends PagerAdapter {
    /* renamed from: a */
    public List<View> f3415a;

    public C1274a(List<View> list) {
        this.f3415a = list;
    }

    public final void destroyItem(View view, int i, Object obj) {
        ((ViewPager) view).removeView((View) this.f3415a.get(i));
    }

    public final void finishUpdate(View view) {
    }

    public final int getCount() {
        return this.f3415a.size();
    }

    public final Object instantiateItem(View view, int i) {
        ((ViewPager) view).addView((View) this.f3415a.get(i), 0);
        return this.f3415a.get(i);
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public final void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public final Parcelable saveState() {
        return null;
    }

    public final void startUpdate(View view) {
    }
}
