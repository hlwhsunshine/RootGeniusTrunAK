package com.tencent.p105mm.opensdk.diffdev;

import com.tencent.p105mm.opensdk.diffdev.p119a.C1663a;
import com.tencent.p105mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.diffdev.DiffDevOAuthFactory */
public class DiffDevOAuthFactory {
    public static final int MAX_SUPPORTED_VERSION = 1;
    private static final String TAG = "MicroMsg.SDK.DiffDevOAuthFactory";
    public static final int VERSION_1 = 1;
    private static IDiffDevOAuth v1Instance = null;

    private DiffDevOAuthFactory() {
    }

    public static IDiffDevOAuth getDiffDevOAuth() {
        return DiffDevOAuthFactory.getDiffDevOAuth(1);
    }

    public static IDiffDevOAuth getDiffDevOAuth(int i) {
        Log.m4582v(TAG, "getDiffDevOAuth, version = " + i);
        if (i > 1) {
            Log.m4580e(TAG, "getDiffDevOAuth fail, unsupported version = " + i);
            return null;
        }
        switch (i) {
            case 1:
                if (v1Instance == null) {
                    v1Instance = new C1663a();
                }
                return v1Instance;
            default:
                return null;
        }
    }
}
