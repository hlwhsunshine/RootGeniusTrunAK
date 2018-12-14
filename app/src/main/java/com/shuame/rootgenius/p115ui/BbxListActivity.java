package com.shuame.rootgenius.p115ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.shuame.rootgenius.common.event.C1337b;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.p087ui.view.C1379b;
import com.shuame.rootgenius.common.util.C1416x;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p115ui.adapter.C1509b;
import com.shuame.rootgenius.pojo.BbxCategoryInfo.Item;
import java.util.ArrayList;

/* renamed from: com.shuame.rootgenius.ui.BbxListActivity */
public class BbxListActivity extends Activity implements OnClickListener {
    /* renamed from: a */
    private String f4128a;
    /* renamed from: b */
    private ArrayList<Item> f4129b;
    /* renamed from: c */
    private ListView f4130c;
    /* renamed from: d */
    private C1509b f4131d;
    /* renamed from: e */
    private BroadcastReceiver f4132e = new C1553h(this);

    public void onClick(View view) {
        switch (view.getId()) {
            case C1450R.id.btn_back:
                finish();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1450R.layout.activity_bbx_list);
        this.f4128a = getIntent().getStringExtra("title");
        this.f4129b = (ArrayList) getIntent().getSerializableExtra("list");
        if (this.f4129b == null) {
            C1416x.m3937a("列表展示失败！");
            finish();
        }
        new C1379b(findViewById(C1450R.id.v_titlebar), (Activity) this, this.f4128a).mo7105b();
        this.f4130c = (ListView) findViewById(C1450R.id.lv_bbx);
        this.f4131d = new C1509b(this.f4130c);
        this.f4131d.mo7412a(this.f4129b);
        this.f4130c.setAdapter(this.f4131d);
        this.f4130c.setOnItemClickListener(new C1552g(this));
        registerReceiver(this.f4132e, new IntentFilter(C1340e.f3632c));
        this.f4131d.mo7411a();
    }

    protected void onDestroy() {
        unregisterReceiver(this.f4132e);
        this.f4131d.mo7413b();
        super.onDestroy();
    }

    protected void onStart() {
        super.onStart();
        C1337b.m3738a().mo7006b();
    }
}
