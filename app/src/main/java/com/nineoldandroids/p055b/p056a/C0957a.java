package com.nineoldandroids.p055b.p056a;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* renamed from: com.nineoldandroids.b.a.a */
public final class C0957a extends Animation {
    /* renamed from: a */
    public static final boolean f2354a = (Integer.valueOf(VERSION.SDK).intValue() < 11);
    /* renamed from: b */
    private static final WeakHashMap<View, C0957a> f2355b = new WeakHashMap();
    /* renamed from: c */
    private final WeakReference<View> f2356c;
    /* renamed from: d */
    private final Camera f2357d = new Camera();
    /* renamed from: e */
    private boolean f2358e;
    /* renamed from: f */
    private float f2359f = 1.0f;
    /* renamed from: g */
    private float f2360g;
    /* renamed from: h */
    private float f2361h;
    /* renamed from: i */
    private float f2362i;
    /* renamed from: j */
    private float f2363j;
    /* renamed from: k */
    private float f2364k;
    /* renamed from: l */
    private float f2365l = 1.0f;
    /* renamed from: m */
    private float f2366m = 1.0f;
    /* renamed from: n */
    private float f2367n;
    /* renamed from: o */
    private float f2368o;
    /* renamed from: p */
    private final RectF f2369p = new RectF();
    /* renamed from: q */
    private final RectF f2370q = new RectF();
    /* renamed from: r */
    private final Matrix f2371r = new Matrix();

    private C0957a(View view) {
        setDuration(0);
        setFillAfter(true);
        view.setAnimation(this);
        this.f2356c = new WeakReference(view);
    }

    /* renamed from: a */
    public static C0957a m2656a(View view) {
        Animation animation = (C0957a) f2355b.get(view);
        if (animation != null && animation == view.getAnimation()) {
            return animation;
        }
        C0957a c0957a = new C0957a(view);
        f2355b.put(view, c0957a);
        return c0957a;
    }

    /* renamed from: a */
    private void m2657a(Matrix matrix, View view) {
        float width = (float) view.getWidth();
        float height = (float) view.getHeight();
        boolean z = this.f2358e;
        float f = z ? this.f2360g : width / 2.0f;
        float f2 = z ? this.f2361h : height / 2.0f;
        float f3 = this.f2362i;
        float f4 = this.f2363j;
        float f5 = this.f2364k;
        if (!(f3 == 0.0f && f4 == 0.0f && f5 == 0.0f)) {
            Camera camera = this.f2357d;
            camera.save();
            camera.rotateX(f3);
            camera.rotateY(f4);
            camera.rotateZ(-f5);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f, -f2);
            matrix.postTranslate(f, f2);
        }
        f3 = this.f2365l;
        f4 = this.f2366m;
        if (!(f3 == 1.0f && f4 == 1.0f)) {
            matrix.postScale(f3, f4);
            matrix.postTranslate((-(f / width)) * ((f3 * width) - width), (-(f2 / height)) * ((f4 * height) - height));
        }
        matrix.postTranslate(this.f2367n, this.f2368o);
    }

    /* renamed from: a */
    private void m2658a(RectF rectF, View view) {
        float f;
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        Matrix matrix = this.f2371r;
        matrix.reset();
        m2657a(matrix, view);
        this.f2371r.mapRect(rectF);
        rectF.offset((float) view.getLeft(), (float) view.getTop());
        if (rectF.right < rectF.left) {
            f = rectF.right;
            rectF.right = rectF.left;
            rectF.left = f;
        }
        if (rectF.bottom < rectF.top) {
            f = rectF.top;
            rectF.top = rectF.bottom;
            rectF.bottom = f;
        }
    }

    /* renamed from: o */
    private void m2659o() {
        View view = (View) this.f2356c.get();
        if (view != null) {
            m2658a(this.f2369p, view);
        }
    }

    /* renamed from: p */
    private void m2660p() {
        View view = (View) this.f2356c.get();
        if (view != null && view.getParent() != null) {
            RectF rectF = this.f2370q;
            m2658a(rectF, view);
            rectF.union(this.f2369p);
            ((View) view.getParent()).invalidate((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
        }
    }

    /* renamed from: a */
    public final float mo6083a() {
        return this.f2359f;
    }

    /* renamed from: a */
    public final void mo6084a(float f) {
        if (this.f2359f != f) {
            this.f2359f = f;
            View view = (View) this.f2356c.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    /* renamed from: a */
    public final void mo6085a(int i) {
        View view = (View) this.f2356c.get();
        if (view != null) {
            view.scrollTo(i, view.getScrollY());
        }
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        View view = (View) this.f2356c.get();
        if (view != null) {
            transformation.setAlpha(this.f2359f);
            m2657a(transformation.getMatrix(), view);
        }
    }

    /* renamed from: b */
    public final float mo6087b() {
        return this.f2360g;
    }

    /* renamed from: b */
    public final void mo6088b(float f) {
        if (!this.f2358e || this.f2360g != f) {
            m2659o();
            this.f2358e = true;
            this.f2360g = f;
            m2660p();
        }
    }

    /* renamed from: b */
    public final void mo6089b(int i) {
        View view = (View) this.f2356c.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), i);
        }
    }

    /* renamed from: c */
    public final float mo6090c() {
        return this.f2361h;
    }

    /* renamed from: c */
    public final void mo6091c(float f) {
        if (!this.f2358e || this.f2361h != f) {
            m2659o();
            this.f2358e = true;
            this.f2361h = f;
            m2660p();
        }
    }

    /* renamed from: d */
    public final float mo6092d() {
        return this.f2364k;
    }

    /* renamed from: d */
    public final void mo6093d(float f) {
        if (this.f2364k != f) {
            m2659o();
            this.f2364k = f;
            m2660p();
        }
    }

    /* renamed from: e */
    public final float mo6094e() {
        return this.f2362i;
    }

    /* renamed from: e */
    public final void mo6095e(float f) {
        if (this.f2362i != f) {
            m2659o();
            this.f2362i = f;
            m2660p();
        }
    }

    /* renamed from: f */
    public final float mo6096f() {
        return this.f2363j;
    }

    /* renamed from: f */
    public final void mo6097f(float f) {
        if (this.f2363j != f) {
            m2659o();
            this.f2363j = f;
            m2660p();
        }
    }

    /* renamed from: g */
    public final float mo6098g() {
        return this.f2365l;
    }

    /* renamed from: g */
    public final void mo6099g(float f) {
        if (this.f2365l != f) {
            m2659o();
            this.f2365l = f;
            m2660p();
        }
    }

    /* renamed from: h */
    public final float mo6100h() {
        return this.f2366m;
    }

    /* renamed from: h */
    public final void mo6101h(float f) {
        if (this.f2366m != f) {
            m2659o();
            this.f2366m = f;
            m2660p();
        }
    }

    /* renamed from: i */
    public final int mo6102i() {
        View view = (View) this.f2356c.get();
        return view == null ? 0 : view.getScrollX();
    }

    /* renamed from: i */
    public final void mo6103i(float f) {
        if (this.f2367n != f) {
            m2659o();
            this.f2367n = f;
            m2660p();
        }
    }

    /* renamed from: j */
    public final int mo6104j() {
        View view = (View) this.f2356c.get();
        return view == null ? 0 : view.getScrollY();
    }

    /* renamed from: j */
    public final void mo6105j(float f) {
        if (this.f2368o != f) {
            m2659o();
            this.f2368o = f;
            m2660p();
        }
    }

    /* renamed from: k */
    public final float mo6106k() {
        return this.f2367n;
    }

    /* renamed from: k */
    public final void mo6107k(float f) {
        View view = (View) this.f2356c.get();
        if (view != null) {
            mo6103i(f - ((float) view.getLeft()));
        }
    }

    /* renamed from: l */
    public final float mo6108l() {
        return this.f2368o;
    }

    /* renamed from: l */
    public final void mo6109l(float f) {
        View view = (View) this.f2356c.get();
        if (view != null) {
            mo6105j(f - ((float) view.getTop()));
        }
    }

    /* renamed from: m */
    public final float mo6110m() {
        View view = (View) this.f2356c.get();
        return view == null ? 0.0f : ((float) view.getLeft()) + this.f2367n;
    }

    /* renamed from: n */
    public final float mo6111n() {
        View view = (View) this.f2356c.get();
        return view == null ? 0.0f : ((float) view.getTop()) + this.f2368o;
    }
}
