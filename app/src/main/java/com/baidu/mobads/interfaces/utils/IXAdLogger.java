package com.baidu.mobads.interfaces.utils;

public interface IXAdLogger {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final String TAG = "BaiduXAdSDK";
    public static final int UNLOGGABLE = -1;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    /* renamed from: d */
    int mo4921d(String str);

    /* renamed from: d */
    int mo4922d(String str, String str2);

    /* renamed from: d */
    int mo4923d(String str, Throwable th);

    /* renamed from: d */
    int mo4924d(Throwable th);

    /* renamed from: d */
    int mo4925d(Object... objArr);

    /* renamed from: e */
    int mo4926e(String str);

    /* renamed from: e */
    int mo4927e(String str, Throwable th);

    /* renamed from: e */
    int mo4928e(Throwable th);

    /* renamed from: e */
    int mo4929e(Object... objArr);

    /* renamed from: i */
    int mo4930i(String str);

    /* renamed from: i */
    int mo4931i(String str, String str2);

    /* renamed from: i */
    int mo4932i(String str, Throwable th);

    /* renamed from: i */
    int mo4933i(Object... objArr);

    boolean isLoggable(int i);

    boolean isLoggable(String str, int i);

    /* renamed from: w */
    int mo4936w(String str);

    /* renamed from: w */
    int mo4937w(String str, Throwable th);

    /* renamed from: w */
    int mo4938w(Throwable th);

    /* renamed from: w */
    int mo4939w(Object... objArr);
}
