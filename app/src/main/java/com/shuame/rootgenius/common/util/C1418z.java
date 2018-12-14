package com.shuame.rootgenius.common.util;

import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;

/* renamed from: com.shuame.rootgenius.common.util.z */
public class C1418z {
    /* renamed from: a */
    private static final String f3910a = C1418z.class.getSimpleName();

    /* renamed from: a */
    public static void m3939a(TextView textView) {
        if (textView == null) {
            return;
        }
        if (VERSION.SDK_INT > 10) {
            textView.setEllipsize(TruncateAt.END);
        } else {
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new C1384aa(textView));
        }
    }
}
