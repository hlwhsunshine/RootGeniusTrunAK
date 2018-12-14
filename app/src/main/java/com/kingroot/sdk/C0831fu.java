package com.kingroot.sdk;

import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.kingroot.sdk.fu */
public class C0831fu {
    /* renamed from: dl */
    private static int f2077dl = 0;
    /* renamed from: dm */
    private static WakeLock f2078dm = null;

    /* renamed from: com.kingroot.sdk.fu$a */
    public interface C0795a<T> {
        /* renamed from: b */
        T mo5806b(C0716ga c0716ga, List<Object> list);
    }

    /* renamed from: a */
    public static <T> T m2119a(C0716ga c0716ga, C0795a<T> c0795a, Object... objArr) {
        try {
            C0831fu.lock();
            T b = c0795a.mo5806b(c0716ga, Arrays.asList(objArr));
            return b;
        } finally {
            C0831fu.release();
        }
    }

    private static void lock() {
        synchronized (C0831fu.class) {
            f2077dl++;
            C0825fq.m2100h("wl_mgr", "WakeLockMgr|lock, count:" + f2077dl);
            if (f2077dl > 1) {
                return;
            }
            if (f2078dm == null) {
                try {
                    f2078dm = ((PowerManager) C0823fo.m2083bR().getSystemService("power")).newWakeLock(536870913, "wk_mgr");
                } catch (SecurityException e) {
                    e.printStackTrace();
                }
            }
            try {
                if (!(f2078dm == null || f2078dm.isHeld())) {
                    f2078dm.acquire();
                    C0825fq.m2100h("wl_mgr", "WakeLockMgr|acquire lock");
                }
            } catch (Exception e2) {
            }
            return;
        }
    }

    private static void release() {
        synchronized (C0831fu.class) {
            if (f2077dl > 0) {
                f2077dl--;
            }
            C0825fq.m2100h("wl_mgr", "WakeLockMgr|release, count:" + f2077dl);
            if (f2077dl > 0) {
                return;
            }
            try {
                if (f2078dm != null && f2078dm.isHeld()) {
                    f2078dm.release();
                    C0825fq.m2100h("wl_mgr", "WakeLockMgr|release lock");
                }
            } catch (Exception e) {
            }
            f2078dm = null;
        }
    }
}
