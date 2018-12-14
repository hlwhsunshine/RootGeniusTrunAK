package com.baidu.mobads.p021j;

import android.net.wifi.ScanResult;
import java.util.Comparator;

/* renamed from: com.baidu.mobads.j.p */
class C0341p implements Comparator<ScanResult> {
    /* renamed from: a */
    final /* synthetic */ C0339n f711a;

    C0341p(C0339n c0339n) {
        this.f711a = c0339n;
    }

    /* renamed from: a */
    public int compare(ScanResult scanResult, ScanResult scanResult2) {
        return scanResult2.level - scanResult.level;
    }
}
