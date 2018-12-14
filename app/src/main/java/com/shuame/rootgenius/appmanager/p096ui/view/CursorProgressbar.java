package com.shuame.rootgenius.appmanager.p096ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: com.shuame.rootgenius.appmanager.ui.view.CursorProgressbar */
public class CursorProgressbar extends View {
    /* renamed from: a */
    private static final String f3521a = CursorProgressbar.class.getSimpleName();
    /* renamed from: b */
    private Paint f3522b;
    /* renamed from: c */
    private int f3523c;
    /* renamed from: d */
    private int f3524d;
    /* renamed from: e */
    private int f3525e;
    /* renamed from: f */
    private int f3526f;
    /* renamed from: g */
    private Handler f3527g;
    /* renamed from: h */
    private boolean f3528h;

    public CursorProgressbar(Context context) {
        super(context);
        this.f3527g = new Handler(new C1298a(this));
        this.f3522b = new Paint();
        this.f3522b.setStrokeWidth(12.0f);
        this.f3522b.setARGB(255, 76, 175, 80);
    }

    public CursorProgressbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.f3522b = new Paint();
        this.f3522b.setStrokeWidth(12.0f);
        this.f3522b.setARGB(255, 76, 175, 80);
    }

    public CursorProgressbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3527g = new Handler(new C1298a(this));
        this.f3522b = new Paint();
        this.f3522b.setStrokeWidth(12.0f);
        this.f3522b.setARGB(255, 76, 175, 80);
    }

    protected void onDraw(Canvas canvas) {
        this.f3525e = getWidth();
        if (this.f3524d < this.f3525e) {
            this.f3523c += this.f3526f;
            this.f3524d += this.f3526f * 2;
        } else {
            this.f3523c = 0;
            this.f3524d = 30;
        }
        new StringBuilder("startx: ").append(this.f3523c).append(" stopx: ").append(this.f3524d).append("screenWidth: ").append(this.f3525e);
        canvas.drawLine((float) this.f3523c, 0.0f, (float) this.f3524d, 0.0f, this.f3522b);
        if (this.f3528h) {
            this.f3527g.sendEmptyMessageDelayed(0, 30);
        }
    }
}
