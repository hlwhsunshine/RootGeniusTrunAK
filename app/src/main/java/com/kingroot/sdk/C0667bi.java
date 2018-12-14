package com.kingroot.sdk;

import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.kingroot.sdk.bi */
public class C0667bi {
    /* renamed from: dl */
    private static int f1667dl = 0;
    /* renamed from: dm */
    private static WakeLock f1668dm = null;

    /* renamed from: com.kingroot.sdk.bi$a */
    public interface C0647a<T> {
        /* renamed from: a */
        T mo5626a(List<Object> list);
    }

    /* renamed from: a */
    public static <T> T m1577a(C0647a<T> c0647a, Object... objArr) {
        try {
            C0667bi.lock();
            T a = c0647a.mo5626a(Arrays.asList(objArr));
            return a;
        } finally {
            C0667bi.release();
        }
    }

    private static void lock() {
        synchronized (C0667bi.class) {
            f1667dl++;
            C0633at.m1463g("WakeLockMgr|lock, count:" + f1667dl);
            if (f1667dl > 1) {
                return;
            }
            if (f1668dm == null) {
                try {
                    f1668dm = ((PowerManager) C0741dg.m1804aL().f1805el.getSystemService("power")).newWakeLock(536870913, "wk_mgr");
                } catch (SecurityException e) {
                    e.printStackTrace();
                }
            }
            try {
                if (!(f1668dm == null || f1668dm.isHeld())) {
                    f1668dm.acquire();
                    C0633at.m1463g("WakeLockMgr|acquire lock");
                }
            } catch (Exception e2) {
            }
            return;
        }
    }

    private static void release() {
        synchronized (C0667bi.class) {
            if (f1667dl > 0) {
                f1667dl--;
            }
            C0633at.m1463g("WakeLockMgr|release, count:" + f1667dl);
            if (f1667dl > 0) {
                return;
            }
            try {
                if (f1668dm != null && f1668dm.isHeld()) {
                    f1668dm.release();
                    C0633at.m1463g("WakeLockMgr|release lock");
                }
            } catch (Exception e) {
            }
            f1668dm = null;
        }
    }
}
