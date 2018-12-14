package com.shuame.rootgenius.appmanager.p096ui.activity;

import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.shuame.rootgenius.appmanager.p091b.C1259d;
import com.shuame.rootgenius.appmanager.p095f.C1270a;
import com.shuame.rootgenius.appmanager.p095f.C1272b.C1271a;
import com.shuame.rootgenius.common.C1323b;

/* renamed from: com.shuame.rootgenius.appmanager.ui.activity.a */
final class C1287a extends Handler {
    /* renamed from: a */
    final /* synthetic */ AppUninstallActivity f3511a;

    C1287a(AppUninstallActivity appUninstallActivity) {
        this.f3511a = appUninstallActivity;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.f3511a.f3496y.mo7088b();
                this.f3511a.f3495x.setVisibility(8);
                this.f3511a.f3484m.setVisibility(0);
                this.f3511a.mo6946c();
                if (!C1323b.m3698d()) {
                    this.f3511a.f3497z.setVisibility(0);
                    this.f3511a.f3497z.setOnClickListener(new C1288b(this));
                    return;
                }
                return;
            case 1:
                this.f3511a.f3477f = (C1271a) message.obj;
                this.f3511a.f3467B = this.f3511a.f3477f.f3409e;
                if (this.f3511a.f3477f.f3406b != 0) {
                    Toast.makeText(this.f3511a.f3478g, "卸载应用\"" + this.f3511a.f3467B.f3339c + "\"失败", 0).show();
                    this.f3511a.f3479h = C1259d.m3554a(this.f3511a.f3478g);
                    this.f3511a.f3479h.mo6905b(this.f3511a.f3467B);
                    ((AppUninstallActivity) this.f3511a.f3478g).mo6947d();
                    this.f3511a.f3493v.notifyDataSetChanged();
                    return;
                }
                return;
            case 2:
                this.f3511a.f3477f = (C1271a) message.obj;
                this.f3511a.f3467B = this.f3511a.f3477f.f3409e;
                if (this.f3511a.f3477f.f3406b != 0) {
                    this.f3511a.f3479h = C1259d.m3554a(this.f3511a.f3478g);
                    this.f3511a.f3479h.mo6909e().add(this.f3511a.f3467B);
                    this.f3511a.f3467B.f3346j = Boolean.valueOf(false);
                    if (this.f3511a.f3473b.isEmpty()) {
                        this.f3511a.f3488q.setVisibility(8);
                        this.f3511a.f3471F.setVisibility(0);
                    } else {
                        this.f3511a.f3488q.setVisibility(0);
                        this.f3511a.f3471F.setVisibility(8);
                    }
                    this.f3511a.f3494w.notifyDataSetChanged();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                    intentFilter.addDataScheme("package");
                    this.f3511a.registerReceiver(this.f3511a.f3469D, intentFilter);
                    C1270a.m3608a(this.f3511a.f3478g, this.f3511a.f3477f.f3409e.f3337a);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
