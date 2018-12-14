package com.tencent.p105mm.opensdk.utils;

import android.net.Uri;
import android.provider.BaseColumns;

/* renamed from: com.tencent.mm.opensdk.utils.c */
public final class C1676c {

    /* renamed from: com.tencent.mm.opensdk.utils.c$a */
    public static final class C1674a {
        /* renamed from: a */
        public static Object m4587a(int i, String str) {
            switch (i) {
                case 1:
                    return Integer.valueOf(str);
                case 2:
                    return Long.valueOf(str);
                case 3:
                    return str;
                case 4:
                    return Boolean.valueOf(str);
                case 5:
                    return Float.valueOf(str);
                case 6:
                    return Double.valueOf(str);
                default:
                    try {
                        Log.m4580e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
                    } catch (Exception e) {
                        Log.m4580e("MicroMsg.SDK.PluginProvider.Resolver", "resolveObj exception:" + e.getMessage());
                    }
                    return null;
            }
        }
    }

    /* renamed from: com.tencent.mm.opensdk.utils.c$b */
    public static final class C1675b implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
    }
}
