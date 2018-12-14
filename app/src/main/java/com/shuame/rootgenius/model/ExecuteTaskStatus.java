package com.shuame.rootgenius.model;

import com.shuame.rootgenius.RootGeniusApp;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.util.NetworkUtils;
import com.shuame.rootgenius.common.util.NetworkUtils.NetworkType;
import java.util.Observable;

public final class ExecuteTaskStatus extends Observable {
    /* renamed from: b */
    private static boolean f3985b;
    /* renamed from: e */
    private static ExecuteTaskStatus f3986e;
    /* renamed from: a */
    private EXECUTE_STATUS f3987a = EXECUTE_STATUS.STATUS_IDEL;
    /* renamed from: c */
    private boolean f3988c;
    /* renamed from: d */
    private NetworkType f3989d = NetworkUtils.m3853c();

    public enum EXECUTE_STATUS {
        STATUS_IDEL(0),
        STATUS_BUSY(1);
        
        private int value;

        private EXECUTE_STATUS(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* renamed from: a */
    public static ExecuteTaskStatus m4027a() {
        if (f3986e == null) {
            C1323b.m3688a();
            f3985b = RootGeniusApp.m3523a().getSharedPreferences("set", 0).getBoolean("auto_download_rom", false);
            f3986e = new ExecuteTaskStatus();
        }
        return f3986e;
    }

    /* renamed from: a */
    public final void mo7217a(boolean z) {
        this.f3988c = z;
        setChanged();
    }

    protected final void setChanged() {
        notifyObservers();
        super.setChanged();
    }
}
