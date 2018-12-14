package com.shuame.mobile.module.autoboot.p085ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.shuame.mobile.module.autoboot.p085ui.AutoBootManagerActivity.CheckState;
import com.shuame.rootgenius.common.p087ui.view.C1378a;
import com.shuame.rootgenius.common.p087ui.view.C1378a.C1177a;
import com.shuame.rootgenius.common.p087ui.view.C1382e;
import com.shuame.rootgenius.p098b.C1312a.C1308b;

/* renamed from: com.shuame.mobile.module.autoboot.ui.view.FlowMarkView */
public class FlowMarkView extends View {
    /* renamed from: a */
    private Paint f3127a;
    /* renamed from: b */
    private int f3128b;
    /* renamed from: c */
    private int f3129c;
    /* renamed from: d */
    private C1182a f3130d;
    /* renamed from: e */
    private C1378a f3131e;
    /* renamed from: f */
    private float f3132f;
    /* renamed from: g */
    private Bitmap f3133g;
    /* renamed from: h */
    private int f3134h;
    /* renamed from: i */
    private int f3135i;
    /* renamed from: j */
    private int f3136j;
    /* renamed from: k */
    private int f3137k;
    /* renamed from: l */
    private float f3138l;
    /* renamed from: m */
    private float f3139m;
    /* renamed from: n */
    private RectF f3140n;
    /* renamed from: o */
    private int f3141o;
    /* renamed from: p */
    private CheckState f3142p = CheckState.normal;
    /* renamed from: q */
    private String f3143q = "Hello Baby";
    /* renamed from: r */
    private int f3144r;
    /* renamed from: s */
    private C1378a f3145s;
    /* renamed from: t */
    private float f3146t;
    /* renamed from: u */
    private float f3147u;
    /* renamed from: v */
    private int f3148v;
    /* renamed from: w */
    private int f3149w;
    /* renamed from: x */
    private int f3150x = 1;
    /* renamed from: y */
    private boolean f3151y;
    /* renamed from: z */
    private SweepGradient f3152z;

    /* renamed from: com.shuame.mobile.module.autoboot.ui.view.FlowMarkView$a */
    private class C1178a implements C1177a {
        private C1178a() {
        }

        /* synthetic */ C1178a(FlowMarkView flowMarkView, byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo6801a(float f) {
            FlowMarkView.m3379b(FlowMarkView.this, f);
            FlowMarkView.this.invalidate();
        }
    }

    /* renamed from: com.shuame.mobile.module.autoboot.ui.view.FlowMarkView$b */
    private class C1179b implements C1177a {
        private C1179b() {
        }

        /* synthetic */ C1179b(FlowMarkView flowMarkView, byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo6801a(float f) {
            FlowMarkView.this.f3132f = 360.0f * f;
            FlowMarkView.this.invalidate();
        }
    }

    public FlowMarkView(Context context) {
        super(context);
        m3380d();
    }

    public FlowMarkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3380d();
    }

    public FlowMarkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3380d();
    }

    /* renamed from: a */
    private static float m3374a(float f, float f2, float f3) {
        return f < 0.0f ? f2 : f2 + (((f - 0.0f) / 1.0f) * (f3 - f2));
    }

    /* renamed from: a */
    private void m3375a(Canvas canvas) {
        m3378b(canvas);
        if (this.f3150x > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 2) {
                    break;
                }
                float f;
                if (i2 == 0) {
                    f = this.f3146t;
                    i = this.f3148v;
                } else {
                    f = this.f3147u;
                    i = this.f3149w;
                }
                float f2 = this.f3139m + (f / 2.0f);
                this.f3127a.reset();
                this.f3127a.setShader(null);
                this.f3127a.setColor(-1);
                this.f3127a.setAntiAlias(true);
                this.f3127a.setStyle(Style.STROKE);
                this.f3127a.setStrokeWidth(f);
                this.f3127a.setAlpha(i);
                canvas.save();
                canvas.drawCircle((float) this.f3136j, (float) this.f3137k, f2, this.f3127a);
                canvas.restore();
                i = i2 + 1;
            }
        }
        canvas.save();
        this.f3127a.reset();
        this.f3127a.setAlpha(255);
        this.f3127a.setAntiAlias(true);
        if (this.f3150x > 0) {
            int i3 = (int) ((this.f3139m * 1.0f) / 3.0f);
            Canvas canvas2 = canvas;
            m3376a(canvas2, "一键禁止", this.f3136j, this.f3137k + (i3 / 2), i3);
        } else {
            canvas.drawBitmap(this.f3133g, (float) (this.f3136j - (this.f3133g.getWidth() / 2)), (float) (this.f3137k - (this.f3133g.getHeight() / 2)), this.f3127a);
        }
        canvas.restore();
    }

    /* renamed from: a */
    private void m3376a(Canvas canvas, String str, int i, int i2, int i3) {
        this.f3127a.reset();
        this.f3127a.setShader(null);
        this.f3127a.setAntiAlias(true);
        this.f3127a.setColor(-1);
        this.f3127a.setTextSize((float) i3);
        this.f3127a.setTextAlign(Align.CENTER);
        canvas.drawText(str, (float) i, (float) i2, this.f3127a);
    }

    /* renamed from: b */
    private void m3378b(Canvas canvas) {
        this.f3127a.reset();
        this.f3127a.setShader(null);
        this.f3127a.setColor(-1);
        this.f3127a.setAntiAlias(true);
        this.f3127a.setStyle(Style.FILL);
        this.f3127a.setStrokeWidth(1.0f);
        this.f3127a.setAlpha(40);
        canvas.save();
        canvas.drawCircle((float) this.f3136j, (float) this.f3137k, this.f3139m, this.f3127a);
        canvas.restore();
    }

    /* renamed from: b */
    static /* synthetic */ void m3379b(FlowMarkView flowMarkView, float f) {
        float f2 = ((float) flowMarkView.f3144r) - flowMarkView.f3139m;
        flowMarkView.f3146t = FlowMarkView.m3374a(f, 0.0f, f2);
        flowMarkView.f3148v = (int) FlowMarkView.m3374a(f, 30.0f, 5.0f);
        float f3 = f - 0.5f;
        flowMarkView.f3147u = FlowMarkView.m3374a(f3, 0.0f, f2);
        flowMarkView.f3149w = (int) FlowMarkView.m3374a(f3, 16.0f, 0.0f);
    }

    /* renamed from: d */
    private void m3380d() {
        this.f3127a = new Paint();
        this.f3133g = BitmapFactory.decodeResource(getResources(), C1308b.boot_finish);
        this.f3128b = (int) (getContext().getResources().getDisplayMetrics().density * 14.0f);
        this.f3129c = C1382e.m3848a(getContext(), 90);
        this.f3130d = new C1182a(this);
        this.f3131e = new C1378a(new C1179b(this, (byte) 0));
        this.f3131e.setInterpolator(new LinearInterpolator());
        this.f3131e.setDuration(2000);
        this.f3131e.setRepeatCount(-1);
        this.f3145s = new C1378a(new C1178a(this, (byte) 0));
        this.f3145s.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f3145s.setDuration(2000);
        this.f3145s.setRepeatCount(-1);
        startAnimation(this.f3145s);
    }

    private RectF getSweepArcRect() {
        return new RectF(((float) this.f3136j) - this.f3138l, ((float) this.f3137k) - this.f3138l, ((float) this.f3136j) + this.f3138l, ((float) this.f3137k) + this.f3138l);
    }

    /* renamed from: a */
    public final void mo6802a() {
        if (!(this.f3133g == null || this.f3133g.isRecycled())) {
            this.f3133g.recycle();
        }
        if (this.f3130d != null) {
            this.f3130d.mo6811a();
        }
    }

    /* renamed from: b */
    public final void mo6803b() {
        clearAnimation();
        this.f3142p = CheckState.check;
        startAnimation(this.f3131e);
    }

    /* renamed from: c */
    public final void mo6804c() {
        clearAnimation();
        this.f3142p = CheckState.normal;
        startAnimation(this.f3145s);
    }

    public int getAppNum() {
        return this.f3150x;
    }

    protected void onDraw(Canvas canvas) {
        if (this.f3142p == CheckState.check) {
            this.f3151y = false;
            int i = (int) ((this.f3139m * 1.0f) / 4.0f);
            int i2 = (int) ((this.f3139m * 1.0f) / 2.0f);
            canvas.save();
            m3376a(canvas, this.f3130d.mo6813b(), this.f3136j, this.f3137k + (i2 / 3), i2);
            Canvas canvas2 = canvas;
            m3376a(canvas2, "%", (this.f3136j + i2) + (i / 2), this.f3137k + i, i);
            canvas.restore();
            m3378b(canvas);
            if (this.f3152z == null) {
                this.f3152z = new SweepGradient((float) this.f3136j, (float) this.f3137k, new int[]{Color.argb(0, 255, 255, 255), Color.argb(64, 255, 255, 255), Color.argb(128, 255, 255, 255)}, null);
            }
            this.f3127a.reset();
            this.f3127a.setAntiAlias(true);
            this.f3127a.setStyle(Style.FILL);
            this.f3127a.setShader(this.f3152z);
            this.f3127a.setAlpha(128);
            canvas.save();
            canvas.rotate(this.f3132f, (float) this.f3136j, (float) this.f3137k);
            canvas.drawArc(this.f3140n, 30.0f, 240.0f, true, this.f3127a);
            canvas.restore();
        } else if (this.f3142p == CheckState.normal) {
            m3375a(canvas);
        }
        if (this.f3142p == CheckState.check) {
            this.f3143q = "正在检测自启软件";
        } else if (this.f3150x > 0) {
            this.f3143q = this.f3150x + "个自启软件建议禁止";
        } else {
            this.f3143q = "没有需要禁止的自启软件";
        }
        m3376a(canvas, this.f3143q, this.f3136j, this.f3141o, this.f3128b);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f3134h = MeasureSpec.getSize(i);
        this.f3135i = MeasureSpec.getSize(i2) - this.f3129c;
        this.f3136j = this.f3134h / 2;
        this.f3137k = this.f3135i / 2;
        this.f3144r = Math.min(this.f3134h, this.f3135i) / 2;
        this.f3139m = ((float) this.f3144r) * 0.6f;
        this.f3138l = this.f3139m + (0.065f * this.f3139m);
        this.f3140n = getSweepArcRect();
        this.f3141o = ((this.f3137k + ((int) this.f3138l)) + (this.f3129c / 2)) + (this.f3128b / 2);
    }

    public void setAppNum(int i) {
        this.f3150x = i;
    }

    public void setCheckProgress(int i) {
        this.f3130d.mo6812a(i);
    }
}
