package com.shuame.utils;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.shuame.utils.a */
public class C1617a {
    /* renamed from: a */
    private static final String f4575a = C1617a.class.getSimpleName();
    /* renamed from: b */
    private static final Map<String, SimpleDateFormat> f4576b = new HashMap();

    /* renamed from: a */
    protected static SimpleDateFormat m4386a(String str) {
        if (f4576b.containsKey(str)) {
            return (SimpleDateFormat) f4576b.get(str);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        f4576b.put(str, simpleDateFormat);
        return simpleDateFormat;
    }
}
