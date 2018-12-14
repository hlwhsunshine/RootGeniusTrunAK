package com.tencent.p105mm.opensdk.channel.p118a;

import com.tencent.p105mm.opensdk.utils.C1673b;

/* renamed from: com.tencent.mm.opensdk.channel.a.b */
public final class C1662b {
    /* renamed from: a */
    public static byte[] m4566a(String str, int i, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        return C1673b.m4586c(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
    }
}
