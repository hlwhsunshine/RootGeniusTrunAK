package com.tencent.stat.common;

import android.net.wifi.ScanResult;
import java.util.Comparator;

/* renamed from: com.tencent.stat.common.p */
final class C1732p implements Comparator<ScanResult> {
    C1732p() {
    }

    /* renamed from: a */
    public final int compare(ScanResult scanResult, ScanResult scanResult2) {
        int abs = Math.abs(scanResult.level);
        int abs2 = Math.abs(scanResult2.level);
        return abs > abs2 ? 1 : abs == abs2 ? 0 : -1;
    }
}
