package com.shuame.rootgenius.common.p087ui.view;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.shuame.rootgenius.common.C1335e.C1330c;
import com.shuame.rootgenius.hook.C1450R;

/* renamed from: com.shuame.rootgenius.common.ui.view.b */
public final class C1379b {
    /* renamed from: a */
    private View f3845a = null;
    /* renamed from: b */
    private Activity f3846b;
    /* renamed from: c */
    private TextView f3847c;
    /* renamed from: d */
    private View f3848d;
    /* renamed from: e */
    private View f3849e;

    public C1379b(View view, Activity activity, int i) {
        m3844a(view, activity, activity.getString(i));
    }

    public C1379b(View view, Activity activity, String str) {
        m3844a(view, activity, str);
    }

    /* renamed from: a */
    private void m3844a(View view, Activity activity, String str) {
        this.f3845a = view;
        this.f3846b = activity;
        this.f3848d = this.f3845a.findViewById(C1330c.btn_back);
        if (!(activity == null || this.f3848d == null)) {
            this.f3848d.setOnClickListener(new C1380c(this));
        }
        this.f3849e = this.f3845a.findViewById(C1330c.btn_more);
        if (!(activity == null || this.f3849e == null)) {
            this.f3849e.setOnClickListener(new C1381d(this));
        }
        this.f3847c = (TextView) this.f3845a.findViewById(C1330c.tv_title);
        this.f3847c.setText(str);
    }

    /* renamed from: a */
    public final void mo7104a() {
        if (this.f3848d != null) {
            this.f3848d.setVisibility(4);
        }
    }

    /* renamed from: b */
    public final void mo7105b() {
        if (this.f3849e != null) {
            this.f3849e.setVisibility(4);
        }
    }

    /* renamed from: c */
    public final void mo7106c() {
        this.f3847c.setText(C1450R.string.optimize_title);
    }
}
