package com.shuame.rootgenius.service;

import com.shuame.rootgenius.common.util.NetworkUtils;

/* renamed from: com.shuame.rootgenius.service.a */
public final class C1481a {
    /* renamed from: a */
    private static boolean f4079a = false;

    /* renamed from: a */
    public static void m4128a() {
        if (!f4079a && NetworkUtils.m3852b()) {
            f4079a = true;
            new C1482b().start();
        }
    }
}
