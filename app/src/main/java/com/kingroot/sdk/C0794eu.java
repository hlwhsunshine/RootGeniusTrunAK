package com.kingroot.sdk;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kingroot.sdk.eu */
public class C0794eu {
    /* renamed from: iC */
    private static final Object f2010iC = new Object();

    /* renamed from: a */
    public static boolean m1986a(C0716ga c0716ga, C0801ez c0801ez, List<C0792fa> list) {
        boolean b;
        synchronized (f2010iC) {
            b = C0794eu.m1987b(c0716ga, c0801ez, list);
        }
        return b;
    }

    /* renamed from: b */
    private static boolean m1987b(C0716ga c0716ga, C0801ez c0801ez, List<C0792fa> list) {
        if (list == null) {
            List list2 = C0794eu.m1988bD();
        }
        boolean z = false;
        for (C0792fa c : list2) {
            if (!c.mo5802c(c0716ga)) {
                z = true;
            }
        }
        if (z) {
            for (C0792fa c2 : list2) {
                if (c2.mo5801bC()) {
                    c2.mo5803d(c0716ga);
                    if (!c2.mo5802c(c0716ga)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /* renamed from: bD */
    private static List<C0792fa> m1988bD() {
        List<C0792fa> arrayList = new ArrayList();
        arrayList.add(C0794eu.m1989bE());
        arrayList.add(new C0797ev(new C0800ey(0, 0, 493, -1, -1, 2, true, false, "u:object_r:system_file:s0", "/system/bin/sh", "/system/bin/rt.sh")));
        arrayList.add(new C0797ev(new C0800ey(0, 0, 493, 16, -1, 2, true, false, "u:object_r:system_file:s0", C0823fo.m2085bT(), "/system/xbin/supolicy")));
        arrayList.add(C0794eu.m1992bH());
        arrayList.add(new C0798ew());
        arrayList.add(C0794eu.m1991bG());
        arrayList.addAll(C0794eu.m1990bF());
        return arrayList;
    }

    /* renamed from: bE */
    public static C0792fa m1989bE() {
        return new C0807fc();
    }

    /* renamed from: bF */
    public static List<C0792fa> m1990bF() {
        List<C0792fa> arrayList = new ArrayList();
        String bS = C0823fo.m2084bS();
        if (bS != null) {
            if (!C0826fr.m2103bY()) {
                arrayList.add(new C0797ev(new C0800ey(0, 0, 3565, -1, -1, 2, true, false, "u:object_r:system_file:s0", bS, "/system/usr/iku/isu")));
            }
            arrayList.add(new C0797ev(new C0800ey(0, 0, 3565, -1, -1, 2, true, false, "u:object_r:system_file:s0", bS, "/system/bin/.usr/.ku")));
        }
        return arrayList;
    }

    /* renamed from: bG */
    public static C0792fa m1991bG() {
        return new C0812fe();
    }

    /* renamed from: bH */
    public static C0792fa m1992bH() {
        return new C0797ev(new C0800ey(0, 0, 493, 14, -1, 2, true, false, "u:object_r:system_file:s0", C0823fo.m2084bS(), "/system/xbin/ku.sud"));
    }
}
