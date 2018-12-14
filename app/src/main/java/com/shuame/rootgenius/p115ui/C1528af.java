package com.shuame.rootgenius.p115ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.shuame.rootgenius.C1446g;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.p102c.C1324a;

/* renamed from: com.shuame.rootgenius.ui.af */
final class C1528af implements OnCheckedChangeListener {
    /* renamed from: a */
    final /* synthetic */ SettingsActivity f4345a;

    C1528af(SettingsActivity settingsActivity) {
        this.f4345a = settingsActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        SettingsActivity.f4224c;
        C1446g.m4003a();
        C1446g.m4007b(z);
        this.f4345a.f4225a.clear();
        this.f4345a.f4225a.setProperty("selected", C1323b.m3688a().mo6997b("allowable_auto_check_auth_component_update", true) ? "打开" : "关闭");
        C1324a c1324a = this.f4345a.f4226b;
        C1324a.m3723a("Setting", this.f4345a.f4225a);
    }
}
