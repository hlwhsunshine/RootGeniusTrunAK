package com.shuame.rootgenius.p115ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.event.C1340e;
import com.shuame.rootgenius.common.p087ui.p106a.C1376b;
import com.shuame.rootgenius.common.p087ui.view.C1379b;
import com.shuame.rootgenius.common.p102c.C1324a;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p115ui.homepage.ScanFragment;
import java.util.Properties;

/* renamed from: com.shuame.rootgenius.ui.MoreActivity */
public class MoreActivity extends Activity implements OnClickListener {
    /* renamed from: a */
    Properties f4218a = new Properties();
    /* renamed from: b */
    C1324a f4219b = null;
    /* renamed from: c */
    private TextView f4220c;
    /* renamed from: d */
    private BroadcastReceiver f4221d = new C1500aa(this);
    /* renamed from: e */
    private C1376b f4222e;

    /* renamed from: a */
    public static Intent m4257a(Context context) {
        return new Intent(context, MoreActivity.class);
    }

    public void onClick(android.view.View r11) {
        /*
        r10 = this;
        r3 = 0;
        r4 = 1;
        r9 = 0;
        r0 = r11.getId();
        switch(r0) {
            case 2131427352: goto L_0x009a;
            case 2131427353: goto L_0x004b;
            case 2131427354: goto L_0x0017;
            case 2131427355: goto L_0x0043;
            case 2131427356: goto L_0x00ad;
            case 2131427357: goto L_0x00c7;
            case 2131427358: goto L_0x0140;
            default: goto L_0x000a;
        };
    L_0x000a:
        r0 = 2131493076; // 0x7f0c00d4 float:1.8609622E38 double:1.053097503E-314;
        com.shuame.rootgenius.common.util.C1416x.m3936a(r0);
    L_0x0010:
        r0 = r9;
    L_0x0011:
        if (r0 == 0) goto L_0x0016;
    L_0x0013:
        r10.startActivity(r0);
    L_0x0016:
        return;
    L_0x0017:
        r0 = new com.shuame.rootgenius.h.a;
        r0.<init>();
        r1 = new com.shuame.rootgenius.sdk.proto.ProtoData$ActExit;
        r1.<init>();
        r2 = com.shuame.rootgenius.sdk.CommUtils.getWifiMacAddr(r10);
        r1.mac = r2;
        r2 = 3;
        r1.code = r2;
        r0.mo7186a(r1);
        r0 = 2131492954; // 0x7f0c005a float:1.8609374E38 double:1.053097443E-314;
        r0 = r10.getString(r0);
        com.shuame.rootgenius.p113i.C1455a.m4024a(r10, r0);
        r0 = r10.f4218a;
        r0.clear();
        r0 = "RootWeibo";
        com.shuame.rootgenius.common.p102c.C1324a.m3723a(r0, r9);
        r0 = r9;
        goto L_0x0011;
    L_0x0043:
        r0 = new android.content.Intent;
        r1 = com.shuame.rootgenius.p115ui.FeedBackIndexActivity.class;
        r0.<init>(r10, r1);
        goto L_0x0011;
    L_0x004b:
        r0 = r10.f4218a;
        r0.clear();
        r0 = "RemoveROOT";
        com.shuame.rootgenius.common.p102c.C1324a.m3723a(r0, r9);
        r0 = com.shuame.rootgenius.common.C1323b.m3698d();
        if (r0 == 0) goto L_0x0010;
    L_0x005b:
        r0 = com.shuame.rootgenius.p113i.C1455a.m4026a(r4);
        if (r0 != 0) goto L_0x0010;
    L_0x0061:
        r0 = com.shuame.rootgenius.p115ui.homepage.ScanFragment.isScanChecking;
        if (r0 != 0) goto L_0x0010;
    L_0x0065:
        r0 = com.shuame.rootgenius.common.event.C1345i.m3749a();
        r0 = r0.mo7020b();
        if (r0 != 0) goto L_0x0091;
    L_0x006f:
        r1 = 2131492955; // 0x7f0c005b float:1.8609377E38 double:1.0530974434E-314;
        r2 = 2131493025; // 0x7f0c00a1 float:1.8609518E38 double:1.053097478E-314;
        r3 = 2131493023; // 0x7f0c009f float:1.8609514E38 double:1.053097477E-314;
        r4 = 2131493024; // 0x7f0c00a0 float:1.8609516E38 double:1.0530974775E-314;
        r5 = 2131361830; // 0x7f0a0026 float:1.8343423E38 double:1.053032659E-314;
        r6 = 2131361832; // 0x7f0a0028 float:1.8343427E38 double:1.05303266E-314;
        r7 = new com.shuame.rootgenius.ui.ab;
        r7.<init>(r10);
        r8 = new com.shuame.rootgenius.ui.ac;
        r8.<init>(r10);
        r0 = r10;
        com.shuame.rootgenius.common.util.C1391d.m3890a(r0, r1, r2, r3, r4, r5, r6, r7, r8);
        r0 = r9;
        goto L_0x0011;
    L_0x0091:
        r0 = 2131492943; // 0x7f0c004f float:1.8609352E38 double:1.0530974375E-314;
        com.shuame.rootgenius.common.util.C1416x.m3936a(r0);
        r0 = r9;
        goto L_0x0011;
    L_0x009a:
        r0 = new android.content.Intent;
        r1 = com.shuame.rootgenius.p115ui.JointPCActivity.class;
        r0.<init>(r10, r1);
        r1 = r10.f4218a;
        r1.clear();
        r1 = "ContactPC";
        com.shuame.rootgenius.common.p102c.C1324a.m3723a(r1, r9);
        goto L_0x0011;
    L_0x00ad:
        r0 = com.shuame.rootgenius.p113i.C1455a.m4026a(r4);
        if (r0 != 0) goto L_0x00ba;
    L_0x00b3:
        r0 = com.shuame.rootgenius.service.C1489g.m4151a();
        r0.mo7312a(r4);
    L_0x00ba:
        r0 = r10.f4218a;
        r0.clear();
        r0 = "CheckUPdate";
        com.shuame.rootgenius.common.p102c.C1324a.m3723a(r0, r9);
        r0 = r9;
        goto L_0x0011;
    L_0x00c7:
        r0 = r10.f4222e;
        if (r0 != 0) goto L_0x012e;
    L_0x00cb:
        r0 = new com.shuame.rootgenius.common.ui.a.b$a;
        r0.<init>();
        r1 = 2130903069; // 0x7f03001d float:1.7412946E38 double:1.052806001E-314;
        r0.f3818b = r1;
        r0.f3819c = r3;
        r1 = new com.shuame.rootgenius.common.ui.a.b;
        r1.<init>(r10, r0);
        r10.f4222e = r1;
        r0 = "v%s";
        r1 = new java.lang.Object[r4];
        r2 = com.shuame.rootgenius.sdk.CommUtils.getVersionName(r10);
        r1[r3] = r2;
        r1 = java.lang.String.format(r0, r1);
        r0 = r10.f4222e;
        r2 = r0.mo7091a();
        r0 = 2131427390; // 0x7f0b003e float:1.8476395E38 double:1.05306505E-314;
        r0 = r2.findViewById(r0);
        r3 = new com.shuame.rootgenius.ui.ad;
        r3.<init>(r10);
        r0.setOnClickListener(r3);
        r0 = 2131427433; // 0x7f0b0069 float:1.8476482E38 double:1.0530650712E-314;
        r0 = r2.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r0.setText(r1);
        r0 = 2131427434; // 0x7f0b006a float:1.8476484E38 double:1.0530650717E-314;
        r0 = r2.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r1 = r0.getPaint();
        r2 = 8;
        r1.setFlags(r2);
        r1 = r0.getPaint();
        r1.setAntiAlias(r4);
        r1 = new com.shuame.rootgenius.ui.ae;
        r1.<init>(r10);
        r0.setOnClickListener(r1);
    L_0x012e:
        r0 = r10.f4222e;
        r0.show();
        r0 = r10.f4218a;
        r0.clear();
        r0 = "AboutUs";
        com.shuame.rootgenius.common.p102c.C1324a.m3723a(r0, r9);
        r0 = r9;
        goto L_0x0011;
    L_0x0140:
        r0 = new android.content.Intent;
        r1 = com.shuame.rootgenius.p115ui.SettingsActivity.class;
        r0.<init>(r10, r1);
        r1 = r10.f4218a;
        r1.clear();
        r1 = "Setting";
        com.shuame.rootgenius.common.p102c.C1324a.m3723a(r1, r9);
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.rootgenius.ui.MoreActivity.onClick(android.view.View):void");
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1450R.layout.activity_more);
        this.f4219b = C1324a.m3722a(getApplicationContext());
        new C1379b(findViewById(C1450R.id.v_titlebar), (Activity) this, (int) C1450R.string.more_title).mo7105b();
        findViewById(C1450R.id.v_relevance_weibo).setOnClickListener(this);
        findViewById(C1450R.id.v_quick_feedback).setOnClickListener(this);
        findViewById(C1450R.id.v_joint_pc_root).setOnClickListener(this);
        findViewById(C1450R.id.v_check_update).setOnClickListener(this);
        findViewById(C1450R.id.v_about_me).setOnClickListener(this);
        findViewById(C1450R.id.v_settings).setOnClickListener(this);
        this.f4220c = (TextView) findViewById(C1450R.id.v_remove_root);
        this.f4220c.setOnClickListener(this);
        if (ScanFragment.isScanChecking || !C1323b.m3698d()) {
            this.f4220c.setTextColor(getResources().getColor(C1450R.color.textcolor_dark_gray));
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(C1340e.f3643n);
        intentFilter.addAction(C1340e.f3642m);
        intentFilter.addAction(C1340e.f3639j);
        intentFilter.addAction(C1340e.f3630a);
        registerReceiver(this.f4221d, intentFilter);
    }

    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.f4221d);
    }
}
