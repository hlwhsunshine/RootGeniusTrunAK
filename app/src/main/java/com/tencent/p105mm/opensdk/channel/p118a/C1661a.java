package com.tencent.p105mm.opensdk.channel.p118a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.p105mm.opensdk.constants.ConstantsAPI;
import com.tencent.p105mm.opensdk.utils.C1677d;
import com.tencent.p105mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.channel.a.a */
public final class C1661a {

    /* renamed from: com.tencent.mm.opensdk.channel.a.a$a */
    public static class C1660a {
        /* renamed from: a */
        public String f4739a;
        public String action;
        /* renamed from: b */
        public long f4740b;
        public Bundle bundle;
        public String content;
    }

    /* renamed from: a */
    public static boolean m4565a(Context context, C1660a c1660a) {
        if (context == null) {
            Log.m4580e("MicroMsg.SDK.MMessage", "send fail, invalid argument");
            return false;
        } else if (C1677d.m4588a(c1660a.action)) {
            Log.m4580e("MicroMsg.SDK.MMessage", "send fail, action is null");
            return false;
        } else {
            String str = null;
            if (!C1677d.m4588a(c1660a.f4739a)) {
                str = c1660a.f4739a + ".permission.MM_MESSAGE";
            }
            Intent intent = new Intent(c1660a.action);
            if (c1660a.bundle != null) {
                intent.putExtras(c1660a.bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, 620823552);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, c1660a.content);
            intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, c1660a.f4740b);
            intent.putExtra(ConstantsAPI.CHECK_SUM, C1662b.m4566a(c1660a.content, 620823552, packageName));
            context.sendBroadcast(intent, str);
            Log.m4579d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str);
            return true;
        }
    }
}
