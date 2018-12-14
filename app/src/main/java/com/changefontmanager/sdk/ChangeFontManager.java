package com.changefontmanager.sdk;

import android.content.Context;
import com.changefontmanager.sdk.utils.ActivityJumpController;
import com.changefontmanager.sdk.utils.RootUtils;

public class ChangeFontManager {
    /* renamed from: a */
    private static ChangeFontManager f1120a;
    /* renamed from: b */
    private IChangeFont f1121b;
    /* renamed from: c */
    private boolean f1122c;
    /* renamed from: d */
    private boolean f1123d;
    /* renamed from: e */
    private boolean f1124e;
    /* renamed from: f */
    private boolean f1125f;
    /* renamed from: g */
    private boolean f1126g = false;

    private ChangeFontManager() {
    }

    public static synchronized ChangeFontManager getInstance() {
        ChangeFontManager changeFontManager;
        synchronized (ChangeFontManager.class) {
            if (f1120a == null) {
                f1120a = new ChangeFontManager();
            }
            changeFontManager = f1120a;
        }
        return changeFontManager;
    }

    public static boolean isRoot() {
        return RootUtils.m974o();
    }

    public void checkPhoneType(Context context) {
        RootUtils.m972m();
    }

    public IChangeFont getChangefont(Context context) {
        RootUtils.m972m();
        return this.f1121b;
    }

    public boolean isIsnexus() {
        return this.f1124e;
    }

    public boolean isLenovoLenovo() {
        return this.f1123d;
    }

    public boolean isLogflog() {
        return this.f1126g;
    }

    public boolean isOPPO() {
        return this.f1125f;
    }

    public boolean isSdkGreaterThanApi14() {
        return this.f1122c;
    }

    public void jumpToHtcSetting(Context context) {
        ActivityJumpController.jumpToHtcSetting(context);
    }

    public void setChangefont(IChangeFont iChangeFont) {
        this.f1121b = iChangeFont;
    }

    public void setCustomizedSu(String str) {
        RootUtils.f1176Y = str;
    }

    public void setIsnexus(boolean z) {
        this.f1124e = z;
    }

    public void setLenovoLenovo(boolean z) {
        this.f1123d = z;
    }

    public void setLogflog(boolean z) {
        this.f1126g = z;
    }

    public void setOPPO(boolean z) {
        this.f1125f = z;
    }

    public void setSdkGreaterThanApi14(boolean z) {
        this.f1122c = z;
    }
}
