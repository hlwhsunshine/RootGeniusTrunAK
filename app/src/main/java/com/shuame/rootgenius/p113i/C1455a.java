package com.shuame.rootgenius.p113i;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.shuame.rootgenius.common.util.C1416x;
import com.shuame.rootgenius.hook.C1450R;
import com.shuame.rootgenius.p110g.C1440c;
import com.shuame.rootgenius.p115ui.homepage.RootRemoveIngFragment;
import com.shuame.rootgenius.p115ui.homepage.RootingFragment;
import com.shuame.rootgenius.p115ui.homepage.UpdatingAuthComponentFragment;

/* renamed from: com.shuame.rootgenius.i.a */
public final class C1455a {
    /* renamed from: a */
    private static long f3984a;

    /* renamed from: a */
    public static void m4024a(Context context, String str) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception e) {
            C1416x.m3936a((int) C1450R.string.string_no_browser);
        }
    }

    /* renamed from: a */
    public static boolean m4025a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - f3984a) < 500) {
            return true;
        }
        f3984a = currentTimeMillis;
        return false;
    }

    /* renamed from: a */
    public static boolean m4026a(boolean z) {
        if (RootingFragment.isRooting) {
            if (!z) {
                return true;
            }
            C1416x.m3936a((int) C1450R.string.string_busy_root_ing);
            return true;
        } else if (UpdatingAuthComponentFragment.isComponentUpdating) {
            if (!z) {
                return true;
            }
            C1416x.m3936a((int) C1450R.string.string_busy_update_su_ing);
            return true;
        } else if (RootRemoveIngFragment.isRootRemoveing) {
            if (!z) {
                return true;
            }
            C1416x.m3936a((int) C1450R.string.string_busy_root_remove_ing);
            return true;
        } else if (!C1440c.f3952b) {
            return false;
        } else {
            if (!z) {
                return true;
            }
            C1416x.m3936a((int) C1450R.string.string_busy_font_repalceing);
            return true;
        }
    }
}
