package android.support.p015v4.widget;

import android.widget.OverScroller;

/* renamed from: android.support.v4.widget.ScrollerCompatIcs */
class ScrollerCompatIcs {
    ScrollerCompatIcs() {
    }

    public static float getCurrVelocity(Object obj) {
        return ((OverScroller) obj).getCurrVelocity();
    }
}
