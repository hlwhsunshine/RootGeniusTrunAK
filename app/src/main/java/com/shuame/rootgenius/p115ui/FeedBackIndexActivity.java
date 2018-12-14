package com.shuame.rootgenius.p115ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.shuame.rootgenius.common.p087ui.view.C1379b;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p110g.C1435a;
import com.shuame.rootgenius.pojo.FeedBackBean;

/* renamed from: com.shuame.rootgenius.ui.FeedBackIndexActivity */
public class FeedBackIndexActivity extends Activity implements OnClickListener, OnItemClickListener {
    /* renamed from: a */
    private static final String f4152a = FeedBackIndexActivity.class.getSimpleName();
    /* renamed from: b */
    private C1435a f4153b;
    /* renamed from: c */
    private FeedBackBean f4154c;
    /* renamed from: d */
    private TextView f4155d;
    /* renamed from: e */
    private ListView f4156e;
    /* renamed from: f */
    private String[] f4157f;

    /* renamed from: a */
    private void m4215a(int i) {
        Intent intent = new Intent(this, FeedBackDetailActivity.class);
        intent.putExtra("selectedProbId", i);
        startActivityForResult(intent, 0);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i2) {
            case -1:
                finish();
                return;
            default:
                return;
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C1450R.id.feedback_have_suggestion_tv:
                m4215a(this.f4153b.mo7153a(this.f4154c, 0));
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1450R.layout.activity_feedback_index);
        this.f4153b = C1435a.m3973a((Context) this);
        this.f4154c = this.f4153b.mo7154a();
        this.f4157f = this.f4153b.mo7155a(this.f4154c);
        new C1379b(findViewById(C1450R.id.v_titlebar), (Activity) this, (int) C1450R.string.more_quick_feedback).mo7105b();
        this.f4155d = (TextView) findViewById(C1450R.id.feedback_have_suggestion_tv);
        this.f4155d.setOnClickListener(this);
        this.f4156e = (ListView) findViewById(C1450R.id.feedback_index_lv);
        this.f4156e.setOnItemClickListener(this);
        this.f4156e.setAdapter(new ArrayAdapter(this, C1450R.layout.view_feedback_index_item, this.f4157f));
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m4215a(this.f4153b.mo7153a(this.f4154c, i + 1));
    }
}
