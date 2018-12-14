package com.shuame.rootgenius.appmanager.p090a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.shuame.rootgenius.appmanager.p091b.C1254a;
import com.shuame.rootgenius.appmanager.p091b.C1259d;
import com.shuame.rootgenius.appmanager.p095f.C1270a;
import com.shuame.rootgenius.appmanager.p095f.C1272b.C1271a;
import com.shuame.rootgenius.appmanager.p096ui.activity.AppUninstallActivity;
import com.shuame.rootgenius.common.p087ui.p106a.C1376b;

/* renamed from: com.shuame.rootgenius.appmanager.a.b */
public final class C1252b extends Thread {
    /* renamed from: a */
    private String f3329a;
    /* renamed from: b */
    private Handler f3330b;
    /* renamed from: c */
    private C1254a f3331c;
    /* renamed from: d */
    private C1271a f3332d;
    /* renamed from: e */
    private ImageView f3333e;
    /* renamed from: f */
    private C1376b f3334f;

    public C1252b(Context context, String str, ImageView imageView, C1376b c1376b) {
        this.f3329a = str;
        this.f3330b = ((AppUninstallActivity) context).mo6945b();
        this.f3333e = imageView;
        this.f3334f = c1376b;
    }

    public final void run() {
        super.run();
        while (true) {
            C1254a c1254a = (C1254a) C1259d.m3571n().poll();
            this.f3331c = c1254a;
            if (c1254a == null) {
                break;
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.f3332d = C1270a.m3604a(this.f3331c.f3340d, this.f3331c.f3341e, this.f3329a, this.f3331c.f3337a);
            Message obtainMessage = this.f3330b.obtainMessage();
            obtainMessage.what = 1;
            this.f3332d.f3409e = this.f3331c;
            this.f3332d.mo6918a(this.f3333e);
            this.f3332d.mo6919a(this.f3334f);
            obtainMessage.obj = this.f3332d;
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
            if (currentTimeMillis > 1500) {
                this.f3330b.sendMessage(obtainMessage);
            } else {
                this.f3330b.sendMessageDelayed(obtainMessage, 1500 - currentTimeMillis);
            }
        }
        if (this.f3332d.f3406b == 0) {
            C1259d.f3371m = true;
        } else {
            C1259d.f3371m = false;
        }
        C1259d.m3563c(Boolean.valueOf(false));
    }
}
