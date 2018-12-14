package android.support.p015v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.widget.CompoundButtonCompatDonut */
class CompoundButtonCompatDonut {
    private static final String TAG = "CompoundButtonCompatDonut";
    private static Field sButtonDrawableField;
    private static boolean sButtonDrawableFieldFetched;

    CompoundButtonCompatDonut() {
    }

    static Drawable getButtonDrawable(CompoundButton compoundButton) {
        if (!sButtonDrawableFieldFetched) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                sButtonDrawableField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            sButtonDrawableFieldFetched = true;
        }
        if (sButtonDrawableField != null) {
            try {
                return (Drawable) sButtonDrawableField.get(compoundButton);
            } catch (IllegalAccessException e2) {
                sButtonDrawableField = null;
            }
        }
        return null;
    }

    static ColorStateList getButtonTintList(CompoundButton compoundButton) {
        return compoundButton instanceof TintableCompoundButton ? ((TintableCompoundButton) compoundButton).getSupportButtonTintList() : null;
    }

    static Mode getButtonTintMode(CompoundButton compoundButton) {
        return compoundButton instanceof TintableCompoundButton ? ((TintableCompoundButton) compoundButton).getSupportButtonTintMode() : null;
    }

    static void setButtonTintList(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (compoundButton instanceof TintableCompoundButton) {
            ((TintableCompoundButton) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    static void setButtonTintMode(CompoundButton compoundButton, Mode mode) {
        if (compoundButton instanceof TintableCompoundButton) {
            ((TintableCompoundButton) compoundButton).setSupportButtonTintMode(mode);
        }
    }
}
