package com.example.myfontsdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    /* renamed from: a */
    Button f1181a;
    /* renamed from: b */
    Button f1182b;
    /* renamed from: c */
    Button f1183c;
    /* renamed from: d */
    TextView f1184d;
    /* renamed from: e */
    TextView f1185e;
    /* renamed from: f */
    TextView f1186f;
    /* renamed from: g */
    Handler f1187g = new C0455l(this, Looper.getMainLooper());

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        C0446c.m980a(new C0456m(this), (Context) this);
        this.f1181a = (Button) findViewById(R.id.btn_jdqpt);
        this.f1182b = (Button) findViewById(R.id.btn_qst);
        this.f1183c = (Button) findViewById(R.id.btn_sjwct);
        this.f1184d = (TextView) findViewById(R.id.tv_jdqpt);
        this.f1185e = (TextView) findViewById(R.id.tv_qst);
        this.f1186f = (TextView) findViewById(R.id.tv_sjwct);
        List arrayList = new ArrayList();
        new C0457n(this).start();
        this.f1181a.setOnClickListener(new C0458o(this, arrayList));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
