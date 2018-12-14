package com.nostra13.universalimageloader.p064b;

import java.util.Comparator;

/* renamed from: com.nostra13.universalimageloader.b.e */
final class C1001e implements Comparator<String> {
    C1001e() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        return str.substring(0, str.lastIndexOf("_")).compareTo(str2.substring(0, str2.lastIndexOf("_")));
    }
}
