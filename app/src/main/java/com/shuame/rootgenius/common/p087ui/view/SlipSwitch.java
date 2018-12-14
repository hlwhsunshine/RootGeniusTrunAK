package com.shuame.rootgenius.common.p087ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import com.shuame.rootgenius.common.C1335e.C1329b;
import com.shuame.rootgenius.common.C1335e.C1334g;

/* renamed from: com.shuame.rootgenius.common.ui.view.SlipSwitch */
public class SlipSwitch extends View implements OnTouchListener {
    /* renamed from: a */
    boolean f3832a = false;
    /* renamed from: b */
    private Bitmap f3833b;
    /* renamed from: c */
    private Bitmap f3834c;
    /* renamed from: d */
    private Bitmap f3835d;
    /* renamed from: e */
    private Paint f3836e;
    /* renamed from: f */
    private Matrix f3837f;
    /* renamed from: g */
    private ViewParent f3838g;
    /* renamed from: h */
    private boolean f3839h = false;
    /* renamed from: i */
    private boolean f3840i = false;
    /* renamed from: j */
    private float f3841j;
    /* renamed from: k */
    private float f3842k;
    /* renamed from: l */
    private C1166a f3843l;

    /* renamed from: com.shuame.rootgenius.common.ui.view.SlipSwitch$a */
    public interface C1166a {
        /* renamed from: a */
        void mo6777a(View view, boolean z);
    }

    public SlipSwitch(Context context) {
        super(context);
        m3842a(C1329b.slipswitch_on_bg_common_module, C1329b.slipswitch_off_bg_common_module, C1329b.slipswitch_icon_common_module);
    }

    public SlipSwitch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1334g.SlipSwitch, 0, 0);
        m3842a(obtainStyledAttributes.getResourceId(C1334g.SlipSwitch_slipswitch_on_bg, C1329b.slipswitch_on_bg_common_module), obtainStyledAttributes.getResourceId(C1334g.SlipSwitch_slipswitch_off_bg, C1329b.slipswitch_off_bg_common_module), obtainStyledAttributes.getResourceId(C1334g.SlipSwitch_slipswitch_icon, C1329b.slipswitch_icon_common_module));
    }

    /* renamed from: a */
    private void m3842a(int i, int i2, int i3) {
        setOnTouchListener(this);
        try {
            this.f3833b = BitmapFactory.decodeResource(getResources(), i);
            this.f3834c = BitmapFactory.decodeResource(getResources(), i2);
            this.f3835d = BitmapFactory.decodeResource(getResources(), i3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f3836e = new Paint();
        this.f3837f = new Matrix();
        this.f3838g = getParent();
    }

    public boolean getSwitchState() {
        return this.f3840i;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f3833b != null && this.f3835d != null) {
            Bitmap bitmap = this.f3840i ? this.f3833b : this.f3834c;
            canvas.drawBitmap(bitmap, this.f3837f, this.f3836e);
            float width = this.f3839h ? this.f3842k > ((float) bitmap.getWidth()) ? (float) (bitmap.getWidth() - this.f3835d.getWidth()) : this.f3842k - ((float) (this.f3835d.getWidth() / 2)) : this.f3840i ? (float) (bitmap.getWidth() - this.f3835d.getWidth()) : 0.0f;
            float width2 = width < 0.0f ? 0.0f : width > ((float) (bitmap.getWidth() - this.f3835d.getWidth())) ? (float) (bitmap.getWidth() - this.f3835d.getWidth()) : width;
            canvas.drawBitmap(this.f3835d, width2, 0.0f, this.f3836e);
        }
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.f3833b.getWidth(), this.f3833b.getHeight());
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (motionEvent.getX() <= ((float) this.f3833b.getWidth()) && motionEvent.getY() <= ((float) this.f3833b.getHeight())) {
                    this.f3841j = motionEvent.getX();
                    this.f3842k = this.f3841j;
                    break;
                }
                return false;
                break;
            case 1:
            case 3:
                boolean z;
                SlipSwitch slipSwitch;
                boolean z2 = this.f3840i;
                SlipSwitch slipSwitch2;
                if (this.f3839h) {
                    if (motionEvent.getX() >= ((float) (this.f3833b.getWidth() / 2))) {
                        z = true;
                        slipSwitch = this;
                    } else {
                        slipSwitch2 = this;
                        slipSwitch = slipSwitch2;
                        z = false;
                    }
                } else if (this.f3840i) {
                    slipSwitch2 = this;
                    slipSwitch = slipSwitch2;
                    z = false;
                } else {
                    z = true;
                    slipSwitch = this;
                }
                slipSwitch.f3840i = z;
                this.f3839h = false;
                if (!(this.f3843l == null || z2 == this.f3840i)) {
                    this.f3843l.mo6777a(this, this.f3840i);
                }
                if (this.f3838g != null) {
                    this.f3838g.requestDisallowInterceptTouchEvent(false);
                    break;
                }
                break;
            case 2:
                if (this.f3838g != null) {
                    this.f3838g.requestDisallowInterceptTouchEvent(true);
                }
                this.f3842k = motionEvent.getX();
                if (Math.abs(this.f3841j - this.f3842k) > 2.0f) {
                    this.f3839h = true;
                    break;
                }
                break;
        }
        invalidate();
        return true;
    }

    public void setChecked(boolean z) {
        if (this.f3840i != z) {
            this.f3840i = z;
            invalidate();
            if (this.f3843l != null) {
                this.f3843l.mo6777a(this, this.f3840i);
            }
        }
    }

    public void setCheckedWithoutSwitchListener(boolean z) {
        if (this.f3840i != z) {
            this.f3840i = z;
            invalidate();
        }
    }

    public void setOnSwitchListener(C1166a c1166a) {
        this.f3843l = c1166a;
    }

    public void setSwitchState(boolean z) {
        this.f3840i = z;
    }
}
