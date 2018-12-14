package com.shuame.rootgenius.appmanager.p096ui.view;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.nineoldandroids.p054a.C0916a;
import com.nineoldandroids.p054a.C0925b;
import com.nineoldandroids.p055b.p056a.C0957a;
import com.shuame.rootgenius.appmanager.p091b.C1254a;

/* renamed from: com.shuame.rootgenius.appmanager.ui.view.e */
final class C1303e extends C0925b {
    /* renamed from: a */
    final /* synthetic */ View f3550a;
    /* renamed from: b */
    final /* synthetic */ int f3551b;
    /* renamed from: c */
    final /* synthetic */ C1254a f3552c;
    /* renamed from: d */
    final /* synthetic */ SwipeDismissListView f3553d;

    C1303e(SwipeDismissListView swipeDismissListView, View view, int i, C1254a c1254a) {
        this.f3553d = swipeDismissListView;
        this.f3550a = view;
        this.f3551b = i;
        this.f3552c = c1254a;
    }

    /* renamed from: b */
    public final void mo6023b(C0916a c0916a) {
        View view = this.f3550a;
        if (C0957a.f2354a) {
            C0957a.m2656a(view).mo6084a(1.0f);
        } else {
            view.setAlpha(1.0f);
        }
        view = this.f3550a;
        if (C0957a.f2354a) {
            C0957a.m2656a(view).mo6103i(0.0f);
        } else {
            view.setTranslationX(0.0f);
        }
        LayoutParams layoutParams = this.f3550a.getLayoutParams();
        layoutParams.height = this.f3551b;
        this.f3550a.setLayoutParams(layoutParams);
        this.f3550a.setTag(SwipeDismissListView.f3529a, "removed");
        if (this.f3553d.f3532d != null) {
            this.f3553d.f3532d.mo6961a(this.f3552c);
        }
    }
}
