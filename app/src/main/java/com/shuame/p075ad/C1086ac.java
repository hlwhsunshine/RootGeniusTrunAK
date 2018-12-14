package com.shuame.p075ad;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.shuame.ad.ac */
final class C1086ac implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ C1121x f2914a;

    C1086ac(C1121x c1121x) {
        this.f2914a = c1121x;
    }

    public final void onClick(View view) {
        if (this.f2914a.f2967b != null && this.f2914a.f2967b.isMiniOs > 0) {
            C1121x.f3006f;
            if (this.f2914a.f2966a != null) {
                this.f2914a.f2966a.mo6687e(this.f2914a);
            }
        } else if (this.f2914a.f2967b != null && !TextUtils.isEmpty(this.f2914a.f2967b.jumpUrl)) {
            if (this.f2914a.f2966a != null) {
                this.f2914a.f2966a.mo6684b(this.f2914a);
            }
            String format = String.format(this.f2914a.f2967b.jumpUrl, new Object[0]);
            C1121x.f3006f;
            try {
                this.f2914a.f2968c.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(format)));
            } catch (ActivityNotFoundException e) {
                C1121x.f3006f;
            }
        }
    }
}
