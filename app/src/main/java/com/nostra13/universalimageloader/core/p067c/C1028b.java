package com.nostra13.universalimageloader.core.p067c;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.p064b.C0999c;
import java.lang.reflect.Field;

/* renamed from: com.nostra13.universalimageloader.core.c.b */
public final class C1028b extends C1027c {
    public C1028b(ImageView imageView) {
        super(imageView);
    }

    /* renamed from: a */
    private static int m2935a(Object obj, String str) {
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int intValue = ((Integer) declaredField.get(obj)).intValue();
            if (intValue > 0 && intValue < Integer.MAX_VALUE) {
                return intValue;
            }
        } catch (Throwable e) {
            C0999c.m2832a(e);
        }
        return 0;
    }

    /* renamed from: a */
    public final int mo6251a() {
        int a = super.mo6251a();
        if (a <= 0) {
            Object obj = (ImageView) this.f2572a.get();
            if (obj != null) {
                return C1028b.m2935a(obj, "mMaxWidth");
            }
        }
        return a;
    }

    /* renamed from: a */
    protected final void mo6259a(Bitmap bitmap, View view) {
        ((ImageView) view).setImageBitmap(bitmap);
    }

    /* renamed from: a */
    protected final void mo6260a(Drawable drawable, View view) {
        ((ImageView) view).setImageDrawable(drawable);
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    /* renamed from: b */
    public final int mo6254b() {
        int b = super.mo6254b();
        if (b <= 0) {
            Object obj = (ImageView) this.f2572a.get();
            if (obj != null) {
                return C1028b.m2935a(obj, "mMaxHeight");
            }
        }
        return b;
    }

    /* renamed from: c */
    public final ViewScaleType mo6255c() {
        ImageView imageView = (ImageView) this.f2572a.get();
        return imageView != null ? ViewScaleType.fromImageView(imageView) : super.mo6255c();
    }

    /* renamed from: d */
    public final /* bridge */ /* synthetic */ View mo6256d() {
        return (ImageView) super.mo6256d();
    }
}
