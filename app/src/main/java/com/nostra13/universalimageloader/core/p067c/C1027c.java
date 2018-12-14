package com.nostra13.universalimageloader.core.p067c;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.p064b.C0999c;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* renamed from: com.nostra13.universalimageloader.core.c.c */
public abstract class C1027c implements C1026a {
    /* renamed from: a */
    protected Reference<View> f2572a;
    /* renamed from: b */
    protected boolean f2573b;

    public C1027c(View view) {
        this(view, (byte) 0);
    }

    private C1027c(View view, byte b) {
        if (view == null) {
            throw new IllegalArgumentException("view must not be null");
        }
        this.f2572a = new WeakReference(view);
        this.f2573b = true;
    }

    /* renamed from: a */
    public int mo6251a() {
        View view = (View) this.f2572a.get();
        if (view == null) {
            return 0;
        }
        LayoutParams layoutParams = view.getLayoutParams();
        int width = (!this.f2573b || layoutParams == null || layoutParams.width == -2) ? 0 : view.getWidth();
        return (width > 0 || layoutParams == null) ? width : layoutParams.width;
    }

    /* renamed from: a */
    protected abstract void mo6259a(Bitmap bitmap, View view);

    /* renamed from: a */
    protected abstract void mo6260a(Drawable drawable, View view);

    /* renamed from: a */
    public final boolean mo6252a(Bitmap bitmap) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = (View) this.f2572a.get();
            if (view != null) {
                mo6259a(bitmap, view);
                return true;
            }
        }
        C0999c.m2835c("Can't set a bitmap into view. You should call ImageLoader on UI thread for it.", new Object[0]);
        return false;
    }

    /* renamed from: a */
    public final boolean mo6253a(Drawable drawable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            View view = (View) this.f2572a.get();
            if (view != null) {
                mo6260a(drawable, view);
                return true;
            }
        }
        C0999c.m2835c("Can't set a drawable into view. You should call ImageLoader on UI thread for it.", new Object[0]);
        return false;
    }

    /* renamed from: b */
    public int mo6254b() {
        View view = (View) this.f2572a.get();
        if (view == null) {
            return 0;
        }
        LayoutParams layoutParams = view.getLayoutParams();
        int height = (!this.f2573b || layoutParams == null || layoutParams.height == -2) ? 0 : view.getHeight();
        return (height > 0 || layoutParams == null) ? height : layoutParams.height;
    }

    /* renamed from: c */
    public ViewScaleType mo6255c() {
        return ViewScaleType.CROP;
    }

    /* renamed from: d */
    public View mo6256d() {
        return (View) this.f2572a.get();
    }

    /* renamed from: e */
    public final boolean mo6257e() {
        return this.f2572a.get() == null;
    }

    /* renamed from: f */
    public final int mo6258f() {
        View view = (View) this.f2572a.get();
        return view == null ? super.hashCode() : view.hashCode();
    }
}
