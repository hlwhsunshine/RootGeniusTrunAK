package com.baidu.mobads.p021j;

import android.net.wifi.ScanResult;
import java.util.Comparator;

/* renamed from: com.baidu.mobads.j.q */
class C0342q implements Comparator<ScanResult> {
    /* renamed from: a */
    final /* synthetic */ C0339n f712a;

    C0342q(C0339n c0339n) {
        this.f712a = c0339n;
    }

    /* renamed from: a */
    public int compare(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult2.level - scanResult.level;
    }
}
