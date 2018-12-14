package com.baidu.mobads;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.widget.ImageView;

/* renamed from: com.baidu.mobads.ae */
class C0248ae extends ImageView {
    /* renamed from: a */
    int f400a = 0;
    /* renamed from: b */
    RectF f401b = new RectF();
    /* renamed from: c */
    private final Paint f402c;
    /* renamed from: d */
    private final Context f403d;

    public C0248ae(Context context) {
        super(context);
        this.f403d = context;
        this.f402c = new Paint();
        this.f402c.setAntiAlias(true);
        this.f402c.setStyle(Style.STROKE);
    }

    /* renamed from: a */
    public static int m324a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    protected void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        int a = C0248ae.m324a(this.f403d, 15.0f);
        int a2 = C0248ae.m324a(this.f403d, 4.0f);
        this.f401b.left = (float) (width - ((a + 1) + (a2 / 2)));
        this.f401b.top = (float) (width - ((a + 1) + (a2 / 2)));
        this.f401b.right = (float) (((a + 1) + (a2 / 2)) + width);
        this.f401b.bottom = (float) (width + ((a + 1) + (a2 / 2)));
        this.f402c.setColor(-1907998);
        this.f402c.setStrokeWidth((float) a2);
        canvas.drawArc(this.f401b, (float) (this.f400a + 0), 72.0f, false, this.f402c);
        this.f402c.setColor(-1594427658);
        canvas.drawArc(this.f401b, (float) (this.f400a + 72), 270.0f, false, this.f402c);
        this.f400a += 10;
        if (this.f400a >= 360) {
            this.f400a = 0;
        }
        super.onDraw(canvas);
        invalidate();
    }
}
