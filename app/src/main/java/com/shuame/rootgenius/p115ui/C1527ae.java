package com.shuame.rootgenius.p115ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p111h.C1447a;
import com.shuame.rootgenius.p113i.C1455a;
import com.shuame.rootgenius.sdk.CommUtils;
import com.shuame.rootgenius.sdk.proto.ProtoData.ActExit;

/* renamed from: com.shuame.rootgenius.ui.ae */
final class C1527ae implements OnClickListener {
    /* renamed from: a */
    final /* synthetic */ MoreActivity f4344a;

    C1527ae(MoreActivity moreActivity) {
        this.f4344a = moreActivity;
    }

    public final void onClick(View view) {
        C1447a c1447a = new C1447a();
        ActExit actExit = new ActExit();
        actExit.mac = CommUtils.getWifiMacAddr(this.f4344a);
        actExit.code = 2;
        c1447a.mo7186a(actExit);
        C1455a.m4024a(this.f4344a, this.f4344a.getString(C1450R.string.about_dialog_text_4));
    }
}
