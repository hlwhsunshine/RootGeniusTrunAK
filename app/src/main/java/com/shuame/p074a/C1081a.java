package com.shuame.p074a;

import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;

/* renamed from: com.shuame.a.a */
public class C1081a {
    /* renamed from: a */
    private static final String f2876a = C1081a.class.getSimpleName();

    /* renamed from: a */
    public static String m3141a(boolean z) {
        String str = "";
        Object obj;
        do {
            try {
                str = UserAction.getQIMEI();
            } catch (Exception e) {
            }
            if (TextUtils.isEmpty(str) && z) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e2) {
                }
                obj = 1;
                z = false;
                continue;
            } else {
                obj = null;
                continue;
            }
        } while (obj != null);
        return str;
    }
}
