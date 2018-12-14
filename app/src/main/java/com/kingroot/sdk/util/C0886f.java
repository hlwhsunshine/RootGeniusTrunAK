package com.kingroot.sdk.util;

import com.kingroot.sdk.C0633at;

/* renamed from: com.kingroot.sdk.util.f */
public class C0886f {
    /* renamed from: gi */
    private static final ThreadLocal<C0886f> f2213gi = new ThreadLocal();
    public Throwable cause;
    /* renamed from: gj */
    public String f2214gj = "";
    public String msg = "";

    /* renamed from: a */
    public static void m2423a(String str, String str2, Throwable th) {
        if (th == null) {
            C0633at.m1465i("[" + str + "]" + str2);
        } else {
            C0633at.m1458a("[" + str + "]" + str2, th);
        }
        C0886f c0886f = (C0886f) f2213gi.get();
        if (c0886f == null) {
            c0886f = new C0886f();
            f2213gi.set(c0886f);
        }
        c0886f.f2214gj = str;
        c0886f.msg = str2;
        c0886f.cause = th;
    }

    /* renamed from: bj */
    public static String m2424bj() {
        C0886f c0886f = (C0886f) f2213gi.get();
        return c0886f == null ? "0" : c0886f.f2214gj;
    }

    public static void clean() {
        if (((C0886f) f2213gi.get()) != null) {
            f2213gi.remove();
        }
    }

    public static Throwable getCause() {
        C0886f c0886f = (C0886f) f2213gi.get();
        return c0886f == null ? null : c0886f.cause;
    }

    public static String getMsg() {
        C0886f c0886f = (C0886f) f2213gi.get();
        return c0886f == null ? "" : c0886f.msg;
    }

    public static String getMsgAndCause() {
        return C0886f.getMsg() + C0886f.getThrowMsg(C0886f.getCause());
    }

    public static String getThrowMsg(Throwable th) {
        if (th == null) {
            return "";
        }
        String th2 = th.toString();
        Throwable cause = th.getCause();
        if (cause == null) {
            return th2;
        }
        th2 = th2 + "_cause_" + cause.toString();
        cause = cause.getCause();
        return cause != null ? th2 + "_cause_" + cause.toString() : th2;
    }

    public static void set(int i, String str) {
        C0886f.set(i, str, null);
    }

    public static void set(int i, String str, Throwable th) {
        C0886f.m2423a(String.valueOf(i), str, th);
    }
}
