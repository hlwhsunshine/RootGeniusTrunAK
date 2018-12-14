package com.baidu.mobads;

import android.app.Activity;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.production.p044e.C0391b;

public class DubaoAd {
    /* renamed from: a */
    private C0391b f350a = null;

    public static class Position {
        public static final int POSITION_LEFT = 0;
        public static final int POSITION_RIGHT = 1;
        /* renamed from: a */
        private int f348a;
        /* renamed from: b */
        private double f349b;

        public Position(int i, double d) {
            this.f348a = i;
            this.f349b = d;
        }

        public int getmLeftOrRight() {
            return this.f348a;
        }

        public double getmTopMarginPercent() {
            return this.f349b;
        }
    }

    public DubaoAd(Activity activity, String str, Position position) {
        if (position == null) {
            C0338m.m569a().mo5033f().mo4926e("parameter position can not be null");
        } else {
            this.f350a = new C0391b(activity, str, position.getmLeftOrRight() == 0, position.getmTopMarginPercent());
        }
    }

    public void destroy() {
        if (this.f350a != null) {
            this.f350a.mo5167l();
            this.f350a = null;
        }
    }
}
