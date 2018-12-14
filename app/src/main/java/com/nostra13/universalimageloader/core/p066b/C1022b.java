package com.nostra13.universalimageloader.core.p066b;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import com.nostra13.universalimageloader.core.p067c.C1026a;
import com.nostra13.universalimageloader.core.p067c.C1028b;

/* renamed from: com.nostra13.universalimageloader.core.b.b */
public final class C1022b implements C1020a {
    /* renamed from: a */
    protected final int f2543a;
    /* renamed from: b */
    protected final int f2544b;

    /* renamed from: com.nostra13.universalimageloader.core.b.b$a */
    public static class C1021a extends Drawable {
        /* renamed from: a */
        protected final float f2537a;
        /* renamed from: b */
        protected final int f2538b;
        /* renamed from: c */
        protected final RectF f2539c = new RectF();
        /* renamed from: d */
        protected final RectF f2540d;
        /* renamed from: e */
        protected final BitmapShader f2541e;
        /* renamed from: f */
        protected final Paint f2542f;

        public C1021a(Bitmap bitmap, int i, int i2) {
            this.f2537a = (float) i;
            this.f2538b = i2;
            this.f2541e = new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP);
            this.f2540d = new RectF((float) i2, (float) i2, (float) (bitmap.getWidth() - i2), (float) (bitmap.getHeight() - i2));
            this.f2542f = new Paint();
            this.f2542f.setAntiAlias(true);
            this.f2542f.setShader(this.f2541e);
        }

        public final void draw(Canvas canvas) {
            canvas.drawRoundRect(this.f2539c, this.f2537a, this.f2537a, this.f2542f);
        }

        public final int getOpacity() {
            return -3;
        }

        protected final void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            this.f2539c.set((float) this.f2538b, (float) this.f2538b, (float) (rect.width() - this.f2538b), (float) (rect.height() - this.f2538b));
            Matrix matrix = new Matrix();
            matrix.setRectToRect(this.f2540d, this.f2539c, ScaleToFit.FILL);
            this.f2541e.setLocalMatrix(matrix);
        }

        public final void setAlpha(int i) {
            this.f2542f.setAlpha(i);
        }

        public final void setColorFilter(ColorFilter colorFilter) {
            this.f2542f.setColorFilter(colorFilter);
        }
    }

    public C1022b(int i) {
        this(i, (byte) 0);
    }

    private C1022b(int i, byte b) {
        this.f2543a = i;
        this.f2544b = 0;
    }

    /* renamed from: a */
    public final void mo6234a(Bitmap bitmap, C1026a c1026a) {
        if (c1026a instanceof C1028b) {
            c1026a.mo6253a(new C1021a(bitmap, this.f2543a, this.f2544b));
            return;
        }
        throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
    }
}
