package com.shuame.rootgenius.p115ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.shuame.rootgenius.C1446g;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.p087ui.view.C1379b;
import com.shuame.rootgenius.common.p102c.C1324a;
import com.shuame.rootgenius.common.util.C1416x;
import com.shuame.rootgenius.hook.C1450R;
import java.util.Properties;

/* renamed from: com.shuame.rootgenius.ui.SettingsActivity */
public class SettingsActivity extends Activity implements OnClickListener {
    /* renamed from: c */
    private static final String f4224c = SettingsActivity.class.getSimpleName();
    /* renamed from: a */
    Properties f4225a = new Properties();
    /* renamed from: b */
    C1324a f4226b = C1324a.m3722a(this);
    /* renamed from: d */
    private CheckBox f4227d;

    public void onClick(View view) {
        switch (view.getId()) {
            case C1450R.id.vitem_component_upgrade_remind:
                CheckBox checkBox = this.f4227d;
                C1446g.m4003a();
                checkBox.setChecked(!C1446g.m4014h());
                this.f4225a.clear();
                this.f4225a.setProperty("selected", C1323b.m3688a().mo6997b("allowable_auto_check_auth_component_update", true) ? "打开" : "关闭");
                C1324a.m3723a("Setting", this.f4225a);
                return;
            default:
                C1416x.m3936a((int) C1450R.string.string_function_developing);
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1450R.layout.activity_settings);
        new C1379b(findViewById(C1450R.id.v_titlebar), (Activity) this, (int) C1450R.string.more_settings).mo7105b();
        findViewById(C1450R.id.vitem_component_upgrade_remind).setOnClickListener(this);
        this.f4227d = (CheckBox) findViewById(C1450R.id.cb_upgrade_remind_switch);
        CheckBox checkBox = this.f4227d;
        C1446g.m4003a();
        checkBox.setChecked(C1446g.m4014h());
        this.f4227d.setOnCheckedChangeListener(new C1528af(this));
    }
}
