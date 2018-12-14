package com.shuame.rootgenius.appmanager.p091b;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* renamed from: com.shuame.rootgenius.appmanager.b.e */
public final class C1260e {
    /* renamed from: a */
    public static <T> T m3592a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return C1260e.m3593a(str.getBytes("ISO-8859-1"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: a */
    private static <T> T m3593a(byte[] bArr) {
        if (bArr != null) {
            try {
                return new BitmapDrawable(BitmapFactory.decodeStream(new ByteArrayInputStream(bArr)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String m3594a(Drawable drawable) {
        if (drawable != null) {
            byte[] toByteArray;
            if (drawable != null) {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ((BitmapDrawable) drawable).getBitmap().compress(CompressFormat.PNG, 0, byteArrayOutputStream);
                toByteArray = byteArrayOutputStream.toByteArray();
            } else {
                toByteArray = null;
            }
            if (toByteArray != null) {
                try {
                    return new String(toByteArray, "ISO-8859-1");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
