package android.support.p015v4.text;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Locale;

/* renamed from: android.support.v4.text.TextUtilsCompatJellybeanMr1 */
class TextUtilsCompatJellybeanMr1 {
    TextUtilsCompatJellybeanMr1() {
    }

    public static int getLayoutDirectionFromLocale(@Nullable Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }

    @NonNull
    public static String htmlEncode(@NonNull String str) {
        return TextUtils.htmlEncode(str);
    }
}
