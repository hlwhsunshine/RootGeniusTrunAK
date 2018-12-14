package com.shuame.mobile.module.autoboot.p085ui.p086a;

import android.app.Activity;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.shuame.mobile.module.autoboot.C1151a;
import com.shuame.mobile.module.autoboot.p080a.C1148a;
import com.shuame.mobile.module.autoboot.p081b.C1155a;
import com.shuame.mobile.module.autoboot.p081b.C1155a.C1152a;
import com.shuame.mobile.module.autoboot.p083c.C1161a;
import com.shuame.mobile.module.autoboot.p083c.C1162b;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.p087ui.view.SlipSwitch;
import com.shuame.rootgenius.common.p087ui.view.SlipSwitch.C1166a;
import com.shuame.rootgenius.common.util.C1391d;
import com.shuame.rootgenius.p098b.C1312a.C1309c;
import com.shuame.rootgenius.p098b.C1312a.C1310d;
import com.shuame.rootgenius.p098b.C1312a.C1311e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.shuame.mobile.module.autoboot.ui.a.a */
public class C1167a extends BaseExpandableListAdapter implements OnChildClickListener, C1148a, C1166a {
    /* renamed from: a */
    private static final String f3102a = C1167a.class.getSimpleName();
    /* renamed from: b */
    private ArrayList<C1162b> f3103b;
    /* renamed from: c */
    private LayoutInflater f3104c;
    /* renamed from: d */
    private Activity f3105d;
    /* renamed from: e */
    private Handler f3106e = new Handler(Looper.getMainLooper());
    /* renamed from: f */
    private long f3107f;
    /* renamed from: g */
    private boolean f3108g;
    /* renamed from: h */
    private List<Long> f3109h = Collections.synchronizedList(new ArrayList());
    /* renamed from: i */
    private ExpandableListView f3110i;
    /* renamed from: j */
    private C1152a f3111j;

    /* renamed from: com.shuame.mobile.module.autoboot.ui.a.a$a */
    class C1165a {
        /* renamed from: a */
        ImageView f3097a;
        /* renamed from: b */
        TextView f3098b;
        /* renamed from: c */
        TextView f3099c;
        /* renamed from: d */
        SlipSwitch f3100d;

        C1165a() {
        }
    }

    public C1167a(Activity activity, ArrayList<C1162b> arrayList, C1152a c1152a, ExpandableListView expandableListView) {
        this.f3105d = activity;
        this.f3104c = LayoutInflater.from(activity);
        this.f3103b = arrayList;
        this.f3111j = c1152a;
        this.f3110i = expandableListView;
    }

    /* renamed from: a */
    static /* synthetic */ void m3361a() {
    }

    /* renamed from: a */
    private void m3362a(C1165a c1165a, C1161a c1161a) {
        Object obj = 1;
        Object obj2 = (c1161a.f3063k & C1161a.f3053a) != 0 ? 1 : null;
        if ((c1161a.f3063k & C1161a.f3054b) == 0) {
            obj = null;
        }
        int i = (obj2 == null || obj == null) ? obj2 != null ? C1311e.auto_boot_item_note_start : C1311e.auto_boot_item_note_back : C1311e.auto_boot_item_note_start_and_back;
        if (c1161a.f3065m) {
            c1165a.f3099c.setTextColor(Color.parseColor("#afafaf"));
        } else {
            c1165a.f3099c.setTextColor(Color.parseColor("#ff6e3c"));
        }
        c1165a.f3099c.setText(this.f3105d.getString(i));
    }

    /* renamed from: b */
    private void m3364b() {
        C1391d.m3892a(this.f3105d, new C1168b(this));
    }

    /* renamed from: a */
    public final void mo6778a(int i) {
        this.f3108g = false;
        if (!C1323b.m3698d()) {
            m3364b();
        } else if (C1323b.m3698d()) {
            C1151a.m3310a();
            this.f3107f = System.currentTimeMillis();
            C1155a.m3315a().mo6750a(this.f3107f);
            Iterator it = this.f3103b.iterator();
            while (it.hasNext()) {
                C1162b c1162b = (C1162b) it.next();
                if (c1162b.f3070a) {
                    for (C1161a c1161a : c1162b.f3072c) {
                        if (!c1161a.f3065m) {
                            c1161a.f3068p = this.f3107f;
                            c1161a.f3069q = true;
                            c1161a.f3065m = true;
                            C1155a.m3315a().mo6755a(c1161a, false);
                        }
                    }
                }
            }
            notifyDataSetChanged();
            Toast.makeText(this.f3105d, String.format(this.f3105d.getResources().getString(C1311e.onekeydisable_sucess), new Object[]{String.valueOf(i)}), 0).show();
        } else {
            m3364b();
        }
    }

    /* renamed from: a */
    public final void mo6777a(View view, boolean z) {
        boolean z2 = true;
        int intValue = ((Integer) view.getTag(C1309c.tag_data_group_id)).intValue();
        int intValue2 = ((Integer) view.getTag(C1309c.tag_data_child_id)).intValue();
        new StringBuilder("-------onSwitched-----group=").append(intValue).append(";  child=").append(intValue2).append(";  isSwitchOn=").append(z);
        C1161a c1161a = (C1161a) ((C1162b) this.f3103b.get(intValue)).f3072c.get(intValue2);
        View findViewWithTag = this.f3110i.findViewWithTag(c1161a.f3062j);
        C1165a c1165a = findViewWithTag != null ? (C1165a) findViewWithTag.getTag(C1309c.tag_data) : null;
        SlipSwitch slipSwitch;
        if (!C1323b.m3698d()) {
            m3364b();
            slipSwitch = c1165a.f3100d;
            if (z) {
                z2 = false;
            }
            slipSwitch.setCheckedWithoutSwitchListener(z2);
        } else if (C1323b.m3698d()) {
            c1161a.f3068p = System.currentTimeMillis();
            if (!z) {
                C1155a.m3315a().mo6750a(c1161a.f3068p);
            }
            if (z) {
                z2 = false;
            }
            c1161a.f3065m = z2;
            c1161a.f3069q = false;
            this.f3109h.add(Long.valueOf(c1161a.f3068p));
            C1155a.m3315a().mo6755a(c1161a, z);
            m3362a(c1165a, c1161a);
            C1151a.m3310a();
        } else {
            m3364b();
            slipSwitch = c1165a.f3100d;
            if (z) {
                z2 = false;
            }
            slipSwitch.setCheckedWithoutSwitchListener(z2);
        }
    }

    /* renamed from: a */
    public final void mo6744a(C1161a c1161a, boolean z) {
    }

    /* renamed from: a */
    public final void mo6745a(C1161a c1161a, boolean z, int i) {
        new StringBuilder("onEndSetEnabled: result=").append(i).append(";enabled=").append(z).append(" disable:").append(c1161a.f3065m);
        if (i == 1) {
            c1161a.f3065m = !c1161a.f3065m;
            this.f3106e.post(new C1169c(this, c1161a, i, z));
        }
        if (this.f3107f <= 0 || c1161a.f3068p != this.f3107f) {
            if (this.f3109h.contains(Long.valueOf(c1161a.f3068p))) {
                this.f3109h.remove(Long.valueOf(c1161a.f3068p));
            } else {
                new StringBuilder("onEndSetEnabled: result=").append(i).append(";enabled=").append(z).append(";not in mSingleSwitchTaskIdList, return");
            }
        } else if (this.f3108g) {
            new StringBuilder("onEndSetEnabled: result=").append(i).append(";enabled=").append(z).append(";mHasShowOneKeyDisableFailDialog, return");
        } else {
            this.f3108g = true;
        }
    }

    /* renamed from: a */
    public final void mo6779a(String str) {
        View findViewWithTag = this.f3110i.findViewWithTag(str);
        if (findViewWithTag != null) {
            C1165a c1165a = (C1165a) findViewWithTag.getTag(C1309c.tag_view_holder);
            if (c1165a != null) {
                c1165a.f3100d.setCheckedWithoutSwitchListener(!c1165a.f3100d.getSwitchState());
            }
        }
    }

    public Object getChild(int i, int i2) {
        return ((C1162b) this.f3103b.get(i)).f3072c.get(i2);
    }

    public long getChildId(int i, int i2) {
        return (long) i2;
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        C1165a c1165a;
        if (view == null) {
            c1165a = new C1165a();
            view = this.f3104c.inflate(C1310d.auto_boot_manager_list_item, null);
            c1165a.f3097a = (ImageView) view.findViewById(C1309c.icon);
            c1165a.f3098b = (TextView) view.findViewById(C1309c.name);
            c1165a.f3099c = (TextView) view.findViewById(C1309c.description);
            c1165a.f3100d = (SlipSwitch) view.findViewById(C1309c.slip_switch);
            view.setTag(C1309c.tag_data, c1165a);
        } else {
            c1165a = (C1165a) view.getTag(C1309c.tag_data);
        }
        C1161a c1161a = (C1161a) ((C1162b) this.f3103b.get(i)).f3072c.get(i2);
        c1165a.f3098b.setText(c1161a.f3060h);
        m3362a(c1165a, c1161a);
        c1165a.f3100d.setTag(C1309c.tag_data_group_id, Integer.valueOf(i));
        c1165a.f3100d.setTag(C1309c.tag_data_child_id, Integer.valueOf(i2));
        c1165a.f3097a.setImageDrawable(c1161a.f3061i);
        c1165a.f3100d.setCheckedWithoutSwitchListener(!c1161a.f3065m);
        c1165a.f3100d.setOnSwitchListener(this);
        view.setTag(c1161a.f3062j);
        return view;
    }

    public int getChildrenCount(int i) {
        return ((C1162b) this.f3103b.get(i)).f3072c.size();
    }

    public Object getGroup(int i) {
        return this.f3103b.get(i);
    }

    public int getGroupCount() {
        return this.f3103b.size();
    }

    public long getGroupId(int i) {
        return (long) i;
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f3104c.inflate(C1310d.group_item, null);
        }
        ((TextView) view.findViewById(C1309c.title)).setText(((C1162b) this.f3103b.get(i)).f3071b);
        return view;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        boolean z = true;
        C1165a c1165a = (C1165a) view.getTag(C1309c.tag_data);
        C1161a c1161a = (C1161a) ((C1162b) this.f3103b.get(i)).f3072c.get(i2);
        boolean switchState = c1165a.f3100d.getSwitchState();
        new StringBuilder("-------onChildClick-----group=").append(i).append(";  child=").append(i2);
        if (!C1323b.m3698d()) {
            m3364b();
        } else if (C1323b.m3698d()) {
            switchState = !switchState;
            c1165a.f3100d.setCheckedWithoutSwitchListener(switchState);
            if (switchState) {
                z = false;
            }
            c1161a.f3065m = z;
            c1161a.f3069q = false;
            c1161a.f3068p = System.currentTimeMillis();
            this.f3109h.add(Long.valueOf(c1161a.f3068p));
            C1155a.m3315a().mo6750a(c1161a.f3068p);
            C1155a.m3315a().mo6755a(c1161a, switchState);
            m3362a(c1165a, c1161a);
            C1151a.m3310a();
        } else {
            m3364b();
        }
        return false;
    }
}
