package com.shuame.rootgenius.p110g;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.p115ui.dialog.C1549b;

/* renamed from: com.shuame.rootgenius.g.f */
final class C1443f implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ Context f3968a;
    /* renamed from: b */
    final /* synthetic */ C1549b f3969b;
    /* renamed from: c */
    final /* synthetic */ C1440c f3970c;

    C1443f(C1440c c1440c, Context context, C1549b c1549b) {
        this.f3970c = c1440c;
        this.f3968a = context;
        this.f3969b = c1549b;
    }

    public final void onClick(View view) {
        Intent intent = new Intent("android.settings.SETTINGS");
        intent.addFlags(268435456);
        this.f3968a.startActivity(intent);
        this.f3969b.dismiss();
    }
}
