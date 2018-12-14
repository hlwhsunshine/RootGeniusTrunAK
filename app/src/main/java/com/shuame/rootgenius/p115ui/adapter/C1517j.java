package com.shuame.rootgenius.p115ui.adapter;

import android.graphics.Typeface;
import android.widget.TextView;
import com.example.myfontsdk.C0459q;

/* renamed from: com.shuame.rootgenius.ui.adapter.j */
final class C1517j implements C0459q {
    /* renamed from: a */
    final /* synthetic */ TextView f4318a;
    /* renamed from: b */
    final /* synthetic */ FontListAdapter f4319b;

    C1517j(FontListAdapter fontListAdapter, TextView textView) {
        this.f4319b = fontListAdapter;
        this.f4318a = textView;
    }

    /* renamed from: a */
    public final void mo5359a(Typeface typeface) {
        this.f4318a.setTypeface(typeface);
    }
}
