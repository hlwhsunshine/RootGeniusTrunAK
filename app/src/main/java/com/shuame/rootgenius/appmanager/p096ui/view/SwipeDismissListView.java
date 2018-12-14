package com.shuame.rootgenius.appmanager.p096ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.nineoldandroids.p054a.C0919aa;
import com.nineoldandroids.p055b.C0958a;
import com.shuame.rootgenius.appmanager.p091b.C1254a;
import com.shuame.rootgenius.p089a.C1248a.C1246d;

/* renamed from: com.shuame.rootgenius.appmanager.ui.view.SwipeDismissListView */
public class SwipeDismissListView extends ListView {
    /* renamed from: a */
    public static final int f3529a = (C1246d.app_manager + 3);
    /* renamed from: b */
    private View f3530b;
    /* renamed from: c */
    private int f3531c;
    /* renamed from: d */
    private C1291a f3532d;

    /* renamed from: com.shuame.rootgenius.appmanager.ui.view.SwipeDismissListView$a */
    public interface C1291a {
        /* renamed from: a */
        void mo6961a(C1254a c1254a);
    }

    public SwipeDismissListView(Context context) {
        super(context);
    }

    public SwipeDismissListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeDismissListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    static /* synthetic */ void m3666a(SwipeDismissListView swipeDismissListView, View view, C1254a c1254a, long j) {
        LayoutParams layoutParams = view.getLayoutParams();
        C0919aa a = C0919aa.m2520b(view.getHeight(), 0).mo6033a(j);
        a.mo6026a();
        a.mo6027a(new C1303e(swipeDismissListView, view, r1, c1254a));
        a.mo6036a(new C1304f(swipeDismissListView, layoutParams, view));
    }

    /* renamed from: a */
    public final void mo6966a(View view, C1254a c1254a, long j) {
        this.f3530b = view;
        if (this.f3530b != null) {
            this.f3531c = this.f3530b.getWidth();
            C0958a.m2689a(this.f3530b).mo6113a((float) (-this.f3531c)).mo6112a().mo6114a(j).mo6115a(new C1302d(this, c1254a, j));
        }
    }

    public void setOnDismissCallback(C1291a c1291a) {
        this.f3532d = c1291a;
    }
}
