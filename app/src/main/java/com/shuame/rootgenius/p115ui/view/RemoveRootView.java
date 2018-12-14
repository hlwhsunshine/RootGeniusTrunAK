package com.shuame.rootgenius.p115ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import com.shuame.rootgenius.common.p087ui.view.C1378a;
import com.shuame.rootgenius.common.p087ui.view.C1378a.C1177a;
import com.shuame.rootgenius.hook.C1450R;

/* renamed from: com.shuame.rootgenius.ui.view.RemoveRootView */
public class RemoveRootView extends View implements C1177a {
    /* renamed from: a */
    private final long f4488a = 1000;
    /* renamed from: b */
    private final float f4489b = 0.85f;
    /* renamed from: c */
    private float f4490c;
    /* renamed from: d */
    private Paint f4491d;
    /* renamed from: e */
    private int f4492e;
    /* renamed from: f */
    private int f4493f;
    /* renamed from: g */
    private int f4494g;
    /* renamed from: h */
    private int f4495h;
    /* renamed from: i */
    private Bitmap f4496i;
    /* renamed from: j */
    private Bitmap f4497j;

    public RemoveRootView(Context context) {
        super(context);
    }

    public RemoveRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RemoveRootView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    private Bitmap m4374a(int i) {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i);
        int width = decodeResource.getWidth();
        int height = decodeResource.getHeight();
        int i2 = (int) (((float) this.f4493f) * 0.85f);
        float f = ((float) i2) / ((float) width);
        float f2 = ((float) i2) / ((float) height);
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        return Bitmap.createBitmap(decodeResource, 0, 0, width, height, matrix, true);
    }

    /* renamed from: a */
    public final void mo7542a() {
        Animation c1378a = new C1378a(this);
        c1378a.setInterpolator(new LinearInterpolator());
        c1378a.setRepeatCount(-1);
        c1378a.setDuration(2147483647L);
        c1378a.setInterpolator(new LinearInterpolator());
        super.startAnimation(c1378a);
    }

    /* renamed from: a */
    public final void mo6801a(float f) {
        this.f4490c = f;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        if (!isInEditMode()) {
            if (this.f4496i == null) {
                this.f4496i = m4374a((int) C1450R.drawable.delete_bg);
            }
            canvas.drawBitmap(this.f4496i, (float) (this.f4494g - (this.f4496i.getWidth() / 2)), (float) (this.f4495h - (this.f4496i.getHeight() / 2)), this.f4491d);
            if (this.f4497j == null) {
                this.f4497j = m4374a((int) C1450R.drawable.delete_arc);
            }
            int width = this.f4494g - (this.f4497j.getWidth() / 2);
            int height = this.f4495h - (this.f4497j.getHeight() / 2);
            canvas.rotate((this.f4490c * 360.0f) * 2147483.0f, (float) this.f4494g, (float) this.f4495h);
            canvas.drawBitmap(this.f4497j, (float) width, (float) height, this.f4491d);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f4492e = getWidth();
        this.f4493f = getHeight();
        this.f4494g = this.f4492e / 2;
        this.f4495h = this.f4493f / 2;
        if (this.f4491d == null) {
            this.f4491d = new Paint();
            this.f4491d.setAntiAlias(true);
        }
    }
}
