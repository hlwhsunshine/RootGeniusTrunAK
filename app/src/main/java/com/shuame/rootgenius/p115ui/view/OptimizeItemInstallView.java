package com.shuame.rootgenius.p115ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import com.shuame.rootgenius.common.p087ui.view.C1378a;
import com.shuame.rootgenius.common.p087ui.view.C1378a.C1177a;

/* renamed from: com.shuame.rootgenius.ui.view.OptimizeItemInstallView */
public class OptimizeItemInstallView extends View implements C1177a {
    /* renamed from: a */
    private final long f4478a = 800;
    /* renamed from: b */
    private final float f4479b = 0.85f;
    /* renamed from: c */
    private float f4480c;
    /* renamed from: d */
    private Paint f4481d;
    /* renamed from: e */
    private int f4482e;
    /* renamed from: f */
    private int f4483f;
    /* renamed from: g */
    private int f4484g;
    /* renamed from: h */
    private int f4485h;
    /* renamed from: i */
    private RectF f4486i;
    /* renamed from: j */
    private float f4487j;

    public OptimizeItemInstallView(Context context) {
        super(context);
    }

    public OptimizeItemInstallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OptimizeItemInstallView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m4372a() {
        clearAnimation();
        Animation c1378a = new C1378a(this);
        c1378a.setInterpolator(new LinearInterpolator());
        c1378a.setRepeatCount(-1);
        c1378a.setDuration(2147483647L);
        c1378a.setInterpolator(new LinearInterpolator());
        super.startAnimation(c1378a);
    }

    private RectF getArcRect() {
        float f = 0.1f * ((float) this.f4483f);
        return new RectF((this.f4487j * 0.5f) + f, (this.f4487j * 0.5f) + f, (((float) this.f4482e) - (this.f4487j * 0.5f)) - f, (((float) this.f4483f) - (this.f4487j * 0.5f)) - f);
    }

    /* renamed from: a */
    public final void mo6801a(float f) {
        this.f4480c = f;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        if (!isInEditMode()) {
            float f = (this.f4480c * 360.0f) * 2684354.0f;
            this.f4481d.setAntiAlias(true);
            this.f4481d.setStyle(Style.STROKE);
            this.f4481d.setStrokeWidth(this.f4487j);
            this.f4481d.setColor(Color.parseColor("#00C85D"));
            canvas.rotate(f, (float) this.f4484g, (float) this.f4485h);
            canvas.drawArc(this.f4486i, 0.0f, 334.8f, false, this.f4481d);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f4482e = getWidth();
        this.f4483f = getHeight();
        this.f4484g = this.f4482e / 2;
        this.f4485h = this.f4483f / 2;
        if (this.f4481d == null) {
            this.f4481d = new Paint();
            this.f4481d.setAntiAlias(true);
        }
        this.f4487j = ((float) this.f4483f) * 0.05f;
        if (this.f4486i == null) {
            this.f4486i = getArcRect();
        }
        m4372a();
    }

    public void setVisibility(int i) {
        if (i == 0) {
            m4372a();
        } else {
            clearAnimation();
        }
        super.setVisibility(i);
    }
}
