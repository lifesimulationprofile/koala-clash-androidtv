package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class LinearSmoothScroller {
    public final DecelerateInterpolator mDecelerateInterpolator;
    public final DisplayMetrics mDisplayMetrics;
    public boolean mHasCalculatedMillisPerPixel;
    public int mInterimTargetDx;
    public int mInterimTargetDy;
    public RecyclerView.LayoutManager mLayoutManager;
    public final LinearInterpolator mLinearInterpolator;
    public float mMillisPerPixel;
    public boolean mPendingInitialRun;
    public RecyclerView mRecyclerView;
    public final RecyclerView$SmoothScroller$Action mRecyclingAction;
    public boolean mRunning;
    public boolean mStarted;
    public int mTargetPosition = -1;
    public PointF mTargetVector;
    public View mTargetView;

    public LinearSmoothScroller(Context context) {
        RecyclerView$SmoothScroller$Action recyclerView$SmoothScroller$Action = new RecyclerView$SmoothScroller$Action();
        recyclerView$SmoothScroller$Action.mJumpToPosition = -1;
        recyclerView$SmoothScroller$Action.mChanged = false;
        recyclerView$SmoothScroller$Action.mConsecutiveUpdates = 0;
        recyclerView$SmoothScroller$Action.mDx = 0;
        recyclerView$SmoothScroller$Action.mDy = 0;
        recyclerView$SmoothScroller$Action.mDuration = Integer.MIN_VALUE;
        recyclerView$SmoothScroller$Action.mInterpolator = null;
        this.mRecyclingAction = recyclerView$SmoothScroller$Action;
        this.mLinearInterpolator = new LinearInterpolator();
        this.mDecelerateInterpolator = new DecelerateInterpolator();
        this.mHasCalculatedMillisPerPixel = false;
        this.mInterimTargetDx = 0;
        this.mInterimTargetDy = 0;
        this.mDisplayMetrics = context.getResources().getDisplayMetrics();
    }

    public static int calculateDtToFit(int i, int i2, int i3, int i4, int i5) {
        if (i5 == -1) {
            return i3 - i;
        }
        if (i5 != 0) {
            if (i5 == 1) {
                return i4 - i2;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i6 = i3 - i;
        if (i6 > 0) {
            return i6;
        }
        int i7 = i4 - i2;
        if (i7 < 0) {
            return i7;
        }
        return 0;
    }

    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int calculateTimeForScrolling(int i) {
        float fAbs = Math.abs(i);
        if (!this.mHasCalculatedMillisPerPixel) {
            this.mMillisPerPixel = calculateSpeedPerPixel(this.mDisplayMetrics);
            this.mHasCalculatedMillisPerPixel = true;
        }
        return (int) Math.ceil(fAbs * this.mMillisPerPixel);
    }

    public final PointF computeScrollVectorForPosition(int i) {
        Object obj = this.mLayoutManager;
        if (obj instanceof RecyclerView$SmoothScroller$ScrollVectorProvider) {
            return ((RecyclerView$SmoothScroller$ScrollVectorProvider) obj).computeScrollVectorForPosition(i);
        }
        Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + RecyclerView$SmoothScroller$ScrollVectorProvider.class.getCanonicalName());
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00f8  */
    public final void onAnimation(int i, int i2) {
        PointF pointFComputeScrollVectorForPosition;
        RecyclerView recyclerView = this.mRecyclerView;
        if (this.mTargetPosition == -1 || recyclerView == null) {
            stop();
        }
        if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (pointFComputeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null) {
            float f = pointFComputeScrollVectorForPosition.x;
            if (f != 0.0f || pointFComputeScrollVectorForPosition.y != 0.0f) {
                recyclerView.scrollStep((int) Math.signum(f), (int) Math.signum(pointFComputeScrollVectorForPosition.y), null);
            }
        }
        this.mPendingInitialRun = false;
        View view = this.mTargetView;
        RecyclerView$SmoothScroller$Action recyclerView$SmoothScroller$Action = this.mRecyclingAction;
        if (view != null) {
            this.mRecyclerView.getClass();
            RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if ((childViewHolderInt != null ? childViewHolderInt.getLayoutPosition() : -1) == this.mTargetPosition) {
                View view2 = this.mTargetView;
                RecyclerView.State state = recyclerView.mState;
                onTargetFound(view2, recyclerView$SmoothScroller$Action);
                recyclerView$SmoothScroller$Action.runIfNecessary(recyclerView);
                stop();
            } else {
                Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                this.mTargetView = null;
            }
        }
        if (this.mRunning) {
            RecyclerView.State state2 = recyclerView.mState;
            if (this.mRecyclerView.mLayout.getChildCount() == 0) {
                stop();
            } else {
                int i3 = this.mInterimTargetDx;
                int i4 = i3 - i;
                if (i3 * i4 <= 0) {
                    i4 = 0;
                }
                this.mInterimTargetDx = i4;
                int i5 = this.mInterimTargetDy;
                int i6 = i5 - i2;
                if (i5 * i6 <= 0) {
                    i6 = 0;
                }
                this.mInterimTargetDy = i6;
                if (i4 == 0 && i6 == 0) {
                    PointF pointFComputeScrollVectorForPosition2 = computeScrollVectorForPosition(this.mTargetPosition);
                    if (pointFComputeScrollVectorForPosition2 != null) {
                        float f2 = pointFComputeScrollVectorForPosition2.x;
                        if (f2 == 0.0f && pointFComputeScrollVectorForPosition2.y == 0.0f) {
                            recyclerView$SmoothScroller$Action.mJumpToPosition = this.mTargetPosition;
                            stop();
                        } else {
                            float f3 = pointFComputeScrollVectorForPosition2.y;
                            float fSqrt = (float) Math.sqrt((f3 * f3) + (f2 * f2));
                            float f4 = pointFComputeScrollVectorForPosition2.x / fSqrt;
                            pointFComputeScrollVectorForPosition2.x = f4;
                            float f5 = pointFComputeScrollVectorForPosition2.y / fSqrt;
                            pointFComputeScrollVectorForPosition2.y = f5;
                            this.mTargetVector = pointFComputeScrollVectorForPosition2;
                            this.mInterimTargetDx = (int) (f4 * 10000.0f);
                            this.mInterimTargetDy = (int) (f5 * 10000.0f);
                            int iCalculateTimeForScrolling = calculateTimeForScrolling(ModuleDescriptor.MODULE_VERSION);
                            int i7 = (int) (this.mInterimTargetDx * 1.2f);
                            int i8 = (int) (this.mInterimTargetDy * 1.2f);
                            recyclerView$SmoothScroller$Action.mDx = i7;
                            recyclerView$SmoothScroller$Action.mDy = i8;
                            recyclerView$SmoothScroller$Action.mDuration = (int) (iCalculateTimeForScrolling * 1.2f);
                            recyclerView$SmoothScroller$Action.mInterpolator = this.mLinearInterpolator;
                            recyclerView$SmoothScroller$Action.mChanged = true;
                        }
                    } else {
                        recyclerView$SmoothScroller$Action.mJumpToPosition = this.mTargetPosition;
                        stop();
                    }
                }
            }
            boolean z = recyclerView$SmoothScroller$Action.mJumpToPosition >= 0;
            recyclerView$SmoothScroller$Action.runIfNecessary(recyclerView);
            if (z && this.mRunning) {
                this.mPendingInitialRun = true;
                recyclerView.mViewFlinger.postOnAnimation();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0015  */
    /* JADX WARN: Code duplicated, block: B:25:0x006b  */
    public void onTargetFound(View view, RecyclerView$SmoothScroller$Action recyclerView$SmoothScroller$Action) {
        int i;
        int iCalculateDtToFit;
        PointF pointF = this.mTargetVector;
        int i2 = -1;
        int iCalculateDtToFit2 = 0;
        if (pointF != null) {
            float f = pointF.x;
            if (f == 0.0f) {
                i = 0;
            } else {
                i = f > 0.0f ? 1 : -1;
            }
        } else {
            i = 0;
        }
        RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            iCalculateDtToFit = 0;
        } else {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            iCalculateDtToFit = calculateDtToFit((view.getLeft() - ((RecyclerView.LayoutParams) view.getLayoutParams()).mDecorInsets.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, view.getRight() + ((RecyclerView.LayoutParams) view.getLayoutParams()).mDecorInsets.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, layoutManager.getPaddingLeft(), layoutManager.mWidth - layoutManager.getPaddingRight(), i);
        }
        PointF pointF2 = this.mTargetVector;
        if (pointF2 != null) {
            float f2 = pointF2.y;
            if (f2 == 0.0f) {
                i2 = 0;
            } else if (f2 > 0.0f) {
                i2 = 1;
            }
        } else {
            i2 = 0;
        }
        RecyclerView.LayoutManager layoutManager2 = this.mLayoutManager;
        if (layoutManager2 != null && layoutManager2.canScrollVertically()) {
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) view.getLayoutParams();
            iCalculateDtToFit2 = calculateDtToFit((view.getTop() - ((RecyclerView.LayoutParams) view.getLayoutParams()).mDecorInsets.top) - ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin, view.getBottom() + ((RecyclerView.LayoutParams) view.getLayoutParams()).mDecorInsets.bottom + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin, layoutManager2.getPaddingTop(), layoutManager2.mHeight - layoutManager2.getPaddingBottom(), i2);
        }
        int iCeil = (int) Math.ceil(((double) calculateTimeForScrolling((int) Math.sqrt((iCalculateDtToFit2 * iCalculateDtToFit2) + (iCalculateDtToFit * iCalculateDtToFit)))) / 0.3356d);
        if (iCeil > 0) {
            recyclerView$SmoothScroller$Action.mDx = -iCalculateDtToFit;
            recyclerView$SmoothScroller$Action.mDy = -iCalculateDtToFit2;
            recyclerView$SmoothScroller$Action.mDuration = iCeil;
            recyclerView$SmoothScroller$Action.mInterpolator = this.mDecelerateInterpolator;
            recyclerView$SmoothScroller$Action.mChanged = true;
        }
    }

    public final void stop() {
        if (this.mRunning) {
            this.mRunning = false;
            this.mInterimTargetDy = 0;
            this.mInterimTargetDx = 0;
            this.mTargetVector = null;
            this.mRecyclerView.mState.mTargetPosition = -1;
            this.mTargetView = null;
            this.mTargetPosition = -1;
            this.mPendingInitialRun = false;
            RecyclerView.LayoutManager layoutManager = this.mLayoutManager;
            if (layoutManager.mSmoothScroller == this) {
                layoutManager.mSmoothScroller = null;
            }
            this.mLayoutManager = null;
            this.mRecyclerView = null;
        }
    }
}
