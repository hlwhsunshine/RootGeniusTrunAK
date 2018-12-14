package com.baidu.mobads.openad.p024a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.baidu.mobads.openad.p020d.C0232b;

/* renamed from: com.baidu.mobads.openad.a.c */
public class C0352c extends C0262d {
    /* renamed from: a */
    private int f726a;
    /* renamed from: d */
    private C0351b f727d;
    /* renamed from: e */
    private IntentFilter f728e;

    public C0352c(Context context) {
        super(context);
    }

    /* renamed from: a */
    public void mo5062a() {
        if (this.f726a == 0) {
            if (this.f727d == null) {
                mo5063a(new C0351b(this));
            }
            this.f728e = new IntentFilter();
            this.f728e.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        this.f726a++;
        this.f435b.registerReceiver(this.f727d, this.f728e);
    }

    /* renamed from: a */
    public void mo5063a(BroadcastReceiver broadcastReceiver) {
        this.f727d = (C0351b) broadcastReceiver;
    }

    /* renamed from: b */
    public void mo5064b() {
        dispatchEvent(new C0232b("network_changed"));
    }
}
