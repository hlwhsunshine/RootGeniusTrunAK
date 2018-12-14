package com.kingroot.sdk;

import java.util.ArrayList;

/* renamed from: com.kingroot.sdk.ep */
public final class C0788ep extends C0597gy {
    /* renamed from: hR */
    static ArrayList<Integer> f1941hR;
    /* renamed from: hS */
    static C0780eh f1942hS;
    /* renamed from: hN */
    public String f1943hN = "";
    /* renamed from: hO */
    public ArrayList<Integer> f1944hO = null;
    /* renamed from: hP */
    public String f1945hP = "";
    /* renamed from: hQ */
    public C0780eh f1946hQ = null;
    /* renamed from: id */
    public int f1947id = 0;
    /* renamed from: x */
    public int f1948x = 0;

    /* renamed from: a */
    public final void mo5569a(C0863gw c0863gw) {
        this.f1947id = c0863gw.mo5893a(this.f1947id, 0, true);
        this.f1948x = c0863gw.mo5893a(this.f1948x, 1, true);
        this.f1943hN = c0863gw.mo5896a(2, true);
        if (f1941hR == null) {
            f1941hR = new ArrayList();
            f1941hR.add(Integer.valueOf(0));
        }
        this.f1944hO = (ArrayList) c0863gw.mo5911b(f1941hR, 3, false);
        this.f1945hP = c0863gw.mo5896a(4, false);
        if (f1942hS == null) {
            f1942hS = new C0780eh();
        }
        this.f1946hQ = (C0780eh) c0863gw.mo5895a(f1942hS, 5, false);
    }

    /* renamed from: a */
    public final void mo5570a(C0864gx c0864gx) {
        c0864gx.mo5936f(this.f1947id, 0);
        c0864gx.mo5936f(this.f1948x, 1);
        c0864gx.mo5935d(this.f1943hN, 2);
        if (this.f1944hO != null) {
            c0864gx.mo5921a(this.f1944hO, 3);
        }
        if (this.f1945hP != null) {
            c0864gx.mo5935d(this.f1945hP, 4);
        }
        if (this.f1946hQ != null) {
            c0864gx.mo5919a(this.f1946hQ, 5);
        }
    }
}
