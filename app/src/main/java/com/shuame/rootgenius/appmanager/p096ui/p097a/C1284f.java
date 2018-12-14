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
import com.shuame.rootgenius.appmanager.p095f.C1270a;
import com.shuame.rootgenius.appmanager.p095f.C1270a.C1268a;
import com.shuame.rootgenius.p089a.C1248a.C1245c;
import com.shuame.rootgenius.p089a.C1248a.C1246d;
import java.util.List;

/* renamed from: com.shuame.rootgenius.appmanager.ui.a.f */
public final class C1284f extends BaseAdapter implements OnClickListener {
    /* renamed from: a */
    public static final int f3458a = (C1246d.app_manager + 2);
    /* renamed from: b */
    public static final int f3459b = (C1246d.app_manager + 3);
    /* renamed from: c */
    private List<C1254a> f3460c;
    /* renamed from: d */
    private String f3461d;
    /* renamed from: e */
    private Context f3462e;

    /* renamed from: com.shuame.rootgenius.appmanager.ui.a.f$a */
    public class C1283a {
        /* renamed from: a */
        public ImageView f3453a;
        /* renamed from: b */
        public TextView f3454b;
        /* renamed from: c */
        public TextView f3455c;
        /* renamed from: d */
        public Button f3456d;
    }

    public C1284f(Context context, List<C1254a> list, String str) {
        this.f3462e = context;
        this.f3460c = list;
        this.f3461d = str;
    }

    /* renamed from: a */
    private C1254a m3622a(int i) {
        return (C1254a) this.f3460c.get(i);
    }

    public final int getCount() {
        return this.f3460c.size();
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C1283a c1283a;
        C1254a a = m3622a(i);
        if (view == null) {
            C1283a c1283a2 = new C1283a();
            view = ((Activity) this.f3462e).getLayoutInflater().inflate(C1246d.recyclebin_item_view, null);
            c1283a2.f3454b = (TextView) view.findViewById(C1245c.tv_appName);
            c1283a2.f3453a = (ImageView) view.findViewById(C1245c.iv_appIcon);
            c1283a2.f3455c = (TextView) view.findViewById(C1245c.tv_appSize);
            c1283a2.f3456d = (Button) view.findViewById(C1245c.btn_uninstall);
            view.setTag(f3458a, c1283a2);
            c1283a = c1283a2;
        } else {
            c1283a = (C1283a) view.getTag(f3458a);
        }
        c1283a.f3454b.setText(a.f3339c);
        c1283a.f3455c.setText(a.f3342f);
        c1283a.f3453a.setImageDrawable(a.f3338b);
        c1283a.f3456d.setOnClickListener(this);
        c1283a.f3456d.setTag(133173249, a);
        view.setTag(a.f3339c);
        return view;
    }

    public final void onClick(View view) {
        int id = view.getId();
        C1254a c1254a = (C1254a) view.getTag(133173249);
        if (!C1259d.f3365g.booleanValue() && System.currentTimeMillis() - C1259d.f3368j >= 100) {
            C1259d.f3365g = Boolean.valueOf(true);
            if (id == C1245c.btn_uninstall) {
                c1254a.f3341e = C1270a.m3606a(this.f3461d, c1254a.f3340d);
                C1259d.m3574q().mo6966a(C1259d.m3574q().findViewWithTag(c1254a.f3339c), c1254a, 300);
                new C1268a(this.f3462e, this.f3461d, c1254a).start();
            }
        }
    }
}
