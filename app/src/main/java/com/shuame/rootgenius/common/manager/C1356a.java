package com.shuame.rootgenius.common.manager;

import com.shuame.rootgenius.common.manager.AppManager.ApkType;
import com.shuame.rootgenius.common.manager.AppManager.C1318c;
import com.shuame.rootgenius.common.manager.AppManager.C1348b;

/* renamed from: com.shuame.rootgenius.common.manager.a */
final class C1356a implements C1318c {
    /* renamed from: a */
    final /* synthetic */ AppManager f3712a;

    C1356a(AppManager appManager) {
        this.f3712a = appManager;
    }

    public final void onStatusChanged(C1348b c1348b) {
        AppManager.f3687e;
        new StringBuilder("-----onStatusChanged-----").append(c1348b.f3679d).append("; type:").append(c1348b.f3680e).append(";  apkTpe:").append(c1348b.f3683h);
        if (c1348b.f3683h == ApkType.APP) {
            switch (C1357b.f3713a[c1348b.f3679d.ordinal()]) {
                case 1:
                    AppManager.m3774a(this.f3712a, c1348b);
                    AppManager.m3772a(c1348b);
                    break;
                case 2:
                    AppManager.m3774a(this.f3712a, c1348b);
                    break;
                case 4:
                    AppManager.m3773a(c1348b, false);
                    break;
                case 5:
                    this.f3712a.f3690b.put(Integer.valueOf(c1348b.f3676a), c1348b);
                    AppManager.m3773a(c1348b, true);
                    break;
                case 6:
                    AppManager.m3779b(c1348b);
                    break;
            }
            if (this.f3712a.f3697l != null) {
                this.f3712a.f3697l.onStatusChanged(c1348b);
            }
        }
    }
}
