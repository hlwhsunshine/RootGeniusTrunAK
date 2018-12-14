package com.baidu.mobads.p031e;

import android.text.TextUtils;
import com.baidu.mobads.interfaces.error.IXAdErrorCode;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.p021j.C0338m;
import java.util.Map;

/* renamed from: com.baidu.mobads.e.a */
public class C0278a implements IXAdErrorCode {
    /* renamed from: a */
    protected final IXAdLogger f506a;

    public C0278a(IXAdLogger iXAdLogger) {
        this.f506a = iXAdLogger;
    }

    /* renamed from: a */
    private String m388a(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ErrorCode: [");
        stringBuilder.append(str);
        stringBuilder.append("]; ErrorDesc: [");
        stringBuilder.append(str2);
        stringBuilder.append("];");
        if (!TextUtils.isEmpty(str3)) {
            stringBuilder.append(" Extra: [");
            stringBuilder.append(str3);
            stringBuilder.append("];");
        }
        return stringBuilder.toString();
    }

    public String genCompleteErrorMessage(XAdErrorCode xAdErrorCode, String str) {
        return xAdErrorCode == null ? "" : m388a(xAdErrorCode.getCode(), xAdErrorCode.getMessage(), str);
    }

    public String getMessage(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        return C0338m.m569a().mo5044q().genCompleteErrorMessage((XAdErrorCode) map.get("msg"), "");
    }

    public void printErrorMessage(XAdErrorCode xAdErrorCode, String str) {
        this.f506a.mo4926e(genCompleteErrorMessage(xAdErrorCode, str));
    }

    public void printErrorMessage(String str, String str2, String str3) {
        this.f506a.mo4926e(m388a(str, str2, str3));
    }
}
