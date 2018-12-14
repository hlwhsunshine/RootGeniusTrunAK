package com.shuame.mobile.sdk.impl.p088a;

import com.shuame.mobile.sdk.impl.utils.RomScanner.ScanListener;
import org.keplerproject.luajava.LuaException;

/* renamed from: com.shuame.mobile.sdk.impl.a.y */
class C1215y implements ScanListener {
    /* renamed from: a */
    final /* synthetic */ C1214x f3202a;

    C1215y(C1214x c1214x) {
        this.f3202a = c1214x;
    }

    public void onProgress(int i) {
        try {
            this.f3202a.f3201a.call(new Object[]{Integer.valueOf(i)}, 0);
        } catch (LuaException e) {
            e.printStackTrace();
        }
    }
}
