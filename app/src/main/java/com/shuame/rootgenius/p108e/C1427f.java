package com.shuame.rootgenius.p108e;

import android.content.Intent;
import com.shuame.mobile.module.autoboot.p085ui.AutoBootManagerActivity;
import com.shuame.rootgenius.appmanager.p096ui.activity.AppUninstallActivity;
import com.shuame.rootgenius.common.event.ModuleEvent;
import com.shuame.rootgenius.p115ui.GuideActivity;
import com.shuame.rootgenius.p115ui.JointPCActivity;
import com.shuame.rootgenius.p115ui.MoreActivity;
import com.shuame.rootgenius.p115ui.homepage.HomepageActivity;

/* renamed from: com.shuame.rootgenius.e.f */
public class C1427f {
    /* renamed from: a */
    private static final String f3928a = C1427f.class.getSimpleName();
    /* renamed from: b */
    private static C1427f f3929b;

    private C1427f() {
    }

    /* renamed from: a */
    public static C1427f m3959a() {
        if (f3929b == null) {
            synchronized (C1427f.class) {
                f3929b = new C1427f();
            }
        }
        return f3929b;
    }

    public void onEvent(ModuleEvent moduleEvent) {
        switch (C1428g.f3930a[moduleEvent.f3606a.ordinal()]) {
            case 1:
                String string = moduleEvent.f3609d.getExtras().getString("EXTAR_ACTIVITY");
                Intent intent = null;
                if (!"LotteryActivity".equals(string)) {
                    if ("MoreActivity".equals(string)) {
                        intent = new Intent(moduleEvent.f3608c, MoreActivity.class);
                    } else if ("JointPCActivity".equals(string)) {
                        intent = new Intent(moduleEvent.f3608c, JointPCActivity.class);
                    } else if ("AppUninstallActivity".equals(string)) {
                        intent = new Intent(moduleEvent.f3608c, AppUninstallActivity.class);
                    } else if ("AutoBootManagerActivity".equals(string)) {
                        intent = new Intent(moduleEvent.f3608c, AutoBootManagerActivity.class);
                    } else if ("GuideActivity".equals(string)) {
                        intent = new Intent(moduleEvent.f3608c, GuideActivity.class);
                    } else if ("HomepageActivity".equals(string)) {
                        intent = new Intent(moduleEvent.f3608c, HomepageActivity.class);
                    } else {
                        new StringBuilder("do not deal with to startactivity:").append(string).append("; should add one else branche for ").append(string);
                    }
                }
                if (intent != null) {
                    intent.setFlags(moduleEvent.f3609d.getFlags());
                    intent.putExtras(moduleEvent.f3609d);
                    moduleEvent.f3608c.startActivity(intent);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
