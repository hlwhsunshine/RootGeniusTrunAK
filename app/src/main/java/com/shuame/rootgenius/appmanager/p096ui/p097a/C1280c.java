package com.shuame.rootgenius.appmanager.p096ui.p097a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.shuame.rootgenius.appmanager.C1253a;
import com.shuame.rootgenius.appmanager.p090a.C1252b;
import com.shuame.rootgenius.appmanager.p091b.C1254a;
import com.shuame.rootgenius.appmanager.p091b.C1259d;
import com.shuame.rootgenius.appmanager.p093c.C1263a;
import com.shuame.rootgenius.appmanager.p093c.C1264b;
import com.shuame.rootgenius.appmanager.p095f.C1270a;
import com.shuame.rootgenius.appmanager.p096ui.view.C1300b;
import com.shuame.rootgenius.appmanager.p096ui.view.C1305g;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.p087ui.p106a.C1376b;
import com.shuame.rootgenius.common.util.C1391d;
import com.shuame.rootgenius.p089a.C1248a.C1243a;
import com.shuame.rootgenius.p089a.C1248a.C1244b;
import com.shuame.rootgenius.p089a.C1248a.C1245c;
import com.shuame.rootgenius.p089a.C1248a.C1246d;
import com.shuame.rootgenius.p089a.C1248a.C1247e;
import java.util.List;

/* renamed from: com.shuame.rootgenius.appmanager.ui.a.c */
public final class C1280c extends BaseAdapter implements OnClickListener {
    /* renamed from: a */
    public static final int f3442a = (C1246d.app_manager + 2);
    /* renamed from: b */
    public static final int f3443b = (C1246d.app_manager + 3);
    /* renamed from: c */
    private List<C1254a> f3444c;
    /* renamed from: d */
    private String f3445d;
    /* renamed from: e */
    private Context f3446e;
    /* renamed from: f */
    private TextView f3447f = C1259d.m3569l();
    /* renamed from: g */
    private C1376b f3448g;
    /* renamed from: h */
    private ImageView f3449h;

    /* renamed from: com.shuame.rootgenius.appmanager.ui.a.c$a */
    public class C1277a {
        /* renamed from: a */
        public TextView f3427a;

        public C1277a(View view) {
            this.f3427a = (TextView) view.findViewById(C1245c.tv_display);
        }
    }

    /* renamed from: com.shuame.rootgenius.appmanager.ui.a.c$b */
    public class C1278b {
        /* renamed from: a */
        public ImageView f3429a;
        /* renamed from: b */
        public TextView f3430b;
        /* renamed from: c */
        public TextView f3431c;
        /* renamed from: d */
        public Button f3432d;

        public C1278b(View view) {
            this.f3430b = (TextView) view.findViewById(C1245c.tv_appName);
            this.f3429a = (ImageView) view.findViewById(C1245c.iv_appIcon);
            this.f3431c = (TextView) view.findViewById(C1245c.tv_appSize);
            this.f3432d = (Button) view.findViewById(C1245c.btn_uninstall);
        }
    }

    /* renamed from: com.shuame.rootgenius.appmanager.ui.a.c$c */
    public class C1279c {
        /* renamed from: a */
        public ImageView f3434a;
        /* renamed from: b */
        public TextView f3435b;
        /* renamed from: c */
        public TextView f3436c;
        /* renamed from: d */
        public Button f3437d;
        /* renamed from: e */
        public Button f3438e;
        /* renamed from: f */
        public ImageView f3439f;
        /* renamed from: g */
        public TextView f3440g;

        public C1279c(View view) {
            this.f3435b = (TextView) view.findViewById(C1245c.tv_appName);
            this.f3434a = (ImageView) view.findViewById(C1245c.iv_appIcon);
            this.f3436c = (TextView) view.findViewById(C1245c.tv_appSize);
            this.f3440g = (TextView) view.findViewById(C1245c.tv_appIntro);
            this.f3437d = (Button) view.findViewById(C1245c.btn_uninstall);
            this.f3438e = (Button) view.findViewById(C1245c.btn_uninstall_confirm);
            this.f3439f = (ImageView) view.findViewById(C1245c.iv_line);
        }
    }

    public C1280c(Context context, List<C1254a> list, String str) {
        this.f3444c = list;
        this.f3445d = str;
        this.f3446e = context;
    }

    /* renamed from: a */
    private C1254a m3616a(int i) {
        return (C1254a) this.f3444c.get(i);
    }

    /* renamed from: a */
    private void m3617a() {
        C1391d.m3890a(this.f3446e, C1247e.need_root_title, C1247e.root_dialog_context, C1247e.root_dialog_cancel, C1247e.root_dialog_do_it_rightnow, C1243a.dialog_btn_cancel, C1243a.dialog_btn_confirm_green, null, new C1281d(this));
    }

    /* renamed from: a */
    public static void m3618a(Context context, String str, C1254a c1254a) {
        C1259d.f3363e = Boolean.valueOf(true);
        View findViewWithTag = C1259d.m3567j().findViewWithTag(str);
        C1259d.m3567j().mo6966a(findViewWithTag, c1254a, 350);
        new C1300b(context, (ImageView) findViewWithTag.findViewById(C1245c.iv_appIcon), C1259d.m3573p()).mo6969a();
    }

    public final int getCount() {
        return this.f3444c.size();
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        return ((C1254a) this.f3444c.get(i)).f3345i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C1279c c1279c;
        C1277a c1277a;
        C1278b c1278b = null;
        C1254a a = m3616a(i);
        int itemViewType = getItemViewType(i);
        if (view != null) {
            switch (itemViewType) {
                case -1:
                    c1279c = null;
                    c1277a = null;
                    c1278b = (C1278b) view.getTag(f3442a);
                    break;
                case 1:
                    c1279c = (C1279c) view.getTag(f3442a);
                    c1277a = null;
                    break;
                case 2:
                    c1277a = (C1277a) view.getTag(f3442a);
                    c1279c = null;
                    break;
                default:
                    c1277a = null;
                    c1279c = null;
                    break;
            }
        }
        switch (itemViewType) {
            case -1:
                view = ((Activity) this.f3446e).getLayoutInflater().inflate(C1246d.sys_component_item_view, null);
                C1278b c1278b2 = new C1278b(view);
                view.setTag(f3442a, c1278b2);
                c1279c = null;
                C1278b c1278b3 = c1278b2;
                c1277a = null;
                c1278b = c1278b3;
                break;
            case 1:
                view = ((Activity) this.f3446e).getLayoutInflater().inflate(C1246d.preinstall_app_item_view, null);
                C1279c c1279c2 = new C1279c(view);
                view.setTag(f3442a, c1279c2);
                c1279c = c1279c2;
                c1277a = null;
                break;
            case 2:
                view = ((Activity) this.f3446e).getLayoutInflater().inflate(C1246d.display_sys_component_view, null);
                c1277a = new C1277a(view);
                view.setTag(f3442a, c1277a);
                c1279c = null;
                break;
            default:
                c1277a = null;
                c1279c = null;
                break;
        }
        switch (itemViewType) {
            case -1:
                c1278b.f3430b.setText(a.f3339c);
                c1278b.f3431c.setText(a.f3342f);
                c1278b.f3429a.setImageDrawable(a.f3338b);
                c1278b.f3432d.setOnClickListener(this);
                c1278b.f3432d.setTag(133173249, a);
                break;
            case 1:
                c1279c.f3435b.setText(a.f3339c);
                c1279c.f3436c.setText(a.f3342f);
                c1279c.f3434a.setImageDrawable(a.f3338b);
                c1279c.f3440g.setText(a.f3343g);
                c1279c.f3437d.setOnClickListener(this);
                c1279c.f3437d.setTag(133173249, a);
                c1279c.f3438e.setOnClickListener(this);
                c1279c.f3438e.setTag(133173249, a);
                if (!a.f3346j.booleanValue()) {
                    c1279c.f3437d.setVisibility(0);
                    c1279c.f3438e.setVisibility(8);
                    break;
                }
                c1279c.f3437d.setVisibility(8);
                c1279c.f3438e.setVisibility(0);
                break;
            case 2:
                c1277a.f3427a.setOnClickListener(this);
                break;
        }
        view.setTag(a.f3339c);
        return view;
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public final void onClick(View view) {
        int id = view.getId();
        C1254a c1254a = (C1254a) view.getTag(133173249);
        if (id == C1245c.btn_uninstall) {
            C1264b.m3595a();
            C1264b.m3596a(new C1263a(c1254a.f3337a, c1254a.f3344h));
            if (c1254a.f3345i == -1) {
                if (C1323b.m3698d()) {
                    C1391d.m3890a(this.f3446e, C1247e.sys_component_uninstall_dialog_title, C1247e.sys_component_uninstall_dialog_context, C1247e.sys_component_uninstall_dialog_cancel, C1247e.sys_component_uninstall_dialog_do_it, C1243a.dialog_btn_cancel, C1243a.dialog_btn_confirm, null, new C1282e(this, c1254a));
                } else {
                    m3617a();
                }
            } else if (!C1259d.f3363e.booleanValue() && !C1259d.f3364f.booleanValue() && System.currentTimeMillis() - C1259d.f3369k >= 250) {
                C1259d.f3364f = Boolean.valueOf(true);
                for (C1254a c1254a2 : C1259d.m3554a(this.f3446e).mo6911g()) {
                    c1254a2.f3346j = Boolean.valueOf(false);
                }
                c1254a.f3346j = Boolean.valueOf(true);
                if (C1259d.m3567j() != null) {
                    new C1305g(c1254a.f3339c, C1259d.m3567j()).mo6970a();
                } else {
                    C1259d.f3364f = Boolean.valueOf(false);
                    C1259d.f3367i = Boolean.valueOf(false);
                }
                notifyDataSetChanged();
            }
        } else if (id == C1245c.btn_uninstall_confirm) {
            if (C1259d.f3363e.booleanValue()) {
                return;
            }
            if (C1323b.m3698d()) {
                c1254a.f3341e = C1270a.m3606a(this.f3445d, c1254a.f3340d);
                C1280c.m3618a(this.f3446e, c1254a.f3339c, c1254a);
                C1259d.m3571n().offer(c1254a);
                if (!C1259d.m3572o().booleanValue()) {
                    C1259d.m3563c(Boolean.valueOf(true));
                    new C1252b(this.f3446e, this.f3445d, this.f3449h, this.f3448g).start();
                }
                C1253a.m3547b();
                return;
            }
            m3617a();
        } else if (id != C1245c.tv_display) {
        } else {
            LayoutParams layoutParams;
            if (((TextView) view).getText().equals("显示系统组件")) {
                layoutParams = (LayoutParams) this.f3447f.getLayoutParams();
                layoutParams.height = this.f3446e.getResources().getDimensionPixelSize(C1244b.system_app_none_notice_short);
                this.f3447f.setLayoutParams(layoutParams);
                this.f3444c.addAll(C1259d.m3554a(this.f3446e).mo6908d());
                ((TextView) view).setText("隐藏系统组件");
                C1259d.m3561b(Boolean.valueOf(true));
                notifyDataSetChanged();
                if (C1259d.m3554a(this.f3446e).mo6911g().size() > 2) {
                    C1259d.m3567j().setSelection(C1259d.m3554a(this.f3446e).mo6912h() - 1);
                    C1259d.m3567j().setSelected(true);
                }
            } else if (((TextView) view).getText().equals("隐藏系统组件")) {
                layoutParams = (LayoutParams) this.f3447f.getLayoutParams();
                layoutParams.height = this.f3446e.getResources().getDimensionPixelSize(C1244b.system_app_none_notice_long);
                this.f3447f.setLayoutParams(layoutParams);
                this.f3444c.removeAll(C1259d.m3554a(this.f3446e).mo6908d());
                ((TextView) view).setText("显示系统组件");
                C1259d.m3561b(Boolean.valueOf(false));
                notifyDataSetChanged();
                C1259d.m3567j().setSelection(0);
                C1259d.m3567j().setSelected(true);
            }
        }
    }
}
