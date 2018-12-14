package android.support.p015v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* renamed from: android.support.v4.view.GestureDetectorCompat */
public final class GestureDetectorCompat {
    private final GestureDetectorCompatImpl mImpl;

    /* renamed from: android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImpl */
    interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();

        boolean onTouchEvent(MotionEvent motionEvent);

        void setIsLongpressEnabled(boolean z);

        void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener);
    }

    /* renamed from: android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase */
    static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
        private static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
        private static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
        private static final int LONG_PRESS = 2;
        private static final int SHOW_PRESS = 1;
        private static final int TAP = 3;
        private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
        private boolean mAlwaysInBiggerTapRegion;
        private boolean mAlwaysInTapRegion;
        private MotionEvent mCurrentDownEvent;
        private boolean mDeferConfirmSingleTap;
        private OnDoubleTapListener mDoubleTapListener;
        private int mDoubleTapSlopSquare;
        private float mDownFocusX;
        private float mDownFocusY;
        private final Handler mHandler;
        private boolean mInLongPress;
        private boolean mIsDoubleTapping;
        private boolean mIsLongpressEnabled;
        private float mLastFocusX;
        private float mLastFocusY;
        private final OnGestureListener mListener;
        private int mMaximumFlingVelocity;
        private int mMinimumFlingVelocity;
        private MotionEvent mPreviousUpEvent;
        private boolean mStillDown;
        private int mTouchSlopSquare;
        private VelocityTracker mVelocityTracker;

        /* renamed from: android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplBase$GestureHandler */
        private class GestureHandler extends Handler {
            GestureHandler() {
            }

            GestureHandler(Handler handler) {
                super(handler.getLooper());
            }

            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GestureDetectorCompatImplBase.this.mListener.onShowPress(GestureDetectorCompatImplBase.this.mCurrentDownEvent);
                        return;
                    case 2:
                        GestureDetectorCompatImplBase.this.dispatchLongPress();
                        return;
                    case 3:
                        if (GestureDetectorCompatImplBase.this.mDoubleTapListener == null) {
                            return;
                        }
                        if (GestureDetectorCompatImplBase.this.mStillDown) {
                            GestureDetectorCompatImplBase.this.mDeferConfirmSingleTap = true;
                            return;
                        } else {
                            GestureDetectorCompatImplBase.this.mDoubleTapListener.onSingleTapConfirmed(GestureDetectorCompatImplBase.this.mCurrentDownEvent);
                            return;
                        }
                    default:
                        throw new RuntimeException("Unknown message " + message);
                }
            }
        }

        public GestureDetectorCompatImplBase(Context context, OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.mHandler = new GestureHandler(handler);
            } else {
                this.mHandler = new GestureHandler();
            }
            this.mListener = onGestureListener;
            if (onGestureListener instanceof OnDoubleTapListener) {
                setOnDoubleTapListener((OnDoubleTapListener) onGestureListener);
            }
            init(context);
        }

        private void cancel() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.mIsDoubleTapping = false;
            this.mStillDown = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        private void cancelTaps() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mIsDoubleTapping = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        private void dispatchLongPress() {
            this.mHandler.removeMessages(3);
            this.mDeferConfirmSingleTap = false;
            this.mInLongPress = true;
            this.mListener.onLongPress(this.mCurrentDownEvent);
        }

        private void init(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.mListener == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            } else {
                this.mIsLongpressEnabled = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
                this.mMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                this.mTouchSlopSquare = scaledTouchSlop * scaledTouchSlop;
                this.mDoubleTapSlopSquare = scaledDoubleTapSlop * scaledDoubleTapSlop;
            }
        }

        private boolean isConsideredDoubleTap(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.mAlwaysInBiggerTapRegion || motionEvent3.getEventTime() - motionEvent2.getEventTime() > ((long) DOUBLE_TAP_TIMEOUT)) {
                return false;
            }
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            return (x * x) + (y * y) < this.mDoubleTapSlopSquare;
        }

        public boolean isLongpressEnabled() {
            return this.mIsLongpressEnabled;
        }

        /* JADX WARNING: Removed duplicated region for block: B:43:0x00eb  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x0104  */
        public boolean onTouchEvent(android.view.MotionEvent r14) {
            /*
            r13 = this;
            r6 = 0;
            r12 = 2;
            r11 = 3;
            r8 = 1;
            r3 = 0;
            r9 = r14.getAction();
            r0 = r13.mVelocityTracker;
            if (r0 != 0) goto L_0x0013;
        L_0x000d:
            r0 = android.view.VelocityTracker.obtain();
            r13.mVelocityTracker = r0;
        L_0x0013:
            r0 = r13.mVelocityTracker;
            r0.addMovement(r14);
            r0 = r9 & 255;
            r1 = 6;
            if (r0 != r1) goto L_0x003c;
        L_0x001d:
            r7 = r8;
        L_0x001e:
            if (r7 == 0) goto L_0x003e;
        L_0x0020:
            r0 = android.support.p015v4.view.MotionEventCompat.getActionIndex(r14);
        L_0x0024:
            r4 = android.support.p015v4.view.MotionEventCompat.getPointerCount(r14);
            r5 = r3;
            r1 = r6;
            r2 = r6;
        L_0x002b:
            if (r5 >= r4) goto L_0x0040;
        L_0x002d:
            if (r0 == r5) goto L_0x0039;
        L_0x002f:
            r10 = android.support.p015v4.view.MotionEventCompat.getX(r14, r5);
            r2 = r2 + r10;
            r10 = android.support.p015v4.view.MotionEventCompat.getY(r14, r5);
            r1 = r1 + r10;
        L_0x0039:
            r5 = r5 + 1;
            goto L_0x002b;
        L_0x003c:
            r7 = r3;
            goto L_0x001e;
        L_0x003e:
            r0 = -1;
            goto L_0x0024;
        L_0x0040:
            if (r7 == 0) goto L_0x004e;
        L_0x0042:
            r0 = r4 + -1;
        L_0x0044:
            r5 = (float) r0;
            r2 = r2 / r5;
            r0 = (float) r0;
            r1 = r1 / r0;
            r0 = r9 & 255;
            switch(r0) {
                case 0: goto L_0x00a7;
                case 1: goto L_0x01b4;
                case 2: goto L_0x013f;
                case 3: goto L_0x0249;
                case 4: goto L_0x004d;
                case 5: goto L_0x0050;
                case 6: goto L_0x005c;
                default: goto L_0x004d;
            };
        L_0x004d:
            return r3;
        L_0x004e:
            r0 = r4;
            goto L_0x0044;
        L_0x0050:
            r13.mLastFocusX = r2;
            r13.mDownFocusX = r2;
            r13.mLastFocusY = r1;
            r13.mDownFocusY = r1;
            r13.cancelTaps();
            goto L_0x004d;
        L_0x005c:
            r13.mLastFocusX = r2;
            r13.mDownFocusX = r2;
            r13.mLastFocusY = r1;
            r13.mDownFocusY = r1;
            r0 = r13.mVelocityTracker;
            r1 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r2 = r13.mMaximumFlingVelocity;
            r2 = (float) r2;
            r0.computeCurrentVelocity(r1, r2);
            r1 = android.support.p015v4.view.MotionEventCompat.getActionIndex(r14);
            r0 = android.support.p015v4.view.MotionEventCompat.getPointerId(r14, r1);
            r2 = r13.mVelocityTracker;
            r2 = android.support.p015v4.view.VelocityTrackerCompat.getXVelocity(r2, r0);
            r5 = r13.mVelocityTracker;
            r5 = android.support.p015v4.view.VelocityTrackerCompat.getYVelocity(r5, r0);
            r0 = r3;
        L_0x0083:
            if (r0 >= r4) goto L_0x004d;
        L_0x0085:
            if (r0 == r1) goto L_0x00a4;
        L_0x0087:
            r7 = android.support.p015v4.view.MotionEventCompat.getPointerId(r14, r0);
            r8 = r13.mVelocityTracker;
            r8 = android.support.p015v4.view.VelocityTrackerCompat.getXVelocity(r8, r7);
            r8 = r8 * r2;
            r9 = r13.mVelocityTracker;
            r7 = android.support.p015v4.view.VelocityTrackerCompat.getYVelocity(r9, r7);
            r7 = r7 * r5;
            r7 = r7 + r8;
            r7 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1));
            if (r7 >= 0) goto L_0x00a4;
        L_0x009e:
            r0 = r13.mVelocityTracker;
            r0.clear();
            goto L_0x004d;
        L_0x00a4:
            r0 = r0 + 1;
            goto L_0x0083;
        L_0x00a7:
            r0 = r13.mDoubleTapListener;
            if (r0 == 0) goto L_0x013d;
        L_0x00ab:
            r0 = r13.mHandler;
            r0 = r0.hasMessages(r11);
            if (r0 == 0) goto L_0x00b8;
        L_0x00b3:
            r4 = r13.mHandler;
            r4.removeMessages(r11);
        L_0x00b8:
            r4 = r13.mCurrentDownEvent;
            if (r4 == 0) goto L_0x0135;
        L_0x00bc:
            r4 = r13.mPreviousUpEvent;
            if (r4 == 0) goto L_0x0135;
        L_0x00c0:
            if (r0 == 0) goto L_0x0135;
        L_0x00c2:
            r0 = r13.mCurrentDownEvent;
            r4 = r13.mPreviousUpEvent;
            r0 = r13.isConsideredDoubleTap(r0, r4, r14);
            if (r0 == 0) goto L_0x0135;
        L_0x00cc:
            r13.mIsDoubleTapping = r8;
            r0 = r13.mDoubleTapListener;
            r4 = r13.mCurrentDownEvent;
            r0 = r0.onDoubleTap(r4);
            r0 = r0 | 0;
            r4 = r13.mDoubleTapListener;
            r4 = r4.onDoubleTapEvent(r14);
            r0 = r0 | r4;
        L_0x00df:
            r13.mLastFocusX = r2;
            r13.mDownFocusX = r2;
            r13.mLastFocusY = r1;
            r13.mDownFocusY = r1;
            r1 = r13.mCurrentDownEvent;
            if (r1 == 0) goto L_0x00f0;
        L_0x00eb:
            r1 = r13.mCurrentDownEvent;
            r1.recycle();
        L_0x00f0:
            r1 = android.view.MotionEvent.obtain(r14);
            r13.mCurrentDownEvent = r1;
            r13.mAlwaysInTapRegion = r8;
            r13.mAlwaysInBiggerTapRegion = r8;
            r13.mStillDown = r8;
            r13.mInLongPress = r3;
            r13.mDeferConfirmSingleTap = r3;
            r1 = r13.mIsLongpressEnabled;
            if (r1 == 0) goto L_0x011c;
        L_0x0104:
            r1 = r13.mHandler;
            r1.removeMessages(r12);
            r1 = r13.mHandler;
            r2 = r13.mCurrentDownEvent;
            r2 = r2.getDownTime();
            r4 = TAP_TIMEOUT;
            r4 = (long) r4;
            r2 = r2 + r4;
            r4 = LONGPRESS_TIMEOUT;
            r4 = (long) r4;
            r2 = r2 + r4;
            r1.sendEmptyMessageAtTime(r12, r2);
        L_0x011c:
            r1 = r13.mHandler;
            r2 = r13.mCurrentDownEvent;
            r2 = r2.getDownTime();
            r4 = TAP_TIMEOUT;
            r4 = (long) r4;
            r2 = r2 + r4;
            r1.sendEmptyMessageAtTime(r8, r2);
            r1 = r13.mListener;
            r1 = r1.onDown(r14);
            r3 = r0 | r1;
            goto L_0x004d;
        L_0x0135:
            r0 = r13.mHandler;
            r4 = DOUBLE_TAP_TIMEOUT;
            r4 = (long) r4;
            r0.sendEmptyMessageDelayed(r11, r4);
        L_0x013d:
            r0 = r3;
            goto L_0x00df;
        L_0x013f:
            r0 = r13.mInLongPress;
            if (r0 != 0) goto L_0x004d;
        L_0x0143:
            r0 = r13.mLastFocusX;
            r0 = r0 - r2;
            r4 = r13.mLastFocusY;
            r4 = r4 - r1;
            r5 = r13.mIsDoubleTapping;
            if (r5 == 0) goto L_0x0157;
        L_0x014d:
            r0 = r13.mDoubleTapListener;
            r0 = r0.onDoubleTapEvent(r14);
            r3 = r0 | 0;
            goto L_0x004d;
        L_0x0157:
            r5 = r13.mAlwaysInTapRegion;
            if (r5 == 0) goto L_0x0192;
        L_0x015b:
            r5 = r13.mDownFocusX;
            r5 = r2 - r5;
            r5 = (int) r5;
            r6 = r13.mDownFocusY;
            r6 = r1 - r6;
            r6 = (int) r6;
            r5 = r5 * r5;
            r6 = r6 * r6;
            r5 = r5 + r6;
            r6 = r13.mTouchSlopSquare;
            if (r5 <= r6) goto L_0x0251;
        L_0x016c:
            r6 = r13.mListener;
            r7 = r13.mCurrentDownEvent;
            r0 = r6.onScroll(r7, r14, r0, r4);
            r13.mLastFocusX = r2;
            r13.mLastFocusY = r1;
            r13.mAlwaysInTapRegion = r3;
            r1 = r13.mHandler;
            r1.removeMessages(r11);
            r1 = r13.mHandler;
            r1.removeMessages(r8);
            r1 = r13.mHandler;
            r1.removeMessages(r12);
        L_0x0189:
            r1 = r13.mTouchSlopSquare;
            if (r5 <= r1) goto L_0x018f;
        L_0x018d:
            r13.mAlwaysInBiggerTapRegion = r3;
        L_0x018f:
            r3 = r0;
            goto L_0x004d;
        L_0x0192:
            r5 = java.lang.Math.abs(r0);
            r6 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
            r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
            if (r5 >= 0) goto L_0x01a6;
        L_0x019c:
            r5 = java.lang.Math.abs(r4);
            r6 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
            r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
            if (r5 < 0) goto L_0x004d;
        L_0x01a6:
            r3 = r13.mListener;
            r5 = r13.mCurrentDownEvent;
            r3 = r3.onScroll(r5, r14, r0, r4);
            r13.mLastFocusX = r2;
            r13.mLastFocusY = r1;
            goto L_0x004d;
        L_0x01b4:
            r13.mStillDown = r3;
            r1 = android.view.MotionEvent.obtain(r14);
            r0 = r13.mIsDoubleTapping;
            if (r0 == 0) goto L_0x01ee;
        L_0x01be:
            r0 = r13.mDoubleTapListener;
            r0 = r0.onDoubleTapEvent(r14);
            r0 = r0 | 0;
        L_0x01c6:
            r2 = r13.mPreviousUpEvent;
            if (r2 == 0) goto L_0x01cf;
        L_0x01ca:
            r2 = r13.mPreviousUpEvent;
            r2.recycle();
        L_0x01cf:
            r13.mPreviousUpEvent = r1;
            r1 = r13.mVelocityTracker;
            if (r1 == 0) goto L_0x01dd;
        L_0x01d5:
            r1 = r13.mVelocityTracker;
            r1.recycle();
            r1 = 0;
            r13.mVelocityTracker = r1;
        L_0x01dd:
            r13.mIsDoubleTapping = r3;
            r13.mDeferConfirmSingleTap = r3;
            r1 = r13.mHandler;
            r1.removeMessages(r8);
            r1 = r13.mHandler;
            r1.removeMessages(r12);
            r3 = r0;
            goto L_0x004d;
        L_0x01ee:
            r0 = r13.mInLongPress;
            if (r0 == 0) goto L_0x01fb;
        L_0x01f2:
            r0 = r13.mHandler;
            r0.removeMessages(r11);
            r13.mInLongPress = r3;
            r0 = r3;
            goto L_0x01c6;
        L_0x01fb:
            r0 = r13.mAlwaysInTapRegion;
            if (r0 == 0) goto L_0x0213;
        L_0x01ff:
            r0 = r13.mListener;
            r0 = r0.onSingleTapUp(r14);
            r2 = r13.mDeferConfirmSingleTap;
            if (r2 == 0) goto L_0x01c6;
        L_0x0209:
            r2 = r13.mDoubleTapListener;
            if (r2 == 0) goto L_0x01c6;
        L_0x020d:
            r2 = r13.mDoubleTapListener;
            r2.onSingleTapConfirmed(r14);
            goto L_0x01c6;
        L_0x0213:
            r0 = r13.mVelocityTracker;
            r2 = android.support.p015v4.view.MotionEventCompat.getPointerId(r14, r3);
            r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r5 = r13.mMaximumFlingVelocity;
            r5 = (float) r5;
            r0.computeCurrentVelocity(r4, r5);
            r4 = android.support.p015v4.view.VelocityTrackerCompat.getYVelocity(r0, r2);
            r0 = android.support.p015v4.view.VelocityTrackerCompat.getXVelocity(r0, r2);
            r2 = java.lang.Math.abs(r4);
            r5 = r13.mMinimumFlingVelocity;
            r5 = (float) r5;
            r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1));
            if (r2 > 0) goto L_0x023f;
        L_0x0234:
            r2 = java.lang.Math.abs(r0);
            r5 = r13.mMinimumFlingVelocity;
            r5 = (float) r5;
            r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1));
            if (r2 <= 0) goto L_0x024e;
        L_0x023f:
            r2 = r13.mListener;
            r5 = r13.mCurrentDownEvent;
            r0 = r2.onFling(r5, r14, r0, r4);
            goto L_0x01c6;
        L_0x0249:
            r13.cancel();
            goto L_0x004d;
        L_0x024e:
            r0 = r3;
            goto L_0x01c6;
        L_0x0251:
            r0 = r3;
            goto L_0x0189;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImplBase.onTouchEvent(android.view.MotionEvent):boolean");
        }

        public void setIsLongpressEnabled(boolean z) {
            this.mIsLongpressEnabled = z;
        }

        public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
            this.mDoubleTapListener = onDoubleTapListener;
        }
    }

    /* renamed from: android.support.v4.view.GestureDetectorCompat$GestureDetectorCompatImplJellybeanMr2 */
    static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {
        private final GestureDetector mDetector;

        public GestureDetectorCompatImplJellybeanMr2(Context context, OnGestureListener onGestureListener, Handler handler) {
            this.mDetector = new GestureDetector(context, onGestureListener, handler);
        }

        public boolean isLongpressEnabled() {
            return this.mDetector.isLongpressEnabled();
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.mDetector.onTouchEvent(motionEvent);
        }

        public void setIsLongpressEnabled(boolean z) {
            this.mDetector.setIsLongpressEnabled(z);
        }

        public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
            this.mDetector.setOnDoubleTapListener(onDoubleTapListener);
        }
    }

    public GestureDetectorCompat(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public GestureDetectorCompat(Context context, OnGestureListener onGestureListener, Handler handler) {
        if (VERSION.SDK_INT > 17) {
            this.mImpl = new GestureDetectorCompatImplJellybeanMr2(context, onGestureListener, handler);
        } else {
            this.mImpl = new GestureDetectorCompatImplBase(context, onGestureListener, handler);
        }
    }

    public final boolean isLongpressEnabled() {
        return this.mImpl.isLongpressEnabled();
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mImpl.onTouchEvent(motionEvent);
    }

    public final void setIsLongpressEnabled(boolean z) {
        this.mImpl.setIsLongpressEnabled(z);
    }

    public final void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        this.mImpl.setOnDoubleTapListener(onDoubleTapListener);
    }
}
