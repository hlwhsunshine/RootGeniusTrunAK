package com.shuame.mobile.sdk;

import android.content.Context;
import com.shuame.mobile.sdk.impl.C1217a;
import com.shuame.mobile.sdk.impl.utils.C1219a;

public class FlashEngineFactory {
    private static final String TAG = FlashEngineFactory.class.getSimpleName();

    public static FlashEngine newFlashEngine(Context context) {
        C1219a.m3447b();
        C1219a.m3446a(context);
        return new C1217a();
    }
}
