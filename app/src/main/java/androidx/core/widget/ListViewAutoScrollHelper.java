package androidx.core.widget;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import androidx.appcompat.widget.DropDownListView;
import com.google.android.gms.tasks.zzg;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ListViewAutoScrollHelper implements View.OnTouchListener {
    public static final int DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
    public final int mActivationDelay;
    public boolean mAlreadyDelayed;
    public boolean mAnimating;
    public final AccelerateInterpolator mEdgeInterpolator;
    public final int mEdgeType;
    public boolean mEnabled;
    public final float[] mMaximumEdges;
    public final float[] mMaximumVelocity;
    public final float[] mMinimumVelocity;
    public boolean mNeedsCancel;
    public boolean mNeedsReset;
    public final float[] mRelativeEdges;
    public final float[] mRelativeVelocity;
    public zzg mRunnable;
    public final AutoScrollHelper$ClampedScroller mScroller;
    public final DropDownListView mTarget;
    public final DropDownListView mTarget$1;

    public ListViewAutoScrollHelper(DropDownListView dropDownListView) {
        AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller = new AutoScrollHelper$ClampedScroller();
        autoScrollHelper$ClampedScroller.mStartTime = Long.MIN_VALUE;
        autoScrollHelper$ClampedScroller.mStopTime = -1L;
        autoScrollHelper$ClampedScroller.mDeltaTime = 0L;
        this.mScroller = autoScrollHelper$ClampedScroller;
        this.mEdgeInterpolator = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.mRelativeEdges = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.mMaximumEdges = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.mRelativeVelocity = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.mMinimumVelocity = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.mMaximumVelocity = fArr5;
        this.mTarget$1 = dropDownListView;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = ((int) ((1575.0f * f) + 0.5f)) / 1000.0f;
        fArr5[0] = f2;
        fArr5[1] = f2;
        float f3 = ((int) ((f * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f3;
        fArr4[1] = f3;
        this.mEdgeType = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.mActivationDelay = DEFAULT_ACTIVATION_DELAY;
        autoScrollHelper$ClampedScroller.mRampUpDuration = 500;
        autoScrollHelper$ClampedScroller.mRampDownDuration = 500;
        this.mTarget = dropDownListView;
    }

    public static float constrain(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        return f < f2 ? f2 : f;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:13:0x003c  */
    /* JADX WARN: Code duplicated, block: B:15:0x004b  */
    /* JADX WARN: Code duplicated, block: B:17:0x0051  */
    public final float computeTargetVelocity(float f, float f2, float f3, int i) {
        float fConstrain;
        float interpolation;
        float fConstrain2 = constrain(this.mRelativeEdges[i] * f2, 0.0f, this.mMaximumEdges[i]);
        float fConstrainEdgeValue = constrainEdgeValue(f2 - f, fConstrain2) - constrainEdgeValue(f, fConstrain2);
        AccelerateInterpolator accelerateInterpolator = this.mEdgeInterpolator;
        if (fConstrainEdgeValue >= 0.0f) {
            if (fConstrainEdgeValue > 0.0f) {
                interpolation = accelerateInterpolator.getInterpolation(fConstrainEdgeValue);
            } else {
                fConstrain = 0.0f;
            }
            if (fConstrain == 0.0f) {
                return 0.0f;
            }
            float f4 = this.mRelativeVelocity[i];
            float f5 = this.mMinimumVelocity[i];
            float f6 = this.mMaximumVelocity[i];
            float f7 = f4 * f3;
            return fConstrain > 0.0f ? constrain(fConstrain * f7, f5, f6) : -constrain((-fConstrain) * f7, f5, f6);
        }
        interpolation = -accelerateInterpolator.getInterpolation(-fConstrainEdgeValue);
        fConstrain = constrain(interpolation, -1.0f, 1.0f);
        if (fConstrain == 0.0f) {
            return 0.0f;
        }
        float f8 = this.mRelativeVelocity[i];
        float f9 = this.mMinimumVelocity[i];
        float f10 = this.mMaximumVelocity[i];
        float f11 = f8 * f3;
        if (fConstrain > 0.0f) {
        }
    }

    public final float constrainEdgeValue(float f, float f2) {
        if (f2 != 0.0f) {
            int i = this.mEdgeType;
            if (i == 0 || i == 1) {
                if (f < f2) {
                    if (f >= 0.0f) {
                        return 1.0f - (f / f2);
                    }
                    if (this.mAnimating && i == 1) {
                        return 1.0f;
                    }
                }
            } else if (i == 2 && f < 0.0f) {
                return f / (-f2);
            }
        }
        return 0.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
    
        if (r0 != 3) goto L30;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.mEnabled
            r1 = 0
            if (r0 != 0) goto L7
            goto L7e
        L7:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1b
            if (r0 == r2) goto L17
            r3 = 2
            if (r0 == r3) goto L1f
            r8 = 3
            if (r0 == r8) goto L17
            goto L7e
        L17:
            r7.requestStop()
            return r1
        L1b:
            r7.mNeedsCancel = r2
            r7.mAlreadyDelayed = r1
        L1f:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            androidx.appcompat.widget.DropDownListView r4 = r7.mTarget$1
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.computeTargetVelocity(r0, r3, r5, r1)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.computeTargetVelocity(r9, r8, r3, r2)
            androidx.core.widget.AutoScrollHelper$ClampedScroller r9 = r7.mScroller
            r9.mTargetVelocityX = r0
            r9.mTargetVelocityY = r8
            boolean r8 = r7.mAnimating
            if (r8 != 0) goto L7e
            boolean r8 = r7.shouldAnimate()
            if (r8 == 0) goto L7e
            com.google.android.gms.tasks.zzg r8 = r7.mRunnable
            if (r8 != 0) goto L62
            com.google.android.gms.tasks.zzg r8 = new com.google.android.gms.tasks.zzg
            r9 = 10
            r8.<init>(r9, r7)
            r7.mRunnable = r8
        L62:
            r7.mAnimating = r2
            r7.mNeedsReset = r2
            boolean r8 = r7.mAlreadyDelayed
            if (r8 != 0) goto L77
            int r8 = r7.mActivationDelay
            if (r8 <= 0) goto L77
            com.google.android.gms.tasks.zzg r9 = r7.mRunnable
            long r5 = (long) r8
            java.util.WeakHashMap r8 = androidx.core.view.ViewCompat.sViewPropertyAnimatorMap
            r4.postOnAnimationDelayed(r9, r5)
            goto L7c
        L77:
            com.google.android.gms.tasks.zzg r8 = r7.mRunnable
            r8.run()
        L7c:
            r7.mAlreadyDelayed = r2
        L7e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.ListViewAutoScrollHelper.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public final void requestStop() {
        int i = 0;
        if (this.mNeedsReset) {
            this.mAnimating = false;
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller = this.mScroller;
        int i2 = (int) (jCurrentAnimationTimeMillis - autoScrollHelper$ClampedScroller.mStartTime);
        int i3 = autoScrollHelper$ClampedScroller.mRampDownDuration;
        if (i2 > i3) {
            i = i3;
        } else if (i2 >= 0) {
            i = i2;
        }
        autoScrollHelper$ClampedScroller.mEffectiveRampDown = i;
        autoScrollHelper$ClampedScroller.mStopValue = autoScrollHelper$ClampedScroller.getValueAt(jCurrentAnimationTimeMillis);
        autoScrollHelper$ClampedScroller.mStopTime = jCurrentAnimationTimeMillis;
    }

    public final boolean shouldAnimate() {
        DropDownListView dropDownListView;
        int count;
        AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller = this.mScroller;
        float f = autoScrollHelper$ClampedScroller.mTargetVelocityY;
        int iAbs = (int) (f / Math.abs(f));
        Math.abs(autoScrollHelper$ClampedScroller.mTargetVelocityX);
        if (iAbs != 0 && (count = (dropDownListView = this.mTarget).getCount()) != 0) {
            int childCount = dropDownListView.getChildCount();
            int firstVisiblePosition = dropDownListView.getFirstVisiblePosition();
            int i = firstVisiblePosition + childCount;
            if (iAbs <= 0 ? !(iAbs >= 0 || (firstVisiblePosition <= 0 && dropDownListView.getChildAt(0).getTop() >= 0)) : !(i >= count && dropDownListView.getChildAt(childCount - 1).getBottom() <= dropDownListView.getHeight())) {
                return true;
            }
        }
        return false;
    }
}
