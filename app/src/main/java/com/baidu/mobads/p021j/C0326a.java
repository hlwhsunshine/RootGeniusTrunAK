package com.baidu.mobads.p021j;

import android.content.p013pm.PermissionInfo;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.utils.IBase64;

/* renamed from: com.baidu.mobads.j.a */
public class C0326a implements IBase64 {
    /* renamed from: a */
    private static final byte[] f655a = new byte[]{(byte) 48, (byte) 75, (byte) 97, (byte) 106, (byte) 68, (byte) 55, (byte) 65, (byte) 90, (byte) 99, (byte) 70, (byte) 50, (byte) 81, (byte) 110, (byte) 80, (byte) 114, (byte) 53, (byte) 102, (byte) 119, (byte) 105, (byte) 72, (byte) 82, (byte) 78, (byte) 121, (byte) 103, (byte) 109, (byte) 117, (byte) 112, (byte) 85, (byte) 84, (byte) 73, (byte) 88, (byte) 120, (byte) 54, (byte) 57, (byte) 66, (byte) 87, (byte) 98, (byte) 45, (byte) 104, (byte) 77, (byte) 67, (byte) 71, (byte) 74, (byte) 111, (byte) 95, (byte) 86, (byte) 56, (byte) 69, (byte) 115, (byte) 107, (byte) 122, (byte) 49, (byte) 89, (byte) 100, (byte) 118, (byte) 76, (byte) 51, (byte) 52, (byte) 108, (byte) 101, (byte) 116, (byte) 113, (byte) 83, (byte) 79};
    /* renamed from: b */
    private static final byte[] f656b = new byte[128];

    static {
        for (int i = 0; i < f655a.length; i++) {
            f656b[f655a[i]] = (byte) i;
        }
    }

    /* renamed from: a */
    private boolean m525a(byte b) {
        return b == (byte) 36 ? true : (b < (byte) 0 || b >= Byte.MIN_VALUE) ? false : f656b[b] != (byte) -1;
    }

    /* renamed from: a */
    private byte[] m526a(String str) {
        byte[] bArr = null;
        int i = 0;
        if (!(m527b(str) || str == null || str.length() < 4)) {
            byte b;
            byte b2;
            bArr = str.charAt(str.length() + -2) == '$' ? new byte[((((str.length() / 4) - 1) * 3) + 1)] : str.charAt(str.length() + -1) == '$' ? new byte[((((str.length() / 4) - 1) * 3) + 2)] : new byte[((str.length() / 4) * 3)];
            int i2 = 0;
            while (i2 < str.length() - 4) {
                b = f656b[str.charAt(i2)];
                b2 = f656b[str.charAt(i2 + 1)];
                byte b3 = f656b[str.charAt(i2 + 2)];
                byte b4 = f656b[str.charAt(i2 + 3)];
                bArr[i] = (byte) ((b << 2) | (b2 >> 4));
                bArr[i + 1] = (byte) ((b2 << 4) | (b3 >> 2));
                bArr[i + 2] = (byte) ((b3 << 6) | b4);
                i2 += 4;
                i += 3;
            }
            byte b5;
            byte b6;
            if (str.charAt(str.length() - 2) == '$') {
                bArr[bArr.length - 1] = (byte) ((f656b[str.charAt(str.length() - 4)] << 2) | (f656b[str.charAt(str.length() - 3)] >> 4));
            } else if (str.charAt(str.length() - 1) == '$') {
                b5 = f656b[str.charAt(str.length() - 4)];
                b6 = f656b[str.charAt(str.length() - 3)];
                b = f656b[str.charAt(str.length() - 2)];
                bArr[bArr.length - 2] = (byte) ((b5 << 2) | (b6 >> 4));
                bArr[bArr.length - 1] = (byte) ((b6 << 4) | (b >> 2));
            } else {
                b5 = f656b[str.charAt(str.length() - 4)];
                b6 = f656b[str.charAt(str.length() - 3)];
                b = f656b[str.charAt(str.length() - 2)];
                b2 = f656b[str.charAt(str.length() - 1)];
                bArr[bArr.length - 3] = (byte) ((b5 << 2) | (b6 >> 4));
                bArr[bArr.length - 2] = (byte) ((b6 << 4) | (b >> 2));
                bArr[bArr.length - 1] = (byte) ((b << 6) | b2);
            }
        }
        return bArr;
    }

    /* renamed from: b */
    private boolean m527b(String str) {
        if (str == null) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!m525a((byte) str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public String decodeStr(String str) {
        if (str == null || str.length() < 4) {
            return null;
        }
        try {
            String str2 = new String(m526a(str));
            while (str2.endsWith("$")) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            return str2;
        } catch (Exception e) {
            return "";
        }
    }

    public String encode(String str) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int length = str.getBytes().length % 3;
        while (length > 0 && length < 3) {
            str = str + "$";
            length++;
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[((bytes.length / 3) * 4)];
        length = 0;
        while (length < bytes.length) {
            bArr[i] = f655a[(bytes[length] & 252) >> 2];
            bArr[i + 1] = f655a[((bytes[length] & 3) << 4) + ((bytes[length + 1] & PermissionInfo.PROTECTION_MASK_FLAGS) >> 4)];
            bArr[i + 2] = f655a[((bytes[length + 1] & 15) << 2) + ((bytes[length + 2] & 192) >> 6)];
            bArr[i + 3] = f655a[bytes[length + 2] & 63];
            length += 3;
            i += 4;
        }
        return new String(bArr);
    }
}
