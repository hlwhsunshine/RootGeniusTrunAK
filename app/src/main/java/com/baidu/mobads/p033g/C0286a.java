package com.baidu.mobads.p033g;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.mobads.AppActivity.ActionBarColorTheme;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.p021j.C0338m;

/* renamed from: com.baidu.mobads.g.a */
public class C0286a extends RelativeLayout {
    /* renamed from: a */
    protected C0284c f518a;
    /* renamed from: b */
    Paint f519b;
    /* renamed from: c */
    int f520c;
    /* renamed from: d */
    int f521d;
    /* renamed from: e */
    private Context f522e;
    /* renamed from: f */
    private IXAdCommonUtils f523f;
    /* renamed from: g */
    private ActionBarColorTheme f524g;
    /* renamed from: h */
    private TextView f525h;

    /* renamed from: com.baidu.mobads.g.a$a */
    public class C0282a extends View {
        public C0282a(Context context) {
            super(context);
        }
    }

    /* renamed from: com.baidu.mobads.g.a$b */
    private class C0283b extends C0282a {
        /* renamed from: c */
        private Paint f513c;
        /* renamed from: d */
        private int f514d;

        public C0283b(Context context, int i) {
            super(context);
            this.f514d = i;
        }

        /* renamed from: a */
        private Paint m389a() {
            if (this.f513c == null) {
                this.f513c = new Paint();
                this.f513c.setStyle(Style.STROKE);
                this.f513c.setColor(this.f514d);
                this.f513c.setAlpha(255);
                this.f513c.setAntiAlias(true);
                this.f513c.setStrokeWidth((float) ((int) C0286a.this.f523f.getScreenDensity(getContext())));
            }
            return this.f513c;
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawLine((float) C0286a.this.f523f.getPixel(getContext(), 18), (float) C0286a.this.f523f.getPixel(getContext(), 15), (float) C0286a.this.f523f.getPixel(getContext(), 34), (float) C0286a.this.f523f.getPixel(getContext(), 31), m389a());
            canvas.drawLine((float) C0286a.this.f523f.getPixel(getContext(), 18), (float) C0286a.this.f523f.getPixel(getContext(), 31), (float) C0286a.this.f523f.getPixel(getContext(), 34), (float) C0286a.this.f523f.getPixel(getContext(), 15), m389a());
        }
    }

    /* renamed from: com.baidu.mobads.g.a$c */
    public interface C0284c {
        /* renamed from: a */
        void mo4461a();

        /* renamed from: b */
        void mo4462b();
    }

    /* renamed from: com.baidu.mobads.g.a$d */
    private class C0285d extends C0282a {
        /* renamed from: c */
        private Paint f516c;
        /* renamed from: d */
        private int f517d;

        public C0285d(Context context, int i) {
            super(context);
            this.f517d = i;
        }

        /* renamed from: a */
        private Paint m392a() {
            if (this.f516c == null) {
                this.f516c = new Paint();
                this.f516c.setColor(this.f517d);
                this.f516c.setAlpha(255);
                this.f516c.setAntiAlias(true);
            }
            return this.f516c;
        }

        /* renamed from: a */
        private void m393a(Canvas canvas, int i) {
            canvas.drawCircle((float) C0286a.this.f523f.getPixel(getContext(), 26), (float) C0286a.this.f523f.getPixel(getContext(), i), (float) ((int) (C0286a.this.f523f.getScreenDensity(getContext()) * 1.0f)), m392a());
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            m393a(canvas, 31);
            m393a(canvas, 15);
            m393a(canvas, 23);
        }
    }

    public C0286a(Context context) {
        super(context);
        this.f519b = new Paint();
        this.f520c = 0;
        this.f521d = 0;
        this.f522e = context;
    }

    public C0286a(Context context, ActionBarColorTheme actionBarColorTheme) {
        this(context);
        this.f524g = actionBarColorTheme;
        setBackgroundColor(this.f524g.getBackgroundColor());
        this.f523f = C0338m.m569a().mo5040m();
        mo4464a();
    }

    /* renamed from: a */
    protected void mo4464a() {
        int pixel = this.f523f.getPixel(this.f522e, 52);
        View c0283b = new C0283b(this.f522e, this.f524g.getCloseColor());
        c0283b.setId(132343242);
        addView(c0283b, new LayoutParams(pixel, -1));
        c0283b.setOnClickListener(new C0287b(this));
        c0283b = new C0285d(this.f522e, this.f524g.getCloseColor());
        c0283b.setId(132343243);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(pixel, -1);
        layoutParams.addRule(11);
        c0283b.setOnClickListener(new C0288c(this));
        addView(c0283b, layoutParams);
        this.f525h = new TextView(this.f522e);
        this.f525h.setTextSize(1, 16.0f);
        this.f525h.setLines(1);
        this.f525h.setEllipsize(TruncateAt.END);
        this.f525h.setGravity(16);
        this.f525h.setTextColor(this.f524g.getTitleColor());
        this.f525h.setText("");
        layoutParams = new LayoutParams(this.f523f.getScreenRect(this.f522e).width() - (pixel * 2), -1);
        layoutParams.addRule(14);
        addView(this.f525h, layoutParams);
    }

    /* renamed from: a */
    public void mo4465a(C0284c c0284c) {
        this.f518a = c0284c;
    }

    /* renamed from: a */
    public void mo4466a(String str) {
        if (this.f525h != null) {
            this.f525h.setText(str);
            this.f525h.invalidate();
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f524g.equals(ActionBarColorTheme.ACTION_BAR_WHITE_THEME)) {
            this.f519b.setColor(-5592406);
            this.f519b.setStyle(Style.STROKE);
            this.f519b.setStrokeWidth((float) this.f523f.getPixel(this.f522e, 1));
            canvas.drawLine(0.0f, (float) this.f521d, (float) this.f520c, (float) this.f521d, this.f519b);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f520c = i3 - i;
        this.f521d = i4 - i2;
    }
}
