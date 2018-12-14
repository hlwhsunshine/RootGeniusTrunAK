package krsdk;

import com.kingroot.sdk.C0633at;

public class KRError {
    public static final int NONE = 0;
    /* renamed from: gi */
    private static final ThreadLocal<KRError> f5188gi = new ThreadLocal();
    public Throwable cause;
    public int code = 0;
    public String msg = "";

    public static void clean() {
        if (((KRError) f5188gi.get()) != null) {
            f5188gi.remove();
        }
    }

    public static boolean exist() {
        KRError kRError = (KRError) f5188gi.get();
        return kRError != null && kRError.code == 0;
    }

    public static Throwable getCause() {
        KRError kRError = (KRError) f5188gi.get();
        return kRError == null ? null : kRError.cause;
    }

    public static int getCode() {
        KRError kRError = (KRError) f5188gi.get();
        return kRError == null ? 0 : kRError.code;
    }

    public static String getMsg() {
        KRError kRError = (KRError) f5188gi.get();
        return kRError == null ? "" : kRError.msg;
    }

    public static String getMsgAndCause() {
        return getMsg() + getThrowMsg(getCause());
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
        set(i, str, null);
    }

    public static void set(int i, String str, Throwable th) {
        if (th == null) {
            C0633at.m1465i("[" + i + "]" + str);
        } else {
            C0633at.m1458a("[" + i + "]" + str, th);
        }
        KRError kRError = (KRError) f5188gi.get();
        if (kRError == null) {
            kRError = new KRError();
            f5188gi.set(kRError);
        }
        kRError.code = i;
        kRError.msg = str;
        kRError.cause = th;
    }
}
