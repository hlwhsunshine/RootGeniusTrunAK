package com.shuame.rootgenius.p115ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import com.shuame.rootgenius.common.p087ui.view.C1378a;
import com.shuame.rootgenius.common.p087ui.view.C1378a.C1177a;
import com.shuame.rootgenius.hook.C1450R;

/* renamed from: com.shuame.rootgenius.ui.view.ScanView */
public class ScanView extends View implements C1177a {
    /* renamed from: a */
    private final long f4528a;
    /* renamed from: b */
    private final float f4529b;
    /* renamed from: c */
    private float f4530c;
    /* renamed from: d */
    private Paint f4531d;
    /* renamed from: e */
    private int f4532e;
    /* renamed from: f */
    private int f4533f;
    /* renamed from: g */
    private int f4534g;
    /* renamed from: h */
    private int f4535h;
    /* renamed from: i */
    private Bitmap f4536i;
    /* renamed from: j */
    private Bitmap f4537j;
    /* renamed from: k */
    private int f4538k;
    /* renamed from: l */
    private int[] f4539l;
    /* renamed from: m */
    private int[] f4540m;
    /* renamed from: n */
    private float[] f4541n;
    /* renamed from: o */
    private RectF f4542o;
    /* renamed from: p */
    private PorterDuffXfermode f4543p;
    /* renamed from: q */
    private SweepGradient f4544q;

    public ScanView(Context context) {
        this(context, null);
    }

    public ScanView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScanView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4528a = 800;
        this.f4529b = 0.85f;
        this.f4538k = 4;
    }

    /* renamed from: a */
    private Bitmap m4379a(int i) {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i);
        int width = decodeResource.getWidth();
        int height = decodeResource.getHeight();
        int i2 = (int) (((float) this.f4533f) * 0.85f);
        float f = ((float) i2) / ((float) width);
        float f2 = ((float) i2) / ((float) height);
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        return Bitmap.createBitmap(decodeResource, 0, 0, width, height, matrix, true);
    }

    private RectF getRectF() {
        return new RectF(0.0f, 0.0f, (float) this.f4532e, (float) this.f4533f);
    }

    /* renamed from: a */
    public final void mo6801a(float f) {
        this.f4530c = f;
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        if (!isInEditMode()) {
            if (this.f4536i == null) {
                this.f4536i = m4379a((int) C1450R.drawable.scan_bg);
            }
            canvas.drawBitmap(this.f4536i, (float) (this.f4534g - (this.f4536i.getWidth() / 2)), (float) (this.f4535h - (this.f4536i.getHeight() / 2)), this.f4531d);
            if (this.f4537j == null) {
                this.f4537j = m4379a((int) C1450R.drawable.scan_pointer);
            }
            int width = this.f4534g - (this.f4537j.getWidth() / 2);
            int height = this.f4535h - (this.f4537j.getHeight() / 2);
            float f = (this.f4530c * 360.0f) * 2684354.0f;
            canvas.save();
            canvas.rotate(f, (float) this.f4534g, (float) this.f4535h);
            canvas.drawBitmap(this.f4537j, (float) width, (float) height, this.f4531d);
            canvas.restore();
            height = canvas.saveLayer(0.0f, 0.0f, (float) this.f4532e, (float) this.f4533f, null, 31);
            for (width = 0; width < this.f4538k; width++) {
                canvas.save();
                this.f4531d.setColor(-1);
                canvas.drawCircle((float) this.f4539l[width], (float) this.f4540m[width], this.f4541n[width], this.f4531d);
                canvas.restore();
            }
            float f2 = (this.f4530c * 360.0f) * 2684354.0f;
            if (this.f4544q == null) {
                this.f4544q = new SweepGradient((float) this.f4534g, (float) this.f4535h, Color.parseColor("#72D7A1"), -1);
            }
            this.f4531d.setShader(this.f4544q);
            if (this.f4542o == null) {
                this.f4542o = getRectF();
            }
            if (this.f4543p == null) {
                this.f4543p = new PorterDuffXfermode(Mode.SRC_IN);
            }
            this.f4531d.setXfermode(this.f4543p);
            canvas.save();
            canvas.rotate(f2, (float) this.f4534g, (float) this.f4535h);
            canvas.drawArc(this.f4542o, 0.0f, 360.0f, true, this.f4531d);
            canvas.restore();
            this.f4531d.setShader(null);
            this.f4531d.setXfermode(null);
            canvas.restoreToCount(height);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f4532e = getWidth();
        this.f4533f = getHeight();
        this.f4534g = this.f4532e / 2;
        this.f4535h = this.f4533f / 2;
        if (this.f4536i == null) {
            this.f4536i = m4379a((int) C1450R.drawable.scan_bg);
        }
        if (this.f4539l == null || this.f4540m == null) {
            this.f4539l = new int[this.f4538k];
            this.f4540m = new int[this.f4538k];
            this.f4541n = new float[this.f4538k];
            int width = this.f4536i.getWidth();
            int height = this.f4536i.getHeight();
            int i5 = 0;
            while (i5 < 4) {
                int random = (int) ((Math.random() * ((double) width)) / 2.0d);
                int random2 = (int) ((Math.random() * ((double) height)) / 2.0d);
                int[] iArr = null;
                switch (i5) {
                    case 0:
                        iArr = new int[]{1, 1};
                        break;
                    case 1:
                        iArr = new int[]{-1, 1};
                        break;
                    case 2:
                        iArr = new int[]{1, -1};
                        break;
                    case 3:
                        iArr = new int[]{-1, -1};
                        break;
                }
                this.f4539l[i5] = (random * iArr[0]) + this.f4534g;
                this.f4540m[i5] = (iArr[1] * random2) + this.f4535h;
                this.f4541n[i5] = (float) (((Math.random() * ((double) this.f4532e)) / 320.0d) + ((double) (this.f4532e / 320)));
                float f = (float) (height / 2);
                float abs = (float) Math.abs(this.f4539l[i5] - this.f4534g);
                float abs2 = (float) Math.abs(this.f4540m[i5] - this.f4535h);
                float sqrt = (float) Math.sqrt((double) ((abs * abs) + (abs2 * abs2)));
                float f2 = 0.2f * f;
                f *= 0.8f;
                Object obj = (sqrt >= f || sqrt <= f2 || abs <= f2 || abs >= f || abs2 <= f2 || abs2 >= f) ? null : 1;
                i5 = obj != null ? i5 + 1 : i5;
            }
        }
        if (this.f4531d == null) {
            this.f4531d = new Paint();
            this.f4531d.setAntiAlias(true);
            Animation c1378a = new C1378a(this);
            c1378a.setInterpolator(new LinearInterpolator());
            c1378a.setRepeatCount(-1);
            c1378a.setDuration(2147483647L);
            c1378a.setInterpolator(new LinearInterpolator());
            super.startAnimation(c1378a);
        }
    }
}
