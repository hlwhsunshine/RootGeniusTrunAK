package com.shuame.rootgenius.appmanager.p096ui.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.shuame.rootgenius.appmanager.p091b.C1254a;
import com.shuame.rootgenius.appmanager.p091b.C1259d;
import com.shuame.rootgenius.appmanager.p091b.C1259d.C1258b;
import com.shuame.rootgenius.appmanager.p095f.C1272b.C1271a;
import com.shuame.rootgenius.appmanager.p096ui.p097a.C1284f;
import com.shuame.rootgenius.appmanager.p096ui.view.SwipeDismissListView;
import com.shuame.rootgenius.common.util.C1391d;
import com.shuame.rootgenius.p089a.C1248a.C1243a;
import com.shuame.rootgenius.p089a.C1248a.C1245c;
import com.shuame.rootgenius.p089a.C1248a.C1246d;
import com.shuame.rootgenius.p089a.C1248a.C1247e;
import java.util.List;

/* renamed from: com.shuame.rootgenius.appmanager.ui.activity.RecycleBinActivity */
public class RecycleBinActivity extends Activity implements OnClickListener, C1258b {
    /* renamed from: a */
    Context f3498a = this;
    /* renamed from: b */
    private TextView f3499b;
    /* renamed from: c */
    private SwipeDismissListView f3500c;
    /* renamed from: d */
    private TextView f3501d;
    /* renamed from: e */
    private C1284f f3502e;
    /* renamed from: f */
    private List<C1254a> f3503f;
    /* renamed from: g */
    private C1259d f3504g;
    /* renamed from: h */
    private Button f3505h;
    /* renamed from: i */
    private ImageView f3506i;
    /* renamed from: j */
    private C1271a f3507j;
    /* renamed from: k */
    private C1254a f3508k;
    /* renamed from: l */
    private String f3509l;
    /* renamed from: m */
    private Handler f3510m = new C1294g(this);

    /* renamed from: a */
    public final void mo6895a() {
        this.f3502e.notifyDataSetChanged();
    }

    /* renamed from: b */
    public final Handler mo6953b() {
        return this.f3510m;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == C1245c.btn_clean_all) {
            if (!this.f3503f.isEmpty()) {
                C1391d.m3890a(this.f3498a, C1247e.recyclebin_dialog_title, C1247e.recyclebin_dialog_context, C1247e.recyclebin_dialog_cancel, C1247e.recyclebin_dialog_comfirm, C1243a.dialog_btn_cancel, C1243a.dialog_btn_confirm, null, new C1296i(this));
            }
        } else if (id == C1245c.iv_back) {
            finish();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1246d.recycle_bin);
        this.f3504g = C1259d.m3554a(this.f3498a);
        this.f3503f = this.f3504g.mo6910f();
        this.f3509l = C1259d.m3566i();
        this.f3499b = (TextView) findViewById(C1245c.tv_title);
        this.f3499b.setText("回收站");
        this.f3500c = (SwipeDismissListView) findViewById(C1245c.lv_recycle_list);
        C1259d.m3562c(this.f3500c);
        this.f3501d = (TextView) findViewById(C1245c.tv_recyclebin_empty);
        this.f3505h = (Button) findViewById(C1245c.btn_clean_all);
        this.f3505h.setOnClickListener(this);
        this.f3506i = (ImageView) findViewById(C1245c.iv_back);
        this.f3506i.setOnClickListener(this);
        this.f3502e = new C1284f(this, this.f3503f, this.f3509l);
        this.f3500c.setAdapter(this.f3502e);
        this.f3500c.setOnDismissCallback(new C1295h(this));
        if (this.f3503f.isEmpty()) {
            this.f3500c.setVisibility(8);
            this.f3501d.setVisibility(0);
        } else {
            this.f3500c.setVisibility(0);
            this.f3501d.setVisibility(8);
        }
        this.f3504g.mo6900a((C1258b) this);
    }

    protected void onDestroy() {
        super.onDestroy();
        C1259d.m3562c(null);
    }
}
