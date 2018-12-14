package com.shuame.rootgenius.appmanager.p096ui.view;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.nineoldandroids.p054a.C0919aa;
import com.nineoldandroids.p054a.C0919aa.C0918b;

/* renamed from: com.shuame.rootgenius.appmanager.ui.view.f */
final class C1304f implements C0918b {
    /* renamed from: a */
    final /* synthetic */ LayoutParams f3554a;
    /* renamed from: b */
    final /* synthetic */ View f3555b;
    /* renamed from: c */
    final /* synthetic */ SwipeDismissListView f3556c;

    C1304f(SwipeDismissListView swipeDismissListView, LayoutParams layoutParams, View view) {
        this.f3556c = swipeDismissListView;
        this.f3554a = layoutParams;
        this.f3555b = view;
    }

    /* renamed from: a */
    public final void mo6032a(C0919aa c0919aa) {
        this.f3554a.height = ((Integer) c0919aa.mo6044g()).intValue();
        this.f3555b.setLayoutParams(this.f3554a);
    }
}
