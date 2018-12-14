package com.shuame.rootgenius.p115ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.C1029c;
import com.nostra13.universalimageloader.core.C1029c.C1025a;
import com.nostra13.universalimageloader.core.C1033d;
import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.pojo.BbxCategoryInfo;
import java.util.ArrayList;

/* renamed from: com.shuame.rootgenius.ui.adapter.a */
public final class C1506a extends BaseAdapter {
    /* renamed from: a */
    private C1029c f4287a = new C1025a().mo6247a(true).mo6241a().mo6242a((int) C1450R.drawable.bbx_item_def_ico).mo6248b((int) C1450R.drawable.bbx_item_def_ico).mo6250c((int) C1450R.drawable.bbx_item_def_ico).mo6249b();
    /* renamed from: b */
    private ArrayList<BbxCategoryInfo> f4288b = new ArrayList();

    /* renamed from: com.shuame.rootgenius.ui.adapter.a$a */
    private class C1505a extends RelativeLayout {
        /* renamed from: a */
        public ImageView f4283a;
        /* renamed from: b */
        public ImageView f4284b;
        /* renamed from: c */
        public TextView f4285c;

        public C1505a(Context context) {
            super(context);
            View inflate = LayoutInflater.from(context).inflate(C1450R.layout.view_bbx_grid_item, this);
            this.f4283a = (ImageView) inflate.findViewById(C1450R.id.iv_remind);
            this.f4284b = (ImageView) inflate.findViewById(C1450R.id.iv_ico);
            this.f4285c = (TextView) inflate.findViewById(C1450R.id.tv_name);
        }
    }

    /* renamed from: a */
    public final BbxCategoryInfo mo7404a(int i) {
        return (BbxCategoryInfo) this.f4288b.get(i);
    }

    /* renamed from: a */
    public final void mo7405a(ArrayList<BbxCategoryInfo> arrayList) {
        if (arrayList == null) {
            this.f4288b.clear();
        } else {
            this.f4288b = arrayList;
        }
    }

    public final int getCount() {
        return this.f4288b.size();
    }

    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new C1505a(RootGeniusApp.m3523a());
        } else {
            C1505a c1505a = (C1505a) view;
        }
        BbxCategoryInfo bbxCategoryInfo = (BbxCategoryInfo) this.f4288b.get(i);
        if (bbxCategoryInfo == null || TextUtils.isEmpty(bbxCategoryInfo.displayName)) {
            view.setBackgroundResource(C1450R.drawable.bbx_item_bg_white);
            view.f4283a.setVisibility(4);
            view.f4285c.setVisibility(4);
            view.f4284b.setVisibility(4);
        } else {
            view.setBackgroundResource(C1450R.drawable.selector_bbx_item);
            view.f4285c.setText(bbxCategoryInfo.displayName);
            if ("shuame_mobile".equalsIgnoreCase(bbxCategoryInfo.name)) {
                view.f4284b.setImageResource(C1450R.drawable.bbx_item_shuaji);
                C1323b.m3688a().mo6993a("shuame_mobile", i);
            } else if ("huangeziti".equalsIgnoreCase(bbxCategoryInfo.name)) {
                view.f4284b.setImageResource(C1450R.drawable.bbx_item_ziti);
                C1323b.m3688a().mo6993a("huangeziti", i);
            } else if ("appuninstall".equalsIgnoreCase(bbxCategoryInfo.name)) {
                view.f4284b.setImageResource(C1450R.drawable.bbx_item_appuninstall);
                C1323b.m3688a().mo6993a("appuninstall", i);
            } else if ("autoboot".equalsIgnoreCase(bbxCategoryInfo.name)) {
                view.f4284b.setImageResource(C1450R.drawable.bbx_item_autoboot);
                C1323b.m3688a().mo6993a("autoboot", i);
            } else {
                C1033d.m2984a().mo6286a(bbxCategoryInfo.iconUrl, view.f4284b, this.f4287a, null);
            }
            if (bbxCategoryInfo.isRemind && C1323b.m3688a().mo6997b(bbxCategoryInfo.name + "_isRemind", true)) {
                view.f4283a.setVisibility(0);
            } else {
                view.f4283a.setVisibility(4);
            }
            view.f4285c.setVisibility(0);
            view.f4284b.setVisibility(0);
            view.setTag(bbxCategoryInfo.name);
            view.setTag(C1450R.string.auto_boot_item_note_back, Integer.valueOf(i));
        }
        return view;
    }
}
