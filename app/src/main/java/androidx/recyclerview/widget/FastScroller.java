package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import androidx.core.view.ViewCompat;
import com.google.android.gms.tasks.zzg;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FastScroller extends RecyclerView.ItemDecoration {
    public int mAnimationState;
    public final zzg mHideRunnable;
    public float mHorizontalDragX;
    public int mHorizontalThumbCenterX;
    public final StateListDrawable mHorizontalThumbDrawable;
    public final int mHorizontalThumbHeight;
    public int mHorizontalThumbWidth;
    public final Drawable mHorizontalTrackDrawable;
    public final int mHorizontalTrackHeight;
    public final int mMargin;
    public final RecyclerView mRecyclerView;
    public final int mScrollbarMinimumRange;
    public final ValueAnimator mShowHideAnimator;
    public float mVerticalDragY;
    public int mVerticalThumbCenterY;
    public final StateListDrawable mVerticalThumbDrawable;
    public int mVerticalThumbHeight;
    public final int mVerticalThumbWidth;
    public final Drawable mVerticalTrackDrawable;
    public final int mVerticalTrackWidth;
    public static final int[] PRESSED_STATE_SET = {R.attr.state_pressed};
    public static final int[] EMPTY_STATE_SET = new int[0];
    public int mRecyclerViewWidth = 0;
    public int mRecyclerViewHeight = 0;
    public boolean mNeedVerticalScrollbar = false;
    public boolean mNeedHorizontalScrollbar = false;
    public int mState = 0;
    public int mDragState = 0;
    public final int[] mVerticalRange = new int[2];
    public final int[] mHorizontalRange = new int[2];

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnimatorListener extends AnimatorListenerAdapter {
        public boolean mCanceled = false;

        public AnimatorListener() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            this.mCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            if (this.mCanceled) {
                this.mCanceled = false;
                return;
            }
            FastScroller fastScroller = FastScroller.this;
            if (((Float) fastScroller.mShowHideAnimator.getAnimatedValue()).floatValue() == 0.0f) {
                fastScroller.mAnimationState = 0;
                fastScroller.setState(0);
            } else {
                fastScroller.mAnimationState = 2;
                fastScroller.mRecyclerView.invalidate();
            }
        }
    }

    public FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mShowHideAnimator = valueAnimatorOfFloat;
        this.mAnimationState = 0;
        zzg zzgVar = new zzg(15, this);
        this.mHideRunnable = zzgVar;
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: androidx.recyclerview.widget.FastScroller.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView recyclerView2, int i4, int i5) {
                int iComputeHorizontalScrollOffset = recyclerView2.computeHorizontalScrollOffset();
                int iComputeVerticalScrollOffset = recyclerView2.computeVerticalScrollOffset();
                FastScroller fastScroller = FastScroller.this;
                int i6 = fastScroller.mScrollbarMinimumRange;
                int iComputeVerticalScrollRange = fastScroller.mRecyclerView.computeVerticalScrollRange();
                int i7 = fastScroller.mRecyclerViewHeight;
                fastScroller.mNeedVerticalScrollbar = iComputeVerticalScrollRange - i7 > 0 && i7 >= i6;
                int iComputeHorizontalScrollRange = fastScroller.mRecyclerView.computeHorizontalScrollRange();
                int i8 = fastScroller.mRecyclerViewWidth;
                boolean z = iComputeHorizontalScrollRange - i8 > 0 && i8 >= i6;
                fastScroller.mNeedHorizontalScrollbar = z;
                boolean z2 = fastScroller.mNeedVerticalScrollbar;
                if (!z2 && !z) {
                    if (fastScroller.mState != 0) {
                        fastScroller.setState(0);
                        return;
                    }
                    return;
                }
                if (z2) {
                    float f = i7;
                    fastScroller.mVerticalThumbCenterY = (int) ((((f / 2.0f) + iComputeVerticalScrollOffset) * f) / iComputeVerticalScrollRange);
                    fastScroller.mVerticalThumbHeight = Math.min(i7, (i7 * i7) / iComputeVerticalScrollRange);
                }
                if (fastScroller.mNeedHorizontalScrollbar) {
                    float f2 = iComputeHorizontalScrollOffset;
                    float f3 = i8;
                    fastScroller.mHorizontalThumbCenterX = (int) ((((f3 / 2.0f) + f2) * f3) / iComputeHorizontalScrollRange);
                    fastScroller.mHorizontalThumbWidth = Math.min(i8, (i8 * i8) / iComputeHorizontalScrollRange);
                }
                int i9 = fastScroller.mState;
                if (i9 == 0 || i9 == 1) {
                    fastScroller.setState(1);
                }
            }
        };
        this.mVerticalThumbDrawable = stateListDrawable;
        this.mVerticalTrackDrawable = drawable;
        this.mHorizontalThumbDrawable = stateListDrawable2;
        this.mHorizontalTrackDrawable = drawable2;
        this.mVerticalThumbWidth = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.mVerticalTrackWidth = Math.max(i, drawable.getIntrinsicWidth());
        this.mHorizontalThumbHeight = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.mHorizontalTrackHeight = Math.max(i, drawable2.getIntrinsicWidth());
        this.mScrollbarMinimumRange = i2;
        this.mMargin = i3;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new AnimatorListener());
        valueAnimatorOfFloat.addUpdateListener(new TextInputLayout.AnonymousClass4(1, this));
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            ArrayList arrayList = recyclerView2.mItemDecorations;
            RecyclerView.LayoutManager layoutManager = recyclerView2.mLayout;
            if (layoutManager != null) {
                layoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
            }
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                recyclerView2.setWillNotDraw(recyclerView2.getOverScrollMode() == 2);
            }
            recyclerView2.markItemDecorInsetsDirty();
            recyclerView2.requestLayout();
            RecyclerView recyclerView3 = this.mRecyclerView;
            recyclerView3.mOnItemTouchListeners.remove(this);
            if (recyclerView3.mInterceptingOnItemTouchListener == this) {
                recyclerView3.mInterceptingOnItemTouchListener = null;
            }
            ArrayList arrayList2 = this.mRecyclerView.mScrollListeners;
            if (arrayList2 != null) {
                arrayList2.remove(onScrollListener);
            }
            this.mRecyclerView.removeCallbacks(zzgVar);
        }
        this.mRecyclerView = recyclerView;
        recyclerView.addItemDecoration(this);
        this.mRecyclerView.mOnItemTouchListeners.add(this);
        this.mRecyclerView.addOnScrollListener(onScrollListener);
    }

    public static int scrollTo(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 != 0) {
            int i5 = i - i3;
            int i6 = (int) (((f2 - f) / i4) * i5);
            int i7 = i2 + i6;
            if (i7 < i5 && i7 >= 0) {
                return i6;
            }
        }
        return 0;
    }

    public final boolean isPointInsideHorizontalThumb(float f, float f2) {
        if (f2 < this.mRecyclerViewHeight - this.mHorizontalThumbHeight) {
            return false;
        }
        int i = this.mHorizontalThumbCenterX;
        int i2 = this.mHorizontalThumbWidth;
        return f >= ((float) (i - (i2 / 2))) && f <= ((float) ((i2 / 2) + i));
    }

    public final boolean isPointInsideVerticalThumb(float f, float f2) {
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        int layoutDirection = this.mRecyclerView.getLayoutDirection();
        int i = this.mVerticalThumbWidth;
        if (layoutDirection == 1) {
            if (f > i) {
                return false;
            }
        } else if (f < this.mRecyclerViewWidth - i) {
            return false;
        }
        int i2 = this.mVerticalThumbCenterY;
        int i3 = this.mVerticalThumbHeight / 2;
        return f2 >= ((float) (i2 - i3)) && f2 <= ((float) (i3 + i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas canvas) {
        int i = this.mRecyclerViewWidth;
        RecyclerView recyclerView = this.mRecyclerView;
        if (i != recyclerView.getWidth() || this.mRecyclerViewHeight != recyclerView.getHeight()) {
            this.mRecyclerViewWidth = recyclerView.getWidth();
            this.mRecyclerViewHeight = recyclerView.getHeight();
            setState(0);
            return;
        }
        if (this.mAnimationState != 0) {
            if (this.mNeedVerticalScrollbar) {
                int i2 = this.mRecyclerViewWidth;
                int i3 = this.mVerticalThumbWidth;
                int i4 = i2 - i3;
                int i5 = this.mVerticalThumbCenterY;
                int i6 = this.mVerticalThumbHeight;
                int i7 = i5 - (i6 / 2);
                StateListDrawable stateListDrawable = this.mVerticalThumbDrawable;
                stateListDrawable.setBounds(0, 0, i3, i6);
                int i8 = this.mVerticalTrackWidth;
                int i9 = this.mRecyclerViewHeight;
                Drawable drawable = this.mVerticalTrackDrawable;
                drawable.setBounds(0, 0, i8, i9);
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                if (recyclerView.getLayoutDirection() == 1) {
                    drawable.draw(canvas);
                    canvas.translate(i3, i7);
                    canvas.scale(-1.0f, 1.0f);
                    stateListDrawable.draw(canvas);
                    canvas.scale(-1.0f, 1.0f);
                    canvas.translate(-i3, -i7);
                } else {
                    canvas.translate(i4, 0.0f);
                    drawable.draw(canvas);
                    canvas.translate(0.0f, i7);
                    stateListDrawable.draw(canvas);
                    canvas.translate(-i4, -i7);
                }
            }
            if (this.mNeedHorizontalScrollbar) {
                int i10 = this.mRecyclerViewHeight;
                int i11 = this.mHorizontalThumbHeight;
                int i12 = i10 - i11;
                int i13 = this.mHorizontalThumbCenterX;
                int i14 = this.mHorizontalThumbWidth;
                int i15 = i13 - (i14 / 2);
                StateListDrawable stateListDrawable2 = this.mHorizontalThumbDrawable;
                stateListDrawable2.setBounds(0, 0, i14, i11);
                int i16 = this.mRecyclerViewWidth;
                int i17 = this.mHorizontalTrackHeight;
                Drawable drawable2 = this.mHorizontalTrackDrawable;
                drawable2.setBounds(0, 0, i16, i17);
                canvas.translate(0.0f, i12);
                drawable2.draw(canvas);
                canvas.translate(i15, 0.0f);
                stateListDrawable2.draw(canvas);
                canvas.translate(-i15, -i12);
            }
        }
    }

    public final void setState(int i) {
        zzg zzgVar = this.mHideRunnable;
        StateListDrawable stateListDrawable = this.mVerticalThumbDrawable;
        if (i == 2 && this.mState != 2) {
            stateListDrawable.setState(PRESSED_STATE_SET);
            this.mRecyclerView.removeCallbacks(zzgVar);
        }
        if (i == 0) {
            this.mRecyclerView.invalidate();
        } else {
            show();
        }
        if (this.mState == 2 && i != 2) {
            stateListDrawable.setState(EMPTY_STATE_SET);
            this.mRecyclerView.removeCallbacks(zzgVar);
            this.mRecyclerView.postDelayed(zzgVar, 1200);
        } else if (i == 1) {
            this.mRecyclerView.removeCallbacks(zzgVar);
            this.mRecyclerView.postDelayed(zzgVar, 1500);
        }
        this.mState = i;
    }

    public final void show() {
        int i = this.mAnimationState;
        ValueAnimator valueAnimator = this.mShowHideAnimator;
        if (i != 0) {
            if (i != 3) {
                return;
            } else {
                valueAnimator.cancel();
            }
        }
        this.mAnimationState = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }
}
