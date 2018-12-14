package com.shuame.rootgenius.appmanager.p096ui.p097a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.shuame.rootgenius.appmanager.p091b.C1254a;
import com.shuame.rootgenius.appmanager.p091b.C1259d;
import com.shuame.rootgenius.appmanager.p095f.C1270a.C1269b;
import com.shuame.rootgenius.appmanager.p096ui.view.C1305g;
import com.shuame.rootgenius.p089a.C1248a.C1245c;
import com.shuame.rootgenius.p089a.C1248a.C1246d;
import java.util.List;

/* renamed from: com.shuame.rootgenius.appmanager.ui.a.b */
public final class C1276b extends BaseAdapter implements OnClickListener {
    /* renamed from: a */
    public static final int f3422a = (C1246d.app_manager + 2);
    /* renamed from: b */
    public static final int f3423b = (C1246d.app_manager + 3);
    /* renamed from: c */
    private List<C1254a> f3424c;
    /* renamed from: d */
    private String f3425d;
    /* renamed from: e */
    private Context f3426e;

    /* renamed from: com.shuame.rootgenius.appmanager.ui.a.b$a */
    public class C1275a {
        /* renamed from: a */
        public ImageView f3416a;
        /* renamed from: b */
        public TextView f3417b;
        /* renamed from: c */
        public TextView f3418c;
        /* renamed from: d */
        public Button f3419d;
        /* renamed from: e */
        public Button f3420e;
    }

    public C1276b(Context context, List<C1254a> list, String str) {
        this.f3426e = context;
        this.f3424c = list;
        this.f3425d = str;
    }

    /* renamed from: a */
    private C1254a m3614a(int i) {
        return (C1254a) this.f3424c.get(i);
    }

    public final int getCount() {
        return this.f3424c.size();
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C1275a c1275a;
        C1254a a = m3614a(i);
        if (view == null) {
            C1275a c1275a2 = new C1275a();
            view = ((Activity) this.f3426e).getLayoutInflater().inflate(C1246d.normal_item_view, null);
            c1275a2.f3417b = (TextView) view.findViewById(C1245c.tv_appName);
            c1275a2.f3416a = (ImageView) view.findViewById(C1245c.iv_appIcon);
            c1275a2.f3418c = (TextView) view.findViewById(C1245c.tv_appSize);
            c1275a2.f3419d = (Button) view.findViewById(C1245c.btn_uninstall);
            c1275a2.f3420e = (Button) view.findViewById(C1245c.btn_uninstall_confirm);
            view.setTag(f3422a, c1275a2);
            c1275a = c1275a2;
        } else {
            c1275a = (C1275a) view.getTag(f3422a);
        }
        c1275a.f3417b.setText(a.f3339c);
        c1275a.f3418c.setText(a.f3342f);
        c1275a.f3416a.setImageDrawable(a.f3338b);
        c1275a.f3419d.setOnClickListener(this);
        c1275a.f3419d.setTag(133173249, a);
        c1275a.f3420e.setOnClickListener(this);
        c1275a.f3420e.setTag(133173249, a);
        if (a.f3346j.booleanValue()) {
            c1275a.f3419d.setVisibility(8);
            c1275a.f3420e.setVisibility(0);
        } else {
            c1275a.f3419d.setVisibility(0);
            c1275a.f3420e.setVisibility(8);
        }
        view.setTag(a.f3339c);
        return view;
    }

    public final void onClick(View view) {
        int id = view.getId();
        C1254a c1254a = (C1254a) view.getTag(133173249);
        if (id == C1245c.btn_uninstall) {
            if (!C1259d.f3367i.booleanValue() && !C1259d.f3366h.booleanValue() && System.currentTimeMillis() - C1259d.f3370l >= 100) {
                C1259d.f3367i = Boolean.valueOf(true);
                c1254a.f3346j = Boolean.valueOf(true);
                if (C1259d.m3568k() != null) {
                    new C1305g(c1254a.f3339c, C1259d.m3568k()).mo6970a();
                    for (C1254a c1254a2 : C1259d.m3554a(this.f3426e).mo6909e()) {
                        if (c1254a2.f3346j.booleanValue() && !c1254a2.equals(c1254a)) {
                            c1254a2.f3346j = Boolean.valueOf(false);
                        }
                    }
                } else {
                    C1259d.f3364f = Boolean.valueOf(false);
                    C1259d.f3367i = Boolean.valueOf(false);
                }
                notifyDataSetChanged();
            }
        } else if (id == C1245c.btn_uninstall_confirm && !C1259d.f3366h.booleanValue()) {
            String str = c1254a.f3339c;
            C1259d.f3366h = Boolean.valueOf(true);
            C1259d.m3568k().mo6966a(C1259d.m3568k().findViewWithTag(str), c1254a, 250);
            new C1269b(this.f3426e, this.f3425d, c1254a, Boolean.valueOf(false)).start();
        }
    }
}
