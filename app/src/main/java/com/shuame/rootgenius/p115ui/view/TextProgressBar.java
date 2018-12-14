package com.shuame.rootgenius.p115ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.shuame.rootgenius.C1249a.C1242a;
import com.shuame.rootgenius.common.util.C1413u;

/* renamed from: com.shuame.rootgenius.ui.view.TextProgressBar */
public class TextProgressBar extends ProgressBar {
    /* renamed from: a */
    private String f4552a;
    /* renamed from: b */
    private Paint f4553b;
    /* renamed from: c */
    private boolean f4554c;
    /* renamed from: d */
    private TextAlign f4555d;
    /* renamed from: e */
    private int f4556e;
    /* renamed from: f */
    private int f4557f;
    /* renamed from: g */
    private int f4558g;
    /* renamed from: h */
    private Rect f4559h;

    /* renamed from: com.shuame.rootgenius.ui.view.TextProgressBar$TextAlign */
    public enum TextAlign {
        LEFT,
        CENTER,
        RIGHT
    }

    public TextProgressBar(Context context) {
        this(context, null);
    }

    public TextProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4559h = new Rect();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C1242a.TextProgressBar, 0, 0);
        this.f4558g = obtainStyledAttributes.getInt(0, 14);
        obtainStyledAttributes.recycle();
        this.f4553b = new Paint();
        this.f4553b.setAntiAlias(true);
        this.f4553b.setColor(-1);
        this.f4553b.setTextSize((float) C1413u.m3930a(getContext(), this.f4558g));
        this.f4555d = TextAlign.CENTER;
        Rect rect = new Rect();
        String str = "正在扫描";
        this.f4553b.getTextBounds(str, 0, str.length(), rect);
        this.f4557f = rect.centerY();
        this.f4556e = C1413u.m3930a(getContext(), 10);
    }

    private void setPercentText(int i) {
        this.f4552a = String.valueOf((int) (((((float) i) * 1.0f) / ((float) getMax())) * 100.0f)) + "%";
    }

    public String getText() {
        return this.f4552a;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f4552a != null) {
            this.f4559h.setEmpty();
            this.f4553b.getTextBounds(this.f4552a, 0, this.f4552a.length(), this.f4559h);
            int i = this.f4556e;
            int height = (getHeight() / 2) - this.f4557f;
            if (this.f4555d == TextAlign.CENTER) {
                i = (getWidth() / 2) - this.f4559h.centerX();
            } else {
                TextAlign textAlign = TextAlign.RIGHT;
            }
            canvas.drawText(this.f4552a, (float) i, (float) height, this.f4553b);
        }
    }

    public void setDisplayPercent(boolean z) {
        this.f4554c = z;
    }

    public void setProgress(int i) {
        super.setProgress(i);
        if (this.f4554c) {
            setPercentText(getProgress());
        }
    }

    public void setProgressDrawable(Drawable drawable) {
        if (VERSION.SDK_INT < 14) {
            Drawable progressDrawable = getProgressDrawable();
            if (progressDrawable != null) {
                Rect bounds = progressDrawable.getBounds();
                if (bounds != null) {
                    drawable.setBounds(bounds);
                }
            }
            super.setProgressDrawable(drawable);
            super.drawableStateChanged();
            return;
        }
        super.setProgressDrawable(drawable);
    }

    public void setText(int i) {
        this.f4552a = getResources().getString(i);
        invalidate();
    }

    public void setText(String str) {
        if (str != null) {
            this.f4552a = str;
            invalidate();
        }
    }

    public void setTextAlign(TextAlign textAlign) {
        this.f4555d = textAlign;
    }

    public void setTextColor(int i) {
        this.f4553b.setColor(i);
    }
}
