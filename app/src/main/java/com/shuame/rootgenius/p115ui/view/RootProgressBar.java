package com.shuame.rootgenius.p115ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.support.p015v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import com.shuame.rootgenius.common.p087ui.view.C1378a;
import com.shuame.rootgenius.common.p087ui.view.C1378a.C1177a;

/* renamed from: com.shuame.rootgenius.ui.view.RootProgressBar */
public class RootProgressBar extends View implements C1177a {
    /* renamed from: A */
    private float f4498A;
    /* renamed from: B */
    private Canvas f4499B;
    /* renamed from: C */
    private Paint f4500C;
    /* renamed from: D */
    private Shader f4501D;
    /* renamed from: a */
    private float f4502a;
    /* renamed from: b */
    private Paint f4503b;
    /* renamed from: c */
    private int f4504c;
    /* renamed from: d */
    private int f4505d;
    /* renamed from: e */
    private int f4506e;
    /* renamed from: f */
    private int f4507f;
    /* renamed from: g */
    private float f4508g;
    /* renamed from: h */
    private float f4509h;
    /* renamed from: i */
    private float f4510i;
    /* renamed from: j */
    private float f4511j;
    /* renamed from: k */
    private float f4512k;
    /* renamed from: l */
    private float f4513l;
    /* renamed from: m */
    private Bitmap f4514m;
    /* renamed from: n */
    private Bitmap f4515n;
    /* renamed from: o */
    private int f4516o;
    /* renamed from: p */
    private int f4517p;
    /* renamed from: q */
    private int f4518q;
    /* renamed from: r */
    private int f4519r;
    /* renamed from: s */
    private float f4520s;
    /* renamed from: t */
    private float f4521t;
    /* renamed from: u */
    private Rect f4522u;
    /* renamed from: v */
    private int f4523v;
    /* renamed from: w */
    private int f4524w;
    /* renamed from: x */
    private int f4525x;
    /* renamed from: y */
    private String f4526y;
    /* renamed from: z */
    private float f4527z;

    public RootProgressBar(Context context) {
        this(context, null);
    }

    public RootProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RootProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4516o = 0;
        this.f4517p = 0;
        this.f4518q = 0;
        this.f4519r = 360;
        this.f4520s = ((float) this.f4519r) / 100.0f;
        this.f4521t = 1.8f;
        this.f4526y = "%";
    }

    private RectF getArcRect() {
        float f = this.f4510i * 2.0f;
        return new RectF(this.f4512k, this.f4513l, this.f4512k + f, f + this.f4513l);
    }

    /* renamed from: a */
    public final void mo6801a(float f) {
        this.f4502a = f;
        this.f4516o = (int) (((float) this.f4517p) + (((float) (this.f4518q - this.f4517p)) * this.f4502a));
        invalidate();
    }

    /* renamed from: a */
    public final void mo7545a(int i) {
        clearAnimation();
        Animation c1378a = new C1378a(this);
        this.f4517p = this.f4516o;
        this.f4518q = i;
        c1378a.setDuration((long) ((Math.abs((float) (i - this.f4516o)) * this.f4520s) * this.f4521t));
        c1378a.setInterpolator(new LinearInterpolator());
        startAnimation(c1378a);
    }

    protected void onDraw(Canvas canvas) {
        if (!isInEditMode()) {
            this.f4503b.setStyle(Style.FILL);
            this.f4503b.setColor(-1);
            canvas.drawCircle((float) this.f4506e, (float) this.f4507f, (float) Math.min(this.f4506e, this.f4507f), this.f4503b);
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) this.f4504c, (float) this.f4505d, null, 31);
            if (this.f4501D == null) {
                this.f4501D = new LinearGradient((float) this.f4506e, 0.0f, (float) this.f4506e, (float) this.f4505d, Color.parseColor("#00C85D"), Color.parseColor("#00ACD1"), TileMode.CLAMP);
            }
            if (this.f4514m == null) {
                this.f4514m = Bitmap.createBitmap(this.f4504c, this.f4505d, Config.ARGB_8888);
                this.f4499B = new Canvas(this.f4514m);
                this.f4500C = new Paint();
                this.f4500C.setAntiAlias(true);
                this.f4500C.setStyle(Style.STROKE);
                this.f4500C.setStrokeWidth(this.f4511j);
                this.f4500C.setShader(this.f4501D);
            }
            this.f4499B.rotate(5.0f, (float) this.f4506e, (float) this.f4507f);
            this.f4499B.drawCircle((float) this.f4506e, (float) this.f4507f, this.f4510i, this.f4500C);
            this.f4503b.setColor(-1);
            canvas.drawBitmap(this.f4514m, 0.0f, 0.0f, this.f4503b);
            if (this.f4515n == null) {
                this.f4515n = Bitmap.createBitmap(this.f4504c, this.f4505d, Config.ARGB_8888);
            }
            Canvas canvas2 = new Canvas(this.f4515n);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Style.STROKE);
            paint.setStrokeWidth(this.f4511j);
            paint.setColor(-1);
            float f = ((float) this.f4516o) * this.f4520s;
            canvas2.drawColor(-1, Mode.CLEAR);
            canvas2.drawArc(getArcRect(), -90.0f, f, false, paint);
            this.f4503b.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
            canvas.drawBitmap(this.f4515n, 0.0f, 0.0f, this.f4503b);
            this.f4503b.setXfermode(null);
            canvas.restoreToCount(saveLayer);
            this.f4503b.setStyle(Style.STROKE);
            this.f4503b.setColor(Color.argb(38, 0, 0, 0));
            this.f4503b.setStrokeWidth(this.f4509h);
            canvas.drawCircle((float) this.f4506e, (float) this.f4507f, this.f4508g, this.f4503b);
            this.f4503b.reset();
            this.f4503b.setAntiAlias(true);
            this.f4503b.setColor(ViewCompat.MEASURED_STATE_MASK);
            this.f4503b.setTextSize(this.f4527z);
            this.f4503b.setTextAlign(Align.CENTER);
            this.f4503b.getTextBounds(String.valueOf(this.f4516o), 0, String.valueOf(this.f4516o).length(), this.f4522u);
            int i = this.f4507f - (this.f4523v / 2);
            canvas.drawText(this.f4516o, (float) this.f4506e, (float) i, this.f4503b);
            float f2 = this.f4516o > 99 ? 0.196f : this.f4516o > 9 ? 0.15f : 0.1f;
            this.f4503b.setTextSize(this.f4498A);
            canvas.drawText(this.f4526y, (float) ((int) ((f2 * ((float) this.f4504c)) + ((float) (this.f4504c / 2)))), (float) ((i + this.f4523v) - this.f4525x), this.f4503b);
            invalidate();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        FontMetricsInt fontMetricsInt;
        super.onLayout(z, i, i2, i3, i4);
        if (this.f4503b == null) {
            this.f4503b = new Paint();
            this.f4503b.setAntiAlias(true);
            this.f4522u = new Rect();
        }
        this.f4504c = getWidth();
        this.f4505d = getHeight();
        this.f4506e = this.f4504c / 2;
        this.f4507f = this.f4505d / 2;
        this.f4509h = (float) Math.floor((double) (((float) this.f4505d) * 0.03f));
        this.f4508g = ((float) this.f4507f) * 0.85f;
        this.f4511j = (((float) this.f4507f) - this.f4508g) + (this.f4509h / 2.0f);
        this.f4510i = ((float) this.f4507f) - (this.f4511j / 2.0f);
        this.f4512k = (((float) this.f4504c) - (this.f4510i * 2.0f)) / 2.0f;
        this.f4513l = (((float) this.f4505d) - (this.f4510i * 2.0f)) / 2.0f;
        if (this.f4523v == 0) {
            this.f4527z = ((float) this.f4505d) * 0.28f;
            this.f4503b.setTextSize(this.f4527z);
            fontMetricsInt = this.f4503b.getFontMetricsInt();
            this.f4523v = fontMetricsInt.descent + fontMetricsInt.ascent;
        }
        if (this.f4524w == 0) {
            this.f4498A = this.f4527z * 0.4f;
            this.f4503b.setTextSize(this.f4498A);
            Rect rect = new Rect();
            this.f4503b.getTextBounds(this.f4526y, 0, 1, rect);
            this.f4524w = rect.right;
            fontMetricsInt = this.f4503b.getFontMetricsInt();
            this.f4525x = fontMetricsInt.descent + fontMetricsInt.ascent;
        }
    }
}
