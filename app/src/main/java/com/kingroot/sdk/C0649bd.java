package com.kingroot.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.kingroot.sdk.C0667bi.C0647a;
import java.util.List;

/* renamed from: com.kingroot.sdk.bd */
public class C0649bd extends BroadcastReceiver {
    public void onReceive(Context context, final Intent intent) {
        C0667bi.m1577a(new C0647a<Object>() {
            /* renamed from: a */
            public Object mo5626a(List<Object> list) {
                boolean z = false;
                if ("com.kingroot.kinguser.action.update".equals(intent.getAction()) || "android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
                    C0665bg.m1554Z().mo5644d(false);
                } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                    C0665bg Z = C0665bg.m1554Z();
                    if (C0659bf.m1548c(false) != null) {
                        z = true;
                    }
                    Z.mo5645e(z);
                }
                return null;
            }
        }, new Object[0]);
    }
}
