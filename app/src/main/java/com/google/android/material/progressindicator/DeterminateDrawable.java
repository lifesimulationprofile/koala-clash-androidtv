package com.google.android.material.progressindicator;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.provider.Settings;
import android.util.AndroidRuntimeException;
import android.view.Choreographer;
import androidx.dynamicanimation.animation.AnimationHandler;
import androidx.dynamicanimation.animation.AnimationHandler$FrameCallbackProvider16$1;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import coil.ImageLoader$Builder;
import com.google.android.material.color.MaterialColors;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DeterminateDrawable extends DrawableWithAnimatedVisibilityChange {
    public static final AnonymousClass1 INDICATOR_LENGTH_IN_LEVEL = new AnonymousClass1();
    public final LinearDrawingDelegate drawingDelegate;
    public float indicatorFraction;
    public boolean skipAnimationOnLevelChange;
    public final SpringAnimation springAnimation;
    public final SpringForce springForce;

    /* JADX INFO: renamed from: com.google.android.material.progressindicator.DeterminateDrawable$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends FloatPropertyCompat {
    }

    public DeterminateDrawable(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec, LinearDrawingDelegate linearDrawingDelegate) {
        super(context, linearProgressIndicatorSpec);
        this.skipAnimationOnLevelChange = false;
        this.drawingDelegate = linearDrawingDelegate;
        linearDrawingDelegate.drawable = this;
        SpringForce springForce = new SpringForce();
        this.springForce = springForce;
        springForce.mDampingRatio = 1.0f;
        springForce.mInitialized = false;
        springForce.mNaturalFreq = Math.sqrt(50.0f);
        springForce.mInitialized = false;
        SpringAnimation springAnimation = new SpringAnimation(this);
        this.springAnimation = springAnimation;
        springAnimation.mSpring = springForce;
        if (this.growFraction != 1.0f) {
            this.growFraction = 1.0f;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.drawingDelegate.validateSpecAndAdjustCanvas(canvas, getGrowFraction());
            LinearDrawingDelegate linearDrawingDelegate = this.drawingDelegate;
            Paint paint = this.paint;
            linearDrawingDelegate.fillTrack(canvas, paint);
            int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(this.baseSpec.indicatorColors[0], this.totalAlpha);
            this.drawingDelegate.fillIndicator(canvas, paint, 0.0f, this.indicatorFraction, iCompositeARGBWithAlpha);
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.drawingDelegate.spec.trackThickness;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        this.drawingDelegate.getClass();
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        this.springAnimation.skipToEnd();
        this.indicatorFraction = getLevel() / 10000.0f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        boolean z = this.skipAnimationOnLevelChange;
        SpringAnimation springAnimation = this.springAnimation;
        if (z) {
            springAnimation.skipToEnd();
            this.indicatorFraction = i / 10000.0f;
            invalidateSelf();
            return true;
        }
        springAnimation.mValue = this.indicatorFraction * 10000.0f;
        springAnimation.mStartValueIsSet = true;
        float f = i;
        if (springAnimation.mRunning) {
            springAnimation.mPendingPosition = f;
            return true;
        }
        if (springAnimation.mSpring == null) {
            springAnimation.mSpring = new SpringForce(f);
        }
        SpringForce springForce = springAnimation.mSpring;
        double d = f;
        springForce.mFinalPosition = d;
        double d2 = (float) d;
        if (d2 > Float.MAX_VALUE) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (d2 < -3.4028235E38f) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
        double dAbs = Math.abs(springAnimation.mMinVisibleChange * 0.75f);
        springForce.mValueThreshold = dAbs;
        springForce.mVelocityThreshold = dAbs * 62.5d;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        boolean z2 = springAnimation.mRunning;
        if (!z2 && !z2) {
            springAnimation.mRunning = true;
            if (!springAnimation.mStartValueIsSet) {
                AnonymousClass1 anonymousClass1 = springAnimation.mProperty;
                DeterminateDrawable determinateDrawable = springAnimation.mTarget;
                anonymousClass1.getClass();
                springAnimation.mValue = determinateDrawable.indicatorFraction * 10000.0f;
            }
            float f2 = springAnimation.mValue;
            if (f2 > Float.MAX_VALUE || f2 < -3.4028235E38f) {
                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
            }
            ThreadLocal threadLocal = AnimationHandler.sAnimatorHandler;
            if (threadLocal.get() == null) {
                threadLocal.set(new AnimationHandler());
            }
            AnimationHandler animationHandler = (AnimationHandler) threadLocal.get();
            ArrayList arrayList = animationHandler.mAnimationCallbacks;
            if (arrayList.size() == 0) {
                if (animationHandler.mProvider == null) {
                    animationHandler.mProvider = new ImageLoader$Builder(animationHandler.mCallbackDispatcher);
                }
                ImageLoader$Builder imageLoader$Builder = animationHandler.mProvider;
                ((Choreographer) imageLoader$Builder.defaults).postFrameCallback((AnimationHandler$FrameCallbackProvider16$1) imageLoader$Builder.options);
            }
            if (!arrayList.contains(springAnimation)) {
                arrayList.add(springAnimation);
                return true;
            }
        }
        return true;
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public final boolean setVisibleInternal(boolean z, boolean z2, boolean z3) {
        boolean visibleInternal = super.setVisibleInternal(z, z2, z3);
        AnimatorDurationScaleProvider animatorDurationScaleProvider = this.animatorDurationScaleProvider;
        ContentResolver contentResolver = this.context.getContentResolver();
        animatorDurationScaleProvider.getClass();
        float f = Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
        if (f == 0.0f) {
            this.skipAnimationOnLevelChange = true;
            return visibleInternal;
        }
        this.skipAnimationOnLevelChange = false;
        float f2 = 50.0f / f;
        SpringForce springForce = this.springForce;
        springForce.getClass();
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        springForce.mNaturalFreq = Math.sqrt(f2);
        springForce.mInitialized = false;
        return visibleInternal;
    }
}
