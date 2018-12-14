package com.shuame.rootgenius.p110g;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.p115ui.dialog.C1549b;

/* renamed from: com.shuame.rootgenius.g.g */
final class C1444g implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ Context f3971a;
    /* renamed from: b */
    final /* synthetic */ C1549b f3972b;
    /* renamed from: c */
    final /* synthetic */ C1440c f3973c;

    C1444g(C1440c c1440c, Context context, C1549b c1549b) {
        this.f3973c = c1440c;
        this.f3971a = context;
        this.f3972b = c1549b;
    }

    public final void onClick(View view) {
        Intent intent = new Intent("android.settings.SETTINGS");
        intent.addFlags(268435456);
        this.f3971a.startActivity(intent);
        this.f3972b.dismiss();
    }
}
