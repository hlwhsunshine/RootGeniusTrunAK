package com.shuame.mobile.module.autoboot.p085ui;

import android.widget.ExpandableListView.OnGroupCollapseListener;

/* renamed from: com.shuame.mobile.module.autoboot.ui.d */
final class C1173d implements OnGroupCollapseListener {
    /* renamed from: a */
    final /* synthetic */ AutoBootManagerActivity f3120a;

    C1173d(AutoBootManagerActivity autoBootManagerActivity) {
        this.f3120a = autoBootManagerActivity;
    }

    public final void onGroupCollapse(int i) {
        this.f3120a.f3080b.expandGroup(i);
    }
}
