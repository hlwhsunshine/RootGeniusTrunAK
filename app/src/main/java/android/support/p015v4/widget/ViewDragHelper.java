package android.support.p015v4.widget;

import android.content.Context;
import android.support.p015v4.view.MotionEventCompat;
import android.support.p015v4.view.VelocityTrackerCompat;
import android.support.p015v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

/* renamed from: android.support.v4.widget.ViewDragHelper */
public class ViewDragHelper {
    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private static final Interpolator sInterpolator = new C02181();
    private int mActivePointerId = -1;
    private final Callback mCallback;
    private View mCapturedView;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private ScrollerCompat mScroller;
    private final Runnable mSetIdleRunnable = new C02192();
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;

    /* renamed from: android.support.v4.widget.ViewDragHelper$Callback */
    public static abstract class Callback {
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return 0;
        }

        public int getOrderedChildIndex(int i) {
            return i;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
        }

        public void onViewCaptured(View view, int i) {
        }

        public void onViewDragStateChanged(int i) {
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        }

        public void onViewReleased(View view, float f, float f2) {
        }

        public abstract boolean tryCaptureView(View view, int i);
    }

    /* renamed from: android.support.v4.widget.ViewDragHelper$1 */
    final class C02181 implements Interpolator {
        C02181() {
        }

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    /* renamed from: android.support.v4.widget.ViewDragHelper$2 */
    class C02192 implements Runnable {
        C02192() {
        }

        public void run() {
            ViewDragHelper.this.setDragState(0);
        }
    }

    private ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (callback == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.mParentView = viewGroup;
            this.mCallback = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.mEdgeSize = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.mMaxVelocity = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.mMinVelocity = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.mScroller = ScrollerCompat.create(context, sInterpolator);
        }
    }

    private boolean checkNewEdgeDrag(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.mInitialEdgesTouched[i] & i2) != i2 || (this.mTrackingEdges & i2) == 0 || (this.mEdgeDragsLocked[i] & i2) == i2 || (this.mEdgeDragsInProgress[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.mTouchSlop) && abs2 <= ((float) this.mTouchSlop)) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.mCallback.onEdgeLock(i2)) {
            return (this.mEdgeDragsInProgress[i] & i2) == 0 && abs > ((float) this.mTouchSlop);
        } else {
            int[] iArr = this.mEdgeDragsLocked;
            iArr[i] = iArr[i] | i2;
            return false;
        }
    }

    private boolean checkTouchSlop(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.mCallback.getViewHorizontalDragRange(view) > 0;
        boolean z2 = this.mCallback.getViewVerticalDragRange(view) > 0;
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.mTouchSlop * this.mTouchSlop)) : z ? Math.abs(f) > ((float) this.mTouchSlop) : z2 && Math.abs(f2) > ((float) this.mTouchSlop);
    }

    private float clampMag(float f, float f2, float f3) {
        float abs = Math.abs(f);
        return abs < f2 ? 0.0f : abs > f3 ? f <= 0.0f ? -f3 : f3 : f;
    }

    private int clampMag(int i, int i2, int i3) {
        int abs = Math.abs(i);
        return abs < i2 ? 0 : abs > i3 ? i <= 0 ? -i3 : i3 : i;
    }

    private void clearMotionHistory() {
        if (this.mInitialMotionX != null) {
            Arrays.fill(this.mInitialMotionX, 0.0f);
            Arrays.fill(this.mInitialMotionY, 0.0f);
            Arrays.fill(this.mLastMotionX, 0.0f);
            Arrays.fill(this.mLastMotionY, 0.0f);
            Arrays.fill(this.mInitialEdgesTouched, 0);
            Arrays.fill(this.mEdgeDragsInProgress, 0);
            Arrays.fill(this.mEdgeDragsLocked, 0);
            this.mPointersDown = 0;
        }
    }

    private void clearMotionHistory(int i) {
        if (this.mInitialMotionX != null) {
            this.mInitialMotionX[i] = 0.0f;
            this.mInitialMotionY[i] = 0.0f;
            this.mLastMotionX[i] = 0.0f;
            this.mLastMotionY[i] = 0.0f;
            this.mInitialEdgesTouched[i] = 0;
            this.mEdgeDragsInProgress[i] = 0;
            this.mEdgeDragsLocked[i] = 0;
            this.mPointersDown &= (1 << i) ^ -1;
        }
    }

    private int computeAxisDuration(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.mParentView.getWidth();
        int i4 = width / 2;
        float distanceInfluenceForSnapDuration = (distanceInfluenceForSnapDuration(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        return Math.min(i4 > 0 ? Math.round(Math.abs(distanceInfluenceForSnapDuration / ((float) i4)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f), 600);
    }

    private int computeSettleDuration(View view, int i, int i2, int i3, int i4) {
        int clampMag = clampMag(i3, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int clampMag2 = clampMag(i4, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(clampMag);
        int abs4 = Math.abs(clampMag2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((clampMag2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) computeAxisDuration(i2, clampMag2, this.mCallback.getViewVerticalDragRange(view)))) + ((clampMag != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) computeAxisDuration(i, clampMag, this.mCallback.getViewHorizontalDragRange(view)))));
    }

    public static ViewDragHelper create(ViewGroup viewGroup, float f, Callback callback) {
        ViewDragHelper create = ViewDragHelper.create(viewGroup, callback);
        create.mTouchSlop = (int) (((float) create.mTouchSlop) * (1.0f / f));
        return create;
    }

    public static ViewDragHelper create(ViewGroup viewGroup, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    private void dispatchViewReleased(float f, float f2) {
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, f, f2);
        this.mReleaseInProgress = false;
        if (this.mDragState == 1) {
            setDragState(0);
        }
    }

    private float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    private void dragTo(int i, int i2, int i3, int i4) {
        int clampViewPositionHorizontal;
        int clampViewPositionVertical;
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        if (i3 != 0) {
            clampViewPositionHorizontal = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, i, i3);
            ViewCompat.offsetLeftAndRight(this.mCapturedView, clampViewPositionHorizontal - left);
        } else {
            clampViewPositionHorizontal = i;
        }
        if (i4 != 0) {
            clampViewPositionVertical = this.mCallback.clampViewPositionVertical(this.mCapturedView, i2, i4);
            ViewCompat.offsetTopAndBottom(this.mCapturedView, clampViewPositionVertical - top);
        } else {
            clampViewPositionVertical = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.mCallback.onViewPositionChanged(this.mCapturedView, clampViewPositionHorizontal, clampViewPositionVertical, clampViewPositionHorizontal - left, clampViewPositionVertical - top);
        }
    }

    private void ensureMotionHistorySizeForId(int i) {
        if (this.mInitialMotionX == null || this.mInitialMotionX.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.mInitialMotionX != null) {
                System.arraycopy(this.mInitialMotionX, 0, obj, 0, this.mInitialMotionX.length);
                System.arraycopy(this.mInitialMotionY, 0, obj2, 0, this.mInitialMotionY.length);
                System.arraycopy(this.mLastMotionX, 0, obj3, 0, this.mLastMotionX.length);
                System.arraycopy(this.mLastMotionY, 0, obj4, 0, this.mLastMotionY.length);
                System.arraycopy(this.mInitialEdgesTouched, 0, obj5, 0, this.mInitialEdgesTouched.length);
                System.arraycopy(this.mEdgeDragsInProgress, 0, obj6, 0, this.mEdgeDragsInProgress.length);
                System.arraycopy(this.mEdgeDragsLocked, 0, obj7, 0, this.mEdgeDragsLocked.length);
            }
            this.mInitialMotionX = obj;
            this.mInitialMotionY = obj2;
            this.mLastMotionX = obj3;
            this.mLastMotionY = obj4;
            this.mInitialEdgesTouched = obj5;
            this.mEdgeDragsInProgress = obj6;
            this.mEdgeDragsLocked = obj7;
        }
    }

    private boolean forceSettleCapturedViewAt(int i, int i2, int i3, int i4) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.mScroller.abortAnimation();
            setDragState(0);
            return false;
        }
        this.mScroller.startScroll(left, top, i5, i6, computeSettleDuration(this.mCapturedView, i5, i6, i3, i4));
        setDragState(2);
        return true;
    }

    private int getEdgesTouched(int i, int i2) {
        int i3 = 0;
        if (i < this.mParentView.getLeft() + this.mEdgeSize) {
            i3 = 1;
        }
        if (i2 < this.mParentView.getTop() + this.mEdgeSize) {
            i3 |= 4;
        }
        if (i > this.mParentView.getRight() - this.mEdgeSize) {
            i3 |= 2;
        }
        return i2 > this.mParentView.getBottom() - this.mEdgeSize ? i3 | 8 : i3;
    }

    private boolean isValidPointerForActionMove(int i) {
        if (isPointerDown(i)) {
            return true;
        }
        new StringBuilder("Ignoring pointerId=").append(i).append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        dispatchViewReleased(clampMag(VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }

    private void reportNewEdgeDrags(float f, float f2, int i) {
        int i2 = 1;
        if (!checkNewEdgeDrag(f, f2, i, 1)) {
            i2 = 0;
        }
        if (checkNewEdgeDrag(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (checkNewEdgeDrag(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (checkNewEdgeDrag(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.mEdgeDragsInProgress;
            iArr[i] = iArr[i] | i2;
            this.mCallback.onEdgeDragStarted(i2, i);
        }
    }

    private void saveInitialMotion(float f, float f2, int i) {
        ensureMotionHistorySizeForId(i);
        float[] fArr = this.mInitialMotionX;
        this.mLastMotionX[i] = f;
        fArr[i] = f;
        fArr = this.mInitialMotionY;
        this.mLastMotionY[i] = f2;
        fArr[i] = f2;
        this.mInitialEdgesTouched[i] = getEdgesTouched((int) f, (int) f2);
        this.mPointersDown |= 1 << i;
    }

    private void saveLastMotion(MotionEvent motionEvent) {
        int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, i);
            float x = MotionEventCompat.getX(motionEvent, i);
            float y = MotionEventCompat.getY(motionEvent, i);
            this.mLastMotionX[pointerId] = x;
            this.mLastMotionY[pointerId] = y;
        }
    }

    public void abort() {
        cancel();
        if (this.mDragState == 2) {
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            this.mScroller.abortAnimation();
            int currX2 = this.mScroller.getCurrX();
            int currY2 = this.mScroller.getCurrY();
            this.mCallback.onViewPositionChanged(this.mCapturedView, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        setDragState(0);
    }

    protected boolean canScroll(View view, boolean z, int i, int i2, int i3, int i4) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i3 + scrollX >= childAt.getLeft() && i3 + scrollX < childAt.getRight() && i4 + scrollY >= childAt.getTop() && i4 + scrollY < childAt.getBottom()) {
                    if (canScroll(childAt, true, i, i2, (i3 + scrollX) - childAt.getLeft(), (i4 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z && (ViewCompat.canScrollHorizontally(view, -i) || ViewCompat.canScrollVertically(view, -i2));
    }

    public void cancel() {
        this.mActivePointerId = -1;
        clearMotionHistory();
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void captureChildView(View view, int i) {
        if (view.getParent() != this.mParentView) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.mParentView + ")");
        }
        this.mCapturedView = view;
        this.mActivePointerId = i;
        this.mCallback.onViewCaptured(view, i);
        setDragState(1);
    }

    public boolean checkTouchSlop(int i) {
        int length = this.mInitialMotionX.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (checkTouchSlop(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTouchSlop(int i, int i2) {
        if (!isPointerDown(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f = this.mLastMotionX[i2] - this.mInitialMotionX[i2];
        float f2 = this.mLastMotionY[i2] - this.mInitialMotionY[i2];
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.mTouchSlop * this.mTouchSlop)) : z ? Math.abs(f) > ((float) this.mTouchSlop) : z2 && Math.abs(f2) > ((float) this.mTouchSlop);
    }

    public boolean continueSettling(boolean z) {
        if (this.mDragState == 2) {
            int i;
            boolean computeScrollOffset = this.mScroller.computeScrollOffset();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            int left = currX - this.mCapturedView.getLeft();
            int top = currY - this.mCapturedView.getTop();
            if (left != 0) {
                ViewCompat.offsetLeftAndRight(this.mCapturedView, left);
            }
            if (top != 0) {
                ViewCompat.offsetTopAndBottom(this.mCapturedView, top);
            }
            if (!(left == 0 && top == 0)) {
                this.mCallback.onViewPositionChanged(this.mCapturedView, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.mScroller.getFinalX() && currY == this.mScroller.getFinalY()) {
                this.mScroller.abortAnimation();
                i = 0;
            } else {
                boolean i2 = computeScrollOffset;
            }
            if (i2 == 0) {
                if (z) {
                    this.mParentView.post(this.mSetIdleRunnable);
                } else {
                    setDragState(0);
                }
            }
        }
        return this.mDragState == 2;
    }

    public View findTopChildUnder(int i, int i2) {
        for (int childCount = this.mParentView.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void flingCapturedView(int i, int i2, int i3, int i4) {
        if (this.mReleaseInProgress) {
            this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int) VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int) VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), i, i3, i2, i4);
            setDragState(2);
            return;
        }
        throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }

    public int getActivePointerId() {
        return this.mActivePointerId;
    }

    public View getCapturedView() {
        return this.mCapturedView;
    }

    public int getEdgeSize() {
        return this.mEdgeSize;
    }

    public float getMinVelocity() {
        return this.mMinVelocity;
    }

    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getViewDragState() {
        return this.mDragState;
    }

    public boolean isCapturedViewUnder(int i, int i2) {
        return isViewUnder(this.mCapturedView, i, i2);
    }

    public boolean isEdgeTouched(int i) {
        int length = this.mInitialEdgesTouched.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (isEdgeTouched(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEdgeTouched(int i, int i2) {
        return isPointerDown(i2) && (this.mInitialEdgesTouched[i2] & i) != 0;
    }

    public boolean isPointerDown(int i) {
        return (this.mPointersDown & (1 << i)) != 0;
    }

    public boolean isViewUnder(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0147  */
    public void processTouchEvent(android.view.MotionEvent r10) {
        /*
        r9 = this;
        r1 = -1;
        r5 = 0;
        r0 = 0;
        r8 = 1;
        r2 = android.support.p015v4.view.MotionEventCompat.getActionMasked(r10);
        r3 = android.support.p015v4.view.MotionEventCompat.getActionIndex(r10);
        if (r2 != 0) goto L_0x0011;
    L_0x000e:
        r9.cancel();
    L_0x0011:
        r4 = r9.mVelocityTracker;
        if (r4 != 0) goto L_0x001b;
    L_0x0015:
        r4 = android.view.VelocityTracker.obtain();
        r9.mVelocityTracker = r4;
    L_0x001b:
        r4 = r9.mVelocityTracker;
        r4.addMovement(r10);
        switch(r2) {
            case 0: goto L_0x0024;
            case 1: goto L_0x0152;
            case 2: goto L_0x008a;
            case 3: goto L_0x015e;
            case 4: goto L_0x0023;
            case 5: goto L_0x004e;
            case 6: goto L_0x010f;
            default: goto L_0x0023;
        };
    L_0x0023:
        return;
    L_0x0024:
        r1 = r10.getX();
        r2 = r10.getY();
        r0 = android.support.p015v4.view.MotionEventCompat.getPointerId(r10, r0);
        r3 = (int) r1;
        r4 = (int) r2;
        r3 = r9.findTopChildUnder(r3, r4);
        r9.saveInitialMotion(r1, r2, r0);
        r9.tryCaptureViewForDrag(r3, r0);
        r1 = r9.mInitialEdgesTouched;
        r1 = r1[r0];
        r2 = r9.mTrackingEdges;
        r2 = r2 & r1;
        if (r2 == 0) goto L_0x0023;
    L_0x0045:
        r2 = r9.mCallback;
        r3 = r9.mTrackingEdges;
        r1 = r1 & r3;
        r2.onEdgeTouched(r1, r0);
        goto L_0x0023;
    L_0x004e:
        r0 = android.support.p015v4.view.MotionEventCompat.getPointerId(r10, r3);
        r1 = android.support.p015v4.view.MotionEventCompat.getX(r10, r3);
        r2 = android.support.p015v4.view.MotionEventCompat.getY(r10, r3);
        r9.saveInitialMotion(r1, r2, r0);
        r3 = r9.mDragState;
        if (r3 != 0) goto L_0x007c;
    L_0x0061:
        r1 = (int) r1;
        r2 = (int) r2;
        r1 = r9.findTopChildUnder(r1, r2);
        r9.tryCaptureViewForDrag(r1, r0);
        r1 = r9.mInitialEdgesTouched;
        r1 = r1[r0];
        r2 = r9.mTrackingEdges;
        r2 = r2 & r1;
        if (r2 == 0) goto L_0x0023;
    L_0x0073:
        r2 = r9.mCallback;
        r3 = r9.mTrackingEdges;
        r1 = r1 & r3;
        r2.onEdgeTouched(r1, r0);
        goto L_0x0023;
    L_0x007c:
        r1 = (int) r1;
        r2 = (int) r2;
        r1 = r9.isCapturedViewUnder(r1, r2);
        if (r1 == 0) goto L_0x0023;
    L_0x0084:
        r1 = r9.mCapturedView;
        r9.tryCaptureViewForDrag(r1, r0);
        goto L_0x0023;
    L_0x008a:
        r1 = r9.mDragState;
        if (r1 != r8) goto L_0x00ca;
    L_0x008e:
        r0 = r9.mActivePointerId;
        r0 = r9.isValidPointerForActionMove(r0);
        if (r0 == 0) goto L_0x0023;
    L_0x0096:
        r0 = r9.mActivePointerId;
        r0 = android.support.p015v4.view.MotionEventCompat.findPointerIndex(r10, r0);
        r1 = android.support.p015v4.view.MotionEventCompat.getX(r10, r0);
        r0 = android.support.p015v4.view.MotionEventCompat.getY(r10, r0);
        r2 = r9.mLastMotionX;
        r3 = r9.mActivePointerId;
        r2 = r2[r3];
        r1 = r1 - r2;
        r1 = (int) r1;
        r2 = r9.mLastMotionY;
        r3 = r9.mActivePointerId;
        r2 = r2[r3];
        r0 = r0 - r2;
        r0 = (int) r0;
        r2 = r9.mCapturedView;
        r2 = r2.getLeft();
        r2 = r2 + r1;
        r3 = r9.mCapturedView;
        r3 = r3.getTop();
        r3 = r3 + r0;
        r9.dragTo(r2, r3, r1, r0);
        r9.saveLastMotion(r10);
        goto L_0x0023;
    L_0x00ca:
        r1 = android.support.p015v4.view.MotionEventCompat.getPointerCount(r10);
    L_0x00ce:
        if (r0 >= r1) goto L_0x010a;
    L_0x00d0:
        r2 = android.support.p015v4.view.MotionEventCompat.getPointerId(r10, r0);
        r3 = r9.isValidPointerForActionMove(r2);
        if (r3 == 0) goto L_0x0107;
    L_0x00da:
        r3 = android.support.p015v4.view.MotionEventCompat.getX(r10, r0);
        r4 = android.support.p015v4.view.MotionEventCompat.getY(r10, r0);
        r5 = r9.mInitialMotionX;
        r5 = r5[r2];
        r5 = r3 - r5;
        r6 = r9.mInitialMotionY;
        r6 = r6[r2];
        r6 = r4 - r6;
        r9.reportNewEdgeDrags(r5, r6, r2);
        r7 = r9.mDragState;
        if (r7 == r8) goto L_0x010a;
    L_0x00f5:
        r3 = (int) r3;
        r4 = (int) r4;
        r3 = r9.findTopChildUnder(r3, r4);
        r4 = r9.checkTouchSlop(r3, r5, r6);
        if (r4 == 0) goto L_0x0107;
    L_0x0101:
        r2 = r9.tryCaptureViewForDrag(r3, r2);
        if (r2 != 0) goto L_0x010a;
    L_0x0107:
        r0 = r0 + 1;
        goto L_0x00ce;
    L_0x010a:
        r9.saveLastMotion(r10);
        goto L_0x0023;
    L_0x010f:
        r2 = android.support.p015v4.view.MotionEventCompat.getPointerId(r10, r3);
        r3 = r9.mDragState;
        if (r3 != r8) goto L_0x014a;
    L_0x0117:
        r3 = r9.mActivePointerId;
        if (r2 != r3) goto L_0x014a;
    L_0x011b:
        r3 = android.support.p015v4.view.MotionEventCompat.getPointerCount(r10);
    L_0x011f:
        if (r0 >= r3) goto L_0x016a;
    L_0x0121:
        r4 = android.support.p015v4.view.MotionEventCompat.getPointerId(r10, r0);
        r5 = r9.mActivePointerId;
        if (r4 == r5) goto L_0x014f;
    L_0x0129:
        r5 = android.support.p015v4.view.MotionEventCompat.getX(r10, r0);
        r6 = android.support.p015v4.view.MotionEventCompat.getY(r10, r0);
        r5 = (int) r5;
        r6 = (int) r6;
        r5 = r9.findTopChildUnder(r5, r6);
        r6 = r9.mCapturedView;
        if (r5 != r6) goto L_0x014f;
    L_0x013b:
        r5 = r9.mCapturedView;
        r4 = r9.tryCaptureViewForDrag(r5, r4);
        if (r4 == 0) goto L_0x014f;
    L_0x0143:
        r0 = r9.mActivePointerId;
    L_0x0145:
        if (r0 != r1) goto L_0x014a;
    L_0x0147:
        r9.releaseViewForPointerUp();
    L_0x014a:
        r9.clearMotionHistory(r2);
        goto L_0x0023;
    L_0x014f:
        r0 = r0 + 1;
        goto L_0x011f;
    L_0x0152:
        r0 = r9.mDragState;
        if (r0 != r8) goto L_0x0159;
    L_0x0156:
        r9.releaseViewForPointerUp();
    L_0x0159:
        r9.cancel();
        goto L_0x0023;
    L_0x015e:
        r0 = r9.mDragState;
        if (r0 != r8) goto L_0x0165;
    L_0x0162:
        r9.dispatchViewReleased(r5, r5);
    L_0x0165:
        r9.cancel();
        goto L_0x0023;
    L_0x016a:
        r0 = r1;
        goto L_0x0145;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.ViewDragHelper.processTouchEvent(android.view.MotionEvent):void");
    }

    void setDragState(int i) {
        this.mParentView.removeCallbacks(this.mSetIdleRunnable);
        if (this.mDragState != i) {
            this.mDragState = i;
            this.mCallback.onViewDragStateChanged(i);
            if (this.mDragState == 0) {
                this.mCapturedView = null;
            }
        }
    }

    public void setEdgeTrackingEnabled(int i) {
        this.mTrackingEdges = i;
    }

    public void setMinVelocity(float f) {
        this.mMinVelocity = f;
    }

    public boolean settleCapturedViewAt(int i, int i2) {
        if (this.mReleaseInProgress) {
            return forceSettleCapturedViewAt(i, i2, (int) VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int) VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Missing block: B:46:0x00fb, code:
            if (r8 != r7) goto L_0x0103;
     */
    public boolean shouldInterceptTouchEvent(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = android.support.p015v4.view.MotionEventCompat.getActionMasked(r14);
        r1 = android.support.p015v4.view.MotionEventCompat.getActionIndex(r14);
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r13.cancel();
    L_0x000d:
        r2 = r13.mVelocityTracker;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = android.view.VelocityTracker.obtain();
        r13.mVelocityTracker = r2;
    L_0x0017:
        r2 = r13.mVelocityTracker;
        r2.addMovement(r14);
        switch(r0) {
            case 0: goto L_0x0026;
            case 1: goto L_0x0127;
            case 2: goto L_0x0092;
            case 3: goto L_0x0127;
            case 4: goto L_0x001f;
            case 5: goto L_0x005a;
            case 6: goto L_0x011e;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r13.mDragState;
        r1 = 1;
        if (r0 != r1) goto L_0x012c;
    L_0x0024:
        r0 = 1;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = 0;
        r2 = android.support.p015v4.view.MotionEventCompat.getPointerId(r14, r2);
        r13.saveInitialMotion(r0, r1, r2);
        r0 = (int) r0;
        r1 = (int) r1;
        r0 = r13.findTopChildUnder(r0, r1);
        r1 = r13.mCapturedView;
        if (r0 != r1) goto L_0x0048;
    L_0x0040:
        r1 = r13.mDragState;
        r3 = 2;
        if (r1 != r3) goto L_0x0048;
    L_0x0045:
        r13.tryCaptureViewForDrag(r0, r2);
    L_0x0048:
        r0 = r13.mInitialEdgesTouched;
        r0 = r0[r2];
        r1 = r13.mTrackingEdges;
        r1 = r1 & r0;
        if (r1 == 0) goto L_0x001f;
    L_0x0051:
        r1 = r13.mCallback;
        r3 = r13.mTrackingEdges;
        r0 = r0 & r3;
        r1.onEdgeTouched(r0, r2);
        goto L_0x001f;
    L_0x005a:
        r0 = android.support.p015v4.view.MotionEventCompat.getPointerId(r14, r1);
        r2 = android.support.p015v4.view.MotionEventCompat.getX(r14, r1);
        r1 = android.support.p015v4.view.MotionEventCompat.getY(r14, r1);
        r13.saveInitialMotion(r2, r1, r0);
        r3 = r13.mDragState;
        if (r3 != 0) goto L_0x007f;
    L_0x006d:
        r1 = r13.mInitialEdgesTouched;
        r1 = r1[r0];
        r2 = r13.mTrackingEdges;
        r2 = r2 & r1;
        if (r2 == 0) goto L_0x001f;
    L_0x0076:
        r2 = r13.mCallback;
        r3 = r13.mTrackingEdges;
        r1 = r1 & r3;
        r2.onEdgeTouched(r1, r0);
        goto L_0x001f;
    L_0x007f:
        r3 = r13.mDragState;
        r4 = 2;
        if (r3 != r4) goto L_0x001f;
    L_0x0084:
        r2 = (int) r2;
        r1 = (int) r1;
        r1 = r13.findTopChildUnder(r2, r1);
        r2 = r13.mCapturedView;
        if (r1 != r2) goto L_0x001f;
    L_0x008e:
        r13.tryCaptureViewForDrag(r1, r0);
        goto L_0x001f;
    L_0x0092:
        r0 = r13.mInitialMotionX;
        if (r0 == 0) goto L_0x001f;
    L_0x0096:
        r0 = r13.mInitialMotionY;
        if (r0 == 0) goto L_0x001f;
    L_0x009a:
        r2 = android.support.p015v4.view.MotionEventCompat.getPointerCount(r14);
        r0 = 0;
        r1 = r0;
    L_0x00a0:
        if (r1 >= r2) goto L_0x0119;
    L_0x00a2:
        r3 = android.support.p015v4.view.MotionEventCompat.getPointerId(r14, r1);
        r0 = r13.isValidPointerForActionMove(r3);
        if (r0 == 0) goto L_0x0113;
    L_0x00ac:
        r0 = android.support.p015v4.view.MotionEventCompat.getX(r14, r1);
        r4 = android.support.p015v4.view.MotionEventCompat.getY(r14, r1);
        r5 = r13.mInitialMotionX;
        r5 = r5[r3];
        r5 = r0 - r5;
        r6 = r13.mInitialMotionY;
        r6 = r6[r3];
        r6 = r4 - r6;
        r0 = (int) r0;
        r4 = (int) r4;
        r4 = r13.findTopChildUnder(r0, r4);
        if (r4 == 0) goto L_0x0117;
    L_0x00c8:
        r0 = r13.checkTouchSlop(r4, r5, r6);
        if (r0 == 0) goto L_0x0117;
    L_0x00ce:
        r0 = 1;
    L_0x00cf:
        if (r0 == 0) goto L_0x0103;
    L_0x00d1:
        r7 = r4.getLeft();
        r8 = (int) r5;
        r8 = r8 + r7;
        r9 = r13.mCallback;
        r10 = (int) r5;
        r8 = r9.clampViewPositionHorizontal(r4, r8, r10);
        r9 = r4.getTop();
        r10 = (int) r6;
        r10 = r10 + r9;
        r11 = r13.mCallback;
        r12 = (int) r6;
        r10 = r11.clampViewPositionVertical(r4, r10, r12);
        r11 = r13.mCallback;
        r11 = r11.getViewHorizontalDragRange(r4);
        r12 = r13.mCallback;
        r12 = r12.getViewVerticalDragRange(r4);
        if (r11 == 0) goto L_0x00fd;
    L_0x00f9:
        if (r11 <= 0) goto L_0x0103;
    L_0x00fb:
        if (r8 != r7) goto L_0x0103;
    L_0x00fd:
        if (r12 == 0) goto L_0x0119;
    L_0x00ff:
        if (r12 <= 0) goto L_0x0103;
    L_0x0101:
        if (r10 == r9) goto L_0x0119;
    L_0x0103:
        r13.reportNewEdgeDrags(r5, r6, r3);
        r5 = r13.mDragState;
        r6 = 1;
        if (r5 == r6) goto L_0x0119;
    L_0x010b:
        if (r0 == 0) goto L_0x0113;
    L_0x010d:
        r0 = r13.tryCaptureViewForDrag(r4, r3);
        if (r0 != 0) goto L_0x0119;
    L_0x0113:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00a0;
    L_0x0117:
        r0 = 0;
        goto L_0x00cf;
    L_0x0119:
        r13.saveLastMotion(r14);
        goto L_0x001f;
    L_0x011e:
        r0 = android.support.p015v4.view.MotionEventCompat.getPointerId(r14, r1);
        r13.clearMotionHistory(r0);
        goto L_0x001f;
    L_0x0127:
        r13.cancel();
        goto L_0x001f;
    L_0x012c:
        r0 = 0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.ViewDragHelper.shouldInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean smoothSlideViewTo(View view, int i, int i2) {
        this.mCapturedView = view;
        this.mActivePointerId = -1;
        boolean forceSettleCapturedViewAt = forceSettleCapturedViewAt(i, i2, 0, 0);
        if (!(forceSettleCapturedViewAt || this.mDragState != 0 || this.mCapturedView == null)) {
            this.mCapturedView = null;
        }
        return forceSettleCapturedViewAt;
    }

    boolean tryCaptureViewForDrag(View view, int i) {
        if (view == this.mCapturedView && this.mActivePointerId == i) {
            return true;
        }
        if (view == null || !this.mCallback.tryCaptureView(view, i)) {
            return false;
        }
        this.mActivePointerId = i;
        captureChildView(view, i);
        return true;
    }
}
