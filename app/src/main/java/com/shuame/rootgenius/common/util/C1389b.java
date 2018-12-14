package com.shuame.rootgenius.common.util;

import com.shuame.rootgenius.common.C1335e.C1332e;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile;
import java.io.File;

/* renamed from: com.shuame.rootgenius.common.util.b */
public final class C1389b {
    /* renamed from: a */
    private static C1389b f3861a = new C1389b();

    /* renamed from: a */
    public static C1389b m3884a() {
        return f3861a;
    }

    /* renamed from: a */
    public static boolean m3885a(QQDownloadFile qQDownloadFile, boolean z) {
        if (qQDownloadFile.f3725f == null) {
            C1416x.m3936a(C1332e.string_space_not_enough);
            return false;
        }
        new StringBuilder("path=").append(qQDownloadFile.f3725f);
        long j = 0;
        if (new File(qQDownloadFile.mo7051a()).exists() && qQDownloadFile.f3728i > 0) {
            j = new File(qQDownloadFile.mo7051a()).length();
        }
        j = qQDownloadFile.f3727h - j;
        new StringBuilder("downloadsize=").append(j / 1024).append("K;   percent=").append(qQDownloadFile.f3728i / 10).append("%");
        long b = C1411s.m3926b(qQDownloadFile.f3725f);
        new StringBuilder("sdcard_size=").append(b).append(";  downloadsize=").append(j);
        new StringBuilder().append((j / 1024) / 1024).append("M/").append((b / 1024) / 1024).append("M");
        if ((b > j ? 1 : null) != null) {
            return true;
        }
        if (z) {
            C1416x.m3936a(C1332e.string_space_not_enough);
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m3886a(boolean z) {
        if (C1411s.m3925a()) {
            return true;
        }
        if (z) {
            C1416x.m3936a(C1332e.string_no_sd_card);
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m3887b(boolean z) {
        if (NetworkUtils.m3852b()) {
            return true;
        }
        if (z) {
            C1416x.m3936a(C1332e.string_no_active_network);
        }
        return false;
    }
}
