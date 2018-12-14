package com.shuame.rootgenius.p115ui.view;

import android.content.Context;
import android.support.p015v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* renamed from: com.shuame.rootgenius.ui.view.MyViewPager */
public class MyViewPager extends ViewPager {
    /* renamed from: a */
    private static final String f4446a = MyViewPager.class.getSimpleName();
    /* renamed from: b */
    private float f4447b;
    /* renamed from: c */
    private float f4448c;
    /* renamed from: d */
    private float f4449d;
    /* renamed from: e */
    private float f4450e;
    /* renamed from: f */
    private int f4451f;

    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4451f = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f4447b = motionEvent.getX();
                this.f4448c = motionEvent.getY();
                break;
            case 1:
                this.f4449d = motionEvent.getX();
                this.f4450e = motionEvent.getY();
                if (!(Math.abs(this.f4450e - this.f4448c) > ((float) this.f4451f))) {
                    this.f4447b = this.f4449d;
                    this.f4448c = this.f4450e;
                    break;
                }
                return true;
            case 2:
                this.f4449d = motionEvent.getX();
                this.f4450e = motionEvent.getY();
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
